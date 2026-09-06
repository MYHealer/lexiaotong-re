package com.ubixnow.network.qumeng;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.qumeng.advlib.api.AiClkAdManager;
import com.qumeng.advlib.core.QMConfig;
import com.qumeng.advlib.core.QMCustomControl;
import com.stub.StubApp;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.j1;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O0O0O;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.oO00000o;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oOo00o00;
import com.ubixnow.ooooo.ooooO000;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class QmInitManager extends o00O0O0O {
    private static QmInitManager OooO0o0;

    private void OooO00o() {
        AiClkAdManager aiClkAdManager;
        boolean z;
        try {
            if (oO00000o.o00O0O.OooOOOo) {
                aiClkAdManager = AiClkAdManager.getInstance();
                z = true;
            } else {
                aiClkAdManager = AiClkAdManager.getInstance();
                z = false;
            }
            aiClkAdManager.setTwistSwitch(z);
        } catch (Throwable unused) {
        }
    }

    public static ErrorInfo getErrorInfo(String str) {
        return new ErrorInfo("500041", getInstance().getName() + oOO00O0.ubix_initError_msg + str);
    }

    public static synchronized QmInitManager getInstance() {
        if (OooO0o0 == null) {
            OooO0o0 = new QmInitManager();
        }
        return OooO0o0;
    }

    public String getName() {
        return "QUMENG";
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public String getVersion() {
        try {
            return AiClkAdManager.getSdkVersion();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return "";
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public synchronized void initSDK(Context context, o00O000 o00o000) {
        super.initSDK(context, o00o000);
        initSDK(context, o00o000, null);
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public synchronized void initSDK(Context context, o00O000 o00o000, o00O0OO0 o00o0oo0) {
        try {
            super.initSDK(context, o00o000, o00o0oo0);
            ooooO000.OooO0O0("-----QuMengInitManager", "init");
            if (isNeedInit(o00o000)) {
                trackSdkInitStart(o00o000);
                AiClkAdManager.getInstance().init(new QMConfig.Builder().customControl(new QMCustomControl() { // from class: com.ubixnow.network.qumeng.QmInitManager.1
                    public String getAndroidId() {
                        return !TextUtils.isEmpty(j1.OooOOO) ? j1.OooOOO : super.getAndroidId();
                    }

                    public List<PackageInfo> getAppList() {
                        return super.getAppList();
                    }

                    public Map<String, Object> getCustomConfig() {
                        HashMap map = new HashMap();
                        map.put("lt_bt", "1");
                        return map;
                    }

                    public String getDevImei() {
                        return !TextUtils.isEmpty(j1.OooOO0o) ? j1.OooOO0o : super.getDevImei();
                    }

                    public String getDevImsi() {
                        return super.getDevImsi();
                    }

                    public String getMacAddress() {
                        return !TextUtils.isEmpty(j1.OooOOO0) ? j1.OooOOO0 : super.getMacAddress();
                    }

                    public String getOaid() {
                        if (!TextUtils.isEmpty(j1.OooOOOO)) {
                            return j1.OooOOOO;
                        }
                        String strOooO0o0 = oOo00o00.OooO0o0("oaid");
                        return !TextUtils.isEmpty(strOooO0o0) ? strOooO0o0 : super.getOaid();
                    }

                    public boolean isCanUseAndroidId() {
                        return j1.OooO0OO;
                    }

                    public boolean isCanUseAppList() {
                        return j1.OooO0oo;
                    }

                    public boolean isCanUseBootId() {
                        return false;
                    }

                    public boolean isCanUseOaid() {
                        return j1.OooO0Oo;
                    }

                    public boolean isCanUsePhoneState() {
                        return j1.OooO0O0;
                    }
                }).build(StubApp.getOrigApplicationContext(context.getApplicationContext())));
                this.OooO0O0 = true;
                trackingAdsInitSucc(o00o000);
                AiClkAdManager.getInstance().setPersonalRecommend(j1.OooO);
                OooO00o();
            }
            if (j1.OooOOo0 != this.OooO0OO) {
                if (!TextUtils.isEmpty(j1.OooOOOO)) {
                    AiClkAdManager.getInstance().setOaid(j1.OooOOOO);
                }
                this.OooO0OO = j1.OooOOo0;
            }
            if (o00o0oo0 != null) {
                o00o0oo0.onSuccess();
                trackRedirectStart();
            }
        } catch (Throwable th) {
            trackingAdsInitFail(o00o000, "-1", th.getMessage());
            ooooO000.OooO00o(th);
            if (o00o0oo0 != null) {
                o00o0oo0.onError(th);
            }
        }
    }
}
