package client.android.yixiaotong.v4.ui.user;

import android.app.Activity;
import android.widget.Toast;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.getserveraddress.RegisterBefore;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.util.AESHelper;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.login.SchoolIdBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.google.gson.Gson;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4SelectSchoolControl {
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
        if (StringUtils.isNotEmpty(V4RegisterQrcodeControl.isV4CustomerQrcode(str))) {
            LocalDataUtil.savePlatformInfo(this.mActivity, 4);
            LocalDataUtil.savePlatformSchoolName(this.mActivity, V4RegisterQrcodeControl.isV4CustomerNameByQrcode(str));
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
            LogUtil.e("test", "schoolInfo:" + strSimpleDecrypt);
            SchoolInfo schoolInfo = (SchoolInfo) new Gson().fromJson(strSimpleDecrypt, SchoolInfo.class);
            if (schoolInfo == null) {
                Toast.makeText(this.mActivity, "扫描错误", 0).show();
                this.mActivity.finish();
            } else {
                long j = schoolInfo.schoolId;
                final String str2 = schoolInfo.schoolName;
                BusinessControllers.getInstance().registerBeforeGetServerAddress(this.mAccount, schoolInfo.schoolId + "", new Listener<RegisterBefore>() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectSchoolControl.1
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, RegisterBefore registerBefore, Object... objArr) {
                        if (V4SelectSchoolControl.this.mIsEnable) {
                            LocalDataUtil.savePlatformInfo(V4SelectSchoolControl.this.mActivity, 0);
                            LocalDataUtil.savePlatformSchoolName(V4SelectSchoolControl.this.mActivity, str2);
                            V4SelectSchoolControl.this.mActivity.finish();
                        }
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, ClientException clientException) {
                        if (V4SelectSchoolControl.this.mIsEnable) {
                            ToastUtils.show(V4SelectSchoolControl.this.mActivity, "非学校二维码");
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            qrcode(str);
        }
    }

    private void qrcode(String str) {
        V3BusinessControllers.getInstance().getAnalysisQRCode(this.mAccount, str, new Listener<SchoolIdBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectSchoolControl.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4SelectSchoolControl.this.mActivity, "正在解析二维码.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SchoolIdBean schoolIdBean, Object... objArr) {
                super.onComplete(controller, schoolIdBean, objArr);
                if (V4SelectSchoolControl.this.mIsEnable) {
                    LocalDataUtil.savePlatformInfo(V4SelectSchoolControl.this.mActivity, 1);
                    LocalDataUtil.savePlatformSchoolName(V4SelectSchoolControl.this.mActivity, schoolIdBean.schoolName);
                    V4SelectSchoolControl.this.mActivity.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4SelectSchoolControl.this.mIsEnable) {
                    ToastUtils.show(V4SelectSchoolControl.this.mActivity, "非学校二维码.");
                    V4SelectSchoolControl.this.mActivity.finish();
                }
            }
        });
    }
}
