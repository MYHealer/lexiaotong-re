package client.android.yixiaotong.ui.hairdryer;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.util.ClientException;
import android.client.bluetoothsdk.util.TimeOut;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
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
public class HairDryerRecordActivity extends BaseActivity {
    private static final String EXTRA_MACHINEID = "extra_machineid";
    public static final String EXTRA_WALLET = "extra_wallet";
    private static final String TYPE_HD_CONNECT_AGAIN = "type_hd_connect_again";
    private static final String TYPE_IS_HD_CONNECT = "type_is_hd_connect";
    private CardRecordAdapter mCardRecordAdapter;
    private ListView mCardRecordList;
    private LoadMoreFooter mLoadMoreFootView;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvErrorTip;
    private WalletModel mWalletModel;
    private String machineid;
    private int mStartIndex = 0;
    private String status = "1";
    private boolean mHasMoreData = false;
    private List<SoundWaveDrinkWaterRecordBean> mCardRecords = new ArrayList();
    private int mTotalCount = 0;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(7249);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$508(HairDryerRecordActivity hairDryerRecordActivity) {
        int i = hairDryerRecordActivity.mStartIndex;
        hairDryerRecordActivity.mStartIndex = i + 1;
        return i;
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mCardRecordList = (ListView) findViewById(R.id.lv_cardrecord);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    public static void launch(Activity activity, WalletModel walletModel, String str) {
        Intent intent = new Intent(activity, (Class<?>) HairDryerRecordActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("extra_machineid", str);
        activity.startActivity(intent);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.hairdryer.HairDryerRecordActivity$1, reason: invalid class name */
    class AnonymousClass1 implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        AnonymousClass1() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (!HairDryerRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= HairDryerRecordActivity.this.mTotalCount) {
                return;
            }
            HairDryerRecordActivity.this.mTotalCount = i3;
            HairDryerRecordActivity.this.getRecordList();
            HairDryerRecordActivity.this.mLoadMoreFootView.loadMoreData();
        }
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
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            BluetoothSDK.getInstance().closeBLE();
            PreferenceUtil.putIsHairDryerBCAgain(getContext(), TYPE_HD_CONNECT_AGAIN, false);
            PreferenceUtil.putIsHairDryerBC(getContext(), TYPE_IS_HD_CONNECT, false);
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
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerRecordActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HairDryerRecordActivity.this.mMultiStateView.setViewState(3);
                HairDryerRecordActivity.this.getRecordList();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerRecordActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                HairDryerRecordActivity.this.mStartIndex = 0;
                HairDryerRecordActivity.this.mTotalCount = 0;
                HairDryerRecordActivity.this.getRecordList();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerRecordActivity.4
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                HairDryerRecordActivity.this.getRecordList();
            }
        });
        BluetoothSDK.getInstance().setListener(new BluetoothConnectListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerRecordActivity.5
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
                Log.e("BluetoothConnect", "onSuccessConnect1");
                PreferenceUtil.putIsHairDryerBCAgain(HairDryerRecordActivity.this.getContext(), HairDryerRecordActivity.TYPE_HD_CONNECT_AGAIN, true);
                BluetoothSDK.getInstance().SendDataManagerDevice("AA");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRecordList() {
        BusinessControllers.getInstance().getDrinkWaterUnFinishOrderRecordList(getLoginAccount(), this.status, this.machineid, this.mWalletModel.typeId, this.mStartIndex, new Listener<SoundWaveDrinkWaterRecordListBean>() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerRecordActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                HairDryerRecordActivity.this.mHasMoreData = false;
                if (HairDryerRecordActivity.this.mStartIndex == 0) {
                    HairDryerRecordActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                } else {
                    HairDryerRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SoundWaveDrinkWaterRecordListBean soundWaveDrinkWaterRecordListBean, Object... objArr) {
                if (HairDryerRecordActivity.this.mIsEnable) {
                    HairDryerRecordActivity.this.mMultiStateView.setViewState(0);
                    HairDryerRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (soundWaveDrinkWaterRecordListBean != null) {
                        if (HairDryerRecordActivity.this.mStartIndex == 0) {
                            HairDryerRecordActivity.this.mCardRecords.clear();
                            HairDryerRecordActivity.this.mCardRecords.addAll(soundWaveDrinkWaterRecordListBean.getSortList());
                        } else {
                            HairDryerRecordActivity.this.mCardRecords.addAll(soundWaveDrinkWaterRecordListBean.getSortList());
                        }
                        HairDryerRecordActivity.this.mCardRecordAdapter.notifyDataSetChanged();
                        if (soundWaveDrinkWaterRecordListBean.pageCount - 1 > soundWaveDrinkWaterRecordListBean.pageIndex) {
                            HairDryerRecordActivity.this.mHasMoreData = true;
                            HairDryerRecordActivity.access$508(HairDryerRecordActivity.this);
                            HairDryerRecordActivity.this.mLoadMoreFootView.reset();
                        } else {
                            HairDryerRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                        }
                        if (soundWaveDrinkWaterRecordListBean.count == 0) {
                            HairDryerRecordActivity.this.mMultiStateView.setViewState(2);
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (HairDryerRecordActivity.this.mIsEnable) {
                    if (HairDryerRecordActivity.this.mStartIndex == 0) {
                        HairDryerRecordActivity.this.mMultiStateView.setViewState(1);
                        HairDryerRecordActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    } else {
                        HairDryerRecordActivity.this.mLoadMoreFootView.resetForFail();
                    }
                    HairDryerRecordActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    SystemErrorTip.getInstance().showTipDialog(HairDryerRecordActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    private class CardRecordAdapter extends BaseAdapter {
        List<SoundWaveDrinkWaterRecordBean> mCardRecords;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public CardRecordAdapter(List<SoundWaveDrinkWaterRecordBean> list) {
            new ArrayList();
            this.mCardRecords = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mCardRecords.size();
        }

        @Override // android.widget.Adapter
        public SoundWaveDrinkWaterRecordBean getItem(int i) {
            return this.mCardRecords.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            final ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(HairDryerRecordActivity.this.getContext()).inflate(R.layout.wash_record_list_item, (ViewGroup) null);
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
            if (StringUtils.isNotEmpty(item.getPayDate()) && StringUtils.isNotEmpty(item.getPayTime()) && StringUtils.isNotEmpty(item.getRealPay() + "") && StringUtils.isNotEmpty(item.getOrderid())) {
                viewHolder.datetime.setText(item.getPayDate() + PPSLabelView.Code + item.getPayTime());
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                final String str = decimalFormat.format(((double) ((item.getRealPay() * 100) / 100)) / 100.0d);
                viewHolder.money.setText(x.A + str);
                if (item.getSysflag() == 1) {
                    viewHolder.money.setText(x.A + decimalFormat.format(((double) ((item.getPayMoney() * 100) / 100)) / 100.0d));
                    viewHolder.chongzhistate.setText("吹风-未激活");
                } else if (item.getSysflag() == 2) {
                    viewHolder.money.setText(x.A + decimalFormat.format(((double) ((item.getPayMoney() * 100) / 100)) / 100.0d));
                    viewHolder.chongzhistate.setText("吹风-待校验");
                } else {
                    viewHolder.chongzhistate.setText("吹风-已完成");
                }
                viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerRecordActivity.CardRecordAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        String str2;
                        String str3;
                        if (viewHolder.chongzhistate.getText().toString().equals("吹风-已完成")) {
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
                                    WashRecordDetailActivity.launch(HairDryerRecordActivity.this.getActivity(), str, str4, orderid, str2, item.getSysflag(), item.payMoney + "");
                                    return;
                                }
                                str3 = "从赠送钱包划扣";
                            }
                            str2 = str3;
                            WashRecordDetailActivity.launch(HairDryerRecordActivity.this.getActivity(), str, str4, orderid, str2, item.getSysflag(), item.payMoney + "");
                            return;
                        }
                        if (AppUtils.isUserHuaWeiScan()) {
                            ScanQrcodeOrBarcodeActivity.launch(HairDryerRecordActivity.this.getActivity(), HairDryerRecordActivity.this.mWalletModel, item.getOrderid(), 8);
                        } else {
                            ZxingScanActivity.launch(HairDryerRecordActivity.this.getActivity(), HairDryerRecordActivity.this.mWalletModel, item.getOrderid(), 8);
                        }
                        HairDryerRecordActivity.this.getActivity().finish();
                    }
                });
                viewHolder.lin.setOnLongClickListener(new View.OnLongClickListener() { // from class: client.android.yixiaotong.ui.hairdryer.HairDryerRecordActivity.CardRecordAdapter.2
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
                                WashRecordDetailActivity.launch(HairDryerRecordActivity.this.getActivity(), str, str4, orderid, str2, item.getSysflag(), item.payMoney + "");
                                return false;
                            }
                            str3 = "从赠送钱包划扣";
                        }
                        str2 = str3;
                        WashRecordDetailActivity.launch(HairDryerRecordActivity.this.getActivity(), str, str4, orderid, str2, item.getSysflag(), item.payMoney + "");
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
