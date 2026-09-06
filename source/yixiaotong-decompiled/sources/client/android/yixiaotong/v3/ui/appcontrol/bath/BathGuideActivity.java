package client.android.yixiaotong.v3.ui.appcontrol.bath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.region.RectRegion;
import client.android.yixiaotong.v3.ui.weight.HighLightLayoutV3;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BathGuideActivity extends Activity {
    public static final String EXTRA_POSITION = "extra_position";
    public static final String EXTRA_REGION_LIST = "extra_region_list";
    public static final String EXTRA_TYPEID = "extra_typeid";
    private static final String TAG = "BathGuideActivity";
    HighLightLayoutV3 mHighLightLayout;
    private int mPosition;
    private int mTypeId;
    private ArrayList<RectRegion> regions;

    static {
        StubApp.interface11(9088);
    }

    private void initClickListeners() {
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, ArrayList<RectRegion> arrayList, int i, int i2) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) BathGuideActivity.class);
            intent.putExtra("extra_region_list", arrayList);
            intent.putExtra("extra_typeid", i);
            intent.putExtra(EXTRA_POSITION, i2);
            activity.startActivity(intent);
        }
    }

    private void initViewNew() {
        this.mHighLightLayout = (HighLightLayoutV3) findViewById(R.id.highLightLayout);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void initView() {
        int i = (int) (this.regions.get(0).rectF.bottom + ((this.regions.get(0).rectF.bottom - this.regions.get(0).rectF.top) / 2.0f));
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.wenzi);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, i, 0, 0);
        if (this.mPosition == 2) {
            layoutParams.gravity = 5;
        } else {
            layoutParams.gravity = 1;
        }
        imageView.setLayoutParams(layoutParams);
        this.mHighLightLayout.addView(imageView, layoutParams);
        String str = TAG;
        LogUtil.e(str, this.regions.get(0).rectF.bottom + "  " + imageView.getHeight());
        imageView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        LogUtil.e(str, "width: " + imageView.getMeasuredWidth() + "  " + getResources().getDisplayMetrics().density);
        LogUtil.e(str, "height: " + imageView.getMeasuredHeight() + "  " + i);
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.mipmap.anniu);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, i + imageView.getMeasuredHeight() + 20, 0, 0);
        if (this.mPosition == 2) {
            layoutParams2.gravity = 5;
        } else {
            layoutParams2.gravity = 1;
        }
        imageView2.setLayoutParams(layoutParams2);
        this.mHighLightLayout.addView(imageView2, layoutParams2);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathGuideActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BathGuideActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
