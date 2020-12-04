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
        this.add(new Accident(1, "narushenie1", "text1", "address1"));
        this.add(new Accident(2, "narushenie2", "text2", "address2"));
        this.add(new Accident(3, "narushenie3", "text3", "address3"));
    }

    @Override
    public void add(Accident accident) {
        accidents.put(COUNT.incrementAndGet(), accident);
    }

    @Override
    public Collection<Accident> getAll() {
        return accidents.values();
    }
}
