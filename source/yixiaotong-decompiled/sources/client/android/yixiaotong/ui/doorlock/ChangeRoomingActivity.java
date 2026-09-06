package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ChangeRoomingActivity extends BaseActivity {
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(6927);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ChangeRoomingActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getResources().getString(R.string.changeroom));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }
}
