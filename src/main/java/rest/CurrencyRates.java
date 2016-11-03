package rest;

import com.google.gson.Gson;
import facades.CurrencyFacade;
import java.util.Date;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Michael
 */
@Path("/currency")
@RolesAllowed("User")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CurrencyRates {

    @GET
    public Object getCurrencyRates() {
        
        CurrencyFacade currencyFacade = new CurrencyFacade();

        List<entity.CurrencyRates> dailyRates = currencyFacade.getDaílyCurrencyRates(new Date());

        return new Gson().toJson(dailyRates);
        
    }
    
}