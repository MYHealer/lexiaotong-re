package client.android.yixiaotong.v3.ui.device;

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
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByLocationBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.bath.BathDetailActivity;
import client.android.yixiaotong.v3.ui.area.AddressActivity;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
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
public class BluetoothListActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final int OPENBLUETOOTH_REQUESTCODE = 200;
    private static final int SCAN_TIMEOUT = 10000;
    public static final String TAG = "BluetoothListActivity";
    private BluetoothDevice mBluetoothDevice;
    private DevicesAdapter mDevicesAdapter;
    private ImageView mImgRefreshDevices;
    private LinearLayout mLinAddress;
    private ListView mList;
    private RelativeLayout mRelAreaDevice;
    private RelativeLayout mRelNearDevice;
    private TitleBar mTitleBar;
    private TextView mTvArea1;
    private TextView mTvArea2;
    private TextView mTvArea3;
    private TextView mTvArea4;
    private TextView mTvAreaText;
    private TextView mTvAreaText1;
    private TextView mTvAreaText2;
    private TextView mTvAreaText3;
    private TextView mTvAreaText4;
    private TextView mTvNearText;
    private TextView mTvScanTip;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private View mVLineLeft;
    private View mVLineRight;
    private boolean mIsEnable = true;
    private List<BluetoothDevice> mBluetoothDevices = new ArrayList();
    private String mId1 = "";
    private String mId2 = "";
    private String mId3 = "";
    private String mId4 = "";
    private String mName = "";
    private int mSiteFlag = -1;
    private int mResultCode = 1;
    private boolean mIsNeedFiltration = true;
    private List<MachineByLocationBean> mMachineByLocationBeans = new ArrayList();
    private ScanListener mScanListener = new ScanListener() { // from class: client.android.yixiaotong.v3.ui.device.BluetoothListActivity.4
        @Override // com.lxt.bluetoothsdk.listener.ScanListener
        public void onStart() {
            BluetoothListActivity.this.mImgRefreshDevices.setVisibility(8);
            BluetoothListActivity.this.mBluetoothDevices.clear();
            BluetoothListActivity.this.mDevicesAdapter.notifyDataSetChanged();
        }

        @Override // com.lxt.bluetoothsdk.listener.ScanListener
        public void onScan(BluetoothDevice bluetoothDevice) {
            if (!BluetoothListActivity.this.mIsEnable || BluetoothListActivity.this.mBluetoothDevices.contains(bluetoothDevice)) {
                return;
            }
            if (BluetoothListActivity.this.mIsNeedFiltration) {
                for (MachineByLocationBean machineByLocationBean : BluetoothListActivity.this.mMachineByLocationBeans) {
                    if (machineByLocationBean != null && StringUtils.isNotEmpty(machineByLocationBean.deviceMac) && machineByLocationBean.deviceMac.replace(x.bQ, "").equalsIgnoreCase(bluetoothDevice.address.replace(x.bQ, ""))) {
                        BluetoothListActivity.this.mBluetoothDevices.add(bluetoothDevice);
                        Collections.sort(BluetoothListActivity.this.mBluetoothDevices, new TestComparator());
                        BluetoothListActivity.this.mDevicesAdapter.notifyDataSetChanged();
                    }
                }
                return;
            }
            BluetoothListActivity.this.mBluetoothDevices.add(bluetoothDevice);
            Collections.sort(BluetoothListActivity.this.mBluetoothDevices, new TestComparator());
            BluetoothListActivity.this.mDevicesAdapter.notifyDataSetChanged();
        }

        @Override // com.lxt.bluetoothsdk.listener.ScanListener
        public void onComplete() {
            if (BluetoothListActivity.this.mIsEnable) {
                BluetoothListActivity.this.mImgRefreshDevices.setVisibility(0);
            }
        }

        @Override // com.lxt.bluetoothsdk.listener.ScanListener
        public void onBluetoothException(ClientException clientException, int i) {
            SystemErrorTip.getInstance().showTipDialog(BluetoothListActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.device.BluetoothListActivity.4.1
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    BluetoothListActivity.this.finish();
                }
            }, "请打开蓝牙！");
        }
    };

    static {
        StubApp.interface11(9799);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, TypeInfoBaseInfoBean typeInfoBaseInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BluetoothListActivity.class).putExtra("bean", typeInfoBaseInfoBean));
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
        this.mImgRefreshDevices.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.device.BluetoothListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BluetoothListActivity.this.startScan();
            }
        });
    }

    private void initClickListeners() {
        findViewById(R.id.rel_areadevice).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.device.BluetoothListActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m362xaa1a12b(view);
            }
        });
        findViewById(R.id.rel_neardevice).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.device.BluetoothListActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m363x9ee010ca(view);
            }
        });
        findViewById(R.id.rel_area1).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.device.BluetoothListActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m364x331e8069(view);
            }
        });
        findViewById(R.id.rel_area2).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.device.BluetoothListActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m365xc75cf008(view);
            }
        });
        findViewById(R.id.rel_area3).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.device.BluetoothListActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m366x5b9b5fa7(view);
            }
        });
        findViewById(R.id.rel_area4).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.device.BluetoothListActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m367xefd9cf46(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-device-BluetoothListActivity, reason: not valid java name */
    /* synthetic */ void m362xaa1a12b(View view) {
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

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-device-BluetoothListActivity, reason: not valid java name */
    /* synthetic */ void m363x9ee010ca(View view) {
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

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-device-BluetoothListActivity, reason: not valid java name */
    /* synthetic */ void m364x331e8069(View view) {
        String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
        if (StringUtils.isNotEmpty(schoolId)) {
            initAreaView(1);
            AddressActivity.launch(getActivity(), schoolId, this.mTvAreaText1.getText().toString(), 1);
        } else {
            ToastUtils.show(getActivity(), "缓存数据异常，尝试重新登录再试");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-device-BluetoothListActivity, reason: not valid java name */
    /* synthetic */ void m365xc75cf008(View view) {
        if (StringUtils.isNotEmpty(this.mTvArea1.getText().toString())) {
            initAreaView(2);
            AddressActivity.launch(getActivity(), this.mId1, this.mTvAreaText2.getText().toString(), 2);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-device-BluetoothListActivity, reason: not valid java name */
    /* synthetic */ void m366x5b9b5fa7(View view) {
        if (StringUtils.isNotEmpty(this.mTvArea2.getText().toString())) {
            initAreaView(3);
            AddressActivity.launch(getActivity(), this.mId2, this.mTvAreaText3.getText().toString(), 3);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-v3-ui-device-BluetoothListActivity, reason: not valid java name */
    /* synthetic */ void m367xefd9cf46(View view) {
        if (StringUtils.isNotEmpty(this.mTvArea3.getText().toString())) {
            initAreaView(4);
            AddressActivity.launch(getActivity(), this.mId3, this.mTvAreaText4.getText().toString(), 4);
        }
    }

    private void initAreaView(int i) {
        if (i == 1) {
            this.mTvArea1.setText("");
            this.mTvArea2.setText("");
            this.mTvArea3.setText("");
            this.mTvArea4.setText("");
            LocalDataUtil.saveArea1(getContext(), "");
            LocalDataUtil.saveArea2(getContext(), "");
            LocalDataUtil.saveArea3(getContext(), "");
            LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 2) {
            this.mTvArea2.setText("");
            this.mTvArea3.setText("");
            this.mTvArea4.setText("");
            LocalDataUtil.saveArea2(getContext(), "");
            LocalDataUtil.saveArea3(getContext(), "");
            LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 3) {
            this.mTvArea3.setText("");
            this.mTvArea4.setText("");
            LocalDataUtil.saveArea3(getContext(), "");
            LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 4) {
            this.mTvArea4.setText("");
            LocalDataUtil.saveArea4(getContext(), "");
            return;
        }
        if (i == 0) {
            String area3 = LocalDataUtil.getArea3(getContext());
            String area2 = LocalDataUtil.getArea2(getContext());
            String area1 = LocalDataUtil.getArea1(getContext());
            String area4 = LocalDataUtil.getArea4(getContext());
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
                this.mSiteFlag = Integer.parseInt(strArrSplit4[2]);
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
            TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.device.BluetoothListActivity.2
                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    if (!BluetoothListActivity.this.mIsNeedFiltration) {
                        LocalDataUtil.saveBathMacInfo(BluetoothListActivity.this.getContext(), BluetoothListActivity.this.mBluetoothDevice.address);
                        BathDetailActivity.launch(BluetoothListActivity.this.getActivity(), BluetoothListActivity.this.mBluetoothDevice.address, false);
                    } else {
                        LocalDataUtil.saveBathMacInfo(BluetoothListActivity.this.getContext(), BluetoothListActivity.this.mBluetoothDevice.address + "," + BluetoothListActivity.this.mTvArea1.getText().toString() + BluetoothListActivity.this.mTvArea2.getText().toString() + BluetoothListActivity.this.mTvArea3.getText().toString() + BluetoothListActivity.this.mTvArea4.getText().toString());
                        BathDetailActivity.launch(BluetoothListActivity.this.getActivity(), BluetoothListActivity.this.mBluetoothDevice.address, true);
                    }
                    BluetoothListActivity.this.finish();
                }
            }, "提示", "确定开启设\n备“" + this.mBluetoothDevice.address + "”吗？", "取消", "确认开启");
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        checkIsOpenBluetooth();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
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
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.device.BluetoothListActivity.3
            @Override // java.lang.Runnable
            public void run() {
                BluetoothSDK.getInstance().startScanDevice(10000, BluetoothListActivity.this.mScanListener);
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
            LocalDataUtil.saveArea1(getContext(), stringExtra + "," + this.mName);
            return;
        }
        if (i2 == 2) {
            this.mId2 = stringExtra;
            this.mTvArea2.setText(this.mName);
            LocalDataUtil.saveArea2(getContext(), stringExtra + "," + this.mName);
        } else if (i2 == 3) {
            this.mId3 = stringExtra;
            this.mTvArea3.setText(this.mName);
            LocalDataUtil.saveArea3(getContext(), stringExtra + "," + this.mName);
        } else if (i2 == 4) {
            this.mId4 = stringExtra;
            this.mSiteFlag = intent.getIntExtra("siteflag", -1);
            this.mTvArea4.setText(this.mName);
            LocalDataUtil.saveArea4(getContext(), stringExtra + "," + this.mName + "," + this.mSiteFlag);
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
            return BluetoothListActivity.this.mBluetoothDevices.size();
        }

        @Override // android.widget.Adapter
        public BluetoothDevice getItem(int i) {
            return (BluetoothDevice) BluetoothListActivity.this.mBluetoothDevices.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(BluetoothListActivity.this.getContext()).inflate(R.layout.bluetooth_devices_list_itemv3, (ViewGroup) null);
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
        V3BusinessControllers.getInstance().postGetMachineByLocation(getLoginAccount(), this.mId4, this.mSiteFlag, this.mTypeInfoBaseInfoBean.typeId, new Listener<List<MachineByLocationBean>>() { // from class: client.android.yixiaotong.v3.ui.device.BluetoothListActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<MachineByLocationBean> list, Object... objArr) {
                if (BluetoothListActivity.this.mIsEnable) {
                    if (list.size() > 0) {
                        BluetoothListActivity.this.mMachineByLocationBeans.clear();
                        BluetoothListActivity.this.mMachineByLocationBeans = list;
                        BluetoothListActivity.this.startScan();
                        return;
                    }
                    BluetoothListActivity.this.mTvScanTip.setVisibility(0);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (BluetoothListActivity.this.mIsEnable) {
                    BluetoothListActivity.this.mTvScanTip.setVisibility(0);
                }
            }
        });
    }

    private void onError(client.android.yixiaotong.exception.ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
    }
}
