package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.kwad.sdk.api.core.IProgressRemoteView;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    private IProgressRemoteView aSz;

    public static c a(Context context, int i, boolean z) {
        c cVar;
        if (((f) ServiceProvider.get(f.class)).getApiVersionCode() >= 3031000) {
            try {
                cVar = new c(RemoteViewBuilder.createProgressView(context, i, z));
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                cVar = null;
            }
        } else {
            try {
                cVar = new c(RemoteViewBuilder.createProgressView(context));
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                cVar = null;
            }
        }
        if (cVar != null) {
            return cVar;
        }
        try {
            return new c(RemoteViewBuilder.createProgressView(context));
        } catch (Throwable th3) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th3);
            return cVar;
        }
    }

    private c(IProgressRemoteView iProgressRemoteView) {
        this.aSz = iProgressRemoteView;
    }

    public final void setIcon(Bitmap bitmap) {
        IProgressRemoteView iProgressRemoteView = this.aSz;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setIcon(bitmap);
        }
    }

    public final void setName(String str) {
        IProgressRemoteView iProgressRemoteView = this.aSz;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setName(str);
        }
    }

    public final void setStatus(String str) {
        IProgressRemoteView iProgressRemoteView = this.aSz;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setStatus(str);
        }
    }

    public final void setProgress(int i, int i2, boolean z) {
        IProgressRemoteView iProgressRemoteView = this.aSz;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setProgress(100, i2, false);
        }
    }

    public final void setSize(String str) {
        IProgressRemoteView iProgressRemoteView = this.aSz;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setSize(str);
        }
    }

    public final void setPercentNum(String str) {
        IProgressRemoteView iProgressRemoteView = this.aSz;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setPercentNum(str);
        }
    }

    public final void setControlBtnPaused(boolean z) {
        try {
            IProgressRemoteView iProgressRemoteView = this.aSz;
            if (iProgressRemoteView != null) {
                iProgressRemoteView.setControlBtnPaused(z);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    final RemoteViews build() {
        IProgressRemoteView iProgressRemoteView = this.aSz;
        if (iProgressRemoteView != null) {
            return iProgressRemoteView.build();
        }
        return null;
    }
}
