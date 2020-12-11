package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;
import java.util.function.Function;

@Repository
public class AccidentHibernate {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Accident save(Accident accident) {
        return tx(session -> {
            session.save(accident);
            return accident;
        });
    }

    public List<Accident> getAll() {
        return tx(session -> session
                .createQuery("FROM Accident", Accident.class)
                .list());

    }

    public void delete(int id) {
        tx(session -> {
            Accident accident = session.get(Accident.class, id);
            session.delete(accident);
            return null;
        });
    }
}
