package agenteproyectos;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AgenteProyectos extends Agent {

    @Override
    protected void setup() {
        System.out.println("Agente " + getLocalName() + " iniciado.");

        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    System.out.println("Mensaje recibido: " + msg.getContent());

                } else {
                    block();
                }
            }
        });
    }
}
