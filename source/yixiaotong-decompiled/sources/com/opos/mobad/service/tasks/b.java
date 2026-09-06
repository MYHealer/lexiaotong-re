package com.opos.mobad.service.tasks;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.omes.scorpion.OmasStub;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CountDownLatch f7391a;
    private Map<Integer, float[]> b;

    public Map<Integer, float[]> a(Context context, int[] iArr, int i) {
        return (Map) OmasStub.omasObject(3, new Object[]{this, context, iArr, Integer.valueOf(i)});
    }

    public void a() {
        OmasStub.omasVoid(4, new Object[]{this});
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        OmasStub.omasVoid(5, new Object[]{this, sensor, Integer.valueOf(i)});
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        OmasStub.omasVoid(6, new Object[]{this, sensorEvent});
    }
}
