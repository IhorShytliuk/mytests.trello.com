package com.trello.api.services;

import com.trello.api.models.auth.AuthParams;
import com.trello.api.models.auth.AuthResp;
import com.trello.api.models.auth.SessionResp;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.HashSet;

public interface AuthService {

    @POST("/1/authentication")
    Call<AuthResp> authentication(@Body AuthParams body);

    @POST("/1/authorization/session")
    Call<SessionResp> createSession(@Query("authentication") String authentication);

}
