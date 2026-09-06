package com.adprof.sdk;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adprof.sdk.api.BannerSize;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class f5 extends g5 {
    public boolean c;

    public f5(Context context, d dVar, boolean z, BannerSize bannerSize, boolean z2) {
        super(context, dVar, z, bannerSize, z2);
        this.c = false;
    }

    public static void a(f5 f5Var, int i) {
        View viewM631a;
        f5Var.removeAllViews();
        f5Var.setMinimumWidth(i);
        f5Var.requestLayout();
        int iMin = f5Var.b ? i : Math.min(i, h8.a(320.0f));
        h8.a(50.0f);
        int iMax = Math.max(h8.a(80.0f), iMin / 3);
        int iMax2 = Math.max(h8.a(60.0f), iMin / 4);
        int iA = h8.a(30.0f);
        LinearLayout linearLayout = new LinearLayout(f5Var.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(-460552);
        f5Var.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(f5Var.getContext());
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(iMax, -1, 0.0f);
        if (((g5) f5Var).f304a.m605f()) {
            viewM631a = f5Var.a(100, 50);
            ImageView imageView = new ImageView(f5Var.getContext());
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            f5Var.a(imageView);
        } else {
            viewM631a = f5Var.m631a();
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        frameLayout.addView(viewM631a, layoutParams2);
        linearLayout.addView(frameLayout, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(f5Var.getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(16);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams3.setMargins(h8.a(8.0f), 0, h8.a(4.0f), 0);
        linearLayout.addView(linearLayout2, layoutParams3);
        TextView textView = new TextView(f5Var.getContext());
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(-16777216);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setText(TextUtils.isEmpty(f5Var.getAdUnit().f202d) ? "广告" : f5Var.getAdUnit().f202d);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        TextView textView2 = new TextView(f5Var.getContext());
        textView2.setTextSize(2, 12.0f);
        textView2.setTextColor(-10066330);
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setText(f5Var.getAdUnit().f203e);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
        Button buttonA = f5Var.a();
        buttonA.setText(f5Var.getCTAText());
        buttonA.setTextColor(-1);
        buttonA.setTextSize(2, 14.0f);
        buttonA.setPadding(h8.a(2.0f), 0, h8.a(2.0f), 0);
        buttonA.setAllCaps(false);
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-15112449);
            gradientDrawable.setCornerRadius(h8.a(20.0f));
            gradientDrawable.setStroke(h8.a(1.0f), -15906911);
            buttonA.setBackground(gradientDrawable);
        } catch (Exception unused) {
            buttonA.setBackgroundColor(-15112449);
        }
        int iMax3 = Math.max(h8.a(26.0f), h8.a(34.0f));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(iMax2, iA, 0.0f);
        layoutParams4.gravity = 16;
        layoutParams4.setMargins(h8.a(4.0f), h8.a(4.0f), iMax3, h8.a(4.0f));
        linearLayout.addView(buttonA, layoutParams4);
        f5Var.setCtaButton(buttonA);
        f5Var.a(buttonA);
        f5Var.m632a();
        try {
            ImageView imageView2 = new ImageView(f5Var.getContext());
            imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView2.setAdjustViewBounds(true);
            Context context = AdprofSdk.getInstance().getContext();
            if (context != null) {
                imageView2.setImageDrawable(context.getDrawable(R.drawable.adprof_ad_logo));
            }
            int iA2 = h8.a(13.0f);
            FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(iA2, iA2);
            layoutParams5.gravity = 85;
            layoutParams5.setMargins(0, 0, h8.a(4.0f), h8.a(4.0f));
            f5Var.addView(imageView2, layoutParams5);
        } catch (Exception unused2) {
        }
        f5Var.a(viewM631a, textView, textView2, linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public int getContainerWidth() {
        int width;
        int width2;
        try {
            ViewParent parent = getParent();
            if ((parent instanceof View) && (width2 = ((View) parent).getWidth()) > 0) {
                return width2;
            }
            if (parent == 0 || !(parent.getParent() instanceof View) || (width = ((View) parent.getParent()).getWidth()) <= 0) {
                return 0;
            }
            return width;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.adprof.sdk.g5
    /* JADX INFO: renamed from: b */
    public void mo633b() {
        setBackgroundColor(-1);
        setMinimumHeight(h8.a(50.0f));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.c) {
            return;
        }
        post(new e5(this));
    }
}
