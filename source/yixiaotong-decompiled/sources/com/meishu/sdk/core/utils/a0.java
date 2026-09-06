package com.meishu.sdk.core.utils;

import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: HttpUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a0 implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f4881a;
    public final /* synthetic */ File b;

    public a0(x xVar, File file) {
        this.f4881a = xVar;
        this.b = file;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        try {
            this.f4881a.onFailure(iOException);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x004c A[Catch: all -> 0x0052, Exception -> 0x0054, TRY_LEAVE, TryCatch #1 {Exception -> 0x0054, blocks: (B:25:0x0044, B:27:0x004c), top: B:64:0x0044, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0057 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #5 {all -> 0x0052, blocks: (B:25:0x0044, B:27:0x004c, B:32:0x0057, B:31:0x0054), top: B:64:0x0044, outer: #11, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x006f A[EXC_TOP_SPLITTER, PHI: r4
  0x006f: PHI (r4v4 java.io.FileOutputStream) = (r4v3 java.io.FileOutputStream), (r4v6 java.io.FileOutputStream), (r4v6 java.io.FileOutputStream) binds: [B:35:0x006d, B:57:0x006f, B:16:0x0036] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) throws IOException {
        Throwable th;
        InputStream inputStreamByteStream;
        FileOutputStream fileOutputStream;
        Throwable th2;
        HttpResponse<byte[]> httpResponse = new HttpResponse<>();
        try {
            if (response.isSuccessful()) {
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody != null) {
                    try {
                        inputStreamByteStream = responseBodyBody.byteStream();
                        try {
                            fileOutputStream = new FileOutputStream(this.b);
                            try {
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    int i = inputStreamByteStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        fileOutputStream.write(bArr, 0, i);
                                    }
                                }
                                fileOutputStream.flush();
                                httpResponse.setSuccessful(true);
                                try {
                                    inputStreamByteStream.close();
                                } catch (Throwable unused) {
                                }
                            } catch (Throwable th3) {
                                th2 = th3;
                                try {
                                    try {
                                        if (this.b.exists()) {
                                            this.b.delete();
                                            httpResponse.setSuccessful(false);
                                            httpResponse.setErrorCode(ErrorCodeUtil.RES_READ_RESPONSE_ERROR.intValue());
                                            httpResponse.setErrorDescription("write file error");
                                            if (inputStreamByteStream != null) {
                                                try {
                                                    inputStreamByteStream.close();
                                                } catch (Throwable unused2) {
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                            }
                                        } else {
                                            httpResponse.setSuccessful(false);
                                            httpResponse.setErrorCode(ErrorCodeUtil.RES_READ_RESPONSE_ERROR.intValue());
                                            httpResponse.setErrorDescription("write file error");
                                            if (inputStreamByteStream != null) {
                                                inputStreamByteStream.close();
                                            }
                                            if (fileOutputStream != null) {
                                            }
                                        }
                                    } catch (Exception unused3) {
                                        th2.printStackTrace();
                                    }
                                    response.close();
                                    this.f4881a.onResponse(httpResponse);
                                } catch (Throwable th4) {
                                    if (inputStreamByteStream != null) {
                                        try {
                                            inputStreamByteStream.close();
                                        } catch (Throwable unused4) {
                                        }
                                    }
                                    if (fileOutputStream == null) {
                                        throw th4;
                                    }
                                    try {
                                        fileOutputStream.close();
                                        throw th4;
                                    } catch (Throwable unused5) {
                                        throw th4;
                                    }
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            Throwable th6 = th;
                            fileOutputStream = null;
                            th2 = th6;
                            if (this.b.exists()) {
                                this.b.delete();
                                httpResponse.setSuccessful(false);
                                httpResponse.setErrorCode(ErrorCodeUtil.RES_READ_RESPONSE_ERROR.intValue());
                                httpResponse.setErrorDescription("write file error");
                                if (inputStreamByteStream != null) {
                                    inputStreamByteStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } else {
                                httpResponse.setSuccessful(false);
                                httpResponse.setErrorCode(ErrorCodeUtil.RES_READ_RESPONSE_ERROR.intValue());
                                httpResponse.setErrorDescription("write file error");
                                if (inputStreamByteStream != null) {
                                    inputStreamByteStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            }
                            response.close();
                            this.f4881a.onResponse(httpResponse);
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        inputStreamByteStream = null;
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused6) {
                    }
                } else {
                    httpResponse.setSuccessful(false);
                    httpResponse.setErrorCode(response.code());
                    httpResponse.setErrorDescription("bad file");
                }
            } else {
                httpResponse.setSuccessful(false);
                httpResponse.setErrorCode(response.code());
                httpResponse.setErrorDescription(response.message());
            }
        } catch (Throwable th8) {
            th8.printStackTrace();
            httpResponse.setSuccessful(false);
            httpResponse.setErrorCode(ErrorCodeUtil.RES_READ_RESPONSE_ERROR.intValue());
            httpResponse.setErrorDescription("bad file");
        }
        try {
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.f4881a.onResponse(httpResponse);
        } catch (Throwable th9) {
            th9.printStackTrace();
        }
    }
}
