package com.ubix.ssp.ad.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.huawei.hms.ads.ez;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.a0.s;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.g;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends com.ubix.ssp.ad.b implements View.OnClickListener {
    private int A;
    private int B;
    private ValueAnimator C;
    protected HashMap<String, Integer> l;
    private AtomicBoolean m;
    private com.ubix.ssp.ad.g.k.e n;
    private com.ubix.ssp.ad.h.c.b o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private float u;
    private int v;
    private int w;
    private boolean x;
    private Rect y;
    private int z;

    /* JADX INFO: renamed from: com.ubix.ssp.ad.h.a$a, reason: collision with other inner class name */
    class C1115a implements s.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8961a;

        C1115a(View view) {
            this.f8961a = view;
        }

        @Override // com.ubix.ssp.ad.e.a0.s.e
        public void a(float f, float f2) {
            try {
                if (!a.this.isShown() || com.ubix.ssp.ad.e.a0.y.c.a(a.this)) {
                    return;
                }
                ((com.ubix.ssp.ad.b) a.this).f.f();
                ((com.ubix.ssp.ad.b) a.this).f.a();
                ((com.ubix.ssp.ad.b) a.this).f8574a.put("__TRI_VAL__", Base64.encodeToString((f + "").getBytes(), 10));
                ((com.ubix.ssp.ad.b) a.this).f8574a.put("__CLICK_AREA__", "3");
                ((com.ubix.ssp.ad.b) a.this).f8574a.put("__CLICK_TRIGGER__", "3");
                if (a.this.n != null) {
                    a.this.n.b(((com.ubix.ssp.ad.b) a.this).b, this.f8961a, ((com.ubix.ssp.ad.b) a.this).f8574a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.s.e
        public void a(Bundle bundle) {
            try {
                if (!a.this.isShown() || com.ubix.ssp.ad.e.a0.y.c.a(a.this)) {
                    return;
                }
                u.e("onSensorInfo=" + bundle.toString());
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
                if (a.this.n != null) {
                    a.this.n.a(((com.ubix.ssp.ad.b) a.this).b, bundle);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (a.this.B != (Integer.parseInt(valueAnimator.getAnimatedValue() + "") * a.this.A) / 100) {
                a.this.B = (Integer.parseInt(valueAnimator.getAnimatedValue() + "") * a.this.A) / 100;
                View viewFindViewById = a.this.findViewById(400001);
                if (viewFindViewById != null && (viewFindViewById instanceof TextView) && a.this.z == 4) {
                    ((TextView) viewFindViewById).setText("跳过 " + (a.this.B + 1));
                }
            }
            a.this.B = (Integer.parseInt(valueAnimator.getAnimatedValue() + "") * a.this.A) / 100;
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (a.this.n != null) {
                a.this.n.e(0);
            }
            try {
                if (a.this.C != null) {
                    a.this.C.removeAllListeners();
                }
            } catch (Throwable unused) {
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if ((com.ubix.ssp.ad.d.b.E != 1 || !((com.ubix.ssp.ad.b) a.this).d) && ((com.ubix.ssp.ad.b) a.this).f != null) {
                a.this.setShakeSensor(null);
            }
            try {
                View viewFindViewById = a.this.findViewById(400001);
                if (viewFindViewById != null && (viewFindViewById instanceof g)) {
                    ((g) viewFindViewById).d();
                }
                if (a.this.C != null) {
                    a.this.C.resume();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if ((com.ubix.ssp.ad.d.b.E != 1 || !((com.ubix.ssp.ad.b) a.this).d) && ((com.ubix.ssp.ad.b) a.this).f != null) {
                a.this.setShakeSensor(null);
            }
            try {
                View viewFindViewById = a.this.findViewById(400001);
                if (viewFindViewById != null && (viewFindViewById instanceof g)) {
                    ((g) viewFindViewById).d();
                }
                if (a.this.C != null) {
                    a.this.C.resume();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public a(Context context) {
        super(context);
        this.l = new HashMap<>();
        this.m = new AtomicBoolean(false);
        this.r = 4;
        this.t = 0;
        this.u = 0.05f;
        this.v = 5;
        this.w = 5;
        this.x = false;
        this.y = new Rect();
        this.z = 0;
        this.A = 5;
        this.B = 5;
    }

    private boolean a(float f, int i, int i2) {
        return Math.abs((f / ((((float) i) * 1.0f) / ((float) i2))) - 1.0f) <= this.u;
    }

    private Rect d(int i, int i2) {
        Rect rect = new Rect();
        if (i * i2 > 0) {
            int i3 = (int) (this.w * i2 * 0.01f);
            int i4 = (int) (this.v * i * 0.01f);
            rect.left = i4;
            rect.top = i3;
            rect.right = i - i4;
            rect.bottom = i2 - i3;
        }
        return rect;
    }

    private void s() {
        if (this.m.get() || !isShown()) {
            return;
        }
        this.m.set(true);
        com.ubix.ssp.ad.g.k.e eVar = this.n;
        if (eVar != null) {
            eVar.a(0, this);
        }
    }

    private void t() {
        if (this.C != null) {
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(99, 0);
        this.C = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(this.A * 1000);
        this.C.setInterpolator(new LinearInterpolator());
        this.C.addUpdateListener(new b());
        this.C.addListener(new c());
        this.C.start();
    }

    private void u() {
        TextView textView;
        String str;
        try {
            if (this.z != 0) {
                if (this.o.getRealTemplateId() == 6004 || this.o.getRealTemplateId() == 6014) {
                    t();
                    View viewFindViewById = findViewById(400001);
                    if (viewFindViewById == null) {
                        return;
                    }
                    viewFindViewById.setVisibility(0);
                    int i = this.z;
                    if (i == 2) {
                        ((g) viewFindViewById).setDuration(this.A * 1000);
                        ((g) viewFindViewById).e();
                        return;
                    }
                    if (i == 3) {
                        textView = (TextView) viewFindViewById;
                        str = "跳过";
                    } else {
                        if (i != 4) {
                            return;
                        }
                        textView = (TextView) viewFindViewById;
                        str = "跳过 " + this.A;
                    }
                    textView.setText(str);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:47:0x00dd A[PHI: r10 r12 r13
  0x00dd: PHI (r10v11 int) = (r10v5 int), (r10v8 int), (r10v21 int), (r10v24 int) binds: [B:46:0x00db, B:38:0x00b4, B:22:0x007d, B:14:0x0059] A[DONT_GENERATE, DONT_INLINE]
  0x00dd: PHI (r12v15 int) = (r12v2 int), (r12v9 int), (r12v23 int), (r12v29 int) binds: [B:46:0x00db, B:38:0x00b4, B:22:0x007d, B:14:0x0059] A[DONT_GENERATE, DONT_INLINE]
  0x00dd: PHI (r13v8 float) = (r13v3 float), (r13v7 float), (r13v25 float), (r13v27 float) binds: [B:46:0x00db, B:38:0x00b4, B:22:0x007d, B:14:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x00e1 A[PHI: r10 r12 r14
  0x00e1: PHI (r10v18 int) = (r10v5 int), (r10v8 int), (r10v21 int), (r10v24 int) binds: [B:46:0x00db, B:38:0x00b4, B:22:0x007d, B:14:0x0059] A[DONT_GENERATE, DONT_INLINE]
  0x00e1: PHI (r12v21 int) = (r12v2 int), (r12v9 int), (r12v23 int), (r12v29 int) binds: [B:46:0x00db, B:38:0x00b4, B:22:0x007d, B:14:0x0059] A[DONT_GENERATE, DONT_INLINE]
  0x00e1: PHI (r14v7 float) = (r14v2 float), (r14v6 float), (r14v9 float), (r14v11 float) binds: [B:46:0x00db, B:38:0x00b4, B:22:0x007d, B:14:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:50:0x00e6  */
    protected HashMap<String, Integer> a(Context context, int i, int i2, int i3) {
        int iWidth;
        int iHeight;
        float f;
        float f2;
        int i4;
        int i5;
        float f3;
        HashMap<String, Integer> map;
        Integer numValueOf;
        int iIntValue;
        int iIntValue2;
        int i6;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i7 = displayMetrics.heightPixels;
        int i8 = displayMetrics.widthPixels;
        int i9 = i7 - r.i(context);
        double d2 = displayMetrics.density;
        float f4 = i;
        float f5 = i2;
        float f6 = (1.0f * f4) / f5;
        if (i8 > i7) {
            if (i3 != 6004 && i3 != 6014) {
                iHeight = ((i7 / 10) * 9) - r.i(context);
                iWidth = (i3 == 6003 || i3 == 6013) ? (int) (((double) ((iHeight * i) / i2)) / 1.8d) : (iHeight * i) / i2;
                f = f4 / iWidth;
                f2 = f5 / iHeight;
                if (f > f2) {
                    i5 = (int) (f4 / f);
                    f3 = f5 / f;
                } else {
                    i5 = (int) (f4 / f2);
                    f3 = f5 / f2;
                }
            } else if (this.t != 1) {
                iHeight = i7;
                i4 = iHeight;
                i5 = i8;
                iWidth = i5;
            } else if (a(f6, i8, i9)) {
                i5 = i8;
                iWidth = i5;
                iHeight = i9;
                i4 = iHeight;
            } else {
                Rect rectD = d(i8, i7);
                iWidth = rectD.width();
                iHeight = rectD.height();
                f = f4 / iWidth;
                f2 = f5 / iHeight;
                if (f > f2) {
                    i5 = (int) (f4 / f);
                    f3 = f5 / f;
                } else {
                    i5 = (int) (f4 / f2);
                    f3 = f5 / f2;
                }
            }
            i4 = (int) f3;
        } else {
            if (i3 != 6004 && i3 != 6014) {
                iHeight = ((i7 / 10) * 9) - r.i(context);
                iWidth = (i3 == 6003 || i3 == 6013) ? (int) (((double) ((iHeight * i) / i2)) / 1.8d) : (iHeight * i) / i2;
                int i10 = (i8 / 10) * 9;
                if (iWidth > i10) {
                    iWidth = i10;
                }
                f = f4 / iWidth;
                f2 = f5 / iHeight;
                if (f > f2) {
                    i5 = (int) (f4 / f);
                    f3 = f5 / f;
                } else {
                    i5 = (int) (f4 / f2);
                    f3 = f5 / f2;
                }
            } else if (this.t != 1) {
                iHeight = i7;
                i4 = iHeight;
                i5 = i8;
                iWidth = i5;
            } else if (a(f6, i8, i9)) {
                i5 = i8;
                iWidth = i5;
                iHeight = i9;
                i4 = iHeight;
            } else {
                Rect rectD2 = d(i8, i7);
                iWidth = rectD2.width();
                iHeight = rectD2.height();
                f = f4 / iWidth;
                f2 = f5 / iHeight;
                if (f > f2) {
                    i5 = (int) (f4 / f);
                    f3 = f5 / f;
                } else {
                    i5 = (int) (f4 / f2);
                    f3 = f5 / f2;
                }
            }
            i4 = (int) f3;
        }
        int i11 = (int) (((double) i5) - d2);
        int iMin = (int) (((double) i4) - d2);
        this.l.put("screenWidth", Integer.valueOf(i8));
        this.l.put("screenHeight", Integer.valueOf(i7));
        this.l.put("frameWidth", Integer.valueOf(iWidth));
        this.l.put("frameHeight", Integer.valueOf(iHeight));
        this.l.put("instlWidth", Integer.valueOf(i11));
        this.l.put("instlHeight", Integer.valueOf(iMin));
        this.l.put("bitmapWidth", Integer.valueOf(i));
        this.l.put("bitmapHeight", Integer.valueOf(i2));
        this.l.put("drawingWidth", Integer.valueOf(i11));
        if (i8 > i7) {
            map = this.l;
            numValueOf = Integer.valueOf(iHeight);
        } else {
            if (i3 == 6001 || i3 == 6002) {
                map = this.l;
            } else {
                map = this.l;
                if (iMin <= i11) {
                    iMin = (int) (((double) ((int) (((double) Math.min(iHeight, iWidth)) * 1.8d))) - (((double) (i11 - iMin)) * 1.3d));
                }
            }
            numValueOf = Integer.valueOf(iMin);
        }
        map.put("drawingHeight", numValueOf);
        if (i3 == 6004 || i3 == 6014) {
            this.l.put("adLeft", 0);
            this.l.put("adTop", 0);
            this.l.put("adRight", Integer.valueOf(iWidth));
            this.l.put("adBottom", Integer.valueOf(iHeight));
            iIntValue = 0;
            iIntValue2 = iHeight;
            i6 = 0;
        } else {
            i6 = (i8 - i11) / 2;
            this.l.put("adLeft", Integer.valueOf(i6));
            HashMap<String, Integer> map2 = this.l;
            iIntValue = (i9 - map2.get("drawingHeight").intValue()) / 2;
            map2.put("adTop", Integer.valueOf(iIntValue));
            iWidth = (i8 + i11) / 2;
            this.l.put("adRight", Integer.valueOf(iWidth));
            HashMap<String, Integer> map3 = this.l;
            iIntValue2 = (i9 + map3.get("drawingHeight").intValue()) / 2;
            map3.put("adBottom", Integer.valueOf(iIntValue2));
        }
        this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, (iWidth - i6) + "");
        this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, (iIntValue2 - iIntValue) + "");
        this.f8574a.put("__IMP_AREA__", i6 + "_" + iIntValue + "_" + iWidth + "_" + iIntValue2);
        this.f8574a.put("adLeft", i6 + "");
        this.f8574a.put("adRight", iWidth + "");
        this.f8574a.put("adTop", iIntValue + "");
        this.f8574a.put("adBottom", iIntValue2 + "");
        return this.l;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0066  */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    @Override // com.ubix.ssp.ad.b
    public void a(int i, int i2, int i3, double d2, int i4, int[] iArr, int i5, String str, String str2, int i6, double d3, boolean z, boolean z2) {
        com.ubix.ssp.ad.e.c cVar;
        boolean z3;
        boolean z4;
        String str3 = str;
        this.s = i;
        if (i != 128 && i != 132) {
            if (i == 2) {
                a(i, str3, str2, true);
                if (this.o.getRealTemplateId() == 6003 || this.o.getRealTemplateId() == 6013) {
                    a(false, 0, i3, 1, false, false, d2, iArr, i5, i6, d3, z, z2);
                } else {
                    a(false, 0, i3, 0, false, false, d2, iArr, i5, i6, d3, z, z2);
                }
            } else {
                if (i != 3) {
                    if (i == 4) {
                        a(i, str3, str2, true);
                        if (this.o.getRealTemplateId() == 6003 || this.o.getRealTemplateId() == 6013) {
                            z3 = false;
                            z4 = true;
                        } else {
                            z3 = false;
                            z4 = false;
                        }
                    } else if (i != 5) {
                        if (TextUtils.isEmpty(str)) {
                            str3 = "点击此处";
                        }
                        a(i, str3, str2, false);
                        cVar = (com.ubix.ssp.ad.e.c) findViewById(910301);
                        if (cVar == null) {
                            return;
                        }
                    } else {
                        a(i, str3, str2, false);
                        if (this.o.getRealTemplateId() == 6003 || this.o.getRealTemplateId() == 6013) {
                            z3 = false;
                            z4 = true;
                        } else {
                            z3 = false;
                            z4 = false;
                        }
                    }
                    a(z3, z4, d2, i4);
                    return;
                }
                a(i, str3, str2, false);
                if (this.o.getRealTemplateId() == 6003 || this.o.getRealTemplateId() == 6013) {
                    a(false, 0, i3, 1, true, false, d2, iArr, i5, i6, d3, z, z2);
                } else {
                    a(false, 0, i3, 0, false, false, d2, iArr, i5, i6, d3, z, z2);
                }
            }
            return;
        }
        if (this.o.getRealTemplateId() == 6003 || this.o.getRealTemplateId() == 6001 || this.o.getRealTemplateId() == 6002 || this.o.getRealTemplateId() == 6004) {
            a(i, str3, str2, true);
            a(i, d2, i4);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str3 = "点击此处";
        }
        a(i, str3, str2, false);
        cVar = (com.ubix.ssp.ad.e.c) findViewById(910301);
        if (cVar == null) {
            return;
        }
        cVar.setNeedWave(true);
    }

    @Override // com.ubix.ssp.ad.b
    protected void a(int i, String str, String str2, boolean z) {
        View viewFindViewById;
        super.a(i, str, str2, z);
        if (this.o.a(i) && (viewFindViewById = findViewById(910301)) != null) {
            if (z) {
                viewFindViewById.setBackgroundColor(0);
            } else {
                viewFindViewById.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), Color.parseColor("#ccc9c9c9"), 72, -1));
                a(viewFindViewById);
            }
        }
        if (findViewById(400001) != null) {
            findViewById(400001).bringToFront();
        }
    }

    @Override // com.ubix.ssp.ad.b
    protected void a(Context context, Bundle bundle) {
        this.r = (int) (this.r * r.a().a(context));
        this.t = bundle.getInt("RENDER_MODE", 0);
        this.u = bundle.getFloat("SCALE_IGNORE_PERCENT", 0.05f);
        int i = bundle.getInt("SCALE_HORIZONTAL_MARGIN", 5);
        this.v = i;
        if (i >= 50) {
            this.v = 5;
        }
        int i2 = bundle.getInt("SCALE_VERTICAL_MARGIN", 5);
        this.w = i2;
        if (i2 >= 50) {
            this.w = 5;
        }
        int i3 = bundle.getInt("AD_WIDTH");
        this.p = i3;
        int i4 = bundle.getInt("AD_HEIGHT");
        this.q = i4;
        HashMap<String, Integer> mapA = a(context, i3, i4, bundle.getInt("TEMPLATE_ID"));
        this.l = mapA;
        bundle.putSerializable("SIZE_MAP", mapA);
        bundle.putSerializable("CLICK_MAP", this.f8574a);
        this.z = bundle.getInt("SKIP_VIEW_STYLE", 0);
        this.A = bundle.getInt("SKIP_COUNT_TIME", 5);
        this.o = com.ubix.ssp.ad.h.c.b.a(context, bundle);
        if (bundle.getInt("TEMPLATE_ID") != this.o.getRealTemplateId()) {
            HashMap<String, Integer> mapA2 = a(context, bundle.getInt("AD_WIDTH"), bundle.getInt("AD_HEIGHT"), this.o.getRealTemplateId());
            this.l = mapA2;
            this.o.a(mapA2);
        }
        setOnClickListener(this);
        addView(this.o);
    }

    @Override // com.ubix.ssp.ad.b
    protected void a(View view) {
        super.a(view);
        view.setOnClickListener(this);
    }

    @Override // com.ubix.ssp.ad.b
    public void a(String str, String str2) {
        try {
            s sVar = this.f;
            if (sVar != null) {
                sVar.f();
                this.f.a();
            }
            View viewFindViewById = r().findViewById(910104);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
                r().removeView(viewFindViewById);
            }
            View viewFindViewById2 = r().findViewById(910301);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(8);
                r().removeView(viewFindViewById2);
            }
            a(1, 0, 0, 0.0d, 0, new int[0], 0, str, str2, 0, 0.0d, false, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.b
    public void a(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        super.a(str, str2, str3, str4, str5, str6, j);
        this.o.a(str, str2, str3, str4, str5, str6, j);
    }

    protected boolean a(int i, float f, float f2) {
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (i == 128 || i == 132) {
            com.ubix.ssp.ad.e.e eVar = (com.ubix.ssp.ad.e.e) findViewById(910401);
            if (eVar != null) {
                eVar.getGlobalVisibleRect(this.y);
                Rect rect2 = this.y;
                return eVar.a(f - rect2.left, (f2 - rect2.top) + rect.top);
            }
        } else if ((i & 4) == 4) {
            try {
                return new Rect(this.l.get("adLeft").intValue(), this.l.get("adTop").intValue(), this.l.get("adRight").intValue(), this.l.get("adBottom").intValue()).contains((int) f, (int) f2);
            } catch (Exception unused) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ubix.ssp.ad.b
    public boolean b(Bundle bundle) {
        return this.o.a(bundle);
    }

    @Override // com.ubix.ssp.ad.b, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.x = a(this.s, motionEvent.getX(), motionEvent.getY());
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!a(this.s, motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        a(motionEvent);
        this.f8574a.put("__TRI_VAL__", Base64.encodeToString(((Math.round(this.k * 100.0f) / 100.0f) + "").getBytes(), 10));
        this.f8574a.put("__INSIDE_AREA__", this.x + "");
        this.f8574a.put("__CLICK_AREA__", "4");
        this.f8574a.put("__CLICK_TRIGGER__", "4");
        com.ubix.ssp.ad.g.k.e eVar = this.n;
        if (eVar == null) {
            return true;
        }
        eVar.b(this.b, this, this.f8574a);
        return true;
    }

    @Override // com.ubix.ssp.ad.b
    public com.ubix.ssp.ad.g.k.b getInterface() {
        return this.n;
    }

    @Override // com.ubix.ssp.ad.b
    public void j() {
        super.j();
        com.ubix.ssp.ad.h.c.b bVar = this.o;
        if (bVar != null) {
            bVar.a();
        }
        ValueAnimator valueAnimator = this.C;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.C.cancel();
        }
        s sVar = this.f;
        if (sVar != null) {
            sVar.a();
        }
    }

    @Override // com.ubix.ssp.ad.b
    protected boolean n() {
        return (this.s & 4) == 4;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
        u();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HashMap<String, String> map;
        String str;
        this.f8574a.put("__CLICK_TRIGGER__", "");
        if (view.getId() == 910301 || view.getId() == 910401) {
            if (view.getId() == 910401) {
                map = this.f8574a;
                str = this.x + "";
            } else {
                map = this.f8574a;
                str = ez.Code;
            }
            map.put("__INSIDE_AREA__", str);
            this.f8574a.put("__CLICK_AREA__", "2");
            this.f8574a.put("__CLICK_TRIGGER__", "2");
        }
        com.ubix.ssp.ad.g.k.e eVar = this.n;
        if (eVar != null) {
            eVar.b(this.b, view, this.f8574a);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.l = a(getContext(), this.p, this.q, this.o.getRealTemplateId());
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            post(new d());
            return;
        }
        s sVar = this.f;
        if (sVar != null) {
            sVar.f();
            this.f.a();
        }
        try {
            View viewFindViewById = findViewById(400001);
            if (viewFindViewById != null && (viewFindViewById instanceof g)) {
                ((g) viewFindViewById).c();
            }
            ValueAnimator valueAnimator = this.C;
            if (valueAnimator != null) {
                valueAnimator.pause();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.b, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            s();
            post(new e());
            return;
        }
        s sVar = this.f;
        if (sVar != null) {
            sVar.f();
            this.f.a();
        }
        try {
            View viewFindViewById = findViewById(400001);
            if (viewFindViewById != null && (viewFindViewById instanceof g)) {
                ((g) viewFindViewById).c();
            }
            ValueAnimator valueAnimator = this.C;
            if (valueAnimator != null) {
                valueAnimator.pause();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.b
    protected void q() {
        View viewFindViewById = findViewById(400001);
        if (viewFindViewById != null) {
            viewFindViewById.bringToFront();
        }
        View viewFindViewById2 = findViewById(400002);
        if (viewFindViewById2 != null) {
            viewFindViewById2.bringToFront();
        }
        View viewFindViewById3 = findViewById(400003);
        if (viewFindViewById3 != null) {
            viewFindViewById3.bringToFront();
        }
        View viewFindViewById4 = findViewById(920301);
        if (viewFindViewById4 != null) {
            viewFindViewById4.bringToFront();
        }
    }

    @Override // com.ubix.ssp.ad.b
    protected ViewGroup r() {
        return this.o;
    }

    @Override // com.ubix.ssp.ad.b
    public void setInnerListener(com.ubix.ssp.ad.g.k.b bVar) {
        this.n = (com.ubix.ssp.ad.g.k.e) bVar;
        this.o.setInnerListener(bVar);
    }

    @Override // com.ubix.ssp.ad.b
    protected void setShakeSensor(View view) {
        super.setShakeSensor(view);
        if (this.f == null || !isShown()) {
            return;
        }
        this.f.a(new C1115a(view));
    }

    @Override // com.ubix.ssp.ad.b
    public void setShowCloseBtnDelay(int i) {
    }
}
