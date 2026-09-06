package com.icbc.paysdk.view;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.icbc.paysdk.webview.CustomWebView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class WebViewLayout {
    Context context;

    public WebViewLayout(Context context) {
        this.context = context;
    }

    public LinearLayout getWebViewLayout() {
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(this.context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 112;
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setBackgroundColor(Color.parseColor("#00000000"));
        CustomWebView customWebView = new CustomWebView(this.context);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        customWebView.setHorizontalScrollBarEnabled(false);
        customWebView.setVerticalScrollBarEnabled(false);
        customWebView.setLayoutParams(layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(this.context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams3.weight = 1.0f;
        linearLayout2.setLayoutParams(layoutParams3);
        linearLayout2.setBackgroundColor(Color.parseColor("#00000000"));
        linearLayout2.setClickable(true);
        linearLayout2.setFocusable(true);
        linearLayout2.setFocusableInTouchMode(true);
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(112);
        linearLayout2.setVisibility(0);
        linearLayout2.addView(new IndicatorView(this.context).getIndicatorView());
        LinearLayout linearLayout3 = new LinearLayout(this.context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams4.weight = 1.0f;
        linearLayout3.setLayoutParams(layoutParams4);
        linearLayout3.setBackgroundColor(Color.parseColor("#00000000"));
        linearLayout3.setClickable(true);
        linearLayout3.setFocusable(true);
        linearLayout3.setFocusableInTouchMode(true);
        linearLayout3.setGravity(17);
        linearLayout3.setOrientation(112);
        linearLayout3.setVisibility(8);
        frameLayout.addView(customWebView);
        frameLayout.addView(linearLayout2);
        frameLayout.addView(linearLayout3);
        linearLayout.addView(frameLayout);
        return linearLayout;
    }
}
