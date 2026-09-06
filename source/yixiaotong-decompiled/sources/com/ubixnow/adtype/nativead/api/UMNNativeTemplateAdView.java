package com.ubixnow.adtype.nativead.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.oO0O0OoO;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNNativeTemplateAdView extends FrameLayout {
    public String TAG;

    public UMNNativeTemplateAdView(Context context) {
        this(context, null, 0);
    }

    public UMNNativeTemplateAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UMNNativeTemplateAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean isCanAddShakeView(o00O000 o00o000, View view) {
        oO0O0OoO.OooO00o oooO00o;
        ooooO000.OooO0O0(this.TAG, "shakeView is null? " + (view == null));
        oO0O0OoO oo0o0ooo = o00o000.OooO00o;
        if (oo0o0ooo.OooO0OO == 2) {
            return false;
        }
        return (view == null || (oooO00o = oo0o0ooo.OooOOoo) == null || !oooO00o.OooO0OO) ? false : true;
    }

    public void renderTemplateView(View view) {
        renderTemplateView(view, null);
    }

    public void renderTemplateView(View view, FrameLayout.LayoutParams layoutParams) {
        if (layoutParams == null) {
            try {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
            } catch (Exception e) {
                ooooO000.OooO00o(e);
                return;
            }
        }
        this.TAG = getClass().getSimpleName();
        addView(view, layoutParams);
    }

    public void showShakeView(ViewGroup viewGroup, o00O000 o00o000, View view, ViewGroup.LayoutParams layoutParams, int i) {
        if (isCanAddShakeView(o00o000, view)) {
            viewGroup.addView(view, layoutParams);
            if (view instanceof UMNNativeShakeView) {
                ((UMNNativeShakeView) view).changeOnlyImageSize(i);
            }
        }
    }
}
