package com.huawei.openalliance.ad.utils;

import com.huawei.hms.ads.fh;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ax {
    private static final String Code = "ax";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable] */
    public static Serializable Code(String str) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        aw awVar;
        String str2;
        String str3;
        Serializable serializable = null;
        try {
            try {
                fileInputStream = new FileInputStream((String) str);
                try {
                    awVar = new aw(fileInputStream);
                    try {
                        Object object = awVar.readObject();
                        if (object instanceof Serializable) {
                            serializable = (Serializable) object;
                        }
                    } catch (FileNotFoundException unused) {
                        fh.Z(Code, "read file FileNotFoundException");
                    } catch (IOException unused2) {
                        str2 = Code;
                        str3 = "read file IOException";
                        fh.I(str2, str3);
                    } catch (ClassNotFoundException unused3) {
                        str2 = Code;
                        str3 = "read file ClassNotFoundException";
                        fh.I(str2, str3);
                    }
                } catch (FileNotFoundException unused4) {
                    awVar = null;
                } catch (IOException unused5) {
                    awVar = null;
                } catch (ClassNotFoundException unused6) {
                    awVar = null;
                } catch (Throwable th2) {
                    th = th2;
                    str = 0;
                    bb.Code((Closeable) fileInputStream);
                    bb.Code((Closeable) str);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException unused7) {
            awVar = null;
            fileInputStream = null;
        } catch (IOException unused8) {
            awVar = null;
            fileInputStream = null;
        } catch (ClassNotFoundException unused9) {
            awVar = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            str = 0;
        }
        bb.Code((Closeable) fileInputStream);
        bb.Code((Closeable) awVar);
        return serializable;
    }

    public static String Code(Serializable serializable) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        if (serializable == null) {
            return "";
        }
        ObjectOutputStream objectOutputStream2 = null;
        byte[] byteArray = null;
        objectOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream.writeObject(serializable);
                        objectOutputStream.flush();
                        byteArray = byteArrayOutputStream.toByteArray();
                    } catch (IOException unused) {
                        fh.Z(Code, "fail to get sequence");
                    }
                } catch (IOException unused2) {
                    objectOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    bb.Code(objectOutputStream2);
                    bb.Code(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
            }
        } catch (IOException unused3) {
            byteArrayOutputStream = null;
            objectOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
        bb.Code(objectOutputStream);
        bb.Code(byteArrayOutputStream);
        return y.Code(byteArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.io.Closeable, java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static boolean Code(Serializable serializable, String str) throws Throwable {
        ?? r4;
        ?? r5;
        String str2;
        String str3;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File((String) str);
                if (!file.getParentFile().exists() && !u.Code(file.getParentFile())) {
                    fh.I(Code, "writeObject, mkdir failed");
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream((String) str);
                try {
                    str = new ObjectOutputStream(fileOutputStream2);
                    try {
                        str.writeObject(serializable);
                        bb.Code(fileOutputStream2);
                        bb.Code((Closeable) str);
                        return true;
                    } catch (FileNotFoundException unused) {
                        fileOutputStream = fileOutputStream2;
                        r5 = str;
                        str2 = Code;
                        str3 = "write file FileNotFoundException";
                        str = r5;
                        fh.I(str2, str3);
                        bb.Code(fileOutputStream);
                        bb.Code((Closeable) str);
                        return false;
                    } catch (IOException unused2) {
                        fileOutputStream = fileOutputStream2;
                        r4 = str;
                        str2 = Code;
                        str3 = "write file IOException";
                        str = r4;
                        fh.I(str2, str3);
                        bb.Code(fileOutputStream);
                        bb.Code((Closeable) str);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        bb.Code(fileOutputStream);
                        bb.Code((Closeable) str);
                        throw th;
                    }
                } catch (FileNotFoundException unused3) {
                    str = 0;
                } catch (IOException unused4) {
                    str = 0;
                } catch (Throwable th2) {
                    th = th2;
                    str = 0;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException unused5) {
            r5 = 0;
        } catch (IOException unused6) {
            r4 = 0;
        } catch (Throwable th4) {
            th = th4;
            str = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v3 */
    public static Serializable V(String str) {
        aw awVar;
        String str2;
        String str3;
        ?? r0;
        ?? r1;
        ?? Code2 = bc.Code((String) str);
        Serializable serializable = null;
        try {
            if (Code2 != 0) {
                return null;
            }
            try {
                Code2 = new ByteArrayInputStream(y.Code((String) str));
                try {
                    awVar = new aw(Code2);
                    try {
                        Object object = awVar.readObject();
                        r1 = Code2;
                        if (object instanceof Serializable) {
                            serializable = (Serializable) object;
                            r1 = Code2;
                        }
                    } catch (UnsupportedEncodingException unused) {
                        str2 = Code;
                        str3 = "fail to get Serializable UnsupportedEncodingException";
                        r0 = Code2;
                        fh.Z(str2, str3);
                        r1 = r0;
                    } catch (IOException unused2) {
                        str2 = Code;
                        str3 = "fail to get Serializable IOException";
                        r0 = Code2;
                        fh.Z(str2, str3);
                        r1 = r0;
                    } catch (ClassNotFoundException unused3) {
                        str2 = Code;
                        str3 = "fail to get Serializable ClassNotFoundException";
                        r0 = Code2;
                        fh.Z(str2, str3);
                        r1 = r0;
                    }
                } catch (UnsupportedEncodingException unused4) {
                    awVar = null;
                } catch (IOException unused5) {
                    awVar = null;
                } catch (ClassNotFoundException unused6) {
                    awVar = null;
                } catch (Throwable th) {
                    th = th;
                    str = 0;
                    bb.Code((Closeable) str);
                    bb.Code((Closeable) Code2);
                    throw th;
                }
            } catch (UnsupportedEncodingException unused7) {
                awVar = null;
                Code2 = 0;
            } catch (IOException unused8) {
                awVar = null;
                Code2 = 0;
            } catch (ClassNotFoundException unused9) {
                awVar = null;
                Code2 = 0;
            } catch (Throwable th2) {
                Code2 = 0;
                th = th2;
                str = 0;
            }
            bb.Code((Closeable) awVar);
            bb.Code((Closeable) r1);
            return serializable;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
