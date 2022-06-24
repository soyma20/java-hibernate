import models.Car;
import models.Owner;
import models.Type;
import models.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Word.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Owner.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

        Session session = sessionFactory.openSession();

//        session.beginTransaction();
//
////        session.save(new Word("big"));
////        session.save(new Word("dream"));
////        session.save(new Word("make"));
////        session.save(new Word("come"));
////        session.save(new Word("lamp"));
////        session.save(new Word("bottle"));
////        session.save(new Word("phone"));
//
//
//        session.getTransaction().commit();

//        List<Word> wordList = session.createNativeQuery("select * from word", Word.class).getResultList();
//        List<Word> select_w_from_word_w = session.createQuery("select w from Word w", Word.class).list();
//
//        System.out.println(select_w_from_word_w);
//        System.out.println(wordList);
//        session.beginTransaction();

//        session.save(new Owner("olia", new Car("tesla", Type.SEDAN, 10000, 200000, 2022)));

        List<Owner> owners = session.createQuery("select o from Owner o", Owner.class).getResultList();
        List<Car> cars = session.createQuery("select o.car from Owner o", Car.class).getResultList();

        System.out.println(owners);

        System.out.println(cars);


//        session.getTransaction().commit();

        session.close();
        sessionFactory.close();


    }
}
