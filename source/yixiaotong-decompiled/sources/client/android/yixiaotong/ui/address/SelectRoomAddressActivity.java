package client.android.yixiaotong.ui.address;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.ammeter.AmmeterAddressActivity;
import client.android.yixiaotong.ui.dialog.AppTipDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import com.afollestad.materialdialogs.MaterialDialog;
import com.hihonor.adsdk.base.g.j.e.a;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class SelectRoomAddressActivity extends BaseActivity {
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final int requestCode = 2;
    LocalPreferencesHelper localPreferencesHelper;
    private Button mFinish;
    private int mFlag = 0;
    private String mId;
    private String mId1;
    private String mId2;
    private String mId3;
    private String mId4;
    private MaterialDialog mMaterialDialog;
    private RelativeLayout mRelFandhao;
    private RelativeLayout mRelLouCeng;
    private RelativeLayout mRelLoudong;
    private RelativeLayout mRelQuyu;
    private TitleBar mTitleBar;
    private TextView mTvAddress1;
    private TextView mTvAddress2;
    private TextView mTvAddress3;
    private TextView mTvAddress4;
    private WalletModel mWalletModel;

    static {
        StubApp.interface11(6179);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) SelectRoomAddressActivity.class);
            intent.putExtra("extra_wallet", walletModel);
            activity.startActivityForResult(intent, 2);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mRelQuyu = (RelativeLayout) findViewById(R.id.rel_quyu);
        this.mRelLoudong = (RelativeLayout) findViewById(R.id.rel_loudong);
        this.mRelLouCeng = (RelativeLayout) findViewById(R.id.rel_loucheng);
        this.mRelFandhao = (RelativeLayout) findViewById(R.id.rel_fanghao);
        this.mTvAddress1 = (TextView) findViewById(R.id.tv_address1);
        this.mTvAddress2 = (TextView) findViewById(R.id.tv_address2);
        this.mTvAddress3 = (TextView) findViewById(R.id.tv_address3);
        this.mTvAddress4 = (TextView) findViewById(R.id.tv_address4);
        this.mFinish = (Button) findViewById(R.id.v_btn_next);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.address.SelectRoomAddressActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectRoomAddressActivity.this.mFlag = 0;
            AmmeterAddressActivity.launch(SelectRoomAddressActivity.this.getActivity(), 1, SelectRoomAddressActivity.this.mId);
            SelectRoomAddressActivity.this.mTvAddress2.setText("请选择楼栋");
            SelectRoomAddressActivity.this.mTvAddress3.setText("请选择楼层");
            SelectRoomAddressActivity.this.mTvAddress4.setText("请选择房号");
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.address.SelectRoomAddressActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SelectRoomAddressActivity.this.mFlag > 0 && StringUtils.isNotEmpty(SelectRoomAddressActivity.this.mId1)) {
                AmmeterAddressActivity.launch(SelectRoomAddressActivity.this.getActivity(), 2, SelectRoomAddressActivity.this.mId1);
                SelectRoomAddressActivity.this.mTvAddress3.setText("请选择楼层");
                SelectRoomAddressActivity.this.mTvAddress4.setText("请选择房号");
            } else if (StringUtils.isNotEmpty(SelectRoomAddressActivity.this.localPreferencesHelper.getString("quyuid" + SelectRoomAddressActivity.this.getLoginAccount().getUid()))) {
                AmmeterAddressActivity.launch(SelectRoomAddressActivity.this.getActivity(), 2, SelectRoomAddressActivity.this.localPreferencesHelper.getString("quyuid" + SelectRoomAddressActivity.this.getLoginAccount().getUid()));
                SelectRoomAddressActivity.this.mTvAddress3.setText("请选择楼层");
                SelectRoomAddressActivity.this.mTvAddress4.setText("请选择房号");
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.address.SelectRoomAddressActivity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SelectRoomAddressActivity.this.mFlag > 1 && StringUtils.isNotEmpty(SelectRoomAddressActivity.this.mId2)) {
                AmmeterAddressActivity.launch(SelectRoomAddressActivity.this.getActivity(), 3, SelectRoomAddressActivity.this.mId2);
                SelectRoomAddressActivity.this.mTvAddress4.setText("请选择房号");
            } else if (StringUtils.isNotEmpty(SelectRoomAddressActivity.this.localPreferencesHelper.getString("loudongid" + SelectRoomAddressActivity.this.getLoginAccount().getUid()))) {
                AmmeterAddressActivity.launch(SelectRoomAddressActivity.this.getActivity(), 3, SelectRoomAddressActivity.this.localPreferencesHelper.getString("loudongid" + SelectRoomAddressActivity.this.getLoginAccount().getUid()));
                SelectRoomAddressActivity.this.mTvAddress4.setText("请选择房号");
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.address.SelectRoomAddressActivity$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SelectRoomAddressActivity.this.mFlag > 2 && StringUtils.isNotEmpty(SelectRoomAddressActivity.this.mId3)) {
                AmmeterAddressActivity.launch(SelectRoomAddressActivity.this.getActivity(), 4, SelectRoomAddressActivity.this.mId3);
            } else if (StringUtils.isNotEmpty(SelectRoomAddressActivity.this.localPreferencesHelper.getString("loucengid" + SelectRoomAddressActivity.this.getLoginAccount().getUid()))) {
                AmmeterAddressActivity.launch(SelectRoomAddressActivity.this.getActivity(), 4, SelectRoomAddressActivity.this.localPreferencesHelper.getString("loucengid" + SelectRoomAddressActivity.this.getLoginAccount().getUid()));
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.address.SelectRoomAddressActivity$5, reason: invalid class name */
    class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectRoomAddressActivity.this.showConfirmDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConfirmDialog() {
        new AppTipDialog().showTipDialog(getActivity(), new AppTipDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.address.SelectRoomAddressActivity.6
            @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
            public void onCanle() {
            }

            @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
            public void onConfirt() {
                SelectRoomAddressActivity.this.clickConfirmButton();
            }
        }, "请核对信息后确认", "再看看", "确认");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickConfirmButton() {
        if ((this.mFlag == 4 || StringUtils.isNotEmpty(this.localPreferencesHelper.getString("qinshiid" + getLoginAccount().getUid()))) && !this.mTvAddress4.getText().toString().contains("请选择") && !this.mTvAddress3.getText().toString().contains("请选择") && !this.mTvAddress2.getText().toString().contains("请选择") && !this.mTvAddress1.getText().toString().contains("请选择")) {
            Intent intent = new Intent();
            intent.putExtra(a.G0, this.mTvAddress1.getText().toString() + this.mTvAddress2.getText().toString() + this.mTvAddress3.getText().toString() + this.mTvAddress4.getText().toString());
            intent.putExtra("id", this.localPreferencesHelper.getString("qinshiid" + getLoginAccount().getUid()));
            setResult(2, intent);
            finish();
            return;
        }
        ToastUtils.show(getActivity(), "请检查是否还有地址没选择！");
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("选择区域");
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
                this.localPreferencesHelper.saveOrUpdate("quyu" + getLoginAccount().getUid(), this.mTvAddress1.getText().toString());
                this.localPreferencesHelper.saveOrUpdate("loudong" + getLoginAccount().getUid(), "");
                this.localPreferencesHelper.saveOrUpdate("louceng" + getLoginAccount().getUid(), "");
                this.localPreferencesHelper.saveOrUpdate("qinshi" + getLoginAccount().getUid(), "");
                this.localPreferencesHelper.saveOrUpdate("quyuid" + getLoginAccount().getUid(), this.mId1);
                this.localPreferencesHelper.saveOrUpdate("loudongid" + getLoginAccount().getUid(), "");
                this.localPreferencesHelper.saveOrUpdate("loucengid" + getLoginAccount().getUid(), "");
                this.localPreferencesHelper.saveOrUpdate("qinshiid" + getLoginAccount().getUid(), "");
                return;
            }
            if (i2 == 2) {
                this.mId2 = stringExtra2;
                this.mTvAddress2.setText(stringExtra);
                this.mFlag = 2;
                this.localPreferencesHelper.saveOrUpdate("loudong" + getLoginAccount().getUid(), this.mTvAddress2.getText().toString());
                this.localPreferencesHelper.saveOrUpdate("louceng" + getLoginAccount().getUid(), "");
                this.localPreferencesHelper.saveOrUpdate("qinshi" + getLoginAccount().getUid(), "");
                this.localPreferencesHelper.saveOrUpdate("loudongid" + getLoginAccount().getUid(), this.mId2);
                this.localPreferencesHelper.saveOrUpdate("loucengid" + getLoginAccount().getUid(), "");
                this.localPreferencesHelper.saveOrUpdate("qinshiid" + getLoginAccount().getUid(), "");
                return;
            }
            if (i2 != 3) {
                if (i2 != 4) {
                    return;
                }
                this.mId4 = stringExtra2;
                this.mTvAddress4.setText(stringExtra);
                this.mFlag = 4;
                this.localPreferencesHelper.saveOrUpdate("qinshi" + getLoginAccount().getUid(), this.mTvAddress4.getText().toString());
                this.localPreferencesHelper.saveOrUpdate("qinshiid" + getLoginAccount().getUid(), this.mId4);
                return;
            }
            this.mId3 = stringExtra2;
            this.mTvAddress3.setText(stringExtra);
            this.mFlag = 3;
            this.localPreferencesHelper.saveOrUpdate("louceng" + getLoginAccount().getUid(), this.mTvAddress3.getText().toString());
            this.localPreferencesHelper.saveOrUpdate("qinshi" + getLoginAccount().getUid(), "");
            this.localPreferencesHelper.saveOrUpdate("loucengid" + getLoginAccount().getUid(), this.mId3);
            this.localPreferencesHelper.saveOrUpdate("qinshiid" + getLoginAccount().getUid(), "");
        }
    }

    private void dismissDialog() {
        try {
            if (isShowingDialog()) {
                this.mMaterialDialog.dismiss();
                this.mMaterialDialog = null;
            }
        } catch (Exception unused) {
        }
    }

    private boolean isShowingDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        return materialDialog != null && materialDialog.isShowing();
    }

    private void showDialog(String str) {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(getActivity()).content("正在搜索" + str).progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.address.SelectRoomAddressActivity.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            }).show();
            this.mMaterialDialog = materialDialogShow;
            materialDialogShow.setCanceledOnTouchOutside(false);
        } catch (Exception unused) {
        }
    }
}
