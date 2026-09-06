package com.opos.mobad.video.player;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.opos.mobad.template.h.p;
import com.opos.mobad.template.h.w;
import com.opos.mobad.ui.b.e;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.cmn.module.ui.b.g.a f8333a;
    private p b;
    private com.opos.cmn.module.ui.b.g.a c;
    private w d;
    private com.opos.cmn.module.ui.b.c.d e;
    private Activity f;
    private InterfaceC1032b g;
    private Dialog h;
    private com.opos.cmn.module.ui.b.a i;

    public interface a {
        void a();

        void b();
    }

    /* JADX INFO: renamed from: com.opos.mobad.video.player.b$b, reason: collision with other inner class name */
    public interface InterfaceC1032b {
        void a(View view, int[] iArr);

        void b(View view, int[] iArr);
    }

    public b(Activity activity) {
        this.f = activity;
    }

    public static final void a(final Window window) {
        if (window == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        window.getDecorView().setSystemUiVisibility(5894);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.opos.mobad.video.player.b.6
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (2 == (i & 2) && 4 == (i & 4)) {
                    return;
                }
                com.opos.cmn.an.f.a.b("DialogTemplate", "reset system ui");
                window.getDecorView().setSystemUiVisibility(5894);
            }
        });
    }

    public Dialog a(String str, String str2, e.b bVar) {
        Dialog dialog = this.h;
        if (dialog != null && dialog.isShowing()) {
            this.h.dismiss();
        }
        Dialog dialogA = e.a(this.f, str, str2, bVar);
        this.h = dialogA;
        a(dialogA.getWindow());
        return this.h;
    }

    public void a() {
        com.opos.cmn.module.ui.b.a aVar = this.i;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(final a aVar) {
        if (aVar != null && this.i == null) {
            com.opos.cmn.module.ui.b.a aVar2 = new com.opos.cmn.module.ui.b.a(this.f);
            this.i = aVar2;
            aVar2.a("当前为非Wi-Fi环境，\n是否继续下载？", "取消", com.hihonor.adsdk.base.c.g1.hnadsa, new com.opos.cmn.module.ui.b.d.a() { // from class: com.opos.mobad.video.player.b.1
                @Override // com.opos.cmn.module.ui.b.d.a
                public void a(View view, int[] iArr) {
                    aVar.b();
                    b.this.i.a();
                }

                @Override // com.opos.cmn.module.ui.b.d.a
                public void b(View view, int[] iArr) {
                    aVar.a();
                    b.this.i.a();
                }
            });
        }
    }

    public void a(InterfaceC1032b interfaceC1032b) {
        this.g = interfaceC1032b;
    }

    public void a(CharSequence charSequence) {
        com.opos.cmn.module.ui.b.g.a aVar = this.c;
        if (aVar == null || !aVar.isShowing()) {
            if (this.f8333a == null) {
                p pVarA = p.a(StubApp.getOrigApplicationContext(this.f.getApplicationContext()));
                this.b = pVarA;
                pVarA.a(new p.a() { // from class: com.opos.mobad.video.player.b.4
                    @Override // com.opos.mobad.template.h.p.a
                    public void a(View view, int[] iArr) {
                        b.this.f8333a.dismiss();
                        if (b.this.g != null) {
                            b.this.g.a(view, iArr);
                        }
                    }

                    @Override // com.opos.mobad.template.h.p.a
                    public void b(View view, int[] iArr) {
                        b.this.f8333a.dismiss();
                        if (b.this.g != null) {
                            b.this.g.b(view, iArr);
                        }
                    }
                });
                com.opos.cmn.module.ui.b.g.a aVar2 = new com.opos.cmn.module.ui.b.g.a(this.f, R.style.Theme.Translucent.NoTitleBar.Fullscreen, new com.opos.cmn.module.ui.b.e.a.C0898a().a(R.style.Theme.Translucent.NoTitleBar).a(false).b(false).a());
                this.f8333a = aVar2;
                aVar2.setContentView(this.b);
                a(this.f8333a.getWindow());
            }
            this.b.a(charSequence);
            this.f8333a.show();
        }
    }

    public void b() {
        com.opos.cmn.module.ui.b.g.a aVar = this.f8333a;
        if (aVar != null && aVar.isShowing()) {
            this.f8333a.dismiss();
        }
        if (this.c == null) {
            w wVarA = w.a(StubApp.getOrigApplicationContext(this.f.getApplicationContext()));
            this.d = wVarA;
            wVarA.a(new w.a() { // from class: com.opos.mobad.video.player.b.5
                @Override // com.opos.mobad.template.h.w.a
                public void a(View view, int[] iArr) {
                    b.this.c.dismiss();
                    if (b.this.g != null) {
                        b.this.g.a(view, iArr);
                    }
                }
            });
            com.opos.cmn.module.ui.b.g.a aVar2 = new com.opos.cmn.module.ui.b.g.a(this.f, R.style.Theme.Translucent.NoTitleBar.Fullscreen, new com.opos.cmn.module.ui.b.e.a.C0898a().a(R.style.Theme.Translucent.NoTitleBar.Fullscreen).a(false).b(false).a());
            this.c = aVar2;
            aVar2.setContentView(this.d);
            a(this.c.getWindow());
        }
        this.c.show();
    }

    public void b(final a aVar) {
        com.opos.cmn.module.ui.b.c.d dVar = this.e;
        if (dVar == null) {
            this.e = new com.opos.cmn.module.ui.b.c.d.a(StubApp.getOrigApplicationContext(this.f.getApplicationContext())).a("当前为非WIFI环境,是否使用\n流量观看？").b("关闭视频", new com.opos.cmn.module.ui.b.c.d.b() { // from class: com.opos.mobad.video.player.b.3
                @Override // com.opos.cmn.module.ui.b.c.d.b
                public void a(com.opos.cmn.module.ui.b.c.d dVar2, View view, int[] iArr) {
                    dVar2.b();
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                }
            }).a("继续观看", new com.opos.cmn.module.ui.b.c.d.b() { // from class: com.opos.mobad.video.player.b.2
                @Override // com.opos.cmn.module.ui.b.c.d.b
                public void a(com.opos.cmn.module.ui.b.c.d dVar2, View view, int[] iArr) {
                    dVar2.b();
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            }).a();
        } else {
            dVar.a("wifi");
        }
        this.e.a(this.f);
    }

    public void c() {
        Dialog dialog = this.h;
        if (dialog != null && dialog.isShowing()) {
            this.h.dismiss();
        }
        com.opos.cmn.module.ui.b.g.a aVar = this.f8333a;
        if (aVar != null && aVar.isShowing()) {
            this.f8333a.dismiss();
        }
        com.opos.cmn.module.ui.b.c.d dVar = this.e;
        if (dVar != null && dVar.a()) {
            this.e.b();
        }
        com.opos.cmn.module.ui.b.a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.a();
        }
        com.opos.cmn.module.ui.b.g.a aVar3 = this.c;
        if (aVar3 == null || !aVar3.isShowing()) {
            return;
        }
        this.c.dismiss();
    }
}
