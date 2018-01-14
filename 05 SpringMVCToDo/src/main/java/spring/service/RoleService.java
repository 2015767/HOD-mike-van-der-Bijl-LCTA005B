package spring.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.model.Role;
import spring.model.User;
import static spring.service.UserService.indexGetById;
import static spring.service.UserService.userGetById;

@Service
public class RoleService {

    @Autowired
    private static ArrayList<Role> roleList;

    public RoleService() {
        this.roleList = new ArrayList<Role>();
    }

    public static void addRole(Role role) {
        roleList.add(role);
    }

    public static void deleteRole(long id) {
        roleList.remove(roleGetById(id));
    }

    public static void editRole(Role role) {

        roleList.set(indexGetById(role.getId()), role);

    }
    public static ArrayList<Role> getRoles() {
        return roleList;
    }

    public static Role roleGetById(long id) {
        Role searchrole = new Role();

        for (Role r : roleList) {
            if (r.getId() == id) {
                searchrole = r;
            }
        }

        return searchrole;
    }

    public static int indexGetById(long id) {
        int index = 0; 
        for (Role r : roleList) {
            if (r.getId() == id) {
                index = roleList.indexOf(r);
            }
        }

        return index;
    }

}
