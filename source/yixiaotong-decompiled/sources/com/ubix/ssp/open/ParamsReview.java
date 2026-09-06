package com.ubix.ssp.open;

import com.ubix.ssp.open.nativee.UBiXImage;
import com.ubix.ssp.open.nativee.UBiXVideo;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class ParamsReview {
    public abstract String getAppPackageName();

    public abstract String getCreativeId();

    public abstract String getDeeplinkUrl();

    public abstract String getDesc();

    public abstract String getDownloadUrl();

    public abstract String getLandingPageUrl();

    public abstract String getTitle();

    public abstract ArrayList<UBiXImage> getUBiXImageList();

    public abstract UBiXVideo getUBiXVideo();

    public abstract String getUrl();

    public abstract ArrayList<String> getUrlList();

    public abstract boolean isVideo();
}
