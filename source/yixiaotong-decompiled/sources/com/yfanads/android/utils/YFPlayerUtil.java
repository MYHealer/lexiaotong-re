package com.yfanads.android.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFPlayerUtil {
    public static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    public static final ExecutorService EXECUTOR = Executors.newScheduledThreadPool(4);
}
