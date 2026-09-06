package com.opos.mobad.template.g;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class y extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f7998a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private String j;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private com.opos.mobad.template.a.InterfaceC1003a r;

    public y(Context context, int i, boolean z) {
        super(context);
        this.j = "#8CFFFFFF";
        this.l = "#4DFFFFFF";
        this.m = "#D9FFFFFF";
        this.n = "#2F80ED";
        this.o = "#3B000000";
        this.p = "#99FFFFFF";
        this.q = "#007BFF";
        a(i, z);
    }

    public static y a(Context context) {
        return new y(context, 1, false);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0094  */
    /* JADX WARN: Code duplicated, block: B:14:0x0097  */
    /* JADX WARN: Code duplicated, block: B:17:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:18:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:21:0x0127  */
    /* JADX WARN: Code duplicated, block: B:22:0x0132  */
    /* JADX WARN: Code duplicated, block: B:25:0x0160  */
    /* JADX WARN: Code duplicated, block: B:26:0x0165  */
    /* JADX WARN: Code duplicated, block: B:29:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:30:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:33:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:34:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:37:0x0227  */
    /* JADX WARN: Code duplicated, block: B:38:0x0232  */
    /* JADX WARN: Code duplicated, block: B:41:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:42:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:45:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:46:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:49:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:51:0x0326 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0328  */
    /* JADX WARN: Code duplicated, block: B:53:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:55:0x03af  */
    private void a(int i, boolean z) {
        int iA;
        int iA2;
        TextView textView;
        String str;
        float f;
        TextView textView2;
        int iA3;
        RelativeLayout.LayoutParams layoutParams;
        TextView textView3;
        String str2;
        RelativeLayout.LayoutParams layoutParams2;
        TextView textView4;
        String str3;
        RelativeLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Context context;
        float f2;
        TextView textView5;
        String str4;
        setGravity(1);
        TextView textView6 = new TextView(getContext());
        this.f7998a = textView6;
        textView6.setId(View.generateViewId());
        int iA4 = com.opos.cmn.an.h.f.a.a(getContext(), 1.4f);
        int iA5 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
        if (i != 1) {
            if (i == 0) {
                this.f7998a.setTextColor(Color.parseColor(this.m));
                this.f7998a.setShadowLayer(1.0f, 0.0f, iA4, Color.parseColor(this.o));
                iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
                iA = com.opos.cmn.an.h.f.a.a(getContext(), 1.5f);
            } else if (i == 2) {
                textView = this.f7998a;
                str = this.p;
            } else {
                iA = 0;
                iA2 = 0;
            }
            Context context2 = getContext();
            if (z) {
                f = 150.0f;
            } else {
                f = 70.0f;
            }
            int iA6 = com.opos.cmn.an.h.f.a.a(context2, f);
            TextView textView7 = new TextView(getContext());
            this.i = textView7;
            textView7.setId(View.generateViewId());
            this.i.setTextSize(1, 10.0f);
            this.i.setText(R.string.mobad_introduce);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            textView2 = this.i;
            if (i == 2) {
                textView2.setTextColor(Color.parseColor(this.q));
                iA3 = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
            } else {
                textView2.setTextColor(Color.parseColor(this.n));
                iA3 = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
            }
            layoutParams5.rightMargin = iA3;
            layoutParams5.leftMargin = iA5;
            layoutParams5.addRule(15);
            layoutParams5.addRule(11);
            addView(this.i, layoutParams5);
            TextView textView8 = new TextView(getContext());
            this.h = textView8;
            textView8.setId(View.generateViewId());
            layoutParams = new RelativeLayout.LayoutParams(iA, iA2);
            layoutParams.leftMargin = iA5;
            layoutParams.addRule(0, this.i.getId());
            if (i == 0) {
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            } else {
                layoutParams.addRule(15);
            }
            addView(this.h, layoutParams);
            TextView textView9 = new TextView(getContext());
            this.g = textView9;
            textView9.setId(View.generateViewId());
            this.g.setTextSize(1, 10.0f);
            this.g.setText(R.string.mobad_permissions);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
            if (i == 2) {
                textView3 = this.g;
                str2 = this.q;
            } else {
                textView3 = this.g;
                str2 = this.n;
            }
            textView3.setTextColor(Color.parseColor(str2));
            layoutParams6.leftMargin = iA5;
            layoutParams6.addRule(15);
            layoutParams6.addRule(0, this.h.getId());
            addView(this.g, layoutParams6);
            TextView textView10 = new TextView(getContext());
            this.f = textView10;
            textView10.setId(View.generateViewId());
            layoutParams2 = new RelativeLayout.LayoutParams(iA, iA2);
            layoutParams2.leftMargin = iA5;
            layoutParams2.addRule(0, this.g.getId());
            if (i == 0) {
                layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            } else {
                layoutParams2.addRule(15);
            }
            addView(this.f, layoutParams2);
            TextView textView11 = new TextView(getContext());
            this.e = textView11;
            textView11.setId(View.generateViewId());
            if (i == 2) {
                textView4 = this.e;
                str3 = this.q;
            } else {
                textView4 = this.e;
                str3 = this.n;
            }
            textView4.setTextColor(Color.parseColor(str3));
            this.e.setTextSize(1, 10.0f);
            this.e.setText(R.string.mobad_privacy);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams7.leftMargin = iA5;
            layoutParams7.addRule(15);
            layoutParams7.addRule(0, this.f.getId());
            addView(this.e, layoutParams7);
            TextView textView12 = new TextView(getContext());
            this.d = textView12;
            textView12.setId(View.generateViewId());
            layoutParams3 = new RelativeLayout.LayoutParams(iA, iA2);
            layoutParams3.leftMargin = iA5;
            layoutParams3.addRule(0, this.e.getId());
            if (i == 0) {
                layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            } else {
                layoutParams3.addRule(15);
            }
            addView(this.d, layoutParams3);
            TextView textView13 = new TextView(getContext());
            this.c = textView13;
            textView13.setId(View.generateViewId());
            this.c.setTextSize(1, 10.0f);
            this.c.setMaxWidth(iA6);
            this.c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.c.setSingleLine(true);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams8.leftMargin = iA5;
            layoutParams8.addRule(15);
            layoutParams8.addRule(0, this.d.getId());
            addView(this.c, layoutParams8);
            TextView textView14 = new TextView(getContext());
            this.b = textView14;
            textView14.setId(View.generateViewId());
            layoutParams4 = new RelativeLayout.LayoutParams(iA, iA2);
            layoutParams4.leftMargin = iA5;
            layoutParams4.addRule(0, this.c.getId());
            if (i == 0) {
                layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
            } else {
                layoutParams4.addRule(15);
            }
            addView(this.b, layoutParams4);
            this.f7998a.setTextSize(1, 10.0f);
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
            if (i == 2) {
                context = getContext();
                f2 = 16.0f;
            } else {
                context = getContext();
                f2 = 22.0f;
            }
            layoutParams9.leftMargin = com.opos.cmn.an.h.f.a.a(context, f2);
            layoutParams9.addRule(0, this.b.getId());
            this.f7998a.setSingleLine(true);
            layoutParams9.addRule(15);
            addView(this.f7998a, layoutParams9);
            if (i == 1) {
                if (i == 0) {
                    this.c.setTextColor(Color.parseColor(this.m));
                    float f3 = iA4;
                    this.c.setShadowLayer(1.0f, 0.0f, f3, Color.parseColor(this.o));
                    this.e.setShadowLayer(1.0f, 0.0f, f3, Color.parseColor(this.o));
                    this.g.setShadowLayer(1.0f, 0.0f, f3, Color.parseColor(this.o));
                    this.i.setShadowLayer(1.0f, 0.0f, f3, Color.parseColor(this.o));
                    com.opos.mobad.template.cmn.ab.a(this.b, Color.parseColor(this.j), 1, Color.parseColor(this.o), 1, 0, iA4);
                    com.opos.mobad.template.cmn.ab.a(this.d, Color.parseColor(this.j), 1, Color.parseColor(this.o), 1, 0, iA4);
                    com.opos.mobad.template.cmn.ab.a(this.f, Color.parseColor(this.j), 1, Color.parseColor(this.o), 1, 0, iA4);
                    com.opos.mobad.template.cmn.ab.a(this.h, Color.parseColor(this.j), 1, Color.parseColor(this.o), 1, 0, iA4);
                } else if (i == 2) {
                    this.c.setTextColor(Color.parseColor(this.p));
                    this.b.setBackgroundColor(Color.parseColor(this.p));
                    this.d.setBackgroundColor(Color.parseColor(this.p));
                    this.f.setBackgroundColor(Color.parseColor(this.p));
                    textView5 = this.h;
                    str4 = this.p;
                }
                com.opos.mobad.template.cmn.p.a(this.i, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.1
                    @Override // com.opos.mobad.template.cmn.p
                    public void b(View view, int[] iArr) {
                        if (y.this.r != null) {
                            y.this.r.d(view, iArr);
                        }
                    }
                });
                com.opos.mobad.template.cmn.p.a(this.g, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.2
                    @Override // com.opos.mobad.template.cmn.p
                    public void b(View view, int[] iArr) {
                        if (y.this.r != null) {
                            y.this.r.c(view, iArr);
                        }
                    }
                });
                com.opos.mobad.template.cmn.p.a(this.e, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.3
                    @Override // com.opos.mobad.template.cmn.p
                    public void b(View view, int[] iArr) {
                        if (y.this.r != null) {
                            y.this.r.b(view, iArr);
                        }
                    }
                });
            }
            this.c.setTextColor(Color.parseColor(this.j));
            this.b.setBackgroundColor(Color.parseColor(this.l));
            this.d.setBackgroundColor(Color.parseColor(this.l));
            this.f.setBackgroundColor(Color.parseColor(this.l));
            textView5 = this.h;
            str4 = this.l;
            textView5.setBackgroundColor(Color.parseColor(str4));
            com.opos.mobad.template.cmn.p.a(this.i, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.1
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (y.this.r != null) {
                        y.this.r.d(view, iArr);
                    }
                }
            });
            com.opos.mobad.template.cmn.p.a(this.g, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.2
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (y.this.r != null) {
                        y.this.r.c(view, iArr);
                    }
                }
            });
            com.opos.mobad.template.cmn.p.a(this.e, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.3
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (y.this.r != null) {
                        y.this.r.b(view, iArr);
                    }
                }
            });
        }
        textView = this.f7998a;
        str = this.j;
        textView.setTextColor(Color.parseColor(str));
        iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 7.0f);
        iA = com.opos.cmn.an.h.f.a.a(getContext(), 0.67f);
        Context context3 = getContext();
        if (z) {
            f = 150.0f;
        } else {
            f = 70.0f;
        }
        int iA7 = com.opos.cmn.an.h.f.a.a(context3, f);
        TextView textView15 = new TextView(getContext());
        this.i = textView15;
        textView15.setId(View.generateViewId());
        this.i.setTextSize(1, 10.0f);
        this.i.setText(R.string.mobad_introduce);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        textView2 = this.i;
        if (i == 2) {
            textView2.setTextColor(Color.parseColor(this.q));
            iA3 = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        } else {
            textView2.setTextColor(Color.parseColor(this.n));
            iA3 = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        }
        layoutParams10.rightMargin = iA3;
        layoutParams10.leftMargin = iA5;
        layoutParams10.addRule(15);
        layoutParams10.addRule(11);
        addView(this.i, layoutParams10);
        TextView textView16 = new TextView(getContext());
        this.h = textView16;
        textView16.setId(View.generateViewId());
        layoutParams = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams.leftMargin = iA5;
        layoutParams.addRule(0, this.i.getId());
        if (i == 0) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        } else {
            layoutParams.addRule(15);
        }
        addView(this.h, layoutParams);
        TextView textView17 = new TextView(getContext());
        this.g = textView17;
        textView17.setId(View.generateViewId());
        this.g.setTextSize(1, 10.0f);
        this.g.setText(R.string.mobad_permissions);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        if (i == 2) {
            textView3 = this.g;
            str2 = this.q;
        } else {
            textView3 = this.g;
            str2 = this.n;
        }
        textView3.setTextColor(Color.parseColor(str2));
        layoutParams11.leftMargin = iA5;
        layoutParams11.addRule(15);
        layoutParams11.addRule(0, this.h.getId());
        addView(this.g, layoutParams11);
        TextView textView18 = new TextView(getContext());
        this.f = textView18;
        textView18.setId(View.generateViewId());
        layoutParams2 = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams2.leftMargin = iA5;
        layoutParams2.addRule(0, this.g.getId());
        if (i == 0) {
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        } else {
            layoutParams2.addRule(15);
        }
        addView(this.f, layoutParams2);
        TextView textView19 = new TextView(getContext());
        this.e = textView19;
        textView19.setId(View.generateViewId());
        if (i == 2) {
            textView4 = this.e;
            str3 = this.q;
        } else {
            textView4 = this.e;
            str3 = this.n;
        }
        textView4.setTextColor(Color.parseColor(str3));
        this.e.setTextSize(1, 10.0f);
        this.e.setText(R.string.mobad_privacy);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams12.leftMargin = iA5;
        layoutParams12.addRule(15);
        layoutParams12.addRule(0, this.f.getId());
        addView(this.e, layoutParams12);
        TextView textView110 = new TextView(getContext());
        this.d = textView110;
        textView110.setId(View.generateViewId());
        layoutParams3 = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams3.leftMargin = iA5;
        layoutParams3.addRule(0, this.e.getId());
        if (i == 0) {
            layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        } else {
            layoutParams3.addRule(15);
        }
        addView(this.d, layoutParams3);
        TextView textView111 = new TextView(getContext());
        this.c = textView111;
        textView111.setId(View.generateViewId());
        this.c.setTextSize(1, 10.0f);
        this.c.setMaxWidth(iA7);
        this.c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.c.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams13.leftMargin = iA5;
        layoutParams13.addRule(15);
        layoutParams13.addRule(0, this.d.getId());
        addView(this.c, layoutParams13);
        TextView textView112 = new TextView(getContext());
        this.b = textView112;
        textView112.setId(View.generateViewId());
        layoutParams4 = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams4.leftMargin = iA5;
        layoutParams4.addRule(0, this.c.getId());
        if (i == 0) {
            layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        } else {
            layoutParams4.addRule(15);
        }
        addView(this.b, layoutParams4);
        this.f7998a.setTextSize(1, 10.0f);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-2, -2);
        if (i == 2) {
            context = getContext();
            f2 = 16.0f;
        } else {
            context = getContext();
            f2 = 22.0f;
        }
        layoutParams14.leftMargin = com.opos.cmn.an.h.f.a.a(context, f2);
        layoutParams14.addRule(0, this.b.getId());
        this.f7998a.setSingleLine(true);
        layoutParams14.addRule(15);
        addView(this.f7998a, layoutParams14);
        if (i == 1) {
            if (i == 0) {
                this.c.setTextColor(Color.parseColor(this.m));
                float f4 = iA4;
                this.c.setShadowLayer(1.0f, 0.0f, f4, Color.parseColor(this.o));
                this.e.setShadowLayer(1.0f, 0.0f, f4, Color.parseColor(this.o));
                this.g.setShadowLayer(1.0f, 0.0f, f4, Color.parseColor(this.o));
                this.i.setShadowLayer(1.0f, 0.0f, f4, Color.parseColor(this.o));
                com.opos.mobad.template.cmn.ab.a(this.b, Color.parseColor(this.j), 1, Color.parseColor(this.o), 1, 0, iA4);
                com.opos.mobad.template.cmn.ab.a(this.d, Color.parseColor(this.j), 1, Color.parseColor(this.o), 1, 0, iA4);
                com.opos.mobad.template.cmn.ab.a(this.f, Color.parseColor(this.j), 1, Color.parseColor(this.o), 1, 0, iA4);
                com.opos.mobad.template.cmn.ab.a(this.h, Color.parseColor(this.j), 1, Color.parseColor(this.o), 1, 0, iA4);
            } else if (i == 2) {
                this.c.setTextColor(Color.parseColor(this.p));
                this.b.setBackgroundColor(Color.parseColor(this.p));
                this.d.setBackgroundColor(Color.parseColor(this.p));
                this.f.setBackgroundColor(Color.parseColor(this.p));
                textView5 = this.h;
                str4 = this.p;
            }
            com.opos.mobad.template.cmn.p.a(this.i, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.1
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (y.this.r != null) {
                        y.this.r.d(view, iArr);
                    }
                }
            });
            com.opos.mobad.template.cmn.p.a(this.g, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.2
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (y.this.r != null) {
                        y.this.r.c(view, iArr);
                    }
                }
            });
            com.opos.mobad.template.cmn.p.a(this.e, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.3
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view, int[] iArr) {
                    if (y.this.r != null) {
                        y.this.r.b(view, iArr);
                    }
                }
            });
        }
        this.c.setTextColor(Color.parseColor(this.j));
        this.b.setBackgroundColor(Color.parseColor(this.l));
        this.d.setBackgroundColor(Color.parseColor(this.l));
        this.f.setBackgroundColor(Color.parseColor(this.l));
        textView5 = this.h;
        str4 = this.l;
        textView5.setBackgroundColor(Color.parseColor(str4));
        com.opos.mobad.template.cmn.p.a(this.i, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (y.this.r != null) {
                    y.this.r.d(view, iArr);
                }
            }
        });
        com.opos.mobad.template.cmn.p.a(this.g, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (y.this.r != null) {
                    y.this.r.c(view, iArr);
                }
            }
        });
        com.opos.mobad.template.cmn.p.a(this.e, new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.y.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (y.this.r != null) {
                    y.this.r.b(view, iArr);
                }
            }
        });
    }

    public static y b(Context context) {
        return new y(context, 2, false);
    }

    public static y c(Context context) {
        return new y(context, 0, false);
    }

    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        com.opos.cmn.an.f.a.b("BlockPrivacyView", "setListener " + interfaceC1003a);
        this.r = interfaceC1003a;
    }

    public void a(String str, String str2) {
        TextView textView;
        TextView textView2;
        if (!TextUtils.isEmpty(str) && (textView2 = this.f7998a) != null) {
            textView2.setText(str);
        }
        if (TextUtils.isEmpty(str2) || (textView = this.c) == null) {
            return;
        }
        textView.setText(str2);
    }
}
