package com.hihonor.adsdk.common.f;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class c0 implements ViewTreeObserver.OnPreDrawListener {
    public static final int hnadsj = 74;
    public static final int hnadsk = 0;
    private static final String hnadsl = "ViewMonitor";
    private static final Map<View, c0> hnadsm = new ConcurrentHashMap();
    private final View hnadsd;
    private boolean hnadse;
    private long hnadsf;
    private int hnadsg;
    private final Rect hnadsh;
    private int hnadsi;

    public c0(View view) {
        this.hnadsh = new Rect();
        this.hnadsi = 0;
        this.hnadsd = view;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x0040  */
    private void hnadsa() {
        boolean z = this.hnadsd.isShown() && this.hnadsd.getLocalVisibleRect(this.hnadsh);
        int width = this.hnadsd.getWidth() * this.hnadsd.getHeight();
        if (z && width > 0) {
            int iWidth = ((this.hnadsh.width() * this.hnadsh.height()) * 100) / width;
            hnadsa(iWidth);
            if (iWidth > this.hnadsi) {
                if (z) {
                    hnadsi();
                    return;
                }
            }
        } else if (z) {
            hnadsi();
            return;
        }
        hnadsh();
    }

    protected void hnadsa(int i) {
        this.hnadsg = i;
    }

    protected void hnadsa(long j, int i) {
    }

    public int hnadsb() {
        return this.hnadsg;
    }

    public boolean hnadsc() {
        return this.hnadse && this.hnadsd.isShown();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x007c  */
    public boolean hnadsd() {
        boolean z = false;
        boolean z2 = this.hnadsd.isShown() && this.hnadsd.getLocalVisibleRect(this.hnadsh) && this.hnadsd.hasWindowFocus();
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsl, (Object) ("isValidVisibleArea,start isShowing: " + z2));
        int width = this.hnadsd.getWidth() * this.hnadsd.getHeight();
        if (!z2 || width <= 0) {
            z = z2;
        } else {
            int iWidth = this.hnadsh.width() * this.hnadsh.height();
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsl, (Object) ("isValidVisibleArea,area: " + width + ",showArea: " + iWidth));
            int i = (iWidth * 100) / width;
            hnadsa(i);
            if (i <= this.hnadsi) {
                com.hihonor.adsdk.common.b.b.hnadsa(hnadsl, (Object) "isValidVisibleArea,set isShowing false");
            } else {
                z = z2;
            }
        }
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsl, (Object) ("isValidVisibleArea,return isShowing: " + z));
        return z;
    }

    public boolean hnadse() {
        return this.hnadsg <= 0;
    }

    public void hnadsf() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "Ad view detach from window", new Object[0]);
        hnadsl();
        hnadsh();
    }

    public void hnadsg() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "Ad view attached to window", new Object[0]);
        hnadsk();
        hnadsa();
    }

    protected void hnadsj() {
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        hnadsa();
        return true;
    }

    private void hnadsk() {
        View view = this.hnadsd;
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            Map<View, c0> map = hnadsm;
            c0 c0Var = map.get(this.hnadsd);
            if (c0Var != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(c0Var);
            }
            map.put(this.hnadsd, this);
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnPreDrawListener(this);
            }
        }
    }

    public void hnadsl() {
        View view = this.hnadsd;
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            hnadsm.remove(this.hnadsd);
        }
    }

    private void hnadsi() {
        if (this.hnadse) {
            return;
        }
        this.hnadse = true;
        this.hnadsf = System.currentTimeMillis();
        hnadsj();
        this.hnadsg = 0;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "Ad view shown", new Object[0]);
    }

    protected void hnadsh() {
        if (this.hnadse) {
            this.hnadse = false;
            hnadsa(System.currentTimeMillis() - this.hnadsf, this.hnadsg);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "Ad view hide", new Object[0]);
        }
    }

    public c0(View view, int i) {
        this.hnadsh = new Rect();
        this.hnadsd = view;
        this.hnadsi = i;
    }
}
