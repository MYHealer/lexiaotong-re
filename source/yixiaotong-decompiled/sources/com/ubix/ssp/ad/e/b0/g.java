package com.ubix.ssp.ad.e.b0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.g.k.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g extends e implements com.ubix.ssp.ad.e.b0.i.b {
    private AtomicBoolean H;
    private AtomicBoolean I;
    private HashMap<String, String> J;
    private boolean K;
    private long L;
    private long M;

    public g(Context context) {
        super(context, 1);
        this.H = new AtomicBoolean(true);
        this.I = new AtomicBoolean(true);
        this.J = new HashMap<>();
        this.K = true;
        this.L = 300L;
        this.M = 0L;
        setAutoPlay(true);
    }

    public g(Context context, int i) {
        super(context, i);
        this.H = new AtomicBoolean(true);
        this.I = new AtomicBoolean(true);
        this.J = new HashMap<>();
        this.K = true;
        this.L = 300L;
        this.M = 0L;
        u.e("user specified type=" + i);
        setAutoPlay(true);
    }

    private void q() {
        if (this.D == null) {
            this.D = new ArrayList<>();
        }
        this.D.add(900102);
        this.D.add(900131);
        this.D.add(900130);
    }

    protected void a(MotionEvent motionEvent) {
        HashMap<String, String> map;
        String str;
        String str2;
        try {
            if (motionEvent.getAction() == 0) {
                this.J.put(com.hihonor.adsdk.base.g.j.e.c.hnadsc, motionEvent.getX() + "");
                this.J.put(com.hihonor.adsdk.base.g.j.e.c.hnadsd, motionEvent.getY() + "");
                this.J.put("__RAW_DOWN_X__", motionEvent.getRawX() + "");
                map = this.J;
                str = motionEvent.getRawY() + "";
                str2 = "__RAW_DOWN_Y__";
            } else {
                if (motionEvent.getAction() != 1) {
                    return;
                }
                this.J.put(com.hihonor.adsdk.base.g.j.e.c.hnadse, motionEvent.getX() + "");
                this.J.put(com.hihonor.adsdk.base.g.j.e.c.hnadsf, motionEvent.getY() + "");
                this.J.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, getWidth() + "");
                this.J.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, getHeight() + "");
                this.J.put("__RAW_UP_X__", motionEvent.getRawX() + "");
                this.J.put("__RAW_UP_Y__", motionEvent.getRawY() + "");
                map = this.J;
                str = motionEvent.getX() + "_" + motionEvent.getY();
                str2 = "__CLICK_XY__";
            }
            map.put(str2, str);
        } catch (Exception unused) {
        }
    }

    public void a(boolean z) {
        this.K = z;
    }

    @Override // com.ubix.ssp.ad.e.b0.i.b
    public boolean a() {
        return hasWindowFocus() && getWindowVisibility() == 0 && !com.ubix.ssp.ad.e.a0.y.c.a(this);
    }

    @Override // com.ubix.ssp.ad.e.b0.i.b
    public void b() {
        j();
    }

    @Override // com.ubix.ssp.ad.e.b0.i.b
    public void c() {
        i();
        if (this.F) {
            com.ubix.ssp.ad.e.b0.i.a.b().b(hashCode());
        }
    }

    @Override // com.ubix.ssp.ad.e.b0.e
    public void h() {
        super.h();
        q();
        setOnClickListener(this);
        setOnTouchListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j jVar = this.B;
        if (jVar != null) {
            jVar.b(0, view, this.J);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(motionEvent);
        return false;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        try {
            if (i == 0) {
                if (this.K) {
                    com.ubix.ssp.ad.e.b0.i.a.b().a(hashCode(), this);
                }
                if (this.H.get() && isShown()) {
                    this.H.set(false);
                    j jVar = this.B;
                    if (jVar != null) {
                        jVar.a(0, this);
                    }
                }
            } else {
                if (this.h != null && 0 != getCurrentPositionWhenPlaying()) {
                    f.a(getContext(), this.h.a(), getCurrentPositionWhenPlaying());
                }
                i();
                if (this.K) {
                    com.ubix.ssp.ad.e.b0.i.a.b().b(hashCode());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        j jVar2 = this.B;
        if (jVar2 != null) {
            jVar2.b(0, i);
        }
    }

    public void p() {
        com.ubix.ssp.ad.e.b0.i.a.b().b(hashCode());
        try {
            b bVar = this.k;
            if (bVar != null) {
                bVar.e();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
