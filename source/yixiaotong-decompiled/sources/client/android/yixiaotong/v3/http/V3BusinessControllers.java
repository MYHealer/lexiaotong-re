package client.android.yixiaotong.v3.http;

import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.gonggaolan.Detail;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAllAnnounceListBean;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAnnouncementBean;
import client.android.yixiaotong.controller.core.BaseControllers;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.exception.HttpException;
import client.android.yixiaotong.v3.bean.AlarmSwitchBean2;
import client.android.yixiaotong.v3.bean.PlatformInfoBean;
import client.android.yixiaotong.v3.bean.adv.AdvBean;
import client.android.yixiaotong.v3.bean.adv.AdvRulesBean;
import client.android.yixiaotong.v3.bean.appointment.AppointmentBean;
import client.android.yixiaotong.v3.bean.appointment.AppointmentListBean;
import client.android.yixiaotong.v3.bean.appointment.AppointmentResultBean;
import client.android.yixiaotong.v3.bean.appointment.UsingBean;
import client.android.yixiaotong.v3.bean.area.AreaListBean;
import client.android.yixiaotong.v3.bean.card.BuyClubCardBean;
import client.android.yixiaotong.v3.bean.card.ClubCardBean;
import client.android.yixiaotong.v3.bean.card.CreateOrderBean;
import client.android.yixiaotong.v3.bean.card.SchoolCardInfoBean;
import client.android.yixiaotong.v3.bean.consumer.ConsumerCreateOrderBean;
import client.android.yixiaotong.v3.bean.consumer.ConsumerPriceInfoBean;
import client.android.yixiaotong.v3.bean.consumer.ConsumerQueryOrderBean;
import client.android.yixiaotong.v3.bean.deviceinfo.BluetoothSetBean;
import client.android.yixiaotong.v3.bean.deviceinfo.DevicePswRuleBean;
import client.android.yixiaotong.v3.bean.deviceinfo.GetModeBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByLocationBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByMacBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineInfoJson;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineStatusData;
import client.android.yixiaotong.v3.bean.deviceinfo.NBOr4GDevice;
import client.android.yixiaotong.v3.bean.deviceinfo.NBOr4GStatuBean;
import client.android.yixiaotong.v3.bean.deviceinfo.PostPrepareBathBean;
import client.android.yixiaotong.v3.bean.deviceinfo.SetData;
import client.android.yixiaotong.v3.bean.drawmoney.DMGetOrderBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMGetQrcodeBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMHandleDataBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMOrderRecordBean;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterInfoBean;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterRoomInfoBean;
import client.android.yixiaotong.v3.bean.elecmeter.ElecMeterBlanceInfoBean;
import client.android.yixiaotong.v3.bean.elecmeter.ElecRechargeRecordBean;
import client.android.yixiaotong.v3.bean.elecmeter.MetersTrendBean;
import client.android.yixiaotong.v3.bean.login.HostUrlBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.bean.login.InvestoridAndSchoolId;
import client.android.yixiaotong.v3.bean.login.LoginSeccessBean;
import client.android.yixiaotong.v3.bean.login.SchoolIdBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfoBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.bean.login.SchoolQrcodeBean;
import client.android.yixiaotong.v3.bean.login.UserInfoBean;
import client.android.yixiaotong.v3.bean.order.BuyClubCardDetailBean;
import client.android.yixiaotong.v3.bean.order.BuyClubCradRecordBean;
import client.android.yixiaotong.v3.bean.order.CouponBean;
import client.android.yixiaotong.v3.bean.order.DepositRechargeRecordBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderListBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderResultBean;
import client.android.yixiaotong.v3.bean.order.OrderMoreDetailBean;
import client.android.yixiaotong.v3.bean.order.OrderRecordBean;
import client.android.yixiaotong.v3.bean.order.UnPayOrdersBean;
import client.android.yixiaotong.v3.bean.pay.SelectAllBean;
import client.android.yixiaotong.v3.bean.pay.SignBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentDeviceInfoBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentRedPackageAmountBean;
import client.android.yixiaotong.v3.bean.prepayment.PrepaymentWalletBean;
import client.android.yixiaotong.v3.bean.prepayment.RefundBean;
import client.android.yixiaotong.v3.bean.prepayment.SetWaterZeroBean;
import client.android.yixiaotong.v3.bean.prepayment.SupervisorBean;
import client.android.yixiaotong.v3.bean.prepayment.UnFinishOrderBean;
import client.android.yixiaotong.v3.bean.prepayment.UserInfoByMobileBean;
import client.android.yixiaotong.v3.bean.register.MobileMessageBean;
import client.android.yixiaotong.v3.bean.register.PswBean;
import client.android.yixiaotong.v3.bean.sellcard.DeductionRuleBean;
import client.android.yixiaotong.v3.bean.user.AppVersionBean;
import client.android.yixiaotong.v3.bean.user.HistoryLoginInfoBean;
import client.android.yixiaotong.v3.bean.user.UserCommon;
import client.android.yixiaotong.v3.bean.user.UserPage;
import client.android.yixiaotong.v3.bean.wallet.AppIdAndSecretBean;
import client.android.yixiaotong.v3.bean.wallet.CashRedPackageBean;
import client.android.yixiaotong.v3.bean.wallet.DepositionBean;
import client.android.yixiaotong.v3.bean.wallet.PayModelParameter;
import client.android.yixiaotong.v3.bean.wallet.WalletInfoBean;
import client.android.yixiaotong.v3.bean.wallet.WalletRefundDetailBean;
import client.android.yixiaotong.v3.bean.wallet.YiKaTongPayModelParameterBean;
import client.android.yixiaotong.v3.bean.wallet.YiKaTongPayResultBean;
import client.android.yixiaotong.v3.bean.ykt.OpenYKTBean;
import client.android.yixiaotong.v3.bean.ykt.YKTBindStateBean;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V3BusinessControllers extends BaseControllers {
    private V3BusinessControllers() {
    }

    private static class SingletonHolder {
        public static final V3BusinessControllers INSTANCE = new V3BusinessControllers();

        private SingletonHolder() {
        }
    }

    public static V3BusinessControllers getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void getAppVerInfo(final Account account, final String str, final String str2, Listener<AppVersionBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getAppVerInfo(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getAppVerInfo2(final Account account, final String str, final String str2, final String str3, Listener<AppVersionBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getAppVerInfo2(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getPlatformInfo(final Account account, final String str, Listener<PlatformInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3TopServerUrl()).getPlatformInfo(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getCheckUser(final Account account, final String str, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getCheckUser(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postUserLogin(final Account account, final String str, final String str2, final String str3, Listener<LoginSeccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3TopServerUrl()).postUserLogin(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postRedisCach(final Account account, final String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postRedisCach(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getRedisCach(final Account account, final String str, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getRedisCach(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getCode(final Account account, final String str, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3TopServerUrl()).getCode(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getUserLogout(final Account account, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getUserLogout(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getUserInfo(final Account account, Listener<UserInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getUserInfo(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getSelectStudentNumberBySchoolId(final Account account, final String str, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getSelectStudentNumberBySchoolId(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postUserInfo(final Account account, final int i, final String str, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postUserInfo(i, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postUpdateStudentNumberBySchoolId(final Account account, final String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postUpdateStudentNumberBySchoolId(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getSchoolInfo(final Account account, Listener<SchoolInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getSchoolInfo(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getSchoolInfos(final Account account, final String str, final boolean z, Listener<List<SchoolInfosBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                        return;
                    }
                    String v3PlatformServerUrl = GetDebugHttpUrlUtil.getV3PlatformServerUrl("");
                    if (z) {
                        v3PlatformServerUrl = GetDebugHttpUrlUtil.getV3TopServerUrl();
                    }
                    V3BusinessControllers.this.callComplete(controller, account.getV3HttpBusinessStore(v3PlatformServerUrl).getSchoolInfos(str), new Object[0]);
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getInvestorInfo(final Account account, Listener<List<InvestorInfosBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getInvestorInfo(UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + ""), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getDepositInfoByInvestorid(final Account account, final String str, final String str2, Listener<DepositionBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getDepositInfoByInvestorid(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postGetWalletInfoByInvestorid(final Account account, final String str, Listener<WalletInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postGetWalletInfoByInvestorid(UserInfoUtilControl.getInstance().getSchoolId(), str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postGetWalletInfoByInvestoridV2(final Account account, final String str, Listener<WalletInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postGetWalletInfoByInvestoridV2(UserInfoUtilControl.getInstance().getStudentId(), UserInfoUtilControl.getInstance().getSchoolId(), str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getMachineByMac(final Account account, final String str, final int i, Listener<MachineByMacBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getMachineByMac(str, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getUpdateMachineMac(final Account account, final String str, final String str2, final int i, Listener<MachineByMacBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.21
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getUpdateMachineMac(str, str2, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getMachineByMachineId(final Account account, final String str, final int i, Listener<MachineByMacBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.22
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getMachineByMachineId(str, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getMachineByMachineId2(final Account account, final String str, final boolean z, Listener<MachineByMacBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.23
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                        return;
                    }
                    String v3PlatformServerUrl = GetDebugHttpUrlUtil.getV3PlatformServerUrl("");
                    if (z) {
                        v3PlatformServerUrl = GetDebugHttpUrlUtil.getV3TopServerUrl();
                    }
                    V3BusinessControllers.this.callComplete(controller, account.getV3HttpBusinessStore(v3PlatformServerUrl).getMachineByMachineId2(str), new Object[0]);
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getInfoByQRCode(final Account account, final String str, final boolean z, Listener<MachineByMacBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.24
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                        return;
                    }
                    String v3PlatformServerUrl = GetDebugHttpUrlUtil.getV3PlatformServerUrl("");
                    if (z) {
                        v3PlatformServerUrl = GetDebugHttpUrlUtil.getV3TopServerUrl();
                    }
                    V3BusinessControllers.this.callComplete(controller, account.getV3HttpBusinessStore(v3PlatformServerUrl).getInfoByQRCode(str), new Object[0]);
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getUseInfoByMachineId(final Account account, final String str, final int i, Listener<InvestoridAndSchoolId> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.25
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getUseInfoByMachineId(str, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postPrepareBath(final Account account, final int i, final String str, final String str2, final MachineInfoJson machineInfoJson, Listener<PostPrepareBathBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.26
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postPrepareBath(i, str, str2, machineInfoJson), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postOpenAuth(final Account account, final int i, final int i2, final String str, final String str2, final String str3, final MachineInfoJson machineInfoJson, Listener<Object> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.27
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postOpenAuth(i, i2, str, str2, str3, machineInfoJson), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postCloseAuth(final Account account, final int i, final int i2, final String str, final String str2, final MachineInfoJson machineInfoJson, Listener<Object> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.28
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postCloseAuth(i, i2, str, str2, machineInfoJson), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getNBOr4GStatus(final Account account, final int i, final String str, final int i2, final String str2, Listener<NBOr4GStatuBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.29
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getNBOr4GStatus(i, str, i2, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postHandleData(final Account account, final int i, final String str, final String str2, final NBOr4GDevice nBOr4GDevice, final int i2, Listener<Object> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.30
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postHandleData(i, str, str2, nBOr4GDevice, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postGetMode(final Account account, final int i, final String str, final String str2, Listener<GetModeBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.31
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postGetMode(i, str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postDMHandleData(final Account account, final int i, final String str, final String str2, Listener<DMHandleDataBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.32
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postDMHandleData(i, str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postDMGetOrder(final Account account, final String str, final String str2, final String str3, final int i, final String str4, final String str5, final String str6, final int i2, final int i3, final int i4, final int i5, final int i6, final String str7, Listener<DMGetOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.33
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postDMGetOrder(str, str2, str3, i, str4, str5, str6, i2, i3, i4, i5, i6, str7), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getDMChargeQRCode(final Account account, final int i, final String str, final String str2, final int i2, final String str3, Listener<DMGetQrcodeBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.34
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getDMChargeQRCode(i, str, str2, i2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postDMRemoveData(final Account account, final int i, final String str, final String str2, Listener<DMGetQrcodeBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.35
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postDMRemoveData(i, str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postMachineRunInfo(final Account account, final int i, final String str, final String str2, final MachineStatusData machineStatusData, Listener<BluetoothSetBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.36
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postMachineRunInfo(i, str, str2, machineStatusData), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postBluetoothSetData(final Account account, final int i, final String str, final String str2, final SetData setData, Listener<BluetoothSetBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.37
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postBluetoothSetData(i, str, str2, setData), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postBluetoothSetDataResult(final Account account, final int i, final String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.38
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postBluetoothSetDataResult(i, str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getLowerAreas(final Account account, final String str, Listener<List<AreaListBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.39
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getLowerAreas(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getDormitoryOrPublicRoom(final Account account, final String str, Listener<List<AreaListBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.40
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getDormitoryOrPublicRoom(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postGetMachineByLocation(final Account account, final String str, final int i, final int i2, Listener<List<MachineByLocationBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.41
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postGetMachineByLocation(str, i, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getOrderList(final Account account, final String str, final int i, final int i2, final int i3, final String str2, final String str3, final int i4, Listener<OrderRecordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.42
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getOrderList(str, i, i2, i3, str2, str3, i4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getOrderIdInfo(final Account account, final String str, final int i, final String str2, final String str3, final String str4, final String str5, final int i2, Listener<OrderMoreDetailBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.43
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getOrderIdInfo(str, i, str2, str3, str4, str5, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getOrderIntegration(final Account account, final String str, final String str2, final int i, final int i2, final int i3, final int i4, Listener<DMOrderRecordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.44
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getOrderIntegration(str, str2, i, i2, i3, i4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getNoPayOrders(final Account account, final String str, final int i, final String str2, final String str3, final String str4, final String str5, final int i2, Listener<NoPayOrderListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.45
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getNoPayOrders(str, i, str2, str3, str4, str5, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postPayOrders(final Account account, final String str, final String str2, final int i, final int i2, final int i3, final List<NoPayOrderBean> list, final String str3, final String str4, final int i4, Listener<NoPayOrderResultBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.46
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postPayOrders(str, str2, i, i2, i3, list, str3, str4, i4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postCancelPayOrders(final Account account, final String str, final String str2, Listener<NoPayOrderResultBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.47
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postCancelPayOrders(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getAnalysisQRCode(final Account account, final String str, Listener<SchoolIdBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.48
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3TopServerUrl()).getAnalysisQRCode(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postBindSchoolInfo(final Account account, final String str, final String str2, final boolean z, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.49
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                        return;
                    }
                    String v3PlatformServerUrl = GetDebugHttpUrlUtil.getV3PlatformServerUrl("");
                    if (z) {
                        v3PlatformServerUrl = GetDebugHttpUrlUtil.getV3TopServerUrl();
                    }
                    V3BusinessControllers.this.callComplete(controller, account.getV3HttpBusinessStore(v3PlatformServerUrl).postBindSchoolInfo(str, str2), new Object[0]);
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getListByAreaInfo(final Account account, final String str, final String str2, Listener<List<SchoolInfosBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.50
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getListByAreaInfo(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getQRCodeBySchoolId(final Account account, final String str, Listener<SchoolQrcodeBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.51
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getQRCodeBySchoolId(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getMoblieMessage(final Account account, final String str, final int i, final String str2, Listener<MobileMessageBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.52
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3TopServerUrl()).getMoblieMessage(str, i, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postMoblieRegisterUser(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.53
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3TopServerUrl()).postMoblieRegisterUser(str, str2, str3, str4, str5), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postLoginPasswordByAuthenticationMessage(final Account account, final String str, final String str2, final String str3, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.54
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3TopServerUrl()).postLoginPasswordByAuthenticationMessage(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postStudentMobileByAuthenticationMessage(final Account account, final String str, final String str2, final String str3, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.55
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postStudentMobileByAuthenticationMessage(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postResetLoginPassword(final Account account, final String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.56
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postResetLoginPassword(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getDelayedPassword(final Account account, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.57
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getDelayedPassword(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getFindMachiniePWD(final Account account, final String str, Listener<PswBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.58
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getFindMachiniePWD(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postSetMachinePWD(final Account account, final String str, final String str2, Listener<PswBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.59
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postSetMachinePWD(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postUpdateMachinePWD(final Account account, final String str, final String str2, final String str3, Listener<PswBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.60
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postUpdateMachinePWD(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getCouponList(final Account account, final String str, final String str2, final int i, final int i2, final int i3, final int i4, final String str3, final String str4, Listener<List<CouponBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.61
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getCouponList(str, str2, i, i2, i3, i4, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getClubCardList(final Account account, final int i, final int i2, Listener<List<ClubCardBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.62
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getClubCardList(i, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postActivate(final Account account, final String str, final String str2, final long j, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.63
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postActivate(str, str2, j), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postRefundCard(final Account account, final String str, final String str2, final String str3, final int i, final int i2, final String str4, final String str5, final String str6, final String str7, Listener<CreateOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.64
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postRefundCard(str, str2, str3, i, i2, str4, str5, str6, str7), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postCreateOrders(final Account account, final String str, final String str2, final int i, final long j, final long j2, final int i2, final int i3, final YiKaTongPayModelParameterBean yiKaTongPayModelParameterBean, Listener<CreateOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.65
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postCreateOrders(str, str2, i, j, j2, i2, i3, yiKaTongPayModelParameterBean), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getAppInfo(final Account account, final String str, final String str2, Listener<AppIdAndSecretBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.66
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getAppInfo(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postRefundOrders(final Account account, final String str, final String str2, final int i, final String str3, final int i2, final int i3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, Listener<CreateOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.67
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postRefundOrders(str, str2, i, str3, i2, i3, str4, str5, str6, str7, str8, str9, str10, str11), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postRefundPic(final Account account, final String str, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.68
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3PicHttpBusinessStore().postRefundPic(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postRevokeRefundOrders(final Account account, final String str, final String str2, final int i, final String str3, Listener<CreateOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.69
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postRevokeRefundOrders(str, str2, i, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getClubCardListByInvestorid(final Account account, final String str, final String str2, Listener<List<BuyClubCardBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.70
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getClubCardListByInvestorid(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getClubCardOrderList(final Account account, final String str, final int i, final int i2, final int i3, Listener<BuyClubCradRecordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.71
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getClubCardOrderList(str, i, i2, i3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getWalletOrderList(final Account account, final String str, final int i, final int i2, Listener<BuyClubCradRecordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.72
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getWalletOrderList(str, i, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getWalletRefundOrderList(final Account account, final String str, final int i, final int i2, final int i3, Listener<BuyClubCradRecordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.73
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getWalletRefundOrderList(str, i, i2, i3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getRefundIdInfo(final Account account, final String str, final String str2, final String str3, Listener<WalletRefundDetailBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.74
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getRefundIdInfo(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getSurrenderIdInfo(final Account account, final String str, final String str2, final String str3, Listener<WalletRefundDetailBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.75
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getSurrenderIdInfo(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getDepositOrderList(final Account account, final String str, final String str2, Listener<DepositRechargeRecordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.76
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getDepositOrderList(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getDepositRefundOrderList(final Account account, final String str, final int i, final int i2, Listener<BuyClubCradRecordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.77
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getDepositRefundOrderList(str, i, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getFindCard(final Account account, final String str, Listener<SchoolCardInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.78
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getFindCard(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void bindCardForOpen(final Account account, final String str, final String str2, final String str3, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.79
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).bindCardForOpen(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postBindCardByMachine(final Account account, final String str, final String str2, final String str3, final String str4, final List<Integer> list, Listener<SchoolCardInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.80
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postBindCardByMachine(str, str2, str3, str4, list), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postBindCardByMachine2(final Account account, final String str, final String str2, final List<Integer> list, Listener<SchoolCardInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.81
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postBindCardByMachine2(str, str2, list), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postUnbindCard(final Account account, final String str, final String str2, Listener<SchoolCardInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.82
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postUnbindCard(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postOpenApplyCard(final Account account, final String str, final String str2, final int i, Listener<SchoolCardInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.83
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postOpenApplyCard(str, str2, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postCloseApplyCard(final Account account, final String str, final String str2, final int i, Listener<SchoolCardInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.84
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postCloseApplyCard(str, str2, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getPayResultForYiKaTong(final Account account, final String str, final String str2, final int i, final String str3, final PayModelParameter payModelParameter, Listener<YiKaTongPayResultBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.85
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getPayResultForYiKaTong(str, str2, i, str3, payModelParameter), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void findAdvertisingFacilitatorRules(final Account account, Listener<AdvRulesBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.86
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).findAdvertisingFacilitatorRules(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getAdvertising(final Account account, final String str, final String str2, Listener<AdvBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.87
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getAdvertising(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getUsingList(final Account account, final String str, final String str2, final int i, Listener<List<UsingBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.88
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getUsingList(str, str2, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getList(final Account account, final String str, final String str2, final String str3, final String str4, final int i, Listener<AppointmentListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.89
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getList(str, str2, str3, str4, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void reserve(final Account account, final String str, final int i, final int i2, Listener<AppointmentBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.90
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).reserve(str, i, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void cancelReserve(final Account account, final String str, final String str2, final int i, final int i2, final int i3, Listener<AppointmentBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.91
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).cancelReserve(str, str2, i, i2, i3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getResult(final Account account, final String str, final int i, final int i2, final String str2, Listener<AppointmentResultBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.92
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getResult(str, i, i2, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getUpdateStatus(final Account account, final String str, final int i, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.93
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getUpdateStatus(str, i, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getMoneyCouponAmount(final Account account, final String str, final String str2, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.94
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getMoneyCouponAmount(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getMoneyCouponAmountV2(final Account account, final String str, final String str2, Listener<CashRedPackageBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.95
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getMoneyCouponAmountV2(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void appUpdateUserStatus(final Account account, final int i, final String str, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.96
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).appUpdateUserStatus(i, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getUnPayOrderIndex(final Account account, final String str, Listener<UnPayOrdersBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.97
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getUnPayOrderIndex(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void paySelectAll(final Account account, final String str, final String str2, final String str3, final int i, Listener<List<SelectAllBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.98
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).paySelectAll(str, str2, str3, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getPayResult(final Account account, final int i, final String str, Listener<SignBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.99
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getPayResult(i, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postUserActiveInfo(final Account account, final UserCommon userCommon, final UserPage userPage, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.100
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3ActiveServerUrl()).postUserActiveInfo(userCommon, userPage), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postBindSchoolGive(final Account account, final String str, final String str2, final String str3, final String str4, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.101
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postBindSchoolGive(str, str2, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getDeviceInfo(final Account account, final String str, Listener<PrepaymentDeviceInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.102
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getDeviceInfo(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getPrepaymentWallet(final Account account, final String str, final String str2, final String str3, Listener<PrepaymentWalletBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.103
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getPrepaymentWallet(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getPrepaymentRedPackageAmount(final Account account, final String str, final String str2, final String str3, Listener<PrepaymentRedPackageAmountBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.104
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getPrepaymentRedPackageAmount(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postPrepaymentCreateOrders(final Account account, final String str, final String str2, final int i, final String str3, final String str4, final int i2, final int i3, final YiKaTongPayModelParameterBean yiKaTongPayModelParameterBean, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, final String str12, final String str13, Listener<CreateOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.105
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postPrepaymentCreateOrders(str, str2, i, str3, str4, i2, i3, yiKaTongPayModelParameterBean, str5, str6, str7, str8, str9, str10, str11, str12, str13), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getAppendOrderStatus(final Account account, final String str, final String str2, final String str3, Listener<PrepaymentWalletBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.106
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getAppendOrderStatus(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getUnFinishOrder(final Account account, final String str, final String str2, final String str3, Listener<List<UnFinishOrderBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.107
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getUnFinishOrder(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void waterAppendCallback(final Account account, final String str, final String str2, final String str3, final int i, Listener<BuyClubCardDetailBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.108
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).waterAppendCallback(str, str2, str3, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getPrepaymentRechargeOrderList(final Account account, final String str, final String str2, final int i, Listener<BuyClubCradRecordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.109
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getPrepaymentRechargeOrderList(str, str2, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getPrepaymentRefundOrderList(final Account account, final String str, final String str2, final int i, Listener<BuyClubCradRecordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.110
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getPrepaymentRefundOrderList(str, str2, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getPrepaymentSupervisor(final Account account, final String str, final String str2, final String str3, Listener<SupervisorBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.111
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getPrepaymentSupervisor(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void changeSupervisor(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.112
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).changeSupervisor(str, str2, str3, str4, str5, str6), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getUserByStudentMobile(final Account account, final String str, Listener<UserInfoByMobileBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.113
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getUserByStudentMobile(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void pastSupervisor(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.114
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).pastSupervisor(str, str2, str3, str4, str5, str6), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getSetWaterZeroData(final Account account, final String str, final String str2, final String str3, final String str4, Listener<SetWaterZeroBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.115
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getSetWaterZeroData(str, str2, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void refundOrderPrepayment(final Account account, final String str, final int i, final int i2, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, final String str12, Listener<RefundBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.116
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).refundOrderPrepayment(str, i, i2, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void unlock(final Account account, final String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.117
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).unlock(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void cancelRefundOrderPrepayment(final Account account, final String str, final String str2, final String str3, Listener<RefundBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.118
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).cancelRefundOrderPrepayment(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void findRefundOrderForPrepayment(final Account account, final String str, final String str2, final String str3, Listener<RefundBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.119
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).findRefundOrderForPrepayment(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void checkPrepaymentDeductionRule(final Account account, final String str, final String str2, final String str3, Listener<Integer> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.120
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).checkPrepaymentDeductionRule(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void selectDeductionRule(final Account account, final String str, final int i, final String str2, final String str3, Listener<DeductionRuleBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.121
            @Override // java.lang.Runnable
            public void run() {
                try {
                    V3BusinessControllers.this.callComplete(controller, account.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).selectDeductionRule(str, i, str2, str3), new Object[0]);
                } catch (ClientException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getIsHasSellCardDevice(final Account account, final String str, final String str2, final int i, final String str3, Listener<Integer> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.122
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getIsHasSellCardDevice(str, str2, i, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postCreateBluetoothOrder(final Account account, final String str, final String str2, final String str3, final int i, final String str4, final int i2, final int i3, final int i4, final int i5, final String str5, Listener<DMGetOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.123
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postCreateBluetoothOrder(str, str2, str3, i, str4, i2, i3, i4, i5, str5), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getSellCardAuthData(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, Listener<AppointmentBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.124
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getSellCardAuthData(str, str2, str3, str4, str5), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getExtendCardInfo(final Account account, final String str, final String str2, final String str3, Listener<YKTBindStateBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.125
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getExtendCardInfo(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void bindExtendCardInfo(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, Listener<YKTBindStateBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.126
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).bindExtendCardInfo(str, str2, str3, str4, str5), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getIsOpenYKT(final Account account, final String str, final String str2, final String str3, Listener<OpenYKTBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.127
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getIsOpenYKT(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getAnnouncementV3(final Account account, final String str, final String str2, Listener<List<GetAnnouncementBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.128
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getAnnouncementV3(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getAnnouncementDetailNewV3(final Account account, final long j, Listener<Detail> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.129
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getAnnouncementDetailNewV3(j), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getAllAnnouncementV3(final Account account, final String str, final String str2, Listener<GetAllAnnounceListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.130
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getAllAnnouncementV3(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getMobileInfo(final Account account, final String str, Listener<List<HistoryLoginInfoBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.131
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getMobileInfo(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getHostUrlBySchoolIdAndInvestorId(final Account account, final String str, final String str2, final String str3, Listener<List<HostUrlBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.132
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3TopServerUrl()).getHostUrlBySchoolIdAndInvestorId(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getCalculatePrepaidMoney(final Account account, final String str, final String str2, final int i, final String str3, final String str4, final String str5, final int i2, Listener<ConsumerPriceInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.133
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getCalculatePrepaidMoney(str, str2, i, str3, str4, str5, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postConsumerCreateOrder(final Account account, final String str, final String str2, final int i, final String str3, final String str4, final String str5, final int i2, final int i3, final int i4, final String str6, final String str7, final String str8, final String str9, final int i5, final int i6, final Long l, final Integer num, final int i7, final String str10, final int i8, Listener<ConsumerCreateOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.134
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postConsumerCreateOrder(str, str2, i, str3, str4, str5, i2, i3, i4, str6, str7, str8, str9, i5, i6, l, num, i7, str10, i8), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postConsumerQueryOrder(final Account account, final String str, final String str2, final int i, final String str3, Listener<ConsumerQueryOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.135
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).postConsumerQueryOrder(str, str2, i, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getUserInfoElecMeter(final Account account, final String str, final String str2, final String str3, final int i, Listener<BindElecMeterInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.136
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getUserInfoElecMeter(str, str2, str3, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getRoomInformationElecMeter(final Account account, final String str, final String str2, final String str3, final int i, Listener<BindElecMeterRoomInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.137
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getRoomInformationElecMeter(str, str2, str3, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getRegionalListElecMeter(final Account account, final String str, final String str2, final int i, final String str3, Listener<List<BindElecMeterRoomInfoBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.138
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getRegionalListElecMeter(str, str2, i, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getBuildingListElecMeter(final Account account, final String str, final String str2, final int i, final String str3, Listener<List<BindElecMeterRoomInfoBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.139
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getBuildingListElecMeter(str, str2, i, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getFloorListElecMeter(final Account account, final String str, final String str2, final int i, final String str3, final String str4, Listener<List<BindElecMeterRoomInfoBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.140
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getFloorListElecMeter(str, str2, i, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getRoomListElecMeter(final Account account, final String str, final String str2, final int i, final String str3, final String str4, final String str5, Listener<List<BindElecMeterRoomInfoBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.141
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getRoomListElecMeter(str, str2, i, str3, str4, str5), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void userBindRoomElecMeter(final Account account, final String str, final String str2, final String str3, final int i, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.142
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).userBindRoomElecMeter(str, str2, str3, i, str4, str5, str6, str7, str8, str9, str10, str11), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getDeviceBalanceElecMeter(final Account account, final String str, final String str2, final String str3, final int i, Listener<ElecMeterBlanceInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.143
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getDeviceBalanceElecMeter(str, str2, str3, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getMetersTrend(final Account account, final String str, final String str2, final String str3, final int i, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final String str11, final String str12, Listener<List<MetersTrendBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.144
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getMetersTrend(str, str2, str3, i, str4, str5, str6, str7, str8, str9, str10, str11, str12), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void elecMeterRechargeCreateOrder(final Account account, final String str, final String str2, final int i, final int i2, final int i3, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final int i4, final int i5, final YiKaTongPayModelParameterBean yiKaTongPayModelParameterBean, Listener<CreateOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.145
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).elecMeterRechargeCreateOrder(str, str2, i, i2, i3, str3, str4, str5, str6, str7, str8, i4, i5, yiKaTongPayModelParameterBean), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void elecMeterRechargeRecord(final Account account, final String str, final String str2, final String str3, final int i, Listener<List<ElecRechargeRecordBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.146
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).elecMeterRechargeRecord(str, str2, str3, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getDevicePswRule(final Account account, final String str, Listener<DevicePswRuleBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.147
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(GetDebugHttpUrlUtil.getV3PlatformServerUrl("")).getDevicePswRule(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postOpen(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final int i, final String str6, final boolean z, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.148
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(V3HttpConfig.OPENPRO_SERVER).postOpen(str, str2, str3, str4, str5, i, str6, z), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void setAlarmSwitch(final Account account, final boolean z, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.149
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(V3HttpConfig.GOWHITE_SERVER).setAlarmSwitch(z), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void alarmSwitch(final Account account, Listener<Boolean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.150
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(V3HttpConfig.GOWHITE_SERVER).alarmSwitch(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void alarmSwitch2(final Account account, final String str, Listener<AlarmSwitchBean2> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v3.http.V3BusinessControllers.151
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V3BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V3BusinessControllers.this.callComplete(controller, account2.getV3HttpBusinessStore(V3HttpConfig.GOWHITE_SERVER).alarmSwitch2(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V3BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }
}
