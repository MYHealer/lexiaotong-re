package com.adprof.sdk;

import android.media.MediaPlayer;
import android.view.Surface;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class vo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ep f1486a;

    public vo(ep epVar) {
        this.f1486a = epVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            qo videoPlayerDataSource = this.f1486a.f265a.getVideoPlayerDataSource();
            this.f1486a.f263a = new MediaPlayer();
            this.f1486a.f263a.setAudioStreamType(3);
            ep epVar = this.f1486a;
            MediaPlayer mediaPlayer = epVar.f263a;
            videoPlayerDataSource.getClass();
            mediaPlayer.setLooping(false);
            this.f1486a.f263a.setOnPreparedListener(epVar);
            this.f1486a.f263a.setOnCompletionListener(epVar);
            this.f1486a.f263a.setOnBufferingUpdateListener(epVar);
            this.f1486a.f263a.setScreenOnWhilePlaying(true);
            this.f1486a.f263a.setOnSeekCompleteListener(epVar);
            this.f1486a.f263a.setOnErrorListener(epVar);
            this.f1486a.f263a.setOnInfoListener(epVar);
            this.f1486a.f263a.setOnVideoSizeChangedListener(epVar);
            MediaPlayer.class.getDeclaredMethod("setDataSource", String.class, Map.class).invoke(this.f1486a.f263a, videoPlayerDataSource.a().toString(), videoPlayerDataSource.f692a);
            this.f1486a.f263a.prepareAsync();
            ep epVar2 = this.f1486a;
            if (epVar2.f1158a != null) {
                epVar2.f266a = false;
                this.f1486a.f263a.setSurface(new Surface(this.f1486a.f1158a));
            }
        } catch (Throwable th) {
            pk.b("VideoPlayerMediaSystem----- prepare error", th);
            this.f1486a.b.post(new so(this));
        }
    }
}
