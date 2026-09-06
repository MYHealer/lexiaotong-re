package com.opos.mobad.video.player.e;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.heytap.msp.mobad.api.R;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d implements com.opos.mobad.video.player.c.a.a.InterfaceC1034a, com.opos.mobad.video.player.c.a.a.b, com.opos.mobad.video.player.c.a.a.c, com.opos.mobad.video.player.c.a.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f8397a;
    private final a b;
    private com.opos.mobad.video.player.c.a.a.c.InterfaceC1035a c;
    private WebView d;
    private final Context e;
    private com.opos.mobad.video.player.c.a.a.d.InterfaceC1036a f;
    private com.opos.mobad.video.player.c.a.a.b g;

    public d(Context context, b bVar, a aVar) {
        this.f8397a = bVar;
        this.b = aVar;
        this.e = context;
        h();
    }

    private void a(final com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> aVar) {
        FrameLayout frameLayoutA;
        if (aVar == null || (frameLayoutA = aVar.a()) == null) {
            return;
        }
        int iA = com.opos.cmn.an.h.f.a.a(this.e, 20.0f);
        ImageView imageView = new ImageView(this.e);
        imageView.setImageResource(R.drawable.opos_mob_drawable_light_close);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 5;
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.e, 49.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.e, 16.0f);
        frameLayoutA.addView(imageView, layoutParams);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.video.player.e.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.opos.mobad.template.a aVar2;
                aVar.b();
                if (d.this.f8397a == null || (aVar2 = d.this.f8397a.f8385a) == null) {
                    return;
                }
                aVar2.b();
            }
        });
    }

    private void h() {
        com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> aVar;
        b bVar = this.f8397a;
        if (bVar == null || (aVar = bVar.i) == null) {
            return;
        }
        a(aVar);
        aVar.a((com.opos.mobad.video.player.c.a.a.c) this);
        aVar.a((com.opos.mobad.video.player.c.a.a.d) this);
        aVar.a((com.opos.mobad.video.player.c.a.a.InterfaceC1034a) this);
        aVar.a((com.opos.mobad.video.player.c.a.a.b) this);
    }

    private WebView i() {
        WebView webView = this.d;
        if (webView != null) {
            return webView;
        }
        WebView webViewA = com.opos.mobad.video.player.c.c.a(this.e, (com.opos.cmn.biz.web.b.a.a.a) null, (Map<String, Object>) null, new com.opos.mobad.video.player.c.c.a() { // from class: com.opos.mobad.video.player.e.d.2
            @Override // com.opos.mobad.video.player.c.c.a
            public void a() {
                if (d.this.f != null) {
                    d.this.f.d();
                }
            }

            @Override // com.opos.mobad.video.player.c.c.a
            public void b() {
                if (d.this.f != null) {
                    d.this.f.e();
                }
            }

            @Override // com.opos.mobad.video.player.c.c.a
            public void c() {
                if (d.this.f != null) {
                    d.this.f.e();
                }
            }
        });
        this.d = webViewA;
        return webViewA;
    }

    @Override // com.opos.mobad.video.player.c.a.a.InterfaceC1034a
    public void a() {
    }

    public void a(int i, String str) {
        com.opos.mobad.video.player.c.a.a.c.InterfaceC1035a interfaceC1035a = this.c;
        if (interfaceC1035a != null) {
            interfaceC1035a.c();
        }
    }

    @Override // com.opos.mobad.video.player.c.a.a.InterfaceC1034a
    public void a(int i, int[] iArr) {
        b bVar;
        com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> aVar;
        if (this.b == null || (bVar = this.f8397a) == null || (aVar = bVar.i) == null) {
            return;
        }
        this.b.a(aVar.a(), iArr, com.opos.mobad.cmn.func.b.a.LIGHT_INTERACTIVE);
    }

    public void a(long j, long j2) {
        com.opos.mobad.video.player.c.a.a.c.InterfaceC1035a interfaceC1035a = this.c;
        if (interfaceC1035a != null) {
            interfaceC1035a.a(j, j2);
        }
    }

    public void a(com.opos.mobad.video.player.c.a.a.b bVar) {
        this.g = bVar;
    }

    @Override // com.opos.mobad.video.player.c.a.a.c
    public void a(com.opos.mobad.video.player.c.a.a.c.InterfaceC1035a interfaceC1035a) {
        this.c = interfaceC1035a;
    }

    @Override // com.opos.mobad.video.player.c.a.a.d
    public void a(com.opos.mobad.video.player.c.a.a.d.InterfaceC1036a interfaceC1036a) {
        this.f = interfaceC1036a;
    }

    @Override // com.opos.mobad.video.player.c.a.a.d
    public void a(Object obj, String str) {
        try {
            i().addJavascriptInterface(obj, str);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("TTLightController", "addJavascriptInterface", th);
        }
    }

    @Override // com.opos.mobad.video.player.c.a.a.d
    public void a(String str) {
        i().loadUrl(str);
    }

    @Override // com.opos.mobad.video.player.c.a.a.InterfaceC1034a
    public void b() {
    }

    public void b(long j, long j2) {
        com.opos.mobad.video.player.c.a.a.c.InterfaceC1035a interfaceC1035a = this.c;
        if (interfaceC1035a != null) {
            interfaceC1035a.b(j, j2);
        }
    }

    @Override // com.opos.mobad.video.player.c.a.a.d
    public void b(String str) {
        i().evaluateJavascript(str, null);
    }

    public void c(long j, long j2) {
        com.opos.mobad.video.player.c.a.a.c.InterfaceC1035a interfaceC1035a = this.c;
        if (interfaceC1035a != null) {
            interfaceC1035a.c(j, j2);
        }
    }

    @Override // com.opos.mobad.video.player.c.a.a.b
    public boolean c() {
        com.opos.mobad.video.player.c.a.a.b bVar = this.g;
        return bVar != null && bVar.c();
    }

    @Override // com.opos.mobad.video.player.c.a.a.c
    public void d() {
        com.opos.mobad.template.a aVar;
        b bVar = this.f8397a;
        if (bVar == null || (aVar = bVar.f8385a) == null) {
            return;
        }
        aVar.b();
    }

    @Override // com.opos.mobad.video.player.c.a.a.c
    public void e() {
        com.opos.mobad.template.a aVar;
        b bVar = this.f8397a;
        if (bVar == null || (aVar = bVar.f8385a) == null) {
            return;
        }
        aVar.a();
    }

    @Override // com.opos.mobad.video.player.c.a.a.d
    public View f() {
        return i();
    }

    @Override // com.opos.mobad.video.player.c.a.a.d
    public void g() {
        i().destroy();
    }
}
