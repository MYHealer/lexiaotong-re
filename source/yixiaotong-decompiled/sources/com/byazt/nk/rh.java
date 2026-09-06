package com.byazt.nk;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.oq.DynamicUnlockView;
import com.byazt.tm.DynamicBaseWidget;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 234, 115})
public class rh implements sp<DynamicUnlockView> {
    public final DynamicUnlockView c;

    @Override // com.byazt.nk.sp
    /* JADX INFO: renamed from: uj, reason: merged with bridge method [inline-methods] */
    public DynamicUnlockView ve() {
        return this.c;
    }

    public rh(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar) {
        int iLr;
        DynamicUnlockView dynamicUnlockView = new DynamicUnlockView(context);
        this.c = dynamicUnlockView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        if (spVar.lr() > 0) {
            iLr = spVar.lr();
        } else {
            iLr = com.byazt.sr.uj.c() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.byazt.or.x.c(context, iLr);
        dynamicUnlockView.setLayoutParams(layoutParams);
        dynamicUnlockView.setClipChildren(false);
        dynamicUnlockView.setText(spVar.lt());
    }

    @Override // com.byazt.nk.sp
    public void c() {
        DynamicUnlockView dynamicUnlockView = this.c;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.c();
        }
    }

    @Override // com.byazt.nk.sp
    public void tt() {
        DynamicUnlockView dynamicUnlockView = this.c;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.tt();
        }
    }
}
