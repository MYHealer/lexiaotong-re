package com.cdo.oaps.ad;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
class z {
    private static String a(long j, String str, int i, String str2, String str3, String str4, int i2) {
        return Uri.encode("out_package_name=" + str + "&out_pid=" + j + "&out_operator_type=" + i + "&out_intent_from=" + i2 + "&enter_id=" + str2 + "&enter_params=" + ("out_operator#" + str3 + (ab.a(str4) ? "" : "^out_match_type#" + str4)));
    }

    private static String a(long j, String str, boolean z, String str2, String str3, String str4, int i, String str5) {
        return Uri.encode("out_pid=" + j + "&out_package_name=" + str + "&out_start_download=" + z + "&out_intent_from=" + i + "&enter_id=" + str2 + "&enter_params=" + ("out_operator#" + str3 + (ab.a(str4) ? "" : "^out_match_type#" + str4)) + "&cpd_params=" + ("Ext-Module#" + str5));
    }

    public static String a(Context context, long j, String str, int i, String str2, String str3, String str4, int i2) {
        return "softmarket://market_pre_download?params=" + a(j, str, i, str2, str3, str4, i2);
    }

    public static String a(Context context, long j, String str, boolean z, boolean z2, String str2, String str3, String str4, int i, String str5) {
        return "softmarket://market_appdetail?params=" + a(j, str, z, str2, str3, str4, i, str5) + "&gb=" + (z2 ? 1 : 0);
    }

    public static String a(Context context, String str, String str2, boolean z) {
        return "softmarket://market_mainmenu?params=" + a(str, str2) + "&gb=" + (z ? 1 : 0);
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2, String str3, String str4, String str5, int i) {
        return "softmarket://market_search_result?params=" + a(str, str2, z, str3, str4, str5, i) + "&gb=" + (z2 ? 1 : 0);
    }

    public static String a(Context context, String str, boolean z, String str2, String str3, String str4, int i, String str5) {
        return "softmarket://market_latestact?params=" + a(str, str2, str3, str4, i, str4) + "&gb=" + (z ? 1 : 0);
    }

    private static String a(String str, String str2) {
        return Uri.encode("enter_id=" + str + "&enter_params=" + ("out_operator#" + str2));
    }

    public static String a(String str, String str2, String str3, String str4, int i, String str5) {
        return Uri.encode("url=" + str + "&out_intent_from=" + i + "&enter_id=" + str2 + "&enter_params=" + ("out_operator#" + str3 + (ab.a(str4) ? "" : "^out_match_type#" + str4)) + "&cpd_params=" + ("Ext-Module#" + str5));
    }

    private static String a(String str, String str2, boolean z, String str3, String str4, String str5, int i) {
        return Uri.encode("out_package_name=" + str2 + "&out_app_name=" + str + "&out_operator=" + str4 + "&out_start_download=" + z + "&out_intent_from=" + i + "&enter_id=" + str3 + "&enter_params=" + ("out_operator#" + str4 + (ab.a(str5) ? "" : "^out_match_type#" + str5)));
    }
}
