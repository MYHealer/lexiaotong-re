package com.hihonor.hianalytics.hnha;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class m1 implements r0 {
    private static m1 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3660a;

    public m1(Context context) {
        this.f3660a = context;
    }

    public static m1 a(Context context) {
        m1 m1Var;
        synchronized (q0.class) {
            if (b == null) {
                b = new m1(context);
            }
            m1Var = b;
        }
        return m1Var;
    }

    public void a() {
        q0.b().a(this.f3660a, this);
    }

    @Override // com.hihonor.hianalytics.hnha.r0
    public void a(JSONObject jSONObject) {
        n1.a().a(jSONObject);
    }

    public void b() {
        q0.b().c();
    }
}
