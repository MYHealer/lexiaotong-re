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
public class BDMarketingLabel extends LinearLayout {
    private View mAdView;
    private Context mContext;
    private ClassLoader mLoader;

    public BDMarketingLabel(Context context) {
        super(context);
        this.mContext = context;
        initView(context);
    }

    public BDMarketingLabel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDMarketingLabel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    public void setAdData(NativeResponse nativeResponse) {
        if (this.mAdView != null) {
            av.a(z.h, this.mAdView, this.mLoader, "setAdData", new Class[]{Object.class}, nativeResponse);
        }
    }

    private void initView(Context context) {
        this.mContext = context;
        this.mLoader = bu.a(context);
        View view = (View) av.a(z.h, this.mLoader, (Class<?>[]) new Class[]{Context.class}, context);
        this.mAdView = view;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void setLabelFontSizeSp(int i) {
        if (this.mAdView != null) {
            av.a(z.h, this.mAdView, this.mLoader, "setLabelFontSizeSp", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setLabelFontTypeFace(Typeface typeface) {
        if (this.mAdView != null) {
            av.a(z.h, this.mAdView, this.mLoader, "setLabelFontTypeFace", new Class[]{Typeface.class}, typeface);
        }
    }
}
