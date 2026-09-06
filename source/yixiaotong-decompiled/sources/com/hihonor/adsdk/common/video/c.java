package com.hihonor.adsdk.common.video;

import android.content.Context;
import android.view.View;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class c {
    private static final String hnadse = "PlayerAdapter";
    protected IPlayer hnadsa = hnadsj();
    protected Context hnadsb;
    private OnVideoSwitchListener hnadsc;
    private OnVideoSwitchListener hnadsd;

    public c(Context context) {
        this.hnadsb = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public void hnadsa(OnVideoSwitchListener onVideoSwitchListener) {
        this.hnadsc = onVideoSwitchListener;
    }

    public void hnadsb(OnVideoSwitchListener onVideoSwitchListener) {
        this.hnadsd = onVideoSwitchListener;
    }

    public OnVideoSwitchListener hnadsd() {
        return this.hnadsc;
    }

    public OnVideoSwitchListener hnadse() {
        return this.hnadsd;
    }

    protected abstract a hnadsj();

    public void hnadsa(long j) {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            iPlayer.seekTo(j);
        }
    }

    public void hnadsb(String str) {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            iPlayer.startUri(str);
        }
    }

    public void hnadsc(boolean z) {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            iPlayer.setMuted(z);
        }
    }

    public long hnadsf() {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            return iPlayer.getDuration();
        }
        return 0L;
    }

    public int hnadsg() {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            return iPlayer.getState();
        }
        return 0;
    }

    public boolean hnadsh() {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            return iPlayer.isMuted();
        }
        return true;
    }

    public boolean hnadsi() {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            return iPlayer.isPlaying();
        }
        return false;
    }

    public View hnadsk() {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            return iPlayer.getPlayerView();
        }
        return null;
    }

    public void hnadsl() {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            iPlayer.pause();
        }
    }

    public void hnadsm() {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            iPlayer.release();
        }
    }

    public void hnadsn() {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            iPlayer.removeAllAdVideoListener();
        }
    }

    public void hnadso() {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            iPlayer.replay();
        }
    }

    public void hnadsp() {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            iPlayer.resume();
        }
    }

    public void hnadsa(String str, OnVideoStatusChangeListener onVideoStatusChangeListener) {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            iPlayer.addOnAdVideoListener(str, onVideoStatusChangeListener);
        }
    }

    public long hnadsc() {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            return iPlayer.getCurrentPosition();
        }
        return 0L;
    }

    public void hnadsb(boolean z) {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            iPlayer.setCacheEnable(z);
        }
    }

    public void hnadsa(String str) {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            iPlayer.removeAdVideoListener(str);
        }
    }

    public long hnadsb() {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            return iPlayer.getBufferedPosition();
        }
        return 0L;
    }

    public void hnadsa(AdVideoSize adVideoSize, int i, int i2) {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            iPlayer.setVideoViewSize(adVideoSize, i, i2);
        }
    }

    public void hnadsa(boolean z) {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            iPlayer.notifyVisibilityChange(z);
        }
    }

    public int hnadsa() {
        IPlayer iPlayer = this.hnadsa;
        if (iPlayer != null) {
            return iPlayer.getBufferedPercentage();
        }
        return 0;
    }
}
