package task1;

import lombok.Data;

//@Builder
@Data
public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public static class PersonBuilder{
        private Person person;

        public PersonBuilder(){
            person = new Person();
        }

        public Person build(){
            return person;
        }

        public PersonBuilder withFirstName(String firstName){
            person.setFirstName(firstName);
            return this;
        }

        public PersonBuilder withLastName(String lastName){
            person.setLastName(lastName);
            return this;
        }

        public PersonBuilder withMiddleName(String middleName){
            person.setMiddleName(middleName);
            return this;
        }

        public PersonBuilder withCountry(String country){
            person.setCountry(country);
            return this;
        }

        public PersonBuilder withAddress(String address){
            person.setAddress(address);
            return this;
        }

        public PersonBuilder withPhone(String phone){
            person.setPhone(phone);
            return this;
        }

        public PersonBuilder withGender(String gender){
            person.setGender(gender);
            return this;
        }

        public PersonBuilder withAge(int age){
            person.setAge(age);
            return this;
        }
    }
}
