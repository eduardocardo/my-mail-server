
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
    //indica el ultimo mensaje recibido
    private MailItem lastEmail;
    /**
     * Constructor for objects of class MailClient
     */
    public MailClient(MailServer server,String user)
    {
        this.server      = server;
        this.user        = user;
        lastEmail = null;
    }

    /**
     *Recupera del servidor el siguiente correo que tiene el usuario
     *y devuelve este correo
     */
    public MailItem getNextMailItem()
    {
        // recupera el siguiente mensaje
        lastEmail = server.getNextMailItem(user);
        return lastEmail;

    }

    /**
     * Recupera del servidor el siguiente mensaje 
     * y lo imprime en pantalla
     */
    public void printNextMailItem()
    {
        if(server.howManyMailItems(user) > 0)
        {
            lastEmail = server.getNextMailItem(user);
            lastEmail.print();
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
    public void sendMailItem(String to,String subject,String message)
    {
        lastEmail = new MailItem(user,to,subject,message);
        server.post(lastEmail);
    } 

    /**
     * Metodo para conocer el numero de emails que tiene el servidor 
     * para un usuario
     * y devuelve esa informacion en pantalla
     */
    public void howManyMailItems()
    {
        int numMessage = server.howManyMailItems(user);
        System.out.println("Tienes " + numMessage + " emails");
    }      

    /**
     * Metodo que cuando recibes un correo responde de manera automatica
     * al emisor
     */
    public void getNextMailItemAndAutorespond()
    {
        MailItem email    = server.getNextMailItem(user);
        if(email!= null)
        {
            String newTo    = email.getFrom();
            String newSubject = ("RE: "+ email.getSubject());
            String newMessage = email.getMessage() + "\nEstoy de vacaciones";
            sendMailItem(newTo,newSubject,newMessage);
        }
    }  
    /**
     * Metodo que imprime por pantalla tantas veces como queramos
     * el ultimo mensaje recibido
     * si no hay mensaje informa de ello
     */
    public void printLastMail()
    {
        if(lastEmail != null)
        {
            lastEmail.print();
        }
        else
        {
            System.out.println("No hay ningun mensaje");
        } 
    }   
}      

