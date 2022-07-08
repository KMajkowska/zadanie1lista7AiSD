import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random g = new Random();
		String nazwa = "slowa.txt";
		String word;
		File plik = new File(nazwa);
		int depth=100, tmp, rand, count=0;
		tmp = g.nextInt(4)+1;
		long Start, Stop, time=0;
		for(int i=0; i<30; i++) {
			TrieTree_HashMapa my_tree_mapa = new TrieTree_HashMapa(); 
			time=0;
			count=0;
			try (BufferedReader breader = new BufferedReader(new InputStreamReader(new FileInputStream(plik), StandardCharsets.UTF_8)))
			{
				while((word = breader.readLine()) != null) {
					rand = g.nextInt(50);
					if(rand%tmp == 0) {
						Start = System.currentTimeMillis();
						my_tree_mapa.AddString(word);
						Stop = System.currentTimeMillis();
						time += (Stop - Start);
						count++;
					}
					if (count == depth)
						break;
				}
				System.out.println("ADDING: " + time + " " + count);
				breader.close();
			}catch(IOException Exception){
				System.out.println("Blad");
			}
			try (BufferedReader breader = new BufferedReader(new InputStreamReader(new FileInputStream(plik), StandardCharsets.UTF_8)))
			{
				boolean searched;
				count =0;
				time=0;
				while((word = breader.readLine()) != null) {
						searched = false;
						rand = g.nextInt(50);
						if(rand%tmp == 0) {
						Start = System.currentTimeMillis();
						searched = my_tree_mapa.isDefined(word);
						Stop = System.currentTimeMillis();
						time += (Stop - Start);
						if(searched == true)
							count++;
						}
			}
				System.out.println("SEARCHING: " + time + " " + count);
				breader.close();
			}catch(IOException Exception){
				System.out.println("Blad");
			}
			
		}
		count=0;
		for(int j=0; j<30; j++) {
			TrieTree_tablica my_tree_tablica = new TrieTree_tablica();
			time=0;
			count=0;
			try (BufferedReader breader = new BufferedReader(new InputStreamReader(new FileInputStream(plik), StandardCharsets.UTF_8)))
			{
				while((word = breader.readLine()) != null) {
						rand = g.nextInt(50);
						if(rand%tmp == 0) {
							Start = System.currentTimeMillis();
							my_tree_tablica.AddString(word);
							Stop = System.currentTimeMillis();
							time += (Stop - Start);
							count++;
						}
						if (count == depth)
							break;
				}
				System.out.println("ADDING: " + time + " " + count);
				breader.close();
			}catch(IOException Exception){
				System.out.println("Blad");
			}
			try (BufferedReader breader = new BufferedReader(new InputStreamReader(new FileInputStream(plik), StandardCharsets.UTF_8)))
			{
				boolean searched;
				count =0;
				time=0;
				while((word = breader.readLine()) != null) {
						searched = false;
						rand = g.nextInt(50);
						if(rand%tmp == 0) {
						Start = System.currentTimeMillis();
						searched = my_tree_tablica.isDefined(word);
						Stop = System.currentTimeMillis();
						time += (Stop - Start);
						if(searched == true)
							count++;
						}
			}
				System.out.println(time);
				breader.close();
			}catch(IOException Exception){
				System.out.println("Blad");
			}
		}
		count=0;
		for(int i=0; i<30; i++) {
			TrieTree_LinkedList my_tree_list = new TrieTree_LinkedList(); 
			time=0;
			count=0;
			try (BufferedReader breader = new BufferedReader(new InputStreamReader(new FileInputStream(plik), StandardCharsets.UTF_8)))
			{
				while((word = breader.readLine()) != null) {
					rand = g.nextInt(5);
					if(rand%tmp == 0) {
						Start = System.currentTimeMillis();
						my_tree_list.AddString(word);
						Stop = System.currentTimeMillis();
						time += (Stop - Start);
						count++;
						}
					if (count == depth)
						break;
				}
				System.out.println("ADDING: " + time + " " + count);
				breader.close();
			}catch(IOException Exception){
				System.out.println("Blad");
			}
			try (BufferedReader breader = new BufferedReader(new InputStreamReader(new FileInputStream(plik), StandardCharsets.UTF_8)))
			{
				boolean searched;
				count =0;
				time=0;
				while((word = breader.readLine()) != null) {
						searched = false;
						rand = g.nextInt(50);
						if(rand%tmp == 0) {
						Start = System.currentTimeMillis();
						searched = my_tree_list.isDefined(word);
						Stop = System.currentTimeMillis();
						time += (Stop - Start);
						if(searched == true)
							count++;
						}
			}
				System.out.println("SEARCHING: " + time + " " + count);
				breader.close();
			}catch(IOException Exception){
				System.out.println("Blad");
			}
			}
	}

}
