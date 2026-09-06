package com.yfanads.android.adx.interact;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.yfanads.android.utils.YFLog;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: TwistDetector.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class d implements SensorEventListener {
    public long d;
    public final a g;
    public SensorManager h;
    public Sensor i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f9609a = 1.0f;
    public float b = 0.0f;
    public float c = 0.0f;
    public boolean e = true;
    public long f = 0;

    /* JADX INFO: compiled from: TwistDetector.java */
    public interface a {
    }

    public d(com.yfanads.android.adx.interact.a aVar) {
        this.g = aVar;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i;
        if (sensorEvent.sensor.getType() == 11) {
            float[] fArr = new float[9];
            SensorManager.getRotationMatrixFromVector(fArr, sensorEvent.values);
            float[] fArr2 = new float[3];
            SensorManager.getOrientation(fArr, fArr2);
            long jRound = Math.round(Math.toDegrees(fArr2[0]));
            long jRound2 = Math.round(Math.toDegrees(fArr2[1]));
            long jRound3 = Math.round(Math.toDegrees(fArr2[2]));
            if (this.b == 0.0f) {
                this.b = jRound3;
            }
            if (this.c == 0.0f) {
                this.c = jRound;
            }
            if (this.d == 0) {
                this.d = jRound3;
            }
            double dAbs = Math.abs(Math.abs(this.b) - Math.abs(jRound3));
            int i2 = this.f9609a == 0.1f ? 10 : 50;
            if (this.f == 0) {
                this.f = System.currentTimeMillis();
            }
            if (System.currentTimeMillis() - this.f > 50) {
                this.f = System.currentTimeMillis();
                if (Math.abs(this.d - jRound3) > 100 || Math.abs(this.c - jRound) > 20.0f) {
                    this.e = false;
                }
                this.c = jRound;
                this.d = jRound3;
                if (dAbs > i2 * this.f9609a) {
                    if (this.e) {
                        float f = jRound3;
                        if (f < 0.0f) {
                            i = 0;
                        } else {
                            i = f > 0.0f ? 1 : -1;
                        }
                        ThreadPoolExecutor threadPoolExecutor = com.yfanads.android.adx.utils.b.f9622a;
                        String[] strArr = new String[6];
                        try {
                            strArr[0] = String.valueOf(new Random().nextInt(2201) + 800);
                            strArr[1] = String.valueOf((int) jRound2);
                            strArr[2] = String.valueOf((int) jRound3);
                            strArr[3] = String.valueOf((int) jRound);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.yfanads.android.adx.interact.a aVar = (com.yfanads.android.adx.interact.a) this.g;
                        aVar.getClass();
                        com.yfanads.android.adx.utils.a.a("action hearTwist " + i);
                        aVar.a(i, 2, strArr);
                    }
                    this.b = jRound3;
                    this.e = true;
                }
            }
        }
    }

    public final boolean a(SensorManager sensorManager) {
        if (this.i == null) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(11);
            this.i = defaultSensor;
            if (defaultSensor != null) {
                this.h = sensorManager;
                sensorManager.registerListener(this, defaultSensor, 0);
            } else {
                YFLog.error("Device does not support TYPE_ROTATION_VECTOR sensor");
            }
            if (this.i == null) {
                return false;
            }
        }
        return true;
    }

    public final void a() {
        Sensor sensor = this.i;
        if (sensor != null) {
            SensorManager sensorManager = this.h;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this, sensor);
            }
            this.h = null;
            this.i = null;
        }
    }
}
