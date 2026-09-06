package com.ubix.ssp.ad.e;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayout f8624a;
    private int b;
    private int c;
    private String d;
    private String e;

    /* JADX WARN: Code duplicated, block: B:11:0x0084  */
    /* JADX WARN: Code duplicated, block: B:13:0x0088  */
    /* JADX WARN: Code duplicated, block: B:16:0x008d  */
    /* JADX WARN: Code duplicated, block: B:22:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:24:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:34:0x0102  */
    /* JADX WARN: Code duplicated, block: B:35:0x010b  */
    /* JADX WARN: Code duplicated, block: B:38:0x0133  */
    /* JADX WARN: Code duplicated, block: B:40:0x0148 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x014a  */
    /* JADX WARN: Code duplicated, block: B:44:0x0157  */
    /* JADX WARN: Code duplicated, block: B:45:0x0159  */
    /* JADX WARN: Code duplicated, block: B:48:0x016c  */
    /* JADX WARN: Code duplicated, block: B:50:? A[RETURN, SYNTHETIC] */
    public a(Context context, int i, int i2, boolean z, boolean z2, String str, String str2) {
        View view;
        boolean z3;
        View view2;
        TextView textView;
        TextView textView2;
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout;
        Context context2;
        String str3;
        LinearLayout.LayoutParams layoutParams3;
        super(context);
        this.c = 2;
        this.d = "摇动手机";
        this.e = "跳转详情页或第三方应用";
        this.b = i;
        setGravity(17);
        setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.f8624a = linearLayout2;
        linearLayout2.setOrientation(1);
        this.f8624a.setGravity(17);
        if (i != 1) {
            if (i != 2) {
                ImageView imageView = new ImageView(getContext());
                imageView.setImageDrawable(q.a("ubix/ic_hand_shake.webp"));
                imageView.setVisibility(0);
                z3 = true;
                view2 = imageView;
            } else {
                p pVar = new p(getContext());
                pVar.b();
                view = pVar;
            }
            textView = new TextView(getContext());
            textView2 = new TextView(getContext());
            view2.setId(910101);
            textView.setId(910102);
            textView2.setId(910103);
            if (z2) {
                str = str == null ? "" : str;
                this.d = str;
                this.e = str2 == null ? "" : str2;
                if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(this.e)) {
                    this.c = 0;
                } else if (!TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e)) {
                    if (!TextUtils.isEmpty(this.e)) {
                        this.d = this.e;
                        this.e = "";
                    }
                    this.c = 1;
                } else {
                    this.c = 2;
                }
            } else {
                this.c = 2;
            }
            textView.setText(this.d);
            textView2.setText(this.e);
            textView.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
            textView.setTextColor(-1);
            textView.getPaint().setFakeBoldText(true);
            textView.setTextSize(16.0f);
            textView.setSingleLine();
            textView.setGravity(1);
            textView2.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
            textView2.setTextColor(-1);
            textView2.setTextSize(12.0f);
            textView2.setSingleLine();
            textView2.setGravity(1);
            if (i2 != -1) {
                view2.setPadding(30, 30, 30, 30);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            int iA = (int) (com.ubix.ssp.ad.e.a0.r.a().a(getContext()) * 20.0f * 4.0f);
            layoutParams = new LinearLayout.LayoutParams(iA, iA);
            layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 20, 0, 20);
            if (i2 == 1) {
                if (i2 == 0) {
                    linearLayout = this.f8624a;
                    context2 = getContext();
                    str3 = "#40000000";
                }
                LinearLayout linearLayout3 = this.f8624a;
                if (z3) {
                    layoutParams3 = layoutParams;
                } else {
                    layoutParams3 = new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
                }
                linearLayout3.addView(view2, layoutParams3);
                addView(this.f8624a, layoutParams);
                if (z) {
                    addView(textView, layoutParams2);
                    addView(textView2, layoutParams2);
                }
            }
            linearLayout = this.f8624a;
            context2 = getContext();
            str3 = "#73ffffff";
            linearLayout.setBackground(com.ubix.ssp.ad.e.a0.c.a(context2, Color.parseColor(str3), iA * 2));
            LinearLayout linearLayout4 = this.f8624a;
            if (z3) {
                layoutParams3 = layoutParams;
            } else {
                layoutParams3 = new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            }
            linearLayout4.addView(view2, layoutParams3);
            addView(this.f8624a, layoutParams);
            if (z) {
                addView(textView, layoutParams2);
                addView(textView2, layoutParams2);
            }
        }
        j jVar = new j(getContext());
        jVar.b();
        view = jVar;
        z3 = false;
        view2 = view;
        textView = new TextView(getContext());
        textView2 = new TextView(getContext());
        view2.setId(910101);
        textView.setId(910102);
        textView2.setId(910103);
        if (z2) {
            this.c = 2;
        } else {
            if (str == null) {
            }
            this.d = str;
            this.e = str2 == null ? "" : str2;
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(this.d)) {
                }
                if (!TextUtils.isEmpty(this.e)) {
                    this.d = this.e;
                    this.e = "";
                }
                this.c = 1;
            } else {
                if (TextUtils.isEmpty(this.d)) {
                }
                if (!TextUtils.isEmpty(this.e)) {
                    this.d = this.e;
                    this.e = "";
                }
                this.c = 1;
            }
        }
        textView.setText(this.d);
        textView2.setText(this.e);
        textView.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
        textView.setTextColor(-1);
        textView.getPaint().setFakeBoldText(true);
        textView.setTextSize(16.0f);
        textView.setSingleLine();
        textView.setGravity(1);
        textView2.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
        textView2.setTextColor(-1);
        textView2.setTextSize(12.0f);
        textView2.setSingleLine();
        textView2.setGravity(1);
        if (i2 != -1) {
            view2.setPadding(30, 30, 30, 30);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        int iA2 = (int) (com.ubix.ssp.ad.e.a0.r.a().a(getContext()) * 20.0f * 4.0f);
        layoutParams = new LinearLayout.LayoutParams(iA2, iA2);
        layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 20, 0, 20);
        if (i2 == 1) {
            if (i2 == 0) {
                linearLayout = this.f8624a;
                context2 = getContext();
                str3 = "#40000000";
            }
            LinearLayout linearLayout5 = this.f8624a;
            if (z3) {
                layoutParams3 = layoutParams;
            } else {
                layoutParams3 = new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            }
            linearLayout5.addView(view2, layoutParams3);
            addView(this.f8624a, layoutParams);
            if (z) {
                addView(textView, layoutParams2);
                addView(textView2, layoutParams2);
            }
        }
        linearLayout = this.f8624a;
        context2 = getContext();
        str3 = "#73ffffff";
        linearLayout.setBackground(com.ubix.ssp.ad.e.a0.c.a(context2, Color.parseColor(str3), iA2 * 2));
        LinearLayout linearLayout6 = this.f8624a;
        if (z3) {
            layoutParams3 = layoutParams;
        } else {
            layoutParams3 = new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
        }
        linearLayout6.addView(view2, layoutParams3);
        addView(this.f8624a, layoutParams);
        if (z) {
            addView(textView, layoutParams2);
            addView(textView2, layoutParams2);
        }
    }

    public int[] a(int i, int i2) {
        int i3;
        double d = i2;
        int i4 = (int) (0.6d * d);
        int i5 = this.c;
        if (i5 == 0) {
            i4 = i2;
        } else if (i5 == 1) {
            i4 = (int) (d * 0.8d);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
        int i6 = this.b;
        if (i6 == 0) {
            findViewById(910101).setLayoutParams(layoutParams);
        } else if (i6 == 1 || i6 == 2) {
            findViewById(910101).setLayoutParams(new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height));
        }
        this.f8624a.setLayoutParams(layoutParams);
        TextView textView = (TextView) findViewById(910102);
        TextView textView2 = (TextView) findViewById(910103);
        textView.getPaint().setFakeBoldText(false);
        float fA = com.ubix.ssp.ad.e.a0.r.a().a(getContext());
        float f = i2;
        if (f <= 20.0f * fA) {
            i3 = 7;
        } else if (f <= 40.0f * fA) {
            i3 = 9;
        } else if (f <= 60.0f * fA) {
            i3 = 11;
        } else if (f <= 80.0f * fA) {
            i3 = 12;
        } else if (f <= 100.0f * fA) {
            i3 = 14;
        } else if (f <= 120.0f * fA) {
            i3 = 16;
        } else if (f <= 150.0f * fA) {
            i3 = 20;
        } else {
            i3 = f <= fA * 200.0f ? 24 : 28;
        }
        float f2 = i3;
        textView.setTextSize(f2);
        textView2.setTextSize(f2);
        int i7 = (int) (((double) i4) * 0.15d);
        findViewById(910101).setPadding(i7, i7, i7, i7);
        Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
        float f3 = fontMetrics.bottom - fontMetrics.top;
        int i8 = this.c;
        if (i8 > 0) {
            int i9 = i2 - i4;
            if (f3 > i9 / i8 && i2 > 0) {
                int i10 = 5;
                while (f3 > i9 / this.c && i10 > 0) {
                    i10--;
                    i3--;
                    float f4 = i3;
                    textView.setTextSize(f4);
                    textView2.setTextSize(f4);
                    Paint.FontMetrics fontMetrics2 = textView.getPaint().getFontMetrics();
                    f3 = fontMetrics2.bottom - fontMetrics2.top;
                }
            }
        }
        int iMax = (int) Math.max(textView.getPaint().measureText(((Object) textView.getText()) + ""), textView2.getPaint().measureText(((Object) textView2.getText()) + ""));
        textView.setLayoutParams(new LinearLayout.LayoutParams(iMax, -2));
        int i11 = this.c;
        textView2.setLayoutParams(new LinearLayout.LayoutParams(i11 == 1 ? -2 : iMax, i11 != 1 ? -2 : 0));
        return new int[]{Math.max(i4, iMax), i2};
    }
}
