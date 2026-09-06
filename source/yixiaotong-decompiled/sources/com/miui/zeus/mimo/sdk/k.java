package com.miui.zeus.mimo.sdk;

import com.miui.zeus.comp.zeusplayer.xiaomiplayer.ZeusMediaXiaoMiPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ZeusMediaXiaoMiPlayer.a f5503a;

    public k(ZeusMediaXiaoMiPlayer.a aVar) {
        this.f5503a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ZeusMediaXiaoMiPlayer.this.mMediaPlayer != null) {
            ZeusMediaXiaoMiPlayer.this.mMediaPlayer.j();
        }
    }
}
