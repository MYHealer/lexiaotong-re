package com.byazt.aas;

import android.text.TextUtils;
import com.alipay.sdk.packet.e;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 215})
public class yp {
    public static String c(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str = e.d;
        if (TextUtils.isEmpty(map.get(e.d))) {
            str = "Content-Type";
        }
        return map.get(str);
    }
}
