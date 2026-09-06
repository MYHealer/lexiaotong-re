package com.adprof.sdk;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class s2 extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObjectAnimator f1411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RelativeLayout f713a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f714a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public q2 f715a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Function4 f716a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f717a;

    public s2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f713a = relativeLayout;
        relativeLayout.setId(RelativeLayout.generateViewId());
        this.f713a.setBackgroundResource(R.drawable.adprof_icon_shake_bottom);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h8.a(90.0f), h8.a(90.0f));
        layoutParams.addRule(14, -1);
        addView(this.f713a, layoutParams);
        ImageView imageView = new ImageView(context);
        this.f712a = imageView;
        imageView.setImageResource(R.drawable.adprof_icon_rotate_phone);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        this.f713a.addView(this.f712a, layoutParams2);
        TextView textView = new TextView(context);
        this.f714a = textView;
        textView.setTextColor(getResources().getColor(R.color.adprof_color_white));
        this.f714a.setTextSize(16.0f);
        this.f714a.setGravity(17);
        this.f714a.setText("扭一扭打开广告");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(h8.a(8.0f));
        gradientDrawable.setColor(1711276032);
        this.f714a.setBackground(gradientDrawable);
        int iA = h8.a(10.0f);
        int iA2 = h8.a(6.0f);
        this.f714a.setPadding(iA, iA2, iA, iA2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14, -1);
        layoutParams3.topMargin = h8.a(10.0f);
        layoutParams3.addRule(3, this.f713a.getId());
        addView(this.f714a, layoutParams3);
        a();
    }

    public final void a() {
        q2 q2Var = new q2(getContext());
        q2Var.f654a = new r2(this);
        this.f715a = q2Var;
    }

    public final Function4<Integer, Integer, Integer, Long, Unit> getCallback() {
        return this.f716a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f1411a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        q2 q2Var = this.f715a;
        if (q2Var != null) {
            try {
                SensorManager sensorManager = q2Var.f653a;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(q2Var);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f717a) {
            try {
                if (z) {
                    q2 q2Var = this.f715a;
                    if (q2Var == null) {
                        return;
                    }
                    SensorManager sensorManager = q2Var.f653a;
                    if (sensorManager != null) {
                        sensorManager.registerListener(q2Var, sensorManager.getDefaultSensor(4), 1);
                    }
                } else {
                    q2 q2Var2 = this.f715a;
                    if (q2Var2 == null) {
                        return;
                    }
                    SensorManager sensorManager2 = q2Var2.f653a;
                    if (sensorManager2 != null) {
                        sensorManager2.unregisterListener(q2Var2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void setCallback(Function4<? super Integer, ? super Integer, ? super Integer, ? super Long, Unit> function4) {
        this.f716a = function4;
    }

    public final void setCooldownMs(long j) {
        q2 q2Var = this.f715a;
        if (q2Var != null) {
            if (j < 0) {
                j = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            }
            q2Var.b = j;
        }
    }

    public final void setData(boolean z) {
        this.f714a.setText("扭一扭打开广告");
    }

    public final void setTextColor(int i) {
        this.f714a.setTextColor(i);
    }
}
