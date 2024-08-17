package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PostPersInfoImpl implements SendPersonalInformationService{

    ResponseForSending response;

    @Override
    public ResponseForSending getSendingPageResponse(String url) {
        if (url.isEmpty()){
            return getFalseResultForIndexPage();
        } else {
            return getTrueResult();
        }
    }

    @Override
    public ResponseForSending getTrueResult() {
        response = new ResponseForSending(true);
        return response;
    }

    @Override
    public ResponseForSending getFalseResultForIndexPage() {
        String error = "Данная страница находится за пределами сайтов";
        response = new ResponseForSending(false,error);
        return response;
    }



}
