package modelo;

import modelo.actividades.Actividad;

import java.io.Serializable;
import java.time.LocalDate;


public class Inscripcion implements Serializable {
    private Actividad actividad;
    private Estudiante estudiante;
    private LocalDate fecha;
    private String estado;

    // ==== AGREGADO EJERCICIO 4 ====
    private TicketDeAcceso ticket;

    public Inscripcion(Actividad actividad, Estudiante estudiante, LocalDate fecha, String estado) {
        this.actividad = actividad;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void confirmar() {
        this.estado = "CONFIRMADA";
    }


    public TicketDeAcceso getTicket() {
        return ticket;
    }


    public void emitirTicket() {
        if ("CONFIRMADA".equals(this.estado)) {
            this.ticket = new TicketDeAcceso("TK-" + this.actividad.getId() + "-" + this.estudiante.getLegajo(), LocalDate.now());
        } else {
            System.out.println("No se puede emitir ticket para " + this.estudiante.getNombre() + ". La inscripción no está confirmada.");
        }
    }


    public class TicketDeAcceso {
        private String idTicket;
        private LocalDate fecha;

        public TicketDeAcceso(String idTicket, LocalDate fecha) {
            this.idTicket = idTicket;
            this.fecha = fecha;
        }

        public String getIdTicket() {
            return idTicket;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void enviarTicket() {
            System.out.println("  -> [Ticket] Enviado a " + estudiante.getNombre() +
                    " | Actividad: " + actividad.getTitulo() +
                    " | ID Ticket: " + idTicket +
                    " | Fecha: " + fecha);
        }
    }
}