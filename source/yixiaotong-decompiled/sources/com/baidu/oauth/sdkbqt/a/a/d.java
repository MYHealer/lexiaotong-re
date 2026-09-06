package com.baidu.oauth.sdkbqt.a.a;

import android.os.Looper;
import com.baidu.passbqt.http.HttpErrorException;
import com.baidu.passbqt.http.HttpResponseHandler;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class d extends HttpResponseHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f1855a;
    final /* synthetic */ String b;
    final /* synthetic */ g c;
    final /* synthetic */ HashMap d;
    final /* synthetic */ List e;
    final /* synthetic */ String f;
    final /* synthetic */ int g;
    final /* synthetic */ a h;

    @Override // com.baidu.passbqt.http.HttpResponseHandler
    protected void a() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    d(a aVar, Looper looper, boolean z, f fVar, String str, g gVar, HashMap map, List list, String str2, int i) {
        super(looper, z);
        this.h = aVar;
        this.f1855a = fVar;
        this.b = str;
        this.c = gVar;
        this.d = map;
        this.e = list;
        this.f = str2;
        this.g = i;
    }

    @Override // com.baidu.passbqt.http.HttpResponseHandler
    protected void b() {
        this.f1855a.b();
    }

    @Override // com.baidu.passbqt.http.HttpResponseHandler
    protected void a(int i, String str, HashMap<String, String> map) {
        this.f1855a.a(i, str, map);
    }

    @Override // com.baidu.passbqt.http.HttpResponseHandler
    protected void a(Throwable th, String str) {
        if ((th instanceof HttpErrorException) && ((HttpErrorException) th).f1925a == 304) {
            this.h.c = false;
        }
        if (this.h.c) {
            this.h.c = false;
            this.h.a(this.b, this.c, this.d, this.e, this.f, this.g, this.f1855a);
        } else {
            this.h.a(this.f1855a, th, str);
        }
    }
}
