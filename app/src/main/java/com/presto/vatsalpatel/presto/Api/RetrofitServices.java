package com.presto.vatsalpatel.presto.Api;

import com.presto.vatsalpatel.presto.Data.ImageSizeApi.ImageSizeResponse;
import com.presto.vatsalpatel.presto.Data.SearchApi.FlickrPhotoSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitServices {

    @GET("rest/?method=flickr.photos.search&api_key=d81a384144084d2638d8ee136cc0398a&format=json&nojsoncallback=1&auth_token=72157673388168278-9fd7b2cafb42b02f&api_sig=1c532783034c421591544d7cbf9e65dd")
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
