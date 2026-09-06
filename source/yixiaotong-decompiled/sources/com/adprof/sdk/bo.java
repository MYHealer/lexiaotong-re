package com.adprof.sdk;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.hardware.SensorManager;
import android.util.Property;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class bo {
    public static /* synthetic */ Unit a(ao aoVar, Integer num, Integer num2, Integer num3, Long l) {
        if (aoVar == null) {
            return null;
        }
        aoVar.a(num.intValue(), num2.intValue(), num3.intValue(), l.longValue());
        return null;
    }

    public static void a(RelativeLayout relativeLayout, Context context, d dVar, boolean z, final ao aoVar) {
        if (relativeLayout == null) {
            return;
        }
        if (!z) {
            relativeLayout.setVisibility(8);
            return;
        }
        relativeLayout.removeAllViews();
        boolean z2 = false;
        s2 s2Var = new s2(context, null, 0);
        s2Var.setCooldownMs(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        s2Var.setLayoutParams(layoutParams);
        if (dVar != null && dVar.m597a()) {
            z2 = true;
        }
        s2Var.setData(z2);
        s2Var.setCallback(new Function4() { // from class: com.adprof.sdk.bo$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return bo.a(aoVar, (Integer) obj, (Integer) obj2, (Integer) obj3, (Long) obj4);
            }
        });
        relativeLayout.addView(s2Var);
        q2 q2Var = s2Var.f715a;
        if (q2Var != null) {
            try {
                SensorManager sensorManager = q2Var.f653a;
                if (sensorManager != null) {
                    sensorManager.registerListener(q2Var, sensorManager.getDefaultSensor(4), 1);
                }
            } catch (Throwable unused) {
            }
        }
        ObjectAnimator objectAnimator = s2Var.f1411a;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(s2Var.f712a, (Property<ImageView, Float>) RelativeLayout.ROTATION_Y, 0.0f, 180.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            objectAnimatorOfFloat.setRepeatCount(-1);
            objectAnimatorOfFloat.setDuration(1500L);
            objectAnimatorOfFloat.start();
            s2Var.f1411a = objectAnimatorOfFloat;
        }
        s2Var.f717a = true;
        relativeLayout.bringToFront();
    }
}
