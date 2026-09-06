package client.android.yixiaotong.ui.hamam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.hamam.HamamRecordBean;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HamamRecordsAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<HamamRecordBean> mRecordListBeans;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public HamamRecordsAdapter(LayoutInflater layoutInflater, List<HamamRecordBean> list, Context context) {
        this.mRecordListBeans = list;
        this.mInflater = layoutInflater;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mRecordListBeans.size();
    }

    @Override // android.widget.Adapter
    public HamamRecordBean getItem(int i) {
        return this.mRecordListBeans.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view != null) {
            viewHolder = (ViewHolder) view.getTag();
        } else {
            view = this.mInflater.inflate(R.layout.hamamrecord_item, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        HamamRecordBean hamamRecordBean = this.mRecordListBeans.get(i);
        if (i == 0) {
            viewHolder.line.setVisibility(4);
        }
        if (StringUtils.isNotEmpty(hamamRecordBean.payDatetime)) {
            viewHolder.datetime.setText(TimeUtils.formatDateTime(Long.parseLong(hamamRecordBean.payDatetime)));
        }
        viewHolder.money.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(hamamRecordBean.pay + "", "100")));
        DecimalUtil.twoDecimal(DecimalUtil.divide(hamamRecordBean.i42 + "", AdnConfig.b.hnadsa));
        if (hamamRecordBean.sysflag == 1) {
            viewHolder.chongzhistate.setText("公共浴室-未结算");
        } else if (hamamRecordBean.sysflag == 2) {
            viewHolder.chongzhistate.setText("公共浴室-已结算");
        } else {
            viewHolder.chongzhistate.setText("公共浴室-未知");
        }
        viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamRecordsAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                viewHolder.chongzhistate.equals("公共浴室-已结算");
            }
        });
        return view;
    }

    static class ViewHolder {
        public TextView chongzhistate;
        public TextView datetime;
        public LinearLayout lin;
        public View line;
        public TextView money;

        public ViewHolder(View view) {
            this.line = view.findViewById(R.id.line1);
            this.datetime = (TextView) view.findViewById(R.id.tv_datetime);
            this.money = (TextView) view.findViewById(R.id.tv_money);
            this.chongzhistate = (TextView) view.findViewById(R.id.tv_chongzhistate);
            this.lin = (LinearLayout) view.findViewById(R.id.lin);
        }
    }
}
