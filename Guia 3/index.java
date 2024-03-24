import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Libro{
    String titulo;
    int precio;
    int stock;
    List <Autor> autores;

    public Libro(){
        autores = new ArrayList<>();
    }
    
    public void agregarAutor(Autor autor){
        autores.add(autor);
    }

    public List<Autor> getAutores(){
        return autores;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public int getStock(){
        return stock;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }

    public int getPrecio(){
        return precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Titulo: ").append(titulo).append("\n");
        sb.append("Precio: ").append(precio).append("\n");
        sb.append("Stock: ").append(stock).append("\n");
        sb.append("Autores: \n");
        for (Autor autor : autores) {
            sb.append(autor.toString()).append("\n");
        }
        return sb.toString();
    }
}

class Autor{
    String nombre;
    String apellido;
    String email;
    char genero;

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getNombre() {
    return nombre;
}

public void setApellido(String apellido) {
    this.apellido = apellido;
}

public String getApellido() {
    return apellido;
}

public void setEmail(String email) {
    this.email = email;
}

public String getEmail() {
    return email;
}

public void setGenero(char genero){
    this.genero = genero;
}

public int getGenero(){
    return genero;
}

@Override
public String toString() {
    return "Nombre: " + nombre + ", Apellido: " + apellido + ", Email: " + email + ", Genero: " + genero;
}

public void mostrar(){
    System.out.printf("Nombre: %s , Apellido: %s , Mail: %s , Genero: %c", nombre, apellido, email, genero);
}
}

class Cliente {
    String idCliente;
    String nombre;
    String email;
    int descuento;

    Cliente() {
        idCliente = java.util.UUID.randomUUID().toString();
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getDescuento() {
        return descuento;
    }

    public void mostrarCliente() {
        System.out.println("Cliente[id = " + idCliente + " Nombre = " + nombre + " Email = " + email + " Descuento = " + descuento + "]");
    }
}

class Factura {
    String idFactura;
    Double montoTotal;
    LocalDateTime fecha;
    Cliente cliente;
    List<ItemVenta> productos;

    Factura() {
        fecha = LocalDateTime.now();
        idFactura = java.util.UUID.randomUUID().toString();
        productos = new ArrayList<>();
        montoTotal = 0.0;
    }

    public void agregarProduct(ItemVenta producto) {
        productos.add(producto);
    }

    public List<ItemVenta> getProductos() {
        return productos;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public double montoConDescuento() {
        double monto = montoTotal - (montoTotal * cliente.descuento / 100);
        return monto;
    }

    public void sumarTotal() {
        for (ItemVenta producto : productos) {
            montoTotal += producto.precio;
        }
    }

    public void mostrarTodo() {
        sumarTotal(); // Calcular el monto total después de agregar los productos
        System.out.println("Factura[Id = " + idFactura + " Fecha y Hora = " + fecha.withNano(0) + " Monto = " + montoTotal + " Monto con Descuento = " + montoConDescuento() + "]");
        cliente.mostrarCliente();
        System.out.println("Productos:");
        for (ItemVenta producto : productos) {
            System.out.println(producto.toString());
        }
    }
}

class ItemVenta {
    int idProducto;
    String nombre;
    String descripcion;
    Double precio;

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "ItemVenta [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + "]";
    }
}

class datosCliente{
    String id;
    String nombre;
    char genero;

    datosCliente(){
        id = java.util.UUID.randomUUID().toString();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setGenero(char genero) {
        this.genero = genero;
    }
    public String getId() {
        return id;
    }
    public char getGenero() {
        return genero;
    }
    public String getNombre() {
        return nombre;
    }
}

class cuentaBanco{
    String id;
    Double balance;
    datosCliente cliente;

    cuentaBanco(){
        id = java.util.UUID.randomUUID().toString();
        balance = 0.0;
    }

    public void depositar(Double deposito){
        balance = balance + deposito;
    }

    public void extraer(Double extracto){
        if(extracto <= (balance + 2000)){
            balance = balance - extracto;
        }
        else{
            System.out.println("Balance insuficiente.");
        } 
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setCliente(datosCliente cliente) {
        this.cliente = cliente;
    }

    public Double getBalance() {
        return balance;
    }

    public datosCliente getCliente() {
        return cliente;
    }
}

public class index {
    public static void main(String[] args) {
        // EJERCICIO 2
        /* Cliente cliente1 = new Cliente();
        cliente1.setNombre("Marangoni");
        cliente1.setEmail("marangoni@gmail.com");
        cliente1.setDescuento(20);

        Factura factura1 = new Factura();
        factura1.setCliente(cliente1);

        ItemVenta item1 = new ItemVenta();
        item1.setNombre("Iphone 15 Pro Max 128Gb ");
        item1.setDescripcion("El telefono mas rapido del mercado con una camara espectacular.");
        item1.setIdProducto(1200);
        item1.setPrecio(1199.99);

        ItemVenta item2 = new ItemVenta();
        item2.setNombre("Apple Watch Series 8");
        item2.setDescripcion("El reloj mas rapido del mercado con una hora espectacular");
        item2.setIdProducto(2300);
        item2.setPrecio(899.99);

        factura1.agregarProduct(item1);
        factura1.agregarProduct(item2);
        factura1.mostrarTodo(); */

        // EJERCICIO 3
        datosCliente cliente1 = new datosCliente();
        cliente1.setNombre("Lupa");
        cliente1.setGenero('f');

        cuentaBanco cuenta1 = new cuentaBanco();
        cuenta1.setBalance(10000.0);
        cuenta1.setCliente(cliente1);

        int i = 0;
        Double[] movimientos = new Double[10];
        Scanner scanner = new Scanner(System.in);
        while(i < 10){
            System.out.println("Desea realizar un movimiento? 0 = No || 1 = Si");
            int control = scanner.nextInt();
            if(control == 1){
                System.out.println("Que operacion realizara? 0 = Deposito || 1 = Extraccion");
                int control1 = scanner.nextInt(); 
                if(control1 == 0){
                    System.out.println("Cuanto quiere depositar?");
                    Double montoDepositar = scanner.nextDouble();
                    cuenta1.depositar(montoDepositar);
                    if(montoDepositar <= (cuenta1.getBalance() + 2000)){
                        movimientos[i] = montoDepositar;
                    }
                    
                }
                else{
                    System.out.println("Cuanto quiere extraer?");
                    Double montoExtraer = scanner.nextDouble();
                    cuenta1.extraer(montoExtraer);

                    movimientos[i] = montoExtraer * -1;
                }
            }   
            i++;
        }
        scanner.close();
        int p = 0;
        System.out.println("Movimientos: ");
        while (p <= movimientos.length) {
            System.out.println(movimientos[p]);
            p++;
        }
    }
}