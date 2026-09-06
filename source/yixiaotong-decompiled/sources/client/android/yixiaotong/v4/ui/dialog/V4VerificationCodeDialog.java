package client.android.yixiaotong.v4.ui.dialog;

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
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4ImageCodeBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4VerificationCodeDialog {
    private static final String TAG = "V4VerificationCodeDialog";
    private String captchaKey;
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

        void onConfirm(String str, String str2);
    }

    private V4VerificationCodeDialog() {
        this.isStart = false;
    }

    private static final class SigleHolder {
        public static final V4VerificationCodeDialog INSTANCE = new V4VerificationCodeDialog();

        private SigleHolder() {
        }
    }

    public static V4VerificationCodeDialog getInstance() {
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
        getCode();
    }

    private void waitOnclick() {
        this.tvWait.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.dialog.V4VerificationCodeDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                V4VerificationCodeDialog.this.mDialog.dismiss();
                V4VerificationCodeDialog.this.mListener.onCancle();
            }
        });
    }

    private void confirmOnclick() {
        this.tv_postive.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.dialog.V4VerificationCodeDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (StringUtils.isNotEmpty(V4VerificationCodeDialog.this.etVerification.getText().toString())) {
                    V4VerificationCodeDialog.this.mDialog.dismiss();
                    V4VerificationCodeDialog.this.mListener.onConfirm(V4VerificationCodeDialog.this.etVerification.getText().toString(), V4VerificationCodeDialog.this.captchaKey);
                } else {
                    ToastUtils.show(V4VerificationCodeDialog.this.mActivity, "请输入验证码");
                }
            }
        });
    }

    private void getCodeOnclick() {
        this.tvGetCode.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.dialog.V4VerificationCodeDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                V4VerificationCodeDialog.this.getCode();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCode() {
        LogUtil.e(TAG, "getV3code" + this.isStart);
        if (this.isStart) {
            return;
        }
        V4BusinessControllers.getInstance().getLoginCodeImage(this.mAccount, new client.android.yixiaotong.controller.core.Listener<V4ImageCodeBean>() { // from class: client.android.yixiaotong.v4.ui.dialog.V4VerificationCodeDialog.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                V4VerificationCodeDialog.this.isStart = true;
                V4VerificationCodeDialog.this.tvGetCode.setVisibility(8);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4ImageCodeBean v4ImageCodeBean, Object... objArr) {
                V4VerificationCodeDialog.this.isStart = false;
                if (V4VerificationCodeDialog.this.mDialog == null || !V4VerificationCodeDialog.this.mDialog.isShowing() || V4VerificationCodeDialog.this.mActivity == null) {
                    return;
                }
                V4VerificationCodeDialog.this.captchaKey = v4ImageCodeBean.captchaKey;
                byte[] bArrDecode = Base64.decode(v4ImageCodeBean.captcha, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                float appScreenDensity = AppUtils.getAppScreenDensity(V4VerificationCodeDialog.this.mActivity);
                int i = (int) (80.0f * appScreenDensity);
                LogUtil.e(V4VerificationCodeDialog.TAG, appScreenDensity + "  " + i);
                V4VerificationCodeDialog.this.ivCode.setImageBitmap(BitmapUtil.scaleBitmap(bitmapDecodeByteArray, i, (int) (appScreenDensity * 40.0f)));
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                V4VerificationCodeDialog.this.isStart = false;
                if (V4VerificationCodeDialog.this.mDialog == null || !V4VerificationCodeDialog.this.mDialog.isShowing() || V4VerificationCodeDialog.this.mActivity == null) {
                    return;
                }
                V4VerificationCodeDialog.this.tvGetCode.setVisibility(0);
                V4VerificationCodeDialog.this.onError(clientException);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        this.mDialog.dismiss();
    }
}
