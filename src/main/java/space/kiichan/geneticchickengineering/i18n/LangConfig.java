package space.kiichan.geneticchickengineering.i18n;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class LangConfig {
    private Plugin plugin;
    private String langName;
    private String fileName;
    private YamlConfiguration config;
    private Translation translation = null;

    public LangConfig(Plugin plugin, String langName) {
        this.plugin = plugin;
        this.langName = langName;
        this.fileName = langName + ".yml";
        this.config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), fileName));
    }

    public Translation getTranslation() {
        if (this.translation == null) {
            this.translation = new Translation(config);
        }
        return translation;
    }
}
