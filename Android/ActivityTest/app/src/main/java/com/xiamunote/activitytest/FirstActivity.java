package com.xiamunote.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        //通过findViewById()方法获取布局文件中定义的元素，传入R.id.button_1，获取button实例
        //通过findViewById()方法返回的是一个View对象，需要向下转型成Button对象
        //id值 button_1 是在first_layout.xml中通过android:id指定的

        button1.setOnClickListener(new View.OnClickListener() {
        //注册监听器
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this,
                        "你点击了button1",Toast.LENGTH_SHORT).show();
                //通过静态方法makeText()方法创建一个Toast对象，然后调用show()方法显示
                //makeText（）方法需要传入三个参数，第一个是Contex,也就是Tocast要求的上下文，
                // 活动本身就是一个Context类型的对象，这里直接传入FirrstActivity.this
                //第二个参数是Tocast显示的文本
                //第三个参数显Tocast显示的时长，短Tocast.LENGTH_SHORT,长Tocast.LENGTH_LONG

//                //显示Intent
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                //构造函数接收两个参数Context要求提供一个启动活动的上下文
//                //第二个参数Class指定想要启动的目标活动
//
//                startActivity(intent);
                //专门用于启动活动，它接受一个Intent参数

//                //隐式Intent，要<action>和<category>同时匹配才能响应Intent
//                Intent intent = new Intent("com.xiamunote.activitytest.ACTION_START");
//                //构造函数，直接将action字符串传入，表明想要启动com.xiamunote.activitytest.ACTION_START这个action的活动
//                intent.addCategory("com.xiamunote.activitytest.MY_CATEGORY");
//                //调用addCategory()来将com.xiamunote.activitytest.MY_CATEGORY这个category添加进去
//                startActivity(intent);

//                //使用隐式Intent还可以启动其他程序的活动，实现Android多个程序间功能共享
//                //使用隐式Intent调用系统浏览器打开百度
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                //指定intentd的指定了action是Intent.ACTIONVIEW,这是一个Android系统内置的动作，
//                // 其常量值为android.intent.action.VIEW
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                //然后通过Uri.pase()方法，将一个网址字符串解析成一个Uri对象，
//                //再调用Intent的setData()方法将这个Uri对象传递进去
//                startActivity(intent);

//                //使用隐式Intent调用系统拨号界面并指定号码10000
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                //指定Intent的action是Intent.ACTION_DIAL，这是系统的内置动作
//                intent.setData(Uri.parse("tel:10000"));
//                //在Data部分指定协议是tel，号码是10000
//                startActivity(intent);

//                //使用显示Intent启动SecondActivity，并通过putExtra()方法传递一个字符串
//                String data = "Hello SecondActivity";
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                intent.putExtra("extra_data",data);
//                startActivity(intent);

                //使用startActivityForResult()方法也是启动活动
                //启动的活动销毁之后会回调上一个活动的 onActivityResult ( )方法，
                // 因此我们需要在重写这个方法来得到返回的数据
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
                //startActivityForResult()方法接收两个参数，第一个参数是Intent
                //第二个参数是请求码，用于在之后的回调中判断数据的来源,请求码只要是一个唯一值就可以了，这里传入了1

            }
        });
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        //通过getMenuInflater()方法能够得到MenuInflater对象，再调用inflate()方法给当前活动创建菜单
        //inflate()方法接受两个参数，第一个参数用于指定通过那个资源文件创建菜单，这里传入R.menu.main
        //第二个参数同于指定我们的菜单项将添加到哪一个Menu对象中，这里直接使用onCreatOptionsMenu()方法中传入的menu参数
        //
        return true;
        //返回true，允许创建的菜单显示出来；返回false，创建的菜单无法显示
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "你点击了Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "你点击了Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        //onActivityResult ( )方法带有三个参数，
        // 第一个参数 requestCode 是我们在启动活动时传人的请求码
        //传人的请求码
        //第二个参数resultCode是我们在返回数据时传人的处理结果
        // 第三个参数data 是携带着返回数据的Intent
        switch (requestCode)
        //由于在一个活动中有可能调用startActivityForResult()方法去启动很多不同的活动，
        // 每一个活动返回的数据都会回调到 onActivityResult ( ) 这个方法
        // 因此我们首先要做的就是通过检查 requestCode 的值来判断数据来源
        {
            case 1:
                if(resultCode == RESULT_OK)
                //通过 resultCode 的值来判断处理结果是否成功
                {
                    String returnedData = data.getStringExtra("data_return");
//                    Log.d("FirstActivity",returnedData);
                    Toast.makeText(this, returnedData, Toast.LENGTH_SHORT).show();
                    //从 data中取值并打印岀来，这样就完成了向上一个活动返回数据的工作
                }
                break;
            default:

        }
    }
}
