package com.kwad.components.core.e.a;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.wrapper.m;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class h implements d {
    private static WeakReference<Window> Qq;
    private final com.kwad.sdk.core.c.c<Activity> Bq = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.h.1
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* JADX INFO: renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            com.kwad.sdk.core.c.b.LW();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            if (activity.equals((Activity) h.this.Qp.get())) {
                h.this.gl();
            }
        }
    };
    private g Qn;
    private b Qo;
    private WeakReference<Activity> Qp;
    private ViewGroup rM;
    private boolean rN;

    public static void a(Window window) {
        Qq = new WeakReference<>(window);
    }

    public static void pB() {
        WeakReference<Window> weakReference = Qq;
        if (weakReference != null) {
            weakReference.clear();
        }
        Qq = null;
    }

    public final boolean b(AdTemplate adTemplate, b bVar) {
        Window window;
        try {
            this.Qo = bVar;
            com.kwad.sdk.core.c.b.LW();
            Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                WeakReference<Window> weakReference = Qq;
                if (weakReference != null) {
                    window = weakReference.get();
                } else {
                    window = currentActivity.getWindow();
                }
                View viewFindViewById = window.getDecorView().findViewById(R.id.content);
                if (!(viewFindViewById instanceof ViewGroup)) {
                    return false;
                }
                this.Qp = new WeakReference<>(currentActivity);
                this.Qn = new g(m.wrapContextIfNeed(currentActivity), adTemplate, this);
                com.kwad.sdk.core.c.b.LW();
                com.kwad.sdk.core.c.b.a(this.Bq);
                this.rM = (ViewGroup) viewFindViewById;
                this.rM.addView(this.Qn, new ViewGroup.LayoutParams(-1, -1));
                bVar.ps();
                return true;
            }
            com.kwad.sdk.core.d.c.d("InstalledActivateViewHelper", "showInWindow fail activity:" + currentActivity);
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.d("InstalledActivateViewHelper", "showInWindow fail error:" + th);
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gl() {
        g gVar;
        if (this.rN) {
            return;
        }
        this.rN = true;
        this.Qo.gk();
        ViewGroup viewGroup = this.rM;
        if (viewGroup != null && (gVar = this.Qn) != null) {
            viewGroup.removeView(gVar);
        }
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this.Bq);
    }

    @Override // com.kwad.components.core.e.a.d
    public final void pt() {
        gl();
    }
}
