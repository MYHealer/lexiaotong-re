package client.android.yixiaotong.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.model.WalletModel;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class GridViewAdapter extends BaseAdapter {
    private int curIndex;
    private LayoutInflater inflater;
    private List<WalletModel> mDatas;
    private int pageSize;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i + (this.curIndex * this.pageSize);
    }

    public GridViewAdapter(Context context, List<WalletModel> list, int i, int i2) {
        this.mDatas = new ArrayList();
        this.inflater = LayoutInflater.from(context);
        this.mDatas = list;
        this.curIndex = i;
        this.pageSize = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size = this.mDatas.size();
        int i = this.curIndex + 1;
        int i2 = this.pageSize;
        return size > i * i2 ? i2 : this.mDatas.size() - (this.curIndex * this.pageSize);
    }

    @Override // android.widget.Adapter
    public WalletModel getItem(int i) {
        return this.mDatas.get(i + (this.curIndex * this.pageSize));
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.inflater.inflate(R.layout.wallet_grid_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.tv = (TextView) view.findViewById(R.id.tv_wallet1_name);
            viewHolder.iv = (SimpleDraweeView) view.findViewById(R.id.iv_wallet1);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        int i2 = i + (this.curIndex * this.pageSize);
        viewHolder.tv.setText(this.mDatas.get(i2).name);
        if (this.mDatas.get(i2).typeId == 1) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_shouye_xizao)).build());
        } else if (this.mDatas.get(i2).typeId == 2) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_shouye_gouwu)).build());
        } else if (this.mDatas.get(i2).typeId == 3) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_shouye_xiyi)).build());
        } else if (this.mDatas.get(i2).typeId == 4) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_qita_yuan)).build());
        } else if (this.mDatas.get(i2).typeId == 5) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_shouye_yongcan)).build());
        } else if (this.mDatas.get(i2).typeId == 6) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_shouye_yinshui)).build());
        } else if (this.mDatas.get(i2).typeId == 7) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_shouye_chongdian)).build());
        } else if (this.mDatas.get(i2).typeId == 8) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_shouye_chuifeng)).build());
        } else if (this.mDatas.get(i2).typeId == 9) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_shouye_shouka)).build());
        } else if (this.mDatas.get(i2).typeId == 10) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_shouye_menjin)).build());
        } else if (this.mDatas.get(i2).typeId == 11) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_shouye_zaotang)).build());
        } else if (this.mDatas.get(i2).typeId == 16) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_chongzhi_dry)).build());
        } else if (this.mDatas.get(i2).typeId == 17) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_init_qrcodebath)).build());
        } else if (this.mDatas.get(i2).typeId == 18) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_main_yuanchuan)).build());
        } else {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.drawable.icon_pic_loding)).build());
        }
        return view;
    }

    class ViewHolder {
        public SimpleDraweeView iv;
        public TextView tv;

        ViewHolder() {
        }
    }
}
