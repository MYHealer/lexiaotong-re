package com.adprof.sdk;

import android.os.Build;
import android.text.TextUtils;
import com.ubixnow.ooooo.o0OO000o;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class jh extends mh {
    public String o;

    @Override // com.adprof.sdk.mh
    public String a(Map map) {
        if (m686a(map)) {
            try {
                JSONObject jSONObject = new JSONObject(new JSONTokener(super.a(map)));
                if (map.get(o0OO000o.o00O00oO) == null) {
                    jSONObject.put(o0OO000o.o00O00oO, c8.a().m587a());
                }
                jSONObject.put("d_m", m684a());
                AtomicInteger atomicInteger = he.f346a;
                String str = g8.f312a;
                jSONObject.put("vender", Build.MANUFACTURER);
                if (!TextUtils.isEmpty(this.o)) {
                    jSONObject.put("Crash_msg", this.o.length() > 800 ? this.o.substring(0, 800) : this.o);
                }
                String string = jSONObject.toString();
                if (pk.f594a) {
                    pk.d("statistic dc_debug item ======= " + string);
                }
                return string;
            } catch (Exception unused) {
            }
        }
        return super.a(map);
    }
}
