package com.byazt.dna;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface qp {

    public interface c {
        void handleMsg(Message message);
    }

    void executeFastTask(Runnable runnable);

    void executeFastTask(Runnable runnable, int i);

    void executeNormalTask(Runnable runnable);

    ExecutorService getAIDLExecutor();

    Handler getCsjMainHandler();

    ExecutorService getFastExecutor();

    Handler getIOHandler();

    ExecutorService getIoExecutor();

    Handler getMainHandler();

    ExecutorService getNormalExecutor();

    ScheduledExecutorService getScheduledThreadPool();

    ExecutorService newCachedThreadPool(int i, int i2);

    Handler obtainHandler(c cVar, String str);

    Handler obtainHandler(String str);

    void postIOTask(Runnable runnable);

    void recycleHandler(Handler handler);

    void updateSettings(JSONObject jSONObject);
}
