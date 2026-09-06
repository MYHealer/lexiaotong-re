package client.android.yixiaotong.v4.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4PayWayAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private static final String TAG = "V4PayWayAdapter";
    private Activity mActivity;
    private String mGift;
    private String mMoney;
    private OnItemClickListener mOnItemClickListener;
    private List<Integer> mPayFlagTypeList = new ArrayList();
    private int mSelectWay = 0;

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public V4PayWayAdapter(Activity activity, OnItemClickListener onItemClickListener) {
        this.mActivity = activity;
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setData(List<Integer> list, String str, String str2) {
        if (list != null) {
            this.mPayFlagTypeList.clear();
            this.mPayFlagTypeList.addAll(list);
        }
        this.mMoney = str;
        this.mGift = str2;
        this.mSelectWay = 0;
        LogUtil.e(TAG, "setData:" + this.mPayFlagTypeList.size());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mPayFlagTypeList.size();
    }

    @Override // android.widget.Adapter
    public Integer getItem(int i) {
        return this.mPayFlagTypeList.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.mActivity).inflate(R.layout.layout_rechargeway_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        int iIntValue = getItem(i).intValue();
        LogUtil.e(TAG, "getView:" + i + PPSLabelView.Code + iIntValue);
        viewHolder.img2.setImageResource(R.mipmap.wxz);
        viewHolder.tv_money.setVisibility(8);
        viewHolder.ll_gift_group.setVisibility(8);
        if (iIntValue == 3) {
            viewHolder.tv_money.setText("(" + this.mActivity.getString(R.string.balance) + this.mMoney + this.mActivity.getString(R.string.yuan) + ")");
            viewHolder.img.setImageResource(R.mipmap.wallet_icon);
            viewHolder.tv_name.setText(this.mActivity.getString(R.string.walletpay));
            if (StringUtils.isNotEmpty(this.mMoney) && StringUtils.isNotEmpty(this.mGift)) {
                viewHolder.tv_base_money.setText(this.mActivity.getString(R.string.basicamount) + "¥ " + this.mMoney);
                viewHolder.tv_gift_money.setText(this.mActivity.getString(R.string.giftamount) + "¥ " + this.mGift);
                viewHolder.ll_gift_group.setVisibility(0);
            }
        } else if (iIntValue == 1) {
            viewHolder.img.setImageResource(R.mipmap.wx);
            viewHolder.tv_name.setText(this.mActivity.getString(R.string.wechatpay));
        } else if (iIntValue == 2) {
            viewHolder.img.setImageResource(R.mipmap.zfb);
            viewHolder.tv_name.setText(this.mActivity.getString(R.string.alipaymeny));
        }
        if (this.mSelectWay == i) {
            viewHolder.img2.setImageResource(R.mipmap.xz1);
        }
        return view;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mSelectWay = i;
        OnItemClickListener onItemClickListener = this.mOnItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(i);
        }
    }

    class ViewHolder {
        public ImageView img;
        public ImageView img2;
        public LinearLayout ll_gift_group;
        public TextView tv_base_money;
        public TextView tv_gift_money;
        public TextView tv_money;
        public TextView tv_name;

        public ViewHolder(View view) {
            this.img = (ImageView) view.findViewById(R.id.img1);
            this.tv_name = (TextView) view.findViewById(R.id.textali);
            this.tv_money = (TextView) view.findViewById(R.id.tv_money);
            this.ll_gift_group = (LinearLayout) view.findViewById(R.id.ll_gift_group);
            this.tv_base_money = (TextView) view.findViewById(R.id.tv_base_money);
            this.tv_gift_money = (TextView) view.findViewById(R.id.tv_gift_money);
            this.img2 = (ImageView) view.findViewById(R.id.img_select_ali);
        }
    }
}
