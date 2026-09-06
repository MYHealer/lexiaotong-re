package com.meishu.sdk.core.utils;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.AdType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ClickUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, Integer> f4907a;
    public static Sensor b;
    public static Sensor c;
    public static Sensor d;
    public static SensorManager e;

    static {
        HashMap map = new HashMap();
        f4907a = map;
        map.put(4, 1);
        map.put(8, 2);
        map.put(64, 4);
        map.put(256, 6);
        map.put(12, 3);
        map.put(72, 5);
        map.put(260, 7);
        map.put(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME), 8);
    }

    public static void a() {
        try {
            int iA = q.a().a("shake_act_type", 0);
            try {
                if (AdSdk.adConfig() != null) {
                    if (AdSdk.adConfig().getDisableSensorTypes() != null && !AdSdk.adConfig().getDisableSensorTypes().isEmpty()) {
                        List<Integer> disableSensorTypes = AdSdk.adConfig().getDisableSensorTypes();
                        if (disableSensorTypes.contains(1) || disableSensorTypes.contains(9)) {
                            d = null;
                            c = null;
                            iA &= -69;
                        } else if ((iA & 4) != 4 || (iA & 64) != 64) {
                            if (e == null) {
                                e = (SensorManager) AdSdk.getContext().getSystemService("sensor");
                            }
                            if (c == null) {
                                c = e.getDefaultSensor(9);
                            }
                            if (d == null) {
                                d = e.getDefaultSensor(1);
                            }
                        }
                        if (disableSensorTypes.contains(4)) {
                            b = null;
                            iA &= -329;
                        } else if ((iA & 8) != 8 || (iA & 256) != 256) {
                            if (e == null) {
                                e = (SensorManager) AdSdk.getContext().getSystemService("sensor");
                            }
                            if (b == null) {
                                b = e.getDefaultSensor(4);
                            }
                        }
                        try {
                            j.c = iA | 163;
                            q.a().b("shake_act_type", iA);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } else {
                        if ((iA & 8) == 8 && (iA & 4) == 4 && (iA & 64) == 64 && (iA & 256) == 256) {
                            return;
                        }
                        if (e == null) {
                            e = (SensorManager) AdSdk.getContext().getSystemService("sensor");
                        }
                        if (c == null) {
                            c = e.getDefaultSensor(9);
                        }
                        if (d == null) {
                            d = e.getDefaultSensor(1);
                        }
                        if (b == null) {
                            b = e.getDefaultSensor(4);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (b != null && c != null && d != null && (iA & 64) != 64) {
                iA |= 64;
                try {
                    j.a(iA);
                    q.a().b("shake_act_type", iA);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (b != null && ((iA & 8) != 8 || (iA & 256) != 256)) {
                iA |= MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME;
                try {
                    j.a(iA);
                    q.a().b("shake_act_type", iA);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
            if (c == null || d == null || (iA & 4) == 4) {
                return;
            }
            int i = iA | 4;
            try {
                j.a(i);
                q.a().b("shake_act_type", i);
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static int b(int i) {
        int i2 = i & MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_REOPEN;
        try {
            int iIntValue = ((Integer) ((HashMap) f4907a).get(Integer.valueOf(i2))).intValue();
            if (iIntValue == 0) {
                return 4;
            }
            return iIntValue;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean c(int i) {
        return d(i) | e(i);
    }

    public static boolean d(int i) {
        return ((i & 68) & j.c) != 0;
    }

    public static boolean e(int i) {
        return ((i & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME) & j.c) != 0;
    }

    public static int a(int i) {
        if (AdSdk.adConfig() == null || AdSdk.adConfig().getDisableSensorTypes() == null || AdSdk.adConfig().getDisableSensorTypes().isEmpty()) {
            return i;
        }
        List<Integer> disableSensorTypes = AdSdk.adConfig().getDisableSensorTypes();
        return (disableSensorTypes.contains(1) || disableSensorTypes.contains(9)) ? i & (-69) : disableSensorTypes.contains(4) ? i & (-329) : i;
    }

    public static int a(int i, int i2) {
        int i3 = j.c;
        if ((i3 & 8) != 8 && (i3 & 256) != 256) {
            i &= -265;
            if (i <= 0) {
                i = 2;
            }
        } else if ((i & 256) == 256 && (i & 8) == 8) {
            i &= -9;
        }
        if ((i3 & 4) != 4 && (i = i & (-69)) <= 0) {
            i = 2;
        }
        if (((AdType.FEED_MIX.value() == i2 ? 1007 : 495) & j.c & i) != 0) {
            return i;
        }
        return 2;
    }
}
