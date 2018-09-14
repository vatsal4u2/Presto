package com.presto.vatsalpatel.presto.Api;

import com.presto.vatsalpatel.presto.Models.ImageSizeApi.ImageSizeResponse;
import com.presto.vatsalpatel.presto.Models.SearchApi.FlickrPhotoSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitServices {

    @GET("rest/")
    Call<FlickrPhotoSearchResponse> getAllPhotos(@Query("method") String method,
                                                 @Query("api_key") String key,
                                                 @Query("format") String format,
                                                 @Query("nojsoncallback")String i,
                                                 @Query("auth_token") String auth,
                                                 @Query("api_sig")String apiSig
    );


    @GET("rest/")
    Call<ImageSizeResponse> getImageSize(@Query("method") String method,
                                         @Query("api_key") String key,
                                         @Query("photo_id") String id,
                                         @Query("format") String format,
                                         @Query("nojsoncallback")String i
    );

}
