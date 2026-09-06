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
import client.android.yixiaotong.ui.doorlock.VerifyLoginPswActivity;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class DoorLockKeyAdapter extends BaseAdapter {
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

    public DoorLockKeyAdapter(Activity activity, Account account, WalletModel walletModel, List<KeyBean> list) {
        this.mListData = list;
        this.mActivity = activity;
        this.mAccount = account;
        this.mWalletModel = walletModel;
    }

    public void onResume() {
        DelectKeyController.getInstance().onResume();
    }

    public void onPause() {
        DelectKeyController.getInstance().onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toLaunch(String str) {
        BluetoothDevice bluetoothDevice = this.mBluetoothDevice;
        if (bluetoothDevice == null || !StringUtils.isNotEmpty(bluetoothDevice.address)) {
            ToastUtils.show(this.mActivity, "当前宿舍没有设备！");
            return;
        }
        int i = this.mSelectIndex;
        if (i == 7 || i == 6) {
            VerifyLoginPswActivity.launch(this.mActivity, i, str, this.mBluetoothDevice);
        } else if (i == 8) {
            if (LocalBusinessStore.getDoorLockTip(this.mActivity)) {
                DelectKeyController.getInstance().init(this.mActivity, this.mAccount, this.mWalletModel, this.mBluetoothDevice, this.mSelectIndex);
            } else {
                RouseTipActivity.launch(this.mActivity, this.mSelectIndex, this.mBluetoothDevice);
            }
        }
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
            view = this.mActivity.getLayoutInflater().inflate(R.layout.layout_dootlock_keydetail_item, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        final KeyBean keyBean = this.mListData.get(i);
        viewHolder.tvKeyIndex.setText(keyBean.keyname);
        viewHolder.tvTime.setText(keyBean.key_create_datetime);
        viewHolder.tvKeyIndex.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.adapter.DoorLockKeyAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Activity activity = DoorLockKeyAdapter.this.mActivity;
                KeyBean keyBean2 = keyBean;
                UpdateKeyNameActivity.launch(activity, keyBean2, keyBean2.keyname);
            }
        });
        viewHolder.tvDelectKey.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.adapter.DoorLockKeyAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                LocalBusinessStore.saveDoorLockServerKeyID(DoorLockKeyAdapter.this.mActivity, keyBean.door_student_machine_key_id);
                LocalBusinessStore.saveDoorLockDeviceKeyID(DoorLockKeyAdapter.this.mActivity, keyBean.keyid);
                DoorLockKeyAdapter.this.mSelectIndex = 8;
                DoorLockKeyAdapter.this.toLaunch(keyBean.key_passwrod);
            }
        });
        viewHolder.tvToSeeKey.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.adapter.DoorLockKeyAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DoorLockKeyAdapter.this.mSelectIndex = 7;
                DoorLockKeyAdapter.this.toLaunch(keyBean.key_passwrod);
            }
        });
        viewHolder.tvUpDateKey.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.adapter.DoorLockKeyAdapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                LocalBusinessStore.saveDoorLockServerKeyID(DoorLockKeyAdapter.this.mActivity, keyBean.door_student_machine_key_id);
                LocalBusinessStore.saveDoorLockDeviceKeyID(DoorLockKeyAdapter.this.mActivity, keyBean.keyid);
                DoorLockKeyAdapter.this.mSelectIndex = 6;
                DoorLockKeyAdapter.this.toLaunch(keyBean.key_passwrod);
            }
        });
        return view;
    }

    static class ViewHolder {
        TextView tvDelectKey;
        TextView tvKeyIndex;
        TextView tvTime;
        TextView tvToSeeKey;
        TextView tvUpDateKey;

        ViewHolder(View view) {
            this.tvKeyIndex = (TextView) view.findViewById(R.id.tv_keyindex);
            this.tvTime = (TextView) view.findViewById(R.id.tv_time);
            this.tvDelectKey = (TextView) view.findViewById(R.id.tv_delectkey);
            this.tvToSeeKey = (TextView) view.findViewById(R.id.tv_tokey);
            this.tvUpDateKey = (TextView) view.findViewById(R.id.tv_updatekey);
        }
    }
}
