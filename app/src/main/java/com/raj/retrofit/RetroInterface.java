package com.raj.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetroInterface {

    @GET("api/unknown")
    Call<ResponseBody> getResults();

//    @GET("country/get/iso2code/{alpha2_code}")
//    Call<ResponseBody> getByAlpha2Code(@Path("alpha2_code") String alpha2Code);

    @FormUrlEncoded
    @POST("/api/users")
    Call<ResponseBody> createuser(
            @Field("name") String name,
            @Field("job") String job
    );

}
