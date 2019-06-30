package com.trello.api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TList {
    private String id;
    private @Setter String idBoard;
    private @Setter String name;
    private @Setter boolean closed;

    @Override
    public String toString() {
        return "TList{" +
                "id='" + id + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", name='" + name + '\'' +
                ", closed=" + closed +
                '}';
    }
}
