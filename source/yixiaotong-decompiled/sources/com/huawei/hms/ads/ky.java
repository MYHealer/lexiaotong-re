package com.huawei.hms.ads;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ky {
    private static final String Code = "ShowTrackerUtil";

    public static String Code(Bundle bundle) {
        String strOptString = com.huawei.openalliance.ad.utils.bc.V(bundle).optString(com.huawei.openalliance.ad.constant.bf.an, "");
        if (!com.huawei.openalliance.ad.utils.bc.L(strOptString)) {
            strOptString = null;
        }
        fh.V(Code, "decouple bundleCreativeSize: %s", strOptString);
        return strOptString;
    }

    public static String Code(View view) {
        if (view == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int width = view.getWidth();
        String string = sb.append(width).append("*").append(view.getHeight()).toString();
        fh.V(Code, "decouple adViewCreativeSize: %s", string);
        return string;
    }

    public static Rect V(View view) {
        if (view == null) {
            return null;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        fh.Code(Code, "viewRect: %s", rect.toString());
        return rect;
    }

    public static String V(Bundle bundle) {
        String strOptString = com.huawei.openalliance.ad.utils.bc.V(bundle).optString(com.huawei.openalliance.ad.constant.bf.aL, "");
        if (!com.huawei.openalliance.ad.utils.bc.D(strOptString)) {
            strOptString = null;
        }
        fh.Code(Code, "slotPosition: %s", strOptString);
        return strOptString;
    }
}
