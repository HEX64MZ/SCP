package hxtedme.staffcontrol.managers;

import hxtedme.staffcontrol.StaffControlPlugin;
import hxtedme.staffcontrol.util.VelocityUtils;

public class ChatManager {
    private final StaffControlPlugin plugin;

    public ChatManager(StaffControlPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean shouldIntercept(String message) {
        // Check if message should be intercepted
        return false; // Actual implementation would go here
    }

    public void broadcastStaffMessage(String message) {
        VelocityUtils.broadcast(
                plugin.getServer(),
                "staffcontrol.staffchat",
                message
        );
    }
}
