package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem implements Store {
    private static final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();
    private static final AtomicInteger COUNT = new AtomicInteger(0);

    public AccidentMem() {
        this.add(new Accident("narushenie1", "text1", "address1"));
        this.add(new Accident("narushenie2", "text2", "address2"));
        this.add(new Accident("narushenie3", "text3", "address3"));
    }

    @Override
    public void add(Accident accident) {
        int id = COUNT.incrementAndGet();
        accident.setId(id);
        accidents.put(id, accident);
    }

    @Override
    public Collection<Accident> getAll() {
        return accidents.values();
    }

    @Override
    public Accident getById(int id) {
        return accidents.get(id);
    }

    @Override
    public void update(Accident accident) {
        accidents.put(accident.getId(), accident);
    }
}
