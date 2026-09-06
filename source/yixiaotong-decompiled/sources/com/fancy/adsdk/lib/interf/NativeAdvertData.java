package com.fancy.adsdk.lib.interf;

import com.fancy.adsdk.lib.model.AppInfo;
import com.fancy.adsdk.lib.model.PtgImageInfo;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface NativeAdvertData {
    void destroy();

    int getAction();

    int getAid();

    AppInfo getApp();

    String getBrand();

    String getButtonText();

    String getDesc();

    long getDuration();

    int getHeight();

    List<PtgImageInfo> getImageList();

    String getLandUrl();

    String getLogo();

    String getMaterialId();

    String getMime();

    String getStyle();

    String getTitle();

    int getType();

    String getVideoCover();

    String getVideoUrl();

    int getWidth();

    boolean isSupportShake();
}
