package com.opos.cmn.module.ui.b.b;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {
    private static final float c = com.opos.cmn.module.ui.d.a.a(328.0f) * com.opos.cmn.module.ui.d.a.a(220.0f);
    private static final float d = com.opos.cmn.module.ui.d.a.a(50.0f) * com.opos.cmn.module.ui.d.a.a(50.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f6199a;
    private final float b;
    private final PathInterpolator e;
    private final PathInterpolator f;
    private final View g;
    private final int h;
    private ValueAnimator i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private long o;

    public c(View view) {
        this(view, 2);
    }

    private c(View view, int i) {
        this.f6199a = 0.92f;
        this.b = 1.0f;
        this.e = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
        this.j = 1.0f;
        this.k = 1.0f;
        this.l = 0.0f;
        this.m = 0.92f;
        this.n = 0.0f;
        this.o = 340L;
        this.g = view;
        this.h = i;
    }

    private float a(int i, int i2) {
        float f = i * i2;
        float f2 = c;
        float f3 = d;
        float f4 = (((f - f2) * 0.04000002f) / (f2 - f3)) + 0.98f;
        if (f < f3) {
            return 1.0f;
        }
        if (f > f2) {
            return 0.98f;
        }
        return f4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, View view) {
        if (f == view.getAlpha() || this.h == 1) {
            return;
        }
        view.setAlpha(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, View view, float f2) {
        float fMax = Math.max(f2, Math.min(1.0f, f));
        view.setScaleX(fMax);
        view.setScaleY(fMax);
        view.invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:38:0x009a  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:51:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:73:0x010b A[LOOP:0: B:72:0x0109->B:73:0x010b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:76:0x011e  */
    /* JADX WARN: Code duplicated, block: B:77:0x0121  */
    private void a(final boolean z) {
        long j;
        long j2;
        boolean z2;
        float f;
        boolean z3;
        float f2;
        float f3;
        float fA;
        ArrayList arrayList;
        float f4;
        float f5;
        int size;
        PropertyValuesHolder[] propertyValuesHolderArr;
        PathInterpolator pathInterpolator;
        float f6;
        float f7;
        float f8;
        int i = this.h;
        if (i != 0) {
            if (i == 1) {
                j = z ? 200L : this.o;
                if (z) {
                    this.n = 0.0f;
                }
                j2 = j;
                z2 = true;
                f = 0.0f;
                z3 = false;
                f2 = 0.05f;
                f3 = 1.0f;
            } else if (i == 2) {
                f3 = 0.8f;
                j2 = z ? 200L : this.o;
                z3 = true;
                f2 = 1.0f;
                f = 1.0f;
                z2 = false;
            } else if (i != 3) {
                j2 = 0;
            } else {
                j = z ? 200L : this.o;
                if (z) {
                    this.n = 1.0f;
                }
                this.m = a(this.g.getWidth(), this.g.getHeight());
                j2 = j;
                z2 = true;
                f = 1.0f;
                z3 = false;
                f2 = 0.5f;
                f3 = 1.0f;
            }
            fA = a();
            if (fA >= 0.0f && fA <= 1.0f) {
                this.m = fA;
            }
            b();
            arrayList = new ArrayList();
            float[] fArr = new float[2];
            fArr[0] = z ? 1.0f : this.j;
            if (z) {
                f4 = this.m;
            } else {
                f4 = 1.0f;
            }
            fArr[1] = f4;
            arrayList.add(PropertyValuesHolder.ofFloat("scaleHolder", fArr));
            if (z3) {
                float[] fArr2 = new float[2];
                if (z) {
                    f7 = 1.0f;
                } else {
                    f7 = this.k;
                }
                fArr2[0] = f7;
                if (z) {
                    f8 = f3;
                } else {
                    f8 = 1.0f;
                }
                fArr2[1] = f8;
                arrayList.add(PropertyValuesHolder.ofFloat("brightnessHolder", fArr2));
            }
            if (z2) {
                float[] fArr3 = new float[2];
                if (z) {
                    f6 = f;
                } else {
                    f6 = this.n;
                }
                fArr3[0] = f6;
                if (!z) {
                    f2 = f;
                }
                fArr3[1] = f2;
                arrayList.add(PropertyValuesHolder.ofFloat("alphaHolder", fArr3));
            }
            float[] fArr4 = new float[2];
            if (z) {
                f5 = 0.0f;
            } else {
                f5 = this.l;
            }
            fArr4[0] = f5;
            fArr4[1] = z ? 0.12f : 0.0f;
            arrayList.add(PropertyValuesHolder.ofFloat("blackAlphaHolder", fArr4));
            size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (int i2 = 0; i2 < size; i2++) {
                propertyValuesHolderArr[i2] = (PropertyValuesHolder) arrayList.get(i2);
            }
            ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderArr);
            this.i = valueAnimatorOfPropertyValuesHolder;
            if (z) {
                pathInterpolator = this.e;
            } else {
                pathInterpolator = this.f;
            }
            valueAnimatorOfPropertyValuesHolder.setInterpolator(pathInterpolator);
            this.i.setDuration(j2);
            this.i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.cmn.module.ui.b.b.c.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.a(z, animatedFraction);
                    Object animatedValue = valueAnimator.getAnimatedValue("scaleHolder");
                    if (animatedValue instanceof Float) {
                        c.this.j = ((Float) animatedValue).floatValue();
                        c cVar = c.this;
                        cVar.a(cVar.j, c.this.g, c.this.m);
                    }
                    Object animatedValue2 = valueAnimator.getAnimatedValue("brightnessHolder");
                    if (animatedValue2 instanceof Float) {
                        c.this.k = ((Float) animatedValue2).floatValue();
                        c.this.a(animatedFraction);
                    }
                    Object animatedValue3 = valueAnimator.getAnimatedValue("alphaHolder");
                    if (animatedValue3 instanceof Float) {
                        c.this.n = ((Float) animatedValue3).floatValue();
                        c cVar2 = c.this;
                        cVar2.a(cVar2.n, c.this.g);
                    }
                    Object animatedValue4 = valueAnimator.getAnimatedValue("blackAlphaHolder");
                    if (animatedValue4 instanceof Float) {
                        c.this.l = ((Float) animatedValue4).floatValue();
                    }
                }
            });
            this.i.start();
        }
        j = z ? 200L : this.o;
        this.m = a(this.g.getWidth(), this.g.getHeight());
        j2 = j;
        f3 = 1.0f;
        f2 = 1.0f;
        f = 1.0f;
        z3 = false;
        z2 = false;
        fA = a();
        if (fA >= 0.0f) {
            this.m = fA;
        }
        b();
        arrayList = new ArrayList();
        float[] fArr5 = new float[2];
        fArr5[0] = z ? 1.0f : this.j;
        if (z) {
            f4 = this.m;
        } else {
            f4 = 1.0f;
        }
        fArr5[1] = f4;
        arrayList.add(PropertyValuesHolder.ofFloat("scaleHolder", fArr5));
        if (z3) {
            float[] fArr6 = new float[2];
            if (z) {
                f7 = 1.0f;
            } else {
                f7 = this.k;
            }
            fArr6[0] = f7;
            if (z) {
                f8 = f3;
            } else {
                f8 = 1.0f;
            }
            fArr6[1] = f8;
            arrayList.add(PropertyValuesHolder.ofFloat("brightnessHolder", fArr6));
        }
        if (z2) {
            float[] fArr7 = new float[2];
            if (z) {
                f6 = f;
            } else {
                f6 = this.n;
            }
            fArr7[0] = f6;
            if (!z) {
                f2 = f;
            }
            fArr7[1] = f2;
            arrayList.add(PropertyValuesHolder.ofFloat("alphaHolder", fArr7));
        }
        float[] fArr8 = new float[2];
        if (z) {
            f5 = 0.0f;
        } else {
            f5 = this.l;
        }
        fArr8[0] = f5;
        fArr8[1] = z ? 0.12f : 0.0f;
        arrayList.add(PropertyValuesHolder.ofFloat("blackAlphaHolder", fArr8));
        size = arrayList.size();
        propertyValuesHolderArr = new PropertyValuesHolder[size];
        while (i2 < size) {
            propertyValuesHolderArr[i2] = (PropertyValuesHolder) arrayList.get(i2);
        }
        ValueAnimator valueAnimatorOfPropertyValuesHolder2 = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderArr);
        this.i = valueAnimatorOfPropertyValuesHolder2;
        if (z) {
            pathInterpolator = this.e;
        } else {
            pathInterpolator = this.f;
        }
        valueAnimatorOfPropertyValuesHolder2.setInterpolator(pathInterpolator);
        this.i.setDuration(j2);
        this.i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.cmn.module.ui.b.b.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                c.this.a(z, animatedFraction);
                Object animatedValue = valueAnimator.getAnimatedValue("scaleHolder");
                if (animatedValue instanceof Float) {
                    c.this.j = ((Float) animatedValue).floatValue();
                    c cVar = c.this;
                    cVar.a(cVar.j, c.this.g, c.this.m);
                }
                Object animatedValue2 = valueAnimator.getAnimatedValue("brightnessHolder");
                if (animatedValue2 instanceof Float) {
                    c.this.k = ((Float) animatedValue2).floatValue();
                    c.this.a(animatedFraction);
                }
                Object animatedValue3 = valueAnimator.getAnimatedValue("alphaHolder");
                if (animatedValue3 instanceof Float) {
                    c.this.n = ((Float) animatedValue3).floatValue();
                    c cVar2 = c.this;
                    cVar2.a(cVar2.n, c.this.g);
                }
                Object animatedValue4 = valueAnimator.getAnimatedValue("blackAlphaHolder");
                if (animatedValue4 instanceof Float) {
                    c.this.l = ((Float) animatedValue4).floatValue();
                }
            }
        });
        this.i.start();
    }

    private void b() {
        ValueAnimator valueAnimator = this.i;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.i.cancel();
    }

    protected float a() {
        return -1.0f;
    }

    protected void a(float f) {
    }

    public void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            a(true);
        } else if (action == 1 || action == 3) {
            a(false);
        }
    }

    protected void a(boolean z, float f) {
    }
}
