package com.hihonor.updater.installsdk;

import android.content.Context;
import com.hihonor.updater.installsdk.api.AppStatusCallback;
import com.hihonor.updater.installsdk.api.AppStatusInfo;
import com.hihonor.updater.installsdk.api.DIInfo;
import com.hihonor.updater.installsdk.api.DownloadInstallListener;
import com.hihonor.updater.installsdk.api.ResultCallback;
import com.hihonor.updater.installsdk.exception.GetSettingValueException;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface b {
    void a(Context context, DIInfo dIInfo, ResultCallback resultCallback);

    void a(Context context, boolean z, ResultCallback resultCallback);

    void a(Context context, boolean z, List<String> list, AppStatusCallback appStatusCallback);

    void a(DIInfo dIInfo, AppStatusInfo appStatusInfo);

    void a(DownloadInstallListener downloadInstallListener);

    boolean a();

    boolean a(Context context) throws GetSettingValueException;

    void b(Context context, DIInfo dIInfo, ResultCallback resultCallback);

    void b(DownloadInstallListener downloadInstallListener);

    boolean b(Context context);

    void c(Context context, DIInfo dIInfo, ResultCallback resultCallback);

    boolean c(Context context) throws GetSettingValueException;

    boolean d(Context context);

    void onAppUninstalled(DIInfo dIInfo, AppStatusInfo appStatusInfo);
}
