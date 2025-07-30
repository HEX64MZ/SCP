package hxtedme.staffcontrol.commands;

import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import hxtedme.staffcontrol.StaffControlPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class FakeLeaveCommand implements SimpleCommand {
    private final StaffControlPlugin plugin;

    public FakeLeaveCommand(StaffControlPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(Invocation invocation) {
        if (!(invocation.source() instanceof Player player)) {
            invocation.source().sendMessage(Component.text("Only players can use this command!", NamedTextColor.RED));
            return;
        }

        String targetPlayer = invocation.arguments().length > 0 ? invocation.arguments()[0] : null;
        if (targetPlayer == null) {
            player.sendMessage(Component.text("Please specify a player to fake leave.", NamedTextColor.RED));
            return;
        }

        // Logic to send fake leave message
        plugin.getServer().getPlayer(targetPlayer).ifPresent(target -> {
            plugin.getServer().getAllPlayers().forEach(p -> {
                p.sendMessage(Component.text(target.getUsername() + " has left the game!", NamedTextColor.RED));
            });
        });
    }

    @Override
    public boolean hasPermission(Invocation invocation) {
        return invocation.source().hasPermission("staffcontrol.command.fakeleave");
    }
}
