
package facebook4;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.conf.ConfigurationBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Autorizacion {
    
    static Facebook facebook ;
    public static void autorizar(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
cb.setDebugEnabled(true)
  .setOAuthAppId("1708752362750702")
  .setOAuthAppSecret("acab787dfca5bc6f057dcc9864ad2987")
  .setOAuthAccessToken("EAAYSGemXQu4BAM9b0wUSiUZAqu39KZA3wzbG89Tk207ZBIRDjPp3cHCEoZCMJyPXRVjHJs5PHnuo4jJ7cYleYsDWnEzhSD1yVVAwZBZC9HZA0Ys0xmjyRnGwF7ZCRNZAVIZBJxsHSwbcYpJCZC9BUwmnWID0OkvCO2T6i5wpPdW3ipoHJb0ceceNnvWPdV8vD7EPKMZD")
  .setOAuthPermissions("email,publish_stream,publish_actions");
  FacebookFactory ff = new FacebookFactory(cb.build());
  facebook = ff.getInstance();


    }
    public static void postearMensaje(String mensaje){
        
        try {
            facebook.postStatusMessage(mensaje);
        } catch (FacebookException ex) {
            Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);
        }


        
    }
}
