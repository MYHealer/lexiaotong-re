package com.baidu.passbqt.http;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class HttpStack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1928a = "HttpStack";
    private static final String b = "Set-Cookie";
    private static final char[] c = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final String f = "User-Agent";
    private static final int g = 15000;
    private String d = "AgzTBLLDxWSdvY0AbyfzsK8KCwpuSV";
    private boolean e = false;
    private HttpRequestHandler h = null;

    public HttpStack a(HttpRequestHandler httpRequestHandler) {
        this.h = httpRequestHandler;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0077 A[EXC_TOP_SPLITTER, PHI: r2
  0x0077: PHI (r2v3 java.io.OutputStream) = (r2v2 java.io.OutputStream), (r2v4 java.io.OutputStream) binds: [B:26:0x0082, B:19:0x0075] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public void a(PassHttpClientRequest passHttpClientRequest) throws IOException, IllegalArgumentException {
        HttpURLConnection httpURLConnectionA;
        byte[] bArrA;
        if (passHttpClientRequest == null || passHttpClientRequest.f) {
            return;
        }
        a();
        int i = AnonymousClass1.f1929a[passHttpClientRequest.e.ordinal()];
        OutputStream outputStream = null;
        if (i == 1) {
            httpURLConnectionA = a(passHttpClientRequest.d);
            bArrA = null;
        } else if (i == 2) {
            httpURLConnectionA = b(passHttpClientRequest.d);
            bArrA = a(httpURLConnectionA, passHttpClientRequest.d);
        } else {
            throw new IllegalArgumentException(passHttpClientRequest.e + " method not support");
        }
        a(httpURLConnectionA, passHttpClientRequest.d.e);
        a(httpURLConnectionA, passHttpClientRequest.d.c);
        a(httpURLConnectionA, passHttpClientRequest.d.h);
        PassHttpCookieUtil.a(passHttpClientRequest.f1935a, httpURLConnectionA, passHttpClientRequest.d);
        if (bArrA != null) {
            try {
                outputStream = httpURLConnectionA.getOutputStream();
                if (outputStream != null) {
                    outputStream.write(bArrA);
                    outputStream.flush();
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        }
        InputStream inputStream = httpURLConnectionA.getInputStream();
        int responseCode = httpURLConnectionA.getResponseCode();
        HashMap<String, String> mapA = a(httpURLConnectionA);
        byte[] bArrA2 = a(inputStream);
        try {
            inputStream.close();
        } catch (Exception unused4) {
        }
        PassHttpCookieUtil.b(passHttpClientRequest.f1935a, httpURLConnectionA, passHttpClientRequest.d);
        if (passHttpClientRequest.f || passHttpClientRequest.b == null) {
            return;
        }
        passHttpClientRequest.b.c(responseCode, mapA, bArrA2);
    }

    /* JADX INFO: renamed from: com.baidu.passbqt.http.HttpStack$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1929a;

        static {
            int[] iArr = new int[Method.values().length];
            f1929a = iArr;
            try {
                iArr[Method.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1929a[Method.POST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void a(HttpURLConnection httpURLConnection, HashMap<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public void a(HttpURLConnection httpURLConnection, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        httpURLConnection.setRequestProperty("User-Agent", str);
    }

    private void a(HttpURLConnection httpURLConnection, int i) {
        httpURLConnection.setConnectTimeout(i == 0 ? 15000 : i);
        if (i == 0) {
            i = 15000;
        }
        httpURLConnection.setReadTimeout(i);
    }

    private byte[] a(HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) throws IOException {
        if (passHttpParamDTO.d instanceof MultipartHashMap) {
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + this.d);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (passHttpParamDTO.d != null) {
                for (Map.Entry entry : passHttpParamDTO.d.a().entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                        a(byteArrayOutputStream, URLEncoder.encode((String) entry.getKey(), "UTF-8"), URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                    }
                }
            }
            MultipartHashMap.FileWrapper fileWrapper = ((MultipartHashMap) passHttpParamDTO.d).f1931a;
            a(byteArrayOutputStream, fileWrapper.f1932a, fileWrapper.b, fileWrapper.d, fileWrapper.c);
            a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        if (!(passHttpParamDTO.d instanceof HttpHashMap)) {
            return null;
        }
        byte[] bytes = a(passHttpParamDTO.d).getBytes("UTF-8");
        HttpRequestHandler httpRequestHandler = this.h;
        return httpRequestHandler != null ? httpRequestHandler.a(bytes) : bytes;
    }

    private HttpURLConnection a(PassHttpParamDTO passHttpParamDTO) throws IOException {
        HttpURLConnection httpURLConnection;
        String strA = a(passHttpParamDTO.d);
        if (!TextUtils.isEmpty(strA)) {
            passHttpParamDTO.f1937a += "?" + strA;
        }
        URL url = new URL(passHttpParamDTO.f1937a);
        if (TextUtils.isEmpty(passHttpParamDTO.i)) {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(passHttpParamDTO.i, passHttpParamDTO.j)));
        }
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
    }

    private HttpURLConnection b(PassHttpParamDTO passHttpParamDTO) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(passHttpParamDTO.f1937a);
        if (TextUtils.isEmpty(passHttpParamDTO.i)) {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(passHttpParamDTO.i, passHttpParamDTO.j)));
        }
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        return httpURLConnection;
    }

    private byte[] a(InputStream inputStream) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                try {
                    try {
                        try {
                            try {
                                int i = bufferedInputStream.read(bArr);
                                if (i <= 0) {
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, i);
                            } catch (IOException e) {
                                e.printStackTrace();
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                                return null;
                            }
                        } catch (Throwable th) {
                            bufferedOutputStream.close();
                            bufferedInputStream.close();
                            byteArrayOutputStream.close();
                            throw th;
                        }
                        bufferedOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    byteArrayOutputStream.close();
                    throw th;
                } catch (IOException e6) {
                    e6.printStackTrace();
                    throw th;
                }
                bufferedInputStream.close();
            } catch (IOException e7) {
                e7.printStackTrace();
            }
        }
        bufferedOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            bufferedOutputStream.close();
        } catch (IOException e8) {
            e8.printStackTrace();
        }
        try {
            bufferedInputStream.close();
        } catch (IOException e9) {
            e9.printStackTrace();
        }
        try {
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e10) {
            e10.printStackTrace();
            return byteArray;
        }
    }

    private HashMap<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap<String, String> map = new HashMap<>();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            String headerFieldKey = httpURLConnection.getHeaderFieldKey(i);
            String headerField = httpURLConnection.getHeaderField(i);
            if ("Set-Cookie".equals(headerFieldKey) && !TextUtils.isEmpty(headerField) && headerField.contains("=")) {
                headerFieldKey = headerField.substring(0, headerField.indexOf("="));
            }
            map.put(headerFieldKey, headerField);
        }
        return map;
    }

    private void a() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            char[] cArr = c;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.d = sb.toString();
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            char[] cArr = c;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        byte[] bytes = ("\r\n--" + this.d + IOUtils.LINE_SEPARATOR_WINDOWS).getBytes();
        if (!this.e) {
            this.e = true;
            byteArrayOutputStream.write(("--" + this.d + IOUtils.LINE_SEPARATOR_WINDOWS).getBytes());
        } else {
            byteArrayOutputStream.write(bytes);
        }
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream, String str, String str2) throws IOException {
        a(byteArrayOutputStream);
        byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
        byteArrayOutputStream.write(str2.getBytes());
    }

    private ByteArrayOutputStream a(ByteArrayOutputStream byteArrayOutputStream, String str, String str2, InputStream inputStream, String str3) throws IOException {
        try {
            try {
                a(byteArrayOutputStream);
                byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
                if (str3 != null) {
                    byteArrayOutputStream.write(("Content-Type: " + str3 + "\r\n\r\n").getBytes());
                } else {
                    byteArrayOutputStream.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
                }
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    throw th;
                }
                byteArrayOutputStream.flush();
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return byteArrayOutputStream;
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    private String a(HttpHashMap httpHashMap) {
        StringBuilder sb = new StringBuilder();
        if (httpHashMap != null && httpHashMap.a() != null) {
            for (Map.Entry entry : httpHashMap.a().entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                    try {
                        sb.append(URLEncoder.encode((String) entry.getKey(), "UTF-8")).append("=").append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                        sb.append("&");
                    } catch (UnsupportedEncodingException e) {
                        PassHttpUtils.a(e.getMessage());
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(sb)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
