package com.adprof.sdk;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class sm {
    public static void a(Context context, View view, TextView textView, TextView textView2, Runnable runnable) {
        if (context == null || view == null || textView == null || textView2 == null || !(view instanceof LinearLayout)) {
            return;
        }
        try {
            h6.b(view);
            LinearLayout linearLayout = (LinearLayout) view;
            linearLayout.removeAllViews();
            linearLayout.setBackgroundColor(0);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            linearLayout.setPadding(0, 0, 0, 0);
            linearLayout.setMinimumHeight(0);
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).setMargins(0, 0, 0, 0);
                linearLayout.setLayoutParams(layoutParams);
            }
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            int iA = h8.a(5.0f);
            int iA2 = h8.a(8.0f);
            linearLayout2.setPadding(iA2, iA, iA2, iA);
            linearLayout2.setBackgroundResource(R.drawable.adprof_splash_cta_pill_bg);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textView.setText(R.string.adprof_splash_cta_enter_now);
            textView.setTextSize(2, 14.0f);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setTextColor(-1);
            textView.setIncludeFontPadding(false);
            linearLayout2.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            TextView textView3 = new TextView(context);
            textView3.setText(">>");
            textView3.setTextSize(2, 12.0f);
            textView3.setTextColor(-1275068417);
            textView3.setIncludeFontPadding(false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMarginStart(h8.a(3.0f));
            linearLayout2.addView(textView3, layoutParams2);
            textView2.setText(R.string.adprof_splash_cta_sub_landing);
            textView2.setTextSize(2, 10.0f);
            textView2.setTypeface(Typeface.DEFAULT);
            textView2.setTextColor(-788529153);
            textView2.setIncludeFontPadding(false);
            textView2.setGravity(17);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = h8.a(4.0f);
            textView2.setLayoutParams(layoutParams3);
            linearLayout.addView(linearLayout2);
            linearLayout.addView(textView2);
            if (runnable != null) {
                runnable.run();
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    public static void a(LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout, View view) {
        FrameLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        int iA = h8.a(30.0f);
        int iA2 = h8.a(8.0f);
        int iA3 = h8.a(6.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(20, -1);
        layoutParams3.addRule(12, -1);
        layoutParams3.setMarginStart(iA);
        layoutParams3.setMarginEnd(0);
        layoutParams3.topMargin = 0;
        layoutParams3.bottomMargin = iA;
        linearLayout.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(21, -1);
        layoutParams4.addRule(10, -1);
        layoutParams4.setMarginStart(0);
        layoutParams4.setMarginEnd(iA2);
        layoutParams4.topMargin = iA3;
        layoutParams4.bottomMargin = 0;
        linearLayout2.setLayoutParams(layoutParams4);
        linearLayout2.setPadding(0, 0, 0, 0);
        if (frameLayout != null) {
            ViewGroup.LayoutParams layoutParams5 = frameLayout.getLayoutParams();
            if (layoutParams5 instanceof LinearLayout.LayoutParams) {
                layoutParams2 = (LinearLayout.LayoutParams) layoutParams5;
                layoutParams2.width = -2;
                layoutParams2.height = -2;
            } else {
                layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams2.gravity = GravityCompat.END;
            layoutParams2.setMargins(0, 0, 0, 0);
            frameLayout.setLayoutParams(layoutParams2);
        }
        if (view != null) {
            ViewGroup.LayoutParams layoutParams6 = view.getLayoutParams();
            if (layoutParams6 instanceof FrameLayout.LayoutParams) {
                layoutParams6.width = -2;
                layoutParams6.height = -2;
                layoutParams = (FrameLayout.LayoutParams) layoutParams6;
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            layoutParams.gravity = 8388629;
            layoutParams.setMargins(0, 0, 0, 0);
            view.setLayoutParams(layoutParams);
        }
    }
}
