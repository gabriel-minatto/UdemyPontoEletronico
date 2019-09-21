package udemy.spring.electronicpoint.api.utils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;

@Slf4j
@NoArgsConstructor
public class PasswordUtils {

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