package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.accident.files.AccidentImage;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentRepository;

import java.util.Collection;

@Service
public class AccidentSpringDataService {
    private final AccidentRepository accidentRepository;

    public AccidentSpringDataService(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    public void save(Accident accident, MultipartFile file) {
        AccidentImage.saveImage(file);
        accident.setPhotoPath(file.getOriginalFilename());
        accident.setStatus("Принята");
        accidentRepository.save(accident);
    }

    public void deleteById(int id) {
        accidentRepository.deleteById(id);
    }

    public Collection<Accident> getAll() {
        return (Collection<Accident>) accidentRepository.findAll();
    }

    public Accident getAccidentById(int id) {
        return accidentRepository.findById(id).get();
    }

    public void updateAccident(Accident accident) {
        accidentRepository.save(accident);
    }
}
