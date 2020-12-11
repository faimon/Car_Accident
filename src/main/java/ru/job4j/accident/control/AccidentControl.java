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
import ru.job4j.accident.service.AccidentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AccidentControl {
    private final AccidentService accidentService;

    public AccidentControl(AccidentService accidentService) {
        this.accidentService = accidentService;
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
        accidentService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, @RequestParam("file") MultipartFile file) {
        accidentService.saveAccident(accident, file);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidentService.getAccidentById(id));
        return "accident/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Accident accident) {
        accidentService.update(accident);
        return "redirect:/";
    }
}
