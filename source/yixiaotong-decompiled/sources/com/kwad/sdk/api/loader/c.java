package com.kwad.sdk.api.loader;

import android.app.Application;
import com.yfanads.android.qapp.Val;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    public static Application HD() {
        try {
            return (Application) Class.forName(Val.AT).getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
