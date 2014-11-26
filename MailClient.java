
/**
 * Representa un cliente de correo electronico.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    //Representa el servidor asociado con el cliente
    private MailServer server;
    //Indica la direccion de correo que utiliza el usuario
    private String user;
    
    /**
     * Constructor for objects of class MailClient
     */
    public MailClient(MailServer server,String user)
    {
        this.server  = server;
        
        this.user    = user;
    }
    
    /**
     *Recupera del servidor el siguiente correo que tiene el usuario
     *y devuelve este correo
     */
    public MailItem getNextMailItem()
    {
        // recupera el siguiente mensaje
        MailItem email = server.getNextMailItem(user);
        return email;
        
    }
    /**
     * Recupera del servidor el siguiente mensaje 
     * y lo imprime en pantalla
     */
    public void printNextMailItem()
    {
      if(server.howManyMailItems(user) > 0)
      {
          MailItem email = server.getNextMailItem(user);
          email.print();
      }
      else //si no hay mensajes lo indica en pantalla
      {
          System.out.println("No hay ningun mensaje");
      }   
    }  
    /**
     * Envia un mensaje a otro usuario de email. Introduce el destinatario
     * y el cuerpo del mensaje
     */
    public void sendMailItem(String to,String text)
    {
        MailItem email = new MailItem(user,to,text);
        server.post(email);
    }    
}
