package client.android.yixiaotong.ui.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import client.android.yixiaotong.R;

/* JADX INFO: compiled from: GongGaoLanInfoAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
class GGLViewHolder extends RecyclerView.ViewHolder {
    View fuit;
    public final TextView tvTime;
    public TextView tvTitle;

    public GGLViewHolder(View view) {
        super(view);
        this.fuit = view;
        this.tvTitle = (TextView) view.findViewById(R.id.tv_title);
        this.tvTime = (TextView) view.findViewById(R.id.tv_time);
    }
}
