package com.byazt.kt;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 71})
public abstract class x {
    public final RecyclerView.i c;
    public final Rect tt;
    public int ve;

    public abstract int a();

    public abstract int a(View view);

    public abstract int c(View view);

    public abstract void c(int i);

    public abstract int n();

    public abstract int n(View view);

    public abstract int sp();

    public abstract int tt(View view);

    public abstract int uj();

    public abstract int uj(View view);

    public abstract int ve();

    public abstract int ve(View view);

    public abstract int x();

    private x(RecyclerView.i iVar) {
        this.ve = Integer.MIN_VALUE;
        this.tt = new Rect();
        this.c = iVar;
    }

    public void c() {
        this.ve = a();
    }

    public int tt() {
        if (Integer.MIN_VALUE == this.ve) {
            return 0;
        }
        return a() - this.ve;
    }

    public static x c(RecyclerView.i iVar, int i) {
        if (i == 0) {
            return c(iVar);
        }
        if (i == 1) {
            return tt(iVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static x c(RecyclerView.i iVar) {
        return new x(iVar) { // from class: com.byazt.kt.x.1
            @Override // com.byazt.kt.x
            public int uj() {
                return this.c.qy() - this.c.yv();
            }

            @Override // com.byazt.kt.x
            public int n() {
                return this.c.qy();
            }

            @Override // com.byazt.kt.x
            public void c(int i) {
                this.c.i(i);
            }

            @Override // com.byazt.kt.x
            public int ve() {
                return this.c.gr();
            }

            @Override // com.byazt.kt.x
            public int n(View view) {
                RecyclerView.da daVar = (RecyclerView.da) view.getLayoutParams();
                return this.c.n(view) + daVar.leftMargin + daVar.rightMargin;
            }

            @Override // com.byazt.kt.x
            public int a(View view) {
                RecyclerView.da daVar = (RecyclerView.da) view.getLayoutParams();
                return this.c.a(view) + daVar.topMargin + daVar.bottomMargin;
            }

            @Override // com.byazt.kt.x
            public int tt(View view) {
                return this.c.i(view) + ((RecyclerView.da) view.getLayoutParams()).rightMargin;
            }

            @Override // com.byazt.kt.x
            public int c(View view) {
                return this.c.sp(view) - ((RecyclerView.da) view.getLayoutParams()).leftMargin;
            }

            @Override // com.byazt.kt.x
            public int ve(View view) {
                this.c.c(view, true, this.tt);
                return this.tt.right;
            }

            @Override // com.byazt.kt.x
            public int uj(View view) {
                this.c.c(view, true, this.tt);
                return this.tt.left;
            }

            @Override // com.byazt.kt.x
            public int a() {
                return (this.c.qy() - this.c.gr()) - this.c.yv();
            }

            @Override // com.byazt.kt.x
            public int sp() {
                return this.c.yv();
            }

            @Override // com.byazt.kt.x
            public int x() {
                return this.c.gt();
            }
        };
    }

    public static x tt(RecyclerView.i iVar) {
        return new x(iVar) { // from class: com.byazt.kt.x.2
            @Override // com.byazt.kt.x
            public int uj() {
                return this.c.gu() - this.c.p();
            }

            @Override // com.byazt.kt.x
            public int n() {
                return this.c.gu();
            }

            @Override // com.byazt.kt.x
            public void c(int i) {
                this.c.da(i);
            }

            @Override // com.byazt.kt.x
            public int ve() {
                return this.c.zm();
            }

            @Override // com.byazt.kt.x
            public int n(View view) {
                RecyclerView.da daVar = (RecyclerView.da) view.getLayoutParams();
                return this.c.a(view) + daVar.topMargin + daVar.bottomMargin;
            }

            @Override // com.byazt.kt.x
            public int a(View view) {
                RecyclerView.da daVar = (RecyclerView.da) view.getLayoutParams();
                return this.c.n(view) + daVar.leftMargin + daVar.rightMargin;
            }

            @Override // com.byazt.kt.x
            public int tt(View view) {
                return this.c.da(view) + ((RecyclerView.da) view.getLayoutParams()).bottomMargin;
            }

            @Override // com.byazt.kt.x
            public int c(View view) {
                return this.c.x(view) - ((RecyclerView.da) view.getLayoutParams()).topMargin;
            }

            @Override // com.byazt.kt.x
            public int ve(View view) {
                this.c.c(view, true, this.tt);
                return this.tt.bottom;
            }

            @Override // com.byazt.kt.x
            public int uj(View view) {
                this.c.c(view, true, this.tt);
                return this.tt.top;
            }

            @Override // com.byazt.kt.x
            public int a() {
                return (this.c.gu() - this.c.zm()) - this.c.p();
            }

            @Override // com.byazt.kt.x
            public int sp() {
                return this.c.p();
            }

            @Override // com.byazt.kt.x
            public int x() {
                return this.c.rl();
            }
        };
    }
}
