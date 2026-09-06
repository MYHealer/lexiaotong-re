package com.opos.mobad.q;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class n implements com.opos.mobad.ad.f.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7305a;
    private ViewGroup b;
    private String c;
    private String d;
    private boolean e = false;

    public n(Context context, String str, String str2) {
        this.f7305a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.c = str;
        this.d = str2;
        b();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00d0 A[PHI: r8
  0x00d0: PHI (r8v5 java.lang.String) = (r8v3 java.lang.String), (r8v3 java.lang.String), (r8v6 java.lang.String) binds: [B:8:0x001c, B:10:0x0022, B:23:0x00c9] A[DONT_GENERATE, DONT_INLINE]] */
    public static String a(Context context, String str) {
        String strG;
        String strSubstring = "";
        if (context != null) {
            try {
                if (!com.opos.cmn.an.d.a.a(str)) {
                    strG = com.opos.cmn.an.h.d.a.g(context, str);
                    try {
                        if (com.opos.cmn.an.d.a.a(strG) || strG.length() <= 0) {
                            strSubstring = strG;
                        } else {
                            int iIndexOf = strG.indexOf("(");
                            int iIndexOf2 = strG.indexOf(")");
                            com.opos.cmn.an.f.a.b("SplashBottomArea", "english first=" + iIndexOf + ",english last=" + iIndexOf2);
                            if (-1 == iIndexOf || -1 == iIndexOf2) {
                                iIndexOf = strG.indexOf("（");
                                iIndexOf2 = strG.indexOf("）");
                                com.opos.cmn.an.f.a.b("SplashBottomArea", "chinese first=" + iIndexOf + ",chinese last=" + iIndexOf2);
                            }
                            if (-1 != iIndexOf && -1 != iIndexOf2 && iIndexOf2 > iIndexOf) {
                                strG = strG.substring(0, iIndexOf) + strG.substring(iIndexOf2 + 1, strG.length());
                            }
                            int iIndexOf3 = strG.indexOf(x.A);
                            com.opos.cmn.an.f.a.b("SplashBottomArea", "english - =" + iIndexOf3);
                            if (-1 == iIndexOf3) {
                                iIndexOf3 = strG.indexOf("—");
                                com.opos.cmn.an.f.a.b("SplashBottomArea", "chinese — =" + iIndexOf3);
                            }
                            if (-1 != iIndexOf3) {
                                strSubstring = strG.substring(0, iIndexOf3);
                            } else {
                                strSubstring = strG;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        com.opos.cmn.an.f.a.a("SplashBottomArea", "", (Throwable) e);
                    }
                }
            } catch (Exception e2) {
                e = e2;
                strG = "";
            }
        }
        strG = strSubstring;
        com.opos.cmn.an.f.a.b("SplashBottomArea", "getAppDefaultTitle=" + strG);
        return strG;
    }

    private void a(RelativeLayout relativeLayout) {
        final ImageView imageView = new ImageView(this.f7305a);
        imageView.setId(2);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.q.n.2
            @Override // java.lang.Runnable
            public void run() {
                final Drawable drawableF;
                if (n.this.e || (drawableF = com.opos.cmn.an.h.d.a.f(n.this.f7305a, n.this.f7305a.getPackageName())) == null) {
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.opos.mobad.q.n.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (n.this.e) {
                            return;
                        }
                        imageView.setImageDrawable(drawableF);
                    }
                });
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f7305a, 40.0f), com.opos.cmn.an.h.f.a.a(this.f7305a, 40.0f));
        layoutParams.addRule(15);
        relativeLayout.addView(imageView, layoutParams);
    }

    private void a(RelativeLayout relativeLayout, String str) {
        TextView textView = new TextView(this.f7305a);
        textView.setText(str);
        textView.setId(3);
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#010036"));
        textView.setTextSize(1, 22.0f);
        textView.setMaxEms(7);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        relativeLayout.addView(textView, layoutParams);
    }

    private void a(RelativeLayout relativeLayout, String str, String str2) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f7305a);
        a(relativeLayout2, str);
        b(relativeLayout2, str2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, 2);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f7305a, 10.0f);
        relativeLayout.addView(relativeLayout2, layoutParams);
    }

    private void b() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f7305a);
        this.b = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f7305a);
        a(relativeLayout2);
        a(relativeLayout2, this.c, this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f7305a, 55.0f));
        layoutParams.addRule(13);
        this.b.addView(relativeLayout2, layoutParams);
        this.b.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.q.n.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                n.this.e = false;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                n.this.e = true;
            }
        });
    }

    private void b(RelativeLayout relativeLayout, String str) {
        TextView textView = new TextView(this.f7305a);
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#aaaaaa"));
        textView.setTextSize(1, 13.0f);
        textView.setMaxEms(11);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, 3);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        relativeLayout.addView(textView, layoutParams);
    }

    @Override // com.opos.mobad.ad.f.d
    public View a() {
        return this.b;
    }
}
