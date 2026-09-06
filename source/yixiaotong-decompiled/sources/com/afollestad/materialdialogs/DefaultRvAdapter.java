package com.afollestad.materialdialogs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.internal.MDTintHelper;
import com.afollestad.materialdialogs.util.DialogUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class DefaultRvAdapter extends RecyclerView.Adapter<DefaultVH> {
    private InternalListCallback callback;
    private final MaterialDialog dialog;
    private final GravityEnum itemGravity;
    private final int layout;

    public interface InternalListCallback {
        boolean onItemSelected(MaterialDialog materialDialog, View view, int i, CharSequence charSequence, boolean z);
    }

    public void setCallback(InternalListCallback internalListCallback) {
        this.callback = internalListCallback;
    }

    public DefaultRvAdapter(MaterialDialog materialDialog, int i) {
        this.dialog = materialDialog;
        this.layout = i;
        this.itemGravity = materialDialog.mBuilder.itemsGravity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DefaultVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.layout, viewGroup, false);
        DialogUtils.setBackgroundCompat(viewInflate, this.dialog.getListSelector());
        return new DefaultVH(viewInflate, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DefaultVH defaultVH, int i) {
        View view = defaultVH.itemView;
        boolean zIsIn = DialogUtils.isIn(Integer.valueOf(i), this.dialog.mBuilder.disabledIndices);
        int i2 = AnonymousClass1.$SwitchMap$com$afollestad$materialdialogs$MaterialDialog$ListType[this.dialog.listType.ordinal()];
        if (i2 == 1) {
            RadioButton radioButton = (RadioButton) defaultVH.control;
            boolean z = this.dialog.mBuilder.selectedIndex == i;
            MDTintHelper.setTint(radioButton, this.dialog.mBuilder.widgetColor);
            radioButton.setChecked(z);
            radioButton.setEnabled(!zIsIn);
        } else if (i2 == 2) {
            CheckBox checkBox = (CheckBox) defaultVH.control;
            boolean zContains = this.dialog.selectedIndicesList.contains(Integer.valueOf(i));
            MDTintHelper.setTint(checkBox, this.dialog.mBuilder.widgetColor);
            checkBox.setChecked(zContains);
            checkBox.setEnabled(!zIsIn);
        }
        defaultVH.title.setText(this.dialog.mBuilder.items.get(i));
        defaultVH.title.setTextColor(this.dialog.mBuilder.itemColor);
        this.dialog.setTypeface(defaultVH.title, this.dialog.mBuilder.regularFont);
        ViewGroup viewGroup = (ViewGroup) view;
        setupGravity(viewGroup);
        if (this.dialog.mBuilder.itemIds != null) {
            if (i < this.dialog.mBuilder.itemIds.length) {
                view.setId(this.dialog.mBuilder.itemIds[i]);
            } else {
                view.setId(-1);
            }
        }
        if (viewGroup.getChildCount() == 2) {
            if (viewGroup.getChildAt(0) instanceof CompoundButton) {
                viewGroup.getChildAt(0).setBackground(null);
            } else if (viewGroup.getChildAt(1) instanceof CompoundButton) {
                viewGroup.getChildAt(1).setBackground(null);
            }
        }
    }

    /* JADX INFO: renamed from: com.afollestad.materialdialogs.DefaultRvAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$afollestad$materialdialogs$MaterialDialog$ListType;

        static {
            int[] iArr = new int[MaterialDialog.ListType.values().length];
            $SwitchMap$com$afollestad$materialdialogs$MaterialDialog$ListType = iArr;
            try {
                iArr[MaterialDialog.ListType.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$afollestad$materialdialogs$MaterialDialog$ListType[MaterialDialog.ListType.MULTI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.dialog.mBuilder.items != null) {
            return this.dialog.mBuilder.items.size();
        }
        return 0;
    }

    private void setupGravity(ViewGroup viewGroup) {
        ((LinearLayout) viewGroup).setGravity(this.itemGravity.getGravityInt() | 16);
        if (viewGroup.getChildCount() == 2) {
            if (this.itemGravity == GravityEnum.END && !isRTL() && (viewGroup.getChildAt(0) instanceof CompoundButton)) {
                View view = (CompoundButton) viewGroup.getChildAt(0);
                viewGroup.removeView(view);
                TextView textView = (TextView) viewGroup.getChildAt(0);
                viewGroup.removeView(textView);
                textView.setPadding(textView.getPaddingRight(), textView.getPaddingTop(), textView.getPaddingLeft(), textView.getPaddingBottom());
                viewGroup.addView(textView);
                viewGroup.addView(view);
                return;
            }
            if (this.itemGravity == GravityEnum.START && isRTL() && (viewGroup.getChildAt(1) instanceof CompoundButton)) {
                View view2 = (CompoundButton) viewGroup.getChildAt(1);
                viewGroup.removeView(view2);
                TextView textView2 = (TextView) viewGroup.getChildAt(0);
                viewGroup.removeView(textView2);
                textView2.setPadding(textView2.getPaddingRight(), textView2.getPaddingTop(), textView2.getPaddingRight(), textView2.getPaddingBottom());
                viewGroup.addView(view2);
                viewGroup.addView(textView2);
            }
        }
    }

    private boolean isRTL() {
        return this.dialog.getBuilder().getContext().getResources().getConfiguration().getLayoutDirection() == 1;
    }

    public static class DefaultVH extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        final DefaultRvAdapter adapter;
        final CompoundButton control;
        final TextView title;

        public DefaultVH(View view, DefaultRvAdapter defaultRvAdapter) {
            super(view);
            this.control = (CompoundButton) view.findViewById(R.id.md_control);
            this.title = (TextView) view.findViewById(R.id.md_title);
            this.adapter = defaultRvAdapter;
            view.setOnClickListener(this);
            if (defaultRvAdapter.dialog.mBuilder.listLongCallback != null) {
                view.setOnLongClickListener(this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.adapter.callback != null) {
                this.adapter.callback.onItemSelected(this.adapter.dialog, view, getAdapterPosition(), (this.adapter.dialog.mBuilder.items == null || getAdapterPosition() >= this.adapter.dialog.mBuilder.items.size()) ? null : this.adapter.dialog.mBuilder.items.get(getAdapterPosition()), false);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (this.adapter.callback != null) {
                return this.adapter.callback.onItemSelected(this.adapter.dialog, view, getAdapterPosition(), (this.adapter.dialog.mBuilder.items == null || getAdapterPosition() >= this.adapter.dialog.mBuilder.items.size()) ? null : this.adapter.dialog.mBuilder.items.get(getAdapterPosition()), true);
            }
            return false;
        }
    }
}
