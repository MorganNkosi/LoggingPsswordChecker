import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {
    private static final Logger logger = LogManager.getLogger(PasswordChecker.class.getName());

    public static void main(String[] args)
    {
        String pass = "Helloworld@";
        logger.info(passwordIsValid(pass));
    }

    public static boolean hasSpecial(String password)
    {
        Pattern sPattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher aMatcher = sPattern.matcher(password);

        if (!aMatcher.matches())
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
            if (password != " ")
            {
                if(password.length() > 7)
                {
                    logger.info("length is ok");

                    if(passwordIsOk(password))
                    {
                        logger.info("Password meets at least 3 conditions");

                        if (hasSpecial(password))
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

    public static boolean passwordIsOk(String password)
    {
        boolean hasNum = false, hasCap = false, hasLow = false;
        char c;
        int condition = 0;
        for (int i = 0; i < password.length(); i++)
        {
            c = password.charAt(i);
            if(Character.isDigit(c))
            {
                hasNum = true;
            }
            if (Character.isUpperCase(c))
            {
                hasCap = true;
            }
            if (Character.isLowerCase(c))
            {
                hasLow = true;
            }
            if(hasNum && hasCap && hasLow)
            {
                logger.debug("User password is ok");
                return true;
            }
        }
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
