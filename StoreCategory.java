import entity.Catalog;
import entity.Category;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.Transaction;
        import org.hibernate.cfg.Configuration;

public class StoreCategory {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction t = session.beginTransaction();

        Catalog ca1=new Catalog();
        ca1.setCatalogName("subject");

        Category c1=new Category();
        c1.setCategoryName("Electrical");
        c1.setStatus("Active");

        Category c2=new Category();
        c2.setCategoryName("Electronics");
        c2.setStatus("Inactive");

        ca1.getCategoryList().add(c1);
        ca1.getCategoryList().add(c2);

        c1.setCatalog(ca1);
        c2.setCatalog(ca1);
        session.save(ca1);
        session.save(c1);
        session.save(c2);

       // session.persist(ca1);
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();

    }
}