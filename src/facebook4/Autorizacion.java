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
/**
 * configuración para la app en la que introducimos los diferentes tokkens de acceso
 */
    public static void autorizar() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("1708752362750702")
                .setOAuthAppSecret("acab787dfca5bc6f057dcc9864ad2987")
                .setOAuthAccessToken("EAAYSGemXQu4BABJ42eik5Y90cvBKKvaN3IAlcvlnbzql4o3hMdxTQyqVRPflXu57D115xqkVrXRTR6zbPyUiSbXfVO1qVy2tlyiIkr27ZCrjZA7QYu9kXSHLcyZA8CgN8GTWfPqLCeeJ5r1bphPRicw4LlCKV0ZD")
                .setOAuthPermissions("email,publish_stream,publish_actions,user_likes,manage_pages,read_stream");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();

    }

    /**
     * postea un mensaje en tu muro
     *
     * @param mensaje contiene el mensaje a postear
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
        ResponseList<Post> noticia = facebook.getFeed(JOptionPane.showInputDialog("Introduce la palabra clave a buscar"));
        System.out.println(noticia.toString());
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
     * crea un nuevo post con imagen incluida,pero sólo desde  una URL  dada por parámetro
     *
     * @throws MalformedURLException
     * @throws FacebookException
     */
    public static void postPhoto() throws MalformedURLException, FacebookException {
        PostUpdate post = new PostUpdate(new URL("http://allblacks.com"))
                .picture(new URL("http://nzrumedia.azurewebsites.net/media/2F225B75-A74D-CBF6-40212B37D6118153.jpg"))
                .name("All blacks maori team Logo")
                .caption("allblacks.com")
                .description("All blacks Maori team");
        facebook.postFeed(post);
    }

}
