package com.opos.cmn.biz.web.base.activity.api;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.opos.cmn.biz.web.b.a.a;
import com.opos.cmn.biz.web.b.a.a.b;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class BaseWebActivity extends Activity implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f6052a;
    private String b;
    private boolean c = false;
    private ViewGroup d;

    private void b(Intent intent) {
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("loadUrl");
                this.b = stringExtra;
                if (TextUtils.isEmpty(stringExtra)) {
                    e();
                } else {
                    b();
                    d();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("AdActivity", "handleAction", e);
                e();
            }
        }
    }

    private void d() {
        try {
            com.opos.cmn.an.f.a.b("AdActivity", "showWebView url:" + this.b);
            if (com.opos.cmn.an.d.a.a(this.b)) {
                return;
            }
            this.d = (ViewGroup) getWindow().getDecorView().findViewById(R.id.content);
            if (this.f6052a.b() != null && this.f6052a.b().getParent() == null) {
                this.d.addView(this.f6052a.b(), new RelativeLayout.LayoutParams(-1, -1));
            }
            this.f6052a.a(this.b);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AdActivity", "showWebView", e);
        }
    }

    private void e() {
        finish();
    }

    protected abstract Map<String, Object> a();

    public void a(Intent intent) {
        com.opos.cmn.an.f.a.b("AdActivity", "reInitWebView");
        a aVar = this.f6052a;
        if (aVar != null) {
            aVar.e();
            b(intent);
        }
    }

    public void b() {
        if (this.c) {
            return;
        }
        try {
            com.opos.cmn.biz.web.base.activity.a.a.a.a(this);
            com.opos.cmn.biz.web.base.activity.a.a.a.b(this);
            this.f6052a = new a(this, new com.opos.cmn.biz.web.b.a.b.a().a(this).a(a()).a(true).a());
            this.c = true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AdActivity", "initWebView", e);
        }
    }

    @Override // com.opos.cmn.biz.web.b.a.a.b
    public void c() {
        com.opos.cmn.an.f.a.b("AdActivity", "onWebViewClose");
        e();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.opos.cmn.an.f.a.b("AdActivity", "onCreate");
        b(getIntent());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.opos.cmn.an.f.a.b("AdActivity", "onDestroy");
        com.opos.cmn.an.f.a.b("AdActivity", "closeWebWidget");
        a aVar = this.f6052a;
        if (aVar != null && aVar.b() != null) {
            this.d.removeView(this.f6052a.b());
        }
        a aVar2 = this.f6052a;
        if (aVar2 != null) {
            aVar2.a();
        }
        this.f6052a = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        a aVar;
        com.opos.cmn.an.f.a.b("AdActivity", "onKeyDown");
        if (i != 4 || keyEvent.getAction() != 0 || (aVar = this.f6052a) == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (!aVar.c() && this.f6052a.d()) {
            return true;
        }
        c();
        return true;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.opos.cmn.an.f.a.b("AdActivity", "onNewIntent");
        setIntent(intent);
        a(intent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.opos.cmn.an.f.a.b("AdActivity", "onPause");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        com.opos.cmn.an.f.a.b("AdActivity", "onResume");
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
