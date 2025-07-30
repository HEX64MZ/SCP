package hxtedme.staffcontrol.managers;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class StaffManager {
    private final Set<UUID> silentJoinUsers = new HashSet<>();
    private final Set<UUID> vanishedUsers = new HashSet<>();

    public boolean toggleSilentJoin(UUID playerId) {
        if (silentJoinUsers.contains(playerId)) {
            silentJoinUsers.remove(playerId);
            return false; // Silent join disabled
        } else {
            silentJoinUsers.add(playerId);
            return true; // Silent join enabled
        }
    }

    public boolean isSilentJoinEnabled(UUID playerId) {
        return silentJoinUsers.contains(playerId);
    }

    public boolean toggleVanish(UUID playerId) {
        if (vanishedUsers.contains(playerId)) {
            vanishedUsers.remove(playerId);
            return false; // Vanish disabled
        } else {
            vanishedUsers.add(playerId);
            return true; // Vanish enabled
        }
    }

    public boolean isVanished(UUID playerId) {
        return vanishedUsers.contains(playerId);
    }
}
