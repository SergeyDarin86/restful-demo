package com.example.demo.service;


public interface SendPersonalInformationService {
    ResponseForSending getSendingPageResponse(String url);
    ResponseForSending getTrueResult();
    ResponseForSending getFalseResultForIndexPage();
}
