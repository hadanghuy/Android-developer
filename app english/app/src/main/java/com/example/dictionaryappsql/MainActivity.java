package com.example.dictionaryappsql;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String shareApp = "Download Dictionary APP  now and know about all the important Computer Term"
            + " and their Full Form: \n"
            + "https://play.google.com/store/apps/details?id=com.sandipbhattacharya.computertermsdictionary";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setIcon(R.mipmap.ic_launcher_d);

        setContentView(R.layout.activity_main);

        // Tạo DB - Get DB
        // Tạo một lớp chứa các phương thức tĩnh để sao chép tệp cơ sở dữ liệu
        // Từ thư mục nội dung vào thư mục: data / data / package-name / databases, từ đó ứng dụng có thể truy cập.
        // Đặt tên nó là PreCreateDB.
        // Từ MainActivity, gọi phương thức copyDB của PreCreateDB và truyền "this" cho Context
        PreCreateDB.copyDB(this);
    }

    public void show(View view) {
        // Thiết lập một văn bản với mọi nút. Văn bản này chỉ chứa một bảng chữ cái.
        // Lấy văn bản của nút Button đã nhấp và lưu trữ trong một biến String
        String termStarsWith = ((Button) view).getText().toString().trim();
        // Tạo Intent để chuyển đến một Activity khác, nơi bạn có thể hiển thị tất cả các Term bắt đầu bằng termStartsWith
        Intent intent = new Intent(this, ShowTerm.class);
        // Đặt termStartsWith với đối tượng Intent là Extra
        intent.putExtra("termStarsWith", termStarsWith);
        // Bắt đầu Activity với Intent
        startActivity(intent);
        // Tạo lớp ShowTerm --> Hiển thị các Term
    }

    public void reset(View view) {
        //sử dụng Android AlertDialog để hỏi người dùng về lựa chọn của họ để tiếp tục hoặc ngừng hoạt động đặt lại.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Resetting will delete all your personal data. Proceed?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            // Gọi một phương thức và chuyển MainActivity.this làm ngữ cảnh,
            // để thay thế tệp cơ sở dữ liệu từ thư mục tài sản sang thư mục cơ sở dữ liệu.
            PreCreateDB.resetDB(MainActivity.this);
        });
        builder.setNegativeButton("No", (dialog, which) -> dialog.cancel());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void addNew(View view) {
        // Tạo biến Intent để chuyển đến Activity addNew
        Intent intent = new Intent(this, AddNew.class);
        startActivity(intent);
        // tạo addNew : Thêm từ
    }

    public void rate(View view) {
        // Tạo Intent mở một URL trong Google Play
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
        // Khi định cấu hình intent này, ta chuyển "com.android.vending" vào Intent.setPackage () để người dùng xem chi tiết ứng dụng
        // trong ứng dụng Cửa hàng Google Play thay vì trình chọn. Đảm bảo rằng trình mô phỏng của đã được cài đặt sẵn ứng dụng Cửa hàng Play.
        intent.setPackage("com.android.vending");
        try {
            // Khởi động Activity
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Couldn't launch Play Store", Toast.LENGTH_SHORT).show();
        }
    }

    public void shareApp(View view) {
        // Tạo Intent gửi / share
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        // Đặt kiểu chia sẻ
        sendIntent.setType("text/plain");
        // Chuyển nội dung chia sẻ bằng phương thức putExtra () của Intent
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Share Dictionary App");
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareApp);
        // Tiếp theo, hướng hệ thống Android cho phép người dùng chọn phương tiện chia sẻ của họ
        startActivity(Intent.createChooser(sendIntent, "Share using..."));
        // Điều này sẽ chuyển sendIntent cùng với tiêu đề được hiển thị ở đầu trình chọn.
        // Khi người dùng chọn một ứng dụng từ danh sách, nội dung chia sẻ sẽ được chuyển đến ứng dụng đó,
        // nơi họ có thể chỉnh sửa nội dung trước khi gửi nếu họ muốn.
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menutrip, menu);
        MenuItem menuItem = menu.findItem(R.id.about_app);
        MenuItem menuItem1 = menu.findItem(R.id.version_app);
        MenuItem menuItem2 = menu.findItem(R.id.help_app);
        MenuItem menuItem3 = menu.findItem(R.id.author_app);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.about_app:
                //  Toast.makeText(this, "Bạn vừa sửa thành công" , Toast.LENGTH_SHORT).show();
                about();
                break;
            case R.id.help_app:
                //Toast.makeText(this,"Bạn vừa chọn hướng dẫn",Toast.LENGTH_SHORT).show();
                help();
                break;
            case R.id.author_app:
                // Toast.makeText(this,"Bạn vua chon phần tác giả",Toast.LENGTH_SHORT).show();
                author();
                break;
            case R.id.version_app:
                //Toast.makeText(this,"Version 1.0.0",Toast.LENGTH_SHORT).show();
                version();
                break;


            default:
        }
        return super.onOptionsItemSelected(item);
    }


    private void version() {
        // Toast.makeText(this,"Version 1.0.0",Toast.LENGTH_SHORT).show();
        AlertDialog.Builder a= new AlertDialog.Builder(MainActivity.this);
        a.setTitle("Phiên bản Version 1.0.0");
        a.setIcon(R.mipmap.ic_launcher);

        a.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        a.show();
    }

    private void author() {
        Intent intent=new Intent(MainActivity.this,AuthorApp.class);
        startActivity(intent);

    }

    private void help() {
        Intent intent=new Intent(MainActivity.this,HelpApp.class);
        startActivity(intent);
    }

    private void about() {

        Intent i=new Intent(MainActivity.this, AboutApp.class);

        startActivity(i);
    }
}