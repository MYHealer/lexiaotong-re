package client.android.yixiaotong.v4.ui.user;

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
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4SchoolQrcodeActivity extends BaseActivity {
    private boolean mIsEnable = true;
    private ImageView mIvQrcode;
    private TitleBar mTitleBar;
    private TextView mTvSchoolName;

    static {
        StubApp.interface11(11065);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4SchoolQrcodeActivity.class));
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
        this.mTvSchoolName.setText(V4UserInfoUtil.getInstance().getLoginAccountV4().customerName);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().onPause();
    }

    private void getSchoolQrCode() {
        V4BusinessControllers.getInstance().getSchoolQrCode(getLoginAccount(), new Listener<String>() { // from class: client.android.yixiaotong.v4.ui.user.V4SchoolQrcodeActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4SchoolQrcodeActivity.this.getActivity(), "获取学校二维码.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str, Object... objArr) {
                Bitmap bitmapBuildBitmap;
                if (V4SchoolQrcodeActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    try {
                        bitmapBuildBitmap = ScanUtil.buildBitmap(str, 0, V4SchoolQrcodeActivity.this.mIvQrcode.getWidth(), V4SchoolQrcodeActivity.this.mIvQrcode.getHeight(), new HmsBuildBitmapOption.Creator().setBitmapMargin(1).setBitmapColor(-16777216).setBitmapBackgroundColor(-1).create());
                    } catch (WriterException e) {
                        e.printStackTrace();
                        bitmapBuildBitmap = null;
                    }
                    if (bitmapBuildBitmap != null) {
                        V4SchoolQrcodeActivity.this.mIvQrcode.setImageBitmap(bitmapBuildBitmap);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4SchoolQrcodeActivity.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4SchoolQrcodeActivity.this.getActivity(), true);
                }
            }
        });
    }
}
