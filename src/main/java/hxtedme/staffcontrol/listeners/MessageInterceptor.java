package hxtedme.staffcontrol.listeners;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.PlayerChatEvent;
import hxtedme.staffcontrol.StaffControlPlugin;
import hxtedme.staffcontrol.managers.ChatManager;

public class MessageInterceptor {
    private final StaffControlPlugin plugin;
    private final ChatManager chatManager;

    public MessageInterceptor(StaffControlPlugin plugin) {
        this.plugin = plugin;
        this.chatManager = new ChatManager(plugin);
    }

    @Subscribe
    public void onChat(PlayerChatEvent event) {
        // Handle InteractiveChat and other message intercepts
        if (chatManager.shouldIntercept(event.getMessage())) {
            event.setResult(PlayerChatEvent.ChatResult.denied());
        }
    }
}
