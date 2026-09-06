package com.alipay.sdk.packet;

import com.alipay.sdk.encrypt.f;
import com.alipay.sdk.util.n;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1645a;
    private String b = n.a(24);

    public c(boolean z) {
        this.f1645a = z;
    }

    public d a(b bVar, boolean z, String str) {
        byte[] bArrA;
        if (bVar == null) {
            return null;
        }
        byte[] bytes = bVar.a().getBytes();
        byte[] bytes2 = bVar.b().getBytes();
        if (z) {
            try {
                bytes2 = com.alipay.sdk.encrypt.c.a(bytes2);
            } catch (Exception unused) {
                z = false;
            }
        }
        if (this.f1645a) {
            bArrA = a(bytes, a(this.b, com.alipay.sdk.cons.a.c), a(this.b, bytes2, str));
        } else {
            bArrA = a(bytes, bytes2);
        }
        return new d(z, bArrA);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0076: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:37:0x0076 */
    public b a(d dVar, String str) {
        ByteArrayInputStream byteArrayInputStream;
        String str2;
        ByteArrayInputStream byteArrayInputStream2;
        String str3;
        ByteArrayInputStream byteArrayInputStream3 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(dVar.b());
                try {
                    byte[] bArr = new byte[5];
                    byteArrayInputStream.read(bArr);
                    byte[] bArr2 = new byte[a(new String(bArr))];
                    byteArrayInputStream.read(bArr2);
                    str2 = new String(bArr2);
                    try {
                        byte[] bArr3 = new byte[5];
                        byteArrayInputStream.read(bArr3);
                        int iA = a(new String(bArr3));
                        if (iA > 0) {
                            byte[] bArrB = new byte[iA];
                            byteArrayInputStream.read(bArrB);
                            if (this.f1645a) {
                                bArrB = b(this.b, bArrB, str);
                            }
                            if (dVar.a()) {
                                bArrB = com.alipay.sdk.encrypt.c.b(bArrB);
                            }
                            str3 = new String(bArrB);
                        } else {
                            str3 = null;
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused) {
                        }
                    } catch (Exception e) {
                        e = e;
                        com.alipay.sdk.util.c.a(e);
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        str3 = null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    str2 = null;
                }
            } catch (Throwable th) {
                th = th;
                byteArrayInputStream3 = byteArrayInputStream2;
                if (byteArrayInputStream3 != null) {
                    try {
                        byteArrayInputStream3.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayInputStream = null;
            str2 = null;
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayInputStream3 != null) {
                byteArrayInputStream3.close();
            }
            throw th;
        }
        if (str2 == null && str3 == null) {
            return null;
        }
        return new b(str2, str3);
    }

    private static byte[] a(String str, String str2) {
        return com.alipay.sdk.encrypt.e.a(str, str2);
    }

    private static byte[] a(String str, byte[] bArr, String str2) {
        return f.a(str, bArr, str2);
    }

    private static byte[] b(String str, byte[] bArr, String str2) {
        return f.b(str, bArr, str2);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    private static byte[] a(byte[]... bArr) throws Throwable {
        DataOutputStream dataOutputStream;
        ?? r0 = 0;
        byteArray = null;
        byte[] byteArray = null;
        if (bArr != null) {
            ?? length = bArr.length;
            try {
                if (length != 0) {
                    try {
                        length = new ByteArrayOutputStream();
                        try {
                            dataOutputStream = new DataOutputStream(length);
                            try {
                                for (byte[] bArr2 : bArr) {
                                    dataOutputStream.write(a(bArr2.length).getBytes());
                                    dataOutputStream.write(bArr2);
                                }
                                dataOutputStream.flush();
                                byteArray = length.toByteArray();
                                try {
                                    length.close();
                                } catch (Exception unused) {
                                }
                            } catch (Exception e) {
                                e = e;
                                com.alipay.sdk.util.c.a(e);
                                if (length != 0) {
                                    try {
                                        length.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                                if (dataOutputStream != null) {
                                }
                                return byteArray;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            dataOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            r0 = length;
                            if (r0 != 0) {
                                try {
                                    r0.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (r0 != 0) {
                                try {
                                    r0.close();
                                    throw th;
                                } catch (Exception unused4) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        length = 0;
                        dataOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (r0 != 0) {
                            r0.close();
                        }
                        if (r0 != 0) {
                            r0.close();
                            throw th;
                        }
                        throw th;
                    }
                    try {
                        dataOutputStream.close();
                    } catch (Exception unused5) {
                    }
                    return byteArray;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    private static String a(int i) {
        return String.format(Locale.getDefault(), "%05d", Integer.valueOf(i));
    }

    private static int a(String str) {
        return Integer.parseInt(str);
    }
}
