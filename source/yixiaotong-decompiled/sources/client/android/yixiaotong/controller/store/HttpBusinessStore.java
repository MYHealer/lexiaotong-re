package client.android.yixiaotong.controller.store;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.account.AppAccountManager;
import client.android.yixiaotong.controller.bean.AliPayBean;
import client.android.yixiaotong.controller.bean.AmmeterAliPayBean;
import client.android.yixiaotong.controller.bean.AmmeterBindingRoom;
import client.android.yixiaotong.controller.bean.AmmeterOrderStateBean;
import client.android.yixiaotong.controller.bean.AmmeterRoomDetail;
import client.android.yixiaotong.controller.bean.AmmeterWeiXinPayBean;
import client.android.yixiaotong.controller.bean.AreasBean;
import client.android.yixiaotong.controller.bean.DeviceInfoBean;
import client.android.yixiaotong.controller.bean.EncrypedBean;
import client.android.yixiaotong.controller.bean.EncryptedWalletModels;
import client.android.yixiaotong.controller.bean.GetDeviceQrCodeBean;
import client.android.yixiaotong.controller.bean.GetMealQrcodeBean;
import client.android.yixiaotong.controller.bean.ManagerBean;
import client.android.yixiaotong.controller.bean.MessageRecordListBean;
import client.android.yixiaotong.controller.bean.NullBean;
import client.android.yixiaotong.controller.bean.OpenDataBean;
import client.android.yixiaotong.controller.bean.RecordListBean;
import client.android.yixiaotong.controller.bean.RefundBean;
import client.android.yixiaotong.controller.bean.RepairProcessListBean;
import client.android.yixiaotong.controller.bean.SoundWaveBean;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.UnionPayBean;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.bean.WeiXinPayBean;
import client.android.yixiaotong.controller.bean.adv.AdvControlListBean;
import client.android.yixiaotong.controller.bean.bath.BathDevicesInfoListBean;
import client.android.yixiaotong.controller.bean.getserveraddress.LoginBefore;
import client.android.yixiaotong.controller.bean.getserveraddress.RegisterBefore;
import client.android.yixiaotong.controller.bean.gonggaolan.Detail;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAllAnnounceListBean;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAnnouncementBean;
import client.android.yixiaotong.controller.bean.hamam.HamamGetRoomInfoBean;
import client.android.yixiaotong.controller.bean.hamam.HamamInitDeviceBean;
import client.android.yixiaotong.controller.bean.hamam.HamamVerifyAuthPasswordSecurity;
import client.android.yixiaotong.controller.bean.init.NBMachineInfo;
import client.android.yixiaotong.controller.bean.pay.ABCPayBean;
import client.android.yixiaotong.controller.bean.recharge.RechargeDetailListBean;
import client.android.yixiaotong.controller.bean.recharge.RechargeInfoBean;
import client.android.yixiaotong.controller.bean.refund.RefundListBean;
import client.android.yixiaotong.controller.bean.report.RepairUploadReportPicsBean;
import client.android.yixiaotong.controller.bean.report.ReportDetailBean;
import client.android.yixiaotong.controller.bean.report.ReportListBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardAliBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardUnionBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardWeiXinPayBean;
import client.android.yixiaotong.controller.bean.set.SetBean;
import client.android.yixiaotong.controller.db.LocalSqliteHelper;
import client.android.yixiaotong.controller.event.MessageFragmentSyncEvent;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.exception.DBException;
import client.android.yixiaotong.exception.HttpException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity;
import client.android.yixiaotong.ui.login.FillInfoActivity;
import client.android.yixiaotong.util.AESHelper;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.Base64;
import client.android.yixiaotong.util.EventBusUtil;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.MD5;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import client.android.yixiaotong.util.http.HttpProtocolFactory;
import client.android.yixiaotong.util.http.bean.BaseBean;
import client.android.yixiaotong.util.http.bean.BaseBeanLow;
import client.android.yixiaotong.util.http.protocol.BusinessHttpProtocol;
import client.android.yixiaotong.v3.util.LogUtil;
import com.google.gson.reflect.TypeToken;
import com.hihonor.adsdk.base.g.j.e.a;
import com.huawei.openalliance.ad.constant.ba;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.opos.acs.st.STManager;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class HttpBusinessStore {
    private static final String TAG = "HttpBusinessStore";
    private Account mAccount;
    private BusinessHttpProtocol mProtocol;

    public HttpBusinessStore(Account account) {
        this.mAccount = account;
    }

    public void getServer() {
        String string = new LocalPreferencesHelper(BaseApplication.app, "localserveraddress").getString("localnetserver");
        if (StringUtils.isNotEmpty(string)) {
            this.mProtocol = (BusinessHttpProtocol) HttpProtocolFactory.getInstance().getProtocol(string, BusinessHttpProtocol.class);
        } else {
            this.mProtocol = (BusinessHttpProtocol) HttpProtocolFactory.getInstance().getProtocol(HttpComfigUtil.SERVER_PRE_HOST, BusinessHttpProtocol.class);
        }
    }

    public void getServerPre() {
        this.mProtocol = (BusinessHttpProtocol) HttpProtocolFactory.getInstance().getProtocol(HttpComfigUtil.SERVER_PRE_HOST, BusinessHttpProtocol.class);
    }

    public void getServerGonggao() {
        this.mProtocol = (BusinessHttpProtocol) HttpProtocolFactory.getInstance().getProtocol(HttpComfigUtil.SERVER_OTHER_HOST, BusinessHttpProtocol.class);
    }

    public void getV3RepairAndAdv() {
        this.mProtocol = (BusinessHttpProtocol) HttpProtocolFactory.getInstance().getProtocol(HttpComfigUtil.SERVER_V3REPAIR_HOST, BusinessHttpProtocol.class);
    }

    public LoginBefore loginBeforeGetServerAddress(String str) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("mobile", str + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<LoginBefore> baseBeanLoginBeforeGetServerAddress = this.mProtocol.loginBeforeGetServerAddress(code, sign);
            if (baseBeanLoginBeforeGetServerAddress.ok()) {
                LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(BaseApplication.app, "localserveraddress");
                if (StringUtils.isNotEmpty(baseBeanLoginBeforeGetServerAddress.Data.netServer)) {
                    localPreferencesHelper.saveOrUpdate("localnetserver", baseBeanLoginBeforeGetServerAddress.Data.netServer);
                }
                if (StringUtils.isNotEmpty(baseBeanLoginBeforeGetServerAddress.Data.javaServer)) {
                    localPreferencesHelper.saveOrUpdate("localjavaserver", baseBeanLoginBeforeGetServerAddress.Data.javaServer);
                }
                return baseBeanLoginBeforeGetServerAddress.Data;
            }
            throw HttpException.filter(baseBeanLoginBeforeGetServerAddress.Code, baseBeanLoginBeforeGetServerAddress.getErrMsg(), baseBeanLoginBeforeGetServerAddress.Data, baseBeanLoginBeforeGetServerAddress.Serial);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean EncryptedLoginToV3(String str) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("account", str + "");
            combindBean.combind("platform", "Android" + AppUtils.getSystemVersion().replace(PPSLabelView.Code, ""));
            LogUtil.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            String code = getCode(combindBean);
            BaseBean<SuccessBean> baseBeanEncryptedLoginToV3 = this.mProtocol.EncryptedLoginToV3(code, getSign(code));
            if (baseBeanEncryptedLoginToV3.ok()) {
                return baseBeanEncryptedLoginToV3.Data;
            }
            throw HttpException.filter(baseBeanEncryptedLoginToV3.Code, baseBeanEncryptedLoginToV3.getErrMsg(), baseBeanEncryptedLoginToV3.Data, baseBeanEncryptedLoginToV3.Serial);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public RegisterBefore registerBeforeGetServerAddress(String str) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<RegisterBefore> baseBeanRegisterBeforeGetServerAddress = this.mProtocol.registerBeforeGetServerAddress(code, sign);
            if (baseBeanRegisterBeforeGetServerAddress.ok()) {
                LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(BaseApplication.app, "localserveraddress");
                if (StringUtils.isNotEmpty(baseBeanRegisterBeforeGetServerAddress.Data.netServer)) {
                    localPreferencesHelper.saveOrUpdate("localnetserver", baseBeanRegisterBeforeGetServerAddress.Data.netServer);
                }
                if (StringUtils.isNotEmpty(baseBeanRegisterBeforeGetServerAddress.Data.javaServer)) {
                    localPreferencesHelper.saveOrUpdate("localjavaserver", baseBeanRegisterBeforeGetServerAddress.Data.javaServer);
                }
                return baseBeanRegisterBeforeGetServerAddress.Data;
            }
            throw HttpException.filter(baseBeanRegisterBeforeGetServerAddress.Code, baseBeanRegisterBeforeGetServerAddress.getErrMsg(), baseBeanRegisterBeforeGetServerAddress.Data, baseBeanRegisterBeforeGetServerAddress.Serial);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public UserInfoBean login(String str, String str2, boolean z) throws HttpException {
        try {
            String randNumMaxString = RandomUtil.getRandNumMaxString(6);
            String uuid = AppUtils.getUuid(0L);
            CombindBean combindBean = new CombindBean();
            combindBean.combind("account", str + "");
            combindBean.combind("password", str2 + "");
            combindBean.combind("platform", "Android" + AppUtils.getSystemVersion().replace(PPSLabelView.Code, ""));
            combindBean.combind("version", AppUtils.getVersion(BaseApplication.app) + "");
            combindBean.combind("deviceId", uuid + "");
            combindBean.combind("relogin", z + "");
            combindBean.combind("mobileVersion", AppUtils.getSystemModel().replace(PPSLabelView.Code, ""));
            combindBean.combind("random", randNumMaxString);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<EncrypedBean> baseBeanLoginEncryped = this.mProtocol.loginEncryped(code, sign);
            if (baseBeanLoginEncryped.ok()) {
                String strDecryptData = decryptData(baseBeanLoginEncryped.Data.data);
                LogUtil.e(TAG, strDecryptData);
                LogUtil.log(strDecryptData);
                try {
                    UserInfoBean userInfoBean = (UserInfoBean) GsonUtils.getInstance().parse(new TypeToken<UserInfoBean>() { // from class: client.android.yixiaotong.controller.store.HttpBusinessStore.1
                    }.getType(), strDecryptData);
                    if (userInfoBean != null && !StringUtils.isEmpty(userInfoBean.random) && randNumMaxString.equals(userInfoBean.random)) {
                        Account account = new Account(userInfoBean.ID);
                        account.setUid(userInfoBean.ID);
                        account.setUserName(str);
                        account.setPassword(str2);
                        account.setIdentityId(userInfoBean.IdentityId);
                        AccountManager.getInstance().saveLoginAccount(account);
                        account.getAccountManagetStore().saveUserInfo(userInfoBean);
                        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(BaseApplication.app, "phone_run_time");
                        localPreferencesHelper.saveOrUpdate("phoneRunTime", SystemClock.elapsedRealtime() / 1000);
                        localPreferencesHelper.saveOrUpdate("loginTime", Long.parseLong(baseBeanLoginEncryped.Serial));
                        return userInfoBean;
                    }
                } catch (ClientException unused) {
                }
                return null;
            }
            throw HttpException.filter(baseBeanLoginEncryped.Code, baseBeanLoginEncryped.getErrMsg(), baseBeanLoginEncryped.Data, baseBeanLoginEncryped.Serial);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public UserInfoBean register(String str, String str2, String str3, String str4, String str5, int i, String str6, long j, String str7, String str8, String str9, String str10, String str11) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("account", str).combind("loginPassword", str2).combind("paymentPassword", str3).combind("studentName", str4).combind("studentNo", str5).combind("genderId", i + "").combind("areaId", j + "").combind("mobile", str7 + "").combind("identityId", str8).combind(a.G0, str9).combind("captchaCode", str10 + "").combind("platform", "Android").combind("deviceId", AppUtils.getUuid(0L)).combind("version", AppUtils.getVersion(BaseApplication.app)).combind("IsScan", "1").combind("authorizedPassword", str11);
            String code = getCode(combindBean);
            String sign = getSign(code);
            String strEncodeToString = StringUtils.isNotEmpty(str6) ? Base64.encodeToString(IOUtils.toByteArray(new FileInputStream(new File(str6))), 0) : "";
            LogUtil.log(combindBean.toString());
            BaseBean<UserInfoBean> baseBeanNewRegister = this.mProtocol.newRegister(code, sign, strEncodeToString);
            if (baseBeanNewRegister.ok()) {
                Account account = new Account(baseBeanNewRegister.Data.ID);
                account.setUid(baseBeanNewRegister.Data.ID);
                account.setUserName(str);
                account.setPassword(str2);
                AccountManager.getInstance().saveLoginAccount(account);
                account.getAccountManagetStore().saveUserInfo(baseBeanNewRegister.Data);
                return baseBeanNewRegister.Data;
            }
            throw HttpException.filter(baseBeanNewRegister.Code, baseBeanNewRegister.getErrMsg(), baseBeanNewRegister.Data, baseBeanNewRegister.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<AreasBean> getSchoolList() throws DBException, HttpException {
        try {
            String code = getCode(new CombindBean());
            BaseBean<List<AreasBean>> schoolList = this.mProtocol.getSchoolList(code, getSign(code));
            if (schoolList.ok()) {
                return schoolList.Data;
            }
            throw HttpException.filter(schoolList.Code, schoolList.getErrMsg(), schoolList.Data, schoolList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DeviceInfoBean getDeviceInfo(String str, long j, long j2, String str2) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "");
            if (TextUtils.isEmpty(str2)) {
                combindBean.combind("Id", j2 + "");
            } else {
                combindBean.combind("deviceId", str2);
            }
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<DeviceInfoBean> deviceInfo = this.mProtocol.getDeviceInfo(code, sign, str);
            if (deviceInfo.ok()) {
                LocalBusinessStore.saveTodayDate(BaseApplication.app, deviceInfo.Serial);
                LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(BaseApplication.app, "phone_run_time");
                localPreferencesHelper.saveOrUpdate("phoneRunTime", SystemClock.elapsedRealtime() / 1000);
                localPreferencesHelper.saveOrUpdate("loginTime", Long.parseLong(deviceInfo.Serial));
                return deviceInfo.Data;
            }
            throw HttpException.filter(deviceInfo.Code, deviceInfo.getErrMsg(), deviceInfo.Data, deviceInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DeviceInfoBean getSmpDeviceInfo(String str, long j, String str2) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "");
            combindBean.combind("deviceId", str2);
            String code = getCode(combindBean);
            String sign = getSign(code);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<DeviceInfoBean> smpDeviceInfo = this.mProtocol.getSmpDeviceInfo(code, sign, str);
            if (smpDeviceInfo.ok()) {
                return smpDeviceInfo.Data;
            }
            throw HttpException.filter(smpDeviceInfo.Code, smpDeviceInfo.getErrMsg(), smpDeviceInfo.Data, smpDeviceInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean updateConsumptionTimes(String str, long j, long j2, int i) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "");
            combindBean.combind("applicationId", j2 + "");
            combindBean.combind("consumptionTimes", i + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanUpdateConsumptionTimes = this.mProtocol.updateConsumptionTimes(code, sign, str);
            if (baseBeanUpdateConsumptionTimes.ok()) {
                return baseBeanUpdateConsumptionTimes.Data;
            }
            throw HttpException.filter(baseBeanUpdateConsumptionTimes.Code, baseBeanUpdateConsumptionTimes.getErrMsg(), baseBeanUpdateConsumptionTimes.Data, baseBeanUpdateConsumptionTimes.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public GetMealQrcodeBean getMealQrCode(String str, long j, long j2) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "");
            combindBean.combind("applicationId", j2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<GetMealQrcodeBean> mealQrCode = this.mProtocol.getMealQrCode(code, sign, str);
            if (mealQrCode.ok()) {
                mealQrCode.Data.time = mealQrCode.Serial;
                return mealQrCode.Data;
            }
            throw HttpException.filter(mealQrCode.Code, mealQrCode.getErrMsg(), mealQrCode.Data, mealQrCode.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public UserInfoBean getStudentInfo(String str, long j) throws HttpException {
        try {
            String randNumMaxString = RandomUtil.getRandNumMaxString(6);
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "");
            combindBean.combind("random", randNumMaxString);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<EncrypedBean> encryptedStudentInfo = this.mProtocol.getEncryptedStudentInfo(code, sign, str);
            if (encryptedStudentInfo.ok()) {
                if (StringUtils.isNotEmpty(encryptedStudentInfo.Data.data)) {
                    String strDecryptData = decryptData(encryptedStudentInfo.Data.data);
                    Log.e(TAG, strDecryptData);
                    LogUtil.log(strDecryptData);
                    UserInfoBean userInfoBean = (UserInfoBean) GsonUtils.getInstance().parse(new TypeToken<UserInfoBean>() { // from class: client.android.yixiaotong.controller.store.HttpBusinessStore.2
                    }.getType(), strDecryptData);
                    if (userInfoBean != null && !StringUtils.isEmpty(userInfoBean.random) && randNumMaxString.equals(userInfoBean.random)) {
                        UserInfoBean userInfo = this.mAccount.getAccountManagetStore().getUserInfo();
                        userInfo.StudentName = userInfoBean.StudentName;
                        userInfo.GenderId = userInfoBean.GenderId;
                        userInfo.StudentNo = userInfoBean.StudentNo;
                        userInfo.IdentityId = userInfoBean.IdentityId;
                        userInfo.Mobile = userInfoBean.Mobile;
                        this.mAccount.getAccountManagetStore().updateUserInfo(userInfo);
                        return userInfoBean;
                    }
                }
                return null;
            }
            throw HttpException.filter(encryptedStudentInfo.Code, encryptedStudentInfo.getErrMsg(), encryptedStudentInfo.Data, encryptedStudentInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public GetDeviceQrCodeBean initDeviceInfo(String str, String str2, int i, long j, long j2, String str3, String str4, String str5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("deviceId", str2).combind("typeId", i + "").combind("investorId", j + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j2 + "").combind(a.G0, str3).combind("blueToothMac", str4).combind("deviceName", str5);
            String code = getCode(combindBean);
            String sign = getSign(code);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<GetDeviceQrCodeBean> baseBeanInitDevice = this.mProtocol.initDevice(code, sign, str);
            if (baseBeanInitDevice.ok()) {
                return baseBeanInitDevice.Data;
            }
            throw HttpException.filter(baseBeanInitDevice.Code, baseBeanInitDevice.getErrMsg(), baseBeanInitDevice.Data, baseBeanInitDevice.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public NullBean updateStudentInfo(String str, long j, String str2, String str3, int i, String str4, long j2, String str5, String str6, String str7) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("studentName", str2).combind("studentNo", str3).combind("genderId", i + "").combind(x.cL, str4).combind("areaId", j2 + "").combind("identityId", str6).combind(a.G0, str7).combind("telephone", str5);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<NullBean> baseBeanUpdateStudentInfo = this.mProtocol.updateStudentInfo(code, sign, str);
            if (baseBeanUpdateStudentInfo.ok()) {
                this.mAccount.getHttpBusinessStore().getStudentInfo(str, j);
                return baseBeanUpdateStudentInfo.Data;
            }
            throw HttpException.filter(baseBeanUpdateStudentInfo.Code, baseBeanUpdateStudentInfo.getErrMsg(), baseBeanUpdateStudentInfo.Data, baseBeanUpdateStudentInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean resetLoginPassword(String str, String str2, String str3) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("account", str + "").combind("mobile", str).combind("newPassword", str2).combind("captchaCode", str3);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanResetLoginPassword = this.mProtocol.resetLoginPassword(code, sign);
            if (baseBeanResetLoginPassword.ok()) {
                return baseBeanResetLoginPassword.Data;
            }
            throw HttpException.filter(baseBeanResetLoginPassword.Code, baseBeanResetLoginPassword.getErrMsg(), baseBeanResetLoginPassword.Data, baseBeanResetLoginPassword.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean modifyLoginPassword(String str, String str2, String str3, String str4, String str5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("account", str2).combind("originalPassword", str3).combind("newPassword", str4).combind("captchaCode", str5);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanModifyLoginPassword = this.mProtocol.modifyLoginPassword(code, sign, str);
            if (baseBeanModifyLoginPassword.ok()) {
                return baseBeanModifyLoginPassword.Data;
            }
            throw HttpException.filter(baseBeanModifyLoginPassword.Code, baseBeanModifyLoginPassword.getErrMsg(), baseBeanModifyLoginPassword.Data, baseBeanModifyLoginPassword.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean modifyPayPassword(String str, long j, String str2, String str3, String str4) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("originalPassword", str2).combind("newPassword", str3).combind("originalCaptchaId", str4);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanModifyPayPassword = this.mProtocol.modifyPayPassword(code, sign, str);
            if (baseBeanModifyPayPassword.ok()) {
                return baseBeanModifyPayPassword.Data;
            }
            throw HttpException.filter(baseBeanModifyPayPassword.Code, baseBeanModifyPayPassword.getErrMsg(), baseBeanModifyPayPassword.Data, baseBeanModifyPayPassword.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<WalletModel> sycnWallets(String str, long j, long j2) throws DBException, HttpException {
        try {
            String randNumMaxString = RandomUtil.getRandNumMaxString(6);
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "");
            combindBean.combind("random", randNumMaxString);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<EncrypedBean> encryptedAllApplication = this.mProtocol.getEncryptedAllApplication(code, sign, str);
            if (encryptedAllApplication.ok()) {
                if (!StringUtils.isNotEmpty(encryptedAllApplication.Data.data)) {
                    return null;
                }
                String strDecryptData = decryptData(encryptedAllApplication.Data.data);
                LogUtil.e(TAG, strDecryptData);
                LogUtil.log(strDecryptData);
                List string2List = GsonUtils.getInstance().parseString2List(strDecryptData, EncryptedWalletModels.class);
                LocalSqliteHelper localSqliteHelper = new LocalSqliteHelper(this.mAccount.getUuid());
                ArrayList arrayList = new ArrayList();
                LocalBusinessStore.saveTodayDate(BaseApplication.app, encryptedAllApplication.Serial);
                if (string2List != null) {
                    for (int i = 0; i < string2List.size(); i++) {
                        EncryptedWalletModels encryptedWalletModels = (EncryptedWalletModels) string2List.get(i);
                        if (!StringUtils.isEmpty(encryptedWalletModels.random) && encryptedWalletModels.random.equals(randNumMaxString)) {
                            if (encryptedWalletModels.TypeId == 1 || encryptedWalletModels.TypeId == 3 || encryptedWalletModels.TypeId == 7 || encryptedWalletModels.TypeId == 6 || encryptedWalletModels.TypeId == 8 || encryptedWalletModels.TypeId == 9 || encryptedWalletModels.TypeId == 11 || encryptedWalletModels.TypeId == 5 || encryptedWalletModels.TypeId == 16 || encryptedWalletModels.TypeId == 17) {
                                WalletModel walletModel = new WalletModel();
                                walletModel.name = encryptedWalletModels.AppName;
                                walletModel.subApp = GsonUtils.getInstance().parse(encryptedWalletModels.SubApp);
                                walletModel.payType = encryptedWalletModels.PayType;
                                walletModel.typeId = encryptedWalletModels.TypeId;
                                walletModel.ID = encryptedWalletModels.ID;
                                walletModel.max = (int) (encryptedWalletModels.MaxDeductPrice * 100.0f);
                                walletModel.icon = encryptedWalletModels.Icon;
                                walletModel.refund = encryptedWalletModels.Refund;
                                walletModel.weiXinCharge = encryptedWalletModels.WeiXinCharge ? 1 : 0;
                                walletModel.aliCharge = encryptedWalletModels.AliCharge ? 1 : 0;
                                walletModel.unionCharge = encryptedWalletModels.UnionCharge ? 1 : 0;
                                walletModel.ABCCharge = encryptedWalletModels.ABCCharge ? 1 : 0;
                                walletModel.IsUseCard = encryptedWalletModels.IsUseCard;
                                walletModel.IsRefund = encryptedWalletModels.IsRefund;
                                walletModel.WeiXinRefund = encryptedWalletModels.WeiXinRefund ? 1 : 0;
                                walletModel.AliRefund = encryptedWalletModels.AliRefund ? 1 : 0;
                                walletModel.wxAppid = encryptedWalletModels.wxAppid;
                                walletModel.wxGhId = encryptedWalletModels.wxGhId;
                                walletModel.WeiXinRefundAppId = encryptedWalletModels.WeiXinRefundAppId;
                                walletModel.WeiXinRefundSecret = encryptedWalletModels.WeiXinRefundSecret;
                                walletModel.serviceMobile = encryptedWalletModels.serviceMobile;
                                arrayList.add(walletModel);
                            } else if (j2 == 25057 && encryptedWalletModels.TypeId == 15) {
                                WalletModel walletModel2 = new WalletModel();
                                walletModel2.name = encryptedWalletModels.AppName;
                                walletModel2.subApp = GsonUtils.getInstance().parse(encryptedWalletModels.SubApp);
                                walletModel2.payType = encryptedWalletModels.PayType;
                                walletModel2.typeId = encryptedWalletModels.TypeId;
                                walletModel2.ID = encryptedWalletModels.ID;
                                walletModel2.max = (int) (encryptedWalletModels.MaxDeductPrice * 100.0f);
                                walletModel2.icon = encryptedWalletModels.Icon;
                                walletModel2.refund = encryptedWalletModels.Refund;
                                walletModel2.IsUseCard = encryptedWalletModels.IsUseCard;
                                walletModel2.IsRefund = encryptedWalletModels.IsRefund;
                                walletModel2.WeiXinRefund = encryptedWalletModels.WeiXinRefund ? 1 : 0;
                                walletModel2.AliRefund = encryptedWalletModels.AliRefund ? 1 : 0;
                                walletModel2.wxAppid = encryptedWalletModels.wxAppid;
                                walletModel2.wxGhId = encryptedWalletModels.wxGhId;
                                walletModel2.WeiXinRefundAppId = encryptedWalletModels.WeiXinRefundAppId;
                                walletModel2.WeiXinRefundSecret = encryptedWalletModels.WeiXinRefundSecret;
                                walletModel2.serviceMobile = encryptedWalletModels.serviceMobile;
                                arrayList.add(walletModel2);
                            }
                        }
                        return null;
                    }
                    if (StringUtils.isNotEmpty(encryptedAllApplication.Serial)) {
                        LocalBusinessStore.saveGetWalletTime(BaseApplication.app, Long.parseLong(encryptedAllApplication.Serial));
                    }
                    this.mAccount.getLocalBusinessStore().clearAndSaveWallet(localSqliteHelper, arrayList);
                }
                return arrayList;
            }
            throw HttpException.filter(encryptedAllApplication.Code, encryptedAllApplication.getErrMsg(), encryptedAllApplication.Data, encryptedAllApplication.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean sendSMSCaptcha(String str, int i, Long l) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("mobile", str + "").combind("typeId", i + "").combind("studentId", l + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanSendSMSCaptcha = this.mProtocol.sendSMSCaptcha(code, sign);
            if (baseBeanSendSMSCaptcha.ok()) {
                return baseBeanSendSMSCaptcha.Data;
            }
            throw HttpException.filter(baseBeanSendSMSCaptcha.Code, baseBeanSendSMSCaptcha.Message, baseBeanSendSMSCaptcha.Data, baseBeanSendSMSCaptcha.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean verifySMSCaptcha(String str, String str2, int i) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("mobile", str + "").combind("captchaCode", str2 + "").combind("typeId", i + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanVerifySMSCaptcha = this.mProtocol.verifySMSCaptcha(code, sign);
            if (baseBeanVerifySMSCaptcha.ok()) {
                return baseBeanVerifySMSCaptcha.Data;
            }
            throw HttpException.filter(baseBeanVerifySMSCaptcha.Code, baseBeanVerifySMSCaptcha.Message, baseBeanVerifySMSCaptcha.Data, baseBeanVerifySMSCaptcha.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public FileUploadBean uploadImage(Long l, String str, int i, String str2) throws HttpException {
        try {
            new File(str);
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", l + "").combind("fileName", "1.png").combind("type", i + "");
            String code = getCode(combindBean);
            BaseBean<FileUploadBean> baseBeanUploadImage = this.mProtocol.uploadImage(code, getSign(code), str2);
            if (baseBeanUploadImage.ok()) {
                FileUploadBean fileUploadBean = baseBeanUploadImage.Data;
                UserInfoBean userInfo = this.mAccount.getAccountManagetStore().getUserInfo();
                userInfo.Icon = baseBeanUploadImage.Data.url;
                this.mAccount.getAccountManagetStore().updateUserInfo(userInfo);
                return fileUploadBean;
            }
            throw HttpException.filter(baseBeanUploadImage.Code, baseBeanUploadImage.getErrMsg(), baseBeanUploadImage.Data, baseBeanUploadImage.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean refund(String str, long j, String str2, long j2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "");
            combindBean.combind("mobile", str2 + "");
            combindBean.combind("typeId", j2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanRefund = this.mProtocol.refund(code, sign, str);
            if (baseBeanRefund.ok()) {
                return baseBeanRefund.Data;
            }
            throw HttpException.filter(baseBeanRefund.Code, baseBeanRefund.Message, baseBeanRefund.Data, baseBeanRefund.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean refund1(String str, long j, String str2, long j2, int i, String str3) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "");
            combindBean.combind("mobile", str2 + "");
            combindBean.combind("typeId", j2 + "");
            combindBean.combind("payType", i + "");
            combindBean.combind("payStr", str3 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanRefund = this.mProtocol.refund(code, sign, str);
            if (baseBeanRefund.ok()) {
                return baseBeanRefund.Data;
            }
            throw HttpException.filter(baseBeanRefund.Code, baseBeanRefund.Message, baseBeanRefund.Data, baseBeanRefund.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean refund2(String str, long j, String str2, long j2, int i, String str3, long j3, String str4, String str5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "");
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, j3 + "");
            combindBean.combind("mobile", str2 + "");
            combindBean.combind("typeId", j2 + "");
            combindBean.combind("payType", i + "");
            combindBean.combind("payStr", str3 + "");
            combindBean.combind("client", "1");
            combindBean.combind("wxOpenId", str4 + "");
            combindBean.combind("refundName", str5);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanRefund2 = this.mProtocol.refund2(code, sign, str);
            if (baseBeanRefund2.ok()) {
                return baseBeanRefund2.Data;
            }
            throw HttpException.filter(baseBeanRefund2.Code, baseBeanRefund2.Message, baseBeanRefund2.Data, baseBeanRefund2.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public RefundBean getRefundProgress(String str, long j, int i) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("investorType", i + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<List<RefundBean>> refundProgress = this.mProtocol.getRefundProgress(code, sign, str);
            if (refundProgress.ok()) {
                if (refundProgress.Data != null) {
                    return refundProgress.Data.get(0);
                }
                return null;
            }
            throw HttpException.filter(refundProgress.Code, refundProgress.getErrMsg(), refundProgress.Data, refundProgress.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean uploadBillConsume(String str, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("billList", str2);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanUploadBillConsume = this.mProtocol.uploadBillConsume(code, sign, str);
            if (baseBeanUploadBillConsume.ok() && baseBeanUploadBillConsume.Data != null && baseBeanUploadBillConsume.Data.success == 1) {
                return baseBeanUploadBillConsume.Data;
            }
            throw HttpException.filter(baseBeanUploadBillConsume.Code, baseBeanUploadBillConsume.Message, baseBeanUploadBillConsume.Data, baseBeanUploadBillConsume.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public RecordListBean getConsumeDetailList(String str, int i, String str2, long j, int i2, int i3) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            if (i <= 0) {
                combindBean.combind("month", str2 + "").combind("studentId", j + "").combind("pageIndex", i2 + "").combind("pageSize", i3 + "");
            } else {
                combindBean.combind("month", str2 + "").combind("studentId", j + "").combind("pageIndex", i2 + "").combind("pageSize", i3 + "").combind("typeId", i + "");
            }
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<RecordListBean> baseBeanGetNewConsumeDetailList = this.mProtocol.GetNewConsumeDetailList(code, sign, str);
            if (baseBeanGetNewConsumeDetailList.ok()) {
                return baseBeanGetNewConsumeDetailList.Data;
            }
            throw HttpException.filter(baseBeanGetNewConsumeDetailList.Code, baseBeanGetNewConsumeDetailList.getErrMsg(), baseBeanGetNewConsumeDetailList.Data, baseBeanGetNewConsumeDetailList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public OpenDataBean uploadBillConsume2(String str, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("billList", str2);
            String code = getCode(combindBean);
            String sign = getSign(code);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<OpenDataBean> baseBeanUploadBillConsume2 = this.mProtocol.uploadBillConsume2(code, sign, str);
            if (baseBeanUploadBillConsume2.ok() && baseBeanUploadBillConsume2.Data != null && baseBeanUploadBillConsume2.Data.success == 1) {
                return baseBeanUploadBillConsume2.Data;
            }
            throw HttpException.filter(baseBeanUploadBillConsume2.Code, baseBeanUploadBillConsume2.Message, baseBeanUploadBillConsume2.Data, baseBeanUploadBillConsume2.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public GetDeviceQrCodeBean initDeviceInfoNew(String str, String str2, int i, long j, long j2, String str3, String str4, String str5, String str6, String str7) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("deviceId", str2).combind("typeId", i + "").combind("investorId", j + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j2 + "").combind(a.G0, str3).combind("blueToothMac", str4).combind("deviceName", str5).combind("roomId", str6);
            if (StringUtils.isNotEmpty(str7)) {
                combindBean.combind("originNumber", str7);
            }
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<GetDeviceQrCodeBean> baseBeanInitDeviceNew = this.mProtocol.initDeviceNew(code, sign, str);
            if (baseBeanInitDeviceNew.ok()) {
                return baseBeanInitDeviceNew.Data;
            }
            throw HttpException.filter(baseBeanInitDeviceNew.Code, baseBeanInitDeviceNew.getErrMsg(), baseBeanInitDeviceNew.Data, baseBeanInitDeviceNew.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DeviceInfoBean getNewDeviceInfo(String str, long j, String str2, long j2, long j3, int i) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            if (i == 1) {
                combindBean.combind("deviceId", str2).combind("studentId", j + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j3 + "");
            } else {
                combindBean.combind("deviceId", str2).combind("studentId", j + "").combind("roomId", j2 + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j3 + "");
            }
            String code = getCode(combindBean);
            String sign = getSign(code);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<DeviceInfoBean> newDeviceInfo = this.mProtocol.getNewDeviceInfo(code, sign, str);
            if (newDeviceInfo.ok()) {
                return newDeviceInfo.Data;
            }
            throw HttpException.filter(newDeviceInfo.Code, newDeviceInfo.getErrMsg(), newDeviceInfo.Data, newDeviceInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean UploadEqStatus(String str, String str2, String str3, long j) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("deviceId", str2).combind("Status", str3).combind("timeStamp", j + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanUploadEqStatus = this.mProtocol.uploadEqStatus(code, sign, str);
            if (baseBeanUploadEqStatus.ok()) {
                return baseBeanUploadEqStatus.Data;
            }
            throw HttpException.filter(baseBeanUploadEqStatus.Code, baseBeanUploadEqStatus.getErrMsg(), baseBeanUploadEqStatus.Data, baseBeanUploadEqStatus.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterBindingRoom ammeterIsBindRoom(String str, String str2, String str3, String str4) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("typeId", str2 + "").combind("studentId", str3 + "").combind(FillInfoActivity.EXTRA_SCHOOLID, str4 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterBindingRoom> baseBeanAmmeterIsBindRoom = this.mProtocol.ammeterIsBindRoom(code, sign, str);
            if (baseBeanAmmeterIsBindRoom.ok() && baseBeanAmmeterIsBindRoom.Data != null && baseBeanAmmeterIsBindRoom.Data.success == 1) {
                return baseBeanAmmeterIsBindRoom.Data;
            }
            throw HttpException.filter(baseBeanAmmeterIsBindRoom.Code, baseBeanAmmeterIsBindRoom.getErrMsg(), baseBeanAmmeterIsBindRoom.Data, baseBeanAmmeterIsBindRoom.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public RepairProcessListBean GetRepairProcessList(String str, long j) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("reportId", j + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<RepairProcessListBean> repairProcessList = this.mProtocol.getRepairProcessList(code, sign, str);
            if (repairProcessList.ok()) {
                return repairProcessList.Data;
            }
            throw HttpException.filter(repairProcessList.Code, repairProcessList.getErrMsg(), repairProcessList.Data, repairProcessList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean UploadReportProcess(String str, long j, long j2, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "");
            combindBean.combind("reportId", j2 + "");
            combindBean.combind("content", str2);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanUploadReportProcess = this.mProtocol.uploadReportProcess(code, sign, str);
            if (baseBeanUploadReportProcess.ok()) {
                return baseBeanUploadReportProcess.Data;
            }
            throw HttpException.filter(baseBeanUploadReportProcess.Code, baseBeanUploadReportProcess.getErrMsg(), baseBeanUploadReportProcess.Data, baseBeanUploadReportProcess.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WeiXinPayBean WeiXinPay(String str, long j, int i, long j2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("deviceType", "1").combind("applicationId", j2 + "").combind("totalPrice", i + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<WeiXinPayBean> baseBeanWeiXinPay = this.mProtocol.WeiXinPay(code, sign, str);
            if (baseBeanWeiXinPay.ok()) {
                EventBusUtil.getInstance().getCommonEventBus().post(new MessageFragmentSyncEvent());
                return baseBeanWeiXinPay.Data;
            }
            throw HttpException.filter(baseBeanWeiXinPay.Code, baseBeanWeiXinPay.getErrMsg(), baseBeanWeiXinPay.Data, baseBeanWeiXinPay.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AliPayBean AliPay(String str, long j, int i, long j2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("deviceType", "1").combind("applicationId", j2 + "").combind("totalPrice", i + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AliPayBean> baseBeanAliPay = this.mProtocol.AliPay(code, sign, str);
            if (baseBeanAliPay.ok()) {
                EventBusUtil.getInstance().getCommonEventBus().post(new MessageFragmentSyncEvent());
                return baseBeanAliPay.Data;
            }
            throw HttpException.filter(baseBeanAliPay.Code, baseBeanAliPay.getErrMsg(), baseBeanAliPay.Data, baseBeanAliPay.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public UnionPayBean UnionPay(String str, long j, int i, long j2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("deviceType", "1").combind("applicationId", j2 + "").combind("totalPrice", i + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<UnionPayBean> baseBeanUnionPay = this.mProtocol.UnionPay(code, sign, str);
            if (baseBeanUnionPay.ok()) {
                EventBusUtil.getInstance().getCommonEventBus().post(new MessageFragmentSyncEvent());
                return baseBeanUnionPay.Data;
            }
            throw HttpException.filter(baseBeanUnionPay.Code, baseBeanUnionPay.getErrMsg(), baseBeanUnionPay.Data, baseBeanUnionPay.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public ABCPayBean ABCPay(String str, long j, String str2, long j2, int i, int i2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, j + "").combind("studentId", j2 + "").combind("client", "1").combind("typeId", i2 + "").combind("totalPrice", i + "").combind("mobile", str2);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<ABCPayBean> baseBeanABCPay = this.mProtocol.ABCPay(code, sign, str);
            if (baseBeanABCPay.ok()) {
                return baseBeanABCPay.Data;
            }
            throw HttpException.filter(baseBeanABCPay.Code, baseBeanABCPay.getErrMsg(), baseBeanABCPay.Data, baseBeanABCPay.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SoundWaveBean SoundWave(String str, long j, String str2, String str3, int i, String str4, String str5, String str6, String str7, int i2, int i3, int i4, int i5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("machineId", str2 + "").combind(AmmeterWalletDetailActivity.EXTRA_ORDERID, str3 + "").combind("managerflag", i + "").combind("machineInfo", str4 + "").combind("machinetime", str5 + "").combind("machineData", str6 + "").combind("randomData", str7 + "").combind(RechargeRecordActivity.EXTRA_TYPEID, i2 + "").combind("cardtype", i3 + "").combind("alleywaytype", i4 + "").combind("version", i5 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SoundWaveBean> soundWave = this.mProtocol.getSoundWave(code, sign, str);
            if (soundWave.ok()) {
                return soundWave.Data;
            }
            throw HttpException.filter(soundWave.Code, soundWave.getErrMsg(), soundWave.Data, soundWave.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterBindingRoom ammeterBindingRoom(String str, long j, long j2) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("RoomID", j2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterBindingRoom> baseBeanAmmeterBindingRoom = this.mProtocol.ammeterBindingRoom(code, sign, str);
            if (baseBeanAmmeterBindingRoom.ok()) {
                return baseBeanAmmeterBindingRoom.Data;
            }
            throw HttpException.filter(baseBeanAmmeterBindingRoom.Code, baseBeanAmmeterBindingRoom.getErrMsg(), baseBeanAmmeterBindingRoom.Data, baseBeanAmmeterBindingRoom.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterBindingRoom ammeterBindingRoom(String str, long j, long j2, int i, int i2) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("roomID", j2 + "").combind("typeId", i + "").combind(FillInfoActivity.EXTRA_SCHOOLID, i2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterBindingRoom> baseBeanAmmeterNewBindingRoom = this.mProtocol.ammeterNewBindingRoom(code, sign, str);
            if (baseBeanAmmeterNewBindingRoom.ok()) {
                return baseBeanAmmeterNewBindingRoom.Data;
            }
            throw HttpException.filter(baseBeanAmmeterNewBindingRoom.Code, baseBeanAmmeterNewBindingRoom.getErrMsg(), baseBeanAmmeterNewBindingRoom.Data, baseBeanAmmeterNewBindingRoom.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterBindingRoom ammeterUnBindingRoom(String str, long j) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentID", j + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterBindingRoom> baseBeanAmmeterUnBindingRoom = this.mProtocol.ammeterUnBindingRoom(code, sign, str);
            if (baseBeanAmmeterUnBindingRoom.ok()) {
                return baseBeanAmmeterUnBindingRoom.Data;
            }
            throw HttpException.filter(baseBeanAmmeterUnBindingRoom.Code, baseBeanAmmeterUnBindingRoom.getErrMsg(), baseBeanAmmeterUnBindingRoom.Data, baseBeanAmmeterUnBindingRoom.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterBindingRoom ammeterUnBindingRoom(String str, long j, int i, int i2) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentID", j + "");
            combindBean.combind("typeId", i + "");
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, i2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterBindingRoom> baseBeanAmmeterUnBindingRoomNew = this.mProtocol.ammeterUnBindingRoomNew(code, sign, str);
            if (baseBeanAmmeterUnBindingRoomNew.ok()) {
                return baseBeanAmmeterUnBindingRoomNew.Data;
            }
            throw HttpException.filter(baseBeanAmmeterUnBindingRoomNew.Code, baseBeanAmmeterUnBindingRoomNew.getErrMsg(), baseBeanAmmeterUnBindingRoomNew.Data, baseBeanAmmeterUnBindingRoomNew.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterRoomDetail ammeterGetRoomDetailNew(String str, long j) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "");
            combindBean.combind("roomid", "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterRoomDetail> baseBeanAmmeterGetRoomDetailNew = this.mProtocol.ammeterGetRoomDetailNew(code, sign, str);
            if (baseBeanAmmeterGetRoomDetailNew.ok()) {
                return baseBeanAmmeterGetRoomDetailNew.Data;
            }
            throw HttpException.filter(baseBeanAmmeterGetRoomDetailNew.Code, baseBeanAmmeterGetRoomDetailNew.getErrMsg(), baseBeanAmmeterGetRoomDetailNew.Data, baseBeanAmmeterGetRoomDetailNew.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterRoomDetail ammeterGetRoomDetail(String str, long j) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentID", j + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterRoomDetail> baseBeanAmmeterGetRoomDetail = this.mProtocol.ammeterGetRoomDetail(code, sign, str);
            if (baseBeanAmmeterGetRoomDetail.ok()) {
                return baseBeanAmmeterGetRoomDetail.Data;
            }
            throw HttpException.filter(baseBeanAmmeterGetRoomDetail.Code, baseBeanAmmeterGetRoomDetail.getErrMsg(), baseBeanAmmeterGetRoomDetail.Data, baseBeanAmmeterGetRoomDetail.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterWeiXinPayBean ammeterWeiXinOrder(String str, long j, long j2, String str2, int i, String str3, String str4, int i2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j2 + "").combind("mobile", str2 + "").combind("typeId", i + "").combind("deviceType", "1").combind("mobileVersion", str3 + "").combind("osVersion", str4 + "").combind("totalPrice", i2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterWeiXinPayBean> ammeterWeiXinOrder = this.mProtocol.getAmmeterWeiXinOrder(code, sign, str);
            if (ammeterWeiXinOrder.ok()) {
                return ammeterWeiXinOrder.Data;
            }
            throw HttpException.filter(ammeterWeiXinOrder.Code, ammeterWeiXinOrder.getErrMsg(), ammeterWeiXinOrder.Data, ammeterWeiXinOrder.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public UnionPayBean ammeterUnionAliOrder(String str, long j, long j2, String str2, int i, String str3, String str4, int i2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j2 + "").combind("mobile", str2 + "").combind("typeId", i + "").combind("deviceType", "1").combind("mobileVersion", str3 + "").combind("osVersion", str4 + "").combind("totalPrice", i2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<UnionPayBean> ammeterUnionAliOrder = this.mProtocol.getAmmeterUnionAliOrder(code, sign, str);
            if (ammeterUnionAliOrder.ok()) {
                return ammeterUnionAliOrder.Data;
            }
            throw HttpException.filter(ammeterUnionAliOrder.Code, ammeterUnionAliOrder.getErrMsg(), ammeterUnionAliOrder.Data, ammeterUnionAliOrder.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterAliPayBean ammeterAliOrder(String str, long j, long j2, String str2, int i, String str3, String str4, int i2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j2 + "").combind("mobile", str2 + "").combind("typeId", i + "").combind("deviceType", "1").combind("mobileVersion", str3 + "").combind("osVersion", str4 + "").combind("totalPrice", i2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterAliPayBean> baseBeanAmmeterAliOrder = this.mProtocol.ammeterAliOrder(code, sign, str);
            if (baseBeanAmmeterAliOrder.ok()) {
                return baseBeanAmmeterAliOrder.Data;
            }
            throw HttpException.filter(baseBeanAmmeterAliOrder.Code, baseBeanAmmeterAliOrder.getErrMsg(), baseBeanAmmeterAliOrder.Data, baseBeanAmmeterAliOrder.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AmmeterOrderStateBean ammeterSelectOrder(String str, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("orderId", str2 + "");
            Log.e(TAG, "订单号:" + combindBean.returnStr);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<AmmeterOrderStateBean> baseBeanAmmeterSelectOrder = this.mProtocol.ammeterSelectOrder(code, sign, str);
            if (baseBeanAmmeterSelectOrder.ok()) {
                return baseBeanAmmeterSelectOrder.Data;
            }
            throw HttpException.filter(baseBeanAmmeterSelectOrder.Code, baseBeanAmmeterSelectOrder.getErrMsg(), baseBeanAmmeterSelectOrder.Data, baseBeanAmmeterSelectOrder.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public ManagerBean getIsManager(String str, long j) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<ManagerBean> isManager = this.mProtocol.getIsManager(code, sign, str);
            AppAccountManager.getInstance().initAppAccount();
            if (isManager.ok()) {
                ManagerBean managerBean = isManager.Data;
                AppAccountManager.getInstance().saveAppAccount(managerBean);
                return managerBean;
            }
            throw HttpException.filter(isManager.Code, isManager.getErrMsg(), isManager.Data, isManager.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public MessageRecordListBean GetRechargeMessageList(String str, long j, int i, int i2, String str2, int i3, long j2) throws DBException, HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("pageIndex", i + "").combind("pageSize", i2 + "").combind("month", str2 + "").combind("typeId", i3 + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<MessageRecordListBean> baseBeanGetRechargeMessageList = this.mProtocol.GetRechargeMessageList(code, sign, str);
            if (baseBeanGetRechargeMessageList.ok()) {
                return baseBeanGetRechargeMessageList.Data;
            }
            throw HttpException.filter(baseBeanGetRechargeMessageList.Code, baseBeanGetRechargeMessageList.getErrMsg(), baseBeanGetRechargeMessageList.Data, baseBeanGetRechargeMessageList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            if (e instanceof DBException) {
                throw ((DBException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<GetAnnouncementBean> getAnnouncement(String str) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<List<GetAnnouncementBean>> announcement = this.mProtocol.getAnnouncement(code, sign);
            if (announcement.ok()) {
                return announcement.Data;
            }
            throw HttpException.filter(announcement.Code, announcement.getErrMsg(), announcement.Data, announcement.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public Detail getAnnouncementDetailNew(String str, long j) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(STManager.REGION_OF_ID, j + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<Detail> announcementDetailNew = this.mProtocol.getAnnouncementDetailNew(code, sign, str);
            if (announcementDetailNew.ok()) {
                return announcementDetailNew.Data;
            }
            throw HttpException.filter(announcementDetailNew.Code, announcementDetailNew.getErrMsg(), announcementDetailNew.Data, announcementDetailNew.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public GetAllAnnounceListBean getAllAnnouncement(String str, long j) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, j + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<GetAllAnnounceListBean> allAnnouncement = this.mProtocol.getAllAnnouncement(code, sign, str);
            if (allAnnouncement.ok()) {
                return allAnnouncement.Data;
            }
            throw HttpException.filter(allAnnouncement.Code, allAnnouncement.getErrMsg(), allAnnouncement.Data, allAnnouncement.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean chongZhiShouQuanPassword(String str, long j, String str2, String str3, String str4) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("captchaCode", str4).combind("newPassword", str3).combind(FillInfoActivity.EXTRA_SCHOOLID, str2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanChongZhiShouQuanPassword = this.mProtocol.chongZhiShouQuanPassword(code, sign, str);
            if (baseBeanChongZhiShouQuanPassword.ok()) {
                return baseBeanChongZhiShouQuanPassword.Data;
            }
            throw HttpException.filter(baseBeanChongZhiShouQuanPassword.Code, baseBeanChongZhiShouQuanPassword.getErrMsg(), baseBeanChongZhiShouQuanPassword.Data, baseBeanChongZhiShouQuanPassword.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SellCardWeiXinPayBean WxCardMachinePay(String str, long j, long j2, String str2, int i, String str3, int i2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j2 + "").combind("mobile", str2).combind("machineId", str3).combind("totalPrice", i + "").combind("typeId", i2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SellCardWeiXinPayBean> baseBeanWxCardMachinePay = this.mProtocol.WxCardMachinePay(code, sign, str);
            if (baseBeanWxCardMachinePay.ok()) {
                return baseBeanWxCardMachinePay.Data;
            }
            throw HttpException.filter(baseBeanWxCardMachinePay.Code, baseBeanWxCardMachinePay.getErrMsg(), baseBeanWxCardMachinePay.Data, baseBeanWxCardMachinePay.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SellCardAliBean AliCardMachinePay(String str, long j, long j2, String str2, int i, String str3, int i2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j2 + "").combind("mobile", str2).combind("machineId", str3).combind("totalPrice", i + "").combind("typeId", i2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SellCardAliBean> baseBeanAliCardMachinePay = this.mProtocol.AliCardMachinePay(code, sign, str);
            if (baseBeanAliCardMachinePay.ok()) {
                return baseBeanAliCardMachinePay.Data;
            }
            throw HttpException.filter(baseBeanAliCardMachinePay.Code, baseBeanAliCardMachinePay.getErrMsg(), baseBeanAliCardMachinePay.Data, baseBeanAliCardMachinePay.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SellCardUnionBean UnionCardMachinePay(String str, long j, long j2, String str2, int i, String str3, int i2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j2 + "").combind("mobile", str2).combind("machineId", str3).combind("totalPrice", i + "").combind("typeId", i2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SellCardUnionBean> baseBeanUnionCardMachinePay = this.mProtocol.UnionCardMachinePay(code, sign, str);
            if (baseBeanUnionCardMachinePay.ok()) {
                return baseBeanUnionCardMachinePay.Data;
            }
            throw HttpException.filter(baseBeanUnionCardMachinePay.Code, baseBeanUnionCardMachinePay.getErrMsg(), baseBeanUnionCardMachinePay.Data, baseBeanUnionCardMachinePay.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean GerOrdersInfo(String str, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("orderId", str2);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanGerOrdersInfo = this.mProtocol.GerOrdersInfo(code, sign, str);
            if (baseBeanGerOrdersInfo.ok()) {
                return baseBeanGerOrdersInfo.Data;
            }
            throw HttpException.filter(baseBeanGerOrdersInfo.Code, baseBeanGerOrdersInfo.getErrMsg(), baseBeanGerOrdersInfo.Data, baseBeanGerOrdersInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public HamamInitDeviceBean initHamam(String str, String str2, int i, long j, String str3, String str4, long j2, String str5, String str6, String str7, String str8, String str9, String str10) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("machineId", str2).combind("typeId", i + "").combind("studentId", j + "").combind("roomId", str3).combind("investorId", str4 + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j2 + "").combind("deviceName", str5).combind("connectionNumber", str6).combind("installLocation", str7).combind("deviceToMobile", str8).combind("maxConnection", str9).combind("devicever", str10);
            String code = getCode(combindBean);
            String sign = getSign(code);
            Log.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<HamamInitDeviceBean> baseBeanInitHamam = this.mProtocol.initHamam(code, sign, str);
            if (baseBeanInitHamam.ok()) {
                return baseBeanInitHamam.Data;
            }
            throw HttpException.filter(baseBeanInitHamam.Code, baseBeanInitHamam.getErrMsg(), baseBeanInitHamam.Data, baseBeanInitHamam.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean uninitHamam(String str, String str2, int i, long j, String str3, long j2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("machineId", str2).combind("typeId", i + "").combind("studentId", j + "").combind("roomId", str3).combind(FillInfoActivity.EXTRA_SCHOOLID, j2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanUninitHamam = this.mProtocol.uninitHamam(code, sign, str);
            if (baseBeanUninitHamam.ok()) {
                return baseBeanUninitHamam.Data;
            }
            throw HttpException.filter(baseBeanUninitHamam.Code, baseBeanUninitHamam.getErrMsg(), baseBeanUninitHamam.Data, baseBeanUninitHamam.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BathDevicesInfoListBean GetEquipmentSerialNumbers(String str, long j, String str2, int i) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, j + "").combind("roomId", str2).combind("typeId", i + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<BathDevicesInfoListBean> baseBeanGetEquipmentSerialNumbers = this.mProtocol.GetEquipmentSerialNumbers(code, sign, str);
            if (baseBeanGetEquipmentSerialNumbers.ok()) {
                return baseBeanGetEquipmentSerialNumbers.Data;
            }
            throw HttpException.filter(baseBeanGetEquipmentSerialNumbers.Code, baseBeanGetEquipmentSerialNumbers.getErrMsg(), baseBeanGetEquipmentSerialNumbers.Data, baseBeanGetEquipmentSerialNumbers.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<WalletModel> GetOneStudentApplication(String str, long j, int i) throws HttpException {
        try {
            String randNumMaxString = RandomUtil.getRandNumMaxString(6);
            CombindBean combindBean = new CombindBean();
            combindBean.combind("studentId", j + "").combind("typeId", i + "").combind("random", randNumMaxString);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<EncrypedBean> baseBeanGetEncryptedOneStudentApplication = this.mProtocol.GetEncryptedOneStudentApplication(code, sign, str);
            if (baseBeanGetEncryptedOneStudentApplication.ok()) {
                String strDecryptData = decryptData(baseBeanGetEncryptedOneStudentApplication.Data.data);
                LogUtil.log(strDecryptData);
                List string2List = GsonUtils.getInstance().parseString2List(strDecryptData, EncryptedWalletModels.class);
                ArrayList arrayList = new ArrayList();
                if (string2List != null) {
                    for (int i2 = 0; i2 < string2List.size(); i2++) {
                        EncryptedWalletModels encryptedWalletModels = (EncryptedWalletModels) string2List.get(i2);
                        if (!StringUtils.isEmpty(encryptedWalletModels.random) && encryptedWalletModels.random.equals(randNumMaxString)) {
                            WalletModel walletModel = new WalletModel();
                            walletModel.name = encryptedWalletModels.AppName;
                            walletModel.subApp = GsonUtils.getInstance().parse(encryptedWalletModels.SubApp);
                            walletModel.payType = encryptedWalletModels.PayType;
                            walletModel.typeId = encryptedWalletModels.TypeId;
                            walletModel.ID = encryptedWalletModels.ID;
                            walletModel.max = (int) (encryptedWalletModels.MaxDeductPrice * 100.0f);
                            walletModel.icon = encryptedWalletModels.Icon;
                            walletModel.refund = encryptedWalletModels.Refund;
                            walletModel.weiXinCharge = encryptedWalletModels.WeiXinCharge ? 1 : 0;
                            walletModel.ABCCharge = encryptedWalletModels.ABCCharge ? 1 : 0;
                            walletModel.aliCharge = encryptedWalletModels.AliCharge ? 1 : 0;
                            walletModel.unionCharge = encryptedWalletModels.UnionCharge ? 1 : 0;
                            walletModel.IsUseCard = encryptedWalletModels.IsUseCard;
                            walletModel.IsRefund = encryptedWalletModels.IsRefund;
                            arrayList.add(walletModel);
                        }
                        return null;
                    }
                }
                return arrayList;
            }
            throw HttpException.filter(baseBeanGetEncryptedOneStudentApplication.Code, baseBeanGetEncryptedOneStudentApplication.getErrMsg(), baseBeanGetEncryptedOneStudentApplication.Data, baseBeanGetEncryptedOneStudentApplication.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public HamamGetRoomInfoBean GetEquipmentInfo(String str, String str2, int i) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("machineId", str2).combind("typeId", i + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.e(TAG, combindBean.toString());
            LogUtil.log(combindBean.toString());
            BaseBean<HamamGetRoomInfoBean> baseBeanGetEquipmentInfo = this.mProtocol.GetEquipmentInfo(code, sign, str);
            if (baseBeanGetEquipmentInfo.ok()) {
                return baseBeanGetEquipmentInfo.Data;
            }
            throw HttpException.filter(baseBeanGetEquipmentInfo.Code, baseBeanGetEquipmentInfo.getErrMsg(), baseBeanGetEquipmentInfo.Data, baseBeanGetEquipmentInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public HamamVerifyAuthPasswordSecurity VerifyAuthPasswordSecurity(String str, long j, String str2, int i) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, j + "").combind("studentId", str2).combind("typeId", i + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<HamamVerifyAuthPasswordSecurity> baseBeanVerifyAuthPasswordSecurity = this.mProtocol.VerifyAuthPasswordSecurity(code, sign, str);
            if (baseBeanVerifyAuthPasswordSecurity.ok()) {
                return baseBeanVerifyAuthPasswordSecurity.Data;
            }
            throw HttpException.filter(baseBeanVerifyAuthPasswordSecurity.Code, baseBeanVerifyAuthPasswordSecurity.getErrMsg(), baseBeanVerifyAuthPasswordSecurity.Data, baseBeanVerifyAuthPasswordSecurity.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public HamamVerifyAuthPasswordSecurity setShouQuanPassword(String str, long j, String str2, String str3) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, j + "").combind("studentId", str2).combind("password", str3);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<HamamVerifyAuthPasswordSecurity> shouQuanPassword = this.mProtocol.setShouQuanPassword(code, sign, str);
            if (shouQuanPassword.ok()) {
                return shouQuanPassword.Data;
            }
            throw HttpException.filter(shouQuanPassword.Code, shouQuanPassword.getErrMsg(), shouQuanPassword.Data, shouQuanPassword.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public RepairUploadReportPicsBean uploadReportPics(String str, long j, String str2, String str3, String str4, int i) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, j + "").combind("studentId", str2).combind("fileName", str3).combind("typeId", i + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<RepairUploadReportPicsBean> baseBeanUploadReportPics = this.mProtocol.uploadReportPics(code, sign, str, str4);
            if (baseBeanUploadReportPics.ok()) {
                return baseBeanUploadReportPics.Data;
            }
            throw HttpException.filter(baseBeanUploadReportPics.Code, baseBeanUploadReportPics.getErrMsg(), baseBeanUploadReportPics.Data, baseBeanUploadReportPics.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean newAddReports(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str2 + "").combind("studentId", str3).combind("machineId", str4).combind("Mobile", str5).combind("typeId", i + "").combind("installLocation", str6).combind("imgs", str7).combind("faultContent", str8 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanNewAddReports = this.mProtocol.newAddReports(code, sign, str);
            if (baseBeanNewAddReports.ok()) {
                return baseBeanNewAddReports.Data;
            }
            throw HttpException.filter(baseBeanNewAddReports.Code, baseBeanNewAddReports.getErrMsg(), baseBeanNewAddReports.Data, baseBeanNewAddReports.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public ReportListBean getReportList(String str, String str2, String str3, int i, int i2, String str4, int i3, int i4) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str2 + "").combind("studentId", str3).combind("pageIndex", i + "").combind("pageSize", i2 + "").combind("month", str4);
            if (i3 != 0) {
                combindBean.combind("typeId", i3 + "");
            }
            if (i4 != 0) {
                combindBean.combind("resultType", i4 + "");
            }
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<ReportListBean> reportList = this.mProtocol.getReportList(code, sign, str);
            if (reportList.ok()) {
                return reportList.Data;
            }
            throw HttpException.filter(reportList.Code, reportList.getErrMsg(), reportList.Data, reportList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public ReportDetailBean getReportDetail(String str, String str2, String str3, int i, String str4, int i2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str2 + "").combind("studentId", str3).combind("typeId", i + "").combind("id", str4 + "").combind("isManager", i2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<ReportDetailBean> reportDetail = this.mProtocol.getReportDetail(code, sign, str);
            if (reportDetail.ok()) {
                return reportDetail.Data;
            }
            throw HttpException.filter(reportDetail.Code, reportDetail.getErrMsg(), reportDetail.Data, reportDetail.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postConfirmFaultInfo(String str, long j, String str2, int i, String str3, int i2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, j + "").combind("studentId", str2).combind("typeId", i + "").combind("id", str3 + "").combind("isConfirm", i2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanPostConfirmFaultInfo = this.mProtocol.postConfirmFaultInfo(code, sign, str);
            if (baseBeanPostConfirmFaultInfo.ok()) {
                return baseBeanPostConfirmFaultInfo.Data;
            }
            throw HttpException.filter(baseBeanPostConfirmFaultInfo.Code, baseBeanPostConfirmFaultInfo.getErrMsg(), baseBeanPostConfirmFaultInfo.Data, baseBeanPostConfirmFaultInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postSubmitReportInfo(String str, long j, String str2, int i, String str3, int i2, int i3) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, j + "").combind("studentId", str2).combind("typeId", i + "").combind("id", str3 + "").combind("status", i2 + "").combind("resultType", i3 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanPostSubmitReportInfo = this.mProtocol.postSubmitReportInfo(code, sign, str);
            if (baseBeanPostSubmitReportInfo.ok()) {
                return baseBeanPostSubmitReportInfo.Data;
            }
            throw HttpException.filter(baseBeanPostSubmitReportInfo.Code, baseBeanPostSubmitReportInfo.getErrMsg(), baseBeanPostSubmitReportInfo.Data, baseBeanPostSubmitReportInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public NBMachineInfo getNBMachineInfo(String str, String str2, String str3, int i, long j, long j2, String str4, String str5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("machineId", str2).combind("investorId", str3 + "").combind("typeId", i + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j + "").combind(ba.r, j2 + "").combind("Username", str4).combind("mobile", str5);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<NBMachineInfo> nBMachineInfo = this.mProtocol.getNBMachineInfo(code, sign, str);
            if (nBMachineInfo.ok()) {
                return nBMachineInfo.Data;
            }
            throw HttpException.filter(nBMachineInfo.Code, nBMachineInfo.getErrMsg(), nBMachineInfo.Data, nBMachineInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postInitNBMachine(String str, String str2, String str3, int i, long j, long j2, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("machineId", str2).combind("investorId", str3 + "").combind("typeId", i + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j + "").combind(ba.r, j2 + "").combind("Username", str4).combind("mobile", str5).combind("imei", str6 + "").combind("NBflag", "1").combind("MAC", str8 + "").combind("roomId", str9 + "").combind("deviceName", str10);
            if (StringUtils.isNotEmpty(str11)) {
                combindBean.combind("originNumber", str11);
            }
            if (StringUtils.isNotEmpty(str12)) {
                combindBean.combind("useAddress", str12);
            }
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanPostInitNBMachine = this.mProtocol.postInitNBMachine(code, sign, str);
            if (baseBeanPostInitNBMachine.ok()) {
                return baseBeanPostInitNBMachine.Data;
            }
            throw HttpException.filter(baseBeanPostInitNBMachine.Code, baseBeanPostInitNBMachine.getErrMsg(), baseBeanPostInitNBMachine.Data, baseBeanPostInitNBMachine.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postCancelNBMachine(String str, String str2, String str3, int i, long j, long j2, String str4, String str5) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("machineId", str2).combind("investorId", str3 + "").combind("typeId", i + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j + "").combind(ba.r, j2 + "").combind("userName", str4).combind("mobile", str5);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanPostCancelNBMachine = this.mProtocol.postCancelNBMachine(code, sign, str);
            if (baseBeanPostCancelNBMachine.ok()) {
                return baseBeanPostCancelNBMachine.Data;
            }
            throw HttpException.filter(baseBeanPostCancelNBMachine.Code, baseBeanPostCancelNBMachine.getErrMsg(), baseBeanPostCancelNBMachine.Data, baseBeanPostCancelNBMachine.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public RechargeInfoBean GetRechargePromptInformation(String str, int i, long j, long j2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("typeId", i + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j + "").combind("studentId", j2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<RechargeInfoBean> baseBeanGetRechargePromptInformation = this.mProtocol.GetRechargePromptInformation(code, sign, str);
            if (baseBeanGetRechargePromptInformation.ok()) {
                return baseBeanGetRechargePromptInformation.Data;
            }
            throw HttpException.filter(baseBeanGetRechargePromptInformation.Code, baseBeanGetRechargePromptInformation.getErrMsg(), baseBeanGetRechargePromptInformation.Data, baseBeanGetRechargePromptInformation.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean SetEquipmentRateInfo(String str, int i, long j, long j2, String str2, String str3, String str4, String str5, String str6) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("typeId", i + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j + "").combind("studentId", j2 + "").combind("investorId", str2 + "").combind("amountDeducted", str3).combind("ChargeBackPulseNumber", str4).combind("PulseQValue", str5).combind("AlarmTime", str6);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> baseBeanSetEquipmentRateInfo = this.mProtocol.SetEquipmentRateInfo(code, sign, str);
            if (baseBeanSetEquipmentRateInfo.ok()) {
                return baseBeanSetEquipmentRateInfo.Data;
            }
            throw HttpException.filter(baseBeanSetEquipmentRateInfo.Code, baseBeanSetEquipmentRateInfo.getErrMsg(), baseBeanSetEquipmentRateInfo.Data, baseBeanSetEquipmentRateInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SetBean GetEquipmentRateInfo(String str, int i, long j, long j2, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("typeId", i + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j + "").combind("studentId", j2 + "").combind("investorId", str2 + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SetBean> baseBeanGetEquipmentRateInfo = this.mProtocol.GetEquipmentRateInfo(code, sign, str);
            if (baseBeanGetEquipmentRateInfo.ok()) {
                return baseBeanGetEquipmentRateInfo.Data;
            }
            throw HttpException.filter(baseBeanGetEquipmentRateInfo.Code, baseBeanGetEquipmentRateInfo.getErrMsg(), baseBeanGetEquipmentRateInfo.Data, baseBeanGetEquipmentRateInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SetBean JudgeEquipmentRateInfo(String str, int i, long j, long j2, String str2, String str3, String str4, String str5, String str6) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("typeId", i + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j + "").combind("studentId", j2 + "").combind("investorId", str2 + "").combind("amountDeducted", str3).combind("ChargeBackPulseNumber", str4).combind("PulseQValue", str5).combind("AlarmTime", str6);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SetBean> baseBeanJudgeEquipmentRateInfo = this.mProtocol.JudgeEquipmentRateInfo(code, sign, str);
            if (!baseBeanJudgeEquipmentRateInfo.ok() && baseBeanJudgeEquipmentRateInfo.Code != -46) {
                throw HttpException.filter(baseBeanJudgeEquipmentRateInfo.Code, baseBeanJudgeEquipmentRateInfo.getErrMsg(), baseBeanJudgeEquipmentRateInfo.Data, baseBeanJudgeEquipmentRateInfo.Serial);
            }
            return baseBeanJudgeEquipmentRateInfo.Data;
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public RechargeDetailListBean getRechargeGiftInfo(String str, long j, long j2, int i) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("typeId", i + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j2 + "").combind("studentId", j + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<RechargeDetailListBean> rechargeGiftInfo = this.mProtocol.getRechargeGiftInfo(code, sign, str);
            if (rechargeGiftInfo.ok()) {
                return rechargeGiftInfo.Data;
            }
            throw HttpException.filter(rechargeGiftInfo.Code, rechargeGiftInfo.getErrMsg(), rechargeGiftInfo.Data, rechargeGiftInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public RefundListBean getUserRefundList(String str, long j, long j2, String str2, int i) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind("random", str2 + "").combind(FillInfoActivity.EXTRA_SCHOOLID, j2 + "").combind("studentId", j + "").combind("typeId", i + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<RefundListBean> userRefundList = this.mProtocol.getUserRefundList(code, sign, str);
            if (userRefundList.ok()) {
                return userRefundList.Data;
            }
            throw HttpException.filter(userRefundList.Code, userRefundList.getErrMsg(), userRefundList.Data, userRefundList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean getCancellationOfRefund(String str, long j, long j2, int i) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, j2 + "").combind("studentId", j + "").combind("typeId", i + "");
            String code = getCode(combindBean);
            String sign = getSign(code);
            LogUtil.log(combindBean.toString());
            BaseBean<SuccessBean> cancellationOfRefund = this.mProtocol.getCancellationOfRefund(code, sign, str);
            if (cancellationOfRefund.ok()) {
                return cancellationOfRefund.Data;
            }
            throw HttpException.filter(cancellationOfRefund.Code, cancellationOfRefund.getErrMsg(), cancellationOfRefund.Data, cancellationOfRefund.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AdvControlListBean getAdvertisingControl(String str, String str2) throws HttpException {
        try {
            CombindBean combindBean = new CombindBean();
            combindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str2);
            String code = getCode(combindBean);
            String sign = getSign(code);
            LocalBusinessStore.saveAdvlaunch(BaseApplication.app, str2 + "", "");
            LocalBusinessStore.saveAdvBanner(BaseApplication.app, str2 + "", "");
            LocalBusinessStore.saveAdvInsert(BaseApplication.app, str2 + "", "");
            LogUtil.log(combindBean.toString());
            BaseBean<AdvControlListBean> advertisingControl = this.mProtocol.getAdvertisingControl(code, sign, str);
            if (advertisingControl.ok()) {
                AdvControlListBean advControlListBean = advertisingControl.Data;
                if (advControlListBean != null && advControlListBean.result != null && advControlListBean.result.size() > 0) {
                    for (int i = 0; i < advControlListBean.result.size(); i++) {
                        if (advControlListBean.result.get(i).advertDic != null && str2.equals(advControlListBean.result.get(i).schoolId)) {
                            Log.e("test", advControlListBean.result.get(i).advertDic.startscreen + "," + advControlListBean.result.get(i).advertDic.ss_number + "," + advControlListBean.result.get(i).advertDic.ss_playtime + "," + advControlListBean.result.get(i).advertDic.ss_jumpstate);
                            LocalBusinessStore.saveAdvlaunch(BaseApplication.app, str2 + "", advControlListBean.result.get(i).advertDic.startscreen + "," + advControlListBean.result.get(i).advertDic.ss_number + "," + advControlListBean.result.get(i).advertDic.ss_playtime + "," + advControlListBean.result.get(i).advertDic.ss_jumpstate);
                            LocalBusinessStore.saveAdvBanner(BaseApplication.app, str2 + "", advControlListBean.result.get(i).advertDic.banner + "," + advControlListBean.result.get(i).advertDic.b_number + "," + advControlListBean.result.get(i).advertDic.b_playtime);
                            LocalBusinessStore.saveAdvInsert(BaseApplication.app, str2 + "", advControlListBean.result.get(i).advertDic.popup + "," + advControlListBean.result.get(i).advertDic.p_number + "," + advControlListBean.result.get(i).advertDic.p_playtime);
                        }
                    }
                }
                return advertisingControl.Data;
            }
            throw HttpException.filter(advertisingControl.Code, advertisingControl.getErrMsg(), advertisingControl.Data, advertisingControl.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean newAddReportsV3(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8) throws HttpException {
        try {
            String str9 = "schoolId=" + str2 + "*_studentId=" + str3 + "*_machineId=" + str4 + "*_Mobile=" + str5 + "*_typeId=" + i + "*_installLocation=" + str6 + "*_faultContent=" + str8;
            String strEncode = URLEncoder.encode(str9, "UTF-8");
            String signV3 = getSignV3(strEncode);
            Log.e(TAG, str9 + "  " + signV3 + "  " + strEncode);
            LogUtil.log(str9);
            BaseBeanLow<SuccessBean> baseBeanLowNewAddReportsV3 = this.mProtocol.newAddReportsV3(signV3, str9, "140000000000000001");
            if (baseBeanLowNewAddReportsV3.ok()) {
                return baseBeanLowNewAddReportsV3.data;
            }
            throw HttpException.filter(baseBeanLowNewAddReportsV3.code, baseBeanLowNewAddReportsV3.getErrMsg(), baseBeanLowNewAddReportsV3.data, baseBeanLowNewAddReportsV3.serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public ReportListBean getReportListV3(String str, String str2, String str3, int i, int i2, String str4, int i3, int i4) throws HttpException {
        try {
            String str5 = "schoolId=" + str2 + "*_studentId=" + str3 + "*_pageIndex=" + i + "*_pageSize=" + i2 + "*_month=" + str4;
            String signV3 = getSignV3(URLEncoder.encode(str5, "UTF-8"));
            LogUtil.log(str5);
            BaseBeanLow<ReportListBean> reportListV3 = this.mProtocol.getReportListV3(signV3, str5, "140000000000000001");
            if (reportListV3.ok()) {
                return reportListV3.data;
            }
            throw HttpException.filter(reportListV3.code, reportListV3.getErrMsg(), reportListV3.data, reportListV3.serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public ReportDetailBean getReportDetailV3(String str, String str2, String str3, int i, String str4, int i2) throws HttpException {
        try {
            String str5 = "schoolId=" + str2 + "*_studentId=" + str3 + "*_typeId=" + i + "*_id=" + str4 + "*_isManager=" + i2;
            String signV3 = getSignV3(URLEncoder.encode(str5, "UTF-8"));
            LogUtil.log(str5);
            BaseBeanLow<ReportDetailBean> reportDetailV3 = this.mProtocol.getReportDetailV3(signV3, str5, "140000000000000001");
            if (reportDetailV3.ok()) {
                return reportDetailV3.data;
            }
            throw HttpException.filter(reportDetailV3.code, reportDetailV3.getErrMsg(), reportDetailV3.data, reportDetailV3.serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<GetAnnouncementBean> getAnnouncementV3(String str, String str2) throws HttpException {
        try {
            String str3 = "schoolId=" + str + "*_investorId=" + str2;
            String signV3 = getSignV3(URLEncoder.encode(str3, "UTF-8"));
            LogUtil.log(str3);
            BaseBeanLow<List<GetAnnouncementBean>> announcementV3 = this.mProtocol.getAnnouncementV3(signV3, str3, "140000000000000001");
            if (announcementV3.ok()) {
                return announcementV3.data;
            }
            throw HttpException.filter(announcementV3.code, announcementV3.getErrMsg(), announcementV3.data, announcementV3.serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public Detail getAnnouncementDetailNewV3(String str, long j) throws HttpException {
        try {
            String str2 = "ID=" + j;
            String signV3 = getSignV3(URLEncoder.encode(str2, "UTF-8"));
            LogUtil.log(str2);
            BaseBeanLow<Detail> announcementDetailNewV3 = this.mProtocol.getAnnouncementDetailNewV3(signV3, str2, "140000000000000001");
            if (announcementDetailNewV3.ok()) {
                return announcementDetailNewV3.data;
            }
            throw HttpException.filter(announcementDetailNewV3.code, announcementDetailNewV3.getErrMsg(), announcementDetailNewV3.data, announcementDetailNewV3.serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public GetAllAnnounceListBean getAllAnnouncementV3(String str, String str2) throws HttpException {
        try {
            String str3 = "schoolId=" + str2;
            String signV3 = getSignV3(URLEncoder.encode(str3, "UTF-8"));
            LogUtil.log(str3);
            BaseBeanLow<GetAllAnnounceListBean> allAnnouncementV3 = this.mProtocol.getAllAnnouncementV3(signV3, str3, "140000000000000001");
            if (allAnnouncementV3.ok()) {
                return allAnnouncementV3.data;
            }
            throw HttpException.filter(allAnnouncementV3.code, allAnnouncementV3.getErrMsg(), allAnnouncementV3.data, allAnnouncementV3.serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    private String decryptData(String str) {
        try {
            return AESHelper.decrypt(str, StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String getCode(CombindBean combindBean) throws HttpException {
        try {
            return AESHelper.encrypt(combindBean.toString(), StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
        } catch (Exception unused) {
            throw new HttpException(-1001, "获取服务器数据失败");
        }
    }

    private String getSign(String str) {
        return MD5.md5(StringUtils.asciiToString("121,107,116,42,37,95,99,79") + str);
    }

    private String getCodeV3(CombindBean combindBean) throws HttpException {
        try {
            return AESHelper.encrypt(combindBean.toString(), StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
        } catch (Exception unused) {
            throw new HttpException(-1001, "获取服务器数据失败");
        }
    }

    private String getSignV3(String str) {
        return MD5.md5_SmallRoutine(StringUtils.asciiToString(HttpComfigUtil.MD5KEY_V3) + str);
    }

    class CombindBean {
        private String returnStr = "";

        CombindBean() {
        }

        public CombindBean combind(String str, String str2) {
            if (str2 != null && !str2.equals("null")) {
                this.returnStr += (str + "=" + str2 + "#?");
            }
            return this;
        }

        public String toString() {
            String str = new String(this.returnStr);
            return str.length() >= 2 ? str.substring(0, str.length() - 2) : str;
        }
    }
}
