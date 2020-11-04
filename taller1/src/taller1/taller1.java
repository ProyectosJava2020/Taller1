package taller1;
import java.io.IOException;

import ucn.*;
/**
 * 
 * @author alexi
 *
 */
public class taller1 {
	/**
	 * This subprogram read the file computadores.txt and add elements in the parallel vectors 
	 */
	public static int leerProductos(String[]codigo,String[]marca,String[]modelo,int[]precio,int[]stock)throws IOException{
		ArchivoEntrada productos=new ArchivoEntrada("computadores.txt");
		int count=0;//number element entered in vector of one dimension
		while(!productos.isEndFile()) {
			Registro reg=productos.getRegistro();
			
			String codigo1=reg.getString();
			String marca1=reg.getString();
			String modelo1=reg.getString();
			int precio1=reg.getInt();
			int stock1=reg.getInt();
			if((precio1>=250000)&&(precio1<=1000000)) {// add elements between this range
				codigo[count]=codigo1;
				marca[count]=marca1;
				modelo[count]=modelo1;
				precio[count]=precio1;
				stock[count]=stock1;
				count++;
			}
		}
		productos.close();
		return count;
		
	}
	/**
	 *  This subprogram read the file clientes.txt and add elements in the parallel vectors 
	 
	 */
	public static int leerClientes(String[]rut,String[]nombre,String[]apellido)throws IOException{
		ArchivoEntrada clientes=new ArchivoEntrada("clientes.txt");
		int count1=0;//-  number element entered in vector of one dimension
		while(!clientes.isEndFile()) {
			Registro cli=clientes.getRegistro();
		
			String rut1=cli.getString();
			String nombre1=cli.getString();
			String apellido1=cli.getString();
			
			rut[count1]=rut1;
			nombre[count1]=nombre1;
			apellido[count1]=apellido1;
			
			count1++;
			
		}
		clientes.close();
		return count1;
		

	}
	/**
	 *  This subprogram read the file cupones.txt and add elements in the parallel vectors 
	 
	 */
	
	public static int leerCupones(String[]codigoN,int[]montoDesc)throws IOException{
		ArchivoEntrada cupones=new ArchivoEntrada("cupones.txt");
		int count2=0;//-  number element entered in vector of one dimension
		while(!cupones.isEndFile()) {
			Registro cu=cupones.getRegistro();
			
			String codigoN1=cu.getString();
			int montoDes1=cu.getInt();
			if(montoDes1>=10000&&montoDes1<=50000) { //add elements between this range
				codigoN[count2]=codigoN1;
				montoDesc[count2]=montoDes1;
				count2++;
			}
		}
		cupones.close();
		return count2;
	}
	/**
	 * this subprogram read the parallels vectors and add this elements at file clientes.txt
	 */
	
