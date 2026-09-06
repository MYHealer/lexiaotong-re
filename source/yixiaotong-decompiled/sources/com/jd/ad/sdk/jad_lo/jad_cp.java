package com.jd.ad.sdk.jad_lo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp {
    public static String jad_an(String str, boolean z) {
        BufferedReader bufferedReader;
        String strTrim;
        StringBuffer stringBuffer = new StringBuffer();
        File file = new File(str);
        if (file.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (z) {
                            line = line + IOUtils.LINE_SEPARATOR_UNIX;
                        }
                        stringBuffer.append(line);
                    } catch (Throwable unused) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                        strTrim = stringBuffer.toString().trim();
                        return !z ? strTrim : strTrim;
                    }
                }
            } catch (Throwable unused3) {
                bufferedReader = null;
            }
            bufferedReader.close();
        }
        strTrim = stringBuffer.toString().trim();
        if (!z && strTrim.endsWith(IOUtils.LINE_SEPARATOR_UNIX)) {
            return strTrim.substring(0, strTrim.length() - 2);
        }
    }
}
