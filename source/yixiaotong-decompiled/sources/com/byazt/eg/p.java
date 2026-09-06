package com.byazt.eg;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 350})
public abstract class p {
    public abstract rl c();

    public abstract void c(com.byazt.mk.uj ujVar) throws IOException;

    public long tt() throws IOException {
        return -1L;
    }

    public static p c(rl rlVar, String str) {
        Charset charsetVe = com.byazt.kh.ve.n;
        if (rlVar != null && (charsetVe = rlVar.ve()) == null) {
            charsetVe = com.byazt.kh.ve.n;
            rlVar = rl.c(rlVar + "; charset=utf-8");
        }
        return c(rlVar, str.getBytes(charsetVe));
    }

    public static p c(rl rlVar, byte[] bArr) {
        return c(rlVar, bArr, 0, bArr.length);
    }

    public static p c(final rl rlVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        com.byazt.kh.ve.c(bArr.length, i, i2);
        return new p() { // from class: com.byazt.eg.p.1
            @Override // com.byazt.eg.p
            public rl c() {
                return rlVar;
            }

            @Override // com.byazt.eg.p
            public long tt() {
                return i2;
            }

            @Override // com.byazt.eg.p
            public void c(com.byazt.mk.uj ujVar) throws IOException {
                ujVar.ve(bArr, i, i2);
            }
        };
    }
}
