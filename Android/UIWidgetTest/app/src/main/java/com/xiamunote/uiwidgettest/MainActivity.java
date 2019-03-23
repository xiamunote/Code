package com.xiamunote.uiwidgettest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        editText = findViewById(R.id.edit_text);
        imageView = findViewById(R.id.image_view);
        button.setOnClickListener(this);
//        button.setOnClickListener(new View.OnClickListener() {
//        //匿名类实现方式
//            @Override
//            public void onClick(View v) {
//                    //此处添加逻辑
//            }
//        });

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                //此处添加逻辑
//                imageView.setImageResource(R.drawable.img_2);

//                String inputText = editText.getText().toString();
//                Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("内容不能为空！");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();


                break;
            default:
                break;
        }
    }

}
