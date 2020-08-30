/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Client;
import Entities.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ClientController {
    private String createString = "insert into Client values(?,?,?,?)";
    private String findAllString = "select * from Client";
    private String findByKeyString = "select * from Client where idClient = ?";
    private String deleteByKeyString = "delete from Client where idClient = ?";
    private String findByLikeString = "select * from Client where lower(first_name) like ? and lower(last_name) like ?";
    
    
    private PreparedStatement createStmt;
    private PreparedStatement findAllStmt;
    private PreparedStatement findByKeyStmt;
    private PreparedStatement deleteByKeyStmt;
    private PreparedStatement findByLikeStmt;

    private ClientController() {
        try {
            createStmt = DataSource.getConnection().prepareStatement(createString);
            findAllStmt = DataSource.getConnection().prepareStatement(findAllString);
            findByKeyStmt = DataSource.getConnection().prepareStatement(findByKeyString);
            deleteByKeyStmt = DataSource.getConnection().prepareStatement(deleteByKeyString);
            findByLikeStmt = DataSource.getConnection().prepareStatement(findByLikeString);
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void create(Client client) throws SQLException {
        createStmt.setString(1, client.getFirstName());
        createStmt.setString(2, client.getLastName());
        createStmt.setString(3, client.getPhone());
        createStmt.setString(4, client.getLocation());
        createStmt.executeUpdate();
    }
    public List<Client> findAll() {
        List<Client> ls = new ArrayList();
        try {

            ResultSet set = findAllStmt.executeQuery();
            int id;
            String firstName;
            String lastName;
            String phone;
            String location;
            
            while (set.next()) {
                id = Integer.parseInt(set.getString(1));
                firstName = set.getString(2);
                lastName = set.getString(3);
                phone = set.getString(4);
                location = set.getString(5);
                ls.add(new Client( id,firstName, lastName ,phone,location));
            }
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
    public Client findByKey(int id) {
        try {
            findByKeyStmt.setString(1,  String.valueOf(id));
            ResultSet set = findByKeyStmt.executeQuery();
            if (set.next()) {
                return new Client(id, set.getString(2), set.getString(3),set.getString(4),set.getString(5));
            }
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void deleteByKey(Client client) throws SQLException {
        deleteByKeyStmt.setString(1, String.valueOf(client.getId()));
        deleteByKeyStmt.executeUpdate();
    }
    public List<Client> findByLike(String firstName, String lastName) {
        List<Client> ls = new ArrayList();
        try {
            if (firstName == null || lastName == null) {
                JOptionPane.showMessageDialog(null, " please enter both first and last name");
                return null;
            }else {
                findByLikeStmt.setString(1, "%" + firstName + "%");
                findByLikeStmt.setString(2, "%" + lastName + "%");
            }
            ResultSet set = findByLikeStmt.executeQuery();
            while (set.next()) {
                Client c = new Client(Integer.parseInt(set.getString(1)), set.getString(2), set.getString(3),set.getString(4),set.getString(5));
                ls.add(c);
                System.out.println(c);
            }
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
    
    
    
    public static final ClientController instance = new ClientController();
    
}
