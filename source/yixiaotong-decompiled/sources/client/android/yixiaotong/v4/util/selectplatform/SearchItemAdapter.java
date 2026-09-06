package client.android.yixiaotong.v4.util.selectplatform;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import client.android.yixiaotong.R;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SearchItemAdapter extends RecyclerView.Adapter<ViewHolder> {
    private OnItemDeleteListener deleteListener;
    private List<SearchItem> items;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(SearchItem searchItem);
    }

    public interface OnItemDeleteListener {
        void onItemDelete(SearchItem searchItem);
    }

    public SearchItemAdapter(List<SearchItem> list, OnItemClickListener onItemClickListener, OnItemDeleteListener onItemDeleteListener) {
        this.items = list;
        this.listener = onItemClickListener;
        this.deleteListener = onItemDeleteListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_search_history, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final SearchItem searchItem = this.items.get(i);
        viewHolder.titleText.setText(searchItem.getSchoolName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.util.selectplatform.SearchItemAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m571xc59322a(searchItem, view);
            }
        });
        viewHolder.deleteButton.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.util.selectplatform.SearchItemAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m572xa8c72e89(searchItem, view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$0$client-android-yixiaotong-v4-util-selectplatform-SearchItemAdapter, reason: not valid java name */
    /* synthetic */ void m571xc59322a(SearchItem searchItem, View view) {
        OnItemClickListener onItemClickListener = this.listener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(searchItem);
        }
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$1$client-android-yixiaotong-v4-util-selectplatform-SearchItemAdapter, reason: not valid java name */
    /* synthetic */ void m572xa8c72e89(SearchItem searchItem, View view) {
        OnItemDeleteListener onItemDeleteListener = this.deleteListener;
        if (onItemDeleteListener != null) {
            onItemDeleteListener.onItemDelete(searchItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public void updateItems(List<SearchItem> list) {
        this.items = list;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton deleteButton;
        TextView titleText;

        public ViewHolder(View view) {
            super(view);
            this.titleText = (TextView) view.findViewById(R.id.item_title);
            this.deleteButton = (ImageButton) view.findViewById(R.id.item_delete);
        }
    }
}
