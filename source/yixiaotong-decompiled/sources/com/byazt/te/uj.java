package com.byazt.te;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 14, 15})
public class uj extends c {
    public String kz;
    public int mq;
    public String vi;

    public uj(Context context) {
        super(context);
    }

    @Override // com.byazt.te.c
    public void c(int i, int i2, int i3) {
        if (i3 <= 0 && !TextUtils.isEmpty(this.vp)) {
            this.c = this.vp;
            sl(this.c);
            return;
        }
        int i4 = this.mq;
        int i5 = i4 - i2;
        if (i4 > 0 && i5 > 0) {
            this.c = this.kz;
        } else {
            this.c = this.vi;
        }
        this.c = this.c.replace("${_countdownTime_}", String.valueOf(i5)).replace("${_remainTime_}", String.valueOf(i3));
        sl(this.c);
    }

    @Override // com.byazt.te.c, com.byazt.sm.tt, com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "text1":
                this.kz = str2;
                break;
            case "text2":
                this.vi = str2;
                break;
            case "startCountDown":
                this.mq = com.byazt.cd.ve.c(str2, -1);
                break;
        }
    }
}
