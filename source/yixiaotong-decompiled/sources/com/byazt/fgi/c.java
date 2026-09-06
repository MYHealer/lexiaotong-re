package com.byazt.fgi;

import android.content.Intent;
import android.os.IBinder;
import com.bytedance.pangle.plugin.Plugin;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface c {
    void attach(Plugin plugin);

    IBinder onBind(Intent intent);

    void onCreate();

    void onDestroy();

    int onStartCommand(Intent intent, int i, int i2);

    boolean onUnbind(Intent intent);
}
