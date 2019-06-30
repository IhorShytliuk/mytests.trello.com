package com.trello.api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Label {
    private String id;
    private @Setter String name;
    private @Setter String idBoard;
    private @Setter String color;

    @Override
    public String toString() {
        return "Label{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
