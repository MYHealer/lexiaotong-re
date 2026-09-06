package com.ubix.ssp.ad.e;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.ad.constant.ai;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i extends RelativeLayout implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8826a;
    private int b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private boolean g;
    private a h;

    public interface a {
        void a();
    }

    public i(Context context) {
        double d;
        super(context);
        this.f8826a = 0;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = false;
        int iH = com.ubix.ssp.ad.e.a0.r.a().h(context);
        int iC = com.ubix.ssp.ad.e.a0.r.a().c(context);
        double dA = com.ubix.ssp.ad.e.a0.r.a().a(context);
        if (iH > iC) {
            this.g = true;
            this.f8826a = (int) (iH * 0.6f);
            d = 54.0d;
        } else {
            this.f8826a = (int) (iH * 0.95f);
            d = 64.0d;
        }
        this.b = (int) (d * dA);
        this.f8826a = Math.min(ai.af, this.f8826a);
        this.c = new ImageView(context);
        this.d = new TextView(context);
        this.e = new TextView(context);
        this.f = new TextView(context);
        this.c.setId(89001);
        this.d.setId(89002);
        this.e.setId(89003);
        this.f.setId(89004);
        setBackground(com.ubix.ssp.ad.e.a0.c.a(context, -1, (int) (dA * 15.0d)));
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.c);
        TextView textView = this.d;
        double d2 = this.b;
        addView(textView, new RelativeLayout.LayoutParams((int) (d2 * 0.8d), (int) (d2 * 0.35d)));
        TextView textView2 = this.e;
        double d3 = this.b;
        addView(textView2, new RelativeLayout.LayoutParams((int) (0.8d * d3), (int) (d3 * 0.35d)));
        addView(this.f);
        setZ(20.0f);
        this.d.setSingleLine();
        this.e.setSingleLine();
        this.d.setTextColor(-16777216);
        this.e.setTextColor(-8158333);
        this.f.setTextColor(-8158333);
        this.d.setTextSize(12.0f);
        this.e.setTextSize(12.0f);
        this.f.setTextSize(9.0f);
        setOnTouchListener(this);
    }

    public void a(Bundle bundle) {
        String string = bundle.getString("DOWNLOAD_APP_NAME", "");
        if (TextUtils.isEmpty(string)) {
            string = bundle.getString("TITLE", "");
        }
        this.d.setText(string);
        String string2 = bundle.getString("SUB_TITLE", "");
        TextView textView = this.e;
        if (TextUtils.isEmpty(string2)) {
            string2 = "精选推荐";
        }
        textView.setText(string2);
        String string3 = bundle.getString("ICON_URL", "");
        this.f.setText("刚刚");
        if (TextUtils.isEmpty(string3)) {
            return;
        }
        com.ubix.ssp.ad.e.v.e.b().a(string3, this.c, 0, null);
    }

    public void a(View view, long j) {
        if (view == null) {
            return;
        }
        try {
            view.setTranslationY(view.getHeight());
            view.setAlpha(0.0f);
            view.setVisibility(0);
            float[] fArr = new float[2];
            fArr[0] = 0.0f;
            fArr[1] = (float) (((double) ((i) view).getTargetHeight()) * (this.g ? 1.6d : 1.4d));
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationY", fArr);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            animatorSet.setDuration(j);
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getTargetHeight() {
        return this.b;
    }

    public int getTargetWidth() {
        return this.f8826a;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            switch (childAt.getId()) {
                case 89001:
                    double d = ((double) this.f8826a) * 0.05d;
                    double d2 = this.b;
                    double d3 = 0.15d * d2;
                    double d4 = d2 * 0.7d;
                    childAt.layout((int) d, (int) d3, (int) (d + d4), (int) (d3 + d4));
                    break;
                case 89002:
                    int right = (int) (((double) findViewById(89001).getRight()) + (((double) this.f8826a) * 0.05d));
                    int i6 = (int) (((double) this.b) * 0.2d);
                    int right2 = findViewById(89001).getRight();
                    int i7 = this.f8826a;
                    double d5 = this.b;
                    childAt.layout(right, i6, (int) ((((double) (right2 + i7)) - (0.8d * d5)) - (((double) i7) * 0.1d)), (int) ((0.2d * d5) + (d5 * 0.35d)));
                    break;
                case 89003:
                    int right3 = (int) (((double) findViewById(89001).getRight()) + (((double) this.f8826a) * 0.05d));
                    int bottom = findViewById(89002).getBottom();
                    int right4 = findViewById(89001).getRight();
                    int i8 = this.f8826a;
                    childAt.layout(right3, bottom, (int) ((((double) (right4 + i8)) - (((double) this.b) * 0.8d)) - (((double) i8) * 0.1d)), (int) (((double) findViewById(89002).getBottom()) + (((double) this.b) * 0.35d)));
                    break;
                case 89004:
                    double d6 = this.f8826a;
                    double d7 = this.b;
                    childAt.layout((int) (0.9d * d6), (int) (0.2d * d7), (int) (d6 * 0.96d), (int) (d7 * 0.45d));
                    break;
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f8826a, this.b);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 1 && action != 3) {
            return true;
        }
        a aVar = this.h;
        if (aVar == null) {
            return false;
        }
        aVar.a();
        return false;
    }

    public void setClickListener(a aVar) {
        this.h = aVar;
    }
}
