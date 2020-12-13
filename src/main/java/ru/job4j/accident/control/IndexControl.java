package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.service.AccidentHibernateService;
import ru.job4j.accident.service.AccidentJdbcService;
import ru.job4j.accident.service.AccidentSpringDataService;

import java.security.Principal;

@Controller
public class IndexControl {
    private final AccidentSpringDataService service;

    public IndexControl(AccidentSpringDataService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model, Principal user) {
        model.addAttribute("accidents", service.getAll());
        model.addAttribute("username", user.getName());
        return "index";
    }
}
