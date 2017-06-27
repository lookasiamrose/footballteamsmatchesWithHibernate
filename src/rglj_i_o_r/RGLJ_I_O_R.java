/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rglj_i_o_r;

import data.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author zti
 */
public class RGLJ_I_O_R {

    //private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.XML);
    private static final SessionFactory SESSION_FACTORY = HiberUtil.getANNSessionFactory();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //COMMENT AFTER FIRST TIME
        /*createOsoby();
         createDruzyny();
         createMecze();
         createPozycje();
         createRodzajeStatystyki();
         createStadiony();
         createStatystyki();
         createTrenerzy();
         createZawodnicy();*/
        //COMMENT AFTER FIRST TIME
        makeRelations();
        //showZawodnicy();
        //showDruzynyIZawodnikow();
        showIlosciSkladowDruzyn();
        showIlosciSkladowDruzynCriteria();
        showSpotkanie(new GregorianCalendar(1975, 2, 27));
        showSpotkanieCriteria(new GregorianCalendar(1975, 2, 27));
        showStatystykiDlaMeczuMniejszeNiz(new GregorianCalendar(1973, 1, 1), 250);
        showStatystykiDlaMeczuMniejszeNizCriteria(new GregorianCalendar(1973, 1, 1), 250);
        //showIlosciZawodnikow("Polska");
    }

    private static void createOsoby() {

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            Osoba o1 = new Osoba("Janusz", "Kowalski");
            session.save(o1);
            Osoba o2 = new Osoba("Tomek", "Baranski");
            session.save(o2);
            tx.commit();
        }
    }

    private static void createDruzyny() {

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            Druzyna o1 = new Druzyna("Polska");
            session.save(o1);
            Druzyna o2 = new Druzyna("Czechy");
            session.save(o2);
            Druzyna o3 = new Druzyna("Ekwador");
            session.save(o3);
            Druzyna o4 = new Druzyna("San Escobar");
            session.save(o4);
            tx.commit();
        }
    }

    private static void createMecze() {

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            Mecz o1 = new Mecz(new GregorianCalendar(1973, 1, 1));
            session.save(o1);
            Mecz o2 = new Mecz(new GregorianCalendar(1975, 2, 27));
            session.save(o2);
            Mecz o3 = new Mecz(new GregorianCalendar(1977, 4, 12));
            session.save(o3);
            Mecz o4 = new Mecz(new GregorianCalendar(2017, 12, 1));
            session.save(o4);
            tx.commit();
        }
    }

    private static void createPozycje() {

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            Pozycja o1 = new Pozycja("NAPASTNIK");
            session.save(o1);
            Pozycja o2 = new Pozycja("OBRONCA");
            session.save(o2);
            Pozycja o3 = new Pozycja("BRAMKARZ");
            session.save(o3);
            Pozycja o4 = new Pozycja("POMOCNIK");
            session.save(o4);
            Pozycja o5 = new Pozycja("REZERWOWY");
            session.save(o5);
            tx.commit();
        }
    }

    private static void createRodzajeStatystyki() {

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            RodzajStatystyki o1 = new RodzajStatystyki("AUTY");
            session.save(o1);
            RodzajStatystyki o2 = new RodzajStatystyki("SPALONE");
            session.save(o2);
            RodzajStatystyki o3 = new RodzajStatystyki("PUNKTOW");
            session.save(o3);
            RodzajStatystyki o4 = new RodzajStatystyki("WOLNYCH");
            session.save(o4);
            RodzajStatystyki o5 = new RodzajStatystyki("BRAMEK");
            session.save(o5);
            RodzajStatystyki o6 = new RodzajStatystyki("ROZNYCH");
            session.save(o6);
            tx.commit();
        }
    }

    private static void createStadiony() {

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            Stadion o1 = new Stadion("STADION NARODOWY", "WARSZAWA");
            session.save(o1);
            Stadion o2 = new Stadion("STADION", "WROCLAW");
            session.save(o2);
            Stadion o3 = new Stadion("ORLIK", "MILOWKA");
            session.save(o3);
            tx.commit();
        }
    }

    private static void createStatystyki() {

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from RodzajStatystyki");
            List<RodzajStatystyki> rodzajstatystyki = query.list();
            Statystyki o1 = new Statystyki(66);
            o1.setRodzajStatystyki(rodzajstatystyki.get(0));
            session.save(o1);
            Statystyki o2 = new Statystyki(211);
            o2.setRodzajStatystyki(rodzajstatystyki.get(1));
            session.save(o2);
            Statystyki o3 = new Statystyki(250);
            o3.setRodzajStatystyki(rodzajstatystyki.get(2));
            session.save(o3);
            Statystyki o4 = new Statystyki(270);
            o4.setRodzajStatystyki(rodzajstatystyki.get(4));
            session.save(o4);
            tx.commit();
        }
    }

    private static void createTrenerzy() {

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            Trener o1 = new Trener("Karol", "Poglodzinski");
            session.save(o1);
            Trener o2 = new Trener("Piotr", "Maszewski");
            session.save(o2);
            Trener o3 = new Trener("Apoloniusz", "Tajner");
            session.save(o3);
            tx.commit();
        }
    }

    private static void createZawodnicy() {

        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();
            Zawodnik o1 = new Zawodnik("Robert", "Lewandowski");
            session.save(o1);
            Zawodnik o2 = new Zawodnik("Cristiano", "Ronaldo");
            session.save(o2);
            Zawodnik o3 = new Zawodnik("Lionel", "Messi");
            session.save(o3);
            tx.commit();
        }
    }

    private static void makeRelations() {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction tx = session.beginTransaction();

            Query query = session.createQuery("from Mecz");
            List<Mecz> mecze = query.list();
            query = session.createQuery("from Druzyna");
            List<Druzyna> druzyny = query.list();
            query = session.createQuery("from Statystyki");
            List<Statystyki> statystyki = query.list();
            query = session.createQuery("from Trener");
            List<Trener> trenerzy = query.list();
            query = session.createQuery("from Zawodnik");
            List<Zawodnik> zawodnicy = query.list();
            query = session.createQuery("from Pozycja");
            List<Pozycja> pozycje = query.list();
            query = session.createQuery("from Stadion");
            List<Stadion> stadiony = query.list();

            Set<Druzyna> twoOfThem = new HashSet<>(2);
            twoOfThem.add(druzyny.get(0));
            twoOfThem.add(druzyny.get(1));
            mecze.get(0).setDruzyny(twoOfThem); //Pierwszy mecz to spotkanie druzyny 0 i 1

            twoOfThem = new HashSet<>(2);
            twoOfThem.add(druzyny.get(2));
            twoOfThem.add(druzyny.get(3));
            mecze.get(1).setDruzyny(twoOfThem); //Drugi mecz to spotkanie druzyny 2 i 3
            
            Set<Mecz> plentyOfThem = new HashSet<>(2); //MECZ1
            plentyOfThem.add(mecze.get(0));
            druzyny.get(0).setMecz(plentyOfThem);
            druzyny.get(1).setMecz(plentyOfThem);
            
            plentyOfThem = new HashSet<>(2);   //MECZ2
            plentyOfThem.add(mecze.get(1));
            druzyny.get(2).setMecz(plentyOfThem);
            druzyny.get(3).setMecz(plentyOfThem);

            Set<Statystyki> sixOfStats = new HashSet<>(6);
            sixOfStats.add(statystyki.get(0));
            sixOfStats.add(statystyki.get(1));
            mecze.get(0).setStatystyki(sixOfStats);
            mecze.get(0).setStadion(stadiony.get(0));
            mecze.get(1).setStadion(stadiony.get(1));
            mecze.get(2).setStadion(stadiony.get(2));

            trenerzy.get(0).setDruzyna(druzyny.get(0));
            trenerzy.get(1).setDruzyna(druzyny.get(1));
            trenerzy.get(2).setDruzyna(druzyny.get(2));
            druzyny.get(0).setTrener(trenerzy.get(0));
            druzyny.get(1).setTrener(trenerzy.get(1));
            druzyny.get(2).setTrener(trenerzy.get(2));

            zawodnicy.get(0).setDruzyna(druzyny.get(2));
            zawodnicy.get(1).setDruzyna(druzyny.get(2));
            zawodnicy.get(2).setDruzyna(druzyny.get(3));

            pozycje.get(0).setMecz(mecze.get(0));
            pozycje.get(0).setZawodnik(zawodnicy.get(0));
            zawodnicy.get(0).setPozycja(pozycje.get(0));

            pozycje.get(1).setMecz(mecze.get(0));
            pozycje.get(1).setZawodnik(zawodnicy.get(1));
            zawodnicy.get(1).setPozycja(pozycje.get(1));

            pozycje.get(2).setMecz(mecze.get(0));
            pozycje.get(2).setZawodnik(zawodnicy.get(2));
            zawodnicy.get(2).setPozycja(pozycje.get(2));

            Set<Pozycja> threeOfThem = new HashSet<>(3);
            threeOfThem.add(pozycje.get(0));
            threeOfThem.add(pozycje.get(1));
            threeOfThem.add(pozycje.get(2));
            mecze.get(0).setPozycje(threeOfThem);
            tx.commit();
        }
    }

    private static void showZawodnicy() {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction txn = session.beginTransaction();
            try {
                String zapytanie = "from Zawodnik";
                Query query = session.createQuery(zapytanie);
                List<Zawodnik> zawodnicy = query.list();
                zawodnicy.stream().forEach((Zawodnik) -> {
                    System.out.println(Zawodnik.getImie() + " " + Zawodnik.getNazwisko());
                });
            } catch (HibernateException e) {
                if (txn != null) {
                    txn.rollback();
                }
            } finally {
                session.close();
            }
        }
        System.out.println();
    }

    private static void showDruzynyIZawodnikow() {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction txn = session.beginTransaction();
            try {
                String zapytanie = "from Druzyna";
                Query query = session.createQuery(zapytanie);
                List<Druzyna> druzyny = query.list();
                druzyny.stream().forEach((Druzyna) -> {
                    System.out.print("Kraj~ " + Druzyna.getKraj());
                    try {
                        Set<Zawodnik> zawodnicy = Druzyna.getZawodnicy();

                        if (!zawodnicy.isEmpty()) {
                            System.out.print(" :");
                        }

                        zawodnicy.forEach((Zawodnik) -> {
                            System.out.print(" " + Zawodnik.getImie() + " " + Zawodnik.getNazwisko() + " ;");
                        });
                        System.out.println();
                    } catch (NullPointerException ex) {
                        System.err.println(ex.getMessage());
                    }
                });
            } catch (HibernateException e) {
                if (txn != null) {
                    txn.rollback();
                }
            } finally {
                session.close();
            }
        }
        System.out.println();
    }

    private static void showIlosciZawodnikow(String kraj) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction txn = session.beginTransaction();
            try {            
                Query query = session.createQuery("select d.zawodnicy.size from Druzyna d WHERE d.kraj= :krj");
                query.setParameter("krj", kraj);
                int count = query.getFirstResult();
                System.out.println("Ilość zawodników w drużynie " + kraj + " : " + count);
            } catch (HibernateException e) {
                if (txn != null) {
                    txn.rollback();
                }
            } finally {
                session.close();
            }
        }
    }

    private static void showIlosciSkladowDruzyn() {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction txn = session.beginTransaction();
            try {
                System.out.println("Ilości zawodników drużyn:");
                Query query = session.createQuery("from Druzyna");
                List<Druzyna> druzyny = query.list();
                druzyny.stream().forEach((Druzyna) -> {
                    showIlosciZawodnikow(Druzyna.getKraj());
                });
            } catch (HibernateException e) {
                if (txn != null) {
                    txn.rollback();
                }
            } finally {
                session.close();
            }
        }
        System.out.println();
    }

    private static void showSpotkanie(GregorianCalendar termin) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction txn = session.beginTransaction();
            try {
                Query query = session.createQuery("select d.kraj from Druzyna d INNER JOIN d.mecz z WHERE z.termin=:term");
                query.setParameter("term", termin);
                SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
                fmt.setCalendar(termin);
                String dateFormatted = fmt.format(termin.getTime());
                List<String> kraje = query.list();
                System.out.println("W terminie " + dateFormatted + " spotkały się " + kraje.get(0) + " oraz " + kraje.get(1));
            } catch (HibernateException e) {
                if (txn != null) {
                    txn.rollback();
                }
            } finally {
                session.close();
            }
        }
        System.out.println();
    }

    private static void showStatystykiDlaMeczuMniejszeNiz(GregorianCalendar termin, int max) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction txn = session.beginTransaction();
            try {
                Query query = session.createQuery("Select max(s.wartosc), s.rodzajStatystyki.opis from Statystyki s INNER JOIN s.mecz m WHERE m.termin=:term GROUP BY s.wartosc, s.rodzajStatystyki.opis HAVING max(s.wartosc) < :maks");
                query.setParameter("term", termin);
                query.setParameter("maks", max);
                SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
                fmt.setCalendar(termin);
                String dateFormatted = fmt.format(termin.getTime());
                List<Object[]> kk = query.list();
                System.out.println("W terminie " + dateFormatted + " statystyki o wartosci mniejszej niz " + Integer.toString(max) + " to:");
                for (Object[] result : kk) {
                    Integer wartosc = (Integer) result[0];
                    String opis = (String) result[1];
                    System.out.println(" - o wartości " + wartosc + " o opisie \"" + opis + "\"");
                }
            } catch (HibernateException e) {
                if (txn != null) {
                    txn.rollback();
                }
            } finally {
                session.close();
            }
        }
        System.out.println();
    }

    private static void showIlosciZawodnikowCriteria(String kraj) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction txn = session.beginTransaction();
            try {
                Criteria cr = session.createCriteria(Druzyna.class, "druzyna");
                cr.createAlias("druzyna.zawodnicy", "zawodnicy");
                cr.add(Restrictions.eq("druzyna.kraj", kraj));
                cr.setProjection(Projections.rowCount());
                Long count = (Long) cr.uniqueResult();

                System.out.println("Ilość zawodników w drużynie " + kraj + " : " + count);

            } catch (HibernateException e) {
                if (txn != null) {
                    txn.rollback();
                }
            } finally {
                session.close();
            }
        }
    }

    private static void showIlosciSkladowDruzynCriteria() {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction txn = session.beginTransaction();
            try {
                Criteria cr = session.createCriteria(Druzyna.class, "druzyna");
                System.out.println("(Kryterialne) Ilości zawodników drużyn:");
                List<Druzyna> druzyny = cr.list();
                druzyny.stream().forEach((Druzyna) -> {
                    showIlosciZawodnikowCriteria(Druzyna.getKraj());
                });
            } catch (HibernateException e) {
                if (txn != null) {
                    txn.rollback();
                }
            } finally {
                session.close();
            }
        }
        System.out.println();
    }

    private static void showSpotkanieCriteria(GregorianCalendar termin) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction txn = session.beginTransaction();
            try {
                Criteria cr = session.createCriteria(Druzyna.class, "druzyna");
                cr.createAlias("druzyna.mecz", "mecz");

                cr.add(Restrictions.eq("mecz.termin", termin));

                cr.setProjection(Projections.distinct(Projections.projectionList()
                        .add(Projections.property("druzyna.kraj"), "kraj")
                ));

                SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
                fmt.setCalendar(termin);
                String dateFormatted = fmt.format(termin.getTime());
                List<String> kraje = cr.list();
                System.out.println("(Kryterialne) W terminie " + dateFormatted + " spotkały się " + kraje.get(0) + " oraz " + kraje.get(1));
            } catch (HibernateException e) {
                if (txn != null) {
                    txn.rollback();
                }
            } finally {
                session.close();
            }
        }
        System.out.println();
    }

    private static void showStatystykiDlaMeczuMniejszeNizCriteria(GregorianCalendar termin, int max) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Transaction txn = session.beginTransaction();
            try {
                Criteria cr = session.createCriteria(Statystyki.class, "statystyki");
                cr.createAlias("statystyki.mecz", "mecz");
                cr.createAlias("statystyki.rodzajStatystyki", "rodzajStatystyki");

                cr.setProjection(Projections.distinct(Projections.projectionList()
                        .add(Projections.property("statystyki.wartosc"), "wartosc")
                        .add(Projections.property("rodzajStatystyki.opis"), "opis")));

                cr.add(Restrictions.eq("mecz.termin", termin));
                cr.add(Restrictions.lt("statystyki.wartosc", max));

                SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
                fmt.setCalendar(termin);
                String dateFormatted = fmt.format(termin.getTime());
                List<Object[]> kk = cr.list();
                System.out.println("(Kryterialne) W terminie " + dateFormatted + " statystyki o wartosci mniejszej niz " + Integer.toString(max) + " to:");
                for (Object[] result : kk) {
                    Integer wartosc = (Integer) result[0];
                    String opis = (String) result[1];
                    System.out.println(" - o wartości " + wartosc + " o opisie \"" + opis + "\"");
                }

            } catch (HibernateException e) {
                if (txn != null) {
                    txn.rollback();
                }
            } finally {
                session.close();
            }
        }
        System.out.println();
    }
}
