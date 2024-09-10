package miBanco;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionAdm {

	Scanner miScan2 = new Scanner(System.in);
	Scanner miScan = new Scanner(System.in);
	Scanner scanner = new Scanner(System.in);

	private ArrayList<Cliente> misCliente = new ArrayList<Cliente>(10);
	private ArrayList<Empleados> misEmpleados = new ArrayList<Empleados>(10);
	private ArrayList<Cuentas> miCuenta = new ArrayList<Cuentas>(10);
	private ArrayList<Debito> miDebito = new ArrayList<Debito>(10);
	private ArrayList<Credito> miCredito = new ArrayList<Credito>(10);
	private ArrayList<Monedero> miMonedero = new ArrayList<Monedero>(10);
	private ArrayList<CreditosPersonales> misCPersonales = new ArrayList<CreditosPersonales>(10);
	private ArrayList<Hipotecas> misHipotecas = new ArrayList<Hipotecas>(10);
	private ArrayList<Prestamos> misPrestamos = new ArrayList<Prestamos>(10);

	public ArrayList<Cliente> getMisCliente() {
		return misCliente;
	}

	public void setMisCliente(ArrayList<Cliente> misCliente) {
		this.misCliente = misCliente;
	}

	public ArrayList<Empleados> getMisEmpleados() {
		return misEmpleados;
	}

	public void setMisEmpleados(ArrayList<Empleados> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}

	public ArrayList<Cuentas> getMiCuenta() {
		return miCuenta;
	}

	public void setMiCuenta(ArrayList<Cuentas> miCuenta) {
		this.miCuenta = miCuenta;
	}

	public ArrayList<Debito> getMiDebito() {
		return miDebito;
	}

	public void setMiDebito(ArrayList<Debito> miDebito) {
		this.miDebito = miDebito;
	}

	public ArrayList<Credito> getMiCredito() {
		return miCredito;
	}

	public void setMiCredito(ArrayList<Credito> miCredito) {
		this.miCredito = miCredito;
	}

	public ArrayList<Monedero> getMiMonedero() {
		return miMonedero;
	}

	public void setMiMonedero(ArrayList<Monedero> miMonedero) {
		this.miMonedero = miMonedero;
	}

	
	// Metodo para creador del Banco

	public void altaCuenta() {
		try {

			if (misCliente.isEmpty()) {
				System.out.println("Por favor cree un cliente primero antes de crear una cuenta");
				AltaCliente();
			}
			
			System.out.println("Ingrese el DNI del cliente para abrir la cuenta:");
			String dniCliente = scanner.nextLine();
			Cliente clienteEncontrado = null;
			for (Cliente c : getMisCliente()) {
				if (c.getDni().equals(dniCliente)) {
					clienteEncontrado = c;
					break;
				}
			}

			if (clienteEncontrado == null) {
				System.out.println("El cliente con dni " + dniCliente + " no ha sido encontrado");
				System.out.println("Primero debe dar de alta un cliente para abrir la cuenta y asociarla a la misma");
				AltaCliente();
			} else {
				System.out.println();
				System.out.println("\u001B[36mCreación de nueva cuenta:");

				System.out.println("\u001B[37mIngrese la descripción de la cuenta:");
				String descripcion = scanner.nextLine();
				System.out.println();

				System.out.println("Ingrese la comision de la cuenta");
				double comision = miScan2.nextDouble();
				System.out.println();

				System.out.println("Ingrese la fecha de inicio (formato dd/mm/yyyy):");
				String fInicio = scanner.nextLine();
				System.out.println();

				System.out.println("Ingrese la fecha final (formato dd/mm/yyyy):");
				String fFinal = scanner.nextLine();
				System.out.println();

				System.out.println("Ingrese el cliente asociado");
				Cliente cliente = clienteEncontrado;
				System.out.println(clienteEncontrado.toString());
				System.out.println();

				System.out.println("Ingrese su clave de acceso bancaria");
				int clave = miScan2.nextInt();
				while (String.valueOf(clave).length() != 4) {
					System.out.println("La clave debe ser de 4 dígitos. Inténtelo de nuevo:");
					clave = miScan2.nextInt();
				}
				System.out.println();

				System.out.println("Ingrese el tipo de cuenta (JOVEN, CORRIENTE, NOMINA, SUPERIOR, AHORRO):");
				String tipoCuentaInput = scanner.nextLine();
				TiposCuenta tipo = null;

				while (tipo == null) {
					try {
						tipo = TiposCuenta.valueOf(tipoCuentaInput.toUpperCase());
					} catch (IllegalArgumentException e) {
						System.out.println("Tipo de cuenta inválido. Ingrese un tipo de cuenta válido:");
						tipoCuentaInput = scanner.nextLine();
					}
				}
				System.out.println();

				System.out.println("Ingrese el iban de la cuenta");
				int iban = (int) (Math.random() * 1000000000 + 1);
				System.out.println("Iban aleatorio generado automáticamente");
				System.out.println(iban);
				System.out.println();

				System.out.println("Ingrese el saldo inicial");
				double saldo = miScan2.nextDouble();
				System.out.println();

				System.out.println("Ingrese la cuota de mantenimiento");
				double cmantenimiento = miScan2.nextDouble();
				System.out.println();

				// Crear una nueva instancia de Cuentas utilizando el constructor predefinido
				Cuentas nuevaCuenta = new Cuentas(descripcion, comision, fInicio, fFinal, cliente, clave, tipo, iban,
						saldo, cmantenimiento);

				// Agregar la nueva cuenta a la lista miCuenta
				miCuenta.add(nuevaCuenta);

				System.out.println(nuevaCuenta.toString());
				System.out.println("\u001B[33m¡Nueva cuenta creada con éxito!");
				System.out.println("\u001B[37m");
			}
		} catch (Exception e) {
			System.out.println("Se esperaba otro tipo de dato, reinicie el programa.");
			miScan.nextLine();
			miScan2.nextLine();
			System.exit(0);
		}
	}

	public void AltaCliente() {
		try {
			System.out.println();
			System.out.println("\u001B[36mCreación de nuevo Cliente:");

			System.out.println("\u001B[37mIntroduzca el DNI del cliente:");
			String dni = miScan.nextLine();
			System.out.println();

			System.out.println("Introduzca el nombre del cliente:");
			String nombre = miScan.nextLine();
			System.out.println();

			System.out.println("Introduzca el primer apellido del cliente:");
			String apellido = miScan.nextLine();
			System.out.println();

			System.out.println("Introduzca el segundo apellido del cliente:");
			String apellido2 = miScan.nextLine();
			System.out.println();

			System.out.println("Introduzca el teléfono del cliente:");
			long telefono = miScan2.nextLong();
			System.out.println();

			System.out.println("Introduzca el correo electrónico del cliente:");
			String correo = miScan.nextLine();
			System.out.println();

			System.out.println("Introduzca la dirección del cliente:");
			String direccion = miScan.nextLine();
			System.out.println();

			System.out.println("Introduzca la localidad del cliente:");
			String localidad = miScan.nextLine();
			System.out.println();

			System.out.println("Introduzca el código postal del cliente:");
			int cPostal = miScan2.nextInt();
			System.out.println();

			System.out.println("Introduzca la provincia del cliente:");
			String provincia = miScan.nextLine();
			System.out.println();

			System.out.println("Introduzca la fecha de nacimiento del cliente (formato dd/mm/yyyy):");
			String fnacimiento = miScan.nextLine();
			System.out.println();

			System.out.println("Introduzca observaciones sobre el cliente:");
			String observaciones = miScan.nextLine();
			System.out.println();

			System.out.println("Introduzca su situación laboral");
			String situacionLaboral = miScan.nextLine();
			System.out.println();

			Cliente nuevoCliente = new Cliente(dni, nombre, apellido, apellido2, telefono, correo, direccion, localidad,
					cPostal, provincia, fnacimiento, observaciones, situacionLaboral);

			misCliente.add(nuevoCliente);

			System.out.println("\u001B[33m¡Cliente dado de alta correctamente!.");
			System.out.println("\u001B[37m");

			for (Cliente cliente : misCliente) {
				int posicion = misCliente.indexOf(cliente);
				System.out.println("Posicion en la lista: " + posicion + " - " + cliente);
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Se esperaba otro tipo de dato, reinicie el programa.");
			miScan.nextLine();
			miScan2.nextLine();
			System.exit(0);

		}
	}

	public void AltaEmpleados() {
		try {
			System.out.println();
			System.out.println("\u001B[36mCreación de nuevo Empleado:");
			System.out.println();

			System.out.println("\u001B[37mIntroduzca el DNI del empleado:");
			String dni = miScan2.nextLine();

			System.out.println("Introduzca el nombre del empleado:");
			String nombre = miScan.nextLine();

			System.out.println("Introduzca el primer apellido del empleado:");
			String apellido = miScan.nextLine();

			System.out.println("Introduzca el segundo apellido del empleado:");
			String apellido2 = miScan.nextLine();

			System.out.println("Introduzca el teléfono del empleado:");
			long telefono = miScan2.nextLong();

			System.out.println("Introduzca el correo electrónico del empleado:");
			String correo = miScan.nextLine();

			System.out.println("Introduzca la dirección del empleado:");
			String direccion = miScan.nextLine();

			System.out.println("Introduzca la localidad del empleado:");
			String localidad = miScan.nextLine();

			System.out.println("Introduzca el código postal del empleado:");
			int cPostal = miScan2.nextInt();

			System.out.println("Introduzca la provincia del empleado:");
			String provincia = miScan.nextLine();

			System.out.println("Introduzca la fecha de nacimiento del empleado (formato dd/mm/yyyy):");
			String fnacimiento = miScan.nextLine();

			System.out.println("Introduzca observaciones sobre el empleado:");
			String observaciones = miScan.nextLine();

			System.out.println("Introduzca la fecha de contratación del empleado (formato dd/mm/yyyy):");
			String fechaContratacion = miScan.nextLine();

			System.out.println("Introduzca el puesto de trabajo del empleado:");
			String puestoTrabajo = miScan.nextLine();

			System.out.println("Introduzca el sueldo del empleado:");
			double sueldo = miScan2.nextDouble();

			System.out.println("Introduzca los años de experiencia del empleado:");
			int aniosExperiencia = miScan2.nextInt();

			Empleados nuevoEmpleado = new Empleados(dni, nombre, apellido, apellido2, telefono, correo, direccion,
					localidad, cPostal, provincia, fnacimiento, observaciones, fechaContratacion, puestoTrabajo, sueldo,
					aniosExperiencia);

			misEmpleados.add(nuevoEmpleado);

			for (Empleados empleado : misEmpleados) {
				int posicion = misCliente.indexOf(empleado);
				System.out.println("Posicion en la lista: " + posicion + " - " + empleado);
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Se esperaba otro tipo de dato, reinicie el programa.");
			miScan.nextLine();
			miScan2.nextLine();
			System.exit(0);

		}
	}

	public void ModificarCliente() {

		int opcion;

		System.out.println("Lista de Cliente:");
		for (int i = 0; i < getMisCliente().size(); i++) {
			System.out.println(i + ". " + getMisCliente().get(i));
		}

		System.out.println("Ingrese el índice del cliente a modificar:");
		int indice = miScan2.nextInt();
		while (indice < 0 || indice >= getMisCliente().size()) {
			System.out.println("La posición ingresada no es válida. Ingrese un índice válido:");
			indice = miScan2.nextInt();
		}

		Cliente clienteAModificar = getMisCliente().get(indice);
		do {
			System.out.println("Modificar cliente:");
			System.out.println("----------------");
			System.out.println();
			System.out.println("1.Modificar DNI");
			System.out.println("2.Modificar Nombre");
			System.out.println("3.Modificar Apellido");
			System.out.println("4.Modificar Apellido2");
			System.out.println("5.Modificar Telefono");
			System.out.println("6.Modificar Email");
			System.out.println("7.Modificar Direccion");
			System.out.println("8.Modificar Localidad");
			System.out.println("9.Modificar Codigo postal");
			System.out.println("10.Modificar Provincia");
			System.out.println("11.Modificar Fecha nacimiento");
			System.out.println("12.Modificar Observaciones");
			System.out.println("13.Modificar Situacion laboral");
			System.out.println("0.SALIR");

			opcion = miScan2.nextInt();

			if (opcion == 1) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setDni(dato);
			}
			if (opcion == 2) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setNombre(dato);
			}
			if (opcion == 3) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setApellido(dato);
			}

			if (opcion == 4) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setApellido2(dato);
			}

			if (opcion == 5) {
				System.out.println("Introduzca nuevo dato");
				long dato = miScan.nextLong();
				clienteAModificar.setTelefono(dato);
			}
			if (opcion == 6) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setCorreo(dato);
			}
			if (opcion == 7) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setDireccion(dato);
			}
			if (opcion == 8) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setLocalidad(dato);
			}
			if (opcion == 9) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				try {
					int codigoPostal = Integer.parseInt(dato);
					clienteAModificar.setCPostal(codigoPostal);
				} catch (NumberFormatException e) {
					System.out.println(
							"El dato introducido no es válido. Introduce un número entero para el código postal.");
				}

			}
			if (opcion == 10) {
				System.out.println("introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setProvincia(dato);
			}
			if (opcion == 11) {
				System.out.println("introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setFnacimiento(dato);
			}
			if (opcion == 12) {
				System.out.println("introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setObservaciones(dato);
			}
			if (opcion == 13) {
				System.out.println("introduzca nuevo dato");
				String dato = miScan.nextLine();
				clienteAModificar.setSituacionLaboral(dato);
			}

		} while (opcion != 0);
		System.out.println("Lista de Cliente modificado:");
		for (int i = 0; i < getMisCliente().size(); i++) {
			System.out.println(i + ". " + getMisCliente().get(i));
		}
		System.out.println();
	}

	public void ImprimirListaCliente() {
		if (misCliente.isEmpty()) {
			System.out.println("La lista de Cliente esta vacia");
			System.out.println();
		} else {
			for (Cliente Cliente : misCliente) {
				int posicion = misCliente.indexOf(Cliente);
				System.out.println("Posicion en la lista: " + posicion + " - " + Cliente);
				System.out.println();
			}
		}
	}

	public void ModificarEmpleado() {

		int opcion;

		System.out.println("Lista de Empleados:");
		for (int i = 0; i < getMisEmpleados().size(); i++) {
			System.out.println(i + ". " + getMisEmpleados().get(i));
		}

		System.out.println("Ingrese el índice del empleado a modificar:");
		int indice = miScan2.nextInt();
		while (indice < 0 || indice >= getMisEmpleados().size()) {
			System.out.println("La posición ingresada no es válida. Ingrese un índice válido:");
			indice = miScan2.nextInt();
		}

		Empleados empleadoAModificar = getMisEmpleados().get(indice);
		do {
			System.out.println("Modificar empleado:");
			System.out.println("----------------");
			System.out.println("1.Modificar DNI");
			System.out.println("2.Modificar Nombre");
			System.out.println("3.Modificar Apellido");
			System.out.println("4.Modificar Apellido2");
			System.out.println("5.Modificar Telefono");
			System.out.println("6.Modificar Email");
			System.out.println("7.Modificar Direccion");
			System.out.println("8.Modificar Localidad");
			System.out.println("9.Modificar Codigo postal");
			System.out.println("10.Modificar Provincia");
			System.out.println("11.Modificar Fecha nacimiento");
			System.out.println("12.Modificar Observaciones");
			System.out.println("13.Modificar Fecha de contratacion");
			System.out.println("14.Modificar Puesto de trabajo");
			System.out.println("15.Modificar Sueldo");
			System.out.println("16.Modificar Años de Experiencia");
			System.out.println("0.SALIR");

			opcion = miScan.nextInt();

			if (opcion == 1) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				empleadoAModificar.setDni(dato);
			}
			if (opcion == 2) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				empleadoAModificar.setNombre(dato);
			}
			if (opcion == 3) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				empleadoAModificar.setApellido(dato);
			}

			if (opcion == 4) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				empleadoAModificar.setApellido2(dato);
			}

			if (opcion == 5) {
				System.out.println("Introduzca nuevo dato");
				long dato = miScan.nextLong();
				empleadoAModificar.setTelefono(dato);
			}
			if (opcion == 6) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				empleadoAModificar.setCorreo(dato);
			}
			if (opcion == 7) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				empleadoAModificar.setDireccion(dato);
			}
			if (opcion == 8) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				empleadoAModificar.setLocalidad(dato);
			}
			if (opcion == 9) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				try {
					int codigoPostal = Integer.parseInt(dato);
					empleadoAModificar.setCPostal(codigoPostal);
				} catch (NumberFormatException e) {
					System.out.println(
							"El dato introducido no es válido. Introduce un número entero para el código postal.");
				}

			}
			if (opcion == 10) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				empleadoAModificar.setProvincia(dato);
			}
			if (opcion == 11) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				empleadoAModificar.setFnacimiento(dato);
			}
			if (opcion == 12) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				empleadoAModificar.setObservaciones(dato);
			}
			if (opcion == 13) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				empleadoAModificar.setFechaContratacion(dato);
			}
			if (opcion == 14) {
				System.out.println("Introduzca nuevo dato");
				String dato = miScan.nextLine();
				empleadoAModificar.setPuestoTrabajo(dato);
			}
			if (opcion == 15) {
				System.out.println("Introduzca nuevo dato");
				double datos = miScan2.nextDouble();
				empleadoAModificar.setSueldo(datos);
			}
			if (opcion == 16) {
				System.out.println("Introduzca nuevo dato");
				int datos = miScan2.nextInt();
				empleadoAModificar.setAniosExperiencia(datos);
			}
		} while (opcion != 0);
		System.out.println("Lista modificada:");
		System.out.println(misEmpleados.toString());
	}

	public void ImprimirListaEmpleado() {

		if (misEmpleados.isEmpty()) {
			System.out.println("La lista de empleados está vacía.");
		} else {
			for (Empleados empleado : misEmpleados) {
				int posicion = misEmpleados.indexOf(empleado);
				System.out.println("Posición en la lista: " + posicion + " - " + empleado);
			}
		}
	}

	public void aplicarAumentoSalarial(int indiceEmpleado, double porcentajeAumento) {
		if (getMisEmpleados().isEmpty()) {
			System.out.println("La lista esta vacia, añada antes un empleado.");
			AltaEmpleados();
		}

		System.out.println("Lista de Empleados:");
		for (int i = 0; i < getMisEmpleados().size(); i++) {
			System.out.println(i + ". " + getMisEmpleados().get(i));
		}

		int indice = indiceEmpleado;
		while (indice < 0 || indice >= getMisEmpleados().size()) {
			System.out.println("La posición ingresada no es válida. Ingrese un índice válido:");
			indice = miScan2.nextInt();
		}
		if (indiceEmpleado >= 0 && indiceEmpleado < misEmpleados.size()) {
			Empleados empleado = misEmpleados.get(indiceEmpleado);
			empleado.aumentoSalarial(porcentajeAumento);
		} else {
			System.out.println("Índice de empleado inválido. Por favor, seleccione un índice válido.");
		}
	}

	public void ascenso() {
		if (getMisEmpleados().isEmpty()) {
			System.out.println("La lista esta vacia, añada antes un empleado.");
			AltaEmpleados();
		}

		System.out.println("Modificar ascenso del empleado");

		System.out.println("Lista de Empleados:");
		for (int i = 0; i < getMisEmpleados().size(); i++) {
			System.out.println(i + ". " + getMisEmpleados().get(i));
		}

		System.out.println("Ingrese el índice del empleado a modificar:");
		int indice = miScan2.nextInt();
		while (indice < 0 || indice >= getMisEmpleados().size()) {
			System.out.println("La posición ingresada no es válida. Ingrese un índice válido:");
			indice = miScan2.nextInt();
		}

		int indiceEmpleado = miScan.nextInt();

		System.out.println("Ingrese el nuevo puesto el empleado");
		String nuevoPuesto = miScan.nextLine();
		System.out.println("Ingrese el nuevo sueldo del empleado");
		double sueldo = miScan2.nextDouble();

		if (indiceEmpleado >= 0 && indiceEmpleado < misEmpleados.size()) {
			Empleados empleado = misEmpleados.get(indiceEmpleado);
			empleado.ascenso(nuevoPuesto, sueldo);
		}
		System.out.println(getMisEmpleados().toString());
	}

	// Metodos para la creacion de las tarjetas

	public void altaTarjetaDebito() {

		Scanner Rafa1 = new Scanner(System.in);
		Scanner Rafa2 = new Scanner(System.in);
		if (misCliente.isEmpty()) {
			System.out.println("Por favor cree un cliente ante de continuar");
			AltaCliente();
		}

		if (miCuenta.isEmpty()) {
			System.out.println("Por favor cree una cuenta antes de continuar");
			altaCuenta();
		}

		System.out.println("Ingrese el DNI del cliente para completar una tarteja:");
		String dniCliente = Rafa1.nextLine();
		System.out.println();
		Cliente clienteEncontrado = null;

		for (Cliente c : getMisCliente()) {
			if (c.getDni().equals(dniCliente)) {
				clienteEncontrado = c;
				break;
			}
		}

		if (clienteEncontrado == null) {
			System.out.println("El cliente con DNI " + dniCliente + " no ha sido encontrado");
			System.out.println("Primero debe dar de alta un cliente para abrir la cuenta y asociarla a la misma");
			AltaCliente();
		} else {
			boolean tieneDebito = false;
			for (Monedero mon : miMonedero) {
				if (mon.getClienteAsociado().equals(clienteEncontrado)) {
					tieneDebito = true;
					break;

				}
			}
			if (tieneDebito) {
				System.out.println("Este cliente ya tiene una tarjeta monedero dada de alta");
			} else {
				System.out.println("Ingrese la descripción de su tarjeta de debito:");
				String descripcion = Rafa1.nextLine();
				System.out.println();

				System.out.println("Ingrese la comisión de su tarjeta de debito:");
				double comision = Rafa2.nextDouble();
				System.out.println();

				System.out.println("Ingrese la fecha de inicio (formato dd/mm/yyyy):");
				String fInicio = Rafa1.nextLine();
				System.out.println();

				System.out.println("Ingrese la fecha final (formato dd/mm/yyyy):");
				String fFinal = Rafa1.nextLine();
				System.out.println();

				System.out.println("La cuenta y cliente asociado es :");
				Cuentas cuentaAsociada = null;

				// Obtener la cuenta asociada al cliente
				for (Cuentas cu : getMiCuenta()) {
					if (cu.getCliente() == clienteEncontrado) {
						cuentaAsociada = cu;
						break;
					}
				}
				System.out.println(cuentaAsociada.toString());
				System.out.println(clienteEncontrado.toString());
				System.out.println();

				if (cuentaAsociada != null) {
					int claveAsociada = cuentaAsociada.getClave();

					System.out.println("Ingrese el numero de tarjeta");
					int minumero = (int) (Math.random() * 1000000000 + 1);
					String numeroTarjeta = String.valueOf(minumero);
					System.out.println("Numero de tarjeta generado automáticamente: " + numeroTarjeta);
					System.out.println();

					System.out.println("Introduzca una clavePIN para su tarjeta");
					int clavePIN = Rafa2.nextInt();
					System.out.println();

					System.out.println("Introduzca una clave de seguridad para su tarjeta");
					int claveSeguridad = Rafa2.nextInt();
					System.out.println();

					System.out.println("Introduzca el limite diario de su tarjeta");
					double saldoDiario = Rafa2.nextDouble();
					System.out.println();

					System.out.println("Introduzca la fecha de caducidad de la tarjeta");
					String fechaCaducidad = "";
					fFinal = fechaCaducidad;
					System.out.println("Su fecha de caducidad sera la misma que la fecha final " + fFinal);
					System.out.println();

					System.out.println("Introduca la cantidad maxima diaria");
					double maximoDiario = Rafa2.nextDouble();

					Debito nuevaTarjeta = new Debito(descripcion, comision, fInicio, fFinal, clienteEncontrado,
							claveAsociada, cuentaAsociada, numeroTarjeta, clavePIN, claveSeguridad, saldoDiario,
							fechaCaducidad, maximoDiario);

					miDebito.add(nuevaTarjeta);
					System.out.println(nuevaTarjeta.toString());
					System.out.println("\u001B[33m¡Nueva tarjeta de debito creada con éxito!");
					System.out.println("\u001B[37m");

				}
			}
		}
	}

	public void altaTarjetaCredito() {

		Scanner Rafa1 = new Scanner(System.in);
		Scanner Rafa2 = new Scanner(System.in);
		if (misCliente.isEmpty()) {
			System.out.println("Por favor cree un cliente antes de continuar");
			AltaCliente();
		}

		if (miCuenta.isEmpty()) {
			System.out.println("Por favor cree una cuenta antes de continuar");
			altaCuenta();
		}

		System.out.println("Ingrese el DNI del cliente para completar una tarteja:");
		String dniCliente = Rafa1.nextLine();
		Cliente clienteEncontrado = null;

		for (Cliente c : getMisCliente()) {
			if (c.getDni().equals(dniCliente)) {
				clienteEncontrado = c;
				break;
			}
		}

		if (clienteEncontrado == null) {
			System.out.println("El cliente con DNI " + dniCliente + " no ha sido encontrado");
			System.out.println("Primero debe dar de alta un cliente para abrir la cuenta y asociarla a la misma");
			AltaCliente();
		} else {
			boolean tieneCredito = false;
			for (Monedero mon : miMonedero) {
				if (mon.getClienteAsociado().equals(clienteEncontrado)) {
					tieneCredito = true;
					break;

				}
			}
			if (tieneCredito) {
				System.out.println("Este cliente ya tiene una tarjeta monedero dada de alta");
			} else {

				System.out.println("Ingrese la descripción de su tarjeta de credito:");
				String descripcion = Rafa1.nextLine();
				System.out.println();

				System.out.println("Ingrese la comisión de su tarjeta de credito:");
				double comision = Rafa2.nextDouble();
				System.out.println();

				System.out.println("Ingrese la fecha de inicio (formato dd/mm/yyyy):");
				String fInicio = Rafa1.nextLine();
				System.out.println();

				System.out.println("Ingrese la fecha final (formato dd/mm/yyyy):");
				String fFinal = Rafa1.nextLine();
				System.out.println();

				System.out.println("Ingrese la cuenta asociada al cliente:");
				Cuentas cuentaAsociada = null;

				// Obtener la cuenta asociada al cliente
				for (Cuentas cu : getMiCuenta()) {
					if (cu.getCliente().equals(clienteEncontrado)) {
						cuentaAsociada = cu;
						break;
					}
				}
				System.out.println(cuentaAsociada.toString());
				System.out.println(clienteEncontrado.toString());
				System.out.println();

				if (cuentaAsociada != null) {
					int claveAsociada = cuentaAsociada.getClave();

					System.out.println("Ingrese el numero de tarjeta");
					int minumero = (int) (Math.random() * 1000000000 + 1);
					String numeroTarjeta = String.valueOf(minumero);
					System.out.println("Numero de tarjeta generado automáticamente: " + numeroTarjeta);
					System.out.println();

					System.out.println("Introduzca una clavePIN para su tarjeta");
					int clavePIN = Rafa2.nextInt();
					System.out.println();

					System.out.println("Introduzca una clave de seguridad para su tarjeta");
					int claveSeguridad = Rafa2.nextInt();
					System.out.println();

					System.out.println("Introduzca el limite diario de su tarjeta");
					double saldoDiario = Rafa2.nextDouble();
					System.out.println();

					System.out.println("Introduza la fecha de caducidad de la tarjeta");
					String fechaCaducidad = "";
					fFinal = fechaCaducidad;
					System.out.println("Su fecha de caducidad sera la misma que la fecha final: " + fechaCaducidad);
					System.out.println();

					System.out.println("Introduzca el saldo maximo diario");
					double saldoMaximo = Rafa2.nextDouble();

					System.out.println("Introduzca el saldo facturacion");
					double saldoFactura = Rafa2.nextDouble();

					System.out.println("Introduzca la fecha de facturacion");
					String fechaFacturacion = Rafa1.nextLine();

					System.out.println("Introduza el importe a recargar");
					double recargoTarjeta = Rafa2.nextDouble();

					Credito nuevaTarjeta = new Credito(descripcion, comision, fInicio, fFinal, clienteEncontrado,
							claveAsociada, cuentaAsociada, numeroTarjeta, clavePIN, claveSeguridad, saldoDiario,
							fechaCaducidad, saldoMaximo, saldoFactura, fechaFacturacion, recargoTarjeta);

					miCredito.add(nuevaTarjeta);
					System.out.println(nuevaTarjeta.toString());
					System.out.println("\u001B[33m¡Nueva tarjeta de credito creada con éxito!");
					System.out.println("\u001B[37m");
				}
			}

		}
	}

	public void altaMonedero() {

		Scanner Rafa1 = new Scanner(System.in);
		Scanner Rafa2 = new Scanner(System.in);

		if (misCliente.isEmpty()) {
			System.out.println("Por favor cree un cliente ante de continuar");
			AltaCliente();
		}

		if (miCuenta.isEmpty()) {
			System.out.println("Por favor cree una cuenta antes de continuar");
			altaCuenta();
		}

		System.out.println("Ingrese el DNI del cliente para completar una tarteja:");
		String dniCliente = Rafa1.nextLine();
		System.out.println();
		Cliente clienteEncontrado = null;

		for (Cliente c : getMisCliente()) {
			if (c.getDni().equals(dniCliente)) {
				clienteEncontrado = c;
				break;
			}
		}

		if (clienteEncontrado == null) {
			System.out.println("El cliente con DNI " + dniCliente + " no ha sido encontrado");
			System.out.println("Primero debe dar de alta un cliente para abrir la cuenta y asociarla a la misma");
			AltaCliente();
		} else {
			boolean tieneMonedero = false;
			for (Monedero mon : miMonedero) {
				if (mon.getClienteAsociado().equals(clienteEncontrado)) {
					tieneMonedero = true;
					break;

				}
			}
			if (tieneMonedero) {
				System.out.println("Este cliente ya tiene una tarjeta monedero dada de alta");
			} else {
				System.out.println("Ingrese la descripción del monedero:");
				String descripcion = Rafa1.nextLine();
				System.out.println();

				System.out.println("Ingrese la comisión de monedero:");
				double comision = Rafa2.nextDouble();
				System.out.println();

				System.out.println("Ingrese la fecha de inicio (formato dd/mm/yyyy):");
				String fInicio = Rafa1.nextLine();
				System.out.println();

				System.out.println("Ingrese la fecha final (formato dd/mm/yyyy):");
				String fFinal = Rafa1.nextLine();
				System.out.println();

				System.out.println("Ingrese la cuenta asociada al cliente:");
				Cuentas cuentaAsociada = null;

				// Obtener la cuenta asociada al cliente
				for (Cuentas cu : getMiCuenta()) {
					if (cu.getCliente().equals(clienteEncontrado)) {
						cuentaAsociada = cu;
						break;
					}
				}
				System.out.println(cuentaAsociada.toString());
				System.out.println(clienteEncontrado.toString());
				System.out.println();

				if (cuentaAsociada != null) {
					int claveAsociada = cuentaAsociada.getClave();

					System.out.println("Ingrese el numero de tarjeta");
					int minumero = (int) (Math.random() * 1000000000 + 1);
					String numeroTarjeta = String.valueOf(minumero);
					System.out.println("Numero de tarjeta generado automáticamente: " + numeroTarjeta);
					System.out.println();

					System.out.println("Introduzca una clavePIN para su tarjeta");
					int clavePIN = Rafa2.nextInt();
					System.out.println();

					System.out.println("Introduzca una clave de seguridad para su tarjeta");
					int claveSeguridad = Rafa2.nextInt();
					System.out.println();

					System.out.println("Introduzca el limite diario de su tarjeta");
					double saldoDiario = Rafa2.nextDouble();
					System.out.println();

					System.out.println("Introduza la fecha de caducidad de la tarjeta");
					String fechaCaducidad = "";
					fFinal = fechaCaducidad;
					System.out.println("Su fecha de caducidad sera la misma que la fecha final: " + fechaCaducidad);
					System.out.println();

					System.out.println("Introduzca un saldo de monedero inicial");
					double saldoMonedero = Rafa2.nextDouble();

					Monedero nuevaTarjeta = new Monedero(descripcion, comision, fInicio, fFinal, clienteEncontrado,
							claveAsociada, cuentaAsociada, numeroTarjeta, clavePIN, claveSeguridad, saldoDiario,
							fechaCaducidad, saldoMonedero);

					miMonedero.add(nuevaTarjeta);
					System.out.println(nuevaTarjeta.toString());
					System.out.println("\u001B[33m¡Nueva tarjeta monedero creada con éxito!");
					System.out.println("\u001B[37m");
				}
			}
		}

	}

	// Metodos para los clientes

	// Inicialmente comprobamos que el DNI del cliente esta asociado a una cuenta y
	// posteriormente pedimos la clave.
	public void SacarDinero(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}

		// Verificar que el cliente y la cuenta coincidan
		if (cliente != null && cuenta != null && cliente.equals(cuenta.getCliente())) {
			System.out.println("Saldo disponible antes de la operación: " + cuenta.getSaldo());

			System.out.println("Ingrese la clave de acceso para realizar la operación: ");
			int claveAcceso = scanner.nextInt();

			if (cuenta.Acceso(claveAcceso)) {
				System.out.println("Ingrese la cantidad que desea retirar: ");
				double cantidad = scanner.nextDouble();

				if (cuenta.getSaldo() >= cantidad) {
					cuenta.SacarDinero(cantidad);

					System.out.println("Saldo disponible después de la operación: " + cuenta.getSaldo());
				} else {
					System.out.println("Saldo insuficiente para realizar la operación de retiro.");
				}
			} else {
				System.out.println("Clave incorrecta. Operación de retiro cancelada.");
			}
		} else {
			System.out.println("La cuenta y el dni no coindicen.");
		}
	}
	// Inicialmente comprobamos que el DNI del cliente esta asociado a una cuenta y
	// posteriormente pedimos la clave.

	public void IngresarDinero(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}

		// Verificar que el cliente y la cuenta coincidan
		if (cliente != null && cuenta != null && cliente.equals(cuenta.getCliente())) {

			System.out.println("Introduzca su clave de acceso para ingresar dinero:");
			int claveAcceso = scanner.nextInt();

			if (cuenta.Acceso(claveAcceso)) {
				System.out.println("Saldo disponible antes de la operación: " + cuenta.getSaldo());

				System.out.println("¿Qué cantidad de dinero quiere ingresar?");
				double cantidad = scanner.nextDouble();

				cuenta.IngresarDinero(cantidad);

				System.out.println("Saldo disponible después de la operación: " + cuenta.getSaldo());
			} else {
				System.out.println("Clave incorrecta. Operación de ingreso cancelada.");
			}
		} else {
			System.out.println("La cuenta y el dni no coindicen.");
		}
	}
	// Inicialmente comprobamos que el DNI del cliente esta asociado a una cuenta y
	// posteriormente pedimos la clave.

	public void VisualizarCuenta(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}

		if (cliente != null && cuenta != null && cliente.equals(cuenta.getCliente())) {
			System.out.println("Introduzca su clave de acceso para ingresar dinero:");
			int claveAcceso = scanner.nextInt();

			if (cuenta.Acceso(claveAcceso)) {
				String infoCuenta = cuenta.VisualizarCuenta();
				System.out.println(infoCuenta);
			} else {
				System.out.println("Clave incorrecta. No se puede mostrar la informacion");
			}
		} else {
			System.out.println("La cuenta y el dni no coindicen.");
		}
	}
	// Inicialmente comprobamos que el DNI del cliente esta asociado a una cuenta y
	// posteriormente pedimos la clave.

	public void DatosCuenta(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}

		if (cliente != null && cuenta != null && cliente.equals(cuenta.getCliente())) {
			System.out.println("Introduzca su clave de acceso para ingresar dinero:");
			int claveAcceso = scanner.nextInt();

			if (cuenta.Acceso(claveAcceso)) {
				String micuenta = cuenta.DatosCuenta();
				System.out.println(micuenta);
			} else {
				System.out.println("Clave incorrecta. No se puede mostrar la informacion.");
			}
		} else {
			System.out.println("La cuenta y el dni no coindicen.");
		}
	}

	// Inicialmente comprobamos que el DNI del cliente esta asociado a una cuenta y
	// posteriormente pedimos la clave.

	public TiposCuenta TipoCuenta(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}

		if (cliente != null && cuenta != null && cliente.equals(cuenta.getCliente())) {

			System.out.println("Introduzca su clave de acceso para ingresar dinero:");
			int claveAcceso = scanner.nextInt();

			if (cuenta.Acceso(claveAcceso)) {
				String tipo = cuenta.getTipo().name();
				System.out.println("Su tipo de cuenta es: " + tipo);

			} else {
				System.out.println("Clave incorrecta. No se puede mostrar la informacion");
				return null;
			}

		} else {
			System.out.println("La cuenta y el dni no coindicen.");
		}
		return null;
	}

	// Inicialmente comprobamos que el DNI del cliente esta asociado a una cuenta y
	// posteriormente pedimos la clave.

	public void DevolverInteres(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}
		if (cliente != null && cuenta != null && cliente.equals(cuenta.getCliente())) {

			System.out.println("Introduzca su clave de acceso para ingresar dinero:");
			int claveAcceso = scanner.nextInt();

			if (cuenta.Acceso(claveAcceso)) {
				cuenta.DevolverIntereses();
			} else {
				System.out.println("Clave incorrecta. No se puede devolver el interes.");
			}
		} else {
			System.out.println("La cuenta y el dni no coinciden.");
		}
	}

	// Metodos para las tarjetas

	public void sacarDineroTarjetas(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;
		Tarjetas tarjeta = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}

		if (cliente != null && cuenta != null && cliente.equals(cuenta.getCliente())) {
			System.out.println("¿Qué tarjeta deseas utilizar?");
			System.out.println("1. Debito");
			System.out.println("2. Credito");
			System.out.println("3. Monedero");

			int tipoTarjeta = miScan.nextInt();

			switch (tipoTarjeta) {
			case 1:
				for (Debito deb : miDebito) {
					if (deb.getCuentaAsociada() == cuenta) {
						tarjeta = deb;
						break;
					}
				}
				break;

			case 2:
				for (Credito cre : miCredito) {
					if (cre.getCuentaAsociada() == cuenta) {
						tarjeta = cre;
						break;
					}
				}
				break;

			case 3:
				for (Monedero mon : miMonedero) {
					if (mon.getCuentaAsociada() == cuenta) {
						tarjeta = mon;
						break;
					}
				}
				break;

			default:
				System.out.println("Opción no válida");
				return;
			}

			if (tarjeta != null) {
				System.out.print("Ingrese el código PIN: ");
				int codigoPIN = miScan.nextInt();
				if (tarjeta.Acceso(codigoPIN)) {
					System.out.print("Ingrese la cantidad a retirar: ");
					double cantidad = miScan.nextDouble();
					tarjeta.sacaDinero(cantidad);
				} else {
					System.out.println("Código PIN incorrecto. No se puede acceder a la tarjeta.");
				}
			} else {
				System.out.println("La tarjeta asociada a la cuenta no se encontró.");
			}
		} else {
			System.out.println("El cliente asociado a la cuenta no se encontró.");
		}
	}

	public void cargarMonedero(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;
		Tarjetas tarjeta = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}

		if (cliente != null && cuenta != null && cliente.equals(cuenta.getCliente())) {
			for (Monedero mon : miMonedero) {
				if (mon.getCuentaAsociada() == cuenta) {
					tarjeta = mon;
					break;
				}
			}
			if (tarjeta != null) {
				System.out.print("Ingrese el código PIN: ");
				int codigoPIN = miScan.nextInt();
				if (tarjeta.Acceso(codigoPIN)) {
					System.out.print("Ingrese la cantidad a cargar: ");
					double cantidad = miScan.nextDouble();
					tarjeta.cargarMonedero(cantidad);
				} else {
					System.out.println("Código PIN incorrecto. No se puede acceder a la tarjeta.");
				}
			} else {
				System.out.println("La tarjeta asociada a la cuenta no se encontró.");
			}
		} else {
			System.out.println("El cliente asociado a la cuenta no se encontró.");
		}
	}

	public void saldoDisponible(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;
		Tarjetas tarjeta = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}

		if (cliente != null && cuenta != null && cliente.equals(cuenta.getCliente())) {
			System.out.println("¿Qué tarjeta deseas utilizar?");
			System.out.println("1. Debito");
			System.out.println("2. Credito");
			System.out.println("3. Monedero");

			int tipoTarjeta = miScan.nextInt();

			switch (tipoTarjeta) {
			case 1:
				for (Debito deb : miDebito) {
					if (deb.getCuentaAsociada() == cuenta) {
						tarjeta = deb;
						break;
					}
				}
				break;

			case 2:
				for (Credito cre : miCredito) {
					if (cre.getCuentaAsociada() == cuenta) {
						tarjeta = cre;
						break;
					}
				}
				break;

			case 3:
				for (Monedero mon : miMonedero) {
					if (mon.getCuentaAsociada() == cuenta) {
						tarjeta = mon;
						break;
					}
				}
				break;

			default:
				System.out.println("Opción no válida");
				return;
			}

			if (tarjeta != null) {
				System.out.print("Ingrese el código PIN: ");
				int codigoPIN = miScan.nextInt();
				if (tarjeta.Acceso(codigoPIN)) {
					tarjeta.saldoDisponible();
					System.out.println(tarjeta.saldoDisponible());
				} else {
					System.out.println("Código PIN incorrecto. No se puede acceder a la tarjeta.");
				}
			} else {
				System.out.println("La tarjeta asociada a la cuenta no se encontró.");
			}
		} else {
			System.out.println("El cliente asociado a la cuenta no se encontró.");
		}
	}

	public void datosTarjeta(String dniCliente) {
		Cuentas cuenta = null;
		Cliente cliente = null;
		Tarjetas tarjeta = null;

		for (Cuentas cu : miCuenta) {
			if (cu.getCliente().getDni().equals(dniCliente)) {
				cuenta = cu;
				cliente = cu.getCliente();
				break;
			}
		}

		if (cliente != null && cuenta != null && cliente.equals(cuenta.getCliente())) {
			System.out.println("¿Qué tarjeta deseas utilizar?");
			System.out.println("1. Debito");
			System.out.println("2. Credito");
			System.out.println("3. Monedero");

			int tipoTarjeta = miScan.nextInt();

			switch (tipoTarjeta) {
			case 1:
				for (Debito deb : miDebito) {
					if (deb.getCuentaAsociada() == cuenta) {
						tarjeta = deb;
						break;
					}
				}
				break;

			case 2:
				for (Credito cre : miCredito) {
					if (cre.getCuentaAsociada() == cuenta) {
						tarjeta = cre;
						break;
					}
				}
				break;

			case 3:
				for (Monedero mon : miMonedero) {
					if (mon.getCuentaAsociada() == cuenta) {
						tarjeta = mon;
						break;
					}
				}
				break;

			default:
				System.out.println("Opción no válida");
				return;
			}

			if (tarjeta != null) {
				System.out.print("Ingrese el código PIN: ");
				int codigoPIN = miScan.nextInt();
				if (tarjeta.Acceso(codigoPIN)) {
					tarjeta.datosTarjeta();
					System.out.println(tarjeta.datosTarjeta());
				} else {
					System.out.println("Código PIN incorrecto. No se puede acceder a la tarjeta.");
				}
			} else {
				System.out.println("La tarjeta asociada a la cuenta no se encontró.");
			}
		} else {
			System.out.println("El cliente asociado a la cuenta no se encontró.");
		}

	}

	public void altaCreditosPersonales(String dniCliente) {
		try {
		Scanner Rafa1 = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		if (misCliente.isEmpty()) {
			System.out.println("Por favor cree un cliente ante de continuar");
			AltaCliente();
		}

		if (miCuenta.isEmpty()) {
			System.out.println("Por favor cree una cuenta antes de continuar");
			altaCuenta();
		}

		System.out.println("Ingrese el DNI del cliente para completar su Credito Personal:");
		dniCliente = Rafa1.nextLine();
		System.out.println();
		Cliente clienteEncontrado = null;

		for (Cliente c : getMisCliente()) {
			if (c.getDni().equals(dniCliente)) {
				clienteEncontrado = c;
				break;
			}
		}

		if (clienteEncontrado == null) {
			System.out.println("El cliente con DNI " + dniCliente + " no ha sido encontrado");
			System.out.println("Primero debe dar de alta un cliente para abrir la cuenta y asociarla a la misma");
			AltaCliente();
		} else {

			System.out.println("Ingrese la descripción:");
			String descripcion = scanner.nextLine();

			System.out.println("Ingrese la comisión:");
			double comision = Rafa1.nextDouble();

			System.out.println("Ingrese la fecha de inicio (formato dd/mm/yyyy):");
			String fInicio = scanner.nextLine();

			System.out.println("Ingrese la fecha final (formato dd/mm/yyyy):");
			String fFinal = scanner.nextLine();

			System.out.println("Ingrese el cliente asociado");
			Cliente cliente = clienteEncontrado;
			System.out.println(clienteEncontrado.toString());
			System.out.println();

			System.out.println("Ingrese la clave:");
			int clave = scanner.nextInt();
			boolean claveCorrecta = false;

			while (!claveCorrecta) {
				claveCorrecta = true;
				for (Cuentas cu : miCuenta) {
					if (cu.getClave() != clave) {
						System.out.println("La clave introducida no es correcta. Inténtelo de nuevo:");
						clave = scanner.nextInt();
						claveCorrecta = false;
						break;
					}
				}
			}

			System.out.println("Ingrese el saldo solicitado:");
			double saldoSolicitado = scanner.nextDouble();

			System.out.println("Ingrese la devolución:");
			int devolucion = scanner.nextInt();

			System.out.println("Ingrese el interés mensual:");
			double intMensual = scanner.nextDouble();

			System.out.println("Ingrese el interés anual:");
			double intAnuales = scanner.nextDouble();

			scanner.nextLine(); // Limpiar el buffer del scanner

			System.out.println("Ingrese la fecha de revisión (formato dd/mm/yyyy):");
			String fechaRevision = scanner.nextLine();

			System.out.println("Ingrese la fecha de solicitud (formato dd/mm/yyyy):");
			String fechaSolicitud = scanner.nextLine();

			System.out.println("Ingrese la fecha final (formato dd/mm/yyyy):");
			String fechaFinal = scanner.nextLine();

			CreditosPersonales nuevoCreditoP = new CreditosPersonales(descripcion, comision, fInicio, fFinal, cliente,
					clave, saldoSolicitado, devolucion, intMensual, intAnuales, fechaRevision, fechaSolicitud,
					fechaFinal);

			misCPersonales.add(nuevoCreditoP);

			System.out.println(nuevoCreditoP.toString() + clienteEncontrado.toString());
			System.out.println();
		}
	}catch (Exception e) {
        System.out.println("Dato mal introducido. Por favor, inténtelo de nuevo.");
    }
}

	public void ImprimirCreditoP(String dniCliente) {
		boolean tieneCredito = false;
		Cliente cliente = null;

		for (Cliente c : misCliente) {
			if (c.getDni().equals(dniCliente)) {
				cliente = c;
				break;
			}
		}

		if (cliente != null) {
			for (CreditosPersonales miCre : misCPersonales) {
				if (miCre.getClienteAsociado().equals(cliente)) {
					tieneCredito = true;
					System.out.println("El cliente tiene el siguiente crédito personal:");
					System.out.println(miCre);
					System.out.println();
					break;
				}
			}

			if (!tieneCredito) {
				System.out.println("El cliente no tiene crédito personal.");
			}
		} else {
			System.out.println("El cliente con DNI " + dniCliente + " no ha sido encontrado.");
			System.out.println("Por favor, asegurese que tenga un crédito personal.");
		}
	}

	public void altaPrestamos(String dniCliente) {
		try {
		Scanner Rafa1 = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		if (misCliente.isEmpty()) {
			System.out.println("Por favor cree un cliente ante de continuar");
			AltaCliente();
		}

		if (miCuenta.isEmpty()) {
			System.out.println("Por favor cree una cuenta antes de continuar");
			altaCuenta();
		}

		System.out.println("Ingrese el DNI del cliente para completar su Hipoteca:");
		dniCliente = Rafa1.nextLine();
		System.out.println();
		Cliente clienteEncontrado = null;

		for (Cliente c : getMisCliente()) {
			if (c.getDni().equals(dniCliente)) {
				clienteEncontrado = c;
				break;
			}
		}

		if (clienteEncontrado == null) {
			System.out.println("El cliente con DNI " + dniCliente + " no ha sido encontrado");
			System.out.println("Primero debe dar de alta un cliente para abrir la cuenta y asociarla a la misma");
			AltaCliente();
		} else {

			System.out.println("Ingrese la descripción:");
			String descripcion = scanner.nextLine();

			System.out.println("Ingrese la comisión:");
			double comision = Rafa1.nextDouble();

			System.out.println("Ingrese la fecha de inicio (formato dd/mm/yyyy):");
			String fInicio = scanner.nextLine();

			System.out.println("Ingrese la fecha final (formato dd/mm/yyyy):");
			String fFinal = scanner.nextLine();

			System.out.println("Ingrese el cliente asociado");
			Cliente cliente = clienteEncontrado;
			System.out.println(clienteEncontrado.toString());
			System.out.println();

			System.out.println("Ingrese la clave:");
			int clave = scanner.nextInt();
			boolean claveCorrecta = false;

			while (!claveCorrecta) {
				claveCorrecta = true;
				for (Cuentas cu : miCuenta) {
					if (cu.getClave() != clave) {
						System.out.println("La clave introducida no es correcta. Inténtelo de nuevo:");
						clave = scanner.nextInt();
						claveCorrecta = false;
						break;
					}
				}
			}
			
			System.out.println("Ingrese el saldo solicitado:");
			double saldoSolicitado = scanner.nextDouble();

			System.out.println("Ingrese la devolución:");
			int devolucion = scanner.nextInt();

			System.out.println("Ingrese el interés mensual:");
			double intMensual = scanner.nextDouble();

			System.out.println("Ingrese el interés anual:");
			double intAnuales = scanner.nextDouble();

			scanner.nextLine(); // Limpiar el buffer del scanner

			System.out.println("Ingrese la fecha de revisión (formato dd/mm/yyyy):");
			String fechaRevision = scanner.nextLine();

			System.out.println("Ingrese la fecha de solicitud (formato dd/mm/yyyy):");
			String fechaSolicitud = scanner.nextLine();

			System.out.println("Ingrese la fecha final (formato dd/mm/yyyy):");
			String fechaFinal = scanner.nextLine();

			Prestamos nuevoPrestamo = new Prestamos(descripcion, comision, fInicio, fFinal, cliente, clave,
					saldoSolicitado, devolucion, intMensual, intAnuales, fechaRevision, fechaSolicitud, fechaFinal);

			misPrestamos.add(nuevoPrestamo);

			System.out.println(nuevoPrestamo.toString() + clienteEncontrado.toString());
			System.out.println();
		}
	}catch (Exception e) {
        System.out.println("Dato mal introducido. Por favor, inténtelo de nuevo.");
    }
}


	public void ImprimirPrestamos(String dniCliente) {
		boolean tienePrestamo = false;
		Cliente cliente = null;

		for (Cliente c : misCliente) {
			if (c.getDni().equals(dniCliente)) {
				cliente = c;
				break;
			}
		}

		if (cliente != null) {
			for (Prestamos prestamo : misPrestamos) {
				if (prestamo.getClienteAsociado().equals(cliente)) {
					tienePrestamo = true;
					System.out.println("El cliente tiene el siguiente préstamo:");
					System.out.println(prestamo);
					System.out.println();
					break;
				}
			}

			if (!tienePrestamo) {
				System.out.println("El cliente no tiene préstamo.");
			}
		} else {
			System.out.println("El cliente con DNI " + dniCliente + " no ha sido encontrado.");
			System.out.println("Por favor, asegurese que tenga un prestamo.");
		}
	}

	public void altaHipotecas(String dniCliente) {
		try {
		Scanner Rafa1 = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		
		if (misCliente.isEmpty()) {
			System.out.println("Por favor cree un cliente ante de continuar");
			AltaCliente();
		}

		if (miCuenta.isEmpty()) {
			System.out.println("Por favor cree una cuenta antes de continuar");
			altaCuenta();
		}

		System.out.println("Ingrese el DNI del cliente para completar su Hipoteca:");
		dniCliente = Rafa1.nextLine();
		System.out.println();
		Cliente clienteEncontrado = null;

		for (Cliente c : getMisCliente()) {
			if (c.getDni().equals(dniCliente)) {
				clienteEncontrado = c;
				break;
			}
		}

		if (clienteEncontrado == null) {
			System.out.println("El cliente con DNI " + dniCliente + " no ha sido encontrado");
			System.out.println("Primero debe dar de alta un cliente para abrir la cuenta y asociarla a la misma");
			AltaCliente();
		} else {

			System.out.println("Ingrese la descripción:");
			String descripcion = scanner.nextLine();

			System.out.println("Ingrese la comisión:");
			double comision = Rafa1.nextDouble();

			System.out.println("Ingrese la fecha de inicio (formato dd/mm/yyyy):");
			String fInicio = scanner.nextLine();

			System.out.println("Ingrese la fecha final (formato dd/mm/yyyy):");
			String fFinal = scanner.nextLine();

			System.out.println("Ingrese el cliente asociado");
			Cliente cliente = clienteEncontrado;
			System.out.println(clienteEncontrado.toString());
			System.out.println();

			System.out.println("Ingrese la clave:");
			int clave = scanner.nextInt();
			boolean claveCorrecta = false;

			while (!claveCorrecta) {
				claveCorrecta = true;
				for (Cuentas cu : miCuenta) {
					if (cu.getClave() != clave) {
						System.out.println("La clave introducida no es correcta. Inténtelo de nuevo:");
						clave = scanner.nextInt();
						claveCorrecta = false;
						break;
					}
				}
			}

			System.out.println("Ingrese el saldo solicitado:");
			double saldoSolicitado = scanner.nextDouble();

			System.out.println("Ingrese la devolución:");
			int devolucion = scanner.nextInt();

			System.out.println("Ingrese el interés mensual:");
			double intMensual = scanner.nextDouble();

			System.out.println("Ingrese el interés anual:");
			double intAnuales = scanner.nextDouble();

			scanner.nextLine(); // Limpiar el buffer del scanner

			System.out.println("Ingrese la fecha de revisión (formato dd/mm/yyyy):");
			String fechaRevision = scanner.nextLine();

			System.out.println("Ingrese la fecha de solicitud (formato dd/mm/yyyy):");
			String fechaSolicitud = scanner.nextLine();

			System.out.println("Ingrese la fecha final (formato dd/mm/yyyy):");
			String fechaFinal = scanner.nextLine();

			Hipotecas nuevaHipoteca = new Hipotecas(descripcion, comision, fInicio, fFinal, cliente, clave,
					saldoSolicitado, devolucion, intMensual, intAnuales, fechaRevision, fechaSolicitud, fechaFinal);

			misHipotecas.add(nuevaHipoteca);

			System.out.println(nuevaHipoteca.toString() + clienteEncontrado.toString());
			System.out.println();
		}

	}catch (Exception e) {
        System.out.println("Dato mal introducido. Por favor, inténtelo de nuevo.");
    }
}


	public void ImprimirHipotecas(String dniCliente) {
		boolean tieneHipoteca = false;
		Cliente cliente = null;

		for (Cliente c : misCliente) {
			if (c.getDni().equals(dniCliente)) {
				cliente = c;
				break;
			}
		}

		if (cliente != null) {
			for (Hipotecas hipoteca : misHipotecas) {
				if (hipoteca.getClienteAsociado().equals(cliente)) {
					tieneHipoteca = true;
					System.out.println("El cliente tiene la siguiente hipoteca:");
					System.out.println(hipoteca);
					System.out.println();
					break;
				}
			}

			if (!tieneHipoteca) {
				System.out.println("El cliente no tiene hipoteca.");
			}
		} else {
			System.out.println("El cliente con DNI " + dniCliente + " no ha sido encontrado.");
			System.out.println("Por favor, asegurese que tenga una hipoteca.");
		}
	}
}