package com.alipay.security.mobile.module.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class b {
    /* JADX WARN: Code duplicated, block: B:21:0x003f A[Catch: all -> 0x0042, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0042, blocks: (B:11:0x002d, B:21:0x003f), top: B:28:0x0006 }] */
    public static String a(String str, String str2) throws Throwable {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                File file = new File(str, str2);
                if (!file.exists()) {
                    return null;
                }
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    } catch (IOException unused) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
                return sb.toString();
            } catch (Throwable unused3) {
            }
        } catch (IOException unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        return sb.toString();
    }
}
