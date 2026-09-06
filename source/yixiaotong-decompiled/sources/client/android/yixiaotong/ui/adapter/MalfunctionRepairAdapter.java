package client.android.yixiaotong.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.controller.bean.report.ReportBean;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.baoxiu.MRepairDetailActivity;
import client.android.yixiaotong.ui.baoxiu.RepairDetailActivity;
import client.android.yixiaotong.util.TimeUtils;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class MalfunctionRepairAdapter extends BaseAdapter {
    private Activity mActivity;
    private LayoutInflater mInflater;
    private List<WalletModel> mWalletModel;
    private List<ReportBean> repairDetailBeanList;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public MalfunctionRepairAdapter(Activity activity, LayoutInflater layoutInflater, List<ReportBean> list, List<WalletModel> list2) {
        this.mActivity = activity;
        this.repairDetailBeanList = list;
        this.mInflater = layoutInflater;
        this.mWalletModel = list2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.repairDetailBeanList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.repairDetailBeanList.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view != null) {
            viewHolder = (ViewHolder) view.getTag();
        } else {
            view = this.mInflater.inflate(R.layout.repair_record_item, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        final ReportBean reportBean = this.repairDetailBeanList.get(i);
        if (this.mWalletModel == null) {
            return view;
        }
        for (int i2 = 0; i2 < this.mWalletModel.size(); i2++) {
            if (this.mWalletModel.get(i2).typeId == reportBean.typeId) {
                viewHolder.tv_appname.setText(this.mWalletModel.get(i2).name + "设备");
            }
        }
        int i3 = reportBean.Status;
        if (i3 == 1 || i3 == 2) {
            viewHolder.tv_state.setText("未解决");
            viewHolder.tv_state.setTextColor(-370604);
        } else if (i3 == 3) {
            viewHolder.tv_state.setText("处理中");
            viewHolder.tv_state.setTextColor(-13710223);
        } else if (i3 == 5) {
            viewHolder.tv_state.setText("已解决");
            viewHolder.tv_state.setTextColor(-13710223);
        } else if (i3 == 6) {
            viewHolder.tv_state.setText("已关闭");
            viewHolder.tv_state.setTextColor(-370604);
        } else if (i3 == 7) {
            viewHolder.tv_state.setText("待解决");
            viewHolder.tv_state.setTextColor(-13710223);
        } else {
            viewHolder.tv_state.setText("未知");
            viewHolder.tv_state.setTextColor(-370604);
        }
        viewHolder.tv_content.setText(reportBean.faultContent);
        viewHolder.tv_time.setText(TimeUtils.formatDateTime(reportBean.reportTime));
        viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.adapter.MalfunctionRepairAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (reportBean.Status != 6) {
                    WalletModel walletModel = null;
                    for (int i4 = 0; i4 < MalfunctionRepairAdapter.this.mWalletModel.size(); i4++) {
                        if (((WalletModel) MalfunctionRepairAdapter.this.mWalletModel.get(i4)).typeId == reportBean.typeId) {
                            walletModel = (WalletModel) MalfunctionRepairAdapter.this.mWalletModel.get(i4);
                        }
                    }
                    if (walletModel != null) {
                        if (AccountManager.getInstance().getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
                            MRepairDetailActivity.launch(MalfunctionRepairAdapter.this.mActivity, walletModel, reportBean.id);
                        } else {
                            RepairDetailActivity.launch(MalfunctionRepairAdapter.this.mActivity, walletModel, reportBean.id);
                        }
                    }
                }
            }
        });
        return view;
    }

    static class ViewHolder {
        Button btn_type;
        LinearLayout lin;
        RelativeLayout rel_detail;
        TextView tv_appname;
        TextView tv_content;
        TextView tv_state;
        TextView tv_time;

        private void initViewNew(View view) {
            this.tv_appname = (TextView) view.findViewById(R.id.tv_appname);
            this.tv_state = (TextView) view.findViewById(R.id.tv_state);
            this.tv_content = (TextView) view.findViewById(R.id.tv_content);
            this.rel_detail = (RelativeLayout) view.findViewById(R.id.rel_detail);
            this.tv_time = (TextView) view.findViewById(R.id.tv_time);
            this.btn_type = (Button) view.findViewById(R.id.btn_type);
            this.lin = (LinearLayout) view.findViewById(R.id.lin);
        }

        ViewHolder(View view) {
            initViewNew(view);
        }
    }
}
