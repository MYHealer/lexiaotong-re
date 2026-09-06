package client.android.yixiaotong.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.recharge.RechargeDetailBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class RechargeRecordAdapter extends BaseAdapter {
    private Activity mActivity;
    private int mIndex;
    private boolean mIsServerData;
    private List<RechargeDetailBean> mListData;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    public void setServerData(boolean z) {
        this.mIsServerData = z;
    }

    public RechargeRecordAdapter(Activity activity, List<RechargeDetailBean> list) {
        new ArrayList();
        this.mIndex = 0;
        this.mIsServerData = false;
        this.mActivity = activity;
        this.mListData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mListData.size();
    }

    @Override // android.widget.Adapter
    public RechargeDetailBean getItem(int i) {
        return this.mListData.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity).inflate(R.layout.recharge_record_item1, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        RechargeDetailBean item = getItem(i);
        viewHolder.tv_chongzhi.setText("充" + item.recharge + "元");
        viewHolder.tv_song.setText("送" + item.gift + "元");
        if (Float.parseFloat(item.gift) != 0.0f) {
            viewHolder.tv_song.setVisibility(0);
        } else if (this.mIsServerData) {
            viewHolder.tv_song.setVisibility(4);
        } else {
            viewHolder.tv_song.setVisibility(8);
        }
        if (this.mIndex == i) {
            viewHolder.mRel.setBackground(this.mActivity.getResources().getDrawable(R.drawable.shape_blue_button));
            viewHolder.tv_chongzhi.setTextColor(this.mActivity.getResources().getColor(R.color.white));
            viewHolder.tv_song.setTextColor(this.mActivity.getResources().getColor(R.color.white));
        } else {
            viewHolder.mRel.setBackgroundColor(this.mActivity.getResources().getColor(R.color.ffF6F7FB));
            viewHolder.tv_chongzhi.setTextColor(this.mActivity.getResources().getColor(R.color.ff333333));
            viewHolder.tv_song.setTextColor(this.mActivity.getResources().getColor(R.color.ffff504c));
        }
        return view;
    }

    class ViewHolder {
        public RelativeLayout mRel;
        public TextView tv_chongzhi;
        public TextView tv_song;

        public ViewHolder(View view) {
            this.mRel = (RelativeLayout) view.findViewById(R.id.ll_recharge_record);
            this.tv_chongzhi = (TextView) view.findViewById(R.id.tv_chongzhi);
            this.tv_song = (TextView) view.findViewById(R.id.tv_song);
        }
    }
}
