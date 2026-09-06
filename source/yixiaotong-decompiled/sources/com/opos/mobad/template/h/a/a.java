package com.opos.mobad.template.h.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.template.cmn.baseview.e;
import com.opos.mobad.template.cmn.baseview.f;
import com.opos.mobad.template.cmn.p;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f8014a;
    protected com.opos.mobad.template.a.InterfaceC1003a b;
    protected com.opos.mobad.template.cmn.baseview.c c;
    protected com.opos.mobad.d.a d;
    protected boolean e;

    public static final boolean a(com.opos.mobad.template.d.b bVar) {
        boolean z = false;
        if (bVar == null) {
            return false;
        }
        if (bVar.k != null && !TextUtils.isEmpty(bVar.k.f7535a)) {
            z = true;
        }
        com.opos.cmn.an.f.a.b("BaseTipBarView", "hasTipBarMaterial=" + z);
        return z;
    }

    public RelativeLayout a() {
        return this.c;
    }

    protected void a(View view) {
        if (view != null) {
            p pVar = new p() { // from class: com.opos.mobad.template.h.a.a.1
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view2, int[] iArr) {
                    if (a.this.b != null) {
                        a.this.b.h(view2, iArr);
                    }
                }
            };
            view.setOnTouchListener(pVar);
            view.setOnClickListener(pVar);
        }
    }

    protected void a(TextView textView, String str) {
        if (textView != null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            textView.setText(str);
        }
    }

    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        this.b = interfaceC1003a;
    }

    protected void a(e eVar) {
        if (eVar != null) {
            eVar.a(new f() { // from class: com.opos.mobad.template.h.a.a.3
                @Override // com.opos.mobad.template.cmn.baseview.f
                public void a(View view, int i, boolean z) {
                    com.opos.cmn.an.f.a.a("BaseTipBarView", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                    if (a.this.b != null) {
                        a.this.b.a(view, i, z);
                    }
                }
            });
        }
    }

    protected void b(View view) {
        if (view != null) {
            p pVar = new p() { // from class: com.opos.mobad.template.h.a.a.2
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view2, int[] iArr) {
                    if (a.this.b != null) {
                        a.this.b.g(view2, iArr);
                    }
                }
            };
            view.setOnTouchListener(pVar);
            view.setOnClickListener(pVar);
        }
    }
}
