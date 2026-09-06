package com.yfanads.android.utils.log;

import com.huawei.openalliance.ad.constant.x;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DateLogContentGenerator implements LogContentGenerator {
    @Override // com.yfanads.android.utils.log.LogContentGenerator
    public String generateLogContent(LogFileBean logFileBean) {
        return new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(logFileBean.time) + x.bQ + logFileBean.tag + x.bQ + logFileBean.msg;
    }
}
