package sn.dev.rentline.dao;

import java.sql.*;

public class SingletonConnection {
    private Connection cnx;
    private PreparedStatement pstm;
    private ResultSet rs;
    private int ok;

    private Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/rentline";
        String user = "postgres";
        String password = "";
        try {
            Class.forName("org.postgresql.Driver");
            cnx = DriverManager.getConnection(url, user, password);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return cnx;
    }

    public void initPrepar(String sql) {
        try {
            getConnection();
            pstm = cnx.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet executeSelect() {
        rs = null;
        try {
            rs = pstm.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public int executeMaj() {
        try {
            ok = pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    public void closeConnection() {
        try{
            if(cnx != null)
                cnx.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public PreparedStatement getPstm(){
        return pstm;
    }
}
