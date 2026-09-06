package com.hihonor.adsdk.base.callback.filter;

import com.hihonor.adsdk.common.b.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AdFilteringLog {
    public static final String FILTER_TYPE_HN = "ADFilterTagHN";
    public static final String FILTER_TYPE_POLYMERIZE = "ADFilterTagPolymerize";
    public static final String TAG = "AdFilteringLog";

    public static void info(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append("[");
            sb.append(str);
            sb.append("]");
        }
        b.hnadsc(TAG, sb.toString(), new Object[0]);
    }
}
