package BaiTap;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bai4Slide54 {

	public static void main(String[] args) {
		try {
			System.out.print("Mời nhập số lượng phần tử cho mảng: ");
			Scanner sc = new Scanner(System.in);
			int n= sc.nextInt();
			int[] M= new int[n];
			nhapMang(M);
			xuatMang(M);
			xoaSoTrung(M);
			System.out.println();
			System.out.print("Các số chẵn trong mảng gồm: "); inSoChan(M);
			System.out.println();
			System.out.print("Các số lẻ trong mảng gồm: "); inSoLe(M);
			System.out.println();
			System.out.print("Các số nguyên tố trong mảng gồm: "); inSoNguyenTo(M);
			System.out.println();
			System.out.print("Các số không phải là số nguyên tố trong mảng gồm: "); inSoKhongNguyenTo(M);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	static void nhapMang(int[] A)
	{
		Random rd= new Random();
		for(int i=0; i<A.length; i++)
		{
			A[i]= rd.nextInt(50);
		}
	
	}
	static void xuatMang(int[] A)
	{
		for(int i:A)
		{
			System.out.print(i + "  ");
		}
	}
	/**
	 * Hàm xóa các chữ số có các giá trị trùng nhau trong mảng và trả về mảng được sắp xếp tăng dần
	 * Số có giá trị trùng nhau sẽ bị gán giá trị là -1 rồi bị đảo qua rìa trái
	 * @param A Mảng cần xử lý
	 * Ví dụ: 
	 * 		Trước xử lý: A={4,1,2,4,9,2,2}
	 * 		Sau xử lý: A={-1,-1,-1,1,2,4,9}
	 */
	static void xoaSoTrung(int[] A)
	{
		Arrays.sort(A);
		int save;
		for(int i=0; i<A.length; i++)
		{
			save= A[i];
			while(Arrays.binarySearch(A, save)>=0)
			{
				A[Arrays.binarySearch(A, save)]=-1;
			}
			A[i]=save;
			Arrays.sort(A);
		}
	}
	/**
	 * Hàm in số chẵn trong mảng ra màn hình
	 * @param A Mảng nhập vào
	 */
	static void inSoChan(int[] A)
	{
		for(int i:A)
		{
			if(i%2==0 && i>0)
				System.out.print(i + "  ");			
		}
	}
	/**
	 * Hàm in số lẻ trong mảng ra màn hình
	 * @param A Mảng nhập vào
	 */
	static void inSoLe(int[] A)
	{
		for(int i:A)
		{
			if(i%2!=0 && i>0)
				System.out.print(i + "  ");			
		}
	}
	/**
	 * Hàm kiểm tra một số có phải là số nguyên tố hay không
	 * @param x Số cần kiểm tra
	 * @return Trả về true nếu phải, ngược lại trả về false
	 */
	static boolean checkPrime(int x)
	{
		if(x<2)
			return false;
		if(x==2)
			return true;
		else
			for(int i=2; i<x; i++)
			{
				if(x%i==0)
					return false;
			}
		return true;
	}
	/**
	 * Hàm in ra tập hợp số nguyên tố tìm được trong mảng
	 * @param A Mảng nhập vào
	 */
	static void inSoNguyenTo(int[] A)
	{
		for(int i:A)
		{
			if(checkPrime(i) && i>0)
				System.out.print(i + "  ");			
		}
	}
	/**
	 * Hàm in ra tập hợp số không phải là số nguyên tố tìm được trong mảng
	 * @param A Mảng nhập vào
	 */
	static void inSoKhongNguyenTo(int[] A)
	{
		for(int i:A)
		{			
			if(checkPrime(i)==false && i>0)
				System.out.print(i + "  ");			
		}
	}
}
