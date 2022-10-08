package com.mantra.eyn.ApiCallInterfaces;

import com.mantra.eyn.KolKataResponseClasses.ResponseKolkataClasses;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KolkataApiCient {

    @GET("relevance/feed?location=4157275&user=177617c8e60x2ac165fa&lang=en")
    Call<ResponseKolkataClasses> getApi();
}
