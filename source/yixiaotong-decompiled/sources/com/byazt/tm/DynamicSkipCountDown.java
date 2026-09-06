package com.byazt.tm;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.aq.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 2089})
public class DynamicSkipCountDown extends DynamicButton implements com.byazt.kn.ve {
    public DynamicSkipCountDown(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.byazt.tm.DynamicButton, com.byazt.tm.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.z).getText())) {
            setMeasuredDimension(0, this.x);
        }
    }

    @Override // com.byazt.tm.DynamicBaseWidget
    public void n() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.sp, this.x);
        layoutParams.leftMargin = this.i;
        layoutParams.gravity = 16;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.byazt.kn.ve
    public void c(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (i == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else {
            ((TextView) this.z).setText(" | " + String.format("%1$ss后可跳过", Integer.valueOf(i)));
        }
        requestLayout();
    }
}
