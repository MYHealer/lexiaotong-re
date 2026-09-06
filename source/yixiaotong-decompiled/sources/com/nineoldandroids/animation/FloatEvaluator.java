package com.nineoldandroids.animation;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class FloatEvaluator implements TypeEvaluator<Number> {
    @Override // com.nineoldandroids.animation.TypeEvaluator
    public Float evaluate(float f, Number number, Number number2) {
        float fFloatValue = number.floatValue();
        return Float.valueOf(fFloatValue + (f * (number2.floatValue() - fFloatValue)));
    }
}
