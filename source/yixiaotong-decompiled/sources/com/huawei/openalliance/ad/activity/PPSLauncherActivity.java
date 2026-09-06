package com.huawei.openalliance.ad.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import com.byazt.hv.TTDownloadField;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PPSLauncherActivity extends d {
    public static final String Code = "69";
    private static final String V = "PPSLauncherActivity";

    static {
        StubApp.interface11(35586);
    }

    private void Code() {
        com.huawei.openalliance.ad.download.app.c.Code(this, Code, (AdContentData) null, (RemoteCallResultCallback) null, (Class) null);
    }

    public boolean Code(Context context) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningTasks(10)) {
            if (runningTaskInfo.topActivity.getClassName().equalsIgnoreCase(PPSLauncherActivity.class.getName()) && runningTaskInfo.numActivities < 2) {
                return false;
            }
            if (runningTaskInfo.topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    protected native void onCreate(Bundle bundle);
}
