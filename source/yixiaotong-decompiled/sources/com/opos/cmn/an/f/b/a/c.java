package com.opos.cmn.an.f.b.a;

import com.huawei.openalliance.ad.constant.br;
import com.usertrace.cdo.usertrace.domain.dto.UserTraceConfigDto;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c implements com.oplus.log.g.a {
    private static SSLSocketFactory a() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    private void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            try {
                SSLSocketFactory sSLSocketFactoryA = a();
                if (sSLSocketFactoryA != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactoryA);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private UserTraceConfigDto c(String str) {
        if (com.opos.cmn.an.d.a.a(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            UserTraceConfigDto userTraceConfigDto = new UserTraceConfigDto();
            userTraceConfigDto.setTraceId(jSONObject.optLong("traceId", 0L));
            if (!jSONObject.isNull("imei")) {
                userTraceConfigDto.setImei(jSONObject.optString("imei", ""));
            }
            userTraceConfigDto.setBeginTime(jSONObject.optLong("beginTime", 0L));
            userTraceConfigDto.setBeginTime(jSONObject.optLong(br.f.h, 0L));
            userTraceConfigDto.setForce(jSONObject.optInt("force", 0));
            if (!jSONObject.isNull("tracePkg")) {
                userTraceConfigDto.setTracePkg(jSONObject.optString("tracePkg", ""));
            }
            if (!jSONObject.isNull("openId")) {
                String strOptString = jSONObject.optString("openId", "");
                com.opos.cmn.an.f.c.c cVar = new com.opos.cmn.an.f.c.c(UserTraceConfigDto.class);
                Method methodA = cVar.a("setOpenId", String.class);
                if (methodA != null) {
                    methodA.invoke(userTraceConfigDto, strOptString);
                } else {
                    cVar.a("setOpenid", String.class).invoke(userTraceConfigDto, strOptString);
                }
            }
            return userTraceConfigDto;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.oplus.log.g.a
    public com.oplus.log.g.b a(String str) {
        HttpURLConnection httpURLConnection;
        try {
            if (com.opos.cmn.an.d.a.a(str)) {
                return null;
            }
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Accept", "application/json");
                httpURLConnection.connect();
                com.oplus.log.g.b bVar = new com.oplus.log.g.b(httpURLConnection.getResponseCode());
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused) {
                    }
                }
                return bVar;
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            httpURLConnection = null;
        }
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused4) {
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x009b A[EXC_TOP_SPLITTER, PHI: r0 r7
  0x009b: PHI (r0v1 com.oplus.log.g.b) = (r0v0 com.oplus.log.g.b), (r0v3 com.oplus.log.g.b) binds: [B:48:0x00a1, B:43:0x0099] A[DONT_GENERATE, DONT_INLINE]
  0x009b: PHI (r7v3 java.net.HttpURLConnection) = (r7v2 java.net.HttpURLConnection), (r7v5 java.net.HttpURLConnection) binds: [B:48:0x00a1, B:43:0x0099] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // com.oplus.log.g.a
    public com.oplus.log.g.b a(String str, File file) {
        HttpURLConnection httpURLConnection;
        com.oplus.log.g.b bVar;
        com.oplus.log.g.b bVar2 = null;
        try {
            if (!com.opos.cmn.an.d.a.a(str) && file != null && file.exists()) {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    a(httpURLConnection);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Charset", "UTF-8");
                    httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                    httpURLConnection.setRequestProperty("Accept", "application/json");
                    try {
                        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = fileInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    }
                                    dataOutputStream.write(bArr, 0, i);
                                    th = th;
                                    try {
                                        throw th;
                                    } catch (Throwable th) {
                                        try {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Throwable th2) {
                                                th.addSuppressed(th2);
                                            }
                                            throw th;
                                        } catch (Throwable unused) {
                                            bVar = bVar2;
                                        }
                                    }
                                }
                                dataOutputStream.flush();
                                bVar = new com.oplus.log.g.b(httpURLConnection.getResponseCode());
                                try {
                                    fileInputStream.close();
                                    try {
                                        dataOutputStream.close();
                                    } catch (Throwable unused2) {
                                    }
                                    bVar2 = bVar;
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable unused3) {
                                        }
                                    }
                                    return bVar2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    bVar2 = bVar;
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                try {
                                    throw th4;
                                } catch (Throwable th5) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable th6) {
                                        th4.addSuppressed(th6);
                                    }
                                    throw th5;
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    } catch (Throwable unused4) {
                    }
                } catch (Throwable unused5) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
            return null;
        } catch (Throwable unused6) {
            httpURLConnection = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0067  */
    /* JADX WARN: Code duplicated, block: B:46:0x0068 A[EXC_TOP_SPLITTER, PHI: r0 r6
  0x0068: PHI (r0v1 java.lang.String) = (r0v0 java.lang.String), (r0v4 java.lang.String) binds: [B:30:0x0067, B:26:0x0061] A[DONT_GENERATE, DONT_INLINE]
  0x0068: PHI (r6v2 java.net.HttpURLConnection) = (r6v1 java.net.HttpURLConnection), (r6v5 java.net.HttpURLConnection) binds: [B:30:0x0067, B:26:0x0061] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // com.oplus.log.g.a
    public UserTraceConfigDto b(String str) {
        HttpURLConnection httpURLConnection;
        String string = "";
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.opos.cmn.an.d.a.a(str)) {
                return null;
            }
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                a(httpURLConnection);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestProperty("Accept", "application/json");
                httpURLConnection.connect();
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        StringBuilder sb = new StringBuilder();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable unused) {
                                }
                            }
                            return c(string);
                        }
                        string = sb.toString();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable unused2) {
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable unused3) {
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection = httpURLConnection2;
                    httpURLConnection.disconnect();
                }
            }
            return c(string);
        } catch (Throwable unused4) {
        }
        if (httpURLConnection2 != null) {
            httpURLConnection = httpURLConnection2;
            httpURLConnection.disconnect();
        }
        return c(string);
    }
}
