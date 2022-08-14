package entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

import static org.eclipse.persistence.expressions.ExpressionOperator.LocalTime;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("labDP");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction et = em.getTransaction();

    public static void main(String[] args) {
        initializeRecordToTable();
        getAllJobApplication();
        getAllInterviewsWithinWeek();
        getAllJobsByState();
        getAllSkillBySalary();
        getAllRecruiters();
    }
//1- Write a query to return all Jobs with an Application. (native query)
    public static void getAllJobApplication(){
        String strQuery = "SELECT * FROM JOB INNER JOIN APPLICATION ON JOB.ID = APPLICATION.JOB_ID";
        Query job = em.createNativeQuery(strQuery,Job.class);
        List<Job> jobList = job.getResultList();
        System.out.println(jobList);
    }

    //2- Write a query to return all Interviews within a week. (Dynamic query)
    public static void getAllInterviewsWithinWeek(){
        String strQuery = "SELECT  s FROM Interview s WHERE s.interviewDate between :weekStart and :weekEnd";
        TypedQuery<Interview> interviewQuery = em.createQuery(strQuery,Interview.class);

        LocalDate weekDate = LocalDate.of(2022, 07, 20);
        LocalDate startDayofWeek = weekDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDate endDayOfWeek = startDayofWeek.plusDays(7);
        interviewQuery.setParameter("weekStart", startDayofWeek);
        interviewQuery.setParameter("weekEnd", endDayOfWeek);

        List<Interview> interviewList = interviewQuery.getResultList();
        System.out.println(interviewList);
    }
    //3- Write a query to return all Jobs with Companies in a specific state (Named Query)
    public static void getAllJobsByState(){
        Query jobQUery = em.createNamedQuery("Job.findJobByState",Job.class);
        jobQUery.setParameter("state","Minnesota");
        List<Job> jobList = jobQUery.getResultList();
        System.out.println(jobList);
    }
    //4- Write a query to return all Skills for Jobs with salary > a certain amount and with a company in a specific state. (Criteria API)
    public  static void getAllSkillBySalary(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Skill> criteriaQuery = criteriaBuilder.createQuery(Skill.class);
        Root<Skill> rootSkill = criteriaQuery.from(Skill.class);
        criteriaQuery.select(rootSkill);
        Join<Skill,Job> joinJob = rootSkill.join("job");
        Predicate salaryCriteria = criteriaBuilder.ge(joinJob.get("salary"),100000);
        Join<Job,Company> joinCompany = joinJob.join("company");
        Predicate stateCritera = criteriaBuilder.equal(joinCompany.get("address"),"Minnesota");

        Predicate joinPredicate = criteriaBuilder.and(salaryCriteria,stateCritera);
        criteriaQuery.where(joinPredicate);
        TypedQuery<Skill> skillTypedQuery = em.createQuery(criteriaQuery);
        List<Skill> skillList = skillTypedQuery.getResultList();
        System.out.println(skillList);
    }
    //5- Write a query to return all Recruiters with Jobs paying more than a certain amount.
    public static void getAllRecruiters(){
        String stringQuery = "SELECT * from recruiter as r join company as c on r.ID = c.ID join job as j on j.COMPANY_ID = c.id where j.SALARY > 1000";
        Query query = em.createNativeQuery(stringQuery, Recruiter.class);
        List<Recruiter> recruiterList = query.getResultList();
        System.out.println(recruiterList);
    }
    //6- Write a query to return all Jobs with at least 2 interviews.
    public static void getAllJobAtLeastTwoInterviewDate(){

    }
    public static void initializeRecordToTable(){
        et.begin();
        Company company = new Company("JP Morgan","Texas");
        Company company1 = new Company("Cotiviti","Minnesota");
        em.persist(company);
        em.persist(company1);

        // Feeding Job data
        Job job = new Job();
        job.setTitle("Manager");
        job.setSalary(300000);
        job.setCompany(company);
        em.persist(job);

        Job job1 = new Job();
        job1.setTitle("Developer");
        job1.setSalary(200000);
        job1.setCompany(company1);
        em.persist(job1);

        // Feeding data to skill
        Skill skill = new Skill();
        skill.setName("Javascript");
        skill.setExperience(5);
        skill.setDescription("Must have 5 years experience in Javascript");
        skill.setLanguage("HTML, CSS, JQuery, ES2016");
        skill.setJob(job);
        em.persist(skill);

        Skill skill1 = new Skill();
        skill1.setName("Java");
        skill1.setExperience(5);
        skill1.setDescription("Must have 5 years experience in Java");
        skill1.setLanguage("Java EE, JPA, Spring");
        skill.setJob(job1);
        em.persist(skill1);

        //Feeding data to client
        Client client = new Client();
        client.setMission("Client1 Mission");
        client.setReason("Client1 Mission");
        client.setWebsite("Client1 Mission");
        Client client1 = new Client();
        client1.setMission("Client2 Mission");
        client1.setReason("Client2 Mission");
        client1.setWebsite("Client2 Mission");
        em.persist(client);
        em.persist(client1);

        // Recruiter
        Recruiter recruiter = new Recruiter();
        em.persist(recruiter);

        RecruiterClient recruiterClient = new RecruiterClient();
        recruiterClient.setRecruiter(recruiter);
        recruiterClient.setClient(client);
        em.persist(recruiterClient);

        RecruiterClient recruiterClient2 = new RecruiterClient();
        recruiterClient2.setRecruiter(recruiter);
        recruiterClient2.setClient(client1);
        em.persist(recruiterClient2);

        // Application data
        Application application = new Application();
        application.setApplicationDate(LocalDate.now());
        application.setResumeVersion("Resume1");
        application.setJob(job);
        em.persist(application);

        Application application1 = new Application();
        application1.setApplicationDate(LocalDate.now());
        application1.setResumeVersion("Resume2");
        application1.setJob(job1);
        em.persist(application1);

        // Screening Interview Data
        ScreeningInterview screeningInterview = new ScreeningInterview();
        screeningInterview.setName("Omkar");
        screeningInterview.setInterviewDate(LocalDate.now());
        screeningInterview.setResult("pass");
        screeningInterview.setEmail("omkar@gmail.com");
        screeningInterview.setPhoneNumber("9876554321");
        em.persist(screeningInterview);

        ScreeningInterview screeningInterview1 = new ScreeningInterview();
        screeningInterview1.setName("Shrawan");
        screeningInterview1.setInterviewDate(LocalDate.now());
        screeningInterview1.setResult("pass");
        screeningInterview1.setEmail("shrawan@gmail.com");
        screeningInterview1.setPhoneNumber("9876554321");
        em.persist(screeningInterview1);

        // Technical Interview
        TechnicalInterview technicalInterview = new TechnicalInterview();
        technicalInterview.setInterviewDate(LocalDate.now());
        technicalInterview.setEmail("omkar@gmail.com");
        technicalInterview.setPhoneNumber("9876554321");
        technicalInterview.setDuration(1);
        technicalInterview.setQuestions("JPA");
         em.persist(technicalInterview);

        TechnicalInterview technicalInterview1 = new TechnicalInterview();
        technicalInterview1.setInterviewDate(LocalDate.now());
        technicalInterview1.setEmail("shrawan@gmail.com");
        technicalInterview1.setPhoneNumber("9876554321");
        technicalInterview1.setDuration(1);
        technicalInterview1.setQuestions("Spring");
        em.persist(technicalInterview1);

        // HiringManagerInterview
        HiringManagerInterview hiringManagerInterview = new HiringManagerInterview();
        hiringManagerInterview.setInterviewDate(LocalDate.now());
        hiringManagerInterview.setEmail("omkar@gmail.com");
        hiringManagerInterview.setPhoneNumber("9876554321");
        hiringManagerInterview.setStartDate(LocalDate.of(2022,11,1));
        hiringManagerInterview.setTeamSize(10);
        em.persist(hiringManagerInterview);

        HiringManagerInterview hiringManagerInterview1 = new HiringManagerInterview();
        hiringManagerInterview1.setInterviewDate(LocalDate.now());
        hiringManagerInterview1.setEmail("shrawan@gmail.com");
        hiringManagerInterview1.setPhoneNumber("9876554321");
        hiringManagerInterview1.setStartDate(LocalDate.of(2022,10,1));
        hiringManagerInterview1.setTeamSize(12);
        em.persist(hiringManagerInterview1);

        et.commit();

    }

}
