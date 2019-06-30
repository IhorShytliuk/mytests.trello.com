package com.trello.api.enums;

public enum PermissionsLevel {

    ORG("org"), PRIVATE("private"), PUBLIC("public");

    private String permissionLevel;

    PermissionsLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @Override
    public String toString() {
        return permissionLevel;
    }
}
