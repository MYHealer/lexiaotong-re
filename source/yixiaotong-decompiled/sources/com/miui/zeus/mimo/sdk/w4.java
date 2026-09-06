package com.miui.zeus.mimo.sdk;

import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class w4 implements g5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MimoAdInfo f5723a;
    public final /* synthetic */ y4.b b;
    public final /* synthetic */ y4 c;

    public w4(y4 y4Var, MimoAdInfo mimoAdInfo, y4.b bVar) {
        this.c = y4Var;
        this.f5723a = mimoAdInfo;
        this.b = bVar;
    }

    @Override // com.miui.zeus.mimo.sdk.g5.b
    public void a(String str) {
        y4.b bVar;
        y4.a(this.c, this);
        if (this.c.c || !this.f5723a.A.equals(str) || (bVar = this.b) == null) {
            return;
        }
        ((q3) bVar).a(this.f5723a, new a7(MimoAdError.ERROR_3000));
    }

    @Override // com.miui.zeus.mimo.sdk.g5.b
    public void b(String str) {
        y4.b bVar;
        y4.a(this.c, this);
        if (this.c.c || !this.f5723a.A.equals(str) || (bVar = this.b) == null) {
            return;
        }
        ((q3) bVar).f5570a.a();
    }
}
