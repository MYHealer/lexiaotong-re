package com.kwad.components.core.e.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.wrapper.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b extends g {
    private static b Qv;
    private boolean QA;
    private final C0660b Qw;
    private com.kwad.components.core.e.c.a Qz;

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.proxy.g
    public final boolean pH() {
        return true;
    }

    public final boolean pI() {
        return this.QA;
    }

    public static boolean a(Context context, C0660b c0660b) {
        Activity activityFromContext;
        b bVar = Qv;
        if ((bVar == null || !bVar.isShowing()) && context != null && (activityFromContext = m.getActivityFromContext(context)) != null && !activityFromContext.isFinishing()) {
            com.kwad.sdk.a.a.c.Hl().dismiss();
            try {
                b bVar2 = new b(activityFromContext, c0660b);
                Qv = bVar2;
                bVar2.show();
                com.kwad.sdk.core.adlog.c.b(c0660b.adTemplate, 86, (JSONObject) null);
                return true;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
        return false;
    }

    public static boolean pG() {
        b bVar = Qv;
        if (bVar != null) {
            return bVar.isShowing();
        }
        return false;
    }

    private b(Activity activity, C0660b c0660b) {
        super(activity);
        this.QA = false;
        this.Qw = c0660b;
        if (com.kwad.sdk.c.a.a.f(activity)) {
            getWindow().addFlags(1024);
        }
        setOnShowListener(c0660b.QC);
        setOnDismissListener(c0660b.QD);
    }

    @Override // com.kwad.components.core.proxy.g
    public final ViewGroup dC() {
        com.kwad.components.core.e.c.a aVar = new com.kwad.components.core.e.c.a(this.mContext, this, this.Qw);
        this.Qz = aVar;
        return aVar;
    }

    @Override // com.kwad.components.core.proxy.g
    public final void g(View view) {
        this.Qz.setChangeListener(new com.kwad.components.core.e.c.a.InterfaceC0659a() { // from class: com.kwad.components.core.e.c.b.1
            @Override // com.kwad.components.core.e.c.a.InterfaceC0659a
            public final void pF() {
                b.this.dismiss();
            }
        });
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog
    public final void onStart() {
        super.onStart();
        b bVar = Qv;
        if (bVar != null) {
            bVar.setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Qv = null;
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        Qv = null;
    }

    public final void an(boolean z) {
        this.QA = z;
        dismiss();
    }

    @Override // android.app.Dialog
    public final void show() {
        Resources resources;
        int identifier;
        try {
            super.show();
            try {
                if (getContext() == null || (resources = getContext().getResources()) == null || (identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android")) <= 0 || getContext().getResources().getDimensionPixelSize(identifier) <= 0) {
                    return;
                }
                getWindow().getDecorView().setSystemUiVisibility(5382);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.adlog.c.cx(this.Qw.adTemplate);
    }

    /* JADX INFO: renamed from: com.kwad.components.core.e.c.b$b, reason: collision with other inner class name */
    public static class C0660b {
        protected DialogInterface.OnShowListener QC;
        protected DialogInterface.OnDismissListener QD;
        protected final AdTemplate adTemplate;
        protected String url;

        /* synthetic */ C0660b(a aVar, byte b) {
            this(aVar);
        }

        private C0660b(a aVar) {
            this.adTemplate = aVar.adTemplate;
            this.url = aVar.url;
            this.QC = aVar.QC;
            this.QD = aVar.QD;
        }
    }

    public static class a {
        private DialogInterface.OnShowListener QC;
        private DialogInterface.OnDismissListener QD;
        private AdTemplate adTemplate;
        private String url;

        public final a a(DialogInterface.OnShowListener onShowListener) {
            this.QC = onShowListener;
            return this;
        }

        public final a aH(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final a ao(String str) {
            this.url = str;
            return this;
        }

        public final a c(DialogInterface.OnDismissListener onDismissListener) {
            this.QD = onDismissListener;
            return this;
        }

        public final C0660b pJ() {
            if (com.kwad.components.core.a.pe.booleanValue() && (this.adTemplate == null || TextUtils.isEmpty(this.url))) {
                throw new IllegalArgumentException("param is error, please check it");
            }
            return new C0660b(this, (byte) 0);
        }
    }
}
