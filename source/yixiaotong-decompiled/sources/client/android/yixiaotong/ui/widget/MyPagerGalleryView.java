package client.android.yixiaotong.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.imgutil.ImageCachceUitl;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.lxt.bluetoothsdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MyPagerGalleryView extends Gallery implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, View.OnTouchListener {
    private static final String TAG = "MyPagerGalleryView";
    private TextView adgallerytxt;
    private int curIndex;
    private Handler handler;
    private Handler handler1;
    private List<ImageView> listImgs;
    private int[] mAdsId;
    private Context mContext;
    private int mFocusedId;
    private MyOnItemClickListener mMyOnItemClickListener;
    private int mNormalId;
    private LinearLayout mOvalLayout;
    private int mSwitchTime;
    private Timer mTimer;
    private String[] mUris;
    private int oldIndex;
    private String[] txtViewpager;

    public interface MyOnItemClickListener {
        void onItemClick(int i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setMyOnItemClickListener(MyOnItemClickListener myOnItemClickListener) {
        this.mMyOnItemClickListener = myOnItemClickListener;
    }

    public MyPagerGalleryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.curIndex = 0;
        this.oldIndex = 0;
        this.listImgs = new ArrayList();
        this.handler1 = new Handler() { // from class: client.android.yixiaotong.ui.widget.MyPagerGalleryView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Bitmap bitmap = (Bitmap) message.obj;
                int i2 = message.arg1;
                if (bitmap == null || MyPagerGalleryView.this.listImgs == null || i2 >= MyPagerGalleryView.this.listImgs.size() || MyPagerGalleryView.this.listImgs.get(i2) == null) {
                    return;
                }
                ((ImageView) MyPagerGalleryView.this.listImgs.get(i2)).setImageBitmap(bitmap);
            }
        };
        this.handler = new Handler() { // from class: client.android.yixiaotong.ui.widget.MyPagerGalleryView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                MyPagerGalleryView.this.onScroll(null, null, 1.0f, 0.0f);
                MyPagerGalleryView.this.onKeyDown(22, null);
            }
        };
    }

    public MyPagerGalleryView(Context context) {
        super(context);
        this.curIndex = 0;
        this.oldIndex = 0;
        this.listImgs = new ArrayList();
        this.handler1 = new Handler() { // from class: client.android.yixiaotong.ui.widget.MyPagerGalleryView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Bitmap bitmap = (Bitmap) message.obj;
                int i2 = message.arg1;
                if (bitmap == null || MyPagerGalleryView.this.listImgs == null || i2 >= MyPagerGalleryView.this.listImgs.size() || MyPagerGalleryView.this.listImgs.get(i2) == null) {
                    return;
                }
                ((ImageView) MyPagerGalleryView.this.listImgs.get(i2)).setImageBitmap(bitmap);
            }
        };
        this.handler = new Handler() { // from class: client.android.yixiaotong.ui.widget.MyPagerGalleryView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                MyPagerGalleryView.this.onScroll(null, null, 1.0f, 0.0f);
                MyPagerGalleryView.this.onKeyDown(22, null);
            }
        };
    }

    public MyPagerGalleryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.curIndex = 0;
        this.oldIndex = 0;
        this.listImgs = new ArrayList();
        this.handler1 = new Handler() { // from class: client.android.yixiaotong.ui.widget.MyPagerGalleryView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Bitmap bitmap = (Bitmap) message.obj;
                int i2 = message.arg1;
                if (bitmap == null || MyPagerGalleryView.this.listImgs == null || i2 >= MyPagerGalleryView.this.listImgs.size() || MyPagerGalleryView.this.listImgs.get(i2) == null) {
                    return;
                }
                ((ImageView) MyPagerGalleryView.this.listImgs.get(i2)).setImageBitmap(bitmap);
            }
        };
        this.handler = new Handler() { // from class: client.android.yixiaotong.ui.widget.MyPagerGalleryView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                MyPagerGalleryView.this.onScroll(null, null, 1.0f, 0.0f);
                MyPagerGalleryView.this.onKeyDown(22, null);
            }
        };
    }

    public void start(Context context, String[] strArr, int[] iArr, int i, LinearLayout linearLayout, int i2, int i3, TextView textView, String[] strArr2) {
        this.mContext = context;
        this.mUris = strArr;
        this.mAdsId = iArr;
        this.mSwitchTime = i;
        this.mOvalLayout = linearLayout;
        this.mFocusedId = i2;
        this.mNormalId = i3;
        this.adgallerytxt = textView;
        this.txtViewpager = strArr2;
        ininImages();
        setAdapter((SpinnerAdapter) new AdAdapter());
        setOnItemClickListener(this);
        setOnTouchListener(this);
        setOnItemSelectedListener(this);
        setSoundEffectsEnabled(false);
        setAnimationDuration(200);
        setUnselectedAlpha(1.0f);
        setSpacing(0);
        if (getCount() != 0) {
            setSelection(((getCount() / 2) / this.listImgs.size()) * this.listImgs.size());
        }
        setFocusableInTouchMode(true);
        initOvalLayout();
        startTimer();
    }

    private void ininImages() {
        this.listImgs.clear();
        String[] strArr = this.mUris;
        int length = strArr != null ? strArr.length : this.mAdsId.length;
        ImageCachceUitl imageCachceUitl = new ImageCachceUitl(this.mContext, this.handler1);
        LogUtil.e(TAG, "ininImages:" + length);
        for (int i = 0; i < length; i++) {
            RoundImageView roundImageView = new RoundImageView(this.mContext);
            roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            roundImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            LogUtil.e(TAG, "ininImages:" + i + PPSLabelView.Code + this.mUris[i]);
            if (StringUtils.isNotEmpty(this.mUris[i])) {
                roundImageView.setImageBitmap(imageCachceUitl.getBitmapFromUrl(this.mUris[i], i));
            } else {
                roundImageView.setImageResource(R.mipmap.shouyebanner);
            }
            this.listImgs.add(roundImageView);
        }
    }

    public void initOvalLayout() {
        LogUtil.e(TAG, "initOvalLayout:" + this.listImgs.size());
        if (this.mOvalLayout != null && this.listImgs.size() < 2) {
            this.mOvalLayout.removeAllViews();
            return;
        }
        LinearLayout linearLayout = this.mOvalLayout;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            int i = (int) (((double) this.mOvalLayout.getLayoutParams().height) * 0.7d);
            int i2 = (int) (((double) this.mOvalLayout.getLayoutParams().height) * 0.2d);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            layoutParams.setMargins(i2, 0, i2, 0);
            for (int i3 = 0; i3 < this.listImgs.size(); i3++) {
                View view = new View(this.mContext);
                view.setLayoutParams(layoutParams);
                view.setBackgroundResource(this.mNormalId);
                this.mOvalLayout.addView(view);
            }
            this.mOvalLayout.getChildAt(0).setBackgroundResource(this.mFocusedId);
        }
    }

    class AdAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        AdAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (MyPagerGalleryView.this.listImgs.size() < 2) {
                return MyPagerGalleryView.this.listImgs.size();
            }
            return Integer.MAX_VALUE;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return (View) MyPagerGalleryView.this.listImgs.get(i % MyPagerGalleryView.this.listImgs.size());
        }
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        onKeyDown(isScrollingLeft(motionEvent, motionEvent2) ? 21 : 22, null);
        return true;
    }

    private boolean isScrollingLeft(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return motionEvent2.getX() > motionEvent.getX() + 50.0f;
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
            startTimer();
            return false;
        }
        stopTimer();
        return false;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.curIndex = i % this.listImgs.size();
        if (this.mOvalLayout == null || this.listImgs.size() <= 1) {
            return;
        }
        if (this.mOvalLayout.getChildAt(this.oldIndex) != null) {
            this.mOvalLayout.getChildAt(this.oldIndex).setBackgroundResource(this.mNormalId);
        }
        if (this.mOvalLayout.getChildAt(this.curIndex) != null) {
            this.mOvalLayout.getChildAt(this.curIndex).setBackgroundResource(this.mFocusedId);
        }
        this.oldIndex = this.curIndex;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MyOnItemClickListener myOnItemClickListener = this.mMyOnItemClickListener;
        if (myOnItemClickListener != null) {
            myOnItemClickListener.onItemClick(this.curIndex);
        }
    }

    public void stopTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }

    public void startTimer() {
        List<ImageView> list;
        if (this.mTimer != null || (list = this.listImgs) == null || list.size() <= 1 || this.mSwitchTime <= 0) {
            return;
        }
        Timer timer = new Timer();
        this.mTimer = timer;
        TimerTask timerTask = new TimerTask() { // from class: client.android.yixiaotong.ui.widget.MyPagerGalleryView.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MyPagerGalleryView.this.handler.sendMessage(MyPagerGalleryView.this.handler.obtainMessage(1));
            }
        };
        int i = this.mSwitchTime;
        timer.schedule(timerTask, i, i);
    }
}
