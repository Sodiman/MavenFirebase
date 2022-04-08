/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.User;

/**
 *
 * @author Ody
 */
public interface UserInterf {
    public List<User> getAll() throws Exception;

    public void save(User u) throws Exception;

    public void update(User u) throws Exception;

    public void deleteBy(String kunci) throws Exception;
}
