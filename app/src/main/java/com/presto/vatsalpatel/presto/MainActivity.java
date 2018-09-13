package com.presto.vatsalpatel.presto;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.presto.vatsalpatel.presto.Api.RetrofitClient;
import com.presto.vatsalpatel.presto.Api.RetrofitServices;
import com.presto.vatsalpatel.presto.Data.ImageSizeApi.ImageSizeResponse;
import com.presto.vatsalpatel.presto.Data.SearchApi.FlickrPhotoSearchResponse;
import com.presto.vatsalpatel.presto.Data.SearchApi.Photo;
import com.presto.vatsalpatel.presto.Data.SearchApi.Photos;
import com.presto.vatsalpatel.presto.Ui.Adapter;
import com.presto.vatsalpatel.presto.Ui.ListData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<ListData> mDataSet;
    private static ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new Adapter(this);
        mRecyclerView.setAdapter(mAdapter);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading..");
        progressDialog.show();

        final RetrofitServices client = RetrofitClient.getRetrofitInstance().create(RetrofitServices.class);
        Call<FlickrPhotoSearchResponse> call = client.getAllPhotos();
        call.enqueue(new Callback<FlickrPhotoSearchResponse>() {
            @Override
            public void onResponse(Call<FlickrPhotoSearchResponse> call, Response<FlickrPhotoSearchResponse> response) {
                progressDialog.dismiss();

                if (response.isSuccessful() && response.body() != null) {
                    mDataSet = new ArrayList<>();
                      listData = new ListData();
                     for(Photo photo : response.body().getPhotos().getPhoto()) {

                         listData.setTitle(photo.getTitle());
                            Call<ImageSizeResponse> imageSizeResponseCall = client.getImageSize("flickr.photos.getSizes",
                                    BuildConfig.API_KEY,
                                    photo.getId(),
                                    "json",
                                    Integer.toString(1)
                            );

                            imageSizeResponseCall.enqueue(new Callback<ImageSizeResponse>() {
                                @Override
                                public void onResponse(Call<ImageSizeResponse> call, Response<ImageSizeResponse> response) {
                                    Log.v("ImageSizeApi", response.body() + "");
                                    if(response.isSuccessful() && response.body() != null){
                                        listData.setImageUrl(response.body().getSizes().getSize().get(0).getSource());
                                        listData.setSize(response.body().getSizes().getSize().get(0).getLabel());
                                        listData.setDimension(response.body().getSizes().getSize().get(0).getWidth() +"* " +
                                                response.body().getSizes().getSize().get(0).getHeight());
                                        mDataSet.add(listData);
                                        mAdapter.setListData(mDataSet);
                                    }
                                }

                                @Override
                                public void onFailure(Call<ImageSizeResponse> call, Throwable t) {
                                    Log.v("Error", t.getLocalizedMessage());
                                }
                            });


                        }
                }
            }

            @Override
            public void onFailure(Call<FlickrPhotoSearchResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), R.string.error_msg,Toast.LENGTH_LONG).show();
            }
        });


    }

    private void updateAdapter() {
        if(mAdapter != null){
            mAdapter.setListData(mDataSet);
        }
    }
}
