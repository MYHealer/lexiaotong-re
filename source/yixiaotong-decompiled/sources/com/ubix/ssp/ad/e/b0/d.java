package com.ubix.ssp.ad.e.b0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.ubix.ssp.ad.g.k.j;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends e implements com.ubix.ssp.ad.e.b0.i.b {
    private HashMap<String, String> H;
    private AtomicInteger I;
    private int J;
    private boolean K;

    public d(Context context, boolean z, int i) {
        this(context, z, i, 0L);
    }

    public d(Context context, boolean z, int i, long j) {
        super(context, i, j);
        this.H = new HashMap<>();
        this.I = new AtomicInteger();
        this.J = 0;
        this.K = z;
        super.setAutoPlay(z);
    }

    public void a(int i) {
        this.J = i;
    }

    protected void a(MotionEvent motionEvent) {
        HashMap<String, String> map;
        String str;
        String str2;
        try {
            if (motionEvent.getAction() == 0) {
                this.H.put(com.hihonor.adsdk.base.g.j.e.c.hnadsc, motionEvent.getX() + "");
                this.H.put(com.hihonor.adsdk.base.g.j.e.c.hnadsd, motionEvent.getY() + "");
                this.H.put("__RAW_DOWN_X__", motionEvent.getRawX() + "");
                map = this.H;
                str = motionEvent.getRawY() + "";
                str2 = "__RAW_DOWN_Y__";
            } else {
                if (motionEvent.getAction() != 1) {
                    return;
                }
                this.H.put(com.hihonor.adsdk.base.g.j.e.c.hnadse, motionEvent.getX() + "");
                this.H.put(com.hihonor.adsdk.base.g.j.e.c.hnadsf, motionEvent.getY() + "");
                this.H.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, getWidth() + "");
                this.H.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, getHeight() + "");
                this.H.put("__RAW_UP_X__", motionEvent.getRawX() + "");
                this.H.put("__RAW_UP_Y__", motionEvent.getRawY() + "");
                map = this.H;
                str = motionEvent.getX() + "_" + motionEvent.getY();
                str2 = "__CLICK_XY__";
            }
            map.put(str2, str);
        } catch (Exception unused) {
        }
    }

    @Override // com.ubix.ssp.ad.e.b0.i.b
    public boolean a() {
        if (getState() == 6) {
            com.ubix.ssp.ad.e.b0.i.a.b().b(hashCode());
            return false;
        }
        if (getState() == 4) {
            return this.K && f() && !com.ubix.ssp.ad.e.a0.y.c.a((View) this, 0.3f, false, (List<Integer>) null) && !com.ubix.ssp.ad.e.a0.y.c.a(this);
        }
        return this.K && f() && !com.ubix.ssp.ad.e.a0.y.c.a((View) this, 0.75f, false, (List<Integer>) null) && !com.ubix.ssp.ad.e.a0.y.c.a(this);
    }

    @Override // com.ubix.ssp.ad.e.b0.i.b
    public void b() {
        j();
    }

    @Override // com.ubix.ssp.ad.e.b0.i.b
    public void c() {
        i();
    }

    @Override // com.ubix.ssp.ad.e.b0.e
    public boolean f() {
        return getWindowVisibility() == 0 && isShown();
    }

    @Override // com.ubix.ssp.ad.e.b0.e
    public void h() {
        super.h();
        setOnClickListener(this);
        setOnTouchListener(this);
    }

    @Override // com.ubix.ssp.ad.e.b0.e
    public void m() {
        super.m();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.F) {
            return;
        }
        com.ubix.ssp.ad.e.b0.i.a.b().a(hashCode(), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j jVar = this.B;
        if (jVar != null) {
            jVar.b(0, view, this.H);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.J = 0;
        com.ubix.ssp.ad.e.b0.i.a.b().b(hashCode());
        c();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(motionEvent);
        return false;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8) {
            i();
        }
    }

    public void p() {
        com.ubix.ssp.ad.e.b0.i.a.b().b(hashCode());
        removeAllViews();
        b bVar = this.k;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // com.ubix.ssp.ad.e.b0.e
    public void setAutoPlay(boolean z) {
        super.setAutoPlay(z);
        this.K = z;
    }

    @Override // com.ubix.ssp.ad.e.b0.e
    public void setMute(boolean z) {
        super.setMute(z);
    }
}
