package com.ubix.ssp.ad.i.e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import client.android.yixiaotong.util.doorlock.DoorLockCommandUtil;
import com.kwad.library.solder.lib.ext.PluginError;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.m;
import com.ubix.ssp.ad.e.q;
import com.ubix.ssp.open.AdError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a extends RelativeLayout implements View.OnClickListener {
    protected int A;
    protected int B;
    protected int C;
    protected int D;
    protected int E;
    protected int F;
    protected int G;
    protected int H;
    protected int I;
    protected int J;
    protected int K;
    protected int L;
    protected int M;
    protected com.ubix.ssp.ad.g.k.g N;
    private int O;
    private int P;
    protected double Q;
    protected int R;
    protected boolean S;
    private double T;
    private int U;
    private boolean V;
    private boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, String> f9001a;
    boolean a0;
    private HashMap<String, Drawable> b;
    private int b0;
    RelativeLayout.LayoutParams c;
    private float c0;
    RelativeLayout.LayoutParams d;
    private int d0;
    RelativeLayout.LayoutParams e;
    private int e0;
    RelativeLayout.LayoutParams f;
    protected boolean f0;
    RelativeLayout.LayoutParams g;
    private ObjectAnimator g0;
    RelativeLayout.LayoutParams h;
    private boolean h0;
    RelativeLayout.LayoutParams i;
    private boolean i0;
    RelativeLayout.LayoutParams j;
    private float j0;
    protected RelativeLayout k;
    private float k0;
    protected com.ubix.ssp.ad.e.t.a.e l;
    protected com.ubix.ssp.ad.e.t.a.e[] m;
    protected TextView n;
    protected ImageView o;
    private Path p;
    private Paint q;
    private boolean r;
    private boolean s;
    private boolean t;
    protected float u;
    protected String v;
    protected String w;
    protected String x;
    protected int y;
    protected int z;

    /* JADX INFO: renamed from: com.ubix.ssp.ad.i.e.a$a, reason: collision with other inner class name */
    class RunnableC1121a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f9002a;

        RunnableC1121a(boolean z) {
            this.f9002a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.f9002a) {
                    a.this.n();
                }
                a.this.o();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class b extends com.ubix.ssp.ad.g.k.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.d.f f9003a;

        b(com.ubix.ssp.ad.d.f fVar) {
            this.f9003a = fVar;
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void a(int i, long j, long j2) {
            com.ubix.ssp.ad.g.k.g gVar = a.this.N;
            if (gVar != null) {
                gVar.a(0, j, j2);
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void a(int i, AdError adError) {
            com.ubix.ssp.ad.g.k.g gVar = a.this.N;
            if (gVar != null) {
                gVar.a(i, com.ubix.ssp.ad.e.a0.a0.a.d(2, "加载在线文件失败"));
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g, com.ubix.ssp.ad.g.k.b
        public void b(int i, View view, HashMap<String, String> map) {
            super.b(i, view, map);
            com.ubix.ssp.ad.d.f fVar = this.f9003a;
            if (fVar != null) {
                fVar.b();
            }
            a.this.onClick(view);
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void c(int i) {
            RelativeLayout relativeLayout = (RelativeLayout) a.this.findViewById(2020001);
            if (a.this.k != null && relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            com.ubix.ssp.ad.e.t.a.e eVar = a.this.l;
            if (eVar != null) {
                eVar.setVisibility(0);
            }
            if (a.this.findViewById(200015) != null) {
                a.this.findViewById(200015).setVisibility(4);
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) a.this.findViewById(2010001);
            if (relativeLayout2 != null) {
                relativeLayout2.bringToFront();
            }
            com.ubix.ssp.ad.g.k.g gVar = a.this.N;
            if (gVar != null) {
                gVar.c(i);
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void g(int i) {
            com.ubix.ssp.ad.g.k.g gVar;
            if (!a.this.W || (gVar = a.this.N) == null) {
                return;
            }
            gVar.g(i);
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void h(int i) {
            super.h(i);
            u.a("onVideoPlayStarted");
            a.this.W = true;
            com.ubix.ssp.ad.e.t.a.e eVar = a.this.l;
            if (eVar != null) {
                eVar.setVisibility(4);
            }
            View viewFindViewById = a.this.findViewById(200019);
            if (viewFindViewById != null) {
                viewFindViewById.bringToFront();
            }
            com.ubix.ssp.ad.g.k.g gVar = a.this.N;
            if (gVar != null) {
                gVar.h(i);
            }
        }

        @Override // com.ubix.ssp.ad.g.k.g
        public void j(int i) {
            com.ubix.ssp.ad.g.k.g gVar;
            if (!a.this.W || (gVar = a.this.N) == null) {
                return;
            }
            gVar.j(i);
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f9004a;

        c(ImageView imageView) {
            this.f9004a = imageView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                ImageView imageView = this.f9004a;
                if (imageView == null || !imageView.isShown()) {
                    if (a.this.g0 != null) {
                        a.this.g0.cancel();
                        a.this.g0.removeAllListeners();
                        a.this.g0 = null;
                    }
                    u.a("startShakeAnim shifangle");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            super.onAnimationEnd(animator, z);
            if (a.this.g0 != null) {
                a.this.g0.removeAllListeners();
            }
            a.this.g0 = null;
            a.this.h0 = false;
            ViewGroup viewGroup = (ViewGroup) a.this.findViewById(2040001);
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f9006a;

        e(ImageView imageView) {
            this.f9006a = imageView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ImageView imageView = this.f9006a;
            if (imageView != null && imageView.isShown()) {
                a.this.h0 = true;
                return;
            }
            a.this.h0 = false;
            valueAnimator.cancel();
            if (a.this.g0 != null) {
                a.this.g0.removeAllListeners();
            }
            a.this.g0 = null;
        }
    }

    class f implements Runnable {
        f() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            int iH = r.a().h(a.this.getContext());
            PathMeasure pathMeasure = new PathMeasure(a.this.p, false);
            if (pathMeasure.getLength() > ((double) iH) * a.this.T) {
                a.this.f9001a.put("__TRI_VAL__", Base64.encodeToString(((Math.round((pathMeasure.getLength() / a.this.getWidth()) * 100.0f) / 100.0f) + "").getBytes(), 10));
                a.this.f9001a.put("__CLICK_AREA__", "7");
                a.this.f9001a.put("__CLICK_TRIGGER__", "7");
                a aVar = a.this;
                com.ubix.ssp.ad.g.k.g gVar = aVar.N;
                if (gVar != null) {
                    int i = aVar.P;
                    a aVar2 = a.this;
                    gVar.b(i, aVar2, aVar2.f9001a);
                }
            }
            a.this.p.reset();
            a.this.postInvalidate();
        }
    }

    public a(Context context) {
        super(context);
        this.f9001a = new HashMap<>();
        this.b = new HashMap<>();
        this.c = new RelativeLayout.LayoutParams(-1, -2);
        this.d = new RelativeLayout.LayoutParams(-1, -2);
        this.m = new com.ubix.ssp.ad.e.t.a.e[3];
        this.p = new Path();
        this.q = new Paint();
        this.r = false;
        this.u = 0.0f;
        this.x = "";
        this.Q = 4.0d;
        this.R = 2;
        this.S = false;
        this.T = 0.0d;
        this.U = 5;
        this.V = true;
        this.W = false;
        this.a0 = false;
        this.b0 = 0;
        this.c0 = 0.05f;
        this.d0 = 5;
        this.e0 = 5;
        this.f0 = false;
        this.h0 = false;
        this.i0 = false;
        this.Q = r.a().a(context);
    }

    private View a(ViewGroup viewGroup, int... iArr) {
        View viewA;
        Arrays.sort(iArr);
        if (viewGroup == null) {
            return null;
        }
        viewGroup.setOnClickListener(this);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if ((viewGroup.getChildAt(i) instanceof LinearLayout) || (viewGroup.getChildAt(i) instanceof RelativeLayout)) {
                viewA = a((ViewGroup) viewGroup.getChildAt(i), iArr);
                if (Arrays.binarySearch(iArr, viewA.getId()) < 0 && !(viewGroup.getChildAt(i) instanceof LinearLayout) && !(viewGroup.getChildAt(i) instanceof RelativeLayout)) {
                    viewA.setOnClickListener(this);
                }
            } else if (Arrays.binarySearch(iArr, viewGroup.getChildAt(i).getId()) < 0) {
                viewA = viewGroup.getChildAt(i);
                viewA.setOnClickListener(this);
            }
        }
        return viewGroup;
    }

    public static a a(Context context, Bundle bundle) {
        switch (bundle.getInt("TEMPLATE_ID")) {
            case 2001:
                return new j(context);
            case 2002:
                return new com.ubix.ssp.ad.i.e.b(context);
            case 2003:
                return new g(context);
            case 2004:
                return new h(context);
            case 2005:
                return new i(context);
            case 2006:
                return new com.ubix.ssp.ad.i.e.d(context);
            case 2007:
                return new com.ubix.ssp.ad.i.e.f(context);
            case 2008:
            case 2009:
            case PluginError.ERROR_UPD_PLUGIN_CONNECTION /* 2010 */:
            default:
                return null;
            case 2011:
                return new k(context);
            case 2012:
                return new com.ubix.ssp.ad.i.e.c(context);
            case 2013:
                return new com.ubix.ssp.ad.i.e.e(context);
            case 2014:
                return new l(context);
        }
    }

    private void a(Bundle bundle) {
        this.b0 = bundle.getInt("RENDER_MODE", 0);
        this.c0 = bundle.getFloat("SCALE_IGNORE_PERCENT", 0.05f);
        int i = bundle.getInt("SCALE_HORIZONTAL_MARGIN", 5);
        this.d0 = i;
        if (i >= 50) {
            this.d0 = 5;
        }
        int i2 = bundle.getInt("SCALE_VERTICAL_MARGIN", 5);
        this.e0 = i2;
        if (i2 >= 50) {
            this.e0 = 5;
        }
    }

    private void b(Bundle bundle) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.k = relativeLayout;
        relativeLayout.setId(2010003);
        com.ubix.ssp.ad.e.t.a.e eVar = new com.ubix.ssp.ad.e.t.a.e(getContext());
        this.l = eVar;
        eVar.setId(DoorLockCommandUtil.AUTHFAILCODE);
        TextView textView = new TextView(getContext());
        this.n = textView;
        textView.setId(DoorLockCommandUtil.DELECTUSERIDCODE);
        ImageView imageView = new ImageView(getContext());
        this.o = imageView;
        imageView.setId(2000014);
        this.l.setScaleType(ImageView.ScaleType.FIT_XY);
        this.l.setBackgroundColor(-16777216);
        this.l.setSupportRound(true);
        c(bundle);
        this.n.setMaxLines(2);
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        this.n.setTextSize(TypedValue.applyDimension(0, this.I, getContext().getResources().getDisplayMetrics()));
        this.n.setTextColor(-13619152);
    }

    private boolean c(int i) {
        float f2;
        if (i != 2005) {
            f2 = (i == 2007 || i == 2014) ? 0.5625f : 1.7777778f;
        } else {
            f2 = 1.5f;
        }
        return Math.abs((this.u / f2) - 1.0f) <= this.c0;
    }

    private void m() {
        a(this, 920101);
    }

    public ViewGroup a(int i) {
        if (i == 2) {
            int i2 = this.O;
            if (i2 != 2006 && i2 != 2013 && i2 != 2007 && i2 != 2014 && i2 != 2003 && i2 != 2011 && i2 != 2012 && i2 != 2004 && i2 != 2005) {
                return this.k;
            }
        } else {
            if (i != 8) {
                if (i != 256) {
                    return null;
                }
                return this;
            }
            int i3 = this.O;
            if (i3 != 2006 && i3 != 2007) {
                if (i3 == 2014 || i3 == 2011 || i3 == 2012 || i3 == 2013 || i3 == 2003 || i3 == 2004 || i3 == 2005) {
                    return null;
                }
                return this.k;
            }
        }
        return (ViewGroup) findViewById(2050001);
    }

    public RelativeLayout a(double d2, int i) {
        this.T = d2;
        this.U = i;
        this.S = true;
        setWillNotDraw(false);
        m mVar = new m(getContext());
        this.q.setStrokeWidth(14.0f);
        this.q.setStyle(Paint.Style.STROKE);
        this.q.setColor(-1);
        this.q.setAntiAlias(true);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        relativeLayout.setId(2040001);
        layoutParams.addRule(13);
        ImageView imageView = new ImageView(getContext());
        imageView.setId(200022);
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setId(200023);
        imageView.setImageDrawable(q.a("ubix/ic_slide_arrow.webp"));
        imageView2.setImageDrawable(q.a("ubix/ic_slide_hand.webp"));
        linearLayout.setGravity(3);
        linearLayout.addView(imageView);
        linearLayout.addView(imageView2);
        relativeLayout.addView(mVar, layoutParams);
        return relativeLayout;
    }

    public RelativeLayout a(String str, boolean z) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setId(2030001);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        int i = (int) (this.Q * 4.0d);
        layoutParams2.rightMargin = i;
        layoutParams2.leftMargin = i;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        if (z) {
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setGravity(17);
            ImageView imageView = new ImageView(getContext());
            imageView.setImageDrawable(q.a("ubix/ic_hand_shake.webp"));
            imageView.setId(910101);
            linearLayout.setId(910100);
            int i2 = ((int) this.Q) * 5;
            imageView.setPadding(i2, i2, i2, i2);
            linearLayout2.addView(imageView, layoutParams2);
            linearLayout.addView(linearLayout2, layoutParams2);
            linearLayout2.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), Color.parseColor("#73000000"), 72));
        }
        TextView textView = new TextView(getContext());
        textView.setId(200021);
        int i3 = this.O;
        if (i3 != 2003 && i3 != 2004 && i3 != 2005) {
            textView.setText(str);
        }
        textView.setTextColor(-1);
        textView.getPaint().setFakeBoldText(true);
        textView.setShadowLayer(3.0f, 0.0f, 1.0f, 1711276032);
        linearLayout.addView(textView);
        int i4 = (int) this.Q;
        linearLayout.setPadding(i4, i4, i4, i4);
        layoutParams.addRule(13);
        relativeLayout.addView(linearLayout, layoutParams);
        relativeLayout.setBackground(com.ubix.ssp.ad.e.a0.c.a(0, -872415232, 8));
        return relativeLayout;
    }

    public void a() {
        HashMap<String, Drawable> map = this.b;
        if (map != null) {
            map.clear();
        }
    }

    protected void a(String str) {
        a(str, this.l);
    }

    protected void a(String str, ImageView imageView) {
        com.ubix.ssp.ad.e.v.a aVarB = com.ubix.ssp.ad.e.v.e.b();
        aVarB.b(str, imageView);
        aVarB.c(str);
        Bitmap bitmapB = aVarB.b(str);
        if (bitmapB == null || bitmapB.getHeight() * bitmapB.getWidth() == 0) {
            this.u = 0.0f;
        } else {
            this.u = bitmapB.getWidth() / bitmapB.getHeight();
        }
        b(str, imageView);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        boolean z;
        String strA;
        try {
            TextView textView = (TextView) findViewById(920101);
            if (textView == null) {
                return;
            }
            if (j > 0) {
                strA = com.ubix.ssp.ad.e.a0.k.a(j);
                z = true;
            } else {
                z = false;
                strA = "";
            }
            Object[] objArr = new Object[6];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = str3;
            objArr[3] = TextUtils.isEmpty(str5) ? "" : "丨备案号:" + str5;
            objArr[4] = TextUtils.isEmpty(str6) ? "" : "丨适用年龄:" + str6;
            objArr[5] = z ? "丨应用大小:" + strA : "";
            textView.setText(new com.ubix.ssp.ad.e.f(String.format("应用名称:%s丨应用版本:%s丨开发者:%s%s%s%s丨权限丨隐私丨功能介绍", objArr)).a(this.N));
        } catch (Exception unused) {
        }
    }

    public void a(boolean z) {
        u.e("addAnimation  " + z);
        post(new RunnableC1121a(z));
    }

    protected void a(String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] != null) {
                com.ubix.ssp.ad.e.v.e.b().b(strArr[i], this.m[i]);
                b(strArr[i], this.m[i]);
            }
        }
    }

    protected abstract void a(String[] strArr, String[] strArr2);

    protected RelativeLayout b(boolean z) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setId(2010001);
        TextView textView = new TextView(getContext());
        textView.setId(DoorLockCommandUtil.B80FAILCODE);
        ImageView imageView = new ImageView(getContext());
        imageView.setId(DoorLockCommandUtil.B4FAILCODE);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(r.b(11.0f), r.b(11.0f));
        layoutParams2.addRule(9);
        layoutParams2.addRule(15);
        layoutParams.addRule(1, DoorLockCommandUtil.B80FAILCODE);
        layoutParams.addRule(15);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams.setMargins(0, r.b(2.0f), 0, 0);
        textView.setGravity(16);
        textView.setTextColor(-8158333);
        relativeLayout.addView(textView, layoutParams2);
        relativeLayout.addView(imageView, layoutParams);
        if (z) {
            relativeLayout.addView(this.o, layoutParams3);
            this.o.setImageDrawable(q.a("ubix/ic_close.webp"));
        }
        return relativeLayout;
    }

    public void b() {
        this.S = false;
        this.a0 = false;
    }

    protected void b(int i) {
        double dA = r.a().a(getContext());
        float f2 = StubApp.getOrigApplicationContext(getContext().getApplicationContext()).getResources().getConfiguration().fontScale;
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        double dSqrt = Math.sqrt(Math.exp(dA));
        int i2 = i / 22;
        this.G = i2;
        this.H = i2;
        double d2 = i;
        double d3 = 0.4d * d2;
        int i3 = (int) d3;
        this.y = i3;
        this.z = (i3 * 9) / 16;
        int i4 = (int) (d2 / 3.1d);
        this.A = i4;
        this.B = (i4 * 2) / 3;
        this.D = Math.min(3, i / 300);
        this.C = Math.min(12, i / 70);
        double d4 = (d2 / dSqrt) / ((double) f2);
        this.I = Math.min((int) (d4 / 13.0d), (int) (16.0f / f2));
        int i5 = (int) (d4 / 16.0d);
        int i6 = (int) (14.0f / f2);
        this.J = Math.min(i5, i6);
        this.K = Math.min(i5, i6);
        this.L = Math.min((int) (d4 / 18.0d), (int) (12.0f / f2));
        this.M = Math.min((int) (d4 / 12.0d), i6);
        TextView textView = (TextView) findViewById(2000016);
        if (textView != null) {
            textView.setTextSize(this.I);
        }
        TextView textView2 = (TextView) findViewById(200021);
        if (textView2 != null) {
            textView2.setTextSize(this.M);
        }
        ImageView imageView = (ImageView) findViewById(DoorLockCommandUtil.B4FAILCODE);
        if (imageView != null && imageView.getLayoutParams() != null) {
            imageView.getLayoutParams().width = (i / 3) / 5;
            imageView.getLayoutParams().height = (i / 6) / 5;
        }
        TextView textView3 = (TextView) findViewById(DoorLockCommandUtil.B80FAILCODE);
        if (textView3 != null) {
            textView3.setTextSize(TypedValue.applyDimension(0, Math.max(2, this.L - 4), getContext().getResources().getDisplayMetrics()));
        }
        TextView textView4 = (TextView) findViewById(DoorLockCommandUtil.DELECTUSERIDCODE);
        if (textView4 != null) {
            textView4.setTextSize(TypedValue.applyDimension(0, this.I, getContext().getResources().getDisplayMetrics()));
        }
        ImageView imageView2 = (ImageView) findViewById(2000017);
        if (imageView2 != null && imageView2.getLayoutParams() != null) {
            int i7 = i / 8;
            imageView2.getLayoutParams().width = i7;
            imageView2.getLayoutParams().height = i7;
        }
        ImageView imageView3 = (ImageView) findViewById(910101);
        if (imageView3 != null && imageView3.getLayoutParams() != null) {
            int iMax = (int) Math.max(dSqrt * 18.0d, getMeasuredWidth() / 12);
            imageView3.getLayoutParams().width = iMax;
            imageView3.getLayoutParams().height = iMax;
            ViewGroup viewGroup = (ViewGroup) imageView3.getParent();
            if (viewGroup != null) {
                viewGroup.getLayoutParams().width = iMax;
                viewGroup.getLayoutParams().height = iMax;
            }
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2030001);
        if (relativeLayout != null && relativeLayout.getLayoutParams() != null) {
            relativeLayout.getLayoutParams().height = Math.max(i / 8, 98);
        }
        ImageView imageView4 = (ImageView) findViewById(200022);
        if (imageView4 != null && imageView4.getLayoutParams() != null) {
            imageView4.getLayoutParams().width = i3;
            imageView4.getLayoutParams().height = (int) (d3 / 4.5d);
        }
        ImageView imageView5 = (ImageView) findViewById(200023);
        if (imageView5 != null && imageView5.getLayoutParams() != null) {
            int i8 = i / 8;
            imageView5.getLayoutParams().width = i8;
            imageView5.getLayoutParams().height = i8;
        }
        if (i() && findViewById(2010002) != null) {
            TextView textView5 = (TextView) findViewById(920101);
            RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(2010002);
            if (relativeLayout2 != null) {
                ViewGroup.LayoutParams layoutParams = relativeLayout2.getLayoutParams();
                if (textView5 != null) {
                    layoutParams.height = (textView5.getLineCount() * textView5.getLineHeight()) + r.b(4.0f);
                } else {
                    layoutParams.height = (int) (TypedValue.applyDimension(0, this.L, getContext().getResources().getDisplayMetrics()) * 12.0f);
                }
            }
        }
        l();
    }

    public void b(Context context, Bundle bundle) {
        r.a().a(context);
        this.P = bundle.getInt("AD_INDEX");
        this.w = bundle.getString("TITLE");
        this.E = bundle.getInt("AD_WIDTH");
        this.v = bundle.getString("AD_SOURCE");
        this.F = bundle.getInt("AD_HEIGHT");
        this.r = bundle.getBoolean("IS_DOWNLOAD", false);
        this.f9001a = (HashMap) bundle.getSerializable("CLICK_MAP");
        this.x = bundle.getString("BUTTON_TEXT", this.r ? "立即下载" : "查看详情");
        this.O = bundle.getInt("TEMPLATE_ID");
        this.f0 = bundle.getBoolean("IS_UNNAMED");
        this.R = bundle.getInt("AUTO_PLAY", 2);
        this.s = true;
        this.E = r.a().h(context);
        this.t = true;
        b(bundle);
    }

    protected void b(String... strArr) {
        com.ubix.ssp.ad.d.f fVar = (com.ubix.ssp.ad.d.f) findViewById(2060001);
        if (fVar == null) {
            return;
        }
        fVar.a(strArr[0], new b(fVar));
    }

    protected boolean b(String str, ImageView imageView) {
        try {
            int i = this.b0;
            if (i == 1) {
                com.ubix.ssp.ad.e.v.a aVarB = com.ubix.ssp.ad.e.v.e.b();
                aVarB.c(str);
                Bitmap bitmapB = aVarB.b(str);
                if (bitmapB != null) {
                    if (bitmapB.getHeight() != 0) {
                        this.u = (bitmapB.getWidth() * 1.0f) / bitmapB.getHeight();
                    }
                    if (!c(getTemplateId())) {
                        Bitmap bitmapB2 = com.ubix.ssp.ad.e.a0.c.b(str);
                        if (bitmapB2 != null) {
                            ((com.ubix.ssp.ad.e.t.a.e) imageView).setSupportRound(false);
                            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            imageView.setBackground(new com.ubix.ssp.ad.e.a0.q(getContext(), bitmapB2, imageView.getMeasuredWidth(), imageView.getMeasuredHeight(), 10.0f));
                        } else if (bitmapB2 != null) {
                            bitmapB2.recycle();
                        }
                    }
                }
            } else if (i == 2) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    protected RelativeLayout c() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setId(2010002);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.setMargins(r.b(2.0f), 0, r.b(2.0f), 0);
        relativeLayout.addView(com.ubix.ssp.ad.e.f.a(getContext()), layoutParams);
        relativeLayout.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), -986379, 10));
        TextView textView = (TextView) relativeLayout.findViewById(920101);
        textView.setTextColor(-8158333);
        textView.setMaxLines(5);
        textView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        return relativeLayout;
    }

    protected abstract void c(Bundle bundle);

    protected RelativeLayout d() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setId(2010002);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.setMargins(0, 0, 0, 0);
        relativeLayout.addView(com.ubix.ssp.ad.e.f.a(getContext()), layoutParams);
        return relativeLayout;
    }

    public void d(Bundle bundle) {
        TextView textView;
        if (bundle == null) {
            return;
        }
        a(bundle);
        ImageView imageView = (ImageView) findViewById(DoorLockCommandUtil.B4FAILCODE);
        boolean z = bundle.getBoolean("IS_UNNAMED");
        this.f0 = z;
        if (imageView != null) {
            imageView.setImageDrawable(q.a("ubix/ic_logo_dark.webp", z));
        }
        TextView textView2 = (TextView) findViewById(DoorLockCommandUtil.B80FAILCODE);
        if (!TextUtils.isEmpty(this.v) && textView2 != null) {
            textView2.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
            textView2.setText(this.v);
            if (imageView != null) {
                ((ViewGroup.MarginLayoutParams) imageView.getLayoutParams()).leftMargin = r.b(2.0f);
            }
        }
        if (!TextUtils.isEmpty(this.w) && (textView = this.n) != null) {
            textView.setText(this.w);
        }
        a(bundle.getStringArray("IMAGE_URL"), bundle.getStringArray("VIDEO_URL"));
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.S) {
            canvas.drawPath(this.p, this.q);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0048  */
    /* JADX WARN: Code duplicated, block: B:38:0x0098  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c8  */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.S) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.j0 = motionEvent.getX();
            this.k0 = motionEvent.getY();
            this.i0 = false;
            View viewFindViewById = findViewById(2000014);
            Rect rect = new Rect();
            if (viewFindViewById != null) {
                viewFindViewById.getGlobalVisibleRect(rect);
            }
            if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                this.i0 = true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        if (action == 1) {
            if (this.i0 && this.a0) {
                if (Math.abs(this.j0 - motionEvent.getX()) >= this.Q || Math.abs(this.k0 - motionEvent.getY()) >= this.Q) {
                    this.f9001a.put("__CLICK_AREA__", "12");
                    this.f9001a.put("__CLICK_TRIGGER__", "12");
                    if (com.ubix.ssp.ad.d.b.E == 1) {
                        b();
                    }
                    com.ubix.ssp.ad.g.k.g gVar = this.N;
                    if (gVar != null) {
                        gVar.b(this.P, this, this.f9001a);
                    }
                    return true;
                }
            } else if (!this.p.isEmpty()) {
                motionEvent.getX();
                motionEvent.getY();
                if (new PathMeasure(this.p, false).getLength() > ((double) getWidth()) * 0.001d) {
                    postDelayed(new f(), 100L);
                    return true;
                }
                this.p.reset();
                invalidate();
            }
        } else if (action != 2) {
            if (action == 3) {
                if (this.i0) {
                    if (!this.p.isEmpty()) {
                        motionEvent.getX();
                        motionEvent.getY();
                        if (new PathMeasure(this.p, false).getLength() > ((double) getWidth()) * 0.001d) {
                            postDelayed(new f(), 100L);
                            return true;
                        }
                        this.p.reset();
                        invalidate();
                    }
                } else if (!this.p.isEmpty()) {
                    motionEvent.getX();
                    motionEvent.getY();
                    if (new PathMeasure(this.p, false).getLength() > ((double) getWidth()) * 0.001d) {
                        postDelayed(new f(), 100L);
                        return true;
                    }
                    this.p.reset();
                    invalidate();
                }
            }
        } else if (!this.a0) {
            if (this.p.isEmpty()) {
                this.p.moveTo(motionEvent.getX(), motionEvent.getY());
            }
            this.p.lineTo(motionEvent.getX(), motionEvent.getY());
            invalidate();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected RelativeLayout e() {
        return b(true);
    }

    public void f() {
        this.S = true;
        this.a0 = true;
    }

    protected RelativeLayout g() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setId(2050001);
        return relativeLayout;
    }

    public int getAdHeight() {
        return this.F;
    }

    public int getAdWidth() {
        return this.E;
    }

    public int getTemplateId() {
        return this.O;
    }

    protected RelativeLayout h() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setId(2020001);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(getContext());
        textView.setId(2000016);
        textView.setGravity(17);
        textView.setTextSize(this.I);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(-1);
        textView.setText(this.x);
        int i = (int) (this.Q * 6.0d);
        textView.setPadding(i, i, i, i);
        textView.setBackgroundColor(-12542209);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        relativeLayout.setBackgroundColor(Color.parseColor("#99000000"));
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    protected boolean i() {
        return this.r;
    }

    protected void j() {
        try {
            u.e("removeAnim");
            ObjectAnimator objectAnimator = this.g0;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.g0.removeAllListeners();
                this.g0 = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void k() {
        j();
    }

    protected abstract void l();

    protected Animation n() {
        ImageView imageView = (ImageView) findViewById(910101);
        if (imageView == null || imageView.getWidth() == 0 || this.g0 != null) {
            return null;
        }
        imageView.setPivotX(imageView.getWidth());
        imageView.setPivotY(imageView.getWidth());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, Key.ROTATION, 0.0f, 2.0f, -6.0f, 6.0f, -6.0f, 3.0f, 0.0f);
        this.g0 = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setStartDelay(500L);
        this.g0.setDuration(1800L);
        this.g0.setInterpolator(new AccelerateDecelerateInterpolator());
        this.g0.setRepeatCount(-1);
        this.g0.start();
        this.g0.addUpdateListener(new c(imageView));
        return null;
    }

    protected Animation o() {
        ImageView imageView = (ImageView) findViewById(200023);
        ImageView imageView2 = (ImageView) findViewById(200022);
        if (imageView != null && imageView2 != null && imageView2.getRight() != 0 && imageView.getRight() != 0 && this.g0 == null && !this.h0) {
            ViewGroup viewGroup = (ViewGroup) findViewById(2040001);
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            imageView.setTranslationX(0.0f);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "translationX", imageView2.getRight() - imageView.getRight());
            this.g0 = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setStartDelay(500L);
            this.g0.setDuration(1200L);
            this.g0.setInterpolator(new AccelerateDecelerateInterpolator());
            this.g0.setRepeatCount(2);
            this.g0.start();
            ArrayList listeners = this.g0.getListeners();
            if (listeners == null || listeners.size() == 0) {
                this.g0.addListener(new d());
                this.g0.addUpdateListener(new e(imageView));
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h0 = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == 2000014) {
            com.ubix.ssp.ad.g.k.g gVar = this.N;
            if (gVar != null) {
                gVar.e(this.P);
                return;
            }
            return;
        }
        this.f9001a.put("__CLICK_AREA__", "1");
        this.f9001a.put("__CLICK_TRIGGER__", "1");
        com.ubix.ssp.ad.g.k.g gVar2 = this.N;
        if (gVar2 != null) {
            gVar2.b(this.P, view, this.f9001a);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.s) {
            this.E = View.MeasureSpec.getSize(i);
        }
        if (this.t) {
            this.F = 0;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredHeight = this.F + childAt.getMeasuredHeight();
                this.F = measuredHeight;
                int i4 = measuredHeight + marginLayoutParams.topMargin;
                this.F = i4;
                this.F = i4 + marginLayoutParams.bottomMargin;
            }
        }
        setMeasuredDimension(this.E, this.F);
        b(this.E);
    }

    public void setInnerListener(com.ubix.ssp.ad.g.k.b bVar) {
        this.N = (com.ubix.ssp.ad.g.k.g) bVar;
    }

    protected void setMuted(boolean z) {
    }
}
