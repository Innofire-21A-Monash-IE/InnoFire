package com.example.chadwickzhao.innofire;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
// this class is used to store the breathe image into adapter
public class BreatheSwipeAdapter extends PagerAdapter {

    private int[] image_resources1 = {R.drawable.breathe1,R.drawable.breathe2,R.drawable.breathe3,R.drawable.breathe4,R.drawable.breathe5,R.drawable.breathe6};

    private Context ctx1;
    private LayoutInflater layoutInflater1;
    public BreatheSwipeAdapter(Context ctx){
        this.ctx1 = ctx;
    }
    @Override
    public int getCount(){
        return image_resources1.length;
    }
    @Override
    public boolean isViewFromObject (View view, Object o){
        return (view == (LinearLayout)o);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater1 = (LayoutInflater)ctx1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater1.inflate(R.layout.activity_breathe_swipe_adapter, container, false);
        ImageView imageView =  (ImageView)item_view.findViewById(R.id.image_view1);
        imageView.setImageResource(image_resources1[position]);
        container.addView(item_view);
        return item_view;

    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }


}

