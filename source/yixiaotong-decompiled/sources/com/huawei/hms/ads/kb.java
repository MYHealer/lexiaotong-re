package com.huawei.hms.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.SafeIntent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class kb extends kr {
    private static final String Code = "AppAction";

    public kb(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    private void B() {
        PromoteInfo promoteInfoZ = this.Z.z();
        if (promoteInfoZ == null || promoteInfoZ.getType() != 1) {
            return;
        }
        fh.Code(Code, "promoteInfo Type is FastApp");
        dd.V(this.I, promoteInfoZ.getName(), this.Z);
    }

    private void C() {
        String str;
        ApkInfo apkInfoE;
        try {
            MetaData metaDataS = this.Z.S();
            jk.Code(this.I, this.Z, com.huawei.openalliance.ad.constant.aj.D, (Integer) 1, Integer.valueOf((metaDataS == null || (apkInfoE = metaDataS.e()) == null || com.huawei.openalliance.ad.utils.h.V(this.I, apkInfoE.Code()) == null) ? 1 : 2));
        } catch (IllegalStateException unused) {
            str = "recordOpenFailEvent IllegalStateException";
            fh.I(Code, str);
        } catch (Exception e) {
            str = "recordOpenFailEvent " + e.getClass().getSimpleName();
            fh.I(Code, str);
        }
    }

    private void Code(Intent intent) {
        if (intent == null) {
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        String strI = com.huawei.openalliance.ad.inter.b.Code().I();
        fh.V(Code, "at is null ? " + TextUtils.isEmpty(strI));
        if (TextUtils.isEmpty(strI)) {
            return;
        }
        if (!V(safeIntent.getDataString())) {
            fh.V(Code, "isHwPPSUri false.");
        } else if (com.huawei.openalliance.ad.utils.h.Code(this.I)) {
            safeIntent.putExtra(com.huawei.openalliance.ad.constant.x.df, strI);
        } else {
            fh.V(Code, "isHMSInstalled false.");
        }
    }

    private void Code(Intent intent, String str) {
        if (intent == null || TextUtils.isEmpty(str) || str.indexOf("hwpps") <= 0) {
            return;
        }
        intent.addFlags(268435456);
    }

    private static void Code(final com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        if (appInfo == null) {
            fh.V(Code, "appInfo is empty.");
        } else {
            com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.kb.1
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a aVarCode = com.huawei.openalliance.ad.download.a.Code();
                    if (aVarCode != null) {
                        aVarCode.Code(appInfo.Code());
                    }
                }
            });
            com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.kb.2
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a aVarCode = com.huawei.openalliance.ad.download.a.Code();
                    if (aVarCode != null) {
                        aVarCode.Code(appInfo);
                    }
                }
            });
        }
    }

    private boolean V(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            return TextUtils.equals("hwpps", uri.getScheme()) && TextUtils.equals(com.huawei.openalliance.ad.constant.x.dh, uri.getHost());
        } catch (Throwable th) {
            fh.I(Code, "isHwPPSUri exception." + th.getClass().getSimpleName());
            return false;
        }
    }

    @Override // com.huawei.hms.ads.kr
    public boolean Code() {
        String str;
        boolean z;
        fh.V(Code, "handle app action");
        try {
            B();
            com.huawei.openalliance.ad.inter.data.AppInfo appInfoY = this.Z.y();
            String strCode = appInfoY == null ? null : appInfoY.Code();
            String strM = this.Z.m();
            kw.a aVar = new kw.a();
            aVar.Code(appInfoY).Code(this.Z);
            kw kwVarCode = aVar.Code();
            if (TextUtils.isEmpty(strM) || !strM.startsWith("hwpps")) {
                z = true;
            } else {
                strM = strM + "&PPSFromIntent=hwpps";
                z = false;
            }
            Intent intentV = com.huawei.openalliance.ad.utils.h.V(this.I, strM, strCode, kwVarCode);
            if (intentV == null) {
                fh.I(Code, "cannot find target activity");
                C();
                return I();
            }
            intentV.addFlags(268435456);
            Code(intentV, strM);
            Code(intentV);
            aVar.Code(intentV);
            com.huawei.openalliance.ad.utils.h.Code(this.I, intentV, aVar.Code());
            Code(com.huawei.hms.ads.utils.a.Code(strCode, appInfoY));
            Code(this.Z.y());
            if (z) {
                jk.Code(this.I, this.Z, "intentSuccess", Integer.valueOf(com.huawei.hms.ads.utils.a.V(strCode, appInfoY)), (Integer) null);
            }
            return true;
        } catch (ActivityNotFoundException unused) {
            str = "activity not exist";
            fh.I(Code, str);
        } catch (Exception unused2) {
            str = "handle intent url fail";
            fh.I(Code, str);
        }
    }

    @Override // com.huawei.hms.ads.kr
    public void V() {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfoY = this.Z.y();
        Code(com.huawei.hms.ads.utils.a.Code(appInfoY == null ? null : appInfoY.Code(), appInfoY));
    }
}
