package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.miui.zeus.mimo.sdk.ad.reward.recycler.RewardRecyclerItemView;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d2 extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5403a;
    public List<String> b;
    public int c;

    public static final class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RewardRecyclerItemView f5404a;

        public a(RewardRecyclerItemView rewardRecyclerItemView) {
            super(rewardRecyclerItemView);
            this.f5404a = rewardRecyclerItemView;
        }
    }

    public d2(Context context, List<String> list, int i) {
        this.f5403a = context;
        this.b = list;
        this.c = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.b;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.b.size() == 1 ? 1 : Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        aVar.f5404a.getAvatarBgView().setVisibility(i == 0 ? 8 : 0);
        List<String> list = this.b;
        String str = list.get(i % list.size());
        if (b.h(str)) {
            Glide.with(y8.f5752a).load(new File(str)).transform(new CenterCrop(), new RoundedCorners(f9.a(this.f5403a, 10.9f))).into(aVar.f5404a.getAvatarImageView());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflaterFrom;
        int i2;
        int i3 = this.c;
        if (i3 == 1) {
            layoutInflaterFrom = LayoutInflater.from(this.f5403a);
            i2 = a0.L0;
        } else if (i3 == 0) {
            layoutInflaterFrom = LayoutInflater.from(this.f5403a);
            i2 = a0.h;
        } else {
            layoutInflaterFrom = LayoutInflater.from(this.f5403a);
            i2 = a0.L;
        }
        return new a((RewardRecyclerItemView) layoutInflaterFrom.inflate(i2, viewGroup, false));
    }
}
