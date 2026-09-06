package com.android.volley.toolbox;

import android.os.SystemClock;
import com.alipay.sdk.app.statistic.c;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.RedirectError;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BasicNetwork implements Network {
    protected static final boolean DEBUG = VolleyLog.DEBUG;
    private static int DEFAULT_POOL_SIZE = 4096;
    private static int SLOW_REQUEST_THRESHOLD_MS = 3000;
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;

    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(DEFAULT_POOL_SIZE));
    }

    public BasicNetwork(HttpStack httpStack, ByteArrayPool byteArrayPool) {
        this.mHttpStack = httpStack;
        this.mPool = byteArrayPool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [com.android.volley.toolbox.BasicNetwork] */
    @Override // com.android.volley.Network
    public NetworkResponse performRequest(Request<?> request) throws VolleyError {
        ?? r17;
        byte[] bArr;
        ?? r1;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Map<String, String> mapEmptyMap = Collections.emptyMap();
            HttpResponse httpResponse = null;
            try {
                try {
                    HashMap map = new HashMap();
                    addCacheHeaders(map, request.getCacheEntry());
                    HttpResponse httpResponsePerformRequest = this.mHttpStack.performRequest(request, map);
                    try {
                        StatusLine statusLine = httpResponsePerformRequest.getStatusLine();
                        int statusCode = statusLine.getStatusCode();
                        Map<String, String> mapConvertHeaders = convertHeaders(httpResponsePerformRequest.getAllHeaders());
                        try {
                            if (statusCode == 304) {
                                Cache.Entry cacheEntry = request.getCacheEntry();
                                if (cacheEntry == null) {
                                    return new NetworkResponse(304, null, mapConvertHeaders, true, SystemClock.elapsedRealtime() - jElapsedRealtime);
                                }
                                cacheEntry.responseHeaders.putAll(mapConvertHeaders);
                                return new NetworkResponse(304, cacheEntry.data, cacheEntry.responseHeaders, true, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            }
                            if (statusCode == 301 || statusCode == 302) {
                                try {
                                    request.setRedirectUrl(mapConvertHeaders.get("Location"));
                                } catch (IOException e) {
                                    e = e;
                                    mapEmptyMap = mapConvertHeaders;
                                    r17 = mapEmptyMap;
                                    bArr = null;
                                    httpResponse = httpResponsePerformRequest;
                                }
                            }
                            byte[] bArrEntityToBytes = httpResponsePerformRequest.getEntity() != null ? entityToBytes(httpResponsePerformRequest.getEntity()) : new byte[0];
                            try {
                                r1 = this;
                                r1.logSlowRequests(SystemClock.elapsedRealtime() - jElapsedRealtime, request, bArrEntityToBytes, statusLine);
                                try {
                                    if (statusCode < 200 || statusCode > 299) {
                                        throw new IOException();
                                    }
                                    return new NetworkResponse(statusCode, bArrEntityToBytes, mapConvertHeaders, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                                } catch (IOException e2) {
                                    e = e2;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                r1 = mapConvertHeaders;
                            }
                            r17 = r1;
                            httpResponse = httpResponsePerformRequest;
                            bArr = bArrEntityToBytes;
                            if (httpResponse != null) {
                                int statusCode2 = httpResponse.getStatusLine().getStatusCode();
                                if (statusCode2 == 301 || statusCode2 == 302) {
                                    VolleyLog.e("Request at %s has been redirected to %s", request.getOriginUrl(), request.getUrl());
                                } else {
                                    VolleyLog.e("Unexpected response code %d for %s", Integer.valueOf(statusCode2), request.getUrl());
                                }
                                if (bArr != null) {
                                    NetworkResponse networkResponse = new NetworkResponse(statusCode2, bArr, r17, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                                    if (statusCode2 == 401 || statusCode2 == 403) {
                                        attemptRetryOnException(c.d, request, new AuthFailureError(networkResponse));
                                    } else if (statusCode2 == 301 || statusCode2 == 302) {
                                        attemptRetryOnException("redirect", request, new RedirectError(networkResponse));
                                    } else {
                                        throw new ServerError(networkResponse);
                                    }
                                } else {
                                    throw new NetworkError(e);
                                }
                            } else {
                                throw new NoConnectionError(e);
                            }
                        } catch (IOException e4) {
                            e = e4;
                            bArr = null;
                            httpResponse = httpResponsePerformRequest;
                            r17 = mapConvertHeaders;
                        }
                    } catch (IOException e5) {
                        e = e5;
                    }
                } catch (IOException e6) {
                    e = e6;
                    r17 = mapEmptyMap;
                    bArr = null;
                }
            } catch (MalformedURLException e7) {
                throw new RuntimeException("Bad URL " + request.getUrl(), e7);
            } catch (SocketTimeoutException unused) {
                attemptRetryOnException("socket", request, new TimeoutError());
            } catch (ConnectTimeoutException unused2) {
                attemptRetryOnException("connection", request, new TimeoutError());
            }
        }
    }

    private void logSlowRequests(long j, Request<?> request, byte[] bArr, StatusLine statusLine) {
        if (DEBUG || j > SLOW_REQUEST_THRESHOLD_MS) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void attemptRetryOnException(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(volleyError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VolleyError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e;
        }
    }

    private void addCacheHeaders(Map<String, String> map, Cache.Entry entry) {
        if (entry == null) {
            return;
        }
        if (entry.etag != null) {
            map.put("If-None-Match", entry.etag);
        }
        if (entry.lastModified > 0) {
            map.put("If-Modified-Since", DateUtils.formatDate(new Date(entry.lastModified)));
        }
    }

    protected void logError(String str, String str2, long j) {
        VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", str, Long.valueOf(SystemClock.elapsedRealtime() - j), str2);
    }

    private byte[] entityToBytes(HttpEntity httpEntity) throws ServerError, IOException {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new ServerError();
            }
            byte[] buf = this.mPool.getBuf(1024);
            while (true) {
                int i = content.read(buf);
                if (i == -1) {
                    break;
                }
                poolingByteArrayOutputStream.write(buf, 0, i);
            }
            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
            try {
                httpEntity.consumeContent();
            } catch (IOException unused) {
                VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
            }
            this.mPool.returnBuf(buf);
            poolingByteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException unused2) {
                VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
            }
            this.mPool.returnBuf(null);
            poolingByteArrayOutputStream.close();
            throw th;
        }
    }

    protected static Map<String, String> convertHeaders(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }
}
