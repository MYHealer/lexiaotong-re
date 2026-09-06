package com.kwad.sdk.lib.ad.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CustomScrollingViewBehavior extends KSAppBarLayout.d {
    public CustomScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSAppBarLayout.d, com.kwad.sdk.lib.ad.desigin.KSHeaderScrollingViewBehavior
    public int getScrollRange(View view) {
        if (view instanceof KSAppBarLayout) {
            Object behavior = ((KSCoordinatorLayout.LayoutParams) view.getLayoutParams()).getBehavior();
            if (behavior instanceof CustomAppBarCustomAttrListener) {
                return ((KSAppBarLayout) view).getTotalScrollRange() - ((CustomAppBarCustomAttrListener) behavior).getExtraFixedSize();
            }
            return ((KSAppBarLayout) view).getTotalScrollRange();
        }
        return super.getScrollRange(view);
    }
}
