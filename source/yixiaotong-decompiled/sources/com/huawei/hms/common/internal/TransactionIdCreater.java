package com.huawei.hms.common.internal;

import client.android.yixiaotong.util.TimeUtils;
import com.huawei.hms.utils.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class TransactionIdCreater {
    public static String getId(String str, String str2) {
        return StringUtil.addByteForNum(str, 9, '0') + StringUtil.addByteForNum(str2, 6, '0') + new SimpleDateFormat(TimeUtils.FORMATDATETIME1, Locale.ENGLISH).format(new Date()) + String.format(Locale.ENGLISH, "%06d", Integer.valueOf(new Random().nextInt(1000000)));
    }
}
