package com.kwad.sdk.k.a;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class a implements c {
    protected List<c> bms;
    protected boolean enabled;

    private List<c> getChildren() {
        return this.bms;
    }

    protected boolean cH(Context context) {
        return false;
    }

    public a(boolean z) {
        this.enabled = z;
    }

    public a() {
        this.enabled = true;
    }

    @Override // com.kwad.sdk.k.a.c
    public final boolean cG(Context context) {
        if (!this.enabled) {
            return false;
        }
        List<c> children = getChildren();
        if (children != null && children.size() > 0) {
            Iterator<c> it = children.iterator();
            while (it.hasNext()) {
                if (it.next().cG(context)) {
                    return true;
                }
            }
            return false;
        }
        try {
            return cH(context);
        } catch (Throwable unused) {
            return false;
        }
    }
}
