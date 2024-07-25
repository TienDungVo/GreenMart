package sof304.testNG;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.duan1.dao.NhanVienDAO;
import com.duan1.entity.TaiKhoan;

public class NV_Select {
    private NhanVienDAO dao;

    @BeforeMethod
    public void setup() {
        dao = new NhanVienDAO();
    }

    @Test
    public void testSelect() {
        try {
            // Gọi phương thức select()
            List<TaiKhoan> list = dao.select();

      

            // Kiểm tra xem list có ít nhất một phần tử không
            if (list != null && list.size() != 0) {
                System.out.println("Danh sách không được trả về rỗng sau khi gọi select()");
            } else {
                System.out.println("Danh sách được trả về là rỗng sau khi gọi select()");
            }

            // (Optional) Hiển thị thông tin về các đối tượng trong danh sách
            for (TaiKhoan tk : list) {
                System.out.println(tk.getUserName());
            }
            

        } catch (Exception e) {
            // Nếu có bất kỳ ngoại lệ nào xảy ra, hiển thị thông báo lỗi
            System.out.println("Ngoại lệ không được xử lý trong phương thức select(): " + e.getMessage());
        }
    }
}
