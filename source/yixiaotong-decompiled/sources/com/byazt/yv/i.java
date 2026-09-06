package com.byazt.yv;

import com.huawei.openalliance.ad.constant.ai;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, ai.y, 42})
public class i {
    public static final x c = new x();
    public static final Map<String, String> tt = new ConcurrentHashMap();

    public static String c(String str) throws IllegalArgumentException {
        Map<String, String> map = tt;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String strC = c.c(str);
        if (strC != null) {
            map.put(str, strC);
        }
        return strC;
    }
}
