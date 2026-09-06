package com.adprof.sdk;

import android.media.MediaPlayer;
import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class jm implements MediaPlayer.OnPreparedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ lm f403a;

    public jm(lm lmVar, d dVar) {
        this.f403a = lmVar;
        this.f1252a = dVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        ViewGroup viewGroup = ((zl) this.f403a).f921a;
        if (viewGroup == null) {
            return;
        }
        viewGroup.post(new im(this, mediaPlayer));
    }
}
