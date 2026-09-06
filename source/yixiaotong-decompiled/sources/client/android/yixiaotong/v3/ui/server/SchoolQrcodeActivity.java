package client.android.yixiaotong.v3.ui.server;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.bean.login.SchoolQrcodeBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SchoolQrcodeActivity extends BaseActivity {
    private boolean mIsEnable = true;
    private ImageView mIvQrcode;
    private String mSchoolId;
    private String mSchoolName;
    private TitleBar mTitleBar;
    private TextView mTvSchoolName;

    static {
        StubApp.interface11(10229);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) SchoolQrcodeActivity.class).putExtra("schoolid", str).putExtra("schoolname", str2));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mIvQrcode = (ImageView) findViewById(R.id.iv_qrcode);
        this.mTvSchoolName = (TextView) findViewById(R.id.tv_schoolname);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.schoolqrcode));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvSchoolName.setText(this.mSchoolName);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    private void getQrcode() {
        V3BusinessControllers.getInstance().getQRCodeBySchoolId(getLoginAccount(), this.mSchoolId, new Listener<SchoolQrcodeBean>() { // from class: client.android.yixiaotong.v3.ui.server.SchoolQrcodeActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(SchoolQrcodeActivity.this.getActivity(), "获取学校二维码.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SchoolQrcodeBean schoolQrcodeBean, Object... objArr) {
                Bitmap bitmapBuildBitmap;
                if (SchoolQrcodeActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    try {
                        bitmapBuildBitmap = ScanUtil.buildBitmap(schoolQrcodeBean.QRCode, 0, SchoolQrcodeActivity.this.mIvQrcode.getWidth(), SchoolQrcodeActivity.this.mIvQrcode.getHeight(), new HmsBuildBitmapOption.Creator().setBitmapMargin(1).setBitmapColor(-16777216).setBitmapBackgroundColor(-1).create());
                    } catch (WriterException e) {
                        e.printStackTrace();
                        bitmapBuildBitmap = null;
                    }
                    if (bitmapBuildBitmap != null) {
                        SchoolQrcodeActivity.this.mIvQrcode.setImageBitmap(bitmapBuildBitmap);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (SchoolQrcodeActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (!clientException.isNeedTip(clientException.getCode())) {
                        SchoolQrcodeActivity.this.onError(clientException);
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(SchoolQrcodeActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.server.SchoolQrcodeActivity.1.1
                            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                            public void onConfirm() {
                                SchoolQrcodeActivity.this.finish();
                            }
                        }, clientException.getDetail());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        finish();
    }
}
