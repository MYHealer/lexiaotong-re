package com.byazt.nb;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2493a;
    public String c;
    public float da;
    public int i;
    public String m;
    public int n;
    public boolean sl;
    public float sp;
    public PointF t;
    public String tt;
    public PointF u;
    public c uj;
    public float ve;
    public int x;
    public n yp;
    public String z;

    public enum c {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public void c(String str, String str2, float f, c cVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2, n nVar, String str3, String str4) {
        this.c = str;
        this.tt = str2;
        this.ve = f;
        this.uj = cVar;
        this.n = i;
        this.f2493a = f2;
        this.sp = f3;
        this.x = i2;
        this.i = i3;
        this.da = f4;
        this.sl = z;
        this.t = pointF;
        this.u = pointF2;
        this.yp = nVar;
        this.z = str3;
        this.m = str4;
    }

    public tt(String str, String str2, float f, c cVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2, n nVar, String str3, String str4) {
        c(str, str2, f, cVar, i, f2, f3, i2, i3, f4, z, pointF, pointF2, nVar, str3, str4);
    }

    public tt() {
        this.yp = new n();
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.c.hashCode() * 31) + this.tt.hashCode()) * 31) + this.ve)) * 31) + this.uj.ordinal()) * 31) + this.n;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f2493a);
        return (((((((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.x) * 31) + this.yp.c) * 31) + this.yp.tt;
    }
}
