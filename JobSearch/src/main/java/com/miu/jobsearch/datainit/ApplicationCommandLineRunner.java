package com.miu.jobsearch.datainit;

import com.miu.jobsearch.entities.*;
import com.miu.jobsearch.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@Transactional
public class ApplicationCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private InterviewRepository interviewRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {

        Client client1 = new Client("Morgan Stanley","dedicated to local and global communities since 1935", "Do the right thing",
                "https://www.morganstanley.com/");
        Client client2 = new Client("Google","American multinational technology company", "provide google search",
                "https://www.google.com/");
        List<Client> clientList1 = Arrays.asList(client1,client2);
        Recruiter recruiter1 = new Recruiter("Synechron");
        recruiter1.setClients(clientList1);

        Client client4 = new Client("Morgan Stanley","online shopping and cloud provider", "online shopping",
                "https://www.amazon.com/");
        Client client5 = new Client("Google","Social media companu", "social media",
                "https://www.facebook.com/");
        List<Client> clientList2 = Arrays.asList(client4,client5);

        Recruiter recruiter2 = new Recruiter("AmazingRecruiter");
        recruiter2.setClients(clientList2);

        Job job1 = new Job("Software",90000,recruiter1);
        Job job2 = new Job("Application",70000,recruiter2);
        Job job3 = new Job("Analyst",100000,client1);
        Job job4 = new Job("Architect",150000,client2);
        Job job6 = new Job("ScrumMaster",130000,client4);
        Job job7 = new Job("ProjectManager",160000,client5);

        Skill skill1 = new Skill("frontend", 2, "Design and implementation of UI",
                "Angular",job1);
        Skill skill2 = new Skill("frontend", 3, "Design and implementation of UI",
                "React",job2);
        Skill skill3 = new Skill("frontend", 4, "Design and implementation of UI",
                "javascript",job3);
        Skill skill4 = new Skill("backend", 3, "Design and implementation of UI",
                "Java",job4);
        Skill skill6 = new Skill("Management", 5, "Design and implementation of UI",
                "Agile",job6);
        Skill skill7 = new Skill("backend", 4, "Design and implementation of UI",
                "dot net",job7);
        Application application = new Application(LocalDate.now(),1,job1);
        ScreeningInterview screeningInterview = new ScreeningInterview(LocalDate.now(),"98765432","John@miu.com",application,"John","Pass");

        Address address1 = new Address("street","chicago","illoinis","1234",recruiter1);
        Address address2 = new Address("street2","texas","texas","1234",recruiter2);

        companyRepository.saveAll(clientList1);
        companyRepository.saveAll(clientList2);
        companyRepository.save(recruiter1);
        companyRepository.save(recruiter2);
        jobRepository.save(job1);
        jobRepository.save(job2);
        skillRepository.save(skill1);
        skillRepository.save(skill2);
        applicationRepository.save(application);
        interviewRepository.save(screeningInterview);
        addressRepository.save(address1);
        addressRepository.save(address2);

    }
}
