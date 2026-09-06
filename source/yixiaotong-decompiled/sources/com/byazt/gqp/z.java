package com.byazt.gqp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f2272a;
    public String c;
    public byte[] n;
    public String tt;
    public String uj;
    public da ve;

    public enum c {
        STRING_TYPE,
        BYTE_ARRAY_TYPE,
        FILE_TYPE
    }

    public String c() {
        return this.c;
    }

    public String tt() {
        return this.tt;
    }

    public z() {
    }

    public z(da daVar, String str, c cVar) {
        this.ve = daVar;
        this.uj = str;
        this.f2272a = cVar;
    }

    public z(da daVar, byte[] bArr, String str, String str2, c cVar) {
        this.ve = daVar;
        this.n = bArr;
        this.tt = str;
        this.c = str2;
        this.f2272a = cVar;
    }

    public z(da daVar, byte[] bArr, c cVar) {
        this.ve = daVar;
        this.n = bArr;
        this.f2272a = cVar;
    }

    public static z c(da daVar, String str) {
        return new z(daVar, str, c.STRING_TYPE);
    }

    public static z c(da daVar, byte[] bArr) {
        return new z(daVar, bArr, c.BYTE_ARRAY_TYPE);
    }

    public static z c(da daVar, byte[] bArr, String str, String str2) {
        return new z(daVar, bArr, str, str2, c.FILE_TYPE);
    }
}
