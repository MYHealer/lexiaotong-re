package com.byazt.un;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.omf.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 96, 2008})
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {
    public boolean c;
    public int tt;

    public void setCanInterruptVideoPlay(boolean z) {
        this.c = z;
    }

    public NativeDrawVideoTsView(Context context, ic icVar) {
        super(context, icVar);
        this.c = false;
        setOnClickListener(this);
        this.tt = getResources().getConfiguration().orientation;
    }

    public NativeDrawVideoTsView(Context context, ic icVar, String str, boolean z, boolean z2) {
        super(context, icVar, str, z, z2);
        this.c = false;
        setOnClickListener(this);
        this.tt = getResources().getConfiguration().orientation;
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void sp() {
        this.z = "draw_ad";
        super.sp();
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void tt() {
        if (this.c) {
            super.tt();
        }
    }

    public void c(Bitmap bitmap, int i) {
        x.m().c(bitmap);
        this.m = i;
    }

    @Override // com.byazt.un.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        if (this.t != null && this.t.getVisibility() == 0) {
            rl();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.byazt.un.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.t != null && this.t.getVisibility() == 0) {
            rl();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void x() {
        pf.c((View) this.da, 0);
        pf.c((View) this.sl, 0);
        pf.c((View) this.u, 8);
    }

    private void rl() {
        t();
        if (this.da != null) {
            if (this.da.getVisibility() == 0) {
                return;
            }
            com.byazt.xky.tt.c(xd.tt(this.uj)).to(this.sl);
            c(this.sl, xd.tt(this.uj));
        }
        x();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.t != null && this.t.getVisibility() == 0) {
            pf.n(this.da);
        }
        tt();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (this.tt == configuration.orientation) {
            return;
        }
        this.tt = configuration.orientation;
        pf.c(this, new pf.c() { // from class: com.byazt.un.NativeDrawVideoTsView.1
            @Override // com.byazt.aas.pf.c
            public void c(View view) {
                if (NativeDrawVideoTsView.this.n == null) {
                    return;
                }
                NativeDrawVideoTsView.this.c(NativeDrawVideoTsView.this.getWidth(), NativeDrawVideoTsView.this.getHeight());
            }
        });
    }

    @Override // com.byazt.un.NativeVideoTsView
    public void uj() {
        int i = getResources().getConfiguration().orientation;
        if (this.tt != i) {
            this.tt = i;
            pf.c(this, new pf.c() { // from class: com.byazt.un.NativeDrawVideoTsView.2
                @Override // com.byazt.aas.pf.c
                public void c(View view) {
                    if (NativeDrawVideoTsView.this.n == null) {
                        return;
                    }
                    NativeDrawVideoTsView.this.c(NativeDrawVideoTsView.this.getWidth(), NativeDrawVideoTsView.this.getHeight());
                    NativeDrawVideoTsView.super.uj();
                }
            });
        } else {
            super.uj();
        }
    }

    @Override // com.byazt.un.NativeVideoTsView
    public com.byazt.dh.ve c(Context context, ViewGroup viewGroup, ic icVar, String str, boolean z, boolean z2, boolean z3) {
        return new ve(context, viewGroup, icVar, str, z, z2, z3);
    }
}
