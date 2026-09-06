package com.byazt.jx;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 214, 130})
public class m implements ve {
    public final String c;
    public final List<ve> tt;
    public final boolean ve;

    public String c() {
        return this.c;
    }

    public List<ve> tt() {
        return this.tt;
    }

    public boolean ve() {
        return this.ve;
    }

    public m(String str, List<ve> list, boolean z) {
        this.c = str;
        this.tt = list;
        this.ve = z;
    }

    @Override // com.byazt.jx.ve
    public com.byazt.zy.ve c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar) {
        return new com.byazt.zy.uj(xVar, veVar, this, aVar);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.c + "' Shapes: " + Arrays.toString(this.tt.toArray()) + '}';
    }
}
