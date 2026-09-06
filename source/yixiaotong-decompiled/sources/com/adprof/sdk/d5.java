package com.adprof.sdk;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adprof.sdk.api.BannerSize;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class d5 extends g5 {
    public boolean c;

    public d5(Context context, d dVar, boolean z, BannerSize bannerSize, boolean z2) {
        super(context, dVar, z, bannerSize, z2);
        this.c = false;
    }

    public static void a(d5 d5Var, int i) {
        View viewM631a;
        d5Var.removeAllViews();
        d5Var.setMinimumWidth(i);
        d5Var.requestLayout();
        int iA = h8.a(300.0f);
        if (!d5Var.b) {
            i = Math.min(i, iA);
        }
        h8.a(75.0f);
        int iMax = Math.max(h8.a(100.0f), i / 2);
        int iA2 = h8.a(75.0f);
        LinearLayout linearLayout = new LinearLayout(d5Var.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(-1);
        d5Var.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(d5Var.getContext());
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(iMax, iA2, 0.0f));
        if (((g5) d5Var).f304a.m605f()) {
            viewM631a = d5Var.a(150, 75);
            ImageView imageView = new ImageView(d5Var.getContext());
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            d5Var.a(imageView);
        } else {
            viewM631a = d5Var.m631a();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(viewM631a, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(d5Var.getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(48);
        linearLayout2.setPadding(h8.a(8.0f), h8.a(4.0f), Math.max(h8.a(26.0f), h8.a(34.0f)), h8.a(4.0f));
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(0, -1, 1.0f));
        TextView textView = new TextView(d5Var.getContext());
        textView.setTextSize(2, 15.0f);
        textView.setTextColor(-16777216);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(17);
        textView.setText(TextUtils.isEmpty(d5Var.getAdUnit().f202d) ? "Title" : d5Var.getAdUnit().f202d);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        TextView textView2 = new TextView(d5Var.getContext());
        textView2.setTextSize(2, 11.0f);
        textView2.setTextColor(-10066330);
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setGravity(17);
        CharSequence charSequence = d5Var.getAdUnit().f203e;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = "拼着买，更实惠";
        }
        textView2.setText(charSequence);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        Button buttonA = d5Var.a();
        buttonA.setText(d5Var.getCTAText());
        buttonA.setTextColor(-1);
        buttonA.setTextSize(2, 12.0f);
        buttonA.setPadding(h8.a(12.0f), h8.a(3.0f), h8.a(12.0f), h8.a(3.0f));
        buttonA.setAllCaps(false);
        buttonA.setGravity(17);
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-15112449);
            gradientDrawable.setCornerRadius(h8.a(20.0f));
            buttonA.setBackground(gradientDrawable);
        } catch (Exception unused) {
            buttonA.setBackgroundColor(-15112449);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, h8.a(24.0f));
        layoutParams2.gravity = 17;
        layoutParams2.setMargins(0, h8.a(2.0f), 0, 0);
        linearLayout2.addView(buttonA, layoutParams2);
        d5Var.setCtaButton(buttonA);
        d5Var.a(buttonA);
        d5Var.m632a();
        try {
            ImageView imageView2 = new ImageView(d5Var.getContext());
            imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView2.setAdjustViewBounds(true);
            Context context = AdprofSdk.getInstance().getContext();
            if (context != null) {
                imageView2.setImageDrawable(context.getDrawable(R.drawable.adprof_ad_logo));
            }
            int iA3 = h8.a(13.0f);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iA3, iA3);
            layoutParams3.gravity = 85;
            layoutParams3.setMargins(0, 0, h8.a(4.0f), 0);
            d5Var.addView(imageView2, layoutParams3);
        } catch (Exception unused2) {
        }
        d5Var.a(viewM631a, textView, textView2, linearLayout);
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
        setMinimumHeight(h8.a(75.0f));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.c) {
            return;
        }
        post(new c5(this));
    }
}
