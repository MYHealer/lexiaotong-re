package client.android.yixiaotong.ui.wash;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.util.ClientException;
import android.client.bluetoothsdk.util.TimeOut;
import android.client.bluetoothsdk.util.executor.MainThreadExecutor;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.wash.WashAuthorizeBean;
import client.android.yixiaotong.controller.bean.wash.WashOrderBean;
import client.android.yixiaotong.controller.bean.wash.WashParameterBean;
import client.android.yixiaotong.controller.bean.wash.WashParametersBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.OrderIdUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.random.RandomUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WashSelectOperateActivity extends BaseActivity {
    public static final String EXTRA_BLESTATE = "extra_blestate";
    public static final String EXTRA_DATA = "extra_data";
    public static final String EXTRA_DEVICENAME = "extra_devicename";
    public static final String EXTRA_DEVICENO = "extra_deviceno";
    public static final String EXTRA_MAC = "extra_mac";
    public static final String EXTRA_WALLET = "extra_wallet";
    ListView mList;
    private MaterialDialog mMaterialDialog;
    private String mOrderId;
    private String mPlayData;
    private String mPlayTime;
    TextView mTvState;
    TextView mTvWashNo;
    TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    private WashParameterAdapter washParameterAdapter;
    private String mDeviceNo = "";
    private String mData = "";
    private String mMac = "";
    private String mDeviceName = "";
    private boolean mIsConnect = false;
    private boolean mIsFirstConnect = true;
    private boolean mIsEnable = true;
    private List<WashParameterBean> washParametersBeans = new ArrayList();
    private SystemErrorTip.SystemErrorDialogListener systemErrorDialogListener = new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.wash.WashSelectOperateActivity.1
        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
        public void onConfirm() {
            BluetoothSDK.getInstance().closeBLE();
            WashSelectOperateActivity.this.finish();
        }
    };
    private boolean mEnableOrder = true;

    static {
        StubApp.interface11(7746);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mTvWashNo = (TextView) findViewById(R.id.tv_wash_no);
        this.mTvState = (TextView) findViewById(R.id.tv_state);
        this.mList = (ListView) findViewById(R.id.lv_list);
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2, String str3, boolean z) {
        Intent intent = new Intent(activity, (Class<?>) WashSelectOperateActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("extra_mac", str);
        intent.putExtra("extra_deviceno", str2);
        intent.putExtra("extra_data", str3);
        intent.putExtra("extra_blestate", z);
        activity.startActivity(intent);
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("洗衣机详情");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvWashNo.setText(this.mDeviceNo);
    }

    private void setBluetoothListener() {
        BluetoothSDK.getInstance().setListener(new BluetoothConnectListener() { // from class: client.android.yixiaotong.ui.wash.WashSelectOperateActivity.2
            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onStart(BluetoothDevice bluetoothDevice) {
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessSendData(BluetoothDevice bluetoothDevice, String str) {
                ToastUtils.show(WashSelectOperateActivity.this.getActivity(), "发送数据成功");
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onFail(final BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
                if (WashSelectOperateActivity.this.mIsEnable) {
                    if (WashSelectOperateActivity.this.mIsFirstConnect) {
                        WashSelectOperateActivity.this.mIsFirstConnect = false;
                        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.wash.WashSelectOperateActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BluetoothSDK.getInstance().ConnectManagerDevice(bluetoothDevice);
                            }
                        }, 1000L);
                    } else if (StringUtils.isNotEmpty(str)) {
                        ErrorUtil.onFailBlueTooth(WashSelectOperateActivity.this.getActivity(), WashSelectOperateActivity.this.mVTitleBar.getTitleViewContent(), str, 204, true);
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(WashSelectOperateActivity.this.getActivity(), WashSelectOperateActivity.this.systemErrorDialogListener, "设备已断开连接" + timeOut);
                    }
                }
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onBluetoothException(ClientException clientException) {
                SystemErrorTip.getInstance().showTipDialog(WashSelectOperateActivity.this.getActivity(), WashSelectOperateActivity.this.systemErrorDialogListener, "请打开手机蓝牙");
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessConnect(BluetoothDevice bluetoothDevice) {
                BluetoothSDK.getInstance().SendDataManagerDevice("AA");
                WashSelectOperateActivity.this.mIsConnect = true;
                if (StringUtils.isNotEmpty(WashSelectOperateActivity.this.mPlayTime) && StringUtils.isNotEmpty(WashSelectOperateActivity.this.mPlayData)) {
                    WashSelectOperateActivity.this.disDialog();
                    WashingActivity.launch(WashSelectOperateActivity.this.getActivity(), WashSelectOperateActivity.this.mWalletModel, WashSelectOperateActivity.this.mPlayTime, WashSelectOperateActivity.this.mPlayData, WashSelectOperateActivity.this.mOrderId, 0, "", WashSelectOperateActivity.this.mMac);
                    WashSelectOperateActivity.this.getActivity().finish();
                }
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        getData();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        BluetoothSDK.getInstance().setListener(null);
    }

    private void getData() {
        BusinessControllers.getInstance().WashParameters(getLoginAccount(), this.mMac, this.mWalletModel.typeId, RandomUtils.getRandNumMaxStringNonO(6), new Listener<WashParametersBean>() { // from class: client.android.yixiaotong.ui.wash.WashSelectOperateActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WashParametersBean washParametersBean, Object... objArr) {
                if (WashSelectOperateActivity.this.mIsEnable) {
                    WashSelectOperateActivity.this.mTvState.setText(washParametersBean.installlocation);
                    WashSelectOperateActivity.this.washParametersBeans.addAll(washParametersBean.getList());
                    WashSelectOperateActivity.this.washParameterAdapter.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (WashSelectOperateActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(WashSelectOperateActivity.this.getActivity(), WashSelectOperateActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    private class WashParameterAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private WashParameterAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return WashSelectOperateActivity.this.washParametersBeans.size();
        }

        @Override // android.widget.Adapter
        public WashParameterBean getItem(int i) {
            return (WashParameterBean) WashSelectOperateActivity.this.washParametersBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(WashSelectOperateActivity.this.getContext()).inflate(R.layout.wash_parameter_list_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final WashParameterBean item = getItem(i);
            if (StringUtils.isNotEmpty(item.F) && StringUtils.isNotEmpty(item.M) && StringUtils.isNotEmpty(item.N)) {
                viewHolder.introduce.setText("简介：" + item.msg);
                if (item.F.equals("1")) {
                    viewHolder.pattern.setText("脱水");
                    viewHolder.icon.setImageResource(R.mipmap.l_xiyi_tuoshui);
                } else if (item.F.equals("2")) {
                    viewHolder.pattern.setText("极速洗");
                    viewHolder.icon.setImageResource(R.mipmap.l_xiyi_kuaisuxi);
                } else if (item.F.equals("3")) {
                    viewHolder.pattern.setText("标准洗");
                    viewHolder.icon.setImageResource(R.mipmap.l_xiyi_biaozhunxi);
                } else if (item.F.equals("4")) {
                    viewHolder.pattern.setText("大件洗");
                    viewHolder.icon.setImageResource(R.mipmap.l_xiyi_dajianxi);
                } else {
                    viewHolder.pattern.setText("其他");
                    viewHolder.introduce.setText("洗衣-其他");
                }
                viewHolder.money.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(item.M, "100")));
                System.currentTimeMillis();
                viewHolder.rel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashSelectOperateActivity.WashParameterAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        WashSelectOperateActivity.this.getOrder(item.M, item.F);
                    }
                });
            }
            return view;
        }

        class ViewHolder {
            public ImageView icon;
            public TextView introduce;
            public TextView money;
            public TextView pattern;
            public RelativeLayout rel;

            public ViewHolder(View view) {
                this.pattern = (TextView) view.findViewById(R.id.tv_pattern);
                this.introduce = (TextView) view.findViewById(R.id.tv_introduce);
                this.money = (TextView) view.findViewById(R.id.tv_money);
                this.icon = (ImageView) view.findViewById(R.id.icon_xiyi);
                this.rel = (RelativeLayout) view.findViewById(R.id.rel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOrder(final String str, final String str2) {
        if (this.mEnableOrder) {
            this.mEnableOrder = false;
            String waterOrderID = OrderIdUtils.getWaterOrderID(this.mWalletModel.typeId);
            final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
            BusinessControllers.getInstance().WashOrder(getLoginAccount(), this.mWalletModel.typeId, str + "", this.mDeviceNo, getLoginAccount().getAccountManagetStore().getUserInfo().Mobile, "1", waterOrderID, OrderIdUtils.getLocalDate("yyyyMMddHHmmss"), this.mWalletModel.ID, this.mDeviceNo, randNumMaxStringNonO, str2 + "", this.mMac, new Listener<WashOrderBean>() { // from class: client.android.yixiaotong.ui.wash.WashSelectOperateActivity.4
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, WashOrderBean washOrderBean, Object... objArr) {
                    if (WashSelectOperateActivity.this.mIsEnable) {
                        WashSelectOperateActivity.this.mEnableOrder = true;
                        if (!StringUtils.isNotEmpty(washOrderBean.orderid) || !washOrderBean.rand.equals(randNumMaxStringNonO)) {
                            SystemErrorTip.getInstance().showTipDialog(WashSelectOperateActivity.this.getActivity(), WashSelectOperateActivity.this.systemErrorDialogListener, "数据出错");
                            return;
                        }
                        WashSelectOperateActivity.this.mOrderId = washOrderBean.orderid;
                        LocalBusinessStore.saveOrderMoney(WashSelectOperateActivity.this.getContext(), WashSelectOperateActivity.this.mWalletModel.typeId, str + "");
                        WashSelectOperateActivity.this.getAuthorize(str);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                    if (WashSelectOperateActivity.this.mIsEnable) {
                        WashSelectOperateActivity.this.mEnableOrder = true;
                        if (clientException.getCode() == 4060) {
                            ToastUtils.show(WashSelectOperateActivity.this.getActivity(), clientException.getDetail());
                            WashRecordActivity.launch(WashSelectOperateActivity.this.getActivity(), WashSelectOperateActivity.this.mWalletModel, "1", WashSelectOperateActivity.this.mDeviceNo, str2 + "", WashSelectOperateActivity.this.mMac);
                            WashSelectOperateActivity.this.finish();
                        } else {
                            BluetoothSDK.getInstance().closeBLE();
                            ErrorUtil.onFailResult(WashSelectOperateActivity.this.getActivity(), WashSelectOperateActivity.this.mVTitleBar.getTitleViewContent(), clientException, true);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAuthorize(String str) {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().WashAuthorize(getLoginAccount(), this.mOrderId, "0", this.mDeviceNo, this.mData, this.mWalletModel.typeId + "", str + "", "1", randNumMaxStringNonO, "1", new Listener<WashAuthorizeBean>() { // from class: client.android.yixiaotong.ui.wash.WashSelectOperateActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (WashSelectOperateActivity.this.mMaterialDialog == null) {
                    WashSelectOperateActivity.this.showDialog();
                } else {
                    WashSelectOperateActivity.this.mMaterialDialog.setContent("正在授权中...");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WashAuthorizeBean washAuthorizeBean, Object... objArr) {
                if (WashSelectOperateActivity.this.mIsEnable) {
                    WashSelectOperateActivity.this.mMaterialDialog.setContent("授权成功...");
                    if (!StringUtils.isNotEmpty(washAuthorizeBean.systemData) || !StringUtils.isNotEmpty(washAuthorizeBean.systemTime) || !StringUtils.isNotEmpty(washAuthorizeBean.rand) || !washAuthorizeBean.rand.equals(randNumMaxStringNonO)) {
                        WashSelectOperateActivity.this.disDialog();
                        SystemErrorTip.getInstance().showTipDialog(WashSelectOperateActivity.this.getActivity(), WashSelectOperateActivity.this.systemErrorDialogListener, "数据出错");
                        return;
                    }
                    WashSelectOperateActivity.this.mPlayData = washAuthorizeBean.systemData;
                    WashSelectOperateActivity.this.mPlayTime = washAuthorizeBean.systemTime;
                    if (WashSelectOperateActivity.this.mIsConnect) {
                        WashSelectOperateActivity.this.disDialog();
                        WashingActivity.launch(WashSelectOperateActivity.this.getActivity(), WashSelectOperateActivity.this.mWalletModel, washAuthorizeBean.systemTime, washAuthorizeBean.systemData, WashSelectOperateActivity.this.mOrderId, 0, "", WashSelectOperateActivity.this.mMac);
                        WashSelectOperateActivity.this.getActivity().finish();
                    } else if (WashSelectOperateActivity.this.mMaterialDialog != null) {
                        WashSelectOperateActivity.this.mMaterialDialog.setContent("正在连接设备中,请稍等..");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (WashSelectOperateActivity.this.mIsEnable) {
                    WashSelectOperateActivity.this.disDialog();
                    BluetoothSDK.getInstance().closeBLE();
                    ErrorUtil.onFailResult(WashSelectOperateActivity.this.getActivity(), WashSelectOperateActivity.this.mVTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            this.mMaterialDialog = new MaterialDialog.Builder(getActivity()).content("正在授权中...").cancelable(false).progress(true, 0).show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.dismiss();
        }
    }
}
