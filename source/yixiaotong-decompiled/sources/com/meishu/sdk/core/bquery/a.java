package com.meishu.sdk.core.bquery;

import com.meishu.sdk.core.safe.l;
import java.io.File;

/* JADX INFO: compiled from: AbstractBQuery.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f4767a;
    public final /* synthetic */ String b;
    public final /* synthetic */ File c;

    public a(e eVar, h hVar, String str, File file) {
        this.f4767a = hVar;
        this.b = str;
        this.c = file;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        h hVar = this.f4767a;
        if (hVar != null) {
            hVar.a(this.b, this.c, true);
        }
    }
}
