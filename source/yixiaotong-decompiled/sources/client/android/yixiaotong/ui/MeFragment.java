package client.android.yixiaotong.ui;

import android.client.bluetoothsdk.BluetoothSDK;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.account.AppAccountManager;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.baoxiu.MRepairActivity;
import client.android.yixiaotong.ui.baoxiu.MalfunctionRepairActivity;
import client.android.yixiaotong.ui.cleandata.CleanDataCapatureActivity;
import client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity;
import client.android.yixiaotong.ui.deviceinit.DeviceInitMainActivity;
import client.android.yixiaotong.ui.dialog.UpdateAppDialog;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.ui.widget.DrinkWaterDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.user.AppVersionBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.afollestad.materialdialogs.MaterialDialog;
import com.byazt.bv.BaseConstants;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class MeFragment extends BaseFragment {
    Button mBtnXueHao;
    SimpleDraweeView mIvMeIcon;
    LinearLayout mLinCleanData;
    LinearLayout mLinInit;
    LinearLayout mLinServer;
    private MaterialDialog mMaterialDialog;
    TitleBar mTitleBar;
    TextView mTvId;
    TextView mTvIdentityId;
    TextView mTvMeNewVersion;
    TextView mTvName;
    private UserInfoBean mUserInfoBean;
    View mVDot;
    private List<WalletModel> mWalletModels = new ArrayList();
    private boolean mIsSuccess = true;

    private void initViewNew(View view) {
        this.mTitleBar = (TitleBar) view.findViewById(R.id.tb_name);
        this.mTvMeNewVersion = (TextView) view.findViewById(R.id.tv_me_new_version);
        this.mIvMeIcon = (SimpleDraweeView) view.findViewById(R.id.iv_me_icon);
        this.mTvName = (TextView) view.findViewById(R.id.tv_name);
        this.mTvId = (TextView) view.findViewById(R.id.tv_id);
        this.mBtnXueHao = (Button) view.findViewById(R.id.btn_xuehao);
        this.mLinInit = (LinearLayout) view.findViewById(R.id.lin_init);
        this.mVDot = view.findViewById(R.id.v_dot);
        this.mTvIdentityId = (TextView) view.findViewById(R.id.tv_identityId);
        this.mLinServer = (LinearLayout) view.findViewById(R.id.lin_service);
        this.mLinCleanData = (LinearLayout) view.findViewById(R.id.lin_clean);
    }

    private void initClickListeners(View view) {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                UserInfoActivity.launch(MeFragment.this.getActivity(), MeFragment.this.mUserInfoBean);
            }
        };
        view.findViewById(R.id.rel_info).setOnClickListener(onClickListener);
        view.findViewById(R.id.tv_identityId).setOnClickListener(onClickListener);
        view.findViewById(R.id.ll_me_chongzhi_record).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RechargeRecordActivity.launch(MeFragment.this.getActivity(), 0);
            }
        });
        view.findViewById(R.id.ll_me_record).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                RecordListActivity.launch(MeFragment.this.getActivity(), 0);
            }
        });
        view.findViewById(R.id.ll_me_message_setting).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MessageSettingActivity.launch(MeFragment.this.getActivity());
            }
        });
        view.findViewById(R.id.ll_me_abount_me).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AboutActivity.launch(MeFragment.this.getActivity());
            }
        });
        view.findViewById(R.id.ll_me_baoixiu).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (MeFragment.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
                    MRepairActivity.launch(MeFragment.this.getActivity());
                } else {
                    MalfunctionRepairActivity.launch(MeFragment.this.getActivity(), 0);
                }
            }
        });
        view.findViewById(R.id.ll_me_repair).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MalfunctionRepairActivity.launch(MeFragment.this.getActivity(), 0);
            }
        });
        view.findViewById(R.id.ll_me_update).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MeFragment.this.getVerSion();
            }
        });
        view.findViewById(R.id.btn_exit_app).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AccountManager.getInstance().clearLoginAccount();
                LoginActivity.launch(MeFragment.this.getActivity());
                MeFragment.this.getActivity().finish();
            }
        });
        view.findViewById(R.id.ll_me_init).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DeviceInitMainActivity.launch(MeFragment.this.getActivity());
            }
        });
        view.findViewById(R.id.ll_me_clean).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MeFragment.this.clean();
            }
        });
    }

    private void initView() {
        this.mTvName.getPaint().setFakeBoldText(true);
        UserInfoBean userInfo = getLoginAccount().getAccountManagetStore().getUserInfo();
        this.mUserInfoBean = userInfo;
        if (userInfo == null) {
            return;
        }
        if (StringUtils.isNotEmpty(userInfo.Icon)) {
            this.mIvMeIcon.setImageURI(UriUtil.parseUriOrNull(this.mUserInfoBean.Icon));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentName)) {
            this.mTvName.setText(this.mUserInfoBean.StudentName);
        }
        String str = this.mUserInfoBean.ID + "";
        if (StringUtils.isNotEmpty(str) && str.length() > 4) {
            this.mTvId.setText("ID：**************" + str.substring(str.length() - 4, str.length()));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentNo)) {
            this.mBtnXueHao.setText(this.mUserInfoBean.StudentNo);
        } else {
            this.mBtnXueHao.setVisibility(4);
        }
        if (StringUtils.isEmpty(this.mUserInfoBean.IdentityId)) {
            this.mTvIdentityId.setVisibility(0);
        } else {
            this.mTvIdentityId.setVisibility(8);
        }
        String version = AppUtils.getVersion(BaseApplication.app);
        String appVerOld = LocalDataUtil.getAppVerOld(getContext());
        if (StringUtils.isNotEmpty(version) && StringUtils.isNotEmpty(appVerOld) && StringUtils.stringToInt(appVerOld) > StringUtils.stringToInt(version)) {
            this.mVDot.setVisibility(0);
        } else {
            this.mVDot.setVisibility(8);
        }
        long j = getLoginAccount().getAccountManagetStore().getUserInfo().AreaId;
        if (j == 1 || j == 25004) {
            this.mLinServer.setVisibility(0);
        }
        getWalletModels();
    }

    private void getWalletModels() {
        if (getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
            this.mLinInit.setVisibility(0);
        }
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.MeFragment.12
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list == null || list.size() <= 0) {
                    return;
                }
                MeFragment.this.mWalletModels = list;
                for (WalletModel walletModel : MeFragment.this.mWalletModels) {
                    if (AppAccountManager.getInstance().getAppManagerAccount(walletModel.typeId) == walletModel.typeId) {
                        MeFragment.this.mLinInit.setVisibility(0);
                    }
                }
            }
        });
    }

    public static MeFragment newInstance() {
        return new MeFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_me, (ViewGroup) null);
        initViewNew(viewInflate);
        initClickListeners(viewInflate);
        initTitleBar();
        this.mTvMeNewVersion.setText(AppUtils.getVersion(BaseApplication.app));
        return viewInflate;
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        initView();
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        UpdateAppDialog.getInstance().dismiss(getActivity());
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("我");
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getVerSion() {
        if (this.mIsSuccess) {
            final String version = AppUtils.getVersion(getContext());
            LocalDataUtil.saveAppUpdateUrl(getActivity(), "");
            V3BusinessControllers.getInstance().getAppVerInfo2(getLoginAccount(), version, "1", "202206280001", new Listener<AppVersionBean>() { // from class: client.android.yixiaotong.ui.MeFragment.13
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    MeFragment.this.mIsSuccess = false;
                    MeFragment.this.mMaterialDialog = new MaterialDialog.Builder(MeFragment.this.getActivity()).content("正在处理中,请稍候...").cancelable(false).progress(true, 0).show();
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, AppVersionBean appVersionBean, Object... objArr) {
                    if (appVersionBean != null) {
                        MeFragment.this.mIsSuccess = true;
                        MeFragment.this.mMaterialDialog.dismiss();
                        MeFragment.this.mVDot.setVisibility(8);
                        LocalDataUtil.saveAppVerOld(MeFragment.this.getContext(), "");
                        if (StringUtils.isNotEmpty(appVersionBean.ver) && (appVersionBean.status == 1 || appVersionBean.status == 2)) {
                            if (StringUtils.isNotEmpty(appVersionBean.url)) {
                                LocalDataUtil.saveAppUpdateUrl(MeFragment.this.getActivity(), appVersionBean.url);
                            }
                            LocalDataUtil.saveAppVerOld(MeFragment.this.getContext(), appVersionBean.ver);
                            if (StringUtils.stringToInt(appVersionBean.ver) > StringUtils.stringToInt(version)) {
                                MeFragment.this.mVDot.setVisibility(0);
                                if (appVersionBean.status == 2) {
                                    MeFragment.this.showMustUpdateApkDialog(appVersionBean.msg);
                                    return;
                                } else {
                                    if (appVersionBean.status == 1) {
                                        MeFragment.this.showUpdateApkDialog(appVersionBean.msg);
                                        return;
                                    }
                                    return;
                                }
                            }
                            ToastUtils.show(MeFragment.this.getContext(), "当前已经是最新版本！");
                            return;
                        }
                        ToastUtils.show(MeFragment.this.getContext(), "当前已经是最新版本！");
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    MeFragment.this.mIsSuccess = true;
                    MeFragment.this.mMaterialDialog.dismiss();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMustUpdateApkDialog(String str) {
        UpdateAppDialog.getInstance().showDialog(getActivity(), new UpdateAppDialog.DialogListener() { // from class: client.android.yixiaotong.ui.MeFragment.14
            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onCanle() {
            }

            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onConfirm() {
                MeFragment.this.toUpdate();
            }
        }, str, "", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUpdateApkDialog(String str) {
        UpdateAppDialog.getInstance().showDialog(getActivity(), new UpdateAppDialog.DialogListener() { // from class: client.android.yixiaotong.ui.MeFragment.15
            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onCanle() {
            }

            @Override // client.android.yixiaotong.ui.dialog.UpdateAppDialog.DialogListener
            public void onConfirm() {
                MeFragment.this.toUpdate();
            }
        }, str, "不了", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toUpdate() {
        String appUpdateUrl = LocalDataUtil.getAppUpdateUrl(getActivity());
        if (StringUtils.isNotEmpty(appUpdateUrl)) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(appUpdateUrl)));
        } else if (isAvilible(getActivity(), "com.tencent.android.qqdownloader")) {
            launchAppDetail(getActivity(), "client.android.yixiaotong", "com.tencent.android.qqdownloader");
        } else {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://a.app.qq.com/o/simple.jsp?pkgname=client.android.yixiaotong")));
        }
    }

    public static boolean isAvilible(Context context, String str) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                arrayList.add(installedPackages.get(i).packageName);
            }
        }
        return arrayList.contains(str);
    }

    public static void launchAppDetail(Context context, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + str));
            if (!TextUtils.isEmpty(str2)) {
                intent.setPackage(str2);
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clean() {
        if (AppAccountManager.getInstance().isYinShuiManager(getLoginAccount().getUserName())) {
            View viewInflate = View.inflate(getActivity(), R.layout.cleandata_dialog, null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_chongzhi);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_drink);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_wash);
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_chuifengji);
            TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_xizao);
            TextView textView6 = (TextView) viewInflate.findViewById(R.id.tv_dry);
            TextView textView7 = (TextView) viewInflate.findViewById(R.id.tv_cancel);
            final DrinkWaterDialog drinkWaterDialog = new DrinkWaterDialog(getContext(), viewInflate, R.style.DrinkWateTextViewDialog);
            drinkWaterDialog.show();
            textView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    for (int i = 0; i < MeFragment.this.mWalletModels.size(); i++) {
                        if (((WalletModel) MeFragment.this.mWalletModels.get(i)).typeId == 1) {
                            BluetoothSDK.getInstance().closeBLE();
                            CleanDataCapatureActivity.launch(MeFragment.this.getActivity(), (WalletModel) MeFragment.this.mWalletModels.get(i), "1");
                            drinkWaterDialog.dismiss();
                        }
                    }
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Log.e("test", MeFragment.this.mWalletModels.size() + "");
                    for (int i = 0; i < MeFragment.this.mWalletModels.size(); i++) {
                        if (((WalletModel) MeFragment.this.mWalletModels.get(i)).typeId == 6) {
                            BluetoothSDK.getInstance().closeBLE();
                            CleanDataCapatureActivity.launch(MeFragment.this.getActivity(), (WalletModel) MeFragment.this.mWalletModels.get(i), "1");
                            drinkWaterDialog.dismiss();
                        }
                    }
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    for (int i = 0; i < MeFragment.this.mWalletModels.size(); i++) {
                        if (((WalletModel) MeFragment.this.mWalletModels.get(i)).typeId == 3) {
                            BluetoothSDK.getInstance().closeBLE();
                            CleanDataCapatureActivity.launch(MeFragment.this.getActivity(), (WalletModel) MeFragment.this.mWalletModels.get(i), "1");
                            drinkWaterDialog.dismiss();
                        }
                    }
                }
            });
            textView4.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    for (int i = 0; i < MeFragment.this.mWalletModels.size(); i++) {
                        if (((WalletModel) MeFragment.this.mWalletModels.get(i)).typeId == 8) {
                            BluetoothSDK.getInstance().closeBLE();
                            CleanDataCapatureActivity.launch(MeFragment.this.getActivity(), (WalletModel) MeFragment.this.mWalletModels.get(i), "1");
                            drinkWaterDialog.dismiss();
                        }
                    }
                }
            });
            textView5.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    for (int i = 0; i < MeFragment.this.mWalletModels.size(); i++) {
                        if (((WalletModel) MeFragment.this.mWalletModels.get(i)).typeId == 1) {
                            ClearDataXiZaoActivity.launch(MeFragment.this.getActivity(), (WalletModel) MeFragment.this.mWalletModels.get(i), true);
                            drinkWaterDialog.dismiss();
                        }
                    }
                }
            });
            textView6.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    for (int i = 0; i < MeFragment.this.mWalletModels.size(); i++) {
                        if (((WalletModel) MeFragment.this.mWalletModels.get(i)).typeId == 16) {
                            CleanDataCapatureActivity.launch(MeFragment.this.getActivity(), (WalletModel) MeFragment.this.mWalletModels.get(i), "1");
                            drinkWaterDialog.dismiss();
                        }
                    }
                }
            });
            textView7.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MeFragment.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    drinkWaterDialog.dismiss();
                }
            });
        }
    }
}
