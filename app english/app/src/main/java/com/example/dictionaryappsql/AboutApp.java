package com.example.dictionaryappsql;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AboutApp extends AppCompatActivity {
    //khai báo các biến
    Button btnquaylai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //xây dưng và gán icon cho thanh actionbar
        setContentView(R.layout.activity_about_app);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_d);
        setContentView(R.layout.activity_about_app);

        setContentView(R.layout.activity_about_app);
        /// gán cái biến đối tượng với các thuộc tính được lấy tù layout
        btnquaylai=(Button) findViewById(R.id.btnquaylai);
        btnquaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // khỏi tạo đối tượng alerDialog
                AlertDialog.Builder a= new AlertDialog.Builder(AboutApp.this);
                //sử dụng phương thức settitle xây dựng chuỗi cần gọi
                a.setTitle("Ban có muốn quay lại không?");
                //seticon cho dialog
                a.setIcon(R.mipmap.ic_launcher);
                //setpositiveButton thực hiện kết quả trả về là đúng của dialog
                a.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // khởi tạo đối tương với intent và thực hiên gọi đến màn hình chứa lớp thực hiện
                        Intent intent=new Intent(AboutApp.this,MainActivity.class);
                        startActivity(intent);//phương thưc thức thi các yêu cầu của intent khởi tạo
                    }
                });
                //thực hiện kết quả trả về là sai của dialog
                a.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();// phương thức thực hiện đóng dialog khi yêu cầu ko thực thi
                    }
                });
                a.show();// thực thi và hiển thị các yêu cầu xây dựn bên trên của Dialog
            }
        });
    }
}