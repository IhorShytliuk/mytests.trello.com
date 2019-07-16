package com.trello.api.models.auth;

public class AuthParams {
    String method = "password";
    Factors factors = new Factors();
    String castleClientId = "14f04df3-bc60-49dd-a0fb-78a04f998432-ce39d7e9052030a9a28f20d8";

    class Factors {
        String user = "shytliuk.ihor+2@pdffiller.team";
        String password = "qwe1rty2";
    }
}
