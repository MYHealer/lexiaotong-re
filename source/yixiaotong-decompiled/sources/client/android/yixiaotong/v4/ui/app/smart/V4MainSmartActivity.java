package client.android.yixiaotong.v4.ui.app.smart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4MainSmartActivity extends BaseActivity {
    private static final String TAG = "V4MainSmartActivity";
    TitleBar mTitleBar;

    static {
        StubApp.interface11(10815);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4MainSmartActivity.class));
        }
    }

    private void initTitleBar() {
        TitleBar titleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTitleBar = titleBar;
        titleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setTitleView("智慧宿舍");
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }
}
