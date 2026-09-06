package com.huawei.hms.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static final String Code = "ReportUrlFormatStrategy";

    public String Code(Map<String, Object> map, String str) {
        if (com.huawei.openalliance.ad.utils.al.Code(map) || TextUtils.isEmpty(str)) {
            fh.V(Code, "urlInfo or url is isEmpty");
            return str;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            fh.Code(Code, "format url key is %s, value is %s", key, value);
            if (key != null && value != null) {
                str = str.replace(key, String.valueOf(value));
            }
        }
        return str;
    }
}
