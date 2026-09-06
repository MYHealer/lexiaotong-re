package client.android.yixiaotong.util.http;

import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import client.android.yixiaotong.util.executor.AsyncExecutor;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.retrofit.ErrorHandler;
import client.android.yixiaotong.util.retrofit.RequestInterceptor;
import client.android.yixiaotong.util.retrofit.RestAdapter;
import client.android.yixiaotong.util.retrofit.RetrofitError;
import client.android.yixiaotong.util.retrofit.client.OkClient;
import client.android.yixiaotong.util.retrofit.converter.GsonConverter;
import com.google.android.exoplayer2.C;
import com.huawei.openalliance.ad.constant.x;
import com.squareup.okhttp.OkHttpClient;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.net.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HttpProtocolFactoryJava {
    private final OkClient mOkClient;
    private final OkHttpClient mOkHttpClient;
    private final Map<String, Object> sHttpProtocolMap;

    /* JADX INFO: renamed from: client.android.yixiaotong.util.http.HttpProtocolFactoryJava$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ HttpProtocolFactoryJava(AnonymousClass1 anonymousClass1) {
        this();
    }

    private HttpProtocolFactoryJava() {
        this.sHttpProtocolMap = new ConcurrentHashMap();
        OkHttpClient okHttpClient = new OkHttpClient();
        this.mOkHttpClient = okHttpClient;
        okHttpClient.setConnectTimeout(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, TimeUnit.MILLISECONDS);
        okHttpClient.setProxy(Proxy.NO_PROXY);
        this.mOkClient = new OkClient(okHttpClient);
    }

    private static class SingletonHolder {
        public static final HttpProtocolFactoryJava INSTANCE = new HttpProtocolFactoryJava(null);

        private SingletonHolder() {
        }
    }

    public static HttpProtocolFactoryJava getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public <T> T getProtocol(String str, Class<T> cls) {
        if (StringUtils.isNotEmpty(str) && !str.contains("9444")) {
            String[] strArrSplit = str.split(x.bQ);
            if (strArrSplit.length == 3) {
                new LocalPreferencesHelper(BaseApplication.app, ClientCookie.PORT_ATTR).saveOrUpdate("localport", strArrSplit[2].replace("/", ""));
            }
        }
        if (this.sHttpProtocolMap.containsKey(cls.getName() + str)) {
            return (T) this.sHttpProtocolMap.get(cls.getName() + str);
        }
        AnonymousClass1 anonymousClass1 = null;
        T t = (T) new RestAdapter.Builder().setEndpoint(str).setClient(this.mOkClient).setExecutors(AsyncExecutor.getInstance(), MainThreadExecutor.getInstance()).setErrorHandler(new MyErrorHandler(anonymousClass1)).setConverter(new GsonConverter(GsonUtils.getInstance().getGson())).setRequestInterceptor(new MyRequestInterceptor(anonymousClass1)).setLogLevel(RestAdapter.LogLevel.FULL).build().create(cls);
        this.sHttpProtocolMap.put(cls.getName() + str, t);
        return t;
    }

    public void cancelRequest(String str) {
        this.mOkHttpClient.cancel(str);
    }

    private static class MyErrorHandler implements ErrorHandler {
        private MyErrorHandler() {
        }

        /* synthetic */ MyErrorHandler(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // client.android.yixiaotong.util.retrofit.ErrorHandler
        public Throwable handleError(RetrofitError retrofitError) {
            retrofitError.printStackTrace();
            return HttpExceptionFilter.getDefaultHttpException();
        }
    }

    private static class MyRequestInterceptor implements RequestInterceptor {
        private MyRequestInterceptor() {
        }

        /* synthetic */ MyRequestInterceptor(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // client.android.yixiaotong.util.retrofit.RequestInterceptor
        public void intercept(RequestInterceptor.RequestFacade requestFacade) {
            requestFacade.addHeader("User-Agent", "Client-Android");
        }
    }
}
