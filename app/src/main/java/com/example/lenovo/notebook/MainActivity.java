package com.example.lenovo.notebook;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lenovo.notebook.Base.BaseActivity;
import com.example.lenovo.notebook.global.NotebookApp;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        //SharedPreferences.Editor editor = getSharedPreferences("password",MODE_PRIVATE).edit();
        SharedPreferences sp = getSharedPreferences("password",MODE_PRIVATE);

        if(!sp.getBoolean("isCreated",false)){
            Intent intent = new Intent(MainActivity.this,IntroduceActivity.class);
            startActivity(intent);

        }else{
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }

        Button write = (Button) findViewById(R.id.write);
        Button read = (Button) findViewById(R.id.read);
        Button reset = (Button)findViewById(R.id.reset);
        Button set_color = (Button)findViewById(R.id.set_color);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,WriteActivity.class);
                intent.putExtra("isNew",true);
                startActivity(intent);
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReadActivity.class);
                startActivity(intent);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,ResetActivity.class);
                startActivity(intent);
            }
        });
        set_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("选择一种颜色");
                String[] colors = {"蓝色","绿色"};
                builder.setItems(colors,new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                            {
//                                Layout layout = (Layout)findViewById(R.id.read);
                            }

                        }
                    }
                });
            }
        });
    }

}