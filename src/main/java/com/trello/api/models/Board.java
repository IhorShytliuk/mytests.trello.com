package com.trello.api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Board {

    private String id;
    private @Setter String name;
    private @Setter String desc;
    private String url;
    //todo     @JsonProperty("prefs_permissionLevel")
    private String prefs_permissionLevel;

    public void setPermissionLevel(String permissionLevel) {
        prefs_permissionLevel = permissionLevel;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", url='" + url + '\'' +
                ", permissionsLevel=" + prefs_permissionLevel +
                '}';
    }
}
