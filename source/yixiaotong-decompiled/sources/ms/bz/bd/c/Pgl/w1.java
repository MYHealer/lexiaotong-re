package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class w1 extends pbly {
    private SSLSocketFactory c;

    /* JADX WARN: Code duplicated, block: B:107:0x02ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x02b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x0287 A[Catch: all -> 0x02dd, TryCatch #15 {all -> 0x02dd, blocks: (B:80:0x0271, B:82:0x0287, B:84:0x02aa), top: B:121:0x0271 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x02a9  */
    private Object[] c(String str, byte[] bArr, String str2, String str3, String str4, boolean z) throws Throwable {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        DataOutputStream dataOutputStream;
        BufferedInputStream bufferedInputStream2;
        int responseCode;
        BufferedInputStream bufferedInputStream3;
        String headerField;
        byte[] bArr2;
        BufferedInputStream bufferedInputStream4;
        byte[] bArr3;
        pblx.pgla pglaVar = new pblx.pgla();
        DataOutputStream dataOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection instanceof HttpsURLConnection) {
                try {
                    if (this.c == null) {
                        synchronized (w1.class) {
                            if (this.c == null) {
                                SSLContext sSLContext = SSLContext.getInstance((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3d8e82", new byte[]{Ascii.SYN, 74, 120}));
                                sSLContext.init(null, null, null);
                                this.c = sSLContext.getSocketFactory();
                            }
                        }
                    }
                    SSLSocketFactory sSLSocketFactory = this.c;
                    if (sSLSocketFactory != null) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = null;
                    dataOutputStream = dataOutputStream2;
                    bufferedInputStream3 = bufferedInputStream;
                    pbly.c(bufferedInputStream3);
                    pbly.c(dataOutputStream);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused2) {
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bf19a6", new byte[]{96, 108, 65, 114, 86, 48, 51});
                        }
                    }
                    throw th;
                }
            }
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "673040", new byte[]{6, 54, 67, 65, Ascii.ESC, 51}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8ba241", new byte[]{99, 47, 88}));
                httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "464301", new byte[]{6, 59, 73, 73, 10, 37, 35, Ascii.RS, 106, 109}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cf5d70", new byte[]{89, 97, 67, 0, 69, 6, 108, 78, 114, 49}));
                httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9af031", new byte[]{Ascii.GS, 112, 16, 86, 65, 7, Base64.padSymbol, 69, 57, 116}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f1782b", new byte[]{85, 42, 80, 73, 41, 116, 107, 19, 99, 37, 90, 0, 119, 104, 38}));
                httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "123594", new byte[]{3, Utf8.REPLACEMENT_BYTE, 78, 85, 3, 45, 38, 94, 86, 124, 48, 53}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "47690f", new byte[]{36, 37, 85, 65, 6, 114, 54, 2, 110, 102, 43, 122, 74, 78, Ascii.ESC, 116, 35, 91, 116, 125, 55, 48, 68, SignedBytes.MAX_POWER_OF_TWO}));
                if (str2 != null && str2.trim().length() > 0) {
                    httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fa93c9", new byte[]{84, 108, 69, 76, 85, 43}), String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5eeea1", new byte[]{55, 98, 5, 2, 87, 41, 56, 77, 48, 104, 97, 116}), str2));
                }
                if (str3 != null && str3.trim().length() > 0) {
                    httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1f6231", new byte[]{56, 41, 81, 82, 65, 52, 55, 86, 114, 103, 51, 112, 8, 82, 13, 33}), str3);
                }
                pglaVar.c(str);
                if (z) {
                    httpURLConnection.setRequestMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8ddb8e", new byte[]{Ascii.EM, 73, 36, 34}));
                    httpURLConnection.setDoOutput(true);
                    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    try {
                        try {
                            dataOutputStream.write(bArr);
                            dataOutputStream.flush();
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedInputStream3 = null;
                            pbly.c(bufferedInputStream3);
                            pbly.c(dataOutputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Exception unused3) {
                        responseCode = -1;
                        bufferedInputStream2 = null;
                        try {
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "eaf1ba", new byte[]{103, 107, Ascii.SYN, 122, 85, 103});
                            if (httpURLConnection != null) {
                                headerField = httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "04f947", new byte[]{57, 123, 1, 89, 70, 44, 60, Ascii.DC2, 62, 109}));
                            } else {
                                headerField = null;
                            }
                            pglaVar.tt(headerField, responseCode);
                            pbly.c(bufferedInputStream2);
                            pbly.c(dataOutputStream);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception unused4) {
                                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9d8303", new byte[]{59, 110, 72, 120, 7, 53, 104});
                                }
                            }
                            bArr2 = null;
                            return new Object[]{String.valueOf(responseCode), bArr2};
                        } catch (Throwable th3) {
                            th = th3;
                            dataOutputStream2 = dataOutputStream;
                            bufferedInputStream = bufferedInputStream2;
                            dataOutputStream = dataOutputStream2;
                            bufferedInputStream3 = bufferedInputStream;
                            pbly.c(bufferedInputStream3);
                            pbly.c(dataOutputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                } else {
                    dataOutputStream = null;
                }
                try {
                    responseCode = httpURLConnection.getResponseCode();
                    try {
                        pglaVar.c(httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3f5d7e", new byte[]{58, 41, 82, 4, 69, 126, Utf8.REPLACEMENT_BYTE, SignedBytes.MAX_POWER_OF_TWO, 109, 48})), responseCode);
                        if (responseCode == 200) {
                            bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                            try {
                                OutputStream fileOutputStream = str4 != null ? new FileOutputStream(str4) : new ByteArrayOutputStream();
                                byte[] bArr4 = new byte[256];
                                while (true) {
                                    int i = bufferedInputStream2.read(bArr4);
                                    if (i <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr4, 0, i);
                                }
                                fileOutputStream.flush();
                                byte[] byteArray = fileOutputStream instanceof ByteArrayOutputStream ? ((ByteArrayOutputStream) fileOutputStream).toByteArray() : null;
                                fileOutputStream.close();
                                bufferedInputStream4 = bufferedInputStream2;
                                bArr3 = byteArray;
                            } catch (Exception unused5) {
                                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "eaf1ba", new byte[]{103, 107, Ascii.SYN, 122, 85, 103});
                                if (httpURLConnection != null) {
                                    headerField = httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "04f947", new byte[]{57, 123, 1, 89, 70, 44, 60, Ascii.DC2, 62, 109}));
                                } else {
                                    headerField = null;
                                }
                                pglaVar.tt(headerField, responseCode);
                                pbly.c(bufferedInputStream2);
                                pbly.c(dataOutputStream);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                bArr2 = null;
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedInputStream3 = bufferedInputStream2;
                                pbly.c(bufferedInputStream3);
                                pbly.c(dataOutputStream);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        } else {
                            bufferedInputStream4 = null;
                            bArr3 = null;
                        }
                        pbly.c(bufferedInputStream4);
                        pbly.c(dataOutputStream);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused6) {
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d95470", new byte[]{102, 51, 69, 127, 0, 54, 53});
                        }
                        bArr2 = bArr3;
                    } catch (Exception unused7) {
                        bufferedInputStream2 = null;
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "eaf1ba", new byte[]{103, 107, Ascii.SYN, 122, 85, 103});
                        if (httpURLConnection != null) {
                            headerField = httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "04f947", new byte[]{57, 123, 1, 89, 70, 44, 60, Ascii.DC2, 62, 109}));
                        } else {
                            headerField = null;
                        }
                        pglaVar.tt(headerField, responseCode);
                        pbly.c(bufferedInputStream2);
                        pbly.c(dataOutputStream);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        bArr2 = null;
                        return new Object[]{String.valueOf(responseCode), bArr2};
                    }
                } catch (Exception unused8) {
                    bufferedInputStream2 = null;
                    responseCode = -1;
                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "eaf1ba", new byte[]{103, 107, Ascii.SYN, 122, 85, 103});
                    if (httpURLConnection != null) {
                        headerField = httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "04f947", new byte[]{57, 123, 1, 89, 70, 44, 60, Ascii.DC2, 62, 109}));
                    } else {
                        headerField = null;
                    }
                    pglaVar.tt(headerField, responseCode);
                    pbly.c(bufferedInputStream2);
                    pbly.c(dataOutputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    bArr2 = null;
                    return new Object[]{String.valueOf(responseCode), bArr2};
                }
            } catch (Exception unused9) {
                dataOutputStream = null;
                bufferedInputStream2 = null;
                responseCode = -1;
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "eaf1ba", new byte[]{103, 107, Ascii.SYN, 122, 85, 103});
                if (httpURLConnection != null) {
                    headerField = httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "04f947", new byte[]{57, 123, 1, 89, 70, 44, 60, Ascii.DC2, 62, 109}));
                } else {
                    headerField = null;
                }
                pglaVar.tt(headerField, responseCode);
                pbly.c(bufferedInputStream2);
                pbly.c(dataOutputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                bArr2 = null;
                return new Object[]{String.valueOf(responseCode), bArr2};
            } catch (Throwable th5) {
                th = th5;
                dataOutputStream2 = null;
                bufferedInputStream = null;
                dataOutputStream = dataOutputStream2;
                bufferedInputStream3 = bufferedInputStream;
                pbly.c(bufferedInputStream3);
                pbly.c(dataOutputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception unused10) {
            httpURLConnection = null;
        } catch (Throwable th6) {
            th = th6;
            dataOutputStream2 = null;
            httpURLConnection = null;
        }
        return new Object[]{String.valueOf(responseCode), bArr2};
    }

    @Override // ms.bz.bd.c.Pgl.pbly
    public final Object[] c(String str, String str2, String str3) {
        return c(str, null, str2, str3, null, false);
    }

    @Override // ms.bz.bd.c.Pgl.pbly
    public final Object[] c(String str, byte[] bArr, String str2, String str3) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "060d54", new byte[]{Ascii.DC2, 45, 80, 4, 15, 46, Ascii.ESC, 3, 117, 36, 2, 56, 74, Ascii.NAK, 4, 55, 115, 2, 115, 56, 97, 121, 14, 93, 74});
        return c(str, bArr, str2, str3, null, true);
    }

    @Override // ms.bz.bd.c.Pgl.pbly
    public final Object[] tt(String str, String str2, String str3) {
        return c(str, null, null, str3, str2, false);
    }
}
