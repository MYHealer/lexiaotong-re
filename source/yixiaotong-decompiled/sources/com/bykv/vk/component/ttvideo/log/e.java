package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import android.provider.Settings;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public enum e {
    instance;


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private VideoEventEngineUploader f2973a;
    private Context b;

    private void a(JSONObject jSONObject) {
        if (((TTVideoEngineLog.LogNotifyLevel >> 2) & 1) == 1 || ((TTVideoEngineLog.LogTurnOn >> 2) & 1) == 1) {
            TTVideoEngineLog.i("VideoEventManager", jSONObject.toString());
        }
        if (((TTVideoEngineLog.LogTurnOn >> 1) & 1) == 1) {
            Context context = this.b;
            String string = context != null ? Settings.Global.getString(context.getContentResolver(), "engine.debug") : "";
            if (string != null) {
                for (String str : string.split(",", -1)) {
                    if (jSONObject.opt(str) != null) {
                        TTVideoEngineLog.i("VideoEventManager", str + x.bQ + jSONObject.opt(str));
                    }
                }
            }
        }
    }

    public void a(Context context) {
        this.b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public synchronized void a(VideoEventEngineUploader videoEventEngineUploader) {
        this.f2973a = videoEventEngineUploader;
    }

    protected void a(boolean z, JSONObject jSONObject) {
        synchronized (e.class) {
            try {
                if (jSONObject == null) {
                    return;
                }
                a(jSONObject);
                VideoEventEngineUploader videoEventEngineUploader = this.f2973a;
                if (videoEventEngineUploader != null) {
                    videoEventEngineUploader.onEvent("video_playq", jSONObject);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
