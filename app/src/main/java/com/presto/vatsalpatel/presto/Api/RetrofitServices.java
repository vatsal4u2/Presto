package com.presto.vatsalpatel.presto.Api;

import com.presto.vatsalpatel.presto.Data.ImageSizeApi.ImageSizeResponse;
import com.presto.vatsalpatel.presto.Data.SearchApi.FlickrPhotoSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitServices {

    // Want to show different ways of calling Apis.
    @GET("rest/?method=flickr.photos.search&api_key=9ff06ccbcd84c3ba832fc1420df0ef49&format=json&nojsoncallback=1&auth_token=72157698054558242-48a863d4feb4712a&api_sig=ec96f7ad35e73ea88fa17d532cacd91e")
    Call<FlickrPhotoSearchResponse> getAllPhotos();

    // Passing by Query Params
    @GET("rest/")
    Call<ImageSizeResponse> getImageSize(@Query("method") String method,
                                         @Query("api_key") String key,
                                         @Query("photo_id") String id,
                                         @Query("format") String format,
                                         @Query("nojsoncallback")String i
    );
}
