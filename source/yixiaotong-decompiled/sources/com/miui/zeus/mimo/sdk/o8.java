package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o8 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SixElementsView f5555a;

    public o8(SixElementsView sixElementsView) {
        this.f5555a = sixElementsView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SixElementsView sixElementsView = this.f5555a;
        SixElementsView.e eVar = sixElementsView.i;
        if (eVar != null) {
            eVar.a(sixElementsView.f);
        }
    }
}
