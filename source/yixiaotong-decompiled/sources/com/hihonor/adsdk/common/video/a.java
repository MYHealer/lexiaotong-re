package com.hihonor.adsdk.common.video;

import android.content.Context;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a implements IPlayer {
    protected boolean hnadsd = true;
    protected final Map<String, OnVideoStatusChangeListener> hnadse = new HashMap();
    protected boolean hnadsf = false;
    protected String hnadsg;
    protected long hnadsh;
    protected boolean hnadsi;
    protected int hnadsj;
    protected int hnadsk;
    protected AdVideoSize hnadsl;
    protected Context hnadsm;

    public a(Context context) {
        this.hnadsm = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void addOnAdVideoListener(String str, OnVideoStatusChangeListener onVideoStatusChangeListener) {
        if (this.hnadse.containsKey(str)) {
            return;
        }
        this.hnadse.put(str, onVideoStatusChangeListener);
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public int getState() {
        return 0;
    }

    protected void hnadsa(long j, long j2) {
        Iterator<String> it = this.hnadse.keySet().iterator();
        while (it.hasNext()) {
            OnVideoStatusChangeListener onVideoStatusChangeListener = this.hnadse.get(it.next());
            if (onVideoStatusChangeListener != null) {
                onVideoStatusChangeListener.onVideoPrepared(j, j2);
            }
        }
    }

    protected void hnadsb() {
        Iterator<String> it = this.hnadse.keySet().iterator();
        while (it.hasNext()) {
            OnVideoStatusChangeListener onVideoStatusChangeListener = this.hnadse.get(it.next());
            if (onVideoStatusChangeListener != null) {
                onVideoStatusChangeListener.onVideoPause();
            }
        }
    }

    protected void hnadsc() {
        Iterator<String> it = this.hnadse.keySet().iterator();
        while (it.hasNext()) {
            OnVideoStatusChangeListener onVideoStatusChangeListener = this.hnadse.get(it.next());
            if (onVideoStatusChangeListener != null) {
                onVideoStatusChangeListener.onVideoPrepare();
            }
        }
    }

    protected void hnadsd() {
        Iterator<String> it = this.hnadse.keySet().iterator();
        while (it.hasNext()) {
            OnVideoStatusChangeListener onVideoStatusChangeListener = this.hnadse.get(it.next());
            if (onVideoStatusChangeListener != null) {
                onVideoStatusChangeListener.onVideoResume();
            }
        }
    }

    protected void hnadse() {
        Iterator<String> it = this.hnadse.keySet().iterator();
        while (it.hasNext()) {
            OnVideoStatusChangeListener onVideoStatusChangeListener = this.hnadse.get(it.next());
            if (onVideoStatusChangeListener != null) {
                onVideoStatusChangeListener.onVideoStart();
            }
        }
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public boolean isMuted() {
        return this.hnadsf;
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void removeAdVideoListener(String str) {
        this.hnadse.remove(str);
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void removeAllAdVideoListener() {
        this.hnadse.clear();
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void setMuted(boolean z) {
        this.hnadsf = z;
    }

    protected void hnadsa(boolean z) {
        Iterator<String> it = this.hnadse.keySet().iterator();
        while (it.hasNext()) {
            OnVideoStatusChangeListener onVideoStatusChangeListener = this.hnadse.get(it.next());
            if (onVideoStatusChangeListener != null) {
                onVideoStatusChangeListener.onVideoBuffering(z);
            }
        }
    }

    protected void hnadsb(boolean z) {
        Iterator<String> it = this.hnadse.keySet().iterator();
        while (it.hasNext()) {
            OnVideoStatusChangeListener onVideoStatusChangeListener = this.hnadse.get(it.next());
            if (onVideoStatusChangeListener != null) {
                onVideoStatusChangeListener.onVideoMute(z);
            }
        }
    }

    protected void hnadsa() {
        Iterator<String> it = this.hnadse.keySet().iterator();
        while (it.hasNext()) {
            OnVideoStatusChangeListener onVideoStatusChangeListener = this.hnadse.get(it.next());
            if (onVideoStatusChangeListener != null) {
                onVideoStatusChangeListener.onVideoEnd();
            }
        }
    }

    protected void hnadsa(int i, String str, int i2) {
        Iterator<String> it = this.hnadse.keySet().iterator();
        while (it.hasNext()) {
            OnVideoStatusChangeListener onVideoStatusChangeListener = this.hnadse.get(it.next());
            if (onVideoStatusChangeListener != null) {
                onVideoStatusChangeListener.onVideoError(i, str, i2);
            }
        }
    }

    protected void hnadsa(long j, long j2, long j3) {
        Iterator<String> it = this.hnadse.keySet().iterator();
        while (it.hasNext()) {
            OnVideoStatusChangeListener onVideoStatusChangeListener = this.hnadse.get(it.next());
            if (onVideoStatusChangeListener != null) {
                onVideoStatusChangeListener.onProgressUpdate(j, j2, j3);
            }
        }
    }
}
