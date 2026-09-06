package client.android.yixiaotong.v4.http;

import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.BaseControllers;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.exception.HttpException;
import client.android.yixiaotong.v4.http.bean.V44GOpenStatus;
import client.android.yixiaotong.v4.http.bean.V4AreaBean;
import client.android.yixiaotong.v4.http.bean.V4BLEOpenBean;
import client.android.yixiaotong.v4.http.bean.V4BathConsumeDetailBean;
import client.android.yixiaotong.v4.http.bean.V4BathRecordBean;
import client.android.yixiaotong.v4.http.bean.V4BathRecordListBean;
import client.android.yixiaotong.v4.http.bean.V4BindCustomer;
import client.android.yixiaotong.v4.http.bean.V4CardInfoBean;
import client.android.yixiaotong.v4.http.bean.V4DeviceInfoBean;
import client.android.yixiaotong.v4.http.bean.V4DeviceListBean;
import client.android.yixiaotong.v4.http.bean.V4DeviceMeterRefundRecordBean;
import client.android.yixiaotong.v4.http.bean.V4ElecMeterInfoBean;
import client.android.yixiaotong.v4.http.bean.V4ElecRechargeRecordBean;
import client.android.yixiaotong.v4.http.bean.V4HomeInfoBean;
import client.android.yixiaotong.v4.http.bean.V4ImageCodeBean;
import client.android.yixiaotong.v4.http.bean.V4LoginBean;
import client.android.yixiaotong.v4.http.bean.V4MeterConsumeDailySummaryBean;
import client.android.yixiaotong.v4.http.bean.V4MetersTrendBean;
import client.android.yixiaotong.v4.http.bean.V4ModeBean;
import client.android.yixiaotong.v4.http.bean.V4PlatformInfoBean;
import client.android.yixiaotong.v4.http.bean.V4ProjectConfigBean;
import client.android.yixiaotong.v4.http.bean.V4RechargeBean;
import client.android.yixiaotong.v4.http.bean.V4RechargeListBean;
import client.android.yixiaotong.v4.http.bean.V4RechargeRecordListBean;
import client.android.yixiaotong.v4.http.bean.V4RefundDetailBean;
import client.android.yixiaotong.v4.http.bean.V4RefundRecordBean;
import client.android.yixiaotong.v4.http.bean.V4RefundableAmountBean;
import client.android.yixiaotong.v4.http.bean.V4RepairRecordBean;
import client.android.yixiaotong.v4.http.bean.V4SchoolInfoBean;
import client.android.yixiaotong.v4.http.bean.V4SelectAllBean;
import client.android.yixiaotong.v4.http.bean.V4ServerListBean;
import client.android.yixiaotong.v4.http.bean.V4SignBean;
import client.android.yixiaotong.v4.http.bean.V4SubmitRefundBean;
import client.android.yixiaotong.v4.http.bean.V4UserInfoDetailBean;
import client.android.yixiaotong.v4.http.bean.V4VersionInfoBean;
import client.android.yixiaotong.v4.http.bean.V4WalletInfoBean;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4BusinessControllers extends BaseControllers {
    private V4BusinessControllers() {
    }

    private static class SingleHolder {
        public static final V4BusinessControllers INSTANCE = new V4BusinessControllers();

        private SingleHolder() {
        }
    }

    public static V4BusinessControllers getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void postBugErrorLog(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4HttpConfig.V4_BUGERROR_SERVER).postBugErrorLog(str, str2, str3, str4, str5, str6, str7), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getAppVersionInfo(final Account account, final String str, Listener<V4VersionInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getAppVersionInfo(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getSchoolPlatform(final Account account, final String str, Listener<List<V4PlatformInfoBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrlForSchool("")).getSchoolPlatform(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void register(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).userRegister(str, str2, str3, str4, str5), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postUserlogoff(final Account account, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postUserlogoff(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void login(final Account account, final String str, final String str2, final String str3, final String str4, Listener<V4LoginBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).login(str, str2, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getHomeInfo(final Account account, Listener<V4HomeInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getHomeInfo(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void post4GOpen(final Account account, final String str, final int i, final String str2, final boolean z, Listener<V4BLEOpenBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).post4GOpen(str, i, str2, z), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postBLEOpen(final Account account, final String str, final String str2, final String str3, final String str4, final boolean z, Listener<V4BLEOpenBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postBLEOpen(str, str2, str3, str4, z), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postBLEClollect(final Account account, final String str, final String str2, final String str3, Listener<V4BLEOpenBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postBLEClollect(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postAppMonitorReport(final Account account, final String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postAppMonitorReport(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void get4GOpenStatus(final Account account, final String str, final String str2, Listener<V44GOpenStatus> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).get4GOpenStatus(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getConsumeRecord(final Account account, final int i, final int i2, final int i3, final int i4, Listener<V4BathRecordListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getConsumeRecord(i, i2, i3, i4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getConsumeDetail(final Account account, final String str, Listener<V4BathConsumeDetailBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getConsumeDetail(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getUserInfo(final Account account, Listener<V4UserInfoDetailBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getUserInfo(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getCustomerPersonInfo(final Account account, Listener<V4UserInfoDetailBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getCustomerPersonInfo(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postUpdateCurrentDeductBank(final Account account, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postUpdateCurrentDeductBank(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getProjectConfig(final Account account, Listener<V4ProjectConfigBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getProjectConfig(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getServerList(final Account account, Listener<V4ServerListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getServerList(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getUserBalance(final Account account, final String str, Listener<V4WalletInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.20
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getUserBalance(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getRechargeAmountList(final Account account, final int i, Listener<List<V4RechargeListBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.21
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getRechargeList(i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postUpdatePassword(final Account account, final String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.22
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postUpdatePassword(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postResetPassword(final Account account, final String str, final String str2, final String str3, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.23
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postResetPassword(str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getCardInfo(final Account account, Listener<V4CardInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.24
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getCardInfo(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postBindCard(final Account account, final String str, final String str2, Listener<V4CardInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.25
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postBindCard(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postUnBindCard(final Account account, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.26
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postUnBindCard(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getDevicePassword(final Account account, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.27
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getDevicePassword(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postSetDevicePassword(final Account account, final String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.28
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postSetDevicePassword(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postSendSmsCode(final Account account, final String str, final String str2, final String str3, final String str4, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.29
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postSendSmsCode(str, str2, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postUpdateMobile(final Account account, final String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.30
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postUpdateMobile(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getLoginCodeImage(final Account account, Listener<V4ImageCodeBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.31
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getLoginCodeImage(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postUserRecharge(final Account account, final String str, final int i, final String str2, Listener<V4RechargeBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.32
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postUserRecharge(str, i, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getRechargeRecord(final Account account, Listener<V4RechargeRecordListBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.33
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getRechargeRecord(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postSubmitRefund(final Account account, final String str, final String str2, final int i, final int i2, final String str3, final String str4, Listener<V4SubmitRefundBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.34
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postSubmitRefund(str, str2, i, i2, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postCancelRefund(final Account account, final String str, final String str2, final int i, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.35
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postCancelRefund(str, str2, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postAgainSubmitRefund(final Account account, final String str, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.36
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postAgainSubmitRefund(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getRefundList(final Account account, final int i, final int i2, Listener<V4RefundRecordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.37
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getRefundList(i, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getWaitRefundList(final Account account, final int i, final int i2, Listener<V4RefundDetailBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.38
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getWaitRefundList(i, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getAreaList(final Account account, final String str, Listener<List<V4AreaBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.39
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getAreaList(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getDeviceList(final Account account, final String str, Listener<List<V4DeviceListBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.40
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getDeviceList(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getDeviceInfoByMac(final Account account, final String str, Listener<V4DeviceInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.41
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getDeviceInfoByMac(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getDeviceInfoByMachineId(final Account account, final String str, Listener<V4DeviceInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.42
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getDeviceInfoByMachineId(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getSchoolInfos(final Account account, Listener<List<V4SchoolInfoBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.43
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getSchoolInfos(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postBindCustomer(final Account account, final String str, Listener<V4BindCustomer> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.44
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postBindCustomer(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postSwitchCustomer(final Account account, final String str, Listener<V4UserInfoDetailBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.45
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postSwitchCustomer(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postSwitchProject(final Account account, final String str, Listener<V4UserInfoDetailBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.46
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postSwitchProject(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postUpdateUserInfo(final Account account, final String str, Listener<V4UserInfoDetailBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.47
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postUpdateUserInfo(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getRepairList(final Account account, final int i, final int i2, final int i3, Listener<V4RepairRecordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.48
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getRepairList(i, i2, i3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postAddRepair(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.49
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postAddRepair(str, str2, str3, str4, str5, str6, str7), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postDeleteRepair(final Account account, final String str, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.50
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postDeleteRepair(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getMode(final Account account, final String str, Listener<V4ModeBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.51
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getMode(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getDeviceInfoByQrcode(final Account account, final String str, Listener<V4DeviceInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.52
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getDeviceInfoByQrcode(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getElecMeterInfo(final Account account, final int i, Listener<V4ElecMeterInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.53
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getElecMeterInfo(i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postBindRoom(final Account account, final String str, final String str2, Listener<V4ElecMeterInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.54
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postBindRoom(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postCreateElecMeterOrderId(final Account account, final int i, final String str, final String str2, final int i2, Listener<V4RechargeBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.55
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postCreateElecMeterOrderId(i, str, str2, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getElecMeterRechargeRecord(final Account account, final int i, final String str, Listener<V4ElecRechargeRecordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.56
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getElecMeterRechargeRecord(i, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void updateF0(final Account account, final String str, final String str2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.57
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).updateF0(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void btRecharge(final Account account, final String str, final String str2, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.58
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).btRecharge(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void netRecharge(final Account account, final String str, Listener<V4RechargeBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.59
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).netRecharge(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getSchoolQrCode(final Account account, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.60
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getSchoolQrCode(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getDeviceInfoBySn(final Account account, final String str, Listener<V4DeviceInfoBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.61
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getDeviceInfoBySn(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getMetersTrend(final Account account, final int i, final String str, final String str2, final String str3, Listener<V4MetersTrendBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.62
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getMetersTrend(i, str, str2, str3), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getMeterConsumeDailySummary(final Account account, final int i, final int i2, Listener<V4MeterConsumeDailySummaryBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.63
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getMeterConsumeDailySummary(i, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void postOpen(final Account account, final String str, final String str2, final String str3, final String str4, final String str5, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.64
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).postOpen(str, str2, str3, str4, str5), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void selectAll(final Account account, Listener<List<V4SelectAllBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.65
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).selectAll(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getSignAContractResult(final Account account, final String str, Listener<V4SignBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.66
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getSignAContractResult(str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void selectIsHasNoPay(final Account account, Listener<Boolean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.67
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).selectIsHasNoPay(), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getNoPayRecord(final Account account, final int i, Listener<List<V4BathRecordBean>> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.68
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getNoPayRecord(i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void toPay(final Account account, final List<String> list, final int i, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.69
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).toPay(list, i), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void updateRoomLeader(final Account account, final int i, final String str, final int i2, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.70
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).updateRoomLeader(i, str, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void cancelRefund(final Account account, final int i, final String str, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.71
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).cancelRefund(i, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getRefundableAmount(final Account account, final int i, final String str, Listener<V4RefundableAmountBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.72
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getRefundableAmount(i, str), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void submitRefundForDevice(final Account account, final int i, final String str, final String str2, final String str3, final String str4, Listener<SuccessBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.73
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).submitRefundForDevice(i, str, str2, str3, str4), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void getDeviceMeterRefundRecord(final Account account, final int i, final int i2, final Integer num, Listener<V4DeviceMeterRefundRecordBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.74
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).getDeviceMeterRefundRecord(i, i2, num), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void btReturnToZeroKwh(final Account account, final String str, final String str2, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.75
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).btReturnToZeroKwh(str, str2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }

    public void toggleDeviceLock(final Account account, final String str, final String str2, final int i, final int i2, Listener<String> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        callStart(controller);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.v4.http.V4BusinessControllers.76
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Account account2 = account;
                    if (account2 == null) {
                        V4BusinessControllers.this.callFail(controller, new ClientException());
                    } else {
                        V4BusinessControllers.this.callComplete(controller, account2.getV4HttpBusinessStore(V4GetHttpUrlUtil.getV4PlatformServerUrl("")).toggleDeviceLock(str, str2, i, i2), new Object[0]);
                    }
                } catch (HttpException e) {
                    e.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    V4BusinessControllers.this.callFail(controller, new ClientException(e2.getMessage()));
                }
            }
        });
    }
}
