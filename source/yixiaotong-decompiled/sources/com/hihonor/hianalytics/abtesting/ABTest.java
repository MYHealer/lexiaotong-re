package com.hihonor.hianalytics.abtesting;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.j2;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class ABTest {
    private static final String TAG = "ABTest";

    public static String getExpParam(String str, String str2) {
        j2.c(TAG, "getExpParam() is execute");
        if (TextUtils.isEmpty(str)) {
            j2.g(TAG, "paramkey is null");
        } else {
            String strA = a.b().a(str);
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        return str2;
    }

    public static void initABTest(Context context, ABTestConfig aBTestConfig) {
        j2.c(TAG, "initABTest() is execute");
        a.b().a(context, aBTestConfig);
    }

    public static void onEvent(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        j2.c(TAG, "onEvent() is execute");
        if (TextUtils.isEmpty(str)) {
            j2.g(TAG, "onEvent() paramkey is null");
        } else {
            a.b().a(str, str2, linkedHashMap);
        }
    }

    public static void onReport() {
        j2.c(TAG, "onReport() is execute");
        a.b().c();
    }

    public static void setExpSyncInterval(int i) {
        j2.c(TAG, "setExpSyncInterval() is execute");
        if (i < 10) {
            i = 10;
        }
        a.b().a(i);
    }

    public static void syncExpParameters() {
        j2.c(TAG, "syncExpParameters() is execute");
        a.b().f();
    }
}
