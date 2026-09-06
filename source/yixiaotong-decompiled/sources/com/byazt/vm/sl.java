package com.byazt.vm;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 158})
public class sl extends com.byazt.kbg.c.AbstractBinderC0194c {
    public volatile boolean c = false;

    @Override // com.byazt.kbg.c
    public void c(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
    }

    public boolean c() {
        return this.c;
    }

    @Override // com.byazt.kbg.c
    public void c(int i, Bundle bundle) throws RemoteException {
        if (i != 0 || bundle == null) {
            return;
        }
        this.c = bundle.getBoolean("oa_id_limit_state");
    }
}
