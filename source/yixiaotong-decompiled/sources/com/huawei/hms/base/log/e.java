package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: LogCatNode.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f3946a;

    @Override // com.huawei.hms.base.log.b
    public void a(b bVar) {
        this.f3946a = bVar;
    }

    @Override // com.huawei.hms.base.log.b
    public void a(Context context, String str) {
        b bVar = this.f3946a;
        if (bVar != null) {
            bVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.b
    public void a(String str, int i, String str2, String str3) {
        Log.println(i, "HMSSDK_" + str2, str3);
        b bVar = this.f3946a;
        if (bVar != null) {
            bVar.a(str, i, str2, str3);
        }
    }
}
