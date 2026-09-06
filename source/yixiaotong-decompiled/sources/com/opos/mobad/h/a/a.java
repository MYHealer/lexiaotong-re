package com.opos.mobad.h.a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import com.opos.cmn.i.g;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Boolean f7019a;
    private Activity b;

    public a(Activity activity, int i) {
        super(activity, i);
        this.f7019a = null;
        this.b = activity;
    }

    private void a() {
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Boolean bool = this.f7019a;
        if (bool == null || !bool.booleanValue()) {
            super.dismiss();
        } else {
            com.opos.cmn.an.f.a.a("", "dialog has detach do not dismiss");
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7019a = false;
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
        this.f7019a = true;
        com.opos.cmn.an.f.a.b("", "dialog onDetachedFromWindow");
    }

    @Override // android.app.Dialog
    public void show() {
        Activity activity = this.b;
        if (activity == null || activity.isFinishing() || this.b.isDestroyed()) {
            com.opos.cmn.an.f.a.b("", "show but activity has destroy");
        } else {
            g.a(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), getWindow());
            super.show();
        }
    }
}
