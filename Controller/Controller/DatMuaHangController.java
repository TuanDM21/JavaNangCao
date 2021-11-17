package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.GioHangBean;
import Bean.KhachHangBean;
import Bo.ChiTietHoaDonBo;
import Bo.HoaDonBo;

/**
 * Servlet implementation class DatMuaHangController
 */
@WebServlet("/DatMuaHangController")
public class DatMuaHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DatMuaHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		HoaDonBo hdbBo = new HoaDonBo();
		ChiTietHoaDonBo chiTietHoaDonBo = new ChiTietHoaDonBo();
		KhachHangBean kh = (KhachHangBean) session.getAttribute("khachhang");
		if (kh == null) {
			request.setAttribute("xacnhan", "xacnhan");
		} else {
			try {
				hdbBo.getHoaDon(kh.getMakh());
				ArrayList<GioHangBean> ghbean = (ArrayList<GioHangBean>) session.getAttribute("giohang");
				chiTietHoaDonBo.getChiTietHoaDon(ghbean);
				request.setAttribute("kiemtra", "kiemtra");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("Cart.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
