package com.jd.ad.sdk.bl.preload;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jd.ad.sdk.jad_kx.jad_er;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PreloadAdDataCacheUsageManager implements Handler.Callback {
    public Handler jad_an = new Handler(Looper.getMainLooper(), this);
    public int jad_bo;
    public UseCacheCounterFinishCallback jad_cp;

    public interface UseCacheCounterFinishCallback {
        void onUseCacheCounterFinish();
    }

    public PreloadAdDataCacheUsageManager() {
        this.jad_bo = 3;
        this.jad_bo = jad_er.jad_an.jad_an.jad_cp();
    }

    public void setCounterFinishCallback(UseCacheCounterFinishCallback useCacheCounterFinishCallback) {
        this.jad_cp = useCacheCounterFinishCallback;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        UseCacheCounterFinishCallback useCacheCounterFinishCallback = this.jad_cp;
        if (useCacheCounterFinishCallback != null) {
            useCacheCounterFinishCallback.onUseCacheCounterFinish();
        }
        Handler handler = this.jad_an;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.jad_an = null;
        }
        setCounterFinishCallback(null);
        return true;
    }

    public void startPreloadAdDataCacheUsageTimeCounter() {
        Handler handler = this.jad_an;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1, ((long) this.jad_bo) * 1000);
        }
    }
}
