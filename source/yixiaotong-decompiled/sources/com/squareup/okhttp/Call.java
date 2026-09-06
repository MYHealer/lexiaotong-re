package com.squareup.okhttp;

import androidx.core.app.NotificationCompat;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.RequestException;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.StreamAllocation;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.logging.Level;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class Call {
    volatile boolean canceled;

    /* JADX INFO: renamed from: client, reason: collision with root package name */
    private final OkHttpClient f8516client;
    HttpEngine engine;
    private boolean executed;
    Request originalRequest;

    /* JADX INFO: renamed from: com.squareup.okhttp.Call$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    protected Call(OkHttpClient okHttpClient, Request request) {
        this.f8516client = okHttpClient.copyWithDefaults();
        this.originalRequest = request;
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        try {
            this.f8516client.getDispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain(false);
            if (responseWithInterceptorChain == null) {
                throw new IOException("Canceled");
            }
            this.f8516client.getDispatcher().finished(this);
            return responseWithInterceptorChain;
        } catch (Throwable th) {
            this.f8516client.getDispatcher().finished(this);
            throw th;
        }
    }

    Object tag() {
        return this.originalRequest.tag();
    }

    public void enqueue(Callback callback) {
        enqueue(callback, false);
    }

    void enqueue(Callback callback, boolean z) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.f8516client.getDispatcher().enqueue(new AsyncCall(this, callback, z, null));
    }

    public void cancel() {
        this.canceled = true;
        HttpEngine httpEngine = this.engine;
        if (httpEngine != null) {
            httpEngine.cancel();
        }
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    final class AsyncCall extends NamedRunnable {
        private final boolean forWebSocket;
        private final Callback responseCallback;

        Call get() {
            return Call.this;
        }

        /* synthetic */ AsyncCall(Call call, Callback callback, boolean z, AnonymousClass1 anonymousClass1) {
            this(callback, z);
        }

        private AsyncCall(Callback callback, boolean z) {
            super("OkHttp %s", Call.this.originalRequest.urlString());
            this.responseCallback = callback;
            this.forWebSocket = z;
        }

        String host() {
            return Call.this.originalRequest.httpUrl().host();
        }

        Request request() {
            return Call.this.originalRequest;
        }

        Object tag() {
            return Call.this.originalRequest.tag();
        }

        void cancel() {
            Call.this.cancel();
        }

        @Override // com.squareup.okhttp.internal.NamedRunnable
        protected void execute() {
            boolean z;
            IOException e;
            try {
                try {
                    Response responseWithInterceptorChain = Call.this.getResponseWithInterceptorChain(this.forWebSocket);
                    z = true;
                    try {
                        if (Call.this.canceled) {
                            this.responseCallback.onFailure(Call.this.originalRequest, new IOException("Canceled"));
                        } else {
                            this.responseCallback.onResponse(responseWithInterceptorChain);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        if (z) {
                            Internal.logger.log(Level.INFO, "Callback failure for " + Call.this.toLoggableString(), (Throwable) e);
                        } else {
                            this.responseCallback.onFailure(Call.this.engine == null ? Call.this.originalRequest : Call.this.engine.getRequest(), e);
                        }
                    }
                } catch (IOException e3) {
                    z = false;
                    e = e3;
                }
            } finally {
                Call.this.f8516client.getDispatcher().finished(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String toLoggableString() {
        return (this.canceled ? "canceled call" : NotificationCompat.CATEGORY_CALL) + " to " + this.originalRequest.httpUrl().resolve("/...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response getResponseWithInterceptorChain(boolean z) throws IOException {
        return new ApplicationInterceptorChain(0, this.originalRequest, z).proceed(this.originalRequest);
    }

    class ApplicationInterceptorChain implements Interceptor.Chain {
        private final boolean forWebSocket;
        private final int index;
        private final Request request;

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Connection connection() {
            return null;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Request request() {
            return this.request;
        }

        ApplicationInterceptorChain(int i, Request request, boolean z) {
            this.index = i;
            this.request = request;
            this.forWebSocket = z;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Response proceed(Request request) throws IOException {
            if (this.index < Call.this.f8516client.interceptors().size()) {
                ApplicationInterceptorChain applicationInterceptorChain = Call.this.new ApplicationInterceptorChain(this.index + 1, request, this.forWebSocket);
                Interceptor interceptor = Call.this.f8516client.interceptors().get(this.index);
                Response responseIntercept = interceptor.intercept(applicationInterceptorChain);
                if (responseIntercept != null) {
                    return responseIntercept;
                }
                throw new NullPointerException("application interceptor " + interceptor + " returned null");
            }
            return Call.this.getResponse(request, this.forWebSocket);
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00e9  */
    Response getResponse(Request request, boolean z) throws Throwable {
        Throwable th;
        StreamAllocation streamAllocation;
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            Request.Builder builderNewBuilder = request.newBuilder();
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                builderNewBuilder.header("Content-Type", mediaTypeContentType.toString());
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                builderNewBuilder.header("Content-Length", Long.toString(jContentLength));
                builderNewBuilder.removeHeader("Transfer-Encoding");
            } else {
                builderNewBuilder.header("Transfer-Encoding", HTTP.CHUNK_CODING);
                builderNewBuilder.removeHeader("Content-Length");
            }
            request = builderNewBuilder.build();
        }
        this.engine = new HttpEngine(this.f8516client, request, false, false, z, null, null, null);
        int i = 0;
        while (!this.canceled) {
            boolean z2 = true;
            try {
                try {
                    try {
                        this.engine.sendRequest();
                        this.engine.readResponse();
                        Response response = this.engine.getResponse();
                        Request requestFollowUpRequest = this.engine.followUpRequest();
                        if (requestFollowUpRequest == null) {
                            if (!z) {
                                this.engine.releaseStreamAllocation();
                            }
                            return response;
                        }
                        StreamAllocation streamAllocationClose = this.engine.close();
                        i++;
                        if (i > 20) {
                            streamAllocationClose.release();
                            throw new ProtocolException("Too many follow-up requests: " + i);
                        }
                        if (this.engine.sameConnection(requestFollowUpRequest.httpUrl())) {
                            streamAllocation = streamAllocationClose;
                        } else {
                            streamAllocationClose.release();
                            streamAllocation = null;
                        }
                        this.engine = new HttpEngine(this.f8516client, requestFollowUpRequest, false, false, z, streamAllocation, null, response);
                    } catch (Throwable th2) {
                        th = th2;
                        if (z2) {
                            this.engine.close().release();
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    HttpEngine httpEngineRecover = this.engine.recover(e, null);
                    if (httpEngineRecover == null) {
                        throw e;
                    }
                    try {
                        this.engine = httpEngineRecover;
                    } catch (Throwable th3) {
                        z2 = false;
                        th = th3;
                        if (z2) {
                            this.engine.close().release();
                        }
                        throw th;
                    }
                }
            } catch (RequestException e2) {
                throw e2.getCause();
            } catch (RouteException e3) {
                HttpEngine httpEngineRecover2 = this.engine.recover(e3);
                if (httpEngineRecover2 == null) {
                    throw e3.getLastConnectException();
                }
                this.engine = httpEngineRecover2;
            }
        }
        this.engine.releaseStreamAllocation();
        throw new IOException("Canceled");
    }
}
