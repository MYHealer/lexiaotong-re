package com.huawei.openalliance.ad.constant;

import com.huawei.hms.ads.fh;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class bu {
    private static final String Code = "PlacementPlayState";
    private final byte[] I;
    private a V;

    public enum a {
        SINGLE_INST,
        MAIN_VIEW,
        BACKUP_VIEW
    }

    public bu() {
        this.V = a.SINGLE_INST;
        this.I = new byte[0];
    }

    public bu(a aVar) {
        a aVar2 = a.SINGLE_INST;
        this.I = new byte[0];
        this.V = aVar;
    }

    public a Code() {
        a aVar;
        synchronized (this.I) {
            aVar = this.V;
        }
        return aVar;
    }

    public void Code(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.I) {
            fh.V(Code, "switch to state: %s", aVar);
            this.V = aVar;
        }
    }

    public boolean I(a aVar) {
        boolean z;
        synchronized (this.I) {
            z = !V(aVar);
        }
        return z;
    }

    public boolean V(a aVar) {
        boolean z;
        synchronized (this.I) {
            z = aVar == this.V;
        }
        return z;
    }
}
