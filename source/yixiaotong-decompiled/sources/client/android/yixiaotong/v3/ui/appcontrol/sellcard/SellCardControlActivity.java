package client.android.yixiaotong.v3.ui.appcontrol.sellcard;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.login.OperationTime;
import client.android.yixiaotong.v3.bean.login.PayPaymentBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.login.ZlPaymentJson;
import client.android.yixiaotong.v3.bean.wallet.WalletInfoBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.ui.scan.ZxingScanV3Activity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LanguageUtils;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SellCardControlActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "SellCardControlActivity";
    private WrapListView mLvRechargeWay;
    private RechargeWayAdapter mRechargeWayAdapter;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvMoney;
    private TypeInfoBean mTypeInfoBean;
    private WalletInfoBean mWalletInfoBean;
    private ZlPaymentJson mZlPaymentJson;
    private boolean mIsEnable = true;
    private int mPlanFlag = 0;
    private List<Integer> mPayFlagTypeList = new ArrayList();
    private List<PayPaymentBean> mPayPaymentBeanList = new ArrayList();
    private int mSelectWay = 0;
    private String mMoney = "";
    private int mCardPrice = -1;
    private boolean mIsNeedInit = false;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlActivity.3
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i == 0) {
                PermissionUtil.requestPerssion(SellCardControlActivity.this.getActivity(), 1, SellCardControlActivity.this.permissionGrant);
            } else {
                if (i != 1) {
                    return;
                }
                if (AppUtils.isUserHuaWeiScan()) {
                    ScanQrcodeActivity.launch(SellCardControlActivity.this.getActivity(), 15);
                } else {
                    ZxingScanV3Activity.launch(SellCardControlActivity.this.getActivity(), 15);
                }
            }
        }
    };

    static {
        StubApp.interface11(9546);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, TypeInfoBean typeInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) SellCardControlActivity.class).putExtra("bean", typeInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mLvRechargeWay = (WrapListView) findViewById(R.id.listview);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(LanguageUtils.getAppName(getActivity(), this.mTypeInfoBean.base.typeId, this.mTypeInfoBean.base.appName));
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setLeftView(R.mipmap.back);
    }

    private void initView() {
        this.mRechargeWayAdapter = new RechargeWayAdapter();
        this.mLvRechargeWay.setOnItemClickListener(this);
        this.mLvRechargeWay.setAdapter((ListAdapter) this.mRechargeWayAdapter);
        this.mRechargeWayAdapter.notifyDataSetChanged();
    }

    private void initClickListeners() {
        findViewById(R.id.img_bill).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m311xbb1490e9(view);
            }
        });
        findViewById(R.id.btn_takecard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m312xbbe30f6a(view);
            }
        });
        findViewById(R.id.btn_buycard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m313xbcb18deb(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-sellcard-SellCardControlActivity, reason: not valid java name */
    /* synthetic */ void m311xbb1490e9(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        this.mIsNeedInit = true;
        ConsumeRecordActivity.launch(getActivity(), 9);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-appcontrol-sellcard-SellCardControlActivity, reason: not valid java name */
    /* synthetic */ void m312xbbe30f6a(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        checkTakeCard();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-appcontrol-sellcard-SellCardControlActivity, reason: not valid java name */
    /* synthetic */ void m313xbcb18deb(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        checkBuyCard();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        if (this.mIsNeedInit) {
            SellCardControlUtil.getInstance().init(getActivity(), getLoginAccount(), this.mTitleBar.getTitleViewContent());
            SellCardControlUtil.getInstance().initBluetooth();
            BluetoothSDK.getInstance().init(getContext());
            setListener();
            this.mIsNeedInit = false;
        }
        SellCardControlUtil.getInstance().onResume();
        BluetoothControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        SellCardControlUtil.getInstance().onPause();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        BaseMaterialDialog.dissmisMaterialDialog();
        BluetoothControlUtil.getInstance().onPause();
        SellCardControlUtil.getInstance().disconnect();
    }

    private void initData() {
        int planFlag = InvestorInfoUtilControl.getInstance().getPlanFlag(9);
        this.mPlanFlag = planFlag;
        if (planFlag == 1) {
            this.mPayFlagTypeList.add(0);
        } else {
            ZlPaymentJson zlPaymentJson = InvestorInfoUtilControl.getInstance().getZlPaymentJson(9);
            this.mZlPaymentJson = zlPaymentJson;
            if (zlPaymentJson != null) {
                for (int i = 0; i < this.mZlPaymentJson.payPaymentList.size(); i++) {
                    if (this.mZlPaymentJson.payPaymentList.get(i).payFlag == 1) {
                        this.mPayFlagTypeList.add(Integer.valueOf(this.mZlPaymentJson.payPaymentList.get(i).payFlagType));
                        this.mPayPaymentBeanList.add(this.mZlPaymentJson.payPaymentList.get(i));
                    }
                }
            }
        }
        this.mSwipeRefreshLayout.setRefreshing(false);
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlActivity.1
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                SellCardControlUtil.getInstance().getCardPrice(SellCardControlActivity.this.mPlanFlag);
            }
        });
        SellCardControlUtil.getInstance().setPayPaymentBean(this.mPayPaymentBeanList);
        setListener();
    }

    private void setListener() {
        SellCardControlUtil.getInstance().setListener(new SellCardControlUtil.OnListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlActivity.2
            @Override // client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.OnListener
            public void onAuth() {
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.OnListener
            public void onError(int i) {
                SellCardControlActivity.this.mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.OnListener
            public void onGetCardPrice(int i) {
                SellCardControlActivity.this.mCardPrice = Integer.parseInt(DecimalUtil.multiply(i + "", "100"));
                SellCardControlActivity.this.mTvMoney.setText(i + "");
                if (SellCardControlActivity.this.mPlanFlag != 1) {
                    SellCardControlActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                }
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.OnListener
            public void onGetWalletInfo(WalletInfoBean walletInfoBean) {
                SellCardControlActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                if (walletInfoBean != null) {
                    SellCardControlActivity.this.mWalletInfoBean = walletInfoBean;
                    SellCardControlActivity.this.mMoney = DecimalUtil.divide(walletInfoBean.money + "", "100");
                    SellCardControlActivity.this.mRechargeWayAdapter.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlUtil.OnListener
            public void onIsHasDevice(boolean z) {
                if (z) {
                    SellCardControlUtil.getInstance().getOrder(SellCardControlActivity.this.mCardPrice, SellCardControlActivity.this.mSelectWay, SellCardControlActivity.this.mPlanFlag);
                } else {
                    SellCardControlUtil.getInstance().showDialog(false, false, false, "当前学校下无售卡设备，暂不支持购卡");
                }
            }
        });
    }

    private void checkBuyCard() {
        if (this.mTypeInfoBean.base.statusFlag == 2) {
            SellCardControlUtil.getInstance().showDialog(false, false, false, "应用已停用");
            return;
        }
        if (this.mCardPrice == -1) {
            SellCardControlUtil.getInstance().showDialog(false, false, false, "获取卡片工本费失败,尝试下拉刷新页面后再进行购卡");
            return;
        }
        if (this.mPlanFlag == 1) {
            WalletInfoBean walletInfoBean = this.mWalletInfoBean;
            if (walletInfoBean == null) {
                SellCardControlUtil.getInstance().showDialog(false, false, false, "钱包信息异常");
                return;
            } else if (walletInfoBean.statusFlag == 3) {
                SellCardControlUtil.getInstance().showDialog(false, false, false, "钱包正在退款中,无法购卡");
                return;
            } else if (this.mWalletInfoBean.money < this.mCardPrice) {
                SellCardControlUtil.getInstance().showDialog(false, false, false, "钱包余额不足，请充值后再购卡");
                return;
            }
        } else if (this.mPayFlagTypeList.size() == 0) {
            SellCardControlUtil.getInstance().showDialog(false, false, false, "后台未配置支付方式，请联系管理员");
            return;
        }
        SellCardControlUtil.getInstance().isHasSellCardDevice();
    }

    private void checkTakeCard() {
        if (checkIsOpenBluetooth()) {
            OperationTime operationTimeIsOpenTime = InvestorInfoUtilControl.getInstance().isOpenTime(9, this.mPlanFlag);
            if (!operationTimeIsOpenTime.isOpen) {
                SellCardControlUtil.getInstance().showDialog(false, false, false, "暂停服务，开放时间为\n每日" + operationTimeIsOpenTime.openTime);
            } else {
                PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
            }
        }
    }

    public boolean checkIsOpenBluetooth() {
        if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            return true;
        }
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mSelectWay = i;
        this.mRechargeWayAdapter.notifyDataSetChanged();
    }

    class RechargeWayAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        RechargeWayAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return SellCardControlActivity.this.mPayFlagTypeList.size();
        }

        @Override // android.widget.Adapter
        public Integer getItem(int i) {
            return (Integer) SellCardControlActivity.this.mPayFlagTypeList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(SellCardControlActivity.this.getContext()).inflate(R.layout.layout_rechargeway_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int iIntValue = getItem(i).intValue();
            viewHolder.img2.setImageResource(R.mipmap.sellcard_wxz);
            viewHolder.tv_money.setVisibility(8);
            if (iIntValue == 0) {
                viewHolder.img.setImageResource(R.mipmap.wallet);
                viewHolder.tv_name.setText(SellCardControlActivity.this.getString(R.string.walletpay));
                viewHolder.tv_money.setVisibility(0);
                viewHolder.tv_money.setText("(" + SellCardControlActivity.this.getString(R.string.balance) + SellCardControlActivity.this.getResources().getString(R.string.renminbi) + SellCardControlActivity.this.mMoney + ")");
            } else if (iIntValue == 1) {
                viewHolder.img.setImageResource(R.mipmap.wx);
                viewHolder.tv_name.setText(SellCardControlActivity.this.getString(R.string.wechatpay));
            } else if (iIntValue == 2) {
                viewHolder.img.setImageResource(R.mipmap.zfb);
                viewHolder.tv_name.setText(SellCardControlActivity.this.getString(R.string.alipaymeny));
            } else if (iIntValue == 7) {
                viewHolder.img.setImageResource(R.mipmap.xzx);
                viewHolder.tv_name.setText(SellCardControlActivity.this.getString(R.string.xiaoyuanyikatong));
            } else if (iIntValue == 3) {
                viewHolder.img.setImageResource(R.mipmap.yl);
                viewHolder.tv_name.setText(SellCardControlActivity.this.getString(R.string.unionpayment));
            }
            if (SellCardControlActivity.this.mSelectWay == i) {
                viewHolder.img2.setImageResource(R.mipmap.sellcard_xz);
            }
            if (iIntValue == 12) {
                viewHolder.img.setImageResource(R.mipmap.icbc);
                viewHolder.tv_name.setText(SellCardControlActivity.this.getString(R.string.icbcjhzf));
            }
            return view;
        }

        class ViewHolder {
            public ImageView img;
            public ImageView img2;
            public TextView tv_money;
            public TextView tv_name;

            public ViewHolder(View view) {
                this.img = (ImageView) view.findViewById(R.id.img1);
                this.tv_name = (TextView) view.findViewById(R.id.textali);
                this.img2 = (ImageView) view.findViewById(R.id.img_select_ali);
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        LogUtil.e(TAG, "onActivityResult:" + i2 + "  " + i);
        if (i == 200) {
            if (i2 != -1) {
                return;
            }
            checkTakeCard();
        } else {
            if (i2 != 15 || intent == null) {
                return;
            }
            final String stringExtra = intent.getStringExtra("qrcode");
            LogUtil.e(TAG, "onActivityResult:" + stringExtra);
            if (StringUtils.isNotEmpty(stringExtra) && stringExtra.length() >= 52) {
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.sellcard.SellCardControlActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SellCardControlUtil.getInstance().getAuthData(stringExtra);
                        SellCardControlUtil.getInstance().connectDecice(stringExtra);
                    }
                }, 200L);
            } else {
                ToastUtils.show(getActivity(), "不合法的二维码！" + stringExtra);
            }
        }
    }
}
