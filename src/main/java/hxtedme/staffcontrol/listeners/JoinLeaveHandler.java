public boolean isSilentJoinEnabled() {
    return config.getNode("settings", "silent-join").getBoolean(false);
}

public boolean isFakeLeaveEnabled() {
    return config.getNode("settings", "fake-leave").getBoolean(false);
}
