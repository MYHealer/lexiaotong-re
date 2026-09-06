package com.miui.zeus.mimo.sdk;

import android.util.Log;
import com.google.common.base.Ascii;
import com.miui.zeus.comp.videoplayer.PlayState;
import com.miui.zeus.comp.zeusplayer.xiaomiplayer.ZeusMediaXiaoMiPlayer;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class i9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m9 f5464a;
    public j9 b;
    public n9 c;
    public k9 d;
    public l9 e;

    public void a() {
        this.f5464a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    public final boolean a(int i, int i2) {
        k9 k9Var = this.d;
        if (k9Var == null) {
            return false;
        }
        ZeusMediaXiaoMiPlayer.h hVar = (ZeusMediaXiaoMiPlayer.h) k9Var;
        ZeusMediaXiaoMiPlayer.this.updateState(PlayState.ERROR);
        ZeusMediaXiaoMiPlayer zeusMediaXiaoMiPlayer = ZeusMediaXiaoMiPlayer.this;
        zeusMediaXiaoMiPlayer.notifyOnError(zeusMediaXiaoMiPlayer.getPlayException(i2), i, i2);
        Log.w(ijiami_1011.s.s.s.d(new byte[]{104, 85, 69, 75, 126, 84, 5, 13, 7, 58, 88, 4, 93, 125, 89, 104, 95, 80, Ascii.CAN, 1, Ascii.DC4}, "200831"), ijiami_1011.s.s.s.d(new byte[]{91, 3, 92, 12, 0, Ascii.SYN, 17, 8, 7, Ascii.ESC, 84, Ascii.ETB, Ascii.SYN, 3, 74, Ascii.ETB, 14, 68, 65, Utf8.REPLACEMENT_BYTE}, "6f8ea6") + i + ijiami_1011.s.s.s.d(new byte[]{65, 73, 70}, "aefc63") + i2 + ijiami_1011.s.s.s.d(new byte[]{60}, "a74cbf"));
        return true;
    }

    public final boolean b(int i, int i2) {
        l9 l9Var = this.e;
        if (l9Var == null) {
            return false;
        }
        ZeusMediaXiaoMiPlayer.j jVar = (ZeusMediaXiaoMiPlayer.j) l9Var;
        if (i == 701) {
            ZeusMediaXiaoMiPlayer.this.notifyOnLoadingChanged(true);
        } else if (i == 702) {
            ZeusMediaXiaoMiPlayer.this.notifyOnLoadingChanged(false);
        } else if (i == 100001) {
            ZeusMediaXiaoMiPlayer.this.notifyOnFirstFrameRendered();
        }
        return true;
    }
}
