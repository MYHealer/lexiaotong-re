package com.ubixnow.ooooo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOO0000 implements SensorEventListener {
    public static final int OooO00o = 200;
    public float OooO;
    private Context OooO0O0;
    private SensorManager OooO0OO;
    private Sensor OooO0Oo;
    public float OooO0o;
    public long OooO0o0;
    public float OooO0oO;
    public float OooO0oo;
    private OooO00o OooOO0;

    public interface OooO00o {
        void OooO00o();
    }

    public oOO0000(Context context, float f) {
        this.OooO = 0.5f;
        this.OooO0O0 = context;
        OooO00o();
        this.OooO = f;
    }

    private void OooO00o() {
        SensorManager sensorManager = (SensorManager) this.OooO0O0.getSystemService("sensor");
        this.OooO0OO = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        this.OooO0Oo = defaultSensor;
        this.OooO0OO.registerListener(this, defaultSensor, 1);
    }

    public void OooO00o(OooO00o oooO00o) {
        this.OooOO0 = oooO00o;
    }

    public void OooO0O0() {
        Sensor sensor;
        try {
            SensorManager sensorManager = this.OooO0OO;
            if (sensorManager == null || (sensor = this.OooO0Oo) == null) {
                return;
            }
            sensorManager.unregisterListener(this, sensor);
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.OooO0o0;
        if (j < 200) {
            return;
        }
        this.OooO0o0 = jCurrentTimeMillis;
        float[] fArr = sensorEvent.values;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = f - this.OooO0o;
        float f5 = f2 - this.OooO0oO;
        float f6 = f3 - this.OooO0oo;
        this.OooO0o = f;
        this.OooO0oO = f2;
        this.OooO0oo = f3;
        float fSqrt = (float) ((Math.sqrt(((f4 * f4) + (f5 * f5)) + (f6 * f6)) / j) * 100.0d);
        ooooO000.OooO0O0("------ShakeSensor ", fSqrt + "");
        if (fSqrt > this.OooO) {
            ooooO000.OooO0O0("------ShakeSensor ", "-----触发摇一摇 摇动的值： " + fSqrt + " 服务端设置的值： " + this.OooO);
            OooO00o oooO00o = this.OooOO0;
            if (oooO00o != null) {
                oooO00o.OooO00o();
            }
        }
    }
}
