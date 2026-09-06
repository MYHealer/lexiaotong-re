package client.android.yixiaotong.ui.ammeter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterRecordBean;
import client.android.yixiaotong.controller.bean.AmmeterRecordListBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterCommandUtils;
import client.android.yixiaotong.util.bluetooth.TimeOut;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AmmeterSubsidyActivity extends BaseActivity implements AmmeterBluetoothManager.Listener {
    public static final String EXTRAS_DEVICE_ADDRESS = "deviceAddress";
    public static final String EXTRA_DEVICENO = "extra_deviceno";
    public static final String EXTRA_ROOMID = "extra_roomid";
    public static final String EXTRA_USERNO = "extra_userno";
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final int MESSAGE_CONNECT = 2;
    public static final int MESSAGE_CONNECTCOUNT = 5;
    public static final int MESSAGE_CONNECTED = 3;
    public static final int MESSAGE_SCAN = 1;
    public static final int MESSAGE_SCANCOUNT = 4;
    private String mAddress;
    private AmmeterBluetoothManager mAmmeterBluetoothManager;
    private CardRecordAdapter mCardRecordAdapter;
    private ListView mCardRecordList;
    private TimeOut mCurrentCheckTimeOut;
    private Handler mHandler;
    private LoadMoreFooter mLoadMoreFootView;
    private MaterialDialog mMaterialDialog;
    private String mMoney;
    private MultiStateView mMultiStateView;
    private String mOrderId;
    private String mRoomId;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TextView mTvErrorTip;
    private String mUserNo;
    private TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    private int mStartIndex = 0;
    private final int mPageSize = 10;
    private List<AmmeterRecordBean> mCardRecords = new ArrayList();
    private int mConnectCount = 0;
    private boolean mConnected = false;
    private boolean mSupport = false;
    private int scanMessage = 10;
    private int connectMessage = 12;
    private boolean isFoundDevice = false;

    static {
        StubApp.interface11(6227);
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onBLEState(boolean z) {
        this.mConnected = z;
        this.mSupport = z;
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnected(String str, boolean z) {
        this.mConnected = z;
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnecting(String str) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryFinished() {
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryStarted() {
    }

    static /* synthetic */ int access$1510(AmmeterSubsidyActivity ammeterSubsidyActivity) {
        int i = ammeterSubsidyActivity.scanMessage;
        ammeterSubsidyActivity.scanMessage = i - 1;
        return i;
    }

    static /* synthetic */ int access$1710(AmmeterSubsidyActivity ammeterSubsidyActivity) {
        int i = ammeterSubsidyActivity.connectMessage;
        ammeterSubsidyActivity.connectMessage = i - 1;
        return i;
    }

    static /* synthetic */ int access$2608(AmmeterSubsidyActivity ammeterSubsidyActivity) {
        int i = ammeterSubsidyActivity.mConnectCount;
        ammeterSubsidyActivity.mConnectCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$308(AmmeterSubsidyActivity ammeterSubsidyActivity) {
        int i = ammeterSubsidyActivity.mStartIndex;
        ammeterSubsidyActivity.mStartIndex = i + 1;
        return i;
    }

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mCardRecordList = (ListView) findViewById(R.id.lv_cardrecord);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2, String str3) {
        Intent intent = new Intent(activity, (Class<?>) AmmeterSubsidyActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("deviceAddress", str);
        intent.putExtra("extra_userno", str2);
        intent.putExtra("extra_roomid", str3);
        activity.startActivity(intent);
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("电费补贴");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mCardRecordList.addFooterView(loadMoreFooter);
        this.mCardRecordList.setFooterDividersEnabled(false);
        this.mLoadMoreFootView.setVisibility(8);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterSubsidyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AmmeterSubsidyActivity.this.mMultiStateView.setViewState(3);
                AmmeterSubsidyActivity.this.initData();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterSubsidyActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                AmmeterSubsidyActivity.this.mStartIndex = 0;
                AmmeterSubsidyActivity.this.initData();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterSubsidyActivity.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                AmmeterSubsidyActivity.this.initData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        getRecordList();
    }

    private void getRecordList() {
        this.mMultiStateView.setViewState(0);
        selectOrderButie();
    }

    private void selectOrderButie() {
        if (StringUtils.isNotEmpty(this.mRoomId)) {
            BusinessControllers.getInstance().getAmmeterBuTieRecordList(getLoginAccount(), this.mRoomId, this.mWalletModel.typeId, this.mStartIndex, new Listener<AmmeterRecordListBean>() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterSubsidyActivity.4
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    super.onStart(controller);
                    if (AmmeterSubsidyActivity.this.mStartIndex == 0) {
                        AmmeterSubsidyActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, AmmeterRecordListBean ammeterRecordListBean, Object... objArr) {
                    super.onComplete(controller, ammeterRecordListBean, objArr);
                    AmmeterSubsidyActivity.this.mMultiStateView.setViewState(0);
                    AmmeterSubsidyActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (ammeterRecordListBean != null) {
                        if (AmmeterSubsidyActivity.this.mStartIndex == 0) {
                            AmmeterSubsidyActivity.this.mCardRecords.clear();
                            AmmeterSubsidyActivity.this.mCardRecords.addAll(ammeterRecordListBean.getSortList());
                        } else {
                            AmmeterSubsidyActivity.this.mCardRecords.addAll(ammeterRecordListBean.getSortList());
                        }
                        AmmeterSubsidyActivity.this.mCardRecordAdapter.notifyDataSetChanged();
                        if (ammeterRecordListBean.pageCount - 1 <= ammeterRecordListBean.pageIndex) {
                            AmmeterSubsidyActivity.this.mLoadMoreFootView.setVisibility(0);
                            AmmeterSubsidyActivity.this.mLoadMoreFootView.setNoMoreData();
                        } else {
                            AmmeterSubsidyActivity.access$308(AmmeterSubsidyActivity.this);
                            AmmeterSubsidyActivity.this.mLoadMoreFootView.setVisibility(0);
                            AmmeterSubsidyActivity.this.mLoadMoreFootView.reset();
                        }
                        if (ammeterRecordListBean.count == 0) {
                            AmmeterSubsidyActivity.this.mMultiStateView.setViewState(2);
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    super.onFail(controller, clientException);
                    if (AmmeterSubsidyActivity.this.mStartIndex == 0) {
                        AmmeterSubsidyActivity.this.mMultiStateView.setViewState(1);
                        AmmeterSubsidyActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    }
                    AmmeterSubsidyActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                }
            });
        } else {
            this.mMultiStateView.setViewState(2);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        AmmeterBluetoothManager ammeterBluetoothManager = AmmeterBluetoothManager.getInstance();
        this.mAmmeterBluetoothManager = ammeterBluetoothManager;
        ammeterBluetoothManager.setListener(this);
        this.mHandler = new Handler() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterSubsidyActivity.5
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    if (TimeOut.Scan == AmmeterSubsidyActivity.this.mCurrentCheckTimeOut) {
                        AmmeterSubsidyActivity.this.dismissDialog();
                        AmmeterSubsidyActivity.this.mAmmeterBluetoothManager.disConnectAll();
                        AmmeterSubsidyActivity.this.mAmmeterBluetoothManager.stopScan();
                        ToastUtils.show(AmmeterSubsidyActivity.this.getActivity(), "无法搜索到您宿舍的电表，请靠近电表后重试！");
                        return;
                    }
                    return;
                }
                if (message.what == 2) {
                    if (TimeOut.Connect == AmmeterSubsidyActivity.this.mCurrentCheckTimeOut) {
                        AmmeterSubsidyActivity.this.dismissDialog();
                        AmmeterBluetoothManager.getInstance().disConnectAll();
                        ToastUtils.show(AmmeterSubsidyActivity.this.getActivity(), "连接超时，请靠近电表设备后重试");
                        return;
                    }
                    return;
                }
                if (message.what == 3) {
                    TimeOut timeOut = TimeOut.Connected;
                    TimeOut unused = AmmeterSubsidyActivity.this.mCurrentCheckTimeOut;
                    return;
                }
                if (message.what == 4) {
                    if (AmmeterSubsidyActivity.this.mMaterialDialog != null) {
                        AmmeterSubsidyActivity.access$1510(AmmeterSubsidyActivity.this);
                        if (AmmeterSubsidyActivity.this.scanMessage > 0) {
                            AmmeterSubsidyActivity.this.mMaterialDialog.setContent("正在搜索您宿舍的电表 " + AmmeterSubsidyActivity.this.scanMessage + " 秒");
                            AmmeterSubsidyActivity.this.mHandler.sendEmptyMessageDelayed(4, 1000L);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (message.what != 5 || AmmeterSubsidyActivity.this.mMaterialDialog == null) {
                    return;
                }
                AmmeterSubsidyActivity.access$1710(AmmeterSubsidyActivity.this);
                if (AmmeterSubsidyActivity.this.connectMessage > 0) {
                    AmmeterSubsidyActivity.this.mMaterialDialog.setContent("正在连接电表 " + AmmeterSubsidyActivity.this.connectMessage + " 秒");
                    AmmeterSubsidyActivity.this.mHandler.sendEmptyMessageDelayed(5, 1000L);
                }
            }
        };
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        AmmeterBluetoothManager ammeterBluetoothManager = this.mAmmeterBluetoothManager;
        if (ammeterBluetoothManager != null) {
            ammeterBluetoothManager.stopScan();
        }
        this.mCurrentCheckTimeOut = null;
        this.mHandler = null;
    }

    private class CardRecordAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private CardRecordAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return AmmeterSubsidyActivity.this.mCardRecords.size();
        }

        @Override // android.widget.Adapter
        public AmmeterRecordBean getItem(int i) {
            return (AmmeterRecordBean) AmmeterSubsidyActivity.this.mCardRecords.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            final ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(AmmeterSubsidyActivity.this.getContext()).inflate(R.layout.ammeter_subsidy_list_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            AmmeterRecordBean item = getItem(i);
            viewHolder.datetime.setText(item.create_date + PPSLabelView.Code + item.create_time);
            viewHolder.money.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(item.pay, "100")));
            viewHolder.orderId.setText("" + item.orderid);
            if (item.payflag == 1) {
                viewHolder.subType.setText("周期补贴");
            } else {
                viewHolder.subType.setText("换电表补贴");
            }
            if (item.sysflag == 1) {
                viewHolder.lin.setBackgroundResource(R.mipmap.l_ammeter_subsidy_gray1);
                viewHolder.chongzhistate.setText(R.string.weilingqu);
                viewHolder.chongzhistate.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.blue));
                viewHolder.state.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.c777777));
                viewHolder.datetime.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.c777777));
                viewHolder.orderId.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.c777777));
                viewHolder.orderText.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.c777777));
                viewHolder.typeText.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.c777777));
                viewHolder.type.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.c777777));
                viewHolder.rel.setBackgroundResource(R.mipmap.l_ammeter_subsidy_blue);
            } else if (item.sysflag == 2) {
                viewHolder.lin.setBackgroundResource(R.mipmap.l_ammeter_subsidy_gray1);
                viewHolder.chongzhistate.setText(R.string.yilingqu);
                viewHolder.chongzhistate.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.bg_verify));
                viewHolder.state.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.c777777));
                viewHolder.datetime.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.c777777));
                viewHolder.orderId.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.c777777));
                viewHolder.orderText.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.c777777));
                viewHolder.typeText.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.c777777));
                viewHolder.type.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.c777777));
                viewHolder.rel.setBackgroundResource(R.mipmap.l_ammeter_subsidy_lightblue);
            } else if (item.sysflag == 3) {
                viewHolder.lin.setBackgroundResource(R.mipmap.l_ammeter_subsidy_gray1);
                viewHolder.chongzhistate.setText(R.string.yiwancheng);
                viewHolder.chongzhistate.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.text_gray4));
                viewHolder.state.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.text_gray4));
                viewHolder.datetime.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.text_gray4));
                viewHolder.orderId.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.text_gray4));
                viewHolder.orderText.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.text_gray4));
                viewHolder.typeText.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.text_gray4));
                viewHolder.type.setTextColor(AmmeterSubsidyActivity.this.getResources().getColor(R.color.text_gray4));
                viewHolder.rel.setBackgroundResource(R.mipmap.l_ammeter_subsidy_gray);
            }
            viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterSubsidyActivity.CardRecordAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (viewHolder.chongzhistate.getText().toString().equals("已完成")) {
                        return;
                    }
                    AmmeterSubsidyActivity.this.mOrderId = viewHolder.orderId.getText().toString();
                    AmmeterSubsidyActivity.this.mMoney = viewHolder.money.getText().toString();
                    if (AmmeterSubsidyActivity.this.mAmmeterBluetoothManager.isBluetoothOn()) {
                        AmmeterSubsidyActivity.this.showDialog();
                        AmmeterSubsidyActivity.this.isFoundDevice = false;
                        AmmeterSubsidyActivity.this.mAmmeterBluetoothManager.disConnectAll();
                        AmmeterSubsidyActivity.this.mAmmeterBluetoothManager.startScan();
                        AmmeterSubsidyActivity.this.mCurrentCheckTimeOut = TimeOut.Scan;
                        AmmeterSubsidyActivity.this.mHandler.sendEmptyMessageDelayed(1, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                        AmmeterSubsidyActivity.this.mHandler.sendEmptyMessageDelayed(4, 1000L);
                        AmmeterSubsidyActivity.this.scanMessage = 10;
                        return;
                    }
                    ToastUtils.show(AmmeterSubsidyActivity.this.getActivity(), "请打开手机的蓝牙！");
                }
            });
            return view;
        }

        class ViewHolder {
            public TextView chongzhistate;
            public TextView datetime;
            public LinearLayout lin;
            public TextView money;
            public TextView orderId;
            public TextView orderText;
            public RelativeLayout rel;
            public TextView state;
            public TextView subType;
            private TextView type;
            private TextView typeText;

            public ViewHolder(View view) {
                this.datetime = (TextView) view.findViewById(R.id.tv_time);
                this.money = (TextView) view.findViewById(R.id.tv_subsidymoney);
                this.orderId = (TextView) view.findViewById(R.id.tv_orderId);
                this.subType = (TextView) view.findViewById(R.id.tv_type);
                this.orderText = (TextView) view.findViewById(R.id.orderId);
                this.chongzhistate = (TextView) view.findViewById(R.id.tv_state);
                this.state = (TextView) view.findViewById(R.id.state);
                this.type = (TextView) view.findViewById(R.id.tv_text);
                this.typeText = (TextView) view.findViewById(R.id.tv_type);
                this.lin = (LinearLayout) view.findViewById(R.id.lin);
                this.rel = (RelativeLayout) view.findViewById(R.id.rel);
            }
        }
    }

    private void connetAmmeter() {
        this.scanMessage = 0;
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.setContent("正在连接电表 12 秒");
            this.mHandler.sendEmptyMessageDelayed(5, 1000L);
            this.connectMessage = 12;
        }
        this.mAmmeterBluetoothManager.disConnectAll();
        runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterSubsidyActivity.6
            @Override // java.lang.Runnable
            public void run() {
                AmmeterSubsidyActivity.this.mCurrentCheckTimeOut = TimeOut.Connect;
                AmmeterSubsidyActivity.access$2608(AmmeterSubsidyActivity.this);
                Message message = new Message();
                message.what = 2;
                message.arg1 = AmmeterSubsidyActivity.this.mConnectCount;
                AmmeterSubsidyActivity.this.mHandler.sendMessageDelayed(message, 12000L);
                AmmeterSubsidyActivity.this.mAmmeterBluetoothManager.connect(AmmeterSubsidyActivity.this.mAddress);
            }
        }, 1500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(this).content("正在搜索您宿舍的电表...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterSubsidyActivity.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            }).show();
            this.mMaterialDialog = materialDialogShow;
            materialDialogShow.setCanceledOnTouchOutside(false);
        } catch (Exception unused) {
        }
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

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDisconnected(String str) {
        dismissDialog();
        ToastUtils.show(getContext(), "电表蓝牙信号不好，请重试");
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectionFailed(String str) {
        dismissDialog();
        AmmeterBluetoothManager.getInstance().disConnectAll();
        ToastUtils.show(getContext(), "连接电表失败");
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDeviceFound(String str) {
        if (StringUtils.isNotEmpty(str) && this.mAddress.equals(str) && !this.isFoundDevice) {
            this.isFoundDevice = true;
            MaterialDialog materialDialog = this.mMaterialDialog;
            if (materialDialog != null) {
                materialDialog.setContent("已经查找到您宿舍的电表...");
            }
            this.mAmmeterBluetoothManager.stopScan();
            connetAmmeter();
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectState(String str, boolean z) {
        this.mSupport = z;
        if (z) {
            if (isShowingDialog()) {
                this.mMaterialDialog.setContent("电表蓝牙匹配成功");
                this.connectMessage = 0;
            }
            this.mCurrentCheckTimeOut = TimeOut.Connected;
            runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterSubsidyActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    AmmeterSubsidyActivity.this.dismissDialog();
                    AmmeterWalletDetailActivity.launch(AmmeterSubsidyActivity.this.getActivity(), AmmeterSubsidyActivity.this.mWalletModel, AmmeterSubsidyActivity.this.mAddress, true, AmmeterSubsidyActivity.this.mOrderId, AmmeterSubsidyActivity.this.mMoney, AmmeterSubsidyActivity.this.mUserNo);
                    AmmeterSubsidyActivity.this.mSupport = false;
                    AmmeterSubsidyActivity.this.mConnected = false;
                    AmmeterSubsidyActivity.this.finish();
                }
            }, 800L);
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onSendDataFailed() {
        dismissDialog();
        ToastUtils.show(getContext(), "数据发送失败！");
        finish();
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDataReceived(String str, byte[] bArr) {
        AmmeterCommandUtils.isConnectResult(HexString.bufferToHex(bArr));
    }
}
