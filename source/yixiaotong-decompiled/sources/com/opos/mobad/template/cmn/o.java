package com.opos.mobad.template.cmn;

import android.content.Context;
import android.widget.ScrollView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f7521a;

    public interface a {
        void a(int i, int i2, int i3, int i4);
    }

    public o(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.f7521a = aVar;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        a aVar = this.f7521a;
        if (aVar != null) {
            aVar.a(i, i2, i3, i4);
        }
    }
}
