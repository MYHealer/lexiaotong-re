package com.adprof.sdk;

import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class k6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1261a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f420a;
    public int b;
    public int c;
    public int d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f418a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Random f419a = new Random();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f417a = new Runnable() { // from class: com.adprof.sdk.k6$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.c();
        }
    };
    public int e = 14;

    public k6(View view) {
        if (view == null) {
            throw new IllegalArgumentException("host");
        }
        this.f416a = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        try {
            for (j6 j6Var : this.f418a) {
                j6Var.f391a.setX(j6Var.f1244a);
                j6Var.f391a.setY(j6Var.b);
            }
            this.f420a = true;
            this.f416a.removeCallbacks(this.f417a);
            this.f416a.postDelayed(this.f417a, this.e);
        } catch (Throwable th) {
            pk.a(th);
        }
    }

    public List a() {
        try {
            try {
                this.f420a = false;
                this.f416a.removeCallbacks(this.f417a);
            } catch (Throwable th) {
                pk.a(th);
            }
            if (this.f418a.isEmpty()) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(this.f418a.size());
            Iterator it = this.f418a.iterator();
            while (it.hasNext()) {
                View view = ((j6) it.next()).f391a;
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.f418a.clear();
            return arrayList;
        } catch (Throwable th2) {
            pk.a(th2);
            return new ArrayList();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m668a() {
        this.f416a.post(new Runnable() { // from class: com.adprof.sdk.k6$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b();
            }
        });
    }

    public final void c() {
        float f;
        try {
            if (this.f420a) {
                int size = this.f418a.size();
                int i = 0;
                if (size == 0) {
                    this.f420a = false;
                    return;
                }
                int i2 = this.b;
                int iMax = Math.max(0, this.f1261a - i2);
                int i3 = this.c;
                int i4 = this.d;
                float f2 = i2 + i4;
                float f3 = i4;
                int i5 = 0;
                while (true) {
                    f = 0.5f;
                    if (i5 >= size) {
                        break;
                    }
                    j6 j6Var = (j6) this.f418a.get(i5);
                    j6Var.c += (this.f419a.nextFloat() - 0.5f) * 1.05f;
                    float fNextFloat = j6Var.d + ((this.f419a.nextFloat() - 0.5f) * 1.05f);
                    j6Var.d = fNextFloat;
                    float f4 = j6Var.c * 0.997f;
                    j6Var.c = f4;
                    float f5 = fNextFloat * 0.997f;
                    j6Var.d = f5;
                    if (f4 > 7.2f) {
                        j6Var.c = 7.2f;
                    } else if (f4 < -7.2f) {
                        j6Var.c = -7.2f;
                    }
                    if (f5 > 7.2f) {
                        j6Var.d = 7.2f;
                    } else if (f5 < -7.2f) {
                        j6Var.d = -7.2f;
                    }
                    j6Var.f1244a += j6Var.c;
                    j6Var.b += j6Var.d;
                    i5++;
                }
                for (int i6 = 0; i6 < size; i6++) {
                    j6 j6Var2 = (j6) this.f418a.get(i6);
                    if (j6Var2.f1244a < 0.0f) {
                        j6Var2.f1244a = 0.0f;
                        j6Var2.c = Math.abs(j6Var2.c) * 0.62f;
                    }
                    if (j6Var2.b < 0.0f) {
                        j6Var2.b = 0.0f;
                        j6Var2.d = Math.abs(j6Var2.d) * 0.62f;
                    }
                    float f6 = iMax;
                    if (j6Var2.f1244a > f6) {
                        j6Var2.f1244a = f6;
                        j6Var2.c = (-Math.abs(j6Var2.c)) * 0.62f;
                    }
                    float f7 = i3;
                    if (j6Var2.b > f7) {
                        j6Var2.b = f7;
                        j6Var2.d = (-Math.abs(j6Var2.d)) * 0.62f;
                    }
                }
                int i7 = 0;
                while (i7 < 5) {
                    int i8 = i;
                    while (i8 < size) {
                        int i9 = i8 + 1;
                        int i10 = i9;
                        while (i10 < size) {
                            j6 j6Var3 = (j6) this.f418a.get(i8);
                            j6 j6Var4 = (j6) this.f418a.get(i10);
                            float f8 = i2 * f;
                            float f9 = j6Var3.f1244a + f8;
                            float f10 = j6Var3.b + f8;
                            int i11 = i2;
                            float f11 = f3;
                            float f12 = f9 - (j6Var4.f1244a + f8);
                            float f13 = f10 - (j6Var4.b + f8);
                            int i12 = i8;
                            float f14 = f12;
                            float fHypot = (float) Math.hypot(f12, f13);
                            if (fHypot < 0.01f) {
                                fHypot = 0.01f;
                                f14 = f11;
                                f13 = 0.0f;
                            }
                            if (fHypot < f2) {
                                float f15 = (f2 - fHypot) * 0.51f;
                                float f16 = (f14 / fHypot) * f15;
                                j6Var3.f1244a += f16;
                                float f17 = (f13 / fHypot) * f15;
                                j6Var3.b += f17;
                                j6Var4.f1244a -= f16;
                                j6Var4.b -= f17;
                            }
                            i10++;
                            i2 = i11;
                            f3 = f11;
                            i8 = i12;
                            f = 0.5f;
                        }
                        i8 = i9;
                    }
                    i7++;
                    i = 0;
                    f = 0.5f;
                }
                for (int i13 = 0; i13 < size; i13++) {
                    j6 j6Var5 = (j6) this.f418a.get(i13);
                    if (j6Var5.f1244a < 0.0f) {
                        j6Var5.f1244a = 0.0f;
                    }
                    if (j6Var5.b < 0.0f) {
                        j6Var5.b = 0.0f;
                    }
                    float f18 = iMax;
                    if (j6Var5.f1244a > f18) {
                        j6Var5.f1244a = f18;
                    }
                    float f19 = i3;
                    if (j6Var5.b > f19) {
                        j6Var5.b = f19;
                    }
                    j6Var5.f391a.setX(j6Var5.f1244a);
                    j6Var5.f391a.setY(j6Var5.b);
                }
                if (!this.f420a || this.f418a.isEmpty()) {
                    return;
                }
                this.f416a.postDelayed(this.f417a, this.e);
            }
        } catch (Exception e) {
            pk.a(e);
        }
    }
}
