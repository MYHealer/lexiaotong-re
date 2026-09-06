package com.jd.ad.sdk.jad_zm;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs {
    public static final TimeZone jad_bo = TimeZone.getTimeZone("GMT");
    public Map<String, List<String>> jad_an = new TreeMap();

    public static Map<String, String> jad_an(jad_fs jad_fsVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<String>> entry : jad_fsVar.jad_an.entrySet()) {
            linkedHashMap.put(entry.getKey(), TextUtils.join("; ", entry.getValue()));
        }
        return linkedHashMap;
    }

    public String jad_an(String str) {
        List<String> list = this.jad_an.get(str);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public void jad_an(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (!this.jad_an.containsKey(str)) {
            this.jad_an.put(str, new ArrayList(1));
        }
        this.jad_an.get(str).add(str2);
    }

    public void jad_bo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.jad_an.remove(str);
        jad_an(str, str2);
    }
}
