package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.files.AccidentImage;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.service.AccidentHibernateService;
import ru.job4j.accident.service.AccidentJdbcService;
import ru.job4j.accident.service.AccidentSpringDataService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AccidentControl {
    private final AccidentSpringDataService service;

    public AccidentControl(AccidentSpringDataService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "accident/create";
    }

    @GetMapping("/image")
    public void getImage(HttpServletResponse response, @RequestParam("filename") String imgPath) {
        byte[] img = AccidentImage.getImageAsBytes(imgPath);
        try {
            response.getOutputStream().write(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        service.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, @RequestParam("file") MultipartFile file) {
        service.save(accident, file);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", service.getAccidentById(id));
        return "accident/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Accident accident) {
        service.updateAccident(accident);
        return "redirect:/";
    }
}
