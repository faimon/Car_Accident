package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem implements Store {
    private static final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();
    private static final AtomicInteger COUNT = new AtomicInteger(0);
    private static final List<AccidentType> types = new ArrayList<>();


    public AccidentMem() {
        types.add(AccidentType.of(1, "Две машины"));
        types.add(AccidentType.of(2, "Машина и человек"));
        types.add(AccidentType.of(3, "Машина и велосипед"));
        this.add(new Accident("narushenie1", "text1", "address1", types.get(0)));
        this.add(new Accident("narushenie2", "text2", "address2", types.get(1)));
        this.add(new Accident("narushenie3", "text3", "address3", types.get(2)));
    }

    @Override
    public void add(Accident accident) {
        int typeId = accident.getType().getId() - 1;
        accident.setType(types.get(typeId));
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
        int typeId = accident.getType().getId() - 1;
        accident.setType(types.get(typeId));
        accidents.put(accident.getId(), accident);
    }

    public List<AccidentType> getTypes() {
        return types;
    }
}
