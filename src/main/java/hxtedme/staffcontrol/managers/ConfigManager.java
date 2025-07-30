package hxtedme.staffcontrol.managers;

import hxtedme.staffcontrol.StaffControlPlugin;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.yaml.YAMLConfigurationLoader;

import java.io.IOException;
import java.nio.file.Path;

public class ConfigManager {
    private final StaffControlPlugin plugin;
    private ConfigurationNode config;

    public ConfigManager(StaffControlPlugin plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    private void loadConfig() {
        try {
            Path configPath = plugin.getDataDirectory().resolve("config.yml");
            if (!configPath.toFile().exists()) {
                plugin.saveResource("config.yml");
            }
            config = YAMLConfigurationLoader.builder().setPath(configPath).build().load();
        } catch (IOException e) {
            plugin.getLogger().error("Failed to load config.yml", e);
        }
    }

    public boolean isPenaltyAnnouncementsEnabled() {
        return config.getNode("settings", "penalty-announcements").getBoolean(true);
    }

    public void setPenaltyAnnouncementsEnabled(boolean state) {
        config.getNode("settings", "penalty-announcements").setValue(state);
        saveConfig();
    }

    private void saveConfig() {
        try {
            YAMLConfigurationLoader.builder()
                    .setPath(plugin.getDataDirectory().resolve("config.yml"))
                    .build()
                    .save(config);
        } catch (IOException e) {
            plugin.getLogger().error("Failed to save config.yml", e);
        }
    }

    public boolean isSilentJoinEnabled() {
        return config.getNode("settings", "silent-join").getBoolean(false);
    }

    public boolean isFakeLeaveEnabled() {
        return config.getNode("settings", "fake-leave").getBoolean(false);
    }
}
