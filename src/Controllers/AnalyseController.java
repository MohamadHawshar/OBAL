/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Analysis;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DataSource;

/**
 *
 * @author lenovo
 */
public class AnalyseController {
    
    private String findAll="select * from analyse";
    private PreparedStatement findAllStatement;

    private AnalyseController() {
        try {
            findAllStatement=DataSource.getConnection().prepareStatement(findAll);
        } catch (SQLException ex) {
            Logger.getLogger(AnalyseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Analysis> findAll()throws SQLException{
        List<Analysis> list=new ArrayList();
        
        ResultSet set=findAllStatement.executeQuery();
        String name;
        float price;
        int id;
        String unit;
        String value;
        while(set.next()){
            id=set.getInt(1);
            name=set.getString(2);
            unit=set.getString(3);
            value=set.getString(3);
            price=(float) set.getDouble(5);
            list.add(new Analysis(id,name,unit,value,price));
        }
            
        
        
        return list;
    }
    public static final AnalyseController instance=new AnalyseController() ;
    
}
