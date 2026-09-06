package com.kwad.sdk.core.video.a;

import android.content.Context;
import android.media.MediaDataSource;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.wrapper.m;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodPlayerWrapper;
import com.kwai.video.ksvodplayerkit.KSVodVideoContext;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d extends com.kwad.sdk.core.video.a.a {
    private static volatile boolean aZp;
    private static final Queue<d> aZq = new ConcurrentLinkedQueue();
    private final String TAG;
    private MediaDataSource aZl;
    private final KSVodPlayerWrapper aZm;
    private final a aZn;
    private boolean aZo;
    private boolean aZr;
    private com.kwad.sdk.contentalliance.a.a.b amC;
    private boolean anE;
    private boolean anF;
    private final Object any;
    private String anz;
    private int mSarDen;
    private int mSarNum;

    public final void bK(boolean z) {
        this.aZr = z;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.anz;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 2;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.aZo;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z) {
    }

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.anF = false;
        return false;
    }

    public d(int i) {
        Object obj = new Object();
        this.any = obj;
        this.anF = false;
        this.aZr = true;
        synchronized (obj) {
            this.aZm = new KSVodPlayerWrapper(m.Yb());
        }
        String str = "KSMediaPlayer[" + i + "]";
        this.TAG = str;
        this.aZn = new a(this, str);
        xK();
        setLooping(false);
        com.kwad.sdk.core.d.c.i(str, "create KwaiMediaPlayer");
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.any) {
            if (!this.anE) {
                this.aZm.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(com.kwad.sdk.contentalliance.a.a.b bVar) {
        this.amC = bVar;
        a(bVar.aKK);
        f fVar = (f) ServiceProvider.get(f.class);
        if (!TextUtils.isEmpty(bVar.manifest) && fVar != null && fVar.Ag()) {
            setDataSource(bVar.manifest, (Map<String, String>) null);
        } else {
            setDataSource(bVar.videoUrl, (Map<String, String>) null);
        }
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        if (this.aZm == null || aVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(aVar.photoId);
        kSVodVideoContext.mClickTime = aVar.clickTime;
        kSVodVideoContext.mExtra = aVar.IF();
        this.aZm.updateVideoContext(kSVodVideoContext);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSurface(Surface surface) {
        this.aZm.setSurface(surface);
    }

    private void setDataSource(String str, Map<String, String> map) {
        this.anz = str;
        this.aZm.setDataSource(str, (Map) null);
    }

    private void OG() {
        MediaDataSource mediaDataSource = this.aZl;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.aZl = null;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        if (this.aZr) {
            Queue<d> queue = aZq;
            if (!queue.contains(this)) {
                queue.offer(this);
            }
            int size = queue.size();
            if (size == 1) {
                com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync first");
                OH();
                return true;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync pending size: " + size);
            return false;
        }
        OH();
        return true;
    }

    private void OH() {
        com.kwad.sdk.core.d.c.i(this.TAG, "realPrepare hasCallPrepare: " + this.anF);
        if (this.anF) {
            return;
        }
        try {
            this.anF = true;
            int iPrepareAsync = this.aZm.prepareAsync();
            OF();
            com.kwad.sdk.core.d.c.i(this.TAG, "realPrepare result: " + iPrepareAsync);
        } catch (IllegalStateException e) {
            com.kwad.sdk.core.d.c.e(this.TAG, "realPrepare failed ", e);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean xJ() {
        com.kwad.sdk.core.d.c.i(this.TAG, "forcePrepareAsync");
        OH();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        com.kwad.sdk.core.d.c.i(this.TAG, "start");
        this.aZm.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.aZm.stop();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.aZm.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.aZm.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.aZm.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        KSVodPlayerWrapper kSVodPlayerWrapper = this.aZm;
        return kSVodPlayerWrapper == null ? "" : kSVodPlayerWrapper.getCurrentPlayUrl();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.aZm.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j) {
        this.aZm.seekTo((int) j);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.aZm.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        try {
            return this.aZm.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        Queue<d> queue = aZq;
        com.kwad.sdk.core.d.c.i(this.TAG, "release remote player ret: " + queue.remove(this) + ", player list size: " + queue.size());
        this.anE = true;
        this.aZm.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.a.d.1
            public final void onPlayerRelease() {
                com.kwad.sdk.core.d.c.i(d.this.TAG, "onPlayerRelease");
            }
        });
        try {
            OG();
            resetListeners();
            xL();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        this.anF = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.aZm.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException unused) {
        }
        OG();
        resetListeners();
        xK();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z) {
        this.aZo = z;
        this.aZm.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f, float f2) {
        this.aZm.setVolume(f, f2);
        o(f);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.aZm.getKwaiMediaPlayer().getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f) {
        this.aZm.setSpeed(f);
    }

    private void xK() {
        this.aZm.setOnPreparedListener(this.aZn);
        this.aZm.setBufferingUpdateListener(this.aZn);
        this.aZm.setOnEventListener(this.aZn);
        this.aZm.setVideoSizeChangedListener(this.aZn);
        this.aZm.setOnErrorListener(this.aZn);
    }

    private void xL() {
        this.aZm.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.aZm.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.aZm.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.aZm.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.aZm.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
    }

    static class a implements IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        final String TAG;
        final WeakReference<d> mWeakMediaPlayer;

        a(d dVar, String str) {
            this.mWeakMediaPlayer = new WeakReference<>(dVar);
            this.TAG = str;
        }

        private d OJ() {
            return this.mWeakMediaPlayer.get();
        }

        public final void onEvent(int i, int i2) {
            com.kwad.sdk.core.d.c.i(this.TAG, "onEvent, what: " + i);
            try {
                d dVarOJ = OJ();
                if (dVarOJ != null) {
                    if (i == 10100) {
                        dVarOJ.notifyOnSeekComplete();
                    } else {
                        if (i == 10101) {
                            dVarOJ.notifyOnCompletion();
                            return;
                        }
                        if (i == 10209) {
                            dVarOJ.OI();
                        }
                        dVarOJ.notifyOnInfo(i, i2);
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }

        public final void onBufferingUpdate(int i) {
            d dVarOJ = OJ();
            if (dVarOJ != null) {
                dVarOJ.notifyOnBufferingUpdate(i);
            }
        }

        public final void onError(int i, int i2) {
            d dVarOJ = OJ();
            if (dVarOJ != null) {
                d.a(dVarOJ, false);
                dVarOJ.notifyOnError(i, i2);
            }
        }

        public final void onPrepared() {
            com.kwad.sdk.core.d.c.i(this.TAG, "onPrepared");
            d dVarOJ = OJ();
            if (dVarOJ != null) {
                dVarOJ.notifyOnPrepared();
            }
        }

        public final void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            com.kwad.sdk.core.d.c.i(this.TAG, "onVideoSizeChanged width: " + i + ", height: " + i2 + ", sarNum:" + i3 + ", sarDen:" + i4);
            d dVarOJ = OJ();
            if (dVarOJ != null) {
                dVarOJ.D(i, i2);
                dVarOJ.mSarNum = i3;
                dVarOJ.mSarDen = i4;
            }
        }

        public final void onPlayerRelease() {
            com.kwad.sdk.core.d.c.i(this.TAG, "onPlayerRelease");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI() {
        Iterator<d> it = aZq.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = 0;
                break;
            } else if (it.next() == this) {
                break;
            } else {
                i++;
            }
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "preloadNextPlayer next player index: " + i);
        int i2 = i + 1;
        if (i2 < aZq.size()) {
            com.kwad.sdk.core.d.c.i(this.TAG, "----------------preloadNextPlayer prepare next player----------------");
            for (int i3 = 0; i3 < i2; i3++) {
                aZq.poll();
            }
            Queue<d> queue = aZq;
            d dVarPoll = queue.poll();
            queue.clear();
            if (dVarPoll != null) {
                dVarPoll.prepareAsync();
            } else {
                com.kwad.sdk.core.d.c.i(this.TAG, "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }
}
