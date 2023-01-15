package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class depth {
	
	public static int getCapacity(int depth, int fin, int inicio) {
		System.out.println("fin: " + fin);
		System.out.println("Inicio: " + inicio);
		if (fin < inicio) {
			return fin - depth;
		} else {
			return inicio - depth;
		}
	}
	
	public static int getDepthMax(int[] A, int fin, int inicio) {
		List<Integer> list = new ArrayList<>();
		
		for (int i = inicio + 1; i < fin; i++) {
			list.add(A[i]);
		}
		if (list.size() == 0) {
			return -1;
		}
		System.out.println("getDepth: " + list);
		return Collections.min(list);
	}

	public static int getIndex(int[] A, int limite, int search) {
		for (int i = limite - 1; i >= 0; i--) {
			System.out.println("A[I]: " + A[i]);
			System.out.println("search: " + search);
			if (A[i] == search) {
				return i;
			}
		}
		return -1;
	}
	
	public static int otraPared(int[] A, int limite) {
		
		if (A[limite - 1] >= A[limite]) {
			return -1;
		}
		List<Integer> list = new ArrayList<>();
		
		for (int reversa = limite - 1; reversa >= 0; reversa--) {
			list.add(A[reversa]);
		}
		int max = Collections.max(list);
		int idx = getIndex(A, limite, max);
		System.out.println("idx: " + idx);
		return idx;
	}

	public static int solution(int[] A) {

		List<Integer> list = new ArrayList<>();
		int depthMax = 0;
		int capacity = 0;
		int pared = 0;
		
		for (int idx = 0; idx < A.length; idx++) {
			System.out.println("INDICE: " + idx);
			capacity = 0;
			if (idx - 2 >= 0) {
				pared = otraPared(A, idx);
				System.out.println(pared);
				if (pared != -1) {
					depthMax = getDepthMax(A, idx, pared);
					System.out.println("depthMaX: " + depthMax);
					if (depthMax != 0) {
						capacity = getCapacity(depthMax, A[idx], A[pared]);
					}
				}
			}
			if (capacity > 0) {
				list.add(capacity);
			}
			System.out.println(list);
		}
		if (list.size() == 0) {
			return 0;
		}
		return Collections.max(list);
	}

	public static void main(String[] args) {

		int array[] = { 8, 1, 2, 5, 2, 2, 2, 8 };

		System.out.println("Bigger: " + solution(array));
	}
}
