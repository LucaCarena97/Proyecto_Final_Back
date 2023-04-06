/*package com.example.clinicaOdontologica.user;

import com.example.clinicaOdontologica.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private IUserRepository userRepository;

    @Autowired
    public DataLoader(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String contrasena1 = passwordEncoder.encode("contrasena1");
        String contrasena2 = passwordEncoder.encode("contrasena2");

        userRepository.save(new AppUser("Luca", "Luca97", "luca@gmail.com", contrasena1, AppUserRol.ADMIN));
        userRepository.save(new AppUser("Luca2", "Luca98", "luca1@gmail.com", contrasena2, AppUserRol.USER));
    }
}
*/