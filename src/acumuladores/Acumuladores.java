package acumuladores;

public class Acumuladores {

	/**
	 * Dada una matriz de enteros y un número, verifica si existe alguna fila 
	 * donde todos sus elementos sean múltiplos del número recibido por 
	 * parámetro.
	 * 
	 * Si la matriz está vacía o si el número no es positivo, devuelve falso.
	 * 
	 * @param mat
	 * @param num
	 * @return
	 */
	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) { 
		if (mat==null||mat.length==0||num<=0){
			return false;
		}
		boolean todosMulNumCol = false;
		for (int col=0; col<mat[0].length; col++){
			
			todosMulNumCol = todosMulNumCol || columnaMultiploNum(mat, col, num);
		}
		return todosMulNumCol;

		//		throw new RuntimeException("Metodo no implementado aun!!!");
	}
	public boolean columnaMultiploNum(int mat[][],int col, int num){
		boolean esMultDeNum = true;
		for (int fila=0; fila<mat.length; fila++){
			esMultDeNum = esMultDeNum && mat[fila][col]%num==0;
		}
		return esMultDeNum;
	}

	
	/**
	 * Dado 2 matrices se verifica si hay intersección entre las filas de cada
	 * matriz, fila a fila.
	 * 
	 * Si las matrices tienen distinta cantidad de filas o si alguna matriz 
	 * está vacía, devuelve falso.
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	
	public boolean hayInterseccionPorFila(int[][] mat1, int[][]mat2) { 
		if (mat2.length==0||mat1.length==0||mat1==null||mat2==null || mat1.length!= mat2.length){
			return false;
		}
		boolean todasFilMult = true;
		for(int f=0;f<mat1.length;f++) {
			todasFilMult= todasFilMult && algunaInterPorFila(mat1, mat2, f);
		}
		return todasFilMult;
		
//		throw new RuntimeException("Metodo no implementado aun!!!");
	}
	public boolean hayInterEnUnaFila(int[][] mat, int num,int f){
		boolean igual=false;
		for (int c=0;c<mat[0].length;c++){
			igual=igual||mat[f][c]==num;
		}
		return igual;
	} 
	public boolean algunaInterPorFila(int[][] mat1, int[][]mat2, int f) { 
		boolean algunaIntersecFil = false;
		for(int c=0;c<mat1[0].length;c++){
			algunaIntersecFil = algunaIntersecFil || hayInterEnUnaFila(mat2, mat1[f][c], f);
		}
		return algunaIntersecFil;
	}
	/**
	 * Dada una matriz y el índice de una columna, se verifica si existe alguna
	 * fila cuya suma de todos sus elementos sea mayor estricto que la suma de
	 * todos los elementos de la columna indicada por parámetro.
	 * 
	 * Si el índice de la columna es inválido o la matriz está vacía, devuelve 
	 * falso.
	 * 
	 * @param mat
	 * @param nColum
	 * @return
	 */
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) { 
//		throw new RuntimeException("Metodo no implementado aun!!!");
		if ((mat.length==0 || mat==null)||(nColum<0 || nColum>mat.length)) {
			return false;
		}
		boolean algunaFil = false;
		for (int f=0; f<mat.length; f++){
		algunaFil = algunaFil || compara(sumaColumna(mat, nColum), sumaFila(mat, f));
		}
		return algunaFil;
	}
	public int sumaFila (int[][] mat, int f){
			int suma = 0;
			for (int c=0;c<mat[0].length; c++){
				suma=suma+mat[f][c];
			}
			return suma;
		}
	public int sumaColumna (int[][] mat, int c){
		int suma = 0;
		for (int f=0; f<mat.length; f++){
			suma=suma+mat[f][c];
		}
		return suma;
	}
	public boolean compara(int sumaCol, int sumaFil){
		return sumaCol<sumaFil;
	}

	
	/**
	 * Dadas 2 matrices, se verifica si hay intersección entre las columnas de
	 * cada matriz, columna a columna.
	 * 
	 * Si las matrices tienen distinta cantidad de columnas o alguna matriz 
	 * está vacía, devuelve falso. 
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorColumna(int[][] mat1, int[][]mat2) { 
//		throw new RuntimeException("Metodo no implementado aun!!!");
		if(mat1==null || mat2==null || mat1.length==0 || mat2.length==0 ||
				   mat1[0].length!=mat2[0].length){
					return false;
		}
		boolean interseccionColumna = true;
		for (int col=0;col<mat1[0].length;col++){
			interseccionColumna = interseccionColumna && igualNumEnCol(mat1, mat2, col); 
		}
		return interseccionColumna;
	}
	public boolean igualNumEnCol(int[][] mat1, int[][]mat2, int col) {
		boolean igual = false;
		for(int f=0; f<mat1.length; f++){
			igual = igual || comparar(mat2, mat1[f][col], col);
		}
		return igual;
	}
	public boolean comparar(int[][] mat, int num, int c){
		boolean resul = false;
		for (int f=0; f<mat.length; f++){
			resul = resul || mat[f][c]==num;
		}
		return resul;
	}
}
