package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e {
    int bkA;
    int bkB;
    int bkC;
    final k bkt;
    private int bkv;
    private int bkw;
    int bkx;
    int bky;
    int bkz;
    private int bku = 0;
    private int bkD = -1;
    private int bkE = -1;
    private int bkF = 0;
    private boolean bkH = false;
    int bkG = 0;

    final int SV() {
        return this.bkD;
    }

    final int SW() {
        return this.bkE;
    }

    final int SX() {
        return this.bku;
    }

    final int SY() {
        return this.bkv;
    }

    final int SZ() {
        return this.bkw;
    }

    public e(k kVar) {
        this.bkt = kVar;
        fm(1);
        fl(0);
    }

    private void fl(int i) {
        this.bkD = i;
        int i2 = (i * this.bkx) + this.bkz;
        this.bkE = i2;
        if (i2 < 0 || i2 >= this.bkt.bkv) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    final boolean SU() {
        int i;
        while (true) {
            this.bkF++;
            int i2 = this.bkv;
            if (i2 != 0 && (i = this.bkD) < i2 - 1) {
                fl(i + 1);
                break;
            }
            int i3 = this.bku;
            if (i3 != 7) {
                fm(i3 + 1);
                if (this.bkv != 0) {
                    fl(0);
                    break;
                }
                this.bkF--;
            } else {
                this.bkH = true;
                return false;
            }
        }
        return true;
    }

    private void fm(int i) {
        int i2;
        int i3;
        if (this.bku == i) {
            return;
        }
        this.bku = i;
        byte[] bArrFn = fn(i);
        this.bky = bArrFn[0];
        this.bkx = bArrFn[1];
        this.bkA = bArrFn[2];
        this.bkz = bArrFn[3];
        if (this.bkt.bkv > this.bkz) {
            int i4 = this.bkt.bkv;
            int i5 = this.bkx;
            i2 = (((i4 + i5) - 1) - this.bkz) / i5;
        } else {
            i2 = 0;
        }
        this.bkv = i2;
        if (this.bkt.bkw > this.bkA) {
            int i6 = this.bkt.bkw;
            int i7 = this.bky;
            i3 = (((i6 + i7) - 1) - this.bkA) / i7;
        } else {
            i3 = 0;
        }
        this.bkw = i3;
        if (i3 == 0) {
            this.bkv = 0;
        }
        this.bkC = this.bky * this.bkt.bkP;
        this.bkB = this.bkA * this.bkt.bkP;
    }

    private static byte[] fn(int i) {
        switch (i) {
            case 1:
                return new byte[]{8, 8, 0, 0};
            case 2:
                return new byte[]{8, 8, 4, 0};
            case 3:
                return new byte[]{4, 8, 0, 4};
            case 4:
                return new byte[]{4, 4, 2, 0};
            case 5:
                return new byte[]{2, 4, 0, 2};
            case 6:
                return new byte[]{2, 2, 1, 0};
            case 7:
                return new byte[]{1, 2, 0, 1};
            default:
                throw new PngjException("bad interlace pass" + i);
        }
    }

    private int Ta() {
        return SZ();
    }

    public final int Tb() {
        return ((this.bkt.bkU * Ta()) + 7) / 8;
    }
}
