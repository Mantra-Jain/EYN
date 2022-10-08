package com.mantra.eyn.ApiCallInterfaces;

import com.mantra.eyn.BangaloreResponseClasses.ResponseBangaloreClasses;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BangaloreApiClient {

    @GET("relevance/feed?location=2001159&user=177617c8e60x2ac165fa&lang=en")
    Call<ResponseBangaloreClasses> getApit();

}
