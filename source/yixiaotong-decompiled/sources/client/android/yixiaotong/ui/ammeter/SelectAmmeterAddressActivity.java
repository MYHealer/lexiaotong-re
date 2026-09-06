package client.android.yixiaotong.ui.ammeter;

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
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterBindRoomBean;
import client.android.yixiaotong.controller.bean.AmmeterBindingRoom;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.AppTipDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import client.android.yixiaotong.util.drinkwater.PreferenceUtil;
import com.afollestad.materialdialogs.MaterialDialog;
import com.hihonor.adsdk.base.g.j.e.a;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SelectAmmeterAddressActivity extends BaseActivity {
    public static final String EXTRAS_FROM = "from";
    public static final int EXTRA_FROMAPPLICATION = 1;
    public static final int EXTRA_FROMINIT = 0;
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final int requestCode = 2;
    LocalPreferencesHelper localPreferencesHelper;
    private Button mFinish;
    private int mFlag = 0;
    private int mFrom = -1;
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
        StubApp.interface11(6322);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) SelectAmmeterAddressActivity.class);
            intent.putExtra("from", i);
            activity.startActivityForResult(intent, 2);
        }
    }

    public static void launch(Activity activity, int i, WalletModel walletModel) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) SelectAmmeterAddressActivity.class);
            intent.putExtra("from", i);
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

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectAmmeterAddressActivity.this.mFlag = 0;
            AmmeterAddressActivity.launch(SelectAmmeterAddressActivity.this.getActivity(), 1, SelectAmmeterAddressActivity.this.mId);
            SelectAmmeterAddressActivity.this.mTvAddress2.setText("请选择楼栋");
            SelectAmmeterAddressActivity.this.mTvAddress3.setText("请选择楼层");
            SelectAmmeterAddressActivity.this.mTvAddress4.setText("请选择房号");
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SelectAmmeterAddressActivity.this.mFlag > 0 && StringUtils.isNotEmpty(SelectAmmeterAddressActivity.this.mId1)) {
                AmmeterAddressActivity.launch(SelectAmmeterAddressActivity.this.getActivity(), 2, SelectAmmeterAddressActivity.this.mId1);
                SelectAmmeterAddressActivity.this.mTvAddress3.setText("请选择楼层");
                SelectAmmeterAddressActivity.this.mTvAddress4.setText("请选择房号");
            } else if (StringUtils.isNotEmpty(SelectAmmeterAddressActivity.this.localPreferencesHelper.getString("quyuid" + SelectAmmeterAddressActivity.this.getLoginAccount().getUid()))) {
                AmmeterAddressActivity.launch(SelectAmmeterAddressActivity.this.getActivity(), 2, SelectAmmeterAddressActivity.this.localPreferencesHelper.getString("quyuid" + SelectAmmeterAddressActivity.this.getLoginAccount().getUid()));
                SelectAmmeterAddressActivity.this.mTvAddress3.setText("请选择楼层");
                SelectAmmeterAddressActivity.this.mTvAddress4.setText("请选择房号");
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SelectAmmeterAddressActivity.this.mFlag > 1 && StringUtils.isNotEmpty(SelectAmmeterAddressActivity.this.mId2)) {
                AmmeterAddressActivity.launch(SelectAmmeterAddressActivity.this.getActivity(), 3, SelectAmmeterAddressActivity.this.mId2);
                SelectAmmeterAddressActivity.this.mTvAddress4.setText("请选择房号");
            } else if (StringUtils.isNotEmpty(SelectAmmeterAddressActivity.this.localPreferencesHelper.getString("loudongid" + SelectAmmeterAddressActivity.this.getLoginAccount().getUid()))) {
                AmmeterAddressActivity.launch(SelectAmmeterAddressActivity.this.getActivity(), 3, SelectAmmeterAddressActivity.this.localPreferencesHelper.getString("loudongid" + SelectAmmeterAddressActivity.this.getLoginAccount().getUid()));
                SelectAmmeterAddressActivity.this.mTvAddress4.setText("请选择房号");
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SelectAmmeterAddressActivity.this.mFlag > 2 && StringUtils.isNotEmpty(SelectAmmeterAddressActivity.this.mId3)) {
                AmmeterAddressActivity.launch(SelectAmmeterAddressActivity.this.getActivity(), 4, SelectAmmeterAddressActivity.this.mId3);
            } else if (StringUtils.isNotEmpty(SelectAmmeterAddressActivity.this.localPreferencesHelper.getString("loucengid" + SelectAmmeterAddressActivity.this.getLoginAccount().getUid()))) {
                AmmeterAddressActivity.launch(SelectAmmeterAddressActivity.this.getActivity(), 4, SelectAmmeterAddressActivity.this.localPreferencesHelper.getString("loucengid" + SelectAmmeterAddressActivity.this.getLoginAccount().getUid()));
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity$5, reason: invalid class name */
    class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectAmmeterAddressActivity.this.showConfirmDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConfirmDialog() {
        new AppTipDialog().showTipDialog(getActivity(), new AppTipDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity.6
            @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
            public void onCanle() {
            }

            @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
            public void onConfirt() {
                SelectAmmeterAddressActivity.this.clickConfirmButton();
            }
        }, "请核对信息后确认", "再看看", "确认");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickConfirmButton() {
        int i = this.mFrom;
        if (i == 0) {
            if ((this.mFlag == 4 || StringUtils.isNotEmpty(this.localPreferencesHelper.getString("qinshiid" + getLoginAccount().getUid()))) && !this.mTvAddress4.getText().toString().contains("请选择") && !this.mTvAddress3.getText().toString().contains("请选择") && !this.mTvAddress2.getText().toString().contains("请选择") && !this.mTvAddress1.getText().toString().contains("请选择")) {
                Intent intent = new Intent();
                intent.putExtra(a.G0, this.mTvAddress1.getText().toString() + this.mTvAddress2.getText().toString() + this.mTvAddress3.getText().toString() + this.mTvAddress4.getText().toString());
                intent.putExtra("id", this.localPreferencesHelper.getString("qinshiid" + getLoginAccount().getUid()));
                setResult(2, intent);
                finish();
                return;
            }
            ToastUtils.show(getActivity(), "请检查是否还有地址没选择！");
            return;
        }
        if (i == 1 || i == 2 || i == 3 || i == 5) {
            if ((this.mFlag == 4 || StringUtils.isNotEmpty(this.localPreferencesHelper.getString("qinshiid" + getLoginAccount().getUid()))) && !this.mTvAddress4.getText().toString().contains("请选择") && !this.mTvAddress3.getText().toString().contains("请选择") && !this.mTvAddress2.getText().toString().contains("请选择") && !this.mTvAddress1.getText().toString().contains("请选择")) {
                BusinessControllers.getInstance().ammeterBindingRoom(getLoginAccount(), Long.parseLong(this.localPreferencesHelper.getString("qinshiid" + getLoginAccount().getUid())), this.mWalletModel.typeId, new Listener<AmmeterBindingRoom>() { // from class: client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity.7
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onStart(Controller controller) {
                        SelectAmmeterAddressActivity.this.showDialog("请稍后");
                        SelectAmmeterAddressActivity.this.mMaterialDialog.setContent("加载中...");
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, AmmeterBindingRoom ammeterBindingRoom, Object... objArr) {
                        SelectAmmeterAddressActivity.this.dismissDialog();
                        PreferenceUtil.putBingdRoom(SelectAmmeterAddressActivity.this.getContext(), "bindRoom" + SelectAmmeterAddressActivity.this.getLoginAccount().getUid(), Long.parseLong(SelectAmmeterAddressActivity.this.localPreferencesHelper.getString("qinshiid" + SelectAmmeterAddressActivity.this.getLoginAccount().getUid())));
                        ToastUtils.show(SelectAmmeterAddressActivity.this.getActivity(), "宿舍绑定成功！");
                        if (SelectAmmeterAddressActivity.this.mFrom == 1) {
                            SelectAmmeterAddressActivity.this.toSelectOperate();
                            return;
                        }
                        if (SelectAmmeterAddressActivity.this.mFrom == 5) {
                            Intent intent2 = new Intent();
                            intent2.putExtra(a.G0, SelectAmmeterAddressActivity.this.mTvAddress1.getText().toString() + SelectAmmeterAddressActivity.this.mTvAddress2.getText().toString() + SelectAmmeterAddressActivity.this.mTvAddress3.getText().toString() + SelectAmmeterAddressActivity.this.mTvAddress4.getText().toString());
                            intent2.putExtra("id", SelectAmmeterAddressActivity.this.localPreferencesHelper.getString("qinshiid" + SelectAmmeterAddressActivity.this.getLoginAccount().getUid()));
                            SelectAmmeterAddressActivity.this.setResult(2, intent2);
                        }
                        if (SelectAmmeterAddressActivity.this.mFrom == 2 && ammeterBindingRoom.success == 1) {
                            LocalBusinessStore.saveBingdRoomStatus1(SelectAmmeterAddressActivity.this.getContext(), 1);
                        }
                        SelectAmmeterAddressActivity.this.finish();
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, ClientException clientException) {
                        SelectAmmeterAddressActivity.this.dismissDialog();
                        if (clientException.getCode() == 7502) {
                            ToastUtils.show(SelectAmmeterAddressActivity.this.getContext(), "宿舍已绑定");
                            Intent intent2 = new Intent();
                            PreferenceUtil.putBingdRoom(SelectAmmeterAddressActivity.this.getContext(), "bindRoom" + SelectAmmeterAddressActivity.this.getLoginAccount().getUid(), Long.parseLong(SelectAmmeterAddressActivity.this.localPreferencesHelper.getString("qinshiid" + SelectAmmeterAddressActivity.this.getLoginAccount().getUid())));
                            intent2.putExtra(a.G0, SelectAmmeterAddressActivity.this.mTvAddress1.getText().toString() + SelectAmmeterAddressActivity.this.mTvAddress2.getText().toString() + SelectAmmeterAddressActivity.this.mTvAddress3.getText().toString() + SelectAmmeterAddressActivity.this.mTvAddress4.getText().toString());
                            intent2.putExtra("id", SelectAmmeterAddressActivity.this.localPreferencesHelper.getString("qinshiid" + SelectAmmeterAddressActivity.this.getLoginAccount().getUid()));
                            SelectAmmeterAddressActivity.this.setResult(2, intent2);
                            SelectAmmeterAddressActivity.this.finish();
                            return;
                        }
                        ToastUtils.show(SelectAmmeterAddressActivity.this.getActivity(), clientException.getDetail());
                    }
                });
            } else {
                ToastUtils.show(getActivity(), "请检查是否还有地址没选择！");
            }
        }
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("绑定宿舍");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void toSelectOperate() {
        BusinessControllers.getInstance().ammeterIsBindRoom(getLoginAccount(), this.mWalletModel.typeId + "", getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", new Listener<AmmeterBindRoomBean>() { // from class: client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterBindRoomBean ammeterBindRoomBean, Object... objArr) {
                if (StringUtils.isNotEmpty(ammeterBindRoomBean.machineid) && StringUtils.isNotEmpty(ammeterBindRoomBean.devicemac)) {
                    SelectOperateActivity.launch(SelectAmmeterAddressActivity.this.getActivity(), SelectAmmeterAddressActivity.this.mWalletModel, ammeterBindRoomBean.devicemac, ammeterBindRoomBean.machineid);
                    SelectAmmeterAddressActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (clientException.getCode() == 4048) {
                    ToastUtils.show(SelectAmmeterAddressActivity.this.getActivity(), "请先绑定宿舍！");
                } else if (clientException.getCode() == 4049) {
                    ToastUtils.show(SelectAmmeterAddressActivity.this.getActivity(), "您的宿舍没安装电表！");
                    SelectOperateActivity.launch(SelectAmmeterAddressActivity.this.getActivity(), SelectAmmeterAddressActivity.this.mWalletModel, "", "");
                } else {
                    ToastUtils.show(SelectAmmeterAddressActivity.this.getActivity(), clientException.getDetail());
                }
                SelectAmmeterAddressActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str) {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(getActivity()).content("正在搜索" + str).progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity.9
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
