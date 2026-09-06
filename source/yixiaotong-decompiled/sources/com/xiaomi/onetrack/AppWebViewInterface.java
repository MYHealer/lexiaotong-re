package com.xiaomi.onetrack;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.common.base.Ascii;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class AppWebViewInterface {
    private OneTrack b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9372a = s.d(new byte[]{121, 70, 70, 99, 82, 6, 55, 13, 3, Ascii.NAK, 120, 11, 76, 83, 68, 82, 86, 7, 4}, "86647d");
    public static final String JAVASCRIPT_INTERFACE_NAME = s.d(new byte[]{41, 94, 81, 99, Ascii.ETB, 2, 2, 15, 57, 35, 97, 53, 57, 120, 1, 104, 39, 17, 8, 0, 1, 7}, "f047ec");

    public AppWebViewInterface(OneTrack oneTrack) {
        this.b = oneTrack;
    }

    @JavascriptInterface
    public boolean track(String str) {
        String strD;
        String str2 = s.d(new byte[]{70, 80, 0, 4, 93, 78, 4, 0, 70, 10, 4, 69, 80, 84, Ascii.ETB, 0, 26, Ascii.CAN, 5, 5, Ascii.DC2, 3, 11, 69}, "45ca48") + str;
        String str3 = f9372a;
        p.a(str3, str2);
        if (this.b == null) {
            strD = s.d(new byte[]{8, 122, 95, 6, 48, 71, 0, 7, 13, 66, 88, Ascii.SYN, 69, 91, 68, 15, 8, Ascii.EM, 65, Ascii.SYN, 3, Ascii.SYN, 68, Ascii.ETB, 11, Ascii.NAK, 87, 2, 8, 70, 4}, "e51cd5");
        } else {
            if (!TextUtils.isEmpty(str)) {
                this.b.trackEventFromH5(str);
                return true;
            }
            strD = s.d(new byte[]{93, 83, 65, 84, 85, 77, 0, 68, 15, 17, 17, 0, 88, Ascii.SYN, Ascii.NAK, 73, Ascii.CAN, Ascii.EM, 19, 1, Ascii.DC2, Ascii.ETB, 67, 11, Ascii.NAK, 0, 0, 92, 71, 92}, "5fa049");
        }
        p.a(str3, strD);
        return false;
    }
}
