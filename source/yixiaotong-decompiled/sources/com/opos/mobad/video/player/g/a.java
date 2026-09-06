package com.opos.mobad.video.player.g;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC1041a f8403a;
    private boolean b;
    private volatile boolean c;

    /* JADX INFO: renamed from: com.opos.mobad.video.player.g.a$a, reason: collision with other inner class name */
    public interface InterfaceC1041a {
        void a();

        void a(boolean z);

        void b();
    }

    public a(Context context) {
        super(context);
        this.b = false;
        this.c = false;
    }

    public void a() {
        if (this.f8403a != null) {
            this.f8403a = null;
        }
    }

    public void a(InterfaceC1041a interfaceC1041a) {
        this.f8403a = interfaceC1041a;
        if (!this.b || interfaceC1041a == null) {
            return;
        }
        interfaceC1041a.b();
    }

    protected void a(boolean z) {
        if (this.c == (!z)) {
            this.c = z;
            InterfaceC1041a interfaceC1041a = this.f8403a;
            if (interfaceC1041a != null) {
                interfaceC1041a.a(z);
            }
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = true;
        InterfaceC1041a interfaceC1041a = this.f8403a;
        if (interfaceC1041a != null) {
            interfaceC1041a.b();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = false;
        InterfaceC1041a interfaceC1041a = this.f8403a;
        if (interfaceC1041a != null) {
            interfaceC1041a.a();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        a(i == 0);
    }
}
