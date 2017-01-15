package com.currency;

import com.entity.Currency;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ExchangeApplication {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.currency_exchange_jar_0.0.1-SNAPSHOTPU");

    private EntityManager getEntityManger() {
        return emf.createEntityManager();
    }
    
    @GetMapping("/v1/value")
    public String index(@RequestParam("date") String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("dd.MM.yyyy");
        Date date = null;
        try {
            date = (Date) dateFormat.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(ExchangeApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        EntityManager em = getEntityManger();
        List<Currency> result = em.createNamedQuery("Currency.findByExchangeDate", Currency.class).setParameter("exchangeDate", date).getResultList();
        return result.toString();
    }

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApplication.class, args);
	}
}
