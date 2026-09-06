package com.cdo.oaps.ad;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
class t {
    public static String a(long j, String str, boolean z, String str2, String str3, int i, String str4) {
        return Uri.encode("out_pid=" + j + "&out_package_name=" + str + "&out_start_download=" + z + "&out_intent_from=" + i + "&enter_id=" + str2 + "&out_operator=" + str3 + "&out_match_type=" + str4);
    }

    public static String a(Context context, long j, String str, boolean z, boolean z2, String str2, String str3, int i, String str4) {
        return "softmarket://market_appdetail?params=" + a(j, str, z, str2, str3, i, str4) + "&gb=" + (z2 ? 1 : 0);
    }

    public static String a(Context context, String str, String str2, boolean z) {
        return "softmarket://market_mainmenu?params=" + a(str, str2) + "&gb=" + (z ? 1 : 0);
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2, String str3, String str4, String str5, int i) {
        return "softmarket://market_search_result?params=" + a(str, str2, z, str3, str4, i, str5) + "&gb=" + (z2 ? 1 : 0);
    }

    public static String a(Context context, String str, boolean z, String str2, String str3, int i, String str4) {
        return "softmarket://market_latestact?params=" + a(str, str2, str3, i, str4) + "&gb=" + (z ? 1 : 0);
    }

    private static String a(String str, String str2) {
        return Uri.encode("enter_id=" + str + "&out_operator=" + str2);
    }

    public static String a(String str, String str2, String str3, int i, String str4) {
        return Uri.encode("url=" + str + "&out_intent_from=" + i + "&enter_id=" + str2 + "&out_operator=" + str3 + "&out_match_type=" + str4);
    }

    private static String a(String str, String str2, boolean z, String str3, String str4, int i, String str5) {
        return Uri.encode("out_package_name=" + str2 + "&out_app_name=" + str + "&out_operator=" + str4 + "&out_start_download=" + z + "&out_intent_from=" + i + "&enter_id=" + str3 + "&out_operator=" + str4 + "&out_match_type=" + str5);
    }

    public static boolean a(Context context, long j, String str, String str2, int i, String str3, String str4, String str5) {
        Intent intent = new Intent();
        intent.setAction(str5);
        intent.setPackage(af.b(context));
        intent.putExtra("out_pid", j);
        intent.putExtra("out_package_name", str);
        intent.putExtra("out_operator", str2);
        intent.putExtra("out_match_type", str4);
        intent.putExtra("out_intent_from", i);
        intent.putExtra("enter_id", str3);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 32);
        if (listQueryIntentServices == null || listQueryIntentServices.size() <= 0) {
            return false;
        }
        context.startService(intent);
        return true;
    }
}
