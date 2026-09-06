package com.miui.zeus.mimo.sdk;

import android.content.Intent;
import android.os.IInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c9 extends g9 {
    public final /* synthetic */ Intent c;
    public final /* synthetic */ a9 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c9(a9 a9Var, String str, String str2, Intent intent) {
        super(str, str2);
        this.d = a9Var;
        this.c = intent;
    }

    @Override // com.miui.zeus.mimo.sdk.g9
    public void a() {
        a9 a9Var = this.d;
        a9Var.getClass();
        a9Var.c = null;
        a9 a9Var2 = this.d;
        S s = a9Var2.c;
        if (s != 0) {
            a9.a(a9Var2, (IInterface) s);
        } else {
            if (a9Var2.f5284a.bindService(this.c, a9Var2, 1)) {
                return;
            }
            this.d.getClass();
        }
    }
}
