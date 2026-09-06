package com.huawei.hms.feature.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.util.ExtractNativeUtils;
import com.huawei.hms.common.util.Logger;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class AssetLoadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3999a = "AssetLoadManager";
    public static final String b = "dynamic_modules";
    public static final String c = ".apk";
    public static final String d = "com.huawei.hms.feature.dynamic.descriptors.";
    public static final String e = ".AssetModuleDescriptor";

    public static int a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.e(f3999a, "Invalid context or moduleName.");
            return 0;
        }
        try {
            return context.getClassLoader().loadClass(d + str + e).getDeclaredField("MODULE_VERSION").getInt(null);
        } catch (ClassNotFoundException unused) {
            Logger.w(f3999a, "Cannot get the class of module descriptor for " + str);
            return 0;
        } catch (Exception e2) {
            Logger.w(f3999a, "Get local asset module info failed.", e2);
            return 0;
        }
    }

    public static Bundle a(Context context, File file, String str) {
        String[] list = file.list();
        if (list == null || list.length == 0) {
            Logger.w(f3999a, "No version in module path.");
            return new Bundle();
        }
        int i = 0;
        for (String str2 : list) {
            if (Integer.parseInt(str2) > i) {
                i = Integer.parseInt(str2);
            }
        }
        if (i == 0) {
            Logger.w(f3999a, "Cannot get module version path.");
            return new Bundle();
        }
        try {
            String canonicalPath = file.getCanonicalPath();
            ModuleCopy.clearLowVersionModule(i, canonicalPath, list, f3999a);
            if (a(context, str) > i) {
                Logger.i(f3999a, "There is a higher loader version in assets.");
                return new Bundle();
            }
            String str3 = canonicalPath + File.separator + i + File.separator + str + ".apk";
            if (!new File(str3).exists()) {
                Logger.w(f3999a, "Cannot find module apk in asset decompressed path.");
                return new Bundle();
            }
            Bundle bundle = new Bundle();
            bundle.putString("module_name", str);
            bundle.putString("module_path", str3);
            bundle.putInt(b.m, i);
            Logger.i(f3999a, "Get module info from decompressed asset path success: ModuleName:" + str + ", ModuleVersion:" + i + ", ModulePath:" + str3);
            return bundle;
        } catch (IOException e2) {
            Logger.w(f3999a, "request modulePath error: " + e2.getMessage());
            return new Bundle();
        }
    }

    public static String a(Context context, String str, int i, String str2) throws Throwable {
        InputStream inputStreamOpen;
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            inputStreamOpen = context.getAssets().open("dynamic_modules" + File.separator + str + File.separator + str2);
            try {
                bufferedInputStream = new BufferedInputStream(inputStreamOpen);
                try {
                    String str3 = ModuleCopy.getProtectedPath(context) + File.separator + "dynamic_modules" + File.separator + str + File.separator + i;
                    if (!new File(str3).exists() && !new File(str3).mkdirs()) {
                        Logger.w(f3999a, "mkdirs local loaderPath failed.");
                        ModuleCopy.closeQuietly(bufferedInputStream);
                        ModuleCopy.closeQuietly(null);
                        ModuleCopy.closeQuietly(inputStreamOpen);
                        return null;
                    }
                    String str4 = str3 + File.separator + str + ".apk";
                    fileOutputStream = new FileOutputStream(new File(str4));
                    try {
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i2 = bufferedInputStream.read(bArr, 0, 4096);
                                if (i2 == -1) {
                                    Logger.i(f3999a, "Decompress module:" + str + " from assets success.");
                                    ModuleCopy.closeQuietly(bufferedInputStream);
                                    ModuleCopy.closeQuietly(fileOutputStream);
                                    ModuleCopy.closeQuietly(inputStreamOpen);
                                    return str4;
                                }
                                fileOutputStream.write(bArr, 0, i2);
                                th = th;
                                fileOutputStream2 = fileOutputStream;
                                ModuleCopy.closeQuietly(bufferedInputStream);
                                ModuleCopy.closeQuietly(fileOutputStream2);
                                ModuleCopy.closeQuietly(inputStreamOpen);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            Logger.w(f3999a, "Cannot find module:" + str + " in assets.", e);
                            ModuleCopy.closeQuietly(bufferedInputStream);
                            ModuleCopy.closeQuietly(fileOutputStream);
                            ModuleCopy.closeQuietly(inputStreamOpen);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
                bufferedInputStream = null;
                Logger.w(f3999a, "Cannot find module:" + str + " in assets.", e);
                ModuleCopy.closeQuietly(bufferedInputStream);
                ModuleCopy.closeQuietly(fileOutputStream);
                ModuleCopy.closeQuietly(inputStreamOpen);
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        } catch (Exception e5) {
            e = e5;
            inputStreamOpen = null;
        } catch (Throwable th4) {
            th = th4;
            inputStreamOpen = null;
        }
    }

    public static Bundle b(Context context, String str) throws Throwable {
        try {
            String[] list = context.getAssets().list("dynamic_modules" + File.separator + str);
            if (list != null && list.length != 0) {
                String str2 = list[0];
                int iA = a(context, str);
                String strA = a(context, str, iA, str2);
                if (!TextUtils.isEmpty(strA) && new File(strA).exists()) {
                    if (ExtractNativeUtils.a(context, strA) && ExtractNativeUtils.a(new File(strA), ModuleCopy.trimLastSection(strA)) != 0) {
                        Logger.w(f3999a, "Extract native to current dir failed.");
                        return new Bundle();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("module_name", str);
                    bundle.putString("module_path", strA);
                    bundle.putInt(b.m, iA);
                    Logger.i(f3999a, "Get dynamic module info from asset success: ModuleName:" + str + ", ModuleVersion:" + iA + ", ModulePath:" + strA);
                    return bundle;
                }
                Logger.w(f3999a, "Decompress module from assets failed.");
                return new Bundle();
            }
            Logger.w(f3999a, "No module apk in asset path.");
            return new Bundle();
        } catch (Exception e2) {
            Logger.i(f3999a, "getModuleFromAsset failed.", e2);
            return new Bundle();
        }
    }

    public static Bundle getAssetModuleInfo(Context context, String str) throws Throwable {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.w(f3999a, "The context or moduleName is null.");
            return new Bundle();
        }
        try {
            File file = new File(ModuleCopy.getProtectedPath(context) + File.separator + "dynamic_modules" + File.separator + str);
            if (file.exists()) {
                Bundle bundleA = a(context, file, str);
                if (bundleA.getInt(b.m) > 0) {
                    Logger.i(f3999a, "Successfully get module info from decompressed asset path.");
                    return bundleA;
                }
            }
            Bundle bundleB = b(context, str);
            if (bundleB.getInt(b.m) > 0) {
                Logger.i(f3999a, "Successfully get module info from asset.");
                return bundleB;
            }
        } catch (Exception e2) {
            Logger.i(f3999a, "getDataModuleInfo failed.", e2);
        }
        return new Bundle();
    }
}
