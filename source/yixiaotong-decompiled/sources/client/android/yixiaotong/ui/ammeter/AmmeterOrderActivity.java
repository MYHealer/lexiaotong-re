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
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AmmeterOrderActivity extends BaseActivity implements AmmeterBluetoothManager.Listener {
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
    private TextView mBtnButie;
    private TextView mBtnChongzhi;
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
    private View mView1;
    private View mView2;
    private WalletModel mWalletModel;
    private int mStartIndex = 0;
    private final int mPageSize = 10;
    private List<AmmeterRecordBean> mCardRecords = new ArrayList();
    private boolean isSelectChongZhi = true;
    private int mConnectCount = 0;
    private boolean mConnected = false;
    private boolean mSupport = false;
    private int scanMessage = 10;
    private int connectMessage = 12;
    private boolean isFoundDevice = false;

    static {
        StubApp.interface11(6210);
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

    static /* synthetic */ int access$108(AmmeterOrderActivity ammeterOrderActivity) {
        int i = ammeterOrderActivity.mStartIndex;
        ammeterOrderActivity.mStartIndex = i + 1;
        return i;
    }

    static /* synthetic */ int access$2210(AmmeterOrderActivity ammeterOrderActivity) {
        int i = ammeterOrderActivity.scanMessage;
        ammeterOrderActivity.scanMessage = i - 1;
        return i;
    }

    static /* synthetic */ int access$2410(AmmeterOrderActivity ammeterOrderActivity) {
        int i = ammeterOrderActivity.connectMessage;
        ammeterOrderActivity.connectMessage = i - 1;
        return i;
    }

    static /* synthetic */ int access$3108(AmmeterOrderActivity ammeterOrderActivity) {
        int i = ammeterOrderActivity.mConnectCount;
        ammeterOrderActivity.mConnectCount = i + 1;
        return i;
    }

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mCardRecordList = (ListView) findViewById(R.id.lv_cardrecord);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
        this.mBtnChongzhi = (TextView) findViewById(R.id.btn_chongzhi);
        this.mBtnButie = (TextView) findViewById(R.id.btn_butie);
        this.mView1 = findViewById(R.id.view1);
        this.mView2 = findViewById(R.id.view2);
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2, String str3) {
        Intent intent = new Intent(activity, (Class<?>) AmmeterOrderActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("deviceAddress", str);
        intent.putExtra("extra_userno", str2);
        intent.putExtra("extra_roomid", str3);
        activity.startActivity(intent);
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("电费充值账单");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initBtnView() {
        this.mBtnChongzhi.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterOrderActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AmmeterOrderActivity.this.mStartIndex = 0;
                AmmeterOrderActivity.this.isSelectChongZhi = true;
                AmmeterOrderActivity.this.mBtnChongzhi.setTextColor(AmmeterOrderActivity.this.getResources().getColor(R.color.blue));
                AmmeterOrderActivity.this.mBtnButie.setTextColor(-16777216);
                AmmeterOrderActivity.this.mView1.setBackgroundColor(AmmeterOrderActivity.this.getResources().getColor(R.color.c40a8dd));
                AmmeterOrderActivity.this.mView2.setBackgroundColor(-1);
                AmmeterOrderActivity.this.selectOrderChongzhi();
            }
        });
        this.mBtnButie.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterOrderActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AmmeterOrderActivity.this.mStartIndex = 0;
                AmmeterOrderActivity.this.isSelectChongZhi = false;
                AmmeterOrderActivity.this.mBtnChongzhi.setTextColor(-16777216);
                AmmeterOrderActivity.this.mBtnButie.setTextColor(AmmeterOrderActivity.this.getResources().getColor(R.color.blue));
                AmmeterOrderActivity.this.mView2.setBackgroundColor(AmmeterOrderActivity.this.getResources().getColor(R.color.c40a8dd));
                AmmeterOrderActivity.this.mView1.setBackgroundColor(-1);
                AmmeterOrderActivity.this.selectOrderButie();
            }
        });
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
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterOrderActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AmmeterOrderActivity.this.mMultiStateView.setViewState(3);
                AmmeterOrderActivity.this.initData();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterOrderActivity.4
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                AmmeterOrderActivity.this.mStartIndex = 0;
                AmmeterOrderActivity.this.initData();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterOrderActivity.5
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                AmmeterOrderActivity.this.initData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        getRecordList();
    }

    private void getRecordList() {
        this.mMultiStateView.setViewState(0);
        if (this.isSelectChongZhi) {
            selectOrderChongzhi();
        } else {
            selectOrderButie();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectOrderChongzhi() {
        BusinessControllers.getInstance().getAmmeterRecordList(getLoginAccount(), this.mWalletModel.typeId, this.mStartIndex, new Listener<AmmeterRecordListBean>() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterOrderActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                if (AmmeterOrderActivity.this.mStartIndex == 0) {
                    AmmeterOrderActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterRecordListBean ammeterRecordListBean, Object... objArr) {
                super.onComplete(controller, ammeterRecordListBean, objArr);
                AmmeterOrderActivity.this.mMultiStateView.setViewState(0);
                AmmeterOrderActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                if (ammeterRecordListBean != null) {
                    if (AmmeterOrderActivity.this.mStartIndex == 0) {
                        AmmeterOrderActivity.this.mCardRecords.clear();
                        AmmeterOrderActivity.this.mCardRecords.addAll(ammeterRecordListBean.getSortList());
                    } else {
                        AmmeterOrderActivity.this.mCardRecords.addAll(ammeterRecordListBean.getSortList());
                    }
                    AmmeterOrderActivity.this.mCardRecordAdapter.notifyDataSetChanged();
                    if (ammeterRecordListBean.pageCount - 1 <= ammeterRecordListBean.pageIndex) {
                        AmmeterOrderActivity.this.mLoadMoreFootView.setVisibility(0);
                        AmmeterOrderActivity.this.mLoadMoreFootView.setNoMoreData();
                        AmmeterOrderActivity.this.mLoadMoreFootView.setBackGround();
                    } else {
                        AmmeterOrderActivity.access$108(AmmeterOrderActivity.this);
                        AmmeterOrderActivity.this.mLoadMoreFootView.setVisibility(0);
                        AmmeterOrderActivity.this.mLoadMoreFootView.reset();
                        AmmeterOrderActivity.this.mLoadMoreFootView.setBackGround();
                    }
                    if (ammeterRecordListBean.count == 0 || (AmmeterOrderActivity.this.mStartIndex == 0 && ammeterRecordListBean.Records.size() == 0)) {
                        AmmeterOrderActivity.this.mMultiStateView.setViewState(2);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (AmmeterOrderActivity.this.mStartIndex == 0) {
                    AmmeterOrderActivity.this.mMultiStateView.setViewState(1);
                    AmmeterOrderActivity.this.mTvErrorTip.setText(clientException.getDetail());
                }
                AmmeterOrderActivity.this.mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectOrderButie() {
        if (StringUtils.isNotEmpty(this.mRoomId)) {
            BusinessControllers.getInstance().getAmmeterBuTieRecordList(getLoginAccount(), this.mRoomId, this.mWalletModel.typeId, this.mStartIndex, new Listener<AmmeterRecordListBean>() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterOrderActivity.7
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    super.onStart(controller);
                    if (AmmeterOrderActivity.this.mStartIndex == 0) {
                        AmmeterOrderActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, AmmeterRecordListBean ammeterRecordListBean, Object... objArr) {
                    super.onComplete(controller, ammeterRecordListBean, objArr);
                    AmmeterOrderActivity.this.mMultiStateView.setViewState(0);
                    AmmeterOrderActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (ammeterRecordListBean != null) {
                        if (AmmeterOrderActivity.this.mStartIndex == 0) {
                            AmmeterOrderActivity.this.mCardRecords.clear();
                            AmmeterOrderActivity.this.mCardRecords.addAll(ammeterRecordListBean.getSortList());
                        } else {
                            AmmeterOrderActivity.this.mCardRecords.addAll(ammeterRecordListBean.getSortList());
                        }
                        AmmeterOrderActivity.this.mCardRecordAdapter.notifyDataSetChanged();
                        if (ammeterRecordListBean.pageCount - 1 <= ammeterRecordListBean.pageIndex) {
                            AmmeterOrderActivity.this.mLoadMoreFootView.setVisibility(0);
                            AmmeterOrderActivity.this.mLoadMoreFootView.setNoMoreData();
                            AmmeterOrderActivity.this.mLoadMoreFootView.setBackGround();
                        } else {
                            AmmeterOrderActivity.access$108(AmmeterOrderActivity.this);
                            AmmeterOrderActivity.this.mLoadMoreFootView.setVisibility(0);
                            AmmeterOrderActivity.this.mLoadMoreFootView.reset();
                            AmmeterOrderActivity.this.mLoadMoreFootView.setBackGround();
                        }
                        if (ammeterRecordListBean.count == 0 || (AmmeterOrderActivity.this.mStartIndex == 0 && ammeterRecordListBean.Records.size() == 0)) {
                            AmmeterOrderActivity.this.mMultiStateView.setViewState(2);
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    super.onFail(controller, clientException);
                    if (AmmeterOrderActivity.this.mStartIndex == 0) {
                        AmmeterOrderActivity.this.mMultiStateView.setViewState(1);
                        AmmeterOrderActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    }
                    AmmeterOrderActivity.this.mSwipeRefreshLayout.setRefreshing(false);
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
        this.mHandler = new Handler() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterOrderActivity.8
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    if (TimeOut.Scan == AmmeterOrderActivity.this.mCurrentCheckTimeOut) {
                        AmmeterOrderActivity.this.dismissDialog();
                        AmmeterOrderActivity.this.mAmmeterBluetoothManager.disConnectAll();
                        AmmeterOrderActivity.this.mAmmeterBluetoothManager.stopScan();
                        ToastUtils.show(AmmeterOrderActivity.this.getActivity(), "无法搜索到您宿舍的电表，请靠近电表后重试！");
                        return;
                    }
                    return;
                }
                if (message.what == 2) {
                    if (TimeOut.Connect == AmmeterOrderActivity.this.mCurrentCheckTimeOut) {
                        AmmeterOrderActivity.this.dismissDialog();
                        AmmeterBluetoothManager.getInstance().disConnectAll();
                        ToastUtils.show(AmmeterOrderActivity.this.getActivity(), "连接超时，请靠近电表设备后重试");
                        return;
                    }
                    return;
                }
                if (message.what == 3) {
                    TimeOut timeOut = TimeOut.Connected;
                    TimeOut unused = AmmeterOrderActivity.this.mCurrentCheckTimeOut;
                    return;
                }
                if (message.what == 4) {
                    if (AmmeterOrderActivity.this.mMaterialDialog != null) {
                        AmmeterOrderActivity.access$2210(AmmeterOrderActivity.this);
                        if (AmmeterOrderActivity.this.scanMessage > 0) {
                            AmmeterOrderActivity.this.mMaterialDialog.setContent("正在搜索您宿舍的电表 " + AmmeterOrderActivity.this.scanMessage + " 秒");
                            AmmeterOrderActivity.this.mHandler.sendEmptyMessageDelayed(4, 1000L);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (message.what != 5 || AmmeterOrderActivity.this.mMaterialDialog == null) {
                    return;
                }
                AmmeterOrderActivity.access$2410(AmmeterOrderActivity.this);
                if (AmmeterOrderActivity.this.connectMessage > 0) {
                    AmmeterOrderActivity.this.mMaterialDialog.setContent("正在连接电表 " + AmmeterOrderActivity.this.connectMessage + " 秒");
                    AmmeterOrderActivity.this.mHandler.sendEmptyMessageDelayed(5, 1000L);
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
            return AmmeterOrderActivity.this.mCardRecords.size();
        }

        @Override // android.widget.Adapter
        public AmmeterRecordBean getItem(int i) {
            return (AmmeterRecordBean) AmmeterOrderActivity.this.mCardRecords.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            final ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(AmmeterOrderActivity.this.getContext()).inflate(R.layout.ammeter_record_list_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            AmmeterRecordBean item = getItem(i);
            viewHolder.datetimeTop.setText(dateTimeToDateTime(item.create_date, item.create_time));
            viewHolder.datetime.setText(item.create_date + PPSLabelView.Code + item.create_time);
            viewHolder.money.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(item.pay, "100")));
            viewHolder.orderId.setText("" + item.orderid);
            if (item.sysflag == 0) {
                viewHolder.rel.setVisibility(8);
                viewHolder.chongzhistate.setText(R.string.weizhifu);
                viewHolder.chongzhistate.setTextColor(AmmeterOrderActivity.this.getResources().getColor(R.color.red));
            } else if (item.sysflag == 1) {
                viewHolder.rel.setVisibility(0);
                viewHolder.chongzhistate.setText(R.string.yizhifu);
                viewHolder.chongzhistate.setTextColor(AmmeterOrderActivity.this.getResources().getColor(R.color.red));
            } else if (item.sysflag == 2) {
                viewHolder.rel.setVisibility(0);
                viewHolder.chongzhistate.setText(R.string.daichongzhi);
                viewHolder.chongzhistate.setTextColor(AmmeterOrderActivity.this.getResources().getColor(R.color.red));
            } else {
                viewHolder.rel.setVisibility(8);
                viewHolder.chongzhistate.setText(R.string.yiwancheng);
                viewHolder.chongzhistate.setTextColor(AmmeterOrderActivity.this.getResources().getColor(R.color.blue));
            }
            viewHolder.rel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterOrderActivity.CardRecordAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AmmeterOrderActivity.this.mOrderId = viewHolder.orderId.getText().toString();
                    AmmeterOrderActivity.this.mMoney = viewHolder.money.getText().toString();
                    if (AmmeterOrderActivity.this.mAmmeterBluetoothManager.isBluetoothOn()) {
                        AmmeterOrderActivity.this.showDialog();
                        AmmeterOrderActivity.this.isFoundDevice = false;
                        AmmeterOrderActivity.this.mAmmeterBluetoothManager.disConnectAll();
                        AmmeterOrderActivity.this.mAmmeterBluetoothManager.startScan();
                        AmmeterOrderActivity.this.mCurrentCheckTimeOut = TimeOut.Scan;
                        AmmeterOrderActivity.this.mHandler.sendEmptyMessageDelayed(1, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                        AmmeterOrderActivity.this.mHandler.sendEmptyMessageDelayed(4, 1000L);
                        AmmeterOrderActivity.this.scanMessage = 10;
                        return;
                    }
                    ToastUtils.show(AmmeterOrderActivity.this.getActivity(), "请打开手机的蓝牙！");
                }
            });
            return view;
        }

        class ViewHolder {
            public TextView chongzhistate;
            public TextView datetime;
            public TextView datetimeTop;
            public LinearLayout lin;
            public TextView money;
            public TextView orderId;
            public RelativeLayout rel;

            public ViewHolder(View view) {
                this.datetimeTop = (TextView) view.findViewById(R.id.tv_dataTimeTop);
                this.datetime = (TextView) view.findViewById(R.id.tv_datetime);
                this.money = (TextView) view.findViewById(R.id.tv_money);
                this.orderId = (TextView) view.findViewById(R.id.tv_orderId);
                this.chongzhistate = (TextView) view.findViewById(R.id.tv_chongzhistate);
                this.lin = (LinearLayout) view.findViewById(R.id.lin);
                this.rel = (RelativeLayout) view.findViewById(R.id.rel);
            }
        }

        private String dateTimeToDateTime(String str, String str2) {
            if (!StringUtils.isNotEmpty(str) || !StringUtils.isNotEmpty(str2)) {
                return "";
            }
            String[] strArrSplit = str.split(x.A);
            StringBuilder sb = new StringBuilder();
            sb.append(strArrSplit[1]);
            sb.append("月");
            sb.append(strArrSplit[2]);
            sb.append("日 ");
            if (Integer.parseInt(str2.substring(0, 2)) > 19) {
                sb.append("晚上");
            } else if (Integer.parseInt(str2.substring(0, 2)) > 12) {
                sb.append("下午");
            } else if (Integer.parseInt(str2.substring(0, 2)) > 6) {
                sb.append("早上");
            } else {
                sb.append("凌晨");
            }
            sb.append(str2.substring(0, 5));
            return sb.toString();
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
        runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterOrderActivity.9
            @Override // java.lang.Runnable
            public void run() {
                AmmeterOrderActivity.this.mCurrentCheckTimeOut = TimeOut.Connect;
                AmmeterOrderActivity.access$3108(AmmeterOrderActivity.this);
                Message message = new Message();
                message.what = 2;
                message.arg1 = AmmeterOrderActivity.this.mConnectCount;
                AmmeterOrderActivity.this.mHandler.sendMessageDelayed(message, 12000L);
                AmmeterOrderActivity.this.mAmmeterBluetoothManager.connect(AmmeterOrderActivity.this.mAddress);
            }
        }, 1500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(this).content("正在搜索您宿舍的电表...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterOrderActivity.10
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
            runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterOrderActivity.11
                @Override // java.lang.Runnable
                public void run() {
                    AmmeterOrderActivity.this.dismissDialog();
                    AmmeterWalletDetailActivity.launch(AmmeterOrderActivity.this.getActivity(), AmmeterOrderActivity.this.mWalletModel, AmmeterOrderActivity.this.mAddress, true, AmmeterOrderActivity.this.mOrderId, AmmeterOrderActivity.this.mMoney, AmmeterOrderActivity.this.mUserNo);
                    AmmeterOrderActivity.this.mSupport = false;
                    AmmeterOrderActivity.this.mConnected = false;
                    AmmeterOrderActivity.this.finish();
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
