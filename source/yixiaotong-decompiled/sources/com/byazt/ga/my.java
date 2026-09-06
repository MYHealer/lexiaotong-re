package com.byazt.ga;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public enum my {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    /* JADX INFO: renamed from: com.byazt.ga.my$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 256, 235})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[my.values().length];
            c = iArr;
            try {
                iArr[my.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[my.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[my.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean c(int i, boolean z, int i2) {
        int i3 = AnonymousClass1.c[ordinal()];
        if (i3 == 1) {
            return false;
        }
        if (i3 != 2) {
            return (z && i < 28) || i2 > 4 || i <= 25;
        }
        return true;
    }
}
