package com.ubix.ssp.ad.e.z;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ubix.ssp.ad.e.a0.k;
import com.ubix.ssp.ad.e.a0.l;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.q;
import com.ubix.ssp.open.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends h implements View.OnClickListener {
    int A;
    int B;
    private ImageView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private int m;
    Matrix n;
    float o;
    float p;
    long q;
    HandlerThread r;
    private Handler s;
    Bitmap t;
    private int u;
    boolean v;
    int w;
    float x;
    boolean y;
    private boolean z;

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.z.a$a, reason: collision with other inner class name */
    class C1112a implements com.ubix.ssp.ad.e.v.e.b {
        C1112a() {
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(com.ubix.ssp.ad.e.v.e eVar, String str, String str2, boolean z) {
            u.b("onResourcesLoaded");
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(AdError adError) {
            u.b("onResourcesLoadFailed");
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.z) {
                    return;
                }
                a aVar = a.this;
                if (aVar.w == -99) {
                    aVar.w = 3;
                }
                if (aVar.w <= 0) {
                    aVar.s.postDelayed(this, 1500L);
                    a.this.w = -99;
                    return;
                }
                if (aVar.findViewById(10004) != null) {
                    a aVar2 = a.this;
                    if (aVar2.A * aVar2.B <= 0) {
                        aVar2.A = (aVar2.findViewById(10004).getRight() / 3) * 2;
                        a aVar3 = a.this;
                        aVar3.B = aVar3.findViewById(10004).getBottom() - ((a.this.findViewById(10004).getBottom() - a.this.findViewById(10004).getTop()) / 2);
                    }
                }
                a.this.postInvalidate();
                a.this.s.postDelayed(this, a.this.u);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public a(Context context) {
        super(context);
        this.n = new Matrix();
        this.o = 2.5f;
        this.p = 50.0f;
        this.r = new HandlerThread("ConfirmViewDraw");
        this.u = 16;
        this.v = false;
        this.w = 3;
        this.x = 0.2f;
        this.z = false;
        this.m = (int) (((double) Math.min(r.a().h(context), r.a().c(context))) * 0.8d);
        this.h = new ImageView(getContext());
        this.l = new ImageView(getContext());
        this.i = new TextView(getContext());
        this.j = new TextView(getContext());
        this.k = new TextView(getContext());
        this.h.setId(10001);
        this.l.setId(10005);
        this.i.setId(10002);
        this.j.setId(10003);
        this.k.setId(10004);
        this.k.setTextColor(-1);
        this.k.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), -12542209, 6));
        setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), -1, 6));
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        d();
    }

    private void d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((double) this.m) * 0.8d), -2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (((double) this.m) * 0.8d), -2);
        int i = this.m;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((i / 3) * 2, i / 8);
        this.k.setZ(4.0f);
        addView(this.h);
        addView(this.i, layoutParams);
        addView(this.j, layoutParams2);
        addView(this.k, layoutParams3);
        addView(this.l);
        addView(b(), new ViewGroup.LayoutParams((int) (((double) this.m) * 0.9d), -2));
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        setOnClickListener(this);
    }

    private void e() {
        try {
            if (this.y) {
                this.z = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void f() {
        HandlerThread handlerThread = this.r;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.s = null;
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void a(Dialog dialog, h.c cVar, h.b bVar) {
        this.d = dialog;
        this.e = cVar;
        this.f = bVar;
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void a(l lVar, h.c cVar, h.b bVar) {
        this.c = lVar;
        this.e = cVar;
        this.f = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float f;
        super.dispatchDraw(canvas);
        try {
            Matrix matrix = this.n;
            float f2 = this.o + this.x;
            matrix.setScale(f2, f2);
            if (this.v) {
                this.x += 0.02f;
                float f3 = this.p;
                if (f3 >= 50.0f) {
                    this.p = 50.0f;
                    this.v = false;
                    this.w--;
                } else {
                    if (f3 >= 40.0f) {
                        f = f3 + 2.0f;
                    } else {
                        f = f3 >= 30.0f ? f3 + 2.5f : f3 + 3.0f;
                    }
                    this.p = f;
                }
            } else {
                this.x -= 0.02f;
                float f4 = this.p;
                if (f4 <= 0.0f) {
                    this.p = 0.0f;
                    this.v = true;
                } else {
                    if (f4 <= 10.0f) {
                        f = f4 - 2.0f;
                    } else {
                        f = f4 <= 20.0f ? f4 - 2.5f : f4 - 3.0f;
                    }
                    this.p = f;
                }
            }
            Matrix matrix2 = this.n;
            float f5 = this.A;
            float f6 = this.p;
            matrix2.postTranslate(f5 + f6, this.B + f6);
            if (this.w > 0) {
                canvas.drawBitmap(this.t, this.n, null);
            } else {
                canvas.drawColor(0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void g() {
        this.t = q.a(getContext(), "ubix/ic_slide_hand.webp");
        setWillNotDraw(false);
        this.q = System.currentTimeMillis();
        b bVar = new b();
        this.r.start();
        Handler handler = new Handler(this.r.getLooper());
        this.s = handler;
        handler.postDelayed(bVar, this.u);
        if (findViewById(10004) != null) {
            this.A = (findViewById(10004).getRight() / 3) * 2;
            this.B = findViewById(10004).getBottom() - ((findViewById(10004).getBottom() - findViewById(10004).getTop()) / 2);
        }
    }

    public int getContentHeight() {
        return this.m;
    }

    public int getContentWidth() {
        return this.m;
    }

    @Override // com.ubix.ssp.ad.e.z.h
    protected int getPopupType() {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0061 A[PHI: r3
  0x0061: PHI (r3v10 com.ubix.ssp.ad.e.z.h$c) = (r3v5 com.ubix.ssp.ad.e.z.h$c), (r3v14 com.ubix.ssp.ad.e.z.h$c) binds: [B:37:0x005f, B:21:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.c cVar;
        int id = view.getId();
        if (id == 10004) {
            l lVar = this.c;
            if (lVar != null && lVar.b()) {
                this.c.a();
            }
            Dialog dialog = this.d;
            if (dialog != null && dialog.isShowing()) {
                this.d.dismiss();
            }
            h.c cVar2 = this.e;
            if (cVar2 != null) {
                cVar2.a(null, null);
            }
            cVar = this.e;
            if (cVar != null) {
                cVar.b(null);
            }
        } else {
            if (id != 10005) {
                return;
            }
            l lVar2 = this.c;
            if (lVar2 != null && lVar2.b()) {
                this.c.a();
            }
            Dialog dialog2 = this.d;
            if (dialog2 != null && dialog2.isShowing()) {
                this.d.dismiss();
            }
            h.c cVar3 = this.e;
            if (cVar3 != null) {
                cVar3.a(null);
            }
            cVar = this.e;
            if (cVar != null) {
                cVar.b(null);
            }
        }
        e();
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        f();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            int i11 = this.m / 5;
            int id = childAt.getId();
            if (id != 920101) {
                switch (id) {
                    case 10001:
                        int i12 = this.m;
                        int i13 = i12 / 8;
                        childAt.layout((i12 - i11) / 2, i13, (i12 + i11) / 2, i11 + i13);
                        continue;
                    case 10002:
                        i5 = (int) (((double) this.m) * 0.1d);
                        int bottom = findViewById(10001).getBottom();
                        int i14 = this.m;
                        i6 = bottom + (i14 / 14);
                        i7 = (int) (((double) i14) * 0.9d);
                        int bottom2 = findViewById(10001).getBottom();
                        int i15 = this.m;
                        i8 = bottom2 + (i15 / 14);
                        i9 = i15 / 10;
                        break;
                    case 10003:
                        i5 = (int) (((double) this.m) * 0.1d);
                        int bottom3 = findViewById(10002).getBottom();
                        int i16 = this.m;
                        i6 = bottom3 + (i16 / 36);
                        i7 = (int) (((double) i16) * 0.9d);
                        int bottom4 = findViewById(10002).getBottom();
                        int i17 = this.m;
                        i8 = bottom4 + (i17 / 36);
                        i9 = i17 / 4;
                        break;
                    case 10004:
                        int i18 = this.m;
                        i5 = (i18 - ((i18 * 2) / 3)) / 2;
                        int bottom5 = findViewById(10003).getBottom();
                        int i19 = this.m;
                        i6 = bottom5 + (i19 / 20);
                        i7 = (i19 + ((i19 * 2) / 3)) / 2;
                        int bottom6 = findViewById(10003).getBottom();
                        int i20 = this.m;
                        i8 = bottom6 + (i20 / 20);
                        i9 = i20 / 8;
                        break;
                    case 10005:
                        int i21 = this.m;
                        int i22 = i21 / 22;
                        int i23 = i21 - i22;
                        int i24 = i21 / 10;
                        childAt.layout(i23 - i24, i22, i23, i24 + i22);
                        continue;
                    default:
                        continue;
                }
                childAt.layout(i5, i6, i7, i8 + i9);
            } else {
                double d = this.m;
                int i25 = (int) (0.05d * d);
                double measuredHeight = ((int) (d * 1.1d)) - childAt.getMeasuredHeight();
                double d2 = this.b * 4.0d;
                double d3 = this.m;
                childAt.layout(i25, (int) (measuredHeight - d2), (int) (0.95d * d3), (int) ((d3 * 1.1d) - d2));
                childAt.getLayoutParams().height = childAt.getMeasuredHeight();
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.m;
        setMeasuredDimension(i3, (int) (((double) i3) * 1.1d));
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void setData(Bundle bundle) {
        boolean z;
        String str;
        String str2;
        String strA;
        boolean z2;
        boolean z3 = bundle.getBoolean("IS_DOWNLOAD", false);
        String string = bundle.getString("ICON_URL");
        String string2 = bundle.getString("TITLE");
        String string3 = bundle.getString("SUB_TITLE");
        String string4 = bundle.getString("BUTTON_TEXT");
        try {
            com.ubix.ssp.ad.e.v.e.b().a(string, this.h, -1, new C1112a());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z3) {
            String string5 = bundle.getString("DOWNLOAD_APP_NAME");
            String string6 = bundle.getString("DOWNLOAD_APP_VERSION");
            String string7 = bundle.getString("DOWNLOAD_APP_PUBLISHER");
            String string8 = bundle.getString("DOWNLOAD_APP_ICP_NUMBER");
            String string9 = bundle.getString("DOWNLOAD_APP_SUITABLE_AGE");
            z = z3;
            long j = bundle.getLong("DOWNLOAD_APP_SIZE");
            try {
                TextView textView = (TextView) findViewById(920101);
                if (textView == null) {
                    return;
                }
                if (j > 0) {
                    strA = k.a(j);
                    z2 = true;
                } else {
                    strA = "";
                    z2 = false;
                }
                str = string4;
                try {
                    Object[] objArr = new Object[6];
                    objArr[0] = string5;
                    objArr[1] = string6;
                    objArr[2] = string7;
                    objArr[3] = TextUtils.isEmpty(string8) ? "" : "丨备案号:" + string8;
                    objArr[4] = TextUtils.isEmpty(string9) ? "" : "丨适用年龄:" + string9;
                    objArr[5] = z2 ? "丨应用大小:" + strA : "";
                    textView.setText(new com.ubix.ssp.ad.e.f(String.format("应用名称:%s丨应用版本:%s丨开发者:%s%s%s%s丨权限丨隐私丨功能介绍", objArr)).a(this.f));
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                str = string4;
            }
            e.printStackTrace();
        } else {
            z = z3;
            str = string4;
        }
        this.i.setText(string2);
        this.j.setText(string3);
        TextView textView2 = this.k;
        if (TextUtils.isEmpty(str)) {
            str2 = z ? "立即下载" : "查看详情";
        } else {
            str2 = str;
        }
        textView2.setText(str2);
        this.k.setSingleLine();
        this.k.setEllipsize(TextUtils.TruncateAt.END);
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        this.j.setEllipsize(TextUtils.TruncateAt.END);
        this.k.setGravity(17);
        this.i.setMaxLines(1);
        this.j.setMaxLines(3);
        this.i.setTextColor(-13421773);
        this.j.setTextColor(-8158333);
        this.i.setGravity(17);
        this.j.setGravity(17);
        this.i.setTextSize(20.0f);
        this.j.setTextSize(18.0f);
        this.l.setImageDrawable(q.a("ubix/ic_close.webp"));
        boolean z4 = bundle.getBoolean("HAS_INDICATE");
        this.y = z4;
        if (z4) {
            g();
        }
    }
}
