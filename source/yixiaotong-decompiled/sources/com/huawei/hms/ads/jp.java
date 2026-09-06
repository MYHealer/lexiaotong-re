package com.huawei.hms.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jp implements SensorEventListener {
    private static final String Code = "PhoneAccelerometerDetec";
    private static final float V = 9.80665f;
    private a B;
    private SensorManager I;
    private Sensor Z;

    public interface a {
        void Code(float f, float f2, float f3);
    }

    public jp(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.I = sensorManager;
        this.Z = sensorManager.getDefaultSensor(1);
    }

    public void Code() {
        Sensor sensor = this.Z;
        if (sensor != null) {
            try {
                this.I.registerListener(this, sensor, 2);
            } catch (Throwable th) {
                fh.I(Code, "registerListener exception: %s", th.getClass().getSimpleName());
            }
        }
    }

    public void Code(a aVar) {
        this.B = aVar;
    }

    public void V() {
        try {
            this.I.unregisterListener(this, this.Z);
            this.B = null;
        } catch (Throwable th) {
            fh.I(Code, "unregister err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (1 == sensorEvent.sensor.getType()) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            if (fh.Code()) {
                fh.Code(Code, "onSensorChanged x: %s, y: %s, z: %s", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
            }
            a aVar = this.B;
            if (aVar != null) {
                aVar.Code(f, f2, f3);
            }
        }
    }
}
