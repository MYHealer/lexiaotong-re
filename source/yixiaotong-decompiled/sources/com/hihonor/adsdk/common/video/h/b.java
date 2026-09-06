package com.hihonor.adsdk.common.video.h;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.hihonor.adsdk.common.f.q;
import com.hihonor.adsdk.common.video.AdVideoSize;
import com.hihonor.adsdk.common.video.VideoPlayState;
import com.hihonor.adsdk.common.video.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends com.hihonor.adsdk.common.video.a implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener, TextureView.SurfaceTextureListener, MediaPlayer.OnVideoSizeChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3522a = "AdMediaPlayer";
    private MediaPlayer hnadsn;
    private TextureView hnadso;
    private Surface hnadsp;
    private SurfaceTexture hnadsq;
    private final VideoPlayState hnadsr;
    private long hnadss;
    private long hnadst;
    private long hnadsu;
    private final Handler hnadsv;
    private int hnadsw;
    private final Runnable hnadsx;
    private long hnadsy;
    private long hnadsz;

    public b(Context context) {
        super(context);
        this.hnadsv = new Handler(Looper.getMainLooper());
        this.hnadsw = 0;
        this.hnadsr = new VideoPlayState();
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.hnadsn = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.hnadsn.setOnPreparedListener(this);
            this.hnadsn.setOnVideoSizeChangedListener(this);
            this.hnadsn.setOnCompletionListener(this);
            this.hnadsn.setOnErrorListener(this);
            this.hnadsn.setOnInfoListener(this);
            this.hnadsn.setOnBufferingUpdateListener(this);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf(), "AdMediaPlayer, init media player error msg is " + e.getMessage(), new Object[0]);
        }
        TextureView textureView = new TextureView(context);
        this.hnadso = textureView;
        textureView.setSurfaceTextureListener(this);
        this.hnadsx = new Runnable() { // from class: com.hihonor.adsdk.common.video.h.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsi();
            }
        };
    }

    private void hnadsa(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "start video", new Object[0]);
        this.hnadsi = false;
        this.hnadsg = str;
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "currentStatus:" + this.hnadsr.getState(), new Object[0]);
            this.hnadsn.reset();
            this.hnadsn.setDataSource(str);
            this.hnadsr.setState(1);
            this.hnadsn.prepareAsync();
            this.hnadsy = SystemClock.elapsedRealtime();
            hnadsc();
            this.hnadsw = 4;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsf(), "start path ex. msg = " + e.getMessage(), new Object[0]);
            hnadsa(e.hnadsc, "set data source error.", 0);
            this.hnadsr.setState(-1);
        }
    }

    private void hnadsb(final MediaPlayer mediaPlayer) {
        com.hihonor.adsdk.common.video.b.hnadsa(new Runnable() { // from class: com.hihonor.adsdk.common.video.h.b$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsa(mediaPlayer);
            }
        });
    }

    private String hnadsf() {
        return f3522a + hashCode();
    }

    private long hnadsg() {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.hnadsg);
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (TextUtils.isEmpty(strExtractMetadata)) {
                return 0L;
            }
            return q.hnadse(strExtractMetadata, true);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsf(), "getMediaDuration, parse duration ex. error = " + e.getMessage(), new Object[0]);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsi() {
        if (!this.hnadsd || this.hnadso.getVisibility() != 0) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsf(), "updateProgress#player view is invisible", new Object[0]);
            return;
        }
        try {
            if (isPlaying()) {
                long currentPosition = this.hnadsn.getCurrentPosition();
                long duration = this.hnadsn.getDuration();
                if (duration <= 0) {
                    duration = hnadsg();
                }
                long j = duration;
                this.hnadsv.postDelayed(this.hnadsx, 1000L);
                this.hnadsr.setState(4);
                this.hnadst = j;
                this.hnadsu = currentPosition;
                hnadsa(currentPosition, this.hnadss, j);
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsf(), "updateProgress error msg is " + e.getMessage(), new Object[0]);
        }
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public int getBufferedPercentage() {
        return 0;
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public long getBufferedPosition() {
        return 0L;
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public long getCurrentPosition() {
        return this.hnadsu;
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public long getDuration() {
        return this.hnadst;
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public View getPlayerView() {
        if (!this.hnadso.isAvailable() && this.hnadsm != null) {
            TextureView textureView = new TextureView(this.hnadsm);
            this.hnadso = textureView;
            textureView.setSurfaceTextureListener(this);
        }
        return this.hnadso;
    }

    @Override // com.hihonor.adsdk.common.video.a, com.hihonor.adsdk.common.video.IPlayer
    public int getState() {
        return this.hnadsr.getState();
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public boolean isPlaying() {
        try {
            return this.hnadsn.isPlaying();
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf(), "isPlaying, isPlaying error: " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void notifyVisibilityChange(boolean z) {
        this.hnadsd = z;
        if (z) {
            if (this.hnadsi) {
                return;
            }
            resume();
        } else {
            if (this.hnadsi) {
                return;
            }
            pause();
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.hnadss = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "onCompletion.", new Object[0]);
        if (this.hnadsr.getState() == -1) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsf(), "onCompletion,current state is error", new Object[0]);
            return;
        }
        this.hnadsr.setState(8);
        this.hnadsi = true;
        hnadsa();
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "onInfo.what=%s, extra=%s", Integer.valueOf(i), Integer.valueOf(i2));
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "onInfo.width=%s, height=%s", Integer.valueOf(mediaPlayer.getVideoWidth()), Integer.valueOf(mediaPlayer.getVideoHeight()));
            int state = this.hnadsr.getState();
            int i3 = 5;
            if (i == 3) {
                this.hnadsr.setState(2);
                hnadsa(this.hnadsz, SystemClock.elapsedRealtime() - this.hnadsy);
                int i4 = this.hnadsw;
                if (i4 == 4) {
                    this.hnadsr.setState(3);
                    hnadse();
                    hnadsi();
                } else if (5 == i4) {
                    try {
                        this.hnadsn.pause();
                    } catch (Exception e) {
                        com.hihonor.adsdk.common.b.b.hnadse(hnadsf(), "onInfo#player pause exception msg is %s", e.getMessage());
                    }
                }
            } else {
                if (i == 701) {
                    this.hnadsr.setState((state == 5 || state == 7) ? 7 : 6);
                    hnadsa(true);
                } else if (i == 702) {
                    if (state == 6) {
                        state = 4;
                    }
                    if (state != 7) {
                        i3 = state;
                    }
                    this.hnadsr.setState(i3);
                    hnadsa(false);
                } else {
                    com.hihonor.adsdk.common.b.b.hnadsa(hnadsf(), (Object) ("onInfo ——> what：" + i));
                }
            }
        } catch (Exception e2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf(), "mediaPlayer onInfo error msg is " + e2.getMessage(), new Object[0]);
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "onPrepared mTargetState:" + this.hnadsw, new Object[0]);
        try {
            if (this.hnadsf) {
                this.hnadsn.setVolume(0.0f, 0.0f);
            } else {
                this.hnadsn.setVolume(1.0f, 1.0f);
            }
            this.hnadsn.start();
            this.hnadsz = SystemClock.elapsedRealtime() - this.hnadsy;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsf(), "onPrepared#player start exception msg is %s", e.getMessage());
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "onSurfaceTextureAvailable,width: " + i + "height: " + i2, new Object[0]);
        try {
            if (this.hnadsq == null) {
                this.hnadsq = surfaceTexture;
                if (this.hnadsp == null) {
                    this.hnadsp = new Surface(this.hnadsq);
                }
                this.hnadsn.setSurface(this.hnadsp);
                return;
            }
            TextureView textureView = this.hnadso;
            if (textureView != null) {
                SurfaceTexture surfaceTexture2 = textureView.getSurfaceTexture();
                SurfaceTexture surfaceTexture3 = this.hnadsq;
                if (surfaceTexture2 != surfaceTexture3) {
                    this.hnadso.setSurfaceTexture(surfaceTexture3);
                }
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsf(), "onSurfaceTextureAvailable#set Surface Texture exception! msg is %s" + e.getMessage(), new Object[0]);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "onSurfaceTextureDestroyed", new Object[0]);
        return this.hnadsq == null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "onSurfaceTextureSizeChanged,width: " + i + ",height: " + i2, new Object[0]);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "onVideoSizeChanged ——> width：" + i + "， height：" + i2, new Object[0]);
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void pause() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "pause status:" + this.hnadsr.getState(), new Object[0]);
        if (!hnadsh()) {
            this.hnadsw = 5;
            return;
        }
        if (isPlaying()) {
            try {
                this.hnadsn.pause();
                this.hnadsr.setState(5);
                hnadsb();
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsf(), "pause#player pause exception msg is %s", e.getMessage());
            }
        }
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void release() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "release", new Object[0]);
        try {
            MediaPlayer mediaPlayer = this.hnadsn;
            if (mediaPlayer != null) {
                mediaPlayer.setOnPreparedListener(null);
                this.hnadsn.setOnVideoSizeChangedListener(null);
                this.hnadsn.setOnCompletionListener(null);
                this.hnadsn.setOnErrorListener(null);
                this.hnadsn.setOnInfoListener(null);
                this.hnadsn.setOnBufferingUpdateListener(null);
                this.hnadsn.stop();
                MediaPlayer mediaPlayer2 = this.hnadsn;
                this.hnadsn = null;
                hnadsb(mediaPlayer2);
                this.hnadsr.setState(0);
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsf(), "release error, current player not init.mes is " + e.getMessage(), new Object[0]);
        }
        try {
            SurfaceTexture surfaceTexture = this.hnadsq;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.hnadsq = null;
            }
        } catch (Exception e2) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsf(), "release error, current mSurfaceTexture not init.mes is " + e2.getMessage(), new Object[0]);
        }
        try {
            Surface surface = this.hnadsp;
            if (surface != null) {
                surface.release();
                this.hnadsp = null;
            }
        } catch (Exception e3) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsf(), "release error, current mSurface not init.mes is " + e3.getMessage(), new Object[0]);
        }
        this.hnadsv.removeCallbacks(this.hnadsx);
        this.hnadsw = 0;
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void replay() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "resume#player resume status:" + this.hnadsr.getState(), new Object[0]);
        if (this.hnadsr.getState() == 8) {
            try {
                this.hnadsn.start();
                this.hnadsr.setState(4);
                hnadse();
                hnadsi();
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "resume#player resume exception msg is %s", e.getMessage());
            }
        }
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void resume() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "resume#player resume status:" + this.hnadsr.getState(), new Object[0]);
        if (!hnadsh()) {
            this.hnadsw = 4;
            return;
        }
        try {
            if (getState() == 5 || getState() == 7) {
                this.hnadsn.start();
                this.hnadsr.setState(4);
                hnadsi();
                hnadsd();
            } else if (getState() == 2) {
                this.hnadsn.start();
                this.hnadsr.setState(3);
                hnadse();
                hnadsi();
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "resume#player resume exception msg is %s", e.getMessage());
        }
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void seekTo(long j) {
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void setCacheEnable(boolean z) {
    }

    @Override // com.hihonor.adsdk.common.video.a, com.hihonor.adsdk.common.video.IPlayer
    public void setMuted(boolean z) {
        super.setMuted(z);
        if (this.hnadsr.getState() < 2) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "player not prepared,return", new Object[0]);
            return;
        }
        try {
            if (z) {
                this.hnadsn.setVolume(0.0f, 0.0f);
            } else {
                this.hnadsn.setVolume(1.0f, 1.0f);
            }
            hnadsb(z);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf(), "setMuted call mediaPlayer set Volume error msg is " + e.getMessage(), new Object[0]);
        }
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void setVideoViewSize(AdVideoSize adVideoSize, int i, int i2) {
        this.hnadsl = adVideoSize;
        this.hnadsj = i2;
        this.hnadsk = i;
    }

    @Override // com.hihonor.adsdk.common.video.IPlayer
    public void startUri(String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "start uri.", new Object[0]);
        hnadsa(str);
    }

    private boolean hnadsh() {
        return (this.hnadsn == null || this.hnadsr.getState() == -1 || this.hnadsr.getState() == 0 || this.hnadsr.getState() == 1 || this.hnadsr.getState() == 8) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        int i3;
        if (this.hnadsn != null && this.hnadsr.getState() != -1 && this.hnadsr.getState() != 0) {
            i3 = (this.hnadsr.getState() == 1 || this.hnadsr.getState() == 8 || this.hnadsr.getState() == 2) ? 0 : 1;
        }
        String str = String.format("onError.what=%s, extra=%s", Integer.valueOf(i), Integer.valueOf(i2));
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), str, new Object[0]);
        this.hnadsr.setState(-1);
        hnadsa(i2, str, i3);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(MediaPlayer mediaPlayer) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf(), "sub release", new Object[0]);
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsf(), "release error, current player not init.mes is " + e.getMessage(), new Object[0]);
            }
        }
    }
}
