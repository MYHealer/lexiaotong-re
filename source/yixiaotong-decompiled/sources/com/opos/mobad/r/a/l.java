package com.opos.mobad.r.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public enum l implements com.heytap.nearx.a.a.i {
    UNKNOWN_MODE(0),
    PERCENTAGE_MODE(1),
    RANKER_MODE(2),
    BIDDING_MODE(3);

    public static final com.heytap.nearx.a.a.e<l> e = com.heytap.nearx.a.a.e.a(l.class);
    private final int f;

    l(int i) {
        this.f = i;
    }

    public static l fromValue(int i) {
        if (i == 0) {
            return UNKNOWN_MODE;
        }
        if (i == 1) {
            return PERCENTAGE_MODE;
        }
        if (i == 2) {
            return RANKER_MODE;
        }
        if (i != 3) {
            return null;
        }
        return BIDDING_MODE;
    }

    @Override // com.heytap.nearx.a.a.i
    public int getValue() {
        return this.f;
    }
}
