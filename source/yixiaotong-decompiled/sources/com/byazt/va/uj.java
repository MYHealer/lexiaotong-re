package com.byazt.va;

import android.text.TextUtils;
import com.byazt.gqp.t;
import com.byazt.gqp.yp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 116, 15})
public abstract class uj {
    public Map<String, Object> c;
    public Object tt;
    public t ve;
    public String uj = null;
    public final Map<String, String> n = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2807a = null;
    public boolean sp = false;

    public abstract com.byazt.hm.tt c();

    public void c(String str) {
        this.f2807a = str;
    }

    public void c(boolean z) {
        this.sp = z;
    }

    public void n(Map<String, Object> map) {
        this.c = map;
    }

    public String tt() {
        return this.uj;
    }

    public void tt(String str) {
        this.uj = str;
    }

    public Object uj() {
        return this.tt;
    }

    public Map<String, Object> ve() {
        return this.c;
    }

    public uj(t tVar) {
        this.ve = tVar;
        tt(UUID.randomUUID().toString());
    }

    public void tt(String str, String str2) {
        this.n.put(str, str2);
    }

    public void uj(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.n.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void c(yp.c cVar) {
        if (cVar != null && this.n.size() > 0) {
            for (Map.Entry<String, String> entry : this.n.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    cVar.tt(key, value);
                }
            }
        }
    }
}
