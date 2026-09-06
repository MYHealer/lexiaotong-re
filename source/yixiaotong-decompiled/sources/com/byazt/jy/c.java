package com.byazt.jy;

import android.content.Context;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2021, 20})
public class c {
    public static volatile boolean c;
    public static final AtomicBoolean tt = new AtomicBoolean(false);

    public static void c(Context context, String str, int i, String[] strArr, long[] jArr, VideoEventEngineUploader videoEventEngineUploader) {
        if (c) {
            return;
        }
        try {
            TTVideoEngine.setCacheInfoLists(strArr, jArr);
            TTVideoEngine.setStringValue(0, str);
            TTVideoEngine.setIntValue(1, i);
            TTVideoEngine.setIntValue(11, 5);
            TTVideoEngine.setIntValue(2, 10);
            TTVideoEngine.setIntValue(3, 10);
            TTVideoEngine.setIntValue(4, 3);
            TTVideoEngine.setVideoEventUploader(videoEventEngineUploader);
        } catch (Exception e) {
            m.c(e);
        }
        c = true;
    }

    public static void c(boolean z) {
        if (z) {
            TTVideoEngineLog.turnOn(1, 1);
            AVMDLLog.turnOn(1, 1);
        } else {
            TTVideoEngineLog.turnOn(1, 0);
        }
    }

    public static TTVideoEngine c(Context context) {
        if (!tt.getAndSet(true)) {
            TTVideoEngine.startDataLoader(context);
        }
        TTVideoEngine tTVideoEngine = new TTVideoEngine(context, 0);
        tTVideoEngine.setIntOption(160, 1);
        tTVideoEngine.setIntOption(11, 10);
        tTVideoEngine.setIntOption(12, 10);
        tTVideoEngine.setMaxRetryCount(2);
        tTVideoEngine.setScreenOnWhilePlaying(true);
        return tTVideoEngine;
    }
}
