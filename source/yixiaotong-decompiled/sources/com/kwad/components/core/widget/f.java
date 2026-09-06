package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import com.kwad.sdk.utils.as;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f extends FrameLayout {
    private boolean awy;
    protected boolean lM;
    protected g lt;
    protected Context mContext;

    public final void setOrientationChangeListener(g gVar) {
        this.lt = gVar;
    }

    public f(Context context) {
        super(context);
        this.mContext = context;
        this.lM = as.VM();
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.awy = i == 0;
        zY();
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        zY();
    }

    private void zY() {
        boolean zVM = as.VM();
        if (!this.awy || zVM == this.lM) {
            return;
        }
        this.lM = zVM;
        g gVar = this.lt;
        if (gVar != null) {
            gVar.k(!zVM);
        }
    }
}
