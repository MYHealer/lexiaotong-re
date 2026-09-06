package com.miui.zeus.mimo.sdk;

import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.comp.videoplayer.PlayException;
import com.miui.zeus.comp.videoplayer.PlayState;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class j extends com.miui.zeus.mimo.sdk.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaPlayer f5465a = null;
    public Surface b = null;
    public boolean c = false;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j.this.f5465a.reset();
                j.this.f5465a.release();
            } catch (Exception | OutOfMemoryError e) {
                Log.w(ijiami_1011.s.s.s.d(new byte[]{101, 78, 17, Ascii.NAK, 92, 94, 49, 8, 7, Ascii.ESC, 84, Ascii.ETB}, "67ba93"), ijiami_1011.s.s.s.d(new byte[]{95, 86, 82, 13, 4, Ascii.CAN, 17, 8, 7, Ascii.ESC, 84, Ascii.ETB, Ascii.DC2, 65, 83, 8, 0, 89, Ascii.DC2, 1, 70, 7, 67, Ascii.ETB, 93, 65, Ascii.SYN}, "236de8") + e.getMessage());
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayer mediaPlayer = j.this.f5465a;
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f5468a;
        public final /* synthetic */ String b;

        public c(Map map, String str) {
            this.f5468a = map;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j.this.f5465a.reset();
                Map map = this.f5468a;
                if (map == null || map.isEmpty()) {
                    j.this.f5465a.setDataSource(this.b);
                } else {
                    j jVar = j.this;
                    jVar.f5465a.setDataSource(jVar.mContext, Uri.parse(this.b), this.f5468a);
                }
                j.this.f5465a.prepareAsync();
            } catch (Exception | OutOfMemoryError e) {
                j.a(j.this, e);
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5469a;

        public d(boolean z) {
            this.f5469a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                float f = this.f5469a ? 0.0f : 1.0f;
                j.this.f5465a.setVolume(f, f);
            } catch (Exception | OutOfMemoryError e) {
                j.a(j.this, e);
            }
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5470a;

        public e(boolean z) {
            this.f5470a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j.this.f5465a.setLooping(this.f5470a);
            } catch (Exception | OutOfMemoryError e) {
                j.a(j.this, e);
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (j.a(j.this)) {
                    return;
                }
                j.this.f5465a.start();
            } catch (Exception | OutOfMemoryError e) {
                j.a(j.this, e);
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (j.a(j.this)) {
                    j.this.f5465a.pause();
                }
            } catch (Exception | OutOfMemoryError e) {
                j.a(j.this, e);
            }
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5473a;

        public h(int i) {
            this.f5473a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (j.a(j.this)) {
                    j.this.f5465a.seekTo(this.f5473a);
                }
            } catch (Exception | OutOfMemoryError e) {
                j.a(j.this, e);
            }
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j.this.f5465a.stop();
            } catch (Exception | OutOfMemoryError e) {
                Log.w(ijiami_1011.s.s.s.d(new byte[]{100, 78, 75, 77, 3, 12, 49, 8, 7, Ascii.ESC, 84, Ascii.ETB}, "7789fa"), ijiami_1011.s.s.s.d(new byte[]{88, 84, 83, 13, 2, 19, 17, 8, 7, Ascii.ESC, 84, Ascii.ETB, Ascii.NAK, 66, 67, 11, 19, 19, 4, Ascii.SYN, Ascii.DC4, 13, 67, 69}, "517dc3") + e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.miui.zeus.mimo.sdk.j$j, reason: collision with other inner class name */
    public class RunnableC0860j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5475a;

        public RunnableC0860j(boolean z) {
            this.f5475a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j.this.f5465a.setScreenOnWhilePlaying(this.f5475a);
            } catch (Exception | OutOfMemoryError e) {
                j.a(j.this, e);
            }
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static ExecutorService f5476a = Executors.newSingleThreadExecutor();
    }

    public j() {
        a();
    }

    public static void a(j jVar, Throwable th) {
        PlayException playExceptionCreateForSource;
        jVar.getClass();
        if (th instanceof OutOfMemoryError) {
            playExceptionCreateForSource = PlayException.createForOutOfMemoryError((OutOfMemoryError) th);
        } else {
            playExceptionCreateForSource = th instanceof IOException ? PlayException.createForSource(th) : PlayException.createForUnexpected(th);
        }
        jVar.notifyOnError(playExceptionCreateForSource, 1, 0);
        Log.w(ijiami_1011.s.s.s.d(new byte[]{53, 72, 71, 71, 6, 84, 49, 8, 7, Ascii.ESC, 84, Ascii.ETB}, "f143c9"), ijiami_1011.s.s.s.d(new byte[]{11, 82, 7, 15, 7, 67, 17, 8, 7, Ascii.ESC, 84, Ascii.ETB, 70, 82, 17, Ascii.DC4, 9, 17, 65}, "f7cffc") + th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(MediaPlayer mediaPlayer) {
        updateState(PlayState.ENDED);
        notifyOnFinished();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(MediaPlayer mediaPlayer, int i2, int i3) {
        notifyOnVideoSizeChanged(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean c(MediaPlayer mediaPlayer, int i2, int i3) {
        if (i2 == 3) {
            notifyOnFirstFrameRendered();
        } else if (i2 == 701) {
            notifyOnLoadingChanged(true);
        } else if (i2 == 702) {
            notifyOnLoadingChanged(false);
        }
        return true;
    }

    public final void a() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f5465a = mediaPlayer;
        mediaPlayer.setAudioStreamType(3);
        this.f5465a.setOnPreparedListener(j$$Lambda$1.lambdaFactory$(this));
        this.f5465a.setOnCompletionListener(j$$Lambda$2.lambdaFactory$(this));
        this.f5465a.setOnErrorListener(j$$Lambda$3.lambdaFactory$(this));
        this.f5465a.setOnVideoSizeChangedListener(j$$Lambda$4.lambdaFactory$(this));
        this.f5465a.setOnInfoListener(j$$Lambda$5.lambdaFactory$(this));
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public long getCurrentPosition() {
        MediaPlayer mediaPlayer = this.f5465a;
        if (mediaPlayer == null || !this.mIsPrepared) {
            return 0L;
        }
        return mediaPlayer.getCurrentPosition();
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public long getDuration() {
        MediaPlayer mediaPlayer = this.f5465a;
        if (mediaPlayer == null || !this.mIsPrepared) {
            return -1L;
        }
        return mediaPlayer.getDuration();
    }

    @Override // com.miui.zeus.mimo.sdk.g, com.miui.zeus.mimo.sdk.i
    public void open(String str, Map<String, String> map) {
        this.mIsPrepared = false;
        this.c = false;
        k.f5476a.submit(new c(map, str));
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void pause() {
        this.c = false;
        if (this.mState == PlayState.PLAYING) {
            updateState(PlayState.PAUSED);
        }
        k.f5476a.submit(new g());
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void release() {
        this.c = false;
        updateState(PlayState.IDLE);
        k.f5476a.submit(new i());
        this.mIsMute = false;
        this.mIsPrepared = false;
        this.mIsLooping = false;
        k.f5476a.submit(new a());
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void seekTo(int i2) {
        k.f5476a.submit(new h(i2));
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void setLooping(boolean z) {
        this.mIsLooping = z;
        k.f5476a.submit(new e(z));
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void setMute(boolean z) {
        this.mIsMute = z;
        k.f5476a.submit(new d(z));
    }

    @Override // com.miui.zeus.mimo.sdk.g, com.miui.zeus.mimo.sdk.i
    public void setScreenOnWhilePlaying(boolean z) {
        k.f5476a.submit(new RunnableC0860j(z));
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void setSurface(Surface surface) {
        this.b = surface;
        try {
            this.f5465a.setSurface(surface);
        } catch (Exception e2) {
            Log.w(ijiami_1011.s.s.s.d(new byte[]{99, 74, Ascii.ETB, 67, 3, 92, 49, 8, 7, Ascii.ESC, 84, Ascii.ETB}, "03d7f1"), ijiami_1011.s.s.s.d(new byte[]{89, 80, 0, 91, 4, Ascii.SYN, 17, 8, 7, Ascii.ESC, 84, Ascii.ETB, Ascii.DC4, 70, 1, 70, 54, 67, 19, 2, 7, 1, 84, 69, 81, 71, Ascii.SYN, 93, Ascii.ETB, Ascii.SYN}, "45d2e6") + e2.getMessage());
        }
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void start() {
        Log.d(ijiami_1011.s.s.s.d(new byte[]{55, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 66, 6, 12, 49, 8, 7, Ascii.ESC, 84, Ascii.ETB}, "d936ca"), ijiami_1011.s.s.s.d(new byte[]{66, 17, 88, 68, 69, Ascii.SYN, 17, 8, 7, Ascii.ESC}, "1e9616"));
        this.c = true;
        if (this.mIsPrepared || this.mState == PlayState.PAUSED) {
            updateState(PlayState.PLAYING);
            k.f5476a.submit(new f());
        }
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void stop() {
        this.c = false;
        updateState(PlayState.IDLE);
        k.f5476a.submit(new i());
    }

    public static boolean a(j jVar) {
        MediaPlayer mediaPlayer = jVar.f5465a;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaPlayer mediaPlayer) {
        this.mIsPrepared = true;
        if (this.c) {
            updateState(PlayState.PLAYING);
            k.f5476a.submit(new b());
        } else {
            updateState(PlayState.PAUSED);
        }
        notifyOnPrepared();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MediaPlayer mediaPlayer, int i2, int i3) {
        PlayException playExceptionCreateForSource;
        updateState(PlayState.ERROR);
        if (i3 == -1004 || i3 == -1007 || i3 == -1010) {
            playExceptionCreateForSource = PlayException.createForSource(null);
        } else {
            playExceptionCreateForSource = i3 == -110 ? PlayException.createForTimeout(null) : PlayException.createForUnexpected(null);
        }
        notifyOnError(playExceptionCreateForSource, i2, i3);
        Log.w(ijiami_1011.s.s.s.d(new byte[]{48, 26, 69, 68, 6, 84, 49, 8, 7, Ascii.ESC, 84, Ascii.ETB}, "cc60c9"), ijiami_1011.s.s.s.d(new byte[]{8, 82, 93, 8, 83, 16, 17, 8, 7, Ascii.ESC, 84, Ascii.ETB, 69, 82, 75, 19, 93, 66, 65, Utf8.REPLACEMENT_BYTE}, "e79a20") + i2 + ijiami_1011.s.s.s.d(new byte[]{65, Ascii.EM, Ascii.CAN}, "a5818e") + i3 + ijiami_1011.s.s.s.d(new byte[]{59}, "f5ffdd"));
        return true;
    }
}
