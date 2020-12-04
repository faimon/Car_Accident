package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Collection;
import java.util.List;

@Service
public class AccidentService {
    private final AccidentMem accidentMem;

    public AccidentService(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    public void saveAccident(Accident accident) {
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

    public List<AccidentType> getTypes() {
        return accidentMem.getTypes();
    }
}
