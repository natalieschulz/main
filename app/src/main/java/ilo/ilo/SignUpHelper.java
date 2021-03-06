package ilo.ilo;


public class SignUpHelper {

    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mUserName;
    private String mPassword;
    private String mPasswordConfirm;
    private String mDob;

    public SignUpHelper(String email, String user, String pass, String confirmPassword, String dob, String first, String last){
        this.mFirstName = first;
        this.mLastName = last;
        this.mEmail = email;
        this.mPassword = pass;
        this.mUserName = user;
        this.mPasswordConfirm = confirmPassword;
        this.mDob = dob;
    }

    private boolean isValidFirstName(){
        // simple check to make sure username is valid
        boolean validLength = mFirstName.length()  >= 2 && mFirstName.length() <= 40;

        return validLength;
    }

    private boolean isValidLastName() {
        // simple check to make sure username is valid
        boolean validLength = mLastName.length() >= 2 && mLastName.length() <= 40;

        return validLength;
    }

    private boolean isValidEmail(){
        //check for valid email address
        String pattern = "\"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$\"";
        boolean validEmail = mEmail.matches(pattern);
        boolean validLength = mEmail.length() > 6 && mEmail.length() <= 40;

        return validEmail && validLength;
    }


    private boolean isValidUserName(){
        // simple check to make sure username is valid
        boolean validLength = mUserName.length()  > 5 && mUserName.length() <= 40;

        return validLength;
    }

    private  boolean isValidPassword(){
        // simple check for password length
        boolean validLength = mPassword.length() > 8 && mPassword.length() <= 40;

        return validLength;
    }

    private boolean isConfirmed(){
        //Checking the password entered, and confirmation pass are equal
        return mPassword.equals(mPasswordConfirm);
    }

    private boolean isValidDob(){
        return false;
    }

    public  boolean isValidateForm(){
        // TODO: figure out an efficient ordering of these checks
        // TODO: see if can execute checks in parallel
        return isValidFirstName() && isValidLastName() && isValidEmail()
                && isValidPassword() && isValidUserName() && isValidDob()
                && isConfirmed();
    }

    //
    // below are functions to be called
    // after isValidForm() returns true

    public String hashPassword(){
        //TODO Learn more about hashing
        String hashedPass = ""+mPassword.hashCode();
        return hashedPass;
    }

}
