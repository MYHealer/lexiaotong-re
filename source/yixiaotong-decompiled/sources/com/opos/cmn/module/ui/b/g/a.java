package com.opos.cmn.module.ui.b.g;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import com.opos.cmn.i.g;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6212a;
    private com.opos.cmn.module.ui.b.e.a b;
    private Activity c;

    public a(Activity activity, int i, com.opos.cmn.module.ui.b.e.a aVar) {
        super(activity, i);
        this.f6212a = true;
        this.c = activity;
        this.b = aVar;
    }

    public a(Activity activity, com.opos.cmn.module.ui.b.e.a aVar) {
        super(activity);
        this.f6212a = true;
        this.c = activity;
        this.b = aVar;
    }

    private void a() {
        com.opos.cmn.module.ui.b.e.a aVar = this.b;
        if (aVar != null) {
            setCancelable(aVar.b);
            setCanceledOnTouchOutside(this.b.c);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f6212a) {
            com.opos.cmn.an.f.a.a("", "dialog has detach do not dismiss");
        } else {
            super.dismiss();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f6212a = false;
        com.opos.cmn.an.f.a.b("", "dialog onAttachedToWindow");
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f6212a = true;
        com.opos.cmn.an.f.a.b("", "dialog onDetachedFromWindow");
    }

    @Override // android.app.Dialog
    public void show() {
        Activity activity = this.c;
        if (activity == null || activity.isFinishing() || this.c.isDestroyed()) {
            com.opos.cmn.an.f.a.b("", "show but activity has destroy");
        } else {
            g.a(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), getWindow());
            super.show();
        }
    }
}
