package com.huawei.hms.scankit.p;

import android.os.Bundle;
import com.huawei.hms.feature.DynamicModuleInitializer;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: HaLog60002.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class h3 extends e3 {

    /* JADX INFO: compiled from: HaLog60002.java */
    class a extends LinkedHashMap<String, String> {
        a() {
            h3.this.g();
            putAll(h3.this.b);
        }
    }

    public h3() {
        super(null, DynamicModuleInitializer.getContext());
    }

    public void c(Bundle bundle) {
        if (bundle == null || !a()) {
            return;
        }
        try {
            if (bundle.containsKey("scanType") && (bundle.get("scanType") instanceof Integer)) {
                bundle.putString("scanType", e3.a(bundle.getInt("scanType")));
            }
            a aVar = new a();
            for (String str : bundle.keySet()) {
                aVar.put(str, String.valueOf(bundle.get(str)));
            }
            j3.b().b("60002", aVar);
        } catch (RuntimeException unused) {
            x3.b("HaLog60002", "RuntimeException");
        } catch (Exception unused2) {
            x3.b("HaLog60002", "Exception");
        }
    }
}
