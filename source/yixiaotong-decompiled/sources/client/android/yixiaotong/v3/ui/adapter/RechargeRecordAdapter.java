package client.android.yixiaotong.v3.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.v3.bean.pay.RechargeRecordInfoBean;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RechargeRecordAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private static final String TAG = "RechargeRecordAdapter";
    private Activity mActivity;
    private int mMoney;
    private OnItemClickListener mOnItemClickListener;
    private List<RechargeRecordInfoBean> mListDatas = new ArrayList();
    private int mSelectIndex = 0;

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public RechargeRecordAdapter(Activity activity, OnItemClickListener onItemClickListener) {
        this.mActivity = activity;
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setData(List<RechargeRecordInfoBean> list) {
        if (list != null) {
            this.mListDatas.clear();
            this.mListDatas.addAll(list);
        }
        this.mSelectIndex = 0;
        LogUtil.e(TAG, "setData:" + this.mListDatas.size());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mListDatas.size();
    }

    @Override // android.widget.Adapter
    public RechargeRecordInfoBean getItem(int i) {
        return this.mListDatas.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity).inflate(R.layout.layout_rechargerefund_item, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        RechargeRecordInfoBean item = getItem(i);
        LogUtil.e(TAG, "getView:" + item.time + PPSLabelView.Code + item.money + PPSLabelView.Code + i + PPSLabelView.Code + this.mListDatas.size());
        viewHolder.tv_title.setText(item.title);
        viewHolder.tv_money.setTextColor(this.mActivity.getResources().getColor(R.color.ff6f32fd));
        viewHolder.tv_time.setText(item.time);
        viewHolder.tv_money.setText("¥ " + item.money);
        viewHolder.tv_statetopright.setVisibility(8);
        if (item.state == 4) {
            viewHolder.tv_statetopright.setVisibility(0);
            viewHolder.tv_statetopright.setText(this.mActivity.getString(R.string.refunding));
        } else if (item.state == 5) {
            viewHolder.tv_statetopright.setVisibility(0);
            viewHolder.tv_statetopright.setText(this.mActivity.getString(R.string.refundsuccessful));
        }
        return view;
    }

    class ViewHolder {
        public TextView tv_money;
        public TextView tv_state;
        public TextView tv_statetopright;
        public TextView tv_time;
        public TextView tv_title;

        public ViewHolder(View view) {
            this.tv_title = (TextView) view.findViewById(R.id.tv_title);
            this.tv_money = (TextView) view.findViewById(R.id.tv_money);
            this.tv_time = (TextView) view.findViewById(R.id.tv_time);
            this.tv_state = (TextView) view.findViewById(R.id.tv_state);
            this.tv_statetopright = (TextView) view.findViewById(R.id.tv_statetopright);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        OnItemClickListener onItemClickListener = this.mOnItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(i);
        }
    }
}
