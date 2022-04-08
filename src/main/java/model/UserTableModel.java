/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ody
 */
public class UserTableModel extends AbstractTableModel {
    
    List<User> list = new ArrayList<>();
    
    private static final String HEADER[] = {"Username", "Password", "Email", "Akses", "Key"};

    public UserTableModel(List<User> l) {
        this.list = l;
    }
    
    

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public String getColumnName(int column) {
        return HEADER[column];
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User u = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return u.getUsername();
            case 1:
                return u.getPassword();
            case 2:
                return u.getEmail();
            case 3:
                return u.getAkses();
            case 4:
                return u.getKey();
                default:
                    return null;
        }
    }
    
}
