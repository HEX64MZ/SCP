package hxtedme.staffcontrol.commands;

import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import hxtedme.staffcontrol.StaffControlPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class PenaltyCommand implements SimpleCommand {
    private final StaffControlPlugin plugin;

    public PenaltyCommand(StaffControlPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(Invocation invocation) {
        if (!(invocation.source() instanceof Player player)) {
            invocation.source().sendMessage(Component.text("Only players can use this command!", NamedTextColor.RED));
            return;
        }

        // Check the current state of penalty announcements
        boolean currentState = plugin.getConfigManager().isPenaltyAnnouncementsEnabled();
        boolean newState = !currentState;

        // Toggle the state in the config
        plugin.getConfigManager().setPenaltyAnnouncementsEnabled(newState);

        player.sendMessage(Component.text()
                .content("Penalty announcements ")
                .append(Component.text(newState ? "enabled" : "disabled",
                        newState ? NamedTextColor.GREEN : NamedTextColor.RED))
        );
    }

    @Override
    public boolean hasPermission(Invocation invocation) {
        return invocation.source().hasPermission("staffcontrol.command.penalty");
    }
}
