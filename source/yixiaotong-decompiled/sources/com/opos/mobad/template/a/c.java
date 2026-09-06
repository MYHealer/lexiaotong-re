package com.opos.mobad.template.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.p;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinearLayout f7403a;
    private TextView b;
    private TextView c;
    private com.opos.mobad.template.a.InterfaceC1003a d;
    private int e;
    private int f;
    private String g;

    public c(Context context) {
        super(context);
        this.g = "#66FFFFFF";
        a();
    }

    public c(Context context, int i) {
        this(context, i, i);
    }

    public c(Context context, int i, int i2) {
        super(context);
        this.g = "#66FFFFFF";
        this.e = i;
        this.f = i2;
        a();
    }

    public c(Context context, String str) {
        super(context);
        this.g = str;
        a();
    }

    private String a(String str) {
        String str2;
        String strSubstring;
        String str3;
        String[] strArrSplit = str.split("\\.");
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            if (!strArrSplit[i2].isEmpty()) {
                int length = strArrSplit[i2].length() + i;
                int i3 = 3;
                if (length > 3) {
                    if (i2 == 0) {
                        str2 = strArrSplit[i2];
                    } else {
                        str2 = strArrSplit[i2];
                        i3 = 3 - i;
                    }
                    strSubstring = str2.substring(0, i3);
                } else {
                    int length2 = strArrSplit.length - 1;
                    if (length != 3) {
                        if (i2 != length2) {
                            sb.append(strArrSplit[i2]).append(".");
                        } else {
                            str3 = strArrSplit[i2];
                        }
                        i = length;
                    } else if (i2 == length2) {
                        str3 = strArrSplit[i2];
                    } else {
                        strSubstring = strArrSplit[i2];
                    }
                    sb.append(str3);
                    i = length;
                }
                sb.append(strSubstring).append("...");
                break;
            }
        }
        return sb.toString();
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f7403a = linearLayout;
        linearLayout.setOrientation(0);
        TextView textView = new TextView(getContext());
        textView.setTextSize(1, 10.0f);
        int color = this.e;
        if (color == 0) {
            color = Color.parseColor(this.g);
        }
        textView.setTextColor(color);
        textView.setText(R.string.mobad_core_privacy);
        textView.setGravity(17);
        p pVar = new p() { // from class: com.opos.mobad.template.a.c.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (c.this.d != null) {
                    c.this.d.b(view, iArr);
                }
            }
        };
        textView.setOnTouchListener(pVar);
        textView.setOnClickListener(pVar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams.gravity = 16;
        this.f7403a.addView(textView, layoutParams);
        TextView textView2 = new TextView(getContext());
        int color2 = this.f;
        if (color2 == 0) {
            color2 = Color.parseColor(this.g);
        }
        textView2.setBackgroundColor(color2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 0.66f), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.67f);
        this.f7403a.addView(textView2, layoutParams2);
        TextView textView3 = new TextView(getContext());
        textView3.setTextSize(1, 10.0f);
        int color3 = this.e;
        if (color3 == 0) {
            color3 = Color.parseColor(this.g);
        }
        textView3.setTextColor(color3);
        textView3.setGravity(17);
        textView3.setText(R.string.mobad_core_permissions);
        p pVar2 = new p() { // from class: com.opos.mobad.template.a.c.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (c.this.d != null) {
                    c.this.d.c(view, iArr);
                }
            }
        };
        textView3.setOnTouchListener(pVar2);
        textView3.setOnClickListener(pVar2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams3.gravity = 16;
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.67f);
        this.f7403a.addView(textView3, layoutParams3);
        TextView textView4 = new TextView(getContext());
        int color4 = this.f;
        if (color4 == 0) {
            color4 = Color.parseColor(this.g);
        }
        textView4.setBackgroundColor(color4);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 0.66f), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.67f);
        this.f7403a.addView(textView4, layoutParams4);
        TextView textView5 = new TextView(getContext());
        textView5.setTextSize(1, 10.0f);
        int color5 = this.e;
        if (color5 == 0) {
            color5 = Color.parseColor(this.g);
        }
        textView5.setTextColor(color5);
        textView5.setText(R.string.mobad_core_introduce);
        textView5.setGravity(17);
        p pVar3 = new p() { // from class: com.opos.mobad.template.a.c.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (c.this.d != null) {
                    c.this.d.d(view, iArr);
                }
            }
        };
        textView5.setOnTouchListener(pVar3);
        textView5.setOnClickListener(pVar3);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams5.gravity = 16;
        layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.67f);
        this.f7403a.addView(textView5, layoutParams5);
        TextView textView6 = new TextView(getContext());
        int color6 = this.f;
        if (color6 == 0) {
            color6 = Color.parseColor(this.g);
        }
        textView6.setBackgroundColor(color6);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 0.66f), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        layoutParams6.gravity = 16;
        layoutParams6.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.67f);
        this.f7403a.addView(textView6, layoutParams6);
        TextView textView7 = new TextView(getContext());
        this.c = textView7;
        textView7.setId(View.generateViewId());
        TextView textView8 = this.c;
        int color7 = this.e;
        if (color7 == 0) {
            color7 = Color.parseColor(this.g);
        }
        textView8.setTextColor(color7);
        this.c.setTextSize(1, 10.0f);
        this.c.setSingleLine();
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams7.gravity = 16;
        layoutParams7.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.67f);
        this.f7403a.addView(this.c, layoutParams7);
        TextView textView9 = new TextView(getContext());
        int color8 = this.f;
        if (color8 == 0) {
            color8 = Color.parseColor(this.g);
        }
        textView9.setBackgroundColor(color8);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 0.66f), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        layoutParams8.gravity = 16;
        layoutParams8.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.67f);
        this.f7403a.addView(textView9, layoutParams8);
        TextView textView10 = new TextView(getContext());
        this.b = textView10;
        int color9 = this.e;
        if (color9 == 0) {
            color9 = Color.parseColor(this.g);
        }
        textView10.setTextColor(color9);
        this.b.setTextSize(1, 10.0f);
        this.b.setSingleLine();
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams9.gravity = 16;
        layoutParams9.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.67f);
        this.f7403a.addView(this.b, layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams10.addRule(13);
        addView(this.f7403a, layoutParams10);
    }

    private String b(String str) {
        String str2;
        String str3;
        String[] strArrSplit = str.split("\\.");
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        int i2 = 0;
        while (i < strArrSplit.length) {
            if (!strArrSplit[i].isEmpty()) {
                int length = strArrSplit[i].length() + i2;
                int i3 = 3;
                if (length > 3) {
                    if (i == 0) {
                        str2 = strArrSplit[i];
                    } else {
                        str2 = strArrSplit[i];
                        i3 = 3 - i2;
                    }
                    sb.append(str2.substring(0, i3));
                    break;
                }
                if (length == 3) {
                    str3 = i == 0 ? strArrSplit[i] : strArrSplit[i];
                } else {
                    if (i != strArrSplit.length - 1) {
                        sb.append(strArrSplit[i]).append(".");
                    } else {
                        str3 = strArrSplit[i];
                    }
                    i2 = length;
                }
                sb.append(str3);
                i2 = length;
            }
            i++;
        }
        return sb.toString();
    }

    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        this.d = interfaceC1003a;
    }

    public void a(String str, String str2) {
        this.c.setText(ExifInterface.GPS_MEASUREMENT_INTERRUPTED + a(str));
        this.b.setText(str2);
    }

    public void b(String str, String str2) {
        this.c.setMaxEms(3);
        this.c.setText(ExifInterface.GPS_MEASUREMENT_INTERRUPTED + b(str));
        this.b.setText(str2);
    }
}
