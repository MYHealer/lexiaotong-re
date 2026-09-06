package com.huawei.hms.scankit;

import com.huawei.hms.scankit.p.g0;
import com.huawei.hms.scankit.p.x3;

/* JADX INFO: compiled from: PreviewCallback.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class j implements g0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f4208a;

    public j(d dVar) {
        this.f4208a = dVar;
    }

    @Override // com.huawei.hms.scankit.p.g0.e
    public void a(byte[] bArr) {
        x3.a("scan-time", "request frame time:" + System.currentTimeMillis());
        this.f4208a.a().obtainMessage(R.id.scankit_decode, bArr).sendToTarget();
    }
}
