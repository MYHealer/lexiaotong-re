package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.HttpServerConnection;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.MethodNotSupportedException;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.UnsupportedHttpVersionException;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.DefaultHttpResponseFactory;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EncodingUtils;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class HttpService {
    private volatile ConnectionReuseStrategy connStrategy;
    private volatile HttpExpectationVerifier expectationVerifier;
    private volatile HttpRequestHandlerMapper handlerMapper;
    private volatile HttpParams params;
    private volatile HttpProcessor processor;
    private volatile HttpResponseFactory responseFactory;

    @Deprecated
    public HttpParams getParams() {
        return this.params;
    }

    @Deprecated
    public void setExpectationVerifier(HttpExpectationVerifier httpExpectationVerifier) {
        this.expectationVerifier = httpExpectationVerifier;
    }

    @Deprecated
    public void setParams(HttpParams httpParams) {
        this.params = httpParams;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), httpExpectationVerifier);
        this.params = httpParams;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), (HttpExpectationVerifier) null);
        this.params = httpParams;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        setHttpProcessor(httpProcessor);
        setConnReuseStrategy(connectionReuseStrategy);
        setResponseFactory(httpResponseFactory);
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper, HttpExpectationVerifier httpExpectationVerifier) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        this.processor = (HttpProcessor) Args.notNull(httpProcessor, "HTTP processor");
        this.connStrategy = connectionReuseStrategy == null ? DefaultConnectionReuseStrategy.INSTANCE : connectionReuseStrategy;
        this.responseFactory = httpResponseFactory == null ? DefaultHttpResponseFactory.INSTANCE : httpResponseFactory;
        this.handlerMapper = httpRequestHandlerMapper;
        this.expectationVerifier = httpExpectationVerifier;
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, httpRequestHandlerMapper, (HttpExpectationVerifier) null);
    }

    public HttpService(HttpProcessor httpProcessor, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, (ConnectionReuseStrategy) null, (HttpResponseFactory) null, httpRequestHandlerMapper, (HttpExpectationVerifier) null);
    }

    @Deprecated
    public void setHttpProcessor(HttpProcessor httpProcessor) {
        Args.notNull(httpProcessor, "HTTP processor");
        this.processor = httpProcessor;
    }

    @Deprecated
    public void setConnReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        this.connStrategy = connectionReuseStrategy;
    }

    @Deprecated
    public void setResponseFactory(HttpResponseFactory httpResponseFactory) {
        Args.notNull(httpResponseFactory, "Response factory");
        this.responseFactory = httpResponseFactory;
    }

    @Deprecated
    public void setHandlerResolver(HttpRequestHandlerResolver httpRequestHandlerResolver) {
        this.handlerMapper = new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0062 A[Catch: HttpException -> 0x0080, TryCatch #1 {HttpException -> 0x0080, blocks: (B:3:0x0007, B:5:0x0012, B:7:0x001b, B:13:0x003c, B:15:0x0046, B:12:0x0030, B:17:0x0055, B:18:0x005b, B:20:0x0062, B:21:0x0072, B:23:0x0076, B:9:0x0029), top: B:33:0x0007, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0076 A[Catch: HttpException -> 0x0080, TRY_LEAVE, TryCatch #1 {HttpException -> 0x0080, blocks: (B:3:0x0007, B:5:0x0012, B:7:0x001b, B:13:0x003c, B:15:0x0046, B:12:0x0030, B:17:0x0055, B:18:0x005b, B:20:0x0062, B:21:0x0072, B:23:0x0076, B:9:0x0029), top: B:33:0x0007, inners: #0 }] */
    public void handleRequest(HttpServerConnection httpServerConnection, HttpContext httpContext) throws IOException, HttpException {
        HttpResponse httpResponseNewHttpResponse;
        httpContext.setAttribute("http.connection", httpServerConnection);
        try {
            HttpRequest httpRequestReceiveRequestHeader = httpServerConnection.receiveRequestHeader();
            httpResponseNewHttpResponse = null;
            if (httpRequestReceiveRequestHeader instanceof HttpEntityEnclosingRequest) {
                if (((HttpEntityEnclosingRequest) httpRequestReceiveRequestHeader).expectContinue()) {
                    HttpResponse httpResponseNewHttpResponse2 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 100, httpContext);
                    if (this.expectationVerifier != null) {
                        try {
                            this.expectationVerifier.verify(httpRequestReceiveRequestHeader, httpResponseNewHttpResponse2, httpContext);
                        } catch (HttpException e) {
                            HttpResponse httpResponseNewHttpResponse3 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpContext);
                            handleException(e, httpResponseNewHttpResponse3);
                            httpResponseNewHttpResponse2 = httpResponseNewHttpResponse3;
                        }
                    }
                    if (httpResponseNewHttpResponse2.getStatusLine().getStatusCode() < 200) {
                        httpServerConnection.sendResponseHeader(httpResponseNewHttpResponse2);
                        httpServerConnection.flush();
                        httpServerConnection.receiveRequestEntity((HttpEntityEnclosingRequest) httpRequestReceiveRequestHeader);
                    } else {
                        httpResponseNewHttpResponse = httpResponseNewHttpResponse2;
                    }
                } else {
                    httpServerConnection.receiveRequestEntity((HttpEntityEnclosingRequest) httpRequestReceiveRequestHeader);
                }
                httpContext.setAttribute("http.request", httpRequestReceiveRequestHeader);
                if (httpResponseNewHttpResponse == null) {
                    httpResponseNewHttpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 200, httpContext);
                    this.processor.process(httpRequestReceiveRequestHeader, httpContext);
                    doService(httpRequestReceiveRequestHeader, httpResponseNewHttpResponse, httpContext);
                }
                if (httpRequestReceiveRequestHeader instanceof HttpEntityEnclosingRequest) {
                    EntityUtils.consume(((HttpEntityEnclosingRequest) httpRequestReceiveRequestHeader).getEntity());
                }
            } else {
                httpContext.setAttribute("http.request", httpRequestReceiveRequestHeader);
                if (httpResponseNewHttpResponse == null) {
                    httpResponseNewHttpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 200, httpContext);
                    this.processor.process(httpRequestReceiveRequestHeader, httpContext);
                    doService(httpRequestReceiveRequestHeader, httpResponseNewHttpResponse, httpContext);
                }
                if (httpRequestReceiveRequestHeader instanceof HttpEntityEnclosingRequest) {
                    EntityUtils.consume(((HttpEntityEnclosingRequest) httpRequestReceiveRequestHeader).getEntity());
                }
            }
        } catch (HttpException e2) {
            httpResponseNewHttpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpContext);
            handleException(e2, httpResponseNewHttpResponse);
        }
        httpContext.setAttribute("http.response", httpResponseNewHttpResponse);
        this.processor.process(httpResponseNewHttpResponse, httpContext);
        httpServerConnection.sendResponseHeader(httpResponseNewHttpResponse);
        httpServerConnection.sendResponseEntity(httpResponseNewHttpResponse);
        httpServerConnection.flush();
        if (this.connStrategy.keepAlive(httpResponseNewHttpResponse, httpContext)) {
            return;
        }
        httpServerConnection.close();
    }

    protected void handleException(HttpException httpException, HttpResponse httpResponse) {
        if (httpException instanceof MethodNotSupportedException) {
            httpResponse.setStatusCode(501);
        } else if (httpException instanceof UnsupportedHttpVersionException) {
            httpResponse.setStatusCode(505);
        } else if (httpException instanceof ProtocolException) {
            httpResponse.setStatusCode(400);
        } else {
            httpResponse.setStatusCode(500);
        }
        String message = httpException.getMessage();
        if (message == null) {
            message = httpException.toString();
        }
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(EncodingUtils.getAsciiBytes(message));
        byteArrayEntity.setContentType("text/plain; charset=US-ASCII");
        httpResponse.setEntity(byteArrayEntity);
    }

    protected void doService(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        HttpRequestHandler httpRequestHandlerLookup = this.handlerMapper != null ? this.handlerMapper.lookup(httpRequest) : null;
        if (httpRequestHandlerLookup != null) {
            httpRequestHandlerLookup.handle(httpRequest, httpResponse, httpContext);
        } else {
            httpResponse.setStatusCode(501);
        }
    }

    @Deprecated
    private static class HttpRequestHandlerResolverAdapter implements HttpRequestHandlerMapper {
        private final HttpRequestHandlerResolver resolver;

        public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver httpRequestHandlerResolver) {
            this.resolver = httpRequestHandlerResolver;
        }

        @Override // cz.msebera.android.httpclient.protocol.HttpRequestHandlerMapper
        public HttpRequestHandler lookup(HttpRequest httpRequest) {
            return this.resolver.lookup(httpRequest.getRequestLine().getUri());
        }
    }
}
