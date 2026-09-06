package com.adprof.sdk;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class x2 extends RelativeLayout implements SurfaceHolder.Callback, MediaPlayer.OnBufferingUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1513a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaPlayer f824a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SurfaceView f825a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f826a;

    public x2(Context context) {
        super(context);
        this.f824a = null;
        this.f826a = "";
        SurfaceView surfaceView = new SurfaceView(context);
        this.f825a = surfaceView;
        addView(surfaceView, new ViewGroup.LayoutParams(-1, -1));
        this.f825a.getHolder().addCallback(this);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f824a = mediaPlayer;
        mediaPlayer.setLooping(true);
        this.f824a.setOnBufferingUpdateListener(this);
    }

    public int getVideoHeight() {
        MediaPlayer mediaPlayer = this.f824a;
        return mediaPlayer != null ? mediaPlayer.getVideoHeight() : getHeight();
    }

    public int getVideoWidth() {
        MediaPlayer mediaPlayer = this.f824a;
        return mediaPlayer != null ? mediaPlayer.getVideoWidth() : getWidth();
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        RelativeLayout.getDefaultSize(0, i);
        RelativeLayout.getDefaultSize(0, i2);
        super.onMeasure(i, i2);
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        MediaPlayer mediaPlayer = this.f824a;
        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(onPreparedListener);
        }
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.f824a.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    public void setVideoPath(String str) {
        this.f826a = str;
        try {
            this.f824a.reset();
            this.f824a.setDataSource(this.f826a);
            this.f824a.prepareAsync();
        } catch (Throwable th) {
            pk.b("ad video play error: ", th);
        }
    }

    public void setVolume(int i) {
        MediaPlayer mediaPlayer = this.f824a;
        if (mediaPlayer != null) {
            float f = i;
            mediaPlayer.setVolume(f, f);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        MediaPlayer mediaPlayer = this.f824a;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        MediaPlayer mediaPlayer = this.f824a;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.f824a.stop();
        this.f824a.reset();
        this.f824a.release();
        this.f824a = null;
    }
}
