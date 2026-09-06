package com.meishu.sdk.platform;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.a;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.c;
import com.meishu.sdk.core.utils.LogUtil;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ADPlatformHelper {
    private static final String TAG = "ADPlatformHelper";

    private static boolean checkPlatformPermission(Context context, String str) {
        List<String> neededPermissions = a.a(str).config().getNeededPermissions();
        if (neededPermissions == null) {
            return true;
        }
        Iterator<String> it = neededPermissions.iterator();
        while (it.hasNext()) {
            if (ActivityCompat.checkSelfPermission(context, it.next()) != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkTypeSupport(c cVar, String str) {
        for (AdType adType : a.a(str).support()) {
            if (cVar.getAdType().equals(adType)) {
                return true;
            }
        }
        return false;
    }

    public static SdkAdInfo[] filterValidSdk(Context context, SdkAdInfo[] sdkAdInfoArr, c cVar) {
        if (sdkAdInfoArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(sdkAdInfoArr.length);
        for (int i = 0; i < sdkAdInfoArr.length; i++) {
            if (isSdkValid(context, sdkAdInfoArr[i], cVar)) {
                if (AdSdk.adConfig() != null && AdSdk.adConfig().isUseMediation()) {
                    arrayList.add(sdkAdInfoArr[i]);
                } else if (!TextUtils.isEmpty(sdkAdInfoArr[i].getCls())) {
                    arrayList.add(sdkAdInfoArr[i]);
                }
            }
        }
        return (SdkAdInfo[]) arrayList.toArray(new SdkAdInfo[0]);
    }

    private static boolean isSdkValid(Context context, SdkAdInfo sdkAdInfo, c cVar) {
        String sdk;
        try {
            sdk = sdkAdInfo.getSdk();
            try {
                if (TextUtils.isEmpty(sdk)) {
                    LogUtil.e(TAG, "sdk invalid, platform is empty");
                    return false;
                }
                if (GlobalSetting.ADMOB_SDK_WRAPPER.equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getAdmobVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                if ("PANGLE".equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getPangleVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                if ("DM".equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getDuoMengVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                if ("SGM".equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getSGMVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                Iterator<String> it = PlatformFactory.ploatforms.iterator();
                while (it.hasNext()) {
                    if (it.next().equalsIgnoreCase(sdk) && checkPlatformPermission(context, sdk) && checkTypeSupport(cVar, sdk)) {
                        return true;
                    }
                }
                LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                return false;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
            sdk = null;
        }
    }
}
