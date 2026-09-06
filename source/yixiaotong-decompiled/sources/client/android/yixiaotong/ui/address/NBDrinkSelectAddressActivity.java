package client.android.yixiaotong.ui.address;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import com.hihonor.adsdk.base.g.j.e.a;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class NBDrinkSelectAddressActivity extends BaseActivity {
    public static final String EXTRAS_FROM = "from";
    public static final String EXTRAS_TONEXT = "tonext";
    public static final int EXTRA_FROMAPPLICATION = 1;
    public static final int EXTRA_FROMINIT = 0;
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final int requestCode = 2;
    private LocalPreferencesHelper localPreferencesHelper;
    private Button mFinish;
    private String mId;
    private String mId1;
    private String mId2;
    private RelativeLayout mRelLoudong;
    private RelativeLayout mRelQuyu;
    private TitleBar mTitleBar;
    private TextView mTvAddress1;
    private TextView mTvAddress2;
    private WalletModel mWalletModel;
    private int mFlag = 0;
    private int mFrom = -1;
    private int mToNext = -1;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(6171);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) NBDrinkSelectAddressActivity.class);
            intent.putExtra("from", i);
            activity.startActivityForResult(intent, 2);
        }
    }

    public static void launch(Activity activity, int i, int i2, WalletModel walletModel) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) NBDrinkSelectAddressActivity.class);
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

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.address.NBDrinkSelectAddressActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NBDrinkAddressActivity.launch(NBDrinkSelectAddressActivity.this.getActivity(), 1, NBDrinkSelectAddressActivity.this.mId);
            NBDrinkSelectAddressActivity.this.mTvAddress2.setText("请选择安装地址");
            NBDrinkSelectAddressActivity.this.mFlag = 1;
            NBDrinkSelectAddressActivity.this.mId = "";
            NBDrinkSelectAddressActivity.this.mId1 = "";
            NBDrinkSelectAddressActivity.this.localPreferencesHelper.saveOrUpdate("id2_" + NBDrinkSelectAddressActivity.this.getLoginAccount().getUid(), "");
            NBDrinkSelectAddressActivity.this.localPreferencesHelper.saveOrUpdate("address2_" + NBDrinkSelectAddressActivity.this.getLoginAccount().getUid(), "");
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.address.NBDrinkSelectAddressActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NBDrinkSelectAddressActivity.this.mFlag > 0) {
                NBDrinkAddressActivity.launch(NBDrinkSelectAddressActivity.this.getActivity(), 2, NBDrinkSelectAddressActivity.this.mId1);
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.address.NBDrinkSelectAddressActivity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NBDrinkSelectAddressActivity.this.mFrom == 0) {
                if (NBDrinkSelectAddressActivity.this.mFlag != 2) {
                    ToastUtils.show(NBDrinkSelectAddressActivity.this.getActivity(), "请检查是否还有地址没选择！");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(a.G0, NBDrinkSelectAddressActivity.this.mTvAddress1.getText().toString() + NBDrinkSelectAddressActivity.this.mTvAddress2.getText().toString());
                intent.putExtra("id", NBDrinkSelectAddressActivity.this.mId);
                NBDrinkSelectAddressActivity.this.setResult(2, intent);
                NBDrinkSelectAddressActivity.this.finish();
                return;
            }
            int unused = NBDrinkSelectAddressActivity.this.mFrom;
        }
    }

    private void initView() {
        String string = this.localPreferencesHelper.getString("id1_" + getLoginAccount().getUid());
        String string2 = this.localPreferencesHelper.getString("id2_" + getLoginAccount().getUid());
        String string3 = this.localPreferencesHelper.getString("address1_" + getLoginAccount().getUid());
        String string4 = this.localPreferencesHelper.getString("address2_" + getLoginAccount().getUid());
        if (StringUtils.isNotEmpty(string) && StringUtils.isNotEmpty(string3)) {
            this.mTvAddress1.setText(string3);
            this.mFlag = 1;
            this.mId = string;
            this.mId1 = string;
        }
        if (StringUtils.isNotEmpty(string2) && StringUtils.isNotEmpty(string4)) {
            this.mTvAddress2.setText(string4);
            this.mFlag = 2;
            this.mId = string2;
            this.mId1 = string2;
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
        this.mTitleBar.setTitleView("选择地址");
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
                this.localPreferencesHelper.saveOrUpdate("id1_" + getLoginAccount().getUid(), stringExtra2);
                this.localPreferencesHelper.saveOrUpdate("address1_" + getLoginAccount().getUid(), stringExtra);
                this.mId1 = stringExtra2;
                this.mTvAddress1.setText(stringExtra);
                this.mFlag = 1;
                return;
            }
            if (i2 != 2) {
                return;
            }
            this.localPreferencesHelper.saveOrUpdate("id2_" + getLoginAccount().getUid(), stringExtra2);
            this.localPreferencesHelper.saveOrUpdate("address2_" + getLoginAccount().getUid(), stringExtra);
            this.mId2 = stringExtra2;
            this.mTvAddress2.setText(stringExtra);
            this.mFlag = 2;
        }
    }
}
