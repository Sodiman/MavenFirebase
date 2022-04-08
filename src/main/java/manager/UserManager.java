/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import com.mycompany.mavenfirebase.MainFirebase;
import interfaces.UserInterf;
import java.util.List;
import model.User;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author Ody
 */
public class UserManager {

    UserInterf interf;

    public UserManager() {
        interf = MainFirebase.getConnFirebase();
    }

    public List<User> getAll() {
        try {
            return interf.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean save(User u) {
        try {
            interf.save(u);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(User u) {
        try {
            interf.update(u);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String random() {
        String randomKey = RandomStringUtils.randomAlphanumeric(10);
        return randomKey;
    }

    public boolean deleteBy(String kunci) {
        try {
            interf.deleteBy(kunci);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
