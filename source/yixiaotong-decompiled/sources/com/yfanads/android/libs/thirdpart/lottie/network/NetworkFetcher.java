package com.yfanads.android.libs.thirdpart.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.stub.StubApp;
import com.yfanads.android.libs.thirdpart.lottie.L;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.LottieCompositionFactory;
import com.yfanads.android.libs.thirdpart.lottie.LottieResult;
import com.yfanads.android.libs.thirdpart.lottie.LottieTask;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class NetworkFetcher {
    private final Context appContext;
    private final NetworkCache networkCache;
    private final String url;

    private NetworkFetcher(Context context, String str) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.appContext = origApplicationContext;
        this.url = str;
        this.networkCache = new NetworkCache(origApplicationContext, str);
    }

    private LottieTask<LottieComposition> fetch() {
        return new LottieTask<>(new Callable<LottieResult<LottieComposition>>() { // from class: com.yfanads.android.libs.thirdpart.lottie.network.NetworkFetcher.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return NetworkFetcher.this.fetchSync();
            }
        });
    }

    public static LottieTask<LottieComposition> fetch(Context context, String str) {
        return new NetworkFetcher(context, str).fetch();
    }

    private LottieComposition fetchFromCache() {
        Pair<FileExtension, InputStream> pairFetch = this.networkCache.fetch();
        if (pairFetch == null) {
            return null;
        }
        FileExtension fileExtension = pairFetch.first;
        InputStream inputStream = pairFetch.second;
        LottieResult<LottieComposition> lottieResultFromZipStreamSync = fileExtension == FileExtension.Zip ? LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), this.url) : LottieCompositionFactory.fromJsonInputStreamSync(inputStream, this.url);
        if (lottieResultFromZipStreamSync.getValue() != null) {
            return lottieResultFromZipStreamSync.getValue();
        }
        return null;
    }

    private LottieResult<LottieComposition> fetchFromNetwork() {
        try {
            return fetchFromNetworkInternal();
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:22:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:23:0x00bc  */
    private LottieResult fetchFromNetworkInternal() throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> lottieResultFromZipStreamSync;
        boolean z;
        L.debug("Fetching " + this.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
            String contentType = httpURLConnection.getContentType();
            int iHashCode = contentType.hashCode();
            if (iHashCode == -1248325150) {
                if (contentType.equals("application/zip")) {
                    L.debug("Handling zip response.");
                    fileExtension = FileExtension.Zip;
                    lottieResultFromZipStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.networkCache.writeTempCacheFile(httpURLConnection.getInputStream(), fileExtension))), this.url);
                }
                if (lottieResultFromZipStreamSync.getValue() != null) {
                    this.networkCache.renameTempFile(fileExtension);
                }
                StringBuilder sb = new StringBuilder("Completed fetch from network. Success: ");
                if (lottieResultFromZipStreamSync.getValue() != null) {
                    z = true;
                } else {
                    z = false;
                }
                L.debug(sb.append(z).toString());
                return lottieResultFromZipStreamSync;
            }
            if (iHashCode == -43840953) {
                contentType.equals("application/json");
            }
            L.debug("Received json response.");
            fileExtension = FileExtension.Json;
            lottieResultFromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(this.networkCache.writeTempCacheFile(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.url);
            if (lottieResultFromZipStreamSync.getValue() != null) {
                this.networkCache.renameTempFile(fileExtension);
            }
            StringBuilder sb2 = new StringBuilder("Completed fetch from network. Success: ");
            if (lottieResultFromZipStreamSync.getValue() != null) {
                z = true;
            } else {
                z = false;
            }
            L.debug(sb2.append(z).toString());
            return lottieResultFromZipStreamSync;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb3 = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return new LottieResult((Throwable) new IllegalArgumentException("Unable to fetch " + this.url + ". Failed with " + httpURLConnection.getResponseCode() + IOUtils.LINE_SEPARATOR_UNIX + ((Object) sb3)));
            }
            sb3.append(line).append('\n');
        }
    }

    public static LottieResult<LottieComposition> fetchSync(Context context, String str) {
        return new NetworkFetcher(context, str).fetchSync();
    }

    public LottieResult<LottieComposition> fetchSync() {
        LottieComposition lottieCompositionFetchFromCache = fetchFromCache();
        if (lottieCompositionFetchFromCache != null) {
            return new LottieResult<>(lottieCompositionFetchFromCache);
        }
        L.debug("Animation for " + this.url + " not found in cache. Fetching from network.");
        return fetchFromNetwork();
    }
}
