package com.xiamunote.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent();
                inten.putExtra("data_return","Hello FirstActivity");
                //构建了一个 Intent 只不过这个 Intent 仅仅是用于传递数据
                setResult(RESULT_OK,inten);
                //调用了 setResult ( )方法。这个方法专门用于向上一个活动返回数据
                //setResult ( ) 方法接收两个参数，第一个参数用于向上一个活动返回处理结果，
                // 一般只使用 RESULT_OK 或 RESULT_CANCELED 这两个值
                //第二个参数则把带有数据的 Intent 传递回去
                finish();
            }
        });
    }

    @Override
    //如果用户在SecondActivity中并不是通过点击按钮，而是通过按下Back键回到FirstActivity,数据不返回
    //通过在SecondActivity中重写onBackPressed()方法来解决这个问题
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello FirstActivity");
        setResult(RESULT_OK,intent);
        finish();
    }
}
