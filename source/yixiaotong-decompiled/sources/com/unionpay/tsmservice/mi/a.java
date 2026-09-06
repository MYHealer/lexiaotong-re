package com.unionpay.tsmservice.mi;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a extends ITsmActivityCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9360a;

    public a(Context context) {
        this.f9360a = context;
    }

    @Override // com.unionpay.tsmservice.mi.ITsmActivityCallback
    public final void startActivity(String str, String str2, int i, Bundle bundle) {
        ComponentName componentName = new ComponentName(str, str2);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (i != -1) {
            intent.setFlags(i);
        }
        intent.setComponent(componentName);
        this.f9360a.startActivity(intent);
    }
}
