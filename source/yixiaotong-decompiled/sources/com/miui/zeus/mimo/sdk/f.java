package com.miui.zeus.mimo.sdk;

import android.content.Context;
import com.miui.zeus.auth.aidl.ICheckIDService;
import com.miui.zeus.auth.aidl.ICheckListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f extends r9<Boolean, ICheckIDService> {
    public final /* synthetic */ String g;
    public final /* synthetic */ ICheckListener h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, Class cls, String str, ICheckListener iCheckListener) {
        super(context, cls);
        this.g = str;
        this.h = iCheckListener;
    }
}
