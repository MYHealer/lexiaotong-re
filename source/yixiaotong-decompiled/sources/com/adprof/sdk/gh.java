package com.adprof.sdk;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class gh extends jh {
    @Override // com.adprof.sdk.mh
    public u7 a() {
        return v7.a().m721a();
    }

    @Override // com.adprof.sdk.mh
    /* JADX INFO: renamed from: a */
    public boolean mo622a() {
        z1.a().getClass();
        Iterator it = new ArrayList().iterator();
        while (it.hasNext()) {
            if (((mh) this).f468b.equals(String.valueOf((Integer) it.next()))) {
                return true;
            }
        }
        return false;
    }
}
