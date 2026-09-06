package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class n8 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SixElementsView f5539a;

    public n8(SixElementsView sixElementsView) {
        this.f5539a = sixElementsView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SixElementsView sixElementsView = this.f5539a;
        SixElementsView.e eVar = sixElementsView.i;
        if (eVar != null) {
            eVar.a(sixElementsView.e);
        }
    }
}
