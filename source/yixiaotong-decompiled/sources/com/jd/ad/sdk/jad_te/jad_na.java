package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_na {
    public static final boolean jad_hu;
    public static final File jad_iv;
    public static final boolean jad_jt;
    public static volatile jad_na jad_jw;
    public static volatile int jad_kx;
    public final int jad_bo;
    public final int jad_cp;
    public int jad_dq;
    public boolean jad_er = true;
    public final AtomicBoolean jad_fs = new AtomicBoolean(false);
    public final boolean jad_an = jad_bo();

    static {
        jad_jt = Build.VERSION.SDK_INT < 29;
        jad_hu = true;
        jad_iv = new File("/proc/self/fd");
        jad_kx = -1;
    }

    public jad_na() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.jad_bo = 20000;
            this.jad_cp = 0;
        } else {
            this.jad_bo = 700;
            this.jad_cp = 128;
        }
    }

    public static jad_na jad_an() {
        if (jad_jw == null) {
            synchronized (jad_na.class) {
                if (jad_jw == null) {
                    jad_jw = new jad_na();
                }
            }
        }
        return jad_jw;
    }

    public static boolean jad_bo() {
        if (Build.VERSION.SDK_INT == 26) {
            Iterator it = Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play").iterator();
            while (it.hasNext()) {
                if (Build.MODEL.startsWith((String) it.next())) {
                }
            }
            if (Build.VERSION.SDK_INT != 27) {
            }
            return true;
        }
        if (Build.VERSION.SDK_INT != 27 || !Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(Build.MODEL)) {
            return true;
        }
        return false;
    }

    public boolean jad_an(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean zJad_an = jad_an(i, i2, z, z2);
        if (zJad_an) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zJad_an;
    }

    public boolean jad_an(int i, int i2, boolean z, boolean z2) {
        boolean z3;
        if (!z) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Logger.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!this.jad_an) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Logger.v("HardwareConfig", "Hardware config disallowed by device model");
            }
            return false;
        }
        if (!jad_hu) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Logger.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (jad_jt && !this.jad_fs.get()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Logger.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z2) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Logger.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        int i3 = this.jad_cp;
        if (i < i3) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Logger.v("HardwareConfig", "Hardware config disallowed because width is too small");
            }
            return false;
        }
        if (i2 < i3) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Logger.v("HardwareConfig", "Hardware config disallowed because height is too small");
            }
            return false;
        }
        synchronized (this) {
            int i4 = this.jad_dq + 1;
            this.jad_dq = i4;
            if (i4 >= 50) {
                this.jad_dq = 0;
                int length = jad_iv.list().length;
                long j = jad_kx != -1 ? jad_kx : this.jad_bo;
                boolean z4 = ((long) length) < j;
                this.jad_er = z4;
                if (!z4 && Log.isLoggable("Downsampler", 5)) {
                    Logger.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + j);
                }
            }
            z3 = this.jad_er;
        }
        if (z3) {
            return true;
        }
        if (Log.isLoggable("HardwareConfig", 2)) {
            Logger.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
        }
        return false;
    }
}
