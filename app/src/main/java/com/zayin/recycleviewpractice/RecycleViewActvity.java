package com.zayin.recycleviewpractice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create by zayin on 2016/09/23
 * TIME 11:19
 */

public class RecycleViewActvity extends Activity {
    @BindView(R.id.rv_practice)
    RecyclerView rvPractice;
    private HomeAdapter mAdapter;
    private ArrayList<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    private void initView() {
        rvPractice.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
        rvPractice.setAdapter(mAdapter = new HomeAdapter());
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 101; i++) {
            mDatas.add("" + i);
        }
    }

    private class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

        @Override
        public HomeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(RecycleViewActvity.this).inflate(R.layout.item_recycle, parent, false));

            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(HomeAdapter.MyViewHolder holder, int position) {
            holder.tv.setText(mDatas.get(position));

        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }


        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.tv_id_num);
            }
        }
    }


    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, RecycleViewActvity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }
}
