package edu.miu.cs.cs425.webapp.homib_tcms;

import edu.miu.cs.cs425.webapp.homib_tcms.module.Credential;
import edu.miu.cs.cs425.webapp.homib_tcms.module.Load;
import edu.miu.cs.cs425.webapp.homib_tcms.module.Role;
import edu.miu.cs.cs425.webapp.homib_tcms.module.User;
import edu.miu.cs.cs425.webapp.homib_tcms.service.CredentialService;
import edu.miu.cs.cs425.webapp.homib_tcms.service.LoadService;
import edu.miu.cs.cs425.webapp.homib_tcms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class HomibTcmsApplication implements CommandLineRunner {

    private final LoadService loadService;
    @Autowired
    public HomibTcmsApplication(LoadService loadService) {
        this.loadService = loadService;
    }
    @Autowired
    private CredentialService credentialService;
    public static void main(String[] args) {
        SpringApplication.run(HomibTcmsApplication.class, args);
    }
        @Autowired
        private RoleService roleService;



    @Override
    public void run(String... args) throws Exception {
        Load load1 = new Load(LocalDate.of(2020,8,05),
                "9:00 pm",20000.50f,2500.50f,"San Jose",
                "Dallas", "Dry");
        Load load2 = new Load(LocalDate.of(2020,10,11),
                "9:00 pm",24000.50f,4000.00f,"New York",
                "Dallas", "Dry");
        Load load3 = new Load(LocalDate.of(2020,10,15),
                "9:00 pm",23000.50f,4000.00f,"",
                "San Jose", "Dry");
        Load load4 = new Load(LocalDate.of(2020,8,15),
                "9:00 pm",25000.50f,5000.00f,"Dallas",
                "Iowa", "Dry");

//        Load savedload1 = loadService.saveLoads(load1);
//        Load savedload2 = loadService.saveLoads(load2);
//        Load savedload3 = loadService.saveLoads(load3);
//        Load savedload4 = loadService.saveLoads(load4);
//
//        Credential admin1 = new Credential("robel921","test123");
//        Credential driver1 = new Credential("chapi123", "test1234");
//
//        Credential savedAdmin1 = credentialService.save(admin1);
//        Credential savedDriver1 = credentialService.save(driver1);
//
//        Role admin = new Role("ADMIN");
//        Role driver = new Role("DRIVER");
//
//        Role savedAdmin = roleService.save(admin);
//        Role savedDriver = roleService.save(driver);



//        User admin1 = new User("12345","luwam", "asmerom","Kflit",
//                LocalDate.of(1995,9,23), LocalDate.of(2019,12,12),"408-564-3129"
//        , "luwam@gamil.com", savedAdmin , savedAdmin1);

    }

}
