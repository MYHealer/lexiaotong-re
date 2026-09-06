package com.huawei.hms.scankit.p;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: MsModel.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class g4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[] f4262a;
    private static byte[] b;
    private static byte[] c;

    public static byte[] a() {
        return b;
    }

    public static byte[] b() {
        return c;
    }

    public static void c(Context context, String str) {
        x3.c("MsModel", "load model...." + str);
        if (f4262a != null) {
            return;
        }
        InputStream inputStreamOpen = null;
        try {
            try {
                try {
                    inputStreamOpen = context.getAssets().open(str);
                    x3.c("MsModel", "inputStream" + inputStreamOpen);
                    byte[] bArr = new byte[inputStreamOpen.available()];
                    inputStreamOpen.read(bArr);
                    inputStreamOpen.close();
                    f4262a = bArr;
                    inputStreamOpen.close();
                } catch (Throwable th) {
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (IOException unused) {
                            x3.b("MsModel", "loadModel inputStream.close() IOException");
                        }
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                x3.b("MsModel", "loadModel IOException");
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
            } catch (Exception unused3) {
                x3.b("MsModel", "loadModel Exception");
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
            }
        } catch (IOException unused4) {
            x3.b("MsModel", "loadModel inputStream.close() IOException");
        }
    }

    public static byte[] c() {
        return f4262a;
    }

    public static void a(Context context, String str) {
        x3.c("MsModel", "load angle model...." + str);
        if (b != null) {
            return;
        }
        InputStream inputStreamOpen = null;
        try {
            try {
                try {
                    inputStreamOpen = context.getAssets().open(str);
                    x3.c("MsModel", "3inputStream" + inputStreamOpen);
                    byte[] bArr = new byte[inputStreamOpen.available()];
                    inputStreamOpen.read(bArr);
                    inputStreamOpen.close();
                    b = bArr;
                    inputStreamOpen.close();
                } catch (Throwable th) {
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (IOException unused) {
                            x3.b("MsModel", "loadAngleModel inputStream.close() IOException");
                        }
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                x3.b("MsModel", "loadAngleModel IOException");
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
            } catch (Exception unused3) {
                x3.b("MsModel", "loadAngleModel Exception");
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
            }
        } catch (IOException unused4) {
            x3.b("MsModel", "loadAngleModel inputStream.close() IOException");
        }
    }

    public static void b(Context context, String str) {
        x3.c("MsModel", "load corner model...." + str);
        if (c != null) {
            return;
        }
        InputStream inputStreamOpen = null;
        try {
            try {
                try {
                    inputStreamOpen = context.getAssets().open(str);
                    x3.c("MsModel", "4inputStream" + inputStreamOpen);
                    byte[] bArr = new byte[inputStreamOpen.available()];
                    inputStreamOpen.read(bArr);
                    inputStreamOpen.close();
                    c = bArr;
                    inputStreamOpen.close();
                } catch (Throwable th) {
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (IOException unused) {
                            x3.b("MsModel", "loadConerModel inputStream.close() IOException");
                        }
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                x3.b("MsModel", "loadConerModel IOException");
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
            } catch (Exception unused3) {
                x3.b("MsModel", "loadConerModel Exception");
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
            }
        } catch (IOException unused4) {
            x3.b("MsModel", "loadConerModel inputStream.close() IOException");
        }
    }
}
