package com.curso.servlets;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author begonaolea
 */
@WebServlet(name = "JMSAddServlet", urlPatterns = {"/enviar"})
public class JMSAddServlet extends HttpServlet {

    @Resource(mappedName = "jms/factoriaColas")
    private QueueConnectionFactory factoriaColas;
    
    
    @Resource(mappedName ="jms/curso")
    private Queue cola;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
        try {
            String texto = req.getParameter("texto");
            
            Connection con = factoriaColas.createConnection();
            Session sesion = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            
            TextMessage msg = sesion.createTextMessage(texto);
            
            MessageProducer producer = sesion.createProducer(cola);
            producer.send(msg);
            
            System.out.println("... envio el mensaje  " + texto + " a la cola");
            producer.close();
            sesion.close();
            con.close();
            
        } catch (JMSException ex) {
            Logger.getLogger(JMSAddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
