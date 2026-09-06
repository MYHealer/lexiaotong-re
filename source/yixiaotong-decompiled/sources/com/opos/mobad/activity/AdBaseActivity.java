package com.opos.mobad.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.opos.cmn.i.g;
import com.opos.mobad.activity.webview.WebDataHepler;
import com.opos.mobad.cmn.a.e;
import com.opos.mobad.cmn.func.b.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class AdBaseActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.activity.webview.b f6587a;
    private com.opos.mobad.t.b b;
    private e c;

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        finish();
    }

    private void a(WebDataHepler webDataHepler, final com.opos.mobad.t.a aVar) {
        e eVar = new e(new com.opos.mobad.activity.webview.b.c() { // from class: com.opos.mobad.activity.AdBaseActivity.2
            @Override // com.opos.mobad.activity.webview.b.c
            public void a() {
                com.opos.mobad.t.a aVar2 = aVar;
                if (aVar2 != null) {
                    try {
                        aVar2.a(AdBaseActivity.this.b);
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("AdActivity", "show callback fail", e);
                    }
                }
            }

            @Override // com.opos.mobad.activity.webview.b.c
            public void b() {
                com.opos.mobad.t.a aVar2 = aVar;
                if (aVar2 != null) {
                    try {
                        aVar2.a();
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("AdActivity", "close callback fail", e);
                    }
                }
            }
        });
        this.c = eVar;
        eVar.a(this, webDataHepler.f(), webDataHepler.g());
    }

    private void b(com.opos.mobad.b bVar, WebDataHepler webDataHepler, com.opos.mobad.t.a aVar, com.opos.mobad.t.c cVar) {
        try {
            if (TextUtils.isEmpty(webDataHepler.d())) {
                com.opos.cmn.an.f.a.b("AdActivity", "data is null " + webDataHepler);
                a();
                return;
            }
            com.opos.mobad.activity.webview.b bVar2 = this.f6587a;
            if (bVar2 != null) {
                bVar2.d();
            }
            com.opos.mobad.activity.webview.b bVar3 = new com.opos.mobad.activity.webview.b(this, bVar, webDataHepler);
            this.f6587a = bVar3;
            bVar3.a();
            this.f6587a.a(new a(aVar, this.b, cVar));
            this.f6587a.a(aVar);
            this.f6587a.a(new com.opos.mobad.activity.webview.b.a() { // from class: com.opos.mobad.activity.AdBaseActivity.3
                @Override // com.opos.mobad.activity.webview.b.a
                public void a() {
                    AdBaseActivity.this.a();
                }
            });
            setContentView(this.f6587a.c());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdActivity", "initWebView", (Throwable) e);
        }
    }

    protected abstract void a(Intent intent);

    protected void a(com.opos.mobad.b bVar, Intent intent) {
        if (bVar == null) {
            a();
            com.opos.cmn.an.f.a.b("AdActivity", "context not init");
            return;
        }
        if (intent != null) {
            try {
                WebDataHepler webDataHepler = (WebDataHepler) intent.getParcelableExtra("webData");
                IBinder binder = intent.getExtras().getBinder("webCallback");
                IBinder binder2 = intent.getExtras().getBinder("videoCallback");
                com.opos.mobad.t.a aVarA = binder != null ? com.opos.mobad.t.a.AbstractBinderC0999a.a(binder) : null;
                com.opos.mobad.t.c cVarA = binder2 != null ? com.opos.mobad.t.c.a.a(binder2) : null;
                if (webDataHepler != null) {
                    a(bVar, webDataHepler, aVarA, cVarA);
                    return;
                } else {
                    com.opos.cmn.an.f.a.b("AdActivity", "data is null " + webDataHepler);
                    a();
                    return;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("AdActivity", "handleAction", (Throwable) e);
            }
        } else {
            com.opos.cmn.an.f.a.b("AdActivity", "handle but intent null");
        }
        a();
    }

    protected void a(com.opos.mobad.b bVar, WebDataHepler webDataHepler, com.opos.mobad.t.a aVar, com.opos.mobad.t.c cVar) {
        if (com.opos.mobad.cmn.service.a.a().b() == null) {
            a();
            com.opos.cmn.an.f.a.b("AdActivity", "handle but not init");
            return;
        }
        int iF = webDataHepler.f();
        if (iF == 1 || iF == 2) {
            h.a(this, "#F5EEEEEE");
            b(bVar, webDataHepler, aVar, cVar);
        } else if (iF == 3 || iF == 4 || iF == 5) {
            a(webDataHepler, aVar);
        } else {
            a();
        }
        com.opos.cmn.an.f.a.a("AdActivity", webDataHepler);
    }

    public void b(Intent intent) {
        com.opos.cmn.an.f.a.b("AdActivity", "reInitWebView");
        com.opos.mobad.activity.webview.b bVar = this.f6587a;
        if (bVar != null) {
            bVar.d();
        }
        a(intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.opos.cmn.an.f.a.b("AdActivity", "onConfigurationChanged newConfig=" + configuration.toString());
        com.opos.mobad.activity.webview.b bVar = this.f6587a;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        h.a(this);
        g.b(this);
        super.onCreate(bundle);
        this.b = new com.opos.mobad.t.b.a() { // from class: com.opos.mobad.activity.AdBaseActivity.1
            @Override // com.opos.mobad.t.b
            public void a() throws RemoteException {
                AdBaseActivity.this.a();
            }
        };
        com.opos.cmn.an.f.a.b("AdActivity", "onCreate");
        a(getIntent());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.opos.cmn.an.f.a.b("AdActivity", "onDestroy");
        com.opos.mobad.activity.webview.b bVar = this.f6587a;
        if (bVar != null) {
            bVar.d();
        }
        e eVar = this.c;
        if (eVar != null) {
            eVar.a();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.opos.cmn.an.f.a.b("AdActivity", "onKeyDown");
        com.opos.mobad.activity.webview.b bVar = this.f6587a;
        if (bVar != null && bVar.a(i, keyEvent)) {
            return true;
        }
        e eVar = this.c;
        if (eVar == null || !eVar.a(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.opos.cmn.an.f.a.b("AdActivity", "onNewIntent");
        setIntent(intent);
        b(intent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.opos.cmn.an.f.a.b("AdActivity", "onPause");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        com.opos.cmn.an.f.a.b("AdActivity", "onStart");
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.opos.cmn.an.f.a.b("AdActivity", "onStop");
    }
}
