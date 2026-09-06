package com.miui.zeus.mimo.sdk.view.component;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.b8;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.c8;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.d8;
import com.miui.zeus.mimo.sdk.download.AutoDownloadController;
import com.miui.zeus.mimo.sdk.e8;
import com.miui.zeus.mimo.sdk.f8;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.g8;
import com.miui.zeus.mimo.sdk.o;
import com.miui.zeus.mimo.sdk.view.LightningView;
import com.miui.zeus.mimo.sdk.y8;
import com.miui.zeus.mimo.sdk.z7;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DownloadButtonICP extends z7 {
    public ProgressBar k;
    public TextView l;
    public ImageView m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public float s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public int x;
    public LightningView y;
    public ValueAnimator z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DownloadButtonICP downloadButtonICP = DownloadButtonICP.this;
            AutoDownloadController autoDownloadController = downloadButtonICP.e;
            if (autoDownloadController != null) {
                autoDownloadController.a();
            }
            MimoAdInfo mimoAdInfo = downloadButtonICP.f5761a;
            if (mimoAdInfo != null) {
                mimoAdInfo.S = false;
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadButtonICP downloadButtonICP = DownloadButtonICP.this;
            MimoAdInfo mimoAdInfo = downloadButtonICP.f5761a;
            if (mimoAdInfo != null) {
                mimoAdInfo.S = false;
                downloadButtonICP.setEnabled(true);
                DownloadButtonICP downloadButtonICP2 = DownloadButtonICP.this;
                TextView textView = downloadButtonICP2.l;
                boolean z = downloadButtonICP2.b;
                MimoAdInfo mimoAdInfo2 = downloadButtonICP2.f5761a;
                textView.setText(z ? mimoAdInfo2.q() : mimoAdInfo2.g());
                DownloadButtonICP downloadButtonICP3 = DownloadButtonICP.this;
                downloadButtonICP3.l.setTextColor(downloadButtonICP3.q);
                DownloadButtonICP.this.m.setVisibility(8);
                DownloadButtonICP.this.k.setVisibility(8);
                DownloadButtonICP.this.k();
            }
        }
    }

    public DownloadButtonICP(Context context) {
        this(context, null);
    }

    public DownloadButtonICP(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadButtonICP(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = a0.H2;
        this.o = a0.H;
        this.p = a0.Z3;
        this.q = -1;
        this.r = -15891201;
        this.s = 14.0f;
        this.t = true;
        this.u = 38;
        this.v = 22;
        this.w = 0;
        a(context, attributeSet);
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void a(int i) {
        j();
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public boolean a() {
        MimoAdInfo mimoAdInfo;
        String string = this.l.getText().toString();
        if (com.miui.zeus.mimo.sdk.b.g(string) || (mimoAdInfo = this.f5761a) == null) {
            return false;
        }
        if (string.equals(mimoAdInfo.g()) || string.equals(this.f5761a.l()) || string.equals(this.f5761a.i()) || string.equals(this.f5761a.m()) || string.equals(this.f5761a.q()) || string.equals(s.d(new byte[]{-124, -126, -109, -48, -117, -102}, "c94707"))) {
            return true;
        }
        o oVarB = com.miui.zeus.mimo.sdk.s.a().b(this.f5761a.C);
        if (oVarB == null || oVarB.b != 3) {
            return false;
        }
        return string.contains(s.d(new byte[]{Ascii.DC4}, "1d0865"));
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void b() {
        ValueAnimator valueAnimator;
        super.b();
        l();
        ValueAnimator valueAnimator2 = this.z;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.z.removeAllUpdateListeners();
            this.z = null;
        }
        LightningView lightningView = this.y;
        if (lightningView != null) {
            if (lightningView.g && (valueAnimator = lightningView.l) != null) {
                lightningView.g = false;
                valueAnimator.cancel();
                lightningView.invalidate();
            }
            this.y.setVisibility(8);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void b(int i) {
        j();
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void c() {
        if (this.f5761a != null) {
            this.l.setText(getBtnInitText());
            this.l.setTextColor(this.q);
            this.m.setVisibility(8);
            this.k.setVisibility(8);
            setEnabled(true);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void c(int i) {
        y8.b.post(new b8(this));
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void d() {
        j();
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void d(int i) {
        y8.b.post(new c8(this, i));
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void e() {
        y8.b.post(new e8(this));
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void f() {
        j();
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void g() {
        y8.b.post(new d8(this));
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public String getBtnText() {
        TextView textView = this.l;
        if (textView != null) {
            return textView.getText().toString();
        }
        return null;
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public ClickAreaType getClickAreaType() {
        return this.h;
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void h() {
        k();
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void i() {
        l();
    }

    public final void j() {
        if (this.f5761a != null) {
            com.miui.zeus.mimo.sdk.s sVarA = com.miui.zeus.mimo.sdk.s.a();
            sVarA.b.remove(this.f5761a.C);
        }
        y8.b.post(new b());
    }

    public final void k() {
        ValueAnimator valueAnimator;
        MimoAdInfo mimoAdInfo = this.f5761a;
        if (mimoAdInfo == null || com.miui.zeus.mimo.sdk.b.g(mimoAdInfo.b1) || com.miui.zeus.mimo.sdk.b.a(this.f5761a.b1, s.d(new byte[]{86, 84, 0, 88, 68, 88, Ascii.NAK}, "21f914"))) {
            return;
        }
        if (this.z == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.z = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(500L);
            this.z.addUpdateListener(new f8(this));
            this.z.addListener(new g8(this));
            this.z.setRepeatMode(2);
            this.z.setRepeatCount(-1);
        }
        ValueAnimator valueAnimator2 = this.z;
        if (valueAnimator2 != null) {
            valueAnimator2.start();
        }
        LightningView lightningView = this.y;
        if (lightningView != null) {
            if (!lightningView.g && (valueAnimator = lightningView.l) != null) {
                lightningView.g = true;
                valueAnimator.setRepeatMode(1);
                lightningView.l.setRepeatCount(-1);
                lightningView.l.start();
            }
            this.y.setVisibility(0);
        }
    }

    public final void l() {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.z;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        LightningView lightningView = this.y;
        if (lightningView != null) {
            if (lightningView.g && (valueAnimator = lightningView.l) != null) {
                lightningView.g = false;
                valueAnimator.cancel();
                lightningView.invalidate();
            }
            this.y.setVisibility(8);
        }
    }

    public void setBackgroundDrawable(int i) {
        this.n = i;
        setBackgroundResource(i);
    }

    public void setCloseDrawable(int i) {
        this.p = i;
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void setDownloadTextColor(int i) {
        this.r = i;
    }

    public void setProgressDrawable(int i) {
        this.o = i;
        ProgressBar progressBar = this.k;
        if (progressBar != null) {
            progressBar.setProgressDrawable(getContext().getResources().getDrawable(this.o));
        }
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void setText(CharSequence charSequence) {
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.z7
    public void setTextColor(int i) {
        this.q = i;
        TextView textView = this.l;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a0.Q3);
                this.n = typedArrayObtainStyledAttributes.getResourceId(a0.y3, a0.H2);
                this.o = typedArrayObtainStyledAttributes.getResourceId(a0.E4, a0.H);
                this.q = typedArrayObtainStyledAttributes.getColor(a0.g3, this.q);
                this.r = typedArrayObtainStyledAttributes.getColor(a0.I4, this.r);
                this.p = typedArrayObtainStyledAttributes.getResourceId(a0.f4, a0.Z3);
                this.t = typedArrayObtainStyledAttributes.getBoolean(a0.c4, this.t);
                this.u = typedArrayObtainStyledAttributes.getInt(a0.q5, this.u);
                this.v = typedArrayObtainStyledAttributes.getInt(a0.m1, this.v);
                this.s = typedArrayObtainStyledAttributes.getDimension(a0.J, f9.a(getContext(), 14.0f));
                this.w = typedArrayObtainStyledAttributes.getInt(a0.p0, 0);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Exception unused) {
            }
        }
        int i = f9.f5428a;
        this.x = Math.round(context.getResources().getDisplayMetrics().density * 72.5f);
        LayoutInflater.from(getContext()).inflate(a0.E2, (ViewGroup) this, true);
        this.k = (ProgressBar) findViewById(a0.B0);
        this.l = (TextView) findViewById(a0.x);
        this.m = (ImageView) findViewById(a0.c3);
        this.y = (LightningView) findViewById(a0.n0);
        setBackgroundResource(this.n);
        this.k.setProgressDrawable(getContext().getResources().getDrawable(this.o));
        this.l.setTextColor(this.q);
        this.l.setTextSize(0, this.s);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f9.a(getContext(), this.v), f9.a(getContext(), this.v));
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, f9.a(getContext(), 6.0f), 0);
        this.m.setLayoutParams(layoutParams);
        int iA = f9.a(getContext(), 4.0f);
        this.m.setPadding(iA, iA, iA, iA);
        this.m.setImageResource(this.p);
        this.k.setMax(100);
        this.m.setOnClickListener(new a());
        if (this.n == a0.C) {
            this.x = 0;
        }
        this.y.setCornerRadius(this.x);
        this.m.setVisibility(8);
    }
}
