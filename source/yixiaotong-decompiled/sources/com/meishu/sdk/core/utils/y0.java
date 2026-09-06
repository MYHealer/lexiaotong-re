package com.meishu.sdk.core.utils;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: RequestUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class y0 extends com.meishu.sdk.core.safe.l {
    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        try {
            Process processStart = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream(), "utf-8"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                } else {
                    stringBuffer.append(line);
                }
            }
            bufferedReader.close();
            String lowerCase = stringBuffer.toString().toLowerCase();
            x0.A = lowerCase;
            if (TextUtils.isEmpty(lowerCase)) {
                return;
            }
            q.a().b("cpuInfo", x0.A);
        } catch (Throwable unused) {
        }
    }
}
