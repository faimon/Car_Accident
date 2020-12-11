package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.accident.files.AccidentImage;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentJdbc;

import java.util.Collection;

@Service
public class AccidentJdbcService {
    private final AccidentJdbc jdbcService;

    public AccidentJdbcService(AccidentJdbc jdbcService) {
        this.jdbcService = jdbcService;
    }

    public void save(Accident accident, MultipartFile file) {
        AccidentImage.saveImage(file);
        accident.setPhotoPath(file.getOriginalFilename());
        accident.setStatus("Принята");
        jdbcService.save(accident);
    }

    public Collection<Accident> getAll() {
        return jdbcService.getAll();
    }

    public void deleteById(int id) {
        jdbcService.deleteById(id);
    }
}
