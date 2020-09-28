/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Analysis;
import Entities.Client;
import Entities.Order;
import Entities.Result;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DataSource;

/**
 *
 * @author Alaa Shafshak
 */
public class BillController {

    private String findClientString = "select * from Client where lower(first_name) like ?;";
    private String findOrdString = "select ordonnance.idordonnance, ordonnance.idclient, ordonnance.date, ordonnance.ispayed,"
            + "client.idclient, client.first_name, client.last_name from ordonnance join client on "
            + "ordonnance.idclient=client.idclient where ordonnance.idclient=?;";

    private String findAnalysisByOrdString = "select ordonnance.idordonnance, ordonnance.idclient, ordonnance.date, ordonnance.ispayed,"
            + "results.idordonnance, results.idAnalyse, analyse.idAnalyse, analyse.name from ordonnance join results on "
            + "ordonnance.idordonnance=results.idordonnance join analyse on results.idAnalyse=analyse.idAnalyse "
            + "where ordonnance.idordonnance=?;";

    private String findCliendId = "select idclient from Client where first_name like ? and last_name like ?;";

    private String findParticipString = "select analyse.idAnalyse, analyse.name, results.idAnalyse, results.particip "
            + "from analyse join results on analyse.idAnalyse=results.idAnalyse where analyse.idAnalyse=?; ";
   
    private String getAnalyseId = "select idAnalyse from analyse where name like ?";
    
    private String updateResultString = "update `obal`.`results` set particip=? where results.idAnalyse=?;";
    
    

    private PreparedStatement findClientStmt;
    private PreparedStatement findOrdStmt;
    private PreparedStatement findAnalyseByOrdStmt;
    private PreparedStatement findClientIdStmt;
    private PreparedStatement findParticipStmt;
    private PreparedStatement getAnalyseIdStmt;
    private PreparedStatement updateResultStmt;

    public BillController() {
        try {
            findClientStmt = DataSource.getConnection().prepareStatement(findClientString);
            findOrdStmt = DataSource.getConnection().prepareStatement(findOrdString);
            findAnalyseByOrdStmt = DataSource.getConnection().prepareStatement(findAnalysisByOrdString);
            findClientIdStmt = DataSource.getConnection().prepareStatement(findCliendId);
            findParticipStmt = DataSource.getConnection().prepareStatement(findParticipString);
            getAnalyseIdStmt = DataSource.getConnection().prepareStatement(getAnalyseId);
            updateResultStmt = DataSource.getConnection().prepareStatement(updateResultString);
        } catch (SQLException ex) {
            Logger.getLogger(BillController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> findClient(String subname) throws SQLException {
        List<String> ls = new ArrayList();
        if (subname == null) {
            findClientStmt.setString(1, "%%");
        } else {
            findClientStmt.setString(1, subname + "%");
            ResultSet set = findClientStmt.executeQuery();
            while (set.next()) {
                String fullName = set.getString(2) + " " + set.getString(3);
                ls.add(fullName);
            }
            set.close();
        }
        return ls;
    }

    public List<Order> findOrd(String subFirst, String subLast) throws SQLException {
        List<Order> ls = new ArrayList();

        if (subFirst == null) {
            findClientIdStmt.setString(1, "%%");
        } else {
            findClientIdStmt.setString(1, subFirst);
        }
        if (subLast == null) {
            findClientIdStmt.setString(2, "%%");
        } else {
            findClientIdStmt.setString(2, subLast);
        }

        ResultSet set_1 = findClientIdStmt.executeQuery();
        set_1.next();
        int clientId = set_1.getInt(1);

        findOrdStmt.setInt(1, clientId);
        ResultSet set_2 = findOrdStmt.executeQuery();

        int id;
        LocalDate date;
        while (set_2.next()) {
            id = set_2.getInt(1);
            date = set_2.getDate(3).toLocalDate();
            ls.add(new Order(id, date));
        }
        set_1.close();
        set_2.close();

        return ls;
    }

    public List<Analysis> findAnalysisByOrd(int id) throws SQLException {
        List<Analysis> ls = new ArrayList<>();

        findAnalyseByOrdStmt.setInt(1, id);
        ResultSet set = findAnalyseByOrdStmt.executeQuery();
        while (set.next()) {
            ls.add(new Analysis(set.getString(8)));
        }
        set.close();
        return ls;
    }

    public String findParticip(int id) throws SQLException {
        String part = null;
        findParticipStmt.setInt(1, id);
        ResultSet set = findParticipStmt.executeQuery();
        while (set.next()) {
            part = set.getString(4);
        }
        set.close();
        return part;
    }
    
    public int getAnalysisId(String st) throws SQLException{
        int id;
        getAnalyseIdStmt.setString(1, st);
        ResultSet set = getAnalyseIdStmt.executeQuery();
        set.next();
        id = set.getInt(1);
        return id;
    }

    public void updateResult(int id, double particip) throws SQLException {
        updateResultStmt.setDouble(1, particip);
        System.out.println("AHHHHHHHHHH" + particip);
        updateResultStmt.setInt(2, id);
        System.out.println("HEEEYYYY" + id);
        updateResultStmt.executeUpdate();
    }
    public static final BillController instance = new BillController();
}
