package facebook4;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Autorizacion {

    static String mensaje;
    static Facebook facebook;

    public static void autorizar() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("1708752362750702")
                .setOAuthAppSecret("acab787dfca5bc6f057dcc9864ad2987")
                .setOAuthAccessToken("EAAYSGemXQu4BADMIrwTvb37e9qBEZCdM9FSXMJ5IV76PjzOTfGmqn64cOOV4faRxqJZAHv2cGE5BfuZAuxbNNcsSiYpZArEQS0tEhiZCi0QnJcuDYypMuY5BnxGbFZCkFF4YlIqfDzQnoTXirSS3wvAZBkUDSPo2UJ36iGrODdYD70uZANIck3mOFNUUZBW15u78ZD")
                .setOAuthPermissions("email,publish_stream,publish_actions,user_likes,manage_pages,read_stream");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();

    }
/**
 * postea un mensaje en tu muro
 * @param mensaje  contiene el mensaje a postear
 */
    public static void postearMensaje(String mensaje) {

        try {
            facebook.postStatusMessage(mensaje);
        } catch (FacebookException ex) {
            Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * busca los post a través de las palabras clave que introduzcamos
     *
     * @throws FacebookException
     */
    public static void buscarPost() throws FacebookException {
        ResponseList<Post> results = facebook.getPosts(JOptionPane.showInputDialog(null, "Introduce la palabra clave para buscar los post"));

        System.out.println(results.toString());
    }

    /**
     * para buscar feeds referentes a las palabras de búsqueda
     *
     * @throws FacebookException
     */
    public static void buscarFeed() throws FacebookException {
        ResponseList<Post> feed = facebook.getFeed(JOptionPane.showInputDialog("Introduce la palabra clave a buscar"));
        System.out.println(feed.toString());

    }

    /**
     * comenta una foto publicada en tu propio muro,el primer parámetro es el
     * ID,el segundo el comentario
     *
     * @throws FacebookException
     */
    public static void comentario() throws FacebookException {
        facebook.commentPhoto(JOptionPane.showInputDialog("Introduce el ID de la foto "), JOptionPane.showInputDialog(" Introduce el comentario  "));
    }

    /**
     * crea un nuevo post con imagen incluida
     *
     * @throws MalformedURLException
     * @throws FacebookException
     */
    public static void postPhoto() throws MalformedURLException, FacebookException {
        PostUpdate post = new PostUpdate(new URL("http://facebook4j.org"))
                .picture(new URL("http://facebook4j.org/images/hero.png"))
                .name("Facebook4J - A Java library for the Facebook Graph API")
                .caption("facebook4j.org")
                .description("Facebook4J is a Java library for the Facebook Graph API.");
        facebook.postFeed(post);
    }

}
