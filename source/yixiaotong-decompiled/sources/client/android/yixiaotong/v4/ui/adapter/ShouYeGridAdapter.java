package client.android.yixiaotong.v4.ui.adapter;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v4.http.bean.V4HomeInfoBean;
import client.android.yixiaotong.v4.util.V4LanguageUtils;
import com.facebook.common.util.UriUtil;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ShouYeGridAdapter extends BaseAdapter {
    private Activity context;
    private List<V4HomeInfoBean> dataList;
    private OnClickItemListener onClickItemListener;

    public interface OnClickItemListener {
        void onClick(int i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setData(List<V4HomeInfoBean> list) {
        this.dataList = list;
    }

    public void setOnItemClick(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    public ShouYeGridAdapter(Activity activity, List<V4HomeInfoBean> list) {
        this.context = activity;
        this.dataList = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dataList.size();
    }

    @Override // android.widget.Adapter
    public V4HomeInfoBean getItem(int i) {
        return this.dataList.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.wallet_grid_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.rel = (RelativeLayout) view.findViewById(R.id.ll_wallet1);
            viewHolder.iv = (ImageView) view.findViewById(R.id.iv_wallet1);
            viewHolder.tv = (TextView) view.findViewById(R.id.tv_wallet1_name);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.rel.setBackgroundColor(-197377);
        viewHolder.rel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.adapter.ShouYeGridAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ShouYeGridAdapter.this.onClickItemListener != null) {
                    ShouYeGridAdapter.this.onClickItemListener.onClick(i);
                }
            }
        });
        V4HomeInfoBean v4HomeInfoBean = this.dataList.get(i);
        String lanuage = LocalDataUtil.getLanuage(this.context);
        if (StringUtils.isNotEmpty(lanuage) && lanuage.equals(BaseActivity.LANGUAGEEN)) {
            viewHolder.tv.setText(V4LanguageUtils.getAppName(this.context, v4HomeInfoBean.productId, v4HomeInfoBean.appName));
        } else {
            viewHolder.tv.setText(v4HomeInfoBean.appName);
        }
        viewHolder.tv.setTextColor(-11380634);
        if (v4HomeInfoBean.productId == 1) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.xiyu)).build());
        } else if (v4HomeInfoBean.productId == 2) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.yinshui)).build());
        } else if (v4HomeInfoBean.productId == 4) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.xiyi)).build());
        } else if (v4HomeInfoBean.productId == 13) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.main_air)).build());
        } else if (v4HomeInfoBean.productId == 12) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.main_elecmeter)).build());
        } else if (v4HomeInfoBean.productId == 3) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.chuifeng)).build());
        } else if (v4HomeInfoBean.productId == 11) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.gyj)).build());
        } else if (v4HomeInfoBean.productId == 6) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_main_yuanchuan)).build());
        } else if (v4HomeInfoBean.productId == 7) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.lkj)).build());
        } else if (v4HomeInfoBean.productId == 10) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.xx)).build());
        } else if (v4HomeInfoBean.productId == 15) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.main_consumer)).build());
        } else if (v4HomeInfoBean.productId == 17) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_main_remotewater2)).build());
        } else if (v4HomeInfoBean.productId == 100) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_shouye_gouwu)).build());
        } else {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.drawable.icon_pic_loding)).build());
        }
        return view;
    }

    static class ViewHolder {
        ImageView iv;
        RelativeLayout rel;
        TextView tv;

        ViewHolder() {
        }
    }
}
