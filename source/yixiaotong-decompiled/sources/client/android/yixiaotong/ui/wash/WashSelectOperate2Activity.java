package client.android.yixiaotong.ui.wash;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.util.ClientException;
import android.client.bluetoothsdk.util.TimeOut;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import client.android.yixiaotong.baseutil.IntegerUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.wash.WashOrderBean;
import client.android.yixiaotong.controller.bean.wash.WashParameterBean;
import client.android.yixiaotong.controller.bean.wash.WashParametersBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.OrderIdUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.bluetooth.CommandUtils;
import client.android.yixiaotong.util.random.RandomUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.stub.StubApp;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WashSelectOperate2Activity extends BaseActivity {
    public static final String EXTRA_DEVICENAME = "extra_devicename";
    public static final String EXTRA_DEVICENO = "extra_deviceno";
    public static final String EXTRA_MAC = "extra_mac";
    public static final String EXTRA_WALLET = "extra_wallet";
    private String mFunction;
    ListView mList;
    private MaterialDialog mMaterialDialog;
    private String mOrderId;
    private String mTimeYear;
    TextView mTvState;
    TextView mTvWashNo;
    TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    private StringBuilder stringBuilder;
    private WashParameterAdapter washParameterAdapter;
    private boolean mDeviceIsReady = false;
    private String mDeviceNo = "";
    private boolean isHasOrder = false;
    private String mMac = "";
    private String mDeviceName = "";
    private boolean mIsConnect = false;
    private boolean mIsFirstConnect = true;
    private List<WashParameterBean> washParametersBeans = new ArrayList();
    public int leftCount = 0;

    static {
        StubApp.interface11(7736);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mTvWashNo = (TextView) findViewById(R.id.tv_wash_no);
        this.mTvState = (TextView) findViewById(R.id.tv_state);
        this.mList = (ListView) findViewById(R.id.lv_list);
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2) {
        Intent intent = new Intent(activity, (Class<?>) WashSelectOperate2Activity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("extra_mac", str);
        intent.putExtra("extra_devicename", str2);
        activity.startActivity(intent);
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2, String str3) {
        Intent intent = new Intent(activity, (Class<?>) WashSelectOperate2Activity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("extra_mac", str);
        intent.putExtra("extra_devicename", str2);
        intent.putExtra("extra_deviceno", str3);
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
        BluetoothSDK.getInstance().setListener(new BluetoothConnectListener() { // from class: client.android.yixiaotong.ui.wash.WashSelectOperate2Activity.1
            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onStart(BluetoothDevice bluetoothDevice) {
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessSendData(BluetoothDevice bluetoothDevice, String str) {
                Log.e("test", "onSuccessSendData:" + str);
                if (!str.startsWith("550001") || str.length() < 8) {
                    if (WashSelectOperate2Activity.this.stringBuilder == null || WashSelectOperate2Activity.this.stringBuilder.toString().length() < 8) {
                        if (WashSelectOperate2Activity.this.stringBuilder != null && WashSelectOperate2Activity.this.stringBuilder.toString().length() < 8) {
                            WashSelectOperate2Activity.this.stringBuilder.append(str);
                            if (WashSelectOperate2Activity.this.stringBuilder.toString().length() >= 8) {
                                byte[] bArrHexToBuffer = HexString.hexToBuffer(WashSelectOperate2Activity.this.stringBuilder.toString().substring(6, 8));
                                byte[] bArr = new byte[4];
                                System.arraycopy(bArrHexToBuffer, 0, bArr, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                                int iBytesToInt2 = IntegerUtils.bytesToInt2(bArr, 0);
                                WashSelectOperate2Activity washSelectOperate2Activity = WashSelectOperate2Activity.this;
                                washSelectOperate2Activity.leftCount = ((iBytesToInt2 + 1) * 2) - (washSelectOperate2Activity.stringBuilder.toString().length() - 6);
                            }
                        } else {
                            if (!str.startsWith("55") || str.length() >= 8) {
                                return;
                            }
                            WashSelectOperate2Activity.this.stringBuilder = new StringBuilder();
                            WashSelectOperate2Activity.this.stringBuilder.append(str);
                            WashSelectOperate2Activity.this.leftCount = 1;
                        }
                    } else {
                        WashSelectOperate2Activity.this.stringBuilder.append(str);
                        WashSelectOperate2Activity.this.leftCount -= str.length();
                    }
                } else {
                    WashSelectOperate2Activity.this.stringBuilder = new StringBuilder();
                    WashSelectOperate2Activity.this.stringBuilder.append(str);
                    byte[] bArrHexToBuffer2 = HexString.hexToBuffer(str.substring(6, 8));
                    byte[] bArr2 = new byte[4];
                    System.arraycopy(bArrHexToBuffer2, 0, bArr2, 4 - bArrHexToBuffer2.length, bArrHexToBuffer2.length);
                    WashSelectOperate2Activity.this.leftCount = ((IntegerUtils.bytesToInt2(bArr2, 0) + 1) * 2) - (str.length() - 6);
                }
                if (WashSelectOperate2Activity.this.leftCount > 0 || WashSelectOperate2Activity.this.stringBuilder == null) {
                    return;
                }
                String string = WashSelectOperate2Activity.this.stringBuilder.toString();
                WashSelectOperate2Activity.this.stringBuilder = null;
                WashSelectOperate2Activity.this.managerData(HexString.hexToBuffer(string));
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
                ToastUtils.show(WashSelectOperate2Activity.this.getActivity(), "连接设备失败！");
                WashSelectOperate2Activity.this.finish();
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onBluetoothException(ClientException clientException) {
                ToastUtils.show(WashSelectOperate2Activity.this.getActivity(), "请打开蓝牙");
                WashSelectOperate2Activity.this.finish();
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessConnect(BluetoothDevice bluetoothDevice) {
                WashSelectOperate2Activity.this.mIsConnect = true;
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    private void getData() {
        BusinessControllers.getInstance().WashParameters2(getLoginAccount(), this.mMac, this.mWalletModel.typeId, RandomUtils.getRandNumMaxStringNonO(6), new Listener<WashParametersBean>() { // from class: client.android.yixiaotong.ui.wash.WashSelectOperate2Activity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                WashSelectOperate2Activity.this.showDialog();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WashParametersBean washParametersBean, Object... objArr) {
                WashSelectOperate2Activity.this.disDialog();
                WashSelectOperate2Activity.this.mTvState.setText(washParametersBean.installlocation);
                WashSelectOperate2Activity.this.washParametersBeans.addAll(washParametersBean.getList());
                WashSelectOperate2Activity.this.washParameterAdapter.notifyDataSetChanged();
                if (WashSelectOperate2Activity.this.mMaterialDialog != null) {
                    WashSelectOperate2Activity.this.mMaterialDialog.setContent("正在读取设备信息中...");
                }
                WashSelectOperate2Activity.this.sendConnectData(Constant.DEFAULT_BALANCE);
                WashSelectOperate2Activity.this.mTimeYear = TimeUtils.formatTime(Long.parseLong(washParametersBean.serial));
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                WashSelectOperate2Activity.this.disDialog();
                ToastUtils.show(WashSelectOperate2Activity.this.getActivity(), clientException.getDetail());
                WashSelectOperate2Activity.this.finish();
            }
        });
    }

    private void sendConfirmData(short s) {
        String onlineConfirmCommand = CommandUtils.getOnlineConfirmCommand(getLoginAccount().getUid(), s, this.mDeviceNo);
        BluetoothSDK.getInstance().SendDataManagerDevice(onlineConfirmCommand);
        Log.e("test", ((int) s) + " 发送数据：" + onlineConfirmCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendConnectData(String str) {
        String onlineConnectCommand1 = CommandUtils.getOnlineConnectCommand1(getLoginAccount().getUid(), str);
        BluetoothSDK.getInstance().SendDataManagerDevice(onlineConnectCommand1);
        Log.e("test", "发送数据2：" + onlineConnectCommand1);
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
            return WashSelectOperate2Activity.this.washParametersBeans.size();
        }

        @Override // android.widget.Adapter
        public WashParameterBean getItem(int i) {
            return (WashParameterBean) WashSelectOperate2Activity.this.washParametersBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(WashSelectOperate2Activity.this.getContext()).inflate(R.layout.wash_parameter_list_item, (ViewGroup) null);
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
                viewHolder.rel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashSelectOperate2Activity.WashParameterAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (!WashSelectOperate2Activity.this.mDeviceIsReady) {
                            ToastUtils.show(WashSelectOperate2Activity.this.getActivity(), "洗衣机还没准备好！请稍后重试");
                            WashSelectOperate2Activity.this.finish();
                        } else {
                            WashSelectOperate2Activity.this.mFunction = item.N;
                            WashSelectOperate2Activity.this.getOrder(item.M, item.F);
                        }
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

    private void updateOrder(String str, String str2) {
        BusinessControllers.getInstance().WashUpdateOrder(getLoginAccount(), str, str2, RandomUtils.getRandNumMaxStringNonO(6), new Listener<WashOrderBean>() { // from class: client.android.yixiaotong.ui.wash.WashSelectOperate2Activity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (WashSelectOperate2Activity.this.mMaterialDialog == null || !WashSelectOperate2Activity.this.isShowingDialog()) {
                    WashSelectOperate2Activity.this.showDialog();
                    WashSelectOperate2Activity.this.mMaterialDialog.setContent("正在上传订单中...");
                } else {
                    WashSelectOperate2Activity.this.mMaterialDialog.setContent("正在上传订单中...");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WashOrderBean washOrderBean, Object... objArr) {
                WashSelectOperate2Activity.this.disDialog();
                if (washOrderBean != null) {
                    WashSelectOperate2Activity.this.mDeviceIsReady = true;
                    ToastUtils.show(WashSelectOperate2Activity.this.getActivity(), "上传订单成功！");
                } else {
                    ToastUtils.show(WashSelectOperate2Activity.this.getActivity(), "数据出错");
                    WashSelectOperate2Activity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                WashSelectOperate2Activity.this.disDialog();
                ToastUtils.show(WashSelectOperate2Activity.this.getActivity(), clientException.getDetail());
                WashSelectOperate2Activity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOrder(String str, final String str2) {
        String waterOrderID = OrderIdUtils.getWaterOrderID(this.mWalletModel.typeId);
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().WashOrderV3(getLoginAccount(), this.mWalletModel.typeId, str + "", this.mDeviceNo, getLoginAccount().getAccountManagetStore().getUserInfo().Mobile, "1", waterOrderID, OrderIdUtils.getLocalDate("yyyyMMddHHmmss"), this.mWalletModel.ID, this.mDeviceName, randNumMaxStringNonO, str2 + "", this.mMac, new Listener<WashOrderBean>() { // from class: client.android.yixiaotong.ui.wash.WashSelectOperate2Activity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (WashSelectOperate2Activity.this.mMaterialDialog == null || !WashSelectOperate2Activity.this.isShowingDialog()) {
                    WashSelectOperate2Activity.this.showDialog();
                    WashSelectOperate2Activity.this.mMaterialDialog.setContent("正在下单中...");
                } else {
                    WashSelectOperate2Activity.this.mMaterialDialog.setContent("正在下单中...");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WashOrderBean washOrderBean, Object... objArr) {
                WashSelectOperate2Activity.this.disDialog();
                if (!StringUtils.isNotEmpty(washOrderBean.orderid) || !washOrderBean.rand.equals(randNumMaxStringNonO) || !StringUtils.isNotEmpty(washOrderBean.systemtime)) {
                    WashSelectOperate2Activity.this.disDialog();
                    ToastUtils.show(WashSelectOperate2Activity.this.getActivity(), "数据出错");
                    WashSelectOperate2Activity.this.finish();
                } else {
                    WashSelectOperate2Activity.this.mOrderId = washOrderBean.orderid;
                    ToastUtils.show(WashSelectOperate2Activity.this.getActivity(), "下单成功");
                    WashSelectOperate2Activity.this.isHasOrder = true;
                    Log.e("test", washOrderBean.systemtime.substring(2));
                    WashSelectOperate2Activity.this.sendConnectData(washOrderBean.systemtime.substring(2));
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                WashSelectOperate2Activity.this.disDialog();
                if (clientException.getCode() == 4060) {
                    WashSelectOperate2Activity.this.isHasOrder = true;
                    ToastUtils.show(WashSelectOperate2Activity.this.getActivity(), clientException.getDetail());
                    WashRecordActivity.launch(WashSelectOperate2Activity.this.getActivity(), WashSelectOperate2Activity.this.mWalletModel, "1", WashSelectOperate2Activity.this.mDeviceNo, str2 + "", WashSelectOperate2Activity.this.mMac);
                } else {
                    ToastUtils.show(WashSelectOperate2Activity.this.getActivity(), clientException.getDetail());
                }
                WashSelectOperate2Activity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            this.mMaterialDialog = new MaterialDialog.Builder(getActivity()).content("正在获取洗衣机的参数中...").cancelable(false).progress(true, 0).show();
        } catch (Exception unused) {
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        disDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowingDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        return materialDialog != null && materialDialog.isShowing();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.isHasOrder) {
            return;
        }
        BluetoothSDK.getInstance().closeBLE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void managerData(byte[] bArr) {
        Log.e("test", "received:" + android.client.bluetoothsdk.util.HexString.bufferToHex(bArr));
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
            disDialog();
            short connectResultStatus = CommandUtils.getConnectResultStatus(bArr);
            if (connectResultStatus != 0) {
                if (connectResultStatus == 2) {
                    this.mDeviceNo = CommandUtils.getConnectResultDeviceHexNo(bArr);
                    if (StringUtils.isNotEmpty(this.mOrderId)) {
                        sendConfirmData(Short.parseShort(this.mFunction));
                    }
                    this.mDeviceIsReady = true;
                    return;
                }
                ToastUtils.show(getActivity(), "洗衣机有异常，错误码：" + ((int) connectResultStatus));
                finish();
                return;
            }
            long connectResultUserId = CommandUtils.getConnectResultUserId(bArr);
            Math.max(0, (int) CommandUtils.getConnectResultBalance(bArr));
            String connectResultTime = CommandUtils.getConnectResultTime(bArr);
            this.mDeviceNo = CommandUtils.getConnectResultDeviceHexNo(bArr);
            Log.e("test", connectResultUserId + "  " + connectResultTime);
            if (!this.isHasOrder) {
                int i = Integer.parseInt(this.mTimeYear.substring(0, 4));
                if (Integer.parseInt(this.mTimeYear.substring(5, 7)) < Integer.parseInt(connectResultTime.substring(0, 2))) {
                    i--;
                }
                updateOrder(connectResultUserId + "", i + connectResultTime);
                return;
            }
            sendConfirmData(Short.parseShort(this.mFunction));
            return;
        }
        if (CommandUtils.isAbortResult(bArr)) {
            if (CommandUtils.getAbortResultStatus(bArr)) {
                ToastUtils.show(getContext(), "终止消费成功", 1);
            } else {
                ToastUtils.show(getContext(), "终止消费失败", 1);
            }
            finish();
        }
    }
}
