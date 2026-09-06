package com.opos.mobad.template.cmn.cardslideview;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d implements g {
    @Override // com.opos.mobad.template.cmn.cardslideview.g
    public void transformPage(View view, float f, int i) {
        float height;
        if (i != 0) {
            if (f > 0.0f) {
                view.setPivotX(view.getWidth() / 2.0f);
                height = view.getHeight();
            } else {
                view.setPivotX(view.getWidth() / 2.0f);
                view.setPivotY(0.0f);
            }
            float fMin = 1.0f - (Math.min(Math.abs(f), 2.0f) / 2.0f);
            float f2 = (0.2f * fMin) + 0.8f;
            view.setScaleX(f2);
            view.setScaleY(f2);
            view.setAlpha((float) Math.pow(fMin, 0.8d));
        }
        if (f > 0.0f) {
            view.setPivotX(view.getWidth());
        } else {
            view.setPivotX(0.0f);
        }
        height = view.getHeight() / 2.0f;
        view.setPivotY(height);
        float fMin2 = 1.0f - (Math.min(Math.abs(f), 2.0f) / 2.0f);
        float f3 = (0.2f * fMin2) + 0.8f;
        view.setScaleX(f3);
        view.setScaleY(f3);
        view.setAlpha((float) Math.pow(fMin2, 0.8d));
    }
}
