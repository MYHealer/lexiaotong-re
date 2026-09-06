package com.yfanads.android.libs.net;

import com.loopj.android.http.AsyncHttpClient;
import com.yfanads.android.libs.utils.Util;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class NetCallBack<T> {
    protected boolean toggleMain = true;
    protected boolean isAES = false;

    public static abstract class NetCallBackEmpty extends NetCallBack<String> {
        public NetCallBackEmpty() {
            this(true);
        }

        public NetCallBackEmpty(boolean z) {
            this.toggleMain = z;
        }

        public NetCallBackEmpty(boolean z, boolean z2) {
            this(z);
        }

        @Override // com.yfanads.android.libs.net.NetCallBack
        public String onParseResponse(BaseResponse baseResponse) {
            return "";
        }
    }

    public static abstract class NetCallBackString extends NetCallBack<String> {
        public NetCallBackString() {
            this(true);
        }

        public NetCallBackString(boolean z) {
            this.toggleMain = z;
        }

        public NetCallBackString(boolean z, boolean z2) {
            this(z);
            this.isAES = z2;
        }

        @Override // com.yfanads.android.libs.net.NetCallBack
        public String onParseResponse(BaseResponse baseResponse) throws Throwable {
            try {
                String retString = NetCallBack.getRetString(baseResponse.contentEncoding, baseResponse.inputStream);
                return (!this.isAES || retString == null) ? retString : Util.decryptAES7(retString, UrlConst.getKey());
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getRetString(String str, InputStream inputStream) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = AsyncHttpClient.ENCODING_GZIP.equals(str) ? new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream))) : new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        String string = sb.toString();
                        Util.closeIO(inputStream, bufferedReader);
                        return string;
                    }
                    sb.append(line + IOUtils.LINE_SEPARATOR_UNIX);
                }
            } catch (Exception unused) {
                Util.closeIO(inputStream, bufferedReader);
                return null;
            } catch (Throwable th) {
                bufferedReader2 = bufferedReader;
                th = th;
                Util.closeIO(inputStream, bufferedReader2);
                throw th;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final byte[] input2byte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[100];
        while (true) {
            int i = inputStream.read(bArr, 0, 100);
            if (i <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    /* JADX INFO: renamed from: lambda$onError$2$com-yfanads-android-libs-net-NetCallBack, reason: not valid java name */
    /* synthetic */ void m1260lambda$onError$2$comyfanadsandroidlibsnetNetCallBack(BaseResponse baseResponse, String str) {
        m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(baseResponse.code, str);
    }

    /* JADX INFO: renamed from: lambda$onSuccess$1$com-yfanads-android-libs-net-NetCallBack, reason: not valid java name */
    /* synthetic */ void m1261lambda$onSuccess$1$comyfanadsandroidlibsnetNetCallBack() {
        m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(null);
    }

    public void onError(final int i, final String str) {
        if (this.toggleMain) {
            Util.MAIN_HANDLER.post(new Runnable() { // from class: com.yfanads.android.libs.net.NetCallBack$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(i, str);
                }
            });
        } else {
            m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(i, str);
        }
    }

    public void onError(final BaseResponse baseResponse) throws Throwable {
        final String retString;
        InputStream inputStream = baseResponse.inputStream;
        if (inputStream == null && (inputStream = baseResponse.errorStream) == null) {
            Exception exc = baseResponse.exception;
            retString = exc != null ? exc.getMessage() : "";
        } else {
            retString = getRetString(baseResponse.contentEncoding, inputStream);
        }
        if (this.toggleMain) {
            Util.MAIN_HANDLER.post(new Runnable() { // from class: com.yfanads.android.libs.net.NetCallBack$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1260lambda$onError$2$comyfanadsandroidlibsnetNetCallBack(baseResponse, retString);
                }
            });
        } else {
            m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(baseResponse.code, retString);
        }
    }

    /* JADX INFO: renamed from: onFailure, reason: merged with bridge method [inline-methods] */
    public abstract void m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(int i, String str);

    public abstract T onParseResponse(BaseResponse baseResponse);

    /* JADX INFO: renamed from: onResponse, reason: merged with bridge method [inline-methods] */
    public abstract void m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(T t);

    public void onSuccess() {
        if (this.toggleMain) {
            Util.MAIN_HANDLER.post(new Runnable() { // from class: com.yfanads.android.libs.net.NetCallBack$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1261lambda$onSuccess$1$comyfanadsandroidlibsnetNetCallBack();
                }
            });
        } else {
            m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(null);
        }
    }

    public void onSuccess(BaseResponse baseResponse) {
        final T tOnParseResponse = onParseResponse(baseResponse);
        if (this.toggleMain) {
            Util.MAIN_HANDLER.post(new Runnable() { // from class: com.yfanads.android.libs.net.NetCallBack$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(tOnParseResponse);
                }
            });
        } else {
            m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(tOnParseResponse);
        }
    }
}
