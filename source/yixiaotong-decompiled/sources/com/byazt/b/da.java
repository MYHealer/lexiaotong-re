package com.byazt.b;

import com.byazt.zz.my;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 223, 72})
public class da implements my {
    @Override // com.byazt.zz.my
    public long c(int i, int i2) {
        if (i == 1) {
            return C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
        }
        if (i == 2) {
            return C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
        }
        if (i == 3) {
            return 30000L;
        }
        return i > 3 ? 300000L : 0L;
    }
}
