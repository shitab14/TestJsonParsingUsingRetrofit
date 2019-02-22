package com.mr_mir.testjsonparsingusingretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GiftList {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("gift")
    @Expose
    private String gift;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GiftList withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public GiftList withGift(String gift) {
        this.gift = gift;
        return this;
    }

}
