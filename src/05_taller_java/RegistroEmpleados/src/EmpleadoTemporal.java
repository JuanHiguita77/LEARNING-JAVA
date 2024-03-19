public class EmpleadoTemporal extends Empleado
{

    private String fechaInicio;
    private String fechaFinalizacion;


    public EmpleadoTemporal(String nombre, int edad, int idEmpleado, double salario, String fechaFinalizacion) {
        super(nombre, edad, idEmpleado, salario);
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }


    @Override
    public String toString() {
        return super.toString() + "--- EmpleadoTemporal --> " + "fechaFinalizacion: " + fechaFinalizacion;
    }
}
