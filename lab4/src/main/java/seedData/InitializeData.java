package seedData;

import dataaccess.DatabaseManager;
import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InitializeData {

    static EntityManager em = DatabaseManager.getDBbConnection();
    EntityTransaction et = em.getTransaction();

    public void loadData() {
        addAddress();
        addStudent();
        addAuthor();
        addPublisher();
        addBook();
        em.close();
    }

    public void addAddress() {
        et.begin();
        Address address = new Address();
        address.setCity("Fairfield");
        address.setState("Iowa");
        address.setZip("52257");
        address.setStreet("1000 N 4th Street");
        em.persist(address);

        Address address1 = new Address();
        address1.setCity("Ottuma");
        address1.setState("Iowa");
        address1.setZip("52257");
        address1.setStreet("1000 N 4th Street");
        em.persist(address1);

        Address address2 = new Address();
        address2.setCity("Texas");
        address2.setState("Texas");
        address2.setZip("52257");
        address2.setStreet("1000 N 4th Street");
        em.persist(address2);
        et.commit();
    }

    public void addStudent() {
        et.begin();
        Student student = new Student();
        student.setName("Jack");
        student.setGpa(3.4);
        em.persist(student);

        Student student1 = new Student();
        student1.setName("Micheal");
        student1.setGpa(2.8);
        em.persist(student1);

        Student student2 = new Student();
        student2.setName("omkar");
        student2.setGpa(3.9);
        em.persist(student2);
        et.commit();
    }

    public void addAuthor() {
        et.begin();
        Address address = em.find(Address.class, 1L);
        Author author = new Author();
        author.setName("Daniel");
        author.setAddress(address);
        em.persist(author);

        Address address1 = em.find(Address.class, 2L);
        Author author1 = new Author();
        author1.setName("Josh");
        author1.setAddress(address1);
        em.persist(author1);

        Address address2 = em.find(Address.class, 3L);
        Author author2 = new Author();
        author2.setName("Josh");
        author2.setAddress(address2);
        em.persist(author2);
        et.commit();

    }

    public void addPublisher() {
        et.begin();
        Publisher publisher = new Publisher();
        publisher.setName("Apress");
        publisher.setNumberOfEmployees(300);
        em.persist(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setName("TestPublisher");
        publisher1.setNumberOfEmployees(200);
        em.persist(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("StatePublisher");
        publisher2.setNumberOfEmployees(400);
        em.persist(publisher2);
        et.commit();
    }

    public void addBook() {
        et.begin();
        Book book = new Book();
        book.setTitle("Pro Spring");
        book.setPages(400);
        Student student = em.find(Student.class,1l);
        Author author = em.find(Author.class,1l);
        Publisher publisher = em.find(Publisher.class,1l);
        book.setStudent(student);
        book.setAuthor(author);
        book.setPublisher(publisher);
        em.persist(book);

        Book book1 = new Book();
        book1.setTitle("Spring 5");
        book1.setPages(198);
        Student student1 = em.find(Student.class,2l);
        Author author1 = em.find(Author.class,2l);
        Publisher publisher1 = em.find(Publisher.class,2l);
        book1.setStudent(student1);
        book1.setAuthor(author1);
        book1.setPublisher(publisher1);
        em.persist(book1);

        Book book2 = new Book();
        book2.setTitle("Pro JPA");
        book2.setPages(640);
        Student student2 = em.find(Student.class,3l);
        Author author2 = em.find(Author.class,3l);
        Publisher publisher2 = em.find(Publisher.class,3l);
        book2.setStudent(student2);
        book2.setAuthor(author2);
        book2.setPublisher(publisher2);
        em.persist(book2);
        et.commit();
    }

}
