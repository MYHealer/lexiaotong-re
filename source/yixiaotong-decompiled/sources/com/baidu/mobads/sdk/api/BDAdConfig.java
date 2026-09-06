package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.aa;
import com.baidu.mobads.sdk.internal.az;
import com.baidu.mobads.sdk.internal.bd;
import com.baidu.mobads.sdk.internal.cs;
import com.baidu.mobads.sdk.internal.d;
import com.baidu.mobads.sdk.internal.e;
import com.huawei.hms.ads.ez;
import com.huawei.openalliance.ad.constant.ba;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BDAdConfig {
    private Context mAppContext;
    private String mAppName;
    private String mAppsid;
    private BDAdInitListener mBDAdInitListener;
    private String mChannelId;
    private int mCheckAdInUiThread;
    private boolean mCloseShake;
    private JSONObject mConfigObj;
    private boolean mDebug;
    private JSONObject mDialogParams;
    private JSONObject mExtraParams;
    private long mInitTime;
    private boolean mLpMultiProcess;
    private boolean mMtjSwitch;
    private boolean mSplashLog;
    private boolean mUseActivityDialog;
    private int mVideoCacheCapacityMb;
    private String mWXAPPid;

    public interface BDAdInitListener {
        void fail();

        void success();
    }

    private BDAdConfig(Context context, Builder builder) {
        this.mUseActivityDialog = true;
        this.mDebug = false;
        this.mSplashLog = false;
        this.mCheckAdInUiThread = 0;
        this.mInitTime = 0L;
        this.mAppContext = context;
        this.mVideoCacheCapacityMb = builder.mVideoCacheCapacityMb;
        this.mAppName = builder.mAppName;
        this.mAppsid = builder.mAppsid;
        this.mChannelId = builder.mChannelId;
        this.mLpMultiProcess = builder.mLpSupportMultiProcess;
        this.mUseActivityDialog = builder.mUseActivityDialog;
        this.mDialogParams = builder.mDialogParams;
        this.mMtjSwitch = builder.mMtjSwitch;
        this.mCloseShake = builder.mCloseShake;
        this.mDebug = builder.mDebug;
        this.mWXAPPid = builder.mWXAPPid;
        this.mBDAdInitListener = builder.mBDAdInitListener;
        this.mSplashLog = builder.mSplashLog;
        this.mCheckAdInUiThread = builder.mCheckAdInUiThread;
        this.mExtraParams = builder.mExtraParams;
    }

    public void init() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        initConfig();
        JSONObject jSONObject = this.mConfigObj;
        if (jSONObject != null) {
            try {
                jSONObject.put("gmss", e.a());
                this.mConfigObj.put("toss", e.b());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        aa.a().a(this.mAppContext, new aa.a() { // from class: com.baidu.mobads.sdk.api.BDAdConfig.1
            @Override // com.baidu.mobads.sdk.internal.aa.a
            public void onSuccess() {
                IXAdContainerFactory iXAdContainerFactoryC = aa.a().c();
                if (iXAdContainerFactoryC != null) {
                    iXAdContainerFactoryC.initConfig(BDAdConfig.this.mConfigObj);
                    iXAdContainerFactoryC.onTaskDistribute(bd.f1741a, MobadsPermissionSettings.getPermissionInfo());
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        if (BDAdConfig.this.mInitTime == 0) {
                            BDAdConfig.this.mInitTime = System.currentTimeMillis() - jCurrentTimeMillis;
                            jSONObject2.put(d.f1799a, BDAdConfig.this.mInitTime);
                            iXAdContainerFactoryC.onTaskDistribute(bd.d, jSONObject2);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (BDAdConfig.this.mBDAdInitListener != null) {
                    BDAdConfig.this.mBDAdInitListener.success();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.aa.a
            public void onFailure() {
                if (BDAdConfig.this.mBDAdInitListener != null) {
                    BDAdConfig.this.mBDAdInitListener.fail();
                }
            }
        });
    }

    public void preInit() {
        try {
            initConfig();
            final long jCurrentTimeMillis = System.currentTimeMillis();
            aa.a().a(this.mAppContext, new aa.a() { // from class: com.baidu.mobads.sdk.api.BDAdConfig.2
                @Override // com.baidu.mobads.sdk.internal.aa.a
                public void onSuccess() {
                    IXAdContainerFactory iXAdContainerFactoryC = aa.a().c();
                    if (iXAdContainerFactoryC != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (BDAdConfig.this.mInitTime == 0) {
                                BDAdConfig.this.mInitTime = System.currentTimeMillis() - jCurrentTimeMillis;
                                jSONObject.put(d.f1799a, BDAdConfig.this.mInitTime);
                                iXAdContainerFactoryC.onTaskDistribute(bd.d, jSONObject);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    if (BDAdConfig.this.mBDAdInitListener != null) {
                        BDAdConfig.this.mBDAdInitListener.success();
                        BDAdConfig.this.mBDAdInitListener = null;
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.aa.a
                public void onFailure() {
                    if (BDAdConfig.this.mBDAdInitListener != null) {
                        BDAdConfig.this.mBDAdInitListener.fail();
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void initConfig() {
        try {
            if (this.mConfigObj == null) {
                this.mConfigObj = new JSONObject();
            }
            this.mConfigObj.put("https", ez.Code);
            this.mConfigObj.put("appName", this.mAppName);
            this.mConfigObj.put("videoCacheSize", "" + this.mVideoCacheCapacityMb);
            this.mConfigObj.put("appsid", this.mAppsid);
            this.mConfigObj.put("channelId", this.mChannelId);
            this.mConfigObj.put("lpMultiProcess", "" + this.mLpMultiProcess);
            this.mConfigObj.put("useActivityDialog", "" + this.mUseActivityDialog);
            this.mConfigObj.put("dialog_params", this.mDialogParams);
            this.mConfigObj.put("mtj_switch", this.mMtjSwitch);
            this.mConfigObj.put("sp_shake", this.mCloseShake);
            this.mConfigObj.put("sdk_debug", this.mDebug);
            this.mConfigObj.put("splashLog", this.mSplashLog);
            this.mConfigObj.put("check_thread", this.mCheckAdInUiThread);
            this.mConfigObj.put(ba.M, this.mExtraParams);
            if (!TextUtils.isEmpty(this.mWXAPPid)) {
                this.mConfigObj.put("wxAppid", this.mWXAPPid);
            }
            cs.a().a(this.mLpMultiProcess);
            az.a(this.mDebug);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void clearMemoryCache() {
        try {
            aa.a().c().onTaskDistribute(bd.c, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static class Builder {
        private String mAppName;
        private String mAppsid;
        private BDAdInitListener mBDAdInitListener;
        private String mChannelId;
        private JSONObject mDialogParams;
        private JSONObject mExtraParams;
        private boolean mLpSupportMultiProcess;
        private int mVideoCacheCapacityMb;
        private String mWXAPPid;
        private boolean mUseActivityDialog = true;
        private boolean mMtjSwitch = true;
        private boolean mCloseShake = false;
        private boolean mDebug = false;
        private boolean mSplashLog = false;
        private int mCheckAdInUiThread = 0;

        public Builder checkAdInUiThread(boolean z) {
            this.mCheckAdInUiThread = z ? 1 : 0;
            return this;
        }

        public Builder setAppName(String str) {
            this.mAppName = str;
            return this;
        }

        public Builder setAppsid(String str) {
            this.mAppsid = str;
            return this;
        }

        public Builder setBDAdInitListener(BDAdInitListener bDAdInitListener) {
            this.mBDAdInitListener = bDAdInitListener;
            return this;
        }

        public Builder setChannelId(String str) {
            this.mChannelId = str;
            return this;
        }

        public Builder setCloseShake(boolean z) {
            this.mCloseShake = z;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.mDebug = z;
            return this;
        }

        public Builder setLpMultiProcess(boolean z) {
            this.mLpSupportMultiProcess = z;
            return this;
        }

        public Builder setMtjSwitch(boolean z) {
            this.mMtjSwitch = z;
            return this;
        }

        public Builder setSplashLog(boolean z) {
            this.mSplashLog = z;
            return this;
        }

        public Builder setVideoCacheCapacityMb(int i) {
            this.mVideoCacheCapacityMb = i;
            return this;
        }

        public Builder setWXAppid(String str) {
            this.mWXAPPid = str;
            return this;
        }

        @Deprecated
        public Builder useActivityDialog(Boolean bool) {
            this.mUseActivityDialog = bool.booleanValue();
            return this;
        }

        public Builder setDialogParams(BDDialogParams bDDialogParams) {
            this.mDialogParams = bDDialogParams.toJson();
            return this;
        }

        public Builder putExtraParam(String str, String str2) {
            if (this.mExtraParams == null) {
                this.mExtraParams = new JSONObject();
            }
            try {
                this.mExtraParams.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return this;
        }

        public BDAdConfig build(Context context) {
            return new BDAdConfig(context, this);
        }
    }
}
