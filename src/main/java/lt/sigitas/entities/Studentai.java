package lt.sigitas.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "studentai")
public class Studentai {
    @Id
    @Column(name = "id_studentas")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_studentas;

    @Column(name = "vardas")
    private String vardas;

    @Column(name = "pavarde")
    private String pavarde;

    @Column(name = "mail")
    private String mail;

    public int getid_studentas() {
        return id_studentas;
    }

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public String getMail() {
        return mail;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_studentas")
    public List<Pazymiai> pazymiai;

    public List<Pazymiai> getPazymiai() {
        return pazymiai;
    }

    public Studentai() {
    }

    public Studentai(String vardas, String pavarde, String mail) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Studentai{" +
                "vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", mail='" + mail + '\'' +
                ", pazymiai=" + pazymiai +
                '}';
    }
}