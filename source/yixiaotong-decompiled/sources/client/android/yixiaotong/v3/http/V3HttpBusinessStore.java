package client.android.yixiaotong.v3.http;

import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.gonggaolan.Detail;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAllAnnounceListBean;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAnnouncementBean;
import client.android.yixiaotong.controller.store.ClientDataManager;
import client.android.yixiaotong.controller.store.HttpComfigUtil;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.exception.HttpException;
import client.android.yixiaotong.ui.login.FillInfoActivity;
import client.android.yixiaotong.util.AESHelper;
import client.android.yixiaotong.util.Base64;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.MD5;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.http.HttpProtocolFactory;
import client.android.yixiaotong.util.http.bean.BaseBean;
import client.android.yixiaotong.v3.bean.AlarmSwitchBean;
import client.android.yixiaotong.v3.bean.AlarmSwitchBean2;
import client.android.yixiaotong.v3.bean.PlatformInfoBean;
import client.android.yixiaotong.v3.bean.adv.AdvBean;
import client.android.yixiaotong.v3.bean.adv.AdvRulesBean;
import client.android.yixiaotong.v3.bean.appointment.AppointmentBean;
import client.android.yixiaotong.v3.bean.appointment.AppointmentListBean;
import client.android.yixiaotong.v3.bean.appointment.AppointmentResultBean;
import client.android.yixiaotong.v3.bean.appointment.UsingBean;
import client.android.yixiaotong.v3.bean.area.AreaListBean;
import client.android.yixiaotong.v3.bean.card.Activate;
import client.android.yixiaotong.v3.bean.card.BindCard;
import client.android.yixiaotong.v3.bean.card.BuyClubCardBean;
import client.android.yixiaotong.v3.bean.card.ClubCardBean;
import client.android.yixiaotong.v3.bean.card.CreateOrder;
import client.android.yixiaotong.v3.bean.card.CreateOrderBean;
import client.android.yixiaotong.v3.bean.card.RefundCreateOrder;
import client.android.yixiaotong.v3.bean.card.SchoolCardInfoBean;
import client.android.yixiaotong.v3.bean.consumer.ConsumerCreateOrder;
import client.android.yixiaotong.v3.bean.consumer.ConsumerCreateOrderBean;
import client.android.yixiaotong.v3.bean.consumer.ConsumerPriceInfoBean;
import client.android.yixiaotong.v3.bean.consumer.ConsumerQueryOrder;
import client.android.yixiaotong.v3.bean.consumer.ConsumerQueryOrderBean;
import client.android.yixiaotong.v3.bean.deviceinfo.BluetoothSetBean;
import client.android.yixiaotong.v3.bean.deviceinfo.DevicePswRuleBean;
import client.android.yixiaotong.v3.bean.deviceinfo.GetModeBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByLocation;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByLocationBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByMacBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineInfoJson;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineRunInfo;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineStatusData;
import client.android.yixiaotong.v3.bean.deviceinfo.NBOr4GDevice;
import client.android.yixiaotong.v3.bean.deviceinfo.NBOr4GStatuBean;
import client.android.yixiaotong.v3.bean.deviceinfo.OpenPro;
import client.android.yixiaotong.v3.bean.deviceinfo.PostPrepareBath;
import client.android.yixiaotong.v3.bean.deviceinfo.PostPrepareBathBean;
import client.android.yixiaotong.v3.bean.deviceinfo.SetData;
import client.android.yixiaotong.v3.bean.deviceinfo.SetRateUpload;
import client.android.yixiaotong.v3.bean.deviceinfo.SetResult;
import client.android.yixiaotong.v3.bean.deviceinfo.UpLoadData;
import client.android.yixiaotong.v3.bean.deviceinfo.UpdateMachineMac;
import client.android.yixiaotong.v3.bean.drawmoney.DMGetOrder;
import client.android.yixiaotong.v3.bean.drawmoney.DMGetOrderBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMGetQrcode;
import client.android.yixiaotong.v3.bean.drawmoney.DMGetQrcodeBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMHandleData;
import client.android.yixiaotong.v3.bean.drawmoney.DMHandleDataBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMOrderRecordBean;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterInfo;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterInfoBean;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterRoomInfoBean;
import client.android.yixiaotong.v3.bean.elecmeter.ElecMeterBlanceInfoBean;
import client.android.yixiaotong.v3.bean.elecmeter.ElecMeterCreateOrder;
import client.android.yixiaotong.v3.bean.elecmeter.ElecRechargeRecord;
import client.android.yixiaotong.v3.bean.elecmeter.ElecRechargeRecordBean;
import client.android.yixiaotong.v3.bean.elecmeter.MetersTrend;
import client.android.yixiaotong.v3.bean.elecmeter.MetersTrendBean;
import client.android.yixiaotong.v3.bean.elecmeter.SelectElecMeterAreaInfo;
import client.android.yixiaotong.v3.bean.elecmeter.SelectElecMeterBuildingInfo;
import client.android.yixiaotong.v3.bean.elecmeter.SelectElecMeterFloorInfo;
import client.android.yixiaotong.v3.bean.elecmeter.SelectElecMeterRoomInfo;
import client.android.yixiaotong.v3.bean.elecmeter.UserBindRoomElecMeter;
import client.android.yixiaotong.v3.bean.login.CancelAccount;
import client.android.yixiaotong.v3.bean.login.HostUrlBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.bean.login.InvestoridAndSchoolId;
import client.android.yixiaotong.v3.bean.login.LoginSeccessBean;
import client.android.yixiaotong.v3.bean.login.SchoolIdBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfoBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.bean.login.SchoolQrcodeBean;
import client.android.yixiaotong.v3.bean.login.UserAesData;
import client.android.yixiaotong.v3.bean.login.UserInfoBean;
import client.android.yixiaotong.v3.bean.login.UserLoginBean;
import client.android.yixiaotong.v3.bean.order.BuyClubCardDetailBean;
import client.android.yixiaotong.v3.bean.order.BuyClubCradRecordBean;
import client.android.yixiaotong.v3.bean.order.Coupon;
import client.android.yixiaotong.v3.bean.order.CouponBean;
import client.android.yixiaotong.v3.bean.order.DMOrder;
import client.android.yixiaotong.v3.bean.order.DepositRechargeRecordBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderListBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderResultBean;
import client.android.yixiaotong.v3.bean.order.OrderMoreDetailBean;
import client.android.yixiaotong.v3.bean.order.OrderRecord;
import client.android.yixiaotong.v3.bean.order.OrderRecordBean;
import client.android.yixiaotong.v3.bean.order.PayOrder;
import client.android.yixiaotong.v3.bean.order.RefundOrderRecord;
import client.android.yixiaotong.v3.bean.order.UnPayOrdersBean;
import client.android.yixiaotong.v3.bean.pay.PayResult;
import client.android.yixiaotong.v3.bean.pay.SelectAll;
import client.android.yixiaotong.v3.bean.pay.SelectAllBean;
import client.android.yixiaotong.v3.bean.pay.SignBean;
import client.android.yixiaotong.v3.bean.prepayment.ChangeSupervisor;
import client.android.yixiaotong.v3.bean.prepayment.MachineRand;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentCreateOrder;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentDeviceInfo;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentDeviceInfoBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentRedPackageAmountBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentWalletBean;
import client.android.yixiaotong.v3.bean.prepayment.Refund;
import client.android.yixiaotong.v3.bean.prepayment.RefundBean;
import client.android.yixiaotong.v3.bean.prepayment.SetWaterZero;
import client.android.yixiaotong.v3.bean.prepayment.SetWaterZeroBean;
import client.android.yixiaotong.v3.bean.prepayment.SupervisorBean;
import client.android.yixiaotong.v3.bean.prepayment.UnFinishOrder;
import client.android.yixiaotong.v3.bean.prepayment.UnFinishOrderBean;
import client.android.yixiaotong.v3.bean.prepayment.UserInfoByMobileBean;
import client.android.yixiaotong.v3.bean.register.ChangePhone;
import client.android.yixiaotong.v3.bean.register.MobileMessageBean;
import client.android.yixiaotong.v3.bean.register.MobileRegisterUser;
import client.android.yixiaotong.v3.bean.register.PswBean;
import client.android.yixiaotong.v3.bean.register.SetMachinePWD;
import client.android.yixiaotong.v3.bean.sellcard.DeductionRuleBean;
import client.android.yixiaotong.v3.bean.sellcard.SellCardAuth;
import client.android.yixiaotong.v3.bean.user.AppVersionBean;
import client.android.yixiaotong.v3.bean.user.HistoryLoginInfoBean;
import client.android.yixiaotong.v3.bean.user.RedisCach;
import client.android.yixiaotong.v3.bean.user.RepairUserInfo;
import client.android.yixiaotong.v3.bean.user.UserActiveInfo;
import client.android.yixiaotong.v3.bean.user.UserCommon;
import client.android.yixiaotong.v3.bean.user.UserPage;
import client.android.yixiaotong.v3.bean.wallet.AppIdAndSecretBean;
import client.android.yixiaotong.v3.bean.wallet.BindSchoolGive;
import client.android.yixiaotong.v3.bean.wallet.CashRedPackageBean;
import client.android.yixiaotong.v3.bean.wallet.DepositionBean;
import client.android.yixiaotong.v3.bean.wallet.PayModelParameter;
import client.android.yixiaotong.v3.bean.wallet.PostGetWalletInfo;
import client.android.yixiaotong.v3.bean.wallet.PostGetWalletInfoV2;
import client.android.yixiaotong.v3.bean.wallet.WalletInfoBean;
import client.android.yixiaotong.v3.bean.wallet.WalletRefundDetailBean;
import client.android.yixiaotong.v3.bean.wallet.YiKaTongPayModelParameterBean;
import client.android.yixiaotong.v3.bean.wallet.YiKaTongPayRequest;
import client.android.yixiaotong.v3.bean.wallet.YiKaTongPayResultBean;
import client.android.yixiaotong.v3.bean.ykt.OpenYKTBean;
import client.android.yixiaotong.v3.bean.ykt.YKTBind;
import client.android.yixiaotong.v3.bean.ykt.YKTBindStateBean;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.WalletInfoUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4HeaderUtil;
import client.android.yixiaotong.v4.http.bean.V4BaseBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.hihonor.adsdk.base.g.j.e.a;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.unionpay.tsmservice.mi.data.Constant;
import com.yfanads.android.libs.net.UrlHttpUtil;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V3HttpBusinessStore {
    public static final String TAG = "V3HttpBusinessStore";
    private Account mAccount;
    private V3BusinessHttpProtocol mProtocol;

    public V3HttpBusinessStore(Account account) {
        this.mAccount = account;
    }

    public void setUrl(String str) {
        this.mProtocol = (V3BusinessHttpProtocol) HttpProtocolFactory.getInstance().getProtocol(str, V3BusinessHttpProtocol.class);
    }

    public AppVersionBean getAppVerInfo(String str, String str2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("premisesId", str);
            v3CombindBean.combind("investorId", str2);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<AppVersionBean> appVerInfo = this.mProtocol.getAppVerInfo(str, str2, sign);
            if ((appVerInfo.ok() || appVerInfo.Code == -53) && appVerInfo.Data != null) {
                LocalDataUtil.saveCurrentTime(BaseApplication.app, appVerInfo.Serial);
                return appVerInfo.Data;
            }
            throw HttpException.filter(appVerInfo.Code, appVerInfo.Message, appVerInfo.Data, appVerInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AppVersionBean getAppVerInfo2(String str, String str2, String str3) throws HttpException {
        LocalDataUtil.saveClientTypeInfo(BaseApplication.app, "202206280001");
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("productVer", str);
            v3CombindBean.combind("clientType", str2);
            v3CombindBean.combind("productCode", str3);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<AppVersionBean> appVerInfo2 = this.mProtocol.getAppVerInfo2(str, str2, str3, sign);
            if ((appVerInfo2.ok() || appVerInfo2.Code == -53) && appVerInfo2.Data != null) {
                return appVerInfo2.Data;
            }
            throw HttpException.filter(appVerInfo2.Code, appVerInfo2.Message, appVerInfo2.Data, appVerInfo2.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public PlatformInfoBean getPlatformInfo(String str) throws HttpException {
        try {
            LogUtil.d(TAG, "schoolId:" + str);
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<PlatformInfoBean> platformInfo = this.mProtocol.getPlatformInfo(str + "", sign);
            if (platformInfo.ok() && platformInfo.Data != null) {
                if (platformInfo.Data.status == 0) {
                    LocalDataUtil.savePlatformInfo(BaseApplication.app, 1);
                } else {
                    LocalDataUtil.savePlatformInfo(BaseApplication.app, 0);
                }
                return platformInfo.Data;
            }
            throw HttpException.filter(platformInfo.Code, platformInfo.Message, platformInfo.Data, platformInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String getCheckUser(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("account", str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<String> checkUser = this.mProtocol.getCheckUser(str, sign);
            if (checkUser.ok()) {
                if (StringUtils.isNotEmpty(checkUser.Data)) {
                    if (checkUser.Data.equals("1")) {
                        LocalDataUtil.savePlatformInfo(BaseApplication.app, 1);
                    } else {
                        LocalDataUtil.savePlatformInfo(BaseApplication.app, 0);
                    }
                }
                return checkUser.Data;
            }
            throw HttpException.filter(checkUser.Code, checkUser.Message, checkUser.Data, checkUser.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public LoginSeccessBean postUserLogin(String str, String str2, String str3) throws HttpException {
        try {
            UserLoginBean userLoginBean = new UserLoginBean();
            userLoginBean.studentMobile = str;
            userLoginBean.loginPassword = str2;
            userLoginBean.code = str3;
            UserAesData userAesData = new UserAesData();
            userAesData.data = getBase64Encode(obJectToString(userLoginBean));
            String sign = getSign(obJectToString(userAesData));
            LogUtil.d(TAG, obJectToString(userLoginBean) + "  " + sign + "  " + new String(Base64.decode(userAesData.data, 0)));
            LogUtil.log(obJectToString(userLoginBean));
            BaseBean<LoginSeccessBean> baseBeanPostUserLoginAes = this.mProtocol.postUserLoginAes(userAesData, sign);
            if (baseBeanPostUserLoginAes.ok() && baseBeanPostUserLoginAes.Data != null) {
                if (StringUtils.isNotEmpty(baseBeanPostUserLoginAes.Data.url)) {
                    LocalDataUtil.saveUrl(BaseApplication.app, baseBeanPostUserLoginAes.Data.url);
                }
                LocalDataUtil.saveLastTokenInfo(BaseApplication.app, baseBeanPostUserLoginAes.TokenInfo);
                UserInfoUtil.getInstance().saveStudentIdV3(baseBeanPostUserLoginAes.Data);
                return baseBeanPostUserLoginAes.Data;
            }
            throw HttpException.filter(baseBeanPostUserLoginAes.Code, baseBeanPostUserLoginAes.getErrMsg(), baseBeanPostUserLoginAes.Data, baseBeanPostUserLoginAes.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postRedisCach(String str, String str2) throws HttpException {
        try {
            RedisCach redisCach = new RedisCach();
            redisCach.key = str;
            redisCach.value = str2;
            String sign = getSign(obJectToString(redisCach));
            LogUtil.d(TAG, obJectToString(redisCach) + sign);
            LogUtil.log(obJectToString(redisCach));
            BaseBean<SuccessBean> baseBeanPostRedisCach = this.mProtocol.postRedisCach(redisCach, sign);
            if (baseBeanPostRedisCach.ok()) {
                return baseBeanPostRedisCach.Data;
            }
            throw HttpException.filter(baseBeanPostRedisCach.Code, baseBeanPostRedisCach.getErrMsg(), baseBeanPostRedisCach.Data, baseBeanPostRedisCach.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String getRedisCach(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("key", str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<String> redisCach = this.mProtocol.getRedisCach(str, sign);
            if (redisCach.ok()) {
                return redisCach.Data;
            }
            throw HttpException.filter(redisCach.Code, redisCach.getErrMsg(), redisCach.Data, redisCach.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String getCode(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("account", str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<String> code = this.mProtocol.getCode(str, sign);
            if (code.ok()) {
                return code.Data;
            }
            throw HttpException.filter(code.Code, code.Message, code.Data, code.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String getUserLogout() throws HttpException {
        try {
            String sign = getSign("");
            LogUtil.d(TAG, sign);
            BaseBean<String> userLogout = this.mProtocol.getUserLogout(sign);
            if (!userLogout.ok() && userLogout.Code != -44) {
                throw HttpException.filter(userLogout.Code, userLogout.getErrMsg(), userLogout.Data, userLogout.Serial);
            }
            LocalDataUtil.saveLastTokenInfo(BaseApplication.app, "");
            return userLogout.Data;
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public UserInfoBean getUserInfo() throws HttpException {
        try {
            String sign = getSign("");
            LogUtil.d(TAG, sign);
            BaseBean<UserInfoBean> userInfo = this.mProtocol.getUserInfo(sign);
            if (userInfo.ok() && userInfo.Data != null) {
                UserInfoUtil.getInstance().saveUserInfoV3(userInfo.Data);
                return userInfo.Data;
            }
            throw HttpException.filter(userInfo.Code, userInfo.getErrMsg(), userInfo.Data, userInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String getSelectStudentNumberBySchoolId(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<String> selectStudentNumberBySchoolId = this.mProtocol.getSelectStudentNumberBySchoolId(str, sign);
            if (selectStudentNumberBySchoolId.ok()) {
                return selectStudentNumberBySchoolId.Data;
            }
            throw HttpException.filter(selectStudentNumberBySchoolId.Code, selectStudentNumberBySchoolId.getErrMsg(), selectStudentNumberBySchoolId.Data, selectStudentNumberBySchoolId.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postUserInfo(int i, String str) throws HttpException {
        try {
            RepairUserInfo repairUserInfo = new RepairUserInfo();
            repairUserInfo.studentGender = i;
            repairUserInfo.studentName = str;
            String sign = getSign(obJectToString(repairUserInfo));
            LogUtil.d(TAG, obJectToString(repairUserInfo) + sign);
            LogUtil.log(obJectToString(repairUserInfo));
            BaseBean<SuccessBean> baseBeanPostUserInfo = this.mProtocol.postUserInfo(repairUserInfo, sign);
            if (baseBeanPostUserInfo.ok()) {
                return baseBeanPostUserInfo.Data;
            }
            throw HttpException.filter(baseBeanPostUserInfo.Code, baseBeanPostUserInfo.getErrMsg(), baseBeanPostUserInfo.Data, baseBeanPostUserInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postUpdateStudentNumberBySchoolId(String str, String str2) throws HttpException {
        try {
            RepairUserInfo repairUserInfo = new RepairUserInfo();
            repairUserInfo.schoolId = str;
            repairUserInfo.studentNumber = str2;
            String sign = getSign(obJectToString(repairUserInfo));
            LogUtil.d(TAG, obJectToString(repairUserInfo) + sign);
            LogUtil.log(obJectToString(repairUserInfo));
            BaseBean<SuccessBean> baseBeanPostUpdateStudentNumberBySchoolId = this.mProtocol.postUpdateStudentNumberBySchoolId(repairUserInfo, sign);
            if (baseBeanPostUpdateStudentNumberBySchoolId.ok()) {
                return baseBeanPostUpdateStudentNumberBySchoolId.Data;
            }
            throw HttpException.filter(baseBeanPostUpdateStudentNumberBySchoolId.Code, baseBeanPostUpdateStudentNumberBySchoolId.getErrMsg(), baseBeanPostUpdateStudentNumberBySchoolId.Data, baseBeanPostUpdateStudentNumberBySchoolId.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SchoolInfoBean getSchoolInfo() throws HttpException {
        try {
            String sign = getSign("");
            LogUtil.d(TAG, sign);
            BaseBean<SchoolInfoBean> schoolInfo = this.mProtocol.getSchoolInfo(sign);
            if (schoolInfo.ok() && schoolInfo.Data != null) {
                UserInfoUtil.getInstance().saveSchoolIdV3(schoolInfo.Data.schoolList);
                return schoolInfo.Data;
            }
            throw HttpException.filter(schoolInfo.Code, schoolInfo.getErrMsg(), schoolInfo.Data, schoolInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<SchoolInfosBean> getSchoolInfos(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("schoolList", str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<List<SchoolInfosBean>> schoolInfos = this.mProtocol.getSchoolInfos(str, sign);
            if (schoolInfos.ok() && schoolInfos.Data != null) {
                return schoolInfos.Data;
            }
            throw HttpException.filter(schoolInfos.Code, schoolInfos.getErrMsg(), schoolInfos.Data, schoolInfos.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<InvestorInfosBean> getInvestorInfo(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<List<InvestorInfosBean>> investorInfo = this.mProtocol.getInvestorInfo(str, sign);
            if (investorInfo.ok()) {
                InvestorInfoUtil.getInstance().saveInvestorInfosV3(investorInfo.Data);
                return investorInfo.Data;
            }
            throw HttpException.filter(investorInfo.Code, investorInfo.getErrMsg(), investorInfo.Data, investorInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DepositionBean getDepositInfoByInvestorid(String str, String str2) throws HttpException {
        try {
            InvestoridAndSchoolId investoridAndSchoolId = new InvestoridAndSchoolId();
            investoridAndSchoolId.investorId = str2;
            investoridAndSchoolId.schoolId = str;
            String sign = getSign(obJectToString(investoridAndSchoolId));
            LogUtil.d(TAG, obJectToString(investoridAndSchoolId) + "  " + sign);
            LogUtil.log(obJectToString(investoridAndSchoolId));
            BaseBean<DepositionBean> depositInfoByInvestorid = this.mProtocol.getDepositInfoByInvestorid(investoridAndSchoolId, sign);
            if (depositInfoByInvestorid.ok()) {
                return depositInfoByInvestorid.Data;
            }
            throw HttpException.filter(depositInfoByInvestorid.Code, depositInfoByInvestorid.getErrMsg(), depositInfoByInvestorid.Data, depositInfoByInvestorid.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WalletInfoBean postGetWalletInfoByInvestorid(String str, String str2) throws HttpException {
        try {
            PostGetWalletInfo postGetWalletInfo = new PostGetWalletInfo();
            postGetWalletInfo.schoolId = str;
            postGetWalletInfo.investorId = str2;
            postGetWalletInfo.walletType = 1;
            String sign = getSign(obJectToString(postGetWalletInfo));
            LogUtil.d(TAG, obJectToString(postGetWalletInfo) + "  " + sign);
            LogUtil.log(obJectToString(postGetWalletInfo));
            BaseBean<WalletInfoBean> baseBeanPostGetWalletInfoByInvestorid = this.mProtocol.postGetWalletInfoByInvestorid(postGetWalletInfo, sign);
            if (baseBeanPostGetWalletInfoByInvestorid.ok() && baseBeanPostGetWalletInfoByInvestorid.Data != null) {
                WalletInfoUtil.getInstance().saveWalletInfoV3(baseBeanPostGetWalletInfoByInvestorid.Data);
                return baseBeanPostGetWalletInfoByInvestorid.Data;
            }
            throw HttpException.filter(baseBeanPostGetWalletInfoByInvestorid.Code, baseBeanPostGetWalletInfoByInvestorid.getErrMsg(), baseBeanPostGetWalletInfoByInvestorid.Data, baseBeanPostGetWalletInfoByInvestorid.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WalletInfoBean postGetWalletInfoByInvestoridV2(String str, String str2, String str3) throws HttpException {
        try {
            PostGetWalletInfoV2 postGetWalletInfoV2 = new PostGetWalletInfoV2();
            postGetWalletInfoV2.studentId = str;
            postGetWalletInfoV2.schoolId = str2;
            postGetWalletInfoV2.investorId = str3;
            postGetWalletInfoV2.walletType = 1;
            String sign = getSign(obJectToString(postGetWalletInfoV2));
            LogUtil.d(TAG, obJectToString(postGetWalletInfoV2) + "  " + sign);
            LogUtil.log(obJectToString(postGetWalletInfoV2));
            BaseBean<WalletInfoBean> baseBeanPostGetWalletInfoByInvestoridV2 = this.mProtocol.postGetWalletInfoByInvestoridV2(postGetWalletInfoV2, sign);
            if (baseBeanPostGetWalletInfoByInvestoridV2.ok() && baseBeanPostGetWalletInfoByInvestoridV2.Data != null) {
                WalletInfoUtil.getInstance().saveWalletInfoV3(baseBeanPostGetWalletInfoByInvestoridV2.Data);
                return baseBeanPostGetWalletInfoByInvestoridV2.Data;
            }
            throw HttpException.filter(baseBeanPostGetWalletInfoByInvestoridV2.Code, baseBeanPostGetWalletInfoByInvestoridV2.getErrMsg(), baseBeanPostGetWalletInfoByInvestoridV2.Data, baseBeanPostGetWalletInfoByInvestoridV2.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public MachineByMacBean getMachineByMac(String str, int i) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(Constant.KEY_MAC, str);
            v3CombindBean.combind("typeId", i + "");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.i(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<MachineByMacBean> machineByMac = this.mProtocol.getMachineByMac(str, i, sign);
            if (machineByMac.ok()) {
                return machineByMac.Data;
            }
            throw HttpException.filter(machineByMac.Code, machineByMac.getErrMsg(), machineByMac.Data, machineByMac.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public MachineByMacBean getUpdateMachineMac(String str, String str2, int i) throws HttpException {
        try {
            UpdateMachineMac updateMachineMac = new UpdateMachineMac();
            updateMachineMac.machineId = str;
            updateMachineMac.mac = str2;
            updateMachineMac.typeId = i;
            String sign = getSign(obJectToString(updateMachineMac));
            LogUtil.i(TAG, sign);
            LogUtil.log(obJectToString(updateMachineMac));
            BaseBean<MachineByMacBean> updateMachineMac2 = this.mProtocol.getUpdateMachineMac(updateMachineMac, sign);
            if (updateMachineMac2.ok()) {
                return updateMachineMac2.Data;
            }
            throw HttpException.filter(updateMachineMac2.Code, updateMachineMac2.getErrMsg(), updateMachineMac2.Data, updateMachineMac2.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public MachineByMacBean getMachineByMachineId(String str, int i) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("machineId", str);
            v3CombindBean.combind("typeId", i + "");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<MachineByMacBean> machineByMachineId = this.mProtocol.getMachineByMachineId(str, i, sign);
            if (machineByMachineId.ok()) {
                return machineByMachineId.Data;
            }
            throw HttpException.filter(machineByMachineId.Code, machineByMachineId.getErrMsg(), machineByMachineId.Data, machineByMachineId.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public MachineByMacBean getMachineByMachineId2(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("machineId", str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<MachineByMacBean> machineByMachineId2 = this.mProtocol.getMachineByMachineId2(str, sign);
            if (machineByMachineId2.ok()) {
                return machineByMachineId2.Data;
            }
            throw HttpException.filter(machineByMachineId2.Code, machineByMachineId2.getErrMsg(), machineByMachineId2.Data, machineByMachineId2.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public MachineByMacBean getInfoByQRCode(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("qrcode", str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<MachineByMacBean> infoByQRCode = this.mProtocol.getInfoByQRCode(str, sign);
            if (infoByQRCode.ok()) {
                return infoByQRCode.Data;
            }
            throw HttpException.filter(infoByQRCode.Code, infoByQRCode.getErrMsg(), infoByQRCode.Data, infoByQRCode.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public InvestoridAndSchoolId getUseInfoByMachineId(String str, int i) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("machineId", str);
            v3CombindBean.combind("typeId", i + "");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<InvestoridAndSchoolId> useInfoByMachineId = this.mProtocol.getUseInfoByMachineId(str, i, sign);
            if (useInfoByMachineId.ok() && useInfoByMachineId.Data != null) {
                return useInfoByMachineId.Data;
            }
            throw HttpException.filter(useInfoByMachineId.Code, useInfoByMachineId.getErrMsg(), useInfoByMachineId.Data, useInfoByMachineId.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public PostPrepareBathBean postPrepareBath(int i, String str, String str2, MachineInfoJson machineInfoJson) throws HttpException {
        try {
            PostPrepareBath postPrepareBath = new PostPrepareBath();
            postPrepareBath.channelWay = 1;
            postPrepareBath.typeId = i;
            postPrepareBath.deviceVer = str;
            postPrepareBath.machineId = str2;
            postPrepareBath.machineInfoJson = machineInfoJson;
            String sign = getSign(obJectToString(postPrepareBath));
            LogUtil.d(TAG, obJectToString(postPrepareBath) + "  " + sign);
            LogUtil.log(obJectToString(postPrepareBath));
            BaseBean<PostPrepareBathBean> baseBeanPostPrepareBath = this.mProtocol.postPrepareBath(postPrepareBath, sign);
            if (baseBeanPostPrepareBath.ok() && baseBeanPostPrepareBath.Data != null) {
                return baseBeanPostPrepareBath.Data;
            }
            throw HttpException.filter(baseBeanPostPrepareBath.Code, baseBeanPostPrepareBath.getErrMsg(), baseBeanPostPrepareBath.Data, baseBeanPostPrepareBath.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public Object postOpenAuth(int i, int i2, String str, String str2, String str3, MachineInfoJson machineInfoJson) throws HttpException {
        BaseBean<Object> baseBeanPostOpenAuthWash;
        try {
            PostPrepareBath postPrepareBath = new PostPrepareBath();
            postPrepareBath.channelWay = i;
            postPrepareBath.typeId = i2;
            postPrepareBath.deviceVer = str;
            postPrepareBath.machineId = str2;
            postPrepareBath.firmwareVer = str3;
            postPrepareBath.machineInfoJson = machineInfoJson;
            String sign = getSign(obJectToString(postPrepareBath));
            LogUtil.d(TAG, obJectToString(postPrepareBath) + "  " + sign);
            LogUtil.log(obJectToString(postPrepareBath));
            if (i2 == 3 || i2 == 16) {
                baseBeanPostOpenAuthWash = this.mProtocol.postOpenAuthWash(postPrepareBath, sign);
            } else if (i2 == 6) {
                baseBeanPostOpenAuthWash = this.mProtocol.postOpenAuthDrink(postPrepareBath, sign);
            } else if (i2 == 8) {
                baseBeanPostOpenAuthWash = this.mProtocol.postOpenAuthHairdryer(postPrepareBath, sign);
            } else {
                baseBeanPostOpenAuthWash = this.mProtocol.postOpenAuth(postPrepareBath, sign);
            }
            if (baseBeanPostOpenAuthWash.ok() && baseBeanPostOpenAuthWash.Data != null) {
                return baseBeanPostOpenAuthWash.Data;
            }
            throw HttpException.filter(baseBeanPostOpenAuthWash.Code, baseBeanPostOpenAuthWash.getErrMsg(), baseBeanPostOpenAuthWash.Data, baseBeanPostOpenAuthWash.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public Object postCloseAuth(int i, int i2, String str, String str2, MachineInfoJson machineInfoJson) throws HttpException {
        try {
            PostPrepareBath postPrepareBath = new PostPrepareBath();
            postPrepareBath.channelWay = i;
            postPrepareBath.typeId = i2;
            postPrepareBath.deviceVer = str;
            postPrepareBath.machineId = str2;
            postPrepareBath.machineInfoJson = machineInfoJson;
            String sign = getSign(obJectToString(postPrepareBath));
            LogUtil.d(TAG, obJectToString(postPrepareBath) + "  " + sign);
            LogUtil.log(obJectToString(postPrepareBath));
            BaseBean<Object> baseBeanPostCloseAuth = this.mProtocol.postCloseAuth(postPrepareBath, sign);
            if (baseBeanPostCloseAuth.ok() && baseBeanPostCloseAuth.Data != null) {
                return baseBeanPostCloseAuth.Data;
            }
            throw HttpException.filter(baseBeanPostCloseAuth.Code, baseBeanPostCloseAuth.getErrMsg(), baseBeanPostCloseAuth.Data, baseBeanPostCloseAuth.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public NBOr4GStatuBean getNBOr4GStatus(int i, String str, int i2, String str2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("typeId", i + "");
            v3CombindBean.combind("machineId", str);
            v3CombindBean.combind("modeValue", i2 + "");
            v3CombindBean.combind("communicationVal", str2);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<NBOr4GStatuBean> nBOr4GStatus = this.mProtocol.getNBOr4GStatus(i, str, i2, str2, sign);
            if (nBOr4GStatus.ok()) {
                return nBOr4GStatus.Data;
            }
            throw HttpException.filter(nBOr4GStatus.Code, nBOr4GStatus.Message, nBOr4GStatus.Data, nBOr4GStatus.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public Object postHandleData(int i, String str, String str2, NBOr4GDevice nBOr4GDevice, int i2) throws HttpException {
        BaseBean<Object> baseBeanPostHandleDataWash;
        try {
            UpLoadData upLoadData = new UpLoadData();
            upLoadData.typeId = i;
            upLoadData.channelWay = "1";
            upLoadData.deviceVer = str2;
            upLoadData.machineId = str;
            upLoadData.machineInfoJson = nBOr4GDevice;
            upLoadData.openClientType = Integer.valueOf(i2);
            String sign = getSign(obJectToString(upLoadData));
            LogUtil.d(TAG, obJectToString(upLoadData) + "  " + sign);
            LogUtil.log(obJectToString(upLoadData));
            if (i == 3 || i == 16) {
                baseBeanPostHandleDataWash = this.mProtocol.postHandleDataWash(upLoadData, sign);
            } else if (i == 6) {
                baseBeanPostHandleDataWash = this.mProtocol.postHandleDataDrink(upLoadData, sign);
            } else if (i == 8) {
                baseBeanPostHandleDataWash = this.mProtocol.postHandleDataHairdryer(upLoadData, sign);
            } else {
                baseBeanPostHandleDataWash = this.mProtocol.postHandleData(upLoadData, sign);
            }
            if (baseBeanPostHandleDataWash.ok() && baseBeanPostHandleDataWash.Data != null) {
                return baseBeanPostHandleDataWash.Data;
            }
            throw HttpException.filter(baseBeanPostHandleDataWash.Code, baseBeanPostHandleDataWash.Message, baseBeanPostHandleDataWash.Data, baseBeanPostHandleDataWash.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public GetModeBean postGetMode(int i, String str, String str2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("typeId", i + "");
            v3CombindBean.combind("machineId", str);
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str2);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<GetModeBean> baseBeanPostGetMode = this.mProtocol.postGetMode(i, str, str2, sign);
            if (baseBeanPostGetMode.ok()) {
                return baseBeanPostGetMode.Data;
            }
            throw HttpException.filter(baseBeanPostGetMode.Code, baseBeanPostGetMode.Message, baseBeanPostGetMode.Data, baseBeanPostGetMode.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DMHandleDataBean postDMHandleData(int i, String str, String str2) throws HttpException {
        try {
            DMHandleData dMHandleData = new DMHandleData();
            dMHandleData.typeId = i;
            dMHandleData.machineId = str;
            dMHandleData.machineData = str2;
            String sign = getSign(obJectToString(dMHandleData));
            LogUtil.d(TAG, obJectToString(dMHandleData) + "  " + sign);
            LogUtil.log(obJectToString(dMHandleData));
            BaseBean<DMHandleDataBean> baseBeanPostDMHandleData = this.mProtocol.postDMHandleData(dMHandleData, sign);
            if (baseBeanPostDMHandleData.ok()) {
                return baseBeanPostDMHandleData.Data;
            }
            throw HttpException.filter(baseBeanPostDMHandleData.Code, baseBeanPostDMHandleData.Message, baseBeanPostDMHandleData.Data, baseBeanPostDMHandleData.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DMGetOrderBean postDMGetOrder(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2, int i3, int i4, int i5, int i6, String str7) throws HttpException {
        try {
            DMGetOrder dMGetOrder = new DMGetOrder();
            dMGetOrder.investorId = str;
            dMGetOrder.schoolId = str2;
            dMGetOrder.studentId = str3;
            dMGetOrder.typeId = i;
            dMGetOrder.studentName = str4;
            dMGetOrder.studentMobile = str5;
            dMGetOrder.machineId = str6;
            dMGetOrder.price = i2;
            dMGetOrder.paymentFlag = i3;
            dMGetOrder.payFlag = i4;
            dMGetOrder.payFlagType = i5;
            dMGetOrder.siteFlag = i6;
            dMGetOrder.siteId = str7;
            String sign = getSign(obJectToString(dMGetOrder));
            LogUtil.d(TAG, obJectToString(dMGetOrder) + "  " + sign);
            LogUtil.log(obJectToString(dMGetOrder));
            BaseBean<DMGetOrderBean> baseBeanPostDMGetOrder = this.mProtocol.postDMGetOrder(dMGetOrder, sign);
            if (baseBeanPostDMGetOrder.Data != null && (baseBeanPostDMGetOrder.ok() || (baseBeanPostDMGetOrder.Code == -52 && baseBeanPostDMGetOrder.Data.hasUnRechargeOrder))) {
                return baseBeanPostDMGetOrder.Data;
            }
            throw HttpException.filter(baseBeanPostDMGetOrder.Code, baseBeanPostDMGetOrder.Message, baseBeanPostDMGetOrder.Data, baseBeanPostDMGetOrder.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DMGetQrcodeBean getDMChargeQRCode(int i, String str, String str2, int i2, String str3) throws HttpException {
        try {
            DMGetQrcode dMGetQrcode = new DMGetQrcode();
            dMGetQrcode.typeId = i;
            dMGetQrcode.machineId = str;
            dMGetQrcode.machineData = str2;
            dMGetQrcode.chargeMoney = i2;
            dMGetQrcode.orderId = str3;
            String sign = getSign(obJectToString(dMGetQrcode));
            LogUtil.d(TAG, obJectToString(dMGetQrcode) + "  " + sign);
            LogUtil.log(obJectToString(dMGetQrcode));
            BaseBean<DMGetQrcodeBean> dMChargeQRCode = this.mProtocol.getDMChargeQRCode(dMGetQrcode, sign);
            if (dMChargeQRCode.ok() && dMChargeQRCode.Data != null) {
                return dMChargeQRCode.Data;
            }
            throw HttpException.filter(dMChargeQRCode.Code, dMChargeQRCode.Message, dMChargeQRCode.Data, dMChargeQRCode.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DMGetQrcodeBean postDMRemoveData(int i, String str, String str2) throws HttpException {
        try {
            DMHandleData dMHandleData = new DMHandleData();
            dMHandleData.typeId = i;
            dMHandleData.machineId = str;
            dMHandleData.machineData = str2;
            String sign = getSign(obJectToString(dMHandleData));
            LogUtil.d(TAG, obJectToString(dMHandleData) + "  " + sign);
            LogUtil.log(obJectToString(dMHandleData));
            BaseBean<DMGetQrcodeBean> baseBeanPostDMRemoveData = this.mProtocol.postDMRemoveData(dMHandleData, sign);
            if (baseBeanPostDMRemoveData.ok() && baseBeanPostDMRemoveData.Data != null) {
                return baseBeanPostDMRemoveData.Data;
            }
            throw HttpException.filter(baseBeanPostDMRemoveData.Code, baseBeanPostDMRemoveData.Message, baseBeanPostDMRemoveData.Data, baseBeanPostDMRemoveData.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BluetoothSetBean postMachineRunInfo(int i, String str, String str2, MachineStatusData machineStatusData) throws HttpException {
        BaseBean<BluetoothSetBean> baseBeanPostMachineRunInfoWashing;
        try {
            MachineRunInfo machineRunInfo = new MachineRunInfo();
            machineRunInfo.typeId = i;
            machineRunInfo.deviceVer = str2;
            machineRunInfo.machineId = str;
            machineRunInfo.machineStatusData = machineStatusData;
            String sign = getSign(obJectToString(machineRunInfo));
            LogUtil.d(TAG, obJectToString(machineRunInfo) + "  " + sign);
            LogUtil.log(obJectToString(machineRunInfo));
            if (i == 3 || i == 16) {
                baseBeanPostMachineRunInfoWashing = this.mProtocol.postMachineRunInfoWashing(machineRunInfo, sign);
            } else if (i == 6) {
                baseBeanPostMachineRunInfoWashing = this.mProtocol.postMachineRunInfoDrink(machineRunInfo, sign);
            } else if (i == 8) {
                baseBeanPostMachineRunInfoWashing = this.mProtocol.postMachineRunInfoHairdryer(machineRunInfo, sign);
            } else {
                baseBeanPostMachineRunInfoWashing = this.mProtocol.postMachineRunInfo(machineRunInfo, sign);
            }
            if (baseBeanPostMachineRunInfoWashing.ok()) {
                return baseBeanPostMachineRunInfoWashing.Data;
            }
            throw HttpException.filter(baseBeanPostMachineRunInfoWashing.Code, baseBeanPostMachineRunInfoWashing.Message, baseBeanPostMachineRunInfoWashing.Data, baseBeanPostMachineRunInfoWashing.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BluetoothSetBean postBluetoothSetData(int i, String str, String str2, SetData setData) throws HttpException {
        BaseBean<BluetoothSetBean> baseBeanPostBluetoothSetDataWashing;
        try {
            SetRateUpload setRateUpload = new SetRateUpload();
            setRateUpload.typeId = i;
            setRateUpload.channelWay = "1";
            setRateUpload.deviceVer = str2;
            setRateUpload.machineId = str;
            setRateUpload.machineInfoJson = setData;
            String sign = getSign(obJectToString(setRateUpload));
            LogUtil.d(TAG, obJectToString(setRateUpload) + "  " + sign);
            LogUtil.log(obJectToString(setRateUpload));
            if (i == 3 || i == 16) {
                baseBeanPostBluetoothSetDataWashing = this.mProtocol.postBluetoothSetDataWashing(setRateUpload, sign);
            } else if (i == 6) {
                baseBeanPostBluetoothSetDataWashing = this.mProtocol.postBluetoothSetDataDrink(setRateUpload, sign);
            } else if (i == 8) {
                baseBeanPostBluetoothSetDataWashing = this.mProtocol.postBluetoothSetDataHairdryer(setRateUpload, sign);
            } else {
                baseBeanPostBluetoothSetDataWashing = this.mProtocol.postBluetoothSetData(setRateUpload, sign);
            }
            if (baseBeanPostBluetoothSetDataWashing.ok()) {
                return baseBeanPostBluetoothSetDataWashing.Data;
            }
            throw HttpException.filter(baseBeanPostBluetoothSetDataWashing.Code, baseBeanPostBluetoothSetDataWashing.Message, baseBeanPostBluetoothSetDataWashing.Data, baseBeanPostBluetoothSetDataWashing.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postBluetoothSetDataResult(int i, String str, String str2) throws HttpException {
        BaseBean<SuccessBean> baseBeanPostBluetoothSetDataResultWashing;
        try {
            SetResult setResult = new SetResult();
            setResult.typeId = i;
            setResult.parFlag = str2;
            setResult.machineId = str;
            String sign = getSign(obJectToString(setResult));
            LogUtil.d(TAG, obJectToString(setResult) + "  " + sign);
            LogUtil.log(obJectToString(setResult));
            if (i == 3 || i == 16) {
                baseBeanPostBluetoothSetDataResultWashing = this.mProtocol.postBluetoothSetDataResultWashing(setResult, sign);
            } else if (i == 6) {
                baseBeanPostBluetoothSetDataResultWashing = this.mProtocol.postBluetoothSetDataResultDrink(setResult, sign);
            } else if (i == 8) {
                baseBeanPostBluetoothSetDataResultWashing = this.mProtocol.postBluetoothSetDataResultHairdryer(setResult, sign);
            } else {
                baseBeanPostBluetoothSetDataResultWashing = this.mProtocol.postBluetoothSetDataResult(setResult, sign);
            }
            if (baseBeanPostBluetoothSetDataResultWashing.ok()) {
                return baseBeanPostBluetoothSetDataResultWashing.Data;
            }
            throw HttpException.filter(baseBeanPostBluetoothSetDataResultWashing.Code, baseBeanPostBluetoothSetDataResultWashing.Message, baseBeanPostBluetoothSetDataResultWashing.Data, baseBeanPostBluetoothSetDataResultWashing.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<AreaListBean> getLowerAreas(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("areaId", str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<List<AreaListBean>> lowerAreas = this.mProtocol.getLowerAreas(str, sign);
            if (lowerAreas.ok()) {
                return lowerAreas.Data;
            }
            throw HttpException.filter(lowerAreas.Code, lowerAreas.getErrMsg(), lowerAreas.Data, lowerAreas.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<AreaListBean> getDormitoryOrPublicRoom(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("areaId", str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<List<AreaListBean>> dormitoryOrPublicRoom = this.mProtocol.getDormitoryOrPublicRoom(str, sign);
            if (dormitoryOrPublicRoom.ok()) {
                return dormitoryOrPublicRoom.Data;
            }
            throw HttpException.filter(dormitoryOrPublicRoom.Code, dormitoryOrPublicRoom.getErrMsg(), dormitoryOrPublicRoom.Data, dormitoryOrPublicRoom.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<MachineByLocationBean> postGetMachineByLocation(String str, int i, int i2) throws HttpException {
        try {
            MachineByLocation machineByLocation = new MachineByLocation();
            machineByLocation.typeId = i2;
            machineByLocation.siteFlag = i;
            machineByLocation.siteId = str;
            String sign = getSign(obJectToString(machineByLocation));
            LogUtil.d(TAG, obJectToString(machineByLocation) + "  " + sign);
            LogUtil.log(obJectToString(machineByLocation));
            BaseBean<List<MachineByLocationBean>> baseBeanPostGetMachineByLocation = this.mProtocol.postGetMachineByLocation(machineByLocation, sign);
            if (baseBeanPostGetMachineByLocation.ok() && baseBeanPostGetMachineByLocation.Data != null) {
                return baseBeanPostGetMachineByLocation.Data;
            }
            throw HttpException.filter(baseBeanPostGetMachineByLocation.Code, baseBeanPostGetMachineByLocation.Message, baseBeanPostGetMachineByLocation.Data, baseBeanPostGetMachineByLocation.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public OrderRecordBean getOrderList(String str, int i, int i2, int i3, String str2, String str3, int i4) throws HttpException {
        try {
            OrderRecord orderRecord = new OrderRecord();
            orderRecord.schoolId = str;
            orderRecord.currentPage = i3;
            orderRecord.selectFlag = i2;
            orderRecord.typeId = i;
            orderRecord.payCode = 1;
            if (i == 18) {
                orderRecord.machineId = str2;
                orderRecord.siteFlag = Integer.valueOf(i4);
                orderRecord.siteId = str3;
            }
            String sign = getSign(obJectToString(orderRecord));
            LogUtil.d(TAG, obJectToString(orderRecord) + "  " + sign);
            LogUtil.log(obJectToString(orderRecord));
            BaseBean<OrderRecordBean> orderList = this.mProtocol.getOrderList(orderRecord, sign);
            if (orderList.ok()) {
                return orderList.Data;
            }
            throw HttpException.filter(orderList.Code, orderList.getErrMsg(), orderList.Data, orderList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public OrderMoreDetailBean getOrderIdInfo(String str, int i, String str2, String str3, String str4, String str5, int i2) throws HttpException {
        try {
            OrderRecord orderRecord = new OrderRecord();
            orderRecord.schoolId = str;
            orderRecord.typeId = i;
            orderRecord.investorId = str2;
            orderRecord.orderId = str3;
            String sign = getSign(obJectToString(orderRecord));
            LogUtil.d(TAG, obJectToString(orderRecord) + "  " + sign);
            LogUtil.log(obJectToString(orderRecord));
            BaseBean<OrderMoreDetailBean> orderIdInfo = this.mProtocol.getOrderIdInfo(orderRecord, sign);
            if (orderIdInfo.ok() && orderIdInfo.Data != null) {
                return orderIdInfo.Data;
            }
            throw HttpException.filter(orderIdInfo.Code, orderIdInfo.getErrMsg(), orderIdInfo.Data, orderIdInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DMOrderRecordBean getOrderIntegration(String str, String str2, int i, int i2, int i3, int i4) throws HttpException {
        try {
            DMOrder dMOrder = new DMOrder();
            dMOrder.schoolId = str;
            dMOrder.investorId = str2;
            dMOrder.currentPage = i3;
            dMOrder.selectFlag = i2;
            dMOrder.typeId = i;
            dMOrder.orderType = i4;
            String sign = getSign(obJectToString(dMOrder));
            LogUtil.d(TAG, obJectToString(dMOrder) + "  " + sign);
            LogUtil.log(obJectToString(dMOrder));
            BaseBean<DMOrderRecordBean> orderIntegration = this.mProtocol.getOrderIntegration(dMOrder, sign);
            if (orderIntegration.ok()) {
                return orderIntegration.Data;
            }
            throw HttpException.filter(orderIntegration.Code, orderIntegration.getErrMsg(), orderIntegration.Data, orderIntegration.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public NoPayOrderListBean getNoPayOrders(String str, int i, String str2, String str3, String str4, String str5, int i2) throws HttpException {
        try {
            OrderRecord orderRecord = new OrderRecord();
            orderRecord.schoolId = str;
            orderRecord.investorId = str2;
            orderRecord.studentId = str3;
            orderRecord.typeId = i;
            if (i == 18) {
                orderRecord.machineId = str4;
                orderRecord.siteFlag = Integer.valueOf(i2);
                orderRecord.siteId = str5;
            }
            String sign = getSign(obJectToString(orderRecord));
            LogUtil.d(TAG, obJectToString(orderRecord) + "  " + sign);
            LogUtil.log(obJectToString(orderRecord));
            BaseBean<NoPayOrderListBean> noPayOrders = this.mProtocol.getNoPayOrders(orderRecord, sign);
            if (noPayOrders.ok()) {
                return noPayOrders.Data;
            }
            throw HttpException.filter(noPayOrders.Code, noPayOrders.getErrMsg(), noPayOrders.Data, noPayOrders.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public NoPayOrderResultBean postPayOrders(String str, String str2, int i, int i2, int i3, List<NoPayOrderBean> list, String str3, String str4, int i4) throws HttpException {
        try {
            PayOrder payOrder = new PayOrder();
            payOrder.schoolId = str;
            payOrder.investorId = str2;
            payOrder.paymentFlag = i;
            payOrder.payFlag = i2;
            payOrder.payFlagType = i3;
            payOrder.orderInfo = list;
            payOrder.machineId = str3;
            payOrder.siteFlag = Integer.valueOf(i4);
            payOrder.siteId = str4;
            String sign = getSign(obJectToString(payOrder));
            LogUtil.d(TAG, obJectToString(payOrder) + "  " + sign);
            LogUtil.log(obJectToString(payOrder));
            BaseBean<NoPayOrderResultBean> baseBeanPostPayOrders = this.mProtocol.postPayOrders(payOrder, sign);
            if (!baseBeanPostPayOrders.ok() && (baseBeanPostPayOrders.Code != -45 || baseBeanPostPayOrders.Data == null || !baseBeanPostPayOrders.Data.hasUnPayMergeOrder)) {
                throw HttpException.filter(baseBeanPostPayOrders.Code, baseBeanPostPayOrders.getErrMsg(), baseBeanPostPayOrders.Data, baseBeanPostPayOrders.Serial);
            }
            NoPayOrderResultBean noPayOrderResultBean = new NoPayOrderResultBean();
            noPayOrderResultBean.payInfo = baseBeanPostPayOrders.Data.payInfo;
            noPayOrderResultBean.hasUnPayMergeOrder = baseBeanPostPayOrders.Data.hasUnPayMergeOrder;
            noPayOrderResultBean.statusFlag = baseBeanPostPayOrders.Data.statusFlag;
            noPayOrderResultBean.createTime = baseBeanPostPayOrders.Data.createTime;
            noPayOrderResultBean.mergeOrderId = baseBeanPostPayOrders.Data.mergeOrderId;
            noPayOrderResultBean.msg = baseBeanPostPayOrders.Message;
            noPayOrderResultBean.orderId = baseBeanPostPayOrders.Data.orderId;
            noPayOrderResultBean.orderInfo = baseBeanPostPayOrders.Data.orderInfo;
            noPayOrderResultBean.totalPrice = baseBeanPostPayOrders.Data.totalPrice;
            noPayOrderResultBean.payFlagType = baseBeanPostPayOrders.Data.payFlagType;
            noPayOrderResultBean.paymentFlag = baseBeanPostPayOrders.Data.paymentFlag;
            noPayOrderResultBean.payFlag = baseBeanPostPayOrders.Data.payFlag;
            return noPayOrderResultBean;
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public Object postCancelPayOrders(String str, String str2) throws HttpException {
        try {
            InvestoridAndSchoolId investoridAndSchoolId = new InvestoridAndSchoolId();
            investoridAndSchoolId.schoolId = str;
            investoridAndSchoolId.investorId = str2;
            String sign = getSign(obJectToString(investoridAndSchoolId));
            LogUtil.d(TAG, obJectToString(investoridAndSchoolId) + "  " + sign);
            LogUtil.log(obJectToString(investoridAndSchoolId));
            BaseBean<Object> baseBeanPostCancelPayOrders = this.mProtocol.postCancelPayOrders(investoridAndSchoolId, sign);
            if (baseBeanPostCancelPayOrders.ok()) {
                return baseBeanPostCancelPayOrders.Data;
            }
            throw HttpException.filter(baseBeanPostCancelPayOrders.Code, baseBeanPostCancelPayOrders.getErrMsg(), baseBeanPostCancelPayOrders.Data, baseBeanPostCancelPayOrders.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SchoolIdBean getAnalysisQRCode(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("QRCode", str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<SchoolIdBean> analysisQRCode = this.mProtocol.getAnalysisQRCode(str, sign);
            if (analysisQRCode.ok() && analysisQRCode != null) {
                return analysisQRCode.Data;
            }
            throw HttpException.filter(analysisQRCode.Code, analysisQRCode.getErrMsg(), analysisQRCode.Data, analysisQRCode.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postBindSchoolInfo(String str, String str2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            v3CombindBean.combind("studentNumber", str2);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<SuccessBean> baseBeanPostBindSchoolInfo = this.mProtocol.postBindSchoolInfo(str, str2, sign);
            if (baseBeanPostBindSchoolInfo.ok()) {
                return baseBeanPostBindSchoolInfo.Data;
            }
            throw HttpException.filter(baseBeanPostBindSchoolInfo.Code, baseBeanPostBindSchoolInfo.getErrMsg(), baseBeanPostBindSchoolInfo.Data, baseBeanPostBindSchoolInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<SchoolInfosBean> getListByAreaInfo(String str, String str2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("province", str);
            v3CombindBean.combind(a.p, str2);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<List<SchoolInfosBean>> listByAreaInfo = this.mProtocol.getListByAreaInfo(str, str2, sign);
            if (listByAreaInfo.ok()) {
                return listByAreaInfo.Data;
            }
            throw HttpException.filter(listByAreaInfo.Code, listByAreaInfo.getErrMsg(), listByAreaInfo.Data, listByAreaInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SchoolQrcodeBean getQRCodeBySchoolId(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("id", str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<SchoolQrcodeBean> qRCodeBySchoolId = this.mProtocol.getQRCodeBySchoolId(str, sign);
            if (qRCodeBySchoolId.ok()) {
                return qRCodeBySchoolId.Data;
            }
            throw HttpException.filter(qRCodeBySchoolId.Code, qRCodeBySchoolId.getErrMsg(), qRCodeBySchoolId.Data, qRCodeBySchoolId.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public MobileMessageBean getMoblieMessage(String str, int i, String str2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("studentMobile", str);
            v3CombindBean.combind("funFlag", i + "");
            v3CombindBean.combind("platform", "1");
            v3CombindBean.combind("verificationCode", str2);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<MobileMessageBean> moblieMessageV2 = this.mProtocol.getMoblieMessageV2(str, i, 1, str2, sign);
            if (moblieMessageV2.ok()) {
                return moblieMessageV2.Data;
            }
            throw HttpException.filter(moblieMessageV2.Code, moblieMessageV2.getErrMsg(), moblieMessageV2.Data, moblieMessageV2.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postMoblieRegisterUser(String str, String str2, String str3, String str4, String str5) throws HttpException {
        try {
            MobileRegisterUser mobileRegisterUser = new MobileRegisterUser();
            mobileRegisterUser.authenticationMessage = str;
            mobileRegisterUser.loginPassword = str2;
            mobileRegisterUser.studentMobile = str3;
            mobileRegisterUser.studentName = str4;
            mobileRegisterUser.schoolId = str5;
            UserAesData userAesData = new UserAesData();
            userAesData.data = getBase64Encode(obJectToString(mobileRegisterUser));
            String sign = getSign(obJectToString(userAesData));
            LogUtil.d(TAG, obJectToString(mobileRegisterUser) + "  " + sign);
            LogUtil.log(obJectToString(mobileRegisterUser));
            BaseBean<SuccessBean> baseBeanPostMoblieRegisterUserAes = this.mProtocol.postMoblieRegisterUserAes(userAesData, sign);
            if (baseBeanPostMoblieRegisterUserAes.ok()) {
                return baseBeanPostMoblieRegisterUserAes.Data;
            }
            throw HttpException.filter(baseBeanPostMoblieRegisterUserAes.Code, baseBeanPostMoblieRegisterUserAes.getErrMsg(), baseBeanPostMoblieRegisterUserAes.Data, baseBeanPostMoblieRegisterUserAes.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postLoginPasswordByAuthenticationMessage(String str, String str2, String str3) throws HttpException {
        try {
            MobileRegisterUser mobileRegisterUser = new MobileRegisterUser();
            mobileRegisterUser.authenticationMessage = str;
            mobileRegisterUser.newLoginPassword = str2;
            mobileRegisterUser.studentMobile = str3;
            UserAesData userAesData = new UserAesData();
            userAesData.data = getBase64Encode(obJectToString(mobileRegisterUser));
            String sign = getSign(obJectToString(userAesData));
            LogUtil.d(TAG, obJectToString(mobileRegisterUser) + "  " + sign);
            LogUtil.log(obJectToString(mobileRegisterUser));
            BaseBean<SuccessBean> baseBeanPostLoginPasswordByAuthenticationMessageAes = this.mProtocol.postLoginPasswordByAuthenticationMessageAes(userAesData, sign);
            if (baseBeanPostLoginPasswordByAuthenticationMessageAes.ok()) {
                return baseBeanPostLoginPasswordByAuthenticationMessageAes.Data;
            }
            throw HttpException.filter(baseBeanPostLoginPasswordByAuthenticationMessageAes.Code, baseBeanPostLoginPasswordByAuthenticationMessageAes.getErrMsg(), baseBeanPostLoginPasswordByAuthenticationMessageAes.Data, baseBeanPostLoginPasswordByAuthenticationMessageAes.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postStudentMobileByAuthenticationMessage(String str, String str2, String str3) throws HttpException {
        try {
            ChangePhone changePhone = new ChangePhone();
            changePhone.newAuthenticationMessage = str;
            changePhone.oldAuthenticationMessage = str2;
            changePhone.setMobile = str3;
            String sign = getSign(obJectToString(changePhone));
            LogUtil.d(TAG, obJectToString(changePhone) + "  " + sign);
            LogUtil.log(obJectToString(changePhone));
            BaseBean<SuccessBean> baseBeanPostStudentMobileByAuthenticationMessage = this.mProtocol.postStudentMobileByAuthenticationMessage(changePhone, sign);
            if (baseBeanPostStudentMobileByAuthenticationMessage.ok()) {
                return baseBeanPostStudentMobileByAuthenticationMessage.Data;
            }
            throw HttpException.filter(baseBeanPostStudentMobileByAuthenticationMessage.Code, baseBeanPostStudentMobileByAuthenticationMessage.getErrMsg(), baseBeanPostStudentMobileByAuthenticationMessage.Data, baseBeanPostStudentMobileByAuthenticationMessage.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postResetLoginPassword(String str, String str2) throws HttpException {
        try {
            MobileRegisterUser mobileRegisterUser = new MobileRegisterUser();
            mobileRegisterUser.newLoginPassword = str;
            mobileRegisterUser.oldloginPassword = str2;
            UserAesData userAesData = new UserAesData();
            userAesData.data = getBase64Encode(obJectToString(mobileRegisterUser));
            String sign = getSign(obJectToString(userAesData));
            LogUtil.d(TAG, obJectToString(mobileRegisterUser) + "  " + sign);
            LogUtil.log(obJectToString(mobileRegisterUser));
            BaseBean<SuccessBean> baseBeanPostResetLoginPasswordAes = this.mProtocol.postResetLoginPasswordAes(userAesData, sign);
            if (baseBeanPostResetLoginPasswordAes.ok()) {
                return baseBeanPostResetLoginPasswordAes.Data;
            }
            throw HttpException.filter(baseBeanPostResetLoginPasswordAes.Code, baseBeanPostResetLoginPasswordAes.getErrMsg(), baseBeanPostResetLoginPasswordAes.Data, baseBeanPostResetLoginPasswordAes.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean getDelayedPassword() throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<SuccessBean> delayedPassword = this.mProtocol.getDelayedPassword(sign);
            if (delayedPassword.ok()) {
                return delayedPassword.Data;
            }
            throw HttpException.filter(delayedPassword.Code, delayedPassword.getErrMsg(), delayedPassword.Data, delayedPassword.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public PswBean getFindMachiniePWD(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<PswBean> findMachiniePWD = this.mProtocol.getFindMachiniePWD(str, sign);
            if (findMachiniePWD.ok()) {
                return findMachiniePWD.Data;
            }
            throw HttpException.filter(findMachiniePWD.Code, findMachiniePWD.getErrMsg(), findMachiniePWD.Data, findMachiniePWD.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public PswBean postSetMachinePWD(String str, String str2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            v3CombindBean.combind("setPassword", str2);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<PswBean> baseBeanPostSetMachinePWD = this.mProtocol.postSetMachinePWD(str, str2, sign);
            if (baseBeanPostSetMachinePWD.ok()) {
                return baseBeanPostSetMachinePWD.Data;
            }
            throw HttpException.filter(baseBeanPostSetMachinePWD.Code, baseBeanPostSetMachinePWD.getErrMsg(), baseBeanPostSetMachinePWD.Data, baseBeanPostSetMachinePWD.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public PswBean postUpdateMachinePWD(String str, String str2, String str3) throws HttpException {
        try {
            SetMachinePWD setMachinePWD = new SetMachinePWD();
            setMachinePWD.schoolId = str;
            setMachinePWD.setPassword = str2;
            setMachinePWD.oldPassword = str3;
            String sign = getSign(obJectToString(setMachinePWD));
            LogUtil.d(TAG, obJectToString(setMachinePWD) + "  " + sign);
            LogUtil.log(obJectToString(setMachinePWD));
            BaseBean<PswBean> baseBeanPostUpdateMachinePWD = this.mProtocol.postUpdateMachinePWD(setMachinePWD, sign);
            if (baseBeanPostUpdateMachinePWD.ok()) {
                return baseBeanPostUpdateMachinePWD.Data;
            }
            throw HttpException.filter(baseBeanPostUpdateMachinePWD.Code, baseBeanPostUpdateMachinePWD.getErrMsg(), baseBeanPostUpdateMachinePWD.Data, baseBeanPostUpdateMachinePWD.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<CouponBean> getCouponList(String str, String str2, int i, int i2, int i3, int i4, String str3, String str4) throws HttpException {
        try {
            Coupon coupon = new Coupon();
            coupon.schoolId = str;
            coupon.investorId = str2;
            coupon.state = i;
            coupon.selectFlag = i2;
            coupon.couponType = i3;
            coupon.isRefund = i4;
            coupon.machineId = str3;
            coupon.studentId = str4;
            String sign = getSign(obJectToString(coupon));
            LogUtil.d(TAG, obJectToString(coupon) + "  " + sign);
            LogUtil.log(obJectToString(coupon));
            BaseBean<List<CouponBean>> couponList = this.mProtocol.getCouponList(coupon, sign);
            if (couponList.ok()) {
                return couponList.Data;
            }
            throw HttpException.filter(couponList.Code, couponList.getErrMsg(), couponList.Data, couponList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<ClubCardBean> getClubCardList(int i, int i2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("typeId", i + "");
            v3CombindBean.combind("flag", i2 + "");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<List<ClubCardBean>> clubCardList = this.mProtocol.getClubCardList(i, i2, sign);
            if (clubCardList.ok()) {
                return clubCardList.Data;
            }
            throw HttpException.filter(clubCardList.Code, clubCardList.getErrMsg(), clubCardList.Data, clubCardList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postActivate(String str, String str2, long j) throws HttpException {
        try {
            Activate activate = new Activate();
            activate.schoolId = str;
            activate.investorId = str2;
            activate.businessType = 3;
            activate.productId = j;
            String sign = getSign(obJectToString(activate));
            LogUtil.d(TAG, obJectToString(activate) + "  " + sign);
            LogUtil.log(obJectToString(activate));
            BaseBean<SuccessBean> baseBeanPostActivate = this.mProtocol.postActivate(activate, sign);
            if (baseBeanPostActivate.ok()) {
                return baseBeanPostActivate.Data;
            }
            throw HttpException.filter(baseBeanPostActivate.Code, baseBeanPostActivate.getErrMsg(), baseBeanPostActivate.Data, baseBeanPostActivate.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public CreateOrderBean postRefundCard(String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, String str7) throws HttpException {
        try {
            RefundCreateOrder refundCreateOrder = new RefundCreateOrder();
            refundCreateOrder.schoolId = str;
            refundCreateOrder.investorId = str2;
            refundCreateOrder.businessType = 3;
            refundCreateOrder.productId = str3;
            refundCreateOrder.price = i;
            refundCreateOrder.payFlagType = i2;
            refundCreateOrder.moblile = str4;
            refundCreateOrder.openId = str5;
            refundCreateOrder.contactName = str6;
            refundCreateOrder.f966client = str7;
            String sign = getSign(obJectToString(refundCreateOrder));
            LogUtil.d(TAG, obJectToString(refundCreateOrder) + "  " + sign);
            LogUtil.log(obJectToString(refundCreateOrder));
            BaseBean<CreateOrderBean> baseBeanPostRefundCard = this.mProtocol.postRefundCard(refundCreateOrder, sign);
            if (baseBeanPostRefundCard.ok()) {
                return baseBeanPostRefundCard.Data;
            }
            throw HttpException.filter(baseBeanPostRefundCard.Code, baseBeanPostRefundCard.getErrMsg(), baseBeanPostRefundCard.Data, baseBeanPostRefundCard.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public CreateOrderBean postCreateOrders(String str, String str2, int i, long j, long j2, int i2, int i3, YiKaTongPayModelParameterBean yiKaTongPayModelParameterBean) throws HttpException {
        try {
            CreateOrder createOrder = new CreateOrder();
            createOrder.schoolId = str;
            createOrder.investorId = str2;
            createOrder.businessType = i;
            createOrder.productId = j;
            createOrder.giveRulesId = j2;
            createOrder.price = i2;
            createOrder.payFlagType = i3;
            if (i3 == 7) {
                createOrder.modelType = "wideBodyGdccardPay";
                createOrder.payModelParameter = yiKaTongPayModelParameterBean;
            } else if (i3 == 3) {
                createOrder.modelType = "prePay";
            } else if (i3 == 12) {
                createOrder.payModelParameter = yiKaTongPayModelParameterBean;
            }
            String sign = getSign(obJectToString(createOrder));
            LogUtil.d(TAG, obJectToString(createOrder) + "  " + sign);
            LogUtil.log(obJectToString(createOrder));
            BaseBean<CreateOrderBean> baseBeanPostCreateOrders = this.mProtocol.postCreateOrders(createOrder, sign);
            if (baseBeanPostCreateOrders.ok() && baseBeanPostCreateOrders != null) {
                return baseBeanPostCreateOrders.Data;
            }
            throw HttpException.filter(baseBeanPostCreateOrders.Code, baseBeanPostCreateOrders.getErrMsg(), baseBeanPostCreateOrders.Data, baseBeanPostCreateOrders.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AppIdAndSecretBean getAppInfo(String str, String str2) throws HttpException {
        try {
            InvestoridAndSchoolId investoridAndSchoolId = new InvestoridAndSchoolId();
            investoridAndSchoolId.investorId = str;
            investoridAndSchoolId.schoolId = str2;
            String sign = getSign(obJectToString(investoridAndSchoolId));
            LogUtil.d(TAG, obJectToString(investoridAndSchoolId) + "  " + sign);
            LogUtil.log(obJectToString(investoridAndSchoolId));
            BaseBean<AppIdAndSecretBean> appInfo = this.mProtocol.getAppInfo(investoridAndSchoolId, sign);
            if (appInfo.ok() && appInfo.Data != null) {
                return appInfo.Data;
            }
            throw HttpException.filter(appInfo.Code, appInfo.getErrMsg(), appInfo.Data, appInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public CreateOrderBean postRefundOrders(String str, String str2, int i, String str3, int i2, int i3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) throws HttpException {
        BaseBean<CreateOrderBean> baseBeanPostRefundOrders;
        try {
            RefundCreateOrder refundCreateOrder = new RefundCreateOrder();
            refundCreateOrder.schoolId = str;
            refundCreateOrder.investorId = str2;
            refundCreateOrder.price = i2;
            refundCreateOrder.payFlagType = i3;
            refundCreateOrder.moblile = str4;
            refundCreateOrder.contactName = str5;
            refundCreateOrder.openId = str6;
            refundCreateOrder.f966client = str7;
            if (i == 3) {
                refundCreateOrder.productId = str3;
                refundCreateOrder.businessType = i;
            } else if (i == 7) {
                refundCreateOrder.studentId = str10;
            } else {
                refundCreateOrder.businessType = i;
                refundCreateOrder.productId = str3;
                refundCreateOrder.refundResoun = str8;
                refundCreateOrder.refundUrl = str9;
                refundCreateOrder.studentNumber = str11;
            }
            String sign = getSign(obJectToString(refundCreateOrder));
            LogUtil.d(TAG, obJectToString(refundCreateOrder) + "  " + sign);
            LogUtil.log(obJectToString(refundCreateOrder));
            if (i == 3) {
                baseBeanPostRefundOrders = this.mProtocol.postRefundCard(refundCreateOrder, sign);
            } else if (i == 7) {
                baseBeanPostRefundOrders = this.mProtocol.postRefundCashRedPackageOrders(refundCreateOrder, sign);
            } else {
                baseBeanPostRefundOrders = this.mProtocol.postRefundOrders(refundCreateOrder, sign);
            }
            if (baseBeanPostRefundOrders.ok()) {
                return baseBeanPostRefundOrders.Data;
            }
            throw HttpException.filter(baseBeanPostRefundOrders.Code, baseBeanPostRefundOrders.getErrMsg(), baseBeanPostRefundOrders.Data, baseBeanPostRefundOrders.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String postRefundPic(String str) throws HttpException {
        try {
            File file = new File(str);
            LogUtil.e(TAG, str);
            HashMap map = new HashMap();
            map.put("file\";filename=\"" + file.getName(), RequestBody.create(MediaType.parse(UrlHttpUtil.FILE_TYPE_IMAGE), file));
            BaseBean<String> baseBeanPostRefundPic = this.mProtocol.postRefundPic(map, "");
            if (baseBeanPostRefundPic.ok()) {
                return baseBeanPostRefundPic.Data;
            }
            throw HttpException.filter(baseBeanPostRefundPic.Code, baseBeanPostRefundPic.getErrMsg(), baseBeanPostRefundPic.Data, baseBeanPostRefundPic.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public CreateOrderBean postRevokeRefundOrders(String str, String str2, int i, String str3) throws HttpException {
        BaseBean<CreateOrderBean> baseBeanPostRevokeRefundOrders;
        try {
            RefundCreateOrder refundCreateOrder = new RefundCreateOrder();
            refundCreateOrder.schoolId = str;
            refundCreateOrder.investorId = str2;
            if (StringUtils.isNotEmpty(str3)) {
                refundCreateOrder.orderId = str3;
            } else {
                refundCreateOrder.businessType = i;
            }
            String sign = getSign(obJectToString(refundCreateOrder));
            LogUtil.d(TAG, obJectToString(refundCreateOrder) + "  " + sign);
            LogUtil.log(obJectToString(refundCreateOrder));
            if (StringUtils.isNotEmpty(str3)) {
                baseBeanPostRevokeRefundOrders = this.mProtocol.postRefundCashRedPackageOrdersCancel(refundCreateOrder, sign);
            } else {
                baseBeanPostRevokeRefundOrders = this.mProtocol.postRevokeRefundOrders(refundCreateOrder, sign);
            }
            if (baseBeanPostRevokeRefundOrders.ok()) {
                return baseBeanPostRevokeRefundOrders.Data;
            }
            throw HttpException.filter(baseBeanPostRevokeRefundOrders.Code, baseBeanPostRevokeRefundOrders.getErrMsg(), baseBeanPostRevokeRefundOrders.Data, baseBeanPostRevokeRefundOrders.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<BuyClubCardBean> getClubCardListByInvestorid(String str, String str2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str + "");
            v3CombindBean.combind("investorId", str2 + "");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<List<BuyClubCardBean>> clubCardListByInvestorid = this.mProtocol.getClubCardListByInvestorid(str, str2, sign);
            if (clubCardListByInvestorid.ok()) {
                return clubCardListByInvestorid.Data;
            }
            throw HttpException.filter(clubCardListByInvestorid.Code, clubCardListByInvestorid.getErrMsg(), clubCardListByInvestorid.Data, clubCardListByInvestorid.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BuyClubCradRecordBean getClubCardOrderList(String str, int i, int i2, int i3) throws HttpException {
        try {
            OrderRecord orderRecord = new OrderRecord();
            orderRecord.schoolId = str;
            orderRecord.currentPage = i3;
            orderRecord.selectFlag = i2;
            orderRecord.typeId = i;
            orderRecord.payCode = 1;
            String sign = getSign(obJectToString(orderRecord));
            LogUtil.d(TAG, obJectToString(orderRecord) + "  " + sign);
            LogUtil.log(obJectToString(orderRecord));
            BaseBean<BuyClubCradRecordBean> clubCardOrderList = this.mProtocol.getClubCardOrderList(orderRecord, sign);
            if (clubCardOrderList.ok()) {
                return clubCardOrderList.Data;
            }
            throw HttpException.filter(clubCardOrderList.Code, clubCardOrderList.getErrMsg(), clubCardOrderList.Data, clubCardOrderList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BuyClubCradRecordBean getWalletOrderList(String str, int i, int i2) throws HttpException {
        try {
            OrderRecord orderRecord = new OrderRecord();
            orderRecord.schoolId = str;
            orderRecord.currentPage = i2;
            orderRecord.selectFlag = i;
            String sign = getSign(obJectToString(orderRecord));
            LogUtil.d(TAG, obJectToString(orderRecord) + "  " + sign);
            LogUtil.log(obJectToString(orderRecord));
            BaseBean<BuyClubCradRecordBean> walletOrderList = this.mProtocol.getWalletOrderList(orderRecord, sign);
            if (walletOrderList.ok()) {
                return walletOrderList.Data;
            }
            throw HttpException.filter(walletOrderList.Code, walletOrderList.getErrMsg(), walletOrderList.Data, walletOrderList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BuyClubCradRecordBean getWalletRefundOrderList(String str, int i, int i2, int i3) throws HttpException {
        try {
            RefundOrderRecord refundOrderRecord = new RefundOrderRecord();
            refundOrderRecord.schoolId = str;
            refundOrderRecord.currentPage = i2;
            refundOrderRecord.selectFlag = i;
            refundOrderRecord.walletType = i3;
            String sign = getSign(obJectToString(refundOrderRecord));
            LogUtil.d(TAG, obJectToString(refundOrderRecord) + "  " + sign);
            LogUtil.log(obJectToString(refundOrderRecord));
            BaseBean<BuyClubCradRecordBean> walletRefundOrderList = this.mProtocol.getWalletRefundOrderList(refundOrderRecord, sign);
            if (walletRefundOrderList.ok()) {
                return walletRefundOrderList.Data;
            }
            throw HttpException.filter(walletRefundOrderList.Code, walletRefundOrderList.getErrMsg(), walletRefundOrderList.Data, walletRefundOrderList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WalletRefundDetailBean getRefundIdInfo(String str, String str2, String str3) throws HttpException {
        try {
            OrderRecord orderRecord = new OrderRecord();
            orderRecord.schoolId = str;
            orderRecord.investorId = str2;
            orderRecord.orderId = str3;
            String sign = getSign(obJectToString(orderRecord));
            LogUtil.d(TAG, obJectToString(orderRecord) + "  " + sign);
            LogUtil.log(obJectToString(orderRecord));
            BaseBean<WalletRefundDetailBean> refundIdInfo = this.mProtocol.getRefundIdInfo(orderRecord, sign);
            if (refundIdInfo.ok() && refundIdInfo != null) {
                return refundIdInfo.Data;
            }
            throw HttpException.filter(refundIdInfo.Code, refundIdInfo.getErrMsg(), refundIdInfo.Data, refundIdInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public WalletRefundDetailBean getSurrenderIdInfo(String str, String str2, String str3) throws HttpException {
        try {
            OrderRecord orderRecord = new OrderRecord();
            orderRecord.schoolId = str;
            orderRecord.investorId = str2;
            orderRecord.orderId = str3;
            String sign = getSign(obJectToString(orderRecord));
            LogUtil.d(TAG, obJectToString(orderRecord) + "  " + sign);
            LogUtil.log(obJectToString(orderRecord));
            BaseBean<WalletRefundDetailBean> surrenderIdInfo = this.mProtocol.getSurrenderIdInfo(orderRecord, sign);
            if (surrenderIdInfo.ok() && surrenderIdInfo != null) {
                return surrenderIdInfo.Data;
            }
            throw HttpException.filter(surrenderIdInfo.Code, surrenderIdInfo.getErrMsg(), surrenderIdInfo.Data, surrenderIdInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DepositRechargeRecordBean getDepositOrderList(String str, String str2) throws HttpException {
        try {
            OrderRecord orderRecord = new OrderRecord();
            orderRecord.schoolId = str;
            orderRecord.investorId = str2;
            String sign = getSign(obJectToString(orderRecord));
            LogUtil.d(TAG, obJectToString(orderRecord) + "  " + sign);
            LogUtil.log(obJectToString(orderRecord));
            BaseBean<DepositRechargeRecordBean> depositOrderList = this.mProtocol.getDepositOrderList(orderRecord, sign);
            if (depositOrderList.ok()) {
                return depositOrderList.Data;
            }
            throw HttpException.filter(depositOrderList.Code, depositOrderList.getErrMsg(), depositOrderList.Data, depositOrderList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BuyClubCradRecordBean getDepositRefundOrderList(String str, int i, int i2) throws HttpException {
        try {
            OrderRecord orderRecord = new OrderRecord();
            orderRecord.schoolId = str;
            orderRecord.currentPage = i2;
            orderRecord.selectFlag = i;
            String sign = getSign(obJectToString(orderRecord));
            LogUtil.d(TAG, obJectToString(orderRecord) + "  " + sign);
            LogUtil.log(obJectToString(orderRecord));
            BaseBean<BuyClubCradRecordBean> depositRefundOrderList = this.mProtocol.getDepositRefundOrderList(orderRecord, sign);
            if (depositRefundOrderList.ok()) {
                return depositRefundOrderList.Data;
            }
            throw HttpException.filter(depositRefundOrderList.Code, depositRefundOrderList.getErrMsg(), depositRefundOrderList.Data, depositRefundOrderList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SchoolCardInfoBean getFindCard(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str + "");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<SchoolCardInfoBean> findCard = this.mProtocol.getFindCard(str, sign);
            if (findCard.ok()) {
                return findCard.Data;
            }
            throw HttpException.filter(findCard.Code, findCard.getErrMsg(), findCard.Data, findCard.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean bindCardForOpen(String str, String str2, String str3) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str + "");
            v3CombindBean.combind("investorId", str2 + "");
            v3CombindBean.combind("cardId", str3 + "");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<SuccessBean> baseBeanBindCardForOpen = this.mProtocol.bindCardForOpen(str, str2, str3, sign);
            if (baseBeanBindCardForOpen.ok()) {
                return baseBeanBindCardForOpen.Data;
            }
            throw HttpException.filter(baseBeanBindCardForOpen.Code, baseBeanBindCardForOpen.getErrMsg(), baseBeanBindCardForOpen.Data, baseBeanBindCardForOpen.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SchoolCardInfoBean postBindCardByMachine(String str, String str2, String str3, String str4, List<Integer> list) throws HttpException {
        try {
            BindCard bindCard = new BindCard();
            bindCard.schoolId = str;
            bindCard.machineId = str2;
            bindCard.machineData = str3;
            bindCard.machineidRandom = str4;
            bindCard.typeIds = list;
            String sign = getSign(obJectToString(bindCard));
            LogUtil.d(TAG, obJectToString(bindCard) + "  " + sign);
            LogUtil.log(obJectToString(bindCard));
            BaseBean<SchoolCardInfoBean> baseBeanPostBindCardByMachine = this.mProtocol.postBindCardByMachine(bindCard, sign);
            if (baseBeanPostBindCardByMachine.ok()) {
                return baseBeanPostBindCardByMachine.Data;
            }
            throw HttpException.filter(baseBeanPostBindCardByMachine.Code, baseBeanPostBindCardByMachine.getErrMsg(), baseBeanPostBindCardByMachine.Data, baseBeanPostBindCardByMachine.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SchoolCardInfoBean postBindCardByMachine2(String str, String str2, List<Integer> list) throws HttpException {
        try {
            BindCard bindCard = new BindCard();
            bindCard.schoolId = str;
            bindCard.cardId = str2;
            bindCard.typeIds = list;
            String sign = getSign(obJectToString(bindCard));
            LogUtil.d(TAG, obJectToString(bindCard) + "  " + sign);
            LogUtil.log(obJectToString(bindCard));
            BaseBean<SchoolCardInfoBean> baseBeanPostBindCardByMachine2 = this.mProtocol.postBindCardByMachine2(bindCard, sign);
            if (baseBeanPostBindCardByMachine2.ok()) {
                return baseBeanPostBindCardByMachine2.Data;
            }
            throw HttpException.filter(baseBeanPostBindCardByMachine2.Code, baseBeanPostBindCardByMachine2.getErrMsg(), baseBeanPostBindCardByMachine2.Data, baseBeanPostBindCardByMachine2.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SchoolCardInfoBean postUnbindCard(String str, String str2) throws HttpException {
        try {
            BindCard bindCard = new BindCard();
            bindCard.schoolId = str;
            bindCard.cardId = str2;
            String sign = getSign(obJectToString(bindCard));
            LogUtil.d(TAG, obJectToString(bindCard) + "  " + sign);
            LogUtil.log(obJectToString(bindCard));
            BaseBean<SchoolCardInfoBean> baseBeanPostUnbindCard = this.mProtocol.postUnbindCard(bindCard, sign);
            if (baseBeanPostUnbindCard.ok()) {
                return baseBeanPostUnbindCard.Data;
            }
            throw HttpException.filter(baseBeanPostUnbindCard.Code, baseBeanPostUnbindCard.getErrMsg(), baseBeanPostUnbindCard.Data, baseBeanPostUnbindCard.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SchoolCardInfoBean postOpenApplyCard(String str, String str2, int i) throws HttpException {
        try {
            BindCard bindCard = new BindCard();
            bindCard.schoolId = str;
            bindCard.cardId = str2;
            bindCard.typeId = i;
            String sign = getSign(obJectToString(bindCard));
            LogUtil.d(TAG, obJectToString(bindCard) + "  " + sign);
            LogUtil.log(obJectToString(bindCard));
            BaseBean<SchoolCardInfoBean> baseBeanPostOpenApplyCard = this.mProtocol.postOpenApplyCard(bindCard, sign);
            if (baseBeanPostOpenApplyCard.ok()) {
                return baseBeanPostOpenApplyCard.Data;
            }
            throw HttpException.filter(baseBeanPostOpenApplyCard.Code, baseBeanPostOpenApplyCard.getErrMsg(), baseBeanPostOpenApplyCard.Data, baseBeanPostOpenApplyCard.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SchoolCardInfoBean postCloseApplyCard(String str, String str2, int i) throws HttpException {
        try {
            BindCard bindCard = new BindCard();
            bindCard.schoolId = str;
            bindCard.cardId = str2;
            bindCard.typeId = i;
            String sign = getSign(obJectToString(bindCard));
            LogUtil.d(TAG, obJectToString(bindCard) + "  " + sign);
            LogUtil.log(obJectToString(bindCard));
            BaseBean<SchoolCardInfoBean> baseBeanPostCloseApplyCard = this.mProtocol.postCloseApplyCard(bindCard, sign);
            if (baseBeanPostCloseApplyCard.ok()) {
                return baseBeanPostCloseApplyCard.Data;
            }
            throw HttpException.filter(baseBeanPostCloseApplyCard.Code, baseBeanPostCloseApplyCard.getErrMsg(), baseBeanPostCloseApplyCard.Data, baseBeanPostCloseApplyCard.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public YiKaTongPayResultBean getPayResultForYiKaTong(String str, String str2, int i, String str3, PayModelParameter payModelParameter) throws HttpException {
        try {
            YiKaTongPayRequest yiKaTongPayRequest = new YiKaTongPayRequest();
            yiKaTongPayRequest.schoolId = str;
            yiKaTongPayRequest.investorId = str2;
            yiKaTongPayRequest.payFlagType = i;
            yiKaTongPayRequest.modelType = str3;
            yiKaTongPayRequest.payModelParameter = payModelParameter;
            String sign = getSign(obJectToString(yiKaTongPayRequest));
            LogUtil.d(TAG, obJectToString(yiKaTongPayRequest) + "  " + sign);
            LogUtil.log(obJectToString(yiKaTongPayRequest));
            BaseBean<YiKaTongPayResultBean> payResultForYiKaTong = this.mProtocol.getPayResultForYiKaTong(yiKaTongPayRequest, sign);
            if (payResultForYiKaTong.ok()) {
                return payResultForYiKaTong.Data;
            }
            throw HttpException.filter(payResultForYiKaTong.Code, payResultForYiKaTong.getErrMsg(), payResultForYiKaTong.Data, payResultForYiKaTong.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AdvRulesBean findAdvertisingFacilitatorRules() throws HttpException {
        try {
            SuccessBean successBean = new SuccessBean();
            String sign = getSign(obJectToString(successBean));
            LogUtil.d(TAG, obJectToString(successBean) + "  " + sign);
            BaseBean<AdvRulesBean> baseBeanFindAdvertisingFacilitatorRules = this.mProtocol.findAdvertisingFacilitatorRules(successBean, sign);
            if (baseBeanFindAdvertisingFacilitatorRules.ok() && baseBeanFindAdvertisingFacilitatorRules != null) {
                return baseBeanFindAdvertisingFacilitatorRules.Data;
            }
            throw HttpException.filter(baseBeanFindAdvertisingFacilitatorRules.Code, baseBeanFindAdvertisingFacilitatorRules.getErrMsg(), baseBeanFindAdvertisingFacilitatorRules.Data, baseBeanFindAdvertisingFacilitatorRules.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AdvBean getAdvertising(String str, String str2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            v3CombindBean.combind("investorId", str2);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<AdvBean> advertising = this.mProtocol.getAdvertising(str, str2, sign);
            if (advertising.ok()) {
                return advertising.Data;
            }
            throw HttpException.filter(advertising.Code, advertising.getErrMsg(), advertising.Data, advertising.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<UsingBean> getUsingList(String str, String str2, int i) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            v3CombindBean.combind("investorId", str2);
            v3CombindBean.combind("typeId", i + "");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<List<UsingBean>> usingList = this.mProtocol.getUsingList(str, str2, i, sign);
            if (usingList.ok()) {
                return usingList.Data;
            }
            throw HttpException.filter(usingList.Code, usingList.getErrMsg(), usingList.Data, usingList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AppointmentListBean getList(String str, String str2, String str3, String str4, int i) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            v3CombindBean.combind("investorId", str2);
            v3CombindBean.combind("siteId", str3);
            v3CombindBean.combind("siteFlag", str4 + "");
            v3CombindBean.combind("typeId", i + "");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<AppointmentListBean> list = this.mProtocol.getList(str, str2, str3, str4, i, sign);
            if (list.ok() && list != null) {
                return list.Data;
            }
            throw HttpException.filter(list.Code, list.getErrMsg(), list.Data, list.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AppointmentBean reserve(String str, int i, int i2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("machineId", str);
            v3CombindBean.combind("channelWay", i + "");
            v3CombindBean.combind("typeId", i2 + "");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<AppointmentBean> baseBeanReserve = this.mProtocol.reserve(str, i, i2, sign);
            if (baseBeanReserve.ok() && baseBeanReserve != null) {
                return baseBeanReserve.Data;
            }
            throw HttpException.filter(baseBeanReserve.Code, baseBeanReserve.getErrMsg(), baseBeanReserve.Data, baseBeanReserve.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AppointmentBean cancelReserve(String str, String str2, int i, int i2, int i3) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("orderId", str);
            v3CombindBean.combind("machineId", str2);
            v3CombindBean.combind("channelWay", i + "");
            v3CombindBean.combind("typeId", i2 + "");
            v3CombindBean.combind("reserveStatus", i3 + "");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<AppointmentBean> baseBeanCancelReserve = this.mProtocol.cancelReserve(str, str2, i, i2, i3, sign);
            if (baseBeanCancelReserve.ok() && baseBeanCancelReserve != null) {
                return baseBeanCancelReserve.Data;
            }
            throw HttpException.filter(baseBeanCancelReserve.Code, baseBeanCancelReserve.getErrMsg(), baseBeanCancelReserve.Data, baseBeanCancelReserve.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AppointmentResultBean getResult(String str, int i, int i2, String str2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("machineId", str);
            v3CombindBean.combind("typeId", i + "");
            v3CombindBean.combind("asyncType", i2 + "");
            v3CombindBean.combind("communicationWord", str2);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<AppointmentResultBean> result = this.mProtocol.getResult(str, i, i2, str2, sign);
            if (result.ok() && result != null) {
                return result.Data;
            }
            throw HttpException.filter(result.Code, result.getErrMsg(), result.Data, result.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean getUpdateStatus(String str, int i, String str2) throws HttpException {
        BaseBean<SuccessBean> updateStatusWash;
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("machineId", str);
            v3CombindBean.combind("typeId", i + "");
            v3CombindBean.combind("statusInfo", str2);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            if (i == 3 || i == 16) {
                updateStatusWash = this.mProtocol.getUpdateStatusWash(str, i, str2, sign);
            } else if (i == 6) {
                updateStatusWash = this.mProtocol.getUpdateStatusDrink(str, i, str2, sign);
            } else if (i == 8) {
                updateStatusWash = this.mProtocol.getUpdateStatusHair(str, i, str2, sign);
            } else {
                updateStatusWash = this.mProtocol.getUpdateStatus(str, i, str2, sign);
            }
            if (updateStatusWash.ok() && updateStatusWash != null) {
                return updateStatusWash.Data;
            }
            throw HttpException.filter(updateStatusWash.Code, updateStatusWash.getErrMsg(), updateStatusWash.Data, updateStatusWash.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String getMoneyCouponAmount(String str, String str2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            v3CombindBean.combind("investorId", str2);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<String> moneyCouponAmount = this.mProtocol.getMoneyCouponAmount(str, str2, sign);
            if (moneyCouponAmount.ok() && moneyCouponAmount != null) {
                return moneyCouponAmount.Data;
            }
            throw HttpException.filter(moneyCouponAmount.Code, moneyCouponAmount.getErrMsg(), moneyCouponAmount.Data, moneyCouponAmount.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public CashRedPackageBean getMoneyCouponAmountV2(String str, String str2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            v3CombindBean.combind("investorId", str2);
            v3CombindBean.combind("isRefund", "1");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<CashRedPackageBean> moneyCouponAmountV2 = this.mProtocol.getMoneyCouponAmountV2(str, str2, 1, sign);
            if (moneyCouponAmountV2.ok() && moneyCouponAmountV2 != null) {
                return moneyCouponAmountV2.Data;
            }
            throw HttpException.filter(moneyCouponAmountV2.Code, moneyCouponAmountV2.getErrMsg(), moneyCouponAmountV2.Data, moneyCouponAmountV2.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean appUpdateUserStatus(int i, String str) throws HttpException {
        try {
            CancelAccount cancelAccount = new CancelAccount();
            cancelAccount.status = i;
            String sign = getSign(obJectToString(cancelAccount));
            LogUtil.e(TAG, i + PPSLabelView.Code + sign);
            LogUtil.log(i + "");
            BaseBean<SuccessBean> baseBeanAppUpdateUserStatus = this.mProtocol.appUpdateUserStatus(cancelAccount, sign);
            if (baseBeanAppUpdateUserStatus.ok() && baseBeanAppUpdateUserStatus != null) {
                if (i == 2) {
                    LocalDataUtil.saveAccoutCancelTime(BaseApplication.app, str, baseBeanAppUpdateUserStatus.Serial);
                }
                return baseBeanAppUpdateUserStatus.Data;
            }
            throw HttpException.filter(baseBeanAppUpdateUserStatus.Code, baseBeanAppUpdateUserStatus.getErrMsg(), baseBeanAppUpdateUserStatus.Data, baseBeanAppUpdateUserStatus.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public UnPayOrdersBean getUnPayOrderIndex(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("studentId", str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<UnPayOrdersBean> unPayOrderIndex = this.mProtocol.getUnPayOrderIndex(str, sign);
            if (unPayOrderIndex.ok()) {
                return unPayOrderIndex.Data;
            }
            throw HttpException.filter(unPayOrderIndex.Code, unPayOrderIndex.getErrMsg(), unPayOrderIndex.Data, unPayOrderIndex.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<SelectAllBean> paySelectAll(String str, String str2, String str3, int i) throws HttpException {
        try {
            SelectAll selectAll = new SelectAll();
            selectAll.schoolId = str;
            selectAll.investorId = str2;
            selectAll.studentId = str3;
            selectAll.payFlagType = 2;
            selectAll.type = i;
            String sign = getSign(obJectToString(selectAll));
            LogUtil.d(TAG, obJectToString(selectAll) + "  " + sign);
            LogUtil.log(obJectToString(selectAll));
            BaseBean<List<SelectAllBean>> baseBeanPaySelectAll = this.mProtocol.paySelectAll(selectAll, sign);
            if (baseBeanPaySelectAll.ok()) {
                return baseBeanPaySelectAll.Data;
            }
            throw HttpException.filter(baseBeanPaySelectAll.Code, baseBeanPaySelectAll.getErrMsg(), baseBeanPaySelectAll.Data, baseBeanPaySelectAll.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SignBean getPayResult(int i, String str) throws HttpException {
        try {
            PayResult payResult = new PayResult();
            payResult.payFlagType = i;
            if (i == 2) {
                payResult.modelType = "cloudsaleApiSignQuery";
            }
            if (StringUtils.isNotEmpty(str)) {
                client.android.yixiaotong.v3.bean.pay.PayModelParameter payModelParameter = new client.android.yixiaotong.v3.bean.pay.PayModelParameter();
                payModelParameter.userId = str;
                payResult.payModelParameter = payModelParameter;
            }
            String sign = getSign(obJectToString(payResult));
            LogUtil.d(TAG, obJectToString(payResult) + PPSLabelView.Code + sign);
            LogUtil.log(obJectToString(payResult));
            BaseBean<SignBean> payResult2 = this.mProtocol.getPayResult(payResult, sign);
            if (payResult2.ok()) {
                return payResult2.Data;
            }
            throw HttpException.filter(payResult2.Code, payResult2.getErrMsg(), payResult2.Data, payResult2.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postUserActiveInfo(UserCommon userCommon, UserPage userPage) throws HttpException {
        try {
            UserActiveInfo userActiveInfo = new UserActiveInfo();
            userActiveInfo.common = userCommon;
            userActiveInfo.page = userPage;
            String sign = getSign(obJectToString(userActiveInfo));
            LogUtil.d(TAG, obJectToString(userActiveInfo) + PPSLabelView.Code + sign);
            LogUtil.log(obJectToString(userActiveInfo));
            BaseBean<SuccessBean> baseBeanPostUserActiveInfo = this.mProtocol.postUserActiveInfo(userActiveInfo, sign);
            if (baseBeanPostUserActiveInfo.ok()) {
                return baseBeanPostUserActiveInfo.Data;
            }
            throw HttpException.filter(baseBeanPostUserActiveInfo.Code, baseBeanPostUserActiveInfo.getErrMsg(), baseBeanPostUserActiveInfo.Data, baseBeanPostUserActiveInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean postBindSchoolGive(String str, String str2, String str3, String str4) throws HttpException {
        try {
            BindSchoolGive bindSchoolGive = new BindSchoolGive();
            bindSchoolGive.schoolId = str;
            bindSchoolGive.investorId = str2;
            bindSchoolGive.giveRulesId = str3;
            bindSchoolGive.buyer = str4;
            String sign = getSign(obJectToString(bindSchoolGive));
            LogUtil.e(TAG, sign + "  " + str + PPSLabelView.Code + str2 + PPSLabelView.Code + str3 + PPSLabelView.Code + str4);
            LogUtil.log(obJectToString(bindSchoolGive));
            BaseBean<SuccessBean> baseBeanPostBindSchoolGive = this.mProtocol.postBindSchoolGive(bindSchoolGive, sign);
            if (baseBeanPostBindSchoolGive.ok()) {
                return baseBeanPostBindSchoolGive.Data;
            }
            throw HttpException.filter(baseBeanPostBindSchoolGive.Code, baseBeanPostBindSchoolGive.getErrMsg(), baseBeanPostBindSchoolGive.Data, baseBeanPostBindSchoolGive.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public PrepaymentDeviceInfoBean getDeviceInfo(String str) throws HttpException {
        try {
            PrepaymentDeviceInfo prepaymentDeviceInfo = new PrepaymentDeviceInfo();
            prepaymentDeviceInfo.machineId = str;
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(TtmlNode.RUBY_BASE);
            arrayList.add("valve");
            arrayList.add("check");
            prepaymentDeviceInfo.keys = arrayList;
            String sign = getSign(obJectToString(prepaymentDeviceInfo));
            LogUtil.e(TAG, sign + "  " + obJectToString(prepaymentDeviceInfo));
            LogUtil.log(obJectToString(prepaymentDeviceInfo));
            BaseBean<PrepaymentDeviceInfoBean> deviceInfo = this.mProtocol.getDeviceInfo(prepaymentDeviceInfo, sign);
            if (deviceInfo.ok()) {
                return deviceInfo.Data;
            }
            throw HttpException.filter(deviceInfo.Code, deviceInfo.getErrMsg(), deviceInfo.Data, deviceInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public PrepaymentWalletBean getPrepaymentWallet(String str, String str2, String str3) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("walletKey", str);
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str2);
            v3CombindBean.combind("investorId", str3);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, sign + "  " + v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<PrepaymentWalletBean> prepaymentWallet = this.mProtocol.getPrepaymentWallet(str, str2, str3, sign);
            if (prepaymentWallet.ok()) {
                return prepaymentWallet.Data;
            }
            throw HttpException.filter(prepaymentWallet.Code, prepaymentWallet.getErrMsg(), prepaymentWallet.Data, prepaymentWallet.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public PrepaymentRedPackageAmountBean getPrepaymentRedPackageAmount(String str, String str2, String str3) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("machineId", str);
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str2);
            v3CombindBean.combind("investorId", str3);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, sign + "  " + v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<PrepaymentRedPackageAmountBean> prepaymentRedPackageAmount = this.mProtocol.getPrepaymentRedPackageAmount(str, str2, str3, sign);
            if (prepaymentRedPackageAmount.ok()) {
                return prepaymentRedPackageAmount.Data;
            }
            throw HttpException.filter(prepaymentRedPackageAmount.Code, prepaymentRedPackageAmount.getErrMsg(), prepaymentRedPackageAmount.Data, prepaymentRedPackageAmount.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public CreateOrderBean postPrepaymentCreateOrders(String str, String str2, int i, String str3, String str4, int i2, int i3, YiKaTongPayModelParameterBean yiKaTongPayModelParameterBean, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) throws HttpException {
        try {
            PrepaymentCreateOrder prepaymentCreateOrder = new PrepaymentCreateOrder();
            prepaymentCreateOrder.schoolId = str;
            prepaymentCreateOrder.investorId = str2;
            prepaymentCreateOrder.investorName = str5;
            prepaymentCreateOrder.schoolName = str6;
            prepaymentCreateOrder.studentId = str7;
            prepaymentCreateOrder.studentNumber = str8;
            prepaymentCreateOrder.studentName = str9;
            prepaymentCreateOrder.studentMobile = str10;
            prepaymentCreateOrder.siteId = str11;
            prepaymentCreateOrder.equipmentAddress = str12;
            prepaymentCreateOrder.valveStatus = str13;
            prepaymentCreateOrder.businessType = i;
            prepaymentCreateOrder.walletKey = str3;
            prepaymentCreateOrder.giveRulesId = str4;
            prepaymentCreateOrder.price = i2;
            prepaymentCreateOrder.payFlagType = i3;
            if (i3 == 7) {
                prepaymentCreateOrder.modelType = "wideBodyGdccardPay";
                prepaymentCreateOrder.payModelParameter = yiKaTongPayModelParameterBean;
            } else if (i3 == 3) {
                prepaymentCreateOrder.modelType = "prePay";
            }
            String sign = getSign(obJectToString(prepaymentCreateOrder));
            LogUtil.d(TAG, obJectToString(prepaymentCreateOrder) + "  " + sign);
            LogUtil.log(obJectToString(prepaymentCreateOrder));
            BaseBean<CreateOrderBean> baseBeanPostPrepaymentCreateOrders = this.mProtocol.postPrepaymentCreateOrders(prepaymentCreateOrder, sign);
            if (baseBeanPostPrepaymentCreateOrders.ok() && baseBeanPostPrepaymentCreateOrders != null) {
                return baseBeanPostPrepaymentCreateOrders.Data;
            }
            throw HttpException.filter(baseBeanPostPrepaymentCreateOrders.Code, baseBeanPostPrepaymentCreateOrders.getErrMsg(), baseBeanPostPrepaymentCreateOrders.Data, baseBeanPostPrepaymentCreateOrders.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public PrepaymentWalletBean getAppendOrderStatus(String str, String str2, String str3) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("id", str);
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str2);
            v3CombindBean.combind("investorId", str3);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, sign + "  " + v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<PrepaymentWalletBean> appendOrderStatus = this.mProtocol.getAppendOrderStatus(str, str2, str3, sign);
            if (appendOrderStatus.ok()) {
                return appendOrderStatus.Data;
            }
            throw HttpException.filter(appendOrderStatus.Code, appendOrderStatus.getErrMsg(), appendOrderStatus.Data, appendOrderStatus.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<UnFinishOrderBean> getUnFinishOrder(String str, String str2, String str3) throws HttpException {
        try {
            UnFinishOrder unFinishOrder = new UnFinishOrder();
            unFinishOrder.walletKey = str;
            unFinishOrder.schoolId = str2;
            unFinishOrder.investorId = str3;
            String sign = getSign(obJectToString(unFinishOrder));
            LogUtil.e(TAG, sign + "  " + obJectToString(unFinishOrder));
            LogUtil.log(obJectToString(unFinishOrder));
            BaseBean<List<UnFinishOrderBean>> unFinishOrder2 = this.mProtocol.getUnFinishOrder(unFinishOrder, sign);
            if (unFinishOrder2.ok()) {
                return unFinishOrder2.Data;
            }
            throw HttpException.filter(unFinishOrder2.Code, unFinishOrder2.getErrMsg(), unFinishOrder2.Data, unFinishOrder2.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BuyClubCardDetailBean waterAppendCallback(String str, String str2, String str3, int i) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("id", str);
            v3CombindBean.combind("status", "0");
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str2);
            v3CombindBean.combind("investorId", str3);
            v3CombindBean.combind("type", i + "");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, sign + "  " + v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<BuyClubCardDetailBean> baseBeanWaterAppendCallback = this.mProtocol.waterAppendCallback(str, 0, str2, str3, i, sign);
            if (baseBeanWaterAppendCallback.ok()) {
                return baseBeanWaterAppendCallback.Data;
            }
            throw HttpException.filter(baseBeanWaterAppendCallback.Code, baseBeanWaterAppendCallback.getErrMsg(), baseBeanWaterAppendCallback.Data, baseBeanWaterAppendCallback.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BuyClubCradRecordBean getPrepaymentRechargeOrderList(String str, String str2, int i) throws HttpException {
        try {
            OrderRecord orderRecord = new OrderRecord();
            orderRecord.schoolId = str;
            orderRecord.currentPage = i;
            orderRecord.machineId = str2;
            String sign = getSign(obJectToString(orderRecord));
            LogUtil.d(TAG, obJectToString(orderRecord) + "  " + sign);
            LogUtil.log(obJectToString(orderRecord));
            BaseBean<BuyClubCradRecordBean> prepaymentRechargeOrderList = this.mProtocol.getPrepaymentRechargeOrderList(orderRecord, sign);
            if (prepaymentRechargeOrderList.ok()) {
                return prepaymentRechargeOrderList.Data;
            }
            throw HttpException.filter(prepaymentRechargeOrderList.Code, prepaymentRechargeOrderList.getErrMsg(), prepaymentRechargeOrderList.Data, prepaymentRechargeOrderList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BuyClubCradRecordBean getPrepaymentRefundOrderList(String str, String str2, int i) throws HttpException {
        try {
            OrderRecord orderRecord = new OrderRecord();
            orderRecord.schoolId = str;
            orderRecord.currentPage = i;
            orderRecord.machineId = str2;
            String sign = getSign(obJectToString(orderRecord));
            LogUtil.d(TAG, obJectToString(orderRecord) + "  " + sign);
            LogUtil.log(obJectToString(orderRecord));
            BaseBean<BuyClubCradRecordBean> prepaymentRefundOrderList = this.mProtocol.getPrepaymentRefundOrderList(orderRecord, sign);
            if (prepaymentRefundOrderList.ok()) {
                return prepaymentRefundOrderList.Data;
            }
            throw HttpException.filter(prepaymentRefundOrderList.Code, prepaymentRefundOrderList.getErrMsg(), prepaymentRefundOrderList.Data, prepaymentRefundOrderList.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SupervisorBean getPrepaymentSupervisor(String str, String str2, String str3) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("walletKey", str);
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str2);
            v3CombindBean.combind("investorId", str3);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, sign + "  " + v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<SupervisorBean> prepaymentSupervisor = this.mProtocol.getPrepaymentSupervisor(str, str2, str3, sign);
            if (prepaymentSupervisor.ok()) {
                return prepaymentSupervisor.Data;
            }
            throw HttpException.filter(prepaymentSupervisor.Code, prepaymentSupervisor.getErrMsg(), prepaymentSupervisor.Data, prepaymentSupervisor.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean changeSupervisor(String str, String str2, String str3, String str4, String str5, String str6) throws HttpException {
        try {
            ChangeSupervisor changeSupervisor = new ChangeSupervisor();
            changeSupervisor.studentId = str;
            changeSupervisor.walletKey = str2;
            changeSupervisor.studentName = str3;
            changeSupervisor.studentMobile = str4;
            changeSupervisor.schoolId = str5;
            changeSupervisor.investorId = str6;
            String sign = getSign(obJectToString(changeSupervisor));
            LogUtil.d(TAG, obJectToString(changeSupervisor) + "  " + sign);
            LogUtil.log(obJectToString(changeSupervisor));
            BaseBean<SuccessBean> baseBeanChangeSupervisor = this.mProtocol.changeSupervisor(changeSupervisor, sign);
            if (baseBeanChangeSupervisor.ok()) {
                return baseBeanChangeSupervisor.Data;
            }
            throw HttpException.filter(baseBeanChangeSupervisor.Code, baseBeanChangeSupervisor.getErrMsg(), baseBeanChangeSupervisor.Data, baseBeanChangeSupervisor.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public UserInfoByMobileBean getUserByStudentMobile(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("studentMobile", str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<UserInfoByMobileBean> userByStudentMobile = this.mProtocol.getUserByStudentMobile(str, sign);
            if (userByStudentMobile.ok()) {
                return userByStudentMobile.Data;
            }
            throw HttpException.filter(userByStudentMobile.Code, userByStudentMobile.getErrMsg(), userByStudentMobile.Data, userByStudentMobile.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean pastSupervisor(String str, String str2, String str3, String str4, String str5, String str6) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("walletKey", str2);
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str5);
            v3CombindBean.combind("investorId", str6);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<SuccessBean> baseBeanPastSupervisor = this.mProtocol.pastSupervisor(str2, str5, str6, sign);
            if (baseBeanPastSupervisor.ok()) {
                return baseBeanPastSupervisor.Data;
            }
            throw HttpException.filter(baseBeanPastSupervisor.Code, baseBeanPastSupervisor.getErrMsg(), baseBeanPastSupervisor.Data, baseBeanPastSupervisor.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SetWaterZeroBean getSetWaterZeroData(String str, String str2, String str3, String str4) throws HttpException {
        try {
            SetWaterZero setWaterZero = new SetWaterZero();
            setWaterZero.channelWay = 1;
            setWaterZero.money = 0;
            setWaterZero.machineId = str;
            MachineRand machineRand = new MachineRand();
            machineRand.key = str2;
            machineRand.zero = str3;
            machineRand.one = str4;
            setWaterZero.random = machineRand;
            String sign = getSign(obJectToString(setWaterZero));
            LogUtil.d(TAG, obJectToString(setWaterZero) + "  " + sign);
            LogUtil.log(obJectToString(setWaterZero));
            BaseBean<SetWaterZeroBean> setWaterZeroData = this.mProtocol.getSetWaterZeroData(setWaterZero, sign);
            if (setWaterZeroData.ok()) {
                return setWaterZeroData.Data;
            }
            throw HttpException.filter(setWaterZeroData.Code, setWaterZeroData.getErrMsg(), setWaterZeroData.Data, setWaterZeroData.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public RefundBean refundOrderPrepayment(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) throws HttpException {
        try {
            Refund refund = new Refund();
            refund.walletKey = str;
            refund.price = i;
            refund.payFlagType = i2;
            refund.businessType = 10;
            refund.studentName = str2;
            refund.investorId = str3;
            refund.schoolId = str4;
            refund.studentId = str5;
            refund.studentMobile = str6;
            refund.reason = str7;
            refund.img = str8;
            refund.openId = str9;
            refund.f967client = str10;
            refund.machineAddress = str11;
            refund.machineStatus = str12;
            refund.typeId = 18;
            String sign = getSign(obJectToString(refund));
            LogUtil.d(TAG, obJectToString(refund) + "  " + sign);
            LogUtil.log(obJectToString(refund));
            BaseBean<RefundBean> baseBeanRefundOrderPrepayment = this.mProtocol.refundOrderPrepayment(refund, sign);
            if (baseBeanRefundOrderPrepayment.ok()) {
                return baseBeanRefundOrderPrepayment.Data;
            }
            throw HttpException.filter(baseBeanRefundOrderPrepayment.Code, baseBeanRefundOrderPrepayment.getErrMsg(), baseBeanRefundOrderPrepayment.Data, baseBeanRefundOrderPrepayment.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean unlock(String str, String str2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("typeId", BaseWrapper.ENTER_ID_18);
            v3CombindBean.combind("machineId", str);
            v3CombindBean.combind("deviceVer", str2);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<SuccessBean> baseBeanUnlock = this.mProtocol.unlock(18, str, str2, sign);
            if (baseBeanUnlock.ok()) {
                return baseBeanUnlock.Data;
            }
            throw HttpException.filter(baseBeanUnlock.Code, baseBeanUnlock.getErrMsg(), baseBeanUnlock.Data, baseBeanUnlock.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public RefundBean cancelRefundOrderPrepayment(String str, String str2, String str3) throws HttpException {
        try {
            Refund refund = new Refund();
            refund.walletKey = str;
            refund.investorId = str2;
            refund.schoolId = str3;
            String sign = getSign(obJectToString(refund));
            LogUtil.d(TAG, obJectToString(refund) + "  " + sign);
            LogUtil.log(obJectToString(refund));
            BaseBean<RefundBean> baseBeanCancelRefundOrderPrepayment = this.mProtocol.cancelRefundOrderPrepayment(refund, sign);
            if (baseBeanCancelRefundOrderPrepayment.ok()) {
                return baseBeanCancelRefundOrderPrepayment.Data;
            }
            throw HttpException.filter(baseBeanCancelRefundOrderPrepayment.Code, baseBeanCancelRefundOrderPrepayment.getErrMsg(), baseBeanCancelRefundOrderPrepayment.Data, baseBeanCancelRefundOrderPrepayment.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public RefundBean findRefundOrderForPrepayment(String str, String str2, String str3) throws HttpException {
        try {
            Refund refund = new Refund();
            refund.walletKey = str;
            refund.investorId = str2;
            refund.schoolId = str3;
            String sign = getSign(obJectToString(refund));
            LogUtil.d(TAG, obJectToString(refund) + "  " + sign);
            LogUtil.log(obJectToString(refund));
            BaseBean<RefundBean> baseBeanFindRefundOrderForPrepayment = this.mProtocol.findRefundOrderForPrepayment(refund, sign);
            if (baseBeanFindRefundOrderForPrepayment.ok()) {
                return baseBeanFindRefundOrderForPrepayment.Data;
            }
            throw HttpException.filter(baseBeanFindRefundOrderForPrepayment.Code, baseBeanFindRefundOrderForPrepayment.getErrMsg(), baseBeanFindRefundOrderForPrepayment.Data, baseBeanFindRefundOrderForPrepayment.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public Integer checkPrepaymentDeductionRule(String str, String str2, String str3) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("investorId", str);
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str2);
            v3CombindBean.combind("typeId", BaseWrapper.ENTER_ID_18);
            v3CombindBean.combind("machineId", str3);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.d(TAG, v3CombindBean.toString() + "  " + sign);
            LogUtil.log(v3CombindBean.toString());
            BaseBean<Integer> baseBeanCheckPrepaymentDeductionRule = this.mProtocol.checkPrepaymentDeductionRule(str, str2, 18, str3, sign);
            if (baseBeanCheckPrepaymentDeductionRule.ok()) {
                return baseBeanCheckPrepaymentDeductionRule.Data;
            }
            throw HttpException.filter(baseBeanCheckPrepaymentDeductionRule.Code, baseBeanCheckPrepaymentDeductionRule.getErrMsg(), baseBeanCheckPrepaymentDeductionRule.Data, baseBeanCheckPrepaymentDeductionRule.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DeductionRuleBean selectDeductionRule(String str, int i, String str2, String str3) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("investorId", str2);
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            v3CombindBean.combind("typeId", i + "");
            v3CombindBean.combind("deviceVer", str3);
            v3CombindBean.combind("ruleType", "0");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<DeductionRuleBean> baseBeanSelectDeductionRule = this.mProtocol.selectDeductionRule(str2, str, i, str3, 0, sign);
            if (baseBeanSelectDeductionRule.ok()) {
                return baseBeanSelectDeductionRule.Data;
            }
            throw HttpException.filter(baseBeanSelectDeductionRule.Code, baseBeanSelectDeductionRule.getErrMsg(), baseBeanSelectDeductionRule.Data, baseBeanSelectDeductionRule.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public Integer getIsHasSellCardDevice(String str, String str2, int i, String str3) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("investorId", str);
            v3CombindBean.combind("premisesId", str2);
            v3CombindBean.combind("typeId", i + "");
            v3CombindBean.combind("deviceVer", str3);
            v3CombindBean.combind("status", "1");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<Integer> isHasSellCardDevice = this.mProtocol.getIsHasSellCardDevice(str, str2, i, str3, 1, sign);
            if (isHasSellCardDevice.Data != null && isHasSellCardDevice.ok()) {
                return isHasSellCardDevice.Data;
            }
            throw HttpException.filter(isHasSellCardDevice.Code, isHasSellCardDevice.Message, isHasSellCardDevice.Data, isHasSellCardDevice.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DMGetOrderBean postCreateBluetoothOrder(String str, String str2, String str3, int i, String str4, int i2, int i3, int i4, int i5, String str5) throws HttpException {
        try {
            DMGetOrder dMGetOrder = new DMGetOrder();
            dMGetOrder.investorId = str;
            dMGetOrder.schoolId = str2;
            dMGetOrder.studentId = str3;
            dMGetOrder.typeId = i;
            dMGetOrder.studentMobile = str4;
            dMGetOrder.paymentFlag = i2;
            dMGetOrder.payFlag = i3;
            dMGetOrder.payFlagType = i4;
            dMGetOrder.posPrice = i5;
            dMGetOrder.studentName = str5;
            String sign = getSign(obJectToString(dMGetOrder));
            LogUtil.d(TAG, obJectToString(dMGetOrder) + "  " + sign);
            LogUtil.log(obJectToString(dMGetOrder));
            BaseBean<DMGetOrderBean> baseBeanPostCreateBluetoothOrder = this.mProtocol.postCreateBluetoothOrder(dMGetOrder, sign);
            if (baseBeanPostCreateBluetoothOrder.Data != null && baseBeanPostCreateBluetoothOrder.ok()) {
                return baseBeanPostCreateBluetoothOrder.Data;
            }
            throw HttpException.filter(baseBeanPostCreateBluetoothOrder.Code, baseBeanPostCreateBluetoothOrder.Message, baseBeanPostCreateBluetoothOrder.Data, baseBeanPostCreateBluetoothOrder.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AppointmentBean getSellCardAuthData(String str, String str2, String str3, String str4, String str5) throws HttpException {
        try {
            SellCardAuth sellCardAuth = new SellCardAuth();
            sellCardAuth.investorId = str;
            sellCardAuth.premisesId = str2;
            sellCardAuth.qrcode = str3;
            sellCardAuth.machineId = str4;
            sellCardAuth.userId = str5;
            String sign = getSign(obJectToString(sellCardAuth));
            LogUtil.e(TAG, obJectToString(sellCardAuth));
            LogUtil.log(obJectToString(sellCardAuth));
            BaseBean<AppointmentBean> sellCardAuthData = this.mProtocol.getSellCardAuthData(sellCardAuth, sign);
            if (sellCardAuthData.Data != null && sellCardAuthData.ok()) {
                return sellCardAuthData.Data;
            }
            throw HttpException.filter(sellCardAuthData.Code, sellCardAuthData.Message, sellCardAuthData.Data, sellCardAuthData.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public YKTBindStateBean getExtendCardInfo(String str, String str2, String str3) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("investorId", str);
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str2);
            v3CombindBean.combind("studentId", str3);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<YKTBindStateBean> extendCardInfo = this.mProtocol.getExtendCardInfo(str, str2, str3, sign);
            if (extendCardInfo.Data != null && extendCardInfo.ok()) {
                return extendCardInfo.Data;
            }
            throw HttpException.filter(extendCardInfo.Code, extendCardInfo.Message, extendCardInfo.Data, extendCardInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public YKTBindStateBean bindExtendCardInfo(String str, String str2, String str3, String str4, String str5) throws HttpException {
        try {
            YKTBind yKTBind = new YKTBind();
            yKTBind.investorId = str;
            yKTBind.schoolId = str2;
            yKTBind.studentId = str3;
            yKTBind.cardNumber = str4;
            yKTBind.cardPassword = str5;
            String sign = getSign(obJectToString(yKTBind));
            LogUtil.e(TAG, obJectToString(yKTBind));
            LogUtil.log(obJectToString(yKTBind));
            BaseBean<YKTBindStateBean> baseBeanBindExtendCardInfo = this.mProtocol.bindExtendCardInfo(yKTBind, sign);
            if (baseBeanBindExtendCardInfo.ok()) {
                return baseBeanBindExtendCardInfo.Data;
            }
            throw HttpException.filter(baseBeanBindExtendCardInfo.Code, baseBeanBindExtendCardInfo.Message, baseBeanBindExtendCardInfo.Data, baseBeanBindExtendCardInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public OpenYKTBean getIsOpenYKT(String str, String str2, String str3) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("investorId", str);
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str2);
            v3CombindBean.combind("categoryCode", str3);
            v3CombindBean.combind("type", "1");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<OpenYKTBean> isOpenYKT = this.mProtocol.getIsOpenYKT(str, str2, str3, 1, sign);
            if (isOpenYKT.Data != null && isOpenYKT.ok()) {
                return isOpenYKT.Data;
            }
            throw HttpException.filter(isOpenYKT.Code, isOpenYKT.Message, isOpenYKT.Data, isOpenYKT.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<GetAnnouncementBean> getAnnouncementV3(String str, String str2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            v3CombindBean.combind("investorId", str2);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<List<GetAnnouncementBean>> announcementV3 = this.mProtocol.getAnnouncementV3(str, str2, sign);
            if (announcementV3.ok()) {
                return announcementV3.Data;
            }
            throw HttpException.filter(announcementV3.Code, announcementV3.getErrMsg(), announcementV3.Data, announcementV3.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public Detail getAnnouncementDetailNewV3(long j) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("id", j + "");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<Detail> announcementDetailNewV3 = this.mProtocol.getAnnouncementDetailNewV3(j + "", sign);
            if (announcementDetailNewV3.ok()) {
                return announcementDetailNewV3.Data;
            }
            throw HttpException.filter(announcementDetailNewV3.Code, announcementDetailNewV3.getErrMsg(), announcementDetailNewV3.Data, announcementDetailNewV3.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public GetAllAnnounceListBean getAllAnnouncementV3(String str, String str2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            v3CombindBean.combind("investorId", str2);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<GetAllAnnounceListBean> allAnnouncementV3 = this.mProtocol.getAllAnnouncementV3(str, str2, sign);
            if (allAnnouncementV3.ok()) {
                return allAnnouncementV3.Data;
            }
            throw HttpException.filter(allAnnouncementV3.Code, allAnnouncementV3.getErrMsg(), allAnnouncementV3.Data, allAnnouncementV3.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<HistoryLoginInfoBean> getMobileInfo(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind("studentId", str);
            v3CombindBean.combind("pageSize", "10");
            v3CombindBean.combind("pageIndex", "1");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<List<HistoryLoginInfoBean>> mobileInfo = this.mProtocol.getMobileInfo(str, 10, 1, sign);
            if (mobileInfo.ok()) {
                return mobileInfo.Data;
            }
            throw HttpException.filter(mobileInfo.Code, mobileInfo.getErrMsg(), mobileInfo.Data, mobileInfo.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<HostUrlBean> getHostUrlBySchoolIdAndInvestorId(String str, String str2, String str3) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            v3CombindBean.combind("investorId", str2);
            v3CombindBean.combind("code", str3);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<List<HostUrlBean>> hostUrlBySchoolIdAndInvestorIdAndCode = this.mProtocol.getHostUrlBySchoolIdAndInvestorIdAndCode(str, str2, str3, sign);
            if (hostUrlBySchoolIdAndInvestorIdAndCode.ok() && hostUrlBySchoolIdAndInvestorIdAndCode.Data != null) {
                return hostUrlBySchoolIdAndInvestorIdAndCode.Data;
            }
            throw HttpException.filter(hostUrlBySchoolIdAndInvestorIdAndCode.Code, hostUrlBySchoolIdAndInvestorIdAndCode.getErrMsg(), hostUrlBySchoolIdAndInvestorIdAndCode.Data, hostUrlBySchoolIdAndInvestorIdAndCode.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public ConsumerPriceInfoBean getCalculatePrepaidMoney(String str, String str2, int i, String str3, String str4, String str5, int i2) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            v3CombindBean.combind("investorId", str2);
            v3CombindBean.combind("typeId", i + "");
            v3CombindBean.combind("studentId", str3);
            v3CombindBean.combind("machineId", str4);
            v3CombindBean.combind("deviceVer", str5);
            v3CombindBean.combind("ruleType", i2 + "");
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<ConsumerPriceInfoBean> calculatePrepaidMoney = this.mProtocol.getCalculatePrepaidMoney(str, str2, i, str3, str4, str5, i2, sign);
            if (calculatePrepaidMoney.ok() && calculatePrepaidMoney.Data != null) {
                return calculatePrepaidMoney.Data;
            }
            throw HttpException.filter(calculatePrepaidMoney.Code, calculatePrepaidMoney.getErrMsg(), calculatePrepaidMoney.Data, calculatePrepaidMoney.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public ConsumerCreateOrderBean postConsumerCreateOrder(String str, String str2, int i, String str3, String str4, String str5, int i2, int i3, int i4, String str6, String str7, String str8, String str9, int i5, int i6, Long l, Integer num, int i7, String str10, int i8) throws HttpException {
        try {
            ConsumerCreateOrder consumerCreateOrder = new ConsumerCreateOrder();
            consumerCreateOrder.schoolId = str;
            consumerCreateOrder.investorId = str2;
            consumerCreateOrder.typeId = i;
            consumerCreateOrder.studentId = str3;
            consumerCreateOrder.machineId = str4;
            consumerCreateOrder.machineName = str5;
            consumerCreateOrder.paymentFlag = i2;
            consumerCreateOrder.payFlag = i3;
            consumerCreateOrder.payFlagType = i4;
            consumerCreateOrder.studentNumber = str6;
            consumerCreateOrder.studentName = str7;
            consumerCreateOrder.studentMobile = str8;
            consumerCreateOrder.siteId = str9;
            consumerCreateOrder.siteFlag = i5;
            consumerCreateOrder.price = i6;
            consumerCreateOrder.deviceVer = str10;
            consumerCreateOrder.discountId = l;
            consumerCreateOrder.discountType = num;
            consumerCreateOrder.discountPrice = i7;
            String sign = getSign(obJectToString(consumerCreateOrder));
            LogUtil.e(TAG, obJectToString(consumerCreateOrder));
            LogUtil.log(obJectToString(consumerCreateOrder));
            BaseBean<ConsumerCreateOrderBean> baseBeanPostConsumerCreateOrder = this.mProtocol.postConsumerCreateOrder(consumerCreateOrder, sign);
            if (baseBeanPostConsumerCreateOrder.ok() && baseBeanPostConsumerCreateOrder.Data != null) {
                return baseBeanPostConsumerCreateOrder.Data;
            }
            throw HttpException.filter(baseBeanPostConsumerCreateOrder.Code, baseBeanPostConsumerCreateOrder.getErrMsg(), baseBeanPostConsumerCreateOrder.Data, baseBeanPostConsumerCreateOrder.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public ConsumerQueryOrderBean postConsumerQueryOrder(String str, String str2, int i, String str3) throws HttpException {
        try {
            ConsumerQueryOrder consumerQueryOrder = new ConsumerQueryOrder();
            consumerQueryOrder.schoolId = str;
            consumerQueryOrder.investorId = str2;
            consumerQueryOrder.typeId = i;
            consumerQueryOrder.id = str3;
            String sign = getSign(obJectToString(consumerQueryOrder));
            LogUtil.e(TAG, obJectToString(consumerQueryOrder));
            LogUtil.log(obJectToString(consumerQueryOrder));
            BaseBean<ConsumerQueryOrderBean> baseBeanPostConsumerQueryOrder = this.mProtocol.postConsumerQueryOrder(consumerQueryOrder, sign);
            if (baseBeanPostConsumerQueryOrder.ok() && baseBeanPostConsumerQueryOrder.Data != null) {
                return baseBeanPostConsumerQueryOrder.Data;
            }
            throw HttpException.filter(baseBeanPostConsumerQueryOrder.Code, baseBeanPostConsumerQueryOrder.getErrMsg(), baseBeanPostConsumerQueryOrder.Data, baseBeanPostConsumerQueryOrder.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BindElecMeterInfoBean getUserInfoElecMeter(String str, String str2, String str3, int i) throws HttpException {
        try {
            BindElecMeterInfo bindElecMeterInfo = new BindElecMeterInfo();
            bindElecMeterInfo.schoolId = str;
            bindElecMeterInfo.investorId = str2;
            bindElecMeterInfo.studentId = str3;
            bindElecMeterInfo.thirdPartyId = i;
            String sign = getSign(obJectToString(bindElecMeterInfo));
            LogUtil.e(TAG, obJectToString(bindElecMeterInfo));
            LogUtil.log(obJectToString(bindElecMeterInfo));
            BaseBean<BindElecMeterInfoBean> userInfoElecMeter = this.mProtocol.getUserInfoElecMeter(bindElecMeterInfo, sign);
            if (userInfoElecMeter.ok() && userInfoElecMeter.Data != null) {
                return userInfoElecMeter.Data;
            }
            throw HttpException.filter(userInfoElecMeter.Code, userInfoElecMeter.getErrMsg(), userInfoElecMeter.Data, userInfoElecMeter.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public BindElecMeterRoomInfoBean getRoomInformationElecMeter(String str, String str2, String str3, int i) throws HttpException {
        try {
            BindElecMeterInfo bindElecMeterInfo = new BindElecMeterInfo();
            bindElecMeterInfo.schoolId = str;
            bindElecMeterInfo.investorId = str2;
            bindElecMeterInfo.studentId = str3;
            bindElecMeterInfo.thirdPartyId = i;
            String sign = getSign(obJectToString(bindElecMeterInfo));
            LogUtil.e(TAG, obJectToString(bindElecMeterInfo));
            LogUtil.log(obJectToString(bindElecMeterInfo));
            BaseBean<BindElecMeterRoomInfoBean> roomInformationElecMeter = this.mProtocol.getRoomInformationElecMeter(bindElecMeterInfo, sign);
            if (roomInformationElecMeter.ok() && roomInformationElecMeter.Data != null) {
                return roomInformationElecMeter.Data;
            }
            throw HttpException.filter(roomInformationElecMeter.Code, roomInformationElecMeter.getErrMsg(), roomInformationElecMeter.Data, roomInformationElecMeter.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<BindElecMeterRoomInfoBean> getRegionalListElecMeter(String str, String str2, int i, String str3) throws HttpException {
        try {
            SelectElecMeterAreaInfo selectElecMeterAreaInfo = new SelectElecMeterAreaInfo();
            selectElecMeterAreaInfo.schoolId = str;
            selectElecMeterAreaInfo.investorId = str2;
            selectElecMeterAreaInfo.thirdPartyId = i;
            String sign = getSign(obJectToString(selectElecMeterAreaInfo));
            LogUtil.e(TAG, obJectToString(selectElecMeterAreaInfo));
            LogUtil.log(obJectToString(selectElecMeterAreaInfo));
            BaseBean<List<BindElecMeterRoomInfoBean>> regionalListElecMeter = this.mProtocol.getRegionalListElecMeter(selectElecMeterAreaInfo, sign);
            if (regionalListElecMeter.ok() && regionalListElecMeter.Data != null) {
                return regionalListElecMeter.Data;
            }
            throw HttpException.filter(regionalListElecMeter.Code, regionalListElecMeter.getErrMsg(), regionalListElecMeter.Data, regionalListElecMeter.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<BindElecMeterRoomInfoBean> getBuildingListElecMeter(String str, String str2, int i, String str3) throws HttpException {
        try {
            SelectElecMeterBuildingInfo selectElecMeterBuildingInfo = new SelectElecMeterBuildingInfo();
            selectElecMeterBuildingInfo.schoolId = str;
            selectElecMeterBuildingInfo.investorId = str2;
            selectElecMeterBuildingInfo.thirdPartyId = i;
            selectElecMeterBuildingInfo.regionalCode = str3;
            String sign = getSign(obJectToString(selectElecMeterBuildingInfo));
            LogUtil.e(TAG, obJectToString(selectElecMeterBuildingInfo));
            LogUtil.log(obJectToString(selectElecMeterBuildingInfo));
            BaseBean<List<BindElecMeterRoomInfoBean>> buildingListElecMeter = this.mProtocol.getBuildingListElecMeter(selectElecMeterBuildingInfo, sign);
            if (buildingListElecMeter.ok() && buildingListElecMeter.Data != null) {
                return buildingListElecMeter.Data;
            }
            throw HttpException.filter(buildingListElecMeter.Code, buildingListElecMeter.getErrMsg(), buildingListElecMeter.Data, buildingListElecMeter.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<BindElecMeterRoomInfoBean> getFloorListElecMeter(String str, String str2, int i, String str3, String str4) throws HttpException {
        try {
            SelectElecMeterFloorInfo selectElecMeterFloorInfo = new SelectElecMeterFloorInfo();
            selectElecMeterFloorInfo.schoolId = str;
            selectElecMeterFloorInfo.investorId = str2;
            selectElecMeterFloorInfo.thirdPartyId = i;
            selectElecMeterFloorInfo.regionalCode = str3;
            selectElecMeterFloorInfo.buildingCode = str4;
            String sign = getSign(obJectToString(selectElecMeterFloorInfo));
            LogUtil.e(TAG, obJectToString(selectElecMeterFloorInfo));
            LogUtil.log(obJectToString(selectElecMeterFloorInfo));
            BaseBean<List<BindElecMeterRoomInfoBean>> floorListElecMeter = this.mProtocol.getFloorListElecMeter(selectElecMeterFloorInfo, sign);
            if (floorListElecMeter.ok() && floorListElecMeter.Data != null) {
                return floorListElecMeter.Data;
            }
            throw HttpException.filter(floorListElecMeter.Code, floorListElecMeter.getErrMsg(), floorListElecMeter.Data, floorListElecMeter.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<BindElecMeterRoomInfoBean> getRoomListElecMeter(String str, String str2, int i, String str3, String str4, String str5) throws HttpException {
        try {
            SelectElecMeterRoomInfo selectElecMeterRoomInfo = new SelectElecMeterRoomInfo();
            selectElecMeterRoomInfo.schoolId = str;
            selectElecMeterRoomInfo.investorId = str2;
            selectElecMeterRoomInfo.thirdPartyId = i;
            selectElecMeterRoomInfo.regionalCode = str3;
            selectElecMeterRoomInfo.buildingCode = str4;
            selectElecMeterRoomInfo.floorCode = str5;
            String sign = getSign(obJectToString(selectElecMeterRoomInfo));
            LogUtil.e(TAG, obJectToString(selectElecMeterRoomInfo));
            LogUtil.log(obJectToString(selectElecMeterRoomInfo));
            BaseBean<List<BindElecMeterRoomInfoBean>> roomListElecMeter = this.mProtocol.getRoomListElecMeter(selectElecMeterRoomInfo, sign);
            if (roomListElecMeter.ok() && roomListElecMeter.Data != null) {
                return roomListElecMeter.Data;
            }
            throw HttpException.filter(roomListElecMeter.Code, roomListElecMeter.getErrMsg(), roomListElecMeter.Data, roomListElecMeter.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public SuccessBean userBindRoomElecMeter(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) throws HttpException {
        try {
            UserBindRoomElecMeter userBindRoomElecMeter = new UserBindRoomElecMeter();
            userBindRoomElecMeter.schoolId = str;
            userBindRoomElecMeter.investorId = str2;
            userBindRoomElecMeter.studentId = str3;
            userBindRoomElecMeter.thirdPartyId = i;
            userBindRoomElecMeter.regionalCode = str4;
            userBindRoomElecMeter.regionalName = str5;
            userBindRoomElecMeter.buildingCode = str6;
            userBindRoomElecMeter.buildingName = str7;
            userBindRoomElecMeter.floorCode = str8;
            userBindRoomElecMeter.floorName = str9;
            userBindRoomElecMeter.roomCode = str10;
            userBindRoomElecMeter.roomName = str11;
            String sign = getSign(obJectToString(userBindRoomElecMeter));
            LogUtil.e(TAG, obJectToString(userBindRoomElecMeter));
            LogUtil.log(obJectToString(userBindRoomElecMeter));
            BaseBean<SuccessBean> baseBeanUserBindRoomElecMeter = this.mProtocol.userBindRoomElecMeter(userBindRoomElecMeter, sign);
            if (baseBeanUserBindRoomElecMeter.ok()) {
                return baseBeanUserBindRoomElecMeter.Data;
            }
            throw HttpException.filter(baseBeanUserBindRoomElecMeter.Code, baseBeanUserBindRoomElecMeter.getErrMsg(), baseBeanUserBindRoomElecMeter.Data, baseBeanUserBindRoomElecMeter.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public ElecMeterBlanceInfoBean getDeviceBalanceElecMeter(String str, String str2, String str3, int i) throws HttpException {
        try {
            BindElecMeterInfo bindElecMeterInfo = new BindElecMeterInfo();
            bindElecMeterInfo.schoolId = str;
            bindElecMeterInfo.investorId = str2;
            bindElecMeterInfo.studentId = str3;
            bindElecMeterInfo.thirdPartyId = i;
            String sign = getSign(obJectToString(bindElecMeterInfo));
            LogUtil.e(TAG, obJectToString(bindElecMeterInfo));
            LogUtil.log(obJectToString(bindElecMeterInfo));
            BaseBean<ElecMeterBlanceInfoBean> deviceBalanceElecMeter = this.mProtocol.getDeviceBalanceElecMeter(bindElecMeterInfo, sign);
            if (deviceBalanceElecMeter.ok() && deviceBalanceElecMeter.Data != null) {
                return deviceBalanceElecMeter.Data;
            }
            throw HttpException.filter(deviceBalanceElecMeter.Code, deviceBalanceElecMeter.getErrMsg(), deviceBalanceElecMeter.Data, deviceBalanceElecMeter.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<MetersTrendBean> getMetersTrend(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) throws HttpException {
        try {
            MetersTrend metersTrend = new MetersTrend();
            metersTrend.schoolId = str;
            metersTrend.investorId = str2;
            metersTrend.studentId = str3;
            metersTrend.thirdPartyId = i;
            metersTrend.dimensionType = str4;
            metersTrend.startDate = str5;
            metersTrend.endDate = str6;
            metersTrend.startMonth = str7;
            metersTrend.endMonth = str8;
            metersTrend.regionalCode = str9;
            metersTrend.buildingCode = str10;
            metersTrend.floorCode = str11;
            metersTrend.roomCode = str12;
            String sign = getSign(obJectToString(metersTrend));
            LogUtil.e(TAG, obJectToString(metersTrend));
            LogUtil.log(obJectToString(metersTrend));
            BaseBean<List<MetersTrendBean>> metersTrend2 = this.mProtocol.getMetersTrend(metersTrend, sign);
            if (metersTrend2.ok() && metersTrend2.Data != null) {
                return metersTrend2.Data;
            }
            throw HttpException.filter(metersTrend2.Code, metersTrend2.getErrMsg(), metersTrend2.Data, metersTrend2.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public CreateOrderBean elecMeterRechargeCreateOrder(String str, String str2, int i, int i2, int i3, String str3, String str4, String str5, String str6, String str7, String str8, int i4, int i5, YiKaTongPayModelParameterBean yiKaTongPayModelParameterBean) throws HttpException {
        try {
            ElecMeterCreateOrder elecMeterCreateOrder = new ElecMeterCreateOrder();
            elecMeterCreateOrder.machineId = str;
            elecMeterCreateOrder.houseHoldId = str2;
            elecMeterCreateOrder.type = i;
            elecMeterCreateOrder.price = i2;
            elecMeterCreateOrder.payFlagType = i3;
            elecMeterCreateOrder.investorId = str3;
            elecMeterCreateOrder.schoolId = str4;
            elecMeterCreateOrder.studentId = str5;
            elecMeterCreateOrder.studentName = str6;
            elecMeterCreateOrder.studentMobile = str7;
            elecMeterCreateOrder.siteAddress = str8;
            elecMeterCreateOrder.typeId = i4;
            elecMeterCreateOrder.businessType = i5;
            if (i3 == 7) {
                elecMeterCreateOrder.modelType = "wideBodyGdccardPay";
                elecMeterCreateOrder.payModelParameter = yiKaTongPayModelParameterBean;
            } else if (i3 == 3) {
                elecMeterCreateOrder.modelType = "prePay";
            } else if (i3 == 12) {
                elecMeterCreateOrder.payModelParameter = yiKaTongPayModelParameterBean;
            }
            String sign = getSign(obJectToString(elecMeterCreateOrder));
            LogUtil.e(TAG, obJectToString(elecMeterCreateOrder) + "  " + sign);
            LogUtil.log(obJectToString(elecMeterCreateOrder));
            BaseBean<CreateOrderBean> baseBeanElecMeterRechargeCreateOrder = this.mProtocol.elecMeterRechargeCreateOrder(elecMeterCreateOrder, sign);
            if (baseBeanElecMeterRechargeCreateOrder.ok() && baseBeanElecMeterRechargeCreateOrder.Data != null) {
                return baseBeanElecMeterRechargeCreateOrder.Data;
            }
            throw HttpException.filter(baseBeanElecMeterRechargeCreateOrder.Code, baseBeanElecMeterRechargeCreateOrder.getErrMsg(), baseBeanElecMeterRechargeCreateOrder.Data, baseBeanElecMeterRechargeCreateOrder.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public List<ElecRechargeRecordBean> elecMeterRechargeRecord(String str, String str2, String str3, int i) throws HttpException {
        try {
            ElecRechargeRecord elecRechargeRecord = new ElecRechargeRecord();
            elecRechargeRecord.schoolId = str;
            elecRechargeRecord.studentId = str2;
            elecRechargeRecord.machineId = str3;
            elecRechargeRecord.type = i;
            String sign = getSign(obJectToString(elecRechargeRecord));
            LogUtil.e(TAG, obJectToString(elecRechargeRecord));
            LogUtil.log(obJectToString(elecRechargeRecord));
            BaseBean<List<ElecRechargeRecordBean>> baseBeanElecMeterRechargeRecord = this.mProtocol.elecMeterRechargeRecord(elecRechargeRecord, sign);
            if (baseBeanElecMeterRechargeRecord.ok() && baseBeanElecMeterRechargeRecord.Data != null) {
                return baseBeanElecMeterRechargeRecord.Data;
            }
            throw HttpException.filter(baseBeanElecMeterRechargeRecord.Code, baseBeanElecMeterRechargeRecord.getErrMsg(), baseBeanElecMeterRechargeRecord.Data, baseBeanElecMeterRechargeRecord.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public DevicePswRuleBean getDevicePswRule(String str) throws HttpException {
        try {
            V3CombindBean v3CombindBean = new V3CombindBean();
            v3CombindBean.combind(FillInfoActivity.EXTRA_SCHOOLID, str);
            String sign = getSign(v3CombindBean.toString());
            LogUtil.e(TAG, v3CombindBean.toString());
            LogUtil.log(v3CombindBean.toString());
            BaseBean<DevicePswRuleBean> devicePswRule = this.mProtocol.getDevicePswRule(str, sign);
            if (devicePswRule.ok() && devicePswRule.Data != null) {
                return devicePswRule.Data;
            }
            throw HttpException.filter(devicePswRule.Code, devicePswRule.getErrMsg(), devicePswRule.Data, devicePswRule.Serial);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public String postOpen(String str, String str2, String str3, String str4, String str5, int i, String str6, boolean z) throws HttpException {
        V4BaseBean<String> v4BaseBeanPostOpen;
        try {
            OpenPro openPro = new OpenPro();
            openPro.deviceSn = str;
            openPro.deviceRandom = str3;
            openPro.productId = str4;
            openPro.serviceId = str2;
            openPro.hexUserId = str5;
            openPro.countMode = i;
            openPro.content = str6;
            openPro.passwordSeed = str5 + ClientDataManager.getInstance().getString(ClientDataManager.LOGIN_ACCOUNT);
            openPro.openPassword = LocalDataUtil.getAlarmPsw(BaseApplication.app);
            LogUtil.e("AlarmPswTrace", "V3HttpBusinessStore postOpen deviceSn=" + openPro.deviceSn + " hexUserId=" + openPro.hexUserId + " passwordSeed=" + openPro.passwordSeed + " openPassword=" + openPro.openPassword + " deviceRandom=" + openPro.deviceRandom + " productId=" + openPro.productId + " serviceId=" + openPro.serviceId + " countMode=" + openPro.countMode);
            LogUtil.log("参数：" + obJectToString(openPro));
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            String signAuth = V4HeaderUtil.getSignAuth("", headerTimestamp);
            if (z) {
                v4BaseBeanPostOpen = this.mProtocol.postOpenV4(headerTimestamp, V4UserInfoUtil.getInstance().getLoginAccountV4().token, signAuth, openPro);
            } else {
                v4BaseBeanPostOpen = this.mProtocol.postOpen(headerTimestamp, LocalDataUtil.getLastTokenInfo(BaseApplication.app), signAuth, openPro);
            }
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

    public SuccessBean setAlarmSwitch(boolean z) throws HttpException {
        try {
            AlarmSwitchBean alarmSwitchBean = new AlarmSwitchBean();
            alarmSwitchBean.goWhite = z;
            LogUtil.log("参数：");
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            V4BaseBean<SuccessBean> alarmSwitch = this.mProtocol.setAlarmSwitch(headerTimestamp, "", V4HeaderUtil.getSignAuth("", headerTimestamp), alarmSwitchBean);
            if (alarmSwitch.ok()) {
                return alarmSwitch.data;
            }
            throw HttpException.filter(alarmSwitch.code, alarmSwitch.getErrMsg());
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public Boolean alarmSwitch() throws HttpException {
        try {
            LogUtil.log("参数：");
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            return Boolean.valueOf(this.mProtocol.alarmSwitch(headerTimestamp, "", V4HeaderUtil.getSignAuth("", headerTimestamp)).goWhite);
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    public AlarmSwitchBean2 alarmSwitch2(String str) throws HttpException {
        try {
            LogUtil.log("参数：");
            LogUtil.e("AlarmPswTrace", "V3HttpBusinessStore alarmSwitch2 request seed=" + str);
            String headerTimestamp = V4HeaderUtil.getHeaderTimestamp();
            V4BaseBean<String> v4BaseBeanAlarmSwitch2 = this.mProtocol.alarmSwitch2(headerTimestamp, "", V4HeaderUtil.getSignAuth("", headerTimestamp), str);
            LogUtil.e("AlarmPswTrace", "V3HttpBusinessStore alarmSwitch2 response seed=" + str + " goWhite=" + v4BaseBeanAlarmSwitch2.goWhite + " openPassword=" + v4BaseBeanAlarmSwitch2.openPassword);
            AlarmSwitchBean2 alarmSwitchBean2 = new AlarmSwitchBean2();
            alarmSwitchBean2.goWhite = v4BaseBeanAlarmSwitch2.goWhite;
            alarmSwitchBean2.openPassword = v4BaseBeanAlarmSwitch2.openPassword;
            return alarmSwitchBean2;
        } catch (Exception e) {
            if (e instanceof HttpException) {
                throw ((HttpException) e);
            }
            throw HttpException.getDefautException();
        }
    }

    private String getSign(String str) {
        return MD5.md5(StringUtils.asciiToString("49,70,70,55,53,69,53,49,50") + str);
    }

    private String obJectToString(Object obj) {
        try {
            return GsonUtils.getInstance().parse(obj);
        } catch (ClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    class V3CombindBean {
        private String returnStr = "";

        V3CombindBean() {
        }

        public V3CombindBean combind(String str, String str2) {
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

    private String getBase64Encode(String str) {
        LogUtil.e(TAG, "Base64加密");
        return Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 0).replaceAll("(\\\r\\\n|\\\r|\\\n|\\\n\\\r)", "");
    }

    private String getAesData(String str) throws HttpException {
        try {
            return AESHelper.encrypt(str, StringUtils.asciiToString(HttpComfigUtil.AESKEYDATA));
        } catch (Exception unused) {
            throw new HttpException(-1001, "获取服务器数据失败");
        }
    }

    private String decryptData(String str) {
        try {
            return AESHelper.decrypt(str, StringUtils.asciiToString(HttpComfigUtil.AESKEYDATA));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String getSignV3(String str) {
        return MD5.md5_SmallRoutine(StringUtils.asciiToString(HttpComfigUtil.MD5KEY_V3) + str);
    }
}
