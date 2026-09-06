package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.kwad.sdk.api.core.ICompletedRemoteView;
import com.kwad.sdk.api.core.RemoteViewBuilder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {
    private ICompletedRemoteView aSy;

    public static b bT(Context context) {
        try {
            return new b(RemoteViewBuilder.createCompletedView(context));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    private b(ICompletedRemoteView iCompletedRemoteView) {
        this.aSy = iCompletedRemoteView;
    }

    public final void setIcon(Bitmap bitmap) {
        ICompletedRemoteView iCompletedRemoteView = this.aSy;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setIcon(bitmap);
        }
    }

    public final void setName(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.aSy;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setName(str);
        }
    }

    public final void setStatus(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.aSy;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setStatus(str);
        }
    }

    public final void setSize(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.aSy;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setSize(str);
        }
    }

    public final void setInstallText(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.aSy;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setInstallText(str);
        }
    }

    final RemoteViews build() {
        ICompletedRemoteView iCompletedRemoteView = this.aSy;
        if (iCompletedRemoteView != null) {
            return iCompletedRemoteView.build();
        }
        return null;
    }
}
