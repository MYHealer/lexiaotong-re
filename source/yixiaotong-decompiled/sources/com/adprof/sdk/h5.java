package com.adprof.sdk;

import android.content.Context;
import com.adprof.sdk.api.BannerSize;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class h5 {
    public static g5 a(Context context, d dVar, boolean z, BannerSize bannerSize, boolean z2) {
        if (bannerSize == null) {
            bannerSize = BannerSize.SIZE_320_50;
        }
        BannerSize bannerSize2 = bannerSize;
        if (bannerSize2 == BannerSize.SIZE_300_75) {
            return new d5(context, dVar, z, bannerSize2, z2);
        }
        return bannerSize2 == BannerSize.SIZE_300_120 ? new b5(context, dVar, z, bannerSize2, z2) : new f5(context, dVar, z, bannerSize2, z2);
    }
}
