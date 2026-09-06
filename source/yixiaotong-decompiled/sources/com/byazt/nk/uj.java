package com.byazt.nk;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.oq.ClickSlideUpView;
import com.byazt.tm.DynamicBaseWidget;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 234, 15})
public class uj extends nu<ClickSlideUpView> {
    @Override // com.byazt.nk.nu
    public void uj() {
    }

    public uj(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar) {
        super(context, dynamicBaseWidget, spVar);
        c(spVar);
    }

    private void c(com.byazt.aq.sp spVar) {
        this.c = new ClickSlideUpView(this.tt);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.byazt.or.x.c(this.tt, spVar.lr());
        this.c.setLayoutParams(layoutParams);
        this.c.setSlideText(this.uj.lt());
        if (this.c instanceof ClickSlideUpView) {
            ((ClickSlideUpView) this.c).setButtonText(this.uj.da());
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
