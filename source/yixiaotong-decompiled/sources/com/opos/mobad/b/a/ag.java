package com.opos.mobad.b.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public enum ag implements com.heytap.nearx.a.a.i {
    UNKNOWN(0),
    SPLASH(1),
    HOT_SPLASH(2);

    public static final com.heytap.nearx.a.a.e<ag> d = com.heytap.nearx.a.a.e.a(ag.class);
    private final int e;

    ag(int i) {
        this.e = i;
    }

    public static ag fromValue(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return SPLASH;
        }
        if (i != 2) {
            return null;
        }
        return HOT_SPLASH;
    }

    @Override // com.heytap.nearx.a.a.i
    public int getValue() {
        return this.e;
    }
}
