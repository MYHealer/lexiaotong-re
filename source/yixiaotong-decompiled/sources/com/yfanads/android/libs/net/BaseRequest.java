package com.yfanads.android.libs.net;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.yfanads.android.libs.utils.Util;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class BaseRequest {
    private static final int HTTP_PERMANENT_REDIRECT = 308;
    private static final int HTTP_TEMPORARY_REDIRECT = 307;
    private static final String LINE_END = "\r\n";
    private static final int MAX_REDIRECT_TIMES = 10;
    private static final int MAX_RETRIES = 3;
    private static final int TIME_OUT = 10000;
    private static final String TWO_HYPHENS = "--";
    private static final String BOUNDARY = UUID.randomUUID().toString();
    private static final int[] RETRY_DELAYS = {5000, 15000, KSImageLoader.InnerImageLoadingListener.MAX_DURATION};

    private HttpURLConnection buildRedirectConnection(Map<String, String> map, String str) {
        try {
            HttpURLConnection httpURLConnection = getHttpURLConnection(str, "GET");
            if (map != null) {
                setHeader(httpURLConnection, map);
            }
            return httpURLConnection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void ending(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (IOException unused) {
        }
    }

    private BaseResponse getBaseResponse(HttpURLConnection httpURLConnection) throws IOException {
        BaseResponse baseResponse = new BaseResponse();
        int responseCode = httpURLConnection.getResponseCode();
        baseResponse.code = responseCode;
        if (responseCode == 200) {
            baseResponse.contentEncoding = httpURLConnection.getContentEncoding();
            baseResponse.contentLength = httpURLConnection.getContentLength();
            baseResponse.inputStream = httpURLConnection.getInputStream();
        } else {
            baseResponse.errorStream = httpURLConnection.getErrorStream();
        }
        return baseResponse;
    }

    private BaseResponse getExceptionResponse(HttpURLConnection httpURLConnection, Exception exc) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.code = UrlConst.ERROR_CODE;
        baseResponse.exception = exc;
        return baseResponse;
    }

    private String getFileParamsString(File file, String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer("\r\n--");
        stringBuffer.append(BOUNDARY);
        stringBuffer.append("\r\nContent-Disposition: form-data; name=\"");
        stringBuffer.append(str);
        stringBuffer.append("\"; filename=\"");
        if (TextUtils.isEmpty(str2)) {
            stringBuffer.append(file.getName());
        } else {
            stringBuffer.append(str2);
        }
        stringBuffer.append("\"\r\nContent-Type: ");
        stringBuffer.append(str3);
        stringBuffer.append("\r\nContent-Lenght: ");
        stringBuffer.append(file.length());
        stringBuffer.append("\r\n\r\n");
        return stringBuffer.toString();
    }

    private HttpURLConnection getHttpURLConnection(String str, String str2) throws ProtocolException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setRequestMethod(str2);
        return httpURLConnection;
    }

    private String getParamsString(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : map.keySet()) {
            stringBuffer.append(TWO_HYPHENS);
            stringBuffer.append(BOUNDARY);
            stringBuffer.append("\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"" + str + "\"");
            stringBuffer.append("\r\nContent-Type: text/plain\r\n");
            stringBuffer.append("Content-Lenght: " + map.get(str).length());
            stringBuffer.append("\r\n\r\n");
            stringBuffer.append(map.get(str));
            stringBuffer.append("\r\n");
        }
        return stringBuffer.toString();
    }

    private static boolean isRedirect(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }

    private void setConnection(HttpURLConnection httpURLConnection) {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; BOUNDARY=" + BOUNDARY);
    }

    private void setHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.setRequestProperty(str, map.get(str));
            }
        }
    }

    private void writeFile(File file, String str, String str2, String str3, DataOutputStream dataOutputStream, NetCallBack netCallBack) throws IOException {
        dataOutputStream.write(getFileParamsString(file, str, str3, str2).getBytes("UTF-8"));
        dataOutputStream.flush();
        FileInputStream fileInputStream = new FileInputStream(file);
        file.length();
        byte[] bArr = new byte[2048];
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                dataOutputStream.flush();
                fileInputStream.close();
                return;
            }
            dataOutputStream.write(bArr, 0, i);
        }
    }

    public BaseResponse getData(String str, Map<String, String> map) {
        try {
            HttpURLConnection httpURLConnection = getHttpURLConnection(str, "GET");
            httpURLConnection.setDoInput(true);
            if (map != null) {
                setHeader(httpURLConnection, map);
            }
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            String headerField = httpURLConnection.getHeaderField("Location");
            int i = 0;
            while (isRedirect(responseCode) && !TextUtils.isEmpty(headerField)) {
                ending(httpURLConnection);
                httpURLConnection = buildRedirectConnection(map, headerField);
                if (httpURLConnection == null) {
                    break;
                }
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
                headerField = httpURLConnection.getHeaderField("Location");
                Log.i("Request", "code " + responseCode + " loc " + headerField);
                i++;
                if (i >= 10) {
                    break;
                }
            }
            if (httpURLConnection == null) {
                return getExceptionResponse(httpURLConnection, new Exception("has bo connect"));
            }
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.code = responseCode;
            if (responseCode == 200) {
                baseResponse.contentEncoding = httpURLConnection.getContentEncoding();
                baseResponse.contentLength = httpURLConnection.getContentLength();
                baseResponse.inputStream = httpURLConnection.getInputStream();
            } else {
                baseResponse.errorStream = httpURLConnection.getErrorStream();
            }
            return baseResponse;
        } catch (Exception e) {
            return getExceptionResponse(null, e);
        }
    }

    public boolean isNetAvailability(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnection = getHttpURLConnection(str, "POST");
                httpURLConnection.setDoInput(true);
                if (map != null) {
                    setHeader(httpURLConnection, map);
                }
                int responseCode = httpURLConnection.getResponseCode();
                Log.i("Request", "isNetAvailability responseCode " + responseCode);
                if (responseCode == 200) {
                    httpURLConnection.disconnect();
                    return true;
                }
            } catch (Exception e) {
                Log.w("Request", "isNetAvailability exception " + e.getMessage());
                if (httpURLConnection == null) {
                    return false;
                }
            }
            httpURLConnection.disconnect();
            return false;
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public BaseResponse postData(String str, String str2, String str3, Map<String, String> map) {
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = getHttpURLConnection(str, "POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            if (!TextUtils.isEmpty(str3)) {
                httpURLConnection.setRequestProperty("Content-Type", str3);
            }
            if (map != null) {
                String strRemove = map.remove("timeout");
                if (!TextUtils.isEmpty(strRemove)) {
                    int i = Util.toInt(strRemove, 10000);
                    httpURLConnection.setReadTimeout(i);
                    httpURLConnection.setConnectTimeout(i);
                }
                setHeader(httpURLConnection, map);
            }
            httpURLConnection.connect();
            if (!TextUtils.isEmpty(str2)) {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(str2);
                bufferedWriter.flush();
                bufferedWriter.close();
            }
            return getBaseResponse(httpURLConnection);
        } catch (Exception e) {
            return getExceptionResponse(httpURLConnection, e);
        }
    }

    public BaseResponse postDataByRetry(String str, String str2, String str3, Map<String, String> map) {
        HttpURLConnection httpURLConnection = null;
        for (int i = 0; i <= 3; i++) {
            try {
                try {
                    httpURLConnection = getHttpURLConnection(str, "POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    if (!TextUtils.isEmpty(str3)) {
                        httpURLConnection.setRequestProperty("Content-Type", str3);
                    }
                    if (map != null) {
                        String strRemove = map.remove("timeout");
                        if (!TextUtils.isEmpty(strRemove)) {
                            int i2 = Util.toInt(strRemove, 10000);
                            httpURLConnection.setReadTimeout(i2);
                            httpURLConnection.setConnectTimeout(i2);
                        }
                        setHeader(httpURLConnection, map);
                    }
                    httpURLConnection.connect();
                    if (!TextUtils.isEmpty(str2)) {
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                        bufferedWriter.write(str2);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    }
                    if (httpURLConnection.getResponseCode() == 200) {
                        BaseResponse baseResponse = getBaseResponse(httpURLConnection);
                        httpURLConnection.disconnect();
                        return baseResponse;
                    }
                    if (i >= 3) {
                        BaseResponse exceptionResponse = getExceptionResponse(httpURLConnection, new Exception("All retries failed"));
                        httpURLConnection.disconnect();
                        return exceptionResponse;
                    }
                    try {
                        httpURLConnection.disconnect();
                        Log.w(Util.TAG, "postDataByRetry code not 200, numbs:" + i);
                        Thread.sleep(RETRY_DELAYS[i]);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                    httpURLConnection.disconnect();
                } catch (Exception e) {
                    if (i >= 3) {
                        BaseResponse exceptionResponse2 = getExceptionResponse(httpURLConnection, e);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return exceptionResponse2;
                    }
                    try {
                        Log.w(Util.TAG, "postDataByRetry fail, numbs:" + i);
                        Thread.sleep(RETRY_DELAYS[i]);
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                    }
                    if (httpURLConnection != null) {
                    }
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
        return getExceptionResponse(httpURLConnection, new Exception("All retries failed"));
    }

    public BaseResponse uploadFile(String str, File file, List<File> list, Map<String, File> map, String str2, String str3, String str4, Map<String, String> map2, Map<String, String> map3, NetCallBack netCallBack) {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = getHttpURLConnection(str, "POST");
            try {
                setConnection(httpURLConnection2);
                if (map3 != null) {
                    setHeader(httpURLConnection2, map3);
                }
                httpURLConnection2.connect();
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                if (map2 != null) {
                    dataOutputStream.write(getParamsString(map2).getBytes("UTF-8"));
                    dataOutputStream.flush();
                }
                if (file != null) {
                    writeFile(file, str2, str4, str3, dataOutputStream, netCallBack);
                } else if (list != null) {
                    Iterator<File> it = list.iterator();
                    while (it.hasNext()) {
                        writeFile(it.next(), str2, str4, str3, dataOutputStream, null);
                    }
                } else if (map != null) {
                    for (String str5 : map.keySet()) {
                        writeFile(map.get(str5), str5, str4, str3, dataOutputStream, null);
                    }
                }
                dataOutputStream.write(("\r\n--" + BOUNDARY + TWO_HYPHENS + "\r\n").getBytes("UTF-8"));
                dataOutputStream.flush();
                return getBaseResponse(httpURLConnection2);
            } catch (Exception e) {
                e = e;
                httpURLConnection = httpURLConnection2;
                return getExceptionResponse(httpURLConnection, e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
