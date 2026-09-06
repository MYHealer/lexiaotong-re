package com.byazt.bj;

import com.byakv.q.YogaNative;
import com.byakv.q.YogaNodeJNIBase;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 224, 66})
public class t extends YogaNodeJNIBase {
    public void finalize() throws Throwable {
        try {
            u();
        } finally {
            super.finalize();
        }
    }

    public void u() {
        if (this.c != 0) {
            long j = this.c;
            this.c = 0L;
            YogaNative.jni_YGNodeFinalizeJNI(j);
        }
    }
}
