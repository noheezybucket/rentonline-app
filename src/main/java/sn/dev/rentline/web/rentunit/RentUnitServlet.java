package sn.dev.rentline.web.rentunit;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.dev.rentline.dao.IRentUnitDao;
import sn.dev.rentline.dao.RentUnitImplDao;
import sn.dev.rentline.entity.RentUnit;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "rs", urlPatterns = "*.rent")
public class RentUnitServlet extends HttpServlet {
    private IRentUnitDao metier;

    @Override
    public void init(ServletConfig config) throws ServletException {
        metier = new RentUnitImplDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equalsIgnoreCase("/list.rent")){
            List<RentUnit> rentUnits = null;
            try {
                rentUnits = metier.getAllUnits();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            RentUnitModel model = new RentUnitModel();
            model.setRentUnits(rentUnits);

            req.setAttribute("rentModel", model);

            req.getRequestDispatcher("rentunits/list.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
