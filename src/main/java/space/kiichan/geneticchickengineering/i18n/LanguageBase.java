package space.kiichan.geneticchickengineering.i18n;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class LanguageBase {
    private static Translation translation;
    private static File file;
    private static YamlConfiguration config;

    public static void setup(@NotNull Plugin plugin, String langName) {
        String fileName = langName + ".yml";
        file = new File(plugin.getDataFolder(), fileName);
        config = YamlConfiguration.loadConfiguration(file);
        translation = new Translation(plugin, config, file);
    }

    public static Translation getTranslation() {
        return translation;
    }
}
