package com.yfanads.android.adx.interact;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.unionpay.tsmservice.data.Constant;
import com.yfanads.android.utils.ScreenUtil;

/* JADX INFO: compiled from: SlideOnTouchListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class c implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f9608a;
    public float b;
    public float c;
    public float d;
    public final String[] e = new String[8];
    public final String[] f = new String[8];
    public a g;

    /* JADX INFO: compiled from: SlideOnTouchListener.java */
    public interface a {
        void a(String[] strArr, String[] strArr2);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            Context context = view.getContext();
            com.yfanads.android.adx.utils.a.a("SlideOnTouchListener ACTION_DOWN ");
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.e[0] = String.valueOf(System.currentTimeMillis());
            this.e[1] = String.valueOf(System.currentTimeMillis());
            this.e[2] = String.valueOf((int) (view.getTop() + x));
            this.e[3] = String.valueOf((int) (view.getLeft() + y));
            this.e[4] = String.valueOf((int) x);
            this.e[5] = String.valueOf((int) y);
            this.e[6] = String.valueOf(ScreenUtil.px2dip(context, x));
            this.e[7] = String.valueOf(ScreenUtil.px2dip(context, y));
            this.f9608a = (int) motionEvent.getRawX();
            this.b = (int) motionEvent.getRawY();
            this.c = 0.0f;
            this.d = 0.0f;
        } else if (motionEvent.getAction() == 2) {
            com.yfanads.android.adx.utils.a.a("SlideOnTouchListener ACTION_MOVE ");
            float rawX = (int) motionEvent.getRawX();
            float rawY = (int) motionEvent.getRawY();
            float f = rawX - this.f9608a;
            float f2 = rawY - this.b;
            this.f9608a = rawX;
            this.b = rawY;
            this.c += f;
            this.d += f2;
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            float f3 = this.c;
            float f4 = this.d;
            double dSqrt = Math.sqrt((f4 * f4) + (f3 * f3));
            Context context2 = view.getContext();
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.f[0] = String.valueOf(System.currentTimeMillis());
            this.f[1] = String.valueOf(System.currentTimeMillis());
            this.f[2] = String.valueOf((int) (view.getTop() + x2));
            this.f[3] = String.valueOf((int) (view.getLeft() + y2));
            this.f[4] = String.valueOf((int) x2);
            this.f[5] = String.valueOf((int) y2);
            this.f[6] = String.valueOf(ScreenUtil.px2dip(context2, x2));
            this.f[7] = String.valueOf(ScreenUtil.px2dip(context2, y2));
            com.yfanads.android.adx.utils.a.a("SlideOnTouchListener Slide ACTION_" + (motionEvent.getAction() == 1 ? Constant.TOKENIZATION_PROVIDER : "CANCEL") + PPSLabelView.Code + dSqrt);
            if (dSqrt > 50.0d && dSqrt <= 100.0d) {
                this.g.a(this.e, this.f);
            } else if ((dSqrt <= 100.0d || dSqrt > 150.0d) && dSqrt <= 150.0d) {
                view.performClick();
            } else {
                this.g.a(this.e, this.f);
            }
        }
        return true;
    }
}
