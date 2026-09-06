package com.adprof.sdk;

import android.os.IBinder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class hb implements ib {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f1209a;

    public hb(IBinder iBinder) {
        this.f1209a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f1209a;
    }
}
