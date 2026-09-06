package com.adprof.sdk;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class lm extends zl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x2 f1292a;

    public lm(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        x2 x2Var = new x2(context);
        this.f1292a = x2Var;
        addView(x2Var, layoutParams);
    }

    @Override // com.adprof.sdk.zl
    public void a() {
        MediaPlayer mediaPlayer;
        if (super.f921a != null) {
            super.f921a = null;
        }
        x2 x2Var = this.f1292a;
        if (x2Var == null || (mediaPlayer = x2Var.f824a) == null) {
            return;
        }
        mediaPlayer.stop();
        x2Var.f824a.reset();
        x2Var.f824a.release();
        x2Var.f824a = null;
    }

    @Override // com.adprof.sdk.zl
    public void a(d dVar) {
        if (dVar == null || super.f921a == null) {
            pk.b("---loadResource adUnit  null");
            return;
        }
        String strM594a = dVar.m594a();
        if (TextUtils.isEmpty(strM594a) || !new File(strM594a).exists()) {
            strM594a = dVar.m();
        }
        pk.d("splash video url = " + strM594a);
        if (TextUtils.isEmpty(strM594a)) {
            pk.d("splash video url empty return ..... ");
            return;
        }
        this.f1292a.setVisibility(0);
        this.f1292a.setOnPreparedListener(new jm(this, dVar));
        this.f1292a.setVideoPath(strM594a);
    }

    @Override // com.adprof.sdk.zl
    public void b() {
        x2 x2Var = this.f1292a;
        MediaPlayer mediaPlayer = x2Var.f824a;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        x2Var.f824a.pause();
        x2Var.f1513a = x2Var.f824a.getCurrentPosition();
    }

    @Override // com.adprof.sdk.zl
    public void c() {
        pk.c("-----showAd onResume");
        this.f1292a.postDelayed(new km(this), 200L);
    }

    @Override // com.adprof.sdk.zl
    public void d() {
    }

    @Override // com.adprof.sdk.zl
    public void setVideoMute(boolean z) {
        MediaPlayer mediaPlayer = this.f1292a.f824a;
        if (mediaPlayer != null) {
            float f = !z ? 1 : 0;
            mediaPlayer.setVolume(f, f);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 8) {
            try {
                x2 x2Var = this.f1292a;
                if (x2Var != null) {
                    MediaPlayer mediaPlayer = x2Var.f824a;
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                        x2Var.f824a.reset();
                        x2Var.f824a.release();
                        x2Var.f824a = null;
                    }
                    removeAllViews();
                }
            } catch (Throwable th) {
                pk.b("set splash ad video content error: ", th);
            }
        }
        super.setVisibility(i);
    }
}
