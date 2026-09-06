package com.yfanads.android.custom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.yfanads.ads.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdSplashViewContainer extends RelativeLayout {
    public AdSplashViewContainer(Context context) {
        super(context);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.yf_splash_container, (ViewGroup) this, false);
    }

    public AdSplashViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AdSplashViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
