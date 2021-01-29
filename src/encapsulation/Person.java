package encapsulation;

import java.util.*; //Imports all util-modules

public class Person { //Create a class named Person
    private String name, first_name, last_name, email; //All Strings
    private char gender; //Gender char M,F
    private Date birth; //Date-variable
    private String instructions = //Instruction on the class, run this in the start of the main loop
            """

                    ----------------- Instruction for Person Class -----------------

                    Name: Must contain a first name and a second name
                     atleast two character ∈[A-Å] with a whitespace to separate the names
                    Email: Must contain a domain name, valid country code, your first name and your last name
                    Birthday: Must be a date before NOW
                    Gender: Given as a single character:
                     F for female, M for male and /0 for null""";



    private boolean nameValidation(String n){ //Boolean function that returns true if the requirements are met
        if(n.contains(" ")) { //The whitespace between the surname and lastname
            String[] split = n.split(" "); //Makes a list, and then splits the String
            String sur = split[0]; //Assigns the surname to a local variable
            String last = split[1]; //Assigns the lastname to a local variable

            //Checks if the surname contains the letters A-Å with regex matched
            return sur.matches("[a-zA-ZæøåÆØÅ]+") && last.matches("[a-zA-ZæøåÆØÅ]+") && sur.length() >= 2 && last.length() >= 2 && split.length == 2;
        }
        else throw new IllegalArgumentException("feil");
    }


    private boolean mailValidate(String email) { //Function that validates the email
        String[] split = email.split("@"); //Splits the mail-address
        if(split.length!=2){ //If the length is not 2 elements on both side of @
            throw new IllegalArgumentException("Email must contain 2 parts before and after '@'");
        }
        String[] split2=email.split("\\W");
        String[] countryCode = Locale.getISOCountries(); //stores the countrycodes to a list
        if(split2.length !=4){ //If theres not 4 elements in total
            throw new IllegalArgumentException("Does not contain enough elements");
        }

        //If not the email contains the surname and lastname it will throw an error
        if(!(email.toLowerCase().contains(this.first_name.toLowerCase()) && email.toLowerCase().contains(this.last_name.toLowerCase()))){
            throw new IllegalArgumentException("The name is not correct");
        }
        //If the email-address does not contain a valid country code there will be an error
        else if(!Arrays.asList(countryCode).contains(split2[3].toUpperCase())){
            throw new IllegalArgumentException("Invalid domain");
        }

        else{return true;}

    }



    //Functions to set the name, email, birthday and gender.

    void setName(String name){ //Function that assigns the variables the parameters
        if(nameValidation(name)){ //If name is valid
            this.name=name; //Assigns the name-variable the value of the parameter
            this.first_name = name.split(" ")[0]; //Splits the name from space to left and assigns it to surname
            this.last_name = name.split(" ")[1]; //Splits the name from space to right and assigns it to lastname
        }
        else {
            throw new IllegalArgumentException("Not a valid name, read instructions"); //Error
        }
    }

    void setEmail(String e){ //Sets the email-variable equal to the parameter e
        if(mailValidate(e)){ //If valid email ->
            this.email = e;//set variable
        }
        else {
            throw new IllegalArgumentException("Invalid email, please read the instructions"); //Else -> error
        }
    }

    void setBirthday(Date date){ //Function that both contains validation and setting the values for birthday
        if(date.before(new Date())){ //if date.before today
            this.birth = date;
        }
        else{
            throw new IllegalArgumentException("Invalid birthday, please read the instructions");
        }
    }

    void setGender(char g){ //Function that both contains validation and setting the values for gender
        if(Character.toString(g).matches("[FM]")||Character.toString(g).equals("\0")){ //If input contains F, M or null
            this.gender = g;
        }
        else {
            throw new IllegalArgumentException("Invalid gender, please read the instructions");
        }
    }



    //Functions that gets the value for each respective variable using return and this.

    String getName(){
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    public Date getBirthday() {
        return this.birth;
    }
    public char getGender() {
        return this.gender;
    }


    //run_func

    public static void main(String[] args){
        Person p = new Person();
        System.out.println(p.instructions);
    }


}