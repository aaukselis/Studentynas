package lt.sigitas.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pazimys")
public class Pazymiai
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_studentas")
    private Integer id_studentas;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "pazimys")
    private Integer pazimys;

    public int getId() {
        return id;
    }

    public Integer getId_studentas() {
        return id_studentas;
    }

    public LocalDate getData() {
        return data;
    }

    public Integer getPazimys() {
        return pazimys;
    }

    public Pazymiai() {
    }

    public Pazymiai(Integer id_studentas, LocalDate data, Integer pazimys) {
        this.id_studentas = id_studentas;
        this.data = data;
        this.pazimys = pazimys;
    }

    @Override
    public String toString() {
        return "Pazymiai is db"+"data =" + data +
                ", pazymys =" + pazimys;
    }
}
