package agenteproyectos;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgenteProfesor extends Agent {

    @Override
    protected void setup() {
        System.out.println("Agente Profesor " + getLocalName() + " iniciado.");

        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println("Profesor " + getLocalName() + " recibió: " + msg.getContent());

                    // Procesar el mensaje del estudiante y enviar una respuesta educativa.
                    ACLMessage reply = msg.createReply();
                    reply.setContent("Este es tu material educativo personalizado.");
                    send(reply);
                } else {
                    block();
                }
            }
        });
    }
}
