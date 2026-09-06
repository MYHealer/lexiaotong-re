package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.miui.zeus.mimo.sdk.view.component.ImageICP;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class u7 extends s7 {
    public ImageICP d;
    public ImageICP e;
    public ImageICP f;
    public ImageICP g;
    public ImageICP h;
    public ImageICP i;

    public u7(Context context, int i) {
        super(context, i);
    }

    @Override // com.miui.zeus.mimo.sdk.s7
    public void a(float f) {
        float f2 = 100.0f * f;
        this.d.setTranslationY(f2);
        this.e.setTranslationY(f2);
        float f3 = 20.0f * f;
        this.e.setTranslationX(f3);
        this.f.setTranslationY((-100.0f) * f);
        this.f.setTranslationX((-20.0f) * f);
        this.g.setTranslationY(f3);
        this.h.setTranslationY((-40.0f) * f);
        this.i.setTranslationY(f * 40.0f);
    }

    @Override // com.miui.zeus.mimo.sdk.s7
    public void a(List<ImageICP> list) {
        Context context;
        Context context2;
        float f;
        this.d = new ImageICP(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f9.a(getContext(), 72.0f), f9.a(getContext(), 72.0f));
        layoutParams.topMargin = f9.a(getContext(), 60.0f);
        if (this.c == 1) {
            layoutParams.topMargin = f9.a(getContext(), 38.0f);
        }
        float f2 = 20.0f;
        layoutParams.leftMargin = f9.a(getContext(), 20.0f);
        addView(this.d, layoutParams);
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, 5);
        layoutParams2.addRule(15);
        imageView.setId(a0.S4);
        addView(imageView, layoutParams2);
        this.e = new ImageICP(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(f9.a(getContext(), 96.0f), f9.a(getContext(), 96.0f));
        layoutParams3.leftMargin = f9.a(getContext(), 3.0f);
        layoutParams3.topMargin = f9.a(getContext(), 12.5f);
        layoutParams3.addRule(3, imageView.getId());
        addView(this.e, layoutParams3);
        this.f = new ImageICP(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(f9.a(getContext(), 72.0f), f9.a(getContext(), 72.0f));
        if (this.c == 1) {
            layoutParams4.rightMargin = f9.a(getContext(), 3.0f);
            layoutParams3.bottomMargin = f9.a(getContext(), 12.5f);
        } else {
            layoutParams4.rightMargin = f9.a(getContext(), 16.0f);
        }
        layoutParams4.addRule(11);
        layoutParams4.addRule(2, imageView.getId());
        addView(this.f, layoutParams4);
        this.g = new ImageICP(getContext());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(f9.a(getContext(), 96.0f), f9.a(getContext(), 96.0f));
        if (this.c == 1) {
            layoutParams5.rightMargin = f9.a(getContext(), 20.0f);
            context = getContext();
            f2 = 140.0f;
        } else {
            layoutParams5.rightMargin = f9.a(getContext(), 4.0f);
            context = getContext();
        }
        layoutParams5.bottomMargin = f9.a(context, f2);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        addView(this.g, layoutParams5);
        this.h = new ImageICP(getContext());
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(f9.a(getContext(), 56.0f), f9.a(getContext(), 56.0f));
        layoutParams6.topMargin = f9.a(getContext(), 40.0f);
        if (this.c == 1) {
            layoutParams6.topMargin = f9.a(getContext(), 60.0f);
        }
        layoutParams6.addRule(14);
        addView(this.h, layoutParams6);
        this.i = new ImageICP(getContext());
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(f9.a(getContext(), 56.0f), f9.a(getContext(), 56.0f));
        if (this.c == 1) {
            layoutParams7.topMargin = f9.a(getContext(), 53.0f);
            context2 = getContext();
            f = 32.0f;
        } else {
            layoutParams7.topMargin = f9.a(getContext(), 30.0f);
            context2 = getContext();
            f = 90.0f;
        }
        layoutParams7.rightMargin = f9.a(context2, f);
        layoutParams7.addRule(11);
        addView(this.i, layoutParams7);
        list.add(this.d);
        list.add(this.e);
        list.add(this.f);
        list.add(this.g);
        list.add(this.h);
        list.add(this.i);
    }
}
