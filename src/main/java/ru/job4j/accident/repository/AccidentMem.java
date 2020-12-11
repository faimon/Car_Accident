package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private static final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();
    private static final AtomicInteger COUNT = new AtomicInteger(0);

    public AccidentMem() {
        this.add(new Accident("парковка под знаком остановка запрещена",
                "о162ру", "Ленина 23", "123.jpg", "Принята"));
        this.add(new Accident("сбит пешеход",
                "о362ру", "Ленина 23", "123.jpg", "Принята"));
    }

    public void add(Accident accident) {
        int id = COUNT.incrementAndGet();
        accident.setId(id);
        accidents.put(id, accident);
    }

    public Collection<Accident> getAll() {
        return accidents.values();
    }

    public Accident getById(int id) {
        return accidents.get(id);
    }

    public void update(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

}
