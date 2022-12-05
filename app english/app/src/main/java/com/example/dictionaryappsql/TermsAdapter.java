package com.example.dictionaryappsql;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

// Tạo Adapter = bộ điều khiển, bằng cách mở rộng RecyclerView.Adapter. ViewHolder tùy chỉnh này
// sẽ cấp quyền truy cập vào các chế độ xem
public class TermsAdapter extends RecyclerView.Adapter<TermsAdapter.ViewHolder> {
    // Khai báo các biến để lưu trữ dữ liệu từ hàm tạo
    Context context;
    ArrayList<Term> termsList;
    RecyclerView rvTerms;
    // Khởi tạo OnClickListener tùy chỉnh
    final View.OnClickListener onClickListener = new MyOnClickListener();
    // Tạo một lớp bên trong và cung cấp các tham chiếu đến tất cả các khung nhìn
    // cho mỗi mục dữ liệu. Điều này đặc biệt hữu ích để lưu vào bộ nhớ đệm các chế độ xem
    // trong bố cục mục để truy cập nhanh.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Khai báo các biến thành viên cho tất cả các chế độ xem trong một hàng
        TextView term;
        TextView full_form;
        // Tạo hàm tạo theo cách chấp nhận toàn bộ hàng và tìm kiếm phân cấp chế độ xem
        // để tìm từng lượt xem phụ.
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            term = itemView.findViewById(R.id.tvTerm);
            full_form = itemView.findViewById(R.id.tvFullForm);
        }
    }

    // Cung cấp một hàm tạo phù hợp cho termsAdapter
    public TermsAdapter(Context context, ArrayList<Term> termsList, RecyclerView rvTerms) {
        this.context = context;
        this.termsList = termsList;
        this.rvTerms = rvTerms;
    }

    // Trong phương thức onCreateViewHolder (), tạo các khung nhìn mới sẽ được gọi
    // bởi Layout Manager

    @NonNull
    @Override
    public TermsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Tạo một đối tượng LayoutInflater
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item, parent, false);
        // RecyclerView không cho phép đặt OnItemClickListener như ListView,
        // vì vậy phải tạo ra cách riêng để thực hiện nó.
        view.setOnClickListener(onClickListener);
        // Tạo và trả về một holder instance mới
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Trong phương thức onBindViewHolder (), thay thế nội dung của một dạng xem và đây sẽ là
    // được gọi bởi Layout Manager
    @Override
    public void onBindViewHolder(@NonNull TermsAdapter.ViewHolder holder, int position) {
        // Tại đây, lấy phần tử từ tập dữ liệu của tại vị trí này và thay thế
        // nội dung của khung nhìn với phần tử đó
        Term term = termsList.get(position);
        holder.term.setText(term.getTerm());
        holder.full_form.setText(term.getFull_form());
    }

    // Trong phương thức getItemCount (), trả về kích thước tập dữ liệu của mình
    @Override
    public int getItemCount() {
        return termsList.size();
    }

    // Xác định OnClickListener tùy chỉnh
    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // Lấy vị trí bố cục con từ đối tượng RecyclerView bằng cách chuyển chế độ xem con
            int itemPosition = rvTerms.getChildLayoutPosition(v);
            // Lấy đối tượng Term tương ứng từ termsList bằng cách chuyển itemPosition
            Term termSelected = termsList.get(itemPosition);
            // Tạo Intent để chuyển đến Activity của TermDetails với termSelected và itemPosition bổ sung
            Intent intent = new Intent(context, TermDetail.class);
            // Bắt đầu Activity với Intent
            intent.putExtra("termSelected", termSelected);
            intent.putExtra("itemPosition", itemPosition);
            context.startActivity(intent);
            // Tiếp theo, tạo lớp TermDetail hay thực thi các yêu cầu được thực hiện trong intent
        }
    }
}
