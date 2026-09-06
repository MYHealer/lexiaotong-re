package com.miui.zeus.comp.zeusplayer.xiaomiplayer;

import android.content.Context;
import android.view.Surface;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.comp.videoplayer.PlayException;
import com.miui.zeus.comp.videoplayer.PlayState;
import com.miui.zeus.mimo.sdk.j9;
import com.miui.zeus.mimo.sdk.k9;
import com.miui.zeus.mimo.sdk.l9;
import com.miui.zeus.mimo.sdk.m9;
import com.miui.zeus.mimo.sdk.n9;
import com.miui.zeus.mimo.sdk.o9;
import com.miui.zeus.mimo.sdk.p9;
import ijiami_1011.s.s.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.videolan.libvlc.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ZeusMediaXiaoMiPlayer extends com.miui.zeus.mimo.sdk.g {
    private static final String LOG_TAG = s.d(new byte[]{107, 84, 76, 67, 43, 81, 5, 13, 7, 58, 88, 4, 94, 124, 80, 96, 10, 85, Ascii.CAN, 1, Ascii.DC4}, "1190f4");
    private int mSessionId;
    private o9 mMediaPlayer = null;
    private Surface mSurface = null;
    public boolean mPlayWhenReady = false;

    public class a implements m9 {
        public a() {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayer mediaPlayer;
            try {
                if (!ZeusMediaXiaoMiPlayer.this.isPlayerPlaying() || (mediaPlayer = ZeusMediaXiaoMiPlayer.this.mMediaPlayer.k) == null) {
                    return;
                }
                mediaPlayer.pause();
            } catch (Throwable th) {
                ZeusMediaXiaoMiPlayer.this.onPlayerException(th);
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5255a;

        public c(int i) {
            this.f5255a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (ZeusMediaXiaoMiPlayer.this.isPlayerPlaying()) {
                    ZeusMediaXiaoMiPlayer.this.mMediaPlayer.a(this.f5255a);
                }
            } catch (Throwable th) {
                ZeusMediaXiaoMiPlayer.this.onPlayerException(th);
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                o9 o9Var = ZeusMediaXiaoMiPlayer.this.mMediaPlayer;
                MediaPlayer mediaPlayer = o9Var.k;
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
                o9Var.M = false;
            } catch (Throwable unused) {
            }
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5257a;

        public e(boolean z) {
            this.f5257a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ZeusMediaXiaoMiPlayer.this.mMediaPlayer.getClass();
            } catch (Throwable unused) {
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                o9 o9Var = ZeusMediaXiaoMiPlayer.this.mMediaPlayer;
                o9Var.K = true;
                if (o9Var.k != null) {
                    o9Var.b();
                    o9Var.f = null;
                }
                o9Var.K = false;
                o9 o9Var2 = ZeusMediaXiaoMiPlayer.this.mMediaPlayer;
                if (o9Var2.k != null) {
                    o9Var2.b();
                    o9Var2.a();
                    o9Var2.m = null;
                    o9Var2.f = null;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public class g implements j9 {
        public g() {
        }
    }

    public class h implements k9 {
        public h() {
        }
    }

    public class i implements n9 {
        public i() {
        }
    }

    public class j implements l9 {
        public j() {
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f5263a;
        public final /* synthetic */ String b;

        public k(Map map, String str) {
            this.f5263a = map;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HashMap map = new HashMap();
                Map map2 = this.f5263a;
                if (map2 != null) {
                    map.putAll(map2);
                }
                map.put(s.d(new byte[]{17, 16, 1, SignedBytes.MAX_POWER_OF_TWO, 7, 70, 4, 73, Ascii.SYN, 3, 68, Ascii.SYN, 4, 6}, "abd0f4"), s.d(new byte[]{1}, "08d123"));
                map.put(s.d(new byte[]{19, 4, 65, 69, 92, Ascii.ESC, 0, 2, Ascii.DC2, 7, 67, 72, 6, 10, 82}, "ce4696"), s.d(new byte[]{1}, "065c38"));
                ZeusMediaXiaoMiPlayer.this.mMediaPlayer.a(this.b, map);
                ZeusMediaXiaoMiPlayer.this.mMediaPlayer.g();
            } catch (Throwable th) {
                ZeusMediaXiaoMiPlayer.this.onPlayerException(th);
            }
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5264a;

        public l(boolean z) {
            this.f5264a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                float f = this.f5264a ? 0.0f : 1.0f;
                ZeusMediaXiaoMiPlayer.this.mMediaPlayer.a(f, f);
            } catch (Throwable th) {
                ZeusMediaXiaoMiPlayer.this.onPlayerException(th);
            }
        }
    }

    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5265a;

        public m(boolean z) {
            this.f5265a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                o9 o9Var = ZeusMediaXiaoMiPlayer.this.mMediaPlayer;
                boolean z = this.f5265a;
                MediaPlayer mediaPlayer = o9Var.k;
                if (mediaPlayer != null) {
                    mediaPlayer.setLooping(z);
                }
            } catch (Exception | OutOfMemoryError e) {
                ZeusMediaXiaoMiPlayer.this.onPlayerException(e);
            }
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (ZeusMediaXiaoMiPlayer.this.isPlayerPlaying()) {
                    return;
                }
                ZeusMediaXiaoMiPlayer.this.mMediaPlayer.j();
            } catch (Throwable th) {
                ZeusMediaXiaoMiPlayer.this.onPlayerException(th);
            }
        }
    }

    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static ExecutorService f5267a = Executors.newSingleThreadExecutor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asyncCall(Runnable runnable) {
        o.f5267a.submit(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PlayException getPlayException(int i2) {
        if (i2 == -1004 || i2 == -1007 || i2 == -1010) {
            return PlayException.createForSource(null);
        }
        return i2 == -110 ? PlayException.createForTimeout(null) : PlayException.createForUnexpected(null);
    }

    private PlayException getPlayException(Throwable th) {
        if (th instanceof OutOfMemoryError) {
            return PlayException.createForOutOfMemoryError((OutOfMemoryError) th);
        }
        return th instanceof IOException ? PlayException.createForSource(th) : PlayException.createForUnexpected(th);
    }

    private void initPlayer(Context context) {
        o9 o9Var = new o9(context);
        this.mMediaPlayer = o9Var;
        o9Var.f5464a = new a();
        o9Var.b = new g();
        o9Var.d = new h();
        o9Var.c = new i();
        o9Var.e = new j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPlayerPlaying() {
        o9 o9Var = this.mMediaPlayer;
        return o9Var != null && o9Var.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayerException(Throwable th) {
        notifyOnError(getPlayException(th), 1, 0);
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public long getCurrentPosition() {
        o9 o9Var = this.mMediaPlayer;
        if (o9Var == null || !this.mIsPrepared) {
            return 0L;
        }
        return o9Var.c();
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public long getDuration() {
        o9 o9Var = this.mMediaPlayer;
        if (o9Var == null || !this.mIsPrepared) {
            return -1L;
        }
        return o9Var.d();
    }

    public boolean hasAudioTrack() {
        p9[] p9VarArr;
        MediaPlayer.TrackDescription[] spuTracks;
        MediaPlayer.TrackDescription[] audioTracks;
        MediaPlayer.TrackDescription[] videoTracks;
        o9 o9Var = this.mMediaPlayer;
        if (o9Var != null) {
            if (o9Var.k == null) {
                p9VarArr = null;
            } else {
                ArrayList arrayList = new ArrayList();
                if (o9Var.k.getVideoTracksCount() > 0 && (videoTracks = o9Var.k.getVideoTracks()) != null) {
                    for (MediaPlayer.TrackDescription trackDescription : videoTracks) {
                        if (trackDescription.id >= 0) {
                            o9.a aVar = new o9.a();
                            trackDescription.name.isEmpty();
                            aVar.f5556a = 1;
                            arrayList.add(aVar);
                        }
                    }
                }
                if (o9Var.k.getAudioTracksCount() > 0 && (audioTracks = o9Var.k.getAudioTracks()) != null) {
                    for (MediaPlayer.TrackDescription trackDescription2 : audioTracks) {
                        if (trackDescription2.id >= 0) {
                            o9.a aVar2 = new o9.a();
                            trackDescription2.name.isEmpty();
                            aVar2.f5556a = 2;
                            arrayList.add(aVar2);
                        }
                    }
                }
                if (o9Var.k.getSpuTracksCount() > 0 && (spuTracks = o9Var.k.getSpuTracks()) != null) {
                    for (MediaPlayer.TrackDescription trackDescription3 : spuTracks) {
                        if (trackDescription3.id >= 0) {
                            o9.a aVar3 = new o9.a();
                            trackDescription3.name.isEmpty();
                            aVar3.f5556a = 3;
                            arrayList.add(aVar3);
                        }
                    }
                }
                p9VarArr = (p9[]) arrayList.toArray(new o9.a[arrayList.size()]);
            }
            if (p9VarArr != null && p9VarArr.length > 0) {
                for (p9 p9Var : p9VarArr) {
                    if (p9Var.a() == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void open(String str) {
        open(str, null);
    }

    @Override // com.miui.zeus.mimo.sdk.g, com.miui.zeus.mimo.sdk.i
    public void open(String str, Map<String, String> map) {
        this.mIsPrepared = false;
        this.mPlayWhenReady = false;
        asyncCall(new k(map, str));
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void pause() {
        this.mPlayWhenReady = false;
        if (this.mState == PlayState.PLAYING) {
            updateState(PlayState.PAUSED);
        }
        asyncCall(new b());
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void release() {
        stop();
        this.mIsMute = false;
        this.mIsPrepared = false;
        asyncCall(new f());
    }

    public void resume() {
        start();
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void seekTo(int i2) {
        asyncCall(new c(i2));
    }

    @Override // com.miui.zeus.mimo.sdk.g
    public void setContext(Context context) {
        super.setContext(context);
        initPlayer(context);
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void setLooping(boolean z) {
        try {
            this.mIsLooping = z;
            asyncCall(new m(z));
        } catch (Throwable th) {
            onPlayerException(th);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void setMute(boolean z) {
        this.mIsMute = z;
        asyncCall(new l(z));
    }

    @Override // com.miui.zeus.mimo.sdk.g, com.miui.zeus.mimo.sdk.i
    public void setScreenOnWhilePlaying(boolean z) {
        asyncCall(new e(z));
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void setSurface(Surface surface) {
        this.mSurface = surface;
        try {
            this.mMediaPlayer.a(surface);
        } catch (Exception unused) {
        }
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void start() {
        this.mPlayWhenReady = true;
        if (this.mIsPrepared || this.mState == PlayState.PAUSED) {
            updateState(PlayState.PLAYING);
            asyncCall(new n());
        }
    }

    @Override // com.miui.zeus.mimo.sdk.i
    public void stop() {
        this.mPlayWhenReady = false;
        updateState(PlayState.IDLE);
        asyncCall(new d());
    }
}
