package com.miui.zeus.mimo.sdk;

import android.view.Surface;
import com.miui.zeus.comp.videoplayer.PlayState;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface i {
    void addEventListener(h hVar);

    long getCurrentPosition();

    long getDuration();

    PlayState getPlayState();

    int getVideoHeight();

    int getVideoWidth();

    void open(String str, Map<String, String> map);

    void pause();

    void release();

    void seekTo(int i);

    void setLooping(boolean z);

    void setMute(boolean z);

    void setScreenOnWhilePlaying(boolean z);

    void setSurface(Surface surface);

    void start();

    void stop();
}
