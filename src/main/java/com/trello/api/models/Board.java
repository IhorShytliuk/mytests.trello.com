package com.trello.api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Board {

    private String id;
    private @Setter String name;
    private String desc;
    private String url;

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
