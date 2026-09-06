package com.kuaishou.weapon.p0;

import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4643a = -1;

    public int a() {
        return this.f4643a;
    }

    public String a(Context context) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return bg.b;
            }
            int streamMaxVolume = audioManager.getStreamMaxVolume(0);
            int streamVolume = audioManager.getStreamVolume(0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", streamMaxVolume + com.huawei.openalliance.ad.constant.x.bQ + streamVolume);
            jSONObject.put("1", audioManager.getStreamMaxVolume(1) + com.huawei.openalliance.ad.constant.x.bQ + audioManager.getStreamVolume(1));
            jSONObject.put("2", audioManager.getStreamMaxVolume(2) + com.huawei.openalliance.ad.constant.x.bQ + audioManager.getStreamVolume(2));
            jSONObject.put("3", audioManager.getStreamMaxVolume(3) + com.huawei.openalliance.ad.constant.x.bQ + audioManager.getStreamVolume(3));
            jSONObject.put("4", audioManager.getStreamMaxVolume(4) + com.huawei.openalliance.ad.constant.x.bQ + audioManager.getStreamVolume(4));
            String string = jSONObject.toString();
            return TextUtils.isEmpty(string) ? bg.c : string;
        } catch (Throwable unused) {
            return bg.d;
        }
    }

    public boolean b(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    public boolean c(Context context) {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (Build.VERSION.SDK_INT >= 28) {
                return keyguardManager.isKeyguardLocked();
            }
            return keyguardManager.inKeyguardRestrictedInputMode();
        } catch (Exception unused) {
            return false;
        }
    }

    public static int d(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean e(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure();
    }

    private boolean g(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.widget.LockPatternUtils");
            return ((Boolean) cls.getMethod("isSecure", new Class[0]).invoke(cls.getConstructor(Context.class).newInstance(context), new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public JSONObject f(Context context) {
        List<Sensor> sensorList;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (Sensor sensor : sensorList) {
                jSONObject.put(sensor.getName(), sensor.getVendor());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
