package hxtedme.staffcontrol.commands;

import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import hxtedme.staffcontrol.StaffControlPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class FakeJoinCommand implements SimpleCommand {
    private final StaffControlPlugin plugin;

    public FakeJoinCommand(StaffControlPlugin plugin) {
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
            player.sendMessage(Component.text("Please specify a player to fake join.", NamedTextColor.RED));
            return;
        }

        // Logic to send fake join message
        plugin.getServer().getPlayer(targetPlayer).ifPresent(target -> {
            plugin.getServer().getAllPlayers().forEach(p -> {
                p.sendMessage(Component.text(target.getUsername() + " has joined the game!", NamedTextColor.GREEN));
            });
        });
    }

    @Override
    public boolean hasPermission(Invocation invocation) {
        return invocation.source().hasPermission("staffcontrol.command.fakejoin");
    }
}
