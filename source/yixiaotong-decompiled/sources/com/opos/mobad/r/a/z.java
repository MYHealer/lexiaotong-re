package com.opos.mobad.r.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public enum z implements com.heytap.nearx.a.a.i {
    UNKNOWN_STATUS(0),
    VIP(1),
    NORMAL(2);

    public static final com.heytap.nearx.a.a.e<z> d = com.heytap.nearx.a.a.e.a(z.class);
    private final int e;

    z(int i) {
        this.e = i;
    }

    public static z fromValue(int i) {
        if (i == 0) {
            return UNKNOWN_STATUS;
        }
        if (i == 1) {
            return VIP;
        }
        if (i != 2) {
            return null;
        }
        return NORMAL;
    }

    @Override // com.heytap.nearx.a.a.i
    public int getValue() {
        return this.e;
    }
}
