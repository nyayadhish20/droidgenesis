package com.nyayadhish.droidgenesis.lib.retrofit;

import com.nyayadhish.droidgenesis.model.Resp;
import com.nyayadhish.droidgenesis.model.Success;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Interface to declare API references with their input parameters
 */
public interface RetrofitAPI {
    @GET("top-headlines?country=us&category=business&apiKey=300e401e143940bc91c1d344186b36ea")
    Call<Resp> getAllNews();

    @GET()
    Call<Success> login(@Url String url);

}