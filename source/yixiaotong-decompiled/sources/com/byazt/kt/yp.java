package com.byazt.kt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 215})
public class yp {
    public final com.byazt.kpm.c<RecyclerView.gu, c> c = new com.byazt.kpm.c<>();
    public final com.byazt.kpm.ve<RecyclerView.gu> tt = new com.byazt.kpm.ve<>();

    interface tt {
        void c(RecyclerView.gu guVar);

        void c(RecyclerView.gu guVar, RecyclerView.a.tt ttVar, RecyclerView.a.tt ttVar2);

        void tt(RecyclerView.gu guVar, RecyclerView.a.tt ttVar, RecyclerView.a.tt ttVar2);

        void ve(RecyclerView.gu guVar, RecyclerView.a.tt ttVar, RecyclerView.a.tt ttVar2);
    }

    public void c() {
        this.c.clear();
        this.tt.ve();
    }

    public void c(RecyclerView.gu guVar, RecyclerView.a.tt ttVar) {
        c cVarC = this.c.get(guVar);
        if (cVarC == null) {
            cVarC = c.c();
            this.c.put(guVar, cVarC);
        }
        cVarC.tt = ttVar;
        cVarC.c |= 4;
    }

    public boolean c(RecyclerView.gu guVar) {
        c cVar = this.c.get(guVar);
        return (cVar == null || (cVar.c & 1) == 0) ? false : true;
    }

    public RecyclerView.a.tt tt(RecyclerView.gu guVar) {
        return c(guVar, 4);
    }

    public RecyclerView.a.tt ve(RecyclerView.gu guVar) {
        return c(guVar, 8);
    }

    private RecyclerView.a.tt c(RecyclerView.gu guVar, int i) {
        c cVarTt;
        RecyclerView.a.tt ttVar;
        int iC = this.c.c(guVar);
        if (iC < 0 || (cVarTt = this.c.tt(iC)) == null || (cVarTt.c & i) == 0) {
            return null;
        }
        cVarTt.c &= ~i;
        if (i == 4) {
            ttVar = cVarTt.tt;
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Must provide flag PRE or POST");
            }
            ttVar = cVarTt.ve;
        }
        if ((cVarTt.c & 12) == 0) {
            this.c.ve(iC);
            c.c(cVarTt);
        }
        return ttVar;
    }

    public void c(long j, RecyclerView.gu guVar) {
        this.tt.tt(j, guVar);
    }

    public void tt(RecyclerView.gu guVar, RecyclerView.a.tt ttVar) {
        c cVarC = this.c.get(guVar);
        if (cVarC == null) {
            cVarC = c.c();
            this.c.put(guVar, cVarC);
        }
        cVarC.c |= 2;
        cVarC.tt = ttVar;
    }

    public boolean uj(RecyclerView.gu guVar) {
        c cVar = this.c.get(guVar);
        return (cVar == null || (cVar.c & 4) == 0) ? false : true;
    }

    public RecyclerView.gu c(long j) {
        return this.tt.c(j);
    }

    public void ve(RecyclerView.gu guVar, RecyclerView.a.tt ttVar) {
        c cVarC = this.c.get(guVar);
        if (cVarC == null) {
            cVarC = c.c();
            this.c.put(guVar, cVarC);
        }
        cVarC.ve = ttVar;
        cVarC.c |= 8;
    }

    public void n(RecyclerView.gu guVar) {
        c cVarC = this.c.get(guVar);
        if (cVarC == null) {
            cVarC = c.c();
            this.c.put(guVar, cVarC);
        }
        cVarC.c |= 1;
    }

    public void a(RecyclerView.gu guVar) {
        c cVar = this.c.get(guVar);
        if (cVar != null) {
            cVar.c &= -2;
        }
    }

    public void c(tt ttVar) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            RecyclerView.gu guVarC = this.c.c(size);
            c cVarVe = this.c.ve(size);
            if ((cVarVe.c & 3) == 3) {
                ttVar.c(guVarC);
            } else if ((cVarVe.c & 1) != 0) {
                if (cVarVe.tt == null) {
                    ttVar.c(guVarC);
                } else {
                    ttVar.c(guVarC, cVarVe.tt, cVarVe.ve);
                }
            } else if ((cVarVe.c & 14) == 14) {
                ttVar.tt(guVarC, cVarVe.tt, cVarVe.ve);
            } else if ((cVarVe.c & 12) == 12) {
                ttVar.ve(guVarC, cVarVe.tt, cVarVe.ve);
            } else if ((cVarVe.c & 4) != 0) {
                ttVar.c(guVarC, cVarVe.tt, null);
            } else if ((cVarVe.c & 8) != 0) {
                ttVar.tt(guVarC, cVarVe.tt, cVarVe.ve);
            }
            c.c(cVarVe);
        }
    }

    public void sp(RecyclerView.gu guVar) {
        for (int iTt = this.tt.tt() - 1; iTt >= 0; iTt--) {
            if (guVar == this.tt.ve(iTt)) {
                this.tt.c(iTt);
                break;
            }
        }
        c cVarRemove = this.c.remove(guVar);
        if (cVarRemove != null) {
            c.c(cVarRemove);
        }
    }

    public void tt() {
        c.tt();
    }

    public void x(RecyclerView.gu guVar) {
        a(guVar);
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 435})
    static class c {
        public static com.byazt.kpm.uj.c<c> uj = new com.byazt.kpm.uj.tt(20);
        public int c;
        public RecyclerView.a.tt tt;
        public RecyclerView.a.tt ve;

        private c() {
        }

        public static c c() {
            c cVarC = uj.c();
            return cVarC == null ? new c() : cVarC;
        }

        public static void c(c cVar) {
            cVar.c = 0;
            cVar.tt = null;
            cVar.ve = null;
            uj.c(cVar);
        }

        public static void tt() {
            while (uj.c() != null) {
            }
        }
    }
}
