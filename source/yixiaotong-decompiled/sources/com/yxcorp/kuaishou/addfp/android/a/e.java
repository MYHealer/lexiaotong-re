package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f9694a;
    private SharedPreferences.Editor b;

    public e(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f9694a = sharedPreferences;
            this.b = sharedPreferences.edit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(String str) {
        this.b.putString("kwtk", str);
        this.b.commit();
    }

    public boolean a() {
        return this.f9694a.getBoolean("xytk", true);
    }

    public String b() {
        return this.f9694a.getString("kwtk", "");
    }
}
