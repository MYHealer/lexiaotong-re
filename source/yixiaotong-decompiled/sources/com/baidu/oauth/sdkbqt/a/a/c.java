package com.baidu.oauth.sdkbqt.a.a;

import android.os.Looper;
import com.baidu.passbqt.http.HttpResponseHandler;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class c extends HttpResponseHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f1854a;
    final /* synthetic */ a b;

    @Override // com.baidu.passbqt.http.HttpResponseHandler
    protected void a() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c(a aVar, Looper looper, boolean z, f fVar) {
        super(looper, z);
        this.b = aVar;
        this.f1854a = fVar;
    }

    @Override // com.baidu.passbqt.http.HttpResponseHandler
    protected void b() {
        this.f1854a.b();
    }

    @Override // com.baidu.passbqt.http.HttpResponseHandler
    protected void a(int i, String str, HashMap<String, String> map) {
        try {
            this.f1854a.a(i, str, map);
        } catch (Throwable th) {
            a(th, str);
        }
    }

    @Override // com.baidu.passbqt.http.HttpResponseHandler
    protected void a(Throwable th, String str) {
        this.b.a(this.f1854a, th, str);
    }
}
