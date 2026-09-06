package com.meishu.sdk.meishu_ad.draw;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.platform.ms.draw.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MeishuDrawRootView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.meishu.sdk.core.ad.draw.a f5009a;
    public a b;

    public interface a {
    }

    public MeishuDrawRootView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        com.meishu.sdk.core.ad.draw.a aVar;
        super.onVisibilityChanged(view, i);
        a aVar2 = this.b;
        if (aVar2 != null) {
            View view2 = ((b) aVar2).f5164a;
            if (view2 instanceof NormalMediaView) {
                if (i == 0) {
                    ((NormalMediaView) view2).resume();
                } else {
                    ((NormalMediaView) view2).pause();
                }
            }
        }
        if (i == 0 && isShown() && (aVar = this.f5009a) != null) {
            aVar.onAdExposure();
        }
    }

    public void setAdListener(com.meishu.sdk.core.ad.draw.a aVar) {
        this.f5009a = aVar;
    }

    public void setOnVisibilityChangeListener(a aVar) {
        this.b = aVar;
    }

    public MeishuDrawRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MeishuDrawRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
