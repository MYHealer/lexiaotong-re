package client.android.yixiaotong.v4.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.bean.V4RefundDetailBean;
import client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeRecordActivity;
import client.android.yixiaotong.v4.util.homeinfo.V4TypeIDSetUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4RechargeRecordAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private static final String TAG = "V4RechargeRecordAdapter";
    private Activity mActivity;
    private int mMoney;
    private OnItemClickListener mOnItemClickListener;
    private int mProductId;
    private V4ElecMeterRechargeRecordActivity.State mState;
    private List<V4RefundDetailBean> mListDatas = new ArrayList();
    private int mSelectIndex = 0;

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public V4RechargeRecordAdapter(Activity activity, int i, OnItemClickListener onItemClickListener) {
        this.mActivity = activity;
        this.mProductId = i;
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setData(List<V4RefundDetailBean> list, V4ElecMeterRechargeRecordActivity.State state) {
        if (list != null) {
            this.mListDatas.clear();
            this.mListDatas.addAll(list);
        }
        this.mSelectIndex = 0;
        this.mState = state;
        LogUtil.e(TAG, "setData:" + this.mListDatas.size() + PPSLabelView.Code + this.mState);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mListDatas.size();
    }

    @Override // android.widget.Adapter
    public V4RefundDetailBean getItem(int i) {
        return this.mListDatas.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        String strBuildTitleWithStatus;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity).inflate(R.layout.layout_rechargerefund_item, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        V4RefundDetailBean item = getItem(i);
        if (this.mState == V4ElecMeterRechargeRecordActivity.State.recharge) {
            strBuildTitleWithStatus = V4TypeIDSetUtil.getAppName(this.mActivity, this.mProductId) + this.mActivity.getResources().getString(R.string.recharge);
            viewHolder.tv_money.setTextColor(this.mActivity.getResources().getColor(R.color.ff6f32fd));
            viewHolder.tv_time.setText(item.createTime);
            viewHolder.tv_money.setText("¥ " + item.amount);
            viewHolder.tv_state.setText(this.mActivity.getString(R.string.recharge));
        } else {
            strBuildTitleWithStatus = V4TypeIDSetUtil.getAppName(this.mActivity, this.mProductId) + this.mActivity.getResources().getString(R.string.refund);
            viewHolder.tv_money.setTextColor(this.mActivity.getResources().getColor(R.color.ff6f32fd));
            viewHolder.tv_time.setText(item.createTime);
            viewHolder.tv_money.setText("¥ " + formatRefundAmount(item));
            viewHolder.tv_state.setText(this.mActivity.getString(R.string.refund));
        }
        TextView textView = viewHolder.tv_title;
        if (this.mState != V4ElecMeterRechargeRecordActivity.State.recharge) {
            strBuildTitleWithStatus = buildTitleWithStatus(strBuildTitleWithStatus, item.statusName);
        }
        textView.setText(strBuildTitleWithStatus);
        viewHolder.tv_statetopright.setVisibility(8);
        return view;
    }

    private String buildTitleWithStatus(String str, String str2) {
        return StringUtils.isNotEmpty(str2) ? str + " (" + str2 + ")" : str;
    }

    private String formatRefundAmount(V4RefundDetailBean v4RefundDetailBean) {
        if (v4RefundDetailBean.refundAmount > 0.0d) {
            return String.valueOf(v4RefundDetailBean.refundAmount);
        }
        return v4RefundDetailBean.amount == null ? "" : v4RefundDetailBean.amount;
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
