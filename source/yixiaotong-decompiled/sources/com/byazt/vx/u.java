package com.byazt.vx;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 67})
public class u {
    public static boolean c = true;

    public static byte[] c(byte[] bArr, int i) {
        com.byazt.dna.ve veVar = (com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog");
        return veVar != null ? veVar.encrypt(bArr, i) : new byte[0];
    }

    public static boolean c() {
        com.byazt.eu.tt.tt("TMe", "applogSOLoadSuccess = " + c);
        return c;
    }

    static {
        try {
            com.byazt.bzd.sp.c("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError unused) {
            c = false;
        }
    }
}
