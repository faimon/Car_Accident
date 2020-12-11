package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.accident.files.AccidentImage;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentHibernate;

import java.util.Collection;

@Service
public class AccidentHibernateService {
    private final AccidentHibernate accidentHibernate;

    public AccidentHibernateService(AccidentHibernate accidentHibernate) {
        this.accidentHibernate = accidentHibernate;
    }

    public Collection<Accident> getAll() {
        return accidentHibernate.getAll();
    }

    public void save(Accident accident, MultipartFile file) {
        AccidentImage.saveImage(file);
        accident.setPhotoPath(file.getOriginalFilename());
        accident.setStatus("Принята");
        accidentHibernate.save(accident);
    }

    public void delete(int id) {
        accidentHibernate.delete(id);
    }
}
