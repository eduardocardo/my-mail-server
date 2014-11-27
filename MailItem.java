
/**
 * Esta clase representa un mensaje de email
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    // indica la procedencia del mensaje
    private String from;
    //indica el destinatario del mensaje
    private String to;
    //indica el asunto del mensaje
    private String subject;
    //indica el contenido del mensaje
    private String message;
    
    /**
     * Constructor for objects of class MailItem
     */
    public MailItem(String from,String to,String subject,String message)
    {
        // 
        this.from    = from;
        this.to      = to;
        this.subject = subject;
        this.message = message;
        
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
     * Metodo que devuelve el asunto del mensaje
     */
    public String getSubject()
    {
        return subject;
    }    
    /**
     *Muestra en pantalla los atributos del objeto
     */
    public void print()
    {
        System.out.println("from: " + from);
        System.out.println("to: " + to);
        System.out.println("subject: " + subject);
        System.out.println("message: " + message);
    }
}
