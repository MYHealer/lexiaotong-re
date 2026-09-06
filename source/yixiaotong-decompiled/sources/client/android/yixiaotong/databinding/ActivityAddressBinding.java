package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityAddressBinding implements ViewBinding {
    public final Button btnSearch;
    public final EditText etName;
    public final ImageView imgBack;
    public final ImageView imgDelect;
    public final ImageView imgSearch;
    public final ListView list;
    public final MultiStateView multiStateView;
    public final RelativeLayout relSearch;
    private final LinearLayout rootView;
    public final PullRefreshLayout swipeRefreshLayout;
    public final TitleBar titleBar;

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private ActivityAddressBinding(LinearLayout linearLayout, Button button, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, ListView listView, MultiStateView multiStateView, RelativeLayout relativeLayout, PullRefreshLayout pullRefreshLayout, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.btnSearch = button;
        this.etName = editText;
        this.imgBack = imageView;
        this.imgDelect = imageView2;
        this.imgSearch = imageView3;
        this.list = listView;
        this.multiStateView = multiStateView;
        this.relSearch = relativeLayout;
        this.swipeRefreshLayout = pullRefreshLayout;
        this.titleBar = titleBar;
    }

    public static ActivityAddressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAddressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_address, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityAddressBinding bind(View view) {
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
                            i = R.id.list;
                            ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                            if (listView != null) {
                                i = R.id.multiStateView;
                                MultiStateView multiStateView = (MultiStateView) ViewBindings.findChildViewById(view, i);
                                if (multiStateView != null) {
                                    i = R.id.rel_search;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout != null) {
                                        i = R.id.swipeRefreshLayout;
                                        PullRefreshLayout pullRefreshLayout = (PullRefreshLayout) ViewBindings.findChildViewById(view, i);
                                        if (pullRefreshLayout != null) {
                                            i = R.id.titleBar;
                                            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
                                            if (titleBar != null) {
                                                return new ActivityAddressBinding((LinearLayout) view, button, editText, imageView, imageView2, imageView3, listView, multiStateView, relativeLayout, pullRefreshLayout, titleBar);
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
