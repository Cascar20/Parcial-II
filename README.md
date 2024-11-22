# Parcial-II

# Nombres y codigos
# 192376-Johan Quintero
# 192378-Jhefer Solano

# Sistema de Gestión de Horarios para Estudiantes

Este sistema permite gestionar las inscripciones de estudiantes en materias universitarias, verificando la disponibilidad de horarios y evitando conflictos

# Clases

Materia: Representa una asignatura con su nombre, código, créditos y horarios disponibles. Permite agregar horarios y mostrar los disponibles
  
Estudiante: Representa a un estudiante con su nombre, ID y las materias inscritas. Permite inscribir materias, verificar conflictos de horarios y mostrar el horario completo del estudiante

GestionHorarios: Administra las materias y estudiantes, permitiendo registrar materias y estudiantes, y mostrar las materias disponibles

# Flujo

1. Se crean materias con horarios disponibles
2. Se inscriben estudiantes, verificando que los horarios no tengan conflictos
3. El estudiante puede ver su horario completo

# Manejo de Errores

 Si el estudiante ya está inscrito en una materia o hay un conflicto de horarios, el sistema lanza una excepción