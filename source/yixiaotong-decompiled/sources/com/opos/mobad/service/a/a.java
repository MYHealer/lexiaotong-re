package com.opos.mobad.service.a;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Long> f7328a = new ConcurrentHashMap();

    public long a(String str) {
        long jLongValue = 60000;
        try {
            if (!com.opos.cmn.an.d.a.a(str) && this.f7328a.containsKey(str)) {
                jLongValue = this.f7328a.get(str).longValue();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("CommonConfig", "", (Throwable) e);
        }
        StringBuilder sb = new StringBuilder("getRefreshTime posId=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("CommonConfig", sb.append(str).append(",result=").append(jLongValue).toString());
        return jLongValue;
    }

    public void a(String str, int i) {
        try {
            if (!com.opos.cmn.an.d.a.a(str) && i > 0) {
                this.f7328a.put(str, Long.valueOf(i * 1000));
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("CommonConfig", "", (Throwable) e);
        }
        StringBuilder sb = new StringBuilder("setRefreshTime posId=");
        if (str == null) {
            str = "null";
        }
        com.opos.cmn.an.f.a.b("CommonConfig", sb.append(str).append(",refreshTime=").append(i).toString());
    }
}
