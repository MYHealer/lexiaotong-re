package com.baidu.mobads.sdk.internal.concrete;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.c;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class RVViewHolderDelegate extends RecyclerView.ViewHolder implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f1785a;

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    public RVViewHolderDelegate(IAdInterListener iAdInterListener, View view) {
        super(view);
        this.f1785a = c.a(iAdInterListener, this);
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public IAdInterListener getDelegator() {
        return this.f1785a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f1785a.setTarget(obj);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f1785a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f1785a.getType();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f1785a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f1785a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f1785a.getData();
    }
}
