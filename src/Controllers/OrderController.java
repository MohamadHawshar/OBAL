/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Analysis;
import Entities.Client;
import Entities.Doctor;
import Entities.Order;
import static java.sql.Date.valueOf;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import utilities.DataSource;

/**
 *
 * @author lenovo
 */
public class OrderController {

    private String createString = "insert into `obal`.`ordonnance`(`date`,`idmedecin`,`idclient`,`isPayed`) values (?,?,?,?)";
    private String deleteString = "delete from ordonnance where idordonnance = ?  ;";
    private String resultCreateString = "insert into `obal`.`results` values(?,?,?,?)";
    private String resultDeleteString = "delete from results where id ordonnance= ?";
    private String datesString = "select DISTINCT date FROM ORDONNANCE ORDER BY date DESC";
    private String findByDate = "SELECT ordonnance.idclient,ordonnance.idordonnance,ordonnance.date,ordonnance.ispayed," +
"            client.first_name,client.last_name,client.tel,client.localite,medecin.nom,medecin.prenom,medecin.titre,medecin.phone" +
"             from ordonnance join client on ordonnance.idClient=client.idClient " +
"			 join medecin on ordonnance.idMedecin=medecin.idmedecin" +
"             where date=?;";

    private PreparedStatement createStmt;
    private PreparedStatement deleteStatement;
    private PreparedStatement resultCreateStatement;
    private PreparedStatement resultDeleteStatement;
    private PreparedStatement dateStatement;
    private PreparedStatement findByDateStatement;

    public OrderController() {

        try {
            createStmt = DataSource.getConnection().prepareStatement(createString);
            deleteStatement = DataSource.getConnection().prepareStatement(deleteString);
            resultCreateStatement = DataSource.getConnection().prepareStatement(resultCreateString);
            resultDeleteStatement = DataSource.getConnection().prepareStatement(resultDeleteString);
            dateStatement = DataSource.getConnection().prepareStatement(datesString);
            findByDateStatement = DataSource.getConnection().prepareStatement(findByDate);
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void create(Order order) throws SQLException {
        Client c = order.getClient();
        int x = c.getId();
        createStmt.setDate(1, valueOf(order.getDate()));
        createStmt.setString(2, order.getDoctor().getId());
        createStmt.setInt(3, x);
        createStmt.setInt(4, 0);
        createStmt.executeUpdate();
        for (Analysis a : order.getListOrders()) {
            int z = order.getId();
            int s = a.getId();
            resultCreateStatement.setDouble(1, 0);
            resultCreateStatement.setDouble(2, 0);
            resultCreateStatement.setInt(3, z);
            resultCreateStatement.setInt(4, s);
            resultCreateStatement.executeUpdate();
        }

    }

    public void delete(Order order) throws SQLException {
        deleteStatement.setString(1, String.valueOf(order.getId()));
        for (Analysis a : order.getListOrders()) {
            resultDeleteStatement.setString(1, String.valueOf(order.getId()));
            resultDeleteStatement.executeUpdate();
        }
        deleteStatement.executeUpdate();

    }

    public List<Date> date() throws SQLException {
        List<Date> list = new ArrayList();
        ResultSet set = dateStatement.executeQuery();
        while (set.next()) {
            list.add(set.getDate(1));
        }
        set.close();

        return list;
    }

    public List<Order> findByDate(Date d) throws SQLException {
        findByDateStatement.setDate(1, (java.sql.Date) d);
        List<Order> list = new ArrayList();
        ResultSet set = findByDateStatement.executeQuery();
        int id;
        Client client;
        Doctor doctor;
        Boolean paid;
        Order o;
        while (set.next()) {
            id = set.getInt(2);
            client = new Client(set.getInt(1), set.getString(5), set.getString(6), set.getString(7), set.getString(8));
            doctor=new Doctor(null,set.getString(10), set.getString(9), set.getString(12), null, set.getString(11));
            paid = set.getInt(4)==1;
            o=new Order(id,valueOf(d.toString()).toLocalDate(), paid, client,doctor, null);
            list.add(o);
        }

        return list;

    }

    public static final OrderController instance = new OrderController();

    public static void main(String[] args) {
        Order order = new Order();
        order.setClient(new Client(2));
        System.out.println(order.getClient().getId());
    }
}
