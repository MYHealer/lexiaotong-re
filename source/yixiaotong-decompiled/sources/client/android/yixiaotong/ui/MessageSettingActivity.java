package client.android.yixiaotong.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.store.ClientDataManager;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class MessageSettingActivity extends BaseActivity {
    TitleBar mTitleBar;
    CheckBox vRbtMessageRemind;
    CheckBox vRbtSound;
    CheckBox vRbtVibrate;

    static {
        StubApp.interface11(5997);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.vRbtMessageRemind = (CheckBox) findViewById(R.id.v_rbt_message_remind);
        this.vRbtSound = (CheckBox) findViewById(R.id.v_rbt_sound);
        this.vRbtVibrate = (CheckBox) findViewById(R.id.v_rbt_vibrate);
        this.vRbtMessageRemind.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MessageSettingActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ClientDataManager.getInstance().saveOrUpdate(ClientDataManager.MESSAGE_REMIND, MessageSettingActivity.this.vRbtMessageRemind.isChecked());
            }
        });
        this.vRbtSound.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MessageSettingActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ClientDataManager.getInstance().saveOrUpdate(ClientDataManager.MESSAGE_SOUND, MessageSettingActivity.this.vRbtSound.isChecked());
            }
        });
        this.vRbtVibrate.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MessageSettingActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ClientDataManager.getInstance().saveOrUpdate(ClientDataManager.MESSAGE_REMIND, MessageSettingActivity.this.vRbtVibrate.isChecked());
            }
        });
    }

    public static void launch(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) MessageSettingActivity.class));
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("消息设置");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.vRbtMessageRemind.setChecked(ClientDataManager.getInstance().getBooleanDefaultFalse(ClientDataManager.MESSAGE_REMIND));
        this.vRbtSound.setChecked(ClientDataManager.getInstance().getBooleanDefaultFalse(ClientDataManager.MESSAGE_SOUND));
        this.vRbtVibrate.setChecked(ClientDataManager.getInstance().getBooleanDefaultTrue(ClientDataManager.MESSAGE_VIBRATE));
    }
}
