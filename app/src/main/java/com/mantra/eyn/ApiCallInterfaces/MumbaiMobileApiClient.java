package com.mantra.eyn.ApiCallInterfaces;

import com.mantra.eyn.MumbaiResponseClasses.MobilesInMumbai.ResponseMobileMumbaiClasses;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MumbaiMobileApiClient {

    @GET("relevance/v2/search?category=1411&facet_limit=100&location=4058997&location_facet_limit=20&platform=web-desktop&user=177617c8e60x2ac165fa&lang=en")
    Call<ResponseMobileMumbaiClasses> getApi();
}
