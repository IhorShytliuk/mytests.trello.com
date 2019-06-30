package com.trello.api.services;

import com.trello.api.models.Label;
import retrofit2.Call;
import retrofit2.http.*;

public interface LabelsService {

    @POST("labels")
    Call<Label> createLabel(@Query("name") String name, @Query("idBoard") String idBoard, @Query("color") String color);

    @GET("labels/{id}")
    Call<Label> getLabel(@Path("id") String id);

    @PUT("labels/{id}")
    Call<Label> updateLabel(@Path("id") String id, @Body Label label);

    @DELETE("labels/{id}")
    Call<Label> deleteLabel(@Path("id") String id);

}
