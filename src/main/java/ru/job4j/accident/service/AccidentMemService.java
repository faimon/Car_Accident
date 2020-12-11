package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.files.AccidentImage;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Collection;

@Service
public class AccidentMemService {
    private final AccidentMem accidentMem;

    public AccidentMemService(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    public void saveAccident(Accident accident, MultipartFile file) {
        AccidentImage.saveImage(file);
        accident.setPhotoPath(file.getOriginalFilename());
        accidentMem.add(accident);
    }

    public Collection<Accident> getAll() {
        return accidentMem.getAll();
    }

    public Accident getAccidentById(int id) {
        return accidentMem.getById(id);
    }

    public void update(Accident accident) {
        accidentMem.update(accident);
    }

    public void delete(int id) {
        accidentMem.deleteById(id);
    }
}
