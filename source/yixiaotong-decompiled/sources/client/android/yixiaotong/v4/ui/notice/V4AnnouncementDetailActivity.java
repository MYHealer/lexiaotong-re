package client.android.yixiaotong.v4.ui.notice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v4.http.bean.V4NoticeInfoBean;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4AnnouncementDetailActivity extends BaseActivity {
    TitleBar mTitleBar;
    TextView mTvContent;
    TextView mTvTitle;
    private V4NoticeInfoBean mV4NoticeInfoBean;

    static {
        StubApp.interface11(10943);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, V4NoticeInfoBean v4NoticeInfoBean) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) V4AnnouncementDetailActivity.class);
            intent.putExtra("bean", v4NoticeInfoBean);
            activity.startActivity(intent);
        }
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.announcementinformation));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }
}
