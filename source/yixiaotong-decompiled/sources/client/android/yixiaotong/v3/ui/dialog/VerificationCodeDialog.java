package client.android.yixiaotong.v3.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.Base64;
import client.android.yixiaotong.util.BitmapUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.util.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class VerificationCodeDialog {
    private static final String TAG = "VerificationCodeDialog";
    private EditText etVerification;
    private boolean isStart;
    private ImageView ivCode;
    private Account mAccount;
    private Activity mActivity;
    private Dialog mDialog;
    private Listener mListener;
    private String mMobile;
    private TextView tvGetCode;
    private Button tvWait;
    private Button tv_postive;

    public interface Listener {
        void onCancle();

        void onConfirm(String str);
    }

    private VerificationCodeDialog() {
        this.isStart = false;
    }

    private static final class SigleHolder {
        public static final VerificationCodeDialog INSTANCE = new VerificationCodeDialog();

        private SigleHolder() {
        }
    }

    public static VerificationCodeDialog getInstance() {
        return SigleHolder.INSTANCE;
    }

    public void showDialog(Account account, String str, Activity activity, Listener listener) {
        Dialog dialog = this.mDialog;
        if ((dialog != null && dialog.isShowing()) || activity == null || listener == null) {
            return;
        }
        this.isStart = false;
        this.mAccount = account;
        this.mMobile = str;
        this.mListener = listener;
        this.mActivity = activity;
        Dialog dialog2 = new Dialog(this.mActivity, R.style.mydialog);
        this.mDialog = dialog2;
        Window window = dialog2.getWindow();
        View viewInflate = this.mActivity.getLayoutInflater().inflate(R.layout.dialog_verificationcodedialog_v3, (ViewGroup) null);
        this.tvWait = (Button) viewInflate.findViewById(R.id.tv_wait);
        this.tv_postive = (Button) viewInflate.findViewById(R.id.tv_positive);
        this.etVerification = (EditText) viewInflate.findViewById(R.id.et_verification);
        this.tvGetCode = (TextView) viewInflate.findViewById(R.id.tv_getcode);
        this.ivCode = (ImageView) viewInflate.findViewById(R.id.iv_code);
        this.mDialog.setContentView(viewInflate);
        this.mDialog.setCancelable(false);
        waitOnclick();
        confirmOnclick();
        getCodeOnclick();
        Display defaultDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) defaultDisplay.getWidth()) * 0.8d);
        window.setAttributes(attributes);
        this.mDialog.show();
        getV3Code();
    }

    private void waitOnclick() {
        this.tvWait.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.VerificationCodeDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VerificationCodeDialog.this.mDialog.dismiss();
                VerificationCodeDialog.this.mListener.onCancle();
            }
        });
    }

    private void confirmOnclick() {
        this.tv_postive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.VerificationCodeDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (StringUtils.isNotEmpty(VerificationCodeDialog.this.etVerification.getText().toString())) {
                    VerificationCodeDialog.this.mDialog.dismiss();
                    VerificationCodeDialog.this.mListener.onConfirm(VerificationCodeDialog.this.etVerification.getText().toString());
                } else {
                    ToastUtils.show(VerificationCodeDialog.this.mActivity, "请输入验证码");
                }
            }
        });
    }

    private void getCodeOnclick() {
        this.tvGetCode.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.dialog.VerificationCodeDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VerificationCodeDialog.this.getV3Code();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getV3Code() {
        LogUtil.e(TAG, "getV3code" + this.isStart);
        if (this.isStart) {
            return;
        }
        V3BusinessControllers.getInstance().getCode(this.mAccount, this.mMobile, new client.android.yixiaotong.controller.core.Listener<String>() { // from class: client.android.yixiaotong.v3.ui.dialog.VerificationCodeDialog.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                VerificationCodeDialog.this.isStart = true;
                VerificationCodeDialog.this.tvGetCode.setVisibility(8);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str, Object... objArr) {
                String[] strArrSplit;
                VerificationCodeDialog.this.isStart = false;
                if (VerificationCodeDialog.this.mDialog == null || !VerificationCodeDialog.this.mDialog.isShowing() || VerificationCodeDialog.this.mActivity == null || !StringUtils.isNotEmpty(str) || (strArrSplit = str.split(",")) == null || strArrSplit.length <= 1) {
                    return;
                }
                byte[] bArrDecode = Base64.decode(strArrSplit[1], 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                float appScreenDensity = AppUtils.getAppScreenDensity(VerificationCodeDialog.this.mActivity);
                int i = (int) (80.0f * appScreenDensity);
                LogUtil.e(VerificationCodeDialog.TAG, appScreenDensity + "  " + i);
                VerificationCodeDialog.this.ivCode.setImageBitmap(BitmapUtil.scaleBitmap(bitmapDecodeByteArray, i, (int) (appScreenDensity * 40.0f)));
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                VerificationCodeDialog.this.isStart = false;
                if (VerificationCodeDialog.this.mDialog == null || !VerificationCodeDialog.this.mDialog.isShowing() || VerificationCodeDialog.this.mActivity == null) {
                    return;
                }
                VerificationCodeDialog.this.tvGetCode.setVisibility(0);
                VerificationCodeDialog.this.onError(clientException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        this.mDialog.dismiss();
        V3ErrorTipActivity.launch(this.mActivity, "获取验证码", clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
    }
}
