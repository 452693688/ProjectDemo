package com.framebase.base.ui.adapters;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.framebase.app.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/12.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHodler> {
    public Context context;
    private ArrayList<String> dataList = new ArrayList<String>();

    public RecyclerAdapter(Context context, ArrayList<String> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public RecyclerAdapter(RecyclerView rv) {
        this.dataList = getData();
        if(rv==null){
            //return;
        }
        rv.setAdapter(this);
        // LinearLayoutManager 显示的为listView效果
        // LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //  new GridLayoutManager(this, 2);
        // StaggeredGridLayoutManager 显示的为网格效果
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);

        // 设置ItemAnimator
        rv.setItemAnimator(new DefaultItemAnimator());
        // 设置固定大小
        rv.setHasFixedSize(true);
    }

    public RecyclerAdapter(Context context) {
        this.context = context;
        this.dataList = getData();
    }

    private ArrayList<String> getData() {
        ArrayList<String> dataList = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            dataList.add("" + i);
        }
        return dataList;
    }

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_list_item, parent, false);
        ViewHodler holder = new ViewHodler(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHodler holder, int position) {
        int h = (int) (Math.random() * 1000);
        if (h < 100) {
            h = 200;
        }
        holder.textView.setText(dataList.get(position));
        // holder.itemView.setMinimumHeight(h);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHodler extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;

        public ViewHodler(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.test_tv);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            /*String str = dataList.get(2);
            if(str.equals("改变")){
                str="哈哈";
            }else {
                str = "改变";
            }
            dataList.set(2,str);*/
            // dataList.remove(2);
            RecyclerAdapter.this.notifyItemMoved(2, 4);
            // RecyclerAdapter.this.notifyItemChanged(2);
            //  RecyclerAdapter.this.notifyItemRemoved(2);
            // RecyclerAdapter.this.notifyItemInserted(47);
        }
    }
}
