import models.Car;
import models.DriveLicense;
import models.Owner;
import models.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Owner.class)
                .addAnnotatedClass(DriveLicense.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

        Session session = sessionFactory.openSession();

        session.beginTransaction();
//
//        ArrayList<Car> ivanCars = new ArrayList<>();
//        ivanCars.add(new Car("tesla", Type.SEDAN,2000,2000,2000));
//        ivanCars.add(new Car("zaz", Type.SEDAN,1000,1000,1000));
//        ArrayList<Car> oliaCars = new ArrayList<>();
//        oliaCars.add(new Car("bmw", Type.CROSSOVER,2000,2000,2000));
//        ArrayList<Car> savikCars = new ArrayList<>();
//        savikCars.add(new Car("mers", Type.HATCHBACK,2000,2000,2000));
//        savikCars.add(new Car("laz", Type.SPORTCAR,1000,1000,1000));
//
//        session.save(new Owner("ivan",ivanCars,new DriveLicense("sjk3123123")));
//        session.save(new Owner("olia",oliaCars,new DriveLicense("dkc3948394")));
//        session.save(new Owner("savik",savikCars,new DriveLicense("sla21390219")));

        session.createQuery("select o from Owner o",Owner.class).getResultList().forEach(System.out::println);
        session.createQuery("select o from Owner o", Owner.class).getResultList().forEach(owner ->{
            System.out.println(owner.getCars());
        });


        session.getTransaction().commit();

        session.close();
        sessionFactory.close();


    }
}
