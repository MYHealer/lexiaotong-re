package com.byazt.jx;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 214, 42})
public class i implements ve {
    public final String c;
    public final c tt;
    public final boolean ve;

    public enum c {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static c c(int i) {
            if (i == 1) {
                return MERGE;
            }
            if (i == 2) {
                return ADD;
            }
            if (i == 3) {
                return SUBTRACT;
            }
            if (i != 4) {
                return i != 5 ? MERGE : EXCLUDE_INTERSECTIONS;
            }
            return INTERSECT;
        }
    }

    public String c() {
        return this.c;
    }

    public c tt() {
        return this.tt;
    }

    public boolean ve() {
        return this.ve;
    }

    public i(String str, c cVar, boolean z) {
        this.c = str;
        this.tt = cVar;
        this.ve = z;
    }

    @Override // com.byazt.jx.ve
    public com.byazt.zy.ve c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar) {
        return new com.byazt.zy.t(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.tt + '}';
    }
}
