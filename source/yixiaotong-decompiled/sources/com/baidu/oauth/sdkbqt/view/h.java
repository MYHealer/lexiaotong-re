package com.baidu.oauth.sdkbqt.view;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class h implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f1914a;

    h(g gVar) {
        this.f1914a = gVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g.a item = this.f1914a.b.getItem(i);
        item.c.a(item);
    }
}
