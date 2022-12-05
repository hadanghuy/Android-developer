package com.example.dictionaryappsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseAdapter {

    // Khai báo một tham chiếu đối tượng DatabaseHelper
    DatabaseHelper helper;
    // Khai báo một tham chiếu đối tượng SQLiteDatabase.
    SQLiteDatabase db;
    // Lớp SQLiteDatabase có các phương thức để tạo, xóa, thực thi các lệnh SQL và thực hiện các cơ sở dữ liệu phổ biến khác
    // nhiệm vụ quản lý.
    // Định nghĩa đối tượng ArrayList of Term.
    ArrayList<Term> termsList = new ArrayList<Term>();
    // Term = Thuật ngữ là gì?
    // Tạo một lớp Thuật ngữ <Term> để chứa và tạo mô hình thông tin và làm cho nó dễ triển khai hơn.
    // Xác định hàm tạo cho DatabaseAdapter

    // Lệnh truy vấn Insert, Update, Delete
    // Khởi tạo trình trợ giúp
    public DatabaseAdapter(Context context) {
        helper = new DatabaseHelper(context);
        // Gọi phương thức getWlikeDatabase () trên trình trợ giúp.
        // Giúp cung cấp cho một đối tượng của SQLiteDatabase.
        // Lưu trữ nó trong db.
        db = helper.getWritableDatabase();
        // Bây giờ, đối tượng SQLiteDatabase này, db, sẽ đại diện cho cơ sở dữ liệu đang có và sẽ sử dụng đối tượng đó
        // để thực hiện các truy vấn khác nhau mà ta muốn thực hiện,
        // ví dụ: Insert <chèn>, Update <cập nhật> hoặc Delete <xóa> khỏi cơ sở dữ liệu.
    }

    // Định nghĩa một phương thức để đóng cơ sở dữ liệu
    public void close() {
        helper.close();
    }

    // Tiếp theo, xác định một phương thức trả về ArrayList của các đối tượng Term cụ thể
    // trong đó thuật ngữ bắt đầu bằng tham số String in.
    public ArrayList<Term> getSomeTerms(String termStarsWith) {
        // Gọi phương thức query () trên db và lưu trữ con trỏ trả về.
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, new String[]{DatabaseHelper.KEY_ID,
        DatabaseHelper.KEY_TERM, DatabaseHelper.KEY_FULL_FORM}, DatabaseHelper.KEY_TERM +
                " like '" + termStarsWith + "%'", null, null, null, null);

        // Ở đây,% là một ký tự đại diện cho bit 0 hoặc bất kỳ số ký tự nào. Vì vậy, có thể có bất kỳ số lượng ký tự nào
        // sau “A” hoặc “B” hoặc “S”, v.v.
        // Câu lệnh sql đơn giản cho điều này có thể là:
        // SELECT * FROM ct WHERE điều khoản LIKE 'A%';
        // Sử dụng vòng lặp while để duyệt qua cơ sở dữ liệu và điền các đối tượng ArrayList of Term
        // Hiển thị danh sách các từ ra
        while (cursor.moveToNext()) {
            // Lấy chỉ mục hoặc vị trí cột cơ sở dữ liệu bằng cách chuyển tên cột
            int index1 = cursor.getColumnIndex(DatabaseHelper.KEY_ID);
            // Bây giờ, lấy giá trị của id cho ô đó
            long id = cursor.getInt(index1);
            // Tương tự để lấy giá trị từ hai cột khác
            int index2 = cursor.getColumnIndex(DatabaseHelper.KEY_TERM);
            String name = cursor.getString(index2);
            int index3 = cursor.getColumnIndex(DatabaseHelper.KEY_FULL_FORM);
            String fullForm = cursor.getString(index3);
            // Tạo một đối tượng Term từ các giá trị cơ sở dữ liệu
            Term term = new Term(id, name, fullForm);
            // Thêm đối tượng Term vào termsList
            termsList.add(term);
        }
        // Trả về termsList
        return termsList;
    }

    // Lệnh Update DB: cập nhật/sửa đổi dữ liệu:
    // UPDATE ct SET full_form = "New Value" WHERE _id = 2
    public int updateTermFullForm(long id, String fullFormEdited) {
        // Để cập nhật cơ sở dữ liệu, cần tạo một đối tượng của lớp được gọi là ContentValues hoạt động giống như một bản đồ, bên trong đó có thể
        // đặt các cặp khóa-giá trị.
        // Ở đây, tên của khóa đc cung cấp ở đây là tên của cột trong bảng db
        // và giá trị muốn đặt bên trong cột sẽ nằm trong tham số thứ hai.
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.KEY_FULL_FORM, fullFormEdited);
        // Bạn cần tạo mảng whereArgs []. whereArgs [] chỉ là một mảng chứa các giá trị được thay thế bên trong
        // dấu chấm hỏi (?) trong số whereClause at run-time, khi bạn đang thực hiện truy vấn.
        // whereArgs [] sẽ chứa các giá trị đối với bạn muốn so sánh.
        String[] whereArgs = {""+id};
        // Gọi phương thức Update() trên db
        return db.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.KEY_ID + "=?", whereArgs);
        // update () trả về số hàng bị ảnh hưởng dưới dạng số nguyên.
        // Ví dụ truy vấn:
        // UPDATE ct SET full_form = "New Value" WHERE _id = 2
    }

    // Lệnh DELETE DB: xoá dữ liệu
    // DELETE FROM ct WHERE _id=id
    public int deleteData(long id) {
        // Xác định mảng String whereArgs
        String[] whereArgs = {""+id};
        // Gọi phương thức delete () trên db
        return db.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.KEY_ID + "=?", whereArgs);
        // delete () trả về số hàng bị xóa dưới dạng số nguyên.
    }

    // Lệnh INSERT DB: thêm dữ liệu
    // INSERT
    public long insertTerm(String edtNew, String edtNewFullForm) {
        // Xác định một đối tượng ContentValues mới
        ContentValues contentValues = new ContentValues();
        // Thêm Term và fullForm vào đó
        contentValues.put(DatabaseHelper.KEY_TERM, edtNew);
        contentValues.put(DatabaseHelper.KEY_FULL_FORM, edtNewFullForm);
        // Gọi phương thức Insert () trên đối tượng db và trả về
        return db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }

