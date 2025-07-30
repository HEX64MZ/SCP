package hxtedme.staffcontrol.listeners;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.PlayerChatEvent;
import hxtedme.staffcontrol.StaffControlPlugin;

public class ChatListener {
    private final StaffControlPlugin plugin;

    public ChatListener(StaffControlPlugin plugin) {
        this.plugin = plugin;
    }

    @Subscribe
    public void onChat(PlayerChatEvent event) {
        // Handle chat events here
    }
}
