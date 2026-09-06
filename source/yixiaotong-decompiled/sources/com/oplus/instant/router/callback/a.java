package com.oplus.instant.router.callback;

import com.oplus.instant.router.g.d;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Callback f5770a;

    public void a(Callback callback) {
        if (callback == null) {
            callback = new b();
        }
        this.f5770a = callback;
    }

    @Override // com.oplus.instant.router.callback.Callback
    public void onResponse(Callback.Response response) {
        if (1 != response.getCode()) {
            HashMap map = new HashMap();
            map.put("failMsg", response.getMsg());
            com.oplus.instant.router.f.a.a().b().onStat(map);
        }
        d.b("router_response", response.toString());
        Callback callback = this.f5770a;
        if (callback != null) {
            callback.onResponse(response);
            this.f5770a = null;
        }
    }
}
