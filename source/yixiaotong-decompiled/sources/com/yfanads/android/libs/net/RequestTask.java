package com.yfanads.android.libs.net;

import android.text.TextUtils;
import android.util.Log;
import com.yfanads.android.libs.utils.NamedThreadFactory;
import com.yfanads.android.libs.utils.RejectedExeHandler;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class RequestTask {
    private static final int CORE_POOL_SIZE;
    private static final Dispatcher DISPATCHER;
    private static final long KEEP_ALIVE_TIME = 60;
    public static final String TAG = "RequestTask";
    private static final ThreadPoolExecutor THREAD_POOL;

    public static final class Dispatcher {
        private static final int MAX_REQUESTS = 6;
        private final Deque<Runnable> readyQueue;
        private final Set<Runnable> runningJobs;
        private static final String KEY = "rtNetwork";
        private static final ThreadPoolExecutor THREAD_RT_POOL = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new NamedThreadFactory(KEY), new RejectedExeHandler(KEY));

        private Dispatcher() {
            this.readyQueue = new ArrayDeque();
            this.runningJobs = new HashSet();
        }

        private void promoteCalls() {
            while (this.runningJobs.size() < 6 && !this.readyQueue.isEmpty()) {
                Log.d(KEY, "finished: run" + this.runningJobs.size() + "|queue" + this.readyQueue.size());
                Runnable runnableRemoveFirst = this.readyQueue.removeFirst();
                this.runningJobs.add(runnableRemoveFirst);
                THREAD_RT_POOL.execute(runnableRemoveFirst);
            }
        }

        public synchronized void enqueue(Runnable runnable) {
            if (this.runningJobs.size() < 6) {
                this.runningJobs.add(runnable);
                THREAD_RT_POOL.execute(runnable);
                Log.d(KEY, "enqueue: run" + this.runningJobs.size() + "|queue" + this.readyQueue.size());
            } else {
                this.readyQueue.addLast(runnable);
            }
        }

        public synchronized void finished(Runnable runnable) {
            if (this.runningJobs.remove(runnable)) {
                promoteCalls();
            } else {
                Log.e(KEY, "runningJobs is not task, return. ");
            }
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CORE_POOL_SIZE = iAvailableProcessors;
        THREAD_POOL = new ThreadPoolExecutor(iAvailableProcessors > 0 ? iAvailableProcessors * 3 : 3, iAvailableProcessors * 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("network"), new RejectedExeHandler("network"));
        DISPATCHER = new Dispatcher();
    }

    public RequestTask() {
    }

    public RequestTask(String str, File file, List<File> list, Map<String, File> map, String str2, String str3, String str4, Map<String, String> map2, Map<String, String> map3, NetCallBack<?> netCallBack) {
        urlHttpUploadFile(str, file, list, map, str2, str3, str4, map2, map3, netCallBack);
    }

    public RequestTask(String str, String str2, Map<String, String> map, Map<String, String> map2, NetCallBack<?> netCallBack) {
        str.getClass();
        if (str.equals("GET")) {
            urlHttpGet(str2, map, map2, netCallBack);
        } else if (str.equals("POST")) {
            urlHttpPost(str2, map, null, map2, netCallBack);
        }
    }

    public RequestTask(String str, String str2, Map<String, String> map, boolean z, NetCallBack<?> netCallBack) {
        if (z) {
            urlHttpPostByTry(str, null, str2, map, netCallBack);
        } else {
            urlHttpPost(str, null, str2, map, netCallBack);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPostBody(Map<String, String> map, String str) {
        if (map != null) {
            return getPostBodyFormParameMap(map);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    private String getPostBodyFormParameMap(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        try {
            boolean z = true;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPostBodyType(Map<String, String> map, String str) {
        if (map == null && !TextUtils.isEmpty(str)) {
            return "application/json;charset=utf-8";
        }
        return null;
    }

    private String getUrl(String str, Map<String, String> map) {
        if (map == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str + "?");
        for (String str2 : map.keySet()) {
            sb.append(str2).append("=").append(map.get(str2)).append("&");
        }
        String string = sb.toString();
        return string.substring(0, string.length() - 1);
    }

    static /* synthetic */ void lambda$isNetAvailability$1(String str, Map map, NetCallBack netCallBack) throws Throwable {
        try {
            if (new BaseRequest().isNetAvailability(str, map)) {
                netCallBack.onSuccess();
            } else {
                netCallBack.onError(UrlConst.ERROR_CODE, "network error");
            }
        } catch (Exception e) {
            Log.e(TAG, "isNetAvailability: " + e.getMessage());
            netCallBack.onError(new BaseResponse(UrlConst.ERROR_CODE, e));
        }
    }

    static /* synthetic */ void lambda$urlHttpUploadFile$3(String str, File file, List list, Map map, String str2, String str3, String str4, Map map2, Map map3, NetCallBack netCallBack) throws Throwable {
        try {
            BaseResponse baseResponseUploadFile = new BaseRequest().uploadFile(str, file, list, map, str2, str3, str4, map2, map3, netCallBack);
            if (baseResponseUploadFile.code == 200) {
                netCallBack.onSuccess(baseResponseUploadFile);
            } else {
                netCallBack.onError(baseResponseUploadFile);
            }
        } catch (Exception e) {
            Log.e(TAG, "urlHttpUploadFile: " + e.getMessage());
        }
    }

    private void urlHttpGet(final String str, final Map<String, String> map, final Map<String, String> map2, final NetCallBack<?> netCallBack) {
        THREAD_POOL.submit(new Runnable() { // from class: com.yfanads.android.libs.net.RequestTask$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.m1263lambda$urlHttpGet$0$comyfanadsandroidlibsnetRequestTask(str, map, map2, netCallBack);
            }
        });
    }

    private void urlHttpPost(final String str, final Map<String, String> map, final String str2, final Map<String, String> map2, final NetCallBack<?> netCallBack) {
        THREAD_POOL.submit(new Runnable() { // from class: com.yfanads.android.libs.net.RequestTask$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.m1264lambda$urlHttpPost$2$comyfanadsandroidlibsnetRequestTask(str, map, str2, map2, netCallBack);
            }
        });
    }

    private void urlHttpPostByTry(final String str, final Map<String, String> map, final String str2, final Map<String, String> map2, final NetCallBack<?> netCallBack) {
        DISPATCHER.enqueue(new Runnable() { // from class: com.yfanads.android.libs.net.RequestTask.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        BaseResponse baseResponsePostDataByRetry = new BaseRequest().postDataByRetry(str, RequestTask.this.getPostBody(map, str2), RequestTask.this.getPostBodyType(map, str2), map2);
                        if (baseResponsePostDataByRetry.code == 200) {
                            netCallBack.onSuccess(baseResponsePostDataByRetry);
                        } else {
                            netCallBack.onError(baseResponsePostDataByRetry);
                        }
                    } catch (Exception e) {
                        Log.e(RequestTask.TAG, "urlHttpPostByTry: " + e.getMessage());
                        netCallBack.onError(new BaseResponse(UrlConst.ERROR_CODE, e));
                    }
                } finally {
                    RequestTask.DISPATCHER.finished(this);
                }
            }
        });
    }

    private void urlHttpUploadFile(final String str, final File file, final List<File> list, final Map<String, File> map, final String str2, final String str3, final String str4, final Map<String, String> map2, final Map<String, String> map3, final NetCallBack<?> netCallBack) {
        THREAD_POOL.submit(new Runnable() { // from class: com.yfanads.android.libs.net.RequestTask$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                RequestTask.lambda$urlHttpUploadFile$3(str, file, list, map, str2, str3, str4, map2, map3, netCallBack);
            }
        });
    }

    public void isNetAvailability(final String str, final Map<String, String> map, final NetCallBack<?> netCallBack) {
        THREAD_POOL.submit(new Runnable() { // from class: com.yfanads.android.libs.net.RequestTask$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                RequestTask.lambda$isNetAvailability$1(str, map, netCallBack);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$urlHttpGet$0$com-yfanads-android-libs-net-RequestTask, reason: not valid java name */
    /* synthetic */ void m1263lambda$urlHttpGet$0$comyfanadsandroidlibsnetRequestTask(String str, Map map, Map map2, NetCallBack netCallBack) throws Throwable {
        try {
            BaseResponse data = new BaseRequest().getData(getUrl(str, map), map2);
            if (data.code == 200) {
                netCallBack.onSuccess(data);
            } else {
                netCallBack.onError(data);
            }
        } catch (Exception e) {
            Log.e(TAG, "urlHttpGet: " + e.getMessage());
            netCallBack.onError(new BaseResponse(UrlConst.ERROR_CODE, e));
        }
    }

    /* JADX INFO: renamed from: lambda$urlHttpPost$2$com-yfanads-android-libs-net-RequestTask, reason: not valid java name */
    /* synthetic */ void m1264lambda$urlHttpPost$2$comyfanadsandroidlibsnetRequestTask(String str, Map map, String str2, Map map2, NetCallBack netCallBack) throws Throwable {
        try {
            BaseResponse baseResponsePostData = new BaseRequest().postData(str, getPostBody(map, str2), getPostBodyType(map, str2), map2);
            if (baseResponsePostData.code == 200) {
                netCallBack.onSuccess(baseResponsePostData);
            } else {
                netCallBack.onError(baseResponsePostData);
            }
        } catch (Exception e) {
            Log.e(TAG, "urlHttpPost: " + e.getMessage());
            netCallBack.onError(new BaseResponse(UrlConst.ERROR_CODE, e));
        }
    }
}
