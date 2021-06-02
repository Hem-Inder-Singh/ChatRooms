
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sendsms {
    public static String smstobesend(String phone,String ans){
        String s ="";
        System.out.println("@@"+ans);
        try {
            HttpResponse<String> httpresponse = Unirest.post("http://server1.vmm.education/VMMCloudMessaging/AWS_SMS_Sender")
                    .queryString("username","danishbhola")
                    .queryString("password","8THBFZ7K")
                    .queryString("message",ans)
                    .queryString("phone_numbers",phone)
                    .asString();
                    
            if(httpresponse.getStatus()==200)
            {
                //System.out.println(httpresponse.getBody());
               s =httpresponse.getBody();
                System.out.println(s);
            }
            else    //for status code other than 200, eg 404
            {
                System.out.println(httpresponse.getStatusText());   
            }
        } catch (UnirestException ex) {
            Logger.getLogger(Sendsms.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(""+ex.getMessage());
        }

        return s;
    }
    

    
}
