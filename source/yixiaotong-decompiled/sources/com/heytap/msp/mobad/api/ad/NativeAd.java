package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.listener.INativeAdListener;
import com.heytap.msp.mobad.api.listener.INativeRewardAdListener;
import com.heytap.msp.mobad.api.params.INativeAdData;
import com.heytap.msp.mobad.api.params.INativeAdFile;
import com.heytap.msp.mobad.api.params.INativeComplianceInfo;
import com.heytap.msp.mobad.api.params.NativeAdError;
import com.heytap.msp.mobad.api.params.NativeAdParams;
import com.huawei.hms.common.internal.RequestManager;
import com.opos.mobad.ad.d.e;
import com.opos.mobad.ad.d.f;
import com.opos.mobad.ad.d.m;
import com.opos.mobad.ad.d.q;
import com.opos.mobad.ad.d.r;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
@Deprecated
public class NativeAd {
    public static final int REWARD_SCENE_INSTALL_COMPLETE = 1;
    public static final int REWARD_SCENE_LAUNCH_APP = 2;
    public static final int REWARD_SCENE_NO = 0;
    public static final String TAG = "NativeAd";
    private boolean isCloseNative;
    private Context mContext;
    private c mListener;
    private volatile com.opos.mobad.ad.d.c mNativeAdImpl;
    private String mPosId;
    private d mRewardListener;
    private int mRewardScene;

    private static class a implements INativeAdData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.opos.mobad.ad.d.d f3432a;
        private final INativeComplianceInfo b;

