package com.example.springdatademo.repository;

import com.example.springdatademo.model.Address;
import com.example.springdatademo.model.Course;
import com.example.springdatademo.model.Student;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class StudentSpecification {

    public static Specification<Student> hasGPAMoreThan(Integer gpa){
        return new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThan(root.get("gpa"),gpa);
            }
        };
    }
    public static Specification<Student> hasCourseAsEAandLiveATNY(){
        return (root, query, criteriaBuilder) -> {
            Join<Student, Course> studentCourseJoin = root.join("enrolCourses",JoinType.INNER);
            Join<Student, Address> addressStudentJoin = root.join("address",JoinType.INNER);
            return criteriaBuilder.and(
                    criteriaBuilder.equal(studentCourseJoin.get("courseCode"),"EA"),
                    criteriaBuilder.equal(addressStudentJoin.get("state"),"NY"));
        };
    }

//    Can't do in this way because we can't change root it hit cross join on spring data jpa
//    public static Specification<Student> hasCourseAsEAAndLiveATNY(){
//        return (root,query,criteriaBuilder)->{
//            Root<Course> courseRoot = query.from(Course.class);
//            Join<Course,Student> courseStudentJoin = courseRoot.join("enrolStudents");
//            Join<Student,Address> studentAddressJoin = courseStudentJoin.join("address",JoinType.INNER);
//            return criteriaBuilder.and(
//                    return criteriaBuilder.equal(courseRoot.get("courseCode"),"EA");
//                    criteriaBuilder.equal(courseStudentJoin.get("address").get("state"),"NY")
//            );
//        };
//    }
//


}
