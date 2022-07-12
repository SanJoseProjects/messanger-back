package ru.cft.messenger.repository.model;

public enum Permission {
    USER_READ("developers:read"),
    USER_WRITE("developers:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
