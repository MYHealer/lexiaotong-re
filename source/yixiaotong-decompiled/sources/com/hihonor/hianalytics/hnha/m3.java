package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3661a;
    private String b;
    private Map<String, List<String>> c;

    public m3(int i, String str) {
        this(i, str, null);
    }

    public m3(int i, String str, Map<String, List<String>> map) {
        this.f3661a = i;
        this.b = str;
        this.c = map;
    }

    public String a() {
        return this.b;
    }

    public String a(String str) {
        return a(str, 0);
    }

    public String a(String str, int i) {
        Map<String, List<String>> map = this.c;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        List<String> list = this.c.get(str);
        int size = list == null ? 0 : list.size();
        if (i < 0 || i >= size) {
            return null;
        }
        return list.get(i);
    }

    public int b() {
        return this.f3661a;
    }
}
