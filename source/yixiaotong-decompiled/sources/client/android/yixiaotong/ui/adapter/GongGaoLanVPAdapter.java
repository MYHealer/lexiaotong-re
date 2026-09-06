package client.android.yixiaotong.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class GongGaoLanVPAdapter extends PagerAdapter {
    private List<ImageView> imageViews;

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public GongGaoLanVPAdapter(List<ImageView> list) {
        this.imageViews = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageView imageView = this.imageViews.get(Math.abs(i % this.imageViews.size()));
        ViewParent parent = imageView.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(imageView);
        }
        viewGroup.addView(imageView);
        return imageView;
    }
}