//    Connect DB SQLite

    // Để quản lý tất cả các hoạt động liên quan đến cơ sở dữ liệu, một lớp trợ giúp đã được cung cấp bởi Android
    // và nó được gọi là SQLiteOpenHelper.
    // Nó quản lý việc mở cơ sở dữ liệu nếu nó tồn tại, tạo nó nếu nó không tồn tại và nâng cấp nó khi cần thiết.
    // Vì vậy, bên trong DatabaseAdapter, ta sẽ tạo một lớp bên trong trình mở rộng SQLiteOpenHelper.

    private static class DatabaseHelper extends SQLiteOpenHelper {

        // Xác định một số biến String để lưu trữ thông tin liên quan đến cơ sở dữ liệu
        private static final String DATABASE_NAME = "CTDB";
        // Tên cơ sở dữ liệu phải là duy nhất trong một ứng dụng, không phải trên tất cả các ứng dụng.
        private static final String TABLE_NAME = "ct";
        // Khi bạn thay đổi cấu trúc của cơ sở dữ liệu, hãy thay đổi số phiên bản từ 1 thành 2
        private static final int DATABASE_VERSION = 1;
        private static final String KEY_ID = "_id";
        private static final String KEY_TERM = "terms";
        private static final String KEY_FULL_FORM = "full_form";
        private Context context;

        // Định nghĩa hàm tạo
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            // Lưu trữ context nhận được từ phương thức khởi tạo vào biến context của lớp này
            this.context = context;
        }


        // Vì không tạo hoặc nâng cấp cơ sở dữ liệu và đang sử dụng tệp cơ sở dữ liệu được tạo trước
        // được sao chép vào đúng vị trí, nên không cần viết bất kỳ mã nào bên trong onCreate () hoặc onUpgrade ().
        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
