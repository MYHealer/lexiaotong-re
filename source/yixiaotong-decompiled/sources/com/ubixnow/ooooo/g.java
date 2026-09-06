package com.ubixnow.ooooo;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g {
    private static final String OooO00o = "---Ubix.UbixSpUtils";
    private static OooO00o OooO0O0;

    public interface OooO00o {
        SharedPreferences OooO00o(Context context, String str, int i);
    }

    public static SharedPreferences OooO00o(Context context, String str, int i) {
        SharedPreferences sharedPreferencesOooO00o;
        OooO00o oooO00o = OooO0O0;
        if (oooO00o == null || (sharedPreferencesOooO00o = oooO00o.OooO00o(context, str, i)) == null) {
            return context.getSharedPreferences(str, i);
        }
        oOO0O0O.OooO00o(OooO00o, "create SharedPreferences by user default, file name is: " + str);
        return sharedPreferencesOooO00o;
    }

    public static void OooO00o(OooO00o oooO00o) {
        OooO0O0 = oooO00o;
    }
}
