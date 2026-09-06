package client.android.yixiaotong.v4.ui.debug;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.TimeUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4LogAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<V4LogEntry> mData = new ArrayList();
    private final SimpleDateFormat mTimeFormat = new SimpleDateFormat(TimeUtils.FORMATIME, Locale.getDefault());

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_v4_log_entry, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        int color;
        V4LogEntry v4LogEntry = this.mData.get(i);
        viewHolder.tvIndex.setText(String.valueOf(v4LogEntry.id));
        viewHolder.tvTime.setText(this.mTimeFormat.format(new Date(v4LogEntry.timestamp)));
        viewHolder.tvContent.setText(v4LogEntry.content);
        int i2 = AnonymousClass1.$SwitchMap$client$android$yixiaotong$v4$ui$debug$V4LogEntry$Level[v4LogEntry.level.ordinal()];
        if (i2 == 1) {
            color = Color.parseColor("#E74C3C");
        } else if (i2 == 2) {
            color = Color.parseColor("#E67E22");
        } else if (i2 == 3) {
            color = Color.parseColor("#3498DB");
        } else if (i2 == 4) {
            color = Color.parseColor("#27AE60");
        } else {
            color = Color.parseColor("#95A5A6");
        }
        viewHolder.vLevelDot.setBackgroundColor(color);
        viewHolder.tvContent.setTextColor(color);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.v4.ui.debug.V4LogAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$client$android$yixiaotong$v4$ui$debug$V4LogEntry$Level;

        static {
            int[] iArr = new int[V4LogEntry.Level.values().length];
            $SwitchMap$client$android$yixiaotong$v4$ui$debug$V4LogEntry$Level = iArr;
            try {
                iArr[V4LogEntry.Level.E.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$client$android$yixiaotong$v4$ui$debug$V4LogEntry$Level[V4LogEntry.Level.W.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$client$android$yixiaotong$v4$ui$debug$V4LogEntry$Level[V4LogEntry.Level.D.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$client$android$yixiaotong$v4$ui$debug$V4LogEntry$Level[V4LogEntry.Level.I.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    public void setData(List<V4LogEntry> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void addEntries(List<V4LogEntry> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.mData.size();
        this.mData.addAll(list);
        notifyItemRangeInserted(size, list.size());
    }

    public void clear() {
        this.mData.clear();
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvContent;
        final TextView tvIndex;
        final TextView tvTime;
        final View vLevelDot;

        ViewHolder(View view) {
            super(view);
            this.vLevelDot = view.findViewById(R.id.v_level_dot);
            this.tvIndex = (TextView) view.findViewById(R.id.tv_index);
            this.tvTime = (TextView) view.findViewById(R.id.tv_time);
            this.tvContent = (TextView) view.findViewById(R.id.tv_content);
        }
    }
}