	public static void CodigoSalidaClientes(String[]lista1, String []lista2,String[]lista3,int tamaño) throws IOException {
		ArchivoSalida arch2=new ArchivoSalida("clientes.txt");
		for(int i=0;i<tamaño;i++) {//add to each line elements of each vector
			Registro registroSalida=new Registro(3);
			registroSalida.agregarCampo(lista1[i]);
			registroSalida.agregarCampo(lista2[i]);
			registroSalida.agregarCampo(lista3[i]);
			arch2.writeRegistro(registroSalida);
		}
		arch2.close();
	}
	/**
	 * this subprogram read the parallels vectors and add this elements at file cupones.txt
	 */
	public static void CodigoSalidaCupones(String[]lista10,int[]lista20,int cantidadElement)throws IOException{
		ArchivoSalida arch3=new ArchivoSalida("cupones.txt");
		for(int i=0;i<cantidadElement;i++) {//add to each line elements of each vector
			Registro registroSalida=new Registro(2);
			registroSalida.agregarCampo(lista10[i]);
			registroSalida.agregarCampo(lista20[i]);
			arch3.writeRegistro(registroSalida);
		}
		arch3.close();
			
	}
	/**
	 * this subprogram read the parallels vectors and add this elements at file computadores.txt
	 */
	public static void CodigoSalidaStock(String[]lista100,String[]lista200,String[]lista300,int[]lista400,int[]lista500,int cantidad)throws IOException{
		ArchivoSalida arch4=new ArchivoSalida("computadores.txt");
		for(int i=0;i<cantidad;i++) {//add to each line elements of each vector
			Registro registroSalida=new Registro(5);
			registroSalida.agregarCampo(lista100[i]);
			registroSalida.agregarCampo(lista200[i]);
			registroSalida.agregarCampo(lista300[i]);
			registroSalida.agregarCampo(lista400[i]);
			registroSalida.agregarCampo(lista500[i]);
			arch4.writeRegistro(registroSalida);
		}
		arch4.close();
			
	}
	/**
	 * this subprogram view main menu
	 */
	public static void menuPrincipal(){
		StdOut.println("Bienvenido a FallaDeuda");
		StdOut.println("1) iniciar sesion");
		StdOut.println("2) Ingresar usuario nuevo");
		StdOut.println("3) Cerrar sistema");
	}
	/**
	 * this subprogram view second menu
	 */
	public static void menuSecundario1() {
		StdOut.println("1) Realizar compra");
		StdOut.println("2) Cerrar Sesion");
	}
	/**
	 * this subprogram view  menu for shopping
	 */
	public static void menuMetodoPago() {
		StdOut.println("Metodo de pago");
		StdOut.println("1) Tarjeta de Credito");
		StdOut.println("2) Tarjeta Debito");
	}
	/**
	 * this subprogram view administrator menu
	 */
	public static void menuAdmi(){
		StdOut.println("Usted ha ingresado como administrador de FallaDeuda");
		StdOut.println("1) Desplegar clientes registrados en el sistema");
		StdOut.println("2) Desplegar Stock disponible de cada producto");
		StdOut.println("3) Añadir stock de productos");
		StdOut.println("4) Ventas realizadas");
		StdOut.println("5) Compras Realizadas");
		StdOut.println("6) Cerrar Sesion");
			
	}
	/**
	 * this subprogram register news users in the parallels vectors from file clientes.txt
	 */
	public static int registrarUsuarioNuevo(String []nombre,String []rut,String []apellido,int cantClientes) throws IOException{
		
		StdOut.print("Ingrese Rut para registrar: ");
		String rutRegis=StdIn.readString();
		StdOut.print("Ingrese nombre para registrar: ");
		String nombreRegis=StdIn.readString();
		StdOut.print("Ingrese apellido para registrar: ");
		String apellidoRegis=StdIn.readString();
		rut[cantClientes]=rutRegis;
		nombre[cantClientes]=nombreRegis;
		apellido[cantClientes]=apellidoRegis;
		cantClientes++;
		return cantClientes;
	}
	/**
	 * method main
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
		String [] codigo=new String[200];  
		String [] marca=new String[200];  
		String [] modelo=new String[200]; 
		int [] precio=new int[200]; 
		int [] stock=new int[200]; 
		int cantComputadores=leerProductos(codigo,marca,modelo,precio,stock);  
		
		String [] rut=new String[200];
		String [] nombre=new String[200];
		String [] apellido=new String[200];
		int cantClientes=leerClientes(rut,nombre,apellido);
		
		String [] codigoN=new String[200];
		int []montoDesc=new int[200];
		int cantCupones=leerCupones(codigoN,montoDesc);
		
		int conDebito=0;
		int conCredito=0;
		int sumadorVentas=0;
		
		String[]RutComprador=new String[200];
		String[]productoComprado=new String[200];
		String[]Comprador=new String[200];
		String[]metodoPago=new String[200];
		int []montoPagado=new int[200];
		int cantVentasRealizadas=0;
		
		menuPrincipal();
		StdOut.print("Elija una opcion: ");
		int option=StdIn.readInt();
		while(option!=3) {
			if(option==2) {//register new user
				cantClientes=registrarUsuarioNuevo(nombre,rut,apellido,cantClientes);
				StdOut.println("registro completo");
			}
			if(option==1) {//login
				StdOut.print("Ingrese Rut del cliente: ");
				String Rut=StdIn.readString();
				if(Rut.equals("admin")) {//option for administrator
					menuAdmi();
					StdOut.println("ingrese la opcion segun el requerimiento a manipular: ");
					int opcionElegida=StdIn.readInt();
					while(opcionElegida!=6) {//sign off
						
						if(opcionElegida==1) {//view registered user in falladeuda
							
							StdOut.println("Rut - Nombre - Apellido");
							for(int i=0;i<cantClientes;i++) {
								StdOut.println(rut[i]+" - "+nombre[i]+" - "+apellido[i]);
							}
							StdOut.println("Ir al Menu (si/) :");
							String opcione12=StdIn.readString();
							while(!opcione12.equals("si")) {//back to the menu
								StdOut.println("Ir al Menu (si) :");
								opcione12=StdIn.readString();	
							}
							
						}
						
						if(opcionElegida==2) {//
							StdOut.println("Marca  Modelo  Stock");
							for(int i=0;i<cantComputadores;i++) {
								StdOut.println(marca[i]+"  "+modelo[i]+"  "+stock[i]);	
							}
							StdOut.println("Ir al Menu (si) :");
							String opcione123=StdIn.readString();
							while(!opcione123.equals("si")) {//back to the menu
								StdOut.println("Ir al Menu (si) :");
								opcione123=StdIn.readString();
								
							}
							
						}
						if(opcionElegida==3) {//search product code for add stock
							
							while(true) {
								StdOut.print("Ingrese codigo del producto:");
								String CodProduc=StdIn.readString();
								int variable=0;
								while(variable<cantComputadores&&!CodProduc.equals(codigo[variable])) {
									variable++;
								}
								if(variable==cantComputadores) {
									StdOut.println("Error Codigo Invalido");
								}
								else {
									StdOut.println(marca[variable]+"  "+modelo[variable]+"  "+stock[variable]);
									StdOut.print("ingrese Stock a agregar: ");
									int stockAgregado=StdIn.readInt();
									stock[variable]+=stockAgregado;
									StdOut.println("Stock agregado correctamente: ");	
									
								}
								StdOut.println("1) Ingresar otro codigo de producto "); 
								StdOut.println("2) Ir al Menu ");
								StdOut.print("Ingrese opcion: ");
								int  opcione124=StdIn.readInt();
								if(opcione124==2) {
									break;
								}
							}
						}
						if(opcionElegida==4) {//purchased computers and information from total purchases
								StdOut.println("ProductoComprado  Comprador  Montopagado  metodoPago");
								for(int t=0;t<cantVentasRealizadas;t++) {
									StdOut.println(productoComprado[t]+"  "+Comprador[t]+"   $"+montoPagado[t]+"  "+metodoPago[t]);
									
								}
								StdOut.println("Monto Total Recaudado");
								int contadorVentas=conDebito+conCredito; 
								double porcentajeDebito=(conDebito*100)/contadorVentas;
								double porcentajeCredito=(100*conCredito)/contadorVentas;
								
								StdOut.println(sumadorVentas+"   ("+porcentajeDebito+"% debito"+"  "+porcentajeCredito+"% credito");
								StdOut.println("Ir al Menu (si/no) :");
								String opcione125=StdIn.readString();
								while(!opcione125.equals("si")) {
									StdOut.println("Ir al Menu (si): ");
									opcione125=StdIn.readString();
									
								}
							
						}
						if(opcionElegida==5) {
							
							while(true) {
								StdOut.print("Ingrese rut del comprador a buscar: ");
								String RutBuscar=StdIn.readString();
								int r=0;
								while(r<cantClientes&&!RutBuscar.equals(RutComprador[r])) {
									r++;
								}
								if(r==cantClientes) {
									StdOut.println("Rut no registrado con compras");
								}
								else {
									StdOut.println("Nombre  ProductoComprado  MontoPagado");  // si hay yn nombre igual en el
									StdOut.println(Comprador[r]+"    "+productoComprado[r]+"      $"+montoPagado[r]);//archivo me va	
										// 
								}
								StdOut.println("1) Ingresar otro rut de comprador ");
								StdOut.println("2) Ir al Menu ");
								StdOut.print("Ingrese opcion: ");
								int  opcione126=StdIn.readInt();
								if(opcione126==2) {
									break;
								}
								
							}
								
							
						}
						menuAdmi();
						StdOut.println("ingrese la opcion segun el requerimiento a manipular: ");
						opcionElegida=StdIn.readInt();
					}		
				}
				else {
					int p=0; // search a element in the vectors
					while(p<cantClientes && !rut[p].equals(Rut)) {
						p++;
					}
					if(p==cantClientes) {
						StdOut.println("El cliente no se encuentra registrado en el sistema");
						StdOut.println("Debe registarse como nuevo usuario o bien ingresar con rut registrado");
						StdOut.println("1) registrar nuevo cliente");
						StdOut.println("2) ingresar con rut registrado");
						StdOut.print("Ingrese opcion: ");
						int opcion=StdIn.readInt();
						if(opcion==2) {
							StdOut.print("Inicie Sesion nuevamente");
							StdOut.println("");
						}
						else {
							cantClientes=registrarUsuarioNuevo(nombre,rut,apellido,cantClientes);
							
						}
					}
					else {//login 
						StdOut.println("sesion iniciada");
						menuSecundario1();
						StdOut.println("Digite opcion: ");
						int opcione2=StdIn.readInt();
						if(opcione2==2) {
						}
						else {
							StdOut.println("codigo - marca - modelo - precio - stock");
							int s=0;
							while(s<cantComputadores) {
								if(stock[s]>0) {//views computers with stock
									StdOut.println(codigo[s]+" - "+marca[s]+" - "+modelo[s]+" - "+precio[s]+" - "+stock[s]);		
								}
								s++;	
							}
					
							while(true) {
								StdOut.print("ingrese codigo de computador a comprar: ");
								String compra=StdIn.readString();
								int g=0;
								while((g<cantComputadores)&&(!codigo[g].equals(compra))) {
									g++;
								}
								if(g==cantComputadores) {
									StdOut.println("codigo invalido");//back for request other computer code
									
								}
								else {
									while(true) {
										StdOut.print("El cliente usara un cupon de descuento (si/no): ");
										String descu=StdIn.readString();
										
										if(descu.equals("si")) {
											StdOut.print("Ingrese codigo de cupon: ");
											String cupone=StdIn.readString();
											int a=0;
										
											while((a<cantCupones)&&(!cupone.equals(codigoN[a]))) {
												a++;
											}
											if(a==cantCupones){
												StdOut.println("cupon invalido,ingrese otro cupon o bien siga con la compra");	
												//back for request a another coupon 
											}
											else {
												StdOut.println("cupon valido");
												menuMetodoPago();
												StdOut.print("ingrese opcion (1)/(2): ");
												int opc=StdIn.readInt();
												if(opc==1){
													conCredito++;
													StdOut.println("compra realizada con exito");
													int ke=0;
													while(ke<cantComputadores&&!compra.equals(codigo[ke])) {
														ke++;
													}
													if(ke==cantComputadores) {
													}
										
													else {
														if(stock[ke]>0) {
															stock[ke]--;
														}
														sumadorVentas+=(precio[ke]-montoDesc[a]);
														RutComprador[cantVentasRealizadas]=Rut;
															
														productoComprado[cantVentasRealizadas]=compra;	
														Comprador[cantVentasRealizadas]=Rut;
														metodoPago[cantVentasRealizadas]="Tarjeta Credito";
														montoPagado[cantVentasRealizadas]=(precio[ke]-montoDesc[a]);
														cantVentasRealizadas++;
														
														for(int k=a;k<cantCupones-1;k++) {//remove coupon used
															codigoN[k]=codigoN[k+1];
															montoDesc[k]=montoDesc[k+1];
														}
														cantCupones--;
														
														StdOut.print("Cerrar sesion SI/NO: ");
														String apro=StdIn.readString();
														while(!apro.equals("si")) {
															StdOut.println("Debe cerrar sesion");
															StdOut.print("Cerrar sesion SI/NO: ");
															apro=StdIn.readString();	
														}
														break;
													}
												}
														
												else {
													conDebito++;
													StdOut.println("compra realizada con exito");
													int ke=0;
													while(ke<cantComputadores&&!compra.equals(codigo[ke])) {
														ke++;
													}
													if(ke==cantComputadores) {
													}
										
													else {
														if(stock[ke]>0) {
															stock[ke]--;
															
														}
														sumadorVentas+=(precio[ke]-montoDesc[a]);
														RutComprador[cantVentasRealizadas]=Rut;
															
														productoComprado[cantVentasRealizadas]=compra;	
														Comprador[cantVentasRealizadas]=Rut;
														metodoPago[cantVentasRealizadas]="Tarjeta Debito";
														montoPagado[cantVentasRealizadas]=(precio[ke]-montoDesc[a]);
														cantVentasRealizadas++;
														
														for(int k=a;k<cantCupones-1;k++) {//remove coupon used
															codigoN[k]=codigoN[k+1];
															montoDesc[k]=montoDesc[k+1];
														}
														cantCupones--;
														StdOut.print("Cerrar sesion SI/NO: ");
														String apro=StdIn.readString();
														while(!apro.equals("si")) {
															StdOut.println("Debe cerrar sesion");
															StdOut.print("Cerrar sesion SI/NO: ");
															   apro=StdIn.readString();	
														}
														break;
													}
													
												}
											}
										}
										else {
											menuMetodoPago();
											
											StdOut.print("ingrese opcion (1)/(2): ");
											int opc12=StdIn.readInt();
											
											if(opc12==1) {
												StdOut.println("compra realizada con exito");
												conCredito++;
												int ke=0;
												while(ke<cantComputadores&&!compra.equals(codigo[ke])) {
													ke++;
												}
												if(ke==cantComputadores) {
												}
									
												else {
													if(stock[ke]>0) {
														stock[ke]--;
													
													}
													sumadorVentas+=precio[ke];
													RutComprador[cantVentasRealizadas]=Rut;
														
													productoComprado[cantVentasRealizadas]=compra;	
													Comprador[cantVentasRealizadas]=Rut;
													metodoPago[cantVentasRealizadas]="Tarjeta Credito";
										
													montoPagado[cantVentasRealizadas]=precio[ke];
													cantVentasRealizadas++;
													StdOut.print("Cerrar sesion SI/NO: ");
													String apro=StdIn.readString();
													while(!apro.equals("si")) {
														StdOut.println("Debe cerrar sesion");
														StdOut.print("Cerrar sesion SI/NO: ");
														apro=StdIn.readString();	
													}
												
													break;
												}
											
											}
													
											else {
												conDebito++;
												StdOut.println("compra realizada con exito");
												int ke=0;
												while(ke<cantComputadores&&!compra.equals(codigo[ke])) {
													ke++;
												}
												if(ke==cantComputadores) {
												}
									
												else {
													if(stock[ke]>0) {
														stock[ke]--;
														
													}
													sumadorVentas+=precio[ke];
													RutComprador[cantVentasRealizadas]=Rut;
													
									
													productoComprado[cantVentasRealizadas]=compra;	
													Comprador[cantVentasRealizadas]=Rut;
													metodoPago[cantVentasRealizadas]="Tarjeta Debito";
										
													montoPagado[cantVentasRealizadas]=precio[ke];
													cantVentasRealizadas++;
													StdOut.print("Cerrar sesion SI/NO: ");
													String apro=StdIn.readString();
													while(!apro.equals("si")) {
														StdOut.println("Debe cerrar sesion");
														StdOut.print("Cerrar sesion si/no: ");
														   apro=StdIn.readString();	
													}
												}
											}
											break;
												
											
										}
										
										
									}
								    
								}
								break;
							}		
						}
					}
			    }
			}
			menuPrincipal();
			StdOut.print("ingrese opcion:");
			option=StdIn.readInt();
		}
		CodigoSalidaClientes(rut,nombre,apellido,cantClientes);
		CodigoSalidaCupones(codigoN,montoDesc,cantCupones);
		CodigoSalidaStock(codigo,marca,modelo,precio,stock,cantComputadores);
	}
}


