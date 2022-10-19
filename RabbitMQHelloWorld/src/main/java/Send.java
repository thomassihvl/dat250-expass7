import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
//import org.apache.log4j.BasicConfigurator;

public class Send {
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] argv) throws Exception {
        //BasicConfigurator.configure();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
                channel.queueDeclare(QUEUE_NAME, false, false, false, null);
                String message = "Hello World!";
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
