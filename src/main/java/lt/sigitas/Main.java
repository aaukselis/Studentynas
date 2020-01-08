package lt.sigitas;


import lt.sigitas.entities.Pazymiai;
import lt.sigitas.entities.Studentai;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
      //  Studentas();
       grazintiDuomenis();
    //    pazymiuVidurkis();
        System.out.println("testas");
    }

    public static void  Studentas ()
    {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        try{
            entityManager.getTransaction().begin();
            List<Studentai> studenciokulistas  = new ArrayList<>();
            Studentai studentai =   entityManager.find(Studentai.class,2);
            studenciokulistas.add(studentai);
            System.out.println(studenciokulistas);
            entityManager.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void grazintiDuomenis() {
        EntityManager em = HibernateUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            List<Studentai> list = em.createQuery("from Studentai s").getResultList();

            // List<String> sortedNames = names.stream().sorted().collect(Collectors.toList()); // standartinis sortinimas kai listas tik is stringu

            // list.sort(Comparator.comparing(Studentai::getPavarde)); // sortina lista pagal pavarde grynai
            //list.sort((p1, p2) -> (p1.getPavarde()+p1.getVardas()).compareTo((p2.getPavarde()+p2.getVardas()))); //senasis metodas isnaudojant lembda
            // kai sortina pagal pavarde o jeigu ji sutampa tada pagal varda

//            list.sort ( Comparator
//                    .comparing ( Studentai::getPavarde )
//                    .thenComparing ( Studentai::getVardas );
            list.sort(Comparator.comparing(p -> (p.getPavarde() + p.getVardas()))); // ir Comparatorius sutrumpima funkcija su lembda paprasciau.

         list.stream().forEach(studentai -> System.out.println(studentai.getPavarde())); //isleidziu sarasa pagal alfabeta

            for (Studentai s : list) {
              List <Pazymiai> pazymiai = s.getPazymiai();
              String balai = "";
                for (Pazymiai p : pazymiai) {

                    balai += "  "+p.getPazimys();
                }
                System.out.println(); System.out.println(); System.out.println();

                System.out.println(s.getPavarde() +"  "+s.getVardas()+ " "+balai); //isleidziu sarasa pagal alfabeta
            }
//            list.stream()
//                    .filter(studentai -> studentai.getid_studentas()== 2)
//                    .forEach(studentai -> System.out.println(studentai.getVardas() + " " + studentai.getPazymiai()));

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void pazymiuVidurkis() {
        EntityManager em = HibernateUtils.getEntityManager();
        try {
            em.getTransaction().begin();

            List<Pazymiai> list = em.createQuery("from Pazymiai s").getResultList();
            //pabandyti su collection streamu
            double x = 0;

            for (Pazymiai p : list) {
                double y = p.getPazimys();
                x += y;
            }
            double vidurkis = x / list.size();
            System.out.println("Kurso vidurkis yra: " + vidurkis);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
