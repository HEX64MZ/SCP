package hxtedme.staffcontrol.commands;

import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import hxtedme.staffcontrol.StaffControlPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class SilentCommand implements SimpleCommand {
    private final StaffControlPlugin plugin;

    public SilentCommand(StaffControlPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(Invocation invocation) {
        if (!(invocation.source() instanceof Player player)) {
            invocation.source().sendMessage(Component.text("Only players can use this command!", NamedTextColor.RED));
            return;
        }

        boolean newState = plugin.getStaffManager().toggleSilentJoin(player.getUniqueId());
        player.sendMessage(Component.text("Silent join has been " + (newState ? "enabled" : "disabled"),
                newState ? NamedTextColor.GREEN : NamedTextColor.RED));
    }

    @Override
    public boolean hasPermission(Invocation invocation) {
        return invocation.source().hasPermission("staffcontrol.command.silentjoin");
    }
}
