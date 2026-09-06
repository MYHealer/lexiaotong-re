package com.byazt.vz;

import android.view.View;
import com.byazt.nr.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1339, 20})
public abstract class c extends com.byazt.ylx.c {
    public abstract View tt();

    public final View c() {
        try {
            return tt();
        } catch (Exception e) {
            m.c(e);
            return null;
        }
    }
}
