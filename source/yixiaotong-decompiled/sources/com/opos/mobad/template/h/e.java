package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n f8067a;
    private com.opos.mobad.template.cmn.n b;
    private RelativeLayout c;
    private LinearLayout d;
    private TextView e;
    private TextView f;
    private boolean g;
    private com.opos.mobad.template.a.f h;
    private com.opos.mobad.template.k.c i;
    private com.opos.mobad.d.a j;
    private com.opos.mobad.template.a.c l;
    private boolean m;
    private boolean n;
    private boolean o;
    private com.opos.mobad.template.a.InterfaceC1003a p;

    public e(Context context, boolean z, boolean z2, com.opos.mobad.d.a aVar) {
        super(context);
        this.g = false;
        this.o = false;
        this.m = z;
        this.n = z2;
        this.j = aVar;
        a(context);
    }

    public static e a(Context context, boolean z, boolean z2, com.opos.mobad.d.a aVar) {
        return new e(context, z, z2, aVar);
    }

    private void a(Context context) {
        setBackgroundResource(R.drawable.opos_mobad_drawable_reward_bottom_bg);
        if (this.m) {
            int iA = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
            int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
            setPadding(iA, iA2, iA, iA2);
        } else {
            int iA3 = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
            setPadding(iA3, iA3, iA3, iA3);
        }
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.c = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        int iA4 = com.opos.cmn.an.h.f.a.a(getContext(), 0.33f);
        this.c.setPadding(iA4, iA4, iA4, iA4);
        this.c.setBackgroundResource(R.drawable.opos_mobad_drawable_block_icon_stroke);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 42.0f), com.opos.cmn.an.h.f.a.a(getContext(), 42.0f));
        layoutParams.addRule(15);
        this.c.setVisibility(0);
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
        this.b = nVar;
        nVar.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        n nVarA = n.a(context, "", this.m);
        this.f8067a = nVarA;
        nVarA.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        b();
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams4.addRule(1, this.c.getId());
        layoutParams4.addRule(0, this.f8067a.getId());
        this.c.addView(this.b, layoutParams2);
        addView(this.c, layoutParams);
        addView(this.f8067a, layoutParams3);
        addView(this.d, layoutParams4);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.e.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (e.this.g || e.this.p == null) {
                    return;
                }
                e.this.p.h(view, iArr);
            }
        };
        setOnClickListener(pVar);
        setOnTouchListener(pVar);
        a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.e.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                if (e.this.g || e.this.p == null) {
                    return;
                }
                e.this.p.a(view, i, z);
            }
        });
    }

    private void a(com.opos.mobad.template.d.e eVar, com.opos.mobad.d.a aVar) {
        this.b.setScaleType(ImageView.ScaleType.FIT_XY);
        if (eVar == null) {
            com.opos.cmn.an.f.a.b("RewardBottomAreaView", "iconUrl is null");
        } else {
            if (this.o) {
                return;
            }
            this.o = true;
            int iA = com.opos.cmn.an.h.f.a.a(getContext(), 42.0f);
            aVar.a(eVar.f7535a, eVar.b, iA, iA, new com.opos.mobad.d.a.InterfaceC0955a() { // from class: com.opos.mobad.template.h.e.3
                @Override // com.opos.mobad.d.a.InterfaceC0955a
                public void a(int i, final Bitmap bitmap) {
                    if (e.this.g) {
                        return;
                    }
                    if (i != 0 && i != 1) {
                        if (e.this.p != null) {
                            e.this.p.c(i);
                        }
                    } else {
                        if (i == 1 && e.this.p != null) {
                            e.this.p.c(i);
                        }
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.h.e.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap bitmap2;
                                if (e.this.g || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                                    return;
                                }
                                e.this.b.setImageBitmap(bitmap);
                            }
                        });
                    }
                }
            });
        }
    }

    private void b() {
        View view;
        TextView textView;
        int color;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.d = linearLayout;
        linearLayout.setOrientation(1);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        relativeLayout.setGravity(16);
        TextView textView2 = new TextView(getContext());
        this.e = textView2;
        textView2.setId(View.generateViewId());
        if (this.m) {
            this.e.setTextColor(Color.parseColor("#E6000000"));
        } else {
            this.e.setTextColor(-1);
        }
        this.e.setTextSize(1, 14.0f);
        this.e.setMaxEms(7);
        this.e.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.e.setSingleLine(true);
        TextPaint paint = this.e.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        int alphaComponent = this.m ? ColorUtils.setAlphaComponent(-16777216, 102) : ColorUtils.setAlphaComponent(Color.parseColor("#42464C"), MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        layoutParams3.addRule(15);
        layoutParams3.addRule(1, this.e.getId());
        relativeLayout.addView(this.e, layoutParams2);
        if (this.n) {
            this.i = this.m ? com.opos.mobad.template.k.c.a(getContext(), 2, 0, this.j) : com.opos.mobad.template.k.c.a(getContext(), 0, 0, this.j);
            view = this.i;
        } else {
            com.opos.mobad.template.a.f fVarA = com.opos.mobad.template.a.f.a(getContext(), alphaComponent, this.j);
            this.h = fVarA;
            view = fVarA;
        }
        relativeLayout.addView(view, layoutParams3);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        TextView textView3 = new TextView(getContext());
        this.f = textView3;
        textView3.setTextSize(1, 10.0f);
        this.f.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f.setSingleLine(true);
        this.f.setVisibility(8);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        if (this.m) {
            this.l = new com.opos.mobad.template.a.c(getContext(), Color.parseColor("#66000000"));
            textView = this.f;
            color = Color.parseColor("#66000000");
        } else {
            this.l = new com.opos.mobad.template.a.c(getContext());
            textView = this.f;
            color = Color.parseColor("#66FFFFFF");
        }
        textView.setTextColor(color);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams6.addRule(5);
        this.l.setGravity(3);
        this.l.setVisibility(8);
        relativeLayout2.addView(this.f, layoutParams5);
        relativeLayout2.addView(this.l, layoutParams6);
        this.d.addView(relativeLayout, layoutParams);
        this.d.addView(relativeLayout2, layoutParams4);
    }

    public void a() {
        this.g = true;
    }

    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        com.opos.cmn.an.f.a.b("RewardBottomAreaView", "setListener " + interfaceC1003a);
        this.p = interfaceC1003a;
        this.f8067a.a(interfaceC1003a);
        if (this.n) {
            this.i.a(interfaceC1003a);
        } else {
            this.h.a(interfaceC1003a);
        }
        this.l.a(interfaceC1003a);
    }

    public void a(com.opos.mobad.template.d.b bVar) {
        com.opos.mobad.template.d.a aVar = bVar.u;
        if (aVar == null || TextUtils.isEmpty(aVar.f7533a) || TextUtils.isEmpty(aVar.b)) {
            this.f.setVisibility(0);
            return;
        }
        com.opos.mobad.template.a.c cVar = this.l;
        if (cVar != null) {
            cVar.setVisibility(0);
            this.l.a(aVar.f7533a, aVar.b);
        }
    }

    public void a(com.opos.mobad.template.d.e eVar, String str, String str2, String str3, com.opos.mobad.d.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            this.f8067a.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.e.setText(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.f.setText(str3);
        }
        if (eVar != null && !TextUtils.isEmpty(eVar.f7535a)) {
            this.c.setVisibility(0);
            a(eVar, aVar);
            return;
        }
        this.c.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.width = -1;
        this.d.setLayoutParams(layoutParams);
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.template.d.e eVar, com.opos.mobad.template.d.e eVar2, com.opos.mobad.template.d.e eVar3, String str2) {
        if (!this.n) {
            this.h.a(z, str, z2, eVar2, str2);
        } else if (this.m) {
            this.i.a(z, z2, eVar2, eVar3, str2);
        } else {
            this.i.a(z, z2, eVar, str2);
        }
    }
}
