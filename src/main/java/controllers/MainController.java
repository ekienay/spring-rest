package controllers;

import model.Payment;
import model.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class MainController {

    private final String sharedCode = "SHARED-CODE";

    private static final String successStatus = "accept";
    private static final String failedStatus = "denied";

    private static final Integer acceptCode = 101;
    private static final Integer failedCode = 102;

    @GetMapping
    public Response showStatus(){
        return new Response(successStatus,1);
    }
    @PostMapping
    public Response pay(@RequestParam(name = "key") String key, @RequestBody Payment payment){

        final Response response;

        if (sharedCode.equalsIgnoreCase(key)){
            int userId = payment.getUserId();
            String productId = payment.getProductId();
            double sale = payment.getSale();

            response = new Response(successStatus,acceptCode);
        }else {
            response = new Response(failedStatus,failedCode);
        }
        return response;
    }
}
