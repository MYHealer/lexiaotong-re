package com.meishu.sdk.core.bquery;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: AbstractBQuery.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b implements com.meishu.sdk.meishu_ad.view.player.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f4768a;

    public b(e eVar, h hVar) {
        this.f4768a = hVar;
    }

    public void a(String str, MediaPlayer mediaPlayer) {
        h hVar = this.f4768a;
        if (hVar != null) {
            hVar.a(str, mediaPlayer, false);
        }
    }

    public void a() {
        h hVar = this.f4768a;
        if (hVar != null) {
            hVar.onFail(0, "mediaPlayer loadVideo error");
        }
    }
}
