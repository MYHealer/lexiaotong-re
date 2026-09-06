package com.kwad.components.offline.api.core.api;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface ISensorManagerProxy {
    @Deprecated
    SensorManager checkAndObtainSensorManager(Context context);

    Sensor getDefaultSensor(Context context, int i);

    boolean registerListener(Context context, SensorEventListener sensorEventListener, Sensor sensor, int i);

    void unregisterListener(SensorEventListener sensorEventListener);
}
