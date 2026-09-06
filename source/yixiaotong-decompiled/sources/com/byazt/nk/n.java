package com.byazt.nk;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.oq.ClickSlideUpView;
import com.byazt.oq.ClickSlideUpView2;
import com.byazt.tm.DynamicBaseWidget;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 234, 46})
public class n extends nu<ClickSlideUpView> {
    @Override // com.byazt.nk.nu
    public void uj() {
    }

    public n(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar) {
        super(context, dynamicBaseWidget, spVar);
        c(spVar);
    }

    private void c(com.byazt.aq.sp spVar) {
        this.c = new ClickSlideUpView2(this.tt);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.c.setLayoutParams(layoutParams);
        if (this.c instanceof ClickSlideUpView2) {
            ((ClickSlideUpView2) this.c).setButtonText(this.uj.lt());
        }
    }

    @Override // com.byazt.nk.nu, com.byazt.nk.sp
    public void c() {
        this.c.c();
    }

    @Override // com.byazt.nk.nu, com.byazt.nk.sp
    public void tt() {
        this.c.tt();
    }
}
