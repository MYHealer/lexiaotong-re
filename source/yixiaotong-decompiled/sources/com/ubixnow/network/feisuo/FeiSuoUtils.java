package com.ubixnow.network.feisuo;

import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.o0O0o0;
import com.ubixnow.ooooo.o0O0o000;
import com.ubixnow.ooooo.oo0OOoo;
import com.zm.fissionsdk.api.interfaces.IFissionNative;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FeiSuoUtils {
    public static String getFailInfo(o00OO0OO o00oo0oo) {
        try {
            return o00oo0oo.OooO00o ? o00oo0oo.OooO0O0 + "" : o00oo0oo.OooO0Oo.OooO00o + "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static o0O0o0 getMaterialInfo(IFissionNative iFissionNative) {
        try {
            o0O0o000 o0o0o000 = new o0O0o000();
            o0O0o0 o0o0o0 = new o0O0o0(o0o0o000);
            o0o0o000.OooO(iFissionNative.getTitle());
            o0o0o000.OooO0o0(iFissionNative.getDesc());
            o0o0o000.OooO0OO(iFissionNative.getSid());
            o0o0o000.OooOO0(iFissionNative.getAppName());
            o0o0o000.OooO0O0(iFissionNative.getPackageName());
            ArrayList arrayList = new ArrayList();
            o0o0o000.OooO00o(arrayList);
            if (isImg(iFissionNative)) {
                o0o0o000.OooO00o("2");
                List imageList = iFissionNative.getImageList();
                if (imageList != null) {
                    int i = 0;
                    while (i < imageList.size()) {
                        arrayList.add(i == 0 ? new oo0OOoo(2, (String) imageList.get(i), iFissionNative.getMaterialWidth(), iFissionNative.getMaterialHeight()) : new oo0OOoo(2, (String) imageList.get(i)));
                        i++;
                    }
                }
            }
            return o0o0o0;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean isImg(IFissionNative iFissionNative) {
        return iFissionNative.getMaterialType() == 1 || iFissionNative.getMaterialType() == 2 || iFissionNative.getMaterialType() == 3 || iFissionNative.getMaterialType() == 6;
    }

    public static boolean isVideo(IFissionNative iFissionNative) {
        return iFissionNative.getMaterialType() == 7 || iFissionNative.getMaterialType() == 4;
    }
}
