package kr.hs.emirim.s2019w39.votemamamoo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GridAdapter extends BaseAdapter {
    Context context;
    int[] imgFileNames = {R.drawable.solar1, R.drawable.moonbyul1, R.drawable.wheein1, R.drawable.hwasa1, R.drawable.solar2, R.drawable.moonbyul2, R.drawable.wheein2, R.drawable.hwasa2, R.drawable.moonbyul3};
    String[] imgNames = {"금발솔라", "그레이문별", "브라운휘인", "블랙화사", "핑크솔라", "오렌지문별", "금발휘인", "퀸화사", "브라운문별"};
    int[] voteCount = new int[imgNames.length];

    public GridAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return imgFileNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgv = new ImageView(context);
        imgv.setLayoutParams(new GridView.LayoutParams(300, 400));
        imgv.setAdjustViewBounds(true);
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imgv.setPadding(10, 10, 10, 10);
        imgv.setImageResource(imgFileNames[position]);
        for (int i = 0; i < voteCount.length; i++) {
            voteCount[i] = 0;
        }

        final int pos = position;
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voteCount[pos]++;
                Toast.makeText(context, imgNames[pos] + ": 총 " + voteCount[pos] + "표", Toast.LENGTH_SHORT).show();
            }
        });
        return imgv;
    }
}
