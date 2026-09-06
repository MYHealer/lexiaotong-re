package client.android.yixiaotong.ui.drinkwater;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.util.ClientException;
import android.client.bluetoothsdk.util.TimeOut;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SoundWaveDrinkWaterRecordBean;
import client.android.yixiaotong.controller.bean.SoundWaveDrinkWaterRecordListBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity;
import client.android.yixiaotong.ui.scancode.ZxingScanActivity;
import client.android.yixiaotong.ui.wash.WashRecordDetailActivity;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.drinkwater.PreferenceUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DrinkWaterRecordActivity extends BaseActivity {
    private static final String EXTRA_MACHINEID = "extra_machineid";
    public static final String EXTRA_WALLET = "extra_wallet";
    private static final String TYPE_BLUE_CONNECT_AGAIN = "type_blue_connect_again";
    private CardRecordAdapter mCardRecordAdapter;
    private ListView mCardRecordList;
    private LoadMoreFooter mLoadMoreFootView;
    private String mMachineid;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvErrorTip;
    private WalletModel mWalletModel;
    private int mStartIndex = 0;
    private boolean mIsEnable = true;
    private List<SoundWaveDrinkWaterRecordBean> mCardRecords = new ArrayList();

    static {
        StubApp.interface11(7113);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$208(DrinkWaterRecordActivity drinkWaterRecordActivity) {
        int i = drinkWaterRecordActivity.mStartIndex;
        drinkWaterRecordActivity.mStartIndex = i + 1;
        return i;
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mCardRecordList = (ListView) findViewById(R.id.lv_cardrecord);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    public static void launch(Activity activity, WalletModel walletModel, String str) {
        Intent intent = new Intent(activity, (Class<?>) DrinkWaterRecordActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("extra_machineid", str);
        activity.startActivity(intent);
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
        this.mTitleBar.setTitleView("消费记录");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBackConnect(getActivity());
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            BluetoothSDK.getInstance().closeBLE();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mCardRecordList.addFooterView(loadMoreFooter);
        this.mCardRecordList.setFooterDividersEnabled(false);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterRecordActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrinkWaterRecordActivity.this.mMultiStateView.setViewState(3);
                DrinkWaterRecordActivity.this.getRecordList();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterRecordActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                DrinkWaterRecordActivity.this.mStartIndex = 0;
                DrinkWaterRecordActivity.this.getRecordList();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterRecordActivity.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                DrinkWaterRecordActivity.this.getRecordList();
            }
        });
        BluetoothSDK.getInstance().setListener(new BluetoothConnectListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterRecordActivity.4
            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onStart(BluetoothDevice bluetoothDevice) {
                super.onStart(bluetoothDevice);
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onBluetoothException(ClientException clientException) {
                super.onBluetoothException(clientException);
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
                super.onFail(bluetoothDevice, timeOut, str);
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessConnect(BluetoothDevice bluetoothDevice) {
                super.onSuccessConnect(bluetoothDevice);
                PreferenceUtil.putIsBlueConnectAgain(DrinkWaterRecordActivity.this.getContext(), DrinkWaterRecordActivity.TYPE_BLUE_CONNECT_AGAIN, true);
                BluetoothSDK.getInstance().SendDataManagerDevice("AA");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRecordList() {
        BusinessControllers.getInstance().getDrinkWaterUnFinishOrderRecordList(getLoginAccount(), "1", this.mMachineid, this.mWalletModel.typeId, this.mStartIndex, new Listener<SoundWaveDrinkWaterRecordListBean>() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterRecordActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                if (DrinkWaterRecordActivity.this.mStartIndex == 0) {
                    DrinkWaterRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                } else {
                    DrinkWaterRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SoundWaveDrinkWaterRecordListBean soundWaveDrinkWaterRecordListBean, Object... objArr) {
                if (DrinkWaterRecordActivity.this.mIsEnable) {
                    DrinkWaterRecordActivity.this.mMultiStateView.setViewState(0);
                    DrinkWaterRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (soundWaveDrinkWaterRecordListBean != null) {
                        if (DrinkWaterRecordActivity.this.mStartIndex == 0) {
                            DrinkWaterRecordActivity.this.mCardRecords.clear();
                            DrinkWaterRecordActivity.this.mCardRecords.addAll(soundWaveDrinkWaterRecordListBean.getSortList());
                        } else {
                            DrinkWaterRecordActivity.this.mCardRecords.addAll(soundWaveDrinkWaterRecordListBean.getSortList());
                        }
                        DrinkWaterRecordActivity.this.mCardRecordAdapter.notifyDataSetChanged();
                        if (soundWaveDrinkWaterRecordListBean.pageCount - 1 <= soundWaveDrinkWaterRecordListBean.pageIndex) {
                            DrinkWaterRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                        } else {
                            DrinkWaterRecordActivity.access$208(DrinkWaterRecordActivity.this);
                            DrinkWaterRecordActivity.this.mLoadMoreFootView.reset();
                        }
                        if (soundWaveDrinkWaterRecordListBean.count == 0) {
                            DrinkWaterRecordActivity.this.mMultiStateView.setViewState(2);
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (DrinkWaterRecordActivity.this.mIsEnable) {
                    if (DrinkWaterRecordActivity.this.mStartIndex == 0) {
                        DrinkWaterRecordActivity.this.mMultiStateView.setViewState(1);
                        DrinkWaterRecordActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    } else {
                        DrinkWaterRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    DrinkWaterRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    SystemErrorTip.getInstance().showTipDialog(DrinkWaterRecordActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    private class CardRecordAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public CardRecordAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return DrinkWaterRecordActivity.this.mCardRecords.size();
        }

        @Override // android.widget.Adapter
        public SoundWaveDrinkWaterRecordBean getItem(int i) {
            return (SoundWaveDrinkWaterRecordBean) DrinkWaterRecordActivity.this.mCardRecords.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            final ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(DrinkWaterRecordActivity.this.getContext()).inflate(R.layout.wash_record_list_item, (ViewGroup) null);
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
            final SoundWaveDrinkWaterRecordBean item = getItem(i);
            if (StringUtils.isNotEmpty(item.getPayDate()) && StringUtils.isNotEmpty(item.getPayTime()) && StringUtils.isNotEmpty(item.getPayMoney() + "") && StringUtils.isNotEmpty(item.getOrderid())) {
                viewHolder.datetime.setText(item.getPayDate() + PPSLabelView.Code + item.getPayTime());
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                final String str = decimalFormat.format(((double) ((item.getRealPay() * 100) / 100)) / 100.0d);
                viewHolder.money.setText(x.A + str);
                if (item.getSysflag() == 1) {
                    viewHolder.money.setText(x.A + decimalFormat.format(((double) ((item.getPayMoney() * 100) / 100)) / 100.0d));
                    viewHolder.chongzhistate.setText("饮水-未激活");
                } else if (item.getSysflag() == 2) {
                    viewHolder.money.setText(x.A + decimalFormat.format(((double) ((item.getPayMoney() * 100) / 100)) / 100.0d));
                    viewHolder.chongzhistate.setText("饮水-待校验");
                } else {
                    viewHolder.chongzhistate.setText("饮水-已完成");
                }
                viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterRecordActivity.CardRecordAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        String str2;
                        String str3;
                        if (viewHolder.chongzhistate.getText().toString().equals("饮水-已完成")) {
                            String str4 = item.getPayDate() + PPSLabelView.Code + item.getPayTime();
                            String orderid = item.getOrderid();
                            if (item.getI41() == 1) {
                                str3 = "从基本钱包划扣";
                            } else {
                                if (item.getI41() != 2) {
                                    if (item.getI41() == 3) {
                                        str3 = "从周期钱包划扣";
                                    } else {
                                        str2 = "";
                                    }
                                    WashRecordDetailActivity.launch(DrinkWaterRecordActivity.this.getActivity(), str, str4, orderid, str2, item.getSysflag(), item.getPayMoney() + "");
                                    return;
                                }
                                str3 = "从赠送钱包划扣";
                            }
                            str2 = str3;
                            WashRecordDetailActivity.launch(DrinkWaterRecordActivity.this.getActivity(), str, str4, orderid, str2, item.getSysflag(), item.getPayMoney() + "");
                            return;
                        }
                        if (AppUtils.isUserHuaWeiScan()) {
                            ScanQrcodeOrBarcodeActivity.launch(DrinkWaterRecordActivity.this.getActivity(), DrinkWaterRecordActivity.this.mWalletModel, item.orderid, 6);
                        } else {
                            ZxingScanActivity.launch(DrinkWaterRecordActivity.this.getActivity(), DrinkWaterRecordActivity.this.mWalletModel, item.orderid, 6);
                        }
                        DrinkWaterRecordActivity.this.getActivity().finish();
                    }
                });
                viewHolder.lin.setOnLongClickListener(new View.OnLongClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.DrinkWaterRecordActivity.CardRecordAdapter.2
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        String str2;
                        String str3;
                        String str4 = item.getPayDate() + PPSLabelView.Code + item.getPayTime();
                        String orderid = item.getOrderid();
                        if (item.getI41() == 1) {
                            str3 = "从基本钱包划扣";
                        } else {
                            if (item.getI41() != 2) {
                                if (item.getI41() == 3) {
                                    str3 = "从周期钱包划扣";
                                } else {
                                    str2 = "";
                                }
                                WashRecordDetailActivity.launch(DrinkWaterRecordActivity.this.getActivity(), str, str4, orderid, str2, item.getSysflag(), item.payMoney + "");
                                return false;
                            }
                            str3 = "从赠送钱包划扣";
                        }
                        str2 = str3;
                        WashRecordDetailActivity.launch(DrinkWaterRecordActivity.this.getActivity(), str, str4, orderid, str2, item.getSysflag(), item.payMoney + "");
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
}
