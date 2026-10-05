package recursividad;

import java.util.Arrays;

public class Backtracking {
	
	static class Laberinto {
		int[][] mapa;
		
		public Laberinto (int[][] mapa){
			this.mapa = mapa;
		}
		
		@Override
		public String toString() {
			String resultado = "";

	        for (int[] fila : mapa) {
	            for (int valor : fila) {
	                resultado += valor + " ";
	            }
	            resultado += "\n";
	        }
	        return resultado;
		}
	}

	public static String matrizToString(int[][] arr) {
		String resultado = "";

        for (int[] fila : arr) {
            for (int valor : fila) {
                resultado += valor + " ";
            }
            resultado += "\n";
        }

        return resultado;
	}
	
	
	public static boolean camino(Laberinto laberinto, int fila,
			int columna, boolean[][] visitado) {
		
        System.out.println("Intento: (" + fila + ", " + columna + ")");
		
		// Fuera de límites
		if (fila < 0 || fila > laberinto.mapa.length - 1 ||
				columna < 0 || columna > laberinto.mapa[0].length - 1) {
			return false;
		}
		
		// Choco
		if (laberinto.mapa[fila][columna] == 1) {
			return false;
		}
		
		// Visitado
		if (visitado[fila][columna] == true) {
			return false;
		}
		
		// Salida
		if (fila == laberinto.mapa.length - 1 && 
				columna == laberinto.mapa[0].length - 1) {
			laberinto.mapa[fila][columna] = 2;
			return true;
		}
		
		// Backtracking
		
 		// PRUEBO
		laberinto.mapa[fila][columna] = 2;
		visitado[fila][columna] = true;
		
		System.out.println(laberinto);
		
		// EXPLORO
		if (camino(laberinto, fila, columna + 1, visitado) ||
				camino(laberinto, fila, columna - 1, visitado) ||
				camino(laberinto, fila + 1, columna, visitado) || 
				camino(laberinto, fila - 1, columna, visitado)) {
			return true;
		}
		
		// VUELVO
		laberinto.mapa[fila][columna] = 0;
        
		System.out.println("Retrocedo desde: (" + fila + ", " + columna + ")");
        System.out.println(laberinto);
		
		return false;
	}
	
	
	public static void main(String[] args) {
		int[][] mapa = {
	            {0, 0, 1, 0},
	            {1, 0, 0, 0},
	            {0, 0, 1, 1},
	            {0, 0, 0, 0}
	        };
		
	    boolean[][] visitado = {
	            {false, false, false, false},
	            {false, false, false, false},
	            {false, false, false, false},
	            {false, false, false, false}
	        };
		Laberinto laberinto = new Laberinto(mapa);
		
		System.out.println(camino(laberinto, 0, 0, visitado));
		System.out.println(laberinto);
	}
}
