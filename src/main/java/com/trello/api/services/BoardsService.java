package com.trello.api.services;

import com.trello.api.models.Board;
import com.trello.api.models.TList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface BoardsService {

    @GET("boards/{id}/lists")
    Call<List<TList>> getLists(@Path("id") String id);


    @POST("boards")
    Call<Board> createBoard(@Query("name") String name);

    @POST("boards")
    Call<Board> createBoard(@Body Board board);

    @GET("boards/{id}")
    Call<Board> getBoard(@Path("id") String id);

    @GET("boards/{id}/lists")
    Call<List<TList>> getBoardLists(@Path("id") String id);

    @PUT("boards/{id}")
    Call<Board> updateBoard(@Path("id") String id, @Body Board board);

    @DELETE("boards/{id}")
    Call<ResponseBody> deleteBoard(@Path("id") String id);
}
