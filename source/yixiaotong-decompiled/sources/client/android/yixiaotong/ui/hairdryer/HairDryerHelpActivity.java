package client.android.yixiaotong.ui.hairdryer;

import android.os.Bundle;
import android.view.MotionEvent;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HairDryerHelpActivity extends BaseActivity {
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(AVMDLDataLoader.KeyIsPlayInfoLoadPercent);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initTitleBar() {
        TitleBar titleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTitleBar = titleBar;
        titleBar.setTitleView("帮助");
        this.mTitleBar.setGravity(10);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || action == 1 || action == 2) {
            finish();
        }
        return super.onTouchEvent(motionEvent);
    }
}
