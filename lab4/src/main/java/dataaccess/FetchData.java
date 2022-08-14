package dataaccess;

import entity.*;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class FetchData {
    static EntityManager em = DatabaseManager.getDBbConnection();

    /*
    1- Write a named query to return all books for a students with gpa >= 3.0.
    */
    public void getAllBookByNameQuery() {
        /* Pessimistic locking require to be enclosed in transaction*/
        EntityTransaction et = em.getTransaction();
        et.begin();
        String strQuery = "SELECT b FROM Book b WHERE b.student.gpa >= :gpa";
        Query bookQuery = em.createNamedQuery("Book.findStudentByGpa", Book.class);
        bookQuery.setParameter("gpa", 3.0);
        List<Book> bookList = bookQuery.getResultList();
        System.out.println("1- Write a named query to return all books for a students with gpa >= 3.0.");
        System.out.println(bookList);
        et.commit();

    }

    //2- Write a native query to return all book with >= 100 pages for students with gpa >= 3.0.
    public void getAllBookByNativeQuery() {
        String strQuery = "SELECT * FROM BOOK B JOIN STUDENT S ON B.STUDENT_ID = S.ID WHERE B.PAGES >= ?page AND S.GPA >= ?gpa";
        Query bookQuery = em.createNativeQuery(strQuery, Book.class);
        bookQuery.setParameter("page", 100);
        bookQuery.setParameter("gpa", 3.0);
        List<Book> bookList = bookQuery.getResultList();
        System.out.println("2- Write a native query to return all book with >= 100 pages for students with gpa >= 3.0");
        System.out.println(bookList);

    }

    //3- Write a criteria query to find the book with pages more than or equal to 120 pages and belonging to students with gpa >= 3.0
    // and written by an Author living in Iowa, and the book is published by a publisher with more than 100 employees.
    public void getAllBookByCriteriaQuery() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> bookRoot = criteriaQuery.from(Book.class);
//         criteriaQuery.select(bookRoot);
        // select ? from book      inner join student
        // inner join author
        // inner join publisher
        // inner join address where book.pages >= 120 and student.gpa >=3.0 and
        //address.state = "Iowa" and publisher.numberOfEmployees> 100;

        Join<Book, Student> bookStudentJoin = bookRoot.join("student");
        Join<Book, Author> bookAuthorJoin = bookRoot.join("author");
        Join<Book, Publisher> bookPublisherJoin = bookRoot.join("publisher");
        Join<Author, Address> addressAuthorJoin = bookAuthorJoin.join("address");
        criteriaQuery.select(bookRoot)
                .where(
                        criteriaBuilder.and(
                                criteriaBuilder.ge(bookRoot.get("pages"), 120), // book pages >=120,
                                criteriaBuilder.ge(bookStudentJoin.get("gpa"), 3.0), // student gpa > =3.0 (take this from join)
                                criteriaBuilder.equal(addressAuthorJoin.get("state"), "Iowa"), // author.address = "Iowa"
                                criteriaBuilder.gt(bookPublisherJoin.get("numberOfEmployees"), 100) // publisher.numberOfEmployees > 100;
                        )
                );
        Query query = em.createQuery(criteriaQuery);
        List<Book> bookList = query.getResultList();
        System.out.println("3 Write a criteria query to find the book");
        System.out.println(bookList);

    }
    //4- Enable optimistic locking on Student entity.
    //5- Enable pessimistic locking on the the named query in part 1.
}
