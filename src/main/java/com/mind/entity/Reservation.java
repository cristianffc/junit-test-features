package com.mind.entity;

public class Reservation {

    private String personName;
    private Integer numberOfDays;

    public Reservation(String personName, Integer numberOfDays) {
        this.personName = personName;
        this.numberOfDays = numberOfDays;
    }

    public static class builder {
        private String personName;
        private Integer numberOfDays;

        public builder withPersonName(String personName) {
            this.personName = personName;
            return this;
        }

        public builder withNumberOfDays(Integer numberOfDays) {
            this.numberOfDays = numberOfDays;
            return this;
        }

        public Reservation build() {
            return new Reservation(personName, numberOfDays);
        }
    }
}
