package com.example.dictionaryappsql;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PreCreateDB {
    static String desPath = "";
    static String desPathWithFileName = "";

    // Cho phép xác định phương thức copyDB ()
    public static void copyDB(Context context) {
        // Gỡ lỗi hai biến String chứa đường dẫn lên đến thư mục "database" và tệp "CTDB" tương ứng
        desPath = "/data/data/" + context.getPackageName() + "/databases";
        desPathWithFileName = desPath + "/CTDB";

        // Tạo hai đối tượng File từ các chuỗi đó
        File fPath = new File(desPath);
        File fPathWithName = new File(desPathWithFileName);
        // Bây giờ, câu hỏi đặt ra là tại sao chúng ta lại tạo ra hai đối tượng File riêng biệt?
        // Đó là vì trong một số thiết bị, thư mục cơ sở dữ liệu sẽ được tự động tạo bởi hệ thống Android.
        // Trong một số thiết bị khác, nó sẽ không ở đó theo mặc định.
        // Vì vậy, chúng ta cần kiểm tra xem nó có hiện diện trong thiết bị hay không.
        if(!fPath.exists()){
            // Nếu đúng, sẽ tạo thư mục cơ sở dữ liệu
            fPath.mkdirs();
            // Và sau đó sao chép tệp Cơ sở dữ liệu CTDB từ thư mục tài sản sang thư mục cơ sở dữ liệu.
            // Xác định một phương thức có tên rawCopy nhận một InputStream và một OutputStream.
            // Phương thức này sẽ sao chép tệp.
            try {
                rawCopy(context.getAssets().open("CTDB"), new FileOutputStream(desPathWithFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            if (!fPathWithName.exists()) {
                try {
                    rawCopy(context.getAssets().open("CTDB"), new FileOutputStream(desPathWithFileName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void rawCopy(InputStream ctdb, FileOutputStream fileOutputStream) throws IOException {
        // Để sao chép 1k byte cùng một lúc, ta tạo một mảng byte có kích thước 1024
        byte[] buffer = new byte[1024];
        // Khai báo một biến số nguyên để lưu tổng số byte được đọc từ bộ đệm.
        int length;
        // Nếu gọi phương thức read () trên đối tượng inputStream và truyền bộ đệm làm tham số, nó sẽ đọc 1024 byte tại một thời điểm.
        // Nó trả về -1 nếu không còn dữ liệu vì đã đến cuối luồng.
        // Sử dụng thông tin này, ta sử dụng vòng lặp while để đọc từ inputStream và ghi vào outputStream.
        // Thao tác này sao chép tệp cơ sở dữ liệu CTDB từ thư mục tài sản sang thư mục data / data / [package-name] / databases.
        while ((length = ctdb.read(buffer)) > 0) {
            fileOutputStream.write(buffer, 0 , length);
        }
        // Đóng các luồng đầu vào và đầu ra khi đã hoàn tất
        ctdb.close();
        fileOutputStream.close();
    }

    public static void resetDB(Context context) {
        // Gọi rawCopy () bên trong try
        try {
            rawCopy(context.getAssets().open("CTDB"), new FileOutputStream(desPathWithFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
