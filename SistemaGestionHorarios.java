import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Materia {
    private String nombre;
    private String codigo;
    private int creditos;
    private List<String> horariosDisponibles;

    public Materia(String nombre, String codigo, int creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.horariosDisponibles = new ArrayList<>();
    }

    public void agregarHorario(String horario) {
        horariosDisponibles.add(horario);
    }

    public List<String> getHorariosDisponibles() {
        return horariosDisponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void mostrarHorariosDisponibles() {
        System.out.println("Horarios disponibles para " + nombre + ": " + horariosDisponibles);
    }
}

class Estudiante {
    public String nombre;
    private String id;
    private HashMap<Materia, String> materiasInscritas;

    public Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.materiasInscritas = new HashMap<>();
    }

    public void inscribirMateria(Materia materia, String horario) throws Exception {
        if (materiasInscritas.containsKey(materia)) {
            throw new Exception("Ya estás inscrito en esta materia.");
        }
        if (!materia.getHorariosDisponibles().contains(horario)) {
            throw new Exception("El horario seleccionado no está disponible para esta materia.");
        }
        for (String horarioOcupado : materiasInscritas.values()) {
            if (horarioOcupado.equals(horario)) {
                throw new Exception("Conflicto de horarios: ya tienes otra materia en este horario.");
            }
        }
        materiasInscritas.put(materia, horario);
        System.out.println("Materia " + materia.getNombre() + " inscrita en el horario " + horario);
    }

    public void mostrarHorarioCompleto() {
        System.out.println("Horario completo del estudiante " + nombre + ":");
        for (Materia materia : materiasInscritas.keySet()) {
            System.out.println("Materia: " + materia.getNombre() + " | Horario: " + materiasInscritas.get(materia));
        }
    }
}

class GestionHorarios {
    private List<Materia> materias;
    private List<Estudiante> estudiantes;

    public GestionHorarios() {
        this.materias = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }

    public void registrarMateria(Materia materia) {
        materias.add(materia);
        System.out.println("Materia registrada: " + materia.getNombre());
    }

    public void inscribirEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        System.out.println("Estudiante inscrito: " + estudiante.nombre);
    }

    public void mostrarMaterias() {
        System.out.println("Materias disponibles:");
        for (Materia materia : materias) {
            System.out.println("- " + materia.getNombre() + " (Código: " + materia.getCodigo() + ")");
        }
    }
}

public class SistemaGestionHorarios {
    public static void main(String[] args) {
        try {
            // Crear instancias de Gestión de Horarios
            GestionHorarios gestion = new GestionHorarios();

            // Inscribir estudiantes
            Estudiante estudiante1 = new Estudiante("Juan Pérez", "20231001");
            gestion.inscribirEstudiante(estudiante1);

                        // Registrar materias
            Materia matematicas = new Materia("Matemáticas", "MAT101", 3);
            matematicas.agregarHorario("Lunes 8:00 - 10:00");
            matematicas.agregarHorario("Miércoles 10:00 - 12:00");

            Materia programacion = new Materia("Programación", "PROG202", 4);
            programacion.agregarHorario("Lunes 8:00 - 10:00");
            programacion.agregarHorario("Viernes 14:00 - 16:00");

            gestion.registrarMateria(matematicas);
            gestion.registrarMateria(programacion);


            // Inscripción de materias
            estudiante1.inscribirMateria(matematicas, "Lunes 8:00 - 10:00");
            estudiante1.inscribirMateria(programacion, "Viernes 14:00 - 16:00");

            // Mostrar horario del estudiante
            estudiante1.mostrarHorarioCompleto();

            // Ver horarios disponibles
            matematicas.mostrarHorariosDisponibles();
            programacion.mostrarHorariosDisponibles();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
