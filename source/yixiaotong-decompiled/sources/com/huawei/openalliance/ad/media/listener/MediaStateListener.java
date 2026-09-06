package com.huawei.openalliance.ad.media.listener;

import com.huawei.openalliance.ad.media.MediaPlayerAgent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface MediaStateListener {
    void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i);

    void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i);

    void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i);

    void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i);

    void onProgress(int i, int i2);
}
