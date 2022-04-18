package proyecto1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;

public class Programa_final_sesion9 {

	public static void main(String[] args) {
		
		int contador = 0;
		
		int[] datos_entrada = new int[74456];
		
		//Leer un archivo de imagen e imprimirlo en uno nuevo
		
		try {
			InputStream imageIn = new FileInputStream("C:\\Users\\usuario\\Pictures\\2014-07-14 001\\Diseño final del ángel.jpg");
			
			boolean final_archivo = false;
			
			//while - lector de bytes
			while(!final_archivo) {
				
				int byte_entrada = imageIn.read();
				
				if(byte_entrada!= -1) {
					
					datos_entrada[contador] = byte_entrada;
					
				} else{
					
					final_archivo = true;
					
				}
				
				System.out.println(datos_entrada[contador]);
				
				contador++;
				
			}
			
			imageIn.close();
				
		}catch(Exception e) {
			System.out.println("No puede accederse a la imagen. " + e.getMessage());
		}
		
		System.out.println(contador);
		
		crea_fichero(datos_entrada);
		
		//Crea un HashMap
		HashMap<Integer, String> indice_sup_americana = new HashMap<>();
	
		indice_sup_americana.put(1, "Canada");
		indice_sup_americana.put(2, "Estados Unidos");
		indice_sup_americana.put(3, "Brasil");
		indice_sup_americana.put(4, "Argentina");
		indice_sup_americana.put(5, "México");
		indice_sup_americana.put(6, "Peru");
		indice_sup_americana.put(7, "Colombia");
		indice_sup_americana.put(8, "Bolivia");
		indice_sup_americana.put(9, "Venezuela");
		indice_sup_americana.put(10, "Chile");
		indice_sup_americana.put(11, "Paraguay");
		indice_sup_americana.put(12, "Ecuador");
		indice_sup_americana.put(13, "Uruguay");
		indice_sup_americana.put(14, "Surinam");
		indice_sup_americana.put(15, "Nicaragua");
		indice_sup_americana.put(16, "Honduras");
		indice_sup_americana.put(17, "Cuba");
		indice_sup_americana.put(18, "Guatemala");
		indice_sup_americana.put(19, "Panama");
		indice_sup_americana.put(20, "Costa Rica");
		indice_sup_americana.put(21, "Republica Dominicana");
		indice_sup_americana.put(22, "Haití");
		indice_sup_americana.put(23, "Belice");
		indice_sup_americana.put(24, "El Salvador");
		indice_sup_americana.put(25, "Bahamas");
		indice_sup_americana.put(26, "Jamaica");
		indice_sup_americana.put(27, "Trinidad y Tobago");
		indice_sup_americana.put(28, "Dominica");
		indice_sup_americana.put(29, "Santa Lucia");
		indice_sup_americana.put(30, "Antigua y Barbuda");
		indice_sup_americana.put(31, "Barbados");
		indice_sup_americana.put(32, "San Vicente y las Granadinas");
		indice_sup_americana.put(33, "Granada");
		indice_sup_americana.put(34, "San Cristobal y Nieves");
		
		//Imprimiendo el HashMap en un nuevo fichero
		try {
			PrintStream fileOut = new PrintStream("C:\\Users\\usuario\\Desktop\\Data america.txt");
				
				Iterator<Integer> it = indice_sup_americana.keySet().iterator(); 
				int cont = 0;
				
				while(it.hasNext()) {
					
					Integer clave = it.next();
					String valor = indice_sup_americana.get(clave);
					fileOut.println(clave + " - " + valor);
					cont++;
					
				}
				fileOut.close();
				
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
		//Leyendo el contenido del fichero destino del HashMap
		try {
			
			InputStream fileIn = new FileInputStream("C:\\Users\\usuario\\Desktop\\Data america.txt");
			
			byte[] datos_externo = fileIn.readAllBytes();
			
			System.out.println("Contenido del fichero: ");
			
			for(byte dato : datos_externo) {
				
				System.out.print((char)dato);
			}
			fileIn.close();
			
		}catch(Exception e) {
			
			System.out.println("El archivo no pudo ser leído " + e.getMessage());
		}
	}
	
	//Metodo para crear un fichero, recibiendo un array como parametro 
	
	static void crea_fichero(int data_new_file[]) {
		
		try {
			
			FileOutputStream copia_fichero = new FileOutputStream("C:\\Users\\usuario\\Pictures\\2014-07-14 001\\Diseño final del ángel - copia.jpg");
			
			for(int i = 0; i < data_new_file.length; i++) {
				
				copia_fichero.write(data_new_file[i]);
				
			}
			
		copia_fichero.close();
		
		}catch(IOException e) {
			
			System.out.println("Error al crear el fichero." + e.getMessage());
	}
}
}	
