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
    public String index(
            @RequestParam("cc") String cc,
            @RequestParam(value = "from", required = false) String fromDate,
            @RequestParam(value = "to", required = false) String toDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("dd.MM.yyyy");
        if (fromDate == null || toDate == null) {
            EntityManager em = getEntityManger();
            List<Currency> result = null;
            try {
                result = em.createNamedQuery("Currency.findByCc", Currency.class).
                        setParameter("cc", cc).
                        setParameter("startDate", dateFormat.parse("01.01.1996")).
                        setParameter("endDate", new Date()).getResultList();
            } catch (ParseException ex) {
                Logger.getLogger(ExchangeApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result.toString();
        } else {

            Date startDate = null;
            Date endDate = null;
            try {
                startDate = (Date) dateFormat.parse(fromDate);
                endDate = (Date) dateFormat.parse(toDate);

            } catch (ParseException ex) {
                Logger.getLogger(ExchangeApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
            EntityManager em = getEntityManger();
            List<Currency> result = em.createNamedQuery("Currency.findByCc", Currency.class).
                    setParameter("cc", cc).
                    setParameter("startDate", startDate).
                    setParameter("endDate", endDate).getResultList();
            return result.toString();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ExchangeApplication.class, args);
    }
}
