package com.opos.mobad.b.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public enum af implements com.heytap.nearx.a.a.i {
    MODE_ONE(1),
    MODE_TWO(2);

    public static final com.heytap.nearx.a.a.e<af> c = com.heytap.nearx.a.a.e.a(af.class);
    private final int d;

    af(int i) {
        this.d = i;
    }

    public static af fromValue(int i) {
        if (i == 1) {
            return MODE_ONE;
        }
        if (i != 2) {
            return null;
        }
        return MODE_TWO;
    }

    @Override // com.heytap.nearx.a.a.i
    public int getValue() {
        return this.d;
    }
}
