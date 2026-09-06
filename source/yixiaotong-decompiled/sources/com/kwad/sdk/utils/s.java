package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class s {
    public static com.kwad.sdk.k.a.d boM;

    static class b extends com.kwad.sdk.k.a.a {
    }

    static class c extends com.kwad.sdk.k.a.a {
    }

    public static synchronized com.kwad.sdk.k.a.d UE() {
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).FI()) {
            return null;
        }
        com.kwad.sdk.k.a.d dVar = boM;
        if (dVar != null) {
            return dVar;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(ServiceProvider.getContext().getApplicationContext());
        com.kwad.sdk.k.a.d dVar2 = new com.kwad.sdk.k.a.d(origApplicationContext);
        boolean zCG = new d().cG(origApplicationContext);
        boolean zCG2 = new e().cG(origApplicationContext);
        boolean zCG3 = new b().cG(origApplicationContext);
        boolean zCG4 = new a().cG(origApplicationContext);
        boolean zCG5 = new c().cG(origApplicationContext);
        dVar2.cl(zCG);
        dVar2.cm(zCG2);
        dVar2.cn(zCG3);
        dVar2.cp(zCG4);
        dVar2.cq(zCG5);
        boM = dVar2;
        return dVar2;
    }

    public static String g(String[] strArr) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec(strArr).getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }

    static class d extends com.kwad.sdk.k.a.a {
        public d() {
            UF();
        }

        private void UF() {
            this.bms = new ArrayList();
            this.bms.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.d.1
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.bms.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.d.2
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                    for (int i = 0; i < 5; i++) {
                        if (new File(strArr[i] + com.kuaishou.weapon.p0.bg.y).exists()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.bms.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.d.3
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    return !TextUtils.isEmpty(s.g(new String[]{"/system/xbin/which", com.kuaishou.weapon.p0.bg.y}));
                }
            });
            this.bms.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.d.4
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    Charset charsetForName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        y.a(file, "ok", charsetForName, false);
                        return y.a(file, charsetForName).equals("ok");
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        }
    }

    static class e extends com.kwad.sdk.k.a.a {
        public e() {
            UF();
        }

        private void UF() {
            this.bms = new ArrayList();
            this.bms.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.e.1
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    return au.aw(context, "de.robv.android.xposed.installer") || au.aw(context, "com.saurik.substrate");
                }
            });
            this.bms.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.e.2
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    try {
                        throw new Exception("empty");
                    } catch (Exception e) {
                        boolean z = false;
                        int i = 0;
                        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                            String className = stackTraceElement.getClassName();
                            String methodName = stackTraceElement.getMethodName();
                            if (className.equals("com.android.internal.os.ZygoteInit") && (i = i + 1) == 2) {
                                z = true;
                            }
                            if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                                Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                                z = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.b) && methodName.equals("main")) {
                                z = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.b) && methodName.equals("handleHookedMethod")) {
                                z = true;
                            }
                        }
                        return z;
                    }
                }
            });
            this.bms.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.e.3
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) throws Throwable {
                    FileReader fileReader;
                    boolean z = false;
                    BufferedReader bufferedReader = null;
                    try {
                        HashSet<String> hashSet = new HashSet();
                        fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                            while (true) {
                                try {
                                    String line = bufferedReader2.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    if (line.endsWith(".so") || line.endsWith(".jar")) {
                                        hashSet.add(line.substring(line.lastIndexOf(PPSLabelView.Code) + 1));
                                    }
                                } catch (Exception unused) {
                                    bufferedReader = bufferedReader2;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader = bufferedReader2;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                    throw th;
                                }
                            }
                            for (String str : hashSet) {
                                if (str.contains("com.saurik.substrate")) {
                                    Log.wtf("HookDetection", "Substrate shared object found: " + str);
                                    z = true;
                                }
                                if (str.contains("XposedBridge.jar")) {
                                    Log.wtf("HookDetection", "Xposed JAR found: " + str);
                                    z = true;
                                }
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        } catch (Exception unused2) {
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception unused3) {
                        fileReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileReader = null;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                    return z;
                }
            });
        }
    }

    static class a extends com.kwad.sdk.k.a.a {
        public a() {
            UF();
        }

        private void UF() {
            this.bms = new ArrayList();
            this.bms.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.a.1
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    int i = (Build.PRODUCT.contains(com.baidu.mobads.sdk.internal.bn.g) || Build.PRODUCT.contains("Andy") || Build.PRODUCT.contains("ttVM_Hdragon") || Build.PRODUCT.contains("google_sdk") || Build.PRODUCT.contains("Droid4X") || Build.PRODUCT.contains("nox") || Build.PRODUCT.contains("sdk_x86") || Build.PRODUCT.contains("sdk_google") || Build.PRODUCT.contains("vbox86p") || Build.PRODUCT.contains("aries")) ? 1 : 0;
                    if (Build.MANUFACTURER.equals("unknown") || Build.MANUFACTURER.equals("Genymotion") || Build.MANUFACTURER.contains("Andy") || Build.MANUFACTURER.contains("MIT") || Build.MANUFACTURER.contains("nox") || Build.MANUFACTURER.contains("TiantianVM")) {
                        i++;
                    }
                    if (Build.BRAND.equals("generic") || Build.BRAND.equals("generic_x86") || Build.BRAND.equals("TTVM") || Build.BRAND.contains("Andy")) {
                        i++;
                    }
                    if (Build.DEVICE.contains("generic") || Build.DEVICE.contains("generic_x86") || Build.DEVICE.contains("Andy") || Build.DEVICE.contains("ttVM_Hdragon") || Build.DEVICE.contains("Droid4X") || Build.DEVICE.contains("nox") || Build.DEVICE.contains("generic_x86_64") || Build.DEVICE.contains("vbox86p") || Build.DEVICE.contains("aries")) {
                        i++;
                    }
                    if (Build.MODEL.equals(com.baidu.mobads.sdk.internal.bn.g) || Build.MODEL.contains("Emulator") || Build.MODEL.equals("google_sdk") || Build.MODEL.contains("Droid4X") || Build.MODEL.contains("TiantianVM") || Build.MODEL.contains("Andy") || Build.MODEL.equals("Android SDK built for x86_64") || Build.MODEL.equals("Android SDK built for x86")) {
                        i++;
                    }
                    if (Build.HARDWARE.equals("goldfish") || Build.HARDWARE.equals("vbox86") || Build.HARDWARE.contains("nox") || Build.HARDWARE.contains("ttVM_x86")) {
                        i++;
                    }
                    if (Build.FINGERPRINT.contains("generic/sdk/generic") || Build.FINGERPRINT.contains("generic_x86/sdk_x86/generic_x86") || Build.FINGERPRINT.contains("Andy") || Build.FINGERPRINT.contains("ttVM_Hdragon") || Build.FINGERPRINT.contains("generic_x86_64") || Build.FINGERPRINT.contains("generic/google_sdk/generic") || Build.FINGERPRINT.contains("vbox86p") || Build.FINGERPRINT.contains("generic/vbox86p/vbox86p")) {
                        i++;
                    }
                    try {
                        if (!be.useStoragePermissionDisable() && new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + "windows" + File.separatorChar + "BstSharedFolder").exists()) {
                            i += 10;
                        }
                    } catch (Exception unused) {
                    }
                    return i > 3;
                }
            });
            this.bms.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.a.2
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    return "1".equals(bs.get("ro.kernel.qemu"));
                }
            });
        }
    }
}
