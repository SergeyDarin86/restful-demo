package com.example.demo.service;

import lombok.Data;

@Data
public class ResponseForSending {
        private boolean result;
        private String error;

        public ResponseForSending(boolean result) {
            this.result = result;
        }

        public ResponseForSending(boolean result, String error) {
            this.result = result;
            this.error = error;
        }
    }
