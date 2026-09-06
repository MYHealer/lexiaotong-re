package com.ubixnow.ooooo;

import android.content.Context;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class f {
    private static final String OooO = "---ubix.UbixDataUtils";
    private static final String OooO00o = "02:00:00:00:00:00";
    private static final String OooO0O0 = "ubixdata";
    private static final String OooO0OO = "ubixdata.user.agent";
    private static final String OooO0Oo = "ubixdata.app.version";
    public static final String OooO0o = "getprop hw_sc.build.platform.version";
    private static final String OooO0o0 = "ubixdata.device.id";
    private static final Set<String> OooO0oO = new HashSet();
    private static final Map<String, String> OooO0oo = new HashMap();

    public static boolean OooO00o(Context context, String str) {
        Class<?> cls;
        try {
            if (OooO0oO.contains(str)) {
                return true;
            }
            try {
                cls = Class.forName("android.support.v4.content.ContextCompat");
            } catch (Exception unused) {
                cls = null;
            }
            if (cls == null) {
                try {
                    cls = Class.forName("androidx.core.content.ContextCompat");
                } catch (Exception unused2) {
                }
            }
            if (cls == null) {
                OooO0oO.add(str);
                return true;
            }
            if (((Integer) cls.getMethod("checkSelfPermission", Context.class, String.class).invoke(null, context, str)).intValue() != 0) {
                oOO0O0O.OooO0O0(OooO, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"" + str + "\" />");
                return false;
            }
            OooO0oO.add(str);
            return true;
        } catch (Exception e) {
            oOO0O0O.OooO0O0(OooO, e.toString());
            return true;
        }
    }
}
