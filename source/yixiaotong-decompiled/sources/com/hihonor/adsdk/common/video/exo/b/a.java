package com.hihonor.adsdk.common.video.exo.b;

import android.content.Context;
import android.view.Surface;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import com.hihonor.adsdk.common.b.b;
import com.hihonor.adsdk.common.video.e;
import com.hihonor.adsdk.common.video.g.h.d.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends com.hihonor.adsdk.common.video.exo.a {
    private static final String o = "AndroidXExoPlayer";
    private static final int p = 5000;
    private ExoPlayer l;
    private MediaSource m;
    private final Player.Listener n;

    /* JADX INFO: renamed from: com.hihonor.adsdk.common.video.exo.b.a$a, reason: collision with other inner class name */
    class C0463a implements Player.Listener {
        C0463a() {
        }

        public void onIsPlayingChanged(boolean z) {
            super.onIsPlayingChanged(z);
            b.hnadsa(a.this.hnadsu(), (Object) "onIsPlayingChanged");
            a.this.hnadsc(z);
        }

        public void onPlaybackStateChanged(int i) {
            super.onPlaybackStateChanged(i);
            b.hnadsa(a.this.hnadsu(), (Object) "onPlaybackStateChanged");
            a.this.hnadsb(i);
        }

        public void onPlayerError(PlaybackException playbackException) {
            super.onPlayerError(playbackException);
            b.hnadsa(a.this.hnadsu(), (Object) "onPlayerError");
            a.this.hnadsa(playbackException.getCause(), playbackException.errorCode);
        }

        public void onRenderedFirstFrame() {
            super.onRenderedFirstFrame();
            b.hnadsa(a.this.hnadsu(), (Object) "onRenderedFirstFrame");
            a.this.c();
        }
    }

    public a(Context context) {
        super(context);
        this.n = new C0463a();
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public void g() {
        try {
            DefaultLoadControl defaultLoadControlBuild = new DefaultLoadControl.Builder().setBufferDurationsMs(5000, 5000, 2500, 5000).build();
            DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(this.hnadsm);
            defaultTrackSelector.setParameters(defaultTrackSelector.buildUponParameters().setConstrainAudioChannelCountToDeviceCapabilities(false).build());
            ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(this.hnadsm).setLoadControl(defaultLoadControlBuild).setTrackSelector(defaultTrackSelector).build();
            this.l = exoPlayerBuild;
            Player.Listener listener = this.n;
            if (listener == null) {
                b.hnadsb(hnadsu(), "initRealExoPlayer mAndroidExoListener is null", new Object[0]);
            } else {
                exoPlayerBuild.addListener(listener);
            }
        } catch (Exception e) {
            b.hnadsb(hnadsu(), "initRealExoPlayer error msg = " + e.getMessage(), new Object[0]);
            hnadsa(e.hnadsa, e.getMessage(), 0);
        }
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public void hnadsm() {
        this.m = c.hnadsa().hnadsa(this.hnadsm, this.hnadsg, this.d);
        b.hnadsa(hnadsu(), (Object) "exoRealInitMediaSource");
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public boolean hnadsn() {
        return this.l.isPlaying();
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public void hnadso() {
        b.hnadsa(hnadsu(), (Object) "exoRealPause");
        this.l.pause();
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public void hnadsp() {
        this.l.play();
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public void hnadsq() {
        b.hnadsa(hnadsu(), (Object) "exoRealPlayUrl");
        this.l.setMediaSource(this.m);
        this.l.prepare();
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public void hnadss() {
        this.l.seekTo(0L);
        this.l.setPlayWhenReady(true);
        b.hnadsa(hnadsu(), (Object) "exoRealReplay");
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public void hnadst() {
        b.hnadsa(hnadsu(), (Object) "exoRealSetMute");
        if (this.l.isCommandAvailable(24)) {
            this.l.setVolume(this.hnadsf ? 0.0f : 1.0f);
        }
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public String hnadsu() {
        return o + hashCode();
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public int hnadsv() {
        return this.l.getBufferedPercentage();
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public long hnadsw() {
        return this.l.getBufferedPosition();
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public long hnadsx() {
        return this.l.getCurrentPosition();
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public long hnadsy() {
        return this.l.getDuration();
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public boolean j() {
        return this.l == null;
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public void hnadsa(Surface surface) {
        this.l.setVideoSurface(surface);
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public void hnadsr() {
        Player.Listener listener = this.n;
        if (listener != null) {
            this.l.removeListener(listener);
        }
        b.hnadsa(hnadsu(), (Object) "exoRealReleasePlayer");
        this.l.clearVideoSurface();
        this.l.release();
        this.l = null;
    }
}
