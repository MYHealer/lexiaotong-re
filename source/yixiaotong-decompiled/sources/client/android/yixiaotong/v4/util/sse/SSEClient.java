package client.android.yixiaotong.v4.util.sse;

import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SSEClient {
    private static final long RECONNECT_DELAY_MS = 3000;
    private static final String TAG = "SSEClient";
    private final SSECallback callback;
    private boolean isConnected;
    private final String url;
    private boolean shouldReconnect = true;

    /* JADX INFO: renamed from: client, reason: collision with root package name */
    private OkHttpClient f968client = createHttpClient();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public interface SSECallback {
        void onConnected();

        void onError(Throwable th);

        void onEvent(String str);

        void onId(String str);

        void onMessage(String str);

        void onReconnecting();

        void onRetry(long j);
    }

    public SSEClient(String str, SSECallback sSECallback) {
        this.url = str;
        this.callback = sSECallback;
    }

    public void connect() {
        this.shouldReconnect = true;
        connectInternal();
    }

    public void disconnect() {
        this.shouldReconnect = false;
        this.isConnected = false;
        OkHttpClient okHttpClient = this.f968client;
        if (okHttpClient != null) {
            okHttpClient.dispatcher().cancelAll();
        }
        ScheduledExecutorService scheduledExecutorService = this.scheduler;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }

    private void connectInternal() {
        this.f968client.newCall(new Request.Builder().url(this.url).header("Accept", "text/event-stream").header("Cache-Control", HeaderConstants.CACHE_CONTROL_NO_CACHE).build()).enqueue(new Callback() { // from class: client.android.yixiaotong.v4.util.sse.SSEClient.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                SSEClient.this.callback.onError(iOException);
                SSEClient.this.reconnect();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String line;
                if (!response.isSuccessful()) {
                    SSEClient.this.callback.onError(new IOException("Unexpected code " + response));
                    SSEClient.this.reconnect();
                    return;
                }
                SSEClient.this.isConnected = true;
                SSEClient.this.callback.onConnected();
                try {
                    try {
                        ResponseBody responseBodyBody = response.body();
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(responseBodyBody.byteStream()));
                            while (SSEClient.this.isConnected && (line = bufferedReader.readLine()) != null) {
                                try {
                                    SSEClient.this.processLine(line);
                                } catch (Throwable th) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                    throw th;
                                }
                            }
                            bufferedReader.close();
                            if (responseBodyBody != null) {
                                responseBodyBody.close();
                            }
                            if (!SSEClient.this.isConnected) {
                                return;
                            }
                            SSEClient.this.reconnect();
                        } catch (Throwable th3) {
                            if (responseBodyBody != null) {
                                try {
                                    responseBodyBody.close();
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                }
                            }
                            throw th3;
                        }
                    } catch (IOException e) {
                        SSEClient.this.callback.onError(e);
                        if (!SSEClient.this.isConnected) {
                        }
                    }
                } catch (Throwable th5) {
                    if (SSEClient.this.isConnected) {
                        SSEClient.this.reconnect();
                    }
                    throw th5;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processLine(String str) {
        if (str.startsWith("data:")) {
            this.callback.onMessage(str.substring(5).trim());
            return;
        }
        if (str.startsWith("event:")) {
            this.callback.onEvent(str.substring(6).trim());
            return;
        }
        if (str.startsWith("id:")) {
            this.callback.onId(str.substring(3).trim());
        } else if (str.startsWith("retry:")) {
            try {
                this.callback.onRetry(Long.parseLong(str.substring(6).trim()));
            } catch (NumberFormatException e) {
                this.callback.onError(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnect() {
        if (this.shouldReconnect) {
            this.callback.onReconnecting();
            this.scheduler.schedule(new Runnable() { // from class: client.android.yixiaotong.v4.util.sse.SSEClient$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m573xb4fb7284();
                }
            }, 3000L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: renamed from: lambda$reconnect$0$client-android-yixiaotong-v4-util-sse-SSEClient, reason: not valid java name */
    /* synthetic */ void m573xb4fb7284() {
        if (this.shouldReconnect) {
            connectInternal();
        }
    }

    private OkHttpClient createHttpClient() {
        return new OkHttpClient.Builder().connectTimeout(0L, TimeUnit.SECONDS).readTimeout(0L, TimeUnit.SECONDS).writeTimeout(0L, TimeUnit.SECONDS).build();
    }
}
