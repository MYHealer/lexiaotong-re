package com.byazt.nk;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.oq.BluePressInteractView;
import com.byazt.tm.DynamicBaseWidget;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 234, 20})
public class c implements sp {
    public BluePressInteractView c;

    @Override // com.byazt.nk.sp
    public ViewGroup ve() {
        return this.c;
    }

    public c(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar) {
        double dV = spVar.v();
        dV = dV == 0.0d ? 1.0d : dV;
        double dOs = spVar.os();
        double d = dOs != 0.0d ? dOs : 1.0d;
        int dynamicWidth = (int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * dV);
        int dynamicWidth2 = (int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * d);
        this.c = new BluePressInteractView(context, dynamicWidth, dynamicWidth2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicWidth, dynamicWidth2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) com.byazt.or.x.c(context, spVar.kk() - 7);
        layoutParams.leftMargin = (int) com.byazt.or.x.c(context, spVar.tx() - 3);
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
