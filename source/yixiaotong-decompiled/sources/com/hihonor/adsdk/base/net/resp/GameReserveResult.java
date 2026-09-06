package com.hihonor.adsdk.base.net.resp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class GameReserveResult {

    @SerializedName("data")
    @Expose
    public int data;

    @SerializedName("code")
    @Expose
    public int errorCode;

    @SerializedName("msg")
    @Expose
    public String errorMessage;

    @SerializedName("success")
    @Expose
    public boolean success;

    public boolean hnadsa() {
        return this.errorCode == 0;
    }
}
