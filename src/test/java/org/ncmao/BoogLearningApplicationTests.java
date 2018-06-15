package org.ncmao;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.ncmao.domain.User;


//@RunWith(SpringRunner.class)
//@SpringBootTest
public class BoogLearningApplicationTests {


    @Test
    public void contextLoads() {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        System.out.println(kc.verify().getMessages().toString());
        execute(kc);


    }

    public void execute(KieContainer kc) {
        KieSession kieSession = kc.newKieSession("rule1KS");
        User user = new User();
        user.setMoney(100);
        kieSession.insert(user);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
