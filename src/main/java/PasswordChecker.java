import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {
    private static final Logger logger = LogManager.getLogger(PasswordChecker.class.getName());

    public static boolean hasSpecial(String password)//method to check special characters
    {
        Pattern sPattern = Pattern.compile("[a-zA-Z0-9]*"); //regex pattern
        Matcher aMatcher = sPattern.matcher(password);

        if (!aMatcher.matches())//checks for special character in string
        {
            return true;
        }
        else
        {
            System.out.println("password should have at least one special character");
            return false;
        }
    }

    public static boolean passwordIsValid(String password)
    {
            if (password != " ")//checks for empty string
            {
                if(password.length() > 7)//checks for length
                {
                    logger.info("length is ok");

                    if(passwordIsOk(password)) //meets at least 3 conditions
                    {
                        logger.info("Password meets at least 3 conditions");

                        if (hasSpecial(password)) //check special character
                        {
                            logger.info("password is strong and valid!!");
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    System.out.println("password should be longer than 8 characters");
                    return false;
                }
            }
            else
            {
                System.out.println("Password should exist");
                return false;
            }
    }

    //method checks if password meets at least 3 conditions
    public static boolean passwordIsOk(String password)
    {
        boolean hasNum = false, hasCap = false, hasLow = false;
        char c;
        int condition = 0;
        for (int i = 0; i < password.length(); i++)
        {
            c = password.charAt(i);
            if(Character.isDigit(c)) //checks for digits
            {
                hasNum = true;
            }
            if (Character.isUpperCase(c)) //checks for upper case
            {
                hasCap = true;
            }
            if (Character.isLowerCase(c)) //checks for lower case
            {
                hasLow = true;
            }
            if(hasNum && hasCap && hasLow) //checks for all three conditions
            {
                logger.debug("User password is ok");
                return true;
            }
        }
        //outputs depending on condition not met
        if(hasNum == false)
        {
            logger.error("password should have at least one digit");
        }
        if(hasLow == false)
        {
            logger.error("password should have at least one lower case letter");
        }
        if(hasCap == false)
        {
            logger.error("password should have at least one upper case letter");
        }

        logger.error("User password is not ok");
        return false;
    }
}
