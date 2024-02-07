package agenteproyectos;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgenteEstudiante extends Agent {

    @Override
    protected void setup() {
        System.out.println("Agente Estudiante " + getLocalName() + " iniciado.");

        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println("Estudiante " + getLocalName() + " recibió: " + msg.getContent());

                    // Procesar el mensaje y responder, por ejemplo, con preguntas o respuestas.
                    ACLMessage reply = msg.createReply();
                    reply.setContent("Gracias por el mensaje.");
                    send(reply);
                } else {
                    block();
                }
            }
        });
    }
}

