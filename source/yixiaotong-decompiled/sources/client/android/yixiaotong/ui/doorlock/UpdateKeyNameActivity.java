package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.doorlock.KeyBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UpdateKeyNameActivity extends BaseActivity {
    public static final String EXTRA_KEYBEAN = "extra_keybean";
    public static final String EXTRA_KEYNAME = "extra_keyname";
    private static final int MAXLENGTH = 6;
    private EditText mEtKeyName;
    private Boolean mIsEnable = true;
    private KeyBean mKeyBean;
    private String mKeyName;
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(7019);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, KeyBean keyBean, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) UpdateKeyNameActivity.class).putExtra(EXTRA_KEYBEAN, keyBean).putExtra(EXTRA_KEYNAME, str));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mEtKeyName = (EditText) findViewById(R.id.et_keyname);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getResources().getString(R.string.doorlock_updatekeyname));
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setRightView("保存");
        this.mTitleBar.setRightViewTextColor(-11645362);
        this.mTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.UpdateKeyNameActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateKeyNameActivity.this.updateName();
            }
        });
    }

    private void initView() {
        this.mEtKeyName.setText(this.mKeyName);
        EditText editText = this.mEtKeyName;
        editText.setSelection(editText.getText().toString().length());
        this.mEtKeyName.setFilters(new InputFilter[]{new EmojiExcludeFilter(), new InputFilter.LengthFilter(6)});
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
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateName() {
        if (StringUtils.isNotEmpty(this.mEtKeyName.getText().toString())) {
            final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
            BusinessControllers.getInstance().getDoorLockUpdateKeyName(getLoginAccount(), 10, randNumMaxString, this.mKeyBean.door_student_machine_key_id, LocalBusinessStore.getDoorLockRoomid(getContext()), LocalBusinessStore.getDoorLockMachineid(getContext()), this.mKeyBean.keyflag, this.mEtKeyName.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.doorlock.UpdateKeyNameActivity.2
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    if (UpdateKeyNameActivity.this.mIsEnable.booleanValue()) {
                        if (successBean == null || !successBean.random.equals(randNumMaxString)) {
                            SystemErrorTip.getInstance().showTipDialog(UpdateKeyNameActivity.this.getActivity(), "修改名称失败");
                        } else {
                            ToastUtils.show(UpdateKeyNameActivity.this.getContext(), "修改名称成功");
                            UpdateKeyNameActivity.this.finish();
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (UpdateKeyNameActivity.this.mIsEnable.booleanValue()) {
                        ErrorUtil.onFailResult(UpdateKeyNameActivity.this.getActivity(), UpdateKeyNameActivity.this.mTitleBar.getTitleViewContent(), clientException, false);
                    }
                }
            });
            return;
        }
        ToastUtils.show(getContext(), "名称不能为空！");
    }
}
