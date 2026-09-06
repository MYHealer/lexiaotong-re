package com.opos.mobad.template.a;

import android.animation.TypeEvaluator;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d<T> implements TypeEvaluator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7407a = 0;
    private int c = 0;
    private List<a<T>> b = new ArrayList();

    private static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f7408a;
        private TypeEvaluator<T> b;
        private long c;

        public a(TypeEvaluator<T> typeEvaluator, long j, long j2) {
            this.f7408a = j;
            this.b = typeEvaluator;
            this.c = j2;
        }
    }

    private a a(float f) {
        float f2 = this.f7407a * f;
        for (int i = this.c; i < this.b.size(); i++) {
            a<T> aVar = this.b.get(i);
            if (f2 >= ((a) aVar).c && f2 <= ((a) aVar).f7408a + ((a) aVar).c) {
                this.c = i;
                return aVar;
            }
        }
        if (this.c <= 0) {
            return null;
        }
        this.c = 0;
        return a(f);
    }

    public long a() {
        return this.f7407a;
    }

    public d a(TypeEvaluator<T> typeEvaluator, long j) {
        if (j > 0 && typeEvaluator != null) {
            this.b.add(new a<>(typeEvaluator, j, this.f7407a));
            this.f7407a += j;
        }
        return this;
    }

    @Override // android.animation.TypeEvaluator
    public T evaluate(float f, T t, T t2) {
        List<a<T>> list = this.b;
        if (list == null || list.isEmpty()) {
            return null;
        }
        a aVarA = a(f);
        if (aVarA == null) {
            Log.d("", "null node:" + f);
            return t2;
        }
        return (T) aVarA.b.evaluate((float) (((((double) f) * this.f7407a) - aVarA.c) / aVarA.f7408a), t, t2);
    }
}
