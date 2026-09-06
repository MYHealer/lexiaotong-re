package com.ubixnow.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.loopj.android.http.AsyncHttpClient;
import com.ubixnow.ooooo.ooo0o;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class BaseUtils {
    private static File cacheDir;
    private static File externalDir;
    private static Context mContext;
    private static Handler mUiHandler;

    public static BufferedInputStream decodeInputStream(InputStream inputStream, String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return new BufferedInputStream(inputStream);
        }
        if (str.toLowerCase().equals(AsyncHttpClient.ENCODING_GZIP)) {
            return new BufferedInputStream(new GZIPInputStream(inputStream));
        }
        return str.toLowerCase().equals("deflate") ? new BufferedInputStream(new InflaterInputStream(inputStream)) : new BufferedInputStream(inputStream);
    }

    public static File getCacheDir() {
        return cacheDir;
    }

    public static Context getContext() {
        return mContext;
    }

    public static File getExternalDir() {
        return externalDir;
    }

    public static int getScreenHeight() {
        WindowManager windowManager = (WindowManager) mContext.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth() {
        WindowManager windowManager = (WindowManager) mContext.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static synchronized Handler getUiHandler() {
        return mUiHandler;
    }

    public static synchronized void init(Context context) {
        mContext = context;
        if (externalDir == null) {
            externalDir = context.getExternalCacheDir();
        }
        if (cacheDir == null) {
            cacheDir = context.getCacheDir();
        }
        if (mUiHandler == null) {
            mUiHandler = new Handler(mContext.getMainLooper());
        }
    }

    public static boolean isRunInMainThread() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    public static String parseInputString(BufferedInputStream bufferedInputStream) throws Exception {
        String str = null;
        Closeable closeable = null;
        if (bufferedInputStream != null) {
            try {
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    } catch (Throwable th) {
                        th = th;
                        closeable = bufferedReader;
                        ooo0o.OooO00o(bufferedInputStream);
                        ooo0o.OooO00o(closeable);
                        throw th;
                    }
                }
                str = new String(sb);
                ooo0o.OooO00o(bufferedInputStream);
                ooo0o.OooO00o(bufferedReader);
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return str;
    }

    public static void post(Runnable runnable) {
        getUiHandler().post(runnable);
    }

    public static void postDelayed(Runnable runnable, long j) {
        getUiHandler().postDelayed(runnable, j);
    }

    public static void runInMainThread(Runnable runnable) {
        if (isRunInMainThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }
}
