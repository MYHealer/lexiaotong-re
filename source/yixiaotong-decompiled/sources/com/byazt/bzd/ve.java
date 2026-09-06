package com.byazt.bzd;

import com.byakv.z.TTEncryptUtils;
import com.byazt.nr.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 724, 54})
public class ve {
    public static byte[] c(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return TTEncryptUtils.c(bArr, i);
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return null;
    }
}
