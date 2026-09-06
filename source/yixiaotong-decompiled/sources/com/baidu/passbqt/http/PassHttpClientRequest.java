package com.baidu.passbqt.http;

import android.content.Context;
import com.baidu.passbqt.NoProguard;
import com.baidu.passbqt.common.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class PassHttpClientRequest implements NoProguard, Comparable<PassHttpClientRequest>, Runnable {
    private static final String g = "PassHttpClientRequest";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1935a;
    public HttpResponseHandler b;
    public HttpRequestHandler c;
    public PassHttpParamDTO d;
    public Method e;
    public volatile boolean f = false;
    private int h;

    public void a() {
        this.f = true;
        this.b = null;
    }

    PassHttpClientRequest(Method method, Context context, PassHttpParamDTO passHttpParamDTO, int i, HttpRequestHandler httpRequestHandler, HttpResponseHandler httpResponseHandler) {
        this.h = i;
        this.e = method;
        this.f1935a = context;
        this.d = passHttpParamDTO;
        this.b = httpResponseHandler;
        this.c = httpRequestHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpResponseHandler httpResponseHandler = this.b;
        if (httpResponseHandler != null) {
            httpResponseHandler.c();
        }
        Log.d(g, "network request already run");
        try {
            new HttpStack().a(this.c).a(this);
        } catch (Exception e) {
            Log.d(g, "PassHttpClientRequestrun " + e.getMessage());
            HttpResponseHandler httpResponseHandler2 = this.b;
            if (httpResponseHandler2 != null) {
                httpResponseHandler2.b(e, e.getMessage());
            }
        }
        HttpResponseHandler httpResponseHandler3 = this.b;
        if (httpResponseHandler3 != null) {
            httpResponseHandler3.d();
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(PassHttpClientRequest passHttpClientRequest) {
        ReqPriority reqPriority = this.d.g;
        ReqPriority reqPriority2 = passHttpClientRequest.d.g;
        return reqPriority == reqPriority2 ? this.h - passHttpClientRequest.h : reqPriority2.ordinal() - reqPriority.ordinal();
    }
}
