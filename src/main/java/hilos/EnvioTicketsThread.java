package hilos;

import modelo.EventoUniversitario;
import modelo.Inscripcion;
import modelo.actividades.Actividad;

public class EnvioTicketsThread extends Thread {
    private EventoUniversitario evento;

    public EnvioTicketsThread(EventoUniversitario evento) {
        this.evento = evento;
        this.setName("Hilo-Envio-Tickets");
    }

    @Override
    public void run() {
        System.out.println("\n[HILO SECUNDARIO] Iniciando proceso de envío de tickets de acceso...");

        for (Actividad actividad : evento.getActividades()) {
            for (Inscripcion inscripcion : actividad.getInscripciones()) {
                // Solo se envían tickets de inscripciones confirmadas y que tengan ticket generado
                if ("CONFIRMADA".equals(inscripcion.getEstado()) && inscripcion.getTicket() != null) {
                    try {
                        // Simulamos el tiempo que tarda el envío por red
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("[HILO SECUNDARIO] Envío interrumpido.");
                    }
                    inscripcion.getTicket().enviarTicket();
                }
            }
        }

        System.out.println("[HILO SECUNDARIO] Finalizó el envío de todos los tickets de acceso.\n");
    }
}