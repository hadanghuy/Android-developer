package com.example.dictionaryappsql;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddNew extends AppCompatActivity {
    // Khai báo các tham chiếu đối tượng View
    EditText edtNewTerm, edtNewTermFullForm;
    TextView tvAddResult;
    // Khai báo một tham chiếu đối tượng DatabaseAdapter, vì sẽ gọi một phương thức trong DatabaseAdapter
    DatabaseAdapter databaseAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Tạo logo ứng dụng
        setContentView(R.layout.add_new);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_d);
        setContentView(R.layout.add_new);

        setContentView(R.layout.add_new);
        // Khởi tạo cơ sở dữ liệu Adapter
        databaseAdapter = new DatabaseAdapter(this);
        // Nhận các xử lý cho các Views
        //thực hiên khai báo và gán các đói tượng được khởi tạo
        edtNewTerm = findViewById(R.id.edtNewTerm);
        edtNewTermFullForm = findViewById(R.id.edtNewTermFullForm);
        tvAddResult = findViewById(R.id.tvAddResult);
    }


    public void addNewTerm(View view) {
        // Nhận các giá trị của Term và FullForm từ EditTexts và lưu trữ trong Chuỗi
        String edtNew = edtNewTerm.getText().toString().trim();
        String edtNewFullForm = edtNewTermFullForm.getText().toString().trim();
        // Kiểm tra xem cả hai EditTexts đều không trống
        if (!edtNew.equals("") && !edtNewFullForm.equals("")) {
            // Nếu đúng, hãy gọi phương thức insertTerm () trong DatabaseAdapter và chuyển Term and FullForm làm tham số
            long rowInserted = databaseAdapter.insertTerm(edtNew, edtNewFullForm);
            // Định nghĩa insertTerm trong DatabaseAdapter
            // Nếu rowInserted không phải là -1, thì bản ghi đã được chèn thành công, nếu không thì đã xảy ra sự cố
            if (rowInserted != -1) {
                //Đã chèn thành công một thuật ngữ;
                tvAddResult.setText("One Term successfully inserted!!!");
            } else {
                //Chèn thông thành công thuật ngữ
                tvAddResult.setText("Something went wrong!!!");
            }
        } else {
            // Khi bất kỳ EditText nào trống, hiển thị thông báo lỗi trong TextView
            tvAddResult.setText("Fields can't be empty.");
        }
    }
}
