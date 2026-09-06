package com.adprof.sdk;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.adprof.sdk.base.activity.AdActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class td extends q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f1439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b6 f743a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f744a;
    public ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f745b;
    public RelativeLayout c;

    public td(Activity activity, d dVar, Bundle bundle, String str, r5 r5Var) {
        super(activity, str, r5Var);
        this.f744a = dVar;
        if (bundle != null) {
            d dVarA = h2.a(bundle.getString("key_adunit_uuid"));
            if (dVarA != null) {
                this.f744a = dVarA;
            }
            this.f745b = bundle.getString("key_detail_url");
        }
        if (this.f744a != null) {
            a().requestWindowFeature(8);
        } else {
            a("action.land.page.show.fail");
            ((AdActivity) m711a()).a();
        }
    }

    public static boolean a(td tdVar, String str) {
        tdVar.getClass();
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.toLowerCase().endsWith(".apk")) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // com.adprof.sdk.q5
    /* JADX INFO: renamed from: a */
    public void mo660a() {
    }

    @Override // com.adprof.sdk.q5
    public void a(Configuration configuration) {
    }

    @Override // com.adprof.sdk.q5
    public void a(Bundle bundle) {
    }

    @Override // com.adprof.sdk.q5
    /* JADX INFO: renamed from: a */
    public boolean mo661a() {
        if (!this.f743a.canGoBack()) {
            return true;
        }
        this.f743a.goBack();
        return false;
    }

    @Override // com.adprof.sdk.q5
    public void b() {
        Resources resources;
        he heVarM644a = he.m644a();
        Context context = heVarM644a.f350a;
        int identifier = (context == null || (resources = context.getResources()) == null) ? 0 : resources.getIdentifier("adprof_land_theme", "style", heVarM644a.f350a.getPackageName());
        if (identifier > 0) {
            a().getTheme().applyStyle(identifier, true);
        }
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(-1, -1, 17);
        ActionBar actionBar = a().getActionBar();
        if (actionBar != null) {
            if (this.c == null) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(13);
                int iA = h8.a(24.0f);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA, iA);
                layoutParams3.addRule(15);
                layoutParams3.addRule(9);
                int i = iA / 2;
                layoutParams3.setMargins(i, i, 0, 0);
                ImageView imageView = new ImageView(((q5) this).f1378a);
                this.f1439a = imageView;
                imageView.setImageBitmap(com.adprof.sdk.base.view.a.BACK.a());
                this.f1439a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f1439a.setClickable(true);
                this.f1439a.setId(he.a());
                this.f1439a.setOnClickListener(new qd(this));
                RelativeLayout relativeLayout = new RelativeLayout(((q5) this).f1378a);
                this.c = relativeLayout;
                relativeLayout.setLayoutParams(layoutParams2);
                this.c.setBackgroundColor(-1);
                this.c.addView(this.f1439a, layoutParams3);
                int iA2 = h8.a(20.0f);
                int iA3 = h8.a(16.0f);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iA2, iA2);
                layoutParams4.addRule(15);
                layoutParams4.addRule(1, this.f1439a.getId());
                layoutParams4.setMargins(iA3, iA2 / 2, 0, 0);
                ImageView imageView2 = new ImageView(((q5) this).f1378a);
                this.b = imageView2;
                imageView2.setImageBitmap(com.adprof.sdk.base.view.a.CLOSE.a());
                this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.b.setClickable(true);
                this.b.setOnClickListener(new rd(this));
                this.c.addView(this.b, layoutParams4);
            }
            actionBar.setCustomView(this.c, layoutParams);
            actionBar.setDisplayOptions(16);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        if (this.f743a == null) {
            try {
                b6 b6Var = new b6(a());
                this.f743a = b6Var;
                b6Var.setScrollBarStyle(0);
                this.f743a.setAdUnit(this.f744a);
                this.f743a.setWebViewClient(new nd(this));
                this.f743a.setWebChromeClient(new od(this));
            } catch (Throwable th) {
                pk.b("create land page webview error: ", th);
                ((AdActivity) ((q5) this).f662a).a();
            }
        }
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout = new LinearLayout(a());
        linearLayout.addView(this.f743a, 0, layoutParams5);
        ((q5) this).f662a.onSetContentView(linearLayout);
        this.f743a.setDownloadListener(new pd(this));
        d dVar = this.f744a;
        String strM720a = dVar.m591a().m720a(dVar.n);
        if (!TextUtils.isEmpty(this.f745b)) {
            this.f743a.loadUrl(this.f745b);
            return;
        }
        if (TextUtils.isEmpty(this.f744a.n)) {
            this.f743a.loadUrl(strM720a);
        } else {
            this.f743a.loadUrl(this.f744a.n);
        }
        String str = ((q5) this).f663a;
        if (str != null) {
            s5.a(str, "action.land.page.show");
        } else {
            pk.e("Tried to broadcast a video event without a broadcast identifier to send to.");
        }
    }

    @Override // com.adprof.sdk.q5
    public void c() {
        String str = ((q5) this).f663a;
        if (str != null) {
            s5.a(str, "action.land.page.dismiss");
        } else {
            pk.e("Tried to broadcast a video event without a broadcast identifier to send to.");
        }
        ImageView imageView = this.f1439a;
        if (imageView != null) {
            imageView.setOnClickListener(null);
            this.f1439a = null;
        }
        ImageView imageView2 = this.b;
        if (imageView2 != null) {
            imageView2.setOnClickListener(null);
            this.b = null;
        }
        b6 b6Var = this.f743a;
        if (b6Var != null) {
            b6Var.destroy();
            this.f743a = null;
        }
        super.c();
    }

    @Override // com.adprof.sdk.q5
    public void d() {
    }

    @Override // com.adprof.sdk.q5
    public void e() {
        b6 b6Var = this.f743a;
        if (b6Var != null) {
            b6Var.resumeTimers();
        }
    }

    @Override // com.adprof.sdk.q5
    public void f() {
    }
}
