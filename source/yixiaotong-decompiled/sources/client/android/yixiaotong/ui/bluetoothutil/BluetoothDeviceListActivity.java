package client.android.yixiaotong.ui.bluetoothutil;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.listener.ScanListener;
import android.client.bluetoothsdk.util.ClientException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.doorlock.AddCardActivity;
import client.android.yixiaotong.ui.doorlock.AddKeyActivity;
import client.android.yixiaotong.ui.doorlock.AddPressActivity;
import client.android.yixiaotong.ui.doorlock.DelectKeyController;
import client.android.yixiaotong.ui.doorlock.RecordController;
import client.android.yixiaotong.ui.doorlock.UpdateKeyActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.permission.PermissionUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BluetoothDeviceListActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String EXTRA_PSW = "psw";
    private static final String EXTRA_STATE = "extra_state";
    private static final int SCANTIME = 5000;
    private DevicesAdapter mDevicesAdapter;
    private ImageView mImgRefreshDevices;
    private ListView mList;
    private String mPsw;
    private ScanListener mScanListener;
    private int mState;
    private TitleBar mTitleBar;
    private WalletModel mWalletModel;
    private List<BluetoothDevice> mBluetoothDevices = new ArrayList();
    private boolean mIsEnbale = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.ui.bluetoothutil.BluetoothDeviceListActivity.3
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 1) {
                return;
            }
            BluetoothSDK.getInstance().startScanDevice(5000, BluetoothDeviceListActivity.this.mScanListener);
        }
    };

    static {
        StubApp.interface11(6613);
    }

    private boolean isDelectKey() {
        int i = this.mState;
        return i == 8 || i == 10 || i == 11 || i == 14;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BluetoothDeviceListActivity.class).putExtra("extra_state", i));
        }
    }

    public static void launch(Activity activity, int i, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BluetoothDeviceListActivity.class).putExtra("extra_state", i).putExtra("psw", str));
        }
    }

    public static void launchForResult(Activity activity, int i) {
        if (activity != null) {
            activity.startActivityForResult(new Intent(activity, (Class<?>) BluetoothDeviceListActivity.class).putExtra("extra_state", i), 2000);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mList = (ListView) findViewById(R.id.recycler_view);
        this.mImgRefreshDevices = (ImageView) findViewById(R.id.img_refresh);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("设备列表");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        DevicesAdapter devicesAdapter = new DevicesAdapter();
        this.mDevicesAdapter = devicesAdapter;
        this.mList.setAdapter((ListAdapter) devicesAdapter);
        this.mDevicesAdapter.notifyDataSetChanged();
        this.mImgRefreshDevices.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothutil.BluetoothDeviceListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BluetoothSDK.getInstance().startScanDevice(5000, BluetoothDeviceListActivity.this.mScanListener);
            }
        });
        this.mList.setOnItemClickListener(this);
    }

    private void initWallet() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.bluetoothutil.BluetoothDeviceListActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list != null && list.size() > 0) {
                    for (WalletModel walletModel : list) {
                        if (walletModel.typeId == 10) {
                            BluetoothDeviceListActivity.this.mWalletModel = walletModel;
                        }
                    }
                }
                if (BluetoothDeviceListActivity.this.mWalletModel == null) {
                    BluetoothDeviceListActivity.this.finish();
                }
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnbale = true;
        if (isDelectKey()) {
            DelectKeyController.getInstance().onResume();
        } else if (this.mState == 13) {
            RecordController.getInstance().onResume();
        }
        PermissionUtil.requestPerssion(getActivity(), 1, this.permissionGrant);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnbale = false;
        BluetoothSDK.getInstance().stopScanDevice();
        if (isDelectKey()) {
            DelectKeyController.getInstance().onPause();
        } else if (this.mState == 13) {
            RecordController.getInstance().onPause();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initBluetooth() {
        this.mScanListener = new ScanListener() { // from class: client.android.yixiaotong.ui.bluetoothutil.BluetoothDeviceListActivity.4
            @Override // android.client.bluetoothsdk.listener.ScanListener
            public void onBluetoothException(ClientException clientException, int i) {
            }

            @Override // android.client.bluetoothsdk.listener.ScanListener
            public void onStart() {
                BluetoothDeviceListActivity.this.mBluetoothDevices.clear();
                BluetoothDeviceListActivity.this.mImgRefreshDevices.setVisibility(8);
            }

            @Override // android.client.bluetoothsdk.listener.ScanListener
            public void onScan(BluetoothDevice bluetoothDevice) {
                if (BluetoothDeviceListActivity.this.mBluetoothDevices.contains(bluetoothDevice)) {
                    return;
                }
                BluetoothDeviceListActivity.this.mBluetoothDevices.add(bluetoothDevice);
                Collections.sort(BluetoothDeviceListActivity.this.mBluetoothDevices, new TestComparator());
                BluetoothDeviceListActivity.this.mDevicesAdapter.notifyDataSetChanged();
            }

            @Override // android.client.bluetoothsdk.listener.ScanListener
            public void onComplete() {
                if (BluetoothDeviceListActivity.this.mIsEnbale) {
                    BluetoothDeviceListActivity.this.mImgRefreshDevices.setVisibility(0);
                }
            }
        };
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BluetoothSDK.getInstance().stopScanDevice();
        toLaunch((BluetoothDevice) adapterView.getItemAtPosition(i));
    }

    private void toLaunch(BluetoothDevice bluetoothDevice) {
        Log.e("test", (bluetoothDevice == null) + PPSLabelView.Code + this.mState);
        int i = this.mState;
        if (i == 5) {
            AddKeyActivity.launch(getActivity(), bluetoothDevice);
            finish();
            return;
        }
        if (i == 6) {
            UpdateKeyActivity.launch(getActivity(), bluetoothDevice, this.mPsw);
            finish();
            return;
        }
        if (i == 8) {
            DelectKeyController.getInstance().init(getActivity(), getLoginAccount(), this.mWalletModel, bluetoothDevice, this.mState);
            return;
        }
        if (i == 7) {
            return;
        }
        if (i == 9) {
            AddCardActivity.launch(getActivity(), bluetoothDevice);
            finish();
            return;
        }
        if (i == 10) {
            DelectKeyController.getInstance().init(getActivity(), getLoginAccount(), this.mWalletModel, bluetoothDevice, this.mState);
            return;
        }
        if (i == 11) {
            DelectKeyController.getInstance().init(getActivity(), getLoginAccount(), this.mWalletModel, bluetoothDevice, this.mState);
            return;
        }
        if (i == 12) {
            AddPressActivity.launch(getActivity(), bluetoothDevice);
            finish();
        } else if (i == 13) {
            RecordController.getInstance().init(getLoginAccount(), getActivity(), bluetoothDevice);
        } else if (i == 14) {
            DelectKeyController.getInstance().init(getActivity(), getLoginAccount(), this.mWalletModel, bluetoothDevice, this.mState);
        }
    }

    static class TestComparator implements Comparator<BluetoothDevice> {
        TestComparator() {
        }

        @Override // java.util.Comparator
        public int compare(BluetoothDevice bluetoothDevice, BluetoothDevice bluetoothDevice2) {
            return bluetoothDevice2.rssi - bluetoothDevice.rssi;
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
            return BluetoothDeviceListActivity.this.mBluetoothDevices.size();
        }

        @Override // android.widget.Adapter
        public BluetoothDevice getItem(int i) {
            return (BluetoothDevice) BluetoothDeviceListActivity.this.mBluetoothDevices.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(BluetoothDeviceListActivity.this.getContext()).inflate(R.layout.bluetooth_devices_list_new_item, (ViewGroup) null);
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
                viewHolder.connect.setText("连接设备");
            }
            return view;
        }

        class ViewHolder {
            public TextView connect;
            public TextView introduce;
            public TextView mactext;
            public TextView name;
            public TextView rssi;

            public ViewHolder(View view) {
                this.mactext = (TextView) view.findViewById(R.id.tv_addresstext);
                this.name = (TextView) view.findViewById(R.id.tv_name);
                this.introduce = (TextView) view.findViewById(R.id.tv_address);
                this.rssi = (TextView) view.findViewById(R.id.rssi);
                this.connect = (TextView) view.findViewById(R.id.connect);
            }
        }
    }
}
