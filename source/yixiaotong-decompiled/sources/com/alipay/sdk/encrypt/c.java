package com.alipay.sdk.encrypt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class c {
    /* JADX WARN: Code duplicated, block: B:40:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] a(byte[] bArr) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        byte[] bArr2 = new byte[4096];
                        while (true) {
                            int i = byteArrayInputStream.read(bArr2);
                            if (i == -1) {
                                break;
                            }
                            gZIPOutputStream.write(bArr2, 0, i);
                        }
                        gZIPOutputStream.flush();
                        gZIPOutputStream.finish();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused2) {
                        }
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused3) {
                        }
                        return byteArray;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        if (byteArrayOutputStream != 0) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused5) {
                            }
                        }
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                                throw th;
                            } catch (Exception unused6) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    gZIPOutputStream = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                gZIPOutputStream = null;
                th = th;
                byteArrayOutputStream = gZIPOutputStream;
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (byteArrayOutputStream != 0) {
                    byteArrayOutputStream.close();
                }
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayInputStream = null;
            gZIPOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] b(byte[] bArr) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        GZIPInputStream gZIPInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr2 = new byte[4096];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int i = gZIPInputStream.read(bArr2, 0, 4096);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, i);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused) {
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (Exception unused2) {
                            }
                            try {
                                byteArrayInputStream.close();
                                throw th;
                            } catch (Exception unused3) {
                                throw th;
                            }
                        }
                    }
                    byteArrayOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused4) {
                    }
                    try {
                        gZIPInputStream.close();
                    } catch (Exception unused5) {
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused6) {
                    }
                    return byteArray;
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                th = th;
                gZIPInputStream = byteArrayOutputStream;
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayInputStream = null;
            byteArrayOutputStream = null;
        }
    }
}
