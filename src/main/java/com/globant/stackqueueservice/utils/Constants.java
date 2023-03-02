package com.globant.stackqueueservice.utils;

public class Constants {
    public static String INVALID_DATA = "Invalid data";
    public static String HANDLE_ERRORS = "Response error";
    public static String VALIDATION_FAILED = "Validation failed";
    public enum ResponseConstant{
        SUCCESS("Success"),
        FAILURE("Failure");

        private String description;

        ResponseConstant(final String description){
            this.description = description;
        }

        public String getDescription(){
            return this.description;
        }
    }
}
