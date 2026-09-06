package client.android.yixiaotong.v3.ui.adv;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.bean.adv.AdvAndroidJsonBean;
import client.android.yixiaotong.v3.bean.adv.AdvBean;
import client.android.yixiaotong.v3.bean.adv.AdvLxtAdvertisingFacilitatorBean;
import client.android.yixiaotong.v3.bean.adv.AdvRulesBean;
import client.android.yixiaotong.v3.bean.adv.AdvServerBean;
import client.android.yixiaotong.v3.bean.adv.AdvxtAdvertisingFacilitatorRulesBean;
import client.android.yixiaotong.v3.bean.adv.BannernfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AdvControl {
    private static final String TAG = "AdvControl";
    private Account mAccount;
    private Activity mActivity;
    private List<AdvServerBean> mAdvServers;
    private List<Common.AdvName> mBannerOrder;
    private List<Common.AdvName> mInsertOrder;
    private boolean mIsEnable;
    private List<Common.AdvName> mNativeOrder;
    private List<Common.AdvName> mSplashOrder;

    public void init(Account account, Activity activity) {
        this.mAccount = account;
        this.mActivity = activity;
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    private AdvControl() {
        this.mIsEnable = true;
        this.mAdvServers = new ArrayList();
        this.mSplashOrder = new ArrayList();
        this.mInsertOrder = new ArrayList();
        this.mBannerOrder = new ArrayList();
        this.mNativeOrder = new ArrayList();
    }

    private static final class SingleHolder {
        public static final AdvControl Instance = new AdvControl();

        private SingleHolder() {
        }
    }

    public static AdvControl getInstance() {
        return SingleHolder.Instance;
    }

    private void initRule() {
        if (this.mSplashOrder == null) {
            this.mSplashOrder = new ArrayList();
        }
        if (this.mInsertOrder == null) {
            this.mInsertOrder = new ArrayList();
        }
        if (this.mBannerOrder == null) {
            this.mBannerOrder = new ArrayList();
        }
        if (this.mNativeOrder == null) {
            this.mNativeOrder = new ArrayList();
        }
        this.mAdvServers.clear();
        this.mSplashOrder.clear();
        this.mInsertOrder.clear();
        this.mNativeOrder.clear();
        this.mBannerOrder.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRultResult() {
        LogUtil.e(TAG, "setRultResult:start");
        if (this.mAdvServers.size() > 0) {
            if (this.mSplashOrder.size() == 0) {
                LogUtil.e(TAG, "后台未配置开屏播放顺序");
                for (int i = 0; i < this.mAdvServers.size(); i++) {
                    LogUtil.e(TAG, "后台未配置开屏播放顺序" + this.mAdvServers.get(i).name);
                    if (this.mAdvServers.get(i).name.equals(Common.AdvName.chuangzhi + "")) {
                        this.mSplashOrder.add(Common.AdvName.chuangzhi);
                    }
                }
            }
            if (this.mInsertOrder.size() == 0) {
                LogUtil.e(TAG, "后台未配置插屏播放顺序");
                for (int i2 = 0; i2 < this.mAdvServers.size(); i2++) {
                    LogUtil.e(TAG, "后台未配置插屏播放顺序" + this.mAdvServers.get(i2).name);
                    if (this.mAdvServers.get(i2).name.equals(Common.AdvName.chuangzhi + "")) {
                        this.mInsertOrder.add(Common.AdvName.chuangzhi);
                    }
                }
            }
            if (this.mBannerOrder.size() == 0) {
                LogUtil.e(TAG, "后台未配置banner播放顺序");
                for (int i3 = 0; i3 < this.mAdvServers.size(); i3++) {
                    LogUtil.e(TAG, "后台未配置banner播放顺序" + this.mAdvServers.get(i3).name);
                }
            }
            if (this.mNativeOrder.size() == 0) {
                LogUtil.e(TAG, "后台未配置信息流播放顺序");
                for (int i4 = 0; i4 < this.mAdvServers.size(); i4++) {
                    LogUtil.e(TAG, "后台未配置信息流播放顺序" + this.mAdvServers.get(i4).name);
                    if (this.mAdvServers.get(i4).name.equals(Common.AdvName.chuangzhi + "")) {
                        this.mNativeOrder.add(Common.AdvName.chuangzhi);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            if (this.mSplashOrder.size() == 0) {
                sb.append("null;");
            } else {
                for (int i5 = 0; i5 < this.mSplashOrder.size(); i5++) {
                    if (i5 != this.mSplashOrder.size() - 1) {
                        sb.append(this.mSplashOrder.get(i5) + ",");
                    } else {
                        sb.append(this.mSplashOrder.get(i5) + ";");
                    }
                }
            }
            if (this.mInsertOrder.size() == 0) {
                sb.append("null;");
            } else {
                for (int i6 = 0; i6 < this.mInsertOrder.size(); i6++) {
                    if (i6 != this.mInsertOrder.size() - 1) {
                        sb.append(this.mInsertOrder.get(i6) + ",");
                    } else {
                        sb.append(this.mInsertOrder.get(i6) + ";");
                    }
                }
            }
            if (this.mBannerOrder.size() == 0) {
                sb.append("null;");
            } else {
                for (int i7 = 0; i7 < this.mBannerOrder.size(); i7++) {
                    if (i7 != this.mBannerOrder.size() - 1) {
                        sb.append(this.mBannerOrder.get(i7) + ",");
                    } else {
                        sb.append(this.mBannerOrder.get(i7) + ";");
                    }
                }
            }
            if (this.mNativeOrder.size() == 0) {
                sb.append("null;");
            } else {
                for (int i8 = 0; i8 < this.mNativeOrder.size(); i8++) {
                    if (i8 != this.mNativeOrder.size() - 1) {
                        sb.append(this.mNativeOrder.get(i8) + ",");
                    } else {
                        sb.append(this.mNativeOrder.get(i8) + ";");
                    }
                }
            }
            LogUtil.e(TAG, "setRultResult:" + sb.toString());
            LocalDataUtil.saveAdvRuleInfo(this.mActivity, sb.toString());
        }
    }

    public void getAdvRules() {
        initRule();
        V3BusinessControllers.getInstance().findAdvertisingFacilitatorRules(this.mAccount, new Listener<AdvRulesBean>() { // from class: client.android.yixiaotong.v3.ui.adv.AdvControl.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AdvRulesBean advRulesBean, Object... objArr) {
                if (AdvControl.this.mIsEnable) {
                    LocalDataUtil.saveAdvRuleInfo(AdvControl.this.mActivity, "");
                    if (advRulesBean.lxtAdvertisingFacilitator == null || advRulesBean.lxtAdvertisingFacilitator.size() <= 0) {
                        return;
                    }
                    for (int i = 0; i < advRulesBean.lxtAdvertisingFacilitator.size(); i++) {
                        AdvLxtAdvertisingFacilitatorBean advLxtAdvertisingFacilitatorBean = advRulesBean.lxtAdvertisingFacilitator.get(i);
                        if (advLxtAdvertisingFacilitatorBean.status == 0 && StringUtils.isNotEmpty(advLxtAdvertisingFacilitatorBean.androidJson)) {
                            try {
                                AdvAndroidJsonBean advAndroidJsonBean = (AdvAndroidJsonBean) GsonUtils.getInstance().parse(AdvAndroidJsonBean.class, advLxtAdvertisingFacilitatorBean.androidJson);
                                if (advAndroidJsonBean != null && StringUtils.isNotEmpty(advAndroidJsonBean.ymMediaid) && advAndroidJsonBean.ymMediaid.equalsIgnoreCase(Common.AppKey_FengChuan)) {
                                    LogUtil.e(AdvControl.TAG, "广告开启  添加风船广告");
                                    AdvServerBean advServerBean = new AdvServerBean();
                                    advServerBean.id = advLxtAdvertisingFacilitatorBean.id;
                                    advServerBean.name = Common.AdvName.chuangzhi + "";
                                    AdvControl.this.mAdvServers.add(advServerBean);
                                }
                            } catch (ClientException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (AdvControl.this.mAdvServers.size() > 0 && advRulesBean.lxtAdvertisingFacilitatorRules != null) {
                        AdvControl.this.setAdvOrder(1, advRulesBean.lxtAdvertisingFacilitatorRules);
                        AdvControl.this.setAdvOrder(2, advRulesBean.lxtAdvertisingFacilitatorRules);
                        AdvControl.this.setAdvOrder(3, advRulesBean.lxtAdvertisingFacilitatorRules);
                        AdvControl.this.setAdvOrder(4, advRulesBean.lxtAdvertisingFacilitatorRules);
                    }
                    AdvControl.this.setRultResult();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                boolean unused = AdvControl.this.mIsEnable;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdvOrder(int i, AdvxtAdvertisingFacilitatorRulesBean advxtAdvertisingFacilitatorRulesBean) {
        String str;
        LogUtil.e(TAG, "广告服务商开启数量:" + this.mAdvServers.size() + PPSLabelView.Code + i);
        if (i == 1) {
            str = advxtAdvertisingFacilitatorRulesBean.startscreenJson;
        } else if (i == 2) {
            str = advxtAdvertisingFacilitatorRulesBean.popupJson;
        } else if (i == 3) {
            str = advxtAdvertisingFacilitatorRulesBean.bannerJson;
        } else {
            str = i == 4 ? advxtAdvertisingFacilitatorRulesBean.informationFlowJson : "";
        }
        List string2List = GsonUtils.getInstance().parseString2List(str, String.class);
        if (string2List == null || string2List.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < string2List.size(); i2++) {
            String str2 = (String) string2List.get(i2);
            for (int i3 = 0; i3 < this.mAdvServers.size(); i3++) {
                LogUtil.e(TAG, this.mAdvServers.get(i3).name + this.mAdvServers.get(i3).id);
                if (this.mAdvServers.get(i3).id.equals(str2) && this.mAdvServers.get(i3).name.equals(Common.AdvName.chuangzhi + "")) {
                    if (i == 1) {
                        this.mSplashOrder.add(Common.AdvName.chuangzhi);
                    } else if (i == 2) {
                        this.mInsertOrder.add(Common.AdvName.chuangzhi);
                    } else if (i == 3) {
                        this.mBannerOrder.add(Common.AdvName.chuangzhi);
                    } else if (i == 4) {
                        this.mNativeOrder.add(Common.AdvName.chuangzhi);
                    }
                }
            }
        }
    }

    public void getAdvertising() {
        final String investorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        final String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
        if (StringUtils.isEmpty(investorId) || StringUtils.isEmpty(schoolId)) {
            return;
        }
        V3BusinessControllers.getInstance().getAdvertising(this.mAccount, schoolId, investorId, new Listener<AdvBean>() { // from class: client.android.yixiaotong.v3.ui.adv.AdvControl.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                boolean unused = AdvControl.this.mIsEnable;
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AdvBean advBean, Object... objArr) {
                if (!AdvControl.this.mIsEnable || advBean == null) {
                    return;
                }
                if (investorId.equals(advBean.investorId) && schoolId.equals(advBean.schoolId)) {
                    if (advBean.state == 0) {
                        LocalDataUtil.saveAdvTime(AdvControl.this.mActivity, investorId, schoolId, "");
                        if (advBean.controlTime != null && advBean.controlTime.size() > 0) {
                            String str = "";
                            for (int i = 0; i < advBean.controlTime.size(); i++) {
                                str = str + advBean.controlTime.get(i).startTime + "," + advBean.controlTime.get(i).endTime + ";";
                            }
                            LocalDataUtil.saveAdvTime(AdvControl.this.mActivity, investorId, schoolId, str.substring(0, str.length() - 1));
                        }
                        if (advBean.startscreen == 0) {
                            LocalDataUtil.saveAdvInfo(AdvControl.this.mActivity, investorId, schoolId, 1, advBean.startscreenNumber + "");
                        } else {
                            LocalDataUtil.saveAdvInfo(AdvControl.this.mActivity, investorId, schoolId, 1, "");
                        }
                        if (advBean.banner != 0) {
                            LocalDataUtil.saveAdvInfo(AdvControl.this.mActivity, investorId, schoolId, 2, "");
                            LocalDataUtil.saveAdvBannerJumpInfo(AdvControl.this.mActivity, investorId, schoolId, "");
                        } else {
                            String str2 = advBean.bannerNumber + "";
                            LogUtil.e(AdvControl.TAG, "bannerinfo:" + str2);
                            LocalDataUtil.saveAdvInfo(AdvControl.this.mActivity, investorId, schoolId, 2, str2);
                            LogUtil.e(AdvControl.TAG, "jumps:" + (advBean.bannerJumpInfo != null) + "  " + advBean.bannerJumpInfo.size());
                            if (advBean.bannerJump != 0 || advBean.bannerJumpInfo == null || advBean.bannerJumpInfo.size() <= 0) {
                                LocalDataUtil.saveAdvBannerJumpInfo(AdvControl.this.mActivity, investorId, schoolId, "");
                            } else {
                                String str3 = "";
                                for (int i2 = 0; i2 < advBean.bannerJumpInfo.size(); i2++) {
                                    BannernfoBean bannernfoBean = advBean.bannerJumpInfo.get(i2).info;
                                    str3 = str3 + advBean.bannerJumpInfo.get(i2).type + "," + (StringUtils.isNotEmpty(bannernfoBean.url) ? bannernfoBean.url : "null") + "," + (StringUtils.isNotEmpty(bannernfoBean.id) ? bannernfoBean.id : "null") + "," + (StringUtils.isNotEmpty(bannernfoBean.appid) ? bannernfoBean.appid : "null") + "," + (StringUtils.isNotEmpty(bannernfoBean.pictureUrl) ? bannernfoBean.pictureUrl : "null") + "," + (StringUtils.isNotEmpty(bannernfoBean.xcxPath) ? bannernfoBean.xcxPath : "null");
                                    if (i2 < advBean.bannerJumpInfo.size() - 1) {
                                        str3 = str3 + ";";
                                    }
                                }
                                LogUtil.e(AdvControl.TAG, "bannerjump:" + str3 + "  " + investorId + "  " + schoolId);
                                LocalDataUtil.saveAdvBannerJumpInfo(AdvControl.this.mActivity, investorId, schoolId, str3);
                            }
                        }
                        if (advBean.popup != 0) {
                            LocalDataUtil.saveAdvInfo(AdvControl.this.mActivity, investorId, schoolId, 3, "");
                        } else {
                            String str4 = advBean.popupNumber + "";
                            LogUtil.e(AdvControl.TAG, "popupinfo:" + str4);
                            LocalDataUtil.saveAdvInfo(AdvControl.this.mActivity, investorId, schoolId, 3, str4);
                        }
                        if (advBean.informationFlow == 0) {
                            LocalDataUtil.saveAdvInfo(AdvControl.this.mActivity, investorId, schoolId, 6, advBean.informationFlowNumber + "");
                        } else {
                            LocalDataUtil.saveAdvInfo(AdvControl.this.mActivity, investorId, schoolId, 6, "");
                        }
                    } else {
                        LocalDataUtil.saveAdvInfo(AdvControl.this.mActivity, investorId, schoolId, 1, "");
                        LocalDataUtil.saveAdvInfo(AdvControl.this.mActivity, investorId, schoolId, 2, "");
                        LocalDataUtil.saveAdvInfo(AdvControl.this.mActivity, investorId, schoolId, 3, "");
                        LocalDataUtil.saveAdvBannerJumpInfo(AdvControl.this.mActivity, investorId, schoolId, "");
                        LocalDataUtil.saveAdvInfo(AdvControl.this.mActivity, investorId, schoolId, 6, "");
                    }
                }
                LocalBusinessStore.saveIsOpenAdv(AdvControl.this.mActivity, true);
            }
        });
    }
}
