package com.ubixnow.network.ubix2;

import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.nativee.NativeAd;
import com.ubix.ssp.open.nativee.UBiXImage;
import com.ubix.ssp.open.nativee.UBiXVideo;
import com.ubixnow.ooooo.o0O0o0;
import com.ubixnow.ooooo.o0O0o000;
import com.ubixnow.ooooo.oo0OOoo;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UbixUtils {
    public static o0O0o0 getMaterialInfo(Object obj) {
        ParamsReview paramsReview;
        try {
            o0O0o000 o0o0o000 = new o0O0o000();
            o0O0o0 o0o0o0 = new o0O0o0(o0o0o000);
            if (!(obj instanceof NativeAd) && (paramsReview = (ParamsReview) obj.getClass().getDeclaredMethod("getParamsReview", new Class[0]).invoke(obj, new Object[0])) != null) {
                o0o0o000.OooO(paramsReview.getTitle());
                o0o0o000.OooO0o0(paramsReview.getDesc());
                o0o0o000.OooO0OO(paramsReview.getCreativeId());
                o0o0o000.OooO0Oo(paramsReview.getDeeplinkUrl());
                o0o0o000.OooO0o(paramsReview.getDownloadUrl());
                o0o0o000.OooO0oo(paramsReview.getLandingPageUrl());
                o0o0o000.OooO0O0(paramsReview.getAppPackageName());
                ArrayList arrayList = new ArrayList();
                o0o0o000.OooO00o(arrayList);
                if (paramsReview.isVideo()) {
                    o0o0o000.OooO00o("1");
                    UBiXVideo uBiXVideo = paramsReview.getUBiXVideo();
                    if (uBiXVideo != null) {
                        oo0OOoo oo0oooo = new oo0OOoo(1, uBiXVideo.getVideoUrl(), uBiXVideo.getWidth(), uBiXVideo.getHeight());
                        oo0oooo.OooO0O0(uBiXVideo.getCoverUrl());
                        oo0oooo.OooO0Oo((int) uBiXVideo.getDuration());
                        arrayList.add(oo0oooo);
                    }
                } else {
                    o0o0o000.OooO00o("2");
                    ArrayList<UBiXImage> uBiXImageList = paramsReview.getUBiXImageList();
                    if (uBiXImageList != null) {
                        for (UBiXImage uBiXImage : uBiXImageList) {
                            arrayList.add(new oo0OOoo(2, uBiXImage.getUrl(), uBiXImage.getWidth(), uBiXImage.getHeight()));
                        }
                    }
                }
            }
            return o0o0o0;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getPR(Object obj) {
        try {
            if (!(obj instanceof NativeAd)) {
                obj = obj.getClass().getDeclaredMethod("getParamsReview", new Class[0]).invoke(obj, new Object[0]);
            }
            Method declaredMethod = obj.getClass().getDeclaredMethod("getPR", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(obj, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
