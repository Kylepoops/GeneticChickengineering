package space.kiichan.geneticchickengineering.i18n;

import org.bukkit.configuration.file.YamlConfiguration;

public class Translation {
    public String PAPER_WARNING;
    public String PAPER_CHECK;

    public Translation(YamlConfiguration config) {
        loadOrSetDefault(config);
    }

    private void loadOrSetDefault(YamlConfiguration config) {
        this.PAPER_WARNING = config.getString("PAPER_WARNING", "Connection to database failed. Aborting initialization.");
        this.PAPER_CHECK = config.getString("PAPER_CHECK", "Check above for more information about the error.");
        //TODO: ALL MESSAGE
    }
}
