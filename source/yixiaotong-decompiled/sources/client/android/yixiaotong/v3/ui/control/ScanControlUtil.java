package client.android.yixiaotong.v3.ui.control;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByMacBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.bean.login.OperationTimeJsonBean;
import client.android.yixiaotong.v3.bean.login.OperationTimeListBean;
import client.android.yixiaotong.v3.bean.login.SchoolIdBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfoBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.login.UseSoftwareProductBean;
import client.android.yixiaotong.v3.bean.login.UseToolsJsonBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity;
import client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlActivity;
import client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DMRechargeActivity;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DrinkWaterDetailActivity;
import client.android.yixiaotong.v3.ui.appcontrol.dry.DryModeActivity;
import client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerDetailActivity;
import client.android.yixiaotong.v3.ui.appcontrol.prepayment.PrepaymentWalletActivity;
import client.android.yixiaotong.v3.ui.appcontrol.prepayment.SelecetDeviceActivity;
import client.android.yixiaotong.v3.ui.appcontrol.wash.WashModeActivity;
import client.android.yixiaotong.v3.ui.dialog.BindSchoolDialog;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.scan.QrcodeUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.constant.x;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ScanControlUtil {
    private static final String TAG = "ScanControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private int mCnFlag;
    private String mDeviceVer;
    private boolean mIsEnable;
    private String mMac;
    private String mMachineId;
    private String mOpenTime;
    private String mQrcode;
    private int mSiteFlag;
    private String mSiteId;
    private String mTitleContent;
    private int mType;
    private int mTypeId;

    public void init(Activity activity, Account account, String str) {
        this.mActivity = activity;
        this.mAccount = account;
        this.mTitleContent = str;
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    private ScanControlUtil() {
        this.mIsEnable = true;
        this.mTitleContent = "";
    }

    private static final class SigleHolder {
        public static final ScanControlUtil INSTANCE = new ScanControlUtil();

        private SigleHolder() {
        }
    }

    public static ScanControlUtil getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void onScan(String str) {
        this.mMachineId = "";
        this.mMac = "";
        this.mTypeId = 0;
        this.mDeviceVer = "";
        if (StringUtils.isNotEmpty(str)) {
            this.mQrcode = str;
            getInfoByQRCode();
        }
    }

    private void getInfoByQRCode() {
        V3BusinessControllers.getInstance().getInfoByQRCode(this.mAccount, this.mQrcode, false, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.control.ScanControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(ScanControlUtil.this.mActivity, "正在获取二维码数据.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (ScanControlUtil.this.mIsEnable) {
                    if (machineByMacBean != null && StringUtils.isNotEmpty(machineByMacBean.deviceMac) && StringUtils.isNotEmpty(machineByMacBean.machineId) && StringUtils.isNotEmpty(machineByMacBean.deviceVer)) {
                        ScanControlUtil.this.mMachineId = machineByMacBean.machineId;
                        ScanControlUtil.this.mMac = machineByMacBean.deviceMac;
                        ScanControlUtil.this.mTypeId = machineByMacBean.typeId;
                        ScanControlUtil.this.mDeviceVer = machineByMacBean.deviceVer;
                    }
                    ScanControlUtil.this.getDeviceInfo();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ScanControlUtil.this.mIsEnable) {
                    ScanControlUtil.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfo() {
        final String strSubstring;
        String subQrcode = QrcodeUtil.getSubQrcode(this.mQrcode);
        if (StringUtils.isNotEmpty(this.mMachineId) || (StringUtils.isNotEmpty(subQrcode) && subQrcode.length() >= 40 && QrcodeUtil.isNumberLetterIllegal(subQrcode.toUpperCase()))) {
            if (StringUtils.isNotEmpty(this.mMachineId)) {
                strSubstring = this.mMachineId;
            } else {
                strSubstring = (subQrcode.length() < 52 || !QrcodeUtil.isNBor4GDevice(subQrcode)) ? subQrcode.substring(2, 10) : subQrcode.substring(34, 50);
            }
            V3BusinessControllers.getInstance().getMachineByMachineId2(this.mAccount, strSubstring, false, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.control.ScanControlUtil.2
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                    if (ScanControlUtil.this.mIsEnable) {
                        boolean z = true;
                        if (machineByMacBean != null && machineByMacBean.base != null && StringUtils.isNotEmpty(machineByMacBean.base.schoolId) && machineByMacBean.base.use == 1) {
                            ScanControlUtil.this.mMachineId = strSubstring;
                            ScanControlUtil.this.mMac = machineByMacBean.base.mac;
                            ScanControlUtil.this.mTypeId = machineByMacBean.base.typeId;
                            ScanControlUtil.this.mDeviceVer = machineByMacBean.base.deviceVer;
                            ScanControlUtil.this.mCnFlag = machineByMacBean.base.cnflag;
                            ScanControlUtil.this.mType = machineByMacBean.base.mtype;
                            ScanControlUtil.this.mSiteFlag = machineByMacBean.base.siteFlag;
                            ScanControlUtil.this.mSiteId = machineByMacBean.base.siteId;
                            List<String> list = UserInfoUtil.getInstance().getLoginAccountV3().schoolList;
                            if (list != null && list.size() > 0) {
                                for (int i = 0; i < list.size(); i++) {
                                    if (list.get(i).equals(machineByMacBean.base.schoolId)) {
                                        z = false;
                                    }
                                }
                                if (!z) {
                                    ScanControlUtil.this.startOpen(machineByMacBean.base.investorId, machineByMacBean.base.schoolId);
                                    return;
                                }
                            }
                            ScanControlUtil.this.getSchoolInfos(machineByMacBean.base.investorId, machineByMacBean.base.schoolId);
                            return;
                        }
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ScanControlUtil.this.showDialog("设备未授权，请联系管理员" + strSubstring + "\n(" + LocalDataUtil.getTraceID(ScanControlUtil.this.mActivity) + ")", true);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (ScanControlUtil.this.mIsEnable) {
                        ScanControlUtil.this.onError(clientException);
                    }
                }
            });
            return;
        }
        if (StringUtils.isNotEmpty(this.mQrcode)) {
            qrcode();
        }
    }

    private void qrcode() {
        V3BusinessControllers.getInstance().getAnalysisQRCode(this.mAccount, this.mQrcode, new Listener<SchoolIdBean>() { // from class: client.android.yixiaotong.v3.ui.control.ScanControlUtil.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(ScanControlUtil.this.mActivity, "正在解析二维码.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SchoolIdBean schoolIdBean, Object... objArr) {
                super.onComplete(controller, schoolIdBean, objArr);
                if (ScanControlUtil.this.mIsEnable) {
                    ScanControlUtil.this.getSchoolInfos("", schoolIdBean.schoolId);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ScanControlUtil.this.mIsEnable) {
                    ScanControlUtil.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.v3.ui.control.ScanControlUtil$4, reason: invalid class name */
    class AnonymousClass4 extends Listener<List<SchoolInfosBean>> {
        final /* synthetic */ String val$investorid;
        final /* synthetic */ String val$schoolid;

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onStart(Controller controller) {
        }

        AnonymousClass4(String str, String str2) {
            this.val$investorid = str;
            this.val$schoolid = str2;
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onComplete(Controller controller, final List<SchoolInfosBean> list, Object... objArr) {
            if (ScanControlUtil.this.mIsEnable) {
                BaseMaterialDialog.dissmisMaterialDialog();
                if (list == null || list.size() <= 0 || list.get(0) == null) {
                    return;
                }
                final String str = list.get(0).schoolName;
                TwoButtonDialog.getInstance().showDialog(ScanControlUtil.this.mActivity, new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.control.ScanControlUtil.4.1
                    @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                    public void onConfirm() {
                        BindSchoolDialog.getInstance().showDialog(ScanControlUtil.this.mActivity, new BindSchoolDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.control.ScanControlUtil.4.1.1
                            @Override // client.android.yixiaotong.v3.ui.dialog.BindSchoolDialog.Listener
                            public void onConfirm(String str2) {
                                LogUtil.e(ScanControlUtil.TAG, "bindSchool:" + ScanControlUtil.this.mIsEnable);
                                ScanControlUtil.this.bindSchool(AnonymousClass4.this.val$investorid, AnonymousClass4.this.val$schoolid, str2);
                            }
                        }, str, ((SchoolInfosBean) list.get(0)).schoolAddress);
                    }

                    @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                    public void onCancle() {
                        ScanControlUtil.this.mActivity.finish();
                    }
                }, "提示", "是否要继续绑定《" + str + "》，请确认学校无误后再继续", "退出", "继续绑定");
            }
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onFail(Controller controller, ClientException clientException) {
            if (ScanControlUtil.this.mIsEnable) {
                ScanControlUtil.this.onError(clientException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSchoolInfos(String str, String str2) {
        V3BusinessControllers.getInstance().getSchoolInfos(this.mAccount, str2, false, new AnonymousClass4(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindSchool(final String str, final String str2, String str3) {
        V3BusinessControllers.getInstance().postBindSchoolInfo(this.mAccount, str2, str3, false, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.control.ScanControlUtil.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(ScanControlUtil.this.mActivity, "绑定学校.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (ScanControlUtil.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(ScanControlUtil.this.mActivity, "绑定学校成功！");
                    LocalDataUtil.saveIsNeedLoadUserInfo(ScanControlUtil.this.mActivity, true);
                    UserInfoUtil.getInstance().saveBindSchoolId(str2);
                    ScanControlUtil.this.getSchoolIdInfo(str);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ScanControlUtil.this.mIsEnable) {
                    ScanControlUtil.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSchoolIdInfo(final String str) {
        V3BusinessControllers.getInstance().getSchoolInfo(this.mAccount, new Listener<SchoolInfoBean>() { // from class: client.android.yixiaotong.v3.ui.control.ScanControlUtil.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SchoolInfoBean schoolInfoBean, Object... objArr) {
                if (ScanControlUtil.this.mIsEnable) {
                    ScanControlUtil.this.getSchoolInfos(str);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ScanControlUtil.this.mIsEnable) {
                    ScanControlUtil.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSchoolInfos(final String str) {
        List<String> list = UserInfoUtil.getInstance().getLoginAccountV3().schoolList;
        if (list == null || list.size() <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + ",");
        }
        V3BusinessControllers.getInstance().getSchoolInfos(this.mAccount, sb.substring(0, sb.length() - 1), false, new Listener<List<SchoolInfosBean>>() { // from class: client.android.yixiaotong.v3.ui.control.ScanControlUtil.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<SchoolInfosBean> list2, Object... objArr) {
                if (ScanControlUtil.this.mIsEnable) {
                    UserInfoUtil.getInstance().saveSchoolInfosV3(list2);
                    String bindSchoolId = UserInfoUtil.getInstance().getBindSchoolId();
                    boolean z = true;
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        if ((list2.get(i2).id + "").equals(bindSchoolId)) {
                            UserInfoUtil.getInstance().saveSchoolInfosIndex(i2);
                            InvestorInfoUtil.getInstance().saveInvestorInfosIndex(0);
                            LocalDataUtil.saveIsNeedLoadInvestorInfo(ScanControlUtil.this.mActivity, true);
                            if (StringUtils.isNotEmpty(str)) {
                                ScanControlUtil.this.getInvestorInfo(str, true);
                                z = false;
                            }
                        }
                    }
                    LocalDataUtil.saveIsNeedLoadUserInfo(ScanControlUtil.this.mActivity, false);
                    UserInfoUtil.getInstance().saveBindSchoolId("");
                    if (z) {
                        ScanControlUtil.this.mActivity.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ScanControlUtil.this.mIsEnable) {
                    ScanControlUtil.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startOpen(String str, String str2) {
        if (StringUtils.isNotEmpty(str) && StringUtils.isNotEmpty(str2)) {
            LogUtil.e(TAG, str2 + "  " + UserInfoUtilControl.getInstance().getSchoolId());
            if (!str2.equals(UserInfoUtilControl.getInstance().getSchoolId())) {
                List<SchoolInfosBean> list = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList;
                boolean z = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).id == Long.parseLong(str2)) {
                        UserInfoUtil.getInstance().saveSchoolInfosIndex(i);
                        z = true;
                    }
                }
                if (z) {
                    InvestorInfoUtil.getInstance().saveInvestorInfosIndex(0);
                    LocalDataUtil.saveIsNeedLoadInvestorInfo(this.mActivity, true);
                    getInvestorInfo(str, false);
                    return;
                }
                return;
            }
            if (!str.equals(InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId)) {
                List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
                for (int i2 = 0; i2 < investorInfosV3.size(); i2++) {
                    if (investorInfosV3.get(i2).investorInfo.investorId.equals(str)) {
                        InvestorInfoUtil.getInstance().saveInvestorInfosIndex(i2);
                    }
                }
                isEnableOpen();
                return;
            }
            isEnableOpen();
            return;
        }
        showDialog("开阀失败", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isEnableOpen() {
        List<TypeInfoBean> typeInfoBeans = InvestorInfoUtilControl.getInstance().getTypeInfoBeans();
        TypeInfoBean typeInfoBean = null;
        for (int i = 0; i < typeInfoBeans.size(); i++) {
            if (typeInfoBeans.get(i).base.typeId == this.mTypeId) {
                typeInfoBean = typeInfoBeans.get(i);
            }
        }
        if (typeInfoBean == null) {
            showDialog("无法找到当前设备的应用信息，尝试点击应用图标去使用设备", true);
            return;
        }
        if (typeInfoBean.base.statusFlag == 1) {
            int planFlag = InvestorInfoUtilControl.getInstance().getPlanFlag(this.mTypeId);
            UseToolsJsonBean useToolsJsonBean = typeInfoBean.useToolsJson;
            OperationTimeJsonBean operationTimeJson = InvestorInfoUtilControl.getInstance().getOperationTimeJson(this.mTypeId, planFlag);
            if (operationTimeJson != null && operationTimeJson.operationFlag == 2) {
                if (isOpenTime(operationTimeJson)) {
                    isPhoneUse(useToolsJsonBean, typeInfoBean);
                    return;
                } else {
                    showDialog("暂停服务，开放时间为\n每日" + this.mOpenTime, true);
                    return;
                }
            }
            isPhoneUse(useToolsJsonBean, typeInfoBean);
            return;
        }
        showDialog("应用已停用", true);
    }

    private boolean isOpenTime(OperationTimeJsonBean operationTimeJsonBean) {
        this.mOpenTime = "";
        List<OperationTimeListBean> list = operationTimeJsonBean.operationTimeList;
        if (list == null || list.size() <= 0) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            this.mOpenTime += list.get(i).startTime + "至" + list.get(i).stopTime + "时\n";
            int i2 = Integer.parseInt(list.get(i).startTime.split(x.bQ)[0]);
            int i3 = Integer.parseInt(list.get(i).startTime.split(x.bQ)[1]);
            int i4 = Integer.parseInt(list.get(i).stopTime.split(x.bQ)[0]);
            int i5 = Integer.parseInt(list.get(i).stopTime.split(x.bQ)[1]);
            LogUtil.e(TAG, i2 + "  " + i3 + "  " + i4 + "  " + i5);
            if (TimeUtils.isCurrentInTimeScope(i2, i3, i4, i5)) {
                return true;
            }
        }
        return false;
    }

    private void isPhoneUse(UseToolsJsonBean useToolsJsonBean, TypeInfoBean typeInfoBean) {
        String str;
        BaseMaterialDialog.dissmisMaterialDialog();
        if (useToolsJsonBean != null && useToolsJsonBean.usePhoneOnMachineFlag == 2) {
            showDialog("本校设备不支持使用，请绑卡使用", true);
            return;
        }
        int i = this.mTypeId;
        if (i == 1) {
            String str2 = this.mQrcode;
            if (str2.contains("?")) {
                String[] strArrSplit = this.mQrcode.split("\\?");
                if (strArrSplit.length > 1 && strArrSplit[1].length() >= 52) {
                    str2 = strArrSplit[1];
                }
            }
            BathDetailActivity.launch(this.mActivity, str2, false, this.mDeviceVer, this.mMachineId, this.mCnFlag, this.mType);
        } else if (i == 6) {
            String str3 = this.mQrcode;
            if (str3.contains("?")) {
                String[] strArrSplit2 = this.mQrcode.split("\\?");
                if (strArrSplit2.length > 1 && strArrSplit2[1].length() >= 52) {
                    str3 = strArrSplit2[1];
                }
            }
            DrinkWaterDetailActivity.launch(this.mActivity, str3, this.mDeviceVer, this.mMachineId, this.mCnFlag, this.mType, this.mMac);
        } else if (i == 8) {
            String str4 = this.mQrcode;
            if (str4.contains("?")) {
                String[] strArrSplit3 = this.mQrcode.split("\\?");
                if (strArrSplit3.length > 1 && strArrSplit3[1].length() >= 52) {
                    str4 = strArrSplit3[1];
                }
            }
            HairdryerDetailActivity.launch(this.mActivity, str4, this.mDeviceVer, this.mMachineId, this.mCnFlag, this.mType, this.mMac);
        } else if (i == 3) {
            WashModeActivity.launch(this.mActivity, this.mQrcode, this.mMachineId, this.mMac);
        } else if (i == 16) {
            DryModeActivity.launch(this.mActivity, this.mQrcode);
        } else if (i == 20) {
            if (typeInfoBean.extendJson != null && typeInfoBean.extendJson.type == 1) {
                showDialog("该款领款机未配置使用功能权限", true);
                return;
            }
            String str5 = this.mQrcode;
            if (str5.contains("?")) {
                String[] strArrSplit4 = this.mQrcode.split("\\?");
                if (strArrSplit4.length > 1) {
                    str5 = strArrSplit4[1];
                }
            }
            DMRechargeActivity.launch(this.mActivity, str5, this.mSiteFlag, this.mSiteId);
        } else if (i == 18) {
            LogUtil.e(TAG, "isPhoneUse:" + this.mMachineId + "  " + LocalDataUtil.getTypeIdMachineId(this.mActivity, 18));
            String typeIdMachineId = LocalDataUtil.getTypeIdMachineId(this.mActivity, 18);
            if (!StringUtils.isNotEmpty(typeIdMachineId) || typeIdMachineId.split(";").length < 3) {
                str = "";
            } else {
                LogUtil.e(TAG, typeIdMachineId.split(";")[0] + "  " + typeIdMachineId.split(";")[1] + "  " + typeIdMachineId.split(";")[2]);
                str = typeIdMachineId.split(";")[0];
            }
            UseSoftwareProductBean useSoftwareProductBeanIsUseAndroid = InvestorInfoUtilControl.getInstance().isUseAndroid(18);
            if (!useSoftwareProductBeanIsUseAndroid.isUse) {
                showDialog(useSoftwareProductBeanIsUseAndroid.msg, true);
                return;
            } else if (StringUtils.isNotEmpty(str) && this.mMachineId.equals(str)) {
                PrepaymentWalletActivity.launch(this.mActivity);
            } else {
                SelecetDeviceActivity.launch(this.mActivity);
            }
        } else if (i == 2) {
            String str6 = this.mQrcode;
            if (str6.contains("?")) {
                String[] strArrSplit5 = this.mQrcode.split("\\?");
                if (strArrSplit5.length > 1 && strArrSplit5[1].length() >= 52) {
                    str6 = strArrSplit5[1];
                }
            }
            ConsumerControlActivity.launch(this.mActivity, typeInfoBean, str6);
        }
        this.mActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getInvestorInfo(final String str, final boolean z) {
        V3BusinessControllers.getInstance().getInvestorInfo(this.mAccount, new Listener<List<InvestorInfosBean>>() { // from class: client.android.yixiaotong.v3.ui.control.ScanControlUtil.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<InvestorInfosBean> list, Object... objArr) {
                if (ScanControlUtil.this.mIsEnable) {
                    List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
                    for (int i = 0; i < investorInfosV3.size(); i++) {
                        if (investorInfosV3.get(i).investorInfo.investorId.equals(str)) {
                            InvestorInfoUtil.getInstance().saveInvestorInfosIndex(i);
                        }
                    }
                    if (z) {
                        ScanControlUtil.this.mActivity.finish();
                    } else {
                        ScanControlUtil.this.isEnableOpen();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ScanControlUtil.this.mIsEnable) {
                    ScanControlUtil.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str, final boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, "", str, "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.control.ScanControlUtil.9
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                if (z) {
                    ScanControlUtil.this.mActivity.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.control.ScanControlUtil.10
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    ScanControlUtil.this.mActivity.finish();
                }
            }, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(this.mActivity, this.mTitleContent, clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            this.mActivity.finish();
        }
    }
}
