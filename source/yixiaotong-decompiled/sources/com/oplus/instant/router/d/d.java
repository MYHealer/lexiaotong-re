package com.oplus.instant.router.d;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d extends a {
    d(b bVar) {
        super(bVar);
    }

    private Map<String, Object> a() {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(this.f)) {
            map.putAll(com.oplus.instant.router.a.a.a(this.f));
        }
        Map<String, String> map2 = this.c;
        if (map2 != null && map2.size() > 0 && this.f5772a.containsKey("f")) {
            try {
                JSONObject jSONObject = new JSONObject(this.f5772a.get("f"));
                for (String str : this.c.keySet()) {
                    jSONObject.put(str, this.c.get(str));
                }
                this.f5772a.put("f", jSONObject.toString());
            } catch (Exception unused) {
            }
        }
        map.putAll(this.f5772a);
        if (!map.containsKey("scheme")) {
            map.put("scheme", "oaps");
        }
        if (!map.containsKey("host")) {
            map.put("host", "instant");
        }
        return map;
    }

    @Override // com.oplus.instant.router.Instant.Req
    public void preload(Context context) {
        com.oplus.instant.router.g.e.b(StubApp.getOrigApplicationContext(context.getApplicationContext()), com.oplus.instant.router.a.a.a(a()), this.f5772a, this.b, this.c, this.d, this.e);
    }

    @Override // com.oplus.instant.router.Instant.Req
    public void request(Context context) {
        com.oplus.instant.router.g.e.a(context, com.oplus.instant.router.a.a.a(a()), this.f5772a, this.b, this.c, this.d, this.e);
    }
}
