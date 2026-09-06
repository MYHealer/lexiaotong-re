package com.kwad.components.core.widget;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.utils.cc;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a extends KSFrameLayout implements cc.a {
    private InterfaceC0705a avj;
    private boolean avk;
    private boolean avl;
    private int avm;
    private boolean avn;
    private long avo;
    private boolean avp;
    private final float avq;
    private final int avr;
    private final View bZ;
    private final cc ca;

    /* JADX INFO: renamed from: com.kwad.components.core.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0705a {
        void aD();

        void ae();

        void af();

        void b(View view);

        void onWindowFocusChanged(boolean z);
    }

    public final void setViewCallback(InterfaceC0705a interfaceC0705a) {
        this.avj = interfaceC0705a;
    }

    public a(Context context, View view) {
        super(context, view);
        this.ca = new cc(this);
        this.avm = 5;
        this.bZ = view;
        setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        float fKd = com.kwad.sdk.core.config.e.Kd();
        this.avq = fKd;
        setVisiblePercent(fKd);
        float fKf = com.kwad.sdk.core.config.e.Kf();
        this.avr = (int) ((fKf < 0.0f ? 1.0f : fKf) * 1000.0f);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.k
    public final void H(View view) {
        InterfaceC0705a interfaceC0705a;
        InterfaceC0705a interfaceC0705a2;
        super.H(view);
        if (this.avr == 0 && (interfaceC0705a2 = this.avj) != null) {
            interfaceC0705a2.b(view);
            return;
        }
        if (!this.avn) {
            this.avn = true;
            this.avo = System.currentTimeMillis();
            zK();
            zJ();
            return;
        }
        if (System.currentTimeMillis() - this.avo <= this.avr || (interfaceC0705a = this.avj) == null) {
            return;
        }
        interfaceC0705a.b(view);
        zK();
    }

    private void zJ() {
        InterfaceC0705a interfaceC0705a;
        if (this.avr == 0 && (interfaceC0705a = this.avj) != null) {
            interfaceC0705a.b(this.bZ);
            return;
        }
        Message messageObtainMessage = this.ca.obtainMessage();
        messageObtainMessage.what = 2;
        this.ca.sendMessageDelayed(messageObtainMessage, this.avr);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.c.d("AdExposureView", "onWindowFocusChanged hasWindowFocus:" + z);
        InterfaceC0705a interfaceC0705a = this.avj;
        if (interfaceC0705a != null) {
            interfaceC0705a.onWindowFocusChanged(z);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        this.avm = 5;
        this.avk = false;
        this.avn = false;
        zL();
        com.kwad.sdk.core.d.c.d("ceshi", "onViewAttached");
        InterfaceC0705a interfaceC0705a = this.avj;
        if (interfaceC0705a != null) {
            interfaceC0705a.ae();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        zK();
        this.avm = 0;
        this.avo = 0L;
        this.avk = true;
        InterfaceC0705a interfaceC0705a = this.avj;
        if (interfaceC0705a != null) {
            interfaceC0705a.af();
        }
    }

    private void zK() {
        this.ca.removeCallbacksAndMessages(null);
        this.avl = false;
    }

    private void zL() {
        if (this.avl) {
            return;
        }
        this.avl = true;
        this.ca.sendEmptyMessage(1);
    }

    public final void zM() {
        zL();
    }

    @Override // com.kwad.sdk.utils.cc.a
    public final void a(Message message) {
        if (this.avk) {
            return;
        }
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (!cb.a(this.bZ, (int) (this.avq * 100.0f), false)) {
                this.avm = 5;
                this.ca.sendEmptyMessage(1);
                return;
            } else {
                InterfaceC0705a interfaceC0705a = this.avj;
                if (interfaceC0705a != null) {
                    interfaceC0705a.b(this.bZ);
                    return;
                }
                return;
            }
        }
        if (cb.a(this.bZ, (int) (this.avq * 100.0f), false)) {
            zK();
            if (this.avn) {
                InterfaceC0705a interfaceC0705a2 = this.avj;
                if (interfaceC0705a2 != null) {
                    interfaceC0705a2.b(this.bZ);
                }
            } else {
                this.avn = true;
                this.avo = System.currentTimeMillis();
                zJ();
            }
            this.avp = false;
            cc ccVar = this.ca;
            int i2 = this.avm;
            this.avm = i2 - 1;
            ccVar.sendEmptyMessageDelayed(1, i2 <= 0 ? 500L : 100L);
            return;
        }
        InterfaceC0705a interfaceC0705a3 = this.avj;
        if (interfaceC0705a3 != null && !this.avp) {
            interfaceC0705a3.aD();
        }
        this.avp = true;
        cc ccVar2 = this.ca;
        int i3 = this.avm;
        this.avm = i3 - 1;
        ccVar2.sendEmptyMessageDelayed(1, i3 <= 0 ? 500L : 100L);
    }
}
