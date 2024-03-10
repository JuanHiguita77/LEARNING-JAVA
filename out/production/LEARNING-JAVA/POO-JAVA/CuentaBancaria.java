public class CuentaBancaria
{

    private String titular;
    private double balance;

    public CuentaBancaria(String titular, double balance) {
        this.titular = titular;
        this.balance = balance;
    }

    public String getTitular()
    {
      return this.titular;
    }

    public void setTitular(String titular)
    {
        this.titular = titular;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void depositar(double dinero)
    {
        this.balance += dinero;
        System.out.println("Balance Actual: " + this.balance);
    }

    public void retirar(double dinero)
    {
        if(dinero > this.balance)
        {
            System.out.println("Balance insuficiente --> " + this.balance);
            return;
        }
        else
        {
            this.balance -= dinero;
            System.out.println("Balance Actual: " + this.balance);
        }
    }

    public void info()
    {
        System.out.println("Titular: " + this.titular +
                            "\nBalance Final: " + this.balance);
    }
}