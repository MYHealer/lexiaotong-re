package client.android.yixiaotong.ui.adapter;

import android.app.Activity;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.doorlock.KeyBean;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.ui.doorlock.DelectKeyController;
import client.android.yixiaotong.ui.doorlock.RouseTipActivity;
import client.android.yixiaotong.ui.doorlock.UpdateKeyNameActivity;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class DoorLockPressKeyAdapter extends BaseAdapter {
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private List<KeyBean> mListData;
    private int mSelectIndex;
    private WalletModel mWalletModel;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.mBluetoothDevice = bluetoothDevice;
    }

    public DoorLockPressKeyAdapter(Activity activity, Account account, WalletModel walletModel, List<KeyBean> list) {
        this.mListData = list;
        this.mActivity = activity;
        this.mAccount = account;
        this.mWalletModel = walletModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toLaunch() {
        BluetoothDevice bluetoothDevice = this.mBluetoothDevice;
        if (bluetoothDevice != null && StringUtils.isNotEmpty(bluetoothDevice.address)) {
            if (LocalBusinessStore.getDoorLockTip(this.mActivity)) {
                DelectKeyController.getInstance().init(this.mActivity, this.mAccount, this.mWalletModel, this.mBluetoothDevice, this.mSelectIndex);
                return;
            } else {
                RouseTipActivity.launch(this.mActivity, this.mSelectIndex, this.mBluetoothDevice);
                return;
            }
        }
        ToastUtils.show(this.mActivity, "当前宿舍没有设备！");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mListData.size();
    }

    @Override // android.widget.Adapter
    public KeyBean getItem(int i) {
        return this.mListData.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view != null) {
            viewHolder = (ViewHolder) view.getTag();
        } else {
            view = this.mActivity.getLayoutInflater().inflate(R.layout.layout_doorlock_pressdetail_item, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        final KeyBean keyBean = this.mListData.get(i);
        if (StringUtils.isNotEmpty(keyBean.keyname)) {
            viewHolder.tvKeyName.setText(keyBean.keyname);
        } else {
            viewHolder.tvKeyName.setText("指纹钥匙" + (i + 1));
        }
        final String string = viewHolder.tvKeyName.getText().toString();
        viewHolder.tvKeyName.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.adapter.DoorLockPressKeyAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                UpdateKeyNameActivity.launch(DoorLockPressKeyAdapter.this.mActivity, keyBean, string);
            }
        });
        viewHolder.tvDelectKey.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.adapter.DoorLockPressKeyAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                LocalBusinessStore.saveDoorLockServerKeyID(DoorLockPressKeyAdapter.this.mActivity, keyBean.door_student_machine_key_id);
                LocalBusinessStore.saveDoorLockDeviceKeyID(DoorLockPressKeyAdapter.this.mActivity, keyBean.keyid);
                DoorLockPressKeyAdapter.this.mSelectIndex = 11;
                DoorLockPressKeyAdapter.this.toLaunch();
            }
        });
        return view;
    }

    static class ViewHolder {
        TextView tvDelectKey;
        TextView tvKeyName;

        ViewHolder(View view) {
            this.tvKeyName = (TextView) view.findViewById(R.id.tv_keyname);
            this.tvDelectKey = (TextView) view.findViewById(R.id.tv_delectkey);
        }
    }
}
