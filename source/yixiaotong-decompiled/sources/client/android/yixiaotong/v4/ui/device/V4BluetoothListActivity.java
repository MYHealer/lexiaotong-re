package client.android.yixiaotong.v4.ui.device;

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
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4DeviceInfoBean;
import client.android.yixiaotong.v4.http.bean.V4DeviceListBean;
import client.android.yixiaotong.v4.http.bean.V4HomeInfoBean;
import client.android.yixiaotong.v4.ui.app.bath.V4BathDetailActivity;
import client.android.yixiaotong.v4.ui.area.V4AddressActivity;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.V4LocalDataUtil;
import com.huawei.openalliance.ad.constant.x;
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.lxt.bluetoothsdk.listener.ScanListener;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import com.lxt.bluetoothsdk.utils.ClientException;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4BluetoothListActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final int OPENBLUETOOTH_REQUESTCODE = 200;
    private static final int SCAN_TIMEOUT = 10000;
    public static final String TAG = "V4BluetoothListActivity";
    private BluetoothDevice mBluetoothDevice;
    private DevicesAdapter mDevicesAdapter;
    ImageView mImgRefreshDevices;
    LinearLayout mLinAddress;
    ListView mList;
    RelativeLayout mRelAreaDevice;
    RelativeLayout mRelNearDevice;
    TitleBar mTitleBar;
    TextView mTvArea1;
    TextView mTvArea2;
    TextView mTvArea3;
    TextView mTvArea4;
    TextView mTvAreaText;
    TextView mTvAreaText1;
    TextView mTvAreaText2;
    TextView mTvAreaText3;
    TextView mTvAreaText4;
    TextView mTvNearText;
    TextView mTvScanTip;
    View mVLineLeft;
    View mVLineRight;
    private boolean mIsEnable = true;
    private List<BluetoothDevice> mBluetoothDevices = new ArrayList();
    private String mId1 = "";
    private String mId2 = "";
    private String mId3 = "";
    private String mId4 = "";
    private String mName = "";
    private int mResultCode = 1;
    private boolean mIsNeedFiltration = true;
    private List<V4DeviceListBean> mMachineByLocationBeans = new ArrayList();
    private ScanListener mScanListener = new ScanListener() { // from class: client.android.yixiaotong.v4.ui.device.V4BluetoothListActivity.4
        @Override // com.lxt.bluetoothsdk.listener.ScanListener
        public void onStart() {
            V4BluetoothListActivity.this.mImgRefreshDevices.setVisibility(8);
            V4BluetoothListActivity.this.mBluetoothDevices.clear();
            V4BluetoothListActivity.this.mDevicesAdapter.notifyDataSetChanged();
        }

        @Override // com.lxt.bluetoothsdk.listener.ScanListener
        public void onScan(BluetoothDevice bluetoothDevice) {
            if (!V4BluetoothListActivity.this.mIsEnable || V4BluetoothListActivity.this.mBluetoothDevices.contains(bluetoothDevice)) {
                return;
            }
            if (V4BluetoothListActivity.this.mIsNeedFiltration) {
                for (V4DeviceListBean v4DeviceListBean : V4BluetoothListActivity.this.mMachineByLocationBeans) {
                    if (v4DeviceListBean != null && v4DeviceListBean.productId == 1 && StringUtils.isNotEmpty(v4DeviceListBean.bluetoothMac) && v4DeviceListBean.bluetoothMac.replace(x.bQ, "").equalsIgnoreCase(bluetoothDevice.address.replace(x.bQ, ""))) {
                        V4BluetoothListActivity.this.mBluetoothDevices.add(bluetoothDevice);
                        Collections.sort(V4BluetoothListActivity.this.mBluetoothDevices, new TestComparator());
                        V4BluetoothListActivity.this.mDevicesAdapter.notifyDataSetChanged();
                    }
                }
                return;
            }
            V4BluetoothListActivity.this.mBluetoothDevices.add(bluetoothDevice);
            Collections.sort(V4BluetoothListActivity.this.mBluetoothDevices, new TestComparator());
            V4BluetoothListActivity.this.mDevicesAdapter.notifyDataSetChanged();
        }

        @Override // com.lxt.bluetoothsdk.listener.ScanListener
        public void onComplete() {
            if (V4BluetoothListActivity.this.mIsEnable) {
                V4BluetoothListActivity.this.mImgRefreshDevices.setVisibility(0);
            }
        }

        @Override // com.lxt.bluetoothsdk.listener.ScanListener
        public void onBluetoothException(ClientException clientException, int i) {
            SystemErrorTip.getInstance().showTipDialog(V4BluetoothListActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.device.V4BluetoothListActivity.4.1
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    V4BluetoothListActivity.this.finish();
                }
            }, "请打开蓝牙！");
        }
    };

    static {
        StubApp.interface11(10901);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, V4HomeInfoBean v4HomeInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4BluetoothListActivity.class).putExtra("bean", v4HomeInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mList = (ListView) findViewById(R.id.recycler_view);
        this.mImgRefreshDevices = (ImageView) findViewById(R.id.img_refresh);
        this.mRelAreaDevice = (RelativeLayout) findViewById(R.id.rel_areadevice);
        this.mTvAreaText = (TextView) findViewById(R.id.tv_areatext);
        this.mVLineLeft = findViewById(R.id.v_lineleft);
        this.mRelNearDevice = (RelativeLayout) findViewById(R.id.rel_neardevice);
        this.mTvNearText = (TextView) findViewById(R.id.tv_neartext);
        this.mVLineRight = findViewById(R.id.v_lineright);
        this.mLinAddress = (LinearLayout) findViewById(R.id.lin_address);
        this.mTvAreaText1 = (TextView) findViewById(R.id.tv_areatext1);
        this.mTvArea1 = (TextView) findViewById(R.id.tv_area1);
        this.mTvAreaText2 = (TextView) findViewById(R.id.tv_areatext2);
        this.mTvArea2 = (TextView) findViewById(R.id.tv_area2);
        this.mTvAreaText3 = (TextView) findViewById(R.id.tv_areatext3);
        this.mTvArea3 = (TextView) findViewById(R.id.tv_area3);
        this.mTvAreaText4 = (TextView) findViewById(R.id.tv_areatext4);
        this.mTvArea4 = (TextView) findViewById(R.id.tv_area4);
        this.mTvScanTip = (TextView) findViewById(R.id.tv_scantip);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.bluetooth));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mList.setOnItemClickListener(this);
        ListView listView = this.mList;
        DevicesAdapter devicesAdapter = new DevicesAdapter();
        this.mDevicesAdapter = devicesAdapter;
        listView.setAdapter((ListAdapter) devicesAdapter);
        this.mImgRefreshDevices.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.device.V4BluetoothListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                V4BluetoothListActivity.this.startScan();
            }
        });
        findViewById(R.id.rel_areadevice).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.device.V4BluetoothListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m514x29b93980(view);
            }
        });
        findViewById(R.id.rel_neardevice).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.device.V4BluetoothListActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m515xa81a3d5f(view);
            }
        });
        findViewById(R.id.rel_area1).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.device.V4BluetoothListActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m516x267b413e(view);
            }
        });
        findViewById(R.id.rel_area2).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.device.V4BluetoothListActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m517xa4dc451d(view);
            }
        });
        findViewById(R.id.rel_area3).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.device.V4BluetoothListActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m518x233d48fc(view);
            }
        });
        findViewById(R.id.rel_area4).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.device.V4BluetoothListActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m519xa19e4cdb(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initView$0$client-android-yixiaotong-v4-ui-device-V4BluetoothListActivity, reason: not valid java name */
    /* synthetic */ void m514x29b93980(View view) {
        handleAreaDeviceClick();
    }

    /* JADX INFO: renamed from: lambda$initView$1$client-android-yixiaotong-v4-ui-device-V4BluetoothListActivity, reason: not valid java name */
    /* synthetic */ void m515xa81a3d5f(View view) {
        handleNearDeviceClick();
    }

    /* JADX INFO: renamed from: lambda$initView$2$client-android-yixiaotong-v4-ui-device-V4BluetoothListActivity, reason: not valid java name */
    /* synthetic */ void m516x267b413e(View view) {
        handleAreaClick(1);
    }

    /* JADX INFO: renamed from: lambda$initView$3$client-android-yixiaotong-v4-ui-device-V4BluetoothListActivity, reason: not valid java name */
    /* synthetic */ void m517xa4dc451d(View view) {
        handleAreaClick(2);
    }

    /* JADX INFO: renamed from: lambda$initView$4$client-android-yixiaotong-v4-ui-device-V4BluetoothListActivity, reason: not valid java name */
    /* synthetic */ void m518x233d48fc(View view) {
        handleAreaClick(3);
    }

    /* JADX INFO: renamed from: lambda$initView$5$client-android-yixiaotong-v4-ui-device-V4BluetoothListActivity, reason: not valid java name */
    /* synthetic */ void m519xa19e4cdb(View view) {
        handleAreaClick(4);
    }

    private void handleAreaDeviceClick() {
        this.mTvAreaText.setTextColor(getResources().getColor(R.color.fff3382a));
        this.mTvAreaText.setTextSize(16.0f);
        this.mVLineLeft.setVisibility(0);
        this.mTvNearText.setTextColor(getResources().getColor(R.color.ff242933));
        this.mTvNearText.setTextSize(15.0f);
        this.mVLineRight.setVisibility(8);
        this.mLinAddress.setVisibility(0);
        this.mIsNeedFiltration = true;
        stopScan();
        this.mImgRefreshDevices.setVisibility(8);
        this.mBluetoothDevices.clear();
        this.mDevicesAdapter.notifyDataSetChanged();
        if (this.mMachineByLocationBeans.size() > 0) {
            startScan();
        }
    }

    private void handleNearDeviceClick() {
        this.mTvScanTip.setVisibility(8);
        this.mTvAreaText.setTextColor(getResources().getColor(R.color.ff242933));
        this.mTvAreaText.setTextSize(15.0f);
        this.mVLineLeft.setVisibility(8);
        this.mTvNearText.setTextColor(getResources().getColor(R.color.fff3382a));
        this.mTvNearText.setTextSize(16.0f);
        this.mVLineRight.setVisibility(0);
        this.mLinAddress.setVisibility(8);
        this.mIsNeedFiltration = false;
        startScan();
    }

    private void handleAreaClick(int i) {
        if (i == 1) {
            initAreaView(1);
            V4AddressActivity.launch(getActivity(), "", this.mTvAreaText1.getText().toString(), 1);
            return;
        }
        if (i == 2) {
            if (StringUtils.isNotEmpty(this.mTvArea1.getText().toString())) {
                initAreaView(2);
                V4AddressActivity.launch(getActivity(), this.mId1, this.mTvAreaText2.getText().toString(), 2);
                return;
            }
            return;
        }
        if (i == 3) {
            if (StringUtils.isNotEmpty(this.mTvArea2.getText().toString())) {
                initAreaView(3);
                V4AddressActivity.launch(getActivity(), this.mId2, this.mTvAreaText3.getText().toString(), 3);
                return;
            }
            return;
        }
        if (i == 4 && StringUtils.isNotEmpty(this.mTvArea3.getText().toString())) {
            initAreaView(4);
            V4AddressActivity.launch(getActivity(), this.mId3, this.mTvAreaText4.getText().toString(), 4);
        }
    }

    private void initAreaView(int i) {
        if (i == 1) {
            this.mTvArea1.setText("");
            this.mTvArea2.setText("");
            this.mTvArea3.setText("");
            this.mTvArea4.setText("");
            V4LocalDataUtil.saveArea1(getContext(), "");
            V4LocalDataUtil.saveArea2(getContext(), "");
            V4LocalDataUtil.saveArea3(getContext(), "");
            V4LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 2) {
            this.mTvArea2.setText("");
            this.mTvArea3.setText("");
            this.mTvArea4.setText("");
            V4LocalDataUtil.saveArea2(getContext(), "");
            V4LocalDataUtil.saveArea3(getContext(), "");
            V4LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 3) {
            this.mTvArea3.setText("");
            this.mTvArea4.setText("");
            V4LocalDataUtil.saveArea3(getContext(), "");
            V4LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 4) {
            this.mTvArea4.setText("");
            V4LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 0) {
            String area2 = V4LocalDataUtil.getArea2(getContext());
            String area1 = V4LocalDataUtil.getArea1(getContext());
            String area3 = V4LocalDataUtil.getArea3(getContext());
            String area4 = V4LocalDataUtil.getArea4(getContext());
            if (StringUtils.isNotEmpty(area1)) {
                String[] strArrSplit = area1.split(",");
                this.mId1 = strArrSplit[0];
                this.mTvArea1.setText(strArrSplit[1]);
            }
            if (StringUtils.isNotEmpty(area2)) {
                String[] strArrSplit2 = area2.split(",");
                this.mId2 = strArrSplit2[0];
                this.mTvArea2.setText(strArrSplit2[1]);
            }
            if (StringUtils.isNotEmpty(area3)) {
                String[] strArrSplit3 = area3.split(",");
                this.mId3 = strArrSplit3[0];
                this.mTvArea3.setText(strArrSplit3[1]);
            }
            if (StringUtils.isNotEmpty(area4)) {
                String[] strArrSplit4 = area4.split(",");
                this.mId4 = strArrSplit4[0];
                this.mTvArea4.setText(strArrSplit4[1]);
                getMachineInfoByLocation();
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        this.mBluetoothDevice = this.mDevicesAdapter.getItem(i);
        LogUtil.e(TAG, "onItemClick:" + (this.mBluetoothDevice != null));
        if (this.mBluetoothDevice != null) {
            this.mImgRefreshDevices.setVisibility(0);
            stopScan();
            TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.device.V4BluetoothListActivity.2
                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    if (V4BluetoothListActivity.this.mIsNeedFiltration) {
                        for (V4DeviceListBean v4DeviceListBean : V4BluetoothListActivity.this.mMachineByLocationBeans) {
                            if (v4DeviceListBean.bluetoothMac.replace(x.bQ, "").equalsIgnoreCase(V4BluetoothListActivity.this.mBluetoothDevice.address.replace(x.bQ, ""))) {
                                V4BathDetailActivity.launch(V4BluetoothListActivity.this.getActivity(), V4BluetoothListActivity.this.mBluetoothDevice.address, v4DeviceListBean.mac, 1, "", false);
                                V4BluetoothListActivity.this.finish();
                            }
                        }
                        return;
                    }
                    V4BluetoothListActivity v4BluetoothListActivity = V4BluetoothListActivity.this;
                    v4BluetoothListActivity.getMac(v4BluetoothListActivity.mBluetoothDevice.address);
                }
            }, "提示", "确定开启设\n备“" + this.mBluetoothDevice.address + "”吗？", "取消", "确认开启");
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
        checkIsOpenBluetooth();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        V4ErrorControlUtil.getInstance().onPause();
        stopScan();
    }

    private void checkIsOpenBluetooth() {
        if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            return;
        }
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startScan() {
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v4.ui.device.V4BluetoothListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                BluetoothSDK.getInstance().startScanDevice(10000, V4BluetoothListActivity.this.mScanListener);
            }
        }, 500L);
    }

    private void stopScan() {
        BluetoothSDK.getInstance().stopScanDevice();
    }

    static class TestComparator implements Comparator<BluetoothDevice> {
        TestComparator() {
        }

        @Override // java.util.Comparator
        public int compare(BluetoothDevice bluetoothDevice, BluetoothDevice bluetoothDevice2) {
            return bluetoothDevice2.rssi - bluetoothDevice.rssi;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200) {
            if (i2 != 0) {
                return;
            }
            finish();
            return;
        }
        if (i != 1 || intent == null) {
            return;
        }
        this.mName = intent.getStringExtra("name");
        String stringExtra = intent.getStringExtra("id");
        this.mResultCode = i2;
        if (i2 == 1) {
            this.mId1 = stringExtra;
            this.mTvArea1.setText(this.mName);
            V4LocalDataUtil.saveArea1(getContext(), stringExtra + "," + this.mName);
            return;
        }
        if (i2 == 2) {
            this.mId2 = stringExtra;
            this.mTvArea2.setText(this.mName);
            V4LocalDataUtil.saveArea2(getContext(), stringExtra + "," + this.mName);
        } else if (i2 == 3) {
            this.mId3 = stringExtra;
            this.mTvArea3.setText(this.mName);
            V4LocalDataUtil.saveArea3(getContext(), stringExtra + "," + this.mName);
        } else if (i2 == 4) {
            this.mId4 = stringExtra;
            this.mTvArea4.setText(this.mName);
            V4LocalDataUtil.saveArea4(getContext(), stringExtra + "," + this.mName);
            getMachineInfoByLocation();
        }
    }

    private class DevicesAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        private DevicesAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return V4BluetoothListActivity.this.mBluetoothDevices.size();
        }

        @Override // android.widget.Adapter
        public BluetoothDevice getItem(int i) {
            return (BluetoothDevice) V4BluetoothListActivity.this.mBluetoothDevices.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V4BluetoothListActivity.this.getContext()).inflate(R.layout.bluetooth_devices_list_itemv3, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            BluetoothDevice item = getItem(i);
            if (item != null) {
                viewHolder.name.setText(item.name);
                viewHolder.introduce.setText(item.address);
                viewHolder.rssi.setText(item.rssi + "");
            }
            return view;
        }

        class ViewHolder {
            public TextView introduce;
            public TextView name;
            public TextView rssi;

            public ViewHolder(View view) {
                this.name = (TextView) view.findViewById(R.id.tv_name);
                this.introduce = (TextView) view.findViewById(R.id.tv_address);
                this.rssi = (TextView) view.findViewById(R.id.rssi);
            }
        }
    }

    private void getMachineInfoByLocation() {
        V4BusinessControllers.getInstance().getDeviceList(getLoginAccount(), this.mId4, new Listener<List<V4DeviceListBean>>() { // from class: client.android.yixiaotong.v4.ui.device.V4BluetoothListActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<V4DeviceListBean> list, Object... objArr) {
                if (V4BluetoothListActivity.this.mIsEnable) {
                    if (list != null && list.size() > 0) {
                        V4BluetoothListActivity.this.mMachineByLocationBeans.clear();
                        V4BluetoothListActivity.this.mMachineByLocationBeans = list;
                        V4BluetoothListActivity.this.startScan();
                        return;
                    }
                    V4BluetoothListActivity.this.mTvScanTip.setVisibility(0);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (V4BluetoothListActivity.this.mIsEnable) {
                    V4BluetoothListActivity.this.mTvScanTip.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getMac(String str) {
        V4BusinessControllers.getInstance().getDeviceInfoByMac(getLoginAccount(), str, new Listener<V4DeviceInfoBean>() { // from class: client.android.yixiaotong.v4.ui.device.V4BluetoothListActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4BluetoothListActivity.this.getActivity(), "获取mac", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4DeviceInfoBean v4DeviceInfoBean, Object... objArr) {
                super.onComplete(controller, v4DeviceInfoBean, objArr);
                if (V4BluetoothListActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (StringUtils.isNotEmpty(v4DeviceInfoBean.mac)) {
                        V4BathDetailActivity.launch(V4BluetoothListActivity.this.getActivity(), V4BluetoothListActivity.this.mBluetoothDevice.address, v4DeviceInfoBean.mac, 1, "", false);
                        V4BluetoothListActivity.this.finish();
                    } else {
                        ToastUtils.show(V4BluetoothListActivity.this.getActivity(), "获取mac失败");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4BluetoothListActivity.this.mIsEnable) {
                    int code = LocalDataUtil.getCode(V4BluetoothListActivity.this.getActivity());
                    if (code < 500 || code >= 600) {
                        V4ErrorControlUtil.getInstance().showDialog(clientException, V4BluetoothListActivity.this.getActivity(), false);
                    } else {
                        V4BathDetailActivity.launch(V4BluetoothListActivity.this.getActivity(), V4BluetoothListActivity.this.mBluetoothDevice.address, "", 1, "", false);
                        V4BluetoothListActivity.this.finish();
                    }
                }
            }
        });
    }
}
