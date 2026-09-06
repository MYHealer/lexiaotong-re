package com.meishu.sdk.core.utils;

import android.util.Base64;
import com.meishu.sdk.core.MSAdConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: ut.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class v1 {
    public static String a(String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, new SecretKeySpec(MessageDigest.getInstance("MD5").digest(str2.getBytes()), "AES"), new IvParameterSpec(MessageDigest.getInstance("MD5").digest(MSAdConfig.initUUID().getBytes())));
            return a(cipher.doFinal(Base64.decode(str, 0)));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:63:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    public static String a(byte[] bArr) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        Throwable th;
        ?? byteArrayOutputStream;
        Exception e;
        Throwable th2;
        if (bArr == null) {
            return "";
        }
        ?? r0 = 0;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    try {
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int i = gZIPInputStream.read(bArr2);
                                if (i == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, i);
                                th = th;
                                Throwable th3 = th;
                                r0 = byteArrayOutputStream;
                                th2 = th3;
                                if (r0 != 0) {
                                    try {
                                        r0.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                if (byteArrayInputStream != null) {
                                    try {
                                        byteArrayInputStream.close();
                                        throw th2;
                                    } catch (IOException unused3) {
                                        throw th2;
                                    }
                                }
                                throw th2;
                            }
                            String string = byteArrayOutputStream.toString();
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException unused4) {
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (IOException unused5) {
                            }
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException unused6) {
                            }
                            return string;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            if (byteArrayOutputStream != 0) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException unused7) {
                                }
                            }
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (IOException unused8) {
                                }
                            }
                            if (byteArrayInputStream != null) {
                                return "";
                            }
                            try {
                                byteArrayInputStream.close();
                                return "";
                            } catch (IOException unused9) {
                                return "";
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Exception e3) {
                    gZIPInputStream = null;
                    e = e3;
                } catch (Throwable th5) {
                    r0 = byteArrayOutputStream;
                    th2 = th5;
                    gZIPInputStream = null;
                }
            } catch (Exception e4) {
                e = e4;
                gZIPInputStream = null;
                e = e;
                byteArrayOutputStream = gZIPInputStream;
                e.printStackTrace();
                if (byteArrayOutputStream != 0) {
                    byteArrayOutputStream.close();
                }
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    return "";
                }
                byteArrayInputStream.close();
                return "";
            } catch (Throwable th6) {
                th2 = th6;
                gZIPInputStream = null;
            }
        } catch (Exception e5) {
            e = e5;
            byteArrayInputStream = null;
            gZIPInputStream = null;
        } catch (Throwable th7) {
            byteArrayInputStream = null;
            gZIPInputStream = null;
            th = th7;
            byteArrayOutputStream = 0;
            Throwable th8 = th;
            r0 = byteArrayOutputStream;
            th2 = th8;
        }
    }
}
