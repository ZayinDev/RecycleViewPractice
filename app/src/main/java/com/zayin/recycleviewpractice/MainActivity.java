package com.zayin.recycleviewpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_recycleview)
    Button btnRecycleview;
    @BindView(R.id.btn_infosys)
    Button btnInfosys;
    @BindView(R.id.btn_others)
    Button btnOthers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_recycleview, R.id.btn_infosys, R.id.btn_others})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_recycleview:
                RecycleViewActvity.actionStart(this,"data1","data2");
                break;
            case R.id.btn_infosys:
                break;
            case R.id.btn_others:
                break;
        }
    }
}
