package com.adprof.sdk;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class k2 implements rk {
    @Override // com.adprof.sdk.rk
    public void a(Error error) {
        pk.b("db del failed: " + error.getMessage());
    }

    @Override // com.adprof.sdk.rk
    public void a(List list) {
        pk.d("cleanLimitAdTracker db delete success ");
    }
}
