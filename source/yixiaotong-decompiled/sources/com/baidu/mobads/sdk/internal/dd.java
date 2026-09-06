package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class dd implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RelativeLayout f1803a;
    final /* synthetic */ cz b;

    dd(cz czVar, RelativeLayout relativeLayout) {
        this.b = czVar;
        this.f1803a = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("novel_activity", (Activity) this.b.i);
            map.put("banner_container", this.f1803a);
            map.put("entry", Integer.valueOf(this.b.G));
            map.put("channelId", Integer.valueOf(this.b.H));
            map.put("novel_id", this.b.I);
            map.put("isnight", Boolean.valueOf(this.b.x()));
            this.b.a(cz.x, map);
        }
    }
}
