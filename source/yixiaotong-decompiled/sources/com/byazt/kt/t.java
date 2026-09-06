package com.byazt.kt;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 66})
public abstract class t extends RecyclerView.t {
    public RecyclerView c;
    public Scroller tt;
    public final RecyclerView.yp ve = new RecyclerView.yp() { // from class: com.byazt.kt.t.1
        public boolean c = false;

        @Override // com.byazt.kt.RecyclerView.yp
        public void c(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.c = true;
        }

        @Override // com.byazt.kt.RecyclerView.yp
        public void c(RecyclerView recyclerView, int i) {
            super.c(recyclerView, i);
            if (i == 0 && this.c) {
                this.c = false;
                t.this.c();
            }
        }
    };

    public abstract int c(RecyclerView.i iVar, int i, int i2);

    public abstract View c(RecyclerView.i iVar);

    public abstract int[] c(RecyclerView.i iVar, View view);

    @Override // com.byazt.kt.RecyclerView.t
    public boolean c(int i, int i2) {
        RecyclerView.i layoutManager = this.c.getLayoutManager();
        if (layoutManager == null || this.c.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.c.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && tt(layoutManager, i, i2);
    }

    public void c(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.c;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                ve();
            }
            this.c = recyclerView;
            if (recyclerView != null) {
                tt();
                this.tt = new Scroller(this.c.getContext(), new DecelerateInterpolator());
                c();
            }
        }
    }

    private void tt() throws IllegalStateException {
        if (this.c.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.c.c(this.ve);
        this.c.setOnFlingListener(this);
    }

    private void ve() {
        this.c.tt(this.ve);
        this.c.setOnFlingListener(null);
    }

    private boolean tt(RecyclerView.i iVar, int i, int i2) {
        RecyclerView.my myVarVe;
        int iC;
        if (!(iVar instanceof RecyclerView.my.tt) || (myVarVe = ve(iVar)) == null || (iC = c(iVar, i, i2)) == -1) {
            return false;
        }
        myVarVe.ve(iC);
        iVar.c(myVarVe);
        return true;
    }

    public void c() {
        RecyclerView.i layoutManager;
        View viewC;
        RecyclerView recyclerView = this.c;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewC = c(layoutManager)) == null) {
            return;
        }
        int[] iArrC = c(layoutManager, viewC);
        int i = iArrC[0];
        if (i == 0 && iArrC[1] == 0) {
            return;
        }
        this.c.c(i, iArrC[1]);
    }

    public RecyclerView.my ve(RecyclerView.i iVar) {
        return tt(iVar);
    }

    @Deprecated
    public a tt(RecyclerView.i iVar) {
        if (iVar instanceof RecyclerView.my.tt) {
            return new a(this.c.getContext()) { // from class: com.byazt.kt.t.2
                @Override // com.byazt.kt.a, com.byazt.kt.RecyclerView.my
                public void c(View view, RecyclerView.gt gtVar, RecyclerView.my.c cVar) {
                    if (t.this.c != null) {
                        t tVar = t.this;
                        int[] iArrC = tVar.c(tVar.c.getLayoutManager(), view);
                        int i = iArrC[0];
                        int i2 = iArrC[1];
                        int iC = c(Math.max(Math.abs(i), Math.abs(i2)));
                        if (iC > 0) {
                            cVar.update(i, i2, iC, this.tt);
                        }
                    }
                }

                @Override // com.byazt.kt.a
                public float c(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }
}
