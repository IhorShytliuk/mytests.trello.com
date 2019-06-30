package com.trello.api.services;

import com.trello.api.models.TList;
import retrofit2.Call;
import retrofit2.http.*;

public interface ListsService {

    @POST("lists")
    Call<TList> createList(@Query("name") String name, @Query("idBoard") String idBoard);

    @GET("lists/{id}")
    Call<TList> getList(@Path("id") String id);

    @PUT("lists/{id}")
    Call<TList> updateList(@Path("id") String id, @Body TList tList);

}
