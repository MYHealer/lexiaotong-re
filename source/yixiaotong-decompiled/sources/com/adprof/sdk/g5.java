package com.adprof.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.adprof.sdk.api.BannerSize;
import com.adprof.sdk.xb.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class g5 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f303a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f304a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public y4 f305a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public z4 f306a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f307a;
    public final boolean b;

    public g5(Context context, d dVar, boolean z, BannerSize bannerSize, boolean z2) {
        super(context);
        this.f304a = dVar;
        this.f307a = z;
        if (bannerSize == null) {
            BannerSize bannerSize2 = BannerSize.SIZE_320_50;
        }
        this.b = z2;
        mo633b();
    }

    private void setVideoStatusListen(po poVar) {
        poVar.setVideoAdStatusListener(new x4(this, poVar));
    }

    public Button a() {
        return new Button(getContext());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ImageView m631a() {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        String bannerImageUrl = getBannerImageUrl();
        if (!TextUtils.isEmpty(bannerImageUrl)) {
            xb xbVarA = xb.a(getContext());
            xbVarA.getClass();
            xbVarA.new a(bannerImageUrl).a(imageView);
        }
        return imageView;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m632a() {
        if (this.f307a) {
            ImageView imageView = new ImageView(getContext());
            this.f303a = imageView;
            imageView.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
            this.f303a.setScaleType(ImageView.ScaleType.CENTER);
            this.f303a.setBackgroundColor(Integer.MIN_VALUE);
            this.f303a.setPadding(h8.a(2.0f), h8.a(2.0f), h8.a(2.0f), h8.a(2.0f));
            int iA = h8.a(12.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
            layoutParams.gravity = 53;
            layoutParams.setMargins(h8.a(4.0f), h8.a(4.0f), 0, 0);
            addView(this.f303a, layoutParams);
            this.f303a.setOnClickListener(new v4(this));
        }
    }

    public void a(View view, TextView textView, TextView textView2, View view2) {
        if (z8.a(this.f304a)) {
            setupFullScreenClickListener(view);
            setupFullScreenClickListener(textView);
            if (textView2 != null) {
                setupFullScreenClickListener(textView2);
            }
            setupFullScreenClickListener(view2);
        }
    }

    public void a(Button button) {
        button.setOnTouchListener(new t4(this));
    }

    public void a(ImageView imageView) {
        try {
            String bannerImageUrl = getBannerImageUrl();
            if (TextUtils.isEmpty(bannerImageUrl)) {
                return;
            }
            xb.a(getContext()).a(bannerImageUrl, new w4(this, imageView));
        } catch (Throwable unused) {
        }
    }

    public final ImageView b() {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        String bannerImageUrl = getBannerImageUrl();
        if (!TextUtils.isEmpty(bannerImageUrl)) {
            xb xbVarA = xb.a(getContext());
            xbVarA.getClass();
            xbVarA.new a(bannerImageUrl).a(imageView);
        }
        return imageView;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public abstract void mo633b();

    public d getAdUnit() {
        return this.f304a;
    }

    public String getBannerImageUrl() {
        d dVar = this.f304a;
        if (dVar == null) {
            return null;
        }
        String str = dVar.f204f;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strL = this.f304a.l();
        if (TextUtils.isEmpty(strL)) {
            return null;
        }
        return strL;
    }

    public String getCTAText() {
        d dVar = this.f304a;
        return (dVar == null || !dVar.m597a()) ? "立即打开" : "立即下载";
    }

    public void setCtaButton(Button button) {
    }

    public void setOnBannerCloseListener(y4 y4Var) {
        this.f305a = y4Var;
    }

    public void setOnBannerTouchListener(z4 z4Var) {
        this.f306a = z4Var;
    }

    public void setupFullScreenClickListener(View view) {
        if (view == null || this.f306a == null) {
            return;
        }
        view.setOnTouchListener(new u4(this));
    }

    public View a(int i, int i2) {
        ImageView imageViewB;
        d dVar = this.f304a;
        if (dVar == null) {
            return b();
        }
        if (!dVar.m605f()) {
            return this.f304a.m603d() ? b() : b();
        }
        try {
            po poVar = new po(getContext());
            poVar.a(true, true);
            String strM = this.f304a.m();
            String str = this.f304a.f202d;
            if (TextUtils.isEmpty(strM)) {
                pk.e("BannerView Video URL is empty, fallback to image");
                imageViewB = b();
            } else {
                try {
                    String bannerImageUrl = getBannerImageUrl();
                    if (!TextUtils.isEmpty(bannerImageUrl) && poVar.getThumbView() != null) {
                        xb xbVarA = xb.a(getContext());
                        xbVarA.getClass();
                        xbVarA.new a(bannerImageUrl).a(poVar.getThumbView());
                    }
                } catch (Throwable unused) {
                }
                setVideoStatusListen(poVar);
                poVar.a(new qo(strM, str), 0);
                poVar.setSoundChange(true);
                imageViewB = poVar;
            }
            return imageViewB;
        } catch (Exception e) {
            if (pk.b()) {
                Log.w("adprofsdk", "BannerView Failed to create video view, fallback to image", e);
            }
            return b();
        }
    }
}
