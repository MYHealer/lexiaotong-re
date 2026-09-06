package com.byazt.ga;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 256, 34})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<com.byazt.nb.sp> f2236a;
    public Rect da;
    public c gt;
    public List<com.byazt.zk.x> i;
    public uj m;
    public ve my;
    public Map<String, com.byazt.nb.ve> n;
    public tt rh;
    public float sl;
    public SparseArray<com.byazt.nb.uj> sp;
    public float t;
    public float u;
    public Map<String, i> uj;
    public Map<String, List<com.byazt.zk.x>> ve;
    public LongSparseArray<com.byazt.zk.x> x;
    public boolean yp;
    public final rh c = new rh();
    public final HashSet<String> tt = new HashSet<>();
    public int z = 0;
    public String nu = "";

    @com.byazt.zqa.c(c = {0, 1, 256, 480})
    public static class tt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2238a;
        public int c;
        public int n;
        public JSONArray sp;
        public Map<String, Object> tt;
        public int uj;
        public Map<String, Object> ve;
        public com.byazt.rs.uj x;
    }

    @com.byazt.zqa.c(c = {0, 1, 256, 474})
    public static class uj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2239a;
        public int c;
        public int da;
        public JSONArray i;
        public int[] n;
        public int sl;
        public JSONArray sp;
        public String[] t;
        public String tt;
        public int u;
        public String uj;
        public String ve;
        public String x;
    }

    @com.byazt.zqa.c(c = {0, 1, 256, 471})
    public static class ve {
        public String c;
        public String n;
        public int[][] tt;
        public int uj = 10;
        public JSONArray ve;
    }

    public float a() {
        return this.sl;
    }

    public void c(int i) {
        this.z += i;
    }

    public void c(Rect rect, float f, float f2, float f3, List<com.byazt.zk.x> list, LongSparseArray<com.byazt.zk.x> longSparseArray, Map<String, List<com.byazt.zk.x>> map, Map<String, i> map2, SparseArray<com.byazt.nb.uj> sparseArray, Map<String, com.byazt.nb.ve> map3, List<com.byazt.nb.sp> list2, uj ujVar, String str, tt ttVar, ve veVar, c cVar) {
        this.da = rect;
        this.sl = f;
        this.t = f2;
        this.u = f3;
        this.i = list;
        this.x = longSparseArray;
        this.ve = map;
        this.uj = map2;
        this.sp = sparseArray;
        this.n = map3;
        this.f2236a = list2;
        this.m = ujVar;
        this.nu = str;
        this.rh = ttVar;
        this.my = veVar;
        this.gt = cVar;
    }

    public void c(boolean z) {
        this.yp = z;
    }

    public boolean c() {
        return this.yp;
    }

    public c da() {
        return this.gt;
    }

    public String i() {
        return this.nu;
    }

    public Map<String, com.byazt.nb.ve> m() {
        return this.n;
    }

    public Map<String, i> nu() {
        return this.uj;
    }

    public float rh() {
        return this.t - this.sl;
    }

    public ve sl() {
        return this.my;
    }

    public float sp() {
        return this.t;
    }

    public tt t() {
        return this.rh;
    }

    public int tt() {
        return this.z;
    }

    public float u() {
        return this.u;
    }

    public Rect uj() {
        return this.da;
    }

    public rh ve() {
        return this.c;
    }

    public uj x() {
        return this.m;
    }

    public List<com.byazt.zk.x> yp() {
        return this.i;
    }

    public SparseArray<com.byazt.nb.uj> z() {
        return this.sp;
    }

    public void c(String str) {
        com.byazt.kk.a.tt(str);
        this.tt.add(str);
    }

    public void tt(boolean z) {
        this.c.c(z);
    }

    public com.byazt.zk.x c(long j) {
        return this.x.get(j);
    }

    public float n() {
        return (long) ((rh() / this.u) * 1000.0f);
    }

    public float c(float f) {
        return com.byazt.kk.i.c(this.sl, this.t, f);
    }

    public List<com.byazt.zk.x> tt(String str) {
        return this.ve.get(str);
    }

    public com.byazt.nb.sp ve(String str) {
        int size = this.f2236a.size();
        for (int i = 0; i < size; i++) {
            com.byazt.nb.sp spVar = this.f2236a.get(i);
            if (spVar.c(str)) {
                return spVar;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.byazt.zk.x> it = this.i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().c("\t"));
        }
        return sb.toString();
    }

    @com.byazt.zqa.c(c = {0, 1, 256, 464})
    public static class c {
        public String c;
        public String tt;
        public String uj;
        public String ve;
        public float n = -1.0f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f2237a = -1.0f;
        public float sp = -1.0f;
        public float x = -1.0f;

        public String toString() {
            return "area[" + this.c + "," + this.tt + "," + this.ve + "," + this.uj + "]->[" + this.n + "," + this.f2237a + "," + this.sp + "," + this.x + "]";
        }
    }
}
