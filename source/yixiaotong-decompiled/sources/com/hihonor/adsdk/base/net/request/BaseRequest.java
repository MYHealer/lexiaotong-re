package com.hihonor.adsdk.base.net.request;

import android.text.TextUtils;
import com.alipay.sdk.packet.e;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hihonor.adsdk.base.j.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class BaseRequest {

    @SerializedName("adContext")
    @Expose
    private String adContext;

    @SerializedName("adUnit")
    @Expose
    private AdUnit adUnit;

    @SerializedName(e.n)
    @Expose
    private DeviceData deviceData;

    @Expose(deserialize = false, serialize = false)
    private String jsonCache;

    @SerializedName("media")
    @Expose
    private MediaData mediaData;

    public String getAdContext() {
        return this.adContext;
    }

    public AdUnit getAdUnit() {
        return this.adUnit;
    }

    public DeviceData getDeviceData() {
        return this.deviceData;
    }

    public String getJsonCache() {
        if (TextUtils.isEmpty(this.jsonCache)) {
            this.jsonCache = g.hnadsa(this);
        }
        return this.jsonCache;
    }

    public MediaData getMediaData() {
        return this.mediaData;
    }

    public void setAdContext(String str) {
        this.adContext = str;
    }

    public void setAdUnit(AdUnit adUnit) {
        this.adUnit = adUnit;
    }

    public void setDeviceData(DeviceData deviceData) {
        this.deviceData = deviceData;
    }

    public void setMediaData(MediaData mediaData) {
        this.mediaData = mediaData;
    }

    public String toJson() {
        return g.hnadsa(this);
    }
}
