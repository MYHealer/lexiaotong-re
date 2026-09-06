package com.kwad.components.core.innerEc.live.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class h extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<c> Ze = new ArrayList();

    public final void b(c cVar) {
        this.Ze.add(cVar);
        notifyItemInserted(this.Ze.size() - 1);
    }

    public final void p(List<c> list) {
        int size = this.Ze.size();
        this.Ze.addAll(list);
        notifyItemRangeInserted(size, list.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return this.Ze.get(i).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        if (i == 1) {
            return new a(layoutInflaterFrom.inflate(R.layout.ksad_live_system_notice_item, viewGroup, false));
        }
        return new b(layoutInflaterFrom.inflate(R.layout.ksad_live_simple_list_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        c cVar = this.Ze.get(i);
        if (viewHolder instanceof b) {
            ((b) viewHolder).c(cVar);
        } else if (viewHolder instanceof a) {
            ((a) viewHolder).c(cVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.Ze.size();
    }

    static class b extends RecyclerView.ViewHolder {
        private final TextView Zf;

        public b(View view) {
            super(view);
            this.Zf = (TextView) view.findViewById(R.id.ksad_content);
        }

        public final void c(c cVar) {
            this.Zf.setText(cVar.sO());
            final ViewGroup viewGroup = (ViewGroup) this.Zf.getParent();
            final ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            this.Zf.post(new bi() { // from class: com.kwad.components.core.innerEc.live.widget.h.b.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (b.this.Zf.getLineCount() == 1) {
                        viewGroup.setBackground(ContextCompat.getDrawable(b.this.itemView.getContext(), R.drawable.ksad_live_comment_single_line_bg));
                    } else {
                        viewGroup.setBackground(ContextCompat.getDrawable(b.this.itemView.getContext(), R.drawable.ksad_live_comment_double_line_bg));
                    }
                    viewGroup.setLayoutParams(layoutParams);
                }
            });
        }
    }

    static class a extends RecyclerView.ViewHolder {
        private final TextView Zf;

        public a(View view) {
            super(view);
            this.Zf = (TextView) view.findViewById(R.id.ksad_content);
        }

        public final void c(c cVar) {
            this.Zf.setText(cVar.sO());
        }
    }
}
