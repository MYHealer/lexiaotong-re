package com.kuaishou.weapon.p0;

import com.huawei.hms.ml.camera.CountryCodeBean;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile aa f4620a;

    private aa() {
    }

    public static synchronized aa a() {
        if (f4620a == null) {
            synchronized (aa.class) {
                if (f4620a == null) {
                    f4620a = new aa();
                }
            }
        }
        return f4620a;
    }

    public String a(String str) {
        try {
            Object objInvoke = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getMethod("get", String.class).invoke(null, str);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    /* JADX WARN: Code duplicated, block: B:50:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8 */
    public String b(String str) throws Throwable {
        Process processExec;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            processExec = Runtime.getRuntime().exec("sh");
            try {
                bufferedOutputStream = new BufferedOutputStream(processExec.getOutputStream());
                try {
                    bufferedInputStream2 = new BufferedInputStream(processExec.getInputStream());
                    try {
                        bufferedOutputStream.write(str.getBytes());
                        bufferedOutputStream.write(10);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        processExec.waitFor();
                        String strA = a(bufferedInputStream2);
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused) {
                        }
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException unused2) {
                        }
                        if (processExec != null) {
                            processExec.destroy();
                        }
                        return strA;
                    } catch (Exception unused3) {
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (bufferedInputStream2 != 0) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (processExec != null) {
                            processExec.destroy();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream2 = bufferedOutputStream;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException unused6) {
                            }
                        }
                        if (bufferedInputStream != 0) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (processExec != null) {
                            processExec.destroy();
                            throw th;
                        }
                        throw th;
                    }
                } catch (Exception unused8) {
                    bufferedInputStream2 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = 0;
                }
            } catch (Exception unused9) {
                bufferedOutputStream = null;
                bufferedInputStream2 = bufferedOutputStream;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream2 != 0) {
                    bufferedInputStream2.close();
                }
                if (processExec != null) {
                    processExec.destroy();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = 0;
            }
        } catch (Exception unused10) {
            processExec = null;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            processExec = null;
            bufferedInputStream = 0;
        }
    }

    private static String a(BufferedInputStream bufferedInputStream) {
        int i;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[512];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                i = bufferedInputStream.read(bArr);
                if (i > 0) {
                    sb.append(new String(bArr, 0, i));
                }
            } catch (Exception unused) {
            }
        } while (i >= 512);
        return sb.toString();
    }
}
