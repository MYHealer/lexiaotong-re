package com.byazt.hw;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 77, 54})
public class ve {
    public boolean c = false;
    public boolean tt = true;
    public Map<String, Integer> ve = null;
    public Map<String, String> uj = null;
    public int n = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2317a = 1;
    public int sp = 1;
    public int x = 10;
    public int i = 1;
    public int da = 1;
    public int sl = 900;
    public int t = 120;
    public String u = null;
    public int yp = 0;
    public long z = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder(" localEnable: ");
        sb.append(this.c);
        sb.append(" probeEnable: ").append(this.tt);
        StringBuilder sbAppend = sb.append(" hostFilter: ");
        Map<String, Integer> map = this.ve;
        sbAppend.append(map != null ? map.size() : 0);
        StringBuilder sbAppend2 = sb.append(" hostMap: ");
        Map<String, String> map2 = this.uj;
        sbAppend2.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ").append(this.n).append("#").append(this.f2317a).append("#").append(this.sp);
        sb.append(" reqErr: ").append(this.x).append("#").append(this.i).append("#").append(this.da);
        sb.append(" updateInterval: ").append(this.sl);
        sb.append(" updateRandom: ").append(this.t);
        sb.append(" httpBlack: ").append(this.u);
        return sb.toString();
    }
}
