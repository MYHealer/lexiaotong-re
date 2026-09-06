package com.hihonor.adsdk.common.video.exo.c;

import android.content.Context;
import android.view.Surface;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.hihonor.adsdk.common.b.b;
import com.hihonor.adsdk.common.video.e;
import com.hihonor.adsdk.common.video.g.h.e.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends com.hihonor.adsdk.common.video.exo.a {
    private static final String o = "GoogleExoPlayer";
    private static final int p = 5000;
    private ExoPlayer l;
    private MediaSource m;
    private final Player.Listener n;

    /* JADX INFO: renamed from: com.hihonor.adsdk.common.video.exo.c.a$a, reason: collision with other inner class name */
    class C0464a implements Player.Listener {
        C0464a() {
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onIsPlayingChanged(boolean z) {
            super.onIsPlayingChanged(z);
            a.this.hnadsc(z);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlaybackStateChanged(int i) {
            super.onPlaybackStateChanged(i);
            a.this.hnadsb(i);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onPlayerError(PlaybackException playbackException) {
            super.onPlayerError(playbackException);
            a.this.hnadsa(playbackException.getCause(), playbackException.errorCode);
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void onRenderedFirstFrame() {
            super.onRenderedFirstFrame();
            a.this.c();
        }
    }

    public a(Context context) {
        super(context);
        this.n = new C0464a();
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
                b.hnadsb(hnadsu(), "initRealExoPlayer mListener is null", new Object[0]);
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
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public boolean hnadsn() {
        return this.l.isPlaying();
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public void hnadso() {
        this.l.pause();
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public void hnadsp() {
        this.l.play();
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public void hnadsq() {
        this.l.setMediaSource(this.m);
        this.l.prepare();
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public void hnadss() {
        this.l.seekTo(0L);
        this.l.setPlayWhenReady(true);
    }

    @Override // com.hihonor.adsdk.common.video.exo.a
    public void hnadst() {
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
        this.l.clearVideoSurface();
        this.l.release();
        this.l = null;
        this.m = null;
    }
}
