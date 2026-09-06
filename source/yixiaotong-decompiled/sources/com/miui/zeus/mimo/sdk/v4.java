package com.miui.zeus.mimo.sdk;

import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class v4 implements g5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MimoAdInfo f5643a;
    public final /* synthetic */ y4.b b;
    public final /* synthetic */ e5 c;
    public final /* synthetic */ List d;
    public final /* synthetic */ y4 e;

    public v4(y4 y4Var, MimoAdInfo mimoAdInfo, y4.b bVar, e5 e5Var, List list) {
        this.e = y4Var;
        this.f5643a = mimoAdInfo;
        this.b = bVar;
        this.c = e5Var;
        this.d = list;
    }

    @Override // com.miui.zeus.mimo.sdk.g5.b
    public void a(String str) {
        y4.b bVar;
        y4.a(this.e, this);
        if (this.e.c || !this.f5643a.B.equals(str) || (bVar = this.b) == null) {
            return;
        }
        ((q3) bVar).a(this.f5643a, new a7(MimoAdError.ERROR_3000));
    }

    @Override // com.miui.zeus.mimo.sdk.g5.b
    public void b(String str) {
        y4.a(this.e, this);
        if (this.e.c || !this.f5643a.B.equals(str)) {
            return;
        }
        y4.b bVar = this.b;
        if (bVar != null) {
            ((q3) bVar).f5570a.a();
        }
        this.c.getClass();
        this.e.a(this.d, this.f5643a.F0, this.c, (g5.b) null);
    }
}
