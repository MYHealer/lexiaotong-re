package com.byazt.zy;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1698, 115})
public class rh implements u, com.byazt.dg.c.InterfaceC0132c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2942a;
    public final com.byazt.dg.u n;
    public final String tt;
    public final com.byazt.ga.x uj;
    public final boolean ve;
    public final Path c = new Path();
    public final tt sp = new tt();

    public rh(com.byazt.ga.x xVar, com.byazt.zk.ve veVar, com.byazt.jx.nu nuVar) {
        this.tt = nuVar.c();
        this.ve = nuVar.ve();
        this.uj = xVar;
        com.byazt.dg.u uVarC = nuVar.tt().c();
        this.n = uVarC;
        veVar.c(uVarC);
        uVarC.c(this);
    }

    @Override // com.byazt.dg.c.InterfaceC0132c
    public void c() {
        tt();
    }

    private void tt() {
        this.f2942a = false;
        this.uj.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:12:0x002a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0036 A[SYNTHETIC] */
    @Override // com.byazt.zy.ve
    public void c(List<ve> list, List<ve> list2) {
        ArrayList arrayList = null;
        for (int i = 0; i < list.size(); i++) {
            ve veVar = list.get(i);
            if (veVar instanceof rl) {
                rl rlVar = (rl) veVar;
                if (rlVar.getType() == com.byazt.jx.my.c.SIMULTANEOUSLY) {
                    this.sp.c(rlVar);
                    rlVar.c(this);
                } else if (!(veVar instanceof my)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((my) veVar);
                }
            } else if (!(veVar instanceof my)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((my) veVar);
            }
        }
        this.n.c((List<my>) arrayList);
    }

    @Override // com.byazt.zy.u
    public Path uj() {
        if (this.f2942a) {
            return this.c;
        }
        this.c.reset();
        if (this.ve) {
            this.f2942a = true;
            return this.c;
        }
        Path pathSp = this.n.sp();
        if (pathSp == null) {
            return this.c;
        }
        this.c.set(pathSp);
        this.c.setFillType(Path.FillType.EVEN_ODD);
        this.sp.c(this.c);
        this.f2942a = true;
        return this.c;
    }
}
