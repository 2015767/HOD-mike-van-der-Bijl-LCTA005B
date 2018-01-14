package spring.controller;

import spring.editor.RoleEditor;
import spring.model.User;
import spring.model.Role;
import spring.service.UserService;
import spring.service.RoleService;
import java.io.IOException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleEditor roleEditor;

    private static String titelNieuw = "Nieuwe role";
    private static String titelOpNieuw = "Nieuwe role, probeer nog eens";
    private static String titelWijzig = "Wijzig role";

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Role.class, this.roleEditor);
    }

    @RequestMapping(value = "/list")
    public ModelAndView roleList() throws IOException {
        ModelAndView userListView = new ModelAndView("roleList");
        userListView.addObject("roleList", roleService.getRoles());

        return userListView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView roleAddPage() throws IOException {

        ModelAndView userAddView = new ModelAndView("roleAdd");
        userAddView.addObject("paginaTitel", titelNieuw);
        userAddView.addObject("role", new Role());
        userAddView.addObject("roleList", roleService.getRoles());
        return userAddView;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView roleAdd(@ModelAttribute("role") @Valid Role role, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            ModelAndView userAddView = new ModelAndView("roleAdd");
            userAddView.addObject("paginaTitel", titelOpNieuw);
        userAddView.addObject("role", role);
            userAddView.addObject("roleList", roleService.getRoles());
            return userAddView;
        } else {
            ModelAndView userListView = new ModelAndView("roleList");
            roleService.addRole(role);
            userListView.addObject("roleList", roleService.getRoles());
            String message = "Role was successfully added.";
            userListView.addObject("message", message);

            return userListView;
        }
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editRolePage(@PathVariable long id) {
        ModelAndView userEditView = new ModelAndView("roleEdit");
        userEditView.addObject("paginaTitel", titelWijzig);
        userEditView.addObject("role", roleService.roleGetById(id));
        userEditView.addObject("roleList", roleService.getRoles());
        return userEditView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView userEdit(@ModelAttribute("role") @Valid Role role, BindingResult result, ModelMap model) {       
        if (result.hasErrors()) {
            ModelAndView roleEditView = new ModelAndView("roleEdit");
            roleEditView.addObject("paginaTitel", titelOpNieuw);
            roleEditView.addObject("Role", role);
            roleEditView.addObject("roleList", roleService.getRoles());
            return roleEditView;
        } else {
            ModelAndView roleEditView = new ModelAndView("roleList");
            System.out.print(role); 
            roleService.editRole(role);
            roleEditView.addObject("roleList", roleService.getRoles());
            String message = "Role was successfully edited.";
            roleEditView.addObject("message", message);
            return roleEditView;
        }
    }


    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public ModelAndView removeRole(@PathVariable long id
    ) {
        ModelAndView roleListView = new ModelAndView("roleList");
        roleService.deleteRole(id);
        roleListView.addObject("userList", roleService.getRoles());

        String message = "Role was successfully deleted.";
        roleListView.addObject("message", message);
        return roleListView;
    }
}
