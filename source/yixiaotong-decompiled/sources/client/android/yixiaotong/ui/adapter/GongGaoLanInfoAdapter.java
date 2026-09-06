package client.android.yixiaotong.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.gonggaolan.GetAllAnnounceBean;
import client.android.yixiaotong.ui.GongGaoLanDetailActivity;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.drinkwater.ParseUtil;
import client.android.yixiaotong.v3.ui.announcement.AnnouncementDetailActivity;
import client.android.yixiaotong.v3.util.LogUtil;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class GongGaoLanInfoAdapter extends RecyclerView.Adapter<GGLViewHolder> {
    private static final String TAG = "GongGaoLanInfoAdapter";
    private LayoutInflater inflater;
    private Activity mActivity;
    private List<GetAllAnnounceBean> mDatas;
    private boolean mIsAppV3 = false;

    public void setAppV3() {
        this.mIsAppV3 = true;
    }

    public GongGaoLanInfoAdapter(Activity activity, List<GetAllAnnounceBean> list) {
        this.mDatas = list;
        this.mActivity = activity;
        this.inflater = LayoutInflater.from(activity);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GGLViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new GGLViewHolder(this.inflater.inflate(R.layout.layout_gonggaolaninfo_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final GGLViewHolder gGLViewHolder, int i) {
        LogUtil.e(TAG, "onBindViewHolder:" + i);
        gGLViewHolder.tvTitle.setText(this.mDatas.get(i).Title);
        if (StringUtils.isNotEmpty(this.mDatas.get(i).AuditTime) && this.mDatas.get(i).AuditTime.length() > 8) {
            gGLViewHolder.tvTime.setText(ParseUtil.millisToData(this.mDatas.get(i).AuditTime.substring(6, this.mDatas.get(i).AuditTime.length() - 2)));
        }
        gGLViewHolder.fuit.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.adapter.GongGaoLanInfoAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int adapterPosition = gGLViewHolder.getAdapterPosition();
                if (GongGaoLanInfoAdapter.this.mIsAppV3) {
                    AnnouncementDetailActivity.launch(GongGaoLanInfoAdapter.this.mActivity, ((GetAllAnnounceBean) GongGaoLanInfoAdapter.this.mDatas.get(adapterPosition)).ID);
                } else {
                    GongGaoLanDetailActivity.launch(GongGaoLanInfoAdapter.this.mActivity, ((GetAllAnnounceBean) GongGaoLanInfoAdapter.this.mDatas.get(adapterPosition)).ID);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDatas.size();
    }
}
