package com.byazt.bt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.byazt.dna.qp;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 274, 2484})
public class DeviceInfoUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile BroadcastReceiver f2012a = null;
    public static volatile int c = -1;
    public static volatile String da = null;
    public static volatile String i = null;
    public static volatile boolean n = true;
    public static volatile long nu;
    public static volatile long sl;
    public static volatile BroadcastReceiver sp;
    public static volatile long t;
    public static volatile boolean tt;
    public static volatile boolean uj;
    public static volatile boolean ve;
    public static volatile ContentObserver x;
    public static AtomicInteger u = new AtomicInteger(-1);
    public static AtomicBoolean yp = new AtomicBoolean(false);
    public static volatile long z = System.currentTimeMillis();
    public static volatile float m = -2.0f;
    public static long rh = 0;

    public static long tt() {
        return z;
    }

    public static int c() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    @com.byazt.zqa.c(c = {0, 1, 274, 1895})
    public static class c implements com.byazt.fn.ve {
        public com.byazt.lz.ve c;

        public c(com.byazt.lz.ve veVar) {
            this.c = veVar;
        }

        @Override // com.byazt.fn.ve
        public void onNetworkChanged(Context context, Intent intent, boolean z, int i) {
            if (DeviceInfoUtils.u.get() == i) {
                return;
            }
            com.byazt.eq.c.mIsNeedUpdateIp.set(true);
            DeviceInfoUtils.u.set(i);
            tt.c.set(true);
            DeviceInfoUtils.yp.set(true);
            com.byazt.dna.n nVar = (com.byazt.dna.n) com.byazt.ut.uj.getService("armor_service");
            if (this.c.uj()) {
                return;
            }
            nVar.updateNetworkStatus(i);
        }
    }

    public static int c(Context context, boolean z2, com.byazt.dna.c cVar, int i2) {
        if (c != -1) {
            return c;
        }
        if (z2) {
            String strC = x.c("dev06", 2592000000L, cVar);
            try {
                if (!TextUtils.isEmpty(strC)) {
                    c = Integer.parseInt(strC);
                }
            } catch (Exception unused) {
            }
            if (c != -1) {
                return c;
            }
        }
        if (tt(context)) {
            c = 3;
        } else if (c(context)) {
            c = 2;
        } else {
            c = 1;
        }
        if (z2) {
            x.c("dev06", String.valueOf(c), cVar, i2);
        }
        return c;
    }

    public static boolean c(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean tt(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void c(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (tt) {
            return;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                n = powerManager.isScreenOn();
            }
        } catch (Throwable th) {
            m.c(th);
        }
        try {
            f2012a = broadcastReceiver;
            StubApp.getOrigApplicationContext(context.getApplicationContext()).registerReceiver(f2012a, intentFilter);
            tt = true;
        } catch (Throwable th2) {
            m.c(th2);
        }
    }

    public static void ve(Context context) {
        try {
            if (tt && f2012a != null) {
                StubApp.getOrigApplicationContext(context.getApplicationContext()).unregisterReceiver(f2012a);
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public static void uj(Context context) {
        try {
            if (ve && sp != null) {
                StubApp.getOrigApplicationContext(context.getApplicationContext()).unregisterReceiver(sp);
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public static void n(Context context) {
        if (uj && x != null) {
            context.getContentResolver().unregisterContentObserver(x);
        }
    }

    public static boolean c(long j, long j2) {
        return System.currentTimeMillis() - j > j2;
    }

    @com.byazt.zqa.c(c = {0, 1, 274, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME})
    public static class ScreenStatusReceiver extends BroadcastReceiver {
        public com.byazt.lz.ve c;

        public ScreenStatusReceiver(com.byazt.lz.ve veVar) {
            this.c = veVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            com.byazt.nr.da.tt().post(new Runnable() { // from class: com.byazt.bt.DeviceInfoUtils.ScreenStatusReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    ScreenStatusReceiver screenStatusReceiver = ScreenStatusReceiver.this;
                    screenStatusReceiver.c(intent, screenStatusReceiver.c.uj());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(final Intent intent, boolean z) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                boolean unused = DeviceInfoUtils.n = true;
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                boolean unused2 = DeviceInfoUtils.n = false;
                if (z) {
                    return;
                }
                ((qp) com.byazt.ut.uj.getService("thread_service")).getIoExecutor().execute(new com.byazt.bwm.sp("updateScreenStatus") { // from class: com.byazt.bt.DeviceInfoUtils.ScreenStatusReceiver.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ((com.byazt.dna.n) com.byazt.ut.uj.getService("armor_service")).updateScreenStatus(intent.getAction());
                    }
                });
                return;
            }
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                long unused3 = DeviceInfoUtils.z = System.currentTimeMillis();
            }
        }
    }

    public static boolean a(Context context) {
        if (!n && SystemClock.elapsedRealtime() - rh >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            rh = SystemClock.elapsedRealtime();
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null) {
                    n = powerManager.isInteractive();
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return n;
    }

    public static float sp(Context context) {
        if (m != -2.0f && !c(nu, 30000L)) {
            return m;
        }
        int i2 = -1;
        if (context != null) {
            try {
                i2 = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
            } catch (Throwable th) {
                m.uj("DeviceInfoUtils", th.getMessage());
            }
        }
        if (i2 < 0) {
            m = -1.0f;
        } else {
            m = Math.round((i2 / 255.0f) * 10.0f) / 10.0f;
        }
        nu = System.currentTimeMillis();
        return m;
    }

    public static String c(int i2, com.byazt.dna.c cVar, Context context) {
        if (i2 == 0 && !TextUtils.isEmpty(i) && !c(sl, 60000L)) {
            return i;
        }
        if (i2 == 1 && !TextUtils.isEmpty(da) && !c(t, 60000L)) {
            return da;
        }
        String strTt = tt(i2, cVar, context);
        if (i2 == 0) {
            i = strTt;
            sl = System.currentTimeMillis();
        } else if (i2 == 1) {
            da = strTt;
            t = System.currentTimeMillis();
        }
        return strTt;
    }

    private static String tt(int i2, com.byazt.dna.c cVar, Context context) {
        TelephonyManager telephonyManagerC;
        List<CellInfo> allCellInfo;
        int dbm;
        WifiInfo wifiInfoC;
        int iVe = rh.ve(context);
        com.byazt.lz.c customController = cVar.getCustomController();
        if (iVe == 4) {
            if (i2 == 0) {
                try {
                    return (customController.isCanUseWifiState() && (wifiInfoC = ve.c(cVar, context)) != null) ? wifiInfoC.getRssi() + "dBm" : "unknown";
                } catch (Throwable unused) {
                }
            }
            return "unknown";
        }
        if (customController.isCanUsePhoneState() && customController.isCanUseLocation() && i2 == 1) {
            try {
                if (!ve.tt(context) || (telephonyManagerC = ve.c(context)) == null || (allCellInfo = telephonyManagerC.getAllCellInfo()) == null) {
                    return "unknown";
                }
                CellInfo cellInfo = allCellInfo.get(0);
                if (cellInfo instanceof CellInfoGsm) {
                    dbm = ((CellInfoGsm) cellInfo).getCellSignalStrength().getDbm();
                } else if (cellInfo instanceof CellInfoCdma) {
                    dbm = ((CellInfoCdma) cellInfo).getCellSignalStrength().getDbm();
                } else if (cellInfo instanceof CellInfoLte) {
                    dbm = ((CellInfoLte) cellInfo).getCellSignalStrength().getDbm();
                } else if (cellInfo instanceof CellInfoWcdma) {
                    dbm = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getDbm();
                } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoNr)) {
                    dbm = ((CellInfoNr) cellInfo).getCellSignalStrength().getDbm();
                } else if (Build.VERSION.SDK_INT >= 29 && (cellInfo instanceof CellInfoTdscdma)) {
                    dbm = ((CellInfoTdscdma) cellInfo).getCellSignalStrength().getDbm();
                }
                return Integer.MIN_VALUE == dbm ? "unknown" : dbm + "dBm";
            } catch (Throwable unused2) {
            }
        }
        return "unknown";
    }
}
