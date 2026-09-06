package client.android.yixiaotong.v3.ui.adv;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.v3.bean.adv.BannerJumpInfoBean;
import client.android.yixiaotong.v3.bean.adv.BannernfoBean;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.byazt.hv.TTDownloadField;
import com.huawei.openalliance.ad.constant.ba;
import com.huawei.openalliance.ad.constant.x;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AdvControlUtil {
    private static final String TAG = "AdvControlUtil";
    private Activity mActivity;
    private AdvListener mAdvListener;
    private int mBannerAdvNumber;
    private List<BannerJumpInfoBean> mBannerJumpInfo;
    private boolean mIsEnable;
    private boolean mIsNewPlantion;
    private boolean mIsOpenBannerAdv;
    private boolean mIsOpenInsertAdv;
    private boolean mIsOpenNativeAdv;
    private boolean mIsOpenSplashAdv;
    private int mNativeAdvNumber;
    private int mPopAdvNumber;
    private String mSchoolId;
    private int mSplashAdvNumber;
    private int mTypeId;

    /* JADX INFO: renamed from: client.android.yixiaotong.v3.ui.adv.AdvControlUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface AdvListener {
        void isOpen(int i, int i2, int i3, int i4, int i5);

        void onAdClosed(Common.AdvType advType);

        void onAdShow(String str, Common.AdvType advType);

        void onRenderSuccess(View view, int i);
    }

    public List<BannerJumpInfoBean> getBannerJumpInfos() {
        return this.mBannerJumpInfo;
    }

    public void init(Activity activity, AdvListener advListener, int i, boolean z, String str) {
        this.mActivity = activity;
        this.mAdvListener = advListener;
        this.mTypeId = i;
        this.mIsNewPlantion = z;
        this.mSchoolId = str;
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    /* synthetic */ AdvControlUtil(AnonymousClass1 anonymousClass1) {
        this();
    }

    private AdvControlUtil() {
        this.mIsEnable = true;
        this.mTypeId = 0;
        this.mIsNewPlantion = true;
        this.mIsOpenSplashAdv = true;
        this.mIsOpenInsertAdv = true;
        this.mIsOpenBannerAdv = true;
        this.mIsOpenNativeAdv = true;
        this.mBannerJumpInfo = new ArrayList();
    }

    private static final class SingleHolder {
        private static final AdvControlUtil INSTANCE = new AdvControlUtil(null);

        private SingleHolder() {
        }
    }

    public static AdvControlUtil getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void initAd() {
        if (TextUtils.equals(BaseApplication.app.getPackageName(), getProcessName(BaseApplication.app))) {
            YFAdsManager.getInstance().init(BaseApplication.app, new YFAdsConfig.YFAdsConfigBuilder(Common.AppKey_FengChuan).setCustomDefine(getCustomValue()).setUserDefine(getUserValue()).builder());
            Common.getLogoValue(BaseApplication.app);
        }
    }

    private Map<String, Object> getCustomValue() {
        HashMap map = new HashMap();
        map.put("C1", LocalDataUtil.getSchoolId(BaseApplication.app));
        return map;
    }

    private Map<String, Object> getUserValue() {
        String str;
        HashMap map = new HashMap();
        int platformInfo = LocalDataUtil.getPlatformInfo(BaseApplication.app);
        if (platformInfo == 4 && V4UserInfoUtil.getInstance().getLoginAccountV4() != null) {
            str = V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId;
        } else {
            str = (platformInfo != 1 || UserInfoUtil.getInstance().getLoginAccountV3() == null) ? ba.r : UserInfoUtil.getInstance().getLoginAccountV3().studentHex;
        }
        LogUtil.e(TAG, "getUserValue:" + str);
        map.put("UserID", str);
        return map;
    }

    private String getProcessName(Context context) {
        if (context == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public void onDestroy(Activity activity) {
        BannerUtil.getInstance().onDestroy();
    }

    public void initAdvInfo() {
        isOpenAdv();
        if (this.mIsNewPlantion) {
            initAdvInfoNew();
        } else {
            initAdvInfoOld();
        }
    }

    private void isOpenAdv() {
        this.mIsOpenSplashAdv = false;
        this.mIsOpenInsertAdv = false;
        this.mIsOpenBannerAdv = false;
        this.mIsOpenNativeAdv = false;
        String advRuleInfo = LocalDataUtil.getAdvRuleInfo(this.mActivity);
        LogUtil.e(TAG, "广告服务商信息：" + advRuleInfo);
        if (StringUtils.isNotEmpty(advRuleInfo)) {
            String[] strArrSplit = advRuleInfo.split(";");
            if (strArrSplit.length >= 4) {
                if (StringUtils.isNotEmpty(strArrSplit[0])) {
                    this.mIsOpenSplashAdv = true;
                }
                if (StringUtils.isNotEmpty(strArrSplit[1])) {
                    this.mIsOpenInsertAdv = true;
                }
                if (StringUtils.isNotEmpty(strArrSplit[2])) {
                    this.mIsOpenBannerAdv = true;
                }
                if (StringUtils.isNotEmpty(strArrSplit[3])) {
                    this.mIsOpenNativeAdv = true;
                }
            }
        }
    }

    public boolean isNeedLoadAdv(Activity activity) {
        if (activity.isTaskRoot()) {
            return true;
        }
        String str = TAG;
        LogUtil.e(str, "isNeedLoadAdv  isTaskRoot");
        Intent intent = activity.getIntent();
        if (intent == null) {
            return true;
        }
        String action = intent.getAction();
        if (!intent.hasCategory("android.intent.category.LAUNCHER") || !"android.intent.action.MAIN".equals(action) || LocalDataUtil.getIsNeedLoadAdv(activity)) {
            return true;
        }
        LogUtil.e(str, "上一次是按下home键关闭，此次直接进入主页面");
        return false;
    }

    private void initAdvInfoOld() {
        String advInsert = LocalBusinessStore.getAdvInsert(this.mActivity, this.mSchoolId);
        int advlaunchCount = LocalBusinessStore.getAdvlaunchCount(this.mActivity, this.mSchoolId, 3);
        String str = TAG;
        LogUtil.e(str, "popinfo:" + advInsert + "  已看次数" + advlaunchCount);
        if (StringUtils.isNotEmpty(advInsert) && this.mIsOpenInsertAdv) {
            String[] strArrSplit = advInsert.split(",");
            if (strArrSplit.length >= 3) {
                int i = Integer.parseInt(strArrSplit[0]);
                this.mPopAdvNumber = Integer.parseInt(strArrSplit[1]);
                LogUtil.e(str, "open:" + i + "总共：" + this.mPopAdvNumber);
                if (i == 1 && this.mPopAdvNumber > advlaunchCount) {
                    LogUtil.e(str, "已开启插屏广告");
                    AdvListener advListener = this.mAdvListener;
                    if (advListener != null) {
                        advListener.isOpen(1, 0, 0, 0, 0);
                    }
                }
            }
        }
        String advBanner = LocalBusinessStore.getAdvBanner(this.mActivity, this.mSchoolId);
        int advlaunchCount2 = LocalBusinessStore.getAdvlaunchCount(this.mActivity, this.mSchoolId, 2);
        LogUtil.e(str, "bannerinfo:" + advBanner + "  已看次数" + advlaunchCount2);
        if (StringUtils.isNotEmpty(advBanner) && this.mIsOpenBannerAdv) {
            String[] strArrSplit2 = advBanner.split(",");
            if (strArrSplit2.length >= 3) {
                int i2 = Integer.parseInt(strArrSplit2[0]);
                this.mBannerAdvNumber = Integer.parseInt(strArrSplit2[1]);
                LogUtil.e(str, "open:" + i2 + "总共：" + this.mPopAdvNumber);
                if (i2 == 1 && this.mBannerAdvNumber > advlaunchCount2) {
                    LogUtil.e(str, "已开启banner广告");
                    AdvListener advListener2 = this.mAdvListener;
                    if (advListener2 != null) {
                        advListener2.isOpen(0, 1, 0, 0, 0);
                    }
                }
            }
        }
        String advlaunch = LocalBusinessStore.getAdvlaunch(this.mActivity, this.mSchoolId);
        int advlaunchCount3 = LocalBusinessStore.getAdvlaunchCount(this.mActivity, this.mSchoolId, 1);
        LogUtil.e(str, "splashinfo:" + advlaunch + "  已看次数" + advlaunchCount3);
        if (!StringUtils.isNotEmpty(advlaunch) || !this.mIsOpenSplashAdv) {
            AdvListener advListener3 = this.mAdvListener;
            if (advListener3 != null) {
                advListener3.isOpen(0, 0, 0, -1, 0);
                return;
            }
            return;
        }
        String[] strArrSplit3 = advlaunch.split(",");
        if (strArrSplit3.length >= 3) {
            int i3 = Integer.parseInt(strArrSplit3[0]);
            this.mSplashAdvNumber = Integer.parseInt(strArrSplit3[1]);
            LogUtil.e(str, "open:" + i3 + "总共：" + this.mSplashAdvNumber);
            if (i3 != 1 || this.mSplashAdvNumber <= advlaunchCount3) {
                AdvListener advListener4 = this.mAdvListener;
                if (advListener4 != null) {
                    advListener4.isOpen(0, 0, 0, -1, 0);
                    return;
                }
                return;
            }
            LogUtil.e(str, "已开启开屏广告");
            AdvListener advListener5 = this.mAdvListener;
            if (advListener5 != null) {
                advListener5.isOpen(0, 0, 0, 1, 0);
            }
        }
    }

    private void initAdvInfoNew() {
        String str;
        boolean z;
        String str2;
        String[] strArr;
        String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
        String investorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        String advInfo = LocalDataUtil.getAdvInfo(this.mActivity, investorId, schoolId, 3);
        int i = 2;
        String advInfo2 = LocalDataUtil.getAdvInfo(this.mActivity, investorId, schoolId, 2);
        char c = 1;
        String advInfo3 = LocalDataUtil.getAdvInfo(this.mActivity, investorId, schoolId, 1);
        String advInfo4 = LocalDataUtil.getAdvInfo(this.mActivity, investorId, schoolId, 6);
        String advTime = LocalDataUtil.getAdvTime(this.mActivity, investorId, schoolId);
        LogUtil.e(TAG, advTime + "  popinfo:" + advInfo + "  banner:" + advInfo2 + " splashinfo:" + advInfo3 + "  nativeinfo:" + advInfo4);
        if (StringUtils.isNotEmpty(advTime)) {
            String[] strArrSplit = advTime.split(";");
            int i2 = 0;
            boolean z2 = false;
            while (i2 < strArrSplit.length) {
                String[] strArrSplit2 = strArrSplit[i2].split(",");
                if (strArrSplit2.length >= i) {
                    int i3 = Integer.parseInt(strArrSplit2[0].split(x.bQ)[0]);
                    strArr = strArrSplit;
                    int i4 = Integer.parseInt(strArrSplit2[0].split(x.bQ)[c]);
                    str2 = advInfo4;
                    int i5 = Integer.parseInt(strArrSplit2[c].split(x.bQ)[0]);
                    int i6 = Integer.parseInt(strArrSplit2[c].split(x.bQ)[c]);
                    LogUtil.e(TAG, i3 + "  " + i4 + "  " + i5 + "  " + i6);
                    if (TimeUtils.isCurrentInTimeScope(i3, i4, i5, i6)) {
                        z2 = true;
                    }
                } else {
                    str2 = advInfo4;
                    strArr = strArrSplit;
                }
                i2++;
                strArrSplit = strArr;
                advInfo4 = str2;
                i = 2;
                c = 1;
            }
            str = advInfo4;
            z = z2;
        } else {
            str = advInfo4;
            z = true;
        }
        String str3 = TAG;
        LogUtil.e(str3, " isOpenTime: " + z);
        if (StringUtils.isNotEmpty(advInfo) && z && this.mIsOpenInsertAdv) {
            int advlaunchCount = LocalDataUtil.getAdvlaunchCount(this.mActivity, 3);
            this.mPopAdvNumber = Integer.parseInt(advInfo.split(",")[0]);
            LogUtil.e(str3, "总共：" + this.mPopAdvNumber + "  已看：" + advlaunchCount);
            AdvListener advListener = this.mAdvListener;
            if (advListener != null) {
                advListener.isOpen(1, 0, 0, 0, 0);
            }
        }
        if (StringUtils.isNotEmpty(advInfo2) && z && this.mIsOpenBannerAdv) {
            int advlaunchCount2 = LocalDataUtil.getAdvlaunchCount(this.mActivity, 2);
            this.mBannerAdvNumber = Integer.parseInt(advInfo2.split(",")[0]);
            LogUtil.e(str3, "banner总共：" + this.mBannerAdvNumber + "  已看：" + advlaunchCount2);
            AdvListener advListener2 = this.mAdvListener;
            if (advListener2 != null) {
                advListener2.isOpen(0, 1, 0, 0, 0);
            }
        }
        String advBannerJumpInfo = LocalDataUtil.getAdvBannerJumpInfo(this.mActivity, investorId, schoolId);
        LogUtil.e(str3, "jumps:" + advBannerJumpInfo + "  " + investorId + "  " + schoolId);
        if (StringUtils.isNotEmpty(advBannerJumpInfo)) {
            String[] strArrSplit3 = advBannerJumpInfo.split(";");
            this.mBannerJumpInfo.clear();
            if (strArrSplit3.length >= 0) {
                for (String str4 : strArrSplit3) {
                    String[] strArrSplit4 = str4.split(",");
                    BannerJumpInfoBean bannerJumpInfoBean = new BannerJumpInfoBean();
                    bannerJumpInfoBean.type = Integer.parseInt(strArrSplit4[0]);
                    BannernfoBean bannernfoBean = new BannernfoBean();
                    bannernfoBean.url = strArrSplit4[1];
                    bannernfoBean.id = strArrSplit4[2];
                    bannernfoBean.appid = strArrSplit4[3];
                    bannernfoBean.pictureUrl = strArrSplit4[4];
                    bannernfoBean.xcxPath = strArrSplit4[5];
                    bannerJumpInfoBean.info = bannernfoBean;
                    this.mBannerJumpInfo.add(bannerJumpInfoBean);
                }
                AdvListener advListener3 = this.mAdvListener;
                if (advListener3 != null) {
                    advListener3.isOpen(0, 0, 1, 0, 0);
                }
            }
        }
        if (StringUtils.isNotEmpty(advInfo3) && z && this.mIsOpenSplashAdv) {
            int advlaunchCount3 = LocalDataUtil.getAdvlaunchCount(this.mActivity, 1);
            this.mSplashAdvNumber = Integer.parseInt(advInfo3.split(",")[0]);
            LogUtil.e(TAG, "开屏总共：" + this.mSplashAdvNumber + "  已看：" + advlaunchCount3);
            AdvListener advListener4 = this.mAdvListener;
            if (advListener4 != null) {
                advListener4.isOpen(0, 0, 0, 1, 0);
            }
        } else {
            AdvListener advListener5 = this.mAdvListener;
            if (advListener5 != null) {
                advListener5.isOpen(0, 0, 0, -1, 0);
            }
        }
        if (StringUtils.isNotEmpty(str) && z && this.mIsOpenNativeAdv) {
            int advlaunchCount4 = LocalDataUtil.getAdvlaunchCount(this.mActivity, 6);
            this.mNativeAdvNumber = Integer.parseInt(str.split(",")[0]);
            LogUtil.e(TAG, "信息流总共：" + this.mNativeAdvNumber + "  已看：" + advlaunchCount4);
            this.mAdvListener.isOpen(0, 0, 0, 0, 1);
        }
    }

    public void requestBanner(FrameLayout frameLayout) {
        BannerUtil.getInstance().initBanner(this.mActivity, this.mAdvListener, this.mIsNewPlantion, this.mSchoolId);
        BannerUtil.getInstance().onBanner(frameLayout);
    }

    public void requestJumpAdv(int i) {
        List<BannerJumpInfoBean> list = this.mBannerJumpInfo;
        if (list == null || list.size() <= i) {
            return;
        }
        if (this.mBannerJumpInfo.get(i).type == 0) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.mBannerJumpInfo.get(i).info.url));
            if (intent.resolveActivity(this.mActivity.getPackageManager()) != null) {
                this.mActivity.startActivity(intent);
                return;
            }
            return;
        }
        if (this.mBannerJumpInfo.get(i).type == 1) {
            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(this.mActivity, this.mBannerJumpInfo.get(i).info.appid);
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = this.mBannerJumpInfo.get(i).info.id;
            if (StringUtils.isNotEmpty(this.mBannerJumpInfo.get(i).info.xcxPath)) {
                req.path = this.mBannerJumpInfo.get(i).info.xcxPath;
            }
            req.miniprogramType = 0;
            iwxapiCreateWXAPI.sendReq(req);
        }
    }

    public int getAdvName(String str) {
        LogUtil.e(TAG, "getAdvName:" + str);
        return 0;
    }
}
