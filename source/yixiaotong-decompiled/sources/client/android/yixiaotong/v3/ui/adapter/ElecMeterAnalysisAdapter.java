package client.android.yixiaotong.v3.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.v3.bean.elecmeter.MetersTrendBean;
import client.android.yixiaotong.v3.util.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ElecMeterAnalysisAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private static final String TAG = "ElecMeterAnalysisAdapter";
    private Activity mActivity;
    private int mMoney;
    private OnItemClickListener mOnItemClickListener;
    private List<MetersTrendBean> mListDatas = new ArrayList();
    private int mSelectIndex = 0;
    private boolean mShowMoney = false;
    private boolean mDailySummaryMode = false;
    private int mTypeFlag = 0;

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDailySummaryMode(boolean z) {
        this.mDailySummaryMode = z;
    }

    public void setShowMoney(boolean z) {
        this.mShowMoney = z;
    }

    public void setTypeFlag(int i) {
        this.mTypeFlag = i;
    }

    public ElecMeterAnalysisAdapter(Activity activity, OnItemClickListener onItemClickListener) {
        this.mActivity = activity;
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setData(List<MetersTrendBean> list) {
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
    public MetersTrendBean getItem(int i) {
        return this.mListDatas.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        String string;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity).inflate(R.layout.layout_elecmeter_annlysis, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        MetersTrendBean item = getItem(i);
        if (i == 0) {
            viewHolder.lin_unit.setVisibility(0);
            if (this.mDailySummaryMode) {
                viewHolder.tv_dosagetext.setVisibility(0);
                viewHolder.tv_moneytext.setVisibility(0);
                viewHolder.tv_tablecodetext.setVisibility(0);
                TextView textView = viewHolder.tv_dosagetext;
                if (this.mTypeFlag == 1) {
                    string = this.mActivity.getString(R.string.daily_usage_l);
                } else {
                    string = this.mActivity.getString(R.string.daily_usage_kwh);
                }
                textView.setText(string);
                viewHolder.tv_moneytext.setText(this.mActivity.getString(R.string.daily_consume_money));
                viewHolder.tv_tablecodetext.setText(this.mActivity.getString(R.string.daily_consume_count));
            } else {
                viewHolder.tv_moneytext.setVisibility(this.mShowMoney ? 0 : 8);
                if (this.mTypeFlag == 1) {
                    viewHolder.tv_dosagetext.setText(this.mActivity.getString(R.string.tablecodel));
                    viewHolder.tv_tablecodetext.setText(this.mActivity.getString(R.string.dosagel));
                } else {
                    viewHolder.tv_dosagetext.setText(this.mActivity.getString(R.string.tablecode));
                    viewHolder.tv_tablecodetext.setText(this.mActivity.getString(R.string.dosage));
                }
            }
        } else {
            viewHolder.lin_unit.setVisibility(8);
        }
        viewHolder.tv_time.setText(item.point);
        if (this.mDailySummaryMode) {
            viewHolder.tv_dosage.setText(item.usageAmount);
            viewHolder.tv_money.setVisibility(0);
            viewHolder.tv_tablecode.setVisibility(0);
            viewHolder.tv_money.setText(item.money != null ? item.money : "");
            viewHolder.tv_tablecode.setText(item.consumeCount != null ? item.consumeCount : "");
        } else {
            viewHolder.tv_dosage.setText(item.meters);
            viewHolder.tv_tablecode.setText(item.usageAmount);
            viewHolder.tv_money.setVisibility(this.mShowMoney ? 0 : 8);
            if (this.mShowMoney) {
                viewHolder.tv_money.setText(item.money != null ? item.money : "");
            }
        }
        return view;
    }

    class ViewHolder {
        public LinearLayout lin_unit;
        public TextView tv_dosage;
        public TextView tv_dosagetext;
        public TextView tv_money;
        public TextView tv_moneytext;
        public TextView tv_tablecode;
        public TextView tv_tablecodetext;
        public TextView tv_time;

        public ViewHolder(View view) {
            this.lin_unit = (LinearLayout) view.findViewById(R.id.lin_unit);
            this.tv_time = (TextView) view.findViewById(R.id.tv_time);
            this.tv_tablecode = (TextView) view.findViewById(R.id.tv_tablecode);
            this.tv_dosage = (TextView) view.findViewById(R.id.tv_dosage);
            this.tv_tablecodetext = (TextView) view.findViewById(R.id.tv_tablecodetext);
            this.tv_dosagetext = (TextView) view.findViewById(R.id.tv_dosagetext);
            this.tv_moneytext = (TextView) view.findViewById(R.id.tv_moneytext);
            this.tv_money = (TextView) view.findViewById(R.id.tv_money);
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
