package client.android.yixiaotong.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AESHelper;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import com.google.gson.Gson;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class SchoolCodeActivity extends BaseActivity {
    public static final String EXTRA_SCHOOL_ID = "extra_school_id";
    public static final String EXTRA_SCHOOL_NAME = "extra_school_name";
    ImageView codeView;
    TextView mVSchoolName;
    TitleBar mVTitleBar;

    static {
        StubApp.interface11(6066);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mVSchoolName = (TextView) findViewById(R.id.tv_school_name);
        this.codeView = (ImageView) findViewById(R.id.simple_drawee_view);
    }

    public static void launch(Activity activity, long j, String str) {
        Intent intent = new Intent(activity, (Class<?>) SchoolCodeActivity.class);
        intent.putExtra(EXTRA_SCHOOL_NAME, str);
        intent.putExtra(EXTRA_SCHOOL_ID, j);
        activity.startActivity(intent);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        initData();
    }

    class SchoolInfo {
        public long schoolId;
        public String schoolName;

        SchoolInfo() {
        }
    }

    private void initData() {
        String strSimpleEncrypt;
        String stringExtra = getIntent().getStringExtra(EXTRA_SCHOOL_NAME);
        long longExtra = getIntent().getLongExtra(EXTRA_SCHOOL_ID, -1L);
        SchoolInfo schoolInfo = new SchoolInfo();
        schoolInfo.schoolName = stringExtra;
        schoolInfo.schoolId = longExtra;
        try {
            strSimpleEncrypt = AESHelper.simpleEncrypt(new Gson().toJson(schoolInfo), StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
        } catch (Exception e) {
            e.printStackTrace();
            strSimpleEncrypt = "";
        }
        if (StringUtils.isNotEmpty(stringExtra)) {
            this.mVSchoolName.setText(stringExtra);
        }
        if (longExtra > -1) {
            refreshQrcode(strSimpleEncrypt);
        }
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("学校二维码");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void refreshQrcode(final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.SchoolCodeActivity.1
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmapBuildBitmap;
                try {
                    bitmapBuildBitmap = ScanUtil.buildBitmap(str, 0, SchoolCodeActivity.this.codeView.getWidth(), SchoolCodeActivity.this.codeView.getHeight(), new HmsBuildBitmapOption.Creator().setBitmapMargin(1).setBitmapColor(-16777216).setBitmapBackgroundColor(-1).create());
                } catch (WriterException e) {
                    e.printStackTrace();
                    bitmapBuildBitmap = null;
                }
                if (bitmapBuildBitmap != null) {
                    SchoolCodeActivity.this.codeView.setImageBitmap(bitmapBuildBitmap);
                }
            }
        });
    }
}
