package com.hihonor.adsdk.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.common.b.b;
import com.hihonor.adsdk.common.f.j;
import com.hihonor.adsdk.splash.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class VerticalSpSmallImageAdView extends BaseSplashAdView {
    private static final String D = "VerticalSpSmallImageAdView";
    private TextView A;
    private TextView B;
    private FrameLayout C;
    private LinearLayout y;
    private ImageView z;

    public VerticalSpSmallImageAdView(Context context) {
        super(context);
    }

    private void q() {
        b.hnadsc(D, "handleSetLogo", new Object[0]);
        this.z.setVisibility(0);
        s();
    }

    private void r() {
        b.hnadsc(D, "handleSetMediaCopyright", new Object[0]);
        this.B.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.honor_ads_magic_dimens_text_vertical);
            b.hnadsc(D, "handleSetMediaCopyright bottomMarginValue = " + dimensionPixelSize, new Object[0]);
            layoutParams2.bottomMargin = dimensionPixelSize;
            this.y.setLayoutParams(layoutParams2);
        }
    }

    private void s() {
        b.hnadsc(D, "setAdsLeaveBlankMediaNameMarginStart", new Object[0]);
        ViewGroup.LayoutParams layoutParams = this.A.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.honor_ads_magic_dimens_text_horizontal);
            b.hnadsc(D, "setAdsLeaveBlankMediaNameMarginStart marginStartValue = " + dimensionPixelSize, new Object[0]);
            layoutParams2.setMarginStart(dimensionPixelSize);
            this.A.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView
    public void a(View view, int i) {
        b.hnadsc(D, "setLogoArea areaView,visible", new Object[0]);
        this.C.addView(view);
        this.C.setVisibility(i);
        this.z.setVisibility(8);
        if (i == 0) {
            s();
        }
    }

    @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView
    protected int getContentView() {
        return R.layout.honor_ads_view_splash_small_image_ad;
    }

    @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView
    protected void m() {
        BaseAd baseAd = this.f3585a;
        if (baseAd != null) {
            setImageView(baseAd);
        }
    }

    @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView
    public void setLogoArea(View view) {
        b.hnadsc(D, "setLogoArea areaView", new Object[0]);
        this.C.addView(view);
        this.z.setVisibility(8);
        s();
    }

    @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView
    public void setLogoResId(int i) {
        b.hnadsc(D, "setLogoResId", new Object[0]);
        this.z.setImageResource(i);
        q();
    }

    @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView
    public void setLogoView(Bitmap bitmap) {
        b.hnadsc(D, "setLogoView", new Object[0]);
        this.z.setImageBitmap(bitmap);
        q();
    }

    @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView
    public void setMediaCopyrightResId(int i) {
        b.hnadsc(D, "setMediaCopyrightResId", new Object[0]);
        this.B.setText(i);
        r();
    }

    @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView
    public void setMediaCopyrightString(String str) {
        b.hnadsc(D, "setMediaCopyrightString", new Object[0]);
        this.B.setText(str);
        r();
    }

    @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView
    public void setMediaNameResId(int i) {
        b.hnadsc(D, "setMediaNameResId", new Object[0]);
        this.A.setText(i);
        this.A.setVisibility(0);
    }

    @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView
    public void setMediaNameString(String str) {
        b.hnadsc(D, "setMediaNameString", new Object[0]);
        this.A.setText(str);
        this.A.setVisibility(0);
    }

    public VerticalSpSmallImageAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VerticalSpSmallImageAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.hihonor.adsdk.splash.view.BaseSplashAdView
    protected void a() {
        this.z = (ImageView) findViewById(R.id.ads_leave_blank_icon_img);
        this.A = (TextView) findViewById(R.id.ads_leave_blank_media_name);
        this.B = (TextView) findViewById(R.id.ads_leave_blank_media_copy_right);
        this.C = (FrameLayout) findViewById(R.id.ads_leave_blank_icon_image_layout);
        this.y = (LinearLayout) findViewById(R.id.ads_leave_blank_top_layout);
        this.z.setOutlineProvider(new BaseSplashAdView.b(j.hnadsa(this.f, 4.0f)));
        this.z.setClipToOutline(true);
    }
}
