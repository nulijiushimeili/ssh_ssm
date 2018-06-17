package util;

import com.sun.xml.internal.ws.api.wsdl.parser.MetaDataResolver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory factory = null;
    static {
        //registry standard service
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static Session getSession(){
        return factory.openSession();
    }

    public static void close(Session session){
        if(session != null)session.close();
    }
}
