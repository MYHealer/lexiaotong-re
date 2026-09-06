package com.jd.ad.sdk.bl.dynamicrender;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class ShakeListener implements SensorEventListener, Handler.Callback {
    public SensorManager jad_an;
    public float jad_bo;
    public float[] jad_cp;
    public final float[] jad_dq;
    public boolean jad_er;
    public float jad_fs;
    public List<Long> jad_hu;
    public List<Long> jad_iv;
    public float jad_jt;
    public long jad_jw;
    public long jad_kx;
    public Handler jad_ly;
    public long jad_mz;

    public ShakeListener(Context context) {
        this.jad_bo = 0.0f;
        this.jad_cp = new float[4];
        this.jad_dq = new float[4];
        this.jad_er = false;
        this.jad_fs = 0.0f;
        this.jad_jt = 0.0f;
        this.jad_hu = new ArrayList();
        this.jad_iv = new ArrayList();
        this.jad_jw = 0L;
        this.jad_mz = 0L;
        try {
            this.jad_an = (SensorManager) context.getSystemService("sensor");
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        jad_an();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        if (r0 != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void jad_an() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.jad_mz <= 2000.0d) {
                return;
            }
            this.jad_mz = jCurrentTimeMillis;
            boolean zJad_an = jad_an(this.jad_hu);
            boolean zJad_an2 = jad_an(this.jad_iv);
            float f = this.jad_fs;
            if (f > 0.0f && this.jad_bo > 0.0f) {
                if (zJad_an && zJad_an2) {
                    onShake();
                    jad_dq();
                    return;
                }
                jad_dq();
                return;
            }
            if (f <= 0.0f) {
                if (this.jad_bo > 0.0f) {
                }
                jad_dq();
                return;
            }
            zJad_an = zJad_an2;
        } catch (Exception e) {
            jad_dq();
            e.printStackTrace();
        }
    }

    public final synchronized void jad_bo() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.jad_jt > 0.0f) {
            if (jCurrentTimeMillis - this.jad_jw > 1500.0d) {
                this.jad_hu = new ArrayList();
                this.jad_iv = new ArrayList();
                jad_dq();
            }
            Handler handler = this.jad_ly;
            if (handler == null) {
                if (handler == null) {
                    this.jad_ly = new Handler(Looper.getMainLooper(), this);
                }
                Handler handler2 = this.jad_ly;
                if (handler2 != null) {
                    handler2.sendEmptyMessageDelayed(1, (long) (this.jad_jt * 1000.0f));
                }
            }
        }
        this.jad_jw = jCurrentTimeMillis;
        if (this.jad_hu == null) {
            this.jad_hu = new ArrayList();
        }
        this.jad_hu.add(Long.valueOf(jCurrentTimeMillis));
        if (this.jad_jt == 0.0f) {
            jad_an();
        }
    }

    public final synchronized void jad_cp() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.jad_jt > 0.0f) {
            if (jCurrentTimeMillis - this.jad_kx > 1500.0d) {
                this.jad_iv = new ArrayList();
                this.jad_hu = new ArrayList();
                jad_dq();
            }
            Handler handler = this.jad_ly;
            if (handler == null) {
                if (handler == null) {
                    this.jad_ly = new Handler(Looper.getMainLooper(), this);
                }
                Handler handler2 = this.jad_ly;
                if (handler2 != null) {
                    handler2.sendEmptyMessageDelayed(1, (long) (this.jad_jt * 1000.0f));
                }
            }
        }
        this.jad_kx = jCurrentTimeMillis;
        if (this.jad_iv == null) {
            this.jad_iv = new ArrayList();
        }
        this.jad_iv.add(Long.valueOf(jCurrentTimeMillis));
        if (this.jad_jt == 0.0f) {
            jad_an();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() == 1) {
                if (this.jad_bo > 0.0f) {
                    float[] fArr = sensorEvent.values;
                    if (Math.sqrt(Math.pow(fArr[0], 2.0d) + Math.pow(fArr[1], 2.0d) + Math.pow(fArr[2], 2.0d)) > this.jad_bo) {
                        jad_bo();
                    }
                }
            } else if (sensorEvent.sensor.getType() == 11 && this.jad_fs > 0.0f) {
                float[] fArr2 = sensorEvent.values;
                float[] fArr3 = this.jad_dq;
                System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
                if (this.jad_er) {
                    float[] fArr4 = new float[4];
                    SensorManager.getQuaternionFromVector(fArr4, this.jad_cp);
                    float[] fArr5 = new float[4];
                    SensorManager.getQuaternionFromVector(fArr5, this.jad_dq);
                    float f = fArr4[0];
                    float f2 = fArr5[0];
                    float f3 = fArr4[1];
                    float f4 = fArr5[1];
                    float f5 = fArr4[2];
                    float f6 = fArr5[2];
                    float f7 = fArr4[3];
                    float f8 = fArr5[3];
                    if (this.jad_fs <= Math.toDegrees(Math.acos(Math.min(Math.max((((f7 * f8) + ((f5 * f6) + ((f3 * f4) + (f * f2)))) * (((f7 * f8) + ((f5 * f6) + ((f3 * f4) + (f * f2)))) * 2.0f)) - 1.0f, -1.0d), 1.0d)))) {
                        this.jad_cp = fArr4;
                        jad_cp();
                    }
                } else {
                    float[] fArr6 = this.jad_dq;
                    System.arraycopy(fArr6, 0, this.jad_cp, 0, fArr6.length);
                    this.jad_er = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void onShake();

    public void unregister() {
        jad_dq();
        SensorManager sensorManager = this.jad_an;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public final void jad_dq() {
        Handler handler = this.jad_ly;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.jad_ly = null;
        }
    }

    public void register() {
        try {
            SensorManager sensorManager = this.jad_an;
            if (sensorManager != null) {
                sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 2);
                SensorManager sensorManager2 = this.jad_an;
                sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(11), 3);
            }
        } catch (Exception e) {
            Logger.w("Exception while register shake listener: " + e, new Object[0]);
        }
    }

    public final boolean jad_an(List<Long> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        if (this.jad_jt == 0.0f) {
            return true;
        }
        if (list.size() < 2) {
            return false;
        }
        int size = list.size();
        double dLongValue = list.get(0).longValue();
        int i = size - 1;
        double dLongValue2 = list.get(i).longValue();
        if (dLongValue2 - dLongValue <= 0.0d) {
            return false;
        }
        double d = 0.0d;
        for (int i2 = 1; i2 < size; i2++) {
            double dLongValue3 = list.get(i2).longValue() - list.get(i2 - 1).longValue();
            if (dLongValue3 < 0.0d) {
                return false;
            }
            d += dLongValue3;
        }
        double d2 = i;
        return d / d2 <= ((double) (this.jad_jt * 1000.0f)) / d2 && ((double) System.currentTimeMillis()) - dLongValue2 < 1500.0d;
    }

    public ShakeListener(Context context, float f, float f2, float f3) {
        this.jad_bo = 0.0f;
        this.jad_cp = new float[4];
        this.jad_dq = new float[4];
        this.jad_er = false;
        this.jad_fs = 0.0f;
        this.jad_jt = 0.0f;
        this.jad_hu = new ArrayList();
        this.jad_iv = new ArrayList();
        this.jad_jw = 0L;
        this.jad_mz = 0L;
        try {
            this.jad_an = (SensorManager) context.getSystemService("sensor");
            this.jad_bo = f;
            this.jad_fs = f2;
            this.jad_jt = f3;
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public ShakeListener(Context context, float f, float f2, float f3, boolean z) {
        this.jad_bo = 0.0f;
        this.jad_cp = new float[4];
        this.jad_dq = new float[4];
        this.jad_er = false;
        this.jad_fs = 0.0f;
        this.jad_jt = 0.0f;
        this.jad_hu = new ArrayList();
        this.jad_iv = new ArrayList();
        this.jad_jw = 0L;
        this.jad_mz = 0L;
        try {
            this.jad_an = (SensorManager) context.getSystemService("sensor");
            this.jad_bo = f;
            this.jad_fs = f2;
            this.jad_jt = f3;
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}
