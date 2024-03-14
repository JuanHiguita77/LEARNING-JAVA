import java.util.HashMap;
import javax.swing.JOptionPane;


public class AuthController
{
    private HashMap<String, String> users;
    private HashMap<String, String> roles;
    private String currentUser;
    private String currentRole;

    public AuthController()
    {
        users = new HashMap<>();
        this.currentUser = null;
        this.currentRole = null;
    }

    public void register(Scanner scanner)
    {
        String emailRegister = JOptionPane.showInputDialog("Ingrese el email a registrar");
        String passwordRegister = JOptionPane.showInputDialog("Ingrese la contraseña");
        String rol = JOptionPane.showInputDialog("Ingrese su Rol 'Cliente' O 'Delivery' ");

        if (users.containsKey(emailRegister))
        {
            System.out.println("El usuario ya esta registrado");
        }
        else
        {
            users.put(emailRegister, passwordRegister);
            roles.put(emailRegister, rol);

            System.out.println("Registro exitoso!");
        }
    }

    public void login(Scanner scanner)
    {
        String emailLogin = JOptionPane.showInputDialog("Ingrese su email registrado ");
        String passwordLogin = JOptionPane.showInputDialog("Ingrese su contraseña");

        if (users.containsKey(emailLogin) && users.get(emailLogin).equals(passwordLogin))
        {
            currentUser = emailLogin;
            currentRole = roles.get(emailLogin);

            System.out.println("Inicio de sesion exitoso!!");

            interfaz();

        }
        else
        {
            System.out.println("Email o Contraseña incorrecta!");
        }
    }

    public void logOut()
    {
        currentUser = null;
        currentRole = null;
        System.out.println("Sesion cerrada correctamente");
    }

    public void interfaz()
    {
        if (currentRole.equalsIgnoreCase("cliente"))
        {
            System.out.println("Interfaz para clientes");
        }
        else if (currentRole.equalsIgnoreCase("delivery"))
        {
            System.out.println("Interfaz para delivery...");
        }
    }
}
