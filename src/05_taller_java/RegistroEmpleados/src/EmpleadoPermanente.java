public class EmpleadoPermanente extends Empleado
{
    private double vacacionesPagadas;

    public EmpleadoPermanente(String nombre, int edad, int idEmpleado, double salario, double vacacionesPagadas) {
        super(nombre, edad, idEmpleado, salario);
        this.vacacionesPagadas = vacacionesPagadas;
    }

    public double getVacacionesPagadas() {
        return vacacionesPagadas;
    }

    public void setVacacionesPagadas(double vacacionesPagadas) {
        this.vacacionesPagadas = vacacionesPagadas;
    }


    @Override
    public String toString() {
        return  super.toString() + "--- Empleado Permanente ---> " + "Dinero beneficio vacaciones Pagadas: " + vacacionesPagadas;
    }
}
