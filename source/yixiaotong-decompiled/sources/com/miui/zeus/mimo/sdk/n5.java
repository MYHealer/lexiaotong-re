package com.miui.zeus.mimo.sdk;

import android.text.TextUtils;
import android.util.Pair;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;
import com.miui.zeus.mimo.sdk.server.http.Error;
import com.miui.zeus.mimo.sdk.server.http.HttpRequest;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeoutException;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class n5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5537a = ijiami_1011.s.s.s.d(new byte[]{88, 12}, "69f0b2");
    public static final int b;

    static {
        int i = e9.f5418a;
        b = 3000;
    }

    public final HttpURLConnection a(String str, HttpRequest httpRequest, int i) throws Throwable {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        List<k5> list = httpRequest.g;
        if (list != null) {
            for (k5 k5Var : list) {
                httpURLConnection.setRequestProperty((String) ((Pair) k5Var).first, (String) ((Pair) k5Var).second);
            }
        }
        httpURLConnection.setRequestMethod(httpRequest.f5606a == HttpRequest.Method.GET ? ijiami_1011.s.s.s.d(new byte[]{127, 112, 49}, "85ea15") : ijiami_1011.s.s.s.d(new byte[]{54, 44, 55, 108}, "fcd818"));
        if (httpRequest.f5606a == HttpRequest.Method.POST) {
            OutputStreamWriter outputStreamWriter = null;
            try {
                httpURLConnection.setDoOutput(true);
                List<k5> list2 = httpRequest.f;
                if (list2 != null && !list2.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        k5 k5Var2 = list2.get(i2);
                        if (k5Var2 != null && !TextUtils.isEmpty((String) ((Pair) k5Var2).first) && !TextUtils.isEmpty((String) ((Pair) k5Var2).second)) {
                            sb.append(URLEncoder.encode((String) ((Pair) k5Var2).first, ijiami_1011.s.s.s.d(new byte[]{103, 48, 36, 8}, "2db0d1")));
                            sb.append(ijiami_1011.s.s.s.d(new byte[]{13}, "0a3263"));
                            sb.append(URLEncoder.encode((String) ((Pair) k5Var2).second, ijiami_1011.s.s.s.d(new byte[]{49, 109, 127, 91}, "d99c98")));
                            sb.append(ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK}, "3cf3db"));
                        }
                    }
                    if (sb.length() > 0) {
                        sb = sb.deleteCharAt(sb.length() - 1);
                    }
                    OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(httpURLConnection.getOutputStream());
                    try {
                        outputStreamWriter2.write(sb.toString());
                        outputStreamWriter2.flush();
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                        outputStreamWriter = outputStreamWriter2;
                        b.a(outputStreamWriter);
                        throw th;
                    }
                    outputStreamWriter = outputStreamWriter2;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
            b.a(outputStreamWriter);
        }
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.connect();
        return httpURLConnection;
    }

    public l5<j5> a(HttpRequest httpRequest, int i) {
        String str;
        StringBuilder sbAppend;
        try {
            HttpURLConnection httpURLConnectionA = a(httpRequest.a(), httpRequest, i);
            int responseCode = httpURLConnectionA.getResponseCode();
            String responseMessage = httpURLConnectionA.getResponseMessage();
            if (responseCode == 301 || responseCode == 302) {
                String headerField = httpURLConnectionA.getHeaderField(ijiami_1011.s.s.s.d(new byte[]{125, 12, 5, 80, Ascii.DC2, 81, 14, 10}, "1cf1f8"));
                httpURLConnectionA.disconnect();
                m.d(f5537a, ijiami_1011.s.s.s.d(new byte[]{42, 69, 66, Ascii.DC2, 51, 84, Ascii.DC2, Ascii.DC4, 9, 12, 66, 0, 66, 11, Ascii.SYN, 17, Ascii.NAK, 80, Ascii.NAK, 17, Ascii.NAK, 33, 94, 1, 7, 12}, "b16ba1") + responseCode + ijiami_1011.s.s.s.d(new byte[]{66, 70, 68, 4, 69, 67, Ascii.DC2, 41, 3, 17, 66, 4, 5, 80, 13}, "b50e16") + responseMessage + ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 41, 91, 80, 3, Ascii.ETB, 8, 11, 8, 95, 19}, "5e43bc") + headerField + ijiami_1011.s.s.s.d(new byte[]{17}, "3b5a69"));
                httpURLConnectionA = a(headerField, httpRequest, i);
                responseCode = httpURLConnectionA.getResponseCode();
                responseMessage = httpURLConnectionA.getResponseMessage();
            }
            int i2 = responseCode;
            String str2 = responseMessage;
            if (TextUtils.isEmpty(str2)) {
                str = f5537a;
                sbAppend = new StringBuilder().append(ijiami_1011.s.s.s.d(new byte[]{127, 67, 67, 73, 97, 83, Ascii.DC2, Ascii.DC4, 9, 12, 66, 0, Ascii.ETB, 13, Ascii.ETB, 74, 71, 87, Ascii.NAK, 17, Ascii.NAK, 33, 94, 1, 82, Ascii.ETB, 10, Ascii.EM}, "777936")).append(i2);
            } else {
                str = f5537a;
                sbAppend = new StringBuilder().append(ijiami_1011.s.s.s.d(new byte[]{121, 16, 68, 67, 97, 86, Ascii.DC2, Ascii.DC4, 9, 12, 66, 0, 17, 94, 16, SignedBytes.MAX_POWER_OF_TWO, 71, 82, Ascii.NAK, 17, Ascii.NAK, 33, 94, 1, 84, 68, 13, 19}, "1d0333")).append(i2).append(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 68, Ascii.SYN, Ascii.DC2, 87, 65, Ascii.DC4, Ascii.ETB, 43, 7, 66, Ascii.SYN, 83, 3, 0, 91}, "2def65")).append(str2);
            }
            m.d(str, sbAppend.toString());
            if (i2 != 200) {
                return new l5<>(new j5(i2, str2, 0L, null), new a7(Error.NULL_RESPONSE), new i5(httpRequest.e ? DiagnosisStep.KEY_FAIL_WHEN_DOWNLOAD_HTTP_STATUS_CODE_IS_NOT_200 : DiagnosisStep.KEY_FAIL_WHEN_AD_SERVER_HTTP_STATUS_CODE_IS_NOT_200, ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 4, 70, 83, 94, 67, 12, 54, 3, 19, 68, 0, 67, Ascii.NAK, Ascii.DC4, 93, 69, 69, 17, 68, Ascii.NAK, Ascii.SYN, 80, 17, 69, Ascii.DC2, Ascii.DC4, 86, 94, 85, 4, 68, 15, 17, 17, 11, 95, Ascii.NAK, Ascii.DC4, 7, 1, 1, 77, 68}, "0a4511"), new i5.a(i2, str2, ijiami_1011.s.s.s.d(new byte[]{11, 71, 77, Ascii.DC4, 104, 92, 19, Ascii.SYN, 9, 16}, "c39d79"))));
            }
            InputStream inputStream = httpURLConnectionA.getInputStream();
            if (!TextUtils.isEmpty(httpURLConnectionA.getContentEncoding())) {
                String lowerCase = httpURLConnectionA.getContentEncoding().toLowerCase(Locale.getDefault());
                if (!TextUtils.isEmpty(lowerCase) && lowerCase.indexOf(ijiami_1011.s.s.s.d(new byte[]{82, 77, 81, Ascii.NAK}, "578ead")) >= 0) {
                    inputStream = new GZIPInputStream(httpURLConnectionA.getInputStream());
                }
            }
            return new l5<>(new j5(i2, str2, httpURLConnectionA.getContentLength(), inputStream));
        } catch (Exception e) {
            if (e instanceof TimeoutException) {
                return l5.a(Error.TIMEOUT, new i5(httpRequest.e ? DiagnosisStep.KEY_EXCEPTION_WHEN_PERFORM_DOWNLOAD_REQUEST : DiagnosisStep.KEY_EXCEPTION_WHEN_PERFORM_AD_REQUEST, ijiami_1011.s.s.s.d(new byte[]{71, 83, 16, 5, 92, 19, 12, 54, 3, 19, 68, 0, 68, 66, 66, 6, 75, 2, 4, Ascii.DC4, Ascii.DC2, 11, 94, 11, Ascii.ETB, 12, 66}, "76bc3a"), e));
            }
            return l5.a(Error.NULL_RESPONSE, new i5(httpRequest.e ? DiagnosisStep.KEY_EXCEPTION_WHEN_PERFORM_DOWNLOAD_REQUEST : DiagnosisStep.KEY_EXCEPTION_WHEN_PERFORM_AD_REQUEST, ijiami_1011.s.s.s.d(new byte[]{70, 93, 19, 81, 12, 66, 12, 54, 3, 19, 68, 0, 69, 76, 65, 82, Ascii.ESC, 83, 4, Ascii.DC4, Ascii.DC2, 11, 94, 11, Ascii.SYN, 2, 65}, "68a7c0"), e));
        }
    }
}
