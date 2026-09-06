package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityV4SelectPlatformBinding implements ViewBinding {
    public final Button btnSearch;
    public final EditText etName;
    public final ImageView imgBack;
    public final ImageView imgDelect;
    public final ImageView imgSearch;
    public final ImageView ivAdd;
    public final ListView lvRecord;
    public final RecyclerView recyclerView;
    public final RelativeLayout relQrcode;
    public final RelativeLayout relSearch;
    private final RelativeLayout rootView;
    public final TitleBar titleBar;
    public final TextView tvNodata;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityV4SelectPlatformBinding(RelativeLayout relativeLayout, Button button, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ListView listView, RecyclerView recyclerView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TitleBar titleBar, TextView textView) {
        this.rootView = relativeLayout;
        this.btnSearch = button;
        this.etName = editText;
        this.imgBack = imageView;
        this.imgDelect = imageView2;
        this.imgSearch = imageView3;
        this.ivAdd = imageView4;
        this.lvRecord = listView;
        this.recyclerView = recyclerView;
        this.relQrcode = relativeLayout2;
        this.relSearch = relativeLayout3;
        this.titleBar = titleBar;
        this.tvNodata = textView;
    }

    public static ActivityV4SelectPlatformBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityV4SelectPlatformBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_v4_select_platform, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityV4SelectPlatformBinding bind(View view) {
        int i = R.id.btn_search;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.et_name;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.img_back;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.img_delect;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.img_search;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.iv_add;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView4 != null) {
                                i = R.id.lv_record;
                                ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                                if (listView != null) {
                                    i = R.id.recycler_view;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                    if (recyclerView != null) {
                                        i = R.id.rel_qrcode;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout != null) {
                                            i = R.id.rel_search;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout2 != null) {
                                                i = R.id.titleBar;
                                                TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                                if (titleBar != null) {
                                                    i = R.id.tv_nodata;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView != null) {
                                                        return new ActivityV4SelectPlatformBinding((RelativeLayout) view, button, editText, imageView, imageView2, imageView3, imageView4, listView, recyclerView, relativeLayout, relativeLayout2, titleBar, textView);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
