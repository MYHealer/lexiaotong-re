package com.opos.mobad.video.player.e;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.huawei.openalliance.ad.constant.br;
import com.opos.mobad.ad.c.e;
import com.opos.mobad.cmn.func.adhandler.f;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.InteractiveData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.utils.AdHelper;
import java.util.Map;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f8387a;
    private final com.opos.mobad.b b;
    private com.opos.mobad.video.player.f.d c;
    private com.opos.mobad.video.player.e.a d;
    private int e;
    private int f;
    private boolean g;
    private com.opos.mobad.cmn.func.a h;
    private com.opos.mobad.video.player.c i;
    private com.opos.mobad.t.a j;
    private f k;
    private AdItemData l;
    private MaterialData m;
    private com.opos.mobad.cmn.service.pkginstall.c.b n = new com.opos.mobad.cmn.service.pkginstall.c.b() { // from class: com.opos.mobad.video.player.e.c.5
        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b("AdShower", "install pkgName=" + str);
            if (c.this.d != null) {
                c.this.d.b(adItemData, str);
            }
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void b(AdItemData adItemData, String str) {
            if (c.this.d != null) {
                c.this.d.a(adItemData, str);
            }
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void c(AdItemData adItemData, String str) {
            if (c.this.d != null) {
                c.this.d.a(adItemData, str);
            }
        }
    };

    private static class a implements com.opos.mobad.video.player.c.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InteractiveData f8396a;

        public a(InteractiveData interactiveData) {
            this.f8396a = interactiveData;
        }

        @Override // com.opos.mobad.video.player.c.a.b
        public String a() {
            return this.f8396a.f;
        }

        @Override // com.opos.mobad.video.player.c.a.b
        public String b() {
            return this.f8396a.g;
        }
    }

    public c(com.opos.mobad.b bVar) {
        this.b = bVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.video.player.e.c.4
            @Override // java.lang.Runnable
            public void run() {
                Activity activity = c.this.f8387a;
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    com.opos.cmn.an.f.a.b("AdShower", "vip result but destroy");
                } else if (c.this.d != null) {
                    c.this.d.d(i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, final String str, final Map<String, String> map) {
        if (this.g) {
            return;
        }
        this.g = true;
        try {
            this.c.a(new com.opos.mobad.o.c() { // from class: com.opos.mobad.video.player.e.c.6
                @Override // com.opos.mobad.o.c
                public void a(final AdHelper.AdHelperData adHelperData) {
                    com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.video.player.e.c.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Object[] objArr = new Object[2];
                            objArr[0] = "tryShowFallbackAd fallbackData=";
                            objArr[1] = Boolean.valueOf(adHelperData != null);
                            com.opos.cmn.an.f.a.b("AdShower", objArr);
                            if (adHelperData == null) {
                                if (c.this.d != null) {
                                    c.this.d.b(map);
                                    return;
                                }
                                return;
                            }
                            boolean zA = c.this.a(adHelperData, c.this.f, c.this.h, c.this.c, c.this.i, c.this.j, c.this.k, true);
                            com.opos.cmn.an.f.a.b("AdShower", "tryShowFallbackAd showResult=", Boolean.valueOf(zA));
                            if (zA) {
                                c.this.d.a(i, str, c.this.l, c.this.m, map);
                            } else if (c.this.d != null) {
                                c.this.d.b(map);
                            } else {
                                c.this.d();
                            }
                        }
                    });
                }

                @Override // android.os.IInterface
                public IBinder asBinder() {
                    return null;
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AdShower", "tryShowFallback", e);
            com.opos.mobad.video.player.e.a aVar = this.d;
            if (aVar != null) {
                aVar.b(map);
            } else {
                d();
            }
        }
    }

    private void a(Activity activity, AdItemData adItemData) {
        if (adItemData != null) {
            int iK = adItemData.K();
            if (iK == 1) {
                activity.setRequestedOrientation(0);
            } else {
                if (iK != 2) {
                    return;
                }
                activity.setRequestedOrientation(1);
            }
        }
    }

    private void a(Activity activity, boolean z) {
        Window window = activity.getWindow();
        window.getDecorView().setBackgroundColor(1711276032);
        window.setStatusBarColor(0);
        window.addFlags(Integer.MIN_VALUE);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        if (z) {
            com.opos.cmn.an.f.a.b("AdShower", "isFullScreen");
            activity.getTheme().applyStyle(R.style.Theme.Translucent.NoTitleBar.Fullscreen, true);
            window.setFlags(1024, 1024);
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 5380);
        }
    }

    private void a(final Window window) {
        window.setBackgroundDrawable(new ColorDrawable(-16777216));
        window.setFlags(1024, 1024);
        window.addFlags(128);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        window.getDecorView().setSystemUiVisibility(5894);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.opos.mobad.video.player.e.c.2
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (2 == (i & 2) && 4 == (i & 4)) {
                    return;
                }
                com.opos.cmn.an.f.a.b("AdShower", "reset system ui");
                window.getDecorView().setSystemUiVisibility(5894);
            }
        });
    }

    private boolean a(int i, com.opos.mobad.cmn.func.a aVar) {
        String str;
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            str = "checkValidAndSetData false, actionType error";
        } else {
            if (aVar != null) {
                return true;
            }
            str = "checkValidAndSetData false, interactor is null";
        }
        com.opos.cmn.an.f.a.a("AdShower", str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AdHelper.a aVar, int i, com.opos.mobad.cmn.func.a aVar2, com.opos.mobad.video.player.f.d dVar, com.opos.mobad.video.player.c cVar, com.opos.mobad.t.a aVar3, f fVar, boolean z) {
        com.opos.cmn.an.f.a.b("AdShower", "showVideo isFallbackAd=", Boolean.valueOf(z));
        if (this.f8387a == null || aVar == null) {
            return false;
        }
        if (aVar != null && aVar.d != null) {
            com.opos.cmn.an.f.a.b("AdShower", "showVideo templateId=", Integer.valueOf(aVar.d.b()));
        }
        a(this.f8387a.getWindow());
        this.f8387a.setVolumeControlStream(3);
        a(this.f8387a, aVar.c);
        boolean z2 = aVar.c.w() != 0;
        com.opos.mobad.template.l.a aVarA = com.opos.mobad.j.b.c.a(aVar.c.V());
        com.opos.mobad.ui.c.b bVarA = com.opos.mobad.ui.c.b.a();
        Context contextB = this.b.b();
        MaterialData materialData = aVar.d;
        com.opos.mobad.template.a aVarA2 = z2 ? bVarA.a(contextB, materialData, aVarA, (com.opos.mobad.template.a.InterfaceC1003a) null) : bVarA.b(contextB, materialData, aVarA, (com.opos.mobad.template.a.InterfaceC1003a) null);
        if (aVarA2 == null || !a(aVar, i, aVar2, dVar, cVar, aVar3, aVarA2, true, false, fVar)) {
            return false;
        }
        if (z2) {
            a(aVar.c.g());
        }
        return true;
    }

    private boolean a(AdHelper.a aVar, int i, com.opos.mobad.cmn.func.a aVar2, com.opos.mobad.video.player.f.d dVar, com.opos.mobad.video.player.c cVar, com.opos.mobad.t.a aVar3, com.opos.mobad.template.a aVar4, boolean z, boolean z2, f fVar) {
        com.opos.mobad.video.player.c.a aVar5;
        com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> aVar6;
        String strG = aVar.c.g();
        String strU = aVar.c.U();
        com.opos.mobad.cmn.func.adhandler.a aVar7 = new com.opos.mobad.cmn.func.adhandler.a(this.b, strG, aVar2, fVar);
        if (dVar instanceof com.opos.mobad.ad.f) {
            aVar7.a((com.opos.mobad.ad.f) dVar);
        }
        com.opos.mobad.template.a aVarA = com.opos.mobad.video.player.g.b.b.a().a(this.f8387a, aVar.d, null);
        com.opos.mobad.ui.feedback.a aVar8 = new com.opos.mobad.ui.feedback.a(this.b.b(), null);
        aVar8.a(strU);
        com.opos.mobad.template.a aVarA2 = com.opos.mobad.video.player.g.b.a.a().a(this.b.b(), aVar.c, (com.opos.mobad.template.a.InterfaceC1003a) null);
        b.a aVarB = new b.a(aVar4, new com.opos.mobad.video.player.b(this.f8387a), aVar8).a(aVarA2).a(z).b(z2).b(aVarA);
        InteractiveData interactiveDataAd = aVar.d.ad();
        if (interactiveDataAd != null && interactiveDataAd.h == 0) {
            com.opos.mobad.video.player.c.a aVar9 = new com.opos.mobad.video.player.c.a(this.b, aVar, aVar.d.ad());
            aVarB.a(aVar9);
            aVar5 = aVar9;
            aVar6 = null;
        } else if (interactiveDataAd != null && interactiveDataAd.h == 1 && aVar.c.ai() == 1017) {
            com.opos.mobad.video.player.c.a.a<com.opos.mobad.video.player.c.a.b> aVarA3 = com.opos.mobad.video.player.c.a.c.a(this.f8387a);
            aVarA3.a(new a(interactiveDataAd));
            aVarB.a(aVarA3);
            aVar6 = aVarA3;
            aVar5 = null;
        } else {
            aVar5 = null;
            aVar6 = null;
        }
        this.d = new com.opos.mobad.video.player.e.a(this.f8387a, this.b, strG, aVar7, aVarB.a(), dVar, aVar3, this.e);
        if (!this.g && com.opos.mobad.video.player.f.c.a(this.e)) {
            this.d.a(new com.opos.mobad.video.player.e.a.InterfaceC1039a() { // from class: com.opos.mobad.video.player.e.c.1
                @Override // com.opos.mobad.video.player.e.a.InterfaceC1039a
                public void a(final int i2, final String str, final Map<String, String> map) {
                    com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.video.player.e.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.a(i2, str, map);
                        }
                    });
                }
            });
        }
        this.d.a(aVar.c, aVar.d, i, cVar);
        FrameLayout frameLayout = new FrameLayout(this.b.b());
        frameLayout.addView(aVar4.c());
        if (aVarA2 != null && aVarA2.c() != null) {
            View viewC = aVarA2.c();
            viewC.setVisibility(8);
            frameLayout.addView(viewC);
        }
        if (aVarA != null && aVarA.c() != null) {
            View viewC2 = aVarA.c();
            viewC2.setVisibility(8);
            frameLayout.addView(viewC2);
        }
        if (aVar5 != null) {
            View viewA = aVar5.a();
            viewA.setVisibility(8);
            frameLayout.addView(viewA, new ViewGroup.LayoutParams(-1, -1));
        } else if (aVar6 != null && aVar6.a() != null) {
            frameLayout.addView(aVar6.a(), new ViewGroup.LayoutParams(-1, -1));
        }
        this.f8387a.setContentView(frameLayout);
        return true;
    }

    private boolean a(AdHelper.a aVar, int i, boolean z, com.opos.mobad.cmn.func.a aVar2, com.opos.mobad.video.player.f.d dVar, com.opos.mobad.video.player.c cVar, f fVar) {
        Activity activity = this.f8387a;
        if (activity == null) {
            com.opos.cmn.an.f.a.b("AdShower", "activity is null");
            return false;
        }
        a(activity, z);
        aVar.c.g();
        Bundle bundle = new Bundle();
        if (e() == 4) {
            bundle.putInt("interstitial_scene", e.b.INSTANT_EXIT.ordinal());
        }
        com.opos.mobad.template.a aVarA = com.opos.mobad.video.player.d.a.a(this.f8387a, aVar.c, aVar.d, bundle, null);
        return aVarA != null && a(aVar, i, aVar2, dVar, cVar, (com.opos.mobad.t.a) null, aVarA, false, true, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.opos.mobad.video.player.f.d dVar = this.c;
        if (dVar != null) {
            dVar.a(-1, "unknown error.");
        }
    }

    private int e() {
        return this.e;
    }

    public void a() {
        com.opos.mobad.video.player.e.a aVar = this.d;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void a(Configuration configuration) {
        com.opos.mobad.video.player.e.a aVar = this.d;
        if (aVar != null) {
            aVar.a(configuration);
        }
    }

    public void a(String str) {
        final FutureTask<Integer> futureTaskA = this.b.j().a(this.b.b(), str);
        if (futureTaskA == null) {
            a(1);
        } else {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.video.player.e.c.3
                @Override // java.lang.Runnable
                public void run() {
                    int iA;
                    try {
                        iA = ((Integer) futureTaskA.get(c.this.b.n().k(), TimeUnit.MILLISECONDS)).intValue();
                    } catch (Exception unused) {
                        iA = c.this.b.j().a();
                    }
                    c.this.a(iA);
                }
            });
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        com.opos.mobad.video.player.e.a aVar = this.d;
        return aVar != null && aVar.a(i, keyEvent);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004c A[Catch: Exception -> 0x0080, TryCatch #0 {Exception -> 0x0080, blocks: (B:4:0x0009, B:7:0x0011, B:19:0x0076, B:20:0x0079, B:16:0x004c, B:17:0x005f, B:22:0x007c), top: B:27:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x005f A[Catch: Exception -> 0x0080, TryCatch #0 {Exception -> 0x0080, blocks: (B:4:0x0009, B:7:0x0011, B:19:0x0076, B:20:0x0079, B:16:0x004c, B:17:0x005f, B:22:0x007c), top: B:27:0x0009 }] */
    public boolean a(Activity activity, AdHelper.a aVar, int i, int i2, boolean z, com.opos.mobad.video.player.f.d dVar, com.opos.mobad.cmn.func.a aVar2, com.opos.mobad.video.player.c cVar, com.opos.mobad.t.a aVar3, f fVar) {
        boolean zA;
        if (aVar != null) {
            try {
                if (a(i, aVar2)) {
                    this.f8387a = activity;
                    this.e = i;
                    this.l = aVar.c;
                    this.m = aVar.d;
                    this.f = i2;
                    this.h = aVar2;
                    this.i = cVar;
                    this.j = aVar3;
                    this.k = fVar;
                    com.opos.mobad.video.player.f.b bVar = new com.opos.mobad.video.player.f.b(dVar);
                    this.c = bVar;
                    bVar.a(this.n);
                    if (i == 1) {
                        zA = a(aVar, i2, aVar2, this.c, cVar, aVar3, fVar, false);
                    } else if (i == 2) {
                        zA = a(aVar, i2, z, aVar2, this.c, cVar, fVar);
                    } else if (i == 3) {
                        zA = a(aVar, i2, aVar2, this.c, cVar, aVar3, fVar, false);
                    } else if (i != 4) {
                        zA = false;
                    } else {
                        zA = a(aVar, i2, z, aVar2, this.c, cVar, fVar);
                    }
                    if (!zA) {
                        d();
                    }
                    this.g = false;
                    return zA;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("AdShower", br.b.V, e);
                d();
                return false;
            }
        }
        d();
        return false;
    }

    public void b() {
        com.opos.mobad.video.player.e.a aVar = this.d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void c() {
        com.opos.mobad.video.player.e.a aVar = this.d;
        if (aVar != null) {
            aVar.b();
        }
        com.opos.mobad.video.player.f.d dVar = this.c;
        if (dVar != null) {
            dVar.a((com.opos.mobad.cmn.service.pkginstall.c.b) null);
        }
        this.f8387a = null;
        this.c = null;
        this.j = null;
        this.i = null;
        this.k = null;
        this.h = null;
    }
}
