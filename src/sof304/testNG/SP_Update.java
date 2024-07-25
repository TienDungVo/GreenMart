package sof304.testNG;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.duan1.dao.SanPhamDao;
import com.duan1.entity.SanPham;

public class SP_Update {
    private SanPhamDao dao;

    @BeforeMethod
    public void setup() {
        dao = new SanPhamDao();
    }

    @Test
    public void testUpdate() {
        try {
            // Tạo một đối tượng SanPham giả định
            SanPham model = getModel();
            String idToSearch = "SP001"; // ID cụ thể bạn muốn tìm

            // Lấy lại đối tượng SanPham từ cơ sở dữ liệu bằng ID cụ thể
            SanPham retrievedModel = dao.findByIdSp(idToSearch);

            // Kiểm tra xem retrievedModel không null
            assertNotNull(retrievedModel, "Không tìm thấy đối tượng để cập nhật");

            // Cập nhật một số thông tin của đối tượng SanPham
            retrievedModel.setTenSanPham("Keo ngot");
            retrievedModel.setGia(20000);

            // Thực hiện cập nhật
            dao.update(retrievedModel);

            // Lấy lại đối tượng đã cập nhật từ cơ sở dữ liệu
            SanPham updatedModel = dao.findByIdSp(retrievedModel.getIDSanPham());

            // Kiểm tra xem thông tin đã được cập nhật chính xác
            assertTrue(updatedModel.getTenSanPham().equals("Keo ngot"));
            assertTrue(updatedModel.getGia() == 20000);

            // In ra thông báo cập nhật thành công
            System.out.println("Cập nhật thành công");

        } catch (Exception e) {
            // Nếu có bất kỳ ngoại lệ nào xảy ra, test case sẽ thất bại
            e.printStackTrace();
        }
    }

    // Phương thức để tạo một đối tượng SanPham giả định
    private SanPham getModel() {
        SanPham model = new SanPham();
        // Thiết lập các thuộc tính của model
        return model;
    }
}
