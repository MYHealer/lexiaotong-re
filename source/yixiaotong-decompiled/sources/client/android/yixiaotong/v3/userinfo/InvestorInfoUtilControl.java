package client.android.yixiaotong.v3.userinfo;

import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.v3.bean.login.BaseInfoBean;
import client.android.yixiaotong.v3.bean.login.CreditAmountRuleBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.bean.login.JumpApp;
import client.android.yixiaotong.v3.bean.login.JumpAppBean;
import client.android.yixiaotong.v3.bean.login.OperationTime;
import client.android.yixiaotong.v3.bean.login.OperationTimeJsonBean;
import client.android.yixiaotong.v3.bean.login.OperationTimeListBean;
import client.android.yixiaotong.v3.bean.login.PayPaymentBean;
import client.android.yixiaotong.v3.bean.login.PlanInfoBean;
import client.android.yixiaotong.v3.bean.login.PlanJsonBean;
import client.android.yixiaotong.v3.bean.login.RechargeGiftProgram;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoExtendJsonBean;
import client.android.yixiaotong.v3.bean.login.UseSoftwareProductBean;
import client.android.yixiaotong.v3.bean.login.UseToolsJsonBean;
import client.android.yixiaotong.v3.bean.login.ZlPaymentJson;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class InvestorInfoUtilControl {
    public static final int PLANFLAG_DEPOSIT = 2;
    public static final int PLANFLAG_WALLET = 1;
    private static final String TAG = "InvestorInfoUtilControl";
    private String mInvestorId;
    private InvestorInfoBean mInvestorInfoBean;
    private List<PlanInfoBean> mPlanInfoBeans;

    /* JADX INFO: renamed from: client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public void setInvestorId() {
        this.mInvestorId = "";
        this.mInvestorInfoBean = null;
        this.mPlanInfoBeans = null;
    }

    /* synthetic */ InvestorInfoUtilControl(AnonymousClass1 anonymousClass1) {
        this();
    }

    private static class SingletonHolder {
        public static final InvestorInfoUtilControl INSTANCE = new InvestorInfoUtilControl(null);

        private SingletonHolder() {
        }
    }

    public static InvestorInfoUtilControl getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private InvestorInfoUtilControl() {
    }

    public InvestorInfoBean getInvestorInfoBean() {
        InvestorInfoBean investorInfoBean = this.mInvestorInfoBean;
        if (investorInfoBean != null) {
            return investorInfoBean;
        }
        int investorInfosIndex = InvestorInfoUtil.getInstance().getInvestorInfosIndex();
        LogUtil.e(TAG, "getInvestorInfoBean:" + investorInfosIndex);
        List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
        if (investorInfosV3 == null || investorInfosV3.size() <= investorInfosIndex) {
            return null;
        }
        InvestorInfoBean investorInfoBean2 = investorInfosV3.get(investorInfosIndex).investorInfo;
        this.mInvestorInfoBean = investorInfoBean2;
        return investorInfoBean2;
    }

    public String getInvestorId() {
        if (StringUtils.isNotEmpty(this.mInvestorId)) {
            LogUtil.e(TAG, "getInvestorId:" + this.mInvestorId);
            return this.mInvestorId;
        }
        InvestorInfoBean investorInfoBean = getInvestorInfoBean();
        String str = investorInfoBean != null ? investorInfoBean.investorId : "";
        this.mInvestorId = str;
        LogUtil.e(TAG, "getInvestorId:" + this.mInvestorId + PPSLabelView.Code + str);
        return str;
    }

    public List<PlanInfoBean> getPlanInfo() {
        List<PlanInfoBean> list = this.mPlanInfoBeans;
        if (list != null) {
            return list;
        }
        InvestorInfoBean investorInfoBean = getInvestorInfoBean();
        if (investorInfoBean == null) {
            return null;
        }
        this.mPlanInfoBeans = investorInfoBean.planInfo;
        return investorInfoBean.planInfo;
    }

    public List<JumpAppBean> getJumpApp() {
        List<JumpAppBean> list;
        ArrayList arrayList = new ArrayList();
        InvestorInfoBean investorInfoBean = getInvestorInfoBean();
        if (investorInfoBean == null || (list = investorInfoBean.jumpApp) == null) {
            return arrayList;
        }
        for (JumpAppBean jumpAppBean : list) {
            if (jumpAppBean != null && jumpAppBean.jumpApp != null) {
                for (JumpApp jumpApp : jumpAppBean.jumpApp) {
                    if (jumpApp != null) {
                        if (jumpApp.jumpType == 0 && StringUtils.isNotEmpty(jumpApp.webUrl)) {
                            JumpAppBean jumpAppBean2 = new JumpAppBean();
                            jumpAppBean2.icon = jumpAppBean.icon;
                            jumpAppBean2.name = jumpAppBean.name;
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(jumpApp);
                            jumpAppBean2.jumpApp = arrayList2;
                            arrayList.add(jumpAppBean2);
                            break;
                        }
                        if (jumpApp.jumpType == 1 && StringUtils.isNotEmpty(jumpApp.extData)) {
                            JumpAppBean jumpAppBean3 = new JumpAppBean();
                            jumpAppBean3.icon = jumpAppBean.icon;
                            jumpAppBean3.name = jumpAppBean.name;
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(jumpApp);
                            jumpAppBean3.jumpApp = arrayList3;
                            arrayList.add(jumpAppBean3);
                            break;
                        }
                        if (jumpApp.jumpType == 2 && StringUtils.isNotEmpty(jumpApp.appId) && StringUtils.isNotEmpty(jumpApp.path)) {
                            JumpAppBean jumpAppBean4 = new JumpAppBean();
                            jumpAppBean4.icon = jumpAppBean.icon;
                            jumpAppBean4.name = jumpAppBean.name;
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(jumpApp);
                            jumpAppBean4.jumpApp = arrayList4;
                            arrayList.add(jumpAppBean4);
                            break;
                        }
                        if (jumpApp.jumpType == 3 && StringUtils.isNotEmpty(jumpApp.appId) && StringUtils.isNotEmpty(jumpApp.extData)) {
                            JumpAppBean jumpAppBean5 = new JumpAppBean();
                            jumpAppBean5.icon = jumpAppBean.icon;
                            jumpAppBean5.name = jumpAppBean.name;
                            ArrayList arrayList5 = new ArrayList();
                            arrayList5.add(jumpApp);
                            jumpAppBean5.jumpApp = arrayList5;
                            arrayList.add(jumpAppBean5);
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean isVisableBindCard() {
        List<JumpAppBean> list;
        InvestorInfoBean investorInfoBean = getInvestorInfoBean();
        if (investorInfoBean == null || (list = investorInfoBean.jumpApp) == null || list.size() <= 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).jumpApp != null && list.get(i).jumpApp.size() > 0) {
                List<JumpApp> list2 = list.get(i).jumpApp;
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    if (list2.get(i2).jumpType == 5) {
                        z = true;
                        break;
                    }
                }
            }
        }
        return z;
    }

    public BaseInfoBean getBaseInfo(int i) {
        List<PlanInfoBean> planInfo = getPlanInfo();
        if (planInfo == null || planInfo.size() <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < planInfo.size(); i2++) {
            if (planInfo.get(i2).base.planFlag == i) {
                return planInfo.get(i2).base;
            }
        }
        return null;
    }

    public boolean isEnablePlanFlag(int i) {
        List<PlanInfoBean> planInfo = getPlanInfo();
        if (planInfo != null && planInfo.size() > 0) {
            for (int i2 = 0; i2 < planInfo.size(); i2++) {
                BaseInfoBean baseInfoBean = planInfo.get(i2).base;
                if (baseInfoBean != null && baseInfoBean.planFlag == i && baseInfoBean.statusFlag == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<PlanJsonBean> getPlanJson() {
        List<PlanInfoBean> planInfo = getPlanInfo();
        ArrayList arrayList = new ArrayList();
        if (planInfo != null && planInfo.size() > 0) {
            for (int i = 0; i < planInfo.size(); i++) {
                PlanInfoBean planInfoBean = planInfo.get(i);
                if (planInfoBean != null && planInfoBean.planJson != null) {
                    arrayList.add(planInfoBean.planJson);
                }
            }
        }
        return arrayList;
    }

    public int getCloudsaleSign() {
        List<PlanJsonBean> planJson = getPlanJson();
        int i = 2;
        if (planJson.size() > 0) {
            for (PlanJsonBean planJsonBean : planJson) {
                if (planJsonBean.cloudsaleSign == 1) {
                    i = 1;
                } else if (planJsonBean.cloudsaleSign == 3 && i != 1) {
                    i = 3;
                }
            }
        }
        return i;
    }

    public PlanJsonBean getPlanJson(int i) {
        List<PlanInfoBean> planInfo = getPlanInfo();
        if (planInfo == null || planInfo.size() <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < planInfo.size(); i2++) {
            if (planInfo.get(i2).base.planFlag == i) {
                return planInfo.get(i2).planJson;
            }
        }
        return null;
    }

    public List<Integer> getPayFlagTypeList(int i) {
        PlanJsonBean planJson = getPlanJson(i);
        if (planJson == null) {
            return null;
        }
        return planJson.payFlagTypeList;
    }

    public RechargeGiftProgram getRechargeGiftProgram(int i, String str) {
        List<PlanInfoBean> planInfo = getPlanInfo();
        RechargeGiftProgram rechargeGiftProgram = null;
        if (planInfo != null && planInfo.size() > 0) {
            for (int i2 = 0; i2 < planInfo.size(); i2++) {
                if (planInfo.get(i2).base.planFlag == i) {
                    new ArrayList();
                    List<RechargeGiftProgram> list = planInfo.get(i2).rechargeGiftProgram;
                    if (list != null && list.size() > 0) {
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            if (StringUtils.isEmpty(list.get(i3).businesKey) && StringUtils.isNotEmpty(list.get(i3).giftType) && list.get(i3).giftType.equals(str)) {
                                rechargeGiftProgram = list.get(i3);
                            }
                        }
                    }
                    return rechargeGiftProgram;
                }
            }
        }
        return null;
    }

    public RechargeGiftProgram getRechargeGiftProgram(List<RechargeGiftProgram> list) {
        RechargeGiftProgram rechargeGiftProgram = null;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (StringUtils.isEmpty(list.get(i).businesKey) && StringUtils.isNotEmpty(list.get(i).giftType) && list.get(i).giftType.equals("1")) {
                    rechargeGiftProgram = list.get(i);
                }
            }
        }
        return rechargeGiftProgram;
    }

    public RechargeGiftProgram getBindRechargeGiftProgram() {
        List<PlanInfoBean> planInfo = getPlanInfo();
        RechargeGiftProgram rechargeGiftProgram = null;
        if (planInfo != null && planInfo.size() > 0 && planInfo.size() > 0) {
            new ArrayList();
            List<RechargeGiftProgram> list = planInfo.get(0).rechargeGiftProgram;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (StringUtils.isNotEmpty(list.get(i).giftType) && list.get(i).giftType.equals("2")) {
                        rechargeGiftProgram = list.get(i);
                    }
                }
            }
        }
        return rechargeGiftProgram;
    }

    public List<TypeInfoBean> getTypeInfoBeans() {
        List<TypeInfoBean> list;
        ArrayList arrayList = new ArrayList();
        List<PlanInfoBean> planInfo = getPlanInfo();
        if (planInfo != null && planInfo.size() > 0) {
            for (int i = 0; i < planInfo.size(); i++) {
                PlanInfoBean planInfoBean = planInfo.get(i);
                if (planInfoBean != null && (list = planInfoBean.typeInfo) != null && list.size() > 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        arrayList.add(list.get(i2));
                    }
                }
            }
        }
        return arrayList;
    }

    public int getPlanFlag(int i) {
        List<PlanInfoBean> planInfo = getPlanInfo();
        if (planInfo != null && planInfo.size() > 0) {
            for (int i2 = 0; i2 < planInfo.size(); i2++) {
                if (planInfo.get(i2) != null && planInfo.get(i2).typeInfo != null && planInfo.get(i2).typeInfo.size() > 0) {
                    for (int i3 = 0; i3 < planInfo.get(i2).typeInfo.size(); i3++) {
                        if (planInfo.get(i2).typeInfo.get(i3).base.typeId == i) {
                            return planInfo.get(i2).base.planFlag;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public PlanInfoBean getPlanInfoBean(int i) {
        List<PlanInfoBean> planInfo = getPlanInfo();
        if (planInfo == null || planInfo.size() <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < planInfo.size(); i2++) {
            if (planInfo.get(i2) != null && planInfo.get(i2).typeInfo != null && planInfo.get(i2).typeInfo.size() > 0) {
                for (int i3 = 0; i3 < planInfo.get(i2).typeInfo.size(); i3++) {
                    if (planInfo.get(i2).typeInfo.get(i3).base.typeId == i) {
                        return planInfo.get(i2);
                    }
                }
            }
        }
        return null;
    }

    public int getPayPaymentFlag(int i) {
        int planFlag = getPlanFlag(i);
        if (planFlag == 1) {
            return 0;
        }
        if (planFlag == 2) {
            return 1;
        }
        return planFlag;
    }

    public List<Integer> getPlanFlagList() {
        ArrayList arrayList = new ArrayList();
        List<PlanInfoBean> planInfo = getPlanInfo();
        if (planInfo != null && planInfo.size() > 0) {
            for (int i = 0; i < planInfo.size(); i++) {
                if (planInfo.get(i) != null && planInfo.get(i).typeInfo != null && planInfo.get(i).typeInfo.size() > 0) {
                    for (int i2 = 0; i2 < planInfo.get(i).typeInfo.size(); i2++) {
                        arrayList.add(Integer.valueOf(planInfo.get(i).base.planFlag));
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean isUse() {
        List<Integer> list;
        List<PlanInfoBean> planInfo = getPlanInfo();
        if (planInfo != null && planInfo.size() > 0) {
            for (int i = 0; i < planInfo.size(); i++) {
                PlanInfoBean planInfoBean = planInfo.get(i);
                if (planInfoBean != null && planInfoBean.planJson != null && (list = planInfoBean.planJson.softwareProduct) != null) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        if (list.get(i2).intValue() == 1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public UseSoftwareProductBean isUseAndroid() {
        UseSoftwareProductBean useSoftwareProductBean = new UseSoftwareProductBean();
        useSoftwareProductBean.isUse = false;
        List<PlanInfoBean> planInfo = getPlanInfo();
        if (planInfo != null && planInfo.size() > 0) {
            for (int i = 0; i < planInfo.size(); i++) {
                PlanInfoBean planInfoBean = planInfo.get(i);
                if (planInfoBean != null && planInfoBean.planJson != null) {
                    List<Integer> list = planInfoBean.planJson.softwareProduct;
                    if (list != null && list.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("系统安全升级维护中，请使用");
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            if (list.get(i2).intValue() == 1) {
                                useSoftwareProductBean.isUse = true;
                            } else if (list.get(i2).intValue() == 2) {
                                sb.append("【乐校通】APP（苹果） 或");
                            } else if (list.get(i2).intValue() == 3) {
                                sb.append("【乐校通】支付宝小程序 或");
                            } else if (list.get(i2).intValue() == 4) {
                                sb.append("【乐校通】微信小程序 或");
                            } else if (list.get(i2).intValue() == 5) {
                                sb.append("【易校园】APP 或");
                            }
                        }
                        if (sb.toString().endsWith("或")) {
                            sb.delete(sb.length() - 2, sb.length());
                        } else if (sb.toString().endsWith("请使用")) {
                            sb.delete(sb.length() - 4, sb.length());
                        }
                        sb.append("，由此给大家造成的不便，敬请谅解！");
                        if (useSoftwareProductBean.isUse) {
                            useSoftwareProductBean.msg = null;
                        } else {
                            useSoftwareProductBean.msg = sb.toString();
                        }
                    } else {
                        useSoftwareProductBean.msg = "系统安全升级维护中，由此给大家造成的不便，敬请谅解！";
                    }
                }
            }
        }
        return useSoftwareProductBean;
    }

    public boolean isUse(int i) {
        List<Integer> list;
        PlanInfoBean planInfoBean = getPlanInfoBean(i);
        if (planInfoBean != null && planInfoBean.planJson != null && (list = planInfoBean.planJson.softwareProduct) != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                LogUtil.e(TAG, "isUse:" + i2 + "  " + list.get(i2));
                if (list.get(i2).intValue() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public UseSoftwareProductBean isUseAndroid(int i) {
        UseSoftwareProductBean useSoftwareProductBean = new UseSoftwareProductBean();
        useSoftwareProductBean.isUse = false;
        PlanInfoBean planInfoBean = getPlanInfoBean(i);
        if (planInfoBean != null && planInfoBean.planJson != null) {
            List<Integer> list = planInfoBean.planJson.softwareProduct;
            if (list != null && list.size() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("系统安全升级维护中，请使用");
                for (int i2 = 0; i2 < list.size(); i2++) {
                    LogUtil.e(TAG, "isUse:" + i2 + "  " + list.get(i2));
                    if (list.get(i2).intValue() == 1) {
                        useSoftwareProductBean.isUse = true;
                    } else if (list.get(i2).intValue() == 2) {
                        sb.append("【乐校通】APP（苹果） 或");
                    } else if (list.get(i2).intValue() == 3) {
                        sb.append("【乐校通】支付宝小程序 或");
                    } else if (list.get(i2).intValue() == 4) {
                        sb.append("【乐校通】微信小程序 或");
                    } else if (list.get(i2).intValue() == 5) {
                        sb.append("【易校园】APP 或");
                    }
                }
                if (sb.toString().endsWith("或")) {
                    sb.delete(sb.length() - 2, sb.length());
                } else if (sb.toString().endsWith("请使用")) {
                    sb.delete(sb.length() - 4, sb.length());
                }
                sb.append("，由此给大家造成的不便，敬请谅解！");
                if (useSoftwareProductBean.isUse) {
                    useSoftwareProductBean.msg = null;
                } else {
                    useSoftwareProductBean.msg = sb.toString();
                }
            } else {
                useSoftwareProductBean.msg = "系统安全升级维护中，由此给大家造成的不便，敬请谅解！";
            }
        }
        return useSoftwareProductBean;
    }

    public List<TypeInfoBean> getTypeInfoBeans(int i) {
        List<PlanInfoBean> planInfo = getPlanInfo();
        if (planInfo == null || planInfo.size() <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < planInfo.size(); i2++) {
            if (planInfo.get(i2).base.planFlag == i) {
                return planInfo.get(i2).typeInfo;
            }
        }
        return null;
    }

    public TypeInfoBean getTypeInfoBean(int i, int i2) {
        List<TypeInfoBean> typeInfoBeans = getTypeInfoBeans(i);
        if (typeInfoBeans == null || typeInfoBeans.size() <= 0) {
            return null;
        }
        for (int i3 = 0; i3 < typeInfoBeans.size(); i3++) {
            if (typeInfoBeans.get(i3).base != null && i2 == typeInfoBeans.get(i3).base.typeId) {
                return typeInfoBeans.get(i3);
            }
        }
        return null;
    }

    public ZlPaymentJson getZlPaymentJson(int i) {
        List<TypeInfoBean> typeInfoBeans;
        int planFlag = getPlanFlag(i);
        if (planFlag == 0 || (typeInfoBeans = getTypeInfoBeans(planFlag)) == null || typeInfoBeans.size() <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < typeInfoBeans.size(); i2++) {
            if (i == typeInfoBeans.get(i2).base.typeId) {
                return typeInfoBeans.get(i2).zlPaymentJson;
            }
        }
        return null;
    }

    public boolean isYuLinYKT(int i) {
        List<PayPaymentBean> list;
        ZlPaymentJson zlPaymentJson = getZlPaymentJson(i);
        if (zlPaymentJson != null && (list = zlPaymentJson.payPaymentList) != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                LogUtil.e(TAG, "getYuLinYKT:" + list.get(i2).payFlag + "  " + list.get(i2).payFlagType);
                if (list.get(i2).payFlag == 1 && list.get(i2).payFlagType == 21) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isContainWxAndAliPay(int i) {
        List<PayPaymentBean> list;
        ZlPaymentJson zlPaymentJson = getZlPaymentJson(i);
        if (zlPaymentJson != null && (list = zlPaymentJson.payPaymentList) != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                LogUtil.e(TAG, "isContainWxAndAliPay:" + list.get(i2).payFlag + "  " + list.get(i2).payFlagType);
                if (list.get(i2).payFlag == 1 && (list.get(i2).payFlagType == 1 || list.get(i2).payFlagType == 2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public TypeInfoExtendJsonBean getTypeInfoExtendJson(int i) {
        List<TypeInfoBean> typeInfoBeans;
        int planFlag = getPlanFlag(i);
        if (planFlag == 0 || (typeInfoBeans = getTypeInfoBeans(planFlag)) == null || typeInfoBeans.size() <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < typeInfoBeans.size(); i2++) {
            if (i == typeInfoBeans.get(i2).base.typeId) {
                return typeInfoBeans.get(i2).extendJson;
            }
        }
        return null;
    }

    public OperationTimeJsonBean getOperationTimeJson(int i) {
        List<TypeInfoBean> typeInfoBeans;
        int planFlag = getPlanFlag(i);
        if (planFlag == 0 || (typeInfoBeans = getTypeInfoBeans(planFlag)) == null || typeInfoBeans.size() <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < typeInfoBeans.size(); i2++) {
            if (i == typeInfoBeans.get(i2).base.typeId) {
                return typeInfoBeans.get(i2).operationTimeJson;
            }
        }
        return null;
    }

    public OperationTimeJsonBean getOperationTimeJson(int i, int i2) {
        List<TypeInfoBean> typeInfoBeans;
        if (i2 == 0 || (typeInfoBeans = getTypeInfoBeans(i2)) == null || typeInfoBeans.size() <= 0) {
            return null;
        }
        for (int i3 = 0; i3 < typeInfoBeans.size(); i3++) {
            if (i == typeInfoBeans.get(i3).base.typeId) {
                return typeInfoBeans.get(i3).operationTimeJson;
            }
        }
        return null;
    }

    public OperationTime isOpenTime(int i, int i2) {
        List<TypeInfoBean> typeInfoBeans;
        OperationTime operationTime = new OperationTime();
        operationTime.isOpen = false;
        String str = "";
        operationTime.openTime = "";
        OperationTimeJsonBean operationTimeJsonBean = null;
        if (i2 != 0 && (typeInfoBeans = getTypeInfoBeans(i2)) != null && typeInfoBeans.size() > 0) {
            for (int i3 = 0; i3 < typeInfoBeans.size(); i3++) {
                if (i == typeInfoBeans.get(i3).base.typeId) {
                    operationTimeJsonBean = typeInfoBeans.get(i3).operationTimeJson;
                }
            }
        }
        if (operationTimeJsonBean != null && operationTimeJsonBean.operationFlag == 2) {
            List<OperationTimeListBean> list = operationTimeJsonBean.operationTimeList;
            if (list != null && list.size() > 0) {
                for (int i4 = 0; i4 < list.size(); i4++) {
                    str = str + list.get(i4).startTime + "至" + list.get(i4).stopTime + "时\n";
                    int i5 = Integer.parseInt(list.get(i4).startTime.split(x.bQ)[0]);
                    int i6 = Integer.parseInt(list.get(i4).startTime.split(x.bQ)[1]);
                    int i7 = Integer.parseInt(list.get(i4).stopTime.split(x.bQ)[0]);
                    int i8 = Integer.parseInt(list.get(i4).stopTime.split(x.bQ)[1]);
                    LogUtil.e(TAG, i5 + "  " + i6 + "  " + i7 + "  " + i8);
                    if (TimeUtils.isCurrentInTimeScope(i5, i6, i7, i8)) {
                        operationTime.isOpen = true;
                        return operationTime;
                    }
                }
                operationTime.openTime = str;
                return operationTime;
            }
            operationTime.isOpen = true;
            return operationTime;
        }
        operationTime.isOpen = true;
        return operationTime;
    }

    public UseToolsJsonBean getUseToolsJsonBean(int i) {
        List<TypeInfoBean> typeInfoBeans = getTypeInfoBeans();
        if (typeInfoBeans == null || typeInfoBeans.size() <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < typeInfoBeans.size(); i2++) {
            TypeInfoBean typeInfoBean = typeInfoBeans.get(i2);
            if (typeInfoBean.base.typeId == i) {
                return typeInfoBean.useToolsJson;
            }
        }
        return null;
    }

    public CreditAmountRuleBean getCreditAmountRule(int i) {
        List<TypeInfoBean> typeInfoBeans;
        int planFlag = getPlanFlag(i);
        if (planFlag == 0 || (typeInfoBeans = getTypeInfoBeans(planFlag)) == null || typeInfoBeans.size() <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < typeInfoBeans.size(); i2++) {
            if (i == typeInfoBeans.get(i2).base.typeId) {
                return typeInfoBeans.get(i2).creditAmountRule;
            }
        }
        return null;
    }
}
