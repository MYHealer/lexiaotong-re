package com.jd.ad.sdk.jad_il;

import android.app.KeyguardManager;
import android.content.Context;
import android.net.LocalServerSocket;
import android.os.Debug;
import android.os.PowerManager;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.jd.ad.sdk.jad_jm.jad_cp;
import com.jd.ad.sdk.jad_kn.jad_dq;
import com.jd.ad.sdk.jad_kn.jad_er;
import com.jd.android.sdk.coreinfo.util.Logger;
import com.kuaishou.weapon.p0.an;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an {
    public static Context jad_an;
    public static boolean jad_bo;

    public static String jad_an() throws Throwable {
        int iMyPid = Process.myPid();
        HashSet hashSet = new HashSet();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(String.format(Locale.ENGLISH, "/proc/%d/maps", Integer.valueOf(iMyPid))));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] strArrSplit = line.split(PPSLabelView.Code);
                    if (strArrSplit.length > 0) {
                        String str = strArrSplit[strArrSplit.length - 1];
                        if (str.endsWith(".so") && str.startsWith("/data") && !str.contains("com.jingdong.app.mall")) {
                            String[] strArr = com.jd.ad.sdk.jad_jm.jad_bo.jad_an;
                            int length = strArr.length;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    hashSet.add(str);
                                    break;
                                }
                                if (Pattern.matches(strArr[i], str)) {
                                    break;
                                }
                                i++;
                            }
                        }
                    }
                } catch (Exception unused) {
                    bufferedReader = bufferedReader2;
                    jad_cp.jad_an(bufferedReader);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    jad_cp.jad_an(bufferedReader);
                    throw th;
                }
            }
            jad_cp.jad_an(bufferedReader2);
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        return hashSet.toString();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d A[Catch: Exception -> 0x0034, TRY_LEAVE, TryCatch #2 {Exception -> 0x0034, blocks: (B:5:0x0008, B:9:0x0019, B:10:0x0020, B:12:0x002d), top: B:22:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x0019 A[Catch: Exception -> 0x0034, TRY_ENTER, TryCatch #2 {Exception -> 0x0034, blocks: (B:5:0x0008, B:9:0x0019, B:10:0x0020, B:12:0x002d), top: B:22:0x0008 }] */
    public static String jad_bo() {
        Context context = jad_an;
        try {
            if (Debug.isDebuggerConnected()) {
                try {
                    com.jd.ad.sdk.jad_kn.jad_an.jad_an |= 1;
                    try {
                        if ((context.getApplicationInfo().flags & 2) != 0) {
                            com.jd.ad.sdk.jad_kn.jad_an.jad_an |= 2;
                        }
                    } catch (Exception unused) {
                    }
                    if (Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0) {
                        com.jd.ad.sdk.jad_kn.jad_an.jad_an |= 4;
                    }
                } catch (Exception unused2) {
                }
            } else {
                if ((context.getApplicationInfo().flags & 2) != 0) {
                    com.jd.ad.sdk.jad_kn.jad_an.jad_an |= 2;
                }
                if (Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0) {
                    com.jd.ad.sdk.jad_kn.jad_an.jad_an |= 4;
                }
            }
        } catch (Exception unused3) {
        }
        return String.valueOf(com.jd.ad.sdk.jad_kn.jad_an.jad_an);
    }

    public static int jad_cp() {
        Context context = jad_an;
        try {
            boolean z = !new jad_dq(context).jad_cp();
            if (com.jd.ad.sdk.jad_kn.jad_bo.jad_an("ro.product.cpu.abi").contains("x86")) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 1;
            }
            if (com.jd.ad.sdk.jad_kn.jad_bo.jad_an("ro.product.cpu.abilist").contains("x86")) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 2;
            }
            if (!context.getPackageManager().hasSystemFeature("android.hardware.camera")) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 8;
            }
            if (!context.getPackageManager().hasSystemFeature("android.hardware.camera.flash") && z) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 16;
            }
            int i = 0;
            while (true) {
                String[] strArr = com.jd.ad.sdk.jad_kn.jad_bo.jad_bo;
                if (i >= strArr.length) {
                    break;
                }
                if (new File(strArr[i]).exists()) {
                    com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 64;
                    break;
                }
                i++;
            }
            if (com.jd.ad.sdk.jad_kn.jad_bo.jad_an()) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 128;
            }
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_kn.jad_bo.jad_an("gsm.version.baseband")) && z) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 256;
            }
            String strJad_bo = com.jd.ad.sdk.jad_kn.jad_bo.jad_bo();
            if (strJad_bo.contains("intel") || strJad_bo.contains("amd")) {
                com.jd.ad.sdk.jad_kn.jad_bo.jad_an |= 512;
            }
        } catch (Exception unused) {
        }
        return (int) Long.valueOf(com.jd.ad.sdk.jad_kn.jad_bo.jad_an).longValue();
    }

    public static String jad_dq() {
        Boolean bool;
        try {
            if (com.jd.ad.sdk.jad_kn.jad_cp.jad_an(jad_an).booleanValue()) {
                com.jd.ad.sdk.jad_kn.jad_cp.jad_an |= 2;
            }
            if (com.jd.ad.sdk.jad_kn.jad_cp.jad_an().booleanValue()) {
                com.jd.ad.sdk.jad_kn.jad_cp.jad_an |= 4;
            }
            try {
                try {
                    Class.forName("de.robv.android.xposed.XC_MethodHook");
                    bool = Boolean.TRUE;
                } catch (Exception unused) {
                    Class.forName(an.f4626a);
                    bool = Boolean.FALSE;
                }
            } catch (Exception unused2) {
                bool = Boolean.FALSE;
            }
            if (bool.booleanValue()) {
                com.jd.ad.sdk.jad_kn.jad_cp.jad_an |= 8;
            }
            Boolean bool2 = Boolean.FALSE;
            try {
                if (System.getProperty("vxp") != null) {
                    bool2 = Boolean.TRUE;
                }
            } catch (Exception unused3) {
            }
            if (bool2.booleanValue()) {
                com.jd.ad.sdk.jad_kn.jad_cp.jad_an |= 16;
            }
        } catch (Exception unused4) {
        }
        return String.valueOf(com.jd.ad.sdk.jad_kn.jad_cp.jad_an);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008e A[Catch: Exception -> 0x00ad, TryCatch #0 {Exception -> 0x00ad, blocks: (B:3:0x0002, B:5:0x0008, B:6:0x000f, B:8:0x001e, B:10:0x0026, B:11:0x002e, B:12:0x0031, B:14:0x0037, B:15:0x003e, B:18:0x0043, B:21:0x0056, B:31:0x0080, B:32:0x0088, B:34:0x008e, B:36:0x009a, B:38:0x00a2, B:24:0x0061, B:26:0x0069, B:28:0x0071, B:30:0x0079, B:20:0x004f), top: B:44:0x0002, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x009a A[Catch: Exception -> 0x00ad, TryCatch #0 {Exception -> 0x00ad, blocks: (B:3:0x0002, B:5:0x0008, B:6:0x000f, B:8:0x001e, B:10:0x0026, B:11:0x002e, B:12:0x0031, B:14:0x0037, B:15:0x003e, B:18:0x0043, B:21:0x0056, B:31:0x0080, B:32:0x0088, B:34:0x008e, B:36:0x009a, B:38:0x00a2, B:24:0x0061, B:26:0x0069, B:28:0x0071, B:30:0x0079, B:20:0x004f), top: B:44:0x0002, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:34:0x008e, please report this as an issue */
    public static String jad_er() {
        String packageName;
        int i;
        Context context = jad_an;
        try {
            if (jad_er.jad_an(context)) {
                jad_er.jad_an |= 1;
            }
            String path = context.getFilesDir().getPath();
            for (String str : jad_er.jad_cp) {
                if (path.contains(str)) {
                    jad_er.jad_an |= 2;
                    break;
                }
            }
            if (jad_er.jad_an()) {
                jad_er.jad_an |= 4;
            }
            if (jad_er.jad_bo != null) {
                packageName = context.getPackageName();
                if (!TextUtils.isEmpty(packageName) && (packageName.equals("com.jingdong.app.mall") || packageName.equals("com.jd.pingou") || packageName.equals("com.jd.jdlite"))) {
                    jad_er.jad_an |= 32;
                }
                loop1: for (String str2 : com.jd.ad.sdk.jad_jm.jad_an.jad_an(context)) {
                    for (String str3 : jad_er.jad_cp) {
                        if (str2.contains(str3)) {
                            jad_er.jad_an |= 64;
                            break loop1;
                        }
                    }
                }
            } else {
                try {
                    jad_er.jad_bo = new LocalServerSocket(context.getPackageName());
                } catch (IOException unused) {
                    jad_er.jad_an |= 16;
                }
                packageName = context.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    jad_er.jad_an |= 32;
                }
                loop1: while (r0.hasNext()) {
                    while (i < r3) {
                        if (str2.contains(str3)) {
                            jad_er.jad_an |= 64;
                            break loop1;
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return String.valueOf(jad_er.jad_an);
    }

    public static boolean jad_fs() {
        try {
            return ((KeyguardManager) jad_an.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e) {
            Logger.e("AntiSDK", e.getMessage());
            return false;
        }
    }

    public static boolean jad_jt() {
        try {
            return !((PowerManager) jad_an.getSystemService("power")).isScreenOn();
        } catch (Exception e) {
            Logger.e("AntiSDK", e.getMessage());
            return false;
        }
    }
}
