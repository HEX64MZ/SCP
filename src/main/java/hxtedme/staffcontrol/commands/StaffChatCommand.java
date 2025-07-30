package hxtedme.staffcontrol.commands;

import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import hxtedme.staffcontrol.StaffControlPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class StaffChatCommand implements SimpleCommand {
    private final StaffControlPlugin plugin;

    public StaffChatCommand(StaffControlPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(Invocation invocation) {
        if (!(invocation.source() instanceof Player player)) {
            invocation.source().sendMessage(Component.text("Only players can use this command!", NamedTextColor.RED));
            return;
        }

        String message = String.join(" ", invocation.arguments());
        if (message.isEmpty()) {
            player.sendMessage(Component.text("Please provide a message to send to staff chat.", NamedTextColor.RED));
            return;
        }

        plugin.getStaffManager().broadcastStaffMessage(message);
        player.sendMessage(Component.text("Message sent to staff chat.", NamedTextColor.GREEN));
    }

    @Override
    public boolean hasPermission(Invocation invocation) {
        return invocation.source().hasPermission("staffcontrol.command.staffchat");
    }
}
