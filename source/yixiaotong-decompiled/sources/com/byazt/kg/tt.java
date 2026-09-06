package com.byazt.kg;

import android.app.ActivityManager;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 428, 13})
public class tt {
    public static String c(ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        StringBuilder sb = new StringBuilder("|------------- processErrorStateInfo--------------|\n");
        sb.append("condition: " + processErrorStateInfo.condition + IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("processName: " + processErrorStateInfo.processName + IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("pid: " + processErrorStateInfo.pid + IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("uid: " + processErrorStateInfo.uid + IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("tag: " + processErrorStateInfo.tag + IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("shortMsg : " + processErrorStateInfo.shortMsg + IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("longMsg : " + processErrorStateInfo.longMsg + IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("-----------------------end----------------------------");
        return sb.toString();
    }
}
