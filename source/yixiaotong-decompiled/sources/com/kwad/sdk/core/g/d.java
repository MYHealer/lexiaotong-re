package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.utils.bk;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {
    private static float aYd = 9.81f;
    private static double aYe = 0.05d;
    private float aYc;
    private b aYf;
    private a aYg;
    private boolean enable;
    private boolean bidirectionalSwitch = false;
    private volatile boolean aXN = true;
    private final bk.b aYa = new bk.b() { // from class: com.kwad.sdk.core.g.d.1
        @Override // com.kwad.sdk.utils.bk.b
        public final void onFailed() {
            if (d.this.aYf != null) {
                d.this.aYf.cj();
            }
        }
    };

    public final void a(b bVar) {
        this.aYf = bVar;
    }

    public final void bG(boolean z) {
        this.bidirectionalSwitch = z;
    }

    public final void m(float f) {
        this.aYc = f;
    }

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.aXN = false;
        return false;
    }

    public d(boolean z, float f) {
        this.enable = false;
        this.enable = z;
        if (f <= 0.0f) {
            this.aYc = 5.0f;
        } else {
            this.aYc = f;
        }
    }

    public final void cb(Context context) {
        if (this.enable) {
            if (context == null) {
                com.kwad.sdk.core.d.c.d("ShakeDetector", "startDetect context is null");
                return;
            }
            this.aXN = true;
            if (this.aYg == null) {
                this.aYg = new a();
            }
            bk.Wo().a(1, 2, this.aYg, this.aYa);
        }
    }

    public final synchronized void NJ() {
        this.aXN = true;
    }

    public final synchronized void cc(Context context) {
        if (context != null) {
            if (this.aYg != null) {
                bk.Wo().a(this.aYg);
                this.aYg = null;
            }
        }
    }

    class a implements SensorEventListener {
        private Random aUi;
        private boolean aYj;
        private final float[] aYi = {0.0f, 0.0f, 9.8f};
        private final float[] aYk = {0.0f, 0.0f, 0.0f};
        boolean aXS = false;
        boolean aXT = false;
        boolean aXU = false;
        boolean aYl = false;
        boolean aYm = false;
        boolean aYn = false;
        private int aYo = 0;

        private void NN() {
            this.aXS = false;
            this.aXT = false;
            this.aXU = false;
            this.aYl = false;
            this.aYm = false;
            this.aYn = false;
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        public a() {
            this.aYj = false;
            if (((DevelopMangerComponents) com.kwad.sdk.components.d.f(DevelopMangerComponents.class)) != null) {
                this.aYj = false;
            }
        }

        private void NQ() {
            if (this.aUi == null) {
                this.aUi = new Random();
            }
            if (this.aUi.nextInt(100) == 1) {
                a(this.aYi);
            }
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            a(sensorEvent.values);
            if (this.aYj) {
                NQ();
            }
        }

        private void a(float[] fArr) {
            c(fArr);
            float f = fArr[0];
            boolean zD = true;
            float f2 = fArr[1];
            float f3 = fArr[2];
            double dAbs = Math.abs(Math.sqrt((f * f) + (f2 * f2) + (f3 * f3)));
            if (b(fArr)) {
                dAbs = Math.abs(dAbs - ((double) d.aYd));
            }
            if (d.this.bidirectionalSwitch) {
                dAbs = Math.max(Math.max(Math.abs(f), Math.abs(f2)), Math.abs(f3));
                zD = d(fArr);
            }
            if (!d.this.aXN || !zD || dAbs < d.this.aYc || d.this.aYf == null) {
                return;
            }
            d.a(d.this, false);
            d.this.aYf.a(dAbs);
        }

        private static boolean b(float[] fArr) {
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            return Math.abs(Math.abs(Math.sqrt((double) (((f * f) + (f2 * f2)) + (f3 * f3)))) - ((double) d.aYd)) <= d.aYe;
        }

        private void c(float[] fArr) {
            float[] fArr2 = this.aYk;
            float f = fArr2[0];
            float f2 = (f == 0.0f && fArr2[1] == 0.0f && fArr2[2] == 0.0f) ? 1.0f : 0.6f;
            float f3 = 1.0f - f2;
            fArr[0] = (fArr[0] * f2) + (f * f3);
            fArr[1] = (fArr[1] * f2) + (fArr2[1] * f3);
            fArr[2] = (f2 * fArr[2]) + (f3 * fArr2[2]);
            System.arraycopy(fArr, 0, fArr2, 0, 3);
        }

        private boolean d(float[] fArr) {
            float f = fArr[0];
            if (f > 0.0f && !this.aXS) {
                this.aXS = n(f);
            } else if (f < 0.0f && !this.aYl) {
                this.aYl = n(f);
            }
            float f2 = fArr[1];
            if (f2 > 0.0f && !this.aXT) {
                this.aXT = n(f2);
            } else if (f2 < 0.0f && !this.aYm) {
                this.aYm = n(f2);
            }
            float f3 = fArr[2];
            if (f3 > 0.0f && !this.aXU) {
                this.aXU = n(f3);
            } else if (f3 < 0.0f && !this.aYn) {
                this.aYn = n(f3);
            }
            boolean z = this.aXS && this.aYl;
            boolean z2 = this.aXT && this.aYm;
            boolean z3 = this.aXU && this.aYn;
            if (z || z2 || z3) {
                this.aYo++;
                NN();
            }
            if (this.aYo <= 2) {
                return false;
            }
            this.aYo = 0;
            return true;
        }

        private boolean n(float f) {
            return Math.abs(f) >= d.this.aYc && ((double) Math.abs(f - d.aYd)) >= d.aYe;
        }
    }
}
