/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rglj_i_o_r;

import data.*;
import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * 
 * @author zti
 */

public final class HiberUtil {
    /**
     * choose type of mapping definition XML or annotations
     */
    public enum Mapping {
       /**
        * use xml defined mappings for configuration
        */
       XML, 
       /**
        * use annotation defined mappings for confuguration
        */
       ANN;
    } 
    /**
     * 
     * @param mapping
     * @return SessionFactory 
     */
    public static SessionFactory getSessionFactory(Mapping mapping) {
     
        switch(mapping){
            case XML:
                return(getXMLSessionFactory());
            case ANN:
                return(getANNSessionFactory());
            default:
               return(getXMLSessionFactory());
        }  
    }
  
    public static SessionFactory getXMLSessionFactory() {
        try {
            File mappingDir = new File("src\\mapowanie");
            Configuration config = new Configuration().configure();

            config.setProperty("hibernate.show_sql", "false");
            config.addDirectory(mappingDir);
            
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
            registryBuilder.applySettings(config.getProperties());
            ServiceRegistry serviceRegistry = registryBuilder.build();
                        
            SessionFactory sf = config.buildSessionFactory(serviceRegistry);
            
            return (sf);
        }
        catch (Throwable ex) {
          
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

 public static SessionFactory getANNSessionFactory() {
        try {
            Configuration config = new Configuration().configure();
            config.setProperty("hibernate.show_sql", "false");
                      
            config.addAnnotatedClass(Osoba.class)
           .addAnnotatedClass(Druzyna.class)
           .addAnnotatedClass(Mecz.class)
           .addAnnotatedClass(RodzajStatystyki.class)
           .addAnnotatedClass(Stadion.class)
           .addAnnotatedClass(Statystyki.class)
           .addAnnotatedClass(Trener.class)
           .addAnnotatedClass(Zawodnik.class)
           .addAnnotatedClass(Pozycja.class);
                       
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
            registryBuilder.applySettings(config.getProperties());
            ServiceRegistry serviceRegistry = registryBuilder.build();
                        
            SessionFactory sf = config.buildSessionFactory(serviceRegistry);
            
            return (sf);
        }
        catch (Throwable ex) {
          
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

}
