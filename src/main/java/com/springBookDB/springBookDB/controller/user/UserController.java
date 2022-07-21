package com.springBookDB.springBookDB.controller.user;


import com.springBookDB.springBookDB.bean.book.entity.Book;
import com.springBookDB.springBookDB.bean.book.service.BookService;
import com.springBookDB.springBookDB.bean.user.entity.User;
import com.springBookDB.springBookDB.bean.user.note.entity.Note;
import com.springBookDB.springBookDB.bean.user.note.service.NoteService;
import com.springBookDB.springBookDB.bean.user.note.status.entity.Status;
import com.springBookDB.springBookDB.bean.user.note.status.service.StatusService;
import com.springBookDB.springBookDB.bean.user.privilege.service.PrivilegeService;
import com.springBookDB.springBookDB.bean.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.springBookDB.springBookDB.bean.user.privilege.entity.Privilege.USER_PRIVILEGE;


@Controller
public class UserController {
    @Autowired
    private StatusService statusService;
    @Autowired
    private BookService bookService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private PrivilegeService privilegeService;

    @PostMapping("/signedup")
    public String signUp (@ModelAttribute ("emptyuser") User user){
        user.setPrivilegeId(privilegeService.findById(USER_PRIVILEGE));
        String hashedPassword = bCryptPasswordEncoder.encode(user.getUserPassword());
        user.setUserPassword(hashedPassword);
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/tosignup")
    public String viewSignUpPage(Model model){
        User user = new User();
        model.addAttribute("emptyuser",user);
        return "/signup";
    }

    @GetMapping("/login")
    public String viewLoginPage(){
        return "/login";
    }


    @GetMapping("/users")
    public String viewAdminUserView (Model model){
       User user =new User();
       List<User> users = userService.getAllUsers();


       model.addAttribute("userlist",users);
       return "/adminuserview";
    }


}
