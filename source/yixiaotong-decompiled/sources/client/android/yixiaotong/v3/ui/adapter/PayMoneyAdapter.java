package client.android.yixiaotong.v3.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.bean.pay.PayMoneyInfoBean;
import client.android.yixiaotong.v3.util.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PayMoneyAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private static final String TAG = "PayMoneyAdapter";
    private Activity mActivity;
    private OnItemClickListener mOnItemClickListener;
    private List<PayMoneyInfoBean> mDataList = new ArrayList();
    private int mSelectIndex = 0;

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setSelectIndex(int i) {
        this.mSelectIndex = i;
    }

    public PayMoneyAdapter(Activity activity, OnItemClickListener onItemClickListener) {
        this.mActivity = activity;
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setData(List<PayMoneyInfoBean> list) {
        if (list != null) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            LogUtil.e(TAG, "setData:" + this.mDataList.size());
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    @Override // android.widget.Adapter
    public PayMoneyInfoBean getItem(int i) {
        return this.mDataList.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity).inflate(R.layout.layout_money_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv_money.setText(getItem(i).payMoney + this.mActivity.getResources().getString(R.string.yuan));
        String str = getItem(i).giftMoney;
        if (StringUtils.isNotEmpty(str)) {
            viewHolder.tv_song.setVisibility(0);
            viewHolder.tv_song.setText(str);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            viewHolder.tv_money.setLayoutParams(layoutParams);
        } else {
            viewHolder.tv_song.setVisibility(8);
            int i2 = (int) (this.mActivity.getResources().getDisplayMetrics().density * 12.0f);
            viewHolder.tv_money.setPadding(0, i2, 0, i2);
        }
        if (this.mSelectIndex == i) {
            viewHolder.mRel.setBackground(this.mActivity.getResources().getDrawable(R.drawable.shape_6f32fd_round_background));
            viewHolder.tv_money.setTextColor(this.mActivity.getResources().getColor(R.color.white));
            viewHolder.tv_song.setTextColor(this.mActivity.getResources().getColor(R.color.white));
        } else {
            viewHolder.mRel.setBackground(this.mActivity.getResources().getDrawable(R.drawable.shape_a1a6b3_background));
            viewHolder.tv_money.setTextColor(this.mActivity.getResources().getColor(R.color.ff242933));
            viewHolder.tv_song.setTextColor(this.mActivity.getResources().getColor(R.color.fff13628));
        }
        return view;
    }

    class ViewHolder {
        public RelativeLayout mRel;
        public TextView tv_money;
        public TextView tv_song;

        public ViewHolder(View view) {
            this.mRel = (RelativeLayout) view.findViewById(R.id.rel_bg);
            this.tv_money = (TextView) view.findViewById(R.id.tv_money);
            this.tv_song = (TextView) view.findViewById(R.id.tv_song);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mSelectIndex = i;
        OnItemClickListener onItemClickListener = this.mOnItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(i);
        }
    }
}
