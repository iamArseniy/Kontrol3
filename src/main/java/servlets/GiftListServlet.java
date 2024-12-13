package servlets;

import model.Gift;
import service.GiftService;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/gifts")
public class GiftListServlet extends HttpServlet {
    private GiftService giftService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        giftService = (GiftService) this.getServletContext().getAttribute("giftService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Получаем список подарков
            List<Gift> gifts = giftService.getAllGifts();
            // Передаем список подарков в JSP
            request.setAttribute("gifts", gifts);
            // Перенаправляем на страницу с выводом списка подарков
            getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving gifts", e);
        }
    }
}
