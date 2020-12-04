package ru.job4j.accident.repository;

import ru.job4j.accident.model.Accident;

import java.util.Collection;

public interface Store {
    void add(Accident accident);

    Collection<Accident> getAll();

    Accident getById(int id);

    void update(Accident accident);
}
