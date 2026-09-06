package com.byazt.aas;

import com.byazt.ete.ic;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 121})
public class cu {
    public static final Set<Integer> c = new CopyOnWriteArraySet();
    public static final com.byazt.nr.yv tt = new com.byazt.nr.yv() { // from class: com.byazt.aas.cu.1
        @Override // com.byazt.nr.yv
        public boolean c(int i) {
            if (com.byazt.omf.gt.tt().yg()) {
                return cu.c.contains(Integer.valueOf(i));
            }
            return true;
        }
    };

    public static com.byazt.nzi.c c(ic icVar) {
        if (icVar == null) {
            return null;
        }
        com.byazt.nzi.c cVar = new com.byazt.nzi.c();
        cVar.c(icVar.eo());
        cVar.c(icVar.w_());
        cVar.tt(icVar.uj());
        return cVar;
    }

    public static void c() {
        if (com.byazt.omf.gt.tt().yg()) {
            com.byazt.nr.zm.c(tt);
        } else {
            c.clear();
        }
    }

    public static void c(int i) {
        if (com.byazt.omf.gt.tt().yg()) {
            c.add(Integer.valueOf(i));
        }
        tt.ve(i);
    }

    public static void tt(int i) {
        c.remove(Integer.valueOf(i));
        tt.tt(i);
    }
}
