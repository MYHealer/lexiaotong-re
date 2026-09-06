package com.huawei.hms.feature.dynamic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.common.util.Logger;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ModuleCopy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4021a = "ModuleCopy";
    public static final int b = 2048;
    public static final int c = 0;
    public static final int d = 1;
    public static final String e = "module_uri_path";
    public static final String f = "loader_uri_path";
    public static final String g = "dynamic_modules";
    public static final String h = ".apk";

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f4022a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public a(String[] strArr, int i, String str) {
            this.f4022a = strArr;
            this.b = i;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.f4022a) {
                if (Integer.parseInt(str) < this.b) {
                    Logger.i(ModuleCopy.f4021a, "Delete low version:" + this.b + " in modulePath.");
                    ModuleCopy.b(this.c + File.separator + str);
                }
            }
        }
    }

    public static int a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            Logger.i(f4021a, "No version dirs in module path, need mkdir.");
            return 0;
        }
        int i = 0;
        for (String str : strArr) {
            if (Integer.parseInt(str) > i) {
                i = Integer.parseInt(str);
            }
        }
        return i;
    }

    public static String a(Context context, Bundle bundle, int i, Uri uri) {
        String str;
        String string;
        String strValueOf;
        StringBuilder sb;
        String[] list;
        int iA;
        if (i == 0) {
            str = "module_name";
            string = bundle.getString("module_name");
            strValueOf = String.valueOf(bundle.getInt("module_version"));
            sb = new StringBuilder();
        } else {
            str = "loader_name";
            string = bundle.getString("loader_name");
            strValueOf = String.valueOf(bundle.getInt("loader_version"));
            sb = new StringBuilder();
        }
        String string2 = sb.append(bundle.getString(str)).append(".apk").toString();
        try {
            String str2 = getProtectedPath(context) + File.separator + "dynamic_modules" + File.separator + string;
            String str3 = str2 + File.separator + strValueOf;
            String str4 = str3 + File.separator + string2;
            if (new File(str2).exists() && (iA = a((list = new File(str2).list()))) >= Integer.parseInt(strValueOf)) {
                clearLowVersionModule(iA, str2, list, f4021a);
                return str2 + File.separator + iA + File.separator + string2;
            }
            return a(context, str3, uri, str4);
        } catch (IOException e2) {
            Logger.w(f4021a, "request modulePath error: " + e2.getMessage());
            return null;
        }
    }

    public static String a(Context context, String str, Uri uri, String str2) throws Throwable {
        if (makeDirectory(str)) {
            a(context, uri, str2);
            return str2;
        }
        Logger.e(f4021a, "makeDirectory return false");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static void a(Context context, Uri uri, String str) throws Throwable {
        IOException e2;
        FileNotFoundException e3;
        StringBuilder sbAppend;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                context = context.getContentResolver().openInputStream(uri);
                try {
                    if (context == 0) {
                        Logger.w(f4021a, "Get input stream failed: null.");
                        closeQuietly(context);
                        closeQuietly(null);
                        return;
                    }
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str)));
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = context.read(bArr);
                            if (i == -1) {
                                closeQuietly(context);
                                closeQuietly(bufferedOutputStream2);
                                return;
                            }
                            bufferedOutputStream2.write(bArr, 0, i);
                        }
                    } catch (FileNotFoundException e4) {
                        bufferedOutputStream = bufferedOutputStream2;
                        e3 = e4;
                        sbAppend = new StringBuilder().append("FileNotFoundException:").append(e3.getMessage());
                        context = context;
                        Logger.e(f4021a, sbAppend.toString());
                        closeQuietly(context);
                        closeQuietly(bufferedOutputStream);
                    } catch (IOException e5) {
                        bufferedOutputStream = bufferedOutputStream2;
                        e2 = e5;
                        sbAppend = new StringBuilder().append("IOException ").append(e2.getMessage());
                        context = context;
                        Logger.e(f4021a, sbAppend.toString());
                        closeQuietly(context);
                        closeQuietly(bufferedOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        closeQuietly(context);
                        closeQuietly(bufferedOutputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e6) {
                    e3 = e6;
                } catch (IOException e7) {
                    e2 = e7;
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    closeQuietly(context);
                    closeQuietly(bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e8) {
            e3 = e8;
            context = 0;
        } catch (IOException e9) {
            e2 = e9;
            context = 0;
        } catch (Throwable th4) {
            th = th4;
            context = 0;
        }
    }

    public static void a(Context context, Bundle bundle, int i) {
        String string = bundle.getString(i == 0 ? "module_uri_path" : f);
        Logger.i(f4021a, "path:" + string);
        String strA = a(context, bundle, i, Uri.parse(string));
        if (TextUtils.isEmpty(strA)) {
            Logger.w(f4021a, "checkModulePath failed: null.");
        } else {
            bundle.putString(i == 0 ? "module_path" : "loader_path", strA);
        }
    }

    public static boolean a(Bundle bundle) {
        return TextUtils.equals(bundle.getString("module_path"), bundle.getString("loader_path"));
    }

    public static boolean b(String str) {
        File file = new File(str);
        if (file.isDirectory() && file.list() != null) {
            boolean z = true;
            for (String str2 : file.list()) {
                z = z && b(new StringBuilder().append(str).append(File.separator).append(str2).toString());
            }
            if (!z) {
                return false;
            }
        }
        return file.delete();
    }

    public static void clearLowVersionModule(int i, String str, String[] strArr, String str2) {
        c.a(1, str2).execute(new a(strArr, i, str));
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Logger.e(f4021a, "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }

    public static void copyModule(Context context, Bundle bundle) {
        if (context == null || bundle == null) {
            Logger.e(f4021a, "The context or module info bundle is null.");
            return;
        }
        boolean zA = a(bundle);
        a(context, bundle, 0);
        if (zA) {
            bundle.putString("loader_path", bundle.getString("module_path"));
        } else {
            a(context, bundle, 1);
        }
    }

    public static String getProtectedPath(Context context) throws IOException {
        return context.createDeviceProtectedStorageContext().getDataDir().getCanonicalPath();
    }

    public static boolean makeDirectory(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        } catch (Exception e2) {
            Log.e(f4021a, "makeDirectory Exception: " + e2.getMessage());
            return false;
        }
    }

    public static String trimLastSection(String str) {
        int iLastIndexOf = str.lastIndexOf(File.separator);
        return iLastIndexOf <= 0 ? str : str.substring(0, iLastIndexOf);
    }
}
