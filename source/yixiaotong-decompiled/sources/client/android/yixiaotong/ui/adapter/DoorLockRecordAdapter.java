package client.android.yixiaotong.ui.adapter;

import android.app.Activity;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.doorlock.GetRecordBean;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.ui.doorlock.RecordController;
import client.android.yixiaotong.ui.doorlock.RouseTipActivity;
import client.android.yixiaotong.util.ToastUtils;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class DoorLockRecordAdapter extends BaseAdapter {
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private List<GetRecordBean> mListData;
    private int mSelectIndex;
    private int mTotalCount = 0;
    private WalletModel mWalletModel;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setCount(int i) {
        this.mTotalCount = i;
    }

    public DoorLockRecordAdapter(Activity activity, Account account, WalletModel walletModel, List<GetRecordBean> list, BluetoothDevice bluetoothDevice) {
        this.mListData = list;
        this.mActivity = activity;
        this.mAccount = account;
        this.mWalletModel = walletModel;
        this.mBluetoothDevice = bluetoothDevice;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toLaunch() {
        if (this.mBluetoothDevice != null) {
            if (LocalBusinessStore.getDoorLockTip(this.mActivity)) {
                RecordController.getInstance().init(this.mAccount, this.mActivity, this.mBluetoothDevice);
                return;
            } else {
                RouseTipActivity.launch(this.mActivity, 13, this.mBluetoothDevice);
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
    public GetRecordBean getItem(int i) {
        return this.mListData.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view != null) {
            viewHolder = (ViewHolder) view.getTag();
        } else {
            view = this.mActivity.getLayoutInflater().inflate(R.layout.layout_doorlock_record_item, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        if (i != 0) {
            viewHolder.tvGetRocord.setVisibility(8);
            viewHolder.relRecord.setVisibility(0);
            GetRecordBean getRecordBean = this.mListData.get(i);
            if (getRecordBean.sysflag == 0) {
                viewHolder.tvOpenWay.setText("未知");
            } else if (getRecordBean.sysflag == 1) {
                viewHolder.tvOpenWay.setText("指纹开锁");
            } else if (getRecordBean.sysflag == 2) {
                viewHolder.tvOpenWay.setText("密码开锁");
            } else if (getRecordBean.sysflag == 3) {
                viewHolder.tvOpenWay.setText("卡片开锁");
            } else if (getRecordBean.sysflag == 4) {
                viewHolder.tvOpenWay.setText("蓝牙开锁");
            }
            viewHolder.tvOpenTime.setText("开锁时间：" + getRecordBean.machineDatetime);
        } else if (i == 0) {
            viewHolder.tvGetRocord.setVisibility(0);
            viewHolder.relRecord.setVisibility(8);
        }
        viewHolder.tvNoData.setVisibility(8);
        if (this.mListData.size() == 2) {
            viewHolder.tvNoData.setVisibility(0);
            viewHolder.tvNoData.setText("暂无记录");
            viewHolder.tvOpenTime.setText("");
            viewHolder.tvOpenWay.setText("");
        } else if (this.mTotalCount == this.mListData.size() - 2 && i == this.mListData.size() - 1) {
            viewHolder.tvNoData.setVisibility(0);
            viewHolder.tvNoData.setText("没有更多记录了");
            viewHolder.tvOpenTime.setText("");
            viewHolder.tvOpenWay.setText("");
        }
        viewHolder.tvGetRocord.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.adapter.DoorLockRecordAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DoorLockRecordAdapter.this.toLaunch();
            }
        });
        return view;
    }

    static class ViewHolder {
        RelativeLayout relRecord;
        TextView tvGetRocord;
        TextView tvNoData;
        TextView tvOpenTime;
        TextView tvOpenWay;

        ViewHolder(View view) {
            this.tvOpenWay = (TextView) view.findViewById(R.id.tv_openway);
            this.tvOpenTime = (TextView) view.findViewById(R.id.tv_opentime);
            this.tvGetRocord = (TextView) view.findViewById(R.id.tv_getrecord);
            this.relRecord = (RelativeLayout) view.findViewById(R.id.rel_record);
            this.tvNoData = (TextView) view.findViewById(R.id.tv_nodata);
        }
    }
}
