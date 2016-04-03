package ru.bobby.bio.web.procedure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.bobby.bio.LoggedUser;
import ru.bobby.bio.service.UserProceduresService;

/**
 * Created by b.istomin on 14.03.2016.
 */
@Controller
public class UserProceduresController {
    @Autowired
    private UserProceduresService service;

    @RequestMapping(value = "/procedures", method = RequestMethod.GET)
    public String procedureList(Model model) {
        model.addAttribute("procedureList", service.getAll(LoggedUser.id()));
        return "procedureList";
    }

}
