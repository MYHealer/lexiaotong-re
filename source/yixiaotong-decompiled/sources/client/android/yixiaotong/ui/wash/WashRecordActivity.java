package client.android.yixiaotong.ui.wash;

import android.app.Activity;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SoundWaveCardRecordBean;
import client.android.yixiaotong.controller.bean.SoundWaveCardRecordListBean;
import client.android.yixiaotong.controller.bean.wash.WashOrderBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity;
import client.android.yixiaotong.ui.scancode.ZxingScanActivity;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothDevice;
import client.android.yixiaotong.util.bluetooth.BluetoothManager;
import client.android.yixiaotong.util.bluetooth.CommandUtils;
import client.android.yixiaotong.util.bluetooth.TimeOut;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.random.RandomUtils;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WashRecordActivity extends BaseActivity implements BluetoothManager.Listener {
    public static final String EXTRA_MAC = "extra_mac";
    public static final String EXTRA_MACHINEID = "extra_machineid";
    public static final String EXTRA_PMINFOTYPE = "extra_pminfotype";
    public static final String EXTRA_STATE = "extra_state";
    public static final String EXTRA_WALLET = "extra_wallet";
    private BluetoothManager mBluetoothManager;
    private CardRecordAdapter mCardRecordAdapter;
    ListView mCardRecordList;
    TimeOut mCurrentCheckTimeOut;
    private String mDeviceHexID;
    private String mDeviceHexNo;
    private String mFunction;
    private LoadMoreFooter mLoadMoreFootView;
    private MaterialDialog mMaterialDialog;
    MultiStateView mMultiStateView;
    PullRefreshLayout mSwipeRefreshLayout;
    private String mTimeYear;
    TitleBar mTitleBar;
    TextView mTvErrorTip;
    private WalletModel mWalletModel;
    private boolean mIsConnected = true;
    private int mStartIndex = 0;
    private String status = "";
    private String mMachineid = "";
    private String pminfotype = "";
    private String mMac = "";
    private String mSystemtime = "";
    private int mTotalCount = 0;
    private List<SoundWaveCardRecordBean> mCardRecords = new ArrayList();
    private boolean mHasMoreData = false;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(7720);
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onConnecting(String str) {
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onConnectionFailed(String str) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDeviceFound(String str) {
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDisconnected(String str) {
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDiscoveryFinished() {
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDiscoveryStarted() {
    }

    static /* synthetic */ int access$508(WashRecordActivity washRecordActivity) {
        int i = washRecordActivity.mStartIndex;
        washRecordActivity.mStartIndex = i + 1;
        return i;
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(activity, (Class<?>) WashRecordActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("extra_state", str);
        intent.putExtra("extra_machineid", str2);
        intent.putExtra(EXTRA_PMINFOTYPE, str3);
        intent.putExtra("extra_mac", str4);
        activity.startActivity(intent);
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mCardRecordList = (ListView) findViewById(R.id.lv_cardrecord);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.wash.WashRecordActivity$1, reason: invalid class name */
    class AnonymousClass1 implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        AnonymousClass1() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (!WashRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= WashRecordActivity.this.mTotalCount) {
                return;
            }
            WashRecordActivity.this.mTotalCount = i3;
            WashRecordActivity.this.initData();
            WashRecordActivity.this.mLoadMoreFootView.loadMoreData();
        }
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("消费记录");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mCardRecordList.addFooterView(loadMoreFooter);
        this.mCardRecordList.setFooterDividersEnabled(false);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashRecordActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WashRecordActivity.this.mMultiStateView.setViewState(3);
                WashRecordActivity.this.initData();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.wash.WashRecordActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                WashRecordActivity.this.mStartIndex = 0;
                WashRecordActivity.this.mTotalCount = 0;
                WashRecordActivity.this.initData();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.wash.WashRecordActivity.4
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                WashRecordActivity.this.initData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        getRecordList();
    }

    private void getRecordList() {
        BusinessControllers.getInstance().getWashRecordList(getLoginAccount(), this.mWalletModel.typeId, this.mStartIndex, this.status, this.mMachineid, this.pminfotype, new Listener<SoundWaveCardRecordListBean>() { // from class: client.android.yixiaotong.ui.wash.WashRecordActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                WashRecordActivity.this.mHasMoreData = false;
                if (WashRecordActivity.this.mStartIndex != 0) {
                    WashRecordActivity.this.mLoadMoreFootView.loadMoreData();
                } else {
                    WashRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SoundWaveCardRecordListBean soundWaveCardRecordListBean, Object... objArr) {
                super.onComplete(controller, soundWaveCardRecordListBean, objArr);
                if (WashRecordActivity.this.mIsEnable) {
                    WashRecordActivity.this.mMultiStateView.setViewState(0);
                    WashRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    WashRecordActivity.this.mTimeYear = TimeUtils.formatTime(Long.parseLong(soundWaveCardRecordListBean.serial));
                    if (soundWaveCardRecordListBean != null) {
                        if (WashRecordActivity.this.mStartIndex == 0) {
                            WashRecordActivity.this.mCardRecords.clear();
                            WashRecordActivity.this.mCardRecords.addAll(soundWaveCardRecordListBean.getSortList());
                        } else {
                            WashRecordActivity.this.mCardRecords.addAll(soundWaveCardRecordListBean.getSortList());
                        }
                        WashRecordActivity.this.mCardRecordAdapter.notifyDataSetChanged();
                        if (soundWaveCardRecordListBean.pageCount - 1 > soundWaveCardRecordListBean.pageIndex) {
                            WashRecordActivity.this.mHasMoreData = true;
                            WashRecordActivity.access$508(WashRecordActivity.this);
                            WashRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                            WashRecordActivity.this.mLoadMoreFootView.reset();
                        } else {
                            WashRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                        }
                        if (soundWaveCardRecordListBean.count == 0) {
                            WashRecordActivity.this.mMultiStateView.setViewState(2);
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (WashRecordActivity.this.mIsEnable) {
                    if (WashRecordActivity.this.mStartIndex != 0) {
                        WashRecordActivity.this.mLoadMoreFootView.resetForFail();
                    } else {
                        WashRecordActivity.this.mMultiStateView.setViewState(1);
                        WashRecordActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    }
                    WashRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    SystemErrorTip.getInstance().showTipDialog(WashRecordActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    private class CardRecordAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private CardRecordAdapter() {
        }

        /* synthetic */ CardRecordAdapter(WashRecordActivity washRecordActivity, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return WashRecordActivity.this.mCardRecords.size();
        }

        @Override // android.widget.Adapter
        public SoundWaveCardRecordBean getItem(int i) {
            return (SoundWaveCardRecordBean) WashRecordActivity.this.mCardRecords.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            final ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(WashRecordActivity.this.getContext()).inflate(R.layout.wash_record_list_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (i == 0) {
                viewHolder.line.setVisibility(4);
            } else {
                viewHolder.line.setVisibility(0);
            }
            final SoundWaveCardRecordBean item = getItem(i);
            if (StringUtils.isNotEmpty(item.payDate) && StringUtils.isNotEmpty(item.payTime) && StringUtils.isNotEmpty(item.realPay) && StringUtils.isNotEmpty(item.orderid)) {
                viewHolder.datetime.setText(item.payDate + PPSLabelView.Code + item.payTime);
                viewHolder.money.setText(x.A + DecimalUtil.twoDecimal(DecimalUtil.divide(item.realPay, "100")));
                if (item.sysflag == 1) {
                    viewHolder.chongzhistate.setText(WashRecordActivity.this.mWalletModel.name + "-未激活");
                } else if (item.sysflag == 2) {
                    viewHolder.chongzhistate.setText(WashRecordActivity.this.mWalletModel.name + "-待校验");
                } else {
                    viewHolder.chongzhistate.setText(WashRecordActivity.this.mWalletModel.name + "-已完成");
                }
                viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashRecordActivity.CardRecordAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        String str = "";
                        if (viewHolder.chongzhistate.getText().toString().equals(WashRecordActivity.this.mWalletModel.name + "-已完成")) {
                            String strTwoDecimal = DecimalUtil.twoDecimal(DecimalUtil.divide(item.realPay, "100"));
                            String str2 = item.payDate + PPSLabelView.Code + item.payTime;
                            String str3 = item.orderid;
                            if (item.i41 == 1) {
                                str = "从基本钱包划扣";
                            } else if (item.i41 == 2) {
                                str = "从赠送钱包划扣";
                            } else if (item.i41 == 3) {
                                str = "从周期钱包划扣";
                            }
                            WashRecordDetailActivity.launch(WashRecordActivity.this.getActivity(), WashRecordActivity.this.mWalletModel.typeId, strTwoDecimal, str2, str3, str, item.sysflag, item.i42);
                            return;
                        }
                        if (item.i81 == 1) {
                            if (WashRecordActivity.this.mWalletModel.typeId != 3) {
                                if (WashRecordActivity.this.mWalletModel.typeId == 16) {
                                    if (AppUtils.isUserHuaWeiScan()) {
                                        ScanQrcodeOrBarcodeActivity.launch(WashRecordActivity.this.getActivity(), WashRecordActivity.this.mWalletModel, item.orderid + "," + Integer.parseInt(item.realPay), 16);
                                    } else {
                                        ZxingScanActivity.launch(WashRecordActivity.this.getActivity(), WashRecordActivity.this.mWalletModel, item.orderid + "," + Integer.parseInt(item.realPay), 16);
                                    }
                                }
                            } else if (AppUtils.isUserHuaWeiScan()) {
                                ScanQrcodeOrBarcodeActivity.launch(WashRecordActivity.this.getActivity(), WashRecordActivity.this.mWalletModel, item.orderid + "," + Integer.parseInt(item.realPay), 3);
                            } else {
                                ZxingScanActivity.launch(WashRecordActivity.this.getActivity(), WashRecordActivity.this.mWalletModel, item.orderid + "," + Integer.parseInt(item.realPay), 3);
                            }
                            WashRecordActivity.this.getActivity().finish();
                            return;
                        }
                        new SimpleDateFormat("yyMMddHHmmss").format(Calendar.getInstance().getTime());
                        if (!StringUtils.isNotEmpty(item.s3)) {
                            WashRecordActivity.this.getActivity().finish();
                            return;
                        }
                        WashRecordActivity.this.mMac = item.s3;
                        WashRecordActivity.this.mFunction = item.i43 + "";
                        if (item.i81 == 2) {
                            WashRecordActivity.this.mSystemtime = item.systemtime.substring(2);
                            if (!StringUtils.isNotEmpty(WashRecordActivity.this.mMachineid) || !WashRecordActivity.this.mIsConnected) {
                                if (StringUtils.isNotEmpty(WashRecordActivity.this.mMac) || !WashRecordActivity.this.mIsConnected) {
                                    WashRecordActivity.this.connect(WashRecordActivity.this.mMac);
                                    return;
                                }
                                return;
                            }
                            WashRecordActivity.this.checkTimeOut(TimeOut.SendConnect, 3000);
                            WashRecordActivity.this.sendConnectData(WashRecordActivity.this.mMac, item.systemtime.substring(2));
                        }
                    }
                });
                viewHolder.lin.setOnLongClickListener(new View.OnLongClickListener() { // from class: client.android.yixiaotong.ui.wash.WashRecordActivity.CardRecordAdapter.2
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        String str;
                        String strTwoDecimal = DecimalUtil.twoDecimal(DecimalUtil.divide(item.realPay, "100"));
                        String str2 = item.payDate + PPSLabelView.Code + item.payTime;
                        String str3 = item.orderid;
                        if (item.i41 == 1) {
                            str = "从基本钱包划扣";
                        } else if (item.i41 == 2) {
                            str = "从赠送钱包划扣";
                        } else {
                            str = item.i41 == 3 ? "从周期钱包划扣" : "";
                        }
                        WashRecordDetailActivity.launch(WashRecordActivity.this.getActivity(), WashRecordActivity.this.mWalletModel.typeId, strTwoDecimal, str2, str3, str, item.sysflag, item.i42);
                        return false;
                    }
                });
            }
            return view;
        }

        class ViewHolder {
            public TextView chongzhistate;
            public TextView datetime;
            public RelativeLayout lin;
            public View line;
            public TextView money;

            public ViewHolder(View view) {
                this.line = view.findViewById(R.id.line1);
                this.datetime = (TextView) view.findViewById(R.id.tv_datetime);
                this.money = (TextView) view.findViewById(R.id.tv_money);
                this.chongzhistate = (TextView) view.findViewById(R.id.tv_chongzhistate);
                this.lin = (RelativeLayout) view.findViewById(R.id.lin);
            }
        }
    }

    private void showDialog() {
        try {
            this.mMaterialDialog = new MaterialDialog.Builder(getActivity()).content("正在连接中...").cancelable(false).progress(true, 0).show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.dismiss();
        }
    }

    private void sendReturnParamsData(String str) {
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.setContent("正在连接洗衣机设备...");
        }
        this.mBluetoothManager.sendData("f5", str, HexString.hexToBuffer(CommandUtils.getReturnSettingCommand()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendConfirmData(short s) {
        String onlineConfirmCommand = CommandUtils.getOnlineConfirmCommand(getLoginAccount().getUid(), s, this.mDeviceHexNo);
        this.mBluetoothManager.sendData("f1", this.mMac, HexString.hexToBuffer(onlineConfirmCommand));
        Log.e("test", "发送数据：" + onlineConfirmCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendConnectData(String str, String str2) {
        this.mBluetoothManager.sendData("f0", str, HexString.hexToBuffer(CommandUtils.getOnlineConnectCommand1(getLoginAccount().getUid(), str2)));
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        dismissDialog();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        BluetoothManager bluetoothManager = BluetoothManager.getInstance();
        this.mBluetoothManager = bluetoothManager;
        bluetoothManager.setListener(this);
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onConnected(String str) {
        this.mCurrentCheckTimeOut = null;
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.setContent("蓝牙配对成功...");
        }
        BluetoothDevice bluetoothDevice = this.mBluetoothManager.getBluetoothDevice(str);
        if (this.mBluetoothManager.isBluetoothLeMode()) {
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothDevice.getAllBluetoothGattCharacteristic()) {
                if (bluetoothGattCharacteristic.getUuid().toString().toLowerCase().indexOf("0000ffe1") == 0) {
                    bluetoothDevice.setReadWriteBluetoothGattCharacteristic(bluetoothGattCharacteristic);
                    sendReturnParamsData(str);
                }
            }
            dismissDialog();
            BluetoothManager.getInstance().disConnectAll();
            ToastUtils.show(getContext(), "您连接的不是洗衣机设备!");
        } else {
            sendReturnParamsData(str);
        }
        dismissDialog();
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDataReceived(String str, byte[] bArr) {
        Log.e("test", "onDataReceived:" + HexString.bufferToHex(bArr));
        if (CommandUtils.isReturnSettingResult(bArr)) {
            this.mCurrentCheckTimeOut = null;
            if (CommandUtils.getReturnSettingResultStatus(bArr)) {
                this.mDeviceHexID = CommandUtils.getReturnSettingDeviceIdResult(bArr);
                if (HexString.bufferToHex(bArr).substring(26, 28).toUpperCase().equals("01")) {
                    sendConnectData(str, this.mSystemtime);
                    return;
                } else if (HexString.bufferToHex(bArr).substring(26, 28).toUpperCase().equals("01")) {
                    dismissDialog();
                    ToastUtils.show(getActivity(), "洗衣机正忙，请稍后再使用！");
                    return;
                } else {
                    dismissDialog();
                    ToastUtils.show(getActivity(), "洗衣机有异常，错误码：" + HexString.bufferToHex(bArr).substring(26, 28).toUpperCase());
                    return;
                }
            }
            return;
        }
        if (CommandUtils.isConfirmResult(bArr)) {
            if (CommandUtils.getConfirmResultStatus(bArr) == 0) {
                ToastUtils.show(getActivity(), "启动成功！");
                finish();
                return;
            } else {
                ToastUtils.show(getActivity(), "启动失败！" + HexString.bufferToHex(bArr));
                finish();
                return;
            }
        }
        if (CommandUtils.isConnectResult(bArr)) {
            this.mCurrentCheckTimeOut = null;
            short connectResultStatus = CommandUtils.getConnectResultStatus(bArr);
            if (connectResultStatus != 0) {
                if (connectResultStatus == 2) {
                    this.mDeviceHexNo = CommandUtils.getConnectResultDeviceHexNo(bArr);
                    sendConfirmData(Short.parseShort(this.mFunction));
                    return;
                } else {
                    ToastUtils.show(getActivity(), "洗衣机有异常，错误码：" + ((int) connectResultStatus));
                    finish();
                    return;
                }
            }
            long connectResultUserId = CommandUtils.getConnectResultUserId(bArr);
            Math.max(0, (int) CommandUtils.getConnectResultBalance(bArr));
            String connectResultTime = CommandUtils.getConnectResultTime(bArr);
            this.mDeviceHexNo = CommandUtils.getConnectResultDeviceHexNo(bArr);
            Log.e("test", connectResultUserId + "  " + connectResultTime);
            if (connectResultUserId == 0 || connectResultTime.startsWith("000000")) {
                sendConfirmData(Short.parseShort(this.mFunction));
                return;
            }
            int i = Integer.parseInt(this.mTimeYear.substring(0, 4));
            if (Integer.parseInt(this.mTimeYear.substring(5, 7)) < Integer.parseInt(connectResultTime.substring(0, 2))) {
                i--;
            }
            updateOrder(connectResultUserId + "", i + connectResultTime);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        BluetoothManager.getInstance().disConnectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTimeOut(TimeOut timeOut, int i) {
        this.mCurrentCheckTimeOut = timeOut;
        MainThreadExecutor.getInstance().executeDelayed(new CheckRunnable(timeOut), Math.max(i, 100));
    }

    private class CheckRunnable implements Runnable {
        private TimeOut timeOut;

        public CheckRunnable(TimeOut timeOut) {
            this.timeOut = timeOut;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TimeOut.SendConnect == WashRecordActivity.this.mCurrentCheckTimeOut) {
                WashRecordActivity.this.mIsConnected = false;
                ToastUtils.show(WashRecordActivity.this.getContext(), "已断开与洗衣机的连接,请重试！");
                BluetoothManager.getInstance().disConnectAll();
            } else if (TimeOut.Connect == WashRecordActivity.this.mCurrentCheckTimeOut) {
                WashRecordActivity.this.mIsConnected = false;
                WashRecordActivity.this.dismissDialog();
                ToastUtils.show(WashRecordActivity.this.getContext(), "洗衣机设备连接超时,请重试！");
                BluetoothManager.getInstance().stopScan();
                BluetoothManager.getInstance().disConnectAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connect(final String str) {
        if (this.mBluetoothManager.isBluetoothLeMode()) {
            showDialog();
            this.mBluetoothManager.disConnectAll();
            runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.wash.WashRecordActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    Log.e("demo", "1:开始建立物理连接!");
                    WashRecordActivity.this.checkTimeOut(TimeOut.Connect, 8000);
                    WashRecordActivity.this.mBluetoothManager.connect(str);
                }
            }, 10L);
            return;
        }
        ToastUtils.show(getContext(), "请在系统蓝牙设置中绑定需要连接的洗衣机设备!", 1);
    }

    private void updateOrder(final String str, final String str2) {
        BusinessControllers.getInstance().WashUpdateOrder(getLoginAccount(), str, str2, RandomUtils.getRandNumMaxStringNonO(6), new Listener<WashOrderBean>() { // from class: client.android.yixiaotong.ui.wash.WashRecordActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WashOrderBean washOrderBean, Object... objArr) {
                if (washOrderBean != null) {
                    ToastUtils.show(WashRecordActivity.this.getActivity(), "上传订单成功！");
                    if (!WashRecordActivity.this.mSystemtime.substring(2).equals(str2.substring(4)) || !(WashRecordActivity.this.getLoginAccount().getUid() + "").equals(str)) {
                        WashRecordActivity washRecordActivity = WashRecordActivity.this;
                        washRecordActivity.sendConfirmData(Short.parseShort(washRecordActivity.mFunction));
                        return;
                    } else {
                        ToastUtils.show(WashRecordActivity.this.getActivity(), "订单已完成！！");
                        WashRecordActivity.this.finish();
                        return;
                    }
                }
                ToastUtils.show(WashRecordActivity.this.getActivity(), "数据出错");
                WashRecordActivity.this.finish();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                ToastUtils.show(WashRecordActivity.this.getActivity(), clientException.getDetail());
                WashRecordActivity.this.finish();
            }
        });
    }
}
