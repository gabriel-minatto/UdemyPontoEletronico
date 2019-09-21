package udemy.spring.electronicpoint.api.utils;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;

@NoArgsConstructor
public class PasswordUtils {

    private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);

    /**
     * Generates as hash using BCrypt.
     *
     * @param password The password seed to generate the hash
     * @return String
     */
    public static String gerarBCrypt(String password) {
        if (StringUtils.isEmpty(password)) {
            return password;
        }

        log.info("Generating hash with BCrypt.");
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.encode(password);
    }

}