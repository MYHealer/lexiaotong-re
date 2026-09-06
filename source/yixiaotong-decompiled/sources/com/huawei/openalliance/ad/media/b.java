package com.huawei.openalliance.ad.media;

import com.huawei.hms.ads.fh;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b {
    private static final String Code = "MediaState";
    private d V = d.IDLE;
    private final byte[] I = new byte[0];

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.media.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[d.values().length];
            Code = iArr;
            try {
                iArr[d.PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[d.PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[d.PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[d.PLAYBACK_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public boolean Code() {
        boolean z;
        synchronized (this.I) {
            int i = AnonymousClass1.Code[this.V.ordinal()];
            z = true;
            if (i != 1 && i != 2 && i != 3 && i != 4) {
                z = false;
            }
        }
        return z;
    }

    public boolean Code(d dVar) {
        boolean z;
        synchronized (this.I) {
            z = this.V == dVar;
        }
        return z;
    }

    void I(d dVar) {
        if (dVar == null) {
            return;
        }
        synchronized (this.I) {
            if (this.V != d.END) {
                fh.V(Code, "switchToState: %s", dVar);
                this.V = dVar;
            }
        }
    }

    public int V() {
        int iCode;
        synchronized (this.I) {
            iCode = this.V.Code();
        }
        return iCode;
    }

    public boolean V(d dVar) {
        return !Code(dVar);
    }

    public String toString() {
        String string;
        synchronized (this.I) {
            string = this.V.toString();
        }
        return string;
    }
}
