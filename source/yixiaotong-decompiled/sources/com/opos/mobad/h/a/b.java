package com.opos.mobad.h.a;

import android.R;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import org.videolan.libvlc.MediaDiscoverer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements DialogInterface.OnKeyListener, DialogInterface.OnShowListener, com.opos.mobad.video.player.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f7020a;
    private Activity b;
    private com.opos.mobad.video.player.b.a c;

    private void a(Activity activity) {
        a aVar = this.f7020a;
        if (aVar != null && (aVar.getContext() instanceof Activity)) {
            if (((Activity) this.f7020a.getContext()) == activity) {
                com.opos.cmn.an.f.a.b("InterstitialDialog", "same activity");
                return;
            }
            a();
        }
        a aVar2 = new a(activity, com.opos.cmn.an.h.f.a.a(activity) ? R.style.Theme.Translucent.NoTitleBar.Fullscreen : R.style.Theme.Translucent.NoTitleBar);
        this.f7020a = aVar2;
        aVar2.getWindow().getDecorView().setBackgroundColor(1711276032);
        this.f7020a.getWindow().setStatusBarColor(0);
        this.f7020a.getWindow().addFlags(Integer.MIN_VALUE);
        this.f7020a.setOnKeyListener(this);
        this.f7020a.setOnShowListener(this);
    }

    @Override // com.opos.mobad.video.player.b.b
    public void a() {
        if (this.b == null || !this.f7020a.isShowing()) {
            com.opos.cmn.an.f.a.b("InterstitialDialog", "dismiss dialog but fail");
        } else {
            this.f7020a.dismiss();
        }
    }

    @Override // com.opos.mobad.video.player.b.b
    public void a(Activity activity, View view) {
        this.b = activity;
        a(activity);
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                view.setForceDarkAllowed(false);
            }
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.opos.mobad.h.a.b.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    return b.this.b();
                }
            });
            this.f7020a.setContentView(view, new ViewGroup.LayoutParams(-1, -1));
            this.f7020a.show();
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = this.f7020a.getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                this.f7020a.getWindow().setAttributes(attributes);
            }
            int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
            int i = (systemUiVisibility & 1024) == 1024 ? MediaDiscoverer.Event.Started : 0;
            if ((systemUiVisibility & 4) == 4) {
                i |= 4100;
            }
            this.f7020a.getWindow().getDecorView().setSystemUiVisibility(i);
        }
    }

    @Override // com.opos.mobad.video.player.b.b
    public void a(com.opos.mobad.video.player.b.a aVar) {
        this.c = aVar;
    }

    public boolean b() {
        a aVar;
        boolean z = false;
        try {
            if (!this.b.isFinishing() && (aVar = this.f7020a) != null && aVar.isShowing()) {
                z = true;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterstitialDialog", "isShowing", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("InterstitialDialog", "isShowing=" + z);
        return z;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        boolean z = false;
        if (i == 4) {
            try {
                if (b() && keyEvent.getAction() == 0) {
                    com.opos.mobad.video.player.b.a aVar = this.c;
                    if (aVar != null) {
                        aVar.a();
                    }
                    z = true;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterstitialDialog", "", (Throwable) e);
            }
        }
        StringBuilder sbAppend = new StringBuilder("dialog onKey=").append(i).append(",keyEvent=");
        String string = keyEvent.toString();
        Object obj = keyEvent;
        if (string == null) {
            obj = "";
        }
        com.opos.cmn.an.f.a.b("InterstitialDialog", sbAppend.append(obj).append(z).toString());
        return z;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        com.opos.cmn.an.f.a.b("InterstitialDialog", "dialog show");
    }
}
