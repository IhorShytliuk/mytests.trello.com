package com.trello.api.services;

import com.trello.api.models.Auth;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    @POST("/1/authentication")
    Call<Auth> auth(@Body Auth body);

}
