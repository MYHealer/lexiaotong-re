package com.meishu.sdk.core.bquery;

import java.io.File;

/* JADX INFO: compiled from: AbstractBQuery.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d implements h<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f4770a;

    public d(e eVar, j jVar) {
        this.f4770a = jVar;
    }

    @Override // com.meishu.sdk.core.bquery.h
    public void a(String str, File file, boolean z) {
        File file2 = file;
        j jVar = this.f4770a;
        if (jVar != null) {
            jVar.onSuccess(str, file2);
        }
    }

    @Override // com.meishu.sdk.core.bquery.h
    public void onFail(int i, String str) {
        j jVar = this.f4770a;
        if (jVar != null) {
            jVar.onFail(i, str);
        }
    }
}
