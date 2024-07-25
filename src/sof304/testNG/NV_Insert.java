package sof304.testNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.duan1.dao.NhanVienDAO;
import com.duan1.entity.TaiKhoan;

public class NV_Insert {
	private NhanVienDAO dao;

    @BeforeMethod
    public void setup() {
        dao = new NhanVienDAO();
    }

    @Test
    public void testInsertAndRetrieve() {
        // Tạo một đối tượng TaiKhoan với dữ liệu giả định
        String userName = "dungvt497";
        String tenTK = "DungVT";
        String password = "password123";
        boolean role = true;
        String moTaRole = "Tai Khoan Demo";
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

        TaiKhoan retrievedModel = dao.findById(userName);

        if (retrievedModel == null) {
            System.out.println("Thêm mới thất bại!!");
        } else {
            // Nếu retrievedModel không phải là null, in ra thông báo
            System.out.println("Thêm mới thành công");
        }

        // Kiểm tra xem userName của retrievedModel khớp với userName ban đầu
        assertEquals(userName, retrievedModel.getUserName());

        // Kiểm tra xem dữ liệu của retrievedModel có khớp với dữ liệu ban đầu
        assertEquals(tenTK, retrievedModel.getTenTK());
        assertEquals(password, retrievedModel.getPassword());
        assertEquals(role, retrievedModel.isRole());
        assertEquals(moTaRole, retrievedModel.getMoTaRole());
        assertEquals(hinhAnh, retrievedModel.getHinhAnh());
    }
}
