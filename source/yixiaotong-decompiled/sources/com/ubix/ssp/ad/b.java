package com.ubix.ssp.ad;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ubix.ssp.ad.d.l;
import com.ubix.ssp.ad.e.a0.s;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.h;
import com.ubix.ssp.ad.e.k;
import com.ubix.ssp.ad.e.n;
import com.ubix.ssp.ad.e.o;
import com.ubix.ssp.ad.e.r;
import java.util.HashMap;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class b extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected HashMap<String, String> f8574a;
    protected int b;
    protected boolean c;
    protected boolean d;
    protected boolean e;
    protected s f;
    protected double g;
    protected double h;
    protected int i;
    private ValueAnimator j;
    protected float k;

    class a implements h.c {
        a() {
        }

        @Override // com.ubix.ssp.ad.e.h.c
        public void a() {
            b.this.f8574a.put("__CLICK_TRIGGER__", "8");
            b.this.f8574a.put("__CLICK_AREA__", "8");
            HashMap<String, String> map = b.this.f8574a;
            map.put("__RAW_UP_X__", map.get("__RAW_DOWN_X__"));
            HashMap<String, String> map2 = b.this.f8574a;
            map2.put("__RAW_UP_Y__", map2.get("__RAW_DOWN_Y__"));
            HashMap<String, String> map3 = b.this.f8574a;
            map3.put(com.hihonor.adsdk.base.g.j.e.c.hnadse, map3.get(com.hihonor.adsdk.base.g.j.e.c.hnadsc));
            HashMap<String, String> map4 = b.this.f8574a;
            map4.put(com.hihonor.adsdk.base.g.j.e.c.hnadsf, map4.get(com.hihonor.adsdk.base.g.j.e.c.hnadsd));
            if (b.this.getInterface() != null) {
                com.ubix.ssp.ad.g.k.b bVar = b.this.getInterface();
                b bVar2 = b.this;
                bVar.b(0, bVar2, bVar2.f8574a);
            }
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.b$b, reason: collision with other inner class name */
    class RunnableC1058b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.e.c f8576a;

        RunnableC1058b(com.ubix.ssp.ad.e.c cVar) {
            this.f8576a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f8574a.put("__BUTTON_AREA__", this.f8576a.getLeft() + "_" + this.f8576a.getTop() + "_" + this.f8576a.getRight() + "_" + this.f8576a.getBottom());
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8577a;

        c(View view) {
            this.f8577a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            ImageView imageView;
            try {
                if (this.f8577a.findViewById(910101) instanceof ImageView) {
                    bVar = b.this;
                    imageView = (ImageView) this.f8577a.findViewById(910101);
                } else {
                    bVar = b.this;
                    imageView = null;
                }
                bVar.a(imageView);
            } catch (Exception unused) {
            }
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f8578a;

        d(e eVar) {
            this.f8578a = eVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (Integer.parseInt(valueAnimator.getAnimatedValue() + "") == 0) {
                e eVar = this.f8578a;
                if (eVar != null) {
                    b bVar = b.this;
                    eVar.a(bVar.b, bVar.f8574a);
                }
                b.this.j = null;
            }
        }
    }

    public interface e {
        void a(int i, HashMap<String, String> map);
    }

    public b(Context context) {
        super(context);
        this.f8574a = new HashMap<>();
        this.d = false;
        this.e = false;
        this.g = -1.0d;
        this.h = -1.0d;
        this.i = 5;
        this.k = 0.0f;
    }

    public static b a(Context context, Bundle bundle, int i, boolean z) {
        b bVar = null;
        try {
            Class<? extends b> clsA = a(i, z);
            if (clsA == null) {
                return null;
            }
            b bVarNewInstance = clsA.getConstructor(Context.class).newInstance(context);
            try {
                bVarNewInstance.a(context, bundle);
                return bVarNewInstance;
            } catch (Throwable th) {
                th = th;
                bVar = bVarNewInstance;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        th.printStackTrace();
        return bVar;
    }

    private static Class<? extends b> a(int i, boolean z) {
        if (i == 1) {
            return com.ubix.ssp.ad.j.a.class;
        }
        if (i == 2) {
            return z ? com.ubix.ssp.ad.i.a.class : com.ubix.ssp.ad.f.a.class;
        }
        if (i == 3) {
            return com.ubix.ssp.ad.f.a.class;
        }
        if (i == 4) {
            return com.ubix.ssp.ad.c.a.class;
        }
        if (i == 6) {
            return com.ubix.ssp.ad.h.a.class;
        }
        if (i != 9) {
            return null;
        }
        return com.ubix.ssp.ad.k.a.class;
    }

    private void p() {
        try {
            int iNextInt = new Random().nextInt(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME) + 100;
            int iNextInt2 = new Random().nextInt(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK) + 100;
            int iNextInt3 = new Random().nextInt(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME) + 100;
            int iNextInt4 = new Random().nextInt(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK) + 100;
            this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsc, iNextInt + "");
            this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsd, iNextInt2 + "");
            this.f8574a.put("__RAW_DOWN_X__", iNextInt3 + "");
            this.f8574a.put("__RAW_DOWN_Y__", iNextInt4 + "");
            this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadse, (new Random().nextInt(100) + iNextInt) + "");
            this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsf, (new Random().nextInt(100) + iNextInt2) + "");
            this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, getWidth() + "");
            this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, getHeight() + "");
            this.f8574a.put("__RAW_UP_X__", (iNextInt3 + new Random().nextInt(100)) + "");
            this.f8574a.put("__RAW_UP_Y__", (iNextInt4 + new Random().nextInt(100)) + "");
            this.f8574a.put("__CLICK_XY__", iNextInt + "_" + iNextInt2);
        } catch (Exception unused) {
        }
    }

    protected void a(int i, double d2, int i2) {
        this.i = i2;
        this.g = d2;
        com.ubix.ssp.ad.e.e eVar = new com.ubix.ssp.ad.e.e(getContext());
        eVar.setId(910401);
        r().addView(eVar, r().getChildCount() <= 2 ? 0 : 2);
        q();
        eVar.a(i == 132);
        a(eVar);
    }

    public void a(int i, int i2, int i3, double d2, int i4, int[] iArr, int i5, String str, String str2, int i6, double d3, boolean z, boolean z2) {
    }

    public void a(int i, e eVar) {
        if (this.j != null) {
            return;
        }
        this.f8574a.put("__CLICK_AREA__", "6");
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(99, 0);
        this.j = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(i);
        this.j.setInterpolator(new LinearInterpolator());
        this.j.addUpdateListener(new d(eVar));
        this.j.start();
    }

    protected void a(int i, String str, String str2, double d2, int i2) {
        this.h = d2;
        this.i = i2;
        r rVar = new r(getContext());
        rVar.setId(910501);
        rVar.a(str, str2);
        r().addView(rVar, r().getChildCount() <= 2 ? 0 : 2);
        q();
        rVar.b();
    }

    protected void a(int i, String str, String str2, boolean z) {
        boolean z2;
        try {
            com.ubix.ssp.ad.e.c cVar = new com.ubix.ssp.ad.e.c(getContext(), z);
            cVar.setId(910301);
            String str3 = "点击此处";
            String str4 = !TextUtils.isEmpty(str) ? str : "点击此处";
            if ((i & 2) == 2) {
                if (TextUtils.isEmpty(str)) {
                    str4 = z ? "摇动手机" : "摇动或点击";
                }
                z2 = false;
            } else {
                z2 = true;
            }
            if ((i & 4) == 4) {
                if (TextUtils.isEmpty(str)) {
                    str4 = z ? "向上滑动" : "上滑或点击";
                }
                z2 = false;
            }
            if ((i & 32) == 32) {
                if (TextUtils.isEmpty(str)) {
                    str4 = i == 36 ? "滑动或点击" : "滑动";
                }
                z2 = false;
            }
            if ((i & 128) == 128) {
                if (!TextUtils.isEmpty(str)) {
                    str3 = str4;
                } else if (i == 132) {
                    str3 = "向上滑动或点击";
                }
                str4 = str3;
                z2 = false;
            }
            cVar.setTitle(str4);
            cVar.setSubTitle(str2);
            if (z) {
                cVar.setBackgroundColor(0);
            } else {
                cVar.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), Color.parseColor("#99000000"), 288, -1));
                a(cVar);
            }
            r().addView(cVar);
            cVar.setVisibility(0);
            cVar.setNeedWave(z2);
            post(new RunnableC1058b(cVar));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void a(int i, String str, String str2, boolean z, double d2, int i2) {
        this.g = d2;
        this.i = i2;
        com.ubix.ssp.ad.e.d dVar = new com.ubix.ssp.ad.e.d(getContext(), z);
        boolean z2 = i == 68;
        if (TextUtils.isEmpty(str)) {
            str = z2 ? "向上滑动或点击" : "点击此处";
        }
        dVar.setTitle(str);
        if (!TextUtils.isEmpty(str2)) {
            dVar.setSubTitle(str2);
        }
        dVar.a(z2);
        dVar.setId(910701);
        r().addView(dVar, r().getChildCount() > 2 ? 2 : 0);
        q();
    }

    protected void a(int i, boolean z, double d2, int i2) {
        this.h = d2;
        this.g = d2;
        this.i = i2;
        o oVar = new o(getContext(), z);
        oVar.a();
        oVar.setId(910601);
        r().addView(oVar);
        q();
    }

    protected abstract void a(Context context, Bundle bundle);

    public void a(Bundle bundle) {
    }

    protected void a(MotionEvent motionEvent) {
        HashMap<String, String> map;
        String str;
        String str2;
        try {
            if (motionEvent.getAction() == 0) {
                this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsc, motionEvent.getX() + "");
                this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsd, motionEvent.getY() + "");
                this.f8574a.put("__RAW_DOWN_X__", motionEvent.getRawX() + "");
                map = this.f8574a;
                str = motionEvent.getRawY() + "";
                str2 = "__RAW_DOWN_Y__";
            } else {
                if (motionEvent.getAction() != 1) {
                    return;
                }
                this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadse, motionEvent.getX() + "");
                this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsf, motionEvent.getY() + "");
                this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, getWidth() + "");
                this.f8574a.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, getHeight() + "");
                this.f8574a.put("__RAW_UP_X__", motionEvent.getRawX() + "");
                this.f8574a.put("__RAW_UP_Y__", motionEvent.getRawY() + "");
                map = this.f8574a;
                str = motionEvent.getX() + "_" + motionEvent.getY();
                str2 = "__CLICK_XY__";
            }
            map.put(str2, str);
        } catch (Exception unused) {
        }
    }

    protected void a(View view) {
    }

    protected void a(ViewGroup viewGroup, View view, boolean z, int i, boolean z2, double d2, int[] iArr, int i2, int i3, double d3, boolean z3, boolean z4) {
        a(viewGroup, view, z, i, false, z2, d2, iArr, i2, i3, d3, z3, z4);
    }

    protected void a(ViewGroup viewGroup, View view, boolean z, int i, boolean z2, boolean z3, double d2, int[] iArr, int i2, int i3, double d3, boolean z4, boolean z5) {
        try {
            this.f = i == 1 ? new s(getContext(), d2, iArr, i3, d3, z4, z5) : new s(getContext(), d2, iArr[0], d3);
            if (!z2 && !z) {
                view.setVisibility(0);
            }
            if (viewGroup == null) {
                addView(view);
            } else {
                viewGroup.addView(view);
            }
            postDelayed(new c(view), i2);
            if (z3 || !(view.findViewById(910101) instanceof ImageView)) {
                return;
            }
            this.f.a((ImageView) view.findViewById(910101));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(ImageView imageView) {
        setShakeSensor(imageView);
    }

    public void a(String str, String str2) {
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, long j) {
    }

    protected void a(boolean z, int i, int i2, int i3, boolean z2, boolean z3, double d2, int[] iArr, int i4, int i5, double d3, boolean z4, boolean z5) {
        try {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(910100);
            k kVar = new k(getContext(), i, i3, z2, z3);
            kVar.setId(910104);
            linearLayout.setVisibility(4);
            linearLayout.setGravity(17);
            linearLayout.addView(kVar, new LinearLayout.LayoutParams(z ? 0 : -2, z ? 0 : -2));
            a(r(), linearLayout, z, i2, i != 0, d2, iArr, i4, i5, d3, z4, z5);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void a(boolean z, boolean z2, double d2, int i) {
        try {
            this.i = i;
            this.g = d2;
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setId(910200);
            linearLayout.addView(new n(getContext(), z, z2));
            r().addView(linearLayout);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0074  */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00df, code lost:
    
        if (java.lang.Math.toDegrees(java.lang.Math.atan(java.lang.Math.abs(r2 / r5))) <= r16.i) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0124, code lost:
    
        if (r7 <= r16.i) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0142, code lost:
    
        if (java.lang.Math.toDegrees(java.lang.Math.atan(java.lang.Math.abs(r5 / r2))) <= r16.i) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean a(int i, MotionEvent motionEvent) {
        int i2;
        float f;
        float fH;
        float f2;
        float fC;
        if (motionEvent.getAction() != 1 || ((this.g == -1.0d && this.h == -1.0d) || !n())) {
            return false;
        }
        String str = this.f8574a.get(com.hihonor.adsdk.base.g.j.e.c.hnadsc);
        String str2 = this.f8574a.get(com.hihonor.adsdk.base.g.j.e.c.hnadsd);
        if (TextUtils.isEmpty(str)) {
            i2 = 0;
            f = 0.0f;
            fH = 0.0f;
        } else {
            f = Float.parseFloat(str) - motionEvent.getX();
            fH = f / com.ubix.ssp.ad.e.a0.r.a().h(getContext());
            if (this.h == -1.0d || Math.abs(fH) <= this.h) {
                i2 = 0;
            } else if (f < 0.0f) {
                i2 = 8;
            } else if (f > 0.0f) {
                i2 = 4;
            } else {
                i2 = 0;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            f2 = 0.0f;
            fC = 0.0f;
        } else {
            f2 = Float.parseFloat(str2) - motionEvent.getY();
            fC = f2 / com.ubix.ssp.ad.e.a0.r.a().c(getContext());
            if (this.g != -1.0d && Math.abs(fC) > this.g) {
                if (f2 < 0.0f) {
                    i2 += 2;
                } else if (f2 > 0.0f) {
                    i2++;
                }
            }
        }
        if (i == 16) {
            if (f > 0.0f) {
                if ((i2 & 4) == 4) {
                }
            }
            return false;
        }
        if (i != 32 && i != 33) {
            if (f2 > 0.0f) {
                if ((i2 & 1) == 1) {
                }
            }
            return false;
        }
        double degrees = ((i2 & 4) == 4 || (i2 & 8) == 8) ? Math.toDegrees(Math.atan(Math.abs(f2 / f))) : 360.0d;
        if (degrees > this.i) {
            if ((i2 & 1) == 1 || (i2 & 2) == 2) {
                degrees = Math.toDegrees(Math.atan(Math.abs(f / f2)));
            }
        }
        if (this.g >= 0.0d) {
            fH = fC;
        }
        this.k = fH;
        return true;
    }

    public boolean a(l.a aVar) {
        try {
            ViewGroup viewGroupR = r();
            if (viewGroupR == null) {
                return false;
            }
            h hVar = new h(getContext());
            hVar.setClickable(aVar.f());
            hVar.setMaxStage(3);
            hVar.setDuration(aVar.a());
            if (aVar.h()) {
                hVar.setResource(aVar.c());
            } else {
                if (TextUtils.isEmpty(aVar.e())) {
                    return false;
                }
                hVar.setResource(aVar.e());
            }
            viewGroupR.addView(hVar, new ViewGroup.LayoutParams(-1, -1));
            q();
            hVar.e();
            hVar.setItemClickListener(new a());
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    protected void b(int i, double d2, int i2) {
        a(i, false, d2, i2);
    }

    public abstract boolean b(Bundle bundle);

    public void c(int i, int i2) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public HashMap<String, String> getClickMap() {
        u.b(this.f8574a.toString());
        if (TextUtils.isEmpty(this.f8574a.get(com.hihonor.adsdk.base.g.j.e.c.hnadsc))) {
            p();
        }
        return this.f8574a;
    }

    public abstract com.ubix.ssp.ad.g.k.b getInterface();

    protected View h() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.ubix.ssp.ad.e.a0.r.b(24.0f), com.ubix.ssp.ad.e.a0.r.b(13.0f));
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.setMargins(com.ubix.ssp.ad.e.a0.r.b(10.0f), com.ubix.ssp.ad.e.a0.r.b(23.0f), 0, 0);
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), Integer.MIN_VALUE, 72));
        textView.setTextColor(-1);
        textView.setTextSize(13.0f);
        textView.setText("反馈");
        textView.setId(920301);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    public void i() {
        try {
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.j.cancel();
            }
            this.j = null;
        } catch (Exception unused) {
        }
    }

    public void j() {
    }

    public void k() {
        this.c = true;
    }

    public boolean l() {
        return this.c;
    }

    public boolean m() {
        return this.d;
    }

    protected boolean n() {
        return false;
    }

    public void o() {
        this.c = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.j.pause();
            return;
        }
        ValueAnimator valueAnimator2 = this.j;
        if (valueAnimator2 == null || !valueAnimator2.isPaused()) {
            return;
        }
        this.j.resume();
    }

    protected void q() {
    }

    protected ViewGroup r() {
        return this;
    }

    public abstract <T extends com.ubix.ssp.ad.g.k.b> void setInnerListener(T t);

    protected void setShakeSensor(View view) {
    }

    public void setShakeTrigger(boolean z) {
        this.d = z;
    }

    public void setShowCloseBtnDelay(int i) {
    }

    public void setSlideTrigger(boolean z) {
        this.e = z;
    }
}
