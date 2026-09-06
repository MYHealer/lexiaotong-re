package com.miui.zeus.mimo.sdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.zeus.mimo.sdk.a0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DeepLinkTipsView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f5662a;
    public TextView b;

    public DeepLinkTipsView(Context context) {
        super(context);
    }

    public DeepLinkTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DeepLinkTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f5662a = (TextView) findViewById(a0.k5);
        this.b = (TextView) findViewById(a0.L4);
    }

    public void setClickCancelBtn(View.OnClickListener onClickListener) {
        this.f5662a.setOnClickListener(onClickListener);
    }

    public void setClickOkBtn(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }
}
