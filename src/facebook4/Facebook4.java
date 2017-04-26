package facebook4;

import facebook4j.*;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;


public class Facebook4 {

   
    public static void main(String[] args) throws FacebookException, MalformedURLException {
   
   
     int select;
     do{
        Autorizacion.autorizar();
        select = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la opción deseada "
                + "\n 1.postear \n 2.buscar Post \n 3. Mostrar Feed \n 4.comentar Foto \n 5. Postear foto \n 0.Salir"));
        switch(select){ 
        case 1: Autorizacion.postearMensaje(JOptionPane.showInputDialog("Introduce el contenido del post "));
        break;
        case 2:Autorizacion.buscarPost();
        break;
        case 3:Autorizacion.buscarFeed();
        break;
        case 4:Autorizacion.comentario();
        break;
        case 5:Autorizacion.postPhoto();
        break;
        
        }  
     }while(select!=0);
     
     
     
      
      
      
      
    }
    
}
