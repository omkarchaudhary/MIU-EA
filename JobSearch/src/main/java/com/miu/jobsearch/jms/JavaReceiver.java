package com.miu.jobsearch.jms;

import com.miu.jobsearch.entities.Client;
import com.miu.jobsearch.entities.Company;
import com.miu.jobsearch.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JavaReceiver {
    @Autowired
    private CompanyService companyService;

    @JmsListener(destination ="${springjms.queueName}" )
    public void receive(Client client){
        System.out.println("The received object -> "+ client);
        companyService.create(client);
    }
}
