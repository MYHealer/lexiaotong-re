package com.opos.mobad.template.a;

import android.animation.FloatEvaluator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e implements TypeEvaluator<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TimeInterpolator f7409a;
    private FloatEvaluator b = new FloatEvaluator();
    private float c;
    private float d;

    public e(TimeInterpolator timeInterpolator, float f, float f2) {
        this.f7409a = timeInterpolator;
        this.c = f;
        this.d = f2;
    }

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float evaluate(float f, Float f2, Float f3) {
        return this.b.evaluate(this.f7409a.getInterpolation(f), (Number) Float.valueOf(this.c), (Number) Float.valueOf(this.d));
    }
}
