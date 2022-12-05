package com.example.dictionaryappsql;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AuthorApp extends AppCompatActivity {
    //khai báo các đối tượng
    ListView lv;
    Button btnquaylai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //chèn hình ảnh vào thanh ActionBar
        setContentView(R.layout.activity_author_app);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_d);
        setContentView(R.layout.activity_author_app);

        //setContentView(R.layout.activity_author_app);
       //Khai báo và gán các đối tượng dc lấy từ đối tượng xây dựng trong layout
        lv=(ListView) findViewById(R.id.lv);
        btnquaylai=(Button) findViewById(R.id.btnquaylai);
        //lv=(ListView) findViewById(R.id.lv);
        //Dialog listview sinh vien
        //xây dựng mảng dữ liệu arraylist để lưu các giá trị khi nhập vào hay khởi tạo cho nó một vài giá trị cụ thể.

        List<String> data = new ArrayList<String>();
        //phương thức data.add() dung để add giá trị dữ liệu trực tiếp mà ta khởi tạo cho nó vào mảng thông qua biến data đã được khởi
        //tạo bên trên
        data.add("Tống Bá Quang Anh - 19103100162");
        data.add("Hà Đăng Huy - 19103100085");
        data.add("Đinh Quang Hưng - 19103100082");
        data.add("Bùi Đức Hiếu - 19103100218");
        // khai báo và khởi tạo mảng dữ liệu arrayadapter  để lưu trữ, quản lý các đối tượng các phẩn tử có kiểu dữ liệu khác nhau đồng thòi gán nó cho lítview
        //để hiển thị các phần từ được lưu trũ từ arraydapter vào từng item trong listview bằng việc lấy dữ liệu từ thằng data
        final ArrayAdapter adapter = new ArrayAdapter(AuthorApp.this,android.R.layout.simple_expandable_list_item_1,data);
        lv.setAdapter(adapter);
        btnquaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //khởi tạo các thuộc tính dùng để xây dựng dialog
                AlertDialog.Builder a= new AlertDialog.Builder(AuthorApp.this);
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
                        Intent intent=new Intent(AuthorApp.this,MainActivity.class);
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