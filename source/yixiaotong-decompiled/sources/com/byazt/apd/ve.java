package com.byazt.apd;

import android.net.Uri;
import android.text.TextUtils;
import com.byazt.nr.m;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1580, 54})
public class ve {
    public static String c(Uri uri, String str) {
        return (uri == null || !uri.isHierarchical() || str == null) ? "" : uri.getQueryParameter(str);
    }

    public static Uri c(Uri uri, Map<String, String> map) {
        if (uri != null && map != null && map.size() > 0) {
            try {
                Uri.Builder builderBuildUpon = uri.buildUpon();
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        builderBuildUpon.appendQueryParameter(str, map.get(str));
                    }
                }
                return builderBuildUpon.build();
            } catch (Exception e) {
                m.c(e);
            }
        }
        return uri;
    }
}
