package com.hihonor.adsdk.common.f;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class x implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f3517a = 2.0f;
    private static final float b = 5.0f;
    private static final float c = 5.0f;
    private static final String hnadst = "ShakeUtils";
    private static final int hnadsu = 3;
    private static final int hnadsv = 0;
    private static final int hnadsw = 1;
    private static final int hnadsx = 2;
    private static final int hnadsy = 1000;
    private static final int hnadsz = 180;
    private SensorManager hnadsd;
    private a hnadsk;
    private float hnadsm;
    private float hnadsn;
    private float hnadso;
    private double hnadsa = 15.0d;
    private double hnadsb = 35.0d;
    private double hnadsc = 3.0d;
    private final float[] hnadse = new float[3];
    private final float[] hnadsf = new float[3];
    private final float[] hnadsg = new float[9];
    private final float[] hnadsh = new float[3];
    private boolean hnadsi = false;
    private boolean hnadsj = false;
    private boolean hnadsl = true;
    private boolean hnadsp = true;
    private final float[] hnadsq = new float[3];
    private long hnadsr = -1;
    private boolean hnadss = false;

    public interface a {
        void hnadsa();

        void hnadsa(String str);
    }

    public void hnadsa(double d) {
        this.hnadsa = d;
    }

    public void hnadsa(a aVar) {
        this.hnadsk = aVar;
    }

    public void hnadsa(boolean z) {
        this.hnadsl = z;
    }

    public void hnadsb(double d) {
        this.hnadsb = d;
    }

    public void hnadsc(double d) {
        this.hnadsc = d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadst, (Object) ("onAccuracyChanged#accuracy is " + i));
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!this.hnadsl) {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadst, (Object) "onSensorChanged#startCalculating is false");
            return;
        }
        if (sensorEvent == null) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadst, "onSensorChanged#event is null", new Object[0]);
            return;
        }
        Sensor sensor = sensorEvent.sensor;
        if (sensor == null) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadst, "onSensorChanged#event.sensor is null", new Object[0]);
            return;
        }
        float[] fArr = sensorEvent.values;
        if (fArr == null || fArr.length < 3) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadst, "onSensorChanged#event.values is null, event.values.length less than 3", new Object[0]);
            return;
        }
        int type = sensor.getType();
        if (type == 1) {
            hnadsa(fArr, this.hnadse);
            if (this.hnadsp) {
                hnadsf();
                this.hnadsp = false;
            } else {
                float fAbs = Math.abs(fArr[0] - this.hnadsm);
                float fAbs2 = Math.abs(fArr[1] - this.hnadsn);
                float fAbs3 = Math.abs(fArr[2] - this.hnadso);
                hnadsb(fAbs, fAbs2, fAbs3);
                hnadsf();
                hnadsa(fAbs, fAbs2, fAbs3);
                if (!this.hnadsl) {
                    hnadsb();
                }
            }
            this.hnadsm = fArr[0];
            this.hnadsn = fArr[1];
            this.hnadso = fArr[2];
        }
        if (type == 2) {
            hnadsa(sensorEvent.values, this.hnadsf);
        }
    }

    private void hnadsf() {
        if (this.hnadsj) {
            return;
        }
        float[] fArr = this.hnadse;
        if (fArr[0] != 0.0f) {
            float[] fArr2 = this.hnadsf;
            if (fArr2[0] == 0.0f) {
                return;
            }
            SensorManager.getRotationMatrix(this.hnadsg, null, fArr, fArr2);
            try {
                float[] orientation = SensorManager.getOrientation(this.hnadsg, this.hnadsh);
                float[] fArr3 = this.hnadsq;
                float f = fArr3[0];
                if (f == 0.0f && orientation[0] != 0.0f) {
                    hnadsa(orientation, fArr3);
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "firstOrientationAnglesX:" + this.hnadsq[0] + ", y:" + this.hnadsq[1] + ", z:" + this.hnadsq[2], new Object[0]);
                    return;
                }
                double d = (this.hnadsb * 3.141592653589793d) / 180.0d;
                if (Math.abs(f - orientation[0]) >= d || Math.abs(this.hnadsq[1] - orientation[1]) >= d || Math.abs(this.hnadsq[2] - orientation[2]) >= d) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "The offset angle condition is met,shakeAngle=" + this.hnadsb + ", OrientationAnglesX:" + orientation[0] + ", y:" + orientation[1] + ", z:" + orientation[2], new Object[0]);
                    this.hnadsj = true;
                    hnadsa();
                }
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadst, "updateOrientationAngles error. message is " + e.getMessage(), new Object[0]);
            }
        }
    }

    public void hnadsd() {
        if (this.hnadsd != null) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "register", new Object[0]);
        hnadsb();
        try {
            SensorManager sensorManager = (SensorManager) com.hihonor.adsdk.common.a.hnadsa().hnadsb().getSystemService("sensor");
            this.hnadsd = sensorManager;
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor != null) {
                this.hnadsd.registerListener(this, defaultSensor, 3, 2);
            }
            Sensor defaultSensor2 = this.hnadsd.getDefaultSensor(2);
            if (defaultSensor2 != null) {
                this.hnadsd.registerListener(this, defaultSensor2, 3, 2);
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadst, "register#error: " + e.getMessage(), new Object[0]);
            this.hnadsd = null;
            a aVar = this.hnadsk;
            if (aVar != null) {
                aVar.hnadsa(e.getMessage());
            }
        }
    }

    public void hnadse() {
        if (this.hnadsd == null) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "unregister", new Object[0]);
        this.hnadsd.unregisterListener(this);
        this.hnadsd = null;
    }

    private float hnadsc() {
        float f = (float) (this.hnadsa / 5.0d);
        if (f < 2.0f) {
            return 2.0f;
        }
        return Math.min(f, 5.0f);
    }

    private void hnadsb(float f, float f2, float f3) {
        if (this.hnadsi) {
            return;
        }
        double d = f;
        double d2 = this.hnadsa;
        if (d >= d2 || f2 >= d2 || f3 >= d2) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "Acceleration conditions met, shakeAcc=" + this.hnadsa + ", accChangeX=" + f + ", accChangeY=" + f2 + ", accChangeZ=" + f3, new Object[0]);
            this.hnadsi = true;
            hnadsa();
        }
    }

    private void hnadsa(float f, float f2, float f3) {
        if (this.hnadss) {
            return;
        }
        float fHnadsc = hnadsc();
        if (f >= fHnadsc || f2 >= fHnadsc || f3 >= fHnadsc) {
            if (this.hnadsr == -1) {
                this.hnadsr = System.currentTimeMillis();
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.hnadsr >= this.hnadsc * 1000.0d) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "time condition achieved, shakeDuration=" + this.hnadsc + ", currentTime=" + jCurrentTimeMillis + ", firstShakeTime=" + this.hnadsr, new Object[0]);
                this.hnadss = true;
                hnadsa();
            }
        }
    }

    private void hnadsb() {
        this.hnadsr = -1L;
        this.hnadss = false;
        this.hnadsi = false;
        this.hnadsj = false;
        Arrays.fill(this.hnadsq, 0.0f);
        Arrays.fill(this.hnadsf, 0.0f);
        Arrays.fill(this.hnadse, 0.0f);
        Arrays.fill(this.hnadsg, 0.0f);
        Arrays.fill(this.hnadsh, 0.0f);
        this.hnadsp = true;
    }

    private void hnadsa() {
        if (this.hnadsi && this.hnadss && this.hnadsj) {
            a aVar = this.hnadsk;
            if (aVar != null) {
                aVar.hnadsa();
                com.hihonor.adsdk.common.b.b.hnadsc(hnadst, "Triggered shake", new Object[0]);
            }
            this.hnadsl = false;
        }
    }

    private void hnadsa(float[] fArr, float[] fArr2) {
        if (fArr == null) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadst, "arrayCopy#src is null", new Object[0]);
            return;
        }
        if (fArr2 == null) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadst, "arrayCopy#desc is null", new Object[0]);
            return;
        }
        if (fArr.length != fArr2.length) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadst, "arrayCopy#srtLength != descLength", new Object[0]);
            return;
        }
        try {
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadst, "arrayCopy#error: " + e.getMessage(), new Object[0]);
        }
    }
}
