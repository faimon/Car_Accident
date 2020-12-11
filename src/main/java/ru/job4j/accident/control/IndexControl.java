package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.service.AccidentJdbcService;

@Controller
public class IndexControl {
    private final AccidentJdbcService jdbcService;

    public IndexControl(AccidentJdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", jdbcService.getAll());
        return "index";
    }
}
