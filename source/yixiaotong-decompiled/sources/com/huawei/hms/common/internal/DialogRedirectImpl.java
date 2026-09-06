package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class DialogRedirectImpl extends DialogRedirect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f3975a;
    private final int b;
    private final Intent c;

    DialogRedirectImpl(Intent intent, Activity activity, int i) {
        this.c = intent;
        this.f3975a = activity;
        this.b = i;
    }

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        Intent intent = this.c;
        if (intent != null) {
            this.f3975a.startActivityForResult(intent, this.b);
        }
    }
}
