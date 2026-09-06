package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.sdk.R;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class BiserialDownloadProgressView extends DownloadProgressView {
    public BiserialDownloadProgressView(Context context) {
        super(context);
    }

    public BiserialDownloadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BiserialDownloadProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    protected final void ot() {
        m.inflate(getContext(), R.layout.ksad_download_progress_biserial_layout, this);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    protected final void ou() {
        this.Of = getResources().getDrawable(R.drawable.ksad_feed_download_progress_novel);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    protected final void ov() {
        this.Og = getResources().getDrawable(R.drawable.ksad_feed_actionbar_before_bg);
    }
}
