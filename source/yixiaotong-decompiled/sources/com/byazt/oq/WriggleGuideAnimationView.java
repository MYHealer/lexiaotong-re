package com.byazt.oq;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.aq.da;
import com.byazt.ga.LottieAnimationView;
import com.byazt.nr.zm;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 269, 1743})
public class WriggleGuideAnimationView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f2595a;
    public int c;
    public boolean i;
    public c n;
    public LottieAnimationView sp;
    public TextView tt;
    public TextView uj;
    public zm ve;
    public da x;

    public interface c {
        void c();
    }

    public TextView getTopTextView() {
        return this.tt;
    }

    public LinearLayout getWriggleLayout() {
        return this.f2595a;
    }

    public View getWriggleProgressIv() {
        return this.sp;
    }

    public void setOnShakeViewListener(c cVar) {
        this.n = cVar;
    }

    public WriggleGuideAnimationView(Context context, View view, da daVar, boolean z, int i) {
        super(context);
        this.x = daVar;
        this.i = z;
        this.c = i;
        c(context, view);
    }

    private void c(Context context, View view) {
        setClipChildren(false);
        addView(view);
        this.f2595a = (LinearLayout) findViewById(2097610722);
        this.tt = (TextView) findViewById(2097610719);
        this.uj = (TextView) findViewById(2097610718);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(2097610706);
        this.sp = lottieAnimationView;
        lottieAnimationView.setAnimation("lottie_json/twist_multi_angle.json");
        this.sp.setImageAssetsFolder("images/");
        this.sp.c(true);
    }

    public void setShakeText(String str) {
        this.uj.setText(str);
    }

    public void c() {
        postDelayed(new Runnable() { // from class: com.byazt.oq.WriggleGuideAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WriggleGuideAnimationView.this.sp.c();
                } catch (Throwable unused) {
                }
            }
        }, 500L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.ve == null) {
                this.ve = new zm(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), 2, this.i);
            }
            this.ve.c(new zm.c() { // from class: com.byazt.oq.WriggleGuideAnimationView.2
                @Override // com.byazt.nr.zm.c
                public void c(int i) {
                    if (i == 2 && WriggleGuideAnimationView.this.isShown() && WriggleGuideAnimationView.this.n != null) {
                        WriggleGuideAnimationView.this.n.c();
                    }
                }
            });
            da daVar = this.x;
            if (daVar != null) {
                this.ve.tt(daVar.ve());
                this.ve.a(this.x.n());
                this.ve.c(this.x.a());
                this.ve.tt(this.x.x());
            }
            this.ve.c(this.c);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zm zmVar = this.ve;
        if (zmVar != null) {
            zmVar.tt(this.c);
        }
        try {
            LottieAnimationView lottieAnimationView = this.sp;
            if (lottieAnimationView != null) {
                lottieAnimationView.a();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        zm zmVar = this.ve;
        if (zmVar != null) {
            if (z) {
                zmVar.c(this.c);
            } else {
                zmVar.tt(this.c);
            }
        }
    }
}
