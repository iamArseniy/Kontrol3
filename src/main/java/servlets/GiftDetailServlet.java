package servlets;

import model.Gift;
import service.GiftService;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/giftDetail")
public class GiftDetailServlet extends HttpServlet {
    private GiftService giftService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        giftService = (GiftService) this.getServletContext().getAttribute("giftService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            int id = Integer.parseInt(request.getParameter("id"));

            Gift gift = giftService.getGiftById(id);

            request.setAttribute("gift", gift);

            request.getRequestDispatcher("/WEB-INF/views/giftDetail.jsp").forward(request, response);
        } catch (SQLException | NumberFormatException e) {
            throw new ServletException("Error retrieving gift details", e);
        }
    }
}
