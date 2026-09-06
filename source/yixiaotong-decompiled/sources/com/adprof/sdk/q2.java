package com.adprof.sdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class q2 implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f1375a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f652a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SensorManager f653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Function4 f654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f655a;
    public long c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f656a = new float[9];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final float[] f657b = new float[3];

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public float[] f658c = new float[3];
    public long b = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;

    public q2(Context context) {
        this.f653a = (SensorManager) context.getSystemService("sensor");
    }

    public final int a(int i) {
        int i2 = i % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        if (i2 < 0) {
            i2 += MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        }
        return i2 > 180 ? i2 - 360 : i2;
    }

    public final void a() {
        long j;
        this.f652a = System.currentTimeMillis();
        int degrees = (int) Math.toDegrees(this.f657b[1] - this.f658c[1]);
        int degrees2 = (int) Math.toDegrees(this.f657b[2] - this.f658c[2]);
        int degrees3 = (int) Math.toDegrees(this.f657b[0] - this.f658c[0]);
        int iA = a(degrees);
        int iA2 = a(degrees2);
        int iA3 = a(degrees3);
        if (pk.f594a) {
            pk.c("handleValidTwist angles: deltaX=" + degrees + " deltaY=" + degrees2 + " deltaZ=" + degrees3 + ", normalized: x=" + iA + " y=" + iA2 + " z=" + iA3);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.c;
        if (j2 > 0) {
            j = jCurrentTimeMillis - j2;
            if (j <= 0) {
                j = 1;
            }
        } else {
            j = 0;
        }
        if (pk.f594a) {
            pk.c("handleValidTwist x=" + iA + " y=" + iA2 + " z=" + iA3 + ", mTwistStartTime=" + this.c + ", currentTime=" + jCurrentTimeMillis + ", twistTime=" + j);
        }
        this.f655a = false;
        this.c = 0L;
        Function4 function4 = this.f654a;
        if (function4 != null) {
            function4.invoke(Integer.valueOf(iA), Integer.valueOf(iA2), Integer.valueOf(iA3), Long.valueOf(j));
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (sensorEvent.values != null && System.currentTimeMillis() - this.f652a >= this.b) {
                    SensorManager.getRotationMatrixFromVector(this.f656a, sensorEvent.values);
                    SensorManager.getOrientation(this.f656a, this.f657b);
                    float[] fArr = this.f658c;
                    if (fArr[0] == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f) {
                        float[] fArr2 = this.f657b;
                        fArr[0] = fArr2[0];
                        fArr[1] = fArr2[1];
                        fArr[2] = fArr2[2];
                    }
                    Math.toDegrees(this.f657b[0]);
                    Math.abs(Math.toDegrees(this.f657b[0]) - Math.toDegrees(this.f658c[0]));
                    float f = this.f657b[0];
                    if (Math.abs(f - this.f1375a) > 1.5f) {
                        if (this.f655a) {
                            a();
                        } else {
                            this.f655a = true;
                            this.c = System.currentTimeMillis();
                            if (pk.f594a) {
                                pk.c("Twist started, mTwistStartTime=" + this.c);
                            }
                        }
                    }
                    this.f1375a = f;
                }
            } catch (Throwable th) {
                pk.a(th);
                oh.b(th);
            }
        }
    }
}
