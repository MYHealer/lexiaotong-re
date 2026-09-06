package com.opos.mobad.b.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public enum u implements com.heytap.nearx.a.a.i {
    TYPE_16_8(1),
    TYPE_16_9(2);

    public static final com.heytap.nearx.a.a.e<u> c = com.heytap.nearx.a.a.e.a(u.class);
    private final int d;

    u(int i) {
        this.d = i;
    }

    public static u fromValue(int i) {
        if (i == 1) {
            return TYPE_16_8;
        }
        if (i != 2) {
            return null;
        }
        return TYPE_16_9;
    }

    @Override // com.heytap.nearx.a.a.i
    public int getValue() {
        return this.d;
    }
}
