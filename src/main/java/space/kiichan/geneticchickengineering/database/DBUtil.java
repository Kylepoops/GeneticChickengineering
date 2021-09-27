package space.kiichan.geneticchickengineering.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

interface Wrap {
    void unsafe() throws SQLException;
}

@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection"})
public class DBUtil {
    private String datadir;
    private Logger logger;
    private Connection conn = null;
    // Track when we last made changes to save db calls
    private boolean delta = true;
    private List<String[]> cache;

    public DBUtil(String datadir, Logger logger) {
        this.datadir = datadir;
        if (!this.datadir.endsWith(File.separator)) {
            this.datadir = this.datadir + File.separator;
        }
        this.logger = logger;
        this.connect();
    }

    public boolean checkForConnection() {
        return this.conn != null;
    }

    private void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:"+this.datadir+"GCE.db";
            // create a connection to the database
            this.conn = DriverManager.getConnection(url);

            if (this.checkForConnection()) {
                this.conn.setAutoCommit(false);
                this.logger.info("Connection to "+this.datadir+"GCE.db has been established.");
                this.create_table();
            } else {
                this.logger.severe("Connection to the database "+this.datadir+"GCE.db has failed for an unknown reason.");
                this.logger.severe("Any error should have already been thrown and caught. You are in uncharted territory.");
            }

        } catch (SQLException e) {
            this.logger.severe(e.getMessage());
        }
    }

    public void commit() {
        this.safely(() -> this.conn.commit());
    }

    public void close() {
        this.safely(() -> {
            this.conn.commit();
            this.conn.close();
            this.logger.info("Connection to "+this.datadir+"GCE.db has been closed.");
        });
    }

    public void create_table() {
        this.safely(() -> {
            String sql = "CREATE TABLE IF NOT EXISTS entities ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "uuid TEXT NOT NULL,"+
                "dna TEXT NOT NULL);";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            this.conn.commit();
        });
    }

    public void delete(String uuid) {
        this.safely(() -> {
            String sql = "DELETE FROM entities WHERE uuid = ?;";
            PreparedStatement s = this.conn.prepareStatement(sql);
            s.setString(1, uuid);
            s.executeUpdate();
            this.delta = true;
        });
    }

    public List<String[]> getAll() {
        List<String[]> out = new ArrayList<>();
        if (!this.delta) {
            return this.cache;
        }
        this.safely(() -> {
            String sql = "SELECT uuid, dna FROM entities;";
            Statement s = this.conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                String[] record = new String[2];
                record[0] = rs.getString("uuid");
                record[1] = rs.getString("dna");
                out.add(record);
            }
            this.cache = out;
            this.delta = false;
        });
        return out;
    }

    public boolean has(String uuid) {
        // refresh the cache if need be
        this.getAll();
        for (String[] strings : this.cache) {
            if (uuid.equals(strings[0])) {
                return true;
            }
        }
        return false;
    }

    public String getDNAOrNull(String uuid) {
        // refresh the cache if need be
        this.getAll();
        for (String[] strings : this.cache) {
            if (uuid.equals(strings[0])) {
                return strings[1];
            }
        }
        return null;
    }

    public void insert(String uuid, String dna) {
        this.safely(() -> {
            String sql = "INSERT INTO entities (uuid, dna) VALUES (?,?);";
            PreparedStatement s = this.conn.prepareStatement(sql);
            s.setString(1, uuid);
            s.setString(2, dna);
            s.executeUpdate();
            this.delta = true;
        });
    }

    private void safely(Wrap w) {
        if (!this.checkForConnection()) {
            this.logger.severe("Database call made with no connection!");
            this.logger.severe("Was the DBUtil object initialized properly?");
            this.logger.severe("Aborting action");
            return;
        }
        try {
            w.unsafe();
        } catch (SQLException ex) {
            this.logger.severe(ex.getMessage());
        }
    }
}
