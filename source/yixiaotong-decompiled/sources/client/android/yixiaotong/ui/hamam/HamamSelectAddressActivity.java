package client.android.yixiaotong.ui.hamam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.hamam.HamamBindBean;
import client.android.yixiaotong.controller.bean.hamam.HamamBindPreBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.drinkwater.AlertIosDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.random.RandomUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.hihonor.adsdk.base.g.j.e.a;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HamamSelectAddressActivity extends BaseActivity {
    public static final String EXTRAS_FROM = "from";
    public static final String EXTRAS_TONEXT = "tonext";
    public static final int EXTRA_FROMAPPLICATION = 1;
    public static final int EXTRA_FROMINIT = 0;
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final int requestCode = 2;
    Button mFinish;
    private String mId;
    private String mId1;
    private String mId2;
    RelativeLayout mRelLoudong;
    RelativeLayout mRelQuyu;
    TitleBar mTitleBar;
    TextView mTvAddress1;
    TextView mTvAddress2;
    private WalletModel mWalletModel;
    private int mFlag = 0;
    private int mFrom = -1;
    private int mToNext = -1;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(AVMDLDataLoader.KeyIsSetGlobalSpeedSampleInterval);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) HamamSelectAddressActivity.class);
            intent.putExtra("from", i);
            activity.startActivityForResult(intent, 2);
        }
    }

    public static void launch(Activity activity, int i, int i2, WalletModel walletModel) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) HamamSelectAddressActivity.class);
            intent.putExtra("from", i);
            intent.putExtra("tonext", i2);
            intent.putExtra("extra_wallet", walletModel);
            activity.startActivityForResult(intent, 2);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mRelQuyu = (RelativeLayout) findViewById(R.id.rel_quyu);
        this.mRelLoudong = (RelativeLayout) findViewById(R.id.rel_loudong);
        this.mTvAddress1 = (TextView) findViewById(R.id.tv_address1);
        this.mTvAddress2 = (TextView) findViewById(R.id.tv_address2);
        this.mFinish = (Button) findViewById(R.id.v_btn_next);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.hamam.HamamSelectAddressActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HamamAddressActivity.launch(HamamSelectAddressActivity.this.getActivity(), 1, HamamSelectAddressActivity.this.mId);
            HamamSelectAddressActivity.this.mTvAddress2.setText("请选择浴室");
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.hamam.HamamSelectAddressActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HamamSelectAddressActivity.this.mFlag > 0) {
                if (HamamSelectAddressActivity.this.mFrom == 0) {
                    HamamZaoTangAddressActivity.launch(HamamSelectAddressActivity.this.getActivity(), 2, HamamSelectAddressActivity.this.mId1, true);
                } else {
                    HamamZaoTangAddressActivity.launch(HamamSelectAddressActivity.this.getActivity(), 2, HamamSelectAddressActivity.this.mId1);
                }
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.hamam.HamamSelectAddressActivity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HamamSelectAddressActivity.this.mFrom == 0) {
                if (HamamSelectAddressActivity.this.mFlag != 2) {
                    ToastUtils.show(HamamSelectAddressActivity.this.getActivity(), "请检查是否还有地址没选择！");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(a.G0, HamamSelectAddressActivity.this.mTvAddress1.getText().toString() + HamamSelectAddressActivity.this.mTvAddress2.getText().toString());
                intent.putExtra("id", HamamSelectAddressActivity.this.mId);
                HamamSelectAddressActivity.this.setResult(2, intent);
                HamamSelectAddressActivity.this.finish();
                return;
            }
            if (HamamSelectAddressActivity.this.mFrom == 1) {
                if (HamamSelectAddressActivity.this.mFlag == 2) {
                    HamamSelectAddressActivity.this.bindHamam();
                } else {
                    ToastUtils.show(HamamSelectAddressActivity.this.getActivity(), "请检查是否还有地址没选择！");
                }
            }
        }
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

    private void initTitleBar() {
        this.mTitleBar.setTitleView("绑定浴室");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("name");
            String stringExtra2 = intent.getStringExtra("id");
            this.mId = stringExtra2;
            if (i2 == 1) {
                this.mId1 = stringExtra2;
                this.mTvAddress1.setText(stringExtra);
                this.mFlag = 1;
            } else {
                if (i2 != 2) {
                    return;
                }
                this.mId2 = stringExtra2;
                this.mTvAddress2.setText(stringExtra);
                this.mFlag = 2;
            }
        }
    }

    private void bindHamamPre() {
        String strSubstring = getLoginAccount().getIdentityId().substring(10, 14);
        String authorizedPassword = LocalBusinessStore.getAuthorizedPassword(getContext(), getLoginAccount().getUid());
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().bindBathHouseFront(getLoginAccount(), strSubstring + authorizedPassword, randNumMaxStringNonO, new Listener<HamamBindPreBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamSelectAddressActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, HamamBindPreBean hamamBindPreBean, Object... objArr) {
                if (hamamBindPreBean.rand.equals(randNumMaxStringNonO) && hamamBindPreBean.status == 1) {
                    HamamSelectAddressActivity.this.bindHamam();
                } else {
                    new AlertIosDialog(HamamSelectAddressActivity.this.getActivity()).builder(R.style.AlertDialogStyle).setMsg("您不能绑定浴室！").setPositiveButton("确定", new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamSelectAddressActivity.4.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            HamamSelectAddressActivity.this.finish();
                        }
                    }, -16776961).setCancleable(false).show();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                new AlertIosDialog(HamamSelectAddressActivity.this.getActivity()).builder(R.style.AlertDialogStyle).setMsg(clientException.getDetail()).setPositiveButton("确定", new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamSelectAddressActivity.4.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        HamamSelectAddressActivity.this.finish();
                    }
                }, -16776961).setCancleable(false).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindHamam() {
        RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().hamamBindingRoom(getLoginAccount(), this.mId, new Listener<HamamBindBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamSelectAddressActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, HamamBindBean hamamBindBean, Object... objArr) {
                if (HamamSelectAddressActivity.this.mIsEnable) {
                    if (hamamBindBean != null) {
                        ToastUtils.show(HamamSelectAddressActivity.this.getActivity(), "浴室绑定成功！");
                        LocalBusinessStore.saveHamamRoomId(HamamSelectAddressActivity.this.getContext(), HamamSelectAddressActivity.this.getLoginAccount().getUid(), HamamSelectAddressActivity.this.mId);
                        if (HamamSelectAddressActivity.this.mToNext == 2) {
                            Intent intent = new Intent();
                            intent.putExtra(a.G0, HamamSelectAddressActivity.this.mTvAddress2.getText().toString());
                            intent.putExtra("id", HamamSelectAddressActivity.this.mId);
                            HamamSelectAddressActivity.this.setResult(4, intent);
                        }
                    } else {
                        ToastUtils.show(HamamSelectAddressActivity.this.getActivity(), "浴室绑定失败！");
                    }
                    HamamSelectAddressActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamSelectAddressActivity.this.mIsEnable) {
                    if (clientException.getCode() == 4127) {
                        ToastUtils.show(HamamSelectAddressActivity.this.getActivity(), "浴室绑定成功");
                        HamamSelectAddressActivity.this.setResult(5, new Intent());
                        LocalBusinessStore.saveHamamRoomId(HamamSelectAddressActivity.this.getContext(), HamamSelectAddressActivity.this.getLoginAccount().getUid(), clientException.getDetail());
                        HamamSelectAddressActivity.this.finish();
                        return;
                    }
                    SystemErrorTip.getInstance().showTipDialog(HamamSelectAddressActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.hamam.HamamSelectAddressActivity.5.1
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            HamamSelectAddressActivity.this.finish();
                        }
                    }, clientException.getDetail());
                }
            }
        });
    }
}
