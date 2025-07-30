package hxtedme.staffcontrol.commands;

import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import hxtedme.staffcontrol.StaffControlPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class VanishCommand implements SimpleCommand {
    private final StaffControlPlugin plugin;

    public VanishCommand(StaffControlPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(Invocation invocation) {
        if (!(invocation.source() instanceof Player player)) {
            invocation.source().sendMessage(Component.text("Only players can use this command!", NamedTextColor.RED));
            return;
        }

        // Toggle vanish state for the player
        boolean isVanished = plugin.getStaffManager().toggleVanish(player.getUniqueId());
        player.sendMessage(Component.text("Vanish has been " + (isVanished ? "enabled" : "disabled"),
                isVanished ? NamedTextColor.GREEN : NamedTextColor.RED));
    }

    @Override
    public boolean hasPermission(Invocation invocation) {
        return invocation.source().hasPermission("staffcontrol.command.vanish");
    }
}
