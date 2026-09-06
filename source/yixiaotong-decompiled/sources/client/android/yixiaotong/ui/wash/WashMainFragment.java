package client.android.yixiaotong.ui.wash;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.account.AppAccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.ui.RecordListActivity;
import client.android.yixiaotong.ui.RefundProgressActivity;
import client.android.yixiaotong.ui.WalletDetailActivity;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity;
import client.android.yixiaotong.ui.scancode.ZxingScanActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothManager;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WashMainFragment extends BaseFragment {
    ImageView mImgSex;
    private boolean mIsEnable;
    private boolean mIsManager = false;
    SimpleDraweeView mIvMeIcon;
    private String mOrderMoney;
    ImageView mQiDong;
    RelativeLayout mRelMoney;
    TitleBar mTitleBar;
    TextView mTvBalance;
    TextView mTvChakanRecored;
    TextView mTvMeId;
    TextView mTvMeName;
    TextView mTvMeXueHao;
    TextView mTvQiehuanDevice;
    private UserInfoBean mUserInfoBean;
    private WalletModel mWalletModel;

    private void initViewNew(View view) {
        this.mTitleBar = (TitleBar) view.findViewById(R.id.tb_name);
        this.mIvMeIcon = (SimpleDraweeView) view.findViewById(R.id.iv_me_icon);
        this.mImgSex = (ImageView) view.findViewById(R.id.img_sex);
        this.mTvMeName = (TextView) view.findViewById(R.id.tv_me_name);
        this.mTvMeId = (TextView) view.findViewById(R.id.tv_me_id);
        this.mTvMeXueHao = (TextView) view.findViewById(R.id.tv_me_xuehao);
        this.mQiDong = (ImageView) view.findViewById(R.id.qidong);
        this.mTvQiehuanDevice = (TextView) view.findViewById(R.id.tv_qiehuandevice);
        this.mTvChakanRecored = (TextView) view.findViewById(R.id.tv_chakanrecord);
        this.mTvBalance = (TextView) view.findViewById(R.id.tv_balance);
        this.mRelMoney = (RelativeLayout) view.findViewById(R.id.rel_money);
    }

    public static WashMainFragment newInstance() {
        return new WashMainFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_wash_main, (ViewGroup) null);
        if (this.mWalletModel == null) {
            getActivity().finish();
            return viewInflate;
        }
        initViewNew(viewInflate);
        initTitleBar();
        initInfoView();
        initView();
        if (AppAccountManager.getInstance().getAppManagerAccount(this.mWalletModel.typeId) == this.mWalletModel.typeId) {
            this.mIsManager = true;
        }
        return viewInflate;
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("洗衣");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initInfoView() {
        this.mTvBalance.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(this.mWalletModel.getBalance() + "", "100")) + "元");
        UserInfoBean userInfo = getLoginAccount().getAccountManagetStore().getUserInfo();
        this.mUserInfoBean = userInfo;
        if (userInfo == null) {
            return;
        }
        this.mIvMeIcon.setImageURI(UriUtil.parseUriOrNull(userInfo.Icon));
        if (this.mUserInfoBean.GenderId == 1) {
            this.mImgSex.setImageDrawable(getResources().getDrawable(R.mipmap.l_shouye_boy));
        } else {
            this.mImgSex.setImageDrawable(getResources().getDrawable(R.mipmap.l_shouye_girl));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentName)) {
            this.mTvMeName.setText(this.mUserInfoBean.StudentName);
        }
        String str = this.mUserInfoBean.ID + "";
        if (StringUtils.isNotEmpty(str) && str.length() > 4) {
            this.mTvMeId.setText("ID：**************" + str.substring(str.length() - 4, str.length()));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentNo)) {
            this.mTvMeXueHao.setText("学号：" + this.mUserInfoBean.StudentNo);
        }
    }

    private void initView() {
        this.mQiDong.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashMainFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WashMainFragment.this.mWalletModel.getBalance() == 0) {
                    if (WashMainFragment.this.mWalletModel.refund == 1) {
                        RefundProgressActivity.launch(WashMainFragment.this.getActivity(), WashMainFragment.this.mWalletModel);
                        return;
                    } else {
                        ToastUtils.show(WashMainFragment.this.getContext(), "余额为0，请充值后再使用");
                        return;
                    }
                }
                if (!BluetoothManager.getInstance().isBluetoothOn()) {
                    WashMainFragment.this.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2001);
                } else if (AppUtils.isUserHuaWeiScan()) {
                    ScanQrcodeOrBarcodeActivity.launch(WashMainFragment.this.getActivity(), WashMainFragment.this.mWalletModel, "", 3);
                } else {
                    ZxingScanActivity.launch(WashMainFragment.this.getActivity(), WashMainFragment.this.mWalletModel, "", 3);
                }
            }
        });
        this.mTvQiehuanDevice.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashMainFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WashMainFragment.this.mIsManager) {
                    WashBluetoothListActivity.launch(WashMainFragment.this.getActivity(), WashMainFragment.this.mWalletModel, 1);
                } else {
                    WashBluetoothListActivity.launch(WashMainFragment.this.getActivity(), WashMainFragment.this.mWalletModel, 0);
                }
            }
        });
        this.mTvChakanRecored.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashMainFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecordListActivity.launch(WashMainFragment.this.getActivity(), 3);
            }
        });
        this.mQiDong.setOnTouchListener(new View.OnTouchListener() { // from class: client.android.yixiaotong.ui.wash.WashMainFragment.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getX() < 100.0f || motionEvent.getY() < 100.0f || motionEvent.getX() > 480.0f || motionEvent.getY() > 480.0f;
            }
        });
        this.mRelMoney.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashMainFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WashMainFragment.this.mWalletModel != null) {
                    WalletDetailActivity.launch(WashMainFragment.this.getActivity(), WashMainFragment.this.mWalletModel);
                }
            }
        });
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mWalletModel = ((WashMainActivity) activity).getmWalletModel();
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        this.mIsEnable = true;
        BluetoothSDK.getInstance().closeBLE();
        String orderMoney = LocalBusinessStore.getOrderMoney(getContext(), this.mWalletModel.typeId);
        this.mOrderMoney = orderMoney;
        if (!StringUtils.isNotEmpty(orderMoney) || this.mOrderMoney.equals("0")) {
            return;
        }
        getOneApp();
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
        LocalBusinessStore.saveOrderMoney(getContext(), this.mWalletModel.typeId, "0");
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void getOneApp() {
        BusinessControllers.getInstance().GetOneStudentApplication(getLoginAccount(), this.mWalletModel.typeId, new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.wash.WashMainFragment.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (WashMainFragment.this.mIsEnable) {
                    if (list != null) {
                        if (list.size() > 0) {
                            WashMainFragment.this.mTvBalance.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(list.get(0).getBalance() + "", "100")) + "元");
                            return;
                        }
                        return;
                    }
                    ToastUtils.show(WashMainFragment.this.getContext(), "数据异常，请重新登录");
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(BaseApplication.app);
                    ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                }
            }
        });
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 2001 && i2 == -1) {
            if (AppUtils.isUserHuaWeiScan()) {
                ScanQrcodeOrBarcodeActivity.launch(getActivity(), this.mWalletModel, "", 3);
            } else {
                ZxingScanActivity.launch(getActivity(), this.mWalletModel, "", 3);
            }
        }
    }
}
