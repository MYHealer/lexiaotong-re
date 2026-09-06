package com.jd.ad.sdk.jad_kn;

import android.content.Context;
import android.net.LocalServerSocket;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er {
    public static long jad_an;
    public static LocalServerSocket jad_bo;
    public static String[] jad_cp = {"com.bly.dkplat", "com.by.chaos", "com.lbe.parallel", "com.excelliance.dualaid", "com.lody.virtual", "com.qihoo.magic", "com.dual.dualgenius", "com.jiubang.commerce.gomultiple"};

    public static boolean jad_an() throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/self/maps"));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            bufferedReader2.close();
                            break;
                        }
                        for (String str : jad_cp) {
                            if (line.contains(str)) {
                                try {
                                    bufferedReader2.close();
                                    return true;
                                } catch (IOException unused) {
                                    return true;
                                }
                            }
                        }
                    } catch (Exception unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException unused4) {
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
        return false;
    }

    public static boolean jad_an(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        String packageName = context.getPackageName();
        return (new StringBuilder("/data/data/").append(packageName).append("/files").toString().equals(absolutePath) || new StringBuilder("/data/user/0/").append(packageName).append("/files").toString().equals(absolutePath)) ? false : true;
    }
}
