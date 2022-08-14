import com.test.entity.*;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
    static EntityManager em = emf.createEntityManager();
    public static void main(String[] args) {
        Main main = new Main();
        main.initializedData();
        main.getPeopleByMoveName("The Matrix");
        main.updateQuery();
        main.moviesNameAfter1997AndActorFromCA("CA",1997);
        main.actorInGivenState("CA");
    }

    private void updateQuery(){
        EntityTransaction et = em.getTransaction();
        et.begin();
        String strQuery = "select p from Person p where p.name like '%Carrie%'";
        TypedQuery<Person> personTypedQuery = em.createQuery(strQuery,Person.class);
        Person person = personTypedQuery.getSingleResult();
        System.out.println("Age of Carrie");
        System.out.println(person.getName()+ " age is "+ person.getAge());
        person.setAge(55);
        System.out.println(person.getName()+ " updated age is "+ person.getAge());
        et.commit();
    }

    private void moviesNameAfter1997AndActorFromCA(String stateName,int year){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Movie> movieCriteriaQuery = criteriaBuilder.createQuery(Movie.class);
        Root<Movie> movieRoot = movieCriteriaQuery.from(Movie.class);
        Root<Person> rootPerson = movieCriteriaQuery.from(Person.class);
        Root<Actor> rootActor = criteriaBuilder.treat(rootPerson,Actor.class);
        Predicate statePredicate = criteriaBuilder.equal(rootActor.get("address").get("state"),stateName);
        Predicate yearPredicate = criteriaBuilder.greaterThan(movieRoot.get("year"),year);
        Predicate andPredicate = criteriaBuilder.and(statePredicate,yearPredicate);
        movieCriteriaQuery.where(andPredicate);

        TypedQuery<Movie> movieTypedQuery = em.createQuery(movieCriteriaQuery);
        List<Movie> movieList = movieTypedQuery.getResultList();
        System.out.println("Movie List");
        movieList.forEach(System.out::println);
    }

    private void actorInGivenState(String stateName){
        TypedQuery<Person> namedQuery = em.createNamedQuery("Person.findAllActorInAState", Person.class);

        namedQuery.setParameter("state",stateName);
        namedQuery.setParameter("actor",Actor.class);
        List<Person> personList = namedQuery.getResultList();
        System.out.println("All actors in state CA::");
        personList.forEach(System.out::println);
    }
    private void getPeopleByMoveName(String movieName){
       TypedQuery<Person> personTypedQuery = em.createNamedQuery("Movie.findPersonsByMovieName",Person.class);
       personTypedQuery.setParameter("title",movieName);
        List<Person> personList = personTypedQuery.getResultList();
        System.out.println("All Persons in movie the matrix");
        for(Person person : personList){
            System.out.println(person);
        }
    }
    private void initializedData() {
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();

        Address keanuAddress = new Address();
        keanuAddress.setStreet("9601 Wilshire Blvd");
        keanuAddress.setCity("Beverly Hills");
        keanuAddress.setState("CA");

        //keanuAddress.setPerson(keanu);
        em.persist(keanuAddress);
        
        Address carrieAddress = new Address();
        carrieAddress.setStreet("9601 Wilshire Blvd");
        carrieAddress.setCity("Beverly Hills");
        carrieAddress.setState("CA");
        //carrieAddress.setPerson(carrie);
        em.persist(carrieAddress);

        Address kateAddress = new Address();
        kateAddress.setStreet("United Agents Ltd");
        kateAddress.setCity("London");
        kateAddress.setState("England");
        //kateAddress.setPerson(kate);
        em.persist(kateAddress);

        Address leonardoAddress = new Address();
        leonardoAddress.setStreet("2000 Avenue Of The Stars");
        leonardoAddress.setCity("Century City");
        leonardoAddress.setState("CA");
        //leonardoAddress.setPerson(leonardo);
        em.persist(leonardoAddress);

        Address sheaAddress = new Address();
        sheaAddress.setStreet("1625 Wilshire Blvd");
        sheaAddress.setCity("Los Angeles");
        sheaAddress.setState("CA");
        //sheaAddress.setPerson(shea);
        em.persist(sheaAddress);

        Address bobAddress = new Address();
        bobAddress.setStreet("10207 Lakewood Blvd");
        bobAddress.setCity("Downey");
        bobAddress.setState("CA");
        //bobAddress.setPerson(bob);
        em.persist(bobAddress);

        Actor keanu = new Actor();
        keanu.setName("Keanu Reeves");
        keanu.setAge(57);
        keanu.setGender(Gender.MALE);
        keanu.setExperience(38);
        keanu.setAddress(keanuAddress);
        em.persist(keanu);

        Actor carrie = new Actor();
        carrie.setName("Carrie-Anne Moss");
        carrie.setAge(50);
        carrie.setGender(Gender.FEMALE);
        carrie.setExperience(33);
        carrie.setAddress(carrieAddress);
        em.persist(carrie);

        Actor kate = new Actor();
        kate.setName("Kate Winslet");
        kate.setAge(46);
        kate.setGender(Gender.FEMALE);
        kate.setExperience(31);
        kate.setAddress(kateAddress);
        em.persist(kate);

        Actor leonardo = new Actor();
        leonardo.setName("Leonardo DiCaprio");
        leonardo.setAge(47);
        leonardo.setGender(Gender.MALE);
        leonardo.setExperience(42);
        leonardo.setAddress(leonardoAddress);
        em.persist(leonardo);

        Stunt shea = new Stunt();
        shea.setName("Shea Adams");
        shea.setAge(35);
        shea.setHeight(5.6f);
        shea.setWeight(150f);
        shea.setAddress(sheaAddress);
        em.persist(shea);

        Stunt bob = new Stunt();
        bob.setName("Bob Bowles");
        bob.setAge(28);
        bob.setHeight(5.5f);
        bob.setWeight(120f);
        bob.setAddress(bobAddress);
        em.persist(bob);

        Movie theMatrix = new Movie();
        theMatrix.setTitle("The Matrix");
        theMatrix.setYear(1999);
        List<Person> matrixMoviePerson = new ArrayList<>();
        matrixMoviePerson.add(keanu);
        matrixMoviePerson.add(carrie);
        matrixMoviePerson.add(shea);
        theMatrix.setPerson(matrixMoviePerson);
        em.persist(theMatrix);

        Movie titanic = new Movie();
        titanic.setTitle("Titanic");
        titanic.setYear(1997);
        List<Person> titanicMoviePerson = new ArrayList<>();
        titanicMoviePerson.add(kate);
        titanicMoviePerson.add(leonardo);
        titanicMoviePerson.add(bob);
        titanic.setPerson(titanicMoviePerson);
        em.persist(titanic);

        entityTransaction.commit();
    }
}
