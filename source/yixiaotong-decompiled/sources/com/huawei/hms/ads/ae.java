package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface ae {
    Context Code(Context context);

    com.huawei.openalliance.ad.utils.i.a Code();

    Object Code(Context context, String str);

    void Code(Activity activity);

    void Code(String str);

    void V(String str);

    void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback);
}
