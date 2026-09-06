package client.android.yixiaotong.controller;

import android.util.Log;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.AccreditBean;
import client.android.yixiaotong.controller.bean.AeemterAuthorizeBean;
import client.android.yixiaotong.controller.bean.AliPayBean;
import client.android.yixiaotong.controller.bean.AmmeterAliPayBean;
import client.android.yixiaotong.controller.bean.AmmeterAreaInfo;
import client.android.yixiaotong.controller.bean.AmmeterBindRoomBean;
import client.android.yixiaotong.controller.bean.AmmeterBindingRoom;
import client.android.yixiaotong.controller.bean.AmmeterDestroyBean;
import client.android.yixiaotong.controller.bean.AmmeterEndBean;
import client.android.yixiaotong.controller.bean.AmmeterInitBean;
import client.android.yixiaotong.controller.bean.AmmeterOrderStateBean;
import client.android.yixiaotong.controller.bean.AmmeterPricesBean;
import client.android.yixiaotong.controller.bean.AmmeterRecordListBean;
import client.android.yixiaotong.controller.bean.AmmeterRoomDetail;
import client.android.yixiaotong.controller.bean.AmmeterSettingBean;
import client.android.yixiaotong.controller.bean.AmmeterStateBean;
import client.android.yixiaotong.controller.bean.AmmeterSubsidyBean;
import client.android.yixiaotong.controller.bean.AmmeterWeiXinPayBean;
import client.android.yixiaotong.controller.bean.AmmeterWriteSettingBean;
import client.android.yixiaotong.controller.bean.AreasBean;
import client.android.yixiaotong.controller.bean.DeviceInfoBean;
import client.android.yixiaotong.controller.bean.GetDeviceQrCodeBean;
import client.android.yixiaotong.controller.bean.GetMealQrcodeBean;
import client.android.yixiaotong.controller.bean.HairDryerBean;
import client.android.yixiaotong.controller.bean.HairDryerOrderBean;
import client.android.yixiaotong.controller.bean.HelloBean;
import client.android.yixiaotong.controller.bean.ManagerBean;
import client.android.yixiaotong.controller.bean.MessageRecordListBean;
import client.android.yixiaotong.controller.bean.NullBean;
import client.android.yixiaotong.controller.bean.OpenDataBean;
import client.android.yixiaotong.controller.bean.OrderBean;
import client.android.yixiaotong.controller.bean.RecordListBean;
import client.android.yixiaotong.controller.bean.RefundBean;
import client.android.yixiaotong.controller.bean.RepairProcessListBean;
import client.android.yixiaotong.controller.bean.SoundWaveBean;
import client.android.yixiaotong.controller.bean.SoundWaveCardRecordListBean;
import client.android.yixiaotong.controller.bean.SoundWaveDrinkWaterCleanData;
import client.android.yixiaotong.controller.bean.SoundWaveDrinkWaterRecordListBean;
import client.android.yixiaotong.controller.bean.SoundWaveOrderBean;
import client.android.yixiaotong.controller.bean.SoundWaveOrderRecordBean;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.SystemErrorBean;
import client.android.yixiaotong.controller.bean.UnionPayBean;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.bean.WeiXinPayBean;
import client.android.yixiaotong.controller.bean.adv.AdvControlListBean;
import client.android.yixiaotong.controller.bean.bath.BathAuthBean;
import client.android.yixiaotong.controller.bean.bath.BathAuthNewBean;
import client.android.yixiaotong.controller.bean.bath.BathDevicesInfoListBean;
import client.android.yixiaotong.controller.bean.bath.BathUploadOrderBean;
import client.android.yixiaotong.controller.bean.bath.BathUploadOrderNewBean;
import client.android.yixiaotong.controller.bean.bindcard.BindCardBean;
import client.android.yixiaotong.controller.bean.bindcard.IsBindCardBean;
import client.android.yixiaotong.controller.bean.bindcard.IsHasBindCardFunctionBean;
import client.android.yixiaotong.controller.bean.bindcard.PasswordStateBean;
import client.android.yixiaotong.controller.bean.doorlock.DLHACBean;
import client.android.yixiaotong.controller.bean.doorlock.DLKeyBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockAddKeyBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockAllUsersInfoBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockChangeRoomRecordsBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockInfoBean;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockKeyInfos;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockNotSyncKeys;
import client.android.yixiaotong.controller.bean.doorlock.DoorLockRecordsBean;
import client.android.yixiaotong.controller.bean.doorlock.SelectUserAuthenticationBean;
import client.android.yixiaotong.controller.bean.doorlock.SubmitUserInformationBean;
import client.android.yixiaotong.controller.bean.entranceguard.EGBindRoomInfo;
import client.android.yixiaotong.controller.bean.entranceguard.EGIsBindBean;
import client.android.yixiaotong.controller.bean.entranceguard.EGRoomDetailBean;
import client.android.yixiaotong.controller.bean.getserveraddress.LoginBefore;
import client.android.yixiaotong.controller.bean.getserveraddress.RegisterBefore;
import client.android.yixiaotong.controller.bean.gonggaolan.Detail;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAllAnnounceListBean;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAnnouncementBean;
import client.android.yixiaotong.controller.bean.hamam.BathHousePasswordBean;
import client.android.yixiaotong.controller.bean.hamam.HamamBindBean;
import client.android.yixiaotong.controller.bean.hamam.HamamBindPreBean;
import client.android.yixiaotong.controller.bean.hamam.HamamDetailListBean;
import client.android.yixiaotong.controller.bean.hamam.HamamGetRoomInfoBean;
import client.android.yixiaotong.controller.bean.hamam.HamamInitDeviceBean;
import client.android.yixiaotong.controller.bean.hamam.HamamIsBindBean;
import client.android.yixiaotong.controller.bean.hamam.HamamRecordListBean;
import client.android.yixiaotong.controller.bean.hamam.HamamVerifyAuthPasswordSecurity;
import client.android.yixiaotong.controller.bean.hamam.HamamYuYueBean;
import client.android.yixiaotong.controller.bean.hamam.UnRegisterBathHouseBean;
import client.android.yixiaotong.controller.bean.init.NBMachineInfo;
import client.android.yixiaotong.controller.bean.init.SetNBDrinkWaterBean;
import client.android.yixiaotong.controller.bean.pay.ABCPayBean;
import client.android.yixiaotong.controller.bean.recharge.RechargeDetailListBean;
import client.android.yixiaotong.controller.bean.recharge.RechargeInfoBean;
import client.android.yixiaotong.controller.bean.refund.RefundListBean;
import client.android.yixiaotong.controller.bean.report.RepairUploadReportPicsBean;
import client.android.yixiaotong.controller.bean.report.ReportDetailBean;
import client.android.yixiaotong.controller.bean.report.ReportListBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardAliBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardAuthorizeBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardPriceBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardUnionBean;
import client.android.yixiaotong.controller.bean.sellcard.SellCardWeiXinPayBean;
import client.android.yixiaotong.controller.bean.set.SetBean;
import client.android.yixiaotong.controller.bean.wash.WashAuthorizeBean;
import client.android.yixiaotong.controller.bean.wash.WashGetMachineid;
import client.android.yixiaotong.controller.bean.wash.WashHistoryOrderBean;
import client.android.yixiaotong.controller.bean.wash.WashOrderBean;
import client.android.yixiaotong.controller.bean.wash.WashParametersBean;
import client.android.yixiaotong.controller.core.BaseControllers;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.db.LocalSqliteHelper;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.FileUploadBean;
import client.android.yixiaotong.event.BalanceSyncEvent;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.exception.DBException;
import client.android.yixiaotong.exception.HttpException;
import client.android.yixiaotong.util.EventBusUtil;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.android.ClientUtils;
import client.android.yixiaotong.v3.util.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class BusinessControllers extends BaseControllers {
    private BusinessControllers() {
    }

    private static class SingletonHolder {
        public static final BusinessControllers INSTANCE = new BusinessControllers();

        private SingletonHolder() {
        }
    }

    public static BusinessControllers getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void welcome(final Account account, Listener<HelloBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.1
            @Override // java.lang.Runnable
            public void run() {
                HelloBean helloBean = new HelloBean();
                if (ClientUtils.isFirstOpenApp(BaseApplication.app)) {
                    helloBean.needIntroduct = true;
                } else {
                    helloBean.needIntroduct = false;
                }
                LogUtil.e("BusinessControllers", (account == null) + "  " + account.isVistor() + "  " + (!ClientUtils.isLoginSuccess(BaseApplication.app)));
                if (account == null || !ClientUtils.isLoginSuccess(BaseApplication.app)) {
                    helloBean.needLogin = true;
                } else {
                    helloBean.needLogin = false;
                }
                ClientUtils.setFirstOpenApp(BaseApplication.app, true);
                BusinessControllers.this.callComplete(controller, helloBean, new Object[0]);
            }
        });
    }

    public void loginBeforeGetServerAddress(final Account account, final String str, Listener<LoginBefore> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BusinessControllers.this.callComplete(controller, account.getHttpBusinessStorePre().loginBeforeGetServerAddress(str), new Object[0]);
                } catch (HttpException e) {
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void encryptedLoginToV3(final Account account, final String str, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().EncryptedLoginToV3(str), new Object[0]);
                } catch (HttpException e) {
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void registerBeforeGetServerAddress(final Account account, final String str, Listener<RegisterBefore> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BusinessControllers.this.callComplete(controller, account.getHttpBusinessStorePre().registerBeforeGetServerAddress(str), new Object[0]);
                } catch (HttpException e) {
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void login(final Account account, final String str, final String str2, Listener<UserInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().login(str, str2, false), new Object[0]);
                } catch (HttpException e) {
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void register(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final int i, final String str6, final long j, final String str7, final String str8, final String str9, final String str10, final String str11, Listener<UserInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UserInfoBean userInfoBeanRegister = account.getHttpBusinessStore().register(str, str2, str3, str4, str5, i, str6, j, str7, str8, str9, str10, str11);
                    account.getHttpBusinessStore().login(str, str2, false);
                    BusinessControllers.this.callComplete(controller, userInfoBeanRegister, new Object[0]);
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getMealQrCode(final Account account, final long j, Listener<GetMealQrcodeBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().getMealQrCode(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), j), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void getSchoolList(final Account account, Listener<List<AreasBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().getSchoolList(), new Object[0]);
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void initDeviceInfo(final Account account, final String str, final int i, final long j, final long j2, final String str2, final String str3, final String str4, Listener<GetDeviceQrCodeBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().initDeviceInfo(account.getAccountManagetStore().getUserInfo().Token, str, i, j, j2, str2, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getDeviceInfo(final Account account, final long j, Listener<DeviceInfoBean> listener) {
        final Controller controller = new Controller(account, listener, Long.valueOf(j));
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().getDeviceInfo(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), j, null), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void getDeviceInfo(final Account account, final String str, Listener<DeviceInfoBean> listener) {
        final Controller controller = new Controller(account, listener, str);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().getDeviceInfo(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), 0L, str), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void getSmpDeviceInfo(final Account account, final String str, Listener<DeviceInfoBean> listener) {
        final Controller controller = new Controller(account, listener, str);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().getSmpDeviceInfo(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), str), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void updateConsumptionTimes(final Account account, final long j, final int i, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().updateConsumptionTimes(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), j, i), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void getStudentInfo(final Account account, Listener<UserInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().getStudentInfo(account.getAccountManagetStore().getUserInfo().Token, account.getUid()), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void updateStudentInfo(final Account account, final String str, final String str2, final int i, final String str3, final long j, final String str4, final String str5, final String str6, Listener<NullBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String str7 = str3;
                    if (str7 == null || str7 == "") {
                        str7 = account.getAccountManagetStore().getUserInfo().Icon;
                    }
                    String str8 = str7;
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().updateStudentInfo(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), str, str2, i, str8, j, str4, str5, str6), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void resetLoginPassword(final Account account, final String str, final String str2, final String str3, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().resetLoginPassword(str, str2, str3), new Object[0]);
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void modifyLoginPassword(final Account account, final String str, final String str2, final String str3, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().modifyLoginPassword(account.getAccountManagetStore().getUserInfo().Token, account.getUserName(), str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void modifyPayPassword(final Account account, final String str, final String str2, final String str3, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().modifyPayPassword(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void syncWallets(final Account account, Listener<List<WalletModel>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        List<WalletModel> listSycnWallets = account.getHttpBusinessStore().sycnWallets(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId);
                        EventBusUtil.getInstance().getCommonEventBus().post(new BalanceSyncEvent());
                        BusinessControllers.this.callComplete(controller, listSycnWallets, new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void getRelationWallet(final Account account, final int i, Listener<WalletModel> listener) {
        final Controller controller = new Controller(account, listener, Integer.valueOf(i));
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.20
            @Override // java.lang.Runnable
            public void run() {
                WalletModel next;
                try {
                    Iterator<WalletModel> it = account.getLocalBusinessStore().getWallets(new LocalSqliteHelper(account.getUuid())).iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (next.typeId != i);
                    if (next != null) {
                        BusinessControllers.this.callComplete(controller, next, new Object[0]);
                    } else {
                        BusinessControllers.this.callFail(controller, new ClientException("此设备无对应的应用"));
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getWalletModels(final Account account, Listener<List<WalletModel>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        runToAsyncCommandQueue(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.21
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BusinessControllers.this.callComplete(controller, account.getLocalBusinessStore().getWallets(new LocalSqliteHelper(account.getUuid())), new Object[0]);
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException("获取数据错误"));
                }
            }
        });
    }

    public void getDrinkWaterUnFinishOrderRecordList(final Account account, final String str, final String str2, final int i, final int i2, Listener<SoundWaveDrinkWaterRecordListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.22
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        SoundWaveDrinkWaterRecordListBean cardDrinkWaterHasUnFinishOrderRecordList = account.getHttpBusinessStoreJava().getCardDrinkWaterHasUnFinishOrderRecordList(account.getAccountManagetStore().getUserInfo().Token, str, str2, account.getUid(), i, i2);
                        cardDrinkWaterHasUnFinishOrderRecordList.getSortList();
                        BusinessControllers.this.callComplete(controller, cardDrinkWaterHasUnFinishOrderRecordList, new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getRecordList(final Account account, final int i, final String str, final int i2, final int i3, Listener<RecordListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.23
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().getConsumeDetailList(account.getAccountManagetStore().getUserInfo().Token, i, str, account.getUid(), i2, i3), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void sendSMSCaptcha(final Account account, final String str, final int i, final Long l, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.24
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().sendSMSCaptcha(str, i, l), new Object[0]);
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void verifySMSCaptcha(final Account account, final String str, final String str2, final int i, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.25
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().verifySMSCaptcha(str, str2, i), new Object[0]);
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void uploadImage(final Account account, final String str, final int i, final String str2, Listener<FileUploadBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.26
            @Override // java.lang.Runnable
            public void run() {
                FileUploadBean fileUploadBeanUploadImage;
                try {
                    if (account.isVistor()) {
                        fileUploadBeanUploadImage = account.getHttpBusinessStore().uploadImage(null, str, i, str2);
                    } else {
                        fileUploadBeanUploadImage = account.getHttpBusinessStore().uploadImage(Long.valueOf(account.getUid()), str, i, str2);
                    }
                    BusinessControllers.this.callComplete(controller, fileUploadBeanUploadImage, new Object[0]);
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void weiXinPay(final Account account, final int i, final long j, Listener<WeiXinPayBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.27
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().WeiXinPay(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), i, j), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void aliPay(final Account account, final int i, final long j, Listener<AliPayBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.28
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().AliPay(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), i, j), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void unionPay(final Account account, final int i, final long j, Listener<UnionPayBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.29
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().UnionPay(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), i, j), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void ABCPay(final Account account, final int i, final int i2, Listener<ABCPayBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.30
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().ABCPay(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, account.getAccountManagetStore().getUserInfo().LoginAccount, account.getUid(), i, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void refund(final Account account, final String str, final int i, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.31
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().refund(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), str, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void refund1(final Account account, final String str, final int i, final int i2, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.32
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().refund1(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), str, i, i2, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void refund2(final Account account, final String str, final int i, final int i2, final String str2, final String str3, final String str4, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.33
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().refund2(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), str, i, i2, str2, account.getAccountManagetStore().getUserInfo().AreaId, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void uploadOrder(final Account account, final String str, final int i, final long j, final short s, final String str2, Listener<Boolean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.34
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ArrayList arrayList = new ArrayList();
                    OrderBean orderBean = new OrderBean();
                    orderBean.UploadId = account.getUid();
                    orderBean.ApplicationType = i;
                    orderBean.ConsumeTime = str2;
                    orderBean.StudentId = j;
                    orderBean.ConsumeAmount = s;
                    orderBean.SerialNumber = str;
                    arrayList.add(orderBean);
                    String ifNull = GsonUtils.getInstance().parseIfNull(arrayList);
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        account.getHttpBusinessStore().uploadBillConsume(account.getAccountManagetStore().getUserInfo().Token, ifNull);
                        BusinessControllers.this.callComplete(controller, true, new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void uploadOrder(String str, final Account account, final String str2, final int i, final long j, final short s, final String str3, final int i2, final long j2, final int i3, final int i4, final int i5, final String str4, final String str5, final String str6, Listener<OpenDataBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.35
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ArrayList arrayList = new ArrayList();
                    AccreditBean accreditBean = new AccreditBean();
                    accreditBean.StudentId = account.getUid();
                    accreditBean.ApplicationType = i;
                    accreditBean.ConsumeAmount = s;
                    accreditBean.ConsumeTime = str3;
                    accreditBean.PosStudentId = j;
                    accreditBean.SerialNumber = str2;
                    accreditBean.Posflag = i3;
                    accreditBean.Netflag = str5;
                    accreditBean.Money = i4;
                    if (accreditBean.StudentId == accreditBean.PosStudentId) {
                        accreditBean.Money -= accreditBean.ConsumeAmount;
                    }
                    accreditBean.SecretKey = str4;
                    accreditBean.Random = str6;
                    accreditBean.InvestorId = j2;
                    accreditBean.SchoolId = i5;
                    accreditBean.OfflineTimes = i2;
                    arrayList.add(accreditBean);
                    String ifNull = GsonUtils.getInstance().parseIfNull(arrayList);
                    Log.e("test", ifNull);
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().uploadBillConsume2(account.getAccountManagetStore().getUserInfo().Token, ifNull), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void initDeviceInfoNew(final Account account, final String str, final int i, final long j, final long j2, final String str2, final String str3, final String str4, final String str5, final String str6, Listener<GetDeviceQrCodeBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.36
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().initDeviceInfoNew(account.getAccountManagetStore().getUserInfo().Token, str, i, j, j2, str2, str3, str4, str5, str6), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getNewDeviceInfo(final Account account, final String str, final long j, Listener<DeviceInfoBean> listener) {
        final Controller controller = new Controller(account, listener, str);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.37
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().getNewDeviceInfo(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), str, j, account.getAccountManagetStore().getUserInfo().AreaId, account.getAccountManagetStore().getUserInfo().UserType), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void ammeterIsBindRoomNew(final Account account, final String str, final String str2, Listener<AmmeterBindingRoom> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.38
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().ammeterIsBindRoom(account.getAccountManagetStore().getUserInfo().Token, str, account.getUid() + "", str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getRepairProcessList(final Account account, final long j, Listener<RepairProcessListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.39
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().GetRepairProcessList(account.getAccountManagetStore().getUserInfo().Token, j), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void uploadEqStatus(final Account account, final String str, final String str2, final long j, Listener<Boolean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.40
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        account.getHttpBusinessStore().UploadEqStatus(account.getAccountManagetStore().getUserInfo().Token, str, str2, j);
                        BusinessControllers.this.callComplete(controller, true, new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void uploadRevertInfo(final Account account, final long j, final String str, Listener<Boolean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.41
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        account.getHttpBusinessStore().UploadReportProcess(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), j, str);
                        BusinessControllers.this.callComplete(controller, true, new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void soundWave1(final Account account, final String str, final int i, final String str2, final String str3, final long j, final int i2, final int i3, final int i4, final String str4, final int i5, Listener<SoundWaveBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.42
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().SoundWave1(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId + "", str, i, str2, str3, j, i2, i3, i4, str4, i5), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void SoundWaveCardUpdateInfo(final Account account, final int i, final String str, final String str2, final int i2, final String str3, final boolean z, Listener<WashHistoryOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.43
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().SoundWaveCardUpdateInfo(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + "", i, str, str2, i2, str3, z), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void soundWaveOrder(final Account account, final int i, final String str, final String str2, final long j, final String str3, final int i2, final int i3, final String str4, Listener<SoundWaveOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.44
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().SoundWaveOrder(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId + "", account.getAccountManagetStore().getUserInfo().Mobile, i, str, str2, j, str3, i2, i3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void soundWaveWaterOrder(final Account account, final int i, final String str, final int i2, final String str2, final long j, final int i3, final int i4, final String str3, Listener<SoundWaveOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.45
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().SoundWaveWaterOrder(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, account.getAccountManagetStore().getUserInfo().Mobile, i, str, i2, str2, j, i3, i4, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void soundWaveHairDryerOrder(final Account account, final int i, final String str, final int i2, final String str2, final long j, final int i3, final int i4, final String str3, final String str4, Listener<HairDryerOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.46
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().SoundWaveHairDryerOrder(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, account.getAccountManagetStore().getUserInfo().Mobile, i, str, i2, str2, j, i3, i4, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void soundWaveHairDryer(final Account account, final String str, final int i, final String str2, final String str3, final int i2, final int i3, final int i4, final long j, final int i5, final String str4, Listener<HairDryerBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.47
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().SoundWaveHairDryer(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, str, i, str2, str3, i2, i3, i4, j, i5, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void soundWaveWater(final Account account, final String str, final int i, final String str2, final String str3, final int i2, final int i3, final int i4, final long j, final int i5, final String str4, Listener<SoundWaveBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.48
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().SoundWaveWater(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, str, i, str2, str3, i2, i3, i4, j, i5, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void soundWaveWaterOrderRecord(final Account account, final int i, final int i2, final String str, final String str2, final int i3, final String str3, Listener<SoundWaveOrderRecordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.49
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().SoundWaveWaterOrderRecord(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, i, i2, account.getUid(), str, str2, i3, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void soundWaveWaterCleanData(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, Listener<SoundWaveDrinkWaterCleanData> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.50
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().SoundWaveWaterCleanData(account.getAccountManagetStore().getUserInfo().Token, str, str2, str3, account.getUid() + "", str4, str5, str6, str7), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void soundWaveWaterSettingData(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, Listener<SoundWaveDrinkWaterCleanData> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.51
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().SoundWaveWaterSettingData(account.getAccountManagetStore().getUserInfo().Token, str, str2, str3, account.getUid() + "", str4, str5, str6, str7, str8, str9, str10), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getCardRecordList(final Account account, final int i, final int i2, final String str, final String str2, Listener<SoundWaveCardRecordListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.52
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getCardRecordList(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), i, i2, str, str2), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDrinkWaterRecordList2(final Account account, final int i, final int i2, final int i3, final String str, final String str2, final String str3, Listener<SoundWaveDrinkWaterRecordListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.53
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDrinkWaterRecordList2(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), i, i2, i3, str, str2, str3), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void ammeterGetPrice(final Account account, final String str, Listener<AmmeterPricesBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.54
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterGetPrice(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + "", str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void ammeterInit(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, final String str10, final int i, final String str11, Listener<AmmeterInitBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.55
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterInit(account.getAccountManagetStore().getUserInfo().Token, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i, str11), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterState(final Account account, final String str, final String str2, Listener<AmmeterStateBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.56
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterState(account.getAccountManagetStore().getUserInfo().Token, str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterInfo(final Account account, final String str, final String str2, final String str3, Listener<AmmeterStateBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.57
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterInfo(account.getAccountManagetStore().getUserInfo().Token, str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterCollectionData(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, Listener<AmmeterStateBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.58
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterCollectionData(account.getAccountManagetStore().getUserInfo().Token, str, str2, str3, str4, str5, str6), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterInitSuccess(final Account account, final String str, final String str2, final String str3, final long j, final int i, Listener<AmmeterStateBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.59
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterInitSuccess(account.getAccountManagetStore().getUserInfo().Token, str, str2, str3, j, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterInitSuccess1(final Account account, final String str, final String str2, final String str3, final long j, final int i, Listener<AmmeterStateBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.60
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterInitSuccess1(account.getAccountManagetStore().getUserInfo().Token, str, str2, str3, j, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterSales(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, Listener<AmmeterDestroyBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.61
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterSales(account.getAccountManagetStore().getUserInfo().Token, str, str2, str3, str4, str5, str6, str7, str8, str9), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterSalesSuccess(final Account account, final String str, final String str2, final String str3, final String str4, Listener<AmmeterDestroyBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.62
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterSalesSuccess(account.getAccountManagetStore().getUserInfo().Token, str, str2, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterGetAreaInfo(final Account account, final String str, Listener<List<AmmeterAreaInfo>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.63
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterGetAreaInfo(account.getAccountManagetStore().getUserInfo().Token, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterGetAreaForRoom(final Account account, final String str, Listener<List<AmmeterAreaInfo>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.64
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterGetAreaForRoom(account.getAccountManagetStore().getUserInfo().Token, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterReadInfo(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, Listener<AmmeterSettingBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.65
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterReadInfo(account.getAccountManagetStore().getUserInfo().Token, str, str2, str3, str4, str5, str6), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterWriteInfo(final Account account, final String str, final String str2, final String str3, Listener<AmmeterWriteSettingBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.66
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterWriteInfo(account.getAccountManagetStore().getUserInfo().Token, str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterWriteInfoSuccess(final Account account, final String str, final String str2, Listener<AmmeterWriteSettingBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.67
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterWriteInfoSuccess(account.getAccountManagetStore().getUserInfo().Token, str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterIsBindRoom(final Account account, final String str, final String str2, Listener<AmmeterBindRoomBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.68
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterIsBindRoom(account.getAccountManagetStore().getUserInfo().Token, str, account.getUid() + "", str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterBindingRoom(final Account account, final long j, Listener<AmmeterBindingRoom> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.69
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().ammeterBindingRoom(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), j), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterBindingRoom(final Account account, final long j, final int i, Listener<AmmeterBindingRoom> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.70
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UserInfoBean userInfo = account.getAccountManagetStore().getUserInfo();
                    if (userInfo == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().ammeterBindingRoom(userInfo.Token, account.getUid(), j, i, (int) userInfo.AreaId), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterUnBindingRoom(final Account account, Listener<AmmeterBindingRoom> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.71
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().ammeterUnBindingRoom(account.getAccountManagetStore().getUserInfo().Token, account.getUid()), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterUnBindingRoom(final Account account, final int i, Listener<AmmeterBindingRoom> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.72
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UserInfoBean userInfo = account.getAccountManagetStore().getUserInfo();
                    if (userInfo == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().ammeterUnBindingRoom(userInfo.Token, account.getUid(), i, (int) userInfo.AreaId), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterGetRoomDetailNew(final Account account, Listener<AmmeterRoomDetail> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.73
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().ammeterGetRoomDetailNew(account.getAccountManagetStore().getUserInfo().Token, account.getUid()), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterGetRoomDetail(final Account account, Listener<AmmeterRoomDetail> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.74
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().ammeterGetRoomDetail(account.getAccountManagetStore().getUserInfo().Token, account.getUid()), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterWeiXinOrder(final Account account, final long j, final String str, final int i, final String str2, final String str3, final int i2, Listener<AmmeterWeiXinPayBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.75
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().ammeterWeiXinOrder(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), j, str, i, str2, str3, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterSelectOrder(final Account account, final String str, Listener<AmmeterOrderStateBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.76
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().ammeterSelectOrder(account.getAccountManagetStore().getUserInfo().Token, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterUnionAliOrder(final Account account, final long j, final String str, final int i, final String str2, final String str3, final int i2, Listener<UnionPayBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.77
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().ammeterUnionAliOrder(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), j, str, i, str2, str3, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterAliOrder(final Account account, final long j, final String str, final int i, final String str2, final String str3, final int i2, Listener<AmmeterAliPayBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.78
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().ammeterAliOrder(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), j, str, i, str2, str3, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterSubsidy(final Account account, final String str, final String str2, final String str3, final String str4, final int i, final String str5, final int i2, Listener<AmmeterSubsidyBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.79
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterSubsidy(account.getAccountManagetStore().getUserInfo().Token, str, account.getUid(), str2, str3, str4, i, str5, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getAmmeterRecordList(final Account account, final int i, final int i2, Listener<AmmeterRecordListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.80
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getAmmeterRecordList(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), i, i2), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getAmmeterBuTieRecordList(final Account account, final String str, final int i, final int i2, Listener<AmmeterRecordListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.81
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getAmmeterButieRecordList(account.getAccountManagetStore().getUserInfo().Token, str, i, i2), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void ammeterAuthorize(final Account account, final String str, final int i, final String str2, final int i2, final int i3, final String str3, final int i4, final String str4, final String str5, final String str6, Listener<AeemterAuthorizeBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.82
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterAuthorize(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), str, i, str2, i2, i3, str3, i4, str4, str5, str6), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterEnd(final Account account, final String str, final String str2, final String str3, final String str4, Listener<AmmeterEndBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.83
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterEnd(account.getAccountManagetStore().getUserInfo().Token, str, str2, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void ammeterDetails(final Account account, final String str, final String str2, final String str3, final String str4, Listener<AmmeterEndBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.84
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().ammeterDetails(account.getAccountManagetStore().getUserInfo().Token, str, str2, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getRefundProgress(final Account account, final int i, Listener<RefundBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.85
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().getRefundProgress(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), i), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getIsManager(final Account account, Listener<ManagerBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.86
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().getIsManager(account.getAccountManagetStore().getUserInfo().Token, account.getUid()), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void GetRechargeMessageList(final Account account, final int i, final int i2, final String str, final int i3, Listener<MessageRecordListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.87
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().GetRechargeMessageList(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), i, i2, str, i3, account.getAccountManagetStore().getUserInfo().AreaId), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void WashParameters(final Account account, final String str, final int i, final String str2, Listener<WashParametersBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.88
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().GetAllWashParameters(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, str, i, str2), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void WashParameters2(final Account account, final String str, final int i, final String str2, Listener<WashParametersBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.89
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().GetAllWashParameters2(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, str, i, str2), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void WashInit(final Account account, final String str, final String str2, final String str3, final String str4, final int i, final String str5, final String str6, final String str7, Listener<WashParametersBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.90
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().WashInit(account.getAccountManagetStore().getUserInfo().Token, str, account.getAccountManagetStore().getUserInfo().AreaId, str2, str3, str4, account.getAccountManagetStore().getUserInfo().StudentName, i, str5, str6, str7), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void WashInitFinish(final Account account, final String str, final String str2, Listener<WashParametersBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.91
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().WashInitFinish(account.getAccountManagetStore().getUserInfo().Token, str, str2), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void WashGetMachineid(final Account account, final String str, final String str2, final int i, final String str3, Listener<WashGetMachineid> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.92
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().WashGetMachineid(account.getAccountManagetStore().getUserInfo().Token, str, account.getAccountManagetStore().getUserInfo().AreaId, str2, i, str3), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void WashUpdateInit(final Account account, final String str, final String str2, final int i, final String str3, final String str4, final String str5, Listener<WashParametersBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.93
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().WashUpdateInit(account.getAccountManagetStore().getUserInfo().Token, str, account.getAccountManagetStore().getUserInfo().AreaId, str2, i, str3, str4, str5), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void WashOrder(final Account account, final int i, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final long j, final String str7, final String str8, final String str9, final String str10, Listener<WashOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.94
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().WashOrder(account.getAccountManagetStore().getUserInfo().Token, account.getUid() + "", i, account.getAccountManagetStore().getUserInfo().AreaId, str, str2, str3, str4, str5, str6, j + "", str7, str8, str9, str10), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void WashOrderV3(final Account account, final int i, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final long j, final String str7, final String str8, final String str9, final String str10, Listener<WashOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.95
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().WashOrderV3(account.getAccountManagetStore().getUserInfo().Token, account.getUid() + "", i, account.getAccountManagetStore().getUserInfo().AreaId, str, str2, str3, str4, str5, str6, j + "", str7, str8, str9, str10), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void WashAuthorize(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, Listener<WashAuthorizeBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.96
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().WashAuthorize(account.getAccountManagetStore().getUserInfo().Token, account.getUid() + "", account.getAccountManagetStore().getUserInfo().AreaId + "", str, str2, str3, str4, str5, str6, str7, str8, str9), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void getWashRecordList(final Account account, final int i, final int i2, final String str, final String str2, final String str3, Listener<SoundWaveCardRecordListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.97
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getWashRecordList(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), i, i2, str, str2, str3), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void SoundWaveWashUpdateInfo(final Account account, final int i, final String str, final String str2, final int i2, final String str3, final boolean z, Listener<WashHistoryOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.98
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().SoundWaveWashUpdateInfo(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + "", i, account.getUid() + "", str, str2, i2, str3, z), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void WashUpdateOrder(final Account account, final String str, final String str2, final String str3, Listener<WashOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.99
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().WashUpdateOrder(account.getAccountManagetStore().getUserInfo().Token, str, str2, str3), new Object[0]);
                    }
                } catch (DBException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (HttpException e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, e2);
                }
            }
        });
    }

    public void getAnnouncement(final Account account, final String str, Listener<List<GetAnnouncementBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.100
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account2.getHttpBusinessStoreTestGongGao().getAnnouncement(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getAnnouncementDetailNew(final Account account, final long j, Listener<Detail> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.101
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreTestGongGao().getAnnouncementDetailNew(account.getAccountManagetStore().getUserInfo().Token, j), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getAllAnnouncement(final Account account, Listener<GetAllAnnounceListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.102
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreTestGongGao().getAllAnnouncement(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void entranceGuardGetAreaInfo(final Account account, final String str, Listener<List<AmmeterAreaInfo>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.103
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().entranceGuardGetAreaInfo(account.getAccountManagetStore().getUserInfo().Token, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void entranceGuardGetAreaInfoAll(final Account account, final String str, Listener<EGRoomDetailBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.104
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().entranceGuardGetAreaInfoAll(account.getAccountManagetStore().getUserInfo().Token, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void entranceGuardUnBindingRoom(final Account account, final String str, final int i, final String str2, Listener<EGBindRoomInfo> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.105
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().entranceGuardUnBindingRoom(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid(), str, i, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void entranceGuardIsBind(final Account account, final int i, final String str, Listener<EGIsBindBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.106
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getEntranceGuardIsBind(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid(), i, str), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void chongzhiShouQuanPassword(final Account account, final String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.107
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().chongZhiShouQuanPassword(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId + "", str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getUpdateMacForSalesCard(final Account account, final int i, final String str, final String str2, final int i2, final String str3, Listener<WashHistoryOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.108
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getUpdateMacForSalesCard(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + "", account.getUid(), i, str, str2, i2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getCardSalesPrice(final Account account, final int i, final String str, Listener<SellCardPriceBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.109
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getCardSalesPrice(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + "", i, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getCardSalesAuth(final Account account, final int i, final String str, final int i2, final int i3, final String str2, final int i4, final String str3, final String str4, final int i5, Listener<SellCardAuthorizeBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.110
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().cardSalesAuth(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId + "", i, str, i2, i3, str2, i4, str3, str4, i5), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void AliCardMachinePay(final Account account, final int i, final String str, final int i2, Listener<SellCardAliBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.111
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().AliCardMachinePay(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, account.getAccountManagetStore().getUserInfo().Mobile, i, str, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void WxCardMachinePay(final Account account, final int i, final String str, final int i2, Listener<SellCardWeiXinPayBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.112
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().WxCardMachinePay(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, account.getAccountManagetStore().getUserInfo().Mobile, i, str, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void UnionCardMachinePay(final Account account, final int i, final String str, final int i2, Listener<SellCardUnionBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.113
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().UnionCardMachinePay(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, account.getAccountManagetStore().getUserInfo().Mobile, i, str, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void GerOrdersInfo(final Account account, final String str, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.114
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().GerOrdersInfo(account.getAccountManagetStore().getUserInfo().Token, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getCardSalesList(final Account account, final int i, final int i2, final String str, final String str2, Listener<SoundWaveCardRecordListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.115
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getCardSalesList(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), i, i2, str, str2), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void hamamIsBind(final Account account, final String str, Listener<HamamIsBindBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.116
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getHamamIsBind(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid(), str), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void hamamUnBind(final Account account, final String str, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.117
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().hamamUnBindingRoom(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid(), str), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void hamamBindingRoom(final Account account, final String str, Listener<HamamBindBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.118
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().hamamBindingRoom(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid(), str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void bindBathHouseFront(final Account account, final String str, final String str2, Listener<HamamBindPreBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.119
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().bindBathHouseFront(account.getAccountManagetStore().getUserInfo().Token, str, str2, account.getAccountManagetStore().getUserInfo().AreaId), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void initHamam(final Account account, final String str, final int i, final String str2, final String str3, final long j, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, Listener<HamamInitDeviceBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.120
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().initHamam(account.getAccountManagetStore().getUserInfo().Token, str, i, account.getUid(), str2, str3, j, str4, str5, str6, str7, str8, str9), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void uninitHamam(final Account account, final String str, final int i, final String str2, final long j, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.121
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().uninitHamam(account.getAccountManagetStore().getUserInfo().Token, str, i, account.getUid(), str2, j), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getHamamRecordList(final Account account, final int i, Listener<HamamRecordListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.122
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getHamamConsumeDetailList(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid(), i), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getHamamDetail(final Account account, final String str, final int i, final String str2, Listener<List<HamamDetailListBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.123
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getHamamDetail(account.getAccountManagetStore().getUserInfo().Token, str, i, str2), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getHamamYuYue(final Account account, final String str, final String str2, final String str3, final String str4, Listener<HamamYuYueBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.124
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getHamamYuYue(account.getAccountManagetStore().getUserInfo().Token, account.getUid() + "", str, account.getAccountManagetStore().getUserInfo().AreaId + "", str2, str3, str4), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getHamamIsYuYue(final Account account, final String str, final String str2, Listener<HamamYuYueBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.125
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getHamamIsYuYue(account.getAccountManagetStore().getUserInfo().Token, account.getUid() + "", str, str2), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void postBathAuth(final Account account, final int i, final String str, final String str2, final int i2, final String str3, Listener<BathAuthBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.126
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().postBathAuth(account.getAccountManagetStore().getUserInfo().Token, account.getUid() + "", account.getAccountManagetStore().getUserInfo().AreaId + "", i, str, str2, i2, str3), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void postBathUploadOrder(final Account account, final int i, final String str, final String str2, final int i2, final String str3, Listener<BathUploadOrderBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.127
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().postBathUploadOrder(account.getAccountManagetStore().getUserInfo().Token, account.getUid() + "", account.getAccountManagetStore().getUserInfo().AreaId + "", i, str, str2, i2, str3), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void GetEquipmentSerialNumbers(final Account account, final String str, final int i, Listener<BathDevicesInfoListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.128
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().GetEquipmentSerialNumbers(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, str, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void GetOneStudentApplication(final Account account, final int i, Listener<List<WalletModel>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.129
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().GetOneStudentApplication(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void GetEquipmentInfo(final Account account, final String str, final int i, Listener<HamamGetRoomInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.130
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().GetEquipmentInfo(account.getAccountManagetStore().getUserInfo().Token, str, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void VerifyAuthPasswordSecurity(final Account account, final int i, Listener<HamamVerifyAuthPasswordSecurity> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.131
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().VerifyAuthPasswordSecurity(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void setShouQuanPassword(final Account account, final String str, Listener<HamamVerifyAuthPasswordSecurity> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.132
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().setShouQuanPassword(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void uploadReportPics(final Account account, final String str, final String str2, final int i, Listener<RepairUploadReportPicsBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.133
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().uploadReportPics(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, str2, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void newAddReports(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final int i, final String str6, final String str7, final String str8, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.134
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account2.getHttpBusinessStore().newAddReports(str, str2, str3, str4, str5, i, str6, str7, str8), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getReportList(final Account account, final String str, final String str2, final String str3, final int i, final int i2, final String str4, final int i3, final int i4, Listener<ReportListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.135
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account2.getHttpBusinessStore().getReportList(str, str2, str3, i, i2, str4, i3, i4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getReportDetail(final Account account, final String str, final String str2, final String str3, final int i, final String str4, final int i2, Listener<ReportDetailBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.136
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account2.getHttpBusinessStore().getReportDetail(str, str2, str3, i, str4, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postConfirmFaultInfo(final Account account, final int i, final String str, final int i2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.137
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().postConfirmFaultInfo(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", i, str, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postSubmitReportInfo(final Account account, final int i, final String str, final int i2, final int i3, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.138
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().postSubmitReportInfo(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", i, str, i2, i3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getSystemErrorMsg(final Account account, Listener<SystemErrorBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.139
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreSystemError().getSystemError(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getNBMachineInfo(final Account account, final String str, final String str2, final int i, final long j, Listener<NBMachineInfo> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.140
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().getNBMachineInfo(account.getAccountManagetStore().getUserInfo().Token, str, str2, i, j, account.getUid(), account.getAccountManagetStore().getUserInfo().StudentName, account.getAccountManagetStore().getUserInfo().LoginAccount), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postInitNBMachine(final Account account, final String str, final String str2, final int i, final long j, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8, final String str9, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.141
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().postInitNBMachine(account.getAccountManagetStore().getUserInfo().Token, str, str2, i, j, account.getUid(), account.getAccountManagetStore().getUserInfo().StudentName, account.getAccountManagetStore().getUserInfo().LoginAccount, str3, str4, str5, str6, str7, str8, str9), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postCancelNBMachine(final Account account, final String str, final String str2, final int i, final long j, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.142
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().postCancelNBMachine(account.getAccountManagetStore().getUserInfo().Token, str, str2, i, j, account.getUid(), account.getAccountManagetStore().getUserInfo().StudentName, account.getAccountManagetStore().getUserInfo().LoginAccount), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postBatheAuthAnalysis(final Account account, final int i, final int i2, final String str, final int i3, final int i4, final String str2, final String str3, final String str4, final int i5, final String str5, final String str6, Listener<BathUploadOrderNewBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.143
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().postBatheAuthAnalysis(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), i, account.getAccountManagetStore().getUserInfo().AreaId, i2, str, i3, i4, str2, str3, str4, i5, str5, str6), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postBatheAuth(final Account account, final String str, final int i, final int i2, final String str2, final int i3, final int i4, final String str3, final String str4, final String str5, final int i5, final String str6, final String str7, Listener<BathAuthNewBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.144
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().postBatheAuth(account.getAccountManagetStore().getUserInfo().Token, str, i, account.getAccountManagetStore().getUserInfo().AreaId, i2, str2, i3, i4, str3, str4, str5, i5, str6, str7), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postCommIotAuthAnalysis(final Account account, final int i, final int i2, final String str, final int i3, final int i4, final String str2, final String str3, final String str4, final int i5, final String str5, final String str6, Listener<BathUploadOrderNewBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.145
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().postCommIotAuthAnalysis(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), i, account.getAccountManagetStore().getUserInfo().AreaId, i2, str, i3, i4, str2, str3, str4, i5, str5, str6), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postCommIotAuth(final Account account, final String str, final int i, final int i2, final String str2, final int i3, final int i4, final String str3, final String str4, final String str5, final int i5, final String str6, final String str7, Listener<BathAuthNewBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.146
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().postCommIotAuth(account.getAccountManagetStore().getUserInfo().Token, str, i, account.getAccountManagetStore().getUserInfo().AreaId, i2, str2, i3, i4, str3, str4, str5, i5, str6, str7), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postDeviceConfiguration(final Account account, final int i, final String str, final int i2, final int i3, final String str2, final String str3, final String str4, final String str5, Listener<SetNBDrinkWaterBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.147
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().postDeviceConfiguration(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, str, i2, i3, str2, str3, str4, str5), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void GetRechargePromptInformation(final Account account, final int i, Listener<RechargeInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.148
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().GetRechargePromptInformation(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid()), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void SetEquipmentRateInfo(final Account account, final int i, final String str, final String str2, final String str3, final String str4, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.149
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().SetEquipmentRateInfo(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid(), account.getAccountManagetStore().getUserInfo().InvestorId, str, str2, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void GetEquipmentRateInfo(final Account account, final int i, Listener<SetBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.150
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().GetEquipmentRateInfo(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid(), account.getAccountManagetStore().getUserInfo().InvestorId), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void JudgeEquipmentRateInfo(final Account account, final int i, final String str, final String str2, final String str3, final String str4, Listener<SetBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.151
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().JudgeEquipmentRateInfo(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid(), account.getAccountManagetStore().getUserInfo().InvestorId, str, str2, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postLogoutBathHouse(final Account account, final String str, final String str2, Listener<UnRegisterBathHouseBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.152
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().postLogoutBathHouse(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId, str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getChangeBathHouse(final Account account, final String str, final String str2, Listener<UnRegisterBathHouseBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.153
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getChangeBathHouse(account.getAccountManagetStore().getUserInfo().Token, str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getBathHousePassword(final Account account, final int i, final String str, Listener<BathHousePasswordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.154
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getBathHousePassword(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, i, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postSetAuthorizedPassword(final Account account, final String str, final int i, final String str2, Listener<BathHousePasswordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.155
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().postSetAuthorizedPassword(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, str, i, account.getAccountManagetStore().getUserInfo().LoginAccount, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postChangeAuthorizedPassword(final Account account, final String str, final String str2, final int i, final String str3, Listener<BathHousePasswordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.156
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().postChangeAuthorizedPassword(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, str, str2, i, account.getAccountManagetStore().getUserInfo().LoginAccount, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getRechargeGiftInfo(final Account account, final int i, Listener<RechargeDetailListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.157
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().getRechargeGiftInfo(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, i), new Object[0]);
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getUserRefundList(final Account account, final String str, final int i, Listener<RefundListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.158
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().getUserRefundList(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, str, i), new Object[0]);
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getCancellationOfRefund(final Account account, final int i, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.159
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().getCancellationOfRefund(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, i), new Object[0]);
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getSelectUserAuthenticationStatus(final Account account, final int i, final String str, Listener<SelectUserAuthenticationBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.160
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getSelectUserAuthenticationStatus(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, i, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void postSubmitUserInformation(final Account account, final int i, final String str, final String str2, final String str3, final int i2, final int i3, Listener<SubmitUserInformationBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.161
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().postSubmitUserInformation(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, i, str, str2, str3, account.getAccountManagetStore().getUserInfo().Mobile, i2, i3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getDoorLockUserInfo(final Account account, final int i, final String str, Listener<DoorLockInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.162
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockUserInfo(account.getAccountManagetStore().getUserInfo().Token, account.getUid(), account.getAccountManagetStore().getUserInfo().AreaId, i, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getDLHAC(final Account account, final int i, final String str, final String str2, final String str3, final String str4, final String str5, Listener<DLHACBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.163
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDLHAC(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, str2, str3, str4, str5), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockAllUserID(final Account account, final int i, final String str, final String str2, final String str3, Listener<DoorLockAllUsersInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.164
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockAllUserID(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, str2, str3), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockSyncUserID(final Account account, final int i, final String str, final String str2, final String str3, final String str4, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.165
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockSyncUserID(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, str2, str3, str4), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockNotSyncKeyInfo(final Account account, final int i, final String str, final String str2, final String str3, Listener<DoorLockNotSyncKeys> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.166
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockNotSyncKeyInfo(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, str2, str3), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockKeyInfo(final Account account, final long j, final int i, final String str, Listener<DoorLockKeyInfos> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.167
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockKeyInfo(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, j + ""), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockSyncKey(final Account account, final int i, final String str, final String str2, final String str3, final int i2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.168
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockSyncKey(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, str2, str3, i2), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockAddUserID(final Account account, final int i, final String str, final String str2, final String str3, final String str4, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.169
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockAddUserID(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, str2, str3, str4), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockAddKey(final Account account, final int i, final String str, final String str2, final String str3, final String str4, final int i2, final String str5, final String str6, Listener<DoorLockAddKeyBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.170
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockAddKey(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, str2, str3, str4, i2, str5, str6), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockUpdateKey(final Account account, final int i, final String str, final String str2, final String str3, Listener<DoorLockAddKeyBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.171
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockUpdateKey(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, str2, str3), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockDeleteKey(final Account account, final int i, final String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.172
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockDeleteKey(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, str2), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockUpdateKeyName(final Account account, final int i, final String str, final String str2, final String str3, final String str4, final int i2, final String str5, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.173
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockUpdateKeyName(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, str2, str3, str4, i2, str5), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockChangeRoom(final Account account, final int i, final String str, final String str2, final String str3, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.174
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockChangeRoom(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, str2, str3), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockChangeRoomRecords(final Account account, final int i, final String str, Listener<DoorLockChangeRoomRecordsBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.175
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockChangeRoomRecords(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockEntryptData(final Account account, final int i, final String str, final String str2, final String str3, final String str4, final String str5, Listener<DLKeyBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.176
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockEntryptData(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, str2, str3, str4, str5), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockUploadRecords(final Account account, final int i, final String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.177
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockUploadRecords(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, str2), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockRecords(final Account account, final int i, final String str, final int i2, final int i3, Listener<DoorLockRecordsBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.178
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockRecords(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, i2, i3), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void getDoorLockStatus(final Account account, final int i, final String str, final String str2, final String str3, final String str4, final String str5, final int i2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.179
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().getDoorLockStatus(account.getAccountManagetStore().getUserInfo().Token, i, account.getAccountManagetStore().getUserInfo().AreaId, account.getUid() + "", str, str2, str3, str4, str5, i2), new Object[0]);
                    }
                } catch (ClientException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2));
                }
            }
        });
    }

    public void xiZaoCleanData(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, Listener<SoundWaveDrinkWaterCleanData> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.180
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreJava().xiZaoCleanData(account.getAccountManagetStore().getUserInfo().Token, str, str2, str3, account.getUid() + "", str4, str5, str6, str7), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getAdvertisingControl(final Account account, Listener<AdvControlListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.181
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStore().getAdvertisingControl(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + ""), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void newAddReportsV3(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final int i, final String str6, final String str7, final String str8, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.182
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account2.getHttpBusinessStoreV3Repair().newAddReportsV3(str, str2, str3, str4, str5, i, str6, str7, str8), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getReportListV3(final Account account, final String str, final String str2, final String str3, final int i, final int i2, final String str4, final int i3, final int i4, Listener<ReportListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.183
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account2.getHttpBusinessStoreV3Repair().getReportListV3(str, str2, str3, i, i2, str4, i3, i4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getReportDetailV3(final Account account, final String str, final String str2, final String str3, final int i, final String str4, final int i2, Listener<ReportDetailBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.184
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account2.getHttpBusinessStoreV3Repair().getReportDetailV3(str, str2, str3, i, str4, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getAnnouncementV3(final Account account, final String str, final String str2, Listener<List<GetAnnouncementBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.185
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account2.getHttpBusinessStoreV3Repair().getAnnouncementV3(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getAnnouncementDetailNewV3(final Account account, final long j, Listener<Detail> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.186
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account2.getHttpBusinessStoreV3Repair().getAnnouncementDetailNewV3("", j), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getAllAnnouncementV3(final Account account, final String str, Listener<GetAllAnnounceListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.187
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account2.getHttpBusinessStoreV3Repair().getAllAnnouncementV3("", str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void whetherPassword(final Account account, Listener<PasswordStateBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.188
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreSmallApp().whetherPassword(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + "", account.getAccountManagetStore().getUserInfo().ID + ""), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void addPassword(final Account account, final String str, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.189
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreSmallApp().addPassword(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + "", account.getAccountManagetStore().getUserInfo().ID + "", str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void updatePassword(final Account account, final String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.190
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreSmallApp().updatePassword(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + "", account.getAccountManagetStore().getUserInfo().ID + "", str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void isHasCardFunction(final Account account, final int i, Listener<IsHasBindCardFunctionBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.191
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreSmallApp().isHasCardFunction(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + "", i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void getIsBindCard(final Account account, final int i, final int i2, Listener<IsBindCardBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.192
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreSmallApp().getIsBindCard(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + "", account.getAccountManagetStore().getUserInfo().ID + "", i, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void bindCard(final Account account, final int i, final int i2, final String str, final String str2, final String str3, final String str4, Listener<BindCardBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.193
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreSmallApp().bindCard(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + "", account.getAccountManagetStore().getUserInfo().ID + "", i, i2, str, str2, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void bindCard2(final Account account, final int i, final String str, final String str2, final String str3, Listener<BindCardBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.194
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreSmallApp().bindCard2(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + "", account.getAccountManagetStore().getUserInfo().ID + "", i, str, str3, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void unBindCard(final Account account, final int i, final int i2, final String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.195
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreSmallApp().unBindCard(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + "", account.getAccountManagetStore().getUserInfo().ID + "", i, i2, str2, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void openCard(final Account account, final int i, int i2, String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.196
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreSmallApp().openCard(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + "", account.getAccountManagetStore().getUserInfo().ID + "", i, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }

    public void closeCard(final Account account, final int i, int i2, String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.BusinessControllers.197
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (account.getAccountManagetStore().getUserInfo() == null) {
                        BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        BusinessControllers.this.callComplete(controller, account.getHttpBusinessStoreSmallApp().closeCard(account.getAccountManagetStore().getUserInfo().Token, account.getAccountManagetStore().getUserInfo().AreaId + "", account.getAccountManagetStore().getUserInfo().ID + "", i, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    BusinessControllers.this.callFail(controller, e);
                }
            }
        });
    }
}
