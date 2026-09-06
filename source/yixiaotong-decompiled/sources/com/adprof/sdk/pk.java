package com.adprof.sdk;

import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.adprof.sdk.api.AdprofSdkConfig;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class pk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f1367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f594a;
    public static boolean b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SimpleDateFormat f592a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ExecutorService f593a = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static File f591a = null;

    public static void a() {
        if (f591a != null) {
            return;
        }
        try {
            try {
                File file = new File(AdprofSdk.getInstance().getContext().getExternalCacheDir().getPath(), "af.log");
                f591a = file;
                if (!file.getParentFile().exists()) {
                    f591a.getParentFile().mkdirs();
                }
                if (f591a.exists()) {
                    f591a.delete();
                }
                d("\n  \n SDKLog file log path: " + f591a.getAbsolutePath() + "  \n \n ");
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            File file2 = new File(AdprofSdk.getInstance().getContext().getCacheDir().getPath(), "af.log");
            f591a = file2;
            if (!file2.getParentFile().exists()) {
                f591a.getParentFile().mkdirs();
            }
            if (f591a.exists()) {
                f591a.delete();
            }
            d("SDKLog file log path: " + f591a.getAbsolutePath());
        }
    }

    public static void a(File file) {
        String string;
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file), 8192);
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    } else {
                        sb.append(IOUtils.LINE_SEPARATOR_UNIX).append(line);
                    }
                }
                bufferedReader.close();
                string = sb.toString();
            } catch (Throwable th) {
                b("readFileToString error: ", th);
                string = null;
            }
            JSONObject jSONObject = new JSONObject(new JSONTokener(a.a(string, "adprof_private_a")));
            String string2 = jSONObject.getString(TtmlNode.RUBY_BASE);
            String string3 = jSONObject.getString("tag");
            if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                z1.a().getClass();
            }
            Log.d("adprofsdk", "---path setBase content " + string + " \n " + string2 + PPSLabelView.Code + file);
        } catch (Exception e) {
            Log.d("adprofsdk", "---path setBase content  Exception " + e);
        }
    }

    public static void a(String str) {
        if (b()) {
            Log.d("adprofsdk", str);
            c("D", str);
        }
    }

    public static void a(String str, String str2) {
        if (b()) {
            Log.d(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (b()) {
            Log.e(str, str2, th);
        }
    }

    public static void a(String str, Throwable th) {
        if (b()) {
            Log.d("adprofsdk", str, th);
        }
    }

    public static void a(Throwable th) {
        if (f594a) {
            String stackTraceString = Log.getStackTraceString(th);
            Log.e("adprofsdk", stackTraceString);
            c(ExifInterface.LONGITUDE_EAST, stackTraceString);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m706a() {
        return f594a;
    }

    public static void b(String str) {
        if (!b() || str == null) {
            return;
        }
        Log.e("adprofsdk", str);
        c(ExifInterface.LONGITUDE_EAST, str);
    }

    public static void b(String str, String str2) {
        if (b()) {
            Log.e(str, str2);
        }
    }

    public static void b(String str, Throwable th) {
        if (b()) {
            Log.e("adprofsdk", str, th);
        }
    }

    public static boolean b() {
        if (f1367a > 9) {
            return b;
        }
        AdprofSdkConfig sdkConfig = AdprofSdk.getInstance().getSdkConfig();
        if (sdkConfig != null && sdkConfig.showLog) {
            b = true;
            if (f594a) {
                a();
            }
        }
        try {
            f1367a++;
            String path = AdprofSdk.getInstance().getContext().getCacheDir().getPath();
            StringBuilder sbAppend = new StringBuilder().append(path);
            String str = File.separator;
            File file = new File(sbAppend.append(str).append("xxx").toString());
            if (file.exists()) {
                f594a = true;
                b = true;
                f1367a = 10;
                a(file);
                return true;
            }
            String path2 = AdprofSdk.getInstance().getContext().getExternalCacheDir().getPath();
            File file2 = new File(path2 + str + "xxx");
            if (file2.exists()) {
                f594a = true;
                b = true;
                f1367a = 10;
                a(file2);
                a();
            }
            if (f1367a < 3) {
                Log.d("adprofsdk", " sdkpath = " + path + PPSLabelView.Code + f594a + PPSLabelView.Code + b + PPSLabelView.Code + file2.exists());
                Log.d("adprofsdk", " extPath = " + path2);
            }
            return b;
        } catch (Exception e) {
            Log.d("adprofsdk", "---path Exception " + e);
        }
    }

    public static void c(String str) {
        if (b()) {
            Log.i("adprofsdk", str);
            c("I", str);
        }
    }

    public static void c(String str, String str2) {
        if (!f594a || f591a == null) {
            return;
        }
        f593a.execute(new ok(str, str2));
    }

    public static void c(String str, Throwable th) {
        if (f594a) {
            String str2 = str + Log.getStackTraceString(th);
            Log.e("adprofsdk", str2);
            c(ExifInterface.LONGITUDE_EAST, str2);
        }
    }

    public static void d(String str) {
        if (f594a) {
            Log.i("adprofsdk", str);
            c("I", str);
        }
    }

    public static void e(String str) {
        if (b()) {
            Log.w("adprofsdk", str);
            c("W", str);
        }
    }
}
