package com.zayin.recycleviewpractice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Create by zayin on 2016/09/23
 * TIME 11:19
 */

public class RecycleViewActvity extends Activity {
    @BindView(R.id.rv_practice)
    RecyclerView rvPractice;
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.btn_remove)
    Button btnRemove;
    private HomeAdapter mAdapter;
    private ArrayList<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        ButterKnife.bind(this);

        initData();
        initView();
    }

    private void initView() {
        rvPractice.setLayoutManager(new LinearLayoutManager(this));
//        rvPractice.addItemDecoration(new DividerGridItemDecoration(this));
        rvPractice.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new HomeAdapter(this, mDatas);
        rvPractice.setAdapter(mAdapter);

        /**方法之二：通过adapter中自己提供回调*/
       /* mAdapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecycleViewActvity.this, position + "  clicked", Toast.LENGTH_LONG).show();
            }
        });
*/

        /**方法之一：条目手势监听*/
       /* rvPractice.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });*/
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 101; i++) {
            mDatas.add("" + i);
        }
    }


    @OnClick({R.id.btn_add, R.id.btn_remove})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                mAdapter.addData(1);

                break;
            case R.id.btn_remove:
                mAdapter.removeData(1);

                break;
        }
    }

    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, RecycleViewActvity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }

}
