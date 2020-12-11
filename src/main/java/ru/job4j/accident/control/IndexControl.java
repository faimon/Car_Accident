package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.service.AccidentHibernateService;
import ru.job4j.accident.service.AccidentJdbcService;

@Controller
public class IndexControl {
    private final AccidentHibernateService service;

    public IndexControl(AccidentHibernateService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", service.getAll());
        return "index";
    }
}
