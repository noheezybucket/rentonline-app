package sn.dev.rentline.web.building;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.dev.rentline.dao.BuildingImplDao;
import sn.dev.rentline.dao.IBuildingDao;
import sn.dev.rentline.entity.Building;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "bs", urlPatterns = "*.do")
public class BuildingServlet extends HttpServlet {

    private IBuildingDao metier;

    @Override
    public void init(ServletConfig config) throws ServletException {
        metier = new BuildingImplDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equalsIgnoreCase("/admin-buildings-list.do") || path.equalsIgnoreCase("/index.do")){
            try {
                List<Building> buildings = metier.getAllBuildings();
                BuildingModel model = new BuildingModel();
                model.setBuildings(buildings);
                req.setAttribute("buildModel", model);


                if(path.equalsIgnoreCase("/admin-buildings-list.do")){
                    req.getRequestDispatcher("buildings/list.jsp").forward(req, resp);
                } else {
                    System.out.println(model);

                    req.getRequestDispatcher("index.jsp").forward(req, resp);

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else if (path.equalsIgnoreCase("/admin-buildings-add.do")){
            req.getRequestDispatcher("buildings/add.jsp").forward(req, resp);
        } else if (path.equalsIgnoreCase("/admin-buildings-view.do")){
            int id = Integer.parseInt(req.getParameter("building_id"));
            Building building = null;
            try {
                building = metier.getBuildingById(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            req.setAttribute("building", building);
            req.getRequestDispatcher("buildings/detail.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equalsIgnoreCase("/admin-buildings-save.do")){

            String name = req.getParameter("name");
            String address = req.getParameter("address");
            String description = req.getParameter("description");
            String equipments = req.getParameter("equipments");
            String image = req.getParameter("image");

            Building building = new Building();
            building.setName(name);
            building.setAddress(address);
            building.setDescription(description);
            building.setEquipments(equipments);
            building.setImage(image);

            building = metier.addBuilding(building);

            req.setAttribute("building", building);
            req.getRequestDispatcher("buildings/detail.jsp").forward(req, resp);
        }
    }
}
