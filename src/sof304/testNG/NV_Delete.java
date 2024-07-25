package sof304.testNG;

import static org.testng.Assert.assertNull;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.duan1.dao.NhanVienDAO;
import com.duan1.entity.TaiKhoan;

public class NV_Delete {
	 private NhanVienDAO dao;

	    @BeforeMethod
	    public void setup() {
	        dao = new NhanVienDAO();
	    }

	    @Test
	    public void testDelete() {
	        // Tạo một đối tượng TaiKhoan để chèn vào cơ sở dữ liệu
	        String userName = "user187";
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

	        // Xóa đối tượng nhân viên với userName tương ứng
	        dao.delete(userName);

	        // Kiểm tra xem đối tượng nhân viên đã được xóa thành công
	        TaiKhoan retrievedModel = dao.findById(userName);
	        if (retrievedModel == null) {
	            System.out.println("Đối tượng đã được xóa thành công từ cơ sở dữ liệu.");
	        } else {
	            // Nếu retrievedModel không phải là null, in ra thông báo
	            System.out.println("Đối tượng vẫn tồn tại trong cơ sở dữ liệu sau khi xóa.");
	        }
	        assertNull(retrievedModel);
	        
	    }
}
