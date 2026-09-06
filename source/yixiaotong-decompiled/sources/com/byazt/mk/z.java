package com.byazt.mk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f2478a;
    public final byte[] c;
    public boolean n;
    public z sp;
    public int tt;
    public boolean uj;
    public int ve;

    public z() {
        this.c = new byte[8192];
        this.n = true;
        this.uj = false;
    }

    public z(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.c = bArr;
        this.tt = i;
        this.ve = i2;
        this.uj = z;
        this.n = z2;
    }

    public final z c() {
        this.uj = true;
        return new z(this.c, this.tt, this.ve, true, false);
    }

    public final z tt() {
        z zVar = this.f2478a;
        z zVar2 = zVar != this ? zVar : null;
        z zVar3 = this.sp;
        if (zVar3 != null) {
            zVar3.f2478a = zVar;
        }
        z zVar4 = this.f2478a;
        if (zVar4 != null) {
            zVar4.sp = zVar3;
        }
        this.f2478a = null;
        this.sp = null;
        return zVar2;
    }

    public final z c(z zVar) {
        zVar.sp = this;
        zVar.f2478a = this.f2478a;
        this.f2478a.sp = zVar;
        this.f2478a = zVar;
        return zVar;
    }

    public final z c(int i) {
        z zVarC;
        if (i <= 0 || i > this.ve - this.tt) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            zVarC = c();
        } else {
            zVarC = m.c();
            System.arraycopy(this.c, this.tt, zVarC.c, 0, i);
        }
        zVarC.ve = zVarC.tt + i;
        this.tt += i;
        this.sp.c(zVarC);
        return zVarC;
    }

    public final void ve() {
        z zVar = this.sp;
        if (zVar == this) {
            throw new IllegalStateException();
        }
        if (zVar.n) {
            int i = this.ve - this.tt;
            if (i > (8192 - zVar.ve) + (zVar.uj ? 0 : zVar.tt)) {
                return;
            }
            c(zVar, i);
            tt();
            m.c(this);
        }
    }

    public final void c(z zVar, int i) {
        if (!zVar.n) {
            throw new IllegalArgumentException();
        }
        int i2 = zVar.ve;
        if (i2 + i > 8192) {
            if (zVar.uj) {
                throw new IllegalArgumentException();
            }
            int i3 = zVar.tt;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = zVar.c;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            zVar.ve -= zVar.tt;
            zVar.tt = 0;
        }
        System.arraycopy(this.c, this.tt, zVar.c, zVar.ve, i);
        zVar.ve += i;
        this.tt += i;
    }
}
