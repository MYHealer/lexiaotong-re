package client.android.yixiaotong.ui.card;

import android.app.Activity;
import android.util.Log;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SoundWaveBean;
import client.android.yixiaotong.controller.bean.SoundWaveOrderBean;
import client.android.yixiaotong.controller.bean.wash.WashHistoryOrderBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.OrderIdUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.qrcodeutil.QrcodeDataUtil;
import client.android.yixiaotong.util.random.RandomUtils;
import client.android.yixiaotong.zksoundwave.SWCommandUtil;
import client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CardScanResultControl {
    private Account mAccount;
    private Activity mActivity;
    private boolean mIsEnable;
    private String mOrderID;
    private String mQrcodeData;
    private String mScanResult;
    private WalletModel mWalletModel;
    private String mMoney = "";
    private boolean isGetOrderIding = false;

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    public void init(Activity activity, Account account, WalletModel walletModel, String str, String str2) {
        this.mActivity = activity;
        this.mAccount = account;
        this.mWalletModel = walletModel;
        this.mScanResult = str;
        if (StringUtils.isNotEmpty(str2)) {
            if (str2.contains(",")) {
                String[] strArrSplit = str2.split(",");
                if (strArrSplit.length == 2) {
                    this.mOrderID = strArrSplit[0];
                    this.mMoney = strArrSplit[1];
                }
            } else {
                this.mOrderID = "";
                this.mMoney = str2;
            }
        }
        initSW();
        checkCode();
    }

    public void onDestroy() {
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().dismiss(this.mActivity);
    }

    private void initSW() {
        SWCommandUtil.getInstance().initDataManage();
        SWCommandUtil.getInstance().setDataListener(new SoundWaveDataListener() { // from class: client.android.yixiaotong.ui.card.CardScanResultControl.1
            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onGetQrcodeData(String str) {
            }

            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onQrcodeData(String str, String str2, int i) {
                Log.e("test", str + "  " + str2 + "  " + i);
                if (StringUtils.isNotEmpty(CardScanResultControl.this.mOrderID)) {
                    CardScanResultControl.this.shouquan(str, str2);
                } else {
                    CardScanResultControl.this.soundwaveCardUpdateInfo(str, str2);
                }
            }
        });
    }

    private void checkCode() {
        if (QrcodeDataUtil.qrcodeFormat(this.mScanResult)) {
            this.mQrcodeData = this.mScanResult.trim();
            SWCommandUtil sWCommandUtil = SWCommandUtil.getInstance();
            String str = this.mQrcodeData;
            sWCommandUtil.sendQrcodeData(str, str.length());
            return;
        }
        ToastUtils.show(this.mActivity, "不合法的设备码");
        this.mActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shouquan(String str, String str2) {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().soundWave1(this.mAccount, this.mOrderID, 0, str, str2, this.mWalletModel.ID, this.mWalletModel.typeId, 1, 1, randNumMaxStringNonO, 1, new Listener<SoundWaveBean>() { // from class: client.android.yixiaotong.ui.card.CardScanResultControl.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("正在加载中..");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SoundWaveBean soundWaveBean, Object... objArr) {
                if (CardScanResultControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (!StringUtils.isNotEmpty(soundWaveBean.systemData) || !StringUtils.isNotEmpty(soundWaveBean.systemTime) || !soundWaveBean.rand.equals(randNumMaxStringNonO)) {
                        ToastUtils.show(CardScanResultControl.this.mActivity, "数据出错");
                        CardScanResultControl.this.mActivity.finish();
                    } else {
                        CardWalletActivity.launch1(CardScanResultControl.this.mActivity, CardScanResultControl.this.mWalletModel, CardScanResultControl.this.mOrderID, CardScanResultControl.this.mMoney, CardScanResultControl.this.mQrcodeData, soundWaveBean.systemData, soundWaveBean.systemTime);
                        CardScanResultControl.this.mActivity.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CardScanResultControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    CardScanResultControl.this.isVisableLog(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void soundwaveCardUpdateInfo(final String str, final String str2) {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().SoundWaveCardUpdateInfo(this.mAccount, this.mWalletModel.typeId, str, str2, 1, randNumMaxStringNonO, true, new Listener<WashHistoryOrderBean>() { // from class: client.android.yixiaotong.ui.card.CardScanResultControl.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(CardScanResultControl.this.mActivity, "连接中...", false);
                if (StringUtils.isEmpty(CardScanResultControl.this.mOrderID)) {
                    BaseMaterialDialog.setConnectMaterialDialog("二维码扫描成功，正在处理中...");
                } else {
                    BaseMaterialDialog.setConnectMaterialDialog("二维码扫描成功，正在查询当前订单的状态...");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WashHistoryOrderBean washHistoryOrderBean, Object... objArr) {
                if (CardScanResultControl.this.mIsEnable) {
                    if (!StringUtils.isNotEmpty(CardScanResultControl.this.mOrderID) || !StringUtils.isNotEmpty(washHistoryOrderBean.before_orderid) || !CardScanResultControl.this.mOrderID.equals(washHistoryOrderBean.before_orderid)) {
                        CardScanResultControl.this.getOrder(str, str2);
                        return;
                    }
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (washHistoryOrderBean.rand.equals(randNumMaxStringNonO)) {
                        SystemErrorTip.getInstance().showTipDialog(CardScanResultControl.this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.card.CardScanResultControl.3.1
                            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                            public void onConfirm() {
                                CardScanResultControl.this.mActivity.finish();
                            }
                        }, "当前订单已经完成了");
                    } else {
                        ToastUtils.show(CardScanResultControl.this.mActivity, "数据出错");
                        CardScanResultControl.this.mActivity.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CardScanResultControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (clientException.getCode() == 4072) {
                        CardWalletActivity.launch(CardScanResultControl.this.mActivity, CardScanResultControl.this.mWalletModel, CardScanResultControl.this.mOrderID, CardScanResultControl.this.mMoney, CardScanResultControl.this.mQrcodeData, str, str2);
                        CardScanResultControl.this.mActivity.finish();
                    } else {
                        CardScanResultControl.this.isVisableLog(clientException);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOrder(final String str, final String str2) {
        if (this.isGetOrderIding) {
            return;
        }
        this.isGetOrderIding = true;
        BusinessControllers.getInstance().soundWaveOrder(this.mAccount, 1, OrderIdUtils.getOrderID(this.mWalletModel.typeId), OrderIdUtils.getLocalDate("yyyyMMddHHmmss"), this.mWalletModel.ID, "1", (int) (Float.parseFloat(this.mMoney) * 100.0f), this.mWalletModel.typeId, this.mQrcodeData.substring(2, 10), new Listener<SoundWaveOrderBean>() { // from class: client.android.yixiaotong.ui.card.CardScanResultControl.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("正在加载中...");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SoundWaveOrderBean soundWaveOrderBean, Object... objArr) {
                if (CardScanResultControl.this.mIsEnable) {
                    CardScanResultControl.this.mOrderID = soundWaveOrderBean.orderId;
                    CardScanResultControl.this.isGetOrderIding = false;
                    CardScanResultControl.this.shouquan(str, str2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (CardScanResultControl.this.mIsEnable) {
                    CardScanResultControl.this.isGetOrderIding = false;
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (clientException.getCode() == 4060) {
                        CardRecordActivity.launch(CardScanResultControl.this.mActivity, CardScanResultControl.this.mWalletModel, "1", CardScanResultControl.this.mQrcodeData.substring(2, 10));
                        CardScanResultControl.this.mActivity.finish();
                    } else {
                        CardScanResultControl.this.isVisableLog(clientException);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isVisableLog(ClientException clientException) {
        ErrorUtil.onFailResult(this.mActivity, "卡片充值", clientException, true);
    }
}
