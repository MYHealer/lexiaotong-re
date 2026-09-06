package client.android.yixiaotong.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.RecordBean;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class RecordsAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<RecordBean> mRecordListBeans;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public RecordsAdapter(LayoutInflater layoutInflater, List<RecordBean> list) {
        this.mRecordListBeans = list;
        this.mInflater = layoutInflater;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mRecordListBeans.size();
    }

    @Override // android.widget.Adapter
    public RecordBean getItem(int i) {
        return this.mRecordListBeans.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view != null) {
            viewHolder = (ViewHolder) view.getTag();
        } else {
            view = this.mInflater.inflate(R.layout.account_record_item, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        RecordBean recordBean = this.mRecordListBeans.get(i);
        if (recordBean.state == 0) {
            viewHolder.tvItemTime.setVisibility(0);
            viewHolder.llDetailLayout.setVisibility(0);
            viewHolder.llRecordDetailBottom.setVisibility(8);
            if (i == 0) {
                viewHolder.ivItemLine.setBackgroundResource(R.drawable.shop_statement_timeline_top);
            } else {
                viewHolder.ivItemLine.setBackgroundResource(R.drawable.shop_statement_timeline_middle);
            }
            viewHolder.rlDetail.setBackgroundResource(R.drawable.shop_statement_bg_top);
        } else if (recordBean.state == 1) {
            viewHolder.tvItemTime.setVisibility(4);
            viewHolder.llDetailLayout.setVisibility(0);
            viewHolder.llRecordDetailBottom.setVisibility(8);
            viewHolder.ivItemLine.setBackgroundResource(R.drawable.shop_statement_timeline_line);
            viewHolder.rlDetail.setBackgroundResource(R.drawable.shop_statement_bg_middle);
        } else if (recordBean.state == 2) {
            viewHolder.tvItemTime.setVisibility(4);
            viewHolder.llDetailLayout.setVisibility(0);
            viewHolder.llRecordDetailBottom.setVisibility(0);
            viewHolder.ivItemLine.setBackgroundResource(R.drawable.shop_statement_timeline_line);
            viewHolder.rlDetail.setBackgroundResource(R.drawable.shop_statement_bg_bottom);
        } else if (recordBean.state == 3) {
            viewHolder.tvItemTime.setVisibility(0);
            viewHolder.llDetailLayout.setVisibility(0);
            viewHolder.llRecordDetailBottom.setVisibility(0);
            viewHolder.ivItemLine.setBackgroundResource(R.drawable.shop_statement_timeline_middle);
            viewHolder.rlDetail.setBackgroundResource(R.drawable.shop_statement_bg_single);
        }
        viewHolder.tvItemTime.setText(recordBean.getTimeStr());
        viewHolder.tvRecordDetailAmount.setText("¥" + recordBean.ConsumeAmount);
        viewHolder.tvRecordDetailDevice.setText(recordBean.ConsumeDetails);
        if (this.mRecordListBeans.get(i).TypeId == 1) {
            if (this.mRecordListBeans.get(i).IsOnline == 1) {
                viewHolder.tvRecordType.setText("联网订单");
            } else {
                viewHolder.tvRecordType.setText("脱机订单");
            }
            if (this.mRecordListBeans.get(i).IsOnline == 0) {
                viewHolder.tvRecordOfflineCount.setVisibility(0);
                if (this.mRecordListBeans.get(i).OffLineTimes > 0) {
                    viewHolder.tvRecordOfflineCount.setText("脱机" + this.mRecordListBeans.get(i).OffLineTimes + "次");
                }
            } else {
                viewHolder.tvRecordOfflineCount.setVisibility(8);
            }
        }
        return view;
    }

    static class ViewHolder {
        ImageView ivItemLine;
        LinearLayout llDetailLayout;
        RelativeLayout llRecordDetailBottom;
        RelativeLayout rlDetail;
        TextView tvItemTime;
        TextView tvRecordDetailAmount;
        TextView tvRecordDetailDevice;
        TextView tvRecordOfflineCount;
        TextView tvRecordType;

        private void initViewNew(View view) {
            this.tvItemTime = (TextView) view.findViewById(R.id.tv_item_time);
            this.ivItemLine = (ImageView) view.findViewById(R.id.iv_item_line);
            this.tvRecordDetailAmount = (TextView) view.findViewById(R.id.tv_record_detail_amount);
            this.tvRecordDetailDevice = (TextView) view.findViewById(R.id.tv_record_detail_device);
            this.llDetailLayout = (LinearLayout) view.findViewById(R.id.ll_detail_layout);
            this.rlDetail = (RelativeLayout) view.findViewById(R.id.rl_detail);
            this.llRecordDetailBottom = (RelativeLayout) view.findViewById(R.id.ll_record_detail_bottom);
            this.tvRecordType = (TextView) view.findViewById(R.id.tv_record_type);
            this.tvRecordOfflineCount = (TextView) view.findViewById(R.id.tv_record_offline_count);
        }

        ViewHolder(View view) {
            initViewNew(view);
        }
    }
}
