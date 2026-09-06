package com.yfanads.android.qapp;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class QuickMgr {
    private static String TAG = "QApp-Hap";
    private static String[] URIS;

    public static void install(Context context, String str, String[] strArr) {
        try {
            if (!TextUtils.isEmpty(str)) {
                TAG = str;
            }
            URIS = strArr;
            new QabRun().install(context, str, strArr);
        } catch (Exception e) {
            Log.e(TAG, "hook failed " + e.getMessage());
        }
    }

    public static boolean isBlocked(String str) {
        try {
            String[] strArr = URIS;
            if (strArr != null && strArr.length != 0) {
                Log.d(TAG, "isBlocked uri: " + str);
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                for (String str2 : URIS) {
                    if (matchRule(str, str2)) {
                        Log.d(TAG, "isBlocked quick-app rule: " + str2 + ", uri " + str);
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            Log.e(TAG, "hook isBlocked " + e.getMessage());
        }
    }

    private static boolean matchRule(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str.startsWith(str2);
    }
}
