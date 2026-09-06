package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.util.Log;
import com.google.common.base.Ascii;
import com.miui.zeus.comp.videoplayer.PlayException;
import com.miui.zeus.comp.videoplayer.PlayState;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class g implements i {
    private static final String LOG_TAG = ijiami_1011.s.s.s.d(new byte[]{123, 0, 68, 87, 49, 88, 0, Ascii.GS, 3, 16}, "9a72a4");
    public Context mContext;
    public PlayState mState = PlayState.IDLE;
    public boolean mIsPrepared = false;
    public boolean mIsMute = false;
    public boolean mIsLooping = false;
    public int mVideoWidth = 0;
    public int mVideoHeight = 0;
    public CopyOnWriteArraySet<h> mVideoListeners = new CopyOnWriteArraySet<>();

    @Override // com.miui.zeus.mimo.sdk.i
    public void addEventListener(h hVar) {
        this.mVideoListeners.add(hVar);
    }

    public boolean getLooping() {
        return this.mIsLooping;
    }

    public boolean getMute() {
        return this.mIsMute;
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public PlayState getPlayState() {
        return this.mState;
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public void notifyOnError(PlayException playException, int i, int i2) {
        Iterator<h> it = this.mVideoListeners.iterator();
        while (it.hasNext()) {
            it.next().a(playException, i, i2);
        }
        Log.w(LOG_TAG, ijiami_1011.s.s.s.d(new byte[]{87, 13, 67, Ascii.SYN, 93, 83, Ascii.CAN, 1, Ascii.DC4, 66, 84, Ascii.ETB, 74, 12, 17, 70}, "8ccf12"));
    }

    public void notifyOnFinished() {
        Iterator<h> it = this.mVideoListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        Log.d(LOG_TAG, ijiami_1011.s.s.s.d(new byte[]{121, 89, 116, 88, 88, 66, 13, 1, Ascii.DC2, 11, 94, 11}, "677752"));
    }

    public void notifyOnFirstFrameRendered() {
        Iterator<h> it = this.mVideoListeners.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        Log.d(LOG_TAG, ijiami_1011.s.s.s.d(new byte[]{86, 95, 35, 12, 69, 66, Ascii.NAK, 34, Ascii.DC4, 3, 92, 0, 107, 84, 11, 1, 82, 67, 4, 0}, "91ee71"));
    }

    public void notifyOnLoadingChanged(boolean z) {
        Iterator<h> it = this.mVideoListeners.iterator();
        while (it.hasNext()) {
            it.next().a(false);
        }
        Log.d(LOG_TAG, ijiami_1011.s.s.s.d(new byte[]{12, 13, 47, 92, 85, 7, 8, 10, 1, 33, 89, 4, 13, 4, 6, 87, Ascii.DC4}, "ccc34c") + z);
    }

    public void notifyOnPrepared() {
        Iterator<h> it = this.mVideoListeners.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        Log.d(LOG_TAG, ijiami_1011.s.s.s.d(new byte[]{121, 94, 105, 68, 83, 19, 0, Ascii.SYN, 3, 6}, "60966c"));
    }

    public void notifyOnVideoSizeChanged(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        Iterator<h> it = this.mVideoListeners.iterator();
        while (it.hasNext()) {
            it.next().a(i, i2);
        }
        Log.w(LOG_TAG, ijiami_1011.s.s.s.d(new byte[]{92, 89, 110, 92, 87, 83, 14, 55, 15, Ascii.CAN, 84, 38, 91, 86, 86, 82, 86, 82, 58}, "378536") + i + ijiami_1011.s.s.s.d(new byte[]{70, Ascii.NAK, Ascii.CAN}, "f9847f") + i2 + ijiami_1011.s.s.s.d(new byte[]{108}, "1acb53"));
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void open(String str, Map<String, String> map) {
    }

    public void removeEventListener(h hVar) {
        this.mVideoListeners.remove(hVar);
    }

    public void setContext(Context context) {
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void setScreenOnWhilePlaying(boolean z) {
    }

    public void updateState(PlayState playState) {
        PlayState playState2 = this.mState;
        if (playState2 == playState) {
            return;
        }
        this.mState = playState;
        Iterator<h> it = this.mVideoListeners.iterator();
        while (it.hasNext()) {
            it.next().a(playState2, playState);
        }
    }
}
