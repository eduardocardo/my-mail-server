
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
    //indica el numero de mensajes enviados
    private int sendEmails;
    //indica el numero de mensajes recibidos
    private int receivedEmails;
    //indica el numero de mensajes spam recibidos
    private int receivedSpam;
    /**
     * Constructor for objects of class MailClient
     */
    public MailClient(MailServer server,String user)
    {
        this.server    = server;
        this.user      = user;
        lastEmail      = null;
        sendEmails     = 0;
        receivedEmails = 0;
        receivedSpam = 0;
    }

    /**
     *Recupera del servidor el siguiente correo que tiene el usuario
     *y devuelve este correo
     */
    public MailItem getNextMailItem()
    {
        // recupera el siguiente mensaje
        lastEmail = server.getNextMailItem(user);
        if(lastEmail != null)
        {
            receivedEmails = receivedEmails + 1;
        }   
        String tempMessage = lastEmail.getMessage();
        if (tempMessage.contains("viagra") || tempMessage.contains("oferta"))
        {

            if (tempMessage.contains("proyecto"))
            {
                return lastEmail;
            }
            else
            {
                receivedSpam = receivedSpam +1;
                return null;
            }
        }
        else
        {
            return lastEmail;
        }

    }

    /**
     * Recupera del servidor el siguiente mensaje 
     * y lo imprime en pantalla
     */
    public void printNextMailItem()
    {
        if (server.howManyMailItems(user) > 0)
        {
            lastEmail = server.getNextMailItem(user);
            receivedEmails = receivedEmails + 1;
            String tempMessage = lastEmail.getMessage();
            if (tempMessage.contains("viagra") || tempMessage.contains("oferta"))
            {
                if (tempMessage.contains("proyecto"))
                {
                    lastEmail.print();

                }
                else
                {
                    System.out.println("Has recibido spam");
                    lastEmail = null;
                    receivedSpam = receivedSpam +1;

                }
            }

            else
            {
                lastEmail.print();

            }
        }
        else
        {
            System.out.println("No hay mensajes nuevos");
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
        sendEmails = sendEmails +1;
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
            sendEmails = sendEmails +1;
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

    /**
     * Metodo que imprime por pantalla el numero de mensajes enviados,el numero de mensajes recibidos
     * el numero de mensajes spam recibidos,el % de mensajes totales que son spam
     */
    public void statistics()
    {
        System.out.println("El numero de mensajes enviados es : " + sendEmails);
        System.out.println("El numero de mensajes recibidos es : " + receivedEmails);
        System.out.println("de los cuales el " + ((receivedSpam*100)/receivedEmails) + "% es spam" ); 

    }                       
}   

