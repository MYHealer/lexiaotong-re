package com.bykv.vk.component.ttvideo.utils;

import android.content.Context;
import com.huawei.openalliance.ad.constant.x;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class AVErrorInfo {
    public static final String CRASH = "crash";
    public static final String ERROR = "error";
    private static StringBuilder PHONE_INFO;

    public static final void setupPhoneInfo(Context context, StringBuilder sb) throws Throwable {
        String[] version = VersionInfo.getVersion();
        if (version != null) {
            sb.append(String.format("version:%s,%s,%s\r\n", version[0], version[1], version[2])).append(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        long[] romMemroy = MemoryInfo.getRomMemroy();
        if (romMemroy != null) {
            sb.append(String.format(Locale.US, "rom memory totle:%d,availe:%d\r\n", Long.valueOf(romMemroy[0]), Long.valueOf(romMemroy[1]))).append(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        long availMemory = MemoryInfo.getAvailMemory(context);
        sb.append(String.format(Locale.US, "ram memory totle:%d,availe:%d\r\n", Long.valueOf(MemoryInfo.getTolalMemory()), Long.valueOf(availMemory))).append(IOUtils.LINE_SEPARATOR_WINDOWS);
        long[] sDCardSize = HardWareInfo.getSDCardSize(context);
        if (sDCardSize != null) {
            sb.append(String.format(Locale.US, "sdcard totle:%d,availe:%d\r\n", Long.valueOf(sDCardSize[0]), Long.valueOf(sDCardSize[1]))).append(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
    }

    public static void setupErrorInfo(Context context, StringBuilder sb, String str, String str2, String str3) throws Throwable {
        if (PHONE_INFO == null) {
            StringBuilder sb2 = new StringBuilder();
            PHONE_INFO = sb2;
            setupPhoneInfo(context, sb2);
        }
        sb.append((CharSequence) PHONE_INFO);
        sb.append(IOUtils.LINE_SEPARATOR_WINDOWS).append(str).append(x.bQ).append(str2);
    }
}
