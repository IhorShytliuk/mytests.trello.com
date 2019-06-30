package com.trello.api.services;

import com.trello.api.models.Card;
import retrofit2.Call;
import retrofit2.http.*;

public interface CardsService {

    @POST("cards")
    Call<Card> createCard(@Query("idList") String idList, @Body Card card);

    @GET("cards/{id}")
    Call<Card> getCard(@Path("id") String id);

    @PUT("cards/{id}")
    Call<Card> updateCard(@Path("id") String id, @Body Card card);

    @DELETE("cards/{id}")
    Call<Card> deleteCard(@Path("id") String id);

}
