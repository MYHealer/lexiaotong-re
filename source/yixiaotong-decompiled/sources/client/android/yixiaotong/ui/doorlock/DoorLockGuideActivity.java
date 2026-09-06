package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.region.RectRegion;
import client.android.yixiaotong.ui.widget.HighLightLayout;
import com.stub.StubApp;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DoorLockGuideActivity extends AppCompatActivity {
    public static final String EXTRA_REGION_LIST = "extra_region_list";
    private HighLightLayout mHighLightLayout;
    private ArrayList<RectRegion> regions;

    static {
        StubApp.interface11(6939);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, ArrayList<RectRegion> arrayList) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) DoorLockGuideActivity.class);
            intent.putExtra("extra_region_list", arrayList);
            activity.startActivity(intent);
        }
    }

    private void initViewNew() {
        this.mHighLightLayout = (HighLightLayout) findViewById(R.id.highLightLayout);
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
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.l_doorlock_yindaoaddress);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, (int) this.regions.get(0).rectF.bottom, 0, 0);
        layoutParams.gravity = 3;
        imageView.setLayoutParams(layoutParams);
        this.mHighLightLayout.addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.mipmap.l_doorlock_yindaoaddpsw);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, (int) this.regions.get(2).rectF.bottom, 0, 0);
        imageView2.setLayoutParams(layoutParams2);
        this.mHighLightLayout.addView(imageView2, layoutParams2);
    }

    private void initClickListeners() {
        findViewById(R.id.highLightLayout).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.DoorLockGuideActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m104xfb482599(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-doorlock-DoorLockGuideActivity, reason: not valid java name */
    /* synthetic */ void m104xfb482599(View view) {
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
