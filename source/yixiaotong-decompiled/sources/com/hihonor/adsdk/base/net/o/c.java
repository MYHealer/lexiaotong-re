package com.hihonor.adsdk.base.net.o;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends EventListener {
    private static final String hnadsa = "RequestEventListener";

    private static String hnadsa(Request request) {
        return request.header(com.hihonor.adsdk.base.c.m0.hnadsg);
    }

    @Override // okhttp3.EventListener
    public void cacheConditionalHit(Call call, Response response) {
        super.cacheConditionalHit(call, response);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("cacheConditionalHit:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void cacheHit(Call call, Response response) {
        super.cacheHit(call, response);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("cacheHit:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void cacheMiss(Call call) {
        super.cacheMiss(call);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("cacheMiss:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        super.callEnd(call);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("callEnd:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("callFailed:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        super.callStart(call);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("callStart: " + hnadsa(call.request())));
        b.hnadsa().hnadsa(hnadsa(call.request()), 2);
    }

    @Override // okhttp3.EventListener
    public void canceled(Call call) {
        super.canceled(call);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("canceled:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("connectEnd:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("connectFailed:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("connectStart:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("connectionAcquired:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        super.connectionReleased(call, connection);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("connectionReleased:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        Request request = call.request();
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, "--dnsEnd:%s,requestId:%s,urlHasCode:%s", str, hnadsa(request), Integer.valueOf(request.url().hashCode()));
        b.hnadsa().hnadsa(hnadsa(request), 5);
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        Request request = call.request();
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, "dnsStart:%s,requestId:%s,urlHasCode:%s", str, hnadsa(request), Integer.valueOf(request.url().hashCode()));
        b.hnadsa().hnadsa(hnadsa(request), 4);
    }

    @Override // okhttp3.EventListener
    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
        super.proxySelectEnd(call, httpUrl, list);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("proxySelectEnd:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        super.proxySelectStart(call, httpUrl);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("proxySelectStart:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("requestBodyEnd: " + hnadsa(call.request())));
        b.hnadsa().hnadsa(hnadsa(call.request()), 9);
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("requestBodyStart:" + hnadsa(call.request())));
        b.hnadsa().hnadsa(hnadsa(call.request()), 8);
    }

    @Override // okhttp3.EventListener
    public void requestFailed(Call call, IOException iOException) {
        super.requestFailed(call, iOException);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("requestFailed:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("requestHeadersEnd:" + hnadsa(call.request())));
        b.hnadsa().hnadsa(hnadsa(call.request()), 7);
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("requestHeadersStart:" + hnadsa(call.request())));
        b.hnadsa().hnadsa(hnadsa(call.request()), 6);
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("responseBodyEnd:" + hnadsa(call.request())));
        b.hnadsa().hnadsa(hnadsa(call.request()), 13);
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("responseBodyStart:" + hnadsa(call.request())));
        b.hnadsa().hnadsa(hnadsa(call.request()), 12);
    }

    @Override // okhttp3.EventListener
    public void responseFailed(Call call, IOException iOException) {
        super.responseFailed(call, iOException);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("responseFailed:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("responseHeadersEnd:" + hnadsa(call.request())));
        b.hnadsa().hnadsa(hnadsa(call.request()), 11);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("responseHeadersStart:" + hnadsa(call.request())));
        b.hnadsa().hnadsa(hnadsa(call.request()), 10);
    }

    @Override // okhttp3.EventListener
    public void satisfactionFailure(Call call, Response response) {
        super.satisfactionFailure(call, response);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("satisfactionFailure:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("secureConnectEnd:" + hnadsa(call.request())));
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("secureConnectStart:" + hnadsa(call.request())));
    }
}
