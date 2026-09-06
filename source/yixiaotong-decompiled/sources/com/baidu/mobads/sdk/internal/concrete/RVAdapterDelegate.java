package com.baidu.mobads.sdk.internal.concrete;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class RVAdapterDelegate extends RecyclerView.Adapter<RVViewHolderDelegate> implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f1782a;
    private final b b;

    public RVAdapterDelegate(IAdInterListener iAdInterListener) {
        this.f1782a = c.a(iAdInterListener, this);
        registerAdapterDataObserver(new ViewPager2.DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                RVAdapterDelegate.this.f1782a.a("onChanged");
            }
        });
        this.b = new b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RVViewHolderDelegate onCreateViewHolder(ViewGroup viewGroup, int i) {
        Object objA = this.f1782a.a("onCreateViewHolder", viewGroup, Integer.valueOf(i));
        if (objA instanceof RVViewHolderDelegate) {
            return (RVViewHolderDelegate) objA;
        }
        return new RVViewHolderDelegate(this.f1782a.getDelegator(), viewGroup) { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.2
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RVViewHolderDelegate rVViewHolderDelegate, int i) {
        this.f1782a.a("onBindViewHolder", rVViewHolderDelegate.getDelegator(), Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Object objA = this.f1782a.a("getItemCount", new Object[0]);
        if (objA instanceof Integer) {
            return ((Integer) objA).intValue();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        Object objA = this.f1782a.a("getItemId", Integer.valueOf(i));
        if (objA instanceof Integer) {
            return ((Integer) objA).intValue();
        }
        return super.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        Object objA = this.f1782a.a("getItemType", Integer.valueOf(i));
        if (objA instanceof Integer) {
            return ((Integer) objA).intValue();
        }
        return super.getItemViewType(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewRecycled(rVViewHolderDelegate);
        this.f1782a.a("onViewRecycled", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RVViewHolderDelegate rVViewHolderDelegate) {
        Object objA = this.f1782a.a("onFailedToRecycleView", rVViewHolderDelegate.getDelegator());
        if (objA instanceof Boolean) {
            return ((Boolean) objA).booleanValue();
        }
        return super.onFailedToRecycleView(rVViewHolderDelegate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewAttachedToWindow(rVViewHolderDelegate);
        this.f1782a.a("onViewAttachedToWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RVViewHolderDelegate rVViewHolderDelegate) {
        super.onViewDetachedFromWindow(rVViewHolderDelegate);
        this.f1782a.a("onViewDetachedFromWindow", rVViewHolderDelegate.getDelegator());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f1782a.a("onAttachedToRecyclerView", recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f1782a.a("onDetachedFromRecyclerView", recyclerView);
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public IAdInterListener getDelegator() {
        return this.f1782a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if ("notifyItemChanged".equals(str2)) {
            notifyItemChanged(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, (Object) null));
        } else if ("notifyRangeInserted".equals(str2)) {
            notifyItemRangeInserted(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, 0));
        } else if ("notifyRangeRemoved".equals(str2)) {
            notifyItemRangeRemoved(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, 0));
        } else if ("notifyItemRangeChanged".equals(str2)) {
            notifyItemRangeChanged(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, 0));
        } else if ("notifyDataSetChanged".equals(str2)) {
            notifyDataSetChanged();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f1782a.setTarget(obj);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f1782a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f1782a.getType();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f1782a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f1782a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f1782a.getData();
    }
}
