package client.android.yixiaotong.ui.hamam;

import android.app.Activity;
import android.util.Log;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.hamam.BathHousePasswordBean;
import client.android.yixiaotong.controller.bean.hamam.HamamGetRoomInfoBean;
import client.android.yixiaotong.controller.bean.hamam.UnRegisterBathHouseBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.InitDialogTip;
import client.android.yixiaotong.ui.dialog.SetPswDialogTip;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.AESHelper;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HamamScanResultControl {
    private Account mAccount;
    private Activity mActivity;
    private boolean mIsEnable;
    private String mScanResult;
    private SetPswDialogTip mSetPswDialogTip;
    private WalletModel mWalletModel;

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
        initDialog();
        checkCode();
    }

    public void onDestroy() {
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().dismiss(this.mActivity);
    }

    private void checkCode() {
        if (StringUtils.isNotEmpty(this.mScanResult)) {
            String[] strArrSplit = this.mScanResult.split(",");
            if (StringUtils.isNotEmpty(strArrSplit[0])) {
                StringBuilder sb = new StringBuilder();
                sb.append(strArrSplit[0]);
                if (strArrSplit[0].length() < 16) {
                    for (int i = 0; i < 16 - strArrSplit[0].length(); i++) {
                        sb.append("0");
                    }
                }
                if (sb.toString().length() > 16) {
                    ToastUtils.show(this.mActivity, "不合法的二维码！");
                    this.mActivity.finish();
                    return;
                }
                String str = "";
                String str2 = (strArrSplit.length <= 1 || !StringUtils.isNotEmpty(strArrSplit[1])) ? "" : strArrSplit[1];
                String str3 = (strArrSplit.length <= 2 || !StringUtils.isNotEmpty(strArrSplit[2])) ? "" : strArrSplit[2];
                if (strArrSplit.length > 3 && StringUtils.isNotEmpty(strArrSplit[3])) {
                    str = strArrSplit[3];
                }
                Log.e("test", sb.toString() + "  " + str2 + "  " + str3 + "  " + str);
                getRoomAddress(sb.toString(), str2, str3, str);
            }
        }
    }

    private void getRoomAddress(final String str, final String str2, final String str3, final String str4) {
        BusinessControllers.getInstance().GetEquipmentInfo(this.mAccount, str, this.mWalletModel.typeId, new Listener<HamamGetRoomInfoBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamScanResultControl.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, final HamamGetRoomInfoBean hamamGetRoomInfoBean, Object... objArr) {
                if (HamamScanResultControl.this.mIsEnable) {
                    InitDialogTip.getInstance().showTipDialog(HamamScanResultControl.this.mActivity, HamamScanResultControl.this.mAccount.getAccountManagetStore().getUserInfo().SchoolName, HamamScanResultControl.this.mWalletModel.name, hamamGetRoomInfoBean.deviceName, hamamGetRoomInfoBean.roomAddress, false, new InitDialogTip.InitDialogListener() { // from class: client.android.yixiaotong.ui.hamam.HamamScanResultControl.1.1
                        @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                        public void onInit() {
                        }

                        @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                        public void onSet() {
                            HamamScanResultControl.this.unBind(str, hamamGetRoomInfoBean.bathId);
                        }

                        @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                        public void onDeviceDetail() {
                            HamamScanResultControl.this.getPassword();
                        }

                        @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                        public void onHelpMore() {
                            HamamScanResultControl.this.mActivity.finish();
                        }

                        @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                        public void onDismiss() {
                            HamamScanResultControl.this.mActivity.finish();
                        }
                    });
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamScanResultControl.this.mIsEnable) {
                    if (clientException.getCode() == 5000) {
                        InitDialogTip.getInstance().showTipDialog(HamamScanResultControl.this.mActivity, "", "", "", "", true, new InitDialogTip.InitDialogListener() { // from class: client.android.yixiaotong.ui.hamam.HamamScanResultControl.1.2
                            @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                            public void onSet() {
                            }

                            @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                            public void onInit() {
                                HamamInitActivity.launch(HamamScanResultControl.this.mActivity, HamamScanResultControl.this.mWalletModel, str, str2, str3, str4, 1);
                                HamamScanResultControl.this.mActivity.finish();
                            }

                            @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                            public void onDeviceDetail() {
                                HamamScanResultControl.this.getPassword();
                            }

                            @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                            public void onHelpMore() {
                                HamamScanResultControl.this.mActivity.finish();
                            }

                            @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                            public void onDismiss() {
                                HamamScanResultControl.this.mActivity.finish();
                            }
                        });
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(HamamScanResultControl.this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.hamam.HamamScanResultControl.1.3
                            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                            public void onConfirm() {
                                HamamScanResultControl.this.mActivity.finish();
                            }
                        }, clientException.getDetail());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unBind(final String str, String str2) {
        if (StringUtils.isEmpty(str)) {
            ToastUtils.show(this.mActivity, "机器ID不能为空！");
        } else if (StringUtils.isEmpty(str2)) {
            ToastUtils.show(this.mActivity, "房间ID不能为空！");
        } else {
            BusinessControllers.getInstance().uninitHamam(this.mAccount, str, this.mWalletModel.typeId, str2, this.mAccount.getAccountManagetStore().getUserInfo().AreaId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamScanResultControl.2
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    if (HamamScanResultControl.this.mIsEnable) {
                        HamamScanResultControl.this.unBindEnd(str);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (HamamScanResultControl.this.mIsEnable) {
                        SystemErrorTip.getInstance().showTipDialog(HamamScanResultControl.this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.hamam.HamamScanResultControl.2.1
                            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                            public void onConfirm() {
                                HamamScanResultControl.this.mActivity.finish();
                            }
                        }, clientException.getDetail());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unBindEnd(String str) {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().getChangeBathHouse(this.mAccount, str, randNumMaxString, new Listener<UnRegisterBathHouseBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamScanResultControl.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, UnRegisterBathHouseBean unRegisterBathHouseBean, Object... objArr) {
                if (!HamamScanResultControl.this.mIsEnable || !StringUtils.isNotEmpty(unRegisterBathHouseBean.rand) || !unRegisterBathHouseBean.rand.equals(randNumMaxString)) {
                    SystemErrorTip.getInstance().showTipDialog(HamamScanResultControl.this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.hamam.HamamScanResultControl.3.1
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            HamamScanResultControl.this.mActivity.finish();
                        }
                    }, "设备解绑失败！");
                } else {
                    ToastUtils.show(HamamScanResultControl.this.mActivity, "设备解绑成功！");
                    HamamScanResultControl.this.mActivity.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamScanResultControl.this.mIsEnable) {
                    SystemErrorTip.getInstance().showTipDialog(HamamScanResultControl.this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.hamam.HamamScanResultControl.3.2
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            HamamScanResultControl.this.mActivity.finish();
                        }
                    }, clientException.getDetail());
                }
            }
        });
    }

    private void initDialog() {
        this.mSetPswDialogTip = new SetPswDialogTip(this.mActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPassword() {
        BusinessControllers.getInstance().getBathHousePassword(this.mAccount, this.mWalletModel.typeId, RandomUtil.getRandNumMaxString(6), new Listener<BathHousePasswordBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamScanResultControl.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathHousePasswordBean bathHousePasswordBean, Object... objArr) {
                String strDecrypt;
                if (HamamScanResultControl.this.mIsEnable) {
                    if (bathHousePasswordBean == null || !StringUtils.isNotEmpty(bathHousePasswordBean.typePassword)) {
                        HamamScanResultControl.this.mSetPswDialogTip.showSetPswDialog();
                        HamamScanResultControl.this.mSetPswDialogTip.waitOnclick();
                        HamamScanResultControl.this.mSetPswDialogTip.confirmOnclick();
                        return;
                    }
                    try {
                        strDecrypt = AESHelper.decrypt(bathHousePasswordBean.typePassword, StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
                    } catch (Exception e) {
                        e.printStackTrace();
                        strDecrypt = "";
                    }
                    if (!StringUtils.isNotEmpty(strDecrypt) || strDecrypt.length() != 10) {
                        SystemErrorTip.getInstance().showTipDialog(HamamScanResultControl.this.mActivity, "获取授权密钥失败");
                        return;
                    }
                    LocalBusinessStore.saveAuthorizedPassword(HamamScanResultControl.this.mActivity, HamamScanResultControl.this.mAccount.getUid(), strDecrypt);
                    HamamMainActivity.launch(HamamScanResultControl.this.mActivity, HamamScanResultControl.this.mWalletModel);
                    HamamScanResultControl.this.mActivity.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamScanResultControl.this.mIsEnable) {
                    SystemErrorTip.getInstance().showTipDialog(HamamScanResultControl.this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.hamam.HamamScanResultControl.4.1
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            HamamScanResultControl.this.mActivity.finish();
                        }
                    }, clientException.getDetail());
                }
            }
        });
    }
}
