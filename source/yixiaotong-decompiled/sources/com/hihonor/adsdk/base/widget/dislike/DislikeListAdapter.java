package com.hihonor.adsdk.base.widget.dislike;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hihonor.adsdk.base.NegativeFeedback;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.bean.DislikeInfo;
import com.hihonor.adsdk.base.callback.DislikeItemClickListener;
import com.hihonor.adsdk.common.f.j;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class DislikeListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<DislikeInfo> hnadsa;
    private DislikeItemClickListener hnadsb;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView hnadsa;

        public ViewHolder(View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R.id.dislike_item_text);
            this.hnadsa = textView;
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, j.hnadsa(textView.getContext(), 48.0f)));
        }

        public void hnadsa(DislikeInfo dislikeInfo) {
            this.hnadsa.setText(dislikeInfo.getText());
        }
    }

    public DislikeListAdapter(List<DislikeInfo> list) {
        this.hnadsa = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<DislikeInfo> list = this.hnadsa;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.hnadsa.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.honor_ads_dislike_item_text, viewGroup, false));
    }

    public void hnadsa(DislikeItemClickListener dislikeItemClickListener) {
        this.hnadsb = dislikeItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.hnadsa(this.hnadsa.get(i));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.dislike.DislikeListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.hnadsa(i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(int i, View view) {
        if (this.hnadsb != null) {
            if (this.hnadsa.get(i).getCode() == NegativeFeedback.POOR_CANCEL.getReason()) {
                this.hnadsb.onCancel();
            } else {
                this.hnadsb.onFeedItemClick(i, this.hnadsa.get(i), view);
            }
        }
    }
}
