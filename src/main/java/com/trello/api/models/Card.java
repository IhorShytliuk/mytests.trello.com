package com.trello.api.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Card {
    private String id;
    private String desc;
    private String idBoard;
    private String idList;
    private @Setter String name;
    private String url;
    private Boolean closed;

    public Card() {
    }

    public Card(String name) {
        this.setName(name);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", idList='" + idList + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
