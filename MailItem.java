
/**
 * Write a description of class MailItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    // indica la procedencia del objeto
    private String from;
    //indica el destinatario del objeto
    private String to;
    //indica el contenido del objeto
    private String message;
    /**
     * Constructor for objects of class MailItem
     */
    public MailItem(String user,String toUser,String newMessage)
    {
        // 
        from    = user;
        to      = toUser;
        message = newMessage;
    }
    /**
     * Metodo que devuelve el remitente
     */
    public String getFrom()
    {
          return from;
    }    
    /**
     * Metodo que devuelve el destinatario
     */
    public String getTo()
    {
          return to;
    }
    /**
     * Metodo que devuelve el mensaje
     */
    public String getMessage()
    {
          return message;
    }    
    /**
     *Muestra en pantalla los atributos del objeto
     */
    public void print()
    {
        System.out.println("from:" + from);
        System.out.println("to:" + to);
        System.out.println("message:" + message);
        
    }
}
