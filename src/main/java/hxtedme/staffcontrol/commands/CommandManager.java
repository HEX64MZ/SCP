package hxtedme.staffcontrol.commands;

import com.velocitypowered.api.command.SimpleCommand;
import hxtedme.staffcontrol.StaffControlPlugin;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CommandManager {
    private final StaffControlPlugin plugin;

    public CommandManager(StaffControlPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerCommands() {
        plugin.getServer().getCommandManager().register(
                "togglepenalty",
                new PenaltyCommand(plugin),
                "tpenalty"
        );

        plugin.getServer().getCommandManager().register(
                "togglesilentjoin",
                new SilentCommand(plugin),
                "tsilent"
        );

        plugin.getServer().getCommandManager().register(
                "togglevanish",
                new VanishCommand(plugin),
                "tvanish"
        );

        plugin.getServer().getCommandManager().register(
                "fakejoin",
                new FakeJoinCommand(plugin),
                "fjoin"
        );

        plugin.getServer().getCommandManager().register(
                "fakeleave",
                new FakeLeaveCommand(plugin),
                "fleave"
        );

        plugin.getServer().getCommandManager().register(
                "staffchat",
                new StaffChatCommand(plugin),
                "sc"
        );
    }
}
