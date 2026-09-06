package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class w8 extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5730a;
    public List<String> b;

    public final class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f5731a;
        public View b;
        public View c;

        public a(w8 w8Var, View view) {
            super(view);
            this.f5731a = (ImageView) view.findViewById(a0.W3);
            this.c = view.findViewById(a0.F);
            this.b = view.findViewById(a0.a3);
        }
    }

    public w8(Context context, List<String> list) {
        this.f5730a = context;
        if (context == null) {
            return;
        }
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.b;
        return (list == null || list.isEmpty()) ? 0 : Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        aVar.getAdapterPosition();
        if (i == 0) {
            aVar.b.setVisibility(0);
            aVar.c.setVisibility(8);
        }
        if (b.b(this.f5730a)) {
            return;
        }
        RequestManager requestManagerWith = Glide.with(this.f5730a);
        List<String> list = this.b;
        requestManagerWith.load(new File(list.get(i % list.size()))).transform(new CenterCrop(), new RoundedCorners(f9.a(this.f5730a, 14.9f))).into(aVar.f5731a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this, LayoutInflater.from(this.f5730a).inflate(a0.h5, viewGroup, false));
    }
}
