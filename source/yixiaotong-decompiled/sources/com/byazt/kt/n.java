package com.byazt.kt;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 46})
public class n extends RecyclerView.i implements RecyclerView.my.tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public uj f2432a;
    public int c;
    public final tt gr;
    public boolean gt;
    public boolean gu;
    public boolean my;
    public int n;
    public boolean qy;
    public ve rh;
    public boolean rl;
    public final c sp;
    public x tt;
    public int uj;
    public boolean ve;
    public int zm;

    @com.byazt.zqa.c(c = {0, 1, 166, 934})
    protected static class tt {
        public int c;
        public boolean tt;
        public boolean uj;
        public boolean ve;

        public void c() {
            this.c = 0;
            this.tt = false;
            this.ve = false;
            this.uj = false;
        }
    }

    @Override // com.byazt.kt.RecyclerView.i
    public boolean c() {
        return true;
    }

    @Override // com.byazt.kt.RecyclerView.i
    public boolean t() {
        return this.f2432a == null && this.my == this.rl;
    }

    @Override // com.byazt.kt.RecyclerView.i
    public boolean uj() {
        return this.c == 1;
    }

    @Override // com.byazt.kt.RecyclerView.i
    public boolean ve() {
        return this.c == 0;
    }

    public n(Context context) {
        this(context, 1, false);
    }

    public n(Context context, int i, boolean z) {
        this.c = 1;
        this.gt = false;
        this.ve = false;
        this.rl = false;
        this.qy = true;
        this.uj = -1;
        this.n = Integer.MIN_VALUE;
        this.f2432a = null;
        this.sp = new c();
        this.gr = new tt();
        this.zm = 2;
        c(i);
        c(z);
    }

    @Override // com.byazt.kt.RecyclerView.i
    public RecyclerView.da tt() {
        return new RecyclerView.da(-2, -2);
    }

    @Override // com.byazt.kt.RecyclerView.i
    public void c(RecyclerView recyclerView, RecyclerView.m mVar) {
        super.c(recyclerView, mVar);
        if (this.gu) {
            ve(mVar);
            mVar.c();
        }
    }

    public void c(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i)));
        }
        c((String) null);
        if (i != this.c || this.tt == null) {
            x xVarC = x.c(this, i);
            this.tt = xVarC;
            this.sp.c = xVarC;
            this.c = i;
            u();
        }
    }

    private void cu() {
        if (this.c == 1 || !n()) {
            this.ve = this.gt;
        } else {
            this.ve = !this.gt;
        }
    }

    public void c(boolean z) {
        c((String) null);
        if (z != this.gt) {
            this.gt = z;
            u();
        }
    }

    @Override // com.byazt.kt.RecyclerView.i
    public View tt(int i) {
        int iMy = my();
        if (iMy == 0) {
            return null;
        }
        int iUj = i - uj(x(0));
        if (iUj >= 0 && iUj < iMy) {
            View viewX = x(iUj);
            if (uj(viewX) == i) {
                return viewX;
            }
        }
        return super.tt(i);
    }

    public int c(RecyclerView.gt gtVar) {
        if (gtVar.ve()) {
            return this.tt.a();
        }
        return 0;
    }

    @Override // com.byazt.kt.RecyclerView.i
    public void c(RecyclerView recyclerView, RecyclerView.gt gtVar, int i) {
        a aVar = new a(recyclerView.getContext());
        aVar.ve(i);
        c(aVar);
    }

    @Override // com.byazt.kt.RecyclerView.my.tt
    public PointF ve(int i) {
        if (my() == 0) {
            return null;
        }
        int i2 = (i < uj(x(0))) != this.ve ? -1 : 1;
        return this.c == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // com.byazt.kt.RecyclerView.i
    public void c(RecyclerView.m mVar, RecyclerView.gt gtVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int iC;
        int i6;
        View viewTt;
        int iC2;
        int iUj;
        if ((this.f2432a != null || this.uj != -1) && gtVar.uj() == 0) {
            ve(mVar);
            return;
        }
        uj ujVar = this.f2432a;
        if (ujVar != null && ujVar.c()) {
            this.uj = this.f2432a.c;
        }
        a();
        this.rh.c = false;
        cu();
        View viewMd = md();
        if (this.sp.n && this.uj == -1 && this.f2432a == null) {
            if (viewMd != null && (this.tt.c(viewMd) >= this.tt.uj() || this.tt.tt(viewMd) <= this.tt.ve())) {
                this.sp.c(viewMd, uj(viewMd));
            }
        } else {
            this.sp.c();
            this.sp.uj = this.ve ^ this.rl;
            c(mVar, gtVar, this.sp);
            this.sp.n = true;
        }
        int iC3 = c(gtVar);
        if (this.rh.da >= 0) {
            i = iC3;
            iC3 = 0;
        } else {
            i = 0;
        }
        int iVe = iC3 + this.tt.ve();
        int iSp = i + this.tt.sp();
        if (gtVar.c() && (i6 = this.uj) != -1 && this.n != Integer.MIN_VALUE && (viewTt = tt(i6)) != null) {
            if (this.ve) {
                iUj = this.tt.uj() - this.tt.tt(viewTt);
                iC2 = this.n;
            } else {
                iC2 = this.tt.c(viewTt) - this.tt.ve();
                iUj = this.n;
            }
            int i7 = iUj - iC2;
            if (i7 > 0) {
                iVe += i7;
            } else {
                iSp -= i7;
            }
        }
        c(mVar);
        this.rh.t = x();
        this.rh.i = gtVar.c();
        if (this.sp.uj) {
            tt(this.sp);
            this.rh.x = iVe;
            c(mVar, this.rh, gtVar, false);
            i3 = this.rh.tt;
            int i8 = this.rh.uj;
            if (this.rh.ve > 0) {
                iSp += this.rh.ve;
            }
            c(this.sp);
            this.rh.x = iSp;
            this.rh.uj += this.rh.n;
            c(mVar, this.rh, gtVar, false);
            i2 = this.rh.tt;
            if (this.rh.ve > 0) {
                int i9 = this.rh.ve;
                sp(i8, i3);
                this.rh.x = i9;
                c(mVar, this.rh, gtVar, false);
                i3 = this.rh.tt;
            }
        } else {
            c(this.sp);
            this.rh.x = iSp;
            c(mVar, this.rh, gtVar, false);
            i2 = this.rh.tt;
            int i10 = this.rh.uj;
            if (this.rh.ve > 0) {
                iVe += this.rh.ve;
            }
            tt(this.sp);
            this.rh.x = iVe;
            this.rh.uj += this.rh.n;
            c(mVar, this.rh, gtVar, false);
            i3 = this.rh.tt;
            if (this.rh.ve > 0) {
                int i11 = this.rh.ve;
                a(i10, i2);
                this.rh.x = i11;
                c(mVar, this.rh, gtVar, false);
                i2 = this.rh.tt;
            }
        }
        if (my() > 0) {
            if (this.ve ^ this.rl) {
                int iC4 = c(i2, mVar, gtVar, true);
                i4 = i3 + iC4;
                i5 = i2 + iC4;
                iC = tt(i4, mVar, gtVar, false);
            } else {
                int iTt = tt(i3, mVar, gtVar, true);
                i4 = i3 + iTt;
                i5 = i2 + iTt;
                iC = c(i5, mVar, gtVar, false);
            }
            i3 = i4 + iC;
            i2 = i5 + iC;
        }
        tt(mVar, gtVar, i3, i2);
        if (!gtVar.c()) {
            this.tt.c();
        } else {
            this.sp.c();
        }
        this.my = this.rl;
    }

    @Override // com.byazt.kt.RecyclerView.i
    public void tt(RecyclerView.gt gtVar) {
        super.tt(gtVar);
        this.f2432a = null;
        this.uj = -1;
        this.n = Integer.MIN_VALUE;
        this.sp.c();
    }

    private void tt(RecyclerView.m mVar, RecyclerView.gt gtVar, int i, int i2) {
        if (!gtVar.tt() || my() == 0 || gtVar.c() || !t()) {
            return;
        }
        List<RecyclerView.gu> listVe = mVar.ve();
        int size = listVe.size();
        int iUj = uj(x(0));
        int iN = 0;
        int iN2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView.gu guVar = listVe.get(i3);
            if (!guVar.nu()) {
                if ((guVar.uj() < iUj) != this.ve) {
                    iN += this.tt.n(guVar.c);
                } else {
                    iN2 += this.tt.n(guVar.c);
                }
            }
        }
        this.rh.sl = listVe;
        if (iN > 0) {
            sp(uj(qp()), i);
            this.rh.x = iN;
            this.rh.ve = 0;
            this.rh.c();
            c(mVar, this.rh, gtVar, false);
        }
        if (iN2 > 0) {
            a(uj(nb()), i2);
            this.rh.x = iN2;
            this.rh.ve = 0;
            this.rh.c();
            c(mVar, this.rh, gtVar, false);
        }
        this.rh.sl = null;
    }

    private void c(RecyclerView.m mVar, RecyclerView.gt gtVar, c cVar) {
        if (c(gtVar, cVar) || tt(mVar, gtVar, cVar)) {
            return;
        }
        cVar.tt();
        cVar.tt = this.rl ? gtVar.uj() - 1 : 0;
    }

    private boolean tt(RecyclerView.m mVar, RecyclerView.gt gtVar, c cVar) {
        if (my() == 0) {
            return false;
        }
        View viewMd = md();
        if (viewMd != null && cVar.c(viewMd, gtVar)) {
            cVar.c(viewMd, uj(viewMd));
            return true;
        }
        if (this.my != this.rl) {
            return false;
        }
        View viewTt = cVar.uj ? tt(mVar, gtVar) : ve(mVar, gtVar);
        if (viewTt == null) {
            return false;
        }
        cVar.tt(viewTt, uj(viewTt));
        if (!gtVar.c() && t() && (this.tt.c(viewTt) >= this.tt.uj() || this.tt.tt(viewTt) < this.tt.ve())) {
            cVar.ve = cVar.uj ? this.tt.uj() : this.tt.ve();
        }
        return true;
    }

    private boolean c(RecyclerView.gt gtVar, c cVar) {
        int i;
        if (!gtVar.c() && (i = this.uj) != -1) {
            if (i >= 0 && i < gtVar.uj()) {
                cVar.tt = this.uj;
                uj ujVar = this.f2432a;
                if (ujVar != null && ujVar.c()) {
                    cVar.uj = this.f2432a.ve;
                    if (cVar.uj) {
                        cVar.ve = this.tt.uj() - this.f2432a.tt;
                    } else {
                        cVar.ve = this.tt.ve() + this.f2432a.tt;
                    }
                    return true;
                }
                if (this.n == Integer.MIN_VALUE) {
                    View viewTt = tt(this.uj);
                    if (viewTt != null) {
                        if (this.tt.n(viewTt) > this.tt.a()) {
                            cVar.tt();
                            return true;
                        }
                        if (this.tt.c(viewTt) - this.tt.ve() < 0) {
                            cVar.ve = this.tt.ve();
                            cVar.uj = false;
                            return true;
                        }
                        if (this.tt.uj() - this.tt.tt(viewTt) < 0) {
                            cVar.ve = this.tt.uj();
                            cVar.uj = true;
                            return true;
                        }
                        cVar.ve = cVar.uj ? this.tt.tt(viewTt) + this.tt.tt() : this.tt.c(viewTt);
                    } else {
                        if (my() > 0) {
                            cVar.uj = (this.uj < uj(x(0))) == this.ve;
                        }
                        cVar.tt();
                    }
                    return true;
                }
                cVar.uj = this.ve;
                if (this.ve) {
                    cVar.ve = this.tt.uj() - this.n;
                } else {
                    cVar.ve = this.tt.ve() + this.n;
                }
                return true;
            }
            this.uj = -1;
            this.n = Integer.MIN_VALUE;
        }
        return false;
    }

    private int c(int i, RecyclerView.m mVar, RecyclerView.gt gtVar, boolean z) {
        int iUj;
        int iUj2 = this.tt.uj() - i;
        if (iUj2 <= 0) {
            return 0;
        }
        int i2 = -ve(-iUj2, mVar, gtVar);
        int i3 = i + i2;
        if (!z || (iUj = this.tt.uj() - i3) <= 0) {
            return i2;
        }
        this.tt.c(iUj);
        return iUj + i2;
    }

    private int tt(int i, RecyclerView.m mVar, RecyclerView.gt gtVar, boolean z) {
        int iVe;
        int iVe2 = i - this.tt.ve();
        if (iVe2 <= 0) {
            return 0;
        }
        int i2 = -ve(iVe2, mVar, gtVar);
        int i3 = i + i2;
        if (!z || (iVe = i3 - this.tt.ve()) <= 0) {
            return i2;
        }
        this.tt.c(-iVe);
        return i2 - iVe;
    }

    private void c(c cVar) {
        a(cVar.tt, cVar.ve);
    }

    private void a(int i, int i2) {
        this.rh.ve = this.tt.uj() - i2;
        this.rh.n = this.ve ? -1 : 1;
        this.rh.uj = i;
        this.rh.f2433a = 1;
        this.rh.tt = i2;
        this.rh.sp = Integer.MIN_VALUE;
    }

    private void tt(c cVar) {
        sp(cVar.tt, cVar.ve);
    }

    private void sp(int i, int i2) {
        this.rh.ve = i2 - this.tt.ve();
        this.rh.uj = i;
        this.rh.n = this.ve ? 1 : -1;
        this.rh.f2433a = -1;
        this.rh.tt = i2;
        this.rh.sp = Integer.MIN_VALUE;
    }

    public boolean n() {
        return nu() == 1;
    }

    public void a() {
        if (this.rh == null) {
            this.rh = sp();
        }
    }

    public ve sp() {
        return new ve();
    }

    @Override // com.byazt.kt.RecyclerView.i
    public void uj(int i) {
        this.uj = i;
        this.n = Integer.MIN_VALUE;
        uj ujVar = this.f2432a;
        if (ujVar != null) {
            ujVar.tt();
        }
        u();
    }

    @Override // com.byazt.kt.RecyclerView.i
    public int c(int i, RecyclerView.m mVar, RecyclerView.gt gtVar) {
        if (this.c == 1) {
            return 0;
        }
        return ve(i, mVar, gtVar);
    }

    @Override // com.byazt.kt.RecyclerView.i
    public int tt(int i, RecyclerView.m mVar, RecyclerView.gt gtVar) {
        if (this.c == 0) {
            return 0;
        }
        return ve(i, mVar, gtVar);
    }

    @Override // com.byazt.kt.RecyclerView.i
    public int ve(RecyclerView.gt gtVar) {
        return i(gtVar);
    }

    @Override // com.byazt.kt.RecyclerView.i
    public int uj(RecyclerView.gt gtVar) {
        return i(gtVar);
    }

    @Override // com.byazt.kt.RecyclerView.i
    public int n(RecyclerView.gt gtVar) {
        return da(gtVar);
    }

    @Override // com.byazt.kt.RecyclerView.i
    public int a(RecyclerView.gt gtVar) {
        return da(gtVar);
    }

    @Override // com.byazt.kt.RecyclerView.i
    public int sp(RecyclerView.gt gtVar) {
        return sl(gtVar);
    }

    @Override // com.byazt.kt.RecyclerView.i
    public int x(RecyclerView.gt gtVar) {
        return sl(gtVar);
    }

    private int i(RecyclerView.gt gtVar) {
        if (my() == 0) {
            return 0;
        }
        a();
        return da.c(gtVar, this.tt, c(!this.qy, true), tt(!this.qy, true), this, this.qy, this.ve);
    }

    private int da(RecyclerView.gt gtVar) {
        if (my() == 0) {
            return 0;
        }
        a();
        return da.c(gtVar, this.tt, c(!this.qy, true), tt(!this.qy, true), this, this.qy);
    }

    private int sl(RecyclerView.gt gtVar) {
        if (my() == 0) {
            return 0;
        }
        a();
        return da.tt(gtVar, this.tt, c(!this.qy, true), tt(!this.qy, true), this, this.qy);
    }

    private void c(int i, int i2, boolean z, RecyclerView.gt gtVar) {
        int iVe;
        this.rh.t = x();
        this.rh.x = c(gtVar);
        this.rh.f2433a = i;
        if (i == 1) {
            this.rh.x += this.tt.sp();
            View viewNb = nb();
            this.rh.n = this.ve ? -1 : 1;
            this.rh.uj = uj(viewNb) + this.rh.n;
            this.rh.tt = this.tt.tt(viewNb);
            iVe = this.tt.tt(viewNb) - this.tt.uj();
        } else {
            View viewQp = qp();
            this.rh.x += this.tt.ve();
            this.rh.n = this.ve ? 1 : -1;
            this.rh.uj = uj(viewQp) + this.rh.n;
            this.rh.tt = this.tt.c(viewQp);
            iVe = (-this.tt.c(viewQp)) + this.tt.ve();
        }
        this.rh.ve = i2;
        if (z) {
            this.rh.ve -= iVe;
        }
        this.rh.sp = iVe;
    }

    public boolean x() {
        return this.tt.x() == 0 && this.tt.n() == 0;
    }

    public void c(RecyclerView.gt gtVar, ve veVar, RecyclerView.i.c cVar) {
        int i = veVar.uj;
        if (i < 0 || i >= gtVar.uj()) {
            return;
        }
        cVar.tt(i, Math.max(0, veVar.sp));
    }

    @Override // com.byazt.kt.RecyclerView.i
    public void c(int i, RecyclerView.i.c cVar) {
        boolean z;
        int i2;
        uj ujVar = this.f2432a;
        if (ujVar != null && ujVar.c()) {
            z = this.f2432a.ve;
            i2 = this.f2432a.c;
        } else {
            cu();
            z = this.ve;
            i2 = this.uj;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.zm && i2 >= 0 && i2 < i; i4++) {
            cVar.tt(i2, 0);
            i2 += i3;
        }
    }

    @Override // com.byazt.kt.RecyclerView.i
    public void c(int i, int i2, RecyclerView.gt gtVar, RecyclerView.i.c cVar) {
        if (this.c != 0) {
            i = i2;
        }
        if (my() == 0 || i == 0) {
            return;
        }
        a();
        c(i > 0 ? 1 : -1, Math.abs(i), true, gtVar);
        c(gtVar, this.rh, cVar);
    }

    public int ve(int i, RecyclerView.m mVar, RecyclerView.gt gtVar) {
        if (my() == 0 || i == 0) {
            return 0;
        }
        this.rh.c = true;
        a();
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        c(i2, iAbs, true, gtVar);
        int iC = this.rh.sp + c(mVar, this.rh, gtVar, false);
        if (iC < 0) {
            return 0;
        }
        if (iAbs > iC) {
            i = i2 * iC;
        }
        this.tt.c(-i);
        this.rh.da = i;
        return i;
    }

    @Override // com.byazt.kt.RecyclerView.i
    public void c(String str) {
        if (this.f2432a == null) {
            super.c(str);
        }
    }

    private void c(RecyclerView.m mVar, int i, int i2) {
        if (i != i2) {
            if (i2 <= i) {
                while (i > i2) {
                    c(i, mVar);
                    i--;
                }
            } else {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    c(i3, mVar);
                }
            }
        }
    }

    private void c(RecyclerView.m mVar, int i) {
        if (i >= 0) {
            int iMy = my();
            if (!this.ve) {
                for (int i2 = 0; i2 < iMy; i2++) {
                    View viewX = x(i2);
                    if (this.tt.tt(viewX) > i || this.tt.ve(viewX) > i) {
                        c(mVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = iMy - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View viewX2 = x(i4);
                if (this.tt.tt(viewX2) > i || this.tt.ve(viewX2) > i) {
                    c(mVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void tt(RecyclerView.m mVar, int i) {
        int iMy = my();
        if (i >= 0) {
            int iN = this.tt.n() - i;
            if (this.ve) {
                for (int i2 = 0; i2 < iMy; i2++) {
                    View viewX = x(i2);
                    if (this.tt.c(viewX) < iN || this.tt.uj(viewX) < iN) {
                        c(mVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = iMy - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View viewX2 = x(i4);
                if (this.tt.c(viewX2) < iN || this.tt.uj(viewX2) < iN) {
                    c(mVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void c(RecyclerView.m mVar, ve veVar) {
        if (!veVar.c || veVar.t) {
            return;
        }
        if (veVar.f2433a == -1) {
            tt(mVar, veVar.sp);
        } else {
            c(mVar, veVar.sp);
        }
    }

    public int c(RecyclerView.m mVar, ve veVar, RecyclerView.gt gtVar, boolean z) {
        int i = veVar.ve;
        if (veVar.sp != Integer.MIN_VALUE) {
            if (veVar.ve < 0) {
                veVar.sp += veVar.ve;
            }
            c(mVar, veVar);
        }
        int i2 = veVar.ve + veVar.x;
        tt ttVar = this.gr;
        while (true) {
            if ((!veVar.t && i2 <= 0) || !veVar.c(gtVar)) {
                break;
            }
            ttVar.c();
            c(mVar, gtVar, veVar, ttVar);
            if (!ttVar.tt) {
                veVar.tt += ttVar.c * veVar.f2433a;
                if (!ttVar.ve || this.rh.sl != null || !gtVar.c()) {
                    veVar.ve -= ttVar.c;
                    i2 -= ttVar.c;
                }
                if (veVar.sp != Integer.MIN_VALUE) {
                    veVar.sp += ttVar.c;
                    if (veVar.ve < 0) {
                        veVar.sp += veVar.ve;
                    }
                    c(mVar, veVar);
                }
                if (z && ttVar.uj) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - veVar.ve;
    }

    public void c(RecyclerView.m mVar, RecyclerView.gt gtVar, ve veVar, tt ttVar) {
        int i;
        int i2;
        int i3;
        int iGr;
        int iA;
        View viewC = veVar.c(mVar);
        if (viewC == null) {
            ttVar.tt = true;
            return;
        }
        RecyclerView.da daVar = (RecyclerView.da) viewC.getLayoutParams();
        if (veVar.sl == null) {
            if (this.ve == (veVar.f2433a == -1)) {
                tt(viewC);
            } else {
                tt(viewC, 0);
            }
        } else {
            if (this.ve == (veVar.f2433a == -1)) {
                c(viewC);
            } else {
                c(viewC, 0);
            }
        }
        c(viewC, 0, 0);
        ttVar.c = this.tt.n(viewC);
        if (this.c == 1) {
            if (n()) {
                iA = qy() - yv();
                iGr = iA - this.tt.a(viewC);
            } else {
                iGr = gr();
                iA = this.tt.a(viewC) + iGr;
            }
            if (veVar.f2433a == -1) {
                int i4 = veVar.tt;
                i2 = veVar.tt - ttVar.c;
                i = iA;
                i3 = i4;
            } else {
                int i5 = veVar.tt;
                i3 = veVar.tt + ttVar.c;
                i = iA;
                i2 = i5;
            }
        } else {
            int iZm = zm();
            int iA2 = this.tt.a(viewC) + iZm;
            if (veVar.f2433a == -1) {
                i2 = iZm;
                i = veVar.tt;
                i3 = iA2;
                iGr = veVar.tt - ttVar.c;
            } else {
                int i6 = veVar.tt;
                i = veVar.tt + ttVar.c;
                i2 = iZm;
                i3 = iA2;
                iGr = i6;
            }
        }
        c(viewC, iGr, i2, i, i3);
        if (daVar.tt() || daVar.ve()) {
            ttVar.ve = true;
        }
        ttVar.uj = viewC.hasFocusable();
    }

    @Override // com.byazt.kt.RecyclerView.i
    public boolean i() {
        return (rl() == 1073741824 || gt() == 1073741824 || !or()) ? false : true;
    }

    public int n(int i) {
        if (i == 1) {
            return (this.c != 1 && n()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.c != 1 && n()) ? -1 : 1;
        }
        if (i == 17) {
            return this.c == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.c == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i != 66) {
            return (i == 130 && this.c == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.c == 0 ? 1 : Integer.MIN_VALUE;
    }

    private View qp() {
        return x(this.ve ? my() - 1 : 0);
    }

    private View nb() {
        return x(this.ve ? 0 : my() - 1);
    }

    private View c(boolean z, boolean z2) {
        int iMy;
        int iMy2;
        if (this.ve) {
            iMy = my() - 1;
            iMy2 = -1;
        } else {
            iMy = 0;
            iMy2 = my();
        }
        return c(iMy, iMy2, z, z2);
    }

    private View tt(boolean z, boolean z2) {
        int iMy;
        int iMy2;
        if (this.ve) {
            iMy = 0;
            iMy2 = my();
        } else {
            iMy = my() - 1;
            iMy2 = -1;
        }
        return c(iMy, iMy2, z, z2);
    }

    private View tt(RecyclerView.m mVar, RecyclerView.gt gtVar) {
        return this.ve ? uj(mVar, gtVar) : n(mVar, gtVar);
    }

    private View ve(RecyclerView.m mVar, RecyclerView.gt gtVar) {
        return this.ve ? n(mVar, gtVar) : uj(mVar, gtVar);
    }

    private View uj(RecyclerView.m mVar, RecyclerView.gt gtVar) {
        return c(mVar, gtVar, 0, my(), gtVar.uj());
    }

    private View n(RecyclerView.m mVar, RecyclerView.gt gtVar) {
        return c(mVar, gtVar, my() - 1, -1, gtVar.uj());
    }

    public View c(RecyclerView.m mVar, RecyclerView.gt gtVar, int i, int i2, int i3) {
        a();
        int iVe = this.tt.ve();
        int iUj = this.tt.uj();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewX = x(i);
            int iUj2 = uj(viewX);
            if (iUj2 >= 0 && iUj2 < i3) {
                if (((RecyclerView.da) viewX.getLayoutParams()).tt()) {
                    if (view2 == null) {
                        view2 = viewX;
                    }
                } else {
                    if (this.tt.c(viewX) < iUj && this.tt.tt(viewX) >= iVe) {
                        return viewX;
                    }
                    if (view == null) {
                        view = viewX;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private View a(RecyclerView.m mVar, RecyclerView.gt gtVar) {
        return this.ve ? x(mVar, gtVar) : i(mVar, gtVar);
    }

    private View sp(RecyclerView.m mVar, RecyclerView.gt gtVar) {
        return this.ve ? i(mVar, gtVar) : x(mVar, gtVar);
    }

    private View x(RecyclerView.m mVar, RecyclerView.gt gtVar) {
        return c(0, my());
    }

    private View i(RecyclerView.m mVar, RecyclerView.gt gtVar) {
        return c(my() - 1, -1);
    }

    public int da() {
        View viewC = c(0, my(), false, true);
        if (viewC == null) {
            return -1;
        }
        return uj(viewC);
    }

    public int sl() {
        View viewC = c(my() - 1, -1, false, true);
        if (viewC == null) {
            return -1;
        }
        return uj(viewC);
    }

    public View c(int i, int i2, boolean z, boolean z2) {
        a();
        int i3 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        int i4 = z ? 24579 : 320;
        if (!z2) {
            i3 = 0;
        }
        return (this.c == 0 ? this.da : this.sl).c(i, i2, i4, i3);
    }

    public View c(int i, int i2) {
        int i3;
        int i4;
        a();
        if (i2 <= i && i2 >= i) {
            return x(i);
        }
        if (this.tt.c(x(i)) < this.tt.ve()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return (this.c == 0 ? this.da : this.sl).c(i, i2, i3, i4);
    }

    @Override // com.byazt.kt.RecyclerView.i
    public View c(View view, int i, RecyclerView.m mVar, RecyclerView.gt gtVar) {
        int iN;
        View viewA;
        View viewNb;
        cu();
        if (my() == 0 || (iN = n(i)) == Integer.MIN_VALUE) {
            return null;
        }
        a();
        a();
        c(iN, (int) (this.tt.a() * 0.33333334f), false, gtVar);
        this.rh.sp = Integer.MIN_VALUE;
        this.rh.c = false;
        c(mVar, this.rh, gtVar, true);
        if (iN == -1) {
            viewA = sp(mVar, gtVar);
        } else {
            viewA = a(mVar, gtVar);
        }
        if (iN == -1) {
            viewNb = qp();
        } else {
            viewNb = nb();
        }
        if (!viewNb.hasFocusable()) {
            return viewA;
        }
        if (viewA == null) {
            return null;
        }
        return viewNb;
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 151})
    static class c {
        public x c;
        public boolean n;
        public int tt;
        public boolean uj;
        public int ve;

        public void c() {
            this.tt = -1;
            this.ve = Integer.MIN_VALUE;
            this.uj = false;
            this.n = false;
        }

        public c() {
            c();
        }

        public void tt() {
            this.ve = this.uj ? this.c.uj() : this.c.ve();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.tt + ", mCoordinate=" + this.ve + ", mLayoutFromEnd=" + this.uj + ", mValid=" + this.n + '}';
        }

        public boolean c(View view, RecyclerView.gt gtVar) {
            RecyclerView.da daVar = (RecyclerView.da) view.getLayoutParams();
            return !daVar.tt() && daVar.uj() >= 0 && daVar.uj() < gtVar.uj();
        }

        public void c(View view, int i) {
            int iTt = this.c.tt();
            if (iTt >= 0) {
                tt(view, i);
                return;
            }
            this.tt = i;
            if (this.uj) {
                int iUj = (this.c.uj() - iTt) - this.c.tt(view);
                this.ve = this.c.uj() - iUj;
                if (iUj > 0) {
                    int iN = this.ve - this.c.n(view);
                    int iVe = this.c.ve();
                    int iMin = iN - (iVe + Math.min(this.c.c(view) - iVe, 0));
                    if (iMin < 0) {
                        this.ve += Math.min(iUj, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iC = this.c.c(view);
            int iVe2 = iC - this.c.ve();
            this.ve = iC;
            if (iVe2 > 0) {
                int iUj2 = (this.c.uj() - Math.min(0, (this.c.uj() - iTt) - this.c.tt(view))) - (iC + this.c.n(view));
                if (iUj2 < 0) {
                    this.ve -= Math.min(iVe2, -iUj2);
                }
            }
        }

        public void tt(View view, int i) {
            if (this.uj) {
                this.ve = this.c.tt(view) + this.c.tt();
            } else {
                this.ve = this.c.c(view);
            }
            this.tt = i;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 938})
    public static class uj implements Parcelable {
        public static final Parcelable.Creator<uj> CREATOR = new Parcelable.Creator<uj>() { // from class: com.byazt.kt.n.uj.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public uj createFromParcel(Parcel parcel) {
                return new uj(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public uj[] newArray(int i) {
                return new uj[i];
            }
        };
        public int c;
        public int tt;
        public boolean ve;

        public boolean c() {
            return this.c >= 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void tt() {
            this.c = -1;
        }

        public uj() {
        }

        public uj(Parcel parcel) {
            this.c = parcel.readInt();
            this.tt = parcel.readInt();
            this.ve = parcel.readInt() == 1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.c);
            parcel.writeInt(this.tt);
            parcel.writeInt(this.ve ? 1 : 0);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, MediaPlayer.MEDIA_PLAYER_OPTION_TTMP_DNS_PARSE_ENABLE})
    static class ve {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2433a;
        public int da;
        public int n;
        public int sp;
        public boolean t;
        public int tt;
        public int uj;
        public int ve;
        public boolean c = true;
        public int x = 0;
        public boolean i = false;
        public List<RecyclerView.gu> sl = null;

        public boolean c(RecyclerView.gt gtVar) {
            int i = this.uj;
            return i >= 0 && i < gtVar.uj();
        }

        public View c(RecyclerView.m mVar) {
            if (this.sl != null) {
                return tt();
            }
            View viewTt = mVar.tt(this.uj);
            this.uj += this.n;
            return viewTt;
        }

        private View tt() {
            int size = this.sl.size();
            for (int i = 0; i < size; i++) {
                View view = this.sl.get(i).c;
                RecyclerView.da daVar = (RecyclerView.da) view.getLayoutParams();
                if (!daVar.tt() && this.uj == daVar.uj()) {
                    c(view);
                    return view;
                }
            }
            return null;
        }

        public void c() {
            c((View) null);
        }

        public void c(View view) {
            View viewTt = tt(view);
            if (viewTt == null) {
                this.uj = -1;
            } else {
                this.uj = ((RecyclerView.da) viewTt.getLayoutParams()).uj();
            }
        }

        public View tt(View view) {
            int iUj;
            int size = this.sl.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.sl.get(i2).c;
                RecyclerView.da daVar = (RecyclerView.da) view3.getLayoutParams();
                if (view3 != view && !daVar.tt() && (iUj = (daVar.uj() - this.uj) * this.n) >= 0 && iUj < i) {
                    view2 = view3;
                    if (iUj == 0) {
                        break;
                    }
                    i = iUj;
                }
            }
            return view2;
        }
    }
}
