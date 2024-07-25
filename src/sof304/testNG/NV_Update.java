package sof304.testNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.duan1.dao.NhanVienDAO;
import com.duan1.entity.TaiKhoan;

public class NV_Update {
	private NhanVienDAO dao;

    @BeforeMethod
    public void setup() {
        dao = new NhanVienDAO();
    }

    @Test
    public void testUpdateAndRetrieve() {
        // Tạo một đối tượng TaiKhoan với dữ liệu giả định
        String userName = "user123";
        String tenTK = "Tên Tài Khoản";
        String password = "password123";
        boolean role = true;
        String moTaRole = "Mô Tả Role";
        String hinhAnh = "hinh_anh.jpg";
        
        TaiKhoan model = new TaiKhoan();
        model.setUserName(userName);
        model.setTenTK(tenTK);
        model.setPassword(password);
        model.setRole(role);
        model.setMoTaRole(moTaRole);
        model.setHinhAnh(hinhAnh);

        // Chèn đối tượng TaiKhoan vào cơ sở dữ liệu
        dao.insert(model);

        // Cập nhật dữ liệu của đối tượng TaiKhoan
        String updatedTenTK = "dungvt";
        model.setTenTK(updatedTenTK);
        dao.update(model);

        // Lấy đối tượng TaiKhoan từ cơ sở dữ liệu bằng userName
        TaiKhoan updatedModel = dao.findById(userName);
        
        // Kiểm tra xem updatedModel không null
        assertNotNull(updatedModel);

        // Kiểm tra xem dữ liệu đã được cập nhật thành công
        assertEquals(updatedTenTK, updatedModel.getTenTK());
    }
}
