package ru.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;

@Repository
public class AccidentJdbc {
    private final JdbcTemplate jdbc;

    public AccidentJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Accident save(Accident accident) {
        jdbc.update("insert into accident (description, carNumber, address, photoPath, status) values (?, ?, ?, ?, ?)",
                accident.getDescription(), accident.getCarNumber(), accident.getAddress(), accident.getPhotoPath(),
                accident.getStatus());
        return accident;
    }

    public List<Accident> getAll() {
        return jdbc.query("select * from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setDescription(rs.getString("description"));
                    accident.setCarNumber(rs.getString("carnumber"));
                    accident.setAddress(rs.getString("address"));
                    accident.setPhotoPath(rs.getString("photoPath"));
                    accident.setStatus(rs.getString("status"));
                    return accident;
                });
    }

    public void deleteById(int id) {
        jdbc.update("delete from accident where id = ?", id);
    }
}
