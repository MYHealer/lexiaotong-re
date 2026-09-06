package client.android.yixiaotong.util.retrofit;

import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.retrofit.client.Client;
import client.android.yixiaotong.util.retrofit.client.Header;
import client.android.yixiaotong.util.retrofit.client.Request;
import client.android.yixiaotong.util.retrofit.client.Response;
import client.android.yixiaotong.util.retrofit.converter.ConversionException;
import client.android.yixiaotong.util.retrofit.converter.Converter;
import client.android.yixiaotong.util.retrofit.mime.MimeUtil;
import client.android.yixiaotong.util.retrofit.mime.TypedByteArray;
import client.android.yixiaotong.util.retrofit.mime.TypedInput;
import client.android.yixiaotong.util.retrofit.mime.TypedOutput;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import cz.msebera.android.httpclient.HttpVersion;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RestAdapter {
    static final String IDLE_THREAD_NAME = "Retrofit-Idle";
    static final String THREAD_PREFIX = "Retrofit-";
    final Executor callbackExecutor;
    private final Client.Provider clientProvider;
    final Converter converter;
    final ErrorHandler errorHandler;
    final Executor httpExecutor;
    final Log log;
    volatile LogLevel logLevel;
    private String mTokenInfo;
    private final Profiler profiler;
    final RequestInterceptor requestInterceptor;
    final Endpoint server;
    private final Map<Class<?>, Map<Method, RestMethodInfo>> serviceMethodInfoCache;

    /* JADX INFO: renamed from: client.android.yixiaotong.util.retrofit.RestAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface Log {
        public static final Log NONE = new Log() { // from class: client.android.yixiaotong.util.retrofit.RestAdapter.Log.1
            @Override // client.android.yixiaotong.util.retrofit.RestAdapter.Log
            public void log(String str) {
            }
        };

        void log(String str);
    }

    public enum LogLevel {
        NONE,
        BASIC,
        HEADERS,
        HEADERS_AND_ARGS,
        FULL;

        public boolean log() {
            return this != NONE;
        }
    }

    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    /* synthetic */ RestAdapter(Endpoint endpoint, Client.Provider provider, Executor executor, Executor executor2, RequestInterceptor requestInterceptor, Converter converter, Profiler profiler, ErrorHandler errorHandler, Log log, LogLevel logLevel, AnonymousClass1 anonymousClass1) {
        this(endpoint, provider, executor, executor2, requestInterceptor, converter, profiler, errorHandler, log, logLevel);
    }

    private RestAdapter(Endpoint endpoint, Client.Provider provider, Executor executor, Executor executor2, RequestInterceptor requestInterceptor, Converter converter, Profiler profiler, ErrorHandler errorHandler, Log log, LogLevel logLevel) {
        this.mTokenInfo = "";
        this.serviceMethodInfoCache = new LinkedHashMap();
        this.server = endpoint;
        this.clientProvider = provider;
        this.httpExecutor = executor;
        this.callbackExecutor = executor2;
        this.requestInterceptor = requestInterceptor;
        this.converter = converter;
        this.profiler = profiler;
        this.errorHandler = errorHandler;
        this.log = log;
        this.logLevel = logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        if (this.logLevel == null) {
            throw new NullPointerException("Log level may not be null.");
        }
        this.logLevel = logLevel;
    }

    public <T> T create(Class<T> cls) {
        Utils.validateServiceClass(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new RestHandler(getMethodInfoCache(cls)));
    }

    Map<Method, RestMethodInfo> getMethodInfoCache(Class<?> cls) {
        Map<Method, RestMethodInfo> linkedHashMap;
        synchronized (this.serviceMethodInfoCache) {
            linkedHashMap = this.serviceMethodInfoCache.get(cls);
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>();
                this.serviceMethodInfoCache.put(cls, linkedHashMap);
            }
        }
        return linkedHashMap;
    }

    static RestMethodInfo getMethodInfo(Map<Method, RestMethodInfo> map, Method method) {
        RestMethodInfo restMethodInfo;
        synchronized (map) {
            restMethodInfo = map.get(method);
            if (restMethodInfo == null) {
                restMethodInfo = new RestMethodInfo(method);
                map.put(method, restMethodInfo);
            }
        }
        return restMethodInfo;
    }

    private class RestHandler implements InvocationHandler {
        private final Map<Method, RestMethodInfo> methodDetailsCache;

        RestHandler(Map<Method, RestMethodInfo> map) {
            this.methodDetailsCache = map;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, final Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            final RestMethodInfo methodInfo = RestAdapter.getMethodInfo(this.methodDetailsCache, method);
            if (methodInfo.isSynchronous) {
                try {
                    return invokeRequest(RestAdapter.this.requestInterceptor, methodInfo, objArr);
                } catch (RetrofitError e) {
                    Throwable thHandleError = RestAdapter.this.errorHandler.handleError(e);
                    if (thHandleError == null) {
                        throw new IllegalStateException("Error handler returned null for wrapped exception.", e);
                    }
                    throw thHandleError;
                }
            }
            if (RestAdapter.this.httpExecutor == null || RestAdapter.this.callbackExecutor == null) {
                throw new IllegalStateException("Asynchronous invocation requires calling setExecutors.");
            }
            final RequestInterceptorTape requestInterceptorTape = new RequestInterceptorTape();
            RestAdapter.this.requestInterceptor.intercept(requestInterceptorTape);
            RestAdapter.this.httpExecutor.execute(new CallbackRunnable((Callback) objArr[objArr.length - 1], RestAdapter.this.callbackExecutor, RestAdapter.this.errorHandler) { // from class: client.android.yixiaotong.util.retrofit.RestAdapter.RestHandler.1
                @Override // client.android.yixiaotong.util.retrofit.CallbackRunnable
                public ResponseWrapper obtainResponse() {
                    return (ResponseWrapper) RestHandler.this.invokeRequest(requestInterceptorTape, methodInfo, objArr);
                }
            });
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object invokeRequest(RequestInterceptor requestInterceptor, RestMethodInfo restMethodInfo, Object[] objArr) {
            String str = null;
            try {
                try {
                    try {
                        restMethodInfo.init();
                        String url = RestAdapter.this.server.getUrl();
                        RequestBuilder requestBuilder = new RequestBuilder(url, restMethodInfo, RestAdapter.this.converter);
                        requestBuilder.setArguments(objArr);
                        requestInterceptor.intercept(requestBuilder);
                        Request requestBuild = requestBuilder.build();
                        String url2 = requestBuild.getUrl();
                        try {
                            RestAdapter.this.log.log(String.format("---> RestAdapter %s   %s", url2, url));
                            if (!restMethodInfo.isSynchronous) {
                                int iIndexOf = url2.indexOf("?", url.length());
                                if (iIndexOf == -1) {
                                    iIndexOf = url2.length();
                                }
                                Thread.currentThread().setName(RestAdapter.THREAD_PREFIX + url2.substring(url.length(), iIndexOf));
                            }
                            if (RestAdapter.this.logLevel.log()) {
                                requestBuild = RestAdapter.this.logAndReplaceRequest(HttpVersion.HTTP, requestBuild, objArr);
                            }
                            Object objBeforeCall = RestAdapter.this.profiler != null ? RestAdapter.this.profiler.beforeCall() : null;
                            long jNanoTime = System.nanoTime();
                            Response responseExecute = RestAdapter.this.clientProvider.get().execute(requestBuild);
                            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
                            int status = responseExecute.getStatus();
                            if (RestAdapter.this.profiler != null) {
                                RestAdapter.this.profiler.afterCall(RestAdapter.getRequestInfo(url, restMethodInfo, requestBuild), millis, status, objBeforeCall);
                            }
                            if (RestAdapter.this.logLevel.log()) {
                                responseExecute = RestAdapter.this.logAndReplaceResponse(url2, responseExecute, millis);
                            }
                            Response bodyToBytesIfNecessary = responseExecute;
                            Type type = restMethodInfo.responseObjectType;
                            if (status < 200 || status > 500) {
                                throw RetrofitError.httpError(url2, Utils.readBodyToBytesIfNecessary(bodyToBytesIfNecessary), RestAdapter.this.converter, type);
                            }
                            if (type.equals(Response.class)) {
                                if (!restMethodInfo.isStreaming) {
                                    bodyToBytesIfNecessary = Utils.readBodyToBytesIfNecessary(bodyToBytesIfNecessary);
                                }
                                if (restMethodInfo.isSynchronous) {
                                    if (!restMethodInfo.isSynchronous) {
                                        Thread.currentThread().setName(RestAdapter.IDLE_THREAD_NAME);
                                    }
                                    return bodyToBytesIfNecessary;
                                }
                                ResponseWrapper responseWrapper = new ResponseWrapper(bodyToBytesIfNecessary, bodyToBytesIfNecessary);
                                if (!restMethodInfo.isSynchronous) {
                                    Thread.currentThread().setName(RestAdapter.IDLE_THREAD_NAME);
                                }
                                return responseWrapper;
                            }
                            TypedInput body = bodyToBytesIfNecessary.getBody();
                            if (body == null) {
                                if (restMethodInfo.isSynchronous) {
                                    if (!restMethodInfo.isSynchronous) {
                                        Thread.currentThread().setName(RestAdapter.IDLE_THREAD_NAME);
                                    }
                                    return null;
                                }
                                ResponseWrapper responseWrapper2 = new ResponseWrapper(bodyToBytesIfNecessary, null);
                                if (!restMethodInfo.isSynchronous) {
                                    Thread.currentThread().setName(RestAdapter.IDLE_THREAD_NAME);
                                }
                                return responseWrapper2;
                            }
                            ExceptionCatchingTypedInput exceptionCatchingTypedInput = new ExceptionCatchingTypedInput(body);
                            try {
                                Object objFromBody = StringUtils.isEmpty(RestAdapter.this.mTokenInfo) ? RestAdapter.this.converter.fromBody(exceptionCatchingTypedInput, type) : RestAdapter.this.converter.fromBody(exceptionCatchingTypedInput, type, RestAdapter.this.mTokenInfo);
                                RestAdapter.this.logResponseBody(body, objFromBody);
                                if (restMethodInfo.isSynchronous) {
                                    if (!restMethodInfo.isSynchronous) {
                                        Thread.currentThread().setName(RestAdapter.IDLE_THREAD_NAME);
                                    }
                                    return objFromBody;
                                }
                                ResponseWrapper responseWrapper3 = new ResponseWrapper(bodyToBytesIfNecessary, objFromBody);
                                if (!restMethodInfo.isSynchronous) {
                                    Thread.currentThread().setName(RestAdapter.IDLE_THREAD_NAME);
                                }
                                return responseWrapper3;
                            } catch (ConversionException e) {
                                if (exceptionCatchingTypedInput.threwException()) {
                                    throw exceptionCatchingTypedInput.getThrownException();
                                }
                                Response responseReplaceResponseBody = Utils.replaceResponseBody(bodyToBytesIfNecessary, null);
                                RestAdapter.this.log.log(String.format("--->test    %s   %s", url2, responseReplaceResponseBody.getUrl()));
                                throw RetrofitError.conversionError(url2, responseReplaceResponseBody, RestAdapter.this.converter, type, e);
                            }
                        } catch (IOException e2) {
                            e = e2;
                            str = url2;
                            if (RestAdapter.this.logLevel.log()) {
                                RestAdapter.this.logException(e, str);
                            }
                            throw RetrofitError.networkError(str, e);
                        } catch (Throwable th) {
                            th = th;
                            str = url2;
                            if (RestAdapter.this.logLevel.log()) {
                                RestAdapter.this.logException(th, str);
                            }
                            throw RetrofitError.unexpectedError(str, th);
                        }
                    } catch (RetrofitError e3) {
                        throw e3;
                    }
                } catch (IOException e4) {
                    e = e4;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                if (!restMethodInfo.isSynchronous) {
                    Thread.currentThread().setName(RestAdapter.IDLE_THREAD_NAME);
                }
                throw th3;
            }
        }
    }

    Request logAndReplaceRequest(String str, Request request, Object[] objArr) throws IOException {
        String str2;
        String[] strArrSplit;
        this.log.log(String.format("---> %s %s %s", str, request.getMethod(), request.getUrl()));
        StringBuilder sb = new StringBuilder();
        if (this.logLevel.ordinal() >= LogLevel.HEADERS.ordinal()) {
            for (Header header : request.getHeaders()) {
                this.log.log(header.toString());
                sb.append(header.toString());
            }
            LocalDataUtil.saveErrorHeader(BaseApplication.app, sb.toString());
            TypedOutput body = request.getBody();
            if (body != null) {
                String strMimeType = body.mimeType();
                if (strMimeType != null) {
                    this.log.log("Content-Type: " + strMimeType);
                }
                long length = body.length();
                str2 = length + "-byte";
                if (length != -1) {
                    this.log.log("Content-Length: " + length);
                }
                if (this.logLevel.ordinal() >= LogLevel.FULL.ordinal()) {
                    if (!request.getHeaders().isEmpty()) {
                        this.log.log("");
                    }
                    if (!(body instanceof TypedByteArray)) {
                        request = Utils.readBodyToBytesIfNecessary(request);
                        body = request.getBody();
                    }
                    byte[] bytes = ((TypedByteArray) body).getBytes();
                    String charset = MimeUtil.parseCharset(body.mimeType(), "UTF-8");
                    this.log.log(new String(bytes, charset));
                    LocalDataUtil.saveErrorBody(BaseApplication.app, new String(bytes, charset));
                } else if (this.logLevel.ordinal() >= LogLevel.HEADERS_AND_ARGS.ordinal()) {
                    if (!request.getHeaders().isEmpty()) {
                        this.log.log("---> REQUEST:");
                    }
                    for (int i = 0; i < objArr.length; i++) {
                        this.log.log("#" + i + ": " + objArr[i]);
                    }
                }
            } else {
                str2 = "no";
            }
            if (str2.equals("no")) {
                String url = request.getUrl();
                if (StringUtils.isNotEmpty(url) && url.contains("?") && (strArrSplit = url.split("\\?")) != null && strArrSplit.length >= 2) {
                    LocalDataUtil.saveErrorBody(BaseApplication.app, strArrSplit[1]);
                }
            }
            this.log.log(String.format("---> END %s (%s body)", str, str2));
        }
        return request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response logAndReplaceResponse(String str, Response response, long j) throws IOException {
        long length;
        this.log.log(String.format("<--- HTTP %s %s (%sms)", Integer.valueOf(response.getStatus()), str, Long.valueOf(j)));
        LocalDataUtil.saveCode(BaseApplication.app, response.getStatus());
        if (response.getStatus() >= 500 && response.getStatus() < 600) {
            LocalDataUtil.saveErrorUrl(BaseApplication.app, str);
        }
        StringBuilder sb = new StringBuilder();
        if (this.logLevel.ordinal() >= LogLevel.HEADERS.ordinal()) {
            for (Header header : response.getHeaders()) {
                this.log.log(header.toString());
                sb.append(header.toString());
                if (header.getName().equalsIgnoreCase("Set-Cookie") && header.getValue().split(";")[0].contains("tokenInfo")) {
                    this.log.log(header.getValue().split(";")[0]);
                    this.mTokenInfo = header.getValue().split(";")[0];
                }
                if (header.getName().equalsIgnoreCase("x-route")) {
                    LocalDataUtil.saveRoute(BaseApplication.app, header.getValue());
                }
            }
            LocalDataUtil.saveErrorHeaderResponse(BaseApplication.app, sb.toString());
            TypedInput body = response.getBody();
            if (body != null) {
                length = body.length();
                if (this.logLevel.ordinal() >= LogLevel.FULL.ordinal()) {
                    if (!response.getHeaders().isEmpty()) {
                        this.log.log("");
                    }
                    if (!(body instanceof TypedByteArray)) {
                        response = Utils.readBodyToBytesIfNecessary(response);
                        body = response.getBody();
                    }
                    byte[] bytes = ((TypedByteArray) body).getBytes();
                    long length2 = bytes.length;
                    String charset = MimeUtil.parseCharset(body.mimeType(), "UTF-8");
                    this.log.log(new String(bytes, charset));
                    LocalDataUtil.saveErrorBodyResponse(BaseApplication.app, new String(bytes, charset));
                    length = length2;
                }
            } else {
                length = 0;
            }
            this.log.log(String.format("<--- END HTTP (%s-byte body)", Long.valueOf(length)));
        }
        return response;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logResponseBody(TypedInput typedInput, Object obj) {
        if (this.logLevel.ordinal() == LogLevel.HEADERS_AND_ARGS.ordinal()) {
            this.log.log("<--- BODY:");
            this.log.log(obj.toString());
        }
    }

    void logException(Throwable th, String str) {
        Log log = this.log;
        Object[] objArr = new Object[1];
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        log.log(String.format("---- ERROR %s", objArr));
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        this.log.log(stringWriter.toString());
        this.log.log("---- END ERROR");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Profiler.RequestInformation getRequestInfo(String str, RestMethodInfo restMethodInfo, Request request) {
        long length;
        String strMimeType;
        TypedOutput body = request.getBody();
        if (body != null) {
            length = body.length();
            strMimeType = body.mimeType();
        } else {
            length = 0;
            strMimeType = null;
        }
        long j = length;
        return new Profiler.RequestInformation(restMethodInfo.requestMethod, str, restMethodInfo.requestUrl, j, strMimeType);
    }

    public static class Builder {
        private Executor callbackExecutor;
        private Client.Provider clientProvider;
        private Converter converter;
        private Endpoint endpoint;
        private ErrorHandler errorHandler;
        private Executor httpExecutor;
        private Log log;
        private LogLevel logLevel = LogLevel.NONE;
        private Profiler profiler;
        private RequestInterceptor requestInterceptor;

        public Builder setEndpoint(String str) {
            if (str == null || str.trim().length() == 0) {
                throw new NullPointerException("Endpoint may not be blank.");
            }
            this.endpoint = Endpoints.newFixedEndpoint(str);
            return this;
        }

        public Builder setEndpoint(Endpoint endpoint) {
            if (endpoint == null) {
                throw new NullPointerException("Endpoint may not be null.");
            }
            this.endpoint = endpoint;
            return this;
        }

        public Builder setClient(final Client client2) {
            if (client2 == null) {
                throw new NullPointerException("Client may not be null.");
            }
            return setClient(new Client.Provider() { // from class: client.android.yixiaotong.util.retrofit.RestAdapter.Builder.1
                @Override // client.android.yixiaotong.util.retrofit.client.Client.Provider
                public Client get() {
                    return client2;
                }
            });
        }

        public Builder setClient(Client.Provider provider) {
            if (provider == null) {
                throw new NullPointerException("Client provider may not be null.");
            }
            this.clientProvider = provider;
            return this;
        }

        public Builder setExecutors(Executor executor, Executor executor2) {
            if (executor == null) {
                throw new NullPointerException("HTTP executor may not be null.");
            }
            if (executor2 == null) {
                executor2 = new Utils.SynchronousExecutor();
            }
            this.httpExecutor = executor;
            this.callbackExecutor = executor2;
            return this;
        }

        public Builder setRequestInterceptor(RequestInterceptor requestInterceptor) {
            if (requestInterceptor == null) {
                throw new NullPointerException("Request interceptor may not be null.");
            }
            this.requestInterceptor = requestInterceptor;
            return this;
        }

        public Builder setConverter(Converter converter) {
            if (converter == null) {
                throw new NullPointerException("Converter may not be null.");
            }
            this.converter = converter;
            return this;
        }

        public Builder setProfiler(Profiler profiler) {
            if (profiler == null) {
                throw new NullPointerException("Profiler may not be null.");
            }
            this.profiler = profiler;
            return this;
        }

        public Builder setErrorHandler(ErrorHandler errorHandler) {
            if (errorHandler == null) {
                throw new NullPointerException("Error handler may not be null.");
            }
            this.errorHandler = errorHandler;
            return this;
        }

        public Builder setLog(Log log) {
            if (log == null) {
                throw new NullPointerException("Log may not be null.");
            }
            this.log = log;
            return this;
        }

        public Builder setLogLevel(LogLevel logLevel) {
            if (logLevel == null) {
                throw new NullPointerException("Log level may not be null.");
            }
            this.logLevel = logLevel;
            return this;
        }

        public RestAdapter build() {
            if (this.endpoint == null) {
                throw new IllegalArgumentException("Endpoint may not be null.");
            }
            ensureSaneDefaults();
            this.log.log(String.format("---> RestAdapter endpoint %s", this.endpoint));
            return new RestAdapter(this.endpoint, this.clientProvider, this.httpExecutor, this.callbackExecutor, this.requestInterceptor, this.converter, this.profiler, this.errorHandler, this.log, this.logLevel, null);
        }

        private void ensureSaneDefaults() {
            if (this.converter == null) {
                this.converter = Platform.get().defaultConverter();
            }
            if (this.clientProvider == null) {
                this.clientProvider = Platform.get().defaultClient();
            }
            if (this.httpExecutor == null) {
                this.httpExecutor = Platform.get().defaultHttpExecutor();
            }
            if (this.callbackExecutor == null) {
                this.callbackExecutor = Platform.get().defaultCallbackExecutor();
            }
            if (this.errorHandler == null) {
                this.errorHandler = ErrorHandler.DEFAULT;
            }
            if (this.log == null) {
                this.log = Platform.get().defaultLog();
            }
            if (this.requestInterceptor == null) {
                this.requestInterceptor = RequestInterceptor.NONE;
            }
        }
    }
}
