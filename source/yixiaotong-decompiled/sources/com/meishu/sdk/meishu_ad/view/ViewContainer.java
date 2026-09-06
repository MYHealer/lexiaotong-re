package com.meishu.sdk.meishu_ad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.meishu.sdk.meishu_ad.splash.k;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ViewContainer extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f5124a;
    public Boolean b;

    public interface a {
    }

    public ViewContainer(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = Boolean.TRUE;
        a aVar = this.f5124a;
        if (aVar != null) {
            aVar.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = Boolean.FALSE;
        a aVar = this.f5124a;
        if (aVar != null) {
            ((k) aVar).f5091a.a();
        }
    }

    public void setWindowEventListener(a aVar) {
        this.f5124a = aVar;
    }

    public ViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
