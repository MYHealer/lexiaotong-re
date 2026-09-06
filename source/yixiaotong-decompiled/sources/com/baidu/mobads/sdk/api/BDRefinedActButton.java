package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.bu;
import com.baidu.mobads.sdk.internal.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BDRefinedActButton extends LinearLayout {
    private View mAdView;
    private Context mContext;
    private ClassLoader mLoader;

    public BDRefinedActButton(Context context) {
        this(context, null, 0);
    }

    public BDRefinedActButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDRefinedActButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    public void setAdData(NativeResponse nativeResponse) {
        if (this.mAdView != null) {
            av.a(z.i, this.mAdView, this.mLoader, "setAdData", new Class[]{Object.class}, nativeResponse);
        }
    }

    private void initView(Context context) {
        try {
            this.mContext = context;
            this.mLoader = bu.a(context);
            View view = (View) av.a(z.i, this.mLoader, (Class<?>[]) new Class[]{Context.class}, context);
            this.mAdView = view;
            if (view != null) {
                addView(view, new RelativeLayout.LayoutParams(-2, -2));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setButtonFontTypeFace(Typeface typeface) {
        if (this.mAdView != null) {
            av.a(z.i, this.mAdView, this.mLoader, "setButtonFontTypeFace", new Class[]{Typeface.class}, typeface);
        }
    }

    public void setButtonFontSizeSp(int i) {
        if (this.mAdView != null) {
            av.a(z.i, this.mAdView, this.mLoader, "setButtonFontSizeSp", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setButtonTextColor(int i) {
        if (this.mAdView != null) {
            av.a(z.i, this.mAdView, this.mLoader, "setButtonTextColor", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setButtonBackgroundColor(int i) {
        if (this.mAdView != null) {
            av.a(z.i, this.mAdView, this.mLoader, "setButtonBackgroundColor", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setIsShowDialog(boolean z) {
        if (this.mAdView != null) {
            av.a(z.i, this.mAdView, this.mLoader, "setIsShowDialog", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }
}
