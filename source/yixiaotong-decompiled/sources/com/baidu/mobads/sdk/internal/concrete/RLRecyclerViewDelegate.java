package com.baidu.mobads.sdk.internal.concrete;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alipay.sdk.widget.j;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.widget.RLRecyclerView;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class RLRecyclerViewDelegate extends RLRecyclerView implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f1779a;
    private final b b;

    public RLRecyclerViewDelegate(IAdInterListener iAdInterListener, Object[] objArr) {
        super((Context) objArr[0]);
        b bVar = new b();
        this.b = bVar;
        setLayoutManager(bVar.a(objArr, 1, 1), bVar.a(objArr, 2, 1), bVar.a(objArr, 3, 0));
        this.f1779a = c.a(iAdInterListener, this);
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public IAdInterListener getDelegator() {
        return this.f1779a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if ("setAdapter".equals(str2)) {
            setAdapter((RecyclerView.Adapter) objArr[0]);
            return null;
        }
        if ("setRefreshing".equals(str2)) {
            setRefreshing(((Boolean) objArr[0]).booleanValue());
            return null;
        }
        if ("setItemDecoration".equals(str2)) {
            setItemDecoration(this.b.a(objArr, 0, 4), this.b.a(objArr, 1, 10), this.b.a(objArr, 2, 4), this.b.a(objArr, 3, 10));
            return null;
        }
        if ("setRvPadding".equals(str2)) {
            setRecyclerViewPadding(this.b.a(objArr, 0, 6), this.b.a(objArr, 1, 0), this.b.a(objArr, 2, 6), this.b.a(objArr, 3, 0));
            return null;
        }
        if ("setRefreshEnable".equals(str2)) {
            setEnabled(((Boolean) objArr[0]).booleanValue());
            return null;
        }
        if ("scrollToPosition".equals(str2)) {
            scrollToPosition(this.b.a(objArr, 0, 0));
            return null;
        }
        if ("addOnScrollListener".equals(str2)) {
            final Object obj = objArr[0];
            addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate.1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    RLRecyclerViewDelegate.this.f1779a.a("onScrollStateChanged", obj, Integer.valueOf(i));
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    RLRecyclerViewDelegate.this.f1779a.a("onScrolled", obj, Integer.valueOf(i), Integer.valueOf(i2));
                }
            });
            return null;
        }
        if ("setOnRefreshListener".equals(str2)) {
            setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate.2
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public void onRefresh() {
                    RLRecyclerViewDelegate.this.f1779a.a(j.e);
                }
            });
            return null;
        }
        if ("findVisibleItemPositions".equals(str2)) {
            return findVisibleItemPositions();
        }
        if ("getLayoutManagerCounts".equals(str2)) {
            return getLayoutManagerCounts();
        }
        if ("getRvChildAt".equals(str2)) {
            return getRvChildAt(this.b.a(objArr, 0, -1));
        }
        if ("getRvChildCount".equals(str2)) {
            return Integer.valueOf(getRvChildCount());
        }
        if ("indexOfRvChild".equals(str2)) {
            return Integer.valueOf(indexOfRvChild((View) objArr[0]));
        }
        if ("getChildAdapterPosition".equals(str2)) {
            return Integer.valueOf(getChildAdapterPosition((View) objArr[0]));
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f1779a.setTarget(obj);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f1779a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f1779a.getType();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f1779a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f1779a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f1779a.getData();
    }
}
