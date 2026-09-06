package com.opos.mobad.video.player.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;
import com.opos.mobad.cmn.func.b.e;
import com.opos.mobad.model.data.InteractiveData;
import com.opos.mobad.model.utils.AdHelper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InteractiveData f8340a;
    private com.opos.mobad.b b;
    private WebView c;
    private AdHelper.a d;
    private InterfaceC1033a e;
    private boolean f = false;

    /* JADX INFO: renamed from: com.opos.mobad.video.player.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC1033a {
        void a();

        void b();
    }

    public a(com.opos.mobad.b bVar, AdHelper.a aVar, InteractiveData interactiveData) {
        this.b = bVar;
        this.d = aVar;
        this.f8340a = interactiveData;
        h();
    }

    private void e() {
        WebView webView = this.c;
        if (webView != null) {
            webView.removeAllViews();
            this.c.stopLoading();
            this.c.getSettings().setJavaScriptEnabled(false);
            this.c.getSettings().setSavePassword(false);
            this.c.clearHistory();
            this.c.destroyDrawingCache();
            this.c.destroy();
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (TextUtils.isEmpty(this.f8340a.d)) {
            return;
        }
        com.opos.mobad.s.a.a(this.b.b(), this.f8340a.d);
        Toast.makeText(this.b.b(), "礼包码已复制，打开应用领取吧！", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.video.player.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f) {
                    return;
                }
                a.this.c();
            }
        });
    }

    private void h() {
        HashMap map = new HashMap();
        map.put("interactiveAd", new b(this.f8340a.a(), new b.a() { // from class: com.opos.mobad.video.player.c.a.2
            @Override // com.opos.mobad.video.player.c.b.a
            public boolean a() {
                com.opos.cmn.an.f.a.b("ad_show", "interactive click");
                if (a.this.f) {
                    return false;
                }
                if (a.this.e != null) {
                    a.this.e.a();
                }
                a.this.f();
                a.this.g();
                return true;
            }

            @Override // com.opos.mobad.video.player.c.b.a
            public boolean a(Map<String, String> map2) {
                if (a.this.f) {
                    return false;
                }
                com.opos.cmn.an.f.a.b("ad_show", "interactive report");
                e.a(a.this.b, a.this.d.c.g(), a.this.d.c, a.this.d.d, String.valueOf(a.this.f8340a.c), map2);
                return true;
            }

            @Override // com.opos.mobad.video.player.c.b.a
            public void b() {
                com.opos.cmn.an.f.a.b("ad_show", "interactive transform");
                if (a.this.f || a.this.e == null) {
                    return;
                }
                a.this.e.b();
            }

            @Override // com.opos.mobad.video.player.c.b.a
            public boolean c() {
                com.opos.cmn.an.f.a.b("ad_show", "interactive onClose");
                if (a.this.f) {
                    return false;
                }
                a.this.g();
                return true;
            }
        }));
        WebView webViewA = c.a(this.b.b(), (com.opos.cmn.biz.web.b.a.a.a) null, map, new c.a() { // from class: com.opos.mobad.video.player.c.a.3
            @Override // com.opos.mobad.video.player.c.c.a
            public void a() {
            }

            @Override // com.opos.mobad.video.player.c.c.a
            public void b() {
                a.this.c();
            }

            @Override // com.opos.mobad.video.player.c.c.a
            public void c() {
                a.this.c();
            }
        });
        this.c = webViewA;
        webViewA.setBackgroundColor(0);
        this.c.setLayerType(1, null);
    }

    public View a() {
        return this.c;
    }

    public void a(Activity activity) {
        if (this.f) {
            return;
        }
        this.c.loadUrl("https://adsfs.heytapimage.com/mp/static/light-interactive/index.html?templateId=" + this.f8340a.c);
        this.c.setVisibility(0);
        e.a(this.b, this.d.c.g(), this.d.c, this.d.d, String.valueOf(this.f8340a.c));
    }

    public void a(InterfaceC1033a interfaceC1033a) {
        this.e = interfaceC1033a;
    }

    public boolean b() {
        if (!c()) {
            return false;
        }
        e.b(this.b, this.d.c.g(), this.d.c, this.d.d, String.valueOf(this.f8340a.c));
        return true;
    }

    public boolean c() {
        if (this.f || this.c.getVisibility() != 0) {
            return false;
        }
        this.c.setVisibility(8);
        return true;
    }

    public void d() {
        c();
        this.f = true;
        e();
        this.e = null;
    }
}
