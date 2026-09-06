package com.miui.zeus.mimo.sdk;

import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.BrandICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class u6 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f5634a;
    public final /* synthetic */ AdMarkICP b;
    public final /* synthetic */ BrandICP c;

    public u6(LinearLayout linearLayout, AdMarkICP adMarkICP, BrandICP brandICP) {
        this.f5634a = linearLayout;
        this.b = adMarkICP;
        this.c = brandICP;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f5634a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.c.setMaxWidth((this.f5634a.getWidth() - this.b.a((String) null)) - ((LinearLayout.LayoutParams) this.b.getLayoutParams()).getMarginStart());
        this.f5634a.requestLayout();
    }
}
