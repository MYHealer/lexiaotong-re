package com.adprof.sdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class c2 implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b2 f1098a = new b2();
    public static volatile long e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f152a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SensorManager f156a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Function3 f157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f158a;
    public double b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float f159b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f161b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f162b;
    public double c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public float f163c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f164c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f165c;
    public double d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f166d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f167d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public double f151a = 15.0d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f153a = 2;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f160b = 3;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f154a = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;

    public c2(Context context) {
        this.f155a = context;
    }

    public final void a() {
        Vibrator defaultVibrator;
        try {
            Context context = AdprofSdk.getInstance().getContext();
            if (context == null) {
                context = this.f155a;
            }
            if (Build.VERSION.SDK_INT >= 31) {
                VibratorManager vibratorManager = (VibratorManager) context.getSystemService("vibrator_manager");
                defaultVibrator = vibratorManager != null ? vibratorManager.getDefaultVibrator() : null;
            } else {
                defaultVibrator = (Vibrator) context.getSystemService("vibrator");
            }
            if (defaultVibrator == null || !defaultVibrator.hasVibrator()) {
                return;
            }
            pk.d("vibrator >= 26");
            defaultVibrator.vibrate(VibrationEffect.createOneShot(800L, -1));
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    public final void a(float f, float f2, float f3) {
        try {
            if (q1.m710a().f648a > 0) {
                this.f167d = System.currentTimeMillis();
                Function3 function3 = this.f157a;
                if (function3 != null) {
                    if (function3 != null) {
                    }
                    if (this.f158a) {
                        a();
                    }
                }
            }
        } catch (Throwable th) {
            pk.a(th);
        }
    }

    public final void b() {
        try {
            pk.d("mSensorManager---  release");
            this.f162b = false;
            SensorManager sensorManager = this.f156a;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
        } catch (Throwable unused) {
        }
    }

    public final void c() {
        this.f164c = 0;
        this.b = 0.0d;
        this.c = 0.0d;
        this.d = 0.0d;
        this.f152a = 0.0f;
        this.f159b = 0.0f;
        this.f163c = 0.0f;
    }

    public final void d() {
        try {
            SensorManager sensorManager = this.f156a;
            if (sensorManager == null) {
                try {
                    Context context = AdprofSdk.getInstance().getContext();
                    if (context == null) {
                        context = this.f155a;
                    }
                    sensorManager = (SensorManager) context.getSystemService("sensor");
                    this.f156a = sensorManager;
                } catch (Throwable th) {
                    pk.c("AdShakeDetector: Failed to init SensorManager", th);
                    oh.b(th);
                    sensorManager = null;
                }
            }
            if (sensorManager == null) {
                pk.b("AdShakeDetector: SensorManager is null, cannot start");
                return;
            }
            if (this.f162b) {
                return;
            }
            b();
            pk.d("mSensorManager----  start");
            if (sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 2)) {
                this.f162b = true;
            }
        } catch (Throwable th2) {
            pk.a(th2);
            oh.b(th2);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* JADX WARN: Code duplicated, block: B:65:0x012f  */
    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double dSqrt;
        double d;
        double dPow;
        double dPow2;
        boolean z;
        if (this.f161b > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f165c;
            if (jCurrentTimeMillis < this.f161b) {
                if (pk.f594a) {
                    pk.d("AdShakeDetector: In immune period, skipping detection. Time remaining: " + (this.f161b - jCurrentTimeMillis) + "ms");
                    return;
                }
                return;
            } else {
                this.f161b = 0L;
                if (pk.f594a) {
                    pk.d("AdShakeDetector: Immune period ended, detection enabled");
                }
            }
        }
        if (sensorEvent != null) {
            try {
                float[] fArr = sensorEvent.values;
                if (fArr != null && fArr.length >= 3) {
                    if (System.currentTimeMillis() - this.f167d < this.f154a) {
                        return;
                    }
                    float[] fArr2 = sensorEvent.values;
                    float f = fArr2[0];
                    float f2 = fArr2[1];
                    float f3 = fArr2[2];
                    if (f > this.f152a) {
                        this.f152a = f;
                    }
                    if (f2 > this.f159b) {
                        this.f159b = f2;
                    }
                    if (f3 > this.f163c) {
                        this.f163c = f3;
                    }
                    double d2 = ((double) 1) - 0.8d;
                    double dAbs = (((double) Math.abs(f)) * d2) + (this.b * 0.8d);
                    double dAbs2 = (this.c * 0.8d) + (((double) Math.abs(f2)) * d2);
                    double dAbs3 = (this.d * 0.8d) + (d2 * ((double) Math.abs(f3)));
                    this.b = dAbs;
                    this.c = dAbs2;
                    this.d = dAbs3;
                    int i = this.f153a;
                    if (i == 1) {
                        dSqrt = Math.max(Math.max(dAbs, dAbs2), dAbs3);
                    } else {
                        if (i == 2) {
                            d = 2;
                            dPow = Math.pow(dAbs, d) + Math.pow(dAbs2, d);
                        } else if (i == 3) {
                            dSqrt = dAbs;
                        } else if (i == 4) {
                            dSqrt = dAbs2;
                        } else if (i == 5) {
                            dSqrt = dAbs3;
                        } else if (i == 6) {
                            double d3 = 2;
                            dPow = Math.pow(dAbs, d3);
                            dPow2 = Math.pow(dAbs2, d3);
                            dSqrt = Math.sqrt(dPow + dPow2);
                        } else if (i == 7) {
                            d = 2;
                            dPow = Math.pow(dAbs, d);
                        } else if (i == 8) {
                            d = 2;
                            dPow = Math.pow(dAbs2, d);
                        } else {
                            dSqrt = 0.0d;
                        }
                        dPow2 = Math.pow(dAbs3, d);
                        dSqrt = Math.sqrt(dPow + dPow2);
                    }
                    boolean z2 = dSqrt >= this.f151a;
                    if (z2) {
                        z = true;
                        int i2 = this.f164c + 1;
                        this.f164c = i2;
                        if (i2 < this.f160b) {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    if (pk.f594a && z2) {
                        pk.d("shake detection isCompleted: " + z + "  ，   hitCount: " + this.f160b + ':' + this.f164c + ",  threshold: " + this.f151a + ",    mode: " + this.f153a + ",  acc: " + dAbs + " : " + dAbs2 + " : " + dAbs3 + "  :  " + dSqrt + "  ");
                    }
                    if (z) {
                        int i3 = this.f166d;
                        if (i3 == 4 || i3 == 5 || i3 == 2 || f1098a.a()) {
                            float f4 = this.f152a;
                            float f5 = this.f159b;
                            float f6 = this.f163c;
                            a(f4, f5, f6);
                        } else if (pk.f594a) {
                            pk.d("AdShakeDetector: Shake detected but blocked by global lock, resetting detection ----- mAdType = " + this.f166d);
                        }
                        c();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                pk.a(th);
                oh.b(th);
                return;
            }
        }
        if (pk.f594a) {
            StringBuilder sbAppend = new StringBuilder("AdShakeDetector: Invalid SensorEvent, event=").append(sensorEvent).append(", values=").append(sensorEvent.values).append(", size=");
            float[] fArr3 = sensorEvent.values;
            pk.d(sbAppend.append(fArr3 != null ? Integer.valueOf(fArr3.length) : null).toString());
        }
    }

    public final void a(double d, int i, int i2, boolean z, int i3) {
        this.f151a = d;
        if (i2 <= 0) {
            i2 = 2;
        }
        this.f153a = i2;
        this.f160b = i <= 0 ? 3 : i;
        this.f158a = z;
        this.f166d = i3;
        if (pk.f594a) {
            pk.d("shake params Sensitivity=" + d + ", mode=" + this.f153a + ", hitcount=" + i + ", vibrator=" + this.f158a + ", adType=" + l1.a(String.valueOf(this.f166d)));
        }
    }
}
