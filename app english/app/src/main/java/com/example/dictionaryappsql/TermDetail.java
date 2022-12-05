package com.example.dictionaryappsql;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TermDetail extends AppCompatActivity {
    // Khai báo các tham chiếu đối tượng View
    TextView tvTermDetails, tvFullFormDetails;
    EditText edtFullFormdetails;
    ImageButton ibEdit;
    // Khai báo một tham chiếu đối tượng Term để lưu trữ Term từ Intent
    Term termSelected;
    // Khai báo một số nguyên để lưu trữ itemPosition từ Intent
    int itemPosition;
    // Định nghĩa đánh dấu để lưu trữ trạng thái chỉnh sửa.
    boolean editState = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.term_detail);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_d);
        setContentView(R.layout.term_detail);

        setContentView(R.layout.term_detail);
        // Lấy thông tin từ Intent
        termSelected = (Term) getIntent().getSerializableExtra("termSelected");
        itemPosition = getIntent().getIntExtra("itemPosition", 1);
        // Nhận các điều khiển cho Views
        tvTermDetails = findViewById(R.id.tvTermDetails);
        tvFullFormDetails = findViewById(R.id.tvFullFormDetails);
        edtFullFormdetails = findViewById(R.id.edtFullFormDetails);
        ibEdit = findViewById(R.id.ibEdit);
        // Đặt các giá trị của Views với các giá trị nhận được từ Intent
        tvTermDetails.setText(termSelected.getTerm());
        tvFullFormDetails.setText(termSelected.getFull_form());
        edtFullFormdetails.setText(termSelected.getFull_form());
    }

    public void edit (View view) {
        if (editState == false) {
            // Nếu chỉnh sửa ImageButton được nhấp và editState là false
            // Thay đổi editState thành true.
            editState = true;
            // Ẩn TextView tvFullFormDetails
            tvFullFormDetails.setVisibility(View.GONE);
            // Và hiển thị EditText etFullFormDetails vì chúng ta sẽ chỉnh sửa
            edtFullFormdetails.setVisibility(View.VISIBLE);
            // Thay đổi hình nền của ImageButton bằng một hình ảnh khác: save.
            ibEdit.setImageResource(R.drawable.save);
        } else {
            // Nếu chỉnh sửa ImageButton được nhấp và editState là true, nghĩa là người dùng đã chỉnh sửa xong,
            // thay đổi editState thành false.
            editState = false;
            // Hiển thị TextView cho FullForm
            tvFullFormDetails.setVisibility(View.VISIBLE);
            // Và ẩn EditText cho FullForm
            edtFullFormdetails.setVisibility(View.GONE);
            // Thay đổi hình nền của ImageButton bằng hình ảnh gốc: edit.
            ibEdit.setImageResource(R.drawable.edit);
            // Lấy văn bản từ EditText cho FullForm
            String fullFormEdited = edtFullFormdetails.getText().toString();
            // Tiếp theo, vào ShowTerm và thay đổi đối tượng DatabaseAdapter thành static.
            // Gọi phương thức updateTermFullForm () trên databaseAdapter và chuyển Id và fullFormEdited làm tham số.
            ShowTerm.databaseAdapter.updateTermFullForm(termSelected.getId(), fullFormEdited);
            // Đặt TextView cho FullForm với String nhận được từ EditText cho FullForm
            tvFullFormDetails.setText(fullFormEdited);
            // Tạo đối tượng Term mới với edited FullForm
            Term termItem = new Term(termSelected.getId(), termSelected.getTerm(), fullFormEdited);
            // Đi tới ShowTerm và đặt RecyclerView và ArrayList tĩnh để có thể truy cập chúng từ đây.
            // Tiếp theo, cập nhật ArrayList of terms với đối tượng Term mới được tạo ở cùng vị trí
            ShowTerm.termsList.set(itemPosition, termItem);
            // Thông báo cho RecyclerView Adapter về sự thay đổi dữ liệu
            ShowTerm.rvTerms.getAdapter().notifyDataSetChanged(); // UPDATE db
        }
    }

    public void delete(View view) {
        // Sử dụng Android AlertDialog để hỏi người dùng về lựa chọn của họ để tiếp tục hoặc ngừng thao tác xóa.
        // AlertDialog có thể được sử dụng để hiển thị thông báo hộp thoại với các nút OK-Cancel hoặc Yes-No.
        // Để tạo một hộp thoại cảnh báo, cần tạo một đối tượng AlertDialog.Builder mà một lớp bên trong của AlertDialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Đặt tiêu đề xuất hiện trong hộp thoại
        builder.setTitle("Delete Entry");
        // Đặt thông báo được hiển thị trong hộp thoại cảnh báo
        builder.setMessage("Are you sure you want to delete " + termSelected.getTerm() + " from Database?");
        // Có thể đặt thuộc tính mà hộp thoại có thể bị hủy hoặc không
        builder.setCancelable(true);
        // Đặt các nút tích cực (có) hoặc tiêu cực (không) bằng cách sử dụng đối tượng của đối tượng AlertDialog.Builder: builder.
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Ở đây gọi một phương thức trong DatabaseAdapter và chuyển Id để xóa
                ShowTerm.databaseAdapter.deleteData(termSelected.getId());
                // Xóa đối tượng Term hiện tại khỏi ArrayList: termsList
                ShowTerm.termsList.remove(itemPosition);
                // Thông báo cho RecyclerView Adapter về sự thay đổi dữ liệu
                ShowTerm.rvTerms.getAdapter().notifyDataSetChanged();
                // Kết thúc Activity hiện tại
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            // Chỉ cần đóng hộp thoại nếu người dùng nhấn nút No.
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        // Sau khi tạo và thiết lập trình tạo hộp thoại, bạn cần tạo hộp thoại cảnh báo bằng cách gọi phương thức create ()
        // trên đối tượng người xây dựng.
        AlertDialog alertDialog = builder.create();
        // Hiển thị hộp thoại cảnh báo trên màn hình
        alertDialog.show();
    }
}
