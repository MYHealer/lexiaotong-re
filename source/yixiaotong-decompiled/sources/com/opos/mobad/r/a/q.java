package com.opos.mobad.r.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public enum q implements com.heytap.nearx.a.a.i {
    HORIZONTAL(0),
    VERTICAL(1);

    public static final com.heytap.nearx.a.a.e<q> c = com.heytap.nearx.a.a.e.a(q.class);
    private final int d;

    q(int i) {
        this.d = i;
    }

    public static q fromValue(int i) {
        if (i == 0) {
            return HORIZONTAL;
        }
        if (i != 1) {
            return null;
        }
        return VERTICAL;
    }

    @Override // com.heytap.nearx.a.a.i
    public int getValue() {
        return this.d;
    }
}
