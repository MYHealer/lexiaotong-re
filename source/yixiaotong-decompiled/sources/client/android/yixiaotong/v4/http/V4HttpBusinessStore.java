package client.android.yixiaotong.v4.http;

import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.exception.HttpException;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.http.HttpProtocolFactory;
import client.android.yixiaotong.v3.bean.deviceinfo.OpenPro;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.bean.DeviceLock;
import client.android.yixiaotong.v4.http.bean.V44GOpen;
import client.android.yixiaotong.v4.http.bean.V44GOpenStatus;
import client.android.yixiaotong.v4.http.bean.V4AddRepair;
import client.android.yixiaotong.v4.http.bean.V4AppMonitorReport;
import client.android.yixiaotong.v4.http.bean.V4AreaBean;
import client.android.yixiaotong.v4.http.bean.V4BLECollect;
import client.android.yixiaotong.v4.http.bean.V4BLEOpen;
import client.android.yixiaotong.v4.http.bean.V4BLEOpenBean;
import client.android.yixiaotong.v4.http.bean.V4BTRecharge;
import client.android.yixiaotong.v4.http.bean.V4BaseBean;
import client.android.yixiaotong.v4.http.bean.V4BathConsumeDetailBean;
import client.android.yixiaotong.v4.http.bean.V4BathRecordBean;
import client.android.yixiaotong.v4.http.bean.V4BathRecordListBean;
import client.android.yixiaotong.v4.http.bean.V4BindCard;
import client.android.yixiaotong.v4.http.bean.V4BindCustomer;
import client.android.yixiaotong.v4.http.bean.V4BindProject;
import client.android.yixiaotong.v4.http.bean.V4BindRoom;
import client.android.yixiaotong.v4.http.bean.V4BugErrorLog;
import client.android.yixiaotong.v4.http.bean.V4CancelRefund;
import client.android.yixiaotong.v4.http.bean.V4CardInfoBean;
import client.android.yixiaotong.v4.http.bean.V4DeleteRepair;
import client.android.yixiaotong.v4.http.bean.V4DeviceInfoBean;
import client.android.yixiaotong.v4.http.bean.V4DeviceListBean;
import client.android.yixiaotong.v4.http.bean.V4DeviceMeterRefundRecordBean;
import client.android.yixiaotong.v4.http.bean.V4DeviceSubmitRefund;
import client.android.yixiaotong.v4.http.bean.V4ElecMeterInfoBean;
import client.android.yixiaotong.v4.http.bean.V4ElecRechargeRecordBean;
import client.android.yixiaotong.v4.http.bean.V4F0Data;
import client.android.yixiaotong.v4.http.bean.V4HomeInfoBean;
import client.android.yixiaotong.v4.http.bean.V4ImageCodeBean;
import client.android.yixiaotong.v4.http.bean.V4Login;
import client.android.yixiaotong.v4.http.bean.V4LoginBean;
import client.android.yixiaotong.v4.http.bean.V4MeterConsumeDailySummaryBean;
import client.android.yixiaotong.v4.http.bean.V4MetersTrendBean;
import client.android.yixiaotong.v4.http.bean.V4Mobile;
import client.android.yixiaotong.v4.http.bean.V4ModeBean;
import client.android.yixiaotong.v4.http.bean.V4PlatformInfoBean;
import client.android.yixiaotong.v4.http.bean.V4ProjectConfigBean;
import client.android.yixiaotong.v4.http.bean.V4Recharge;
import client.android.yixiaotong.v4.http.bean.V4RechargeBean;
import client.android.yixiaotong.v4.http.bean.V4RechargeListBean;
import client.android.yixiaotong.v4.http.bean.V4RechargeRecordListBean;
import client.android.yixiaotong.v4.http.bean.V4RefundDetailBean;
import client.android.yixiaotong.v4.http.bean.V4RefundRecordBean;
import client.android.yixiaotong.v4.http.bean.V4RefundableAmountBean;
import client.android.yixiaotong.v4.http.bean.V4Register;
import client.android.yixiaotong.v4.http.bean.V4RepairRecordBean;
import client.android.yixiaotong.v4.http.bean.V4ResetPassword;
import client.android.yixiaotong.v4.http.bean.V4SchoolInfoBean;
import client.android.yixiaotong.v4.http.bean.V4SelectAllBean;
import client.android.yixiaotong.v4.http.bean.V4ServerListBean;
import client.android.yixiaotong.v4.http.bean.V4SetDevicePassword;
import client.android.yixiaotong.v4.http.bean.V4SignBean;
import client.android.yixiaotong.v4.http.bean.V4SubmitRefund;
import client.android.yixiaotong.v4.http.bean.V4SubmitRefundBean;
import client.android.yixiaotong.v4.http.bean.V4ToPay;
import client.android.yixiaotong.v4.http.bean.V4UpdateRoomLeader;
import client.android.yixiaotong.v4.http.bean.V4UpdateUserInfo;
import client.android.yixiaotong.v4.http.bean.V4UserInfoDetailBean;
import client.android.yixiaotong.v4.http.bean.V4UserLogoff;
import client.android.yixiaotong.v4.http.bean.V4UserUpdateLoginPassword;
import client.android.yixiaotong.v4.http.bean.V4VersionInfoBean;
import client.android.yixiaotong.v4.http.bean.V4WalletInfoBean;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectConfigInfoUtil;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectInfoBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.alipay.sdk.util.i;
import com.huawei.openalliance.ad.constant.x;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4HttpBusinessStore {
    public static final String TAG = "V4HttpBusinessStore";
    private Account mAccount;
    private V4BusinessHttpProtocol mProtocol;

    public V4HttpBusinessStore(Account account) {
        this.mAccount = account;
    }

    public void setUrl(String str) {
        this.mProtocol = (V4BusinessHttpProtocol) HttpProtocolFactory.getInstance().getProtocol(str, V4BusinessHttpProtocol.class);
    }

    public SuccessBean postBugErrorLog(String str, String str2, String str3, String str4, String str5, String str6, String str7) throws HttpException {
        try {
            String version = AppUtils.getVersion(BaseApplication.app);
            String str8 = AppUtils.getDeviceManufacturer() + "  " + AppUtils.getSystemModel() + "  " + AppUtils.getSystemVersion();
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str9 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            String sign = V4HeaderUtil.getSign(str9, headerTimestamp);
            V4BugErrorLog v4BugErrorLog = new V4BugErrorLog();
            v4BugErrorLog.domain = str;
            v4BugErrorLog.fullUrl = str;
            v4BugErrorLog.requestBody = str4;
            v4BugErrorLog.requestHeaders = str2;
            v4BugErrorLog.responseHeaders = str5;
            v4BugErrorLog.statusCode = str3;
            v4BugErrorLog.responseBody = str6;
            v4BugErrorLog.timestamp = V4HeaderUtil.getHeaderTimestamp();
            v4BugErrorLog.errorMessage = "{errMsg:" + str7 + ",client:乐校通Android,version:" + version + ",mobileVersion:" + str8 + i.d;
            LogUtil.log(v4BugErrorLog.toString());
            LogUtil.e(TAG, v4BugErrorLog.toString());
            V4BaseBean<SuccessBean> v4BaseBeanPostBugErrorLog = this.mProtocol.postBugErrorLog(headerTimestamp, str9, sign, v4BugErrorLog);
            if (v4BaseBeanPostBugErrorLog.ok() && v4BaseBeanPostBugErrorLog.data != null) {
                return v4BaseBeanPostBugErrorLog.data;
            }
            throw HttpException.filter(v4BaseBeanPostBugErrorLog.code, v4BaseBeanPostBugErrorLog.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4VersionInfoBean getAppVersionInfo(String str) throws HttpException {
        try {
            LogUtil.log("clientType:3clientPlatformType:1curVer:" + str);
            LogUtil.e(TAG, "clientType:3clientPlatformType:1curVer:" + str);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4VersionInfoBean> appVersionInfo = this.mProtocol.getAppVersionInfo(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), 3, 1, str);
            if (appVersionInfo.ok() && appVersionInfo.data != null) {
                return appVersionInfo.data;
            }
            throw HttpException.filter(appVersionInfo.code, appVersionInfo.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<V4PlatformInfoBean> getSchoolPlatform(String str) throws HttpException {
        try {
            LogUtil.log("keyword:" + str);
            LogUtil.e(TAG, "keyword:" + str);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            V4BaseBean<List<V4PlatformInfoBean>> schoolPlatform = this.mProtocol.getSchoolPlatform(headerTimestamp, "", V4HeaderUtil.getSign("", headerTimestamp), str);
            if (schoolPlatform.ok() && schoolPlatform.data != null) {
                return schoolPlatform.data;
            }
            throw HttpException.filter(schoolPlatform.code, schoolPlatform.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean userRegister(String str, String str2, String str3, String str4, String str5) throws HttpException {
        try {
            V4Register v4Register = new V4Register();
            v4Register.mobile = str;
            v4Register.password = str2;
            v4Register.name = str3;
            v4Register.customerId = str4;
            v4Register.smsCode = str5;
            LogUtil.log("参数：" + obJectToString(v4Register));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            V4BaseBean<SuccessBean> v4BaseBeanPostUserRegister = this.mProtocol.postUserRegister(headerTimestamp, "", V4HeaderUtil.getSign("", headerTimestamp), v4Register);
            if (v4BaseBeanPostUserRegister.ok()) {
                return v4BaseBeanPostUserRegister.data;
            }
            throw HttpException.filter(v4BaseBeanPostUserRegister.code, v4BaseBeanPostUserRegister.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postUserlogoff() throws HttpException {
        try {
            V4UserLogoff v4UserLogoff = new V4UserLogoff();
            LogUtil.log("参数：");
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<SuccessBean> v4BaseBeanPostUserlogoff = this.mProtocol.postUserlogoff(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp), v4UserLogoff);
            if (v4BaseBeanPostUserlogoff.ok()) {
                return v4BaseBeanPostUserlogoff.data;
            }
            throw HttpException.filter(v4BaseBeanPostUserlogoff.code, v4BaseBeanPostUserlogoff.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4LoginBean login(String str, String str2, String str3, String str4) throws HttpException {
        try {
            V4Login v4Login = new V4Login();
            v4Login.userName = str;
            v4Login.password = str2;
            v4Login.captcha = str3;
            v4Login.captchaKey = str4;
            LogUtil.log("参数：" + obJectToString(v4Login));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            V4BaseBean<V4LoginBean> v4BaseBeanPostLogin = this.mProtocol.postLogin(headerTimestamp, "", V4HeaderUtil.getSign("", headerTimestamp), v4Login);
            if (v4BaseBeanPostLogin.ok() && v4BaseBeanPostLogin.data != null) {
                V4UserInfoBean v4UserInfoBean = new V4UserInfoBean();
                v4UserInfoBean.userId = v4BaseBeanPostLogin.data.userId;
                v4UserInfoBean.token = v4BaseBeanPostLogin.data.token;
                v4UserInfoBean.customerName = v4BaseBeanPostLogin.data.customerName;
                v4UserInfoBean.hexUserId = v4BaseBeanPostLogin.data.hexUserId;
                v4UserInfoBean.customerId = v4BaseBeanPostLogin.data.customerId;
                v4UserInfoBean.name = v4BaseBeanPostLogin.data.name;
                V4UserInfoUtil.getInstance().saveUserInfoV4(v4UserInfoBean);
                return v4BaseBeanPostLogin.data;
            }
            throw HttpException.filter(v4BaseBeanPostLogin.code, v4BaseBeanPostLogin.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4HomeInfoBean getHomeInfo() throws HttpException {
        try {
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4HomeInfoBean> homeInfo = this.mProtocol.getHomeInfo(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp));
            if (homeInfo.ok() && homeInfo.data != null) {
                return homeInfo.data;
            }
            throw HttpException.filter(homeInfo.code, homeInfo.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4BLEOpenBean post4GOpen(String str, int i, String str2, boolean z) throws HttpException {
        try {
            V44GOpen v44GOpen = new V44GOpen();
            v44GOpen.mac = str;
            v44GOpen.productId = i;
            v44GOpen.washModeId = str2;
            v44GOpen.deductBank = 1;
            v44GOpen.washModeUseAddLiquid = Boolean.valueOf(z);
            LogUtil.log("参数：" + obJectToString(v44GOpen));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4BLEOpenBean> v4BaseBeanPost4GOpen = this.mProtocol.post4GOpen(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), v44GOpen);
            if (v4BaseBeanPost4GOpen.ok() && v4BaseBeanPost4GOpen.data != null) {
                return v4BaseBeanPost4GOpen.data;
            }
            throw HttpException.filter(v4BaseBeanPost4GOpen.code, v4BaseBeanPost4GOpen.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4BLEOpenBean postBLEOpen(String str, String str2, String str3, String str4, boolean z) throws HttpException {
        try {
            V4BLEOpen v4BLEOpen = new V4BLEOpen();
            v4BLEOpen.deviceMac = str;
            v4BLEOpen.deviceRandom = str3;
            v4BLEOpen.data02 = str4;
            v4BLEOpen.washModeId = str2;
            v4BLEOpen.deductBank = 1;
            v4BLEOpen.washModeUseAddLiquid = Boolean.valueOf(z);
            LogUtil.log("参数：" + obJectToString(v4BLEOpen));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str5 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4BLEOpenBean> v4BaseBeanPostBLEOpen = this.mProtocol.postBLEOpen(headerTimestamp, str5, V4HeaderUtil.getSign(str5, headerTimestamp), v4BLEOpen);
            if (v4BaseBeanPostBLEOpen.ok() && v4BaseBeanPostBLEOpen.data != null) {
                return v4BaseBeanPostBLEOpen.data;
            }
            throw HttpException.filter(v4BaseBeanPostBLEOpen.code, v4BaseBeanPostBLEOpen.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4BLEOpenBean postBLEClollect(String str, String str2, String str3) throws HttpException {
        try {
            V4BLECollect v4BLECollect = new V4BLECollect();
            v4BLECollect.deviceMac = str;
            v4BLECollect.deviceRandom = str2;
            v4BLECollect.data = str3;
            LogUtil.log("参数：" + obJectToString(v4BLECollect));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str4 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4BLEOpenBean> v4BaseBeanPostBLEClollect = this.mProtocol.postBLEClollect(headerTimestamp, str4, V4HeaderUtil.getSign(str4, headerTimestamp), v4BLECollect);
            if (v4BaseBeanPostBLEClollect.ok() && v4BaseBeanPostBLEClollect.data != null) {
                return v4BaseBeanPostBLEClollect.data;
            }
            throw HttpException.filter(v4BaseBeanPostBLEClollect.code, v4BaseBeanPostBLEClollect.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postAppMonitorReport(String str, String str2) throws HttpException {
        try {
            V4AppMonitorReport v4AppMonitorReport = new V4AppMonitorReport();
            v4AppMonitorReport.deviceMac = str;
            v4AppMonitorReport.appType = 1;
            v4AppMonitorReport.extension = str2.trim();
            LogUtil.log("参数：" + obJectToString(v4AppMonitorReport));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<SuccessBean> v4BaseBeanPostAppMonitorReport = this.mProtocol.postAppMonitorReport(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), v4AppMonitorReport);
            if (v4BaseBeanPostAppMonitorReport.ok()) {
                return v4BaseBeanPostAppMonitorReport.data;
            }
            throw HttpException.filter(v4BaseBeanPostAppMonitorReport.code, v4BaseBeanPostAppMonitorReport.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V44GOpenStatus get4GOpenStatus(String str, String str2) throws HttpException {
        try {
            LogUtil.log("参数：" + str);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V44GOpenStatus> v4BaseBean = this.mProtocol.get4GOpenStatus(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), str, str2);
            if (v4BaseBean.ok()) {
                return v4BaseBean.data;
            }
            throw HttpException.filter(v4BaseBean.code, v4BaseBean.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4BathRecordListBean getConsumeRecord(int i, int i2, int i3, int i4) throws HttpException {
        int i5 = i + 2;
        try {
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            String sign = V4HeaderUtil.getSign(str, headerTimestamp);
            String str2 = i5 > 5 ? "" : i5 + "";
            LogUtil.log("参数：timeFrameType:" + str2 + "pageSize:10pageIndex:" + i2 + "productId:" + i3 + "pay:" + i4);
            try {
                V4BaseBean<V4BathRecordListBean> consumeRecord = this.mProtocol.getConsumeRecord(headerTimestamp, str, sign, str2, 10, i2, i3, i4);
                if (consumeRecord != null && consumeRecord.ok() && consumeRecord.data != null) {
                    return consumeRecord.data;
                }
                throw HttpException.filter(consumeRecord.code, consumeRecord.getErrMsg());
            } catch (Exception e) {
                e = e;
                if (e instanceof HttpException) {
                    throw ((HttpException) e);
                }
                throw HttpException.getDefautException();
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public V4BathConsumeDetailBean getConsumeDetail(String str) throws HttpException {
        try {
            LogUtil.log("参数：consumeOrderId:" + str);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4BathConsumeDetailBean> consumeDetail = this.mProtocol.getConsumeDetail(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), str);
            if (consumeDetail != null && consumeDetail.ok() && consumeDetail.data != null) {
                return consumeDetail.data;
            }
            throw HttpException.filter(consumeDetail.code, consumeDetail.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4UserInfoDetailBean getUserInfo() throws HttpException {
        try {
            LogUtil.log("参数：");
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4UserInfoDetailBean> userInfo = this.mProtocol.getUserInfo(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp));
            if (userInfo.ok() && userInfo.data != null) {
                V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
                loginAccountV4.userId = userInfo.data.userId;
                loginAccountV4.token = userInfo.data.token;
                loginAccountV4.customerName = userInfo.data.customerName;
                loginAccountV4.hexUserId = userInfo.data.hexUserId;
                loginAccountV4.customerId = userInfo.data.customerId;
                loginAccountV4.refundLock = userInfo.data.refundLock;
                loginAccountV4.name = userInfo.data.name;
                loginAccountV4.cpersonId = userInfo.data.cpersonId;
                loginAccountV4.projectId = userInfo.data.projectId;
                loginAccountV4.serviceId = userInfo.data.serviceId;
                V4UserInfoUtil.getInstance().saveUserInfoV4(loginAccountV4);
                return userInfo.data;
            }
            throw HttpException.filter(userInfo.code, userInfo.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4UserInfoDetailBean getCustomerPersonInfo() throws HttpException {
        try {
            LogUtil.log("参数：");
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4UserInfoDetailBean> customerPersonInfo = this.mProtocol.getCustomerPersonInfo(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp));
            if (customerPersonInfo.ok() && customerPersonInfo.data != null) {
                V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
                loginAccountV4.currentDeductBank = customerPersonInfo.data.currentDeductBank;
                V4UserInfoUtil.getInstance().saveUserInfoV4(loginAccountV4);
                return customerPersonInfo.data;
            }
            throw HttpException.filter(customerPersonInfo.code, customerPersonInfo.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postUpdateCurrentDeductBank() throws HttpException {
        try {
            LogUtil.log("参数：");
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<SuccessBean> v4BaseBeanPostUpdateCurrentDeductBank = this.mProtocol.postUpdateCurrentDeductBank(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp), 1);
            if (v4BaseBeanPostUpdateCurrentDeductBank.ok()) {
                return v4BaseBeanPostUpdateCurrentDeductBank.data;
            }
            throw HttpException.filter(v4BaseBeanPostUpdateCurrentDeductBank.code, v4BaseBeanPostUpdateCurrentDeductBank.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4ProjectConfigBean getProjectConfig() throws HttpException {
        try {
            LogUtil.log("参数：");
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4ProjectConfigBean> projectConfig = this.mProtocol.getProjectConfig(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp), V4UserInfoUtil.getInstance().getLoginAccountV4().projectId);
            if (projectConfig.ok() && projectConfig.data != null) {
                V4ProjectInfoBean v4ProjectInfoBean = new V4ProjectInfoBean();
                v4ProjectInfoBean.aliCartoonSign = Integer.valueOf(projectConfig.data.aliCartoonSign == null ? 0 : projectConfig.data.aliCartoonSign.intValue());
                v4ProjectInfoBean.projectPayConfigDTO = projectConfig.data.projectPayConfigDTO;
                v4ProjectInfoBean.payMentS = projectConfig.data.payMentS;
                v4ProjectInfoBean.consumeMode = Integer.valueOf(projectConfig.data.consumeMode);
                v4ProjectInfoBean.frontTypeToArray = projectConfig.data.frontTypeToArray;
                v4ProjectInfoBean.productTypeToArray = projectConfig.data.productTypeToArray;
                v4ProjectInfoBean.refundConfigObj = projectConfig.data.refundConfigObj;
                v4ProjectInfoBean.dormWallet = projectConfig.data.dormWallet;
                v4ProjectInfoBean.rechargeRemark = projectConfig.data.rechargeRemark;
                V4ProjectConfigInfoUtil.getInstance().saveProjectInfoV4(v4ProjectInfoBean);
                return projectConfig.data;
            }
            throw HttpException.filter(projectConfig.code, projectConfig.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4ServerListBean getServerList() throws HttpException {
        try {
            LogUtil.log("参数：");
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<List<V4ServerListBean>> serverList = this.mProtocol.getServerList(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp));
            if (serverList.ok() && serverList.data != null) {
                V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
                loginAccountV4.serverInfoList = serverList.data;
                LogUtil.e(TAG, loginAccountV4.serverInfoList.size() + "");
                V4ServerListBean v4ServerListBean = new V4ServerListBean();
                for (V4ServerListBean v4ServerListBean2 : serverList.data) {
                    if (v4ServerListBean2.projectId.equals(loginAccountV4.projectId)) {
                        loginAccountV4.balance = v4ServerListBean2.balance;
                        loginAccountV4.totalBalance = v4ServerListBean2.totalBalance;
                        loginAccountV4.giftBalance = v4ServerListBean2.giftBalance;
                        loginAccountV4.balanceId = v4ServerListBean2.balanceId;
                        loginAccountV4.serviceId = v4ServerListBean2.serviceId;
                        v4ServerListBean = v4ServerListBean2;
                    }
                }
                V4UserInfoUtil.getInstance().saveUserInfoV4(loginAccountV4);
                return v4ServerListBean;
            }
            throw HttpException.filter(serverList.code, serverList.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4WalletInfoBean getUserBalance(String str) throws HttpException {
        try {
            LogUtil.e(TAG, "参数：" + str);
            LogUtil.log("参数：" + str);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4WalletInfoBean> userBalance = this.mProtocol.getUserBalance(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), str);
            if (userBalance.ok() && userBalance.data != null) {
                V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
                loginAccountV4.balance = userBalance.data.balance;
                loginAccountV4.giftBalance = userBalance.data.giftBalance;
                loginAccountV4.totalBalance = userBalance.data.totalBalance;
                V4UserInfoUtil.getInstance().saveUserInfoV4(loginAccountV4);
                return userBalance.data;
            }
            throw HttpException.filter(userBalance.code, userBalance.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<V4RechargeListBean> getRechargeList(int i) throws HttpException {
        try {
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().serviceId;
            LogUtil.log("参数：type:" + i + "serviceId:" + str);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<List<V4RechargeListBean>> rechargeList = this.mProtocol.getRechargeList(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), i, str);
            if (rechargeList.ok()) {
                return rechargeList.data;
            }
            throw HttpException.filter(rechargeList.code, rechargeList.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postUpdatePassword(String str, String str2) throws HttpException {
        try {
            V4UserUpdateLoginPassword v4UserUpdateLoginPassword = new V4UserUpdateLoginPassword();
            v4UserUpdateLoginPassword.newPassword = str;
            v4UserUpdateLoginPassword.oldPassword = str2;
            LogUtil.log("参数：" + obJectToString(v4UserUpdateLoginPassword));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<SuccessBean> v4BaseBeanPostUpdatePassword = this.mProtocol.postUpdatePassword(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), v4UserUpdateLoginPassword);
            if (v4BaseBeanPostUpdatePassword.ok()) {
                return v4BaseBeanPostUpdatePassword.data;
            }
            throw HttpException.filter(v4BaseBeanPostUpdatePassword.code, v4BaseBeanPostUpdatePassword.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postResetPassword(String str, String str2, String str3) throws HttpException {
        try {
            V4ResetPassword v4ResetPassword = new V4ResetPassword();
            v4ResetPassword.mobile = str;
            v4ResetPassword.smsCode = str2;
            v4ResetPassword.password = str3;
            LogUtil.log("参数：" + obJectToString(v4ResetPassword));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            V4BaseBean<SuccessBean> v4BaseBeanPostResetPassword = this.mProtocol.postResetPassword(headerTimestamp, "", V4HeaderUtil.getSign("", headerTimestamp), v4ResetPassword);
            if (v4BaseBeanPostResetPassword.ok()) {
                return v4BaseBeanPostResetPassword.data;
            }
            throw HttpException.filter(v4BaseBeanPostResetPassword.code, v4BaseBeanPostResetPassword.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4CardInfoBean getCardInfo() throws HttpException {
        try {
            LogUtil.log("参数：");
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4CardInfoBean> cardInfo = this.mProtocol.getCardInfo(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp));
            if (cardInfo.ok()) {
                return cardInfo.data;
            }
            throw HttpException.filter(cardInfo.code, cardInfo.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4CardInfoBean postBindCard(String str, String str2) throws HttpException {
        try {
            V4BindCard v4BindCard = new V4BindCard();
            v4BindCard.idcardId = str;
            v4BindCard.userId = str2;
            LogUtil.log("参数：" + obJectToString(v4BindCard));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4CardInfoBean> v4BaseBeanPostBindCard = this.mProtocol.postBindCard(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), v4BindCard);
            if (v4BaseBeanPostBindCard.ok()) {
                return v4BaseBeanPostBindCard.data;
            }
            throw HttpException.filter(v4BaseBeanPostBindCard.code, v4BaseBeanPostBindCard.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postUnBindCard() throws HttpException {
        try {
            V4BindCard v4BindCard = new V4BindCard();
            LogUtil.log("参数：");
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<SuccessBean> v4BaseBeanPostUnBindCard = this.mProtocol.postUnBindCard(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp), v4BindCard);
            if (v4BaseBeanPostUnBindCard.ok()) {
                return v4BaseBeanPostUnBindCard.data;
            }
            throw HttpException.filter(v4BaseBeanPostUnBindCard.code, v4BaseBeanPostUnBindCard.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String getDevicePassword() throws HttpException {
        try {
            LogUtil.log("参数：");
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<String> devicePassword = this.mProtocol.getDevicePassword(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp));
            if (devicePassword.ok()) {
                return devicePassword.data;
            }
            throw HttpException.filter(devicePassword.code, devicePassword.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postSetDevicePassword(String str, String str2) throws HttpException {
        try {
            V4SetDevicePassword v4SetDevicePassword = new V4SetDevicePassword();
            v4SetDevicePassword.newUserName = str;
            v4SetDevicePassword.newPassword = str2;
            LogUtil.log("参数：" + obJectToString(v4SetDevicePassword));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<SuccessBean> v4BaseBeanPostSetDevicePassword = this.mProtocol.postSetDevicePassword(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), v4SetDevicePassword);
            if (v4BaseBeanPostSetDevicePassword.ok()) {
                return v4BaseBeanPostSetDevicePassword.data;
            }
            throw HttpException.filter(v4BaseBeanPostSetDevicePassword.code, v4BaseBeanPostSetDevicePassword.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postSendSmsCode(String str, String str2, String str3, String str4) throws HttpException {
        try {
            V4Mobile v4Mobile = new V4Mobile();
            v4Mobile.mobile = str;
            v4Mobile.captcha = str2;
            v4Mobile.captchaKey = str3;
            LogUtil.log("参数：" + obJectToString(v4Mobile));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            V4BaseBean<SuccessBean> v4BaseBeanPostSendSmsCode = this.mProtocol.postSendSmsCode(headerTimestamp, str4, V4HeaderUtil.getSign(str4, headerTimestamp), str, str2, str3);
            if (v4BaseBeanPostSendSmsCode.ok()) {
                return v4BaseBeanPostSendSmsCode.data;
            }
            throw HttpException.filter(v4BaseBeanPostSendSmsCode.code, v4BaseBeanPostSendSmsCode.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postUpdateMobile(String str, String str2) throws HttpException {
        try {
            V4Mobile v4Mobile = new V4Mobile();
            v4Mobile.mobile = str;
            v4Mobile.smsCode = str2;
            LogUtil.log("参数：" + obJectToString(v4Mobile));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<SuccessBean> v4BaseBeanPostUpdateMobile = this.mProtocol.postUpdateMobile(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), v4Mobile);
            if (v4BaseBeanPostUpdateMobile.ok()) {
                return v4BaseBeanPostUpdateMobile.data;
            }
            throw HttpException.filter(v4BaseBeanPostUpdateMobile.code, v4BaseBeanPostUpdateMobile.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4ImageCodeBean getLoginCodeImage() throws HttpException {
        try {
            LogUtil.log("参数：");
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
            String str = loginAccountV4 != null ? loginAccountV4.token : "";
            V4BaseBean<V4ImageCodeBean> loginCodeImage = this.mProtocol.getLoginCodeImage(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp));
            if (loginCodeImage.ok() && loginCodeImage.data != null) {
                return loginCodeImage.data;
            }
            throw HttpException.filter(loginCodeImage.code, loginCodeImage.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4RechargeBean postUserRecharge(String str, int i, String str2) throws HttpException {
        try {
            V4Recharge v4Recharge = new V4Recharge();
            v4Recharge.amount = str;
            v4Recharge.payMent = i;
            v4Recharge.projectId = V4UserInfoUtil.getInstance().getLoginAccountV4().projectId;
            v4Recharge.rechargeAmountDefId = str2;
            v4Recharge.productType = 1;
            LogUtil.log("参数：" + obJectToString(v4Recharge));
            LogUtil.e(TAG, obJectToString(v4Recharge));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4RechargeBean> v4BaseBeanPostUserRecharge = this.mProtocol.postUserRecharge(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), v4Recharge);
            if (v4BaseBeanPostUserRecharge.ok()) {
                return v4BaseBeanPostUserRecharge.data;
            }
            throw HttpException.filter(v4BaseBeanPostUserRecharge.code, v4BaseBeanPostUserRecharge.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4RechargeRecordListBean getRechargeRecord() throws HttpException {
        try {
            LogUtil.log("参数：");
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4RechargeRecordListBean> rechargeRecord = this.mProtocol.getRechargeRecord(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp));
            if (rechargeRecord.ok()) {
                return rechargeRecord.data;
            }
            throw HttpException.filter(rechargeRecord.code, rechargeRecord.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4SubmitRefundBean postSubmitRefund(String str, String str2, int i, int i2, String str3, String str4) throws HttpException {
        try {
            V4SubmitRefund v4SubmitRefund = new V4SubmitRefund();
            v4SubmitRefund.name = str;
            v4SubmitRefund.reason = str2;
            v4SubmitRefund.projectId = V4UserInfoUtil.getInstance().getLoginAccountV4().projectId;
            v4SubmitRefund.type = i;
            if (i == 2) {
                v4SubmitRefund.productId = i2;
                v4SubmitRefund.serviceId = V4UserInfoUtil.getInstance().getLoginAccountV4().serviceId;
                v4SubmitRefund.roomId = str3;
                v4SubmitRefund.alipayAccount = str4;
                v4SubmitRefund.alipayName = str;
            }
            LogUtil.log("参数：" + obJectToString(v4SubmitRefund));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str5 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4SubmitRefundBean> v4BaseBeanPostSubmitRefund = this.mProtocol.postSubmitRefund(headerTimestamp, str5, V4HeaderUtil.getSign(str5, headerTimestamp), v4SubmitRefund);
            if (v4BaseBeanPostSubmitRefund.ok()) {
                return v4BaseBeanPostSubmitRefund.data;
            }
            throw HttpException.filter(v4BaseBeanPostSubmitRefund.code, v4BaseBeanPostSubmitRefund.getErrMsg(), v4BaseBeanPostSubmitRefund.data);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String postCancelRefund(String str, String str2, int i) throws HttpException {
        try {
            V4SubmitRefund v4SubmitRefund = new V4SubmitRefund();
            v4SubmitRefund.refId = str;
            v4SubmitRefund.rejectReason = str2;
            v4SubmitRefund.type = i;
            LogUtil.log("参数：" + obJectToString(v4SubmitRefund));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<String> v4BaseBeanPostCancelRefund = this.mProtocol.postCancelRefund(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), v4SubmitRefund);
            if (v4BaseBeanPostCancelRefund.ok()) {
                return v4BaseBeanPostCancelRefund.data;
            }
            throw HttpException.filter(v4BaseBeanPostCancelRefund.code, v4BaseBeanPostCancelRefund.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String postAgainSubmitRefund(String str) throws HttpException {
        try {
            V4SubmitRefund v4SubmitRefund = new V4SubmitRefund();
            v4SubmitRefund.refId = str;
            LogUtil.log("参数：" + obJectToString(v4SubmitRefund));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<String> v4BaseBeanPostAgainSubmitRefund = this.mProtocol.postAgainSubmitRefund(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), v4SubmitRefund);
            if (v4BaseBeanPostAgainSubmitRefund.ok()) {
                return v4BaseBeanPostAgainSubmitRefund.data;
            }
            throw HttpException.filter(v4BaseBeanPostAgainSubmitRefund.code, v4BaseBeanPostAgainSubmitRefund.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4RefundRecordBean getRefundList(int i, int i2) throws HttpException {
        try {
            LogUtil.log("参数：type:" + i + "productId:" + i2);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4RefundRecordBean> refundList = this.mProtocol.getRefundList(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp), i, i2);
            if (refundList.ok()) {
                return refundList.data;
            }
            throw HttpException.filter(refundList.code, refundList.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4RefundDetailBean getWaitRefundList(int i, int i2) throws HttpException {
        try {
            LogUtil.log("参数：type:" + i);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4RefundDetailBean> waitRefundList = this.mProtocol.getWaitRefundList(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp), i, i2);
            if (waitRefundList.ok()) {
                return waitRefundList.data;
            }
            throw HttpException.filter(waitRefundList.code, waitRefundList.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<V4AreaBean> getAreaList(String str) throws HttpException {
        try {
            LogUtil.log("参数：id" + str);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<List<V4AreaBean>> areaList = this.mProtocol.getAreaList(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), str);
            if (areaList.ok()) {
                return areaList.data;
            }
            throw HttpException.filter(areaList.code, areaList.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<V4DeviceListBean> getDeviceList(String str) throws HttpException {
        try {
            LogUtil.log("参数：roomId" + str);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<List<V4DeviceListBean>> deviceList = this.mProtocol.getDeviceList(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), str);
            if (deviceList.ok()) {
                return deviceList.data;
            }
            throw HttpException.filter(deviceList.code, deviceList.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4DeviceInfoBean getDeviceInfoByMac(String str) throws HttpException {
        try {
            String strReplace = str.replace(x.bQ, "");
            LogUtil.log("参数：btMac" + strReplace);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4DeviceInfoBean> deviceInfoByMac = this.mProtocol.getDeviceInfoByMac(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), strReplace);
            if (deviceInfoByMac.ok() && deviceInfoByMac.data != null) {
                return deviceInfoByMac.data;
            }
            throw HttpException.filter(deviceInfoByMac.code, deviceInfoByMac.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4DeviceInfoBean getDeviceInfoByMachineId(String str) throws HttpException {
        try {
            LogUtil.log("参数：mac" + str);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4DeviceInfoBean> deviceInfoByMachineId = this.mProtocol.getDeviceInfoByMachineId(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), str);
            if (deviceInfoByMachineId.ok() && deviceInfoByMachineId.data != null) {
                return deviceInfoByMachineId.data;
            }
            throw HttpException.filter(deviceInfoByMachineId.code, deviceInfoByMachineId.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<V4SchoolInfoBean> getSchoolInfos() throws HttpException {
        try {
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<List<V4SchoolInfoBean>> schoolInfos = this.mProtocol.getSchoolInfos(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp));
            if (schoolInfos.ok() && schoolInfos.data != null) {
                return schoolInfos.data;
            }
            throw HttpException.filter(schoolInfos.code, schoolInfos.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4BindCustomer postBindCustomer(String str) throws HttpException {
        try {
            V4BindCustomer v4BindCustomer = new V4BindCustomer();
            v4BindCustomer.customerId = str;
            LogUtil.log(obJectToString(v4BindCustomer));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4BindCustomer> v4BaseBeanPostBindCustomer = this.mProtocol.postBindCustomer(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), v4BindCustomer);
            if (v4BaseBeanPostBindCustomer.ok() && v4BaseBeanPostBindCustomer.data != null) {
                V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
                loginAccountV4.token = v4BaseBeanPostBindCustomer.data.token;
                loginAccountV4.customerName = v4BaseBeanPostBindCustomer.data.customerName;
                loginAccountV4.customerId = v4BaseBeanPostBindCustomer.data.customerId;
                V4UserInfoUtil.getInstance().saveUserInfoV4(loginAccountV4);
                return v4BaseBeanPostBindCustomer.data;
            }
            throw HttpException.filter(v4BaseBeanPostBindCustomer.code, v4BaseBeanPostBindCustomer.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4UserInfoDetailBean postSwitchCustomer(String str) throws HttpException {
        try {
            V4BindCustomer v4BindCustomer = new V4BindCustomer();
            v4BindCustomer.customerId = str;
            LogUtil.log(obJectToString(v4BindCustomer));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4UserInfoDetailBean> v4BaseBeanPostSwitchCustomer = this.mProtocol.postSwitchCustomer(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), v4BindCustomer);
            if (v4BaseBeanPostSwitchCustomer.ok() && v4BaseBeanPostSwitchCustomer.data != null && StringUtils.isNotEmpty(v4BaseBeanPostSwitchCustomer.data.customerId) && v4BaseBeanPostSwitchCustomer.data.customerId.equals(str)) {
                V4UserInfoBean v4UserInfoBean = new V4UserInfoBean();
                v4UserInfoBean.userId = v4BaseBeanPostSwitchCustomer.data.userId;
                v4UserInfoBean.token = v4BaseBeanPostSwitchCustomer.data.token;
                v4UserInfoBean.customerName = v4BaseBeanPostSwitchCustomer.data.customerName;
                v4UserInfoBean.hexUserId = v4BaseBeanPostSwitchCustomer.data.hexUserId;
                v4UserInfoBean.customerId = v4BaseBeanPostSwitchCustomer.data.customerId;
                v4UserInfoBean.refundLock = v4BaseBeanPostSwitchCustomer.data.refundLock;
                v4UserInfoBean.name = v4BaseBeanPostSwitchCustomer.data.name;
                v4UserInfoBean.cpersonId = v4BaseBeanPostSwitchCustomer.data.cpersonId;
                v4UserInfoBean.projectId = v4BaseBeanPostSwitchCustomer.data.projectId;
                V4UserInfoUtil.getInstance().saveUserInfoV4(v4UserInfoBean);
                return v4BaseBeanPostSwitchCustomer.data;
            }
            throw HttpException.filter(v4BaseBeanPostSwitchCustomer.code, v4BaseBeanPostSwitchCustomer.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4UserInfoDetailBean postSwitchProject(String str) throws HttpException {
        try {
            V4BindProject v4BindProject = new V4BindProject();
            v4BindProject.projectId = str;
            LogUtil.log(obJectToString(v4BindProject));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4UserInfoDetailBean> v4BaseBeanPostSwitchProject = this.mProtocol.postSwitchProject(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), str);
            if (v4BaseBeanPostSwitchProject.ok() && v4BaseBeanPostSwitchProject.data != null) {
                V4UserInfoBean v4UserInfoBean = new V4UserInfoBean();
                v4UserInfoBean.userId = v4BaseBeanPostSwitchProject.data.userId;
                v4UserInfoBean.token = v4BaseBeanPostSwitchProject.data.token;
                v4UserInfoBean.customerName = v4BaseBeanPostSwitchProject.data.customerName;
                v4UserInfoBean.hexUserId = v4BaseBeanPostSwitchProject.data.hexUserId;
                v4UserInfoBean.customerId = v4BaseBeanPostSwitchProject.data.customerId;
                v4UserInfoBean.refundLock = v4BaseBeanPostSwitchProject.data.refundLock;
                v4UserInfoBean.name = v4BaseBeanPostSwitchProject.data.name;
                v4UserInfoBean.cpersonId = v4BaseBeanPostSwitchProject.data.cpersonId;
                v4UserInfoBean.projectId = v4BaseBeanPostSwitchProject.data.projectId;
                List<V4ServerListBean> list = V4UserInfoUtil.getInstance().getLoginAccountV4().serverInfoList;
                v4UserInfoBean.serverInfoList = list;
                for (V4ServerListBean v4ServerListBean : list) {
                    if (v4ServerListBean.projectId.equals(v4UserInfoBean.projectId)) {
                        v4UserInfoBean.balance = v4ServerListBean.balance;
                        v4UserInfoBean.totalBalance = v4ServerListBean.totalBalance;
                        v4UserInfoBean.giftBalance = v4ServerListBean.giftBalance;
                        v4UserInfoBean.balanceId = v4ServerListBean.balanceId;
                        v4UserInfoBean.serviceId = v4ServerListBean.serviceId;
                    }
                }
                V4UserInfoUtil.getInstance().saveUserInfoV4(v4UserInfoBean);
                return v4BaseBeanPostSwitchProject.data;
            }
            throw HttpException.filter(v4BaseBeanPostSwitchProject.code, v4BaseBeanPostSwitchProject.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4UserInfoDetailBean postUpdateUserInfo(String str) throws HttpException {
        try {
            V4UpdateUserInfo v4UpdateUserInfo = new V4UpdateUserInfo();
            v4UpdateUserInfo.cpersonName = str;
            LogUtil.log(obJectToString(v4UpdateUserInfo));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4UserInfoDetailBean> v4BaseBeanPostUpdateUserInfo = this.mProtocol.postUpdateUserInfo(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), str);
            if (v4BaseBeanPostUpdateUserInfo.ok()) {
                V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
                loginAccountV4.name = str;
                V4UserInfoUtil.getInstance().saveUserInfoV4(loginAccountV4);
                return v4BaseBeanPostUpdateUserInfo.data;
            }
            throw HttpException.filter(v4BaseBeanPostUpdateUserInfo.code, v4BaseBeanPostUpdateUserInfo.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4RepairRecordBean getRepairList(int i, int i2, int i3) throws HttpException {
        try {
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().serviceId;
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().customerId;
            LogUtil.log("参数：status" + i + "pageSize:" + i2 + "pageIndex:" + i3 + "serviceId:" + str + "customerId:" + str2);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4RepairRecordBean> repairList = this.mProtocol.getRepairList(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), i, i2, i3, str, str2);
            if (repairList.ok()) {
                return repairList.data;
            }
            throw HttpException.filter(repairList.code, repairList.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postAddRepair(String str, String str2, String str3, String str4, String str5, String str6, String str7) throws HttpException {
        try {
            String str8 = V4UserInfoUtil.getInstance().getLoginAccountV4().projectId;
            V4AddRepair v4AddRepair = new V4AddRepair();
            v4AddRepair.repairContent = str;
            v4AddRepair.areaName = str2;
            v4AddRepair.buildingName = str3;
            v4AddRepair.floorName = str4;
            v4AddRepair.roomName = str5;
            v4AddRepair.contactName = str6;
            v4AddRepair.contactPhone = str7;
            v4AddRepair.projectId = str8;
            LogUtil.log("参数：" + obJectToString(v4AddRepair));
            LogUtil.e(TAG, obJectToString(v4AddRepair));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str9 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<SuccessBean> v4BaseBeanPostAddRepair = this.mProtocol.postAddRepair(headerTimestamp, str9, V4HeaderUtil.getSign(str9, headerTimestamp), v4AddRepair);
            if (v4BaseBeanPostAddRepair.ok()) {
                return v4BaseBeanPostAddRepair.data;
            }
            throw HttpException.filter(v4BaseBeanPostAddRepair.code, v4BaseBeanPostAddRepair.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postDeleteRepair(String str) throws HttpException {
        try {
            V4DeleteRepair v4DeleteRepair = new V4DeleteRepair();
            v4DeleteRepair.repairId = str;
            LogUtil.log("参数：" + obJectToString(v4DeleteRepair));
            LogUtil.e(TAG, obJectToString(v4DeleteRepair));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<SuccessBean> v4BaseBeanPostDeleteRepair = this.mProtocol.postDeleteRepair(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), str);
            if (v4BaseBeanPostDeleteRepair.ok()) {
                return v4BaseBeanPostDeleteRepair.data;
            }
            throw HttpException.filter(v4BaseBeanPostDeleteRepair.code, v4BaseBeanPostDeleteRepair.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4ModeBean getMode(String str) throws HttpException {
        try {
            LogUtil.log("参数：mac:" + str);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4ModeBean> mode = this.mProtocol.getMode(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), str);
            if (mode.ok()) {
                return mode.data;
            }
            throw HttpException.filter(mode.code, mode.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4DeviceInfoBean getDeviceInfoByQrcode(String str) throws HttpException {
        try {
            LogUtil.log("参数：qrcode:" + str);
            LogUtil.e(TAG, "参数：qrcode:" + str);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4DeviceInfoBean> deviceInfoByQrcode = this.mProtocol.getDeviceInfoByQrcode(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), str);
            if (deviceInfoByQrcode.ok() && deviceInfoByQrcode.data != null) {
                return deviceInfoByQrcode.data;
            }
            throw HttpException.filter(deviceInfoByQrcode.code, deviceInfoByQrcode.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4ElecMeterInfoBean getElecMeterInfo(int i) throws HttpException {
        try {
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4ElecMeterInfoBean> elecMeterInfo = this.mProtocol.getElecMeterInfo(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp), V4UserInfoUtil.getInstance().getLoginAccountV4().projectId, i);
            if (elecMeterInfo.ok()) {
                return elecMeterInfo.data;
            }
            throw HttpException.filter(elecMeterInfo.code, elecMeterInfo.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4ElecMeterInfoBean postBindRoom(String str, String str2) throws HttpException {
        try {
            V4BindRoom v4BindRoom = new V4BindRoom();
            v4BindRoom.roomId = str;
            v4BindRoom.cpersonId = str2;
            LogUtil.log("参数：" + obJectToString(v4BindRoom));
            LogUtil.e(TAG, "参数：" + obJectToString(v4BindRoom));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4ElecMeterInfoBean> v4BaseBeanPostBindRoom = this.mProtocol.postBindRoom(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), v4BindRoom);
            if (v4BaseBeanPostBindRoom.ok()) {
                return v4BaseBeanPostBindRoom.data;
            }
            throw HttpException.filter(v4BaseBeanPostBindRoom.code, v4BaseBeanPostBindRoom.getErrMsg(), v4BaseBeanPostBindRoom.data);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4RechargeBean postCreateElecMeterOrderId(int i, String str, String str2, int i2) throws HttpException {
        try {
            V4Recharge v4Recharge = new V4Recharge();
            v4Recharge.payMent = i;
            v4Recharge.amount = str;
            v4Recharge.mac = str2;
            v4Recharge.way = 1;
            LogUtil.log("参数：" + obJectToString(v4Recharge));
            LogUtil.e(TAG, "参数：" + obJectToString(v4Recharge));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4RechargeBean> v4BaseBeanPostCreateElecMeterOrderId = this.mProtocol.postCreateElecMeterOrderId(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), v4Recharge);
            if (v4BaseBeanPostCreateElecMeterOrderId.ok()) {
                return v4BaseBeanPostCreateElecMeterOrderId.data;
            }
            throw HttpException.filter(v4BaseBeanPostCreateElecMeterOrderId.code, v4BaseBeanPostCreateElecMeterOrderId.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4ElecRechargeRecordBean getElecMeterRechargeRecord(int i, String str) throws HttpException {
        try {
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().cpersonId;
            LogUtil.log("参数：pageSize:10pageIndex:" + i + "mac:" + str + "cpersonId:" + str2);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4ElecRechargeRecordBean> elecMeterRechargeRecord = this.mProtocol.getElecMeterRechargeRecord(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), 10, i, str, str2);
            if (elecMeterRechargeRecord != null && elecMeterRechargeRecord.ok() && elecMeterRechargeRecord.data != null) {
                return elecMeterRechargeRecord.data;
            }
            throw HttpException.filter(elecMeterRechargeRecord.code, elecMeterRechargeRecord.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean updateF0(String str, String str2) throws HttpException {
        try {
            V4F0Data v4F0Data = new V4F0Data();
            v4F0Data.dataF0 = str;
            v4F0Data.mac = str2;
            LogUtil.log("参数：" + obJectToString(v4F0Data));
            LogUtil.e(TAG, "参数：" + obJectToString(v4F0Data));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<SuccessBean> v4BaseBeanUpdateF0 = this.mProtocol.updateF0(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), v4F0Data);
            if (v4BaseBeanUpdateF0.ok()) {
                return v4BaseBeanUpdateF0.data;
            }
            throw HttpException.filter(v4BaseBeanUpdateF0.code, v4BaseBeanUpdateF0.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String btRecharge(String str, String str2) throws HttpException {
        try {
            V4BTRecharge v4BTRecharge = new V4BTRecharge();
            v4BTRecharge.deviceRandom = str;
            v4BTRecharge.mac = str2;
            LogUtil.log("参数：" + obJectToString(v4BTRecharge));
            LogUtil.e(TAG, "参数：" + obJectToString(v4BTRecharge));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<String> v4BaseBeanBtRecharge = this.mProtocol.btRecharge(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), v4BTRecharge);
            if (v4BaseBeanBtRecharge.ok()) {
                return v4BaseBeanBtRecharge.data;
            }
            throw HttpException.filter(v4BaseBeanBtRecharge.code, v4BaseBeanBtRecharge.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4RechargeBean netRecharge(String str) throws HttpException {
        try {
            new V4BTRecharge().mac = str;
            LogUtil.log("参数：mac:" + str);
            LogUtil.e(TAG, "参数：" + str);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4RechargeBean> v4BaseBeanNetRecharge = this.mProtocol.netRecharge(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), str);
            if (v4BaseBeanNetRecharge.ok()) {
                return v4BaseBeanNetRecharge.data;
            }
            throw HttpException.filter(v4BaseBeanNetRecharge.code, v4BaseBeanNetRecharge.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String getSchoolQrCode() throws HttpException {
        try {
            LogUtil.log("参数：");
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<String> schoolQrCode = this.mProtocol.getSchoolQrCode(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp));
            if (schoolQrCode.ok()) {
                return schoolQrCode.data;
            }
            throw HttpException.filter(schoolQrCode.code, schoolQrCode.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4DeviceInfoBean getDeviceInfoBySn(String str) throws HttpException {
        try {
            LogUtil.log("参数：eleSn" + str);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4DeviceInfoBean> deviceInfoBySn = this.mProtocol.getDeviceInfoBySn(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), str);
            if (deviceInfoBySn.ok()) {
                return deviceInfoBySn.data;
            }
            throw HttpException.filter(deviceInfoBySn.code, deviceInfoBySn.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4MetersTrendBean getMetersTrend(int i, String str, String str2, String str3) throws HttpException {
        try {
            LogUtil.log("参数：productId:" + i + "mac:" + str + "statisticType:" + str2 + "timeRange:" + str3);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str4 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4MetersTrendBean> metersTrend = this.mProtocol.getMetersTrend(headerTimestamp, str4, V4HeaderUtil.getSign(str4, headerTimestamp), i, str, str2, str3);
            if (metersTrend.ok()) {
                return metersTrend.data;
            }
            throw HttpException.filter(metersTrend.code, metersTrend.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4MeterConsumeDailySummaryBean getMeterConsumeDailySummary(int i, int i2) throws HttpException {
        try {
            LogUtil.log("参数：timeRange:" + i + " productId:" + i2);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4MeterConsumeDailySummaryBean> meterConsumeDailySummary = this.mProtocol.getMeterConsumeDailySummary(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp), i, i2);
            if (meterConsumeDailySummary != null && meterConsumeDailySummary.ok() && meterConsumeDailySummary.data != null) {
                return meterConsumeDailySummary.data;
            }
            throw HttpException.filter(meterConsumeDailySummary.code, meterConsumeDailySummary.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String postOpen(String str, String str2, String str3, String str4, String str5) throws HttpException {
        try {
            OpenPro openPro = new OpenPro();
            openPro.deviceSn = str;
            openPro.deviceRandom = str3;
            openPro.productId = str4;
            openPro.serviceId = str2;
            openPro.hexUserId = str5;
            LogUtil.log("参数：" + obJectToString(openPro));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            V4BaseBean<String> v4BaseBeanPostOpen = this.mProtocol.postOpen(headerTimestamp, "", V4HeaderUtil.getSignAuth("", headerTimestamp), openPro);
            if (v4BaseBeanPostOpen.ok() && v4BaseBeanPostOpen.data != null) {
                return v4BaseBeanPostOpen.data;
            }
            throw HttpException.filter(v4BaseBeanPostOpen.code, v4BaseBeanPostOpen.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<V4SelectAllBean> selectAll() throws HttpException {
        try {
            V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
            String str = loginAccountV4.serviceId;
            String str2 = loginAccountV4.customerId;
            String str3 = loginAccountV4.cpersonId;
            LogUtil.log("参数：customerId:" + str2 + "serviceId:" + str + "cpersonId:" + str3 + "payFlagType:2type:2");
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str4 = loginAccountV4.token;
            V4BaseBean<List<V4SelectAllBean>> v4BaseBeanSelectAll = this.mProtocol.selectAll(headerTimestamp, str4, V4HeaderUtil.getSign(str4, headerTimestamp), str2, str, str3, 2, 2);
            if (v4BaseBeanSelectAll.ok()) {
                return v4BaseBeanSelectAll.data;
            }
            throw HttpException.filter(v4BaseBeanSelectAll.code, v4BaseBeanSelectAll.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4SignBean getSignAContractResult(String str) throws HttpException {
        try {
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().serviceId;
            LogUtil.log("参数：modelType:cloudsaleApiEnterpriseUserQueryparameter:" + str + "serviceId:" + str2);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<V4SignBean> signAContractResult = this.mProtocol.getSignAContractResult(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), "cloudsaleApiEnterpriseUserQuery", str, str2);
            if (signAContractResult.ok()) {
                return signAContractResult.data;
            }
            throw HttpException.filter(signAContractResult.code, signAContractResult.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public Boolean selectIsHasNoPay() throws HttpException {
        try {
            V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
            String str = loginAccountV4.serviceId;
            LogUtil.log("参数：serviceId:" + str);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = loginAccountV4.token;
            V4BaseBean<Boolean> v4BaseBeanSelectIsHasNoPay = this.mProtocol.selectIsHasNoPay(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), str);
            if (v4BaseBeanSelectIsHasNoPay.ok()) {
                return v4BaseBeanSelectIsHasNoPay.data;
            }
            throw HttpException.filter(v4BaseBeanSelectIsHasNoPay.code, v4BaseBeanSelectIsHasNoPay.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<V4BathRecordBean> getNoPayRecord(int i) throws HttpException {
        try {
            String str = V4UserInfoUtil.getInstance().getLoginAccountV4().serviceId;
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            String sign = V4HeaderUtil.getSign(str2, headerTimestamp);
            LogUtil.log("参数：serviceId:" + str + "pay:" + i);
            V4BaseBean<List<V4BathRecordBean>> noPayRecord = this.mProtocol.getNoPayRecord(headerTimestamp, str2, sign, str, i);
            if (noPayRecord != null && noPayRecord.ok() && noPayRecord.data != null) {
                return noPayRecord.data;
            }
            throw HttpException.filter(noPayRecord.code, noPayRecord.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String toPay(List<String> list, int i) throws HttpException {
        try {
            V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
            String str = loginAccountV4.serviceId;
            V4ToPay v4ToPay = new V4ToPay();
            v4ToPay.payMent = i;
            v4ToPay.serviceId = str;
            v4ToPay.orderList = list;
            LogUtil.log("参数：serviceId:" + str + "payMent:" + i + "orderList:" + list.toString());
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = loginAccountV4.token;
            V4BaseBean<String> pay = this.mProtocol.toPay(headerTimestamp, str2, V4HeaderUtil.getSign(str2, headerTimestamp), v4ToPay);
            if (pay.ok()) {
                return pay.data;
            }
            throw HttpException.filter(pay.code, pay.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean updateRoomLeader(int i, String str, int i2) throws HttpException {
        try {
            V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
            String str2 = loginAccountV4.serviceId;
            String str3 = loginAccountV4.customerId;
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str4 = loginAccountV4.token;
            String sign = V4HeaderUtil.getSign(str4, headerTimestamp);
            V4UpdateRoomLeader v4UpdateRoomLeader = new V4UpdateRoomLeader();
            v4UpdateRoomLeader.customerId = str3;
            v4UpdateRoomLeader.serviceId = str2;
            v4UpdateRoomLeader.productId = i;
            v4UpdateRoomLeader.roomId = str;
            v4UpdateRoomLeader.leaderCpersonId = loginAccountV4.cpersonId;
            v4UpdateRoomLeader.operationType = i2;
            V4BaseBean<SuccessBean> v4BaseBeanUpdateRoomLeader = this.mProtocol.updateRoomLeader(headerTimestamp, str4, sign, v4UpdateRoomLeader);
            LogUtil.e("updateRoomLeader", "code=" + v4BaseBeanUpdateRoomLeader.code + " message=" + v4BaseBeanUpdateRoomLeader.message);
            if (v4BaseBeanUpdateRoomLeader.ok()) {
                return v4BaseBeanUpdateRoomLeader.data;
            }
            throw HttpException.filter(v4BaseBeanUpdateRoomLeader.code, v4BaseBeanUpdateRoomLeader.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean cancelRefund(int i, String str) throws HttpException {
        try {
            V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str2 = loginAccountV4.token;
            String sign = V4HeaderUtil.getSign(str2, headerTimestamp);
            V4CancelRefund v4CancelRefund = new V4CancelRefund();
            v4CancelRefund.refundId = i;
            v4CancelRefund.rejectReason = str;
            V4BaseBean<SuccessBean> v4BaseBeanCancelRefund = this.mProtocol.cancelRefund(headerTimestamp, str2, sign, v4CancelRefund);
            if (v4BaseBeanCancelRefund.ok()) {
                return v4BaseBeanCancelRefund.data;
            }
            throw HttpException.filter(v4BaseBeanCancelRefund.code, v4BaseBeanCancelRefund.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4RefundableAmountBean getRefundableAmount(int i, String str) throws HttpException {
        try {
            V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
            String str2 = loginAccountV4.customerId;
            String str3 = loginAccountV4.serviceId;
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str4 = loginAccountV4.token;
            V4BaseBean<V4RefundableAmountBean> refundableAmount = this.mProtocol.getRefundableAmount(headerTimestamp, str4, V4HeaderUtil.getSign(str4, headerTimestamp), str2, str3, i, str);
            if (refundableAmount.ok()) {
                return refundableAmount.data;
            }
            throw HttpException.filter(refundableAmount.code, refundableAmount.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean submitRefundForDevice(int i, String str, String str2, String str3, String str4) throws HttpException {
        try {
            V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
            String str5 = loginAccountV4.customerId;
            String str6 = loginAccountV4.serviceId;
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str7 = loginAccountV4.token;
            String sign = V4HeaderUtil.getSign(str7, headerTimestamp);
            V4DeviceSubmitRefund v4DeviceSubmitRefund = new V4DeviceSubmitRefund();
            v4DeviceSubmitRefund.customerId = str5;
            v4DeviceSubmitRefund.serviceId = str6;
            v4DeviceSubmitRefund.productId = i;
            v4DeviceSubmitRefund.roomId = str;
            v4DeviceSubmitRefund.reason = str2;
            v4DeviceSubmitRefund.alipayAccount = str3;
            v4DeviceSubmitRefund.alipayName = str4;
            V4BaseBean<SuccessBean> v4BaseBeanSubmitRefundForDevice = this.mProtocol.submitRefundForDevice(headerTimestamp, str7, sign, v4DeviceSubmitRefund);
            if (v4BaseBeanSubmitRefundForDevice.ok()) {
                return v4BaseBeanSubmitRefundForDevice.data;
            }
            throw HttpException.filter(v4BaseBeanSubmitRefundForDevice.code, v4BaseBeanSubmitRefundForDevice.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public V4DeviceMeterRefundRecordBean getDeviceMeterRefundRecord(int i, int i2, Integer num) throws HttpException {
        try {
            V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str = loginAccountV4.token;
            V4BaseBean<V4DeviceMeterRefundRecordBean> deviceMeterRefundRecord = this.mProtocol.getDeviceMeterRefundRecord(headerTimestamp, str, V4HeaderUtil.getSign(str, headerTimestamp), i, i2, num);
            if (deviceMeterRefundRecord.ok()) {
                return deviceMeterRefundRecord.data;
            }
            throw HttpException.filter(deviceMeterRefundRecord.code, deviceMeterRefundRecord.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String btReturnToZeroKwh(String str, String str2) throws HttpException {
        try {
            V4BTRecharge v4BTRecharge = new V4BTRecharge();
            v4BTRecharge.deviceRandom = str;
            v4BTRecharge.mac = str2;
            LogUtil.log("参数：" + obJectToString(v4BTRecharge));
            LogUtil.e(TAG, "参数：" + obJectToString(v4BTRecharge));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str3 = V4UserInfoUtil.getInstance().getLoginAccountV4().token;
            V4BaseBean<String> v4BaseBeanBtReturnToZeroKwh = this.mProtocol.btReturnToZeroKwh(headerTimestamp, str3, V4HeaderUtil.getSign(str3, headerTimestamp), v4BTRecharge);
            if (v4BaseBeanBtReturnToZeroKwh.ok()) {
                return v4BaseBeanBtReturnToZeroKwh.data;
            }
            throw HttpException.filter(v4BaseBeanBtReturnToZeroKwh.code, v4BaseBeanBtReturnToZeroKwh.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String toggleDeviceLock(String str, String str2, int i, int i2) throws HttpException {
        try {
            V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
            String str3 = loginAccountV4.customerId;
            String str4 = loginAccountV4.serviceId;
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String str5 = loginAccountV4.token;
            DeviceLock deviceLock = new DeviceLock();
            deviceLock.serviceId = str4;
            deviceLock.customerId = str3;
            deviceLock.roomId = str;
            deviceLock.productId = i;
            deviceLock.action = i2;
            deviceLock.mac = str2;
            LogUtil.log("参数：" + obJectToString(deviceLock));
            LogUtil.e(TAG, "参数：" + obJectToString(deviceLock));
            V4BaseBean<String> v4BaseBean = this.mProtocol.toggleDeviceLock(headerTimestamp, str5, V4HeaderUtil.getSign(str5, headerTimestamp), deviceLock);
            if (v4BaseBean.ok()) {
                return v4BaseBean.data;
            }
            throw HttpException.filter(v4BaseBean.code, v4BaseBean.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    private String obJectToString(Object obj) {
        try {
            return GsonUtils.getInstance().parse(obj);
        } catch (ClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    class V4CombindBean {
        private String returnStr = "";

        V4CombindBean() {
        }

        public V4CombindBean combind(String str, String str2) {
            if (str2 != null && !str2.equals("null")) {
                this.returnStr += (str + "=" + str2 + "&");
            }
            return this;
        }

        public String toString() {
            String str = new String(this.returnStr);
            return str.length() >= 2 ? str.substring(0, str.length() - 1) : str;
        }
    }
}
