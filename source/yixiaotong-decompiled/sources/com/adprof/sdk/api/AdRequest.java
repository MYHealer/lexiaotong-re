package com.adprof.sdk.api;

import com.adprof.sdk.pk;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AdRequest implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BannerSize f46a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f48a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map f49a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f52b;
    public int c;
    public int d;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Boolean f51b = Boolean.TRUE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f45a = 500;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f50a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f53b = false;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f54c = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Boolean f47a = null;

    /* JADX INFO: renamed from: com.adprof.sdk.api.AdRequest$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public BannerSize f56a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Boolean f57a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f58a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Map f59a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public String f62b;
        public int c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1045a = 1080;
        public int b = 0;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Boolean f61b = Boolean.TRUE;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f55a = 500;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f60a = false;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f63b = false;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f64c = false;

        public AdRequest build() {
            AdRequest adRequest = new AdRequest();
            adRequest.f48a = this.f58a;
            adRequest.f1044a = this.f1045a;
            adRequest.b = this.b;
            adRequest.c = 0;
            adRequest.f49a = this.f59a;
            adRequest.d = this.c;
            adRequest.f47a = this.f57a;
            adRequest.f51b = this.f61b;
            adRequest.f46a = this.f56a;
            adRequest.f45a = this.f55a;
            adRequest.f50a = this.f60a;
            adRequest.f54c = this.f63b;
            adRequest.f53b = this.f64c;
            adRequest.f52b = this.f62b;
            return adRequest;
        }

        public Builder setBannerSize(BannerSize bannerSize) {
            this.f56a = bannerSize;
            return this;
        }

        public Builder setBannerWidthFullParent(boolean z) {
            this.f63b = z;
            return this;
        }

        public Builder setBidFloor(int i) {
            this.c = i;
            return this;
        }

        public Builder setBidResponse(String str) {
            this.f62b = str;
            return this;
        }

        public Builder setCloseAfterClick(boolean z) {
            this.f64c = z;
            return this;
        }

        public Builder setCloseDelayRemoveViewMills(long j) {
            this.f55a = j;
            return this;
        }

        public Builder setCodeId(String str) {
            this.f58a = str;
            return this;
        }

        public Builder setExtOption(Map<String, Object> map) {
            this.f59a = map;
            return this;
        }

        public Builder setHeight(int i) {
            this.b = i;
            return this;
        }

        public Builder setIsExpressAd(boolean z) {
            this.f61b = Boolean.valueOf(z);
            return this;
        }

        public Builder setOrientation(int i) {
            return this;
        }

        public Builder setUseClick(boolean z) {
            this.f60a = z;
            return this;
        }

        public Builder setVideoMute(boolean z) {
            this.f57a = Boolean.valueOf(z);
            return this;
        }

        public Builder setWidth(int i) {
            this.f1045a = i;
            return this;
        }
    }

    public AdRequest() {
        this.c = 0;
        this.c = 0;
    }

    public BannerSize getBannerSize() {
        return this.f46a;
    }

    public int getBidFloor() {
        return this.d;
    }

    public long getCloseDelayRemoveViewMills() {
        return this.f45a;
    }

    public String getCodeId() {
        return this.f48a;
    }

    public Map<String, Object> getExtOption() {
        return this.f49a;
    }

    public int getHeight() {
        return this.b;
    }

    public Boolean getIsExpressAd() {
        return this.f51b;
    }

    public int getOrientation() {
        return this.c;
    }

    public String getS2sBidResponse() {
        return this.f52b;
    }

    public boolean getUseClick() {
        return this.f50a;
    }

    public Boolean getVideoMute() {
        return this.f47a;
    }

    public int getWidth() {
        return this.f1044a;
    }

    public boolean isBannerWidthFullParent() {
        return this.f54c;
    }

    public boolean isCloseAfterClick() {
        return this.f53b;
    }

    public void setBannerSize(BannerSize bannerSize) {
        this.f46a = bannerSize;
    }

    public void setBannerWidthFullParent(boolean z) {
        this.f54c = z;
    }

    public void setS2sBidResponse(String str) {
        this.f52b = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adUnitID", this.f48a);
            jSONObject.put("width", this.f1044a);
            jSONObject.put("height", this.b);
            jSONObject.put("orientation", this.c);
            jSONObject.put("extOption", this.f49a);
            jSONObject.put("bidFloor", this.d);
            Boolean bool = this.f47a;
            if (bool != null) {
                jSONObject.put("videoMute", bool);
            }
            Boolean bool2 = this.f51b;
            if (bool2 != null) {
                jSONObject.put("isExpressAd", bool2);
            }
            String str = this.f52b;
            if (str != null) {
                jSONObject.put("bidResponse", str);
            }
        } catch (Throwable th) {
            pk.b("AdReq toJson error: ", th);
        }
        return jSONObject;
    }

    public String toString() {
        return toJsonObj().toString();
    }
}
