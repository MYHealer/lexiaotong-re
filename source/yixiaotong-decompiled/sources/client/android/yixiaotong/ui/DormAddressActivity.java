package client.android.yixiaotong.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterBindingRoom;
import client.android.yixiaotong.controller.bean.AmmeterRoomDetail;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.entranceguard.EGBindRoomInfo;
import client.android.yixiaotong.controller.bean.entranceguard.EGIsBindBean;
import client.android.yixiaotong.controller.bean.entranceguard.EGRoomDetailBean;
import client.android.yixiaotong.controller.bean.hamam.HamamDetailListBean;
import client.android.yixiaotong.controller.bean.hamam.HamamIsBindBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity;
import client.android.yixiaotong.ui.drinkwater.AlertIosDialog;
import client.android.yixiaotong.ui.hamam.HamamSelectAddressActivity;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.drinkwater.PreferenceUtil;
import client.android.yixiaotong.util.random.RandomUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.hihonor.adsdk.base.g.j.e.a;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class DormAddressActivity extends BaseActivity {
    public static final String EXTRA_WALLET = "extra_wallet";
    private static final String TYPE_PUTBINGDROOMSTATUS1 = "type_putbingdroomstatus1";
    private String mId;
    private MaterialDialog mMaterialDialog;
    private WalletModel mPBWalletModel;
    TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    TextView onEGclickBind;
    TextView onPBclickBind;
    TextView onclickBind;
    RelativeLayout relPBBindOrUnbind;
    TextView tvBindDormAddress;
    RelativeLayout tvBindOrUnbind;
    TextView tvEGBindDormAddress;
    RelativeLayout tvEGBindOrUnbind;
    TextView tvPBBindDormAddress;
    private WalletModel walletModel;
    public int flag = 0;
    private boolean mIsBind = true;

    static {
        StubApp.interface11(5932);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.tvBindOrUnbind = (RelativeLayout) findViewById(R.id.tv_bind_or_unbind);
        this.tvBindDormAddress = (TextView) findViewById(R.id.bind_dorm_address);
        this.onclickBind = (TextView) findViewById(R.id.onclick_bind);
        this.tvEGBindOrUnbind = (RelativeLayout) findViewById(R.id.tv_eg_bind_or_unbind);
        this.tvEGBindDormAddress = (TextView) findViewById(R.id.eg_bind_dorm_address);
        this.onEGclickBind = (TextView) findViewById(R.id.eg_onclick_bind);
        this.relPBBindOrUnbind = (RelativeLayout) findViewById(R.id.rel_pb_bind_or_unbind);
        this.tvPBBindDormAddress = (TextView) findViewById(R.id.pb_bind_dorm_address);
        this.onPBclickBind = (TextView) findViewById(R.id.pb_onclick_bind);
    }

    public static void launch(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) DormAddressActivity.class));
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("设备地址");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        if (this.walletModel == null) {
            this.tvBindDormAddress.setVisibility(8);
        }
        if (this.mWalletModel == null) {
            this.tvEGBindOrUnbind.setVisibility(8);
        }
        if (this.mPBWalletModel == null) {
            this.relPBBindOrUnbind.setVisibility(8);
        }
    }

    private void initListener() {
        this.tvBindOrUnbind.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.DormAddressActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DormAddressActivity.this.onclickBind.getText().toString().trim().equals("点击绑定")) {
                    SelectAmmeterAddressActivity.launch(DormAddressActivity.this.getActivity(), 5, DormAddressActivity.this.walletModel);
                } else {
                    DormAddressActivity dormAddressActivity = DormAddressActivity.this;
                    dormAddressActivity.showUnBingRoomDialog(dormAddressActivity.walletModel.typeId, "宿舍");
                }
            }
        });
        this.tvEGBindOrUnbind.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.DormAddressActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DormAddressActivity.this.onEGclickBind.getText().toString().trim().equals("点击绑定")) {
                    return;
                }
                DormAddressActivity dormAddressActivity = DormAddressActivity.this;
                dormAddressActivity.showUnBingRoomDialog(dormAddressActivity.mWalletModel.typeId, "宿舍");
            }
        });
        this.relPBBindOrUnbind.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.DormAddressActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!StringUtils.isNotEmpty(LocalBusinessStore.getAuthorizedPassword(DormAddressActivity.this.getContext(), DormAddressActivity.this.getLoginAccount().getUid()))) {
                    ToastUtils.show(DormAddressActivity.this.getContext(), "请去个人信息界面设置授权密码");
                } else if (!StringUtils.isNotEmpty(DormAddressActivity.this.getLoginAccount().getIdentityId()) || DormAddressActivity.this.getLoginAccount().getIdentityId().length() != 18) {
                    ToastUtils.show(DormAddressActivity.this.getContext(), "请去个人信息界面输入身份证号码");
                } else {
                    HamamSelectAddressActivity.launch(DormAddressActivity.this.getActivity(), 1, 2, DormAddressActivity.this.mWalletModel);
                }
            }
        });
    }

    private void getWalModle() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.DormAddressActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).typeId == 1) {
                        DormAddressActivity.this.walletModel = list.get(i);
                        DormAddressActivity.this.getBingRoomAddress();
                    } else if (list.get(i).typeId == 10) {
                        DormAddressActivity.this.mWalletModel = list.get(i);
                        DormAddressActivity.this.egIsBind();
                    } else if (list.get(i).typeId == 11) {
                        DormAddressActivity.this.mPBWalletModel = list.get(i);
                        DormAddressActivity.this.isBindHamam();
                    }
                }
                DormAddressActivity.this.initView();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getBingRoomAddress() {
        BusinessControllers.getInstance().ammeterGetRoomDetailNew(getLoginAccount(), new Listener<AmmeterRoomDetail>() { // from class: client.android.yixiaotong.ui.DormAddressActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                DormAddressActivity.this.showDialog("加载中...");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterRoomDetail ammeterRoomDetail, Object... objArr) {
                DormAddressActivity.this.dismissDialog();
                if (ammeterRoomDetail != null) {
                    DormAddressActivity.this.tvBindDormAddress.setText(ammeterRoomDetail.Region + ammeterRoomDetail.Building + ammeterRoomDetail.Floor + ammeterRoomDetail.Room);
                    DormAddressActivity.this.onclickBind.setText("点击解绑");
                    DormAddressActivity.this.flag = 0;
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                DormAddressActivity.this.dismissDialog();
                DormAddressActivity.this.tvBindDormAddress.setText("未绑定水控");
                DormAddressActivity.this.flag = 1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUnBingRoomDialog(final int i, String str) {
        new AlertIosDialog(getActivity()).builder(R.style.AlertDialogStyle).setTitle("解绑" + str).setMsg("确定解绑当前" + str + "?").setPositiveButton("确定", new View.OnClickListener() { // from class: client.android.yixiaotong.ui.DormAddressActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i2 = i;
                if (i2 == 1) {
                    BusinessControllers.getInstance().ammeterUnBindingRoom(DormAddressActivity.this.getLoginAccount(), i, new Listener<AmmeterBindingRoom>() { // from class: client.android.yixiaotong.ui.DormAddressActivity.7.1
                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onStart(Controller controller) {
                            DormAddressActivity.this.showDialog("加载中...");
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onComplete(Controller controller, AmmeterBindingRoom ammeterBindingRoom, Object... objArr) {
                            DormAddressActivity.this.dismissDialog();
                            if (ammeterBindingRoom.success == 1) {
                                LocalBusinessStore.putBingdRoomStatus1(DormAddressActivity.this.getContext(), DormAddressActivity.TYPE_PUTBINGDROOMSTATUS1 + DormAddressActivity.this.getLoginAccount().getUid(), 0);
                                PreferenceUtil.putBingdRoom(DormAddressActivity.this.getContext(), "bindRoom" + DormAddressActivity.this.getLoginAccount().getUid(), 0L);
                                AccountManager.getInstance().clearLoginAccount();
                                LoginActivity.launch(BaseApplication.app);
                                ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                                DormAddressActivity.this.flag = 1;
                                ToastUtils.show(DormAddressActivity.this.getActivity(), "宿舍解绑成功,请重新登录！");
                            }
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onFail(Controller controller, ClientException clientException) {
                            DormAddressActivity.this.dismissDialog();
                            ToastUtils.show(DormAddressActivity.this.getActivity(), clientException.getDetail());
                        }
                    });
                    return;
                }
                if (i2 == 10) {
                    final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
                    BusinessControllers.getInstance().entranceGuardUnBindingRoom(DormAddressActivity.this.getLoginAccount(), LocalBusinessStore.getEntranceguardRoomId(DormAddressActivity.this.getContext(), DormAddressActivity.this.getLoginAccount().getUid()), i, randNumMaxStringNonO, new Listener<EGBindRoomInfo>() { // from class: client.android.yixiaotong.ui.DormAddressActivity.7.2
                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onStart(Controller controller) {
                            DormAddressActivity.this.showDialog("加载中...");
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onComplete(Controller controller, EGBindRoomInfo eGBindRoomInfo, Object... objArr) {
                            DormAddressActivity.this.dismissDialog();
                            if (eGBindRoomInfo == null || !eGBindRoomInfo.rand.equals(randNumMaxStringNonO)) {
                                ToastUtils.show(DormAddressActivity.this.getContext(), "解绑失败");
                                return;
                            }
                            ToastUtils.show(DormAddressActivity.this.getContext(), "解绑成功");
                            LocalBusinessStore.saveEntranceguardMac(DormAddressActivity.this.getContext(), DormAddressActivity.this.getLoginAccount().getUid(), "");
                            LocalBusinessStore.saveEntranceguardRoomId(DormAddressActivity.this.getContext(), DormAddressActivity.this.getLoginAccount().getUid(), "");
                            DormAddressActivity.this.tvEGBindDormAddress.setText("未绑定门禁");
                            DormAddressActivity.this.onEGclickBind.setText("点击绑定");
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onFail(Controller controller, ClientException clientException) {
                            DormAddressActivity.this.dismissDialog();
                            ToastUtils.show(DormAddressActivity.this.getContext(), clientException.getDetail());
                        }
                    });
                } else if (i2 == 11) {
                    BusinessControllers.getInstance().hamamUnBind(DormAddressActivity.this.getLoginAccount(), LocalBusinessStore.getHamamRoomId(DormAddressActivity.this.getContext(), DormAddressActivity.this.getLoginAccount().getUid()), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.DormAddressActivity.7.3
                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onStart(Controller controller) {
                            DormAddressActivity.this.showDialog("加载中...");
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                            DormAddressActivity.this.dismissDialog();
                            if (successBean != null) {
                                ToastUtils.show(DormAddressActivity.this.getContext(), "解绑成功");
                                LocalBusinessStore.saveHamamRoomId(DormAddressActivity.this.getContext(), DormAddressActivity.this.getLoginAccount().getUid(), "");
                                DormAddressActivity.this.tvPBBindDormAddress.setText("未绑定公共浴室");
                                DormAddressActivity.this.onPBclickBind.setText("点击绑定");
                                return;
                            }
                            ToastUtils.show(DormAddressActivity.this.getContext(), "解绑失败");
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onFail(Controller controller, ClientException clientException) {
                            DormAddressActivity.this.dismissDialog();
                            ToastUtils.show(DormAddressActivity.this.getContext(), clientException.getDetail());
                        }
                    });
                }
            }
        }, SupportMenu.CATEGORY_MASK).setNegativeButton("取消", new View.OnClickListener() { // from class: client.android.yixiaotong.ui.DormAddressActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, -16777216).show();
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
        if (isShowingDialog()) {
            return;
        }
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(getActivity()).content(str).progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.DormAddressActivity.8
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            }).show();
            this.mMaterialDialog = materialDialogShow;
            materialDialogShow.setCanceledOnTouchOutside(false);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == 3) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra(a.G0);
                this.mId = intent.getStringExtra("id");
                this.tvEGBindDormAddress.setText(stringExtra);
                this.onEGclickBind.setText("点击解绑");
                return;
            }
            return;
        }
        if (i2 == 4) {
            String stringExtra2 = intent.getStringExtra(a.G0);
            this.mId = intent.getStringExtra("id");
            this.tvPBBindDormAddress.setText(stringExtra2);
            this.onPBclickBind.setText("点击解绑");
            return;
        }
        if (i2 == 5) {
            isBindHamam();
            return;
        }
        if (intent != null) {
            String stringExtra3 = intent.getStringExtra(a.G0);
            this.mId = intent.getStringExtra("id");
            this.tvBindDormAddress.setText(stringExtra3);
            this.onclickBind.setText("点击解绑");
            this.flag = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egIsBind() {
        String entranceguardRoomId = LocalBusinessStore.getEntranceguardRoomId(getContext(), getLoginAccount().getUid());
        if (StringUtils.isNotEmpty(entranceguardRoomId)) {
            getRoomDetail(entranceguardRoomId);
        } else {
            final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
            BusinessControllers.getInstance().entranceGuardIsBind(getLoginAccount(), this.mWalletModel.typeId, randNumMaxStringNonO, new Listener<EGIsBindBean>() { // from class: client.android.yixiaotong.ui.DormAddressActivity.9
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    DormAddressActivity.this.showDialog("加载中...");
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, EGIsBindBean eGIsBindBean, Object... objArr) {
                    DormAddressActivity.this.dismissDialog();
                    if (eGIsBindBean != null && StringUtils.isNotEmpty(eGIsBindBean.rand) && eGIsBindBean.rand.equals(randNumMaxStringNonO)) {
                        if (eGIsBindBean.isBind == 1) {
                            LocalBusinessStore.saveEntranceguardRoomId(DormAddressActivity.this.getContext(), DormAddressActivity.this.getLoginAccount().getUid(), eGIsBindBean.roomid);
                            DormAddressActivity.this.getRoomDetail(eGIsBindBean.roomid);
                        } else if (eGIsBindBean.isBind == 0) {
                            DormAddressActivity.this.mIsBind = false;
                        } else {
                            ToastUtils.show(DormAddressActivity.this.getContext(), "未知错误！");
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    DormAddressActivity.this.dismissDialog();
                    if (clientException.getCode() == 4104) {
                        DormAddressActivity.this.mIsBind = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRoomDetail(String str) {
        BusinessControllers.getInstance().entranceGuardGetAreaInfoAll(getLoginAccount(), str, new Listener<EGRoomDetailBean>() { // from class: client.android.yixiaotong.ui.DormAddressActivity.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                DormAddressActivity.this.showDialog("加载中...");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, EGRoomDetailBean eGRoomDetailBean, Object... objArr) {
                DormAddressActivity.this.dismissDialog();
                DormAddressActivity.this.tvEGBindDormAddress.setText(eGRoomDetailBean.Region + eGRoomDetailBean.Building + eGRoomDetailBean.Floor + eGRoomDetailBean.Room);
                DormAddressActivity.this.onEGclickBind.setText("点击解绑");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                DormAddressActivity.this.dismissDialog();
                ToastUtils.show(DormAddressActivity.this.getContext(), clientException.getDetail());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isBindHamam() {
        String hamamRoomId = LocalBusinessStore.getHamamRoomId(getContext(), getLoginAccount().getUid());
        if (StringUtils.isNotEmpty(hamamRoomId)) {
            getRoomDetailHamam(hamamRoomId);
        } else {
            BusinessControllers.getInstance().hamamIsBind(getLoginAccount(), hamamRoomId, new Listener<HamamIsBindBean>() { // from class: client.android.yixiaotong.ui.DormAddressActivity.11
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    DormAddressActivity.this.showDialog("加载中...");
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, HamamIsBindBean hamamIsBindBean, Object... objArr) {
                    DormAddressActivity.this.dismissDialog();
                    if (hamamIsBindBean != null) {
                        if (hamamIsBindBean.isbind == 1) {
                            LocalBusinessStore.saveHamamRoomId(DormAddressActivity.this.getContext(), DormAddressActivity.this.getLoginAccount().getUid(), hamamIsBindBean.bathhouseareaid);
                            DormAddressActivity.this.getRoomDetailHamam(hamamIsBindBean.bathhouseareaid);
                        } else {
                            if (hamamIsBindBean.isbind == 2) {
                                return;
                            }
                            ToastUtils.show(DormAddressActivity.this.getContext(), "未知错误！");
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    DormAddressActivity.this.dismissDialog();
                    if (clientException.getCode() == 4104) {
                        return;
                    }
                    ToastUtils.show(DormAddressActivity.this.getActivity(), clientException.getDetail());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRoomDetailHamam(String str) {
        BusinessControllers.getInstance().getHamamDetail(getLoginAccount(), "", getLoginAccount().getAccountManagetStore().getUserInfo().GenderId, str, new Listener<List<HamamDetailListBean>>() { // from class: client.android.yixiaotong.ui.DormAddressActivity.12
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<HamamDetailListBean> list, Object... objArr) {
                DormAddressActivity.this.dismissDialog();
                if (list != null) {
                    DormAddressActivity.this.tvPBBindDormAddress.setText(list.get(0).bhname);
                    DormAddressActivity.this.onPBclickBind.setText("点击解绑");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                ToastUtils.show(DormAddressActivity.this.getContext(), clientException.getDetail());
                DormAddressActivity.this.dismissDialog();
                DormAddressActivity.this.finish();
            }
        });
    }
}
