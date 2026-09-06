package com.byazt.nk;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.oq.PressButtonInteractView;
import com.byazt.tm.DynamicBaseWidget;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 234, 66})
public class t implements sp {
    public PressButtonInteractView c;

    @Override // com.byazt.nk.sp
    /* JADX INFO: renamed from: uj, reason: merged with bridge method [inline-methods] */
    public PressButtonInteractView ve() {
        return this.c;
    }

    public t(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar) {
        this.c = new PressButtonInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicBaseWidget.getDynamicHeight(), dynamicBaseWidget.getDynamicHeight());
        layoutParams.gravity = 8388629;
        this.c.setLayoutParams(layoutParams);
    }

    @Override // com.byazt.nk.sp
    public void c() {
        this.c.c();
    }

    @Override // com.byazt.nk.sp
    public void tt() {
        this.c.tt();
    }
}
