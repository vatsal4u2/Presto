package com.presto.vatsalpatel.presto.Models.ImageSizeApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageSizeResponse {

    @SerializedName("sizes")
    @Expose
    private Sizes sizes;

    @SerializedName("stat")
    @Expose
    private String stat;

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
