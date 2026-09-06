package client.android.yixiaotong.ui.qrcode;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.getserveraddress.RegisterBefore;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.FillInfoActivity;
import client.android.yixiaotong.util.AESHelper;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.PlatformInfoBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByMacBean;
import client.android.yixiaotong.v3.bean.login.SchoolIdBean;
import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.register.V3RegisterActivity;
import client.android.yixiaotong.v3.ui.scan.QrcodeUtil;
import client.android.yixiaotong.v4.ui.user.V4RegisterQrcodeControl;
import client.android.yixiaotong.v4.ui.user.V4UserRegisterActivity;
import com.google.gson.Gson;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BindSchoolControl {
    private Account mAccount;
    private Activity mActivity;
    private boolean mIsEnable = true;
    private String mScanResult;

    public void onPause() {
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    public void init(Activity activity, Account account, String str) {
        this.mActivity = activity;
        this.mAccount = account;
        this.mScanResult = str;
        String strIsV4CustomerQrcode = V4RegisterQrcodeControl.isV4CustomerQrcode(str);
        if (StringUtils.isNotEmpty(strIsV4CustomerQrcode)) {
            V4UserRegisterActivity.launch(this.mActivity, strIsV4CustomerQrcode, V4RegisterQrcodeControl.isV4CustomerNameByQrcode(str));
            this.mActivity.finish();
            return;
        }
        manage(str);
    }

    public void onDestroy() {
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    class SchoolInfo {
        public long schoolId;
        public String schoolName;

        SchoolInfo() {
        }
    }

    private void manage(String str) {
        try {
            String strSimpleDecrypt = AESHelper.simpleDecrypt(str, StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
            Log.e("test", "schoolInfo:" + strSimpleDecrypt);
            SchoolInfo schoolInfo = (SchoolInfo) new Gson().fromJson(strSimpleDecrypt, SchoolInfo.class);
            if (schoolInfo == null) {
                Toast.makeText(this.mActivity, "扫描错误", 0).show();
                this.mActivity.finish();
            } else {
                final long j = schoolInfo.schoolId;
                final String str2 = schoolInfo.schoolName;
                BusinessControllers.getInstance().registerBeforeGetServerAddress(this.mAccount, schoolInfo.schoolId + "", new Listener<RegisterBefore>() { // from class: client.android.yixiaotong.ui.qrcode.BindSchoolControl.1
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, RegisterBefore registerBefore, Object... objArr) {
                        if (BindSchoolControl.this.mIsEnable) {
                            FillInfoActivity.launch(BindSchoolControl.this.mActivity, j, str2);
                            BindSchoolControl.this.mActivity.finish();
                        }
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, ClientException clientException) {
                        if (BindSchoolControl.this.mIsEnable) {
                            ErrorUtil.onFailResult(BindSchoolControl.this.mActivity, "扫码绑定学校", clientException, true);
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            qrcode(str);
        }
    }

    private void qrcode(final String str) {
        V3BusinessControllers.getInstance().getAnalysisQRCode(this.mAccount, str, new Listener<SchoolIdBean>() { // from class: client.android.yixiaotong.ui.qrcode.BindSchoolControl.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(BindSchoolControl.this.mActivity, "正在解析二维码.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SchoolIdBean schoolIdBean, Object... objArr) {
                super.onComplete(controller, schoolIdBean, objArr);
                if (BindSchoolControl.this.mIsEnable) {
                    BindSchoolControl.this.getPlatformInfo(schoolIdBean.schoolId, schoolIdBean.schoolName);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (BindSchoolControl.this.mIsEnable) {
                    BindSchoolControl.this.getInfoByQRCode(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPlatformInfo(final String str, final String str2) {
        V3BusinessControllers.getInstance().getPlatformInfo(this.mAccount, str, new Listener<PlatformInfoBean>() { // from class: client.android.yixiaotong.ui.qrcode.BindSchoolControl.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.setConnectMaterialDialog("正在获取平台信息..");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PlatformInfoBean platformInfoBean, Object... objArr) {
                if (BindSchoolControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (platformInfoBean.status == 0) {
                        V3RegisterActivity.launch(BindSchoolControl.this.mActivity, str2, str);
                    } else {
                        ToastUtils.show(BindSchoolControl.this.mActivity, "信息异常");
                    }
                    BindSchoolControl.this.mActivity.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BindSchoolControl.this.mIsEnable) {
                    BindSchoolControl.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getInfoByQRCode(final String str) {
        V3BusinessControllers.getInstance().getInfoByQRCode(this.mAccount, str, true, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.ui.qrcode.BindSchoolControl.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(BindSchoolControl.this.mActivity, "正在获取二维码数据.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (BindSchoolControl.this.mIsEnable) {
                    BindSchoolControl.this.getDeviceInfo((machineByMacBean == null || !StringUtils.isNotEmpty(machineByMacBean.machineId)) ? "" : machineByMacBean.machineId, str);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BindSchoolControl.this.mIsEnable) {
                    BindSchoolControl.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfo(final String str, String str2) {
        String subQrcode = QrcodeUtil.getSubQrcode(str2);
        if (StringUtils.isNotEmpty(str) || (StringUtils.isNotEmpty(subQrcode) && subQrcode.length() >= 40 && QrcodeUtil.isNumberLetterIllegal(subQrcode.toUpperCase()))) {
            if (!StringUtils.isNotEmpty(str)) {
                str = subQrcode.substring(2, 10);
                if (subQrcode.length() >= 52 && QrcodeUtil.isNBor4GDevice(subQrcode)) {
                    str = subQrcode.substring(34, 50);
                }
            }
            V3BusinessControllers.getInstance().getMachineByMachineId2(this.mAccount, str, true, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.ui.qrcode.BindSchoolControl.5
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                    if (BindSchoolControl.this.mIsEnable) {
                        if (machineByMacBean == null || machineByMacBean.base == null || !StringUtils.isNotEmpty(machineByMacBean.base.schoolId)) {
                            BindSchoolControl.this.showDialog(str + "设备未授权，建议扫其他设备码");
                        } else {
                            BindSchoolControl.this.getSchoolInfos(machineByMacBean.base.schoolId);
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (BindSchoolControl.this.mIsEnable) {
                        BindSchoolControl.this.onError(clientException);
                    }
                }
            });
            return;
        }
        if (StringUtils.isNotEmpty(str2)) {
            showDialog("不合法的设备码，尝试扫其他设备码！");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSchoolInfos(final String str) {
        V3BusinessControllers.getInstance().getSchoolInfos(this.mAccount, str, true, new Listener<List<SchoolInfosBean>>() { // from class: client.android.yixiaotong.ui.qrcode.BindSchoolControl.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<SchoolInfosBean> list, Object... objArr) {
                if (BindSchoolControl.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (list == null || list.size() <= 0 || list.get(0) == null) {
                        return;
                    }
                    V3RegisterActivity.launch(BindSchoolControl.this.mActivity, list.get(0).schoolName, str);
                    BindSchoolControl.this.mActivity.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BindSchoolControl.this.mIsEnable) {
                    BindSchoolControl.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, "提示", "请扫描学校二维码/设备二维码", "确定", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.qrcode.BindSchoolControl.7
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                BindSchoolControl.this.mActivity.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, "提示", "请扫描学校二维码/设备码", "确定", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.qrcode.BindSchoolControl.8
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                BindSchoolControl.this.mActivity.finish();
            }
        });
    }
}
