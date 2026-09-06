package com.meishu.sdk.core.bquery;

import java.io.File;

/* JADX INFO: compiled from: AbstractBQuery.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c implements h<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f4769a;

    public c(e eVar, h hVar) {
        this.f4769a = hVar;
    }

    @Override // com.meishu.sdk.core.bquery.h
    public void a(String str, File file, boolean z) {
        File file2 = file;
        h hVar = this.f4769a;
        if (hVar != null) {
            hVar.a(str, file2, z);
        }
    }

    @Override // com.meishu.sdk.core.bquery.h
    public void onFail(int i, String str) {
        h hVar = this.f4769a;
        if (hVar != null) {
            hVar.onFail(i, str);
        }
    }
}
