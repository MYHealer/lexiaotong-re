package com.byazt.ds;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 20})
public class c extends ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f2109a;
    public final Context n;

    public c(Context context, x xVar) {
        super(true, false);
        this.n = context;
        this.f2109a = xVar;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException, SecurityException {
        if (!TextUtils.isEmpty(this.f2109a.cu())) {
            jSONObject.put("ab_client", this.f2109a.cu());
        }
        if (!TextUtils.isEmpty(this.f2109a.my())) {
            if (com.byazt.yv.da.tt) {
                com.byazt.yv.da.c("init config has abversion:" + this.f2109a.my(), null);
            }
            jSONObject.put("ab_version", this.f2109a.my());
        }
        if (!TextUtils.isEmpty(this.f2109a.qp())) {
            jSONObject.put("ab_group", this.f2109a.qp());
        }
        if (TextUtils.isEmpty(this.f2109a.nb())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f2109a.nb());
        return true;
    }
}
