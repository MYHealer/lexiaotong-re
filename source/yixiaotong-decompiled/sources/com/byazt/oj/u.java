package com.byazt.oj;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.byazt.tm.DynamicImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 787, 67})
public class u extends uj {
    public u(View view, com.byazt.aq.c cVar) {
        super(view, cVar);
    }

    @Override // com.byazt.oj.uj
    public List<ObjectAnimator> c() {
        if ((this.ve instanceof ImageView) && (this.ve.getParent() instanceof DynamicImageView)) {
            this.ve = (View) this.ve.getParent();
            ((ViewGroup) this.ve).setClipChildren(true);
            ((ViewGroup) this.ve.getParent()).setClipChildren(true);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ve, "stretchValue", 0.0f, 1.0f).setDuration((int) (this.tt.da() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        return arrayList;
    }
}
