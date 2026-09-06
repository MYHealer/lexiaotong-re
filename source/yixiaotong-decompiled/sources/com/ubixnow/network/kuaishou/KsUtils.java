package com.ubixnow.network.kuaishou;

import android.text.TextUtils;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd;
import com.ubixnow.ooooo.o00oO0o;
import com.ubixnow.ooooo.o0O0o0;
import com.ubixnow.ooooo.o0O0o000;
import com.ubixnow.ooooo.oo0OOoo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class KsUtils {
    private static KSAdInfoData OooO00o(Object obj) {
        List<KSAdInfoData> kSAdInfoDatas;
        if (obj instanceof KsSplashScreenAd) {
            return ((KsSplashScreenAd) obj).getKSAdInfoData();
        }
        if (!(obj instanceof KsRewardVideoAd) || (kSAdInfoDatas = ((KsRewardVideoAd) obj).getKSAdInfoDatas()) == null || kSAdInfoDatas.isEmpty()) {
            return null;
        }
        return kSAdInfoDatas.get(0);
    }

    private static void OooO00o(o0O0o0 o0o0o0, Object obj) {
        Field declaredField;
        Object obj2 = null;
        try {
            try {
                declaredField = obj.getClass().getDeclaredField("mAdTemplate");
            } catch (Throwable unused) {
                declaredField = obj.getClass().getSuperclass() != null ? obj.getClass().getSuperclass().getDeclaredField("mAdTemplate") : null;
            }
            if (declaredField != null) {
                declaredField.setAccessible(true);
                obj2 = declaredField.get(obj);
            }
            if (obj2 == null || !obj2.getClass().getName().contains("AdTemplate")) {
                return;
            }
            Field declaredField2 = obj2.getClass().getDeclaredField("mOriginJString");
            declaredField2.setAccessible(true);
            String str = (String) declaredField2.get(obj2);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o0O0o000 o0o0o000 = new o0O0o000();
            o0o0o000.OooO0oO(str);
            o0o0o0.OooO00o = o0o0o000;
        } catch (Throwable unused2) {
        }
    }

    private static void OooO0O0(o0O0o0 o0o0o0, Object obj) {
        try {
            KSAdInfoData kSAdInfoDataOooO00o = OooO00o(obj);
            if (kSAdInfoDataOooO00o != null) {
                o0O0o000 o0o0o000 = new o0O0o000();
                o0o0o0.OooO0O0 = o0o0o000;
                o0o0o000.OooO0o0(kSAdInfoDataOooO00o.getAdDescription());
                o0o0o0.OooO0O0.OooO0OO(kSAdInfoDataOooO00o.getCreativeId() + "");
                String videoUrl = kSAdInfoDataOooO00o.getVideoUrl();
                String videoCoverImageUrl = kSAdInfoDataOooO00o.getVideoCoverImageUrl();
                o0o0o0.OooO0O0.OooO0OO = new ArrayList();
                int materialType = kSAdInfoDataOooO00o.getMaterialType();
                if (materialType == 1 || materialType == 8) {
                    o0o0o0.OooO0O0.OooO00o("1");
                    oo0OOoo oo0oooo = new oo0OOoo(1, videoUrl);
                    oo0oooo.OooO0O0(videoCoverImageUrl);
                    o0o0o0.OooO0O0.OooO0OO.add(oo0oooo);
                } else if (materialType == 2 || materialType == 3 || materialType == 5) {
                    o0o0o0.OooO0O0.OooO00o("2");
                    List<String> imageUrlArray = kSAdInfoDataOooO00o.getImageUrlArray();
                    if (imageUrlArray != null && !imageUrlArray.isEmpty()) {
                        Iterator<String> it = imageUrlArray.iterator();
                        while (it.hasNext()) {
                            o0o0o0.OooO0O0.OooO0OO.add(new oo0OOoo(2, it.next()));
                        }
                    }
                }
                if (TextUtils.isEmpty(kSAdInfoDataOooO00o.getAppName())) {
                    o0o0o0.OooO0O0.OooOO0(kSAdInfoDataOooO00o.getProductName());
                } else {
                    o0o0o0.OooO0O0.OooOO0(kSAdInfoDataOooO00o.getAppName());
                    o0o0o0.OooO0O0.OooO(kSAdInfoDataOooO00o.getAppName());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static o0O0o0 getMaterialInfo(Object obj) {
        o0O0o0 o0o0o0 = new o0O0o0();
        OooO00o(o0o0o0, obj);
        OooO0O0(o0o0o0, obj);
        return o0o0o0;
    }

    public static o0O0o0 getMaterialInfo(Object obj, UMNCustomNativeAd uMNCustomNativeAd) {
        o0O0o0 o0o0o0 = new o0O0o0();
        OooO00o(o0o0o0, obj);
        o00oO0o.OooO00o(o0o0o0, uMNCustomNativeAd);
        return o0o0o0;
    }
}
