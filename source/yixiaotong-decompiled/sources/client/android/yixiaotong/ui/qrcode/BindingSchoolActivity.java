package client.android.yixiaotong.ui.qrcode;

import android.app.Activity;
import android.content.Intent;
import client.android.yixiaotong.BaseActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BindingSchoolActivity extends BaseActivity {
    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BindingSchoolActivity.class));
        }
    }
}
