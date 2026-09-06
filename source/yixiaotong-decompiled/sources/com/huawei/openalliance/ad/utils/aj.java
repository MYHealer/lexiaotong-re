package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class aj {
    private static final String Code = "LogTool";

    public static void Code(Context context, int i, String str) {
        if (i < 4) {
            i = 4;
        }
        if (TextUtils.isEmpty(str)) {
            str = az.Code(context);
            if (TextUtils.isEmpty(str)) {
                fh.I(Code, "enable log failed, due to root path is null");
                return;
            }
        }
        fh.Code(i, str, "HiAd");
    }
}
