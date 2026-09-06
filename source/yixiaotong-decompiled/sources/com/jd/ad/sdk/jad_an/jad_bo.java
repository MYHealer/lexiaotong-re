package com.jd.ad.sdk.jad_an;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface jad_bo {
    int jad_an(Context context);

    String jad_an();

    List<ActivityManager.RunningServiceInfo> jad_an(Context context, int i);

    String jad_bo();

    String jad_bo(Context context);

    List<ActivityManager.RunningTaskInfo> jad_bo(Context context, int i);

    String jad_cp();

    String jad_cp(Context context);

    List<PackageInfo> jad_cp(Context context, int i);

    List<ActivityManager.RunningAppProcessInfo> jad_dq(Context context);
}