        public a(com.opos.mobad.ad.d.d dVar) {
            this.f3432a = dVar;
            this.b = dVar.l() != null ? new INativeComplianceInfo() { // from class: com.heytap.msp.mobad.api.ad.NativeAd.a.1
                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getAppDescUrl() {
                    return a.this.f3432a.l().f();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getAppName() {
                    return a.this.f3432a.l().c();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getAppVersion() {
                    return a.this.f3432a.l().a();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getDeveloperName() {
                    return a.this.f3432a.l().b();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getPermissionUrl() {
                    return a.this.f3432a.l().e();
                }

                @Override // com.heytap.msp.mobad.api.params.INativeComplianceInfo
                public String getPrivacyUrl() {
                    return a.this.f3432a.l().d();
                }
            } : null;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getClickBnText() {
            return this.f3432a.j();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public INativeComplianceInfo getComplianceInfo() {
            return this.b;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public int getCreativeType() {
            return this.f3432a.e();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getDesc() {
            return this.f3432a.b();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getExtra() {
            return this.f3432a.i();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public List<INativeAdFile> getIconFiles() {
            List<e> listC = this.f3432a.c();
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (e eVar : listC) {
                if (eVar != null) {
                    arrayList.add(new b(eVar));
                }
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public List<INativeAdFile> getImgFiles() {
            List<e> listD = this.f3432a.d();
            if (listD == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (e eVar : listD) {
                if (eVar != null) {
                    arrayList.add(new b(eVar));
                }
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public int getInteractionType() {
            return this.f3432a.f();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public INativeAdFile getLogoFile() {
            e eVarG = this.f3432a.g();
            if (eVarG != null) {
                return new b(eVarG);
            }
            return null;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public String getTitle() {
            return this.f3432a.a();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public boolean isAdValid() {
            return this.f3432a.h();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public boolean isCurrentApp(String str) {
            return this.f3432a.a(str);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public boolean launchApp() {
            return this.f3432a.k();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public void onAdClick(View view) {
            this.f3432a.b(view);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdData
        public void onAdShow(View view) {
            this.f3432a.a(view);
        }
    }

    private static class b implements INativeAdFile {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f3434a;

        public b(e eVar) {
            this.f3434a = eVar;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getMd5() {
            return this.f3434a.b();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getUrl() {
            return this.f3434a.a();
        }
    }

    private static class c implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final INativeAdListener f3435a;

        public c(INativeAdListener iNativeAdListener) {
            this.f3435a = iNativeAdListener;
        }

        @Override // com.opos.mobad.ad.d.f
        public void a(q qVar) {
            if (this.f3435a == null) {
                return;
            }
            this.f3435a.onAdFailed(qVar != null ? new NativeAdError(qVar.f6647a, qVar.b) : null);
        }

        @Override // com.opos.mobad.ad.d.f
        public void a(q qVar, com.opos.mobad.ad.d.d dVar) {
            if (this.f3435a == null) {
                return;
            }
            a aVar = dVar != null ? new a(dVar) : null;
            INativeAdListener iNativeAdListener = this.f3435a;
            if (iNativeAdListener != null) {
                iNativeAdListener.onAdError(new NativeAdError(qVar.f6647a, qVar.b), aVar);
            }
        }

        @Override // com.opos.mobad.ad.d.f
        public void a(List<com.opos.mobad.ad.d.d> list) {
            ArrayList arrayList;
            if (this.f3435a == null) {
                return;
            }
            if (list != null) {
                arrayList = new ArrayList();
                for (com.opos.mobad.ad.d.d dVar : list) {
                    if (dVar != null) {
                        arrayList.add(new a(dVar));
                    }
                }
            } else {
                arrayList = null;
            }
            this.f3435a.onAdSuccess(arrayList);
        }
    }

    private static class d implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public INativeRewardAdListener f3436a;

        public d(INativeRewardAdListener iNativeRewardAdListener) {
            this.f3436a = iNativeRewardAdListener;
        }

        @Override // com.opos.mobad.ad.d.f
        public void a(q qVar) {
            if (this.f3436a == null) {
                return;
            }
            this.f3436a.onAdFailed(qVar != null ? new NativeAdError(qVar.f6647a, qVar.b) : null);
        }

        @Override // com.opos.mobad.ad.d.f
        public void a(q qVar, com.opos.mobad.ad.d.d dVar) {
            if (this.f3436a == null) {
                return;
            }
            a aVar = dVar != null ? new a(dVar) : null;
            INativeRewardAdListener iNativeRewardAdListener = this.f3436a;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onAdError(new NativeAdError(qVar.f6647a, qVar.b), aVar);
            }
        }

        @Override // com.opos.mobad.ad.h
        public void a(String str) {
            INativeRewardAdListener iNativeRewardAdListener = this.f3436a;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onInstallCompleted(str);
            }
        }

        @Override // com.opos.mobad.ad.d.f
        public void a(List<com.opos.mobad.ad.d.d> list) {
            ArrayList arrayList;
            if (this.f3436a == null) {
                return;
            }
            if (list != null) {
                arrayList = new ArrayList();
                for (com.opos.mobad.ad.d.d dVar : list) {
                    if (dVar != null) {
                        arrayList.add(new a(dVar));
                    }
                }
            } else {
                arrayList = null;
            }
            this.f3436a.onAdSuccess(arrayList);
        }

        @Override // com.opos.mobad.ad.j
        public void a(Object... objArr) {
            INativeRewardAdListener iNativeRewardAdListener = this.f3436a;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onReward(objArr);
            }
        }

        @Override // com.opos.mobad.ad.d.m
        public void b(Object... objArr) {
            INativeRewardAdListener iNativeRewardAdListener = this.f3436a;
            if (iNativeRewardAdListener != null) {
                iNativeRewardAdListener.onRewardFail(objArr);
            }
        }
    }

    @Deprecated
    public NativeAd(Context context, String str, int i, INativeRewardAdListener iNativeRewardAdListener) {
        this.isCloseNative = true;
        if (context == null || TextUtils.isEmpty(str) || iNativeRewardAdListener == null) {
            Log.e(TAG, "NativeAd Constructor param context and posId and iNativeRewardAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mRewardListener = new d(iNativeRewardAdListener);
        this.mRewardScene = i;
        this.isCloseNative = com.heytap.msp.mobad.api.a.a().a(this.mPosId);
        initImplIfNeed();
    }

    @Deprecated
    public NativeAd(Context context, String str, INativeAdListener iNativeAdListener) {
        this.isCloseNative = true;
        if (context == null || TextUtils.isEmpty(str) || iNativeAdListener == null) {
            Log.e(TAG, "NativeAd Constructor param context and posId and iNativeAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mListener = new c(iNativeAdListener);
        this.isCloseNative = com.heytap.msp.mobad.api.a.a().a(this.mPosId);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.isCloseNative) {
            return false;
        }
        if (this.mNativeAdImpl != null) {
            return true;
        }
        if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mNativeAdImpl != null) {
                return true;
            }
            this.mNativeAdImpl = this.mRewardScene > 0 ? com.heytap.msp.mobad.api.a.a().a(StubApp.getOrigApplicationContext(this.mContext.getApplicationContext()), this.mPosId, this.mRewardScene, this.mRewardListener) : com.heytap.msp.mobad.api.a.a().a(StubApp.getOrigApplicationContext(this.mContext.getApplicationContext()), this.mPosId, this.mListener);
            return this.mNativeAdImpl != null;
        }
    }

    @Deprecated
    public void destroyAd() {
        if (this.mNativeAdImpl != null) {
            this.mNativeAdImpl.a();
        }
        this.mContext = null;
        this.mPosId = null;
    }

    @Deprecated
    public void loadAd() {
        loadAd(null);
    }

    @Deprecated
    public void loadAd(NativeAdParams nativeAdParams) {
        r rVarA;
        if (initImplIfNeed()) {
            if (nativeAdParams != null) {
                r.a aVar = new r.a();
                aVar.a(nativeAdParams.fetchTimeout);
                rVarA = aVar.a();
            } else {
                rVarA = null;
            }
            this.mNativeAdImpl.a(rVarA);
            return;
        }
        int i = this.isCloseNative ? RequestManager.NOTIFY_CONNECT_FAILED : -1;
        c cVar = this.mListener;
        if (cVar != null) {
            cVar.a(new q(i, "inter ad create fail"));
            return;
        }
        d dVar = this.mRewardListener;
        if (dVar != null) {
            dVar.a(new q(i, "inter ad create fail"));
        }
    }
}
