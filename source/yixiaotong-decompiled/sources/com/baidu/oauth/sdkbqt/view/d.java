package com.baidu.oauth.sdkbqt.view;

import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f1909a;

    d(a aVar) {
        this.f1909a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent("android.settings.SETTINGS");
        intent.setFlags(270532608);
        this.f1909a.startActivity(intent);
    }
}
