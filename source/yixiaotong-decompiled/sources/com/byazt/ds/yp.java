package com.byazt.ds;

import android.content.Context;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 215})
public final class yp extends ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f2117a;
    public final Context n;

    public yp(Context context, x xVar) {
        super(true, false);
        this.n = context;
        this.f2117a = xVar;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException, SecurityException {
        Map<String, String> mapC = com.byazt.vm.sp.c(this.n, this.f2117a.n());
        if (mapC == null) {
            return !com.byazt.gj.c.tt;
        }
        jSONObject.put("oaid", new JSONObject(mapC));
        return true;
    }
}
