package com.opos.mobad.video.player.g.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.cmn.func.b.h;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f8404a;
    protected TextView c;
    protected TextView d;
    protected com.opos.cmn.module.ui.a.c e;
    protected TextView f;
    protected TextView g;
    protected RelativeLayout h;
    protected RelativeLayout i;
    protected com.opos.mobad.template.a.c j;
    protected View k;
    protected com.opos.mobad.template.a.InterfaceC1003a l;
    protected com.opos.mobad.video.player.g.a m;
    protected e n;
    protected int o;
    protected int p;
    protected int q;
    protected int r;
    protected com.opos.mobad.template.d.d s;
    protected com.opos.mobad.d.a t;
    private int x;
    protected int[] b = new int[4];
    protected volatile boolean u = false;
    protected com.opos.mobad.video.player.g.a.InterfaceC1041a v = new com.opos.mobad.video.player.g.a.InterfaceC1041a() { // from class: com.opos.mobad.video.player.g.a.a.3
        @Override // com.opos.mobad.video.player.g.a.InterfaceC1041a
        public void a() {
            com.opos.cmn.an.f.a.b("BaseFloatLayerView", "end to scale");
            if (a.this.n != null) {
                a.this.n.b();
            }
            if (a.this.m != null) {
                a.this.m.a();
            }
        }

        @Override // com.opos.mobad.video.player.g.a.InterfaceC1041a
        public void a(boolean z) {
        }

        @Override // com.opos.mobad.video.player.g.a.InterfaceC1041a
        public void b() {
            com.opos.cmn.an.f.a.b("BaseFloatLayerView", "start to scale");
            if (a.this.n != null) {
                a.this.n.a();
            }
        }
    };
    protected com.opos.mobad.ui.c.e.a w = new com.opos.mobad.ui.c.e.a() { // from class: com.opos.mobad.video.player.g.a.a.4
        @Override // com.opos.mobad.ui.c.e.a
        public boolean a() {
            return a.this.u;
        }
    };

    public a(Context context, int i, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, com.opos.mobad.d.a aVar) {
        this.f8404a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.l = interfaceC1003a;
        this.x = i;
        this.t = aVar;
        f();
        g();
        k();
    }

    private void k() {
        com.opos.mobad.video.player.g.a aVar = new com.opos.mobad.video.player.g.a(this.f8404a);
        this.m = aVar;
        aVar.a(this.v);
        this.i.addView(this.m);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
    }

    protected void a(View view) {
        if (view != null) {
            try {
                view.setOnTouchListener(null);
                view.setOnClickListener(null);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("BaseFloatLayerView", "", (Throwable) e);
            }
        }
    }

    protected void a(View view, final com.opos.mobad.cmn.func.b.a aVar) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.module.ui.a.b(this.b));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.video.player.g.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.l != null) {
                        if (aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT) {
                            a.this.l.j(view2, a.this.b);
                        } else {
                            a.this.l.i(view2, a.this.b);
                        }
                    }
                }
            });
        }
    }

    protected void a(TextView textView) {
        if (textView != null) {
            TextPaint paint = textView.getPaint();
            paint.setStrokeWidth(0.8f);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
    }

    protected void a(TextView textView, String str) {
        if (textView != null) {
            if (com.opos.cmn.an.d.a.a(str)) {
                str = "";
            }
            textView.setText(str);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        this.l = interfaceC1003a;
    }

    protected void a(String str) {
        a(this.c, str);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        this.u = true;
        this.i.removeAllViews();
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.x;
    }

    protected void f() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f8404a);
        this.i = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor("#c0000000"));
        this.i.setClickable(true);
        this.i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.h = new RelativeLayout(this.f8404a);
        this.o = h.a();
        this.p = h.a();
        this.q = h.a();
        this.r = h.a();
    }

    public abstract void g();

    protected void h() {
        if (this.s != null) {
            return;
        }
        TextView textView = new TextView(this.f8404a);
        this.d = textView;
        textView.setGravity(17);
        h.a(this.d, com.opos.cmn.an.e.a.a.c(this.f8404a, "opos_module_biz_ui_reward_video_float_layer_close_bn.png"));
        this.i.addView(this.d, i());
    }

    public abstract RelativeLayout.LayoutParams i();

    protected void j() {
        this.d.setOnTouchListener(new com.opos.cmn.module.ui.a.b(this.b));
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.video.player.g.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.l != null) {
                    a.this.l.e(view, a.this.b);
                }
            }
        });
    }
}
