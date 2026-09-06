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
import com.adprof.sdk.xb.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class b5 extends g5 {
    public boolean c;

    public b5(Context context, d dVar, boolean z, BannerSize bannerSize, boolean z2) {
        super(context, dVar, z, bannerSize, z2);
        this.c = false;
    }

    public static void a(b5 b5Var, int i) {
        View viewM631a;
        ViewGroup.LayoutParams layoutParams;
        b5Var.removeAllViews();
        b5Var.setMinimumWidth(i);
        b5Var.requestLayout();
        int iA = h8.a(300.0f);
        if (!b5Var.b) {
            i = Math.min(i, iA);
        }
        h8.a(120.0f);
        int iMax = Math.max(h8.a(120.0f), (i * 3) / 5);
        int iA2 = h8.a(120.0f);
        LinearLayout linearLayout = new LinearLayout(b5Var.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(-1);
        b5Var.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(b5Var.getContext());
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(iMax, iA2, 0.0f));
        if (((g5) b5Var).f304a.m605f()) {
            viewM631a = b5Var.a(180, 120);
            ImageView imageView = new ImageView(b5Var.getContext());
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            b5Var.a(imageView);
        } else {
            viewM631a = b5Var.m631a();
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        frameLayout.addView(viewM631a, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(b5Var.getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(48);
        linearLayout2.setPadding(h8.a(12.0f), h8.a(8.0f), Math.max(h8.a(26.0f), h8.a(34.0f)), h8.a(8.0f));
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(0, -1, 1.0f));
        boolean z = !TextUtils.isEmpty(b5Var.getAdUnit().f204f);
        LinearLayout linearLayout3 = new LinearLayout(b5Var.getContext());
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(17);
        if (z) {
            layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
            linearLayout3.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0, 0.0f);
            linearLayout3.setVisibility(8);
            layoutParams = layoutParams3;
        }
        linearLayout2.addView(linearLayout3, layoutParams);
        ImageView imageView2 = new ImageView(b5Var.getContext());
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int iA3 = h8.a(32.0f);
        linearLayout3.addView(imageView2, new LinearLayout.LayoutParams(iA3, iA3));
        if (z) {
            xb xbVarA = xb.a(b5Var.getContext());
            String str = b5Var.getAdUnit().f204f;
            xbVarA.getClass();
            xbVarA.new a(str).a(imageView2);
        }
        TextView textView = new TextView(b5Var.getContext());
        textView.setTextSize(2, 15.0f);
        textView.setTextColor(-16777216);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(17);
        textView.setText(TextUtils.isEmpty(b5Var.getAdUnit().f202d) ? "Title" : b5Var.getAdUnit().f202d);
        linearLayout2.addView(textView, z ? new LinearLayout.LayoutParams(-1, 0, 1.0f) : new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout linearLayout4 = new LinearLayout(b5Var.getContext());
        linearLayout4.setOrientation(0);
        linearLayout4.setGravity(17);
        linearLayout2.addView(linearLayout4, z ? new LinearLayout.LayoutParams(-1, 0, 1.0f) : new LinearLayout.LayoutParams(-1, 0, 1.0f));
        Button buttonA = b5Var.a();
        buttonA.setText(b5Var.getCTAText());
        buttonA.setTextColor(-1);
        buttonA.setTextSize(2, 12.0f);
        buttonA.setPadding(h8.a(12.0f), h8.a(6.0f), h8.a(12.0f), h8.a(6.0f));
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
        linearLayout4.addView(buttonA, new LinearLayout.LayoutParams(-2, h8.a(28.0f)));
        b5Var.setCtaButton(buttonA);
        b5Var.a(buttonA);
        b5Var.m632a();
        try {
            ImageView imageView3 = new ImageView(b5Var.getContext());
            imageView3.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView3.setAdjustViewBounds(true);
            Context context = AdprofSdk.getInstance().getContext();
            if (context != null) {
                imageView3.setImageDrawable(context.getDrawable(R.drawable.adprof_ad_logo));
            }
            int iA4 = h8.a(13.0f);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(iA4, iA4);
            layoutParams4.gravity = 85;
            layoutParams4.setMargins(0, 0, h8.a(4.0f), h8.a(4.0f));
            b5Var.addView(imageView3, layoutParams4);
        } catch (Exception unused2) {
        }
        b5Var.a(viewM631a, textView, null, linearLayout);
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
        setMinimumHeight(h8.a(120.0f));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.c) {
            return;
        }
        post(new a5(this));
    }
}
