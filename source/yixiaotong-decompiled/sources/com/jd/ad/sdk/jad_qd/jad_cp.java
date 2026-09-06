package com.jd.ad.sdk.jad_qd;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.kuaishou.weapon.p0.g;
import java.io.File;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: JADAntiUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp {
    public static final List<String> jad_an = Arrays.asList("com.kingroot.kinguser", "MobileSubstrate", "libhooker", "Cephei.framework", "frida-agent-32.so", "liblhooker64.so", "libnathook.so", "io.virtualapp.sandvxposed64", "me.weishu.exp", "zygisk", "libsandhook", "frida", "zorro.dylib", "AXJ.dylib", "com.yztc.studio");
    public static final List<String> jad_bo = Arrays.asList("com_yztc_studio_plugin", "com.miui.miuibbs", "com_wtkj_app_clicker", "com_github_uiautomator", "com_uwish_app");

    /* JADX WARN: Code duplicated, block: B:69:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:93:0x0152  */
    /* JADX WARN: Code duplicated, block: B:94:0x0154  */
    /* JADX WARN: Code duplicated, block: B:97:0x0162  */
    /* JADX WARN: Code duplicated, block: B:98:0x0164  */
    public static String jad_an(Context context, String str) {
        String str2;
        String[] strArr;
        String str3;
        String str4;
        String[] strArr2;
        int i;
        Boolean bool;
        String str5;
        String str6;
        Iterator<InputMethodInfo> it;
        try {
            StringBuilder sb = new StringBuilder();
            PackageManager packageManager = context.getPackageManager();
            String str7 = "0";
            sb.append((packageManager != null && packageManager.hasSystemFeature("android.hardware.sensor.compass")) ? "0" : "1");
            sb.append((packageManager != null && packageManager.hasSystemFeature("android.hardware.usb.host")) ? "0" : "1");
            Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
            sb.append((vibrator == null || !vibrator.hasVibrator()) ? "1" : "0");
            String strJad_cn = jad_an.jad_cn();
            if (jad_bo(context) && "0".equals(strJad_cn)) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            try {
                try {
                    String strJad_bo = jad_bo("sys.usb.state");
                    String strJad_bo2 = jad_bo("ro.debuggable");
                    str2 = ((strJad_bo != null && strJad_bo.contains("adb")) && (strJad_bo2 != null && "1".equals(strJad_bo2))) ? "1" : "0";
                    while (true) {
                        if (!it.hasNext()) {
                            str4 = "0";
                            break;
                        }
                        if ("com.android.adbkeyboard".equals(it.next().getPackageName())) {
                            str4 = "1";
                            break;
                        }
                    }
                    while (true) {
                        if (i < 2) {
                            try {
                                String property = System.getProperty(strArr2[i]);
                                i = ("disabled".equals(property) || "3".equals(property)) ? 0 : i + 1;
                                bool = Boolean.TRUE;
                            } catch (Exception e) {
                                e.printStackTrace();
                                bool = Boolean.FALSE;
                            }
                            if (bool.booleanValue()) {
                                str5 = "1";
                            } else {
                                str5 = "0";
                            }
                            sb.append(str5);
                            if (jad_an().booleanValue()) {
                                str6 = "1";
                            } else {
                                str6 = "0";
                            }
                            sb.append(str6);
                            if (jad_an(context) && jad_bo().booleanValue()) {
                                str7 = "1";
                            }
                            sb.append(str7);
                            return jad_an(sb.toString());
                        }
                        bool = Boolean.FALSE;
                        if (bool.booleanValue()) {
                            str5 = "1";
                        } else {
                            str5 = "0";
                        }
                        sb.append(str5);
                        if (jad_an().booleanValue()) {
                            str6 = "1";
                        } else {
                            str6 = "0";
                        }
                        sb.append(str6);
                        if (jad_an(context)) {
                            str7 = "1";
                        }
                        sb.append(str7);
                        return jad_an(sb.toString());
                    }
                } catch (Exception unused) {
                }
                it = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
            } catch (Exception unused2) {
            }
            sb.append(str2);
            boolean[] zArr = {false};
            if (Looper.getMainLooper() != Looper.myLooper()) {
                zArr[0] = jad_er();
            } else {
                WorkExecutor.execute(new jad_bo(zArr));
            }
            sb.append(zArr[0] ? "1" : "0");
            PackageManager packageManager2 = context.getPackageManager();
            if (packageManager2 != null) {
                try {
                    PackageInfo packageInfo = packageManager2.getPackageInfo(context.getPackageName(), 4096);
                    if (packageInfo == null || (strArr = packageInfo.requestedPermissions) == null) {
                        str3 = "0";
                    } else {
                        int length = strArr.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                String str8 = strArr[i2];
                                if (TextUtils.isEmpty(str8) || !(str8.equals("android.permission.READ_LOGS") || str8.equals("android.permission.READ_CALL_LOG"))) {
                                    i2++;
                                } else {
                                    str3 = "1";
                                }
                            } else {
                                str3 = "0";
                            }
                        }
                    }
                } catch (Exception unused3) {
                }
            } else {
                str3 = "0";
            }
            sb.append(str3);
            sb.append(str4);
            strArr2 = new String[]{"ro.boot.veritymode", "persist.sys.root_access"};
        } catch (Exception unused4) {
            return str;
        }
    }

    public static Boolean jad_bo() {
        String str;
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "sys.usb.config");
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        return (str == null || !str.contains("adb")) ? Boolean.FALSE : Boolean.TRUE;
    }

    public static boolean jad_er() {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", 5073), 500);
            socket.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String jad_dq() throws Throwable {
        try {
            String strJad_an = com.jd.ad.sdk.jad_il.jad_an.jad_an();
            if (TextUtils.isEmpty(strJad_an)) {
                return "NA";
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                List<String> list = jad_an;
                if (i < list.size()) {
                    String str = list.get(i);
                    sb.append((TextUtils.isEmpty(str) || !strJad_an.contains(str)) ? "0" : "1");
                    i++;
                } else {
                    return jad_an(sb.toString());
                }
            }
        } catch (Exception unused) {
            return "NA";
        }
    }

    public static String jad_cp(Context context) {
        String str;
        ApplicationInfo applicationInfo;
        try {
            StringBuilder sb = new StringBuilder();
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                int i = 0;
                while (true) {
                    List<String> list = jad_bo;
                    if (i >= list.size()) {
                        break;
                    }
                    String str2 = list.get(i);
                    try {
                        str = (TextUtils.isEmpty(str2) || (applicationInfo = packageManager.getApplicationInfo(str2, 0)) == null || (applicationInfo.flags & 2097152) != 0) ? "0" : "1";
                    } catch (Exception unused) {
                    }
                    sb.append(str);
                    i++;
                }
            }
            if (!TextUtils.isEmpty(sb)) {
                return jad_an(sb.toString());
            }
        } catch (Exception unused2) {
        }
        return "NA";
    }

    public static boolean jad_bo(Context context) {
        Network activeNetwork;
        if (ContextCompat.checkSelfPermission(context, g.b) == -1) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetwork = connectivityManager.getActiveNetwork()) != null && connectivityManager.getNetworkInfo(activeNetwork) != null) {
                return (System.getProperty("http.proxyHost") == null || System.getProperty("http.proxyPort") == null) ? false : true;
            }
            return false;
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String jad_bo(String str) {
        String str2;
        try {
            Class<?> clsLoadClass = ClassLoader.getSystemClassLoader().loadClass(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            Method method = clsLoadClass.getMethod("get", String.class);
            method.setAccessible(true);
            str2 = (String) method.invoke(clsLoadClass, str);
        } catch (Exception unused) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    public static String jad_cp() {
        try {
            StringBuilder sb = new StringBuilder();
            String str = "1";
            sb.append(jad_hu.jad_jt() == 1 ? "1" : "0");
            sb.append("0");
            if (jad_hu.jad_fs() != 1) {
                str = "0";
            }
            sb.append(str);
            return jad_an(sb.toString());
        } catch (Exception unused) {
            return "NA";
        }
    }

    public static Boolean jad_an() {
        try {
            String[] strArr = {"/system/xbin/su", "/system/bin/su", "/sbin/su", "/su/bin/su"};
            for (int i = 0; i < 4; i++) {
                if (new File(strArr[i]).exists()) {
                    return Boolean.TRUE;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    public static boolean jad_an(Context context) {
        try {
            if (!context.getPackageManager().hasSystemFeature("android.hardware.usb.host")) {
                return false;
            }
            UsbManager usbManager = (UsbManager) context.getSystemService("usb");
            Iterator<Map.Entry<String, UsbDevice>> it = usbManager.getDeviceList().entrySet().iterator();
            while (it.hasNext()) {
                UsbDevice value = it.next().getValue();
                if (usbManager.hasPermission(value) && value.getDeviceClass() == 8) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String jad_an(String str) {
        try {
            return TextUtils.isEmpty(str) ? "NA" : new BigInteger(str, 2).toString(16);
        } catch (Exception unused) {
            return "NA";
        }
    }
}
