package com.example.dictionaryappsql;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelpApp extends AppCompatActivity {
    //khai báo các đối tượng
    Button btnquaylai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //chèn hình ảnh vào thanh ActionBar
        setContentView(R.layout.activity_help_app);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_d);
        setContentView(R.layout.activity_help_app);

       // setContentView(R.layout.activity_help_app);
        //setContentView(R.layout.activity_author_app);
        //Khai báo và gán các đối tượng dc lấy từ đối tượng xây dựng trong layout
        btnquaylai= (Button) findViewById(R.id.btnquaylai);
        btnquaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // khỏi tạo đối tượng alerDialog
                AlertDialog.Builder a= new AlertDialog.Builder(HelpApp.this);
                //dùng phương thức settitle dùng để hiển nội dung muốn thực hiện.
                a.setTitle("Ban có muốn quay lại không?");
                //dùng phương thức seticon dùng để gắn icon cho hiển thị của đối tượng dialog
                a.setIcon(R.mipmap.ic_launcher);
                //dùng phương thức setpositivebutton dùng để thực thi đối tượng khi kết quá được chon
                //là đúng
                a.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Khỏi tạo intent dùng để thực thi các đối tượng và gọi đến lớp chứ cái đối tương đó
                        Intent intent=new Intent(HelpApp.this,MainActivity.class);
                        //Thực thi các yêu cầu của intent
                        startActivity(intent);
                    }
                });
                //dùng phương thức setNegativeButton dùng để thi đối tượng của dialog khi đối tượng đó khoonng được thực hiện
                a.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //thực thi kết quả , và thoát hiển thị dialog
                        dialogInterface.cancel();
                    }
                });
                a.show();//hiển thị và thực hiên yêu cầu trong Dialog.
            }
        });
    }


}