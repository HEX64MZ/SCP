package hxtedme.staffcontrol;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;
import hxtedme.staffcontrol.managers.StaffManager;

@Plugin(id = "hxtedmestaffcontrol", name = "StaffControl", version = "1.0.0",
        authors = {"YourName"}, description = "Global staff management system")
public class StaffControlPlugin {

    private final ProxyServer server;
    private final Logger logger;
    private StaffManager staffManager;

    @Inject
    public StaffControlPlugin(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        // Initialize managers
        staffManager = new StaffManager();

        // Register commands and listeners...
    }

    public StaffManager getStaffManager() {
        return staffManager;
    }

    // Other methods...
}
