package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.address.SelectRoomAddressActivity;
import client.android.yixiaotong.ui.dialog.ChangeRoomTipDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import com.hihonor.adsdk.base.g.j.e.a;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ChangeRoomActivity extends BaseActivity {
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final int RESULTCODE = 2;
    private boolean mIsEnable = true;
    private String mRoomId;
    private TitleBar mTitleBar;
    private TextView mTvChangeRoomAddress;
    private TextView mTvRoomAddress;
    private WalletModel mWalletModel;

    static {
        StubApp.interface11(6926);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ChangeRoomActivity.class).putExtra("extra_wallet", walletModel));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvRoomAddress = (TextView) findViewById(R.id.tv_roomaddress);
        this.mTvChangeRoomAddress = (TextView) findViewById(R.id.tv_changeroomaddress);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getResources().getString(R.string.changeroom));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvRoomAddress.setText(LocalBusinessStore.getDoorLockRoomAddress(getContext()));
    }

    private void initClickListeners() {
        findViewById(R.id.tv_changeroomaddress).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.ChangeRoomActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m100x92ab7553(view);
            }
        });
        findViewById(R.id.btn_changeroom).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.ChangeRoomActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m101x1f988c72(view);
            }
        });
        findViewById(R.id.tv_tip).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.ChangeRoomActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m102xac85a391(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-doorlock-ChangeRoomActivity, reason: not valid java name */
    /* synthetic */ void m100x92ab7553(View view) {
        SelectRoomAddressActivity.launch(getActivity(), this.mWalletModel);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-ui-doorlock-ChangeRoomActivity, reason: not valid java name */
    /* synthetic */ void m101x1f988c72(View view) {
        if (StringUtils.isNotEmpty(this.mRoomId)) {
            changeRoom();
        } else {
            ToastUtils.show(getContext(), "请选择更换房间");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-ui-doorlock-ChangeRoomActivity, reason: not valid java name */
    /* synthetic */ void m102xac85a391(View view) {
        new ChangeRoomTipDialog().showTipDialog(getActivity());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != 2 || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(a.G0);
        this.mRoomId = intent.getStringExtra("id");
        this.mTvChangeRoomAddress.setText(stringExtra);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void changeRoom() {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().getDoorLockChangeRoom(getLoginAccount(), this.mWalletModel.typeId, randNumMaxString, LocalBusinessStore.getDoorLockRoomid(getContext()), this.mRoomId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.doorlock.ChangeRoomActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (ChangeRoomActivity.this.mIsEnable) {
                    if (successBean == null || !successBean.random.equals(randNumMaxString)) {
                        SystemErrorTip.getInstance().showTipDialog(ChangeRoomActivity.this.getActivity(), "更换失败");
                    } else {
                        ChangeRoomingActivity.launch(ChangeRoomActivity.this.getActivity());
                        ChangeRoomActivity.this.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ChangeRoomActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(ChangeRoomActivity.this.getActivity(), ChangeRoomActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }
}
