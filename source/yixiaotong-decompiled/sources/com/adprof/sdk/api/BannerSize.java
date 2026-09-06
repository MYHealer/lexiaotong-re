package com.adprof.sdk.api;

import com.alipay.sdk.util.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BannerSize implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1049a;
    public final int b;
    public static final BannerSize SIZE_320_50 = new BannerSize(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 50);
    public static final BannerSize SIZE_300_75 = new BannerSize(300, 75);
    public static final BannerSize SIZE_300_120 = new BannerSize(300, 120);

    public BannerSize(int i, int i2) {
        this.f1049a = i;
        this.b = i2;
    }

    public String getDescription() {
        return this.f1049a + "x" + this.b;
    }

    public int getHeight() {
        return this.b;
    }

    public int getWidth() {
        return this.f1049a;
    }

    public String toString() {
        return "BannerSize{" + getDescription() + i.d;
    }
}
