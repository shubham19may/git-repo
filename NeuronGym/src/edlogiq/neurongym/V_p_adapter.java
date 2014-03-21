package edlogiq.neurongym;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class V_p_adapter extends BaseAdapter {

	private Context context;
	int imageBackground;
	int height , width;
	public V_p_adapter(Context context, int h , int w) {
		this.context = context;
		this.height = h;
		this.width = w;
		Log.d("height", "height= "+h);
		Log.d("height", "width= "+w);
		TypedArray ta = context.obtainStyledAttributes(R.styleable.Gallery1);
		
	    imageBackground = ta.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 1);
	    ta.recycle();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imgId.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView iv = new ImageView(context);
	    iv.setImageResource(imgId[position]);
	    iv.setScaleType(ImageView.ScaleType.FIT_XY);
	    iv.setLayoutParams(new Gallery.LayoutParams(width/2 , height -20));
	    iv.setBackgroundResource(imageBackground);
	    return iv;
	}

	public Integer imgId[] = {
			R.drawable.dancing_balls_del
			
	};
}