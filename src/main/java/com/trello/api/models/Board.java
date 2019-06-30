package com.trello.api.models;

import com.trello.api.enums.PermissionsLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Board {

    private String id;
    private @Setter String name;
    private @Setter String desc;
    private String url;
    private @Setter String prefs_permissionLevel;

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
