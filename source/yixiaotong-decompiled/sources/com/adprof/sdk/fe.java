package com.adprof.sdk;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class fe implements eb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ he f1170a;

    public fe(he heVar) {
        this.f1170a = heVar;
    }

    @Override // com.adprof.sdk.eb
    public void a(Exception exc) {
    }

    @Override // com.adprof.sdk.eb
    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            he heVar = this.f1170a;
            heVar.e = str;
            if (!str.equalsIgnoreCase(heVar.d)) {
                String str2 = a8.f13a;
                if (!TextUtils.isEmpty(str)) {
                    sl.a("o_aid_encrypt", a.b(str, "adprof_private_a"));
                }
            }
        }
        this.f1170a.f354a = true;
    }
}
