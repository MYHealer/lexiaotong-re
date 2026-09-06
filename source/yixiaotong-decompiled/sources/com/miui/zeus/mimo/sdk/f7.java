package com.miui.zeus.mimo.sdk;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f7 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f5426a;

    public interface a {
        void onViewAttached();

        void onViewDetached();
    }

    public f7(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f5426a;
        if (aVar != null) {
            aVar.onViewAttached();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f5426a;
        if (aVar != null) {
            aVar.onViewDetached();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setOnShownListener(a aVar) {
        this.f5426a = aVar;
    }
}
