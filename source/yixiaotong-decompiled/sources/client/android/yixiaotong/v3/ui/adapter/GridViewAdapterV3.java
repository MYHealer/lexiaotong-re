package client.android.yixiaotong.v3.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.bean.login.JumpApp;
import client.android.yixiaotong.v3.bean.login.JumpAppBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.bumptech.glide.Glide;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class GridViewAdapterV3 extends BaseAdapter {
    private int curIndex;
    private LayoutInflater inflater;
    private Context mContext;
    private List<TypeInfoBean> mDatas;
    private List<JumpApp> mJumpAppList = new ArrayList();
    private int pageSize;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i + (this.curIndex * this.pageSize);
    }

    public GridViewAdapterV3(Context context, List<TypeInfoBean> list, int i, int i2) {
        this.mDatas = new ArrayList();
        this.mContext = context;
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
    public TypeInfoBean getItem(int i) {
        return this.mDatas.get(i + (this.curIndex * this.pageSize));
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.inflater.inflate(R.layout.wallet_grid_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.ll_wallet1 = (RelativeLayout) view.findViewById(R.id.ll_wallet1);
            viewHolder.tv = (TextView) view.findViewById(R.id.tv_wallet1_name);
            viewHolder.iv = (SimpleDraweeView) view.findViewById(R.id.iv_wallet1);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        int i2 = i + (this.curIndex * this.pageSize);
        viewHolder.ll_wallet1.setBackgroundColor(-197377);
        String lanuage = LocalDataUtil.getLanuage(this.mContext);
        if (StringUtils.isNotEmpty(lanuage) && lanuage.equals(BaseActivity.LANGUAGEEN)) {
            viewHolder.tv.setText(getAppName(this.mDatas.get(i2).base.typeId, this.mDatas.get(i2).base.appName));
        } else {
            viewHolder.tv.setText(this.mDatas.get(i2).base.appName);
        }
        viewHolder.tv.setTextColor(-11380634);
        if (this.mDatas.get(i2).base.typeId == 1) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.xiyu)).build());
        } else if (this.mDatas.get(i2).base.typeId == 2) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.main_vendingmachine)).build());
        } else if (this.mDatas.get(i2).base.typeId == 3) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.xiyi)).build());
        } else if (this.mDatas.get(i2).base.typeId == 4) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_qita_yuan)).build());
        } else if (this.mDatas.get(i2).base.typeId == 5) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.yongcan)).build());
        } else if (this.mDatas.get(i2).base.typeId == 6) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.yinshui)).build());
        } else if (this.mDatas.get(i2).base.typeId == 7) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.main_elecmeter)).build());
        } else if (this.mDatas.get(i2).base.typeId == 8) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.chuifeng)).build());
        } else if (this.mDatas.get(i2).base.typeId == 9) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.sellcard)).build());
        } else if (this.mDatas.get(i2).base.typeId == 10) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_shouye_menjin)).build());
        } else if (this.mDatas.get(i2).base.typeId == 11) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_shouye_zaotang)).build());
        } else if (this.mDatas.get(i2).base.typeId == 16) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.gyj)).build());
        } else if (this.mDatas.get(i2).base.typeId == 17) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_init_qrcodebath)).build());
        } else if (this.mDatas.get(i2).base.typeId == 18) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.l_main_yuanchuan)).build());
        } else if (this.mDatas.get(i2).base.typeId == 20) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.lkj)).build());
        } else if (this.mDatas.get(i2).base.typeId == 23) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.xx)).build());
        } else if (this.mDatas.get(i2).base.typeId == 26) {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.mipmap.main_consumer)).build());
        } else if (this.mDatas.get(i2).base.typeId >= 100) {
            List<JumpAppBean> jumpApp = InvestorInfoUtilControl.getInstance().getJumpApp();
            if (jumpApp != null && jumpApp.size() > 0) {
                viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.drawable.icon_pic_loding)).build());
                for (int i3 = 0; i3 < jumpApp.size(); i3++) {
                    if (this.mDatas.get(i2).base.typeId == i3 + 100) {
                        Glide.with(this.mContext).load(jumpApp.get(i3).icon).into(viewHolder.iv);
                    }
                }
            }
        } else {
            viewHolder.iv.setImageURI(new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(R.drawable.icon_pic_loding)).build());
        }
        return view;
    }

    class ViewHolder {
        public SimpleDraweeView iv;
        public RelativeLayout ll_wallet1;
        public TextView tv;

        ViewHolder() {
        }
    }

    private String getAppName(int i, String str) {
        if (i == 1) {
            return this.mContext.getResources().getString(R.string.bath);
        }
        if (i == 3) {
            return this.mContext.getResources().getString(R.string.laundry);
        }
        if (i == 16) {
            return this.mContext.getResources().getString(R.string.clothesdryer);
        }
        if (i == 18) {
            return this.mContext.getResources().getString(R.string.prepaidmeter);
        }
        if (i == 20) {
            return this.mContext.getResources().getString(R.string.drawmoney);
        }
        if (i == 23) {
            return this.mContext.getResources().getString(R.string.washshoes);
        }
        if (i != 26) {
            switch (i) {
                case 6:
                    return this.mContext.getResources().getString(R.string.drink);
                case 7:
                    return this.mContext.getResources().getString(R.string.elecmeter);
                case 8:
                    return this.mContext.getResources().getString(R.string.hairdryer);
                case 9:
                    return this.mContext.getResources().getString(R.string.sellcard);
                default:
                    return str;
            }
        }
        return this.mContext.getResources().getString(R.string.consumermachine);
    }
}
