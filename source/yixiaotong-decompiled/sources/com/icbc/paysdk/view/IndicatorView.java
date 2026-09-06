package com.icbc.paysdk.view;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class IndicatorView {
    Context context;

    public IndicatorView(Context context) {
        this.context = context;
    }

    public RelativeLayout getIndicatorView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(dip2px(this.context, 110.0f), dip2px(this.context, 48.0f)));
        relativeLayout.setBackgroundColor(Color.parseColor("#50000000"));
        relativeLayout.setPadding(dip2px(this.context, 5.0f), dip2px(this.context, 5.0f), dip2px(this.context, 5.0f), dip2px(this.context, 5.0f));
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        ProgressWheel progressWheel = new ProgressWheel(this.context, null);
        progressWheel.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        progressWheel.setVisibility(0);
        progressWheel.setId(100000001);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, 100000001);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        TextView textView = new TextView(this.context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(8, 0, 0, 0);
        textView.setLayoutParams(layoutParams2);
        textView.setTextColor(-1);
        textView.setTextSize(13.0f);
        textView.setText("正在载入...");
        relativeLayout.addView(progressWheel);
        relativeLayout.addView(textView, layoutParams);
        return relativeLayout;
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
