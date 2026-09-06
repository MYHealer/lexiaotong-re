package com.adprof.sdk;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class z7 implements eb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ eb f1551a;

    public z7(eb ebVar) {
        this.f1551a = ebVar;
    }

    @Override // com.adprof.sdk.eb
    public void a(String str) {
        try {
            a8.f13a = str;
            this.f1551a.a(str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            sl.a("o_aid_encrypt", a.b(str, "adprof_private_a"));
        } catch (Exception unused) {
        }
    }

    @Override // com.adprof.sdk.eb
    public void a(Exception exc) {
        a8.f13a = a8.a();
        if (a8.f13a == null) {
            a8.f13a = "";
        }
    }
}
