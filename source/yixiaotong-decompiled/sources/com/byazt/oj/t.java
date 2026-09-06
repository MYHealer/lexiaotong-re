package com.byazt.oj;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 787, 66})
public class t extends uj {
    public t(View view, com.byazt.aq.c cVar) {
        super(view, cVar);
    }

    @Override // com.byazt.oj.uj
    public List<ObjectAnimator> c() {
        int i;
        int i2;
        this.ve.setTag(2097610711, Integer.valueOf(this.tt.uj()));
        if (this.ve == null || !com.byazt.or.ve.c(this.ve.getContext())) {
            i = 0;
            i2 = 1;
        } else {
            i2 = 0;
            i = 1;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ve, "shineValue", i, i2).setDuration((int) (this.tt.da() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        return arrayList;
    }
}
