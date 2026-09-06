package com.unionpay.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public final class e {
    public static String a(Context context) {
        try {
            String packageName = context instanceof Activity ? ((Activity) context).getPackageName() : "";
            return packageName == null ? "" : packageName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String strA = UPUtils.a(context, "merchant_id");
            if (TextUtils.isEmpty(strA)) {
                strA = UUID.randomUUID().toString();
                if (!TextUtils.isEmpty(strA)) {
                    strA = strA.replaceAll(x.A, "");
                    UPUtils.a(context, strA, "merchant_id");
                }
            }
            return strA;
        } catch (Exception unused) {
            return "";
        }
    }
}
