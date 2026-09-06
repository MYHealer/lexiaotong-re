package com.ubixnow.ooooo;

import android.text.TextUtils;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.core.api.UMNImageInfo;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o00oO0o {
    public static o0O0o0 OooO00o(o0O0o0 o0o0o0, UMNCustomNativeAd uMNCustomNativeAd) {
        if (uMNCustomNativeAd != null) {
            try {
                o0o0o0.OooO0O0 = new o0O0o000();
                if (uMNCustomNativeAd.getAdType().equals("1")) {
                    o0o0o0.OooO0O0.OooO00o("1");
                    oo0OOoo oo0oooo = new oo0OOoo(1, uMNCustomNativeAd.getVideoUrl(), uMNCustomNativeAd.getVideoWidth(), uMNCustomNativeAd.getVideoHeight());
                    oo0oooo.OooO0O0(uMNCustomNativeAd.getVideoCoverUrl());
                    oo0oooo.OooO0Oo(uMNCustomNativeAd.getVideoDuration());
                    o0o0o0.OooO0O0.OooO0OO.add(oo0oooo);
                } else if (uMNCustomNativeAd.getAdType().equals("2")) {
                    o0o0o0.OooO0O0.OooO00o("2");
                    List<UMNImageInfo> imageUrlList = uMNCustomNativeAd.getImageUrlList();
                    String mainImageUrl = uMNCustomNativeAd.getMainImageUrl();
                    if (!TextUtils.isEmpty(mainImageUrl)) {
                        o0o0o0.OooO0O0.OooO0OO.add(new oo0OOoo(2, mainImageUrl, uMNCustomNativeAd.getMainImgWidth(), uMNCustomNativeAd.getMainImgHeight()));
                    }
                    if (imageUrlList != null && !imageUrlList.isEmpty()) {
                        for (UMNImageInfo uMNImageInfo : imageUrlList) {
                            if (!Objects.equals(uMNImageInfo.url, mainImageUrl)) {
                                o0o0o0.OooO0O0.OooO0OO.add(new oo0OOoo(2, uMNImageInfo.url, uMNImageInfo.width, uMNImageInfo.height));
                            }
                        }
                    }
                }
                o0o0o0.OooO0O0.OooO(uMNCustomNativeAd.getTitle());
                o0o0o0.OooO0O0.OooO0o0(uMNCustomNativeAd.getDescriptionText());
                o0o0o0.OooO0O0.OooO0O0(uMNCustomNativeAd.getAppPackageName());
                o0o0o0.OooO0O0.OooO0OO(uMNCustomNativeAd.getCreativeId());
                o0o0o0.OooO0O0.OooO0o(uMNCustomNativeAd.getDownloadUrl());
                o0o0o0.OooO0O0.OooO0Oo(uMNCustomNativeAd.getDeeplinkUrl());
                o0o0o0.OooO0O0.OooO0oo(uMNCustomNativeAd.getLandingPageUrl());
                o0o0o0.OooO0O0.OooOO0(uMNCustomNativeAd.getUserName());
            } catch (Throwable unused) {
            }
        }
        return o0o0o0;
    }
}
