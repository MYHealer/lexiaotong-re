package com.ubix.ssp.ad.e.z;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ubix.ssp.ad.e.a0.l;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.q;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g extends h implements View.OnClickListener {
    private TextView h;
    private TextView i;
    private e j;
    private TextView k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private RelativeLayout p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private int u;
    private com.ubix.ssp.ad.e.a0.g v;
    private boolean w;
    private boolean x;
    private float y;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8950a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ long f;

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.z.g$a$a, reason: collision with other inner class name */
        class C1113a implements h.b {
            C1113a() {
            }

            @Override // com.ubix.ssp.ad.e.z.h.b
            public void a() {
                g.this.d();
                h.b bVar = g.this.f;
                if (bVar != null) {
                    bVar.a();
                }
            }

            @Override // com.ubix.ssp.ad.e.z.h.b
            public void b() {
                g.this.d();
                h.b bVar = g.this.f;
                if (bVar != null) {
                    bVar.b();
                }
            }

            @Override // com.ubix.ssp.ad.e.z.h.b
            public void c() {
                g.this.d();
                h.b bVar = g.this.f;
                if (bVar != null) {
                    bVar.c();
                }
            }
        }

        a(String str, String str2, String str3, String str4, String str5, long j) {
            this.f8950a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = (TextView) g.this.findViewById(920101);
            if (textView != null) {
                Object[] objArr = new Object[6];
                objArr[0] = this.f8950a;
                objArr[1] = this.b;
                objArr[2] = this.c;
                objArr[3] = TextUtils.isEmpty(this.d) ? "" : "丨备案号:" + this.d;
                objArr[4] = TextUtils.isEmpty(this.e) ? "" : "丨适用年龄:" + this.e;
                objArr[5] = this.f > 0 ? "丨应用大小:" + this.f : "";
                textView.setText(new com.ubix.ssp.ad.e.f(String.format("应用名称:%s丨应用版本:%s丨开发者:%s%s%s%s丨权限丨隐私丨功能介绍", objArr)).a(new C1113a()));
                textView.setTextColor(-16777216);
                g.this.forceLayout();
                g.this.requestLayout();
            }
        }
    }

    class b implements com.ubix.ssp.ad.e.a0.g.b {
        b() {
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a() {
            if (g.this.k != null) {
                g.this.k.setText(g.this.a("继续看广告", "继续看广告"));
            }
            l lVar = g.this.c;
            if (lVar != null && lVar.b()) {
                g.this.c.a();
            }
            Dialog dialog = g.this.d;
            if (dialog != null && dialog.isShowing()) {
                g.this.d.dismiss();
            }
            h.c cVar = g.this.e;
            if (cVar != null) {
                cVar.a(null);
            }
            h.c cVar2 = g.this.e;
            if (cVar2 != null) {
                cVar2.b(null);
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void a(long j) {
            int i = (int) (j / 1000);
            if (g.this.k != null) {
                g.this.k.setText(g.this.a(String.format("%s秒后自动放弃继续看广告", Integer.valueOf(i + 1)), "继续看广告"));
            }
        }

        @Override // com.ubix.ssp.ad.e.a0.g.b
        public void b() {
            if (g.this.k != null) {
                g.this.k.setText(g.this.a("继续看广告", "继续看广告"));
            }
        }
    }

    class c extends ClickableSpan {
        c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            l lVar = g.this.c;
            if (lVar != null && lVar.b()) {
                g.this.c.a();
            }
            Dialog dialog = g.this.d;
            if (dialog != null && dialog.isShowing()) {
                g.this.d.dismiss();
            }
            h.c cVar = g.this.e;
            if (cVar != null) {
                cVar.a(null);
            }
            h.c cVar2 = g.this.e;
            if (cVar2 != null) {
                cVar2.b(null);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.linkColor = -7829368;
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.e();
        }
    }

    public static class e extends TextView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f8955a;
        private Paint b;
        private Paint c;
        private RectF d;
        private String e;

        public e(Context context) {
            super(context);
            this.b = new Paint(1);
            this.c = new Paint(1);
            this.d = new RectF();
            this.e = "";
            setWillNotDraw(false);
            this.b.setColor(-12542209);
            this.c.setColor(-1);
            this.c.setTextSize(r.d(20.0f));
            this.c.setTextAlign(Paint.Align.CENTER);
        }

        public void a(float f) {
            this.f8955a = f;
            this.d.set(0.0f, 0.0f, (int) (getMeasuredWidth() * f), getMeasuredHeight());
            this.e = "下载中" + ((int) (this.f8955a * 100.0f)) + "%";
            postInvalidate();
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRoundRect(this.d, 8.0f, 8.0f, this.b);
            Paint.FontMetrics fontMetrics = this.c.getFontMetrics();
            canvas.drawText(this.e, getWidth() / 2.0f, ((getHeight() / 2) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f), this.c);
        }

        public void setText(String str) {
            this.e = str;
            postInvalidate();
        }
    }

    public g(Context context) {
        super(context);
        this.s = false;
        this.t = true;
        this.u = 0;
        this.w = false;
        this.x = true;
        this.y = 3.0f;
        int iH = r.a().h(context);
        int iC = r.a().c(context);
        this.y = r.a().a(context);
        if (iH > iC) {
            this.w = true;
            int iMin = Math.min((int) (((double) iC) * 0.9d), 972);
            this.r = iMin;
            this.q = (int) (((double) iMin) * 0.9d);
        } else {
            this.w = false;
            int iMin2 = Math.min((int) (((double) iH) * 0.75d), 960);
            this.q = iMin2;
            this.r = (int) (((double) iMin2) * 1.5d);
        }
        this.h = new TextView(getContext());
        this.i = new TextView(getContext());
        this.j = new e(getContext());
        this.k = new TextView(getContext());
        this.m = new TextView(getContext());
        this.n = new TextView(getContext());
        this.l = new ImageView(getContext());
        this.o = new ImageView(getContext());
        this.p = new RelativeLayout(getContext());
        this.h.setId(10002);
        this.i.setId(10003);
        this.j.setId(10004);
        this.k.setId(10005);
        this.o.setId(876547);
        this.p.setId(10010);
        this.l.setId(10007);
        this.m.setId(10008);
        this.n.setId(10009);
        this.o.setVisibility(4);
        this.j.setTextColor(-1);
        this.j.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), -12542209, 6));
        this.k.setTextColor(-8158333);
        this.k.setMovementMethod(LinkMovementMethod.getInstance());
        this.k.setHighlightColor(0);
        this.i.setTextColor(-16777216);
        this.h.getPaint().setFakeBoldText(true);
        setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), -1, 32));
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpannableStringBuilder a(String str, String str2) {
        SpannableStringBuilder spannableStringBuilderValueOf = SpannableStringBuilder.valueOf(str);
        if (str.contains(str2)) {
            int iIndexOf = str.indexOf(str2);
            int length = str2.length() + iIndexOf;
            spannableStringBuilderValueOf.setSpan(new c(), iIndexOf, length, 33);
            spannableStringBuilderValueOf.setSpan(new UnderlineSpan(), iIndexOf, length, 33);
        }
        return spannableStringBuilderValueOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.ubix.ssp.ad.e.a0.g gVar = this.v;
        if (gVar != null) {
            gVar.a();
            this.x = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((double) this.q) * 0.8d), -2);
        int i = this.q;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (((double) i) * 0.8d), i / 4);
        int i2 = this.q;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) (((double) i2) * 0.8d), i2 / 8);
        this.j.setZ(4.0f);
        addView(this.h, layoutParams);
        addView(this.i, layoutParams);
        addView(this.j, layoutParams2);
        addView(this.k, layoutParams3);
        RelativeLayout relativeLayout = this.p;
        double d2 = this.q;
        addView(relativeLayout, new LinearLayout.LayoutParams((int) (d2 * 0.8d), (int) (this.w ? d2 / 4.6d : d2 / 3.5d)));
        int i3 = (int) ((((double) this.q) / 3.5d) * 0.6d);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = (int) ((((double) this.q) / 3.5d) * 0.2d);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(5, 10007);
        layoutParams6.addRule(5, 10007);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(1, 10007);
        layoutParams7.addRule(15);
        layoutParams7.leftMargin = (int) ((((double) this.q) / 3.5d) * 0.2d);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        double d3 = this.q;
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams((int) ((d3 * 0.8d) - (d3 / 3.5d)), -2);
        this.m.setEllipsize(TextUtils.TruncateAt.END);
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(this.m, layoutParams8);
        linearLayout.addView(this.n, layoutParams8);
        this.m.setSingleLine();
        this.n.setSingleLine();
        this.p.addView(this.l, layoutParams4);
        this.p.addView(linearLayout, layoutParams7);
        if (this.s) {
            addView(com.ubix.ssp.ad.e.f.a(getContext(), 1), new RelativeLayout.LayoutParams((int) (((double) this.q) * 0.8d), -2));
        }
        addView(this.o);
        this.o.setOnClickListener(this);
        this.j.setOnClickListener(this);
    }

    public void a(int i) {
        this.i.setText(String.format("点击广告并停留%s秒即可获取奖励", i + ""));
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void a(Dialog dialog, h.c cVar, h.b bVar) {
        this.d = dialog;
        this.e = cVar;
        this.f = bVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void a(l lVar, h.c cVar, h.b bVar) {
        this.c = lVar;
        this.e = cVar;
        this.f = bVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    public void a(String str, int i) {
        try {
            e eVar = this.j;
            if (eVar != null) {
                eVar.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), Color.parseColor("#C3D8FF"), 6));
                if (i < 0) {
                    this.j.setText(str);
                } else {
                    this.j.a(i / 100.0f);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(boolean z) {
        e eVar;
        String str;
        if (!z) {
            this.h.setText("尚未获取奖励");
            return;
        }
        this.h.setText("恭喜获得奖励");
        this.i.setText("点击下方按钮跳转到广告详情页或第三方应用");
        if (this.s) {
            eVar = this.j;
            str = "立即下载";
        } else {
            eVar = this.j;
            str = "查看详情";
        }
        eVar.setText(str);
    }

    public void b(int i) {
        try {
            e eVar = this.j;
            if (eVar != null) {
                eVar.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), Color.parseColor("#C3D8FF"), 6));
                this.j.a(i / 100.0f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b(boolean z) {
        TextView textView;
        String str;
        e eVar;
        String str2;
        if (z) {
            textView = this.h;
            str = "恭喜获得奖励";
        } else {
            textView = this.h;
            str = "奖励获取失败";
        }
        textView.setText(str);
        this.i.setText("点击下方按钮跳转到广告详情页或第三方应用");
        if (this.s) {
            eVar = this.j;
            str2 = "立即下载";
        } else {
            eVar = this.j;
            str2 = "查看详情";
        }
        eVar.setText(str2);
    }

    public void f() {
        e eVar;
        String str;
        this.h.setText("奖励获取中");
        this.i.setText("点击下方按钮跳转到广告详情页或第三方应用");
        if (this.s) {
            eVar = this.j;
            str = "立即下载";
        } else {
            eVar = this.j;
            str = "查看详情";
        }
        eVar.setText(str);
    }

    public int getContentHeight() {
        return this.q;
    }

    public int getContentWidth() {
        return this.q;
    }

    @Override // com.ubix.ssp.ad.e.z.h
    protected int getPopupType() {
        return 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.c cVar;
        d();
        int id = view.getId();
        if (id == 10004) {
            if (this.t) {
                l lVar = this.c;
                if (lVar != null && lVar.b()) {
                    this.c.a();
                }
                Dialog dialog = this.d;
                if (dialog != null && dialog.isShowing()) {
                    this.d.dismiss();
                }
            }
            h.c cVar2 = this.e;
            if (cVar2 != null) {
                cVar2.a(null, null);
            }
            if (!this.t || (cVar = this.e) == null) {
                return;
            }
        } else if (id == 10005) {
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
            if (cVar == null) {
                return;
            }
        } else {
            if (id != 876547) {
                return;
            }
            l lVar3 = this.c;
            if (lVar3 != null && lVar3.b()) {
                this.c.a();
            }
            Dialog dialog3 = this.d;
            if (dialog3 != null && dialog3.isShowing()) {
                this.d.dismiss();
            }
            cVar = this.e;
            if (cVar == null) {
                return;
            }
        }
        cVar.b(null);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        double d2;
        double d3;
        double d4;
        int i5;
        int bottom;
        int i6;
        int bottom2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        double bottom3;
        double d5;
        double d6;
        double d7;
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            View childAt = getChildAt(i13);
            int id = childAt.getId();
            if (id == 10010) {
                double d8 = this.q;
                int i14 = (int) ((d8 - (d8 * 0.8d)) / 2.0d);
                int bottom4 = findViewById(10003).getBottom() + ((int) (this.w ? ((double) this.r) * 0.02d : ((double) this.r) * 0.05d));
                double d9 = this.q;
                int i15 = (int) ((d9 + (0.8d * d9)) / 2.0d);
                double bottom5 = findViewById(10003).getBottom();
                if (this.w) {
                    d2 = (int) (((double) this.r) * 0.02d);
                    d3 = this.q;
                    d4 = 4.6d;
                } else {
                    d2 = (int) (((double) this.r) * 0.05d);
                    d3 = this.q;
                    d4 = 3.5d;
                }
                childAt.layout(i14, bottom4, i15, (int) (bottom5 + d2 + (d3 / d4)));
                childAt.setBackgroundColor(-1);
            } else if (id != 876547) {
                if (id != 920101) {
                    switch (id) {
                        case 10002:
                            if (this.h.getLineCount() == 1) {
                                i7 = this.q;
                                double d10 = i7;
                                i8 = (int) (0.1d * d10);
                                boolean z2 = this.w;
                                i9 = z2 ? i7 / 14 : i7 / 7;
                                i10 = (int) (d10 * 0.9d);
                                if (z2) {
                                    i11 = i7 / 14;
                                    i12 = i7 / 8;
                                } else {
                                    i11 = i7 / 7;
                                    i12 = i7 / 6;
                                }
                            } else {
                                i7 = this.q;
                                double d11 = i7;
                                i8 = (int) (0.1d * d11);
                                boolean z3 = this.w;
                                i9 = z3 ? i7 / 16 : i7 / 8;
                                i10 = (int) (d11 * 0.9d);
                                if (z3) {
                                    i11 = i7 / 16;
                                    i12 = i7 / 8;
                                } else {
                                    i11 = i7 / 8;
                                    i12 = i7 / 6;
                                }
                            }
                            childAt.layout(i8, i9, i10, i11 + i12);
                            continue;
                        case 10003:
                            childAt.layout((int) (((double) this.q) * 0.1d), findViewById(10002).getBottom() + ((int) (this.w ? ((double) this.r) * 0.03d : ((double) this.r) * 0.05d)), (int) (((double) this.q) * 0.9d), findViewById(10002).getBottom() + (this.w ? (int) (((double) this.r) * 0.03d) : (int) (((double) this.r) * 0.05d)) + (this.q / 6));
                            continue;
                        case 10004:
                            if (findViewById(920101) == null) {
                                double d12 = this.q;
                                i5 = (int) ((d12 - (d12 * 0.8d)) / 2.0d);
                                bottom = findViewById(10010).getBottom() + ((int) (((double) this.r) * 0.07d));
                                double d13 = this.q;
                                i6 = (int) ((d13 + (0.8d * d13)) / 2.0d);
                                bottom3 = findViewById(10010).getBottom() + ((int) (((double) this.r) * 0.07d));
                                if (this.w) {
                                    d6 = this.q;
                                    d7 = 4.4d;
                                } else {
                                    d5 = this.q / 4;
                                }
                                bottom2 = (int) (bottom3 + d5);
                                break;
                            } else {
                                double d14 = this.q;
                                i5 = (int) ((d14 - (d14 * 0.8d)) / 2.0d);
                                bottom = findViewById(920101).getTop() + findViewById(920101).getMeasuredHeight() + ((int) (((double) this.r) * 0.015d));
                                double d15 = this.q;
                                i6 = (int) ((d15 + (0.8d * d15)) / 2.0d);
                                bottom3 = findViewById(920101).getTop() + findViewById(920101).getMeasuredHeight() + ((int) (((double) this.r) * 0.015d));
                                if (this.w) {
                                    d6 = this.q;
                                    d7 = 5.2d;
                                } else {
                                    d6 = this.q;
                                    d7 = 4.0d;
                                }
                            }
                            d5 = d6 / d7;
                            bottom2 = (int) (bottom3 + d5);
                            break;
                        case 10005:
                            double d16 = this.q;
                            int bottom6 = findViewById(10004).getBottom() + ((int) (((double) this.r) * 0.012d));
                            double d17 = this.q;
                            childAt.layout((int) ((d16 - (d16 * 0.8d)) / 2.0d), bottom6, (int) ((d17 + (0.8d * d17)) / 2.0d), findViewById(10004).getBottom() + ((int) (((double) this.r) * 0.012d)) + (this.q / 8));
                            continue;
                        default:
                            continue;
                    }
                } else {
                    i5 = (int) (((double) this.q) * 0.1d);
                    bottom = findViewById(10010).getBottom() + ((int) (this.y * 8.0f));
                    i6 = (int) (((double) this.q) * 0.9d);
                    bottom2 = findViewById(10010).getBottom() + ((int) (this.y * 8.0f)) + findViewById(920101).getMeasuredHeight();
                }
                childAt.layout(i5, bottom, i6, bottom2);
            } else {
                int i16 = this.q;
                int i17 = i16 / 30;
                int i18 = i16 - i17;
                int i19 = i16 / 11;
                childAt.layout(i18 - i19, i17, i18, i19 + i17);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.q, this.r);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.x) {
            return;
        }
        if (i == 0) {
            com.ubix.ssp.ad.e.a0.g gVar = this.v;
            if (gVar == null || !gVar.b()) {
                return;
            }
            this.v.d();
            return;
        }
        com.ubix.ssp.ad.e.a0.g gVar2 = this.v;
        if (gVar2 == null || gVar2.b()) {
            return;
        }
        this.v.c();
    }

    /* JADX WARN: Code duplicated, block: B:54:0x01af  */
    /* JADX WARN: Code duplicated, block: B:55:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:81:0x023c  */
    /* JADX WARN: Code duplicated, block: B:82:0x023f  */
    /* JADX WARN: Code duplicated, block: B:91:0x026c  */
    @Override // com.ubix.ssp.ad.e.z.h
    public void setData(Bundle bundle) {
        int color;
        e eVar;
        TextView textView;
        SpannableStringBuilder spannableStringBuilderA;
        String string = bundle.getString("TITLE");
        String string2 = bundle.getString("SUB_TITLE");
        String string3 = bundle.getString("ELAPSE");
        String string4 = bundle.getString("TASK_TIME");
        boolean z = bundle.getBoolean("IS_REWARDED");
        int i = bundle.getInt("TITLE_TEMP");
        int i2 = bundle.getInt("REWARD_GUIDE_AUTO_CLOSE_TIME");
        String string5 = bundle.getString("ICON_URL");
        this.u = bundle.getInt("REWARD_VIDEO_DIALOG_TYPE");
        this.t = bundle.getBoolean("REWARD_VIDEO_DIALOG_AUTO_CLOSE");
        this.s = bundle.getBoolean("IS_DOWNLOAD");
        String string6 = bundle.getString("DOWNLOAD_APP_NAME");
        String string7 = bundle.getString("DOWNLOAD_APP_PUBLISHER");
        String string8 = bundle.getString("DOWNLOAD_APP_VERSION");
        long j = bundle.getLong("DOWNLOAD_APP_SIZE");
        boolean z2 = bundle.getBoolean("GOT_VIDEO_CACHE");
        String string9 = bundle.getString("DOWNLOAD_APP_ICP_NUMBER");
        String string10 = bundle.getString("DOWNLOAD_APP_SUITABLE_AGE");
        this.m.setText(string);
        this.n.setText(string2);
        com.ubix.ssp.ad.e.v.e.b().a(string5, this.l, 0, null);
        if (this.s) {
            postDelayed(new a(string6, string8, string7, string9, string10, j), 100L);
        }
        int i3 = this.u;
        if (i3 == 0) {
            color = Color.parseColor("#F1F1F1");
        } else {
            if (i3 == 1) {
                this.o.setVisibility(0);
            }
            color = Color.parseColor("#FFFBDB");
        }
        setBackgroundColor(color);
        String str = "立即下载";
        switch (i) {
            case 0:
                int i4 = this.u;
                if (i4 == 1) {
                    this.h.setText("完成观看领奖励");
                    TextView textView2 = this.i;
                    if (z2) {
                        textView2.setText(String.format("还需观看%s秒即可获取奖励", string3));
                        this.j.setText("继续看广告");
                    } else {
                        textView2.setText("视频正在加载中，请耐心等待");
                        eVar = this.j;
                        str = "继续等待";
                        eVar.setText(str);
                    }
                    textView = this.k;
                    spannableStringBuilderA = a("关闭广告", "关闭广告");
                    textView.setText(spannableStringBuilderA);
                } else if (i4 == 0) {
                    TextView textView3 = this.h;
                    if (z) {
                        textView3.setText("恭喜获得奖励");
                    } else {
                        textView3.setText("奖励获取中");
                    }
                    this.i.setText("点击下方按钮跳转到广告详情页或第三方应用");
                    if (this.s) {
                        eVar = this.j;
                        eVar.setText(str);
                    } else {
                        this.j.setText("查看详情");
                    }
                    textView = this.k;
                    spannableStringBuilderA = a("关闭广告", "关闭广告");
                    textView.setText(spannableStringBuilderA);
                } else if (i4 == 3) {
                    this.h.setText("完成观看领奖励");
                    this.i.setText("点击下方按钮跳转到广告详情页或第三方应用");
                    if (this.s) {
                        this.j.setText("立即下载");
                    } else {
                        this.j.setText("查看详情");
                    }
                    textView = this.k;
                    spannableStringBuilderA = a("继续看广告", "继续看广告");
                    textView.setText(spannableStringBuilderA);
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                int i5 = this.u;
                if (i5 == 0) {
                    TextView textView4 = this.h;
                    if (!z) {
                        textView4.setText("尚未获取奖励");
                        this.i.setText("点击并成功跳转即可获取奖励");
                        if (this.s) {
                            eVar = this.j;
                            str = "下载拿奖励";
                        } else {
                            eVar = this.j;
                            str = "我要拿奖励";
                        }
                        eVar.setText(str);
                        textView = this.k;
                        spannableStringBuilderA = a("关闭广告", "关闭广告");
                        textView.setText(spannableStringBuilderA);
                    } else {
                        textView4.setText("恭喜获得奖励");
                        this.i.setText("点击下方按钮跳转到广告详情页或第三方应用");
                        if (this.s) {
                            eVar = this.j;
                            eVar.setText(str);
                        } else {
                            this.j.setText("查看详情");
                        }
                        textView = this.k;
                        spannableStringBuilderA = a("关闭广告", "关闭广告");
                        textView.setText(spannableStringBuilderA);
                    }
                } else if (i5 == 1) {
                    this.h.setText("尚未获取奖励");
                    this.i.setText("点击并成功跳转即可获取奖励");
                    if (this.s) {
                        eVar = this.j;
                        str = "下载拿奖励";
                    } else {
                        eVar = this.j;
                        str = "我要拿奖励";
                    }
                    eVar.setText(str);
                    textView = this.k;
                    spannableStringBuilderA = a("关闭广告", "关闭广告");
                    textView.setText(spannableStringBuilderA);
                } else if (i5 == 2 || i5 == 3) {
                    this.h.setText("更快拿奖励");
                    this.i.setText("点击并成功跳转即可获取奖励");
                    if (this.s) {
                        this.j.setText("下载更快拿奖励");
                    } else {
                        this.j.setText("我要更快拿奖励");
                    }
                    if (this.u == 3 || i2 <= 0) {
                        textView = this.k;
                        spannableStringBuilderA = a("继续看广告", "继续看广告");
                    } else {
                        textView = this.k;
                        spannableStringBuilderA = a(String.format("%s秒后自动放弃继续看广告", Integer.valueOf(i2)), "继续看广告");
                    }
                    textView.setText(spannableStringBuilderA);
                }
                break;
            case 9:
            case 10:
                int i6 = this.u;
                if (i6 == 0) {
                    TextView textView5 = this.h;
                    if (!z) {
                        textView5.setText(String.format("%s秒更快拿奖励", string4));
                        this.i.setText(String.format("点击广告并停留%s秒即可获取奖励", string3));
                        if (this.s) {
                            eVar = this.j;
                            str = "下载拿奖励";
                        } else {
                            eVar = this.j;
                            str = "我要拿奖励";
                        }
                        eVar.setText(str);
                        textView = this.k;
                        spannableStringBuilderA = a("关闭广告", "关闭广告");
                        textView.setText(spannableStringBuilderA);
                    } else {
                        textView5.setText("恭喜获得奖励");
                        this.i.setText("点击下方按钮跳转到广告详情页或第三方应用");
                        if (this.s) {
                            eVar = this.j;
                            eVar.setText(str);
                        } else {
                            this.j.setText("查看详情");
                        }
                        textView = this.k;
                        spannableStringBuilderA = a("关闭广告", "关闭广告");
                        textView.setText(spannableStringBuilderA);
                    }
                } else if (i6 == 1) {
                    this.h.setText("尚未获取奖励");
                    this.i.setText(String.format("点击广告并停留%s秒即可获取奖励", string3));
                    if (this.s) {
                        eVar = this.j;
                        str = "下载拿奖励";
                    } else {
                        eVar = this.j;
                        str = "我要拿奖励";
                    }
                    eVar.setText(str);
                    textView = this.k;
                    spannableStringBuilderA = a("关闭广告", "关闭广告");
                    textView.setText(spannableStringBuilderA);
                } else if (i6 == 2 || i6 == 3) {
                    this.h.setText(String.format("%s秒更快拿奖励", string4));
                    this.i.setText(String.format("点击广告并停留%s秒即可获取奖励", string3));
                    if (this.s) {
                        this.j.setText("下载更快拿奖励");
                    } else {
                        this.j.setText("我要更快拿奖励");
                    }
                    if (this.u == 3 || i2 <= 0) {
                        textView = this.k;
                        spannableStringBuilderA = a("继续看广告", "继续看广告");
                    } else {
                        textView = this.k;
                        spannableStringBuilderA = a(String.format("%s秒后自动放弃继续看广告", Integer.valueOf(i2)), "%s秒后自动放弃继续看广告");
                    }
                    textView.setText(spannableStringBuilderA);
                }
                break;
        }
        if (this.w) {
            this.h.setTextSize(27.0f);
            this.i.setTextSize(16.0f);
            this.j.setTextSize(17.0f);
            this.k.setTextSize(12.0f);
            this.m.setTextSize(14.0f);
            this.n.setTextSize(12.0f);
            this.h.setMaxLines(1);
            this.i.setMaxLines(2);
        } else {
            this.h.setTextSize(30.0f);
            this.i.setTextSize(17.0f);
            this.j.setTextSize(20.0f);
            this.k.setTextSize(12.0f);
            this.m.setTextSize(16.0f);
            this.n.setTextSize(12.0f);
            this.i.setMaxLines(3);
        }
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        this.j.setGravity(17);
        this.k.setGravity(17);
        this.h.setTextColor(-13421773);
        this.h.setGravity(17);
        this.i.setGravity(17);
        this.m.setTextColor(-16777216);
        this.n.setTextColor(-7829368);
        this.h.setTextColor(Color.parseColor("#FF8D1A"));
        this.o.setImageDrawable(q.a("ubix/ic_close.webp"));
        if (i2 <= 0 || this.u != 2) {
            return;
        }
        com.ubix.ssp.ad.e.a0.g gVar = new com.ubix.ssp.ad.e.a0.g(((long) i2) * 1000);
        this.v = gVar;
        gVar.a(new b());
        this.v.e();
        this.x = false;
    }
}
