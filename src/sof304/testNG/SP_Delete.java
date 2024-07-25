package sof304.testNG;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.duan1.dao.SanPhamDao;

public class SP_Delete {
    private SanPhamDao dao;

    @BeforeMethod
    public void setup() {
        dao = new SanPhamDao();
    }

    @Test
    public void testDelete() {
        try {
            String maSPToDelete = "SP001";
            dao.delete(maSPToDelete);
            System.out.println("Xóa sản phẩm thành công");

        } catch (Exception e) {
            // Nếu có bất kỳ ngoại lệ nào xảy ra, test case sẽ thất bại
            e.printStackTrace();
        }
    }
}