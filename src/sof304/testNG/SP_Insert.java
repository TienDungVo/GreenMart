package sof304.testNG;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.duan1.dao.SanPhamDao;
import com.duan1.entity.DoanhMuc;
import com.duan1.entity.SanPham;

public class SP_Insert {
	private SanPhamDao dao;

	@BeforeMethod
	public void setup() {
		dao = new SanPhamDao();
	}

	@Test
	public void testInsert() {
		try {
			// Tạo một đối tượng SanPham giả định
			SanPham model = getModel();

			// Chèn đối tượng vào cơ sở dữ liệu
			dao.insert(model);

			// Lấy đối tượng SanPham từ cơ sở dữ liệu bằng IDSanPham
			SanPham retrievedModel = dao.findByIdSp(model.getIDSanPham());

			// Kiểm tra xem retrievedModel không null
			assertNotNull(retrievedModel, "Không tìm thấy đối tượng sau khi chèn");

			// Nếu retrievedModel không phải là null, in ra thông báo
			System.out.println("Thêm mới thành công");

			// Kiểm tra xem IDSanPham của retrievedModel khớp với IDSanPham ban đầu
			assertTrue(model.getIDSanPham().equals(retrievedModel.getIDSanPham()));

			// (Optional) Kiểm tra logic khác nếu cần thiết

		} catch (Exception e) {
			// Nếu có bất kỳ ngoại lệ nào xảy ra, test case sẽ thất bại
			e.printStackTrace();
		}
	}

	// Phương thức để tạo một đối tượng SanPham giả định
	private SanPham getModel() {
		// Tạo một đối tượng SanPham với dữ liệu giả định từ giao diện người dùng
		SanPham model = new SanPham();
		DoanhMuc doanhMuc = new DoanhMuc(); // Giả định đối tượng DoanhMuc
		int idDoanhMuc = 8; // Ví dụ: IDDoanhMuc giả định là 1
		doanhMuc.setIDDoanhMuc(idDoanhMuc);
		model.setIDSanPham("SP001"); // IDSanPham giả định
		model.setIDDoanhMuc(doanhMuc.getIDDoanhMuc()); // Thiết lập IDDoanhMuc cho SanPham
		model.setTenSanPham("Sản phẩm 1"); // Tên sản phẩm giả định
		model.setGia(10000); // Giá giả định
		model.setMoTa("Mô tả sản phẩm 1"); // Mô tả giả định
		model.setHinhAnh("hinh_anh.jpg"); // Hình ảnh giả định
		return model;
	}
}
