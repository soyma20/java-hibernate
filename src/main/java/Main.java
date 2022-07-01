import Models.Car;
import Models.Manufacturer;
import Models.Owner;
import Models.Wheels;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Manufacturer.class)
                .addAnnotatedClass(Owner.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Wheels.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        ArrayList<Manufacturer> europeanManufacturers = new ArrayList<>();
        europeanManufacturers.add(new Manufacturer("poland"));
        europeanManufacturers.add(new Manufacturer("france"));

        ArrayList<Manufacturer> asianManufacturers = new ArrayList<>();
        europeanManufacturers.add(new Manufacturer("china"));


        ArrayList<Wheels> wheels = new ArrayList<>();
        wheels.add(new Wheels("big",europeanManufacturers));
        wheels.add(new Wheels("small",europeanManufacturers));
        wheels.add(new Wheels("medium",asianManufacturers));


        Car car = new Car("mazda",wheels);

        Owner owner = new Owner("ivan",car);


        session.save(car);
        session.save(owner);


        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

    }
}
