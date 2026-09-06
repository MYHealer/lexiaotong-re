package com.kwad.sdk.widget;

import android.app.Dialog;
import android.content.Context;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
@Deprecated
public class c extends Dialog {
    public c(Context context) {
        super(m.wrapContextIfNeed(context));
        requestWindowFeature(1);
    }
}
