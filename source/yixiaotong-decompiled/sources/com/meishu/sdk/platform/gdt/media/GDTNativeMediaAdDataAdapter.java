package com.meishu.sdk.platform.gdt.media;

import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.media.c;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTNativeMediaAdDataAdapter {
    private NativeUnifiedADData nativeMediaADData;

    public GDTNativeMediaAdDataAdapter(NativeUnifiedADData nativeUnifiedADData) {
        this.nativeMediaADData = nativeUnifiedADData;
    }

    public void bindView(ViewGroup viewGroup, boolean z) {
    }

    public int getAdPatternType() {
        return this.nativeMediaADData.getAdPatternType();
    }

    public int getCurrentPosition() {
        return this.nativeMediaADData.getVideoCurrentPosition();
    }

    public String getDesc() {
        return this.nativeMediaADData.getDesc();
    }

    public int getDuration() {
        return this.nativeMediaADData.getVideoDuration();
    }

    public int getECPM() {
        return this.nativeMediaADData.getECPM();
    }

    public String getIconUrl() {
        return this.nativeMediaADData.getIconUrl();
    }

    public List<String> getImgList() {
        return this.nativeMediaADData.getImgList();
    }

    public String getImgUrl() {
        return this.nativeMediaADData.getImgUrl();
    }

    public int getProgress() {
        return this.nativeMediaADData.getProgress();
    }

    public String getTitle() {
        return this.nativeMediaADData.getTitle();
    }

    public boolean isPlaying() {
        return false;
    }

    public void onClicked(View view) {
    }

    public void onExposured(View view) {
    }

    public void onScroll(int i, View view) {
    }

    public void play() {
        this.nativeMediaADData.startVideo();
    }

    public void preLoadVideo() {
    }

    public void resume() {
        this.nativeMediaADData.resume();
    }

    public void setMediaListener(c cVar) {
    }

    public void stop() {
        this.nativeMediaADData.stopVideo();
    }
}
