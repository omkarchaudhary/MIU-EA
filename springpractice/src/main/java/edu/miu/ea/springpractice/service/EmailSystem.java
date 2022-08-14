package edu.miu.ea.springpractice.service;

public class EmailSystem {

    DateService dateService;

    public EmailSystem() {
    }

    public EmailSystem(DateService dateService){
        this.dateService = dateService;
    }
    public void connectToMailServer() {
        System.out.println("Connecting to email server ...");
    }

    public void sendEmail() {
        if(!dateService.isTodayWeekend()) {
            System.out.println("Sending email ...");
        }
    }

    public DateService getDateService() {
        return dateService;
    }

    public void setDateService(DateService dateService) {
        this.dateService = dateService;
    }
}
