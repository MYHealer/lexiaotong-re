package com.ubix.ssp.ad.i;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.a0.s;
import com.ubix.ssp.ad.g.k.f;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends com.ubix.ssp.ad.b implements View.OnClickListener {
    private boolean l;
    private f m;
    private com.ubix.ssp.ad.i.e.a n;
    private boolean o;
    private AtomicBoolean p;
    public boolean q;

    /* JADX INFO: renamed from: com.ubix.ssp.ad.i.a$a, reason: collision with other inner class name */
    class C1117a implements s.e {
        C1117a() {
        }

        @Override // com.ubix.ssp.ad.e.a0.s.e
        public void a(float f, float f2) {
            try {
                if (!a.this.isShown() || com.ubix.ssp.ad.e.a0.y.c.a(a.this.findViewById(2010003), 0.75f, false, (List<Integer>) null) || com.ubix.ssp.ad.e.a0.y.c.a(a.this)) {
                    return;
                }
                a.this.s();
                ((com.ubix.ssp.ad.b) a.this).f8574a.put("__TRI_VAL__", Base64.encodeToString((f + "").getBytes(), 10));
                ((com.ubix.ssp.ad.b) a.this).f8574a.put("__CLICK_AREA__", "3");
                ((com.ubix.ssp.ad.b) a.this).f8574a.put("__CLICK_TRIGGER__", "3");
                if (a.this.m != null) {
                    a.this.m.b(((com.ubix.ssp.ad.b) a.this).b, a.this.findViewById(2010003), ((com.ubix.ssp.ad.b) a.this).f8574a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.s.e
        public void a(Bundle bundle) {
            try {
                if (!a.this.isShown() || com.ubix.ssp.ad.e.a0.y.c.a(a.this.findViewById(2010003), 0.75f, false, (List<Integer>) null) || com.ubix.ssp.ad.e.a0.y.c.a(a.this)) {
                    return;
                }
                if (bundle.getInt("__SENSOR_INFO_TYPE__") == 1) {
                    ((com.ubix.ssp.ad.b) a.this).f8574a.put("__X_MAX_ACC__", String.format("%.2f", Float.valueOf(bundle.getFloat("__X_MAX_ACC__"))));
                    ((com.ubix.ssp.ad.b) a.this).f8574a.put("__Y_MAX_ACC__", String.format("%.2f", Float.valueOf(bundle.getFloat("__Y_MAX_ACC__"))));
                    ((com.ubix.ssp.ad.b) a.this).f8574a.put("__Z_MAX_ACC__", String.format("%.2f", Float.valueOf(bundle.getFloat("__Z_MAX_ACC__"))));
                    ((com.ubix.ssp.ad.b) a.this).f8574a.put("__TURN_X__", String.format("%.2f", Float.valueOf(bundle.getFloat("__TURN_X__"))));
                    ((com.ubix.ssp.ad.b) a.this).f8574a.put("__TURN_Y__", String.format("%.2f", Float.valueOf(bundle.getFloat("__TURN_Y__"))));
                    ((com.ubix.ssp.ad.b) a.this).f8574a.put("__TURN_Z__", String.format("%.2f", Float.valueOf(bundle.getFloat("__TURN_Z__"))));
                    ((com.ubix.ssp.ad.b) a.this).f8574a.put("__UBIX_TURN_TARGET__", bundle.getInt("__UBIX_TURN_TARGET__") + "");
                    ((com.ubix.ssp.ad.b) a.this).f8574a.put("__TURN_TIME__", bundle.getLong("__TURN_TIME__") + "");
                }
                if (a.this.m != null) {
                    a.this.m.a(((com.ubix.ssp.ad.b) a.this).b, bundle);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.m != null) {
                a.this.m.d(((com.ubix.ssp.ad.b) a.this).b);
            }
            a.this.requestLayout();
            if (a.this.n != null) {
                a.this.n.a(a.this.l());
            }
        }
    }

    public a(Context context) {
        super(context);
        this.p = new AtomicBoolean(false);
        this.q = false;
    }

    @Override // com.ubix.ssp.ad.b
    public void a(int i, int i2, int i3, double d, int i4, int[] iArr, int i5, String str, String str2, int i6, double d2, boolean z, boolean z2) {
        ViewGroup viewGroupA = this.n.a(i);
        if (viewGroupA != null && viewGroupA.findViewById(2030001) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (i == 2) {
                RelativeLayout relativeLayoutA = this.n.a(TextUtils.isEmpty(new StringBuilder().append(str).append(str2).toString()) ? "摇动或点击了解更多" : str + str2, true);
                relativeLayoutA.setVisibility(4);
                if (this.n.getTemplateId() == 2003 || this.n.getTemplateId() == 2004 || this.n.getTemplateId() == 2005) {
                    layoutParams.addRule(13);
                } else {
                    layoutParams.addRule(12);
                }
                relativeLayoutA.setLayoutParams(layoutParams);
                a(viewGroupA, (View) relativeLayoutA, false, i3, true, true, d, iArr, i5, i6, d2, z, z2);
                if (l()) {
                    return;
                }
                relativeLayoutA.setVisibility(0);
                s();
                return;
            }
            if (i == 8) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                layoutParams2.addRule(2, 2030001);
                viewGroupA.addView(this.n.a(TextUtils.isEmpty(new StringBuilder().append(str).append(str2).toString()) ? "滑动或点击了解更多" : str + str2, false), layoutParams);
                viewGroupA.addView(this.n.a(d, i4), layoutParams2);
                return;
            }
            if (i != 256) {
                return;
            }
            if (com.ubix.ssp.ad.d.b.E == 1 && this.o) {
                this.n.b();
            } else {
                this.n.f();
            }
        }
    }

    @Override // com.ubix.ssp.ad.b
    protected void a(Context context, Bundle bundle) {
        this.b = bundle.getInt("AD_INDEX", 0);
        this.o = bundle.getBoolean("isSlided", false);
        bundle.putSerializable("CLICK_MAP", this.f8574a);
        com.ubix.ssp.ad.i.e.a aVarA = com.ubix.ssp.ad.i.e.a.a(context, bundle);
        this.n = aVarA;
        if (aVarA != null) {
            aVarA.b(context, bundle);
            int i = bundle.getInt("AD_WIDTH");
            if (i <= 0) {
                i = -1;
            }
            int i2 = bundle.getInt("AD_HEIGHT");
            if (i2 <= 0) {
                i2 = -1;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i == -1 ? -1.0f : i * r.a().a(context)), (int) (i2 != -1 ? i2 * r.a().a(context) : -1.0f));
            int iA = r.a(bundle.getFloat("AD_MARGIN_LEFT"));
            int iA2 = r.a(bundle.getFloat("AD_MARGIN_TOP"));
            int iA3 = r.a(bundle.getFloat("AD_MARGIN_RIGHT"));
            int iA4 = r.a(bundle.getFloat("AD_MARGIN_BOTTOM"));
            layoutParams.setMargins(iA, iA2, iA3, iA4);
            if (iA + iA2 + iA3 + iA4 > 0) {
                setOnClickListener(this);
            }
            addView(this.n, layoutParams);
        }
    }

    @Override // com.ubix.ssp.ad.b
    public void a(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        super.a(str, str2, str3, str4, str5, str6, j);
        this.n.a(str, str2, str3, str4, str5, str6, j);
    }

    @Override // com.ubix.ssp.ad.b
    public boolean b(Bundle bundle) {
        try {
            this.n.d(bundle);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void d(int i, int i2) {
    }

    @Override // com.ubix.ssp.ad.b
    public com.ubix.ssp.ad.g.k.b getInterface() {
        return null;
    }

    @Override // com.ubix.ssp.ad.b
    public void j() {
        super.j();
        removeAllViews();
        this.n.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.l) {
            this.l = true;
            post(new b());
            f fVar = this.m;
            if (fVar != null) {
                fVar.a(this.b, this);
            }
        }
        setShakeSensor(findViewById(910101));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            this.f8574a.put("__CLICK_AREA__", "1");
            this.f8574a.put("__CLICK_TRIGGER__", "1");
            f fVar = this.m;
            if (fVar != null) {
                fVar.b(this.b, findViewById(2010003), this.f8574a);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s();
        com.ubix.ssp.ad.i.e.a aVar = this.n;
        if (aVar != null) {
            aVar.k();
        }
    }

    @Override // com.ubix.ssp.ad.b, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        com.ubix.ssp.ad.i.e.a aVar = this.n;
        if (aVar != null) {
            if (i == 0) {
                aVar.a(l());
            } else {
                aVar.k();
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            setShakeSensor(findViewById(910101));
        } else {
            s();
        }
    }

    @Override // com.ubix.ssp.ad.b, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            setShakeSensor(findViewById(910101));
        }
    }

    protected void s() {
        if (l() && this.f != null && findViewById(2030001) != null) {
            findViewById(2030001).setVisibility(4);
        }
        s sVar = this.f;
        if (sVar != null) {
            sVar.f();
        }
        AtomicBoolean atomicBoolean = this.p;
        if (atomicBoolean != null) {
            atomicBoolean.set(false);
        }
        s sVar2 = this.f;
        if (sVar2 != null) {
            sVar2.a();
        }
        com.ubix.ssp.ad.i.e.a aVar = this.n;
        if (aVar != null) {
            aVar.k();
        }
    }

    @Override // com.ubix.ssp.ad.b
    public void setInnerListener(com.ubix.ssp.ad.g.k.b bVar) {
        this.m = (f) bVar;
        this.n.setInnerListener(bVar);
    }

    @Override // com.ubix.ssp.ad.b
    protected void setShakeSensor(View view) {
        if (l() && this.f != null) {
            if (findViewById(2030001) != null) {
                findViewById(2030001).setVisibility(4);
            }
            com.ubix.ssp.ad.i.e.a aVar = this.n;
            if (aVar != null) {
                aVar.k();
                return;
            }
            return;
        }
        super.setShakeSensor(view);
        synchronized (this) {
            if (this.f != null && !this.p.get() && !this.q) {
                this.p.set(true);
                this.f.a(new C1117a());
            }
        }
    }
}
