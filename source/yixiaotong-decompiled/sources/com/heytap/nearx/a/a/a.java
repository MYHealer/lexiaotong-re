package com.heytap.nearx.a.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public enum a {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);

    final int e;

    /* JADX INFO: renamed from: com.heytap.nearx.a.a.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3481a;

        static {
            int[] iArr = new int[a.values().length];
            f3481a = iArr;
            try {
                iArr[a.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3481a[a.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3481a[a.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3481a[a.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    a(int i) {
        this.e = i;
    }

    public e<?> a() {
        int i = AnonymousClass1.f3481a[ordinal()];
        if (i == 1) {
            return e.j;
        }
        if (i == 2) {
            return e.g;
        }
        if (i == 3) {
            return e.l;
        }
        if (i == 4) {
            return e.q;
        }
        throw new AssertionError();
    }
}
