package com.byazt.ip;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 1363, 71})
public class x {
    public long c;
    public Map<String, Object> tt = new ConcurrentHashMap();

    public long c() {
        return this.c;
    }

    public x(long j) {
        this.c = j;
    }

    public void c(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.tt.put(str, obj);
    }

    public Object c(String str) {
        if (str == null) {
            return null;
        }
        return this.tt.get(str);
    }
}
