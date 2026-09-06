package com.kuaishou.weapon.p0;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class cy {
    private static volatile cy b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4692a;
    private Application.ActivityLifecycleCallbacks c;
    private boolean d;

    private cy(Context context) {
        this.f4692a = context;
    }

    public static cy a(Context context) {
        if (b == null) {
            synchronized (cy.class) {
                if (b == null) {
                    b = new cy(context);
                }
            }
        }
        return b;
    }

    public void a() {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cy.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        h hVarA = h.a(cy.this.f4692a, "re_po_rt");
                        boolean zE = hVarA.e("a1_p_s_p_s");
                        boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
                        if ((zE || zE2) && !cy.this.d) {
                            cy.this.d = true;
                            cy.this.b();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            Context context = this.f4692a;
            if (context == null) {
                return;
            }
            h hVarA = h.a(context, "re_po_rt");
            if (hVarA.b(dd.w, 0) == 0) {
                return;
            }
            final int[] iArr = {0};
            final int[] iArr2 = {hVarA.b(dd.k, 1)};
            if (this.f4692a instanceof Application) {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.kuaishou.weapon.p0.cy.2
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity) {
                        try {
                            int[] iArr3 = iArr;
                            iArr3[0] = iArr3[0] + 1;
                            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cy.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (iArr[0] < 20 && iArr2[0] <= 0) {
                                        ((Application) cy.this.f4692a).unregisterActivityLifecycleCallbacks(cy.this.c);
                                        return;
                                    }
                                    int[] iArr4 = iArr2;
                                    iArr4[0] = iArr4[0] - 1;
                                    cv.a(cy.this.f4692a).a(106);
                                    db.a(cy.this.f4692a).a(106);
                                    cz.a(cy.this.f4692a).a(106, 0);
                                    cx.a(cy.this.f4692a).a(106);
                                    dc.a(cy.this.f4692a).a(106);
                                }
                            });
                        } catch (Throwable unused) {
                        }
                    }
                };
                this.c = activityLifecycleCallbacks;
                ((Application) this.f4692a).registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        } catch (Throwable unused) {
        }
    }
}
