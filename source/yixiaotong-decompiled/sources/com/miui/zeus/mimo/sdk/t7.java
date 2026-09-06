package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.widget.RelativeLayout;
import com.miui.zeus.mimo.sdk.view.component.ImageICP;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class t7 extends s7 {
    public ImageICP d;
    public ImageICP e;
    public ImageICP f;
    public ImageICP g;

    public t7(Context context) {
        super(context, 1);
    }

    @Override // com.miui.zeus.mimo.sdk.s7
    public void a(float f) {
        float f2 = 100.0f * f;
        this.d.setTranslationY(f2);
        this.e.setTranslationY(f2);
        float f3 = 20.0f * f;
        this.e.setTranslationX(f3);
        this.f.setTranslationY(f3);
        this.g.setTranslationY(f * 40.0f);
    }

    @Override // com.miui.zeus.mimo.sdk.s7
    public void a(List<ImageICP> list) {
        this.d = new ImageICP(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f9.a(getContext(), 56.0f), f9.a(getContext(), 56.0f));
        layoutParams.topMargin = f9.a(getContext(), 1.0f);
        layoutParams.leftMargin = f9.a(getContext(), 6.0f);
        addView(this.d, layoutParams);
        ImageICP imageICP = new ImageICP(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, 5);
        layoutParams2.addRule(15);
        imageICP.setId(a0.S4);
        addView(imageICP, layoutParams2);
        this.e = new ImageICP(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(f9.a(getContext(), 72.0f), f9.a(getContext(), 72.0f));
        layoutParams3.leftMargin = f9.a(getContext(), 3.0f);
        layoutParams3.topMargin = f9.a(getContext(), 12.5f);
        layoutParams3.addRule(3, imageICP.getId());
        addView(this.e, layoutParams3);
        this.f = new ImageICP(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(f9.a(getContext(), 72.0f), f9.a(getContext(), 72.0f));
        layoutParams4.rightMargin = f9.a(getContext(), 13.0f);
        layoutParams4.bottomMargin = f9.a(getContext(), 5.0f);
        layoutParams4.addRule(12);
        layoutParams4.addRule(11);
        addView(this.f, layoutParams4);
        this.g = new ImageICP(getContext());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(f9.a(getContext(), 56.0f), f9.a(getContext(), 56.0f));
        layoutParams5.topMargin = f9.a(getContext(), 12.0f);
        layoutParams5.rightMargin = f9.a(getContext(), 13.0f);
        layoutParams5.addRule(11);
        addView(this.g, layoutParams5);
        list.add(this.d);
        list.add(this.e);
        list.add(this.f);
        list.add(this.g);
    }
}
